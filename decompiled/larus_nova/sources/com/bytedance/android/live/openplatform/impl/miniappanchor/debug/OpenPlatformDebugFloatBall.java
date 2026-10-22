package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/OpenPlatformDebugFloatBall;", "Landroidx/appcompat/widget/AppCompatImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformDebugFloatBall extends AppCompatImageView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f84358b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IQRCodeService.b f84359a;

    public static final class a {
    }

    static {
    }

    public final int j(Context r100, int r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public OpenPlatformDebugFloatBall(ViewGroup r100, Context r101, MiniAppAnchorDebugContextService r102) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "scanResultListener");
        super(r101);
        this.f84359a = r102;
        UtilityKotlinExtentionsKt.t(this);
        setImageDrawable(s1.m(R.drawable.ttlive_open_platform_debug_ball));
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(j(r101, 36), j(r101, 36));
        r103.topMargin = j(r101, 134);
        r103.rightMargin = j(r101, 10);
        r103.gravity = GravityCompat.END;
        r100.addView(this, r103);
        setOnClickListener(new g(this));
    }
}
