package com.bytedance.android.live.base.model;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m {
    @Deprecated(message = "Do not use unless necessary")
    public static final vh7.e a(vh7.c r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$callCastToWithoutTypeChecking");
        Intrinsics.checkNotNullParameter(r101, "type");
        return r100.castToOrNull(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "该扩展方法极易误用，请确认实际需求后使用替代方案：若要在 FlexModel 和 ModelExtension 之间转换，请使用其castTo方法；其他情况请使用 Kotlin 的 as 关键字。")
    public static final <T> T b(Object r100, Class<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 != 0) goto L6;
        return null;
    L6:
        if (r101.isInstance(r100) == false) goto L9;
        return r100;
    L9:
        if (vh7.c.class.isAssignableFrom(r101) == true) goto L16;
        if (vh7.e.class.isAssignableFrom(r101) == true) goto L16;
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    L16:
        if ((r100 instanceof vh7.e) == false) goto L22;
        Object r102 = ((vh7.e) r100).getFlexInstance();
        if (r102 == null) goto L21;
        vh7.c r103 = (vh7.c) r102;
    L24:
        if (vh7.e.class.isAssignableFrom(r101) == false) goto L29;
        boolean r104 = r103.getClass().isAssignableFrom(r101);
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r104 == true) goto L28;
        return null;
    L28:
        return (T) a(r103, r101);
    L29:
        boolean r105 = Intrinsics.areEqual(r103.getClass(), r101);
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r105 == true) goto L32;
        return null;
    L32:
        return (T) r103;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
    L22:
        r103 = (vh7.c) r100;
        goto L24
    }
}
