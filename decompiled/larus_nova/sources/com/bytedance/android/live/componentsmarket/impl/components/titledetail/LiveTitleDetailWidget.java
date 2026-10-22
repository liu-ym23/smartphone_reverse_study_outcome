package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import am2.x;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.media.impl.ParentTouchScrollView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.qu0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomTitle;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.d0;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/titledetail/LiveTitleDetailWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/componentsmarket/impl/components/titledetail/a$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTitleDetailWidget extends LiveWidget implements com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetectorCompat f64685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f64686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f64687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f64688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ParentTouchScrollView f64689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f64690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f64691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f64692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f64693i;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f64694a;

        public a(Function0<Unit> r100) {
            this.f64694a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            Function0<Unit> r101 = this.f64694a;
            if (r101 == null) goto L7;
            r101.invoke();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            Function0<Unit> r104 = this.f64694a;
            if (r104 == null) goto L7;
            r104.invoke();
            return true;
        L7:
            return true;
        }
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTitleDetailWidget f64695a;

        public b(LiveTitleDetailWidget r100) {
            this.f64695a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101 != null) goto L4;
        L6:
            this.f64695a.f64685a.onTouchEvent(r101);
            return true;
        L4:
            if (r101.getAction() != 0) goto L6;
            xs2.b.a().post(new d0());
            goto L6
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_live_detail_layout;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final void C4() {
        View r100 = this.contentView;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final boolean isShowing() {
        View r100 = this.contentView;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    public LiveTitleDetailWidget() {
        this.f64685a = new GestureDetectorCompat(this.context, new a(LiveTitleDetailWidget$gesture$1.INSTANCE));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r100 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        Intrinsics.checkNotNullParameter(this, "view");
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a = this;
        int r101 = 8;
        this.contentView.setVisibility(8);
        this.contentView.setOnTouchListener(new b(this));
        this.f64686b = (ViewGroup) this.contentView.findViewById(R.id.user_info_container);
        this.f64687c = (ViewGroup) this.contentView.findViewById(R.id.title_container);
        this.f64688d = (ViewGroup) this.contentView.findViewById(R.id.user_list_container);
        ParentTouchScrollView r102 = (ParentTouchScrollView) this.contentView.findViewById(R.id.vs_live_detail_content);
        this.f64689e = r102;
        if (r102 == null) goto L5;
        r102.setTopFading(0.5f);
    L5:
        this.f64692h = this.contentView.findViewById(R.id.ll_content);
        this.f64690f = (TextView) this.contentView.findViewById(R.id.vs_live_detail_title);
        this.f64691g = (TextView) this.contentView.findViewById(R.id.vs_live_detail_introduction);
        this.f64693i = this.contentView.findViewById(R.id.vs_first_live_hint);
        RelativeLayout r103 = (RelativeLayout) this.contentView.findViewById(R.id.vs_live_detail_back);
        String r104 = null;
        Room r105 = (Room) this.dataCenter.get("data_room", null);
        if (r105 == null) goto L12;
        RoomPlatformComponentsData r106 = r105.roomPlatformComponentsData;
        if (r106 == null) goto L12;
        RoomTitle r107 = r106.getRoomTitle();
        if (r107 == null) goto L12;
        String r108 = r107.getTitle();
    L14:
        if (TextUtils.isEmpty(r108) == false) goto L23;
        TextView r109 = this.f64690f;
        if (r109 == null) goto L33;
        if (r105 == null) goto L21;
        User r110 = r105.mo8271getOwner();
        if (r110 == null) goto L21;
        String r111 = r110.getNickName();
    L22:
        r109.setText(r111);
    L21:
        r111 = null;
    L33:
        if (r105 == null) goto L41;
        RoomPlatformComponentsData r112 = r105.roomPlatformComponentsData;
        if (r112 == null) goto L41;
        RoomTitle r113 = r112.getRoomTitle();
        if (r113 == null) goto L41;
        String r114 = r113.getIntroduction();
        if (r114 == null) goto L41;
        r104 = StringsKt.replace$default(r114, "\n", "\n\n", false, 4, null);
    L41:
        TextView r115 = this.f64691g;
        if (r115 == null) goto L44;
        r115.setText(r104);
    L44:
        TextView r116 = this.f64691g;
        if (r116 == null) goto L47;
        r116.post(new c(this));
    L47:
        View r117 = this.f64693i;
        if (r117 == null) goto L56;
        RoomContext r118 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r118 != null) goto L52;
    L54:
        r117.setVisibility(r101);
        goto L56
    L52:
        if (r118.isVSFirstShow() != true) goto L54;
        r101 = 0;
    L56:
        if (PadConfigUtils.c() == false) goto L61;
        RoomContext r119 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r119 == null) goto L61;
        ((ObservableSubscribeProxy) r119.getPadOrientation().a().as(AutoDispose.bind(this))).subscribe(new e(this));
    L61:
        if (qu0.f121084a.getValue().booleanValue() == false) goto L69;
        DataCenter r120 = this.dataCenter;
        if (r120 == null) goto L65;
        r120.observe("data_room_title", this);
    L65:
        DataCenter r121 = this.dataCenter;
        if (r121 == null) goto L70;
        r121.observe("data_room_short_title", this);
        return;
    L70:
        return;
    L69:
        return;
    L23:
        TextView r122 = this.f64690f;
        if (r122 == null) goto L33;
        if (r105 == null) goto L31;
        RoomPlatformComponentsData r123 = r105.roomPlatformComponentsData;
        if (r123 == null) goto L31;
        RoomTitle r124 = r123.getRoomTitle();
        if (r124 == null) goto L31;
        String r125 = r124.getTitle();
    L32:
        r122.setText(r125);
    L31:
        r125 = null;
    L12:
        r108 = null;
        goto L14
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r100 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64696a = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64697b.clear();
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64698c = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64700e = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64701f = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64702g = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64703h = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64704i = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64705j = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64706k = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64707l = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64708m = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64709n = null;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f64710o = null;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final void y2() {
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L5;
        this.contentView.setPadding(0, x1.k(), 0, 0);
    L5:
        this.contentView.setVisibility(0);
        ParentTouchScrollView r100 = this.f64689e;
        if (r100 == null) goto L8;
        r100.scrollTo(0, 0);
    L8:
        u.l().d("livesdk_live_intro_title_click", new Object[]{Room.class, x.class});
        u.l().d("livesdk_live_intro_panel_show", new Object[]{Room.class, x.class});
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final ViewGroup B2() {
        return this.f64688d;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final ViewGroup J4() {
        return this.f64687c;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b
    public final ViewGroup r3() {
        return this.f64686b;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L31;
        String r102 = r101.getKey();
        if (r102.hashCode() == 956730793) goto L11;
        return;
    L11:
        if (r102.equals("data_room_title") == false) goto L26;
        Object r103 = r101.getData();
        if ((r103 instanceof String) == true) goto L15;
        r103 = null;
    L15:
        String r104 = (String) r103;
        if (r104 != null) goto L18;
        return;
    L18:
        if ((!Intrinsics.areEqual(r104, "")) == true) goto L20;
        return;
    L20:
        if (qu0.f121084a.getValue().booleanValue() == false) goto L29;
        TextView r105 = this.f64690f;
        if (r105 == null) goto L30;
        r105.setText(r104);
        return;
    L30:
        return;
    L29:
        return;
    L26:
        return;
    }
}
