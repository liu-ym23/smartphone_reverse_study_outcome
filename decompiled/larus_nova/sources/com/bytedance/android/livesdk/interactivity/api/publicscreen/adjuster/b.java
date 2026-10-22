package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zg1.z0;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f133376a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133377b = 0;

    static {
        s1.j(R.dimen.ttlive_gift_anim_gift_padding);
        f133376a = s1.e(150.0f);
        f133377b = UtilityKotlinExtentionsKt.i(80);
    }

    @JvmStatic
    public static final void a(DataCenter r100, z0 r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101.f572034a != 0) goto L17;
        Object r103 = r101.f572035b;
        if ((r103 instanceof Integer) == false) goto L18;
        if (r103 == null) goto L16;
        int r104 = (r102 - ((int) (((Integer) r103).intValue() + s1.e(26.0f)))) + 0;
        if (r104 >= s1.e(90.0f)) goto L10;
        r104 = (int) s1.e(90.0f);
    L10:
        PageUIContext r105 = PageUIContext.Companion.getContext(r100);
        if (r105 == null) goto L19;
        m<Integer> r106 = r105.getRequestPkHeightIncludeMarginDefault();
        if (r106 == null) goto L20;
        r106.setValue(Integer.valueOf(r104));
        return;
    L20:
        return;
    L19:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L18:
        return;
    }
}
