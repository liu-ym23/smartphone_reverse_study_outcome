package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.replay;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.view.BlurImageView;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.larus.nova.R;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class PaidReplayMLVideoMaskView extends com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.f {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f160426q = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f160427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f160428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f160429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f160430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f160431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BlurImageView f160432p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.f, com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void dc() {
        BlurImageView r100 = this.f160432p;
        if (r100 == null) goto L5;
        r100.setBackground(null);
    L5:
        VideoContext r101 = j();
        if (r101 != null) goto L8;
    L9:
        VideoContext r102 = j();
        if (r102 == null) goto L12;
        r102.play();
    L12:
        super.dc();
        return;
    L8:
        if (r101.isPlaying() == true) goto L12;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.f
    public final void i() {
        VideoContext r100 = this.f160354j.D().d();
        if (r100 == null) goto L8;
        SimpleMediaView r101 = r100.f455950d;
        if (r101 == null) goto L9;
        r101.d(new c(this));
        return;
    L9:
        return;
    }

    public final VideoContext j() {
        return this.f160354j.D().d();
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.f
    public final Integer a() {
        return Integer.valueOf(R.layout.ttlive_paid_replay_ml_video_block_view);
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.f
    public final void h() {
        super.h();
        ViewGroup r100 = this.f160346b;
        BlurImageView r101 = null;
        if (r100 == null) goto L5;
        TextView r102 = (TextView) r100.findViewById(R.id.replay_paid_block_title);
    L6:
        this.f160428l = r102;
        ViewGroup r103 = this.f160346b;
        if (r103 == null) goto L9;
        TextView r104 = (TextView) r103.findViewById(R.id.replay_paid_sub_title);
    L10:
        this.f160429m = r104;
        ViewGroup r105 = this.f160346b;
        if (r105 == null) goto L13;
        View r106 = r105.findViewById(R.id.replay_buy_btn);
    L14:
        this.f160430n = r106;
        ViewGroup r107 = this.f160346b;
        if (r107 == null) goto L17;
        View r108 = r107.findViewById(R.id.delivery_btn);
    L18:
        this.f160431o = r108;
        ViewGroup r109 = this.f160346b;
        if (r109 == null) goto L21;
        r101 = (BlurImageView) r109.findViewById(R.id.replay_blur_background);
    L21:
        this.f160432p = r101;
        ViewGroup r110 = this.f160346b;
        if (r110 == null) goto L25;
        r110.setVisibility(8);
        return;
    L25:
        return;
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public PaidReplayMLVideoMaskView(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        super(r100);
        this.f160427k = "PaidReplayMLVideoMaskView[" + hashCode() + ']';
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void Kb(IRenderView r100, boolean r101) {
        if (this.f160352h == false) goto L13;
        ViewGroup r102 = this.f160346b;
        if (r102 != null) goto L7;
    L8:
        ViewGroup r103 = this.f160346b;
        if (r103 == null) goto L11;
        r103.setVisibility(0);
    L11:
        ALogger.d(this.f160427k, "render has rendered, skip");
        return;
    L7:
        if (r102.getVisibility() == 0) goto L11;
    L13:
        i();
        ViewGroup r104 = this.f160346b;
        if (r104 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r104);
    L16:
        TextView r105 = this.f160428l;
        if (r105 == null) goto L23;
        String r106 = this.f160345a.f159431e;
        if (r106 != null) goto L22;
        r106 = s1.B(R.string.ttlive_live_paid_live_temp_watch_end);
    L22:
        r105.setText(r106);
    L23:
        TextView r107 = this.f160429m;
        if (r107 == null) goto L27;
        UtilityKotlinExtentionsKt.z(r107, this.f160345a.f159433g);
    L27:
        if (this.f160345a.f159435i == false) goto L34;
        View r108 = this.f160430n;
        if (r108 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r108);
    L31:
        View r109 = this.f160431o;
        if (r109 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r109);
    L40:
        ViewGroup r110 = this.f160346b;
        if (r110 == null) goto L43;
        r110.setOnClickListener(x0.a(new PaidReplayMLVideoMaskView$onAddedToPlayerContainer$1(this)));
    L43:
        logTempMaskShow();
        this.f160352h = true;
        return;
    L34:
        View r111 = this.f160430n;
        if (r111 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r111);
    L37:
        View r112 = this.f160431o;
        if (r112 == null) goto L40;
        UtilityKotlinExtentionsKt.w(r112);
        goto L40
    }
}
