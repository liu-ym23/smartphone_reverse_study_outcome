package com.bytedance.android.live.revlink.impl.intercomment;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import r11.u;

/* JADX INFO: loaded from: classes47.dex */
@Deprecated(message = "回合前移植到lynx，内部实现不再维护")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/intercomment/InteractCommentWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/revlink/impl/intercomment/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractCommentWidget extends LiveWidget implements com.bytedance.android.live.revlink.impl.intercomment.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f92519n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InteractCommentDataContext f92520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f92521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InteractCommentView f92522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.room.a f92523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f92524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i11.b f92525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f92526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.intercomment.e f92527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f92528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l f92529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m f92530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k f92531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f92532m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentWidget f92533a;

        public b(InteractCommentWidget r100) {
            this.f92533a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f92533a.xq();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentWidget f92534a;

        public c(InteractCommentWidget r100) {
            this.f92534a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            InteractCommentWidget r102 = this.f92534a;
            int r103 = InteractCommentWidget.f92519n;
            r102.yq(false);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentWidget f92535a;

        public d(InteractCommentWidget r100) {
            this.f92535a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            InteractCommentDataContext r102 = this.f92535a.f92520a;
            if (r102 == null) goto L5;
            r102.close();
        L5:
            this.f92535a.f92526g++;
            r100.dismiss();
        }
    }

    public static final class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f92536a = null;

        static {
            f92536a = new e();
        }

        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.intercomment.b
    public final boolean a0() {
        InteractCommentDataContext r100 = this.f92520a;
        if (r100 == null) goto L7;
        LiveData<Integer> r101 = r100.getInterComState();
        if (r101 == null) goto L7;
        Integer r102 = r101.getValue();
    L8:
        if (r102 != null) goto L11;
    L13:
        return false;
    L11:
        if (r102.intValue() != 4) goto L13;
        return true;
    L7:
        r102 = null;
        goto L8
    }

    public final InteractCommentView wq() {
        if (this.f92532m == 1) goto L7;
        return null;
    L7:
        return this.f92522c;
    }

    public final void xq() {
        InteractCommentDataContext r100 = this.f92520a;
        if (r100 == null) goto L8;
        LiveData<Integer> r101 = r100.getInterComState();
        if (r101 == null) goto L8;
        Integer r102 = r101.getValue();
        if (r102 == null) goto L8;
    L9:
        int r103 = r102.intValue();
        if (this.f92524e == true) goto L16;
        if (r103 != 4) goto L13;
        ToastUtil.a(R.string.ttlive_inter_comment_click_audience, 0);
    L13:
        this.f92527h.b(r103, false);
        return;
    L16:
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L35;
        ToastUtil.a(R.string.ttlive_inter_comment_click_when_inviting, 0);
    L50:
        if (this.f92524e == false) goto L56;
        this.f92527h.b(r103, true);
        return;
    L56:
        return;
    L35:
        if (r103 != 4) goto L50;
        z0 r104 = z0.a();
        Context r105 = getContext();
        r104.getClass();
        x0.b r106 = new x0.b(r105, 4);
        r106.m(R.string.ttlive_inter_comment_close_confirm_title);
        if (this.f92526g < 3) goto L39;
    L47:
        int r107 = R.string.ttlive_inter_comment_close_confirm_message2;
    L48:
        r106.l(r107);
        r106.i(0, R.string.ttlive_ok, new d(this));
        r106.i(1, R.string.ttlive_cancel, e.f92536a);
        r106.n();
        goto L50
    L39:
        if (System.currentTimeMillis() > this.f92528i) goto L41;
    L43:
        boolean r108 = false;
    L44:
        if (r108 == true) goto L47;
        r107 = R.string.ttlive_inter_comment_close_confirm_message1;
        goto L48
    L41:
        if ((System.currentTimeMillis() - this.f92528i) > 30000) goto L43;
        r108 = true;
        goto L44
    L18:
        if (l51.a.n() == false) goto L25;
        InteractCommentInviteDialog r109 = new InteractCommentInviteDialog(this.context, new o(this));
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r109);
    L30:
        InteractCommentView r110 = wq();
        if (r110 == null) goto L50;
        r110.a(R.id.guide_dot).setVisibility(8);
        goto L50
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L23:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        goto L30
    L25:
        if (this.f92524e == false) goto L27;
        this.f92527h.d(false, false);
    L27:
        InteractCommentDataContext r111 = this.f92520a;
        if (r111 == null) goto L30;
        r111.invite();
    L8:
        r102 = 0;
        goto L9
    }

    public InteractCommentWidget() {
        this.f92532m = 7;
        this.f92521b = new CompositeDisposable();
        com.bytedance.android.livesdk.revenue.service.room.c r100 = (com.bytedance.android.livesdk.revenue.service.room.c) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r101 = r100.getRoomContext();
    L6:
        this.f92523d = r101;
        if (r101 == null) goto L13;
        com.bytedance.live.datacontext.i<Boolean> r102 = r101.isAnchor();
        if (r102 == null) goto L13;
        Boolean r103 = r102.getValue();
        if (r103 == null) goto L13;
        boolean r104 = r103.booleanValue();
    L14:
        this.f92524e = r104;
        this.f92527h = new com.bytedance.android.live.revlink.impl.intercomment.e(7);
        this.f92529j = new l(this);
        this.f92530k = new m(this);
        this.f92531l = new k(this);
        return;
    L13:
        r104 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        Pair r100 = com.bytedance.live.datacontext.d.a(new InteractCommentWidget$onCreate$dataPair$1(this));
        this.f92520a = (InteractCommentDataContext) r100.getFirst();
        DataContext r101 = (DataContext) r100.getFirst();
        InteractCommentDataContext.Companion.getClass();
        com.bytedance.live.datacontext.b.a(r101, InteractCommentDataContext.access$getTAG$cp());
        ((InteractCommentDataContext) r100.getFirst()).getService().d(this);
        this.f92521b.add((Disposable) r100.getSecond());
        if (this.f92532m != 7) goto L11;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r102 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r102 == null) goto L7;
        i11.b r103 = r102.getLinkUserCenter();
    L8:
        this.f92525f = r103;
        if (r103 == null) goto L11;
        r103.i(this.f92529j);
        goto L11
    L7:
        r103 = null;
    L11:
        int r104 = this.f92532m;
        boolean r105 = true;
        if (r104 != 1) goto L14;
        ViewGroup r106 = this.containerView;
    L15:
        if (r106 == null) goto L18;
        if (r104 != 1) goto L18;
        InteractCommentView r107 = new InteractCommentView(r106.getContext());
        r106.addView(r107);
        Unit r108 = Unit.INSTANCE;
        this.f92522c = r107;
    L18:
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r109 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r109.getClass();
        ReadOnlyProperty r110 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97554y;
        KProperty<?>[] r111 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a;
        if (((Boolean) r110.getValue(r109, r111[23])).booleanValue() == false) goto L21;
    L22:
        InteractCommentView r112 = wq();
        if (r112 == null) goto L25;
        a1.k(r112, 0);
    L25:
        InteractCommentView r113 = wq();
        if (r113 == null) goto L29;
        a1.p(r113, 0);
    L29:
        if (this.f92532m != 1) goto L31;
        ViewGroup r114 = this.containerView;
    L32:
        if (r114 == null) goto L35;
        a1.p(r114, 0);
    L35:
        if (this.f92532m != 1) goto L37;
        ViewGroup r115 = this.containerView;
    L38:
        if (r115 == null) goto L40;
        a1.k(r115, 0);
    L40:
        InteractCommentDataContext r116 = this.f92520a;
        if (r116 == null) goto L45;
        LiveData<Integer> r117 = r116.getInterComState();
        if (r117 == null) goto L45;
        r117.observeForever(this.f92531l);
    L45:
        com.bytedance.android.live.revlink.impl.pk.utils.q r118 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r118 == null) goto L52;
        PkScopeProviderService r119 = r118.f97131a;
        if (r119 == null) goto L52;
        MutableLiveData<q11.b> r120 = r119.f96777a;
        if (r120 == null) goto L52;
        r120.observeForever(this.f92530k);
    L52:
        yq(true);
        InteractCommentDataContext r121 = this.f92520a;
        if (r121 == null) goto L61;
        com.bytedance.live.datacontext.k<Object> r122 = r121.getOnIconClickEvent();
        if (r122 == null) goto L61;
        PublishSubject r123 = r122.onEvent();
        if (r123 == null) goto L61;
        Disposable r124 = r123.subscribe(new b(this));
        if (r124 == null) goto L61;
        this.f92521b.add(r124);
    L61:
        InteractCommentView r125 = wq();
        if (r125 == null) goto L64;
        r125.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AnonymousClass4(this)));
    L64:
        InteractCommentView r126 = wq();
        if (r126 == null) goto L67;
        r126.a(R.id.guide_dot).setVisibility(8);
    L67:
        u r127 = s41.b.f540544c.a();
        if (r127.a() == true) goto L70;
    L72:
        r105 = false;
    L73:
        if (r105 == true) goto L75;
    L78:
        com.bytedance.android.livesdk.revenue.room.a r128 = this.f92523d;
        if (r128 == null) goto L88;
        com.bytedance.live.datacontext.m<Integer> r129 = r128.getCleanMode();
        if (r129 == null) goto L88;
        Observable<Integer> r130 = r129.a();
        if (r130 == null) goto L88;
        Disposable r131 = r130.subscribe(new c(this));
        if (r131 == null) goto L88;
        RxUtilKt.c(r131, this.f92521b);
    L88:
        if (this.f92524e == true) goto L91;
        mz0.d.a(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.intercomment.d.class), com.bytedance.android.live.revlink.impl.intercomment.d.f92538b);
        return;
    L91:
        return;
    L75:
        if (l51.a.n() == true) goto L77;
        l51.a.f507435J.setValue(null, l51.a.f507436a[36], Boolean.TRUE);
    L77:
        l51.a.I.setValue(null, l51.a.f507436a[35], Integer.valueOf(r127.c()));
        goto L78
    L70:
        if (r127.c() <= ((Number) l51.a.I.getValue(null, l51.a.f507436a[35])).intValue()) goto L72;
    L37:
        r115 = null;
        goto L38
    L31:
        r114 = null;
        goto L32
    L21:
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.B.getValue(r109, r111[26])).booleanValue() == false) goto L40;
    L14:
        r106 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        if (this.f92532m != 1) goto L5;
        ViewGroup r100 = this.containerView;
    L6:
        if (r100 == null) goto L8;
        r100.setVisibility(8);
    L8:
        CompositeDisposable r101 = this.f92521b;
        if (r101 == null) goto L11;
        r101.dispose();
    L11:
        com.bytedance.android.live.revlink.impl.pk.utils.q r102 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r102 == null) goto L18;
        PkScopeProviderService r103 = r102.f97131a;
        if (r103 == null) goto L18;
        MutableLiveData<q11.b> r104 = r103.f96777a;
        if (r104 == null) goto L18;
        r104.removeObserver(this.f92530k);
    L18:
        InteractCommentDataContext r105 = this.f92520a;
        if (r105 == null) goto L23;
        LiveData<Integer> r106 = r105.getInterComState();
        if (r106 == null) goto L23;
        r106.removeObserver(this.f92531l);
    L23:
        i11.b r107 = this.f92525f;
        if (r107 == null) goto L27;
        r107.l(this.f92529j);
    L27:
        if (this.f92524e == true) goto L30;
        mz0.d.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.intercomment.d.class));
        return;
    L30:
        return;
    L5:
        r100 = null;
        goto L6
    }

    public final void yq(boolean r110) {
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r100 = null;
        if (this.f92524e == false) goto L32;
        InteractCommentDataContext r101 = this.f92520a;
        if (r101 == null) goto L9;
        LiveData<Integer> r102 = r101.getInterComState();
        if (r102 == null) goto L9;
        Integer r103 = r102.getValue();
    L10:
        if (r103 == null) goto L32;
        if (r103.intValue() != 4) goto L32;
        if (this.f92532m == 1) goto L24;
        i11.b r104 = this.f92525f;
        if (r104 == null) goto L21;
        List<com.bytedance.android.livesdk.link.model.p> r105 = r104.getOnlineUserList();
        if (r105 == null) goto L21;
        int r106 = r105.size();
    L23:
        if (r106 > 2) goto L32;
    L21:
        r106 = 0;
    L24:
        com.bytedance.android.live.revlink.impl.global.c r107 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r107 == null) goto L27;
        com.bytedance.android.live.revlink.impl.utils.b r108 = r107.getClearScreenLinkUtils();
    L28:
        if (r108 != null) goto L30;
    L31:
        boolean r109 = true;
    L33:
        if (r109 == false) goto L39;
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r111 = com.bytedance.android.live.revlink.impl.global.b.c();
        if (r111 == null) goto L39;
        if (r111.a() != true) goto L39;
        r109 = a0();
    L57:
        if (this.f92532m != 1) goto L59;
        ViewGroup r112 = this.containerView;
    L60:
        if (r109 == false) goto L83;
        if (r112 != null) goto L63;
    L85:
        InteractCommentDataContext r113 = this.f92520a;
        if (r113 == null) goto L90;
        MutableLiveData<Boolean> r114 = r113.getShowInterCommentIcon();
        if (r114 == null) goto L90;
        r114.setValue(Boolean.valueOf(r109));
    L90:
        JSONObject r115 = new JSONObject();
        String r116 = "1";
        if (r109 == false) goto L106;
        if (r110 == true) goto L106;
        InteractCommentDataContext r117 = this.f92520a;
        if (r117 == null) goto L98;
        LiveData<Integer> r118 = r117.getInterComState();
        if (r118 == null) goto L98;
        Integer r119 = r118.getValue();
    L99:
        if (r119 != null) goto L102;
    L104:
        r116 = "0";
    L105:
        r115.put("intercom_status", r116);
    L107:
        com.bytedance.android.live.revlink.impl.global.c r120 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r120 == null) goto L110;
        r100 = r120.w2();
    L110:
        if (r100 == null) goto L113;
        r100.b("intercom_data", r115.toString());
        return;
    L113:
        return;
    L102:
        if (r119.intValue() != 4) goto L104;
    L98:
        r119 = null;
    L106:
        r115.put("intercom_status", "0");
        r115.put("close_reason", "1");
        goto L107
    L63:
        if (r112.getVisibility() == 0) goto L85;
        com.bytedance.android.live.revlink.impl.intercomment.e r121 = this.f92527h;
        r121.getClass();
        long r122 = System.currentTimeMillis();
        long r123 = r121.f92539a;
        if (r123 != 0) goto L67;
    L69:
        r121.f92539a = r122;
        HashMap r124 = new HashMap();
        if (r121.f92540b != 1) goto L72;
        String r125 = PbRequest.SwitchType.PK;
    L73:
        r124.put("connection_scene", r125);
        r121.a(r124);
        LinkCrossRoomDataHolder r126 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r126 == null) goto L76;
        Long r127 = Long.valueOf(r126.c());
    L77:
        r124.put("channel_id", String.valueOf(r127));
        w31.c r128 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r128 == null) goto L80;
        Long r129 = Long.valueOf(r128.i());
    L81:
        r124.put("pk_id", String.valueOf(r129));
        mz0.n r130 = new mz0.n();
        Map<String, String> r131 = r130.f516447a;
        Intrinsics.checkNotNullParameter(r131, "map");
        Intrinsics.checkNotNullParameter(r124, "map");
        r131.putAll(r124);
        mz0.m r132 = new mz0.m();
        r132.b(LogCommon.ROOM);
        r132.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r130.f516448b).addAll(r132.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r133 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r134 = com.bytedance.android.scope.m.b(r133).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r134);
        ((mz0.i) ((f80.a) r134)).w3("livesdk_comment_interflow_icon_show", r130.f516447a, r130.f516448b);
    L82:
        r112.setVisibility(0);
        goto L85
    L80:
        r129 = null;
        goto L81
    L76:
        r127 = null;
        goto L77
    L72:
        r125 = WsConstants.KEY_CONNECTION;
        goto L73
    L67:
        if (Math.abs(r123 - r122) > 1200) goto L69;
    L83:
        if (r112 == null) goto L85;
        r112.setVisibility(8);
        goto L85
    L59:
        r112 = null;
    L39:
        com.bytedance.android.live.revlink.impl.pk.utils.q r135 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r135 == null) goto L42;
        q11.b r136 = r135.a();
    L44:
        if (Intrinsics.areEqual(r136, q11.b.C7265b.f531273b) == false) goto L57;
        InteractCommentDataContext r137 = this.f92520a;
        if (r137 == null) goto L50;
        LiveData<Integer> r138 = r137.getInterComState();
        if (r138 == null) goto L50;
        Integer r139 = r138.getValue();
    L51:
        if (r139 != null) goto L54;
    L55:
        r109 = false;
        goto L57
    L54:
        if (r139.intValue() == 4) goto L57;
    L50:
        r139 = null;
        goto L51
    L42:
        r136 = null;
        goto L44
    L30:
        if (r108.b() == true) goto L32;
    L27:
        r108 = null;
    L9:
        r103 = null;
    L32:
        r109 = false;
        goto L33
    }
}
