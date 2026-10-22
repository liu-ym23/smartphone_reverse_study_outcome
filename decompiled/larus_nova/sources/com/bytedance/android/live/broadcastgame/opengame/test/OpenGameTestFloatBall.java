package com.bytedance.android.live.broadcastgame.opengame.test;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.openplatform.f;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/test/OpenGameTestFloatBall;", "Landroid/widget/FrameLayout;", "", "onFloatBallClick", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "dp", "dp2px", "setVisible", "setGone", "release", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenGameTestFloatBall extends FrameLayout {
    public static final b Companion = null;
    public static final int HEIGHT = 36;
    public static final int WIDTH = 36;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenGameTestFloatBall f61095a;

        public a(OpenGameTestFloatBall r100) {
            this.f61095a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OpenGameTestFloatBall.access$onFloatBallClick(this.f61095a);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    private final void onFloatBallClick() {
        xs2.b.a().post(new f(0));
    }

    public final void release() {
        setGone();
    }

    public final void setGone() {
        UtilityKotlinExtentionsKt.t(this);
    }

    public final void setVisible() {
        UtilityKotlinExtentionsKt.w(this);
    }

    public OpenGameTestFloatBall(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        UtilityKotlinExtentionsKt.t(this);
        setOnClickListener(new a(this));
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_live_broadcastgame_opengame_test_OpenGameTestFloatBall_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ void access$onFloatBallClick(OpenGameTestFloatBall r100) {
        r100.onFloatBallClick();
    }

    public OpenGameTestFloatBall(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        UtilityKotlinExtentionsKt.t(this);
        setOnClickListener(new a(this));
    }

    private final int dp2px(Context r100, int r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_bytedance_android_live_broadcastgame_opengame_test_OpenGameTestFloatBall_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public OpenGameTestFloatBall(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        UtilityKotlinExtentionsKt.t(this);
        setOnClickListener(new a(this));
    }
}
