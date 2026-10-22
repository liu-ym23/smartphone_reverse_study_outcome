package com.android.vcard;

import android.util.Log;
import com.android.vcard.exception.VCardException;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class VCardParserImpl_V30 extends VCardParserImpl_V21 {
    private static final String LOG_TAG = "vCard";
    private boolean mEmittedAgentWarning;
    private String mPreviousLine;

    @Override // com.android.vcard.VCardParserImpl_V21
    protected String getBase64(String r1) throws IOException, VCardException {
        return r1;
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected int getVersion() {
        return 1;
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected String getVersionString() {
        return VCardConstants.VERSION_V30;
    }

    public VCardParserImpl_V30() {
        this.mEmittedAgentWarning = false;
    }

    public VCardParserImpl_V30(int r1) {
        super(r1);
        this.mEmittedAgentWarning = false;
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected String peekLine() throws IOException {
        String r0 = this.mPreviousLine;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.mReader.peekLine();
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected String getLine() throws IOException {
        String r0 = this.mPreviousLine;
        if (r0 == null) goto L7;
        this.mPreviousLine = null;
        return r0;
    L7:
        return this.mReader.readLine();
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected String getNonEmptyLine() throws IOException, VCardException {
        String r0 = null;
        StringBuilder r1 = null;
    L3:
        String r2 = this.mReader.readLine();
        if (r2 == null) goto L24;
        if (r2.length() == 0) goto L3;
        if (r2.charAt(0) == ' ') goto L18;
        if (r2.charAt(0) == '\t') goto L18;
        if (r1 != null) goto L24;
        if (this.mPreviousLine != null) goto L24;
        this.mPreviousLine = r2;
    L18:
        if (r1 != null) goto L20;
        r1 = new StringBuilder();
    L20:
        String r3 = this.mPreviousLine;
        if (r3 == null) goto L23;
        r1.append(r3);
        this.mPreviousLine = null;
    L23:
        r1.append(r2.substring(1));
    L24:
        if (r1 == null) goto L26;
        r0 = r1.toString();
    L29:
        this.mPreviousLine = r2;
        if (r0 == null) goto L33;
        return r0;
    L33:
        throw new VCardException("Reached end of buffer.");
    L26:
        String r4 = this.mPreviousLine;
        if (r4 == null) goto L29;
        r0 = r4;
        goto L29
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected boolean readBeginVCard(boolean r1) throws IOException, VCardException {
        return super.readBeginVCard(r1);
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected void handleParams(VCardProperty r4, String r5) throws VCardException {
        super.handleParams(r4, r5);     // Catch: VCardException -> L4
        return;
    L4:
        String[] r0 = r5.split("=", 2);
        if (r0.length != 2) goto L9;
        handleAnyParam(r4, r0[0], r0[1]);
        return;
    L9:
        throw new VCardException("Unknown params value: " + r5);
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected void handleAnyParam(VCardProperty r1, String r2, String r3) {
        splitAndPutParam(r1, r2, r3);
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected void handleParamWithoutName(VCardProperty r1, String r2) {
        handleType(r1, r2);
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected void handleType(VCardProperty r2, String r3) {
        splitAndPutParam(r2, VCardConstants.PARAM_TYPE, r3);
    }

    private void splitAndPutParam(VCardProperty r10, String r11, String r12) {
        int r0 = r12.length();
        StringBuilder r5 = null;
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r0) goto L25;
        char r7 = r12.charAt(r3);
        if (r7 != '\"') goto L16;
        if (r4 == false) goto L9;
        r10.addParameter(r11, encodeParamValue(r5.toString()));
        r5 = null;
        r4 = false;
    L24:
        r3 = r3 + 1;
        goto L4
    L9:
        if (r5 != null) goto L11;
    L14:
        r4 = true;
        goto L24
    L11:
        if (r5.length() <= 0) goto L13;
        Log.w(LOG_TAG, "Unexpected Dquote inside property.");
        goto L14
    L13:
        r10.addParameter(r11, encodeParamValue(r5.toString()));
        goto L14
    L16:
        if (r7 != ',') goto L21;
        if (r4 == true) goto L21;
        if (r5 != null) goto L20;
        Log.w(LOG_TAG, "Comma is used before actual string comes. (" + r12 + ")");
        goto L24
    L20:
        r10.addParameter(r11, encodeParamValue(r5.toString()));
        r5 = null;
    L21:
        if (r5 != null) goto L23;
        r5 = new StringBuilder();
    L23:
        r5.append(r7);
        goto L24
    L25:
        if (r4 == false) goto L27;
        Log.d(LOG_TAG, "Dangling Dquote.");
    L27:
        if (r5 != null) goto L29;
        return;
    L29:
        if (r5.length() != 0) goto L31;
        Log.w(LOG_TAG, "Unintended behavior. We must not see empty StringBuilder at the end of parameter value parsing.");
        return;
    L31:
        r10.addParameter(r11, encodeParamValue(r5.toString()));
    }

    protected String encodeParamValue(String r2) {
        return VCardUtils.convertStringCharset(r2, "ISO-8859-1", "UTF-8");
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected void handleAgent(VCardProperty r2) {
        if (this.mEmittedAgentWarning == true) goto L6;
        Log.w(LOG_TAG, "AGENT in vCard 3.0 is not supported yet. Ignore it");
        this.mEmittedAgentWarning = true;
        return;
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected String maybeUnescapeText(String r1) {
        return unescapeText(r1);
    }

    public static String unescapeText(String r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        char r3 = r5.charAt(r2);
        if (r3 == '\\') goto L7;
    L15:
        r0.append(r3);
    L16:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r2 >= (r1 - 1)) goto L15;
        r2 = r2 + 1;
        char r4 = r5.charAt(r2);
        if (r4 != 'n') goto L11;
    L14:
        r0.append("\n");
        goto L16
    L11:
        if (r4 == 'N') goto L14;
        r0.append(r4);
        goto L16
    L18:
        return r0.toString();
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected String maybeUnescapeCharacter(char r1) {
        return unescapeCharacter(r1);
    }

    public static String unescapeCharacter(char r1) {
        if (r1 != 'n') goto L5;
        return "\n";
    L5:
        if (r1 != 'N') goto L8;
        return "\n";
    L8:
        return String.valueOf(r1);
    }

    @Override // com.android.vcard.VCardParserImpl_V21
    protected Set<String> getKnownPropertyNameSet() {
        return VCardParser_V30.sKnownPropertyNameSet;
    }
}
