package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.config.bi1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatButtonView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatButtonView$d;", "listener", "", "setButtonClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "d", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatButtonView extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f87773e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f87774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u0 f87775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f87776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f87777d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatButtonView f87778a;

        public a(VoiceChatButtonView r100) {
            this.f87778a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            final VoiceChatButtonView r101 = this.f87778a;
            MutablePropertyReference0Impl r102 = new VoiceChatButtonView$1$1(r101);
            u0 r103 = u0.f90999f;
            if (t0.a(r102, new u0(500)) == true) goto L5;
            return;
        L5:
            d r104 = this.f87778a.f87774a;
            if (r104 == null) goto L9;
            r104.b();
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatButtonView f87779a;

        public b(VoiceChatButtonView r100) {
            this.f87779a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            final VoiceChatButtonView r101 = this.f87779a;
            MutablePropertyReference0Impl r102 = new VoiceChatButtonView$2$1(r101);
            u0 r103 = u0.f90999f;
            if (t0.a(r102, new u0(500)) == true) goto L5;
            return;
        L5:
            d r104 = this.f87779a.f87774a;
            if (r104 == null) goto L9;
            r104.a();
            return;
        }
    }

    public static final class c {
    }

    public interface d {
        void a();

        void b();
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f87780a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        public e(View r100) {
            this.f87780a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            UtilityKotlinExtentionsKt.w(this.f87780a);
        }
    }

    public static final class f implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f87781a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        public f(View r100) {
            this.f87781a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            ViewUtilsKt.e(this.f87781a);
        }
    }

    static {
    }

    public VoiceChatButtonView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceChatButtonView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setButtonClickListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f87774a = r100;
    }

    public final Animator a(boolean r110, long r111) {
        Float r100 = Float.valueOf(1.0f);
        Object r101 = Float.valueOf(0.0f);
        if (r110 == false) goto L12;
        PathInterpolator r112 = new PathInterpolator(0.76f, 0.0f, 0.24f, 1.0f);
        Property r102 = View.ALPHA;
        float[] r103 = new float[2];
        Boolean r104 = Boolean.TRUE;
        Object r105 = bi1.a(r104, r101);
        if (r105 != null) goto L7;
        r105 = r100;
    L7:
        r103[0] = ((Number) r105).floatValue();
        Object r106 = bi1.a(r104, r100);
        if (r106 == null) goto L11;
        r101 = r106;
    L11:
        r103[1] = ((Number) r101).floatValue();
        ObjectAnimator r107 = ObjectAnimator.ofFloat(this, r102, r103);
        r107.setDuration(417);
        r107.setStartDelay(r111);
        r107.setInterpolator(r112);
        r107.addListener(new e(this));
        return r107;
    L12:
        PathInterpolator r113 = new PathInterpolator(0.5f, 0.0f, 0.5f, 1.0f);
        Property r108 = View.ALPHA;
        float[] r109 = new float[2];
        Boolean r114 = Boolean.FALSE;
        Object r115 = bi1.a(r114, r101);
        if (r115 != null) goto L15;
        r115 = r100;
    L15:
        r109[0] = ((Number) r115).floatValue();
        Object r116 = bi1.a(r114, r100);
        if (r116 == null) goto L19;
        r101 = r116;
    L19:
        r109[1] = ((Number) r101).floatValue();
        ObjectAnimator r117 = ObjectAnimator.ofFloat(this, r108, r109);
        r117.setDuration(383);
        r117.setStartDelay(r111);
        r117.setInterpolator(r113);
        r117.addListener(new f(this));
        return r117;
    }

    public VoiceChatButtonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        u0 r103 = u0.f90999f;
        this.f87775b = u0.f90999f;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_format_voice_chat_button_layout, this);
        this.f87776c = (TextView) findViewById(R.id.voice_chat_button_text);
        this.f87777d = (TextView) findViewById(R.id.voice_chat_tip);
        View r104 = findViewById(R.id.voice_chat_exit);
        if (r104 == null) goto L5;
        r104.setOnClickListener(new a(this));
    L5:
        VoiceChatStartButton r105 = (VoiceChatStartButton) findViewById(R.id.voice_chat_button);
        if (r105 == null) goto L9;
        r105.setOnClickListener(new b(this));
        return;
    }

    public /* synthetic */ VoiceChatButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
