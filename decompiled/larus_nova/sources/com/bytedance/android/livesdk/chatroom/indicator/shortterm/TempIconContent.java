package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/TempIconContent;", "Landroid/widget/LinearLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "isBackgroundEnabled", "()Z", "setBackgroundEnabled", "(Z)V", "", "b", FaceService.girlLabel, "getBackgroundAlpha", "()F", "setBackgroundAlpha", "(F)V", "backgroundAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TempIconContent extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f106542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f106543b;

    public TempIconContent(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TempIconContent(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getBackgroundAlpha() {
        return this.f106543b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Path r101 = new Path();
        r101.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(8), Path.Direction.CW);
        r100.clipPath(r101);
        if (this.f106542a == false) goto L5;
        setBackgroundResource(R.drawable.ttlive_temp_short_term_bg);
    L6:
        super.dispatchDraw(r100);
        return;
    L5:
        setBackgroundColor(0);
        goto L6
    }

    public final void setBackgroundAlpha(float r100) {
        this.f106543b = r100;
    }

    public final void setBackgroundEnabled(boolean r100) {
        this.f106542a = r100;
    }

    public TempIconContent(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        this.f106542a = true;
        this.f106543b = 1.0f;
    }

    public /* synthetic */ TempIconContent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
