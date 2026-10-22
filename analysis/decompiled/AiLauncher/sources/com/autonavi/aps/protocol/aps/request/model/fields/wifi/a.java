package com.autonavi.aps.protocol.aps.request.model.fields.wifi;

import com.autonavi.aps.protocol.aps.common.e.e;
import com.autonavi.aps.protocol.aps.common.model.InvalidValueException;
import io.ktor.sse.ServerSentEventKt;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f19064a;

    /* renamed from: b, reason: collision with root package name */
    private String f19065b;

    public a() {
        this.f19064a = new byte[6];
        this.f19065b = null;
    }

    public void a(String str) throws Exception {
        try {
            if (str.length() != 17) {
                throw new Exception();
            }
            String[] strArrSplit = str.split(ServerSentEventKt.COLON);
            if (strArrSplit.length != 6) {
                throw new Exception();
            }
            for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                this.f19064a[i10] = Integer.valueOf(strArrSplit[i10], 16).byteValue();
            }
            this.f19065b = null;
        } catch (Exception unused) {
            throw new InvalidValueException("Mac.Mac", str);
        }
    }

    public int b() {
        return this.f19064a.length;
    }

    public String toString() {
        String str = this.f19065b;
        if (str != null) {
            return str;
        }
        char[] cArr = new char[17];
        cArr[0] = 0;
        cArr[1] = 0;
        cArr[2] = ':';
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = ':';
        cArr[6] = 0;
        cArr[7] = 0;
        cArr[8] = ':';
        cArr[9] = 0;
        cArr[10] = 0;
        cArr[11] = ':';
        cArr[12] = 0;
        cArr[13] = 0;
        cArr[14] = ':';
        cArr[15] = 0;
        cArr[16] = 0;
        for (int i10 = 0; i10 < 6; i10++) {
            int iA = e.a(this.f19064a[i10]) >> 4;
            int iA2 = e.a(this.f19064a[i10]) & 15;
            char c10 = (char) (iA > 9 ? iA + 87 : iA + 48);
            int i11 = iA2 > 9 ? iA2 + 87 : iA2 + 48;
            int i12 = (i10 * 2) + i10;
            cArr[i12] = c10;
            cArr[i12 + 1] = (char) i11;
        }
        String str2 = new String(cArr);
        this.f19065b = str2;
        return str2;
    }

    public void b(ByteBuffer byteBuffer) {
        byteBuffer.get(this.f19064a, 0, 6);
    }

    public a(String str) throws Exception {
        this.f19064a = new byte[6];
        this.f19065b = null;
        a(str);
    }

    public byte[] a() {
        return this.f19064a;
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f19064a);
    }
}
