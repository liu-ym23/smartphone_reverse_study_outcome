package com.bytedance.android.livesdk.interactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.BorderInfo;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r52.w1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/LeftAvatarWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LeftAvatarWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f132689n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f132690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f132691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f132692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f132693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f132694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompositeDisposable f132695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public yo2.e f132696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedList<pp1.c> f132697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f132698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IUser f132699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f132700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f132701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f132702m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_view_left_avatar;
    }

    public final void Aq() {
        yo2.e r100 = this.f132696g;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        this.f132696g = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        CompositeDisposable r101 = this.f132695f;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        this.f132695f = null;
        this.f132697h.clear();
        this.f132698i = false;
        Aq();
    }

    public final void zq() {
        if (this.f132698i == false) goto L5;
        return;
    L5:
        if (this.f132696g != null) goto L34;
        FrameLayout r100 = this.f132692c;
        if (r100 != null) goto L9;
    L11:
        pp1.c r110 = this.f132697h.poll();
        if (r110 != null) goto L14;
        return;
    L14:
        this.f132698i = true;
        FrameLayout r101 = this.f132692c;
        if (r101 == null) goto L35;
        Intrinsics.checkNotNullParameter(r101, "view");
        if (r101.getParent() != null) goto L19;
    L23:
        boolean r102 = false;
    L24:
        if (r102 == true) goto L26;
        this.f132698i = false;
        Aq();
        zq();
        return;
    L26:
        long r111 = r110.f530171e;
        View r103 = LayoutInflater.from(this.context).inflate(R.layout.ttlive_view_left_avatar_bubble, null);
        TextView r112 = (TextView) r103.findViewById(R.id.bubble_tv);
        ImageView r104 = (ImageView) r103.findViewById(R.id.bubble_arrow);
        View r105 = r103.findViewById(R.id.icon_click_view);
        final Ref.IntRef r106 = new Ref.IntRef();
        r106.element = 0;
        final Ref.IntRef r107 = new Ref.IntRef();
        r107.element = 0;
        final LeftAvatarWidget$showBubble$onBackgroundReady$1 r108 = new LeftAvatarWidget$showBubble$onBackgroundReady$1(this, r101, r112, r106, r107, r110, r104, r105, r103, r111);
        Function0<Unit> r109 = new LeftAvatarWidget$showBubble$useDefaultBackground$1(this, r106, r107, r108);
        py.k r113 = r110.f530172f;
        if (r113 != null) goto L29;
    L31:
        r109.invoke();
        return;
    L29:
        if (r113.isValid() != true) goto L31;
        int r114 = a3.f114402d;
        a3.a.a(r112, r110.f530172f, new o(r108, r109), 0.0f);
        return;
    L19:
        if (r101.getApplicationWindowToken() == null) goto L23;
        if (r101.getVisibility() != 0) goto L23;
        r102 = true;
        goto L24
    L35:
        return;
    L9:
        if (r100.getVisibility() != 8) goto L11;
        return;
    }

    public LeftAvatarWidget() {
        this.f132697h = new LinkedList();
        this.f132700k = w1.f536278a.getValue().intValue();
        this.f132701l = 1;
        this.f132702m = 2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        py.k r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L6:
        if (r103 == null) goto L137;
        int r104 = r103.hashCode();
        if (r104 == (-1755684509)) goto L120;
        if (r104 == (-1741164106)) goto L14;
        return;
    L14:
        if (r103.equals("data_user_in_room") == false) goto L131;
        IRoom r105 = (IRoom) this.dataCenter.get("data_room", null);
        if (r105 != null) goto L19;
        return;
    L19:
        if (r105.allowGift() == true) goto L21;
        yq(false);
        return;
    L21:
        IUser r106 = (IUser) this.dataCenter.get("data_user_in_room", null);
        this.f132699j = r106;
        if (r106 == null) goto L118;
        com.bytedance.android.live.base.model.user.e r107 = r106.getBottomEntry();
        if (r107 == null) goto L118;
        if (r107.getStatus() == 1) goto L28;
    L30:
        boolean r108 = false;
    L31:
        if (r108 == true) goto L34;
        r107 = null;
    L34:
        if (r107 == null) goto L118;
        int r109 = this.f132700k;
        if (r109 != this.f132701l) goto L58;
        ImageView r110 = this.f132693d;
        if (r110 == null) goto L40;
        r110.setVisibility(8);
    L40:
        TextView r111 = this.f132694e;
        if (r111 == null) goto L43;
        r111.setVisibility(8);
    L43:
        ImageView r112 = this.f132691b;
        if (r112 == null) goto L46;
        r112.setVisibility(8);
    L46:
        HSImageView r113 = this.f132690a;
        if (r113 == null) goto L51;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L51;
        r114.width = com.bytedance.android.anniex.utils.j.a(38);
        r114.height = com.bytedance.android.anniex.utils.j.a(38);
    L51:
        String r115 = r107.getIcon();
        if (r115 == null) goto L54;
        a1.n(this.f132690a, r115);
    L54:
        Bq("show", r107, "medal");
        FrameLayout r116 = this.f132692c;
        if (r116 == null) goto L116;
        r116.setOnClickListener(new n(this, r107));
    L116:
        yq(true);
        return;
    L58:
        if (r109 != this.f132702m) goto L117;
        IUser r117 = this.f132699j;
        if (r117 == null) goto L62;
        py.f r118 = r117.getBorder();
    L64:
        if ((r118 instanceof BorderInfo) == true) goto L66;
        r118 = null;
    L66:
        BorderInfo r119 = (BorderInfo) r118;
        IUser r120 = this.f132699j;
        if (r120 == null) goto L72;
        py.k r121 = r120.getAvatarThumb();
        if (r121 == null) goto L72;
        ImageUtil.loadRoundImage(this.f132690a, r121);
    L72:
        if (r107.getMysteryMan() == false) goto L93;
        ImageView r122 = this.f132693d;
        if (r122 == null) goto L76;
        r122.setVisibility(8);
    L76:
        TextView r123 = this.f132694e;
        if (r123 == null) goto L79;
        r123.setVisibility(8);
    L79:
        if (r119 == null) goto L90;
        py.k r124 = r119.getDefaultIcon();
        if (r124 == null) goto L90;
        if ((!UtilityKotlinExtentionsKt.n(r124)) == false) goto L85;
        r102 = r124;
    L85:
        if (r102 == null) goto L90;
        ImageView r125 = this.f132691b;
        if (r125 == null) goto L89;
        r125.setVisibility(0);
    L89:
        ImageUtil.loadRoundImage(this.f132691b, r102);
    L103:
        if (r107.getHideGradeLevel() == false) goto L110;
        TextView r126 = this.f132694e;
        if (r126 == null) goto L107;
        r126.setText("**");
    L107:
        TextView r127 = this.f132694e;
        if (r127 == null) goto L113;
        r127.setTextSize(11.0f);
    L113:
        Bq("show", r107, "number");
        FrameLayout r128 = this.f132692c;
        if (r128 == null) goto L116;
        r128.setOnClickListener(new m(this, r107));
        goto L116
    L110:
        TextView r129 = this.f132694e;
        if (r129 == null) goto L113;
        r129.setText(String.valueOf(r107.getGradeLevel()));
    L90:
        ImageView r130 = this.f132691b;
        if (r130 == null) goto L103;
        r130.setVisibility(8);
        goto L103
    L93:
        ImageView r131 = this.f132693d;
        if (r131 == null) goto L96;
        r131.setVisibility(0);
    L96:
        TextView r132 = this.f132694e;
        if (r132 == null) goto L99;
        r132.setVisibility(0);
    L99:
        ImageView r133 = this.f132691b;
        if (r133 == null) goto L103;
        r133.setVisibility(8);
        goto L103
    L62:
        r118 = null;
        goto L64
    L117:
        yq(false);
        return;
    L28:
        if (this.f132700k <= 0) goto L30;
        r108 = true;
    L118:
        yq(false);
        return;
    L131:
        return;
    L120:
        if (r103.equals("cmd_toolbar_left_avatar_bubble") == false) goto L136;
        FrameLayout r134 = this.f132692c;
        if (r134 != null) goto L124;
    L126:
        pp1.c r135 = (pp1.c) this.dataCenter.get("cmd_toolbar_left_avatar_bubble", null);
        if (r135 == null) goto L141;
        this.f132697h.offer(r135);
        zq();
        return;
    L141:
        return;
    L124:
        if (r134.getVisibility() != 8) goto L126;
        return;
    L136:
        return;
    L137:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f132690a = (HSImageView) this.contentView.findViewById(R.id.avatar_icon);
        this.f132691b = (ImageView) this.contentView.findViewById(R.id.avatar_border);
        this.f132692c = (FrameLayout) this.contentView.findViewById(R.id.left_avatar_container);
        this.f132693d = (ImageView) this.contentView.findViewById(R.id.avatar_cover);
        this.f132694e = (TextView) this.contentView.findViewById(R.id.grade_level);
        if (PadConfigUtils.c() == false) goto L6;
        int r101 = s1.j(R.dimen.ttlive_pad_left_right_margin);
        int r102 = s1.j(R.dimen.ttlive_pad_left_avatar_right_margin);
        UIUtils.updateLayoutMargin(this.contentView, r101, -3, r102, r101);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f132695f = new CompositeDisposable();
        DataCenter r101 = this.dataCenter;
        IRoom r102 = null;
        if (r101 == null) goto L5;
        r102 = (IRoom) r101.get("data_room", null);
    L5:
        if (r102 != null) goto L7;
    L10:
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L13;
        r103.observe("data_user_in_room", this);
    L13:
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L17;
        r104.observe("cmd_toolbar_left_avatar_bubble", this);
        return;
    L17:
        return;
    L7:
        if (r102.allowGift() == true) goto L10;
        yq(false);
    }

    public final void yq(boolean r100) {
        FrameLayout r101 = this.f132692c;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public static final void xq(LeftAvatarWidget r100, com.bytedance.android.live.base.model.user.e r101) {
        r100.getClass();
        String r102 = r101.getSchema();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r2.a(r102) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L14;
        r100.Bq("click", r101, "medal");
        IBaseLiveActionHandler r103 = (IBaseLiveActionHandler) jc1.k.f(IBaseLiveActionHandler.class);
        if (r103 == null) goto L15;
        r103.handle(r100.context, r102);
        return;
    L15:
        return;
    }

    public final void Bq(String r100, com.bytedance.android.live.base.model.user.e r101, String r102) {
        if (Intrinsics.areEqual(r100, "show") == false) goto L5;
        String r103 = "livesdk_toolbar_icon_show";
    L6:
        HashMap r104 = new HashMap();
        r104.put("privilege_level", String.valueOf(r101.getGradeLevel()));
        String r105 = "1";
        if (r101.getHideGradeLevel() == false) goto L9;
        Object r106 = "1";
    L10:
        r104.put("is_hide", r106);
        r104.put("icon_type", "privilege_icon");
        r104.put("icon_order", "-1");
        if (z.e(this.dataCenter, false) == true) goto L14;
        r105 = "0";
    L14:
        r104.put(IPerformanceManager.Params.is_anchor, r105);
        if (r101.getMysteryMan() == false) goto L17;
        r102 = "mystery";
    L17:
        r104.put("show_type", r102);
        j0.l().sendLog(r103, r104, new Object[]{IRoom.class, am2.x.class});
        return;
    L9:
        r106 = "0";
        goto L10
    L5:
        r103 = "livesdk_toolbar_icon_click";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void wq(LeftAvatarWidget r110, Map r111, int r112, String r113) {
        Pair[] r100 = new Pair[5];
        IUser r101 = r110.f132699j;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getIdString();
    L6:
        r100[0] = TuplesKt.to("user_id", r103);
        IUser r104 = r110.f132699j;
        if (r104 == null) goto L11;
        py.d r105 = r104.getUserHonor();
        if (r105 == null) goto L11;
        String r106 = String.valueOf(r105.getLevel());
    L12:
        r100[1] = TuplesKt.to("privilege_level", r106);
        r100[2] = TuplesKt.to("location_from", "comment_left_avatar");
        r100[3] = TuplesKt.to("privilege_from", String.valueOf(r112));
        if (z.e(r110.dataCenter, false) == false) goto L15;
        String r114 = "1";
    L16:
        r100[4] = TuplesKt.to(IPerformanceManager.Params.is_anchor, r114);
        Map r115 = MapsKt.mutableMapOf(r100);
        boolean r107 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        kc0.e r108 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService();
        if (r108 == null) goto L20;
        Map<String, String> r109 = r108.q();
        if (r109 == null) goto L20;
    L21:
        r115.putAll(r109);
        if (r111 == null) goto L45;
        Iterator r116 = r111.entrySet().iterator();
    L24:
        String r117 = "";
        if (r116.hasNext() == false) goto L31;
        Map.Entry r118 = (Map.Entry) r116.next();
        Object r119 = r118.getKey();
        String r120 = (String) r118.getValue();
        if (r120 == null) goto L30;
        r117 = r120;
    L30:
        r115.put(r119, r117);
        goto L24
    L31:
        String r121 = (String) r111.get("message_type");
        if (r121 != null) goto L34;
        r121 = "";
    L34:
        r115.put("content", r121);
        if (r112 != 3) goto L40;
        String r122 = (String) r111.get("bubble_info");
        if (r122 != null) goto L39;
        r122 = "";
    L39:
        r115.put("bubble_info", r122);
    L40:
        String r123 = (String) r111.get("prop_id");
        if (r123 == null) goto L44;
        r117 = r123;
    L44:
        r115.put("prop_id", r117);
    L45:
        int r124 = r113.hashCode();
        if (r124 == 3529469) goto L54;
        if (r124 != 94750088) goto L57;
        if (r113.equals("click") == false) goto L57;
        r102 = "livesdk_room_bubble_click";
    L57:
        if (r112 != 14) goto L60;
        r115.put("message_type", "room_grouppk_matching");
    L60:
        if (r102 == null) goto L66;
        j0.l().sendLog(r102, r115, new Object[]{Room.class, am2.x.class});
        return;
    L66:
        return;
    L54:
        if (r113.equals("show") == false) goto L57;
        r102 = "livesdk_room_bubble_show";
    L20:
        r109 = new HashMap();
        goto L21
    L15:
        r114 = "0";
    L11:
        r106 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
