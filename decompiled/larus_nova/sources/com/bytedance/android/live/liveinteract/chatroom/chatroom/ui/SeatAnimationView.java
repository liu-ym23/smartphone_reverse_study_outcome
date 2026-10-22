package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.GuestBattleSeatAnimTask;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimTaskState;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.o;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.v;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.w;
import com.bytedance.android.live.liveinteract.view.MicSeatSponsorView;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/SeatAnimationView;", "Landroid/widget/FrameLayout;", "Lke0/a;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/o;", "taskChain", "", "setTaskChain", "Landroid/widget/ImageView;", "guestAvatar", "setGuestAvatar", "Landroid/widget/TextView;", "guestName", "setGuestName", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/SeatAnimTaskState;", "getTaskState", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LinkSucAnimationView$a;", "linkSucCallback", "setLinkSucCallback", "Lcom/bytedance/android/livesdk/chatroom/ui/e6;", "emojiCallback", "setEmojiCallback", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/e;", "listener", "setSeatAnimTaskListener", "getLinkSucAnimCallback", "", "enable", "setEnableShowKtvSeatAnimation", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeatAnimationView extends FrameLayout implements ke0.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f72413t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f72414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f72415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkSucAnimationView.a f72416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkSucAnimationView f72417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DynamicEmojiView f72418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f72419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f72420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f72421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f72422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MicSeatSponsorView f72423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HSImageView f72424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public KtvSeatAnimationView f72425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f72426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f72427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f72428o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f72429p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f72430q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f72431r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f72432s;

    public SeatAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SeatAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void e() {
        int r100 = this.f72426m;
        if (r100 == 0) goto L7;
        int r101 = this.f72427n;
        if (r101 == 0) goto L7;
        f(this.f72417d, r100, r101);
    L7:
        int r102 = this.f72428o;
        if (r102 == 0) goto L12;
        int r103 = this.f72429p;
        if (r103 == 0) goto L12;
        f(this.f72418e, r102, r103);
        f(this.f72422i, this.f72428o, this.f72429p);
        f(this.f72424k, this.f72428o, this.f72429p);
    L12:
        Integer r104 = je0.d.h();
        if (r104 != null) goto L16;
    L20:
        int r105 = this.f72430q;
        if (r105 == 0) goto L26;
        int r106 = this.f72431r;
        if (r106 == 0) goto L27;
        f(this.f72419f, r105, r106);
        return;
    L27:
        return;
    L26:
        return;
    L16:
        if (r104.intValue() != 24) goto L20;
        HSImageView r107 = this.f72422i;
        if (r107 == null) goto L20;
        r107.setPadding(s1.f(10.0f), s1.f(10.0f), s1.f(10.0f), 0);
        goto L20
    }

    public final SeatAnimTaskState getTaskState() {
        v r100 = this.f72414a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f72348a;
    }

    public final LinkSucAnimationView.a getLinkSucAnimCallback() {
        return this.f72416c;
    }

    public final void a(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.h r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f72432s == true) goto L5;
        return;
    L5:
        v r101 = this.f72414a;
        if (r101 == null) goto L9;
        r101.c(r100);
        return;
    }

    @Override // ke0.a
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ALogger.i("TAG", "handleWidgetInfo taskEngine: " + this.f72414a);
        v r101 = this.f72414a;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    L6:
        if ((r100 instanceof com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b) == false) goto L14;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r102 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b) r100;
        if (r102.f72214b == false) goto L15;
        Function0<Unit> r103 = r102.f72221i;
        if (r103 == null) goto L16;
        Unit r104 = r103.invoke();
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void setEmojiCallback(e6 r100) {
        Intrinsics.checkNotNullParameter(r100, "emojiCallback");
        DynamicEmojiView r101 = this.f72418e;
        if (r101 == null) goto L6;
        r101.setEmojiAnimCallback(r100);
        return;
    }

    public final void setEnableShowKtvSeatAnimation(boolean r100) {
        this.f72432s = r100;
        if (r100 == true) goto L6;
        a(new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.h(false));
        return;
    }

    public final void setGuestAvatar(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "guestAvatar");
        LinkSucAnimationView r101 = this.f72417d;
        if (r101 == null) goto L6;
        r101.setGuestAvatar(r100);
        return;
    }

    public final void setGuestName(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "guestName");
        LinkSucAnimationView r101 = this.f72417d;
        if (r101 == null) goto L6;
        r101.setGuestName(r100);
        return;
    }

    public final void setLinkSucCallback(LinkSucAnimationView.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkSucCallback");
        this.f72416c = r100;
        LinkSucAnimationView r101 = this.f72417d;
        if (r101 == null) goto L6;
        r101.setCallback(r100);
        return;
    }

    public final void setSeatAnimTaskListener(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        v r101 = this.f72414a;
        if (r101 == null) goto L10;
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d r102 = r101.f72349b;
    L5:
        if (r102 == null) goto L14;
        if ((r102 instanceof GuestBattleSeatAnimTask) == false) goto L9;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((GuestBattleSeatAnimTask) r102).f72195c = r100;
    L9:
        r102 = r102.a();
        goto L5
    L14:
        return;
    }

    public final void setTaskChain(o r100) {
        Intrinsics.checkNotNullParameter(r100, "taskChain");
        v r101 = this.f72414a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "chain");
        r101.f72349b = r100;
        return;
    }

    public SeatAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f72432s = true;
    }

    public static int d(int r100, MicSeatScene r101, boolean r102) {
        if (r100 != 4) goto L5;
        return R.layout.ttlive_view_audience_interact_seat_animation_view;
    L5:
        if (r100 == 5) goto L27;
        if (r100 != 8) goto L9;
        if (r102 == false) goto L24;
        return R.layout.ttlive_view_video_anchor_seat_anim_view;
    L24:
        return R.layout.ttlive_view_video_guest_seat_anim_view;
    L9:
        if (r100 != 9) goto L11;
        return R.layout.ttlive_view_ktv_seat_anim_view;
    L11:
        if (r100 == 12) goto L15;
        return R.layout.ttlive_view_seat_animation_view;
    L15:
        if (d0.d() == false) goto L18;
        return R.layout.ttlive_view_video_c_equal_seat_anim_view;
    L18:
        return R.layout.ttlive_view_video_equal_seat_anim_view;
    L27:
        if (r101 != MicSeatScene.AUDIO_LINK_HAMLET_AVATAR_C_POSITION) goto L29;
        return R.layout.ttlive_audio_hamlet_avatar_first_user_anim_layout;
    L29:
        return R.layout.ttlive_view_common_window_seat_anim_view;
    }

    public static void f(View r100, int r101, int r102) {
        if (r100 == null) goto L6;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L6;
        r103.width = r101;
    L6:
        if (r100 == null) goto L11;
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if (r104 == null) goto L12;
        r104.height = r102;
        return;
    L12:
        return;
    }

    public /* synthetic */ SeatAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void c(int r110, MicSeatScene r111, boolean r112, boolean r113, int r210, int r211) {
        Intrinsics.checkNotNullParameter(r111, "micSeatScene");
        View r100 = FrameLayout.inflate(getContext(), R.layout.ttlive_view_mic_seat_anim_layer, this);
        this.f72415b = r100;
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.ttlive_fixed_anim_container);
    L6:
        this.f72420g = r102;
        Integer r103 = je0.d.h();
        if (r103 != null) goto L10;
    L14:
        ViewGroup r104 = this.f72420g;
        if (r104 == null) goto L17;
        a1.j(r104, 1);
    L17:
        ViewGroup r105 = this.f72420g;
        if (r105 == null) goto L20;
        r105.removeAllViews();
    L20:
        int r106 = -1;
        if (r210 <= 0) goto L24;
        if (r211 <= 0) goto L24;
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(r210, r211);
    L25:
        ViewGroup r107 = this.f72420g;
        if (r107 == null) goto L28;
        r107.setLayoutParams(r114);
    L28:
        View r108 = FrameLayout.inflate(getContext(), d(r110, r111, r113), this.f72420g);
        Integer r109 = je0.d.h();
        if (r109 != null) goto L32;
    L38:
        ViewGroup.LayoutParams r115 = r108.getLayoutParams();
        if (r115 == null) goto L88;
        ((FrameLayout.LayoutParams) r115).gravity = 1;
    L41:
        ViewGroup r116 = this.f72420g;
        if (r116 == null) goto L44;
        LinkSucAnimationView r117 = (LinkSucAnimationView) r116.findViewById(R.id.link_suc_anim_view);
    L45:
        this.f72417d = r117;
        ViewGroup r118 = this.f72420g;
        if (r118 == null) goto L48;
        DynamicEmojiView r119 = (DynamicEmojiView) r118.findViewById(R.id.dynamic_emoji_view);
    L49:
        this.f72418e = r119;
        ViewGroup r120 = this.f72420g;
        if (r120 == null) goto L52;
        HSImageView r121 = (HSImageView) r120.findViewById(R.id.emoji_mask_layer);
    L53:
        this.f72419f = r121;
        ViewGroup r122 = this.f72420g;
        if (r122 == null) goto L56;
        HSImageView r123 = (HSImageView) r122.findViewById(R.id.guest_seat_animation);
    L57:
        this.f72422i = r123;
        ViewGroup r124 = this.f72420g;
        if (r124 == null) goto L60;
        MicSeatSponsorView r125 = (MicSeatSponsorView) r124.findViewById(R.id.ll_mic_seat_sponsor_anim);
    L61:
        this.f72423j = r125;
        ViewGroup r126 = this.f72420g;
        if (r126 == null) goto L64;
        HSImageView r127 = (HSImageView) r126.findViewById(R.id.themed_competition_seat_animation);
    L65:
        this.f72424k = r127;
        ViewGroup r128 = this.f72420g;
        if (r128 == null) goto L68;
        KtvSeatAnimationView r129 = (KtvSeatAnimationView) r128.findViewById(R.id.ktv_singer_animation_view);
    L69:
        this.f72425l = r129;
        e();
        if (r110 == 5) goto L75;
        int r130 = 0;
        if (r110 != 9) goto L79;
        r106 = (int) UIUtils.dip2Px(getContext(), 52.0f);
    L79:
        FrameLayout.LayoutParams r131 = new FrameLayout.LayoutParams(r106, r106);
        r131.gravity = 17;
        if (r130 == 0) goto L82;
        r131.topMargin = r130;
    L82:
        View r132 = this.f72415b;
        if (r132 == null) goto L85;
        r101 = (ViewGroup) r132.findViewById(R.id.ttlive_expand_anim_container);
    L85:
        this.f72421h = r101;
        v r133 = new v();
        this.f72414a = r133;
        Intrinsics.checkNotNull(r133);
        r133.b(this.f72422i, this.f72423j, this.f72424k, this.f72417d, this.f72418e, this.f72419f, this.f72425l);
        return;
    L75:
        if (r112 == false) goto L77;
        int r134 = getResources().getDimensionPixelSize(R.dimen.ttlive_voice_chat_guest_seat_avatar_size_large);
        float r135 = UIUtils.dip2Px(getContext(), 2.0f);
    L78:
        r106 = r134;
        r130 = (int) r135;
        goto L79
    L77:
        r134 = getResources().getDimensionPixelSize(R.dimen.ttlive_voice_chat_guest_seat_avatar_size);
        r135 = UIUtils.dip2Px(getContext(), -4.0f);
        goto L78
    L68:
        r129 = null;
        goto L69
    L64:
        r127 = null;
        goto L65
    L60:
        r125 = null;
        goto L61
    L56:
        r123 = null;
        goto L57
    L52:
        r121 = null;
        goto L53
    L48:
        r119 = null;
        goto L49
    L44:
        r117 = null;
        goto L45
    L88:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L32:
        if (r109.intValue() != 24) goto L38;
        ViewGroup.LayoutParams r136 = r108.getLayoutParams();
        if (r136 == null) goto L37;
        ((FrameLayout.LayoutParams) r136).gravity = 17;
        goto L41
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L24:
        r114 = new FrameLayout.LayoutParams(-1, -1);
        goto L25
    L10:
        if (r103.intValue() != 24) goto L14;
        ViewGroup r137 = this.f72420g;
        if (r137 == null) goto L17;
        a1.j(r137, 17);
        goto L17
    L5:
        r102 = null;
        goto L6
    }
}
