package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.FormattedHeader;
import com.ss.android.http.legacy.Header;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BasicLineFormatter implements LineFormatter {
    public static final BasicLineFormatter DEFAULT = null;

    public BasicLineFormatter() {
    }

    static {
        DEFAULT = new BasicLineFormatter();
    }

    protected CharArrayBuffer initBuffer(CharArrayBuffer r1) {
        if (r1 == null) goto L5;
        r1.clear();
        return r1;
    L5:
        return new CharArrayBuffer(64);
    }

    public static final String formatHeader(Header r1, LineFormatter r2) {
        if (r2 != null) goto L5;
        r2 = DEFAULT;
    L5:
        return r2.formatHeader(null, r1).toString();
    }

    @Override // com.ss.android.http.legacy.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer r2, Header r3) {
        if (r3 == null) goto L9;
        if ((r3 instanceof FormattedHeader) == true) goto L10;
        CharArrayBuffer r4 = initBuffer(r2);
        doFormatHeader(r4, r3);
        return r4;
    L10:
        return ((FormattedHeader) r3).getBuffer();
    L9:
        throw new IllegalArgumentException("Header may not be null");
    }

    protected void doFormatHeader(CharArrayBuffer r3, Header r4) {
        String r2 = r4.getName();
        String r5 = r4.getValue();
        int r0 = r2.length() + 2;
        if (r5 == null) goto L5;
        r0 = r0 + r5.length();
    L5:
        r3.ensureCapacity(r0);
        r3.append(r2);
        r3.append(": ");
        if (r5 == null) goto L9;
        r3.append(r5);
        return;
    }
}
