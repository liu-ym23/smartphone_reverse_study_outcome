package com.bytedance.android.shopping.feed.widget.gesture;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundLinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends RoundLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f176025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f176026b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.widget.gesture.b$b, reason: collision with other inner class name */
    public interface InterfaceC2609b {
        void onAnimationCancel();

        void onAnimationEnd();
    }

    static {
    }

    public b(Context r100) {
        this(r100, null, 14);
    }

    private final TextView getLongPressDescView() {
        return (TextView) this.f176026b.getValue();
    }

    private final LottieAnimationView getLottieView() {
        return (LottieAnimationView) this.f176025a.getValue();
    }

    public static final /* synthetic */ LottieAnimationView a(b r100) {
        return r100.getLottieView();
    }

    public b(final Context r100, final com.bytedance.android.shopping.feed.widget.b r101, int r102) {
        Drawable r103 = null;
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f176025a = LazyKt.lazy(new GestureView$lottieView$2(this, r100, r101));
        this.f176026b = LazyKt.lazy(new GestureView$longPressDescView$2(r100));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setOrientation(1);
        ViewExtensionsKt.g(this, 16.0f, 16.0f, 16.0f, 16.0f);
        setGravity(17);
        addView(getLottieView());
        addView(getLongPressDescView());
        int r104 = ContextCompat.getColor(r100, R.color.ec_inner_flow_long_press_gesture_bg);
        Drawable r105 = getBackground();
        if ((r105 instanceof BackgroundDrawable) == false) goto L9;
        r103 = r105;
    L9:
        BackgroundDrawable r106 = (BackgroundDrawable) r103;
        if (r106 == null) goto L14;
        BackgroundDrawable r107 = r106.setBgColor(r104);
        if (r107 == null) goto L14;
        r107.invalidate();
    L14:
        new Handler(Looper.getMainLooper()).postDelayed(new com.bytedance.android.shopping.feed.widget.gesture.a(this), 3000);
    }
}
