package com.bytedance.android.livesdk.model;

import com.bytedance.android.live.core.setting.k2;
import com.bytedance.android.livesdkapi.model.DislikeConfig;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    @JvmStatic
    public static final DislikeConfig a() {
        return k2.f65338a.getValue();
    }

    @JvmStatic
    public static final boolean c() {
        int r100 = a().getEntranceStyle();
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 != 5) goto L9;
        return true;
    L9:
        if (r100 == 6) goto L16;
        return false;
    L16:
        return true;
    }

    @JvmStatic
    public static final boolean d() {
        int r100 = a().getStyle();
        if (r100 != 5) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 6) goto L8;
        return false;
    }

    @JvmStatic
    public static final boolean e() {
        int r100 = a().getStyle();
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 3) goto L7;
        return true;
    L7:
        if (r100 == 5) goto L18;
        Boolean r101 = a().getDislikeUnfold();
        if (r101 == null) goto L11;
        boolean r102 = r101.booleanValue();
    L12:
        if (r102 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        r102 = false;
        goto L12
    L18:
        return true;
    }

    static {
    }

    @JvmStatic
    public static final boolean b(DislikeConfig r100) {
        if (r100 != null) goto L4;
        r100 = a();
    L4:
        int r101 = r100.getEntranceStyle();
        if (r101 != 3) goto L7;
    L14:
        return true;
    L7:
        if (r101 == 4) goto L14;
        if (r101 == 5) goto L14;
        if (r101 == 6) goto L14;
        return false;
    }
}
