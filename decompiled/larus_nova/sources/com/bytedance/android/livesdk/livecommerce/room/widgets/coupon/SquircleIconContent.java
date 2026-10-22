package com.bytedance.android.livesdk.livecommerce.room.widgets.coupon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.graphics.PathParser;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/SquircleIconContent;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "isTempShortTouch", "()Z", "setTempShortTouch", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SquircleIconContent extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Path f152076b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Path f152077c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f152078a;

    public static final class a {
    }

    public SquircleIconContent(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SquircleIconContent(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        Path r100 = PathParser.createPathFromPathData("M0 7.99818C0 3.5799 3.5799 0 7.99818 0C11.0318 0 14.5807 0 18 0C21.4193 0 24.9682 0 28.0018 0C32.4201 0 36 3.5799 36 7.99817C36 11.0318 36 14.5807 36 18C36 21.4193 36 24.9682 36 28.0018C36 32.4201 32.4201 36 28.0018 36C24.9682 36 21.4193 36 18 36C14.5807 36 11.0318 36 7.99818 36C3.5799 36 0 32.4201 0 28.0018C0 24.9682 0 21.4193 0 18C0 14.5807 0 11.0318 0 7.99818Z");
        Matrix r101 = new Matrix();
        Resources r102 = Resources.getSystem();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        r101.setScale(r103, r103);
        r100.transform(r101);
        f152076b = r100;
        Path r104 = PathParser.createPathFromPathData("M0.125,8.037C0.228,3.456 4.001,-0.157 8.583,-0.132C18.429,-0.078 35.648,0 52,0C68.386,0 85.644,0 95.479,0C100.037,0 103.773,3.6 103.876,8.156C103.944,11.162 104,14.658 104,18.027C104,21.397 103.944,24.892 103.876,27.898C103.773,32.455 100.037,36.055 95.479,36.055C85.644,36.055 68.386,36.055 52,36.055C35.648,36.055 18.429,36.133 8.583,36.187C4.001,36.211 0.228,32.599 0.125,28.017C0.056,24.965 -0,21.418 -0,18.027C-0,14.636 0.056,11.09 0.125,8.037Z");
        Matrix r105 = new Matrix();
        Resources r106 = Resources.getSystem();
        float r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density;
        r105.setScale(r107, r107);
        r104.transform(r105);
        f152077c = r104;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f152078a == false) goto L5;
        r100.clipPath(f152077c);
    L6:
        r100.drawARGB(61, 21, 23, 34);
        super.dispatchDraw(r100);
        return;
    L5:
        r100.clipPath(f152076b);
        goto L6
    }

    public final void setTempShortTouch(boolean r100) {
        this.f152078a = r100;
    }

    public SquircleIconContent(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SquircleIconContent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
