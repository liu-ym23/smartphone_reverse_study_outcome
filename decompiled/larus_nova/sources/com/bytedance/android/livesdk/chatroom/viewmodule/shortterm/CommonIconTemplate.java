package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/shortterm/CommonIconTemplate;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonIconTemplate extends FrameLayout implements IconTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animator f115511a;

    public CommonIconTemplate(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonIconTemplate(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IconTemplate
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IconTemplate
    public final Animator getEntryAnimation(long r100) {
        getView().setScaleX(0.0f);
        getView().setScaleY(0.0f);
        AnimatorSet r101 = com.bytedance.android.live.core.utils.h.c(getView(), new float[]{1.0f});
        r101.setDuration(250);
        r101.setInterpolator(new DecelerateInterpolator());
        AnimatorSet r102 = new AnimatorSet();
        r102.setStartDelay(r100);
        r102.play(r101);
        return r102;
    }

    public CommonIconTemplate(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ CommonIconTemplate(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
