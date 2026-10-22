package com.bytedance.frameworks.baselib.network.http.parser;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class MimeTypeParameterList {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private Hashtable parameters;

    public MimeTypeParameterList() {
        this.parameters = new Hashtable();
    }

    public MimeTypeParameterList(String r2) throws MimeTypeParseException {
        this.parameters = new Hashtable();
        parse(r2);
    }

    protected void parse(String r9) throws MimeTypeParseException {
        if (r9 != null) goto L4;
        return;
    L4:
        int r0 = r9.length();
        if (r0 > 0) goto L7;
        return;
    L7:
        int r1 = skipWhiteSpace(r9, 0);
    L8:
        if (r1 >= r0) goto L59;
        if (r9.charAt(r1) != ';') goto L59;
        int r2 = skipWhiteSpace(r9, r1 + 1);
        if (r2 >= r0) goto L13;
        int r3 = r2;
    L15:
        if (r3 >= r0) goto L19;
        if (isTokenChar(r9.charAt(r3)) == false) goto L19;
        r3 = r3 + 1;
    L19:
        String r4 = r9.substring(r2, r3).toLowerCase(Locale.ENGLISH);
        int r5 = skipWhiteSpace(r9, r3);
        if (r5 >= r0) goto L58;
        if (r9.charAt(r5) != '=') goto L58;
        int r6 = skipWhiteSpace(r9, r5 + 1);
        if (r6 >= r0) goto L56;
        char r7 = r9.charAt(r6);
        if (r7 != '\"') goto L45;
        int r8 = r6 + 1;
        if (r8 >= r0) goto L43;
        int r10 = r8;
    L30:
        if (r10 >= r0) goto L38;
        r7 = r9.charAt(r10);
        if (r7 == '\"') goto L38;
        if (r7 != '\\') goto L37;
        r10 = r10 + 1;
    L37:
        r10 = r10 + 1;
    L38:
        if (r7 != '\"') goto L41;
        String r11 = unquote(r9.substring(r8, r10));
        int r12 = r10 + 1;
    L52:
        this.parameters.put(r4, r11);
        r1 = skipWhiteSpace(r9, r12);
        goto L8
    L41:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L43:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L45:
        if (isTokenChar(r7) == false) goto L54;
        r12 = r6;
    L47:
        if (r12 >= r0) goto L51;
        if (isTokenChar(r9.charAt(r12)) == false) goto L51;
        r12 = r12 + 1;
    L51:
        r11 = r9.substring(r6, r12);
        goto L52
    L54:
        throw new MimeTypeParseException("Unexpected character encountered at index " + r6);
    L56:
        throw new MimeTypeParseException("Couldn't find a value for parameter named " + r4);
    L58:
        throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
    L13:
        return;
    L59:
        if (r1 < r0) goto L62;
        return;
    L62:
        throw new MimeTypeParseException("More characters encountered in input than expected.");
    }

    public int size() {
        return this.parameters.size();
    }

    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    public String get(String r2) {
        return (String) this.parameters.get(r2.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String r2, String r3) {
        this.parameters.put(r2.trim().toLowerCase(Locale.ENGLISH), r3);
    }

    public void remove(String r2) {
        this.parameters.remove(r2.trim().toLowerCase(Locale.ENGLISH));
    }

    public Enumeration getNames() {
        return this.parameters.keys();
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        r0.ensureCapacity(this.parameters.size() * 16);
        Enumeration r1 = this.parameters.keys();
    L4:
        if (r1.hasMoreElements() == false) goto L7;
        String r2 = (String) r1.nextElement();
        r0.append("; ");
        r0.append(r2);
        r0.append('=');
        r0.append(quote((String) this.parameters.get(r2)));
        goto L4
    L7:
        return r0.toString();
    }

    private static boolean isTokenChar(char r1) {
        if (r1 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r1 >= 127) goto L9;
        if (TSPECIALS.indexOf(r1) >= 0) goto L9;
        return true;
    }

    private static int skipWhiteSpace(String r2, int r3) {
        int r0 = r2.length();
    L3:
        if (r3 >= r0) goto L7;
        if (Character.isWhitespace(r2.charAt(r3)) == false) goto L7;
        r3 = r3 + 1;
    L7:
        return r3;
    }

    private static String quote(String r7) {
        int r0 = r7.length();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L6;
        if (r3 == true) goto L6;
        r3 = !isTokenChar(r7.charAt(r2));
        r2 = r2 + 1;
    L6:
        if (r3 == false) goto L21;
        StringBuffer r4 = new StringBuffer();
        r4.ensureCapacity((int) (((double) r0) * 1.5d));
        r4.append(Typography.quote);
    L8:
        if (r1 >= r0) goto L14;
        char r5 = r7.charAt(r1);
        if (r5 == '\\') goto L12;
        if (r5 == '\"') goto L12;
    L13:
        r4.append(r5);
        r1 = r1 + 1;
    L12:
        r4.append('\\');
        goto L13
    L14:
        r4.append(Typography.quote);
        return r4.toString();
    L21:
        return r7;
    }

    private static String unquote(String r7) {
        int r0 = r7.length();
        StringBuffer r1 = new StringBuffer();
        r1.ensureCapacity(r0);
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r0) goto L14;
        char r5 = r7.charAt(r3);
        if (r4 == false) goto L7;
    L9:
        if (r4 == false) goto L11;
        r1.append(r5);
        r4 = false;
    L12:
        r3 = r3 + 1;
        goto L3
    L11:
        r4 = true;
        goto L12
    L7:
        if (r5 == '\\') goto L9;
        r1.append(r5);
        goto L12
    L14:
        return r1.toString();
    }
}
