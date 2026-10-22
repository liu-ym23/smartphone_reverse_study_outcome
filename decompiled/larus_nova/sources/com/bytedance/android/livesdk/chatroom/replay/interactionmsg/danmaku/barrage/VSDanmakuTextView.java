package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.Layout;
import android.util.AttributeSet;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/barrage/VSDanmakuTextView;", "Lcom/bytedance/android/livesdk/chatroom/ui/StrokeTextView;", "", "getMaxLineRight", "", "color", "", "setTextColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSDanmakuTextView extends StrokeTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearGradient f108989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f108990g;

    public VSDanmakuTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VSDanmakuTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final float getMaxLineRight() {
        Layout r100 = getLayout();
        float r101 = 0.0f;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        int r102 = r100.getLineCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r101 = Math.max(r101, r100.getLineRight(r103));
        r103 = r103 + 1;
        goto L6
    L8:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.StrokeTextView, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f108989f != null) goto L5;
    L9:
        super.onDraw(r100);
        return;
    L5:
        if (getLayout() == null) goto L9;
        this.f108990g.reset();
        this.f108990g.setScale(getMaxLineRight(), getLayout().getHeight(), 0.0f, 0.0f);
        LinearGradient r101 = this.f108989f;
        if (r101 == null) goto L9;
        r101.setLocalMatrix(this.f108990g);
        goto L9
    }

    @Override // android.widget.TextView
    public void setTextColor(int r100) {
        this.f108989f = null;
        getPaint().setShader(null);
        super.setTextColor(r100);
    }

    public final void y(int r110, int r111) {
        this.f108989f = new LinearGradient(0.0f, 1.0f, 1.0f, 1.0f, r110, r111, Shader.TileMode.CLAMP);
        getPaint().setShader(this.f108989f);
        invalidate();
    }

    public VSDanmakuTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f108990g = new Matrix();
    }

    public /* synthetic */ VSDanmakuTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
