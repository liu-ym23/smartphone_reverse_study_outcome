package com.baidu.platform.comapi.bmsdk.style;

import androidx.room.AbstractC0351g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int[] f8715a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    public int[] f8716b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f8717c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f8718d;

    private static void a(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = byteBuffer.getInt();
        }
    }

    private static void a(int i4) {
        if (i4 == 0 || (i4 & 1) != 0) {
            throw new RuntimeException(AbstractC0351g.m("invalid nine-patch: ", i4));
        }
    }

    public static b a(byte[] bArr) {
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (byteBufferOrder.get() == 0) {
            return null;
        }
        b bVar = new b();
        bVar.f8716b = new int[byteBufferOrder.get()];
        bVar.f8717c = new int[byteBufferOrder.get()];
        bVar.f8718d = new int[byteBufferOrder.get()];
        a(bVar.f8716b.length);
        a(bVar.f8717c.length);
        byteBufferOrder.getInt();
        byteBufferOrder.getInt();
        bVar.f8715a[0] = byteBufferOrder.getInt();
        bVar.f8715a[1] = byteBufferOrder.getInt();
        bVar.f8715a[2] = byteBufferOrder.getInt();
        bVar.f8715a[3] = byteBufferOrder.getInt();
        byteBufferOrder.getInt();
        a(bVar.f8716b, byteBufferOrder);
        a(bVar.f8717c, byteBufferOrder);
        a(bVar.f8718d, byteBufferOrder);
        return bVar;
    }
}
