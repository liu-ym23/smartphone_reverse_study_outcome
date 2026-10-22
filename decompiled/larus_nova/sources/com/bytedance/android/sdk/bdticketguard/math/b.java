package com.bytedance.android.sdk.bdticketguard.math;

import java.util.Comparator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes12.dex */
public final class b<T> implements Comparator<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f163965a = null;

    static {
        f163965a = new b();
    }

    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(byte[] r100, byte[] r101) {
        byte[] r102 = r100;
        byte[] r103 = r101;
        int r104 = Math.min(r102.length, r103.length);
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        int r106 = r102[r105] & UByte.MAX_VALUE;
        int r107 = r103[r105] & UByte.MAX_VALUE;
        if (r106 != r107) goto L12;
        r105 = r105 + 1;
        goto L3
    L12:
        return r106 - r107;
    L9:
        return r102.length - r103.length;
    }
}
