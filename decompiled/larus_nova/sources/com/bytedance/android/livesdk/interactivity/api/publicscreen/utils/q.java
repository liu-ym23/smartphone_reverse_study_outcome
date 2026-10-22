package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.config.w71;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.p0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.r0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133648a = 0;

    public static int b() {
        if (FoldScreenUtils.e() == false) goto L9;
        if (e5.n() == false) goto L14;
        return s1.w();
    L14:
        return s1.y();
    L9:
        if (PadConfigUtils.c() == false) goto L12;
        return Math.min(s1.y(), s1.w());
    L12:
        return s1.y();
    }

    @JvmStatic
    public static final float i() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r100 = com.bytedance.android.livesdk.interactivity.api.q.i();
        if (r100 == null) goto L7;
        e52.a r101 = r100.getTextConfig();
        if (r101 == null) goto L7;
        return r101.b();
    L7:
        Context r102 = s1.getContext();
        float r103 = 1.0f;
        if (r102 == null) goto L20;
        Resources r104 = r102.getResources();
        if (r104 == null) goto L20;
        Configuration r105 = r104.getConfiguration();
        if (r105 == null) goto L20;
        float r106 = r105.fontScale;
        if (r106 > 1.0f) goto L16;
        return 1.0f;
    L16:
        r103 = 1.3f;
        if (r106 >= 1.3f) goto L20;
        return 1.15f;
    L20:
        return r103;
    }

    static {
    }

    public static float f(boolean r100) {
        if (FoldScreenUtils.f() == true) goto L5;
    L7:
        if (r100 == true) goto L9;
        return 1.0f;
    L9:
        if (PublicScreenABHelper.h().fontSizeFitResolution == true) goto L11;
        return 1.0f;
    L11:
        if (PadConfigUtils.c() == false) goto L14;
        float r101 = PublicScreenABHelper.h().padBaseResolutionWidthDp / 1.3f;
    L17:
        r0 r102 = PublicScreenABHelper.h();
        float r103 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(s1.G(b()) / r101, r102.minResolutionFitScale), r102.maxResolutionFitScale);
        ALogger.i("PS_RESOLUTION_FIT", "screen px width:" + b() + ", dp width：" + s1.G(b()) + ", base width:" + r101 + ", scale rate：" + r103);
        return r103;
    L14:
        if (FoldScreenUtils.e() == false) goto L16;
        r101 = PublicScreenABHelper.h().phoneBaseResolutionWidthDp * 2;
        goto L17
    L16:
        r101 = PublicScreenABHelper.h().phoneBaseResolutionWidthDp;
        goto L17
    L5:
        if (PublicScreenABHelper.h().foldScreenFitResolution == true) goto L7;
        return 1.0f;
    }

    public static IPublicScreenSpeedConfig g(IRoom r100) {
        if (r100 == null) goto L16;
        IPublicScreenSpeedConfig r101 = r100.getPublicScreenSpeedConfig();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.getInterval() >= 0) goto L9;
        return null;
    L9:
        if (r101.getUpdateScrollSize() >= 0) goto L11;
        return null;
    L11:
        if (r101.getUpdateFoldSize() >= 0) goto L13;
        return null;
    L13:
        if (r101.getScrollSpeed() < 0) goto L22;
        return r101;
    L22:
        return null;
    L16:
        return null;
    }

    public static float c(boolean r100, boolean r101) {
        float r102 = 1.0f;
        if (r100 == false) goto L12;
        int r103 = PublicScreenStyleHelper.a();
        if (r103 != 1) goto L7;
        r102 = 1.1428572f;
    L17:
        return r102 * d(r101, r100);
    L7:
        if (r103 != 2) goto L17;
        r102 = 1.2857143f;
        goto L17
    L12:
        if (f.a().enable == false) goto L17;
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e("audience_public_screen_setting_saved", Boolean.FALSE).getValue()).booleanValue() == false) goto L17;
        b52.a r104 = b52.a.f17745a;
        r102 = ((Number) r104.b(r104.a().b())).floatValue() / i();
        goto L17
    }

    public static float d(boolean r100, boolean r101) {
        if (r101 == false) goto L4;
        float r102 = 1.0f;
    L6:
        return f(r100) * r102;
    L4:
        r102 = PublicScreenABHelper.h().fontSize / 14.0f;
        goto L6
    }

    @JvmStatic
    public static final int e(boolean r100, boolean r101) {
        if (PublicScreenABHelper.h().itemGapFitResolution == false) goto L12;
        if (r100 == true) goto L12;
        int r102 = y42.a.f565987c.b().a();
        if (r102 == 1) goto L10;
        if (r102 == 2) goto L9;
        int r103 = PublicScreenStyleHelper.f133613c;
    L29:
        if (PublicScreenABHelper.h().itemGapFitResolution == true) goto L31;
        return r103;
    L31:
        return (int) (r103 * f(r101));
    L9:
        r103 = PublicScreenStyleHelper.f133615e;
        goto L29
    L10:
        r103 = PublicScreenStyleHelper.f133614d;
    L12:
        if (PublicScreenStyleHelper.f133624n == false) goto L27;
        int r104 = PublicScreenStyleHelper.f133627q;
        if (r104 < 0) goto L18;
        if (2 < r104) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L22;
        r104 = 0;
    L22:
        if (r104 == 1) goto L26;
        if (r104 == 2) goto L25;
        r103 = PublicScreenStyleHelper.f133613c;
        goto L29
    L25:
        r103 = PublicScreenStyleHelper.f133615e;
        goto L29
    L26:
        r103 = PublicScreenStyleHelper.f133614d;
    L18:
        r105 = false;
        goto L19
    L27:
        r103 = PublicScreenStyleHelper.f133612b;
        goto L29
    }

    @JvmStatic
    public static final g52.e a(e52.a r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "textConfig");
        Intrinsics.checkNotNullParameter(r110, "textConfig");
        if (r111 == false) goto L5;
    L7:
        n42.a r113 = r110.h();
    L8:
        float r100 = r113.f517038a;
        int r101 = r113.f517040c;
        Typeface r102 = r113.f517039b;
        int r103 = s1.f(r113.f517041d.left);
        int r104 = s1.f(r113.f517041d.top);
        int r105 = s1.f(r113.f517041d.right);
        int r106 = s1.f(r113.f517041d.bottom);
        if (PublicScreenStyleHelper.f133624n == false) goto L11;
        float r114 = PublicScreenStyleHelper.f133617g;
    L12:
        float r107 = r114;
        tx1.b.f547810a.getClass();
        float r115 = tx1.b.a();
        if (r112 == false) goto L18;
        if (w71.a() == false) goto L18;
        r115 = c(r112, r111);
    L18:
        return new g52.e(r100, r101, r102, r103, r104, r105, r106, r107, r115);
    L11:
        r114 = PublicScreenStyleHelper.f133616f;
        goto L12
    L5:
        if (r110.f() == false) goto L7;
        r113 = r110.d();
        goto L8
    }

    public static com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e h(j0 r100, int r101, IPublicScreenSpeedConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (r102 == null) goto L6;
        ALogger.i("PSSpeedConfig", "use server config. " + r102);
        int r103 = com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.f133483e;
        Intrinsics.checkNotNullParameter(r102, "serverConfig");
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e(r102.getInterval(), r102.getUpdateScrollSize(), r102.getUpdateFoldSize(), r102.getScrollSpeed());
    L6:
        List<p0> r104 = r100.b();
        Object r105 = null;
        if (r104 == null) goto L22;
        Iterator<T> r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        if (((p0) r107).a() != r101) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L10;
    L18:
        p0 r109 = (p0) r107;
        if (r109 == null) goto L22;
        ALogger.i("PSSpeedConfig", "use dynamic strategy. " + r109);
        int r110 = com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.f133483e;
        return com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.a.a(r109);
    L14:
        r108 = false;
        goto L15
    L17:
        r107 = null;
    L22:
        List<p0> r111 = r100.b();
        if (r111 == null) goto L37;
        Iterator<T> r112 = r111.iterator();
    L26:
        if (r112.hasNext() == false) goto L33;
        Object r113 = r112.next();
        if (((p0) r113).a() != r100.a()) goto L30;
        boolean r114 = true;
    L31:
        if (r114 == false) goto L26;
        r105 = r113;
        goto L33
    L30:
        r114 = false;
    L33:
        p0 r115 = (p0) r105;
        if (r115 == null) goto L37;
        ALogger.i("PSSpeedConfig", "use default level. " + r115);
        int r116 = com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.f133483e;
        return com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.a.a(r115);
    L37:
        p0 r117 = new p0(0);
        ALogger.i("PSSpeedConfig", "use fallback config. " + r117);
        int r118 = com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.f133483e;
        return com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e.a.a(r117);
    }
}
