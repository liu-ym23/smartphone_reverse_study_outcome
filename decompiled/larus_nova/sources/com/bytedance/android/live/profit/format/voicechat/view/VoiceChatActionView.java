package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nu0.j;
import nu0.m;
import nu0.n;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003%&'B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatActionView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatActionView$e;", "listener", "", "setActionListener", "Landroid/graphics/drawable/Drawable;", RXScreenCaptureService.KEY_INDEX, "Lkotlin/Lazy;", "getMuteDrawable", "()Landroid/graphics/drawable/Drawable;", "muteDrawable", ce.f26395j, "getUnMuteDrawable", "unMuteDrawable", "", ce.f26396k, "getConnectingText", "()Ljava/lang/String;", "connectingText", "l", "getTimeUPText", "timeUPText", "m", "getWaitingText", "waitingText", OfficeSDKRequestTag.KEY_NEW_USER, "getMutedText", "mutedText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "e", "VoiceChatAction", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatActionView extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f87731s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f87732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f87733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f87734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f87735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f87736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f87737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f87738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f87739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f87740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f87741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f87742k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f87743l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f87744m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f87745n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VoiceChatState f87746o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f87747p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Animator f87748q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f87749r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatActionView$VoiceChatAction;", "", "ACTION_CLOSE", "ACTION_MUTE", "ACTION_INTERCEPT", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum VoiceChatAction extends Enum<VoiceChatAction> {
        public static final VoiceChatAction ACTION_CLOSE = null;
        public static final VoiceChatAction ACTION_INTERCEPT = null;
        public static final VoiceChatAction ACTION_MUTE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VoiceChatAction[] f87750a = null;

        static {
            VoiceChatAction r100 = new VoiceChatAction("ACTION_CLOSE", 0);
            ACTION_CLOSE = r100;
            VoiceChatAction r101 = new VoiceChatAction("ACTION_MUTE", 1);
            ACTION_MUTE = r101;
            VoiceChatAction r102 = new VoiceChatAction("ACTION_INTERCEPT", 2);
            ACTION_INTERCEPT = r102;
            f87750a = new VoiceChatAction[]{r100, r101, r102};
        }

        public static VoiceChatAction valueOf(String r100) {
            return (VoiceChatAction) r27.a.a(VoiceChatAction.class, r100);
        }

        public static VoiceChatAction[] values() {
            return (VoiceChatAction[]) f87750a.clone();
        }

        public VoiceChatAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatActionView f87751a;

        public a(VoiceChatActionView r100) {
            this.f87751a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            e r101 = this.f87751a.f87733b;
            if (r101 == null) goto L6;
            r101.a(VoiceChatAction.ACTION_CLOSE);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatActionView f87752a;

        public b(VoiceChatActionView r100) {
            this.f87752a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            e r101 = this.f87752a.f87733b;
            if (r101 == null) goto L6;
            r101.a(VoiceChatAction.ACTION_MUTE);
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatActionView f87753a;

        public c(VoiceChatActionView r100) {
            this.f87753a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            e r101 = this.f87753a.f87733b;
            if (r101 == null) goto L6;
            r101.a(VoiceChatAction.ACTION_INTERCEPT);
            return;
        }
    }

    public static final class d {
    }

    public interface e {
        void a(VoiceChatAction r100);
    }

    public static final class f implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f87754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f87755b;

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
            if (this.f87755b == true) goto L6;
            ViewUtilsKt.e(this.f87754a);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            if (this.f87755b == false) goto L6;
            UtilityKotlinExtentionsKt.w(this.f87754a);
            return;
        }

        public f(View r100, boolean r101) {
            this.f87754a = r100;
            this.f87755b = r101;
        }
    }

    public static final class g implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatActionView f87756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f87757b;

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

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            VoiceChatActionView r101 = this.f87756a;
            r101.f87747p = this.f87757b;
        }

        public g(VoiceChatActionView r100, View r101) {
            this.f87756a = r100;
            this.f87757b = r101;
        }
    }

    public static final class h implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f87758a;

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

        public h(View r100) {
            this.f87758a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            ViewUtilsKt.e(this.f87758a);
        }
    }

    public static final class i implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f87759a;

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

        public i(View r100) {
            this.f87759a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            UtilityKotlinExtentionsKt.w(this.f87759a);
        }
    }

    public VoiceChatActionView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceChatActionView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final String getConnectingText() {
        return (String) this.f87742k.getValue();
    }

    private final Drawable getMuteDrawable() {
        return (Drawable) this.f87740i.getValue();
    }

    private final String getMutedText() {
        return (String) this.f87745n.getValue();
    }

    private final String getTimeUPText() {
        return (String) this.f87743l.getValue();
    }

    private final Drawable getUnMuteDrawable() {
        return (Drawable) this.f87741j.getValue();
    }

    private final String getWaitingText() {
        return (String) this.f87744m.getValue();
    }

    static {
        f87731s = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/voice_chat_listening.webp";
    }

    public final void b(VoiceChatState r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        j.a(this, "on chat state change, currentState:" + this.f87746o + ", targetState: " + r110);
        if (this.f87746o != r110) goto L5;
        return;
    L5:
        this.f87746o = r110;
        switch(com.bytedance.android.live.profit.format.voicechat.view.e.f87787a[r110.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L8;
            default: goto L43;
        };
    L8:
        TextView r100 = this.f87739h;
        Object r101 = bi1.a(Boolean.valueOf(this.f87749r), getMutedText());
        String r102 = getWaitingText();
        if (r101 != null) goto L11;
        r101 = r102;
    L11:
        r100.setText((CharSequence) r101);
        d(this.f87737f);
        return;
    L12:
        d(this.f87736e);
        return;
    L13:
        d(this.f87735d);
        return;
    L43:
        return;
    L15:
        if (r110 != VoiceChatState.CONNECTING) goto L17;
        boolean r103 = true;
    L18:
        Object r104 = bi1.a(Boolean.valueOf(r103), getConnectingText());
        String r105 = getTimeUPText();
        if (r104 != null) goto L21;
        r104 = r105;
    L21:
        String r106 = (String) r104;
        if (Intrinsics.areEqual(this.f87747p, this.f87734c) == false) goto L37;
        TextView r107 = this.f87734c;
        LinearInterpolator r108 = new LinearInterpolator();
        LinearInterpolator r109 = new LinearInterpolator();
        Intrinsics.checkNotNullParameter(r107, "$this$getChangeTextAnim");
        Intrinsics.checkNotNullParameter(r108, "hideInterpolator");
        Intrinsics.checkNotNullParameter(r109, "showInterpolator");
        AnimatorSet r111 = new AnimatorSet();
        Animator[] r112 = new Animator[2];
        long r113 = 680 / ((long) 2);
        Property r114 = View.ALPHA;
        float[] r115 = new float[2];
        Boolean r116 = Boolean.FALSE;
        Object r117 = Float.valueOf(0.0f);
        Object r118 = bi1.a(r116, r117);
        Float r119 = Float.valueOf(1.0f);
        if (r118 != null) goto L26;
        r118 = r119;
    L26:
        r115[0] = ((Number) r118).floatValue();
        Object r120 = bi1.a(r116, r119);
        if (r120 != null) goto L29;
        r120 = r117;
    L29:
        r115[1] = ((Number) r120).floatValue();
        ObjectAnimator r121 = ObjectAnimator.ofFloat(r107, r114, r115);
        r121.setDuration(r113);
        r121.setStartDelay(0);
        r121.setInterpolator(r108);
        r121.addListener(new n(r107, r107, r106));
        r112[0] = r121;
        Property r122 = View.ALPHA;
        float[] r123 = new float[2];
        Boolean r124 = Boolean.TRUE;
        Object r125 = bi1.a(r124, r117);
        if (r125 != null) goto L32;
        r125 = r119;
    L32:
        r123[0] = ((Number) r125).floatValue();
        Object r126 = bi1.a(r124, r119);
        if (r126 == null) goto L36;
        r117 = r126;
    L36:
        r123[1] = ((Number) r117).floatValue();
        ObjectAnimator r127 = ObjectAnimator.ofFloat(r107, r122, r123);
        r127.setDuration(r113);
        r127.setStartDelay(0);
        r127.setInterpolator(r109);
        r127.addListener(new m(r107));
        r112[1] = r127;
        r111.playSequentially(r112);
        r111.start();
        return;
    L37:
        this.f87734c.setText(r106);
        d(this.f87734c);
        return;
    L17:
        r103 = false;
        goto L18
    }

    public final void c(boolean r100) {
        ImageView r101 = this.f87732a;
        Object r102 = bi1.a(Boolean.valueOf(r100), getUnMuteDrawable());
        Drawable r103 = getMuteDrawable();
        if (r102 != null) goto L5;
        r102 = r103;
    L5:
        r101.setImageDrawable((Drawable) r102);
        this.f87749r = r100;
        if (this.f87746o != VoiceChatState.WAITING) goto L12;
        TextView r104 = this.f87739h;
        Object r105 = bi1.a(Boolean.valueOf(r100), getMutedText());
        String r106 = getWaitingText();
        if (r105 != null) goto L10;
        r105 = r106;
    L10:
        r104.setText((CharSequence) r105);
        return;
    }

    public final void d(View r110) {
        if (Intrinsics.areEqual(this.f87747p, r110) == false) goto L5;
        return;
    L5:
        Animator r100 = this.f87748q;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        View r101 = this.f87747p;
        if (r101 == null) goto L17;
        PathInterpolator r111 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        Property r102 = View.ALPHA;
        float[] r103 = new float[2];
        Boolean r104 = Boolean.FALSE;
        Object r105 = bi1.a(r104, Float.valueOf(0.0f));
        Float r112 = Float.valueOf(1.0f);
        if (r105 != null) goto L13;
        r105 = r112;
    L13:
        r103[0] = ((Number) r105).floatValue();
        Object r106 = bi1.a(r104, Float.valueOf(1.0f));
        Float r107 = Float.valueOf(0.0f);
        if (r106 != null) goto L16;
        r106 = r107;
    L16:
        r103[1] = ((Number) r106).floatValue();
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r101, r102, r103);
        r108.setDuration(340);
        r108.setStartDelay(0);
        r108.setInterpolator(r111);
        r108.addListener(new h(r101));
    L18:
        if (r110 == null) goto L26;
        PathInterpolator r109 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        Property r113 = View.ALPHA;
        float[] r114 = new float[2];
        Boolean r115 = Boolean.TRUE;
        Object r116 = bi1.a(r115, Float.valueOf(0.0f));
        Float r117 = Float.valueOf(1.0f);
        if (r116 != null) goto L22;
        r116 = r117;
    L22:
        r114[0] = ((Number) r116).floatValue();
        Object r118 = bi1.a(r115, Float.valueOf(1.0f));
        Float r119 = Float.valueOf(0.0f);
        if (r118 != null) goto L25;
        r118 = r119;
    L25:
        r114[1] = ((Number) r118).floatValue();
        ObjectAnimator r120 = ObjectAnimator.ofFloat(r110, r113, r114);
        r120.setDuration(340);
        r120.setStartDelay(0);
        r120.setInterpolator(r109);
        r120.addListener(new i(r110));
        ObjectAnimator r121 = r120;
    L27:
        AnimatorSet r122 = new AnimatorSet();
        r122.playSequentially(new Animator[]{r108, r121});
        r122.addListener(new g(this, r110));
        r122.start();
        Unit r123 = Unit.INSTANCE;
        this.f87748q = r122;
        return;
    L26:
        r121 = null;
        goto L27
    L17:
        r108 = null;
        goto L18
    }

    public final void setActionListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f87733b = r100;
    }

    public final Animator a(boolean r110, long r111) {
        Object r100 = bi1.a(Boolean.valueOf(r110), 467L);
        if (r100 != null) goto L5;
        r100 = 933L;
    L5:
        long r101 = ((Number) r100).longValue();
        PathInterpolator r102 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        Property r103 = View.ALPHA;
        float[] r104 = new float[2];
        Object r105 = bi1.a(Boolean.valueOf(r110), Float.valueOf(0.0f));
        Float r106 = Float.valueOf(1.0f);
        if (r105 != null) goto L8;
        r105 = r106;
    L8:
        r104[0] = ((Number) r105).floatValue();
        Object r107 = bi1.a(Boolean.valueOf(r110), Float.valueOf(1.0f));
        Float r108 = Float.valueOf(0.0f);
        if (r107 != null) goto L11;
        r107 = r108;
    L11:
        r104[1] = ((Number) r107).floatValue();
        ObjectAnimator r109 = ObjectAnimator.ofFloat(this, r103, r104);
        r109.setDuration(r101);
        r109.setStartDelay(r111);
        r109.setInterpolator(r102);
        r109.addListener(new f(this, r110));
        return r109;
    }

    public VoiceChatActionView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f87740i = LazyKt.lazy(new VoiceChatActionView$muteDrawable$2(r100));
        this.f87741j = LazyKt.lazy(new VoiceChatActionView$unMuteDrawable$2(r100));
        this.f87742k = LazyKt.lazy(new VoiceChatActionView$connectingText$2(r100));
        this.f87743l = LazyKt.lazy(new VoiceChatActionView$timeUPText$2(r100));
        this.f87744m = LazyKt.lazy(new VoiceChatActionView$waitingText$2(r100));
        this.f87745n = LazyKt.lazy(new VoiceChatActionView$mutedText$2(r100));
        this.f87746o = VoiceChatState.CONNECTING;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_format_voice_chat_action_layout, this);
        setAlpha(0.0f);
        View r103 = findViewById(R.id.action_close);
        if (r103 == null) goto L5;
        r103.setOnClickListener(new a(this));
    L5:
        ImageView r104 = (ImageView) findViewById(R.id.action_mute);
        this.f87732a = r104;
        r104.setOnClickListener(new b(this));
        View r105 = findViewById(R.id.action_interrupt_icon);
        if (r105 == null) goto L8;
        r105.setOnClickListener(new c(this));
    L8:
        HSImageView r106 = (HSImageView) findViewById(R.id.action_listening_icon);
        if (r106 == null) goto L11;
        r106.setController(Fresco.newDraweeControllerBuilder().setUri(f87731s).setAutoPlayAnimations(true).build());
    L11:
        this.f87738g = (ViewGroup) findViewById(R.id.action_container);
        TextView r107 = (TextView) findViewById(R.id.action_text);
        this.f87734c = r107;
        this.f87735d = (ViewGroup) findViewById(R.id.action_interrupt_container);
        this.f87736e = (ViewGroup) findViewById(R.id.action_listening_container);
        this.f87737f = (ViewGroup) findViewById(R.id.action_waiting_container);
        this.f87739h = (TextView) findViewById(R.id.action_waiting_text);
        this.f87747p = r107;
    }

    public /* synthetic */ VoiceChatActionView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
