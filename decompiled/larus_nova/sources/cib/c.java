package cib;

import android.app.Activity;
import androidx.core.math.MathUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23904a = 0;

    static {
    }

    public static ForsetiMode a(Activity r100, Integer r101) {
        if (r101 == null) goto L13;
        r101.intValue();
        if (r100 == null) goto L6;
        b(r100, r101.intValue());
        if (r101.intValue() >= UIUtils.dp2px(r100, 636.0f)) goto L11;
        return ForsetiMode.Compact;
    L11:
        return ForsetiMode.Regular;
    L6:
        return ForsetiMode.Unknown;
    L13:
        return ForsetiMode.Unknown;
    }

    public static com.ss.android.lark.base.embedded.e b(Activity r100, int r101) {
        int r102 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.placeholder_cover_feed_disabled") == false) goto L5;
        int r103 = com.ss.android.lark.base.embedded.e.f409753c;
        return com.ss.android.lark.base.embedded.e.a.b(r100, r101);
    L5:
        int r104 = com.ss.android.lark.base.embedded.e.f409753c;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 < com.ss.android.lark.base.embedded.e.a.a(r100, 854.0f)) goto L8;
        float r105 = r101;
        MathUtils.clamp(com.ss.android.lark.base.embedded.e.a.a(r100, 420.0f), MathKt.roundToInt(0.3f * r105), MathKt.roundToInt(r105 * 0.375f));
        com.ss.android.lark.base.embedded.e r106 = new com.ss.android.lark.base.embedded.e(com.ss.android.lark.base.embedded.e.a.a(r100, 854.0f), com.ss.android.lark.base.embedded.e.a.a(r100, 550.0f));
    L10:
        return r106;
    L8:
        r106 = new com.ss.android.lark.base.embedded.e(com.ss.android.lark.base.embedded.e.a.a(r100, 636.0f), com.ss.android.lark.base.embedded.e.a.a(r100, 550.0f));
        goto L10
    }
}
