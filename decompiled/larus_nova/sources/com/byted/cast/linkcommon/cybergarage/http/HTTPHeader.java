package com.byted.cast.linkcommon.cybergarage.http;

import android.text.TextUtils;
import com.byted.cast.common.Logger;
import com.byted.cast.common.Utils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPHeader {
    private static int MAX_LENGTH = 1024;
    private static final String TAG = "HTTPHeader";
    private String name;
    private String value;

    public boolean hasName() {
        String r100 = this.name;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public HTTPHeader(String r100) {
        setName("");
        setValue("");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r101 = r100.indexOf(58);
        if (r101 >= 0) goto L8;
        return;
    L8:
        String r102 = Utils.newString(r100.getBytes(), 0, r101);
        String r103 = Utils.newString(r100.getBytes(), r101 + 1, (r100.length() - r101) - 1);
        setName(r102.trim());
        setValue(r103.trim());
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }

    public HTTPHeader(String r100, String r101) {
        setName(r100);
        setValue(r101);
    }

    public static final int getIntegerValue(String r100, String r101) {
        return CastIntegerProtector.parseInt(getValue(r100, r101));
    L4:
        return 0;
    }

    public static final String getValue(LineNumberReader r100, String r101) {
        String r102 = r101.toUpperCase();
        String r103 = r100.readLine();     // Catch: IOException -> L16
    L4:
        if (r103 == null) goto L15;
        if (r103.length() <= 0) goto L15;
        HTTPHeader r104 = new HTTPHeader(r103);     // Catch: IOException -> L16
        if (r104.hasName() == false) goto L9;
        if (r104.getName().toUpperCase().equals(r102) == true) goto L13;
        r103 = r100.readLine();     // Catch: IOException -> L16
        goto L4
    L13:
        return r104.getValue();
    L9:
        r103 = r100.readLine();     // Catch: IOException -> L16
    L15:
        return "";
    L16:
        e = move-exception;
        Logger.d(TAG, e.getMessage());
        return "";
    }

    public static final int getIntegerValue(byte[] r100, String r101) {
        return CastIntegerProtector.parseInt(getValue(r100, r101));
    L4:
        return 0;
    }

    public static final String getValue(String r100, String r101) {
        StringReader r102 = new StringReader(r100);
        int r103 = Math.min(r100.length(), MAX_LENGTH);
        if (r103 > 0) goto L6;
        r103 = MAX_LENGTH;
    L6:
        return getValue(new LineNumberReader(r102, r103), r101);
    }

    public static final String getValue(byte[] r100, String r101) {
        return getValue(new String(r100), r101);
    }
}
