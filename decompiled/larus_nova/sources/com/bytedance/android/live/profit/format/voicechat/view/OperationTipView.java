package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.config.bi1;
import com.larus.nova.R;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nu0.j;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/OperationTipView;", "Landroid/widget/FrameLayout;", "", "d", "Lkotlin/Lazy;", "getThinking", "()Ljava/lang/String;", SubtitleListUpdateType.THINKING, "e", "getThinkingContent", "thinkingContent", "f", "getStartTopic", "startTopic", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OperationTipView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f87720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f87721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f87722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f87723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f87724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f87725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f87726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f87727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f87728i;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f87729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f87730b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            if (this.f87730b == true) goto L6;
            ViewUtilsKt.e(this.f87729a);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            if (this.f87730b == false) goto L6;
            UtilityKotlinExtentionsKt.w(this.f87729a);
            return;
        }

        public a(View r100, boolean r101) {
            this.f87729a = r100;
            this.f87730b = r101;
        }
    }

    public OperationTipView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OperationTipView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final String getStartTopic() {
        return (String) this.f87725f.getValue();
    }

    private final String getThinking() {
        return (String) this.f87723d.getValue();
    }

    private final String getThinkingContent() {
        return (String) this.f87724e.getValue();
    }

    public static final /* synthetic */ String a(OperationTipView r100) {
        return r100.getThinking();
    }

    public static final /* synthetic */ String b(OperationTipView r100) {
        return r100.getThinkingContent();
    }

    public final Animator c(boolean r100) {
        Object r101 = Float.valueOf(0.0f);
        Float r102 = Float.valueOf(1.0f);
        PathInterpolator r103 = new PathInterpolator(0.76f, 0.0f, 0.24f, 1.0f);
        Property r104 = View.ALPHA;
        float[] r105 = new float[2];
        Object r106 = bi1.a(Boolean.valueOf(r100), r101);
        if (r106 != null) goto L5;
        r106 = r102;
    L5:
        r105[0] = ((Number) r106).floatValue();
        Object r107 = bi1.a(Boolean.valueOf(r100), r102);
        if (r107 == null) goto L9;
        r101 = r107;
    L9:
        r105[1] = ((Number) r101).floatValue();
        ObjectAnimator r108 = ObjectAnimator.ofFloat(this, r104, r105);
        r108.setDuration(200);
        r108.setStartDelay(0);
        r108.setInterpolator(r103);
        r108.addListener(new a(this, r100));
        return r108;
    }

    public final void d(ju0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        j.d(this, "onReceiveTopicMsg, topics: " + r100.f500405b, null);
        Disposable r101 = this.f87728i;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        e(this.f87727h, getStartTopic(), r100.f500405b);
    }

    public OperationTipView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f87723d = LazyKt.lazy(new OperationTipView$thinking$2(r100));
        this.f87724e = LazyKt.lazy(new OperationTipView$thinkingContent$2(r100));
        this.f87725f = LazyKt.lazy(new OperationTipView$startTopic$2(r100));
        this.f87726g = R.drawable.ttlive_format_voice_chat_thinking_icon;
        this.f87727h = R.drawable.ttlive_format_voice_chat_topic_icon;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_format_voice_chat_opeartion_tip_layout, this);
        this.f87720a = (ImageView) findViewById(R.id.tip_icon);
        this.f87721b = (TextView) findViewById(R.id.tip_title);
        this.f87722c = (ViewGroup) findViewById(R.id.tip_container);
    }

    public final void e(int r100, String r101, List<String> r102) {
        this.f87720a.setImageResource(r100);
        this.f87721b.setText(r101);
        this.f87722c.removeAllViews();
        List r103 = CollectionsKt.take(r102, 3);
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        String r106 = (String) r105.next();
        TextView r107 = new TextView(getContext(), null, 0, R.style.voice_chat_topic_text);
        r107.setText(r106);
        ViewGroup r108 = this.f87722c;
        ViewGroup.MarginLayoutParams r109 = new ViewGroup.MarginLayoutParams(-1, -2);
        r109.topMargin = UtilityKotlinExtentionsKt.i(12);
        Unit r110 = Unit.INSTANCE;
        r108.addView(r107, r109);
        r104.add(r107);
        goto L4
    L6:
        c(true).start();
    }

    public /* synthetic */ OperationTipView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
