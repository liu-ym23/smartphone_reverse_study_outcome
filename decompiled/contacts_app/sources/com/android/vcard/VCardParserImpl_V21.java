package com.android.vcard;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import com.android.vcard.exception.VCardAgentNotSupportedException;
import com.android.vcard.exception.VCardException;
import com.android.vcard.exception.VCardInvalidCommentLineException;
import com.android.vcard.exception.VCardInvalidLineException;
import com.android.vcard.exception.VCardVersionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class VCardParserImpl_V21 {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_ENCODING = "8BIT";
    private static final String LOG_TAG = "vCard";
    private static final int STATE_GROUP_OR_PROPERTY_NAME = 0;
    private static final int STATE_PARAMS = 1;
    private static final int STATE_PARAMS_IN_DQUOTE = 2;
    private boolean mCanceled;
    protected String mCurrentCharset;
    protected String mCurrentEncoding;
    protected final String mIntermediateCharset;
    private final List<VCardInterpreter> mInterpreterList;
    protected CustomBufferedReader mReader;
    protected final Set<String> mUnknownTypeSet;
    protected final Set<String> mUnknownValueSet;

    protected static final class CustomBufferedReader extends BufferedReader {
        private String mNextLine;
        private boolean mNextLineIsValid;
        private long mTime;

        public CustomBufferedReader(Reader r1) {
            super(r1);
        }

        @Override // java.io.BufferedReader
        public String readLine() throws IOException {
            if (this.mNextLineIsValid == false) goto L6;
            String r0 = this.mNextLine;
            this.mNextLine = null;
            this.mNextLineIsValid = false;
            return r0;
        L6:
            long r1 = System.currentTimeMillis();
            String r2 = super.readLine();
            this.mTime += System.currentTimeMillis() - r1;
            return r2;
        }

        public String peekLine() throws IOException {
            if (this.mNextLineIsValid == true) goto L6;
            long r0 = System.currentTimeMillis();
            String r2 = super.readLine();
            this.mTime += System.currentTimeMillis() - r0;
            this.mNextLine = r2;
            this.mNextLineIsValid = true;
        L6:
            return this.mNextLine;
        }

        public long getTotalmillisecond() {
            return this.mTime;
        }
    }

    private boolean isAsciiLetter(char r1) {
        if (r1 < 'a') goto L7;
        if (r1 > 'z') goto L7;
        return true;
    L7:
        if (r1 >= 'A') goto L9;
        return false;
    L9:
        if (r1 > 'Z') goto L15;
        return true;
    L15:
        return false;
    }

    protected String getDefaultCharset() {
        return "UTF-8";
    }

    protected String getDefaultEncoding() {
        return "8BIT";
    }

    protected int getVersion() {
        return 0;
    }

    protected String getVersionString() {
        return VCardConstants.VERSION_V21;
    }

    protected String maybeUnescapeText(String r1) {
        return r1;
    }

    public VCardParserImpl_V21() {
        this(VCardConfig.VCARD_TYPE_DEFAULT);
    }

    public VCardParserImpl_V21(int r1) {
        this.mInterpreterList = new ArrayList();
        this.mUnknownTypeSet = new HashSet();
        this.mUnknownValueSet = new HashSet();
        this.mIntermediateCharset = "ISO-8859-1";
    }

    protected boolean isValidPropertyName(String r3) {
        if (getKnownPropertyNameSet().contains(r3.toUpperCase()) == false) goto L5;
        return true;
    L5:
        if (r3.startsWith("X-") == false) goto L7;
        return true;
    L7:
        if (this.mUnknownTypeSet.contains(r3) == true) goto L13;
        this.mUnknownTypeSet.add(r3);
        Log.w(LOG_TAG, "Property name unsupported by vCard 2.1: " + r3);
        return true;
    L13:
        return true;
    }

    protected String getLine() throws IOException {
        return this.mReader.readLine();
    }

    protected String peekLine() throws IOException {
        return this.mReader.peekLine();
    }

    protected String getNonEmptyLine() throws IOException, VCardException {
    L2:
        String r0 = getLine();
        if (r0 == null) goto L8;
        if (r0.trim().length() <= 0) goto L2;
        return r0;
    L8:
        throw new VCardException("Reached end of buffer.");
    }

    private boolean parseOneVCard() throws IOException, VCardException {
        this.mCurrentEncoding = "8BIT";
        this.mCurrentCharset = "UTF-8";
        if (readBeginVCard(true) == true) goto L6;
        return false;
    L6:
        Iterator<VCardInterpreter> r1 = this.mInterpreterList.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().onEntryStarted();
        goto L8
    L10:
        parseItems();
        Iterator<VCardInterpreter> r3 = this.mInterpreterList.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        r3.next().onEntryEnded();
        goto L12
    L14:
        return true;
    }

    protected boolean readBeginVCard(boolean r6) throws IOException, VCardException {
    L2:
        String r0 = getLine();
        if (r0 == null) goto L4;
        if (r0.trim().length() <= 0) goto L2;
        String[] r2 = r0.split(SimContactsConstants.ANR_SEP, 2);
        if (r2.length == 2) goto L10;
    L14:
        if (r6 == false) goto L20;
        if (r6 == true) goto L2;
        throw new VCardException("Reached where must not be reached.");
    L20:
        throw new VCardException("Expected String \"BEGIN:VCARD\" did not come (Instead, \"" + r0 + "\" came)");
    L10:
        if (r2[0].trim().equalsIgnoreCase(VCardConstants.PROPERTY_BEGIN) == false) goto L14;
        if (r2[1].trim().equalsIgnoreCase("VCARD") == false) goto L14;
        return true;
    L4:
        return false;
    }

    protected void parseItems() throws IOException, VCardException {
        boolean r2 = parseItem();     // Catch: VCardInvalidCommentLineException -> L5
    L6:
        if (r2 == true) goto L10;
        r2 = parseItem();     // Catch: VCardInvalidCommentLineException -> L9
    L9:
        Log.e(LOG_TAG, "Invalid line which looks like some comment was found. Ignored.");
        goto L6
    L10:
        return;
    L5:
        Log.e(LOG_TAG, "Invalid line which looks like some comment was found. Ignored.");
        r2 = false;
        goto L6
    }

    protected boolean parseItem() throws IOException, VCardException {
        this.mCurrentEncoding = "8BIT";
        VCardProperty r0 = constructPropertyData(getNonEmptyLine());
        String r1 = r0.getName().toUpperCase();
        String r2 = r0.getRawValue();
        if (r1.equals(VCardConstants.PROPERTY_BEGIN) == false) goto L10;
        if (r2.equalsIgnoreCase("VCARD") == false) goto L8;
        handleNest();
        return false;
    L8:
        throw new VCardException("Unknown BEGIN type: " + r2);
    L10:
        if (r1.equals(VCardConstants.PROPERTY_END) == true) goto L12;
        parseItemInter(r0, r1);
        return false;
    L12:
        if (r2.equalsIgnoreCase("VCARD") == false) goto L16;
        return true;
    L16:
        throw new VCardException("Unknown END type: " + r2);
    }

    private void parseItemInter(VCardProperty r3, String r4) throws IOException, VCardException {
        String r0 = r3.getRawValue();
        if (r4.equals(VCardConstants.PROPERTY_AGENT) == false) goto L6;
        handleAgent(r3);
        return;
    L6:
        if (isValidPropertyName(r4) == false) goto L17;
        if (r4.equals(VCardConstants.PROPERTY_VERSION) == true) goto L10;
    L14:
        handlePropertyValue(r3, r4);
        return;
    L10:
        if (r0.equals(getVersionString()) == true) goto L14;
        throw new VCardVersionException("Incompatible version: " + r0 + " != " + getVersionString());
    L17:
        throw new VCardException("Unknown property name: \"" + r4 + "\"");
    }

    private void handleNest() throws IOException, VCardException {
        Iterator<VCardInterpreter> r0 = this.mInterpreterList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onEntryStarted();
        goto L4
    L6:
        parseItems();
        Iterator<VCardInterpreter> r2 = this.mInterpreterList.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().onEntryEnded();
        goto L8
    }

    protected VCardProperty constructPropertyData(String r17) throws VCardException {
        VCardProperty r2 = new VCardProperty();
        int r3 = r17.length();
        int r4 = 0;
        if (r3 > 0) goto L5;
    L9:
        char r5 = 0;
        int r6 = 0;
    L10:
        if (r4 >= r3) goto L54;
        char r7 = r17.charAt(r4);
        String r8 = "";
        if (r5 == 0) goto L38;
        if (r5 == 1) goto L22;
        if (r5 != 2) goto L52;
        if (r7 != '\"') goto L52;
        if (VCardConstants.VERSION_V21.equalsIgnoreCase(getVersionString()) == false) goto L21;
        Log.w(LOG_TAG, "Double-quoted params found in vCard 2.1. Silently allow it");
    L21:
        r5 = 1;
    L52:
        r4 = r4 + 1;
        goto L10
    L22:
        if (r7 == '\"') goto L24;
        if (r7 != ';') goto L31;
        handleParams(r2, r17.substring(r6, r4));
    L29:
        r6 = r4 + 1;
        goto L52
    L31:
        if (r7 != ':') goto L52;
        handleParams(r2, r17.substring(r6, r4));
        if (r4 >= (r3 - 1)) goto L35;
        r8 = r17.substring(r4 + 1);
    L35:
        r2.setRawValue(r8);
        return r2;
    L24:
        if (VCardConstants.VERSION_V21.equalsIgnoreCase(getVersionString()) == false) goto L26;
        Log.w(LOG_TAG, "Double-quoted params found in vCard 2.1. Silently allow it");
    L26:
        r5 = 2;
        goto L52
    L38:
        if (r7 == ':') goto L39;
        if (r7 != '.') goto L50;
        String r9 = r17.substring(r6, r4);
        if (r9.length() != 0) goto L49;
        Log.w(LOG_TAG, "Empty group found. Ignoring.");
        goto L29
    L49:
        r2.addGroup(r9);
        goto L29
    L50:
        if (r7 != ';') goto L52;
        r2.setName(r17.substring(r6, r4));
        r6 = r4 + 1;
        goto L21
    L39:
        r2.setName(r17.substring(r6, r4));
        if (r4 >= (r3 - 1)) goto L42;
        r8 = r17.substring(r4 + 1);
    L42:
        r2.setRawValue(r8);
        return r2;
    L54:
        throw new VCardInvalidLineException("Invalid line: \"" + r17 + "\"");
    L5:
        if (r17.charAt(0) != '#') goto L9;
        throw new VCardInvalidCommentLineException();
    }

    protected void handleParams(VCardProperty r4, String r5) throws VCardException {
        String[] r6 = r5.split("=", 2);
        if (r6.length != 2) goto L24;
        String r0 = r6[0].trim().toUpperCase();
        String r7 = r6[1].trim();
        if (r0.equals(VCardConstants.PARAM_TYPE) == false) goto L8;
        handleType(r4, r7);
        return;
    L8:
        if (r0.equals(VCardConstants.PARAM_VALUE) == false) goto L11;
        handleValue(r4, r7);
        return;
    L11:
        if (r0.equals(VCardConstants.PARAM_ENCODING) == false) goto L14;
        handleEncoding(r4, r7.toUpperCase());
        return;
    L14:
        if (r0.equals(VCardConstants.PARAM_CHARSET) == false) goto L17;
        handleCharset(r4, r7);
        return;
    L17:
        if (r0.equals(VCardConstants.PARAM_LANGUAGE) == false) goto L20;
        handleLanguage(r4, r7);
        return;
    L20:
        if (r0.startsWith("X-") == false) goto L23;
        handleAnyParam(r4, r0, r7);
        return;
    L23:
        throw new VCardException("Unknown type \"" + r0 + "\"");
    L24:
        handleParamWithoutName(r4, r6[0]);
    }

    protected void handleParamWithoutName(VCardProperty r1, String r2) {
        handleType(r1, r2);
    }

    protected void handleType(VCardProperty r3, String r4) {
        if (getKnownTypeSet().contains(r4.toUpperCase()) == false) goto L5;
    L9:
        r3.addParameter(VCardConstants.PARAM_TYPE, r4);
        return;
    L5:
        if (r4.startsWith("X-") == true) goto L9;
        if (this.mUnknownTypeSet.contains(r4) == true) goto L9;
        this.mUnknownTypeSet.add(r4);
        Log.w(LOG_TAG, String.format("TYPE unsupported by %s: ", new Object[]{Integer.valueOf(getVersion()), r4}));
        goto L9
    }

    protected void handleValue(VCardProperty r3, String r4) {
        if (getKnownValueSet().contains(r4.toUpperCase()) == false) goto L5;
    L9:
        r3.addParameter(VCardConstants.PARAM_VALUE, r4);
        return;
    L5:
        if (r4.startsWith("X-") == true) goto L9;
        if (this.mUnknownValueSet.contains(r4) == true) goto L9;
        this.mUnknownValueSet.add(r4);
        Log.w(LOG_TAG, String.format("The value unsupported by TYPE of %s: ", new Object[]{Integer.valueOf(getVersion()), r4}));
        goto L9
    }

    protected void handleEncoding(VCardProperty r2, String r3) throws VCardException {
        if (getAvailableEncodingSet().contains(r3) == false) goto L5;
    L9:
        r2.addParameter(VCardConstants.PARAM_ENCODING, r3);
        this.mCurrentEncoding = r3.toUpperCase();
        return;
    L5:
        if (r3.startsWith("X-") == true) goto L9;
        throw new VCardException("Unknown encoding \"" + r3 + "\"");
    }

    protected void handleCharset(VCardProperty r1, String r2) {
        this.mCurrentCharset = r2;
        r1.addParameter(VCardConstants.PARAM_CHARSET, r2);
    }

    protected void handleLanguage(VCardProperty r9, String r10) throws VCardException {
        String[] r0 = r10.split("-");
        if (r0.length != 2) goto L21;
        int r1 = 0;
        String r2 = r0[0];
        int r5 = r2.length();
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L11;
        if (isAsciiLetter(r2.charAt(r6)) == false) goto L10;
        r6 = r6 + 1;
        goto L5
    L10:
        throw new VCardException("Invalid Language: \"" + r10 + "\"");
    L11:
        String r3 = r0[1];
        int r4 = r3.length();
    L12:
        if (r1 >= r4) goto L18;
        if (isAsciiLetter(r3.charAt(r1)) == false) goto L17;
        r1 = r1 + 1;
        goto L12
    L17:
        throw new VCardException("Invalid Language: \"" + r10 + "\"");
    L18:
        r9.addParameter(VCardConstants.PARAM_LANGUAGE, r10);
        return;
    L21:
        throw new VCardException("Invalid Language: \"" + r10 + "\"");
    }

    protected void handleAnyParam(VCardProperty r1, String r2, String r3) {
        r1.addParameter(r2, r3);
    }

    protected void handlePropertyValue(VCardProperty r10, String r11) throws IOException, VCardException {
        String r0 = r10.getName().toUpperCase();
        String r1 = r10.getRawValue();
        Collection<String> r2 = r10.getParameters(VCardConstants.PARAM_CHARSET);
        StringBuilder r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.iterator().next();
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L10;
        r4 = "UTF-8";
    L10:
        if (r0.equals(VCardConstants.PROPERTY_ADR) == false) goto L12;
    L72:
        handleAdrOrgN(r10, r1, "ISO-8859-1", r4);
        return;
    L12:
        if (r0.equals(VCardConstants.PROPERTY_ORG) == true) goto L72;
        if (r0.equals("N") == true) goto L72;
        if (this.mCurrentEncoding.equals(VCardConstants.PARAM_ENCODING_QP) == false) goto L19;
    L67:
        String r12 = getQuotedPrintablePart(r1);
        String r5 = VCardUtils.parseQuotedPrintable(r12, false, "ISO-8859-1", r4);
        r10.setRawValue(r12);
        r10.setValues(new String[]{r5});
        Iterator<VCardInterpreter> r9 = this.mInterpreterList.iterator();
    L69:
        if (r9.hasNext() == false) goto L88;
        r9.next().onPropertyCreated(r10);
        goto L69
    L88:
        return;
    L19:
        if (r0.equals(VCardConstants.PROPERTY_FN) == false) goto L26;
        if (r10.getParameters(VCardConstants.PARAM_ENCODING) != null) goto L26;
        if (VCardUtils.appearsLikeAndroidVCardQuotedPrintable(r1) == true) goto L67;
    L26:
        if (this.mCurrentEncoding.equals(VCardConstants.PARAM_ENCODING_BASE64) == false) goto L28;
    L76:
    L63:
        Log.e(LOG_TAG, "OutOfMemoryError happened during parsing BASE64 data!");
        Iterator<VCardInterpreter> r13 = this.mInterpreterList.iterator();
    L65:
        if (r13.hasNext() == false) goto L87;
        r13.next().onPropertyCreated(r10);
        goto L65
    L87:
        return;
    L74:
        r10.setByteValue(Base64.decode(getBase64(r1), 0));     // Catch: IllegalArgumentException -> L61 OutOfMemoryError -> L63
        Iterator<VCardInterpreter> r14 = this.mInterpreterList.iterator();     // Catch: OutOfMemoryError -> L63
    L59:
        if (r14.hasNext() == false) goto L86;
        r14.next().onPropertyCreated(r10);     // Catch: OutOfMemoryError -> L63
        goto L59
    L86:
        return;
    L62:
        throw new VCardException("Decode error on base64 photo: " + r1);     // Catch: OutOfMemoryError -> L63
    L28:
        if (this.mCurrentEncoding.equals(VCardConstants.PARAM_ENCODING_B) == true) goto L76;
        if (this.mCurrentEncoding.equals(VCardConstants.PARAM_ENCODING_7BIT) == true) goto L38;
        if (this.mCurrentEncoding.equals("8BIT") == true) goto L38;
        if (this.mCurrentEncoding.startsWith("X-") == true) goto L38;
        Log.w(LOG_TAG, String.format("The encoding \"%s\" is unsupported by vCard %s", new Object[]{this.mCurrentEncoding, getVersionString()}));
    L38:
        if (getVersion() != 0) goto L51;
    L39:
        String r15 = peekLine();
        if (TextUtils.isEmpty(r15) == true) goto L49;
        if (r15.charAt(0) != ' ') goto L49;
        if ("END:VCARD".contains(r15.toUpperCase()) == true) goto L49;
        getLine();
        if (r3 != null) goto L48;
        StringBuilder r6 = new StringBuilder();
        r6.append(r1);
        r3 = r6;
    L48:
        r3.append(r15.substring(1));
    L49:
        if (r3 == null) goto L51;
        r1 = r3.toString();
    L51:
        ArrayList r16 = new ArrayList();
        r16.add(maybeUnescapeText(VCardUtils.convertStringCharset(r1, "ISO-8859-1", r4)));
        r10.setValues(r16);
        Iterator<VCardInterpreter> r17 = this.mInterpreterList.iterator();
    L53:
        if (r17.hasNext() == false) goto L71;
        r17.next().onPropertyCreated(r10);
        goto L53
    L71:
        return;
    L5:
        r4 = null;
        goto L7
    }

    private void handleAdrOrgN(VCardProperty r4, String r5, String r6, String r7) throws VCardException, IOException {
        ArrayList r0 = new ArrayList();
        if (this.mCurrentEncoding.equals(VCardConstants.PARAM_ENCODING_QP) == false) goto L8;
        String r8 = getQuotedPrintablePart(r5);
        r4.setRawValue(r8);
        Iterator<String> r9 = VCardUtils.constructListFromValue(r8, getVersion()).iterator();
    L6:
        if (r9.hasNext() == false) goto L12;
        r0.add(VCardUtils.parseQuotedPrintable(r9.next(), false, r6, r7));
    L12:
        r4.setValues(r0);
        Iterator<VCardInterpreter> r3 = this.mInterpreterList.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r3.next().onPropertyCreated(r4);
        goto L14
    L16:
        return;
    L8:
        Iterator<String> r10 = VCardUtils.constructListFromValue(VCardUtils.convertStringCharset(getPotentialMultiline(r5), r6, r7), getVersion()).iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r0.add(r10.next());
        goto L10
    }

    private String getQuotedPrintablePart(String r8) throws IOException, VCardException {
        if (r8.trim().endsWith("=") == false) goto L22;
        int r0 = r8.length() - 1;
    L6:
        if (r8.charAt(r0) != '=') goto L6;
        StringBuilder r2 = new StringBuilder();
        r2.append(r8.substring(0, r0 + 1));
        r2.append(VCardBuilder.VCARD_END_OF_LINE);
    L9:
        String r1 = getLine();
        if (r1 == null) goto L21;
        if (r1.trim().endsWith("=") == false) goto L18;
        int r5 = r1.length() - 1;
    L15:
        if (r1.charAt(r5) != '=') goto L15;
        r2.append(r1.substring(0, r5 + 1));
        r2.append(VCardBuilder.VCARD_END_OF_LINE);
        goto L9
    L18:
        r2.append(r1);
        return r2.toString();
    L21:
        throw new VCardException("File ended during parsing a Quoted-Printable String");
    L22:
        return r8;
    }

    private String getPotentialMultiline(String r3) throws IOException {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
    L3:
        String r4 = peekLine();
        if (r4 == null) goto L13;
        if (r4.length() == 0) goto L13;
        if (getPropertyNameUpperCase(r4) != null) goto L13;
        getLine();
        r0.append(HanziToPinyin.Token.SEPARATOR).append(r4);
    L13:
        return r0.toString();
    }

    protected String getBase64(String r4) throws IOException, VCardException {
        StringBuilder r0 = new StringBuilder();
        r0.append(r4);
    L3:
        String r5 = peekLine();
        if (r5 == null) goto L18;
        String r1 = getPropertyNameUpperCase(r5);
        if (getKnownPropertyNameSet().contains(r1) == true) goto L14;
        if (VCardConstants.PROPERTY_X_ANDROID_CUSTOM.equals(r1) == true) goto L14;
        getLine();
        if (r5.length() == 0) goto L16;
        r0.append(r5.trim());
    L16:
        return r0.toString();
    L14:
        Log.w(LOG_TAG, "Found a next property during parsing a BASE64 string, which must not contain semi-colon or colon. Treat the line as next property.");
        Log.w(LOG_TAG, "Problematic line: " + r5.trim());
        goto L16
    L18:
        throw new VCardException("File ended during parsing BASE64 binary");
    }

    private String getPropertyNameUpperCase(String r3) {
        int r2 = r3.indexOf(SimContactsConstants.ANR_SEP);
        if (r2 <= (-1)) goto L12;
        int r1 = r3.indexOf(";");
        if (r2 != (-1)) goto L7;
        r2 = r1;
    L11:
        return r3.substring(0, r2).toUpperCase();
    L7:
        if (r1 == (-1)) goto L11;
        r2 = Math.min(r2, r1);
        goto L11
    L12:
        return null;
    }

    protected void handleAgent(VCardProperty r3) throws VCardException {
        if (r3.getRawValue().toUpperCase().contains("BEGIN:VCARD") == true) goto L10;
        Iterator<VCardInterpreter> r2 = this.mInterpreterList.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().onPropertyCreated(r3);
        goto L6
    L8:
        return;
    L10:
        throw new VCardAgentNotSupportedException("AGENT Property is not supported now.");
    }

    protected String maybeUnescapeCharacter(char r1) {
        return unescapeCharacter(r1);
    }

    static String unescapeCharacter(char r1) {
        if (r1 == '\\') goto L14;
        if (r1 == ';') goto L14;
        if (r1 == ':') goto L14;
        if (r1 == ',') goto L14;
        return null;
    L14:
        return String.valueOf(r1);
    }

    protected Set<String> getKnownPropertyNameSet() {
        return VCardParser_V21.sKnownPropertyNameSet;
    }

    protected Set<String> getKnownTypeSet() {
        return VCardParser_V21.sKnownTypeSet;
    }

    protected Set<String> getKnownValueSet() {
        return VCardParser_V21.sKnownValueSet;
    }

    protected Set<String> getAvailableEncodingSet() {
        return VCardParser_V21.sAvailableEncoding;
    }

    protected String getCurrentCharset() {
        return this.mCurrentCharset;
    }

    public void addInterpreter(VCardInterpreter r1) {
        this.mInterpreterList.add(r1);
    }

    public void parse(InputStream r3) throws IOException, VCardException {
        if (r3 == null) goto L25;
        this.mReader = new CustomBufferedReader(new InputStreamReader(r3, this.mIntermediateCharset));
        System.currentTimeMillis();
        Iterator<VCardInterpreter> r4 = this.mInterpreterList.iterator();
    L5:
        if (r4.hasNext() == false) goto L7;
        r4.next().onVCardStarted();
    L7:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.mCanceled == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L21
        if (parseOneVCard() == true) goto L7;
    L16:
        Iterator<VCardInterpreter> r2 = this.mInterpreterList.iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        r2.next().onVCardEnded();
        goto L18
    L20:
        return;
    L10:
        Log.i(LOG_TAG, "Cancel request has come. exitting parse operation.");     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        goto L16
    L25:
        throw new NullPointerException("InputStream must not be null.");
    }

    public void parseOne(InputStream r3) throws IOException, VCardException {
        if (r3 == null) goto L13;
        this.mReader = new CustomBufferedReader(new InputStreamReader(r3, this.mIntermediateCharset));
        System.currentTimeMillis();
        Iterator<VCardInterpreter> r4 = this.mInterpreterList.iterator();
    L5:
        if (r4.hasNext() == false) goto L7;
        r4.next().onVCardStarted();
        goto L5
    L7:
        parseOneVCard();
        Iterator<VCardInterpreter> r2 = this.mInterpreterList.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().onVCardEnded();
        goto L9
    L11:
        return;
    L13:
        throw new NullPointerException("InputStream must not be null.");
    }

    public final synchronized void cancel() {
        monitor-enter(this);
        Log.i(LOG_TAG, "ParserImpl received cancel operation.");     // Catch: Throwable -> L6
        this.mCanceled = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
