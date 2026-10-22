package com.bytedance.android.live.livepkaudience.seat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/seat/PkSeatAnimationView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/livepkaudience/seat/d;", "taskChain", "", "setTaskChain", "Lcom/bytedance/android/live/livepkaudience/seat/SeatAnimTaskState;", "getTaskState", "Lcom/bytedance/android/livesdk/chatroom/ui/e6;", "emojiCallback", "setEmojiCallback", "Lcom/bytedance/android/livesdk/chatroom/ui/DynamicEmojiView;", "getDynamicEmojiView", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getEmojiMaskLayer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkSeatAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f82230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f82231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DynamicEmojiView f82232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f82233d;

    public PkSeatAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PkSeatAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final SeatAnimTaskState getTaskState() {
        g r100 = this.f82230a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f82241a;
    }

    public final DynamicEmojiView getDynamicEmojiView() {
        return this.f82232c;
    }

    public final HSImageView getEmojiMaskLayer() {
        return this.f82233d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setEmojiCallback(e6 r100) {
        Intrinsics.checkNotNullParameter(r100, "emojiCallback");
        DynamicEmojiView r101 = this.f82232c;
        if (r101 == null) goto L6;
        r101.setEmojiAnimCallback(r100);
        return;
    }

    public final void setTaskChain(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskChain");
        g r101 = this.f82230a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "chain");
        r101.f82242b = r100;
        return;
    }

    public PkSeatAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ PkSeatAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
