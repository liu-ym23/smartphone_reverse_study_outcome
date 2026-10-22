package com.bytedance.android.livesdk.interactivity.chatchannel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/view/ChatChannelBlurView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelBlurView extends FrameLayout {
    public ChatChannelBlurView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatChannelBlurView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return true;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = findViewById(R.id.mock_blur_view);
        View r101 = findViewById(R.id.encrypt_message_view);
        if (c.f132980i == false) goto L8;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        if (r101 == null) goto L13;
        r101.setVisibility(0);
        return;
    L13:
        return;
    L8:
        if (r100 == null) goto L10;
        r100.setVisibility(0);
    L10:
        if (r101 == null) goto L15;
        r101.setVisibility(8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        ALogger.i("ChatChannelBlurView", "onDraw");
    }

    public ChatChannelBlurView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.blurRadius, R.attr.downsampleFactor, R.attr.updateInterval});
        int r104 = r103.getInt(0, 12);
        r103.recycle();
        if (c.f132980i == false) goto L6;
        float r105 = r104;
        setRenderEffect(RenderEffect.createBlurEffect(r105, r105, Shader.TileMode.CLAMP));
        setWillNotDraw(false);
        setLayerType(2, null);
        return;
    }

    public /* synthetic */ ChatChannelBlurView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
