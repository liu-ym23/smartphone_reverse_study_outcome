package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.graphics.PathParser;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/framework/SquircleIconContent;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "isMaskEnabled", "()Z", "setMaskEnabled", "(Z)V", "b", "isBackgroundEnabled", "setBackgroundEnabled", "", "c", FaceService.girlLabel, "getBackgroundAlpha", "()F", "setBackgroundAlpha", "(F)V", "backgroundAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SquircleIconContent extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Path f106618d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f106619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f106620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f106621c;

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
        Resources r102 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        r101.setScale(r103, r103);
        r100.transform(r101);
        f106618d = r100;
    }

    public final float getBackgroundAlpha() {
        return this.f106621c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f106619a == false) goto L6;
        r100.clipPath(f106618d);
    L6:
        if (this.f106620b == false) goto L8;
        r100.drawARGB((int) (61 * this.f106621c), 21, 23, 34);
    L8:
        super.dispatchDraw(r100);
    }

    public final void setBackgroundAlpha(float r100) {
        this.f106621c = r100;
    }

    public final void setBackgroundEnabled(boolean r100) {
        this.f106620b = r100;
    }

    public final void setMaskEnabled(boolean r100) {
        this.f106619a = r100;
    }

    public SquircleIconContent(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f106619a = true;
        this.f106620b = true;
        this.f106621c = 1.0f;
    }

    public /* synthetic */ SquircleIconContent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
