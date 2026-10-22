package org.apache.http;

import com.bytedanceos.common.ad.param.AdReportParam;

/* JADX INFO: loaded from: classes4.dex */
public class HttpException extends Exception {
    private static final int FIRST_VALID_CHAR = 32;
    private static final long serialVersionUID = -5437299376222011036L;

    public HttpException() {
    }

    public static String clean(String r10) {
        char[] r11 = r10.toCharArray();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r11.length) goto L10;
        if (r11[r13] < ' ') goto L10;
        r13 = r13 + 1;
    L10:
        if (r13 != r11.length) goto L12;
        return r10;
    L12:
        StringBuilder r14 = new StringBuilder(r11.length * 2);
    L14:
        if (r12 >= r11.length) goto L24;
        char r15 = r11[r12];
        if (r15 >= ' ') goto L21;
        r14.append("[0x");
        String r16 = Integer.toHexString(r12);
        if (r16.length() != 1) goto L20;
        r14.append(AdReportParam.ClickPosType.SKIP);
    L20:
        r14.append(r16);
        r14.append("]");
    L22:
        r12 = r12 + 1;
        goto L14
    L21:
        r14.append(r15);
        goto L22
    L24:
        return r14.toString();
    }

    public HttpException(String r10) {
        super(clean(r10));
    }

    public HttpException(String r10, Throwable r11) {
        super(clean(r10));
        initCause(r11);
    }
}
