package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ue1;
import com.bytedance.android.livesdk.message.model.jb;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleStarActivityGradeMedal;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/FansRankListAnimationWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansRankListAnimationWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f118489o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f118490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f118491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout f118492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f118493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LottieAnimationView f118494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f118495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HSImageView f118496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f118497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f118498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f118499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<Animator> f118500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f118501l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AnimatedDrawable2 f118502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AnimatedDrawable2 f118503n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_module_live_room_fans_rank_list;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a156";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ArrayList<Animator> r100 = this.f118500k;
        if (r100 == null) goto L9;
        Iterator<Animator> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Animator r102 = r101.next();
        r102.cancel();
        r102.removeAllListeners();
        goto L6
    L8:
        r100.clear();
    L9:
        wq();
        LottieAnimationView r103 = this.f118494e;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L12:
        r103.cancelAnimation();
        LottieAnimationView r104 = this.f118494e;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L15:
        UIUtils.setViewVisibility(r104, 8);
    }

    public final void wq() {
        AnimatedDrawable2 r100 = this.f118502m;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        AnimatedDrawable2 r101 = this.f118503n;
        if (r101 == null) goto L8;
        r101.stop();
    L8:
        this.f118502m = null;
        this.f118503n = null;
        this.f118501l = "";
        TextView r102 = this.f118493d;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L11:
        r102.setText(this.f118501l);
        RelativeLayout r103 = this.f118492c;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L14:
        UIUtils.setViewVisibility(r103, 8);
    }

    public FansRankListAnimationWidget() {
        this.f118499j = true;
        this.f118501l = "";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        if (this.f118498i == true) goto L21;
        HSImageView r100 = this.f118496g;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
    L7:
        r100.setController(null);
        View r101 = this.f118495f;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
    L10:
        UIUtils.setViewVisibility(r101, 4);
        HSImageView r102 = this.f118496g;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
    L13:
        if (r102 == null) goto L15;
        r102.clearAnimation();
    L15:
        HSImageView r103 = this.f118497h;
        if (r103 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mPKLevel");
    L18:
        if (r103 == null) goto L22;
        r103.clearAnimation();
        return;
    L22:
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (this.context != null) goto L6;
        return;
    L6:
        if (this.isViewValid == true) goto L9;
        return;
    L9:
        if (r101 == null) goto L11;
        String r102 = r101.getKey();
    L12:
        boolean r103 = false;
        if (Intrinsics.areEqual(r102, "fans_rank_list_award_anim") == false) goto L33;
        jb r104 = (jb) this.dataCenter.get("fans_rank_list_award_anim", vh7.f.c(jb.class));
        if (this.f118499j == false) goto L98;
        int r105 = r104.getRank();
        if (r105 != 1) goto L19;
        this.f118501l = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_live_fans_rank_list_award_top);
    L20:
        RelativeLayout r106 = this.f118492c;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L23:
        UIUtils.setViewVisibility(r106, 0);
        TextView r107 = this.f118493d;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L26:
        UIUtils.setViewVisibility(r107, 4);
        RelativeLayout r108 = this.f118492c;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L29:
        r108.setAlpha(1.0f);
        AbstractDraweeController r109 = Fresco.newDraweeControllerBuilder().setControllerListener(new x(this)).setUri(UriProtector.parse(ue1.f121367a.getValue())).setAutoPlayAnimations(false).build();
        HSImageView r110 = this.f118490a;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationDi");
    L32:
        r110.setController(r109);
        return;
    L19:
        this.f118501l = com.bytedance.android.live.core.utils.s1.C(R.string.ttlive_live_fans_rank_list_award_normal, new Object[]{Integer.valueOf(r105)});
        goto L20
    L98:
        return;
    L33:
        if (r101 == null) goto L35;
        String r111 = r101.getKey();
    L37:
        if (Intrinsics.areEqual(r111, "fans_rank_list_lottie") == true) goto L39;
        if (r101 == null) goto L53;
        String r112 = r101.getKey();
    L55:
        if (Intrinsics.areEqual(r112, "pk_activity_award_anim") == false) goto L102;
        jb r113 = (jb) this.dataCenter.get("pk_activity_award_anim", vh7.f.c(jb.class));
        if (this.f118499j == false) goto L103;
        Intrinsics.checkNotNullParameter(r113, "message");
        View r114 = this.f118495f;
        if (r114 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
    L61:
        r114.setOnClickListener(new a0(this, r113));
        RelativeLayout r115 = this.f118492c;
        if (r115 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L64:
        UIUtils.setViewVisibility(r115, 4);
        View r116 = this.f118495f;
        if (r116 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnimContainer");
    L67:
        UIUtils.setViewVisibility(r116, 4);
        if (com.bytedance.android.livesdk.chatroom.utils.a1.j(r113.getAssetImage()) == false) goto L76;
        HSImageView r117 = this.f118497h;
        if (r117 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mPKLevel");
    L72:
        UIUtils.setViewVisibility(r117, 4);
        AbstractDraweeController r118 = Fresco.newDraweeControllerBuilder().setControllerListener(new b0(this)).setFirstAvailableImageRequests(ImageLoader.createImageRequests(r113.getAssetImage(), null, null)).setAutoPlayAnimations(true).build();
        HSImageView r119 = this.f118496g;
        if (r119 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
    L75:
        r119.setController(r118);
        return;
    L76:
        HSImageView r120 = this.f118497h;
        if (r120 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mPKLevel");
    L79:
        UIUtils.setViewVisibility(r120, 0);
        BattleStarActivityGradeMedal r121 = r113.getGradeMedal();
        if (r121 == null) goto L82;
        py.k r122 = r121.gradeMedal;
    L83:
        ImageRequest[] r123 = ImageLoader.createImageRequests(r122, null, null);
        if (r123 != null) goto L86;
    L90:
        r103 = true;
    L91:
        if (r103 == true) goto L107;
        AbstractDraweeController r124 = Fresco.newDraweeControllerBuilder().setControllerListener(new c0(this, r113)).setFirstAvailableImageRequests(r123).setAutoPlayAnimations(true).build();
        HSImageView r125 = this.f118496g;
        if (r125 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mPkAnim");
    L96:
        r125.setController(r124);
        return;
    L107:
        return;
    L86:
        if (r123.length != 0) goto L88;
        boolean r126 = true;
    L89:
        if (r126 == false) goto L91;
    L88:
        r126 = false;
        goto L89
    L82:
        r122 = null;
        goto L83
    L103:
        return;
    L102:
        return;
    L53:
        r112 = null;
        goto L55
    L39:
        if (((Boolean) this.dataCenter.get("fans_rank_list_lottie", Boolean.FALSE)).booleanValue() == false) goto L44;
        LottieAnimationView r127 = this.f118494e;
        if (r127 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L43:
        r127.setVisibility(0);
        r127.setRepeatCount(-1);
        com.bytedance.android.livesdk.chatroom.utils.i2.g(r127, "/revenue/entrance/ttlive_fans_rank_tip_lottie.zip");
        return;
    L44:
        LottieAnimationView r128 = this.f118494e;
        if (r128 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L47:
        r128.cancelAnimation();
        LottieAnimationView r129 = this.f118494e;
        if (r129 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L50:
        UIUtils.setViewVisibility(r129, 8);
        return;
    L35:
        r111 = null;
        goto L37
    L11:
        r102 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f118492c = (RelativeLayout) this.contentView.findViewById(R.id.rank_list_award_webp_container);
        this.f118490a = (HSImageView) this.contentView.findViewById(R.id.rank_list_award_webp_di);
        this.f118491b = (HSImageView) this.contentView.findViewById(R.id.rank_list_award_webp_light);
        this.f118493d = (TextView) this.contentView.findViewById(R.id.rank_list_award_webp_text);
        this.f118494e = (LottieAnimationView) this.contentView.findViewById(R.id.fans_rank_list_tip_lottie);
        this.f118495f = this.contentView.findViewById(R.id.pk_anim);
        this.f118496g = (HSImageView) this.containerView.findViewById(R.id.iv_pk);
        this.f118497h = (HSImageView) this.contentView.findViewById(R.id.iv_level);
        ViewGroup.LayoutParams r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L28;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L29;
        Room r104 = r103.getValue();
        if (r104 == null) goto L30;
        User r105 = r104.mo8271getOwner();
        if (r105 == null) goto L31;
        com.bytedance.android.live.base.model.user.g0 r106 = r105.getSubscribe();
        if (r106 != null) goto L13;
        return;
    L13:
        if (r106.getOpen() != 1) goto L33;
        LottieAnimationView r107 = this.f118494e;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L17:
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof RelativeLayout.LayoutParams) == false) goto L21;
        r101 = r108;
    L21:
        RelativeLayout.LayoutParams r109 = (RelativeLayout.LayoutParams) r101;
        if (r109 == null) goto L34;
        r109.leftMargin = com.bytedance.android.live.core.utils.s1.f(-20.0f);
        LottieAnimationView r110 = this.f118494e;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mFansRankListLottie");
    L26:
        r110.setLayoutParams(r109);
        return;
    L34:
        return;
    L33:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f118498i = com.bytedance.android.live.core.utils.z.b(this.dataCenter).f66429c;
        this.f118499j = com.bytedance.android.live.core.utils.z.b(this.dataCenter).f66428b;
        this.dataCenter.observe("fans_rank_list_award_anim", this).observe("fans_rank_list_lottie", this).observe("pk_activity_award_anim", this);
    }
}
