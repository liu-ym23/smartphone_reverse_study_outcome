package com.bytedance.ai.resource.security;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f37517a = 0;

    static {
    }

    public static int a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        if (4 > r100.length) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return ((r100[3] & UByte.MAX_VALUE) << 24) | (((r100[0] & UByte.MAX_VALUE) | ((r100[1] & UByte.MAX_VALUE) << 8)) | ((r100[2] & UByte.MAX_VALUE) << 16));
    L10:
        throw new IllegalArgumentException(("u32_le overflow: offset=0 size=" + r100.length).toString());
    L5:
        r101 = false;
        goto L6
    }
}
