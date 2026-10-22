package com.bytedance.android.live.openplatform.api.utils;

import android.graphics.Color;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f84004a = 0;

    public c() {
    }

    static {
    }

    public static int a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L24;
    L21:
        return -1;
    L24:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L14;
        int r102 = CastIntegerProtector.parseInt(r100);     // Catch: Throwable -> L23
    L15:
        if (r100.length() == 7) goto L18;
    L20:
        int r103 = r102 >>> 8;
        return r103 | (r102 << 24);
    L18:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L20;
        return r102;
    L14:
        r102 = Color.parseColor(r100);     // Catch: Throwable -> L23
        goto L15
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }
}
