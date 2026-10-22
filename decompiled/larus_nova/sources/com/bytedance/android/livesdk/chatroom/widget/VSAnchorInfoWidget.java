package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.unionlive.UnionAnchorWidget;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.bytedance.android.livesdk.common.MinMaxWidthLinearLayout;
import com.bytedance.android.livesdk.config.sr;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.PortraitTopAnchor, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/VSAnchorInfoWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSAnchorInfoWidget extends LiveRecyclableWidget implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a, Observer<KVData> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f118714t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f118715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f118716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f118717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f118718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f118719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f118720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ProgressBar f118721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f118722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MinMaxWidthLinearLayout f118723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MarqueeTextView f118724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HSImageView f118725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f118726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.live.profit.fansclub.o f118727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f118728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Room f118729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f118730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public UnionAnchorWidget f118731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f118732r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final VSAnchorInfoWidget$timerListener$1 f118733s;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSAnchorInfoWidget f118734a;

        public b(VSAnchorInfoWidget r100) {
            this.f118734a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            if (r101 == null) goto L5;
            String r102 = r101.getKey();
        L6:
            if (r102 != null) goto L9;
            return;
        L9:
            if (r102.hashCode() == 1060055221) goto L12;
            return;
        L12:
            if (r102.equals("data_keyboard_status") == false) goto L23;
            Boolean r103 = (Boolean) r101.getData();
            int r104 = 0;
            if (r103 == null) goto L16;
            boolean r105 = r103.booleanValue();
        L17:
            ViewGroup r106 = this.f118734a.containerView;
            if (r106 == null) goto L24;
            if (r105 == false) goto L21;
            r104 = 8;
        L21:
            r106.setVisibility(r104);
            return;
        L24:
            return;
        L16:
            r105 = false;
            goto L17
        L23:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSAnchorInfoWidget f118735a;

        public c(VSAnchorInfoWidget r100) {
            this.f118735a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Room r101 = (Room) sh6.c.b((sh6.b) r100);
            if (r101 == null) goto L6;
            VSAnchorInfoWidget r102 = this.f118735a;
            r102.f118729o = r101;
            r102.Aq();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_vs_anchor_info;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final void Aq() {
        Room r100 = this.f118729o;
        if (r100 == null) goto L124;
        HSImageView r101 = this.f118715a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorAvatar");
    L7:
        User r102 = r100.mo8271getOwner();
        Long r103 = null;
        if (r102 == null) goto L10;
        py.k r104 = r102._avatarMedium;
    L11:
        ImageLoader.bindAvatar(r101, r104, UtilityKotlinExtentionsKt.i(18), UtilityKotlinExtentionsKt.i(18));
        boolean r105 = false;
        if (wt2.e.a() == false) goto L29;
        TextView r106 = (TextView) this.contentView.findViewById(R.id.vs_anchor_name);
        if (r106 == null) goto L16;
        r106.setVisibility(8);
    L16:
        HSImageView r107 = (HSImageView) this.contentView.findViewById(R.id.vs_anchor_verify);
        if (r107 == null) goto L19;
        r107.setVisibility(8);
    L19:
        this.f118723i = (MinMaxWidthLinearLayout) this.contentView.findViewById(R.id.marquee_anchor_name_layout);
        this.f118724j = (MarqueeTextView) this.contentView.findViewById(R.id.marquee_anchor_name);
        this.f118725k = (HSImageView) this.contentView.findViewById(R.id.marquee_anchor_verify);
        MinMaxWidthLinearLayout r108 = this.f118723i;
        if (r108 == null) goto L22;
        r108.setVisibility(0);
    L22:
        ConstraintSet r109 = new ConstraintSet();
        ConstraintLayout r110 = (ConstraintLayout) findViewById(R.id.root);
        r109.clone(r110);
        r109.connect(R.id.vs_follow_container, 1, R.id.marquee_anchor_name_layout, 2);
        r109.connect(R.id.vs_fans_container, 1, R.id.marquee_anchor_name_layout, 2);
        r109.applyTo(r110);
        MinMaxWidthLinearLayout r111 = this.f118723i;
        if (r111 == null) goto L25;
        r111.setMinWidth(UtilityKotlinExtentionsKt.i(48));
    L25:
        MarqueeTextView r112 = this.f118724j;
        if (r112 == null) goto L29;
        r112.setMaxWidth(UtilityKotlinExtentionsKt.i(59));
    L29:
        if (wt2.e.a() == false) goto L67;
        RoomContext.a r113 = RoomContext.Companion;
        RoomContext r114 = RoomContext.a.c(r113, this.dataCenter, 0, 2);
        if (r114 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r115 = r114.isAnchorNameMarqueed();
        if (r115 == null) goto L37;
        Boolean r116 = r115.getValue();
        if (r116 == null) goto L37;
        boolean r117 = r116.booleanValue();
    L38:
        if (r117 == false) goto L46;
        MarqueeTextView r118 = this.f118724j;
        if (r118 == null) goto L53;
        User r119 = r100.mo8271getOwner();
        if (r119 == null) goto L44;
        String r120 = r119.getRemarkNameOrNickname();
    L45:
        r118.setTextWithEllipsis(r120);
        goto L53
    L44:
        r120 = null;
    L53:
        RoomContext r121 = RoomContext.a.c(r113, this.dataCenter, 0, 2);
        if (r121 == null) goto L56;
        com.bytedance.live.datacontext.j<d9> r122 = r121.getRoomTitleAndAnchorNameTimer();
    L57:
        if (r122 != null) goto L59;
    L60:
        if (r122 == null) goto L62;
        final long r123 = 111;
        final long r124 = 1000;
        r122.e(new VSAnchorInfoWidget$startAnimationListener$1(r123, r124));
    L62:
        if (r122 == null) goto L64;
        r122.c(new VSAnchorInfoWidget$startAnimationListener$2(this));
    L64:
        MarqueeTextView r125 = this.f118724j;
        if (r125 == null) goto L75;
        r125.setOnClickListener(new VSAnchorInfoWidget$renderData$$inlined$also$lambda$1(this));
    L75:
        User r126 = r100.mo8271getOwner();
        if (r126 == null) goto L93;
        py.c r127 = r126.getMAuthenticationInfo();
        if (r127 == null) goto L93;
        py.k r128 = r127.getAuthenticationBadge();
        if (r128 == null) goto L93;
        if (wt2.e.a() == false) goto L86;
        ImageLoader.bindImage(this.f118725k, r128);
        HSImageView r129 = this.f118725k;
        if (r129 == null) goto L101;
        r129.setVisibility(0);
    L101:
        if (sr.f121247a.getValue().booleanValue() == false) goto L103;
        com.bytedance.android.live.room.api.follow.b.c(r100.mo8271getOwner(), "VSAnchorInfoWidget", r100, new VSAnchorInfoWidget$renderData$$inlined$also$lambda$2(this));
        return;
    L103:
        User r130 = r100.mo8271getOwner();
        if (r130 == null) goto L106;
        FollowInfo r131 = r130.getFollowInfo();
    L107:
        if (r131 == null) goto L121;
        FollowInfo r132 = r130.getFollowInfo();
        if (r132 == null) goto L111;
        r103 = Long.valueOf(r132.getFollowStatus());
    L111:
        if (r103 != null) goto L114;
    L115:
        long r133 = 2;
        if (r103 == null) goto L121;
        if (r133 != r103.longValue()) goto L121;
    L120:
        r105 = true;
        goto L121
    L114:
        if (1 == r103.longValue()) goto L120;
    L121:
        if (r105 == false) goto L123;
        yq();
        return;
    L123:
        zq();
        return;
    L106:
        r131 = null;
        goto L107
    L86:
        HSImageView r134 = this.f118720f;
        if (r134 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("vsVerifyIcon");
    L89:
        ImageLoader.bindImage(r134, r128);
        HSImageView r135 = this.f118720f;
        if (r135 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("vsVerifyIcon");
    L92:
        r135.setVisibility(0);
    L93:
        HSImageView r136 = this.f118725k;
        if (r136 == null) goto L96;
        r136.setVisibility(8);
    L96:
        HSImageView r137 = this.f118720f;
        if (r137 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("vsVerifyIcon");
    L99:
        r137.setVisibility(8);
        Unit r138 = Unit.INSTANCE;
        goto L101
    L59:
        if (r122.hasValue() == true) goto L62;
    L56:
        r122 = null;
        goto L57
    L46:
        MarqueeTextView r139 = this.f118724j;
        if (r139 == null) goto L53;
        User r140 = r100.mo8271getOwner();
        if (r140 == null) goto L51;
        String r141 = r140.getRemarkNameOrNickname();
    L52:
        r139.setTextWithFading(r141);
        goto L53
    L51:
        r141 = null;
    L37:
        r117 = false;
        goto L38
    L67:
        TextView r142 = this.f118716b;
        if (r142 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorName");
    L70:
        User r143 = r100.mo8271getOwner();
        if (r143 == null) goto L73;
        String r144 = r143.getRemarkNameOrNickname();
    L74:
        r142.setText(r144);
        goto L75
    L73:
        r144 = null;
        goto L74
    L10:
        r104 = null;
        goto L11
    L124:
        ALogger.e("VSAnchorInfoWidget", "vs_episode_info_widget load info failed cause of empty null data");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        MarqueeTextView r100 = this.f118724j;
        if (r100 == null) goto L5;
        r100.cancelAnimation();
    L5:
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r101 == null) goto L12;
        com.bytedance.live.datacontext.j<d9> r102 = r101.getRoomTitleAndAnchorNameTimer();
        if (r102 == null) goto L12;
        d9 r103 = r102.getValue();
        if (r103 == null) goto L12;
        r103.c(this.f118733s);
    L12:
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L15;
        r104.removeObserver(this);
    L15:
        this.f118731q = null;
        this.f118726l.clear();
    }

    public final void xq() {
        int r100 = com.bytedance.android.live.room.utils.c.f100395a;
        if (com.bytedance.android.live.room.utils.c.b(this.f118729o) == true) goto L5;
    L25:
        UnionAnchorWidget r101 = this.f118731q;
        if (r101 == null) goto L30;
        View r102 = r101.contentView;
        if (r102 == null) goto L30;
        UtilityKotlinExtentionsKt.t(r102);
    L30:
        View r103 = this.contentView;
        if (r103 == null) goto L37;
        UtilityKotlinExtentionsKt.w(r103);
        return;
    L37:
        return;
    L5:
        if (com.bytedance.android.live.core.utils.z.m(this.dataCenter, true) == false) goto L25;
        if (this.f118731q != null) goto L11;
        this.f118731q = new UnionAnchorWidget(false);
        enableSubWidgetManager();
        WidgetManager r104 = this.subWidgetManager;
        if (r104 == null) goto L11;
        r104.load(this.containerView, this.f118731q, false);
    L11:
        View r105 = this.contentView;
        if (r105 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r105);
    L14:
        View r106 = this.contentView;
        if (r106 == null) goto L17;
        com.bytedance.android.live.core.utils.a1.o(r106, UtilityKotlinExtentionsKt.i(2));
    L17:
        View r107 = this.contentView;
        if (r107 == null) goto L20;
        com.bytedance.android.live.core.utils.a1.l(r107, UtilityKotlinExtentionsKt.i(2));
    L20:
        UnionAnchorWidget r108 = this.f118731q;
        if (r108 == null) goto L34;
        View r109 = r108.contentView;
        if (r109 == null) goto L35;
        UtilityKotlinExtentionsKt.w(r109);
        return;
    L35:
        return;
    }

    public final void yq() {
        View r100 = this.f118718d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowContainer");
    L5:
        r100.setVisibility(8);
        Room r101 = this.f118729o;
        if (r101 != null) goto L8;
    L22:
        FrameLayout r102 = this.f118722h;
        if (r102 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("vsFansClubContainer");
    L25:
        r102.setVisibility(0);
        return;
    L8:
        if (r101.isMergeVSRoom() != true) goto L22;
        Room r103 = this.f118729o;
        if (r103 != null) goto L12;
    L13:
        Room r104 = this.f118729o;
        if (r104 == null) goto L22;
        if (r104.allowFansClub() == true) goto L22;
    L17:
        View r105 = this.f118719e;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowedContainer");
    L20:
        UtilityKotlinExtentionsKt.w(r105);
        return;
    L12:
        if (r103.allowGift() == false) goto L17;
        goto L13
    }

    public final void zq() {
        View r100 = this.f118718d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowContainer");
    L5:
        r100.setVisibility(0);
        FrameLayout r101 = this.f118722h;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vsFansClubContainer");
    L8:
        r101.setVisibility(8);
        View r102 = this.f118719e;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowedContainer");
    L11:
        UtilityKotlinExtentionsKt.t(r102);
    }

    public VSAnchorInfoWidget() {
        this.f118726l = new CompositeDisposable();
        this.f118728n = 32;
        this.f118730p = -1;
        this.f118732r = new b(this);
        this.f118733s = new VSAnchorInfoWidget$timerListener$1(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (com.bytedance.android.live.core.utils.z.m(this.dataCenter, true) == true) goto L11;
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L11;
        Room r102 = com.bytedance.android.live.core.utils.z.o(r101);
        if (r102 == null) goto L11;
        if (r102.isMergeVSRoom() != true) goto L11;
        return true;
    L11:
        VSDataContext r103 = VSDataContext.a.c(VSDataContext.Companion, this.dataCenter);
        if (r103 != null) goto L14;
    L16:
        return false;
    L14:
        if (r103.isVerticalVideo().getValue().booleanValue() != true) goto L16;
        return r103.isVerticalVideoLock().getValue().booleanValue();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        String r102 = r101.getKey();
        if (r102.hashCode() == 560852175) goto L6;
        return;
    L6:
        if (r102.equals("data_union_room_change") == false) goto L9;
        xq();
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (PadConfigUtils.c() == false) goto L11;
        if (r100 == null) goto L8;
        boolean r101 = true;
        if (r100.orientation != 1) goto L8;
    L9:
        wq(r101);
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.contentView.setVisibility(0);
        this.f118729o = com.bytedance.android.live.core.utils.z.o(this.dataCenter);
        this.f118727m = yt0.c.c();
        com.bytedance.android.livesdk.user.f0 r101 = (com.bytedance.android.livesdk.user.f0) this.dataCenter.get("data_user_center");
        Room r102 = this.f118729o;
        if (r102 == null) goto L9;
        String r103 = r102.getOwnerUserIdString();
        if (r101 == null) goto L7;
        String r104 = r101.n();
    L8:
        Intrinsics.areEqual(r103, r104);
        goto L9
    L7:
        r104 = null;
    L9:
        View r105 = this.contentView;
        if (r105 == null) goto L31;
        this.f118715a = (HSImageView) r105.findViewById(R.id.vs_anchor_avatar);
        this.f118716b = (TextView) r105.findViewById(R.id.vs_anchor_name);
        this.f118717c = (TextView) r105.findViewById(R.id.vs_anchor_follow);
        this.f118720f = (HSImageView) r105.findViewById(R.id.vs_anchor_verify);
        this.f118721g = (ProgressBar) r105.findViewById(R.id.vs_follow_progress);
        this.f118718d = r105.findViewById(R.id.vs_follow_container);
        this.f118719e = r105.findViewById(R.id.vs_followed_container);
        View r106 = this.f118718d;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowContainer");
    L14:
        r106.setVisibility(8);
        View r107 = this.f118719e;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowedContainer");
    L17:
        r107.setVisibility(8);
        FrameLayout r108 = (FrameLayout) r105.findViewById(R.id.vs_fans_container);
        this.f118722h = r108;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("vsFansClubContainer");
    L20:
        r108.setVisibility(8);
        this.f118723i = (MinMaxWidthLinearLayout) r105.findViewById(R.id.marquee_anchor_name_layout);
        this.f118724j = (MarqueeTextView) r105.findViewById(R.id.marquee_anchor_name);
        this.f118725k = (HSImageView) r105.findViewById(R.id.marquee_anchor_verify);
        if (com.bytedance.android.live.core.utils.z.m(this.dataCenter, true) == true) goto L26;
        HSImageView r109 = this.f118715a;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorAvatar");
    L25:
        r109.setVisibility(8);
        float r110 = 2;
        this.contentView.setPadding((int) UtilityKotlinExtentionsKt.h(r110), 0, (int) UtilityKotlinExtentionsKt.h(r110), 0);
    L30:
        wq(com.bytedance.android.live.core.utils.z.m(this.dataCenter, true));
        goto L31
    L26:
        HSImageView r111 = this.f118715a;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorAvatar");
    L29:
        r111.setVisibility(0);
        this.contentView.setPadding(0, 0, (int) UtilityKotlinExtentionsKt.h(2), 0);
    L31:
        DataCenter r112 = this.dataCenter;
        if (r112 == null) goto L34;
        r112.observe("data_keyboard_status", this.f118732r);
    L34:
        this.contentView.setOnClickListener(new k2(this));
        View r113 = this.f118719e;
        if (r113 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("vsFollowedContainer");
    L37:
        r113.setOnClickListener(l2.f118836a);
        Disposable r114 = ((IUserService) jc1.k.n(IUserService.class)).user().followStateChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new m2(this), n2.f119149a);
        if (r114 == null) goto L40;
        this.f118726l.add(r114);
    L40:
        TextView r115 = this.f118717c;
        if (r115 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("vsAnchorFollow");
    L43:
        r115.setOnClickListener(new o2(this));
        RoomContext.a r116 = RoomContext.Companion;
        DataCenter r117 = this.dataCenter;
        r116.getClass();
        RoomContext r118 = RoomContext.a.a(r117, 0);
        if (r118 == null) goto L52;
        com.bytedance.live.datacontext.n<Room> r119 = r118.getInteractionDataPrepared();
        if (r119 == null) goto L52;
        if (r119.getValue() != null) goto L52;
        ObservableSubscribeProxy r120 = (ObservableSubscribeProxy) r119.a().as(autoDispose());
        if (r120 == null) goto L52;
        r120.subscribe(new c(this));
    L52:
        Aq();
        DataCenter r121 = this.dataCenter;
        if (r121 == null) goto L55;
        r121.observe("data_union_room_change", this);
    L55:
        com.bytedance.android.live.room.a0.b r122 = com.bytedance.android.live.room.a0.f98863a;
        com.bytedance.android.live.room.a0.f98869g = this.containerView;
        xq();
        com.bytedance.android.live.profit.fansclub.o r123 = this.f118727m;
        if (r123 == null) goto L62;
        Context r124 = this.context;
        DataCenter r125 = this.dataCenter;
        FrameLayout r126 = this.f118722h;
        if (r126 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("vsFansClubContainer");
    L60:
        com.bytedance.android.live.profit.fansclub.o.a.a(r123, r124, r125, r126);
        return;
    }

    public final void wq(boolean r100) {
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isVSRoom() != true) goto L17;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) this.contentView.getLayoutParams();
        if (r102 != null) goto L10;
        return;
    L10:
        if (r100 == true) goto L12;
        r102.height = UtilityKotlinExtentionsKt.i(24);
        r102.topMargin = 0;
        r102.bottomMargin = 0;
    L13:
        this.contentView.setLayoutParams(r102);
        return;
    L12:
        r102.height = UtilityKotlinExtentionsKt.i(22);
        r102.topMargin = 0;
        r102.bottomMargin = 0;
        goto L13
    }
}
