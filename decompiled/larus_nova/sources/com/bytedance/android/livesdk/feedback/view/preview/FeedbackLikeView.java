package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000eB\u001d\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/view/preview/FeedbackLikeView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/feedback/view/preview/i;", "listenerView", "", "setLikeClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackLikeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f124987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f124988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f124989c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedbackLikeView f124990a;

        public a(FeedbackLikeView r100) {
            this.f124990a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f124990a.a();
        }
    }

    public final void a() {
        if (this.f124989c == true) goto L5;
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this.f124987a, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.9f, 1.1f, 1.0f});
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f124987a, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.9f, 1.1f, 1.0f});
        AnimatorSet r102 = new AnimatorSet();
        r102.setDuration(200);
        r102.addListener(new com.bytedance.android.livesdk.feedback.view.preview.a(this));
        r102.playTogether(new Animator[]{r100, r101});
        r102.start();
    L6:
        boolean r103 = !this.f124989c;
        this.f124989c = r103;
        i r104 = this.f124988b;
        if (r104 == null) goto L10;
        r104.onClick(r103);
        return;
    L10:
        return;
    L5:
        this.f124987a.setBackground(s1.m(R.drawable.ttlive_ic_feedback_unlike));
        goto L6
    }

    public FeedbackLikeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0);
    }

    public final void setLikeClickListener(i r100) {
        Intrinsics.checkNotNullParameter(r100, "listenerView");
        this.f124988b = r100;
    }

    public FeedbackLikeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public FeedbackLikeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.ttlive_feedback_like_view_layout, this);
        this.f124987a = findViewById(R.id.ic_img);
        setOnClickListener(new a(this));
    }
}
