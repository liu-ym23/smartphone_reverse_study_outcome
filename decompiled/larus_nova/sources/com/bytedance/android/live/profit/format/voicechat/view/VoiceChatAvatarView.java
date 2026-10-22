package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatAvatarView;", "Landroid/widget/FrameLayout;", "", "scale", "", "setTagMargin", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatAvatarView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f87760h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f87761i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f87762j = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f87763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f87764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CircleProgressView f87765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f87766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f87767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f87768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f87769g;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatAvatarView f87770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f87771b;

        public b(VoiceChatAvatarView r100, boolean r101) {
            this.f87770a = r100;
            this.f87771b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "anim");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L34;
            float r102 = ((Float) r101).floatValue();
            float r103 = 1;
            float r104 = (0.40310073f * r102) + r103;
            ImageView r105 = this.f87770a.f87763a;
            if (r105 == null) goto L7;
            r105.setAlpha(r103 - ((r103 - r102) * 0.2f));
        L7:
            ImageView r106 = this.f87770a.f87768f;
            if (r106 == null) goto L12;
            Drawable r107 = r106.getDrawable();
            if (r107 == null) goto L12;
            r107.setAlpha(MathKt.roundToInt((r103 - ((r103 - r102) * 0.5f)) * 255));
        L12:
            ImageView r108 = this.f87770a.f87763a;
            if (r108 == null) goto L15;
            r108.setScaleX(r104);
            r108.setScaleY(r104);
        L15:
            ImageView r109 = this.f87770a.f87764b;
            if (r109 == null) goto L18;
            r109.setScaleX(r104);
            r109.setScaleY(r104);
        L18:
            ImageView r110 = this.f87770a.f87768f;
            if (r110 == null) goto L21;
            r110.setScaleX(r104);
            r110.setScaleY(r104);
        L21:
            CircleProgressView r111 = this.f87770a.f87765c;
            if (r111 == null) goto L24;
            r111.setScaleX(r104);
            r111.setScaleY(r104);
        L24:
            VoiceChatAvatarView.a(this.f87770a, r104);
            if (this.f87771b == false) goto L29;
            CircleProgressView r112 = this.f87770a.f87765c;
            if (r112 == null) goto L35;
            r112.setProgress(r102);
            return;
        L35:
            return;
        L29:
            ImageView r113 = this.f87770a.f87763a;
            if (r113 == null) goto L37;
            r113.invalidate();
            return;
        L37:
            return;
        L34:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatAvatarView f87772a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        public c(VoiceChatAvatarView r100) {
            this.f87772a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            ImageView r101 = this.f87772a.f87764b;
            if (r101 == null) goto L6;
            UtilityKotlinExtentionsKt.e(r101, 200);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            ImageView r101 = this.f87772a.f87764b;
            if (r101 == null) goto L5;
            r101.setAlpha(0.0f);
        L5:
            ImageView r102 = this.f87772a.f87764b;
            if (r102 == null) goto L9;
            UtilityKotlinExtentionsKt.d(r102, 200);
            return;
        }
    }

    public VoiceChatAvatarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceChatAvatarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        StringBuilder r100 = new StringBuilder("https://");
        LiveCommonConstants r101 = LiveCommonConstants.INSTANCE;
        r100.append(r101.getObjectTosPath());
        r100.append("/obj/live-android/voice_chat_voice_wave_v2.webp");
        f87760h = r100.toString();
        f87761i = "https://" + r101.getObjectTosPath() + "/obj/live-android/voice_chat_thinking.webp";
        f87762j = UtilityKotlinExtentionsKt.h(45.5f);
    }

    private final void setTagMargin(float r100) {
        ImageView r101 = this.f87768f;
        if (r101 == null) goto L11;
        if (r101 == null) goto L6;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L7:
        if (r102 == null) goto L10;
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        float r104 = f87762j;
        r103.topMargin = MathKt.roundToInt(r104 * r100);
        r103.leftMargin = MathKt.roundToInt(r104 * r100);
        Unit r105 = Unit.INSTANCE;
        r101.setLayoutParams(r103);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L6:
        r102 = null;
        goto L7
    }

    public static final /* synthetic */ void a(VoiceChatAvatarView r100, float r101) {
        r100.setTagMargin(r101);
    }

    public VoiceChatAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_format_voice_chat_avatar_layout, this);
        this.f87763a = (ImageView) findViewById(R.id.voice_chat_avatar);
        this.f87764b = (ImageView) findViewById(R.id.voice_chat_avatar_bg);
        this.f87765c = (CircleProgressView) findViewById(R.id.voice_chat_progress);
        this.f87769g = (HSImageView) findViewById(R.id.voice_chat_thinking);
        this.f87766d = (HSImageView) findViewById(R.id.voice_chat_voice_wave);
        ImageView r103 = (ImageView) findViewById(R.id.voice_chat_ai_tag);
        this.f87768f = r103;
        if (r103 == null) goto L9;
        Drawable r104 = AppCompatResources.getDrawable(r100, R.drawable.ttlive_format_voice_chat_ai_tag);
        if (r104 == null) goto L7;
        Drawable r105 = r104.mutate();
    L8:
        r103.setImageDrawable(r105);
        goto L9
    L7:
        r105 = null;
    L9:
        if (r103 == null) goto L14;
        Drawable r106 = r103.getDrawable();
        if (r106 == null) goto L15;
        r106.setAlpha(MathKt.roundToInt(0.5f * 255));
        return;
    L15:
        return;
    }

    public final Animator b(long r100, boolean r101, boolean r102) {
        if (r101 == false) goto L8;
        CircleProgressView r103 = this.f87765c;
        if (r103 == null) goto L7;
        r103.setProgressDirection(Path.Direction.CW);
    L7:
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    L12:
        r104.addUpdateListener(new b(this, r102));
        r104.addListener(new c(this));
        r104.setDuration(r100);
        r104.setInterpolator(new PathInterpolator(0.5f, 0.0f, 0.5f, 1.0f));
        return r104;
    L8:
        CircleProgressView r105 = this.f87765c;
        if (r105 == null) goto L11;
        r105.setProgressDirection(Path.Direction.CCW);
    L11:
        r104 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        goto L12
    }

    public /* synthetic */ VoiceChatAvatarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
