package com.bytedance.android.livesdk.chatroom.tetris.service;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.castscreen.views.ShadowPlayerBottomWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.rowone.RoomShadowPlayerBottomWidget;
import com.bytedance.android.livesdk.message.model.jn;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.event.OpenNativePanelEvent;
import com.bytedance.android.livesdk.schema.event.OpenVsPanelEvent;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;
import vlc.l;
import zn1.f;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/service/HybridBottomPanelManagerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridBottomPanelManagerWidget extends LiveWidget implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridDialog f111841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vlc.d f111842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IRoomEventHub f111843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f111844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f111845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f111846f;

    public static final class a extends g<JSONObject, JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridBottomPanelManagerWidget f111847a;

        public a(HybridBottomPanelManagerWidget r100) {
            this.f111847a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final JSONObject invoke(JSONObject r100, CallContext r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            JSONObject r102 = new JSONObject();
            r102.put("code", 0);
            IRoomEventHub r103 = this.f111847a.f111843c;
            if (r103 == null) goto L8;
            MutableLiveData<String> r104 = r103.getSeiUpdate();
            if (r104 == null) goto L8;
            String r105 = r104.getValue();
            if (r105 == null) goto L8;
        L9:
            r102.put("data", r105);
            return r102;
        L8:
            r105 = "";
            goto L9
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridBottomPanelManagerWidget f111848a;

        public b(HybridBottomPanelManagerWidget r100) {
            this.f111848a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            RoomContext.a r102 = RoomContext.Companion;
            RoomContext r103 = RoomContext.a.c(r102, this.f111848a.dataCenter, 0, 2);
            if (r103 == null) goto L7;
            m<Long> r104 = r103.getVsHybridPanelHeight();
            if (r104 == null) goto L7;
            r104.setValue(Long.valueOf(this.f111848a.xq()));
        L7:
            DataCenter r105 = this.f111848a.dataCenter;
            if (r105 != null) goto L10;
            return;
        L10:
            if (z.m(r105, true) != true) goto L18;
            RoomContext r106 = RoomContext.a.c(r102, this.f111848a.dataCenter, 0, 2);
            if (r106 == null) goto L19;
            m<Long> r107 = r106.getVsHybridPanelFirstFrameHeight();
            if (r107 == null) goto L20;
            r107.setValue(Long.valueOf(this.f111848a.xq()));
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridBottomPanelManagerWidget f111849a;

        public c(HybridBottomPanelManagerWidget r100) {
            this.f111849a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            OpenVsPanelEvent r101 = (OpenVsPanelEvent) r100;
            HybridBottomPanelManagerWidget r102 = this.f111849a;
            Uri r103 = r101.getUri();
            int r104 = r101.getType();
            int r105 = r102.xq();
            String r106 = UriProtector.getQueryParameter(r103, "url");
            if (r106 == null) goto L49;
            Uri r107 = com.bytedance.android.livesdk.vs.d.a(UriProtector.parse(r106), r102.dataCenter);
            if (r107 == null) goto L9;
            String r108 = r107.toString();
            if (r108 == null) goto L9;
        L10:
            Ref.ObjectRef r109 = new Ref.ObjectRef();
            if (1 != r104) goto L13;
            T r110 = (T) x6.a.d(r108);
        L14:
            r109.element = r110;
            Iterator<String> r111 = UriProtector.getQueryParameterNames(r103).iterator();
        L16:
            if (r111.hasNext() == false) goto L18;
            String r112 = r111.next();
            r109.element = (T) UriProtector.parse(((Uri) r109.element).toString()).buildUpon().appendQueryParameter(r112, UriProtector.getQueryParameter(r103, r112)).build();
            goto L16
        L18:
            r109.element = (T) UriProtector.parse(((Uri) r109.element).toString()).buildUpon().appendQueryParameter("type", "popup").appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom").appendQueryParameter("height", String.valueOf(r105)).build();
            HybridDialog r113 = ((IBrowserService) k.n(IBrowserService.class)).showHybridDialog(r102.context, (Uri) r109.element, new zn1.g(r102, r109));
            if (r113 == null) goto L42;
            r102.f111841a = r113;
            r113.setJSBridgeListener(new f(r102));
            if (ContextUtil.contextToFragmentActivity(r102.context) == null) goto L43;
            ILivePlayerClient r114 = LivePlatformPlayerManager.f();
            if (r114 == null) goto L25;
            IRoomEventHub r115 = r114.getEventHub();
        L26:
            r102.f111843c = r115;
            ALogger.i("VsBottomPanelManagerWidget", "registerMessageListener");
            vlc.d r116 = (vlc.d) r102.dataCenter.get("data_message_manager");
            r102.f111842b = r116;
            if (r116 == null) goto L29;
            r116.addMessageListener(MessageType.VS_PANEL_MESSAGE.getIntType(), r102);
        L29:
            DataCenter r117 = r102.dataCenter;
            if (r117 == null) goto L44;
            Room r118 = (Room) r117.get("data_room", null);
            if (r118 != null) goto L34;
            return;
        L34:
            if (r118.isMergeVSRoom() != true) goto L46;
            IRoomEventHub r119 = r102.f111843c;
            if (r119 == null) goto L47;
            MutableLiveData<String> r120 = r119.getSeiUpdate();
            if (r120 == null) goto L48;
            r120.observeForever(r102.f111844d);
            return;
        L48:
            return;
        L47:
            return;
        L46:
            return;
        L44:
            return;
        L25:
            r115 = null;
            goto L26
        L43:
            return;
        L42:
            return;
        L13:
            r110 = (T) x6.a.b(r108);
        L9:
            r108 = "";
            goto L10
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridBottomPanelManagerWidget f111850a;

        public d(HybridBottomPanelManagerWidget r100) {
            this.f111850a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            HybridBottomPanelManagerWidget r101 = this.f111850a;
            if (((OpenNativePanelEvent) r100).getType() != 0) goto L5;
            r101.getClass();
            ALogger.i("VsBottomPanelManagerWidget", "unSupport cache");
            return;
        L5:
            r101.getClass();
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridBottomPanelManagerWidget f111851a;

        public e(HybridBottomPanelManagerWidget r100) {
            this.f111851a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (r101 == null) goto L5;
            LiveSeiUtil.f71508i.getClass();     // Catch: JSONException -> L10
            JSONObject r102 = LiveSeiUtil.c(r101);     // Catch: JSONException -> L10
        L7:
            if (r102.has("ts") == false) goto L15;
            HybridBottomPanelManagerWidget.wq(this.f111851a, r102.optLong("ts", p6.b()) / ((long) 1000));     // Catch: JSONException -> L10
            return;
        L15:
            return;
        L5:
            r102 = new JSONObject(r101);     // Catch: JSONException -> L10
        L10:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public final int xq() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        int r101 = 0;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        return (int) (UIUtils.getScreenHeight(this.context) * this.f111846f);
    L12:
        if ((this.context instanceof Activity) == true) goto L15;
        return 0;
    L15:
        if (PadConfigUtils.d() == false) goto L21;
        WidgetInfo r103 = getWidgetInfo(ShadowPlayerBottomWidget.class);
        if (r103 == null) goto L19;
        int r104 = r103.getContentViewHeight();
    L20:
        Integer r105 = Integer.valueOf(r104 - s1.f(38.0f));
    L25:
        if (r105 == null) goto L28;
        r101 = r105.intValue();
    L28:
        return ((int) s1.G(r101)) + 1;
    L19:
        r104 = 0;
        goto L20
    L21:
        WidgetInfo r106 = getWidgetInfo(RoomShadowPlayerBottomWidget.class);
        if (r106 == null) goto L24;
        r105 = Integer.valueOf(r106.getContentViewHeight());
        goto L25
    L24:
        r105 = null;
        goto L25
    L5:
        if (r100.isVSVerticalStream() != true) goto L7;
        r102 = true;
        goto L8
    }

    public HybridBottomPanelManagerWidget() {
        this.f111844d = new e(this);
        this.f111845e = new a(this);
        this.f111846f = 0.75f;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        RoomContext.a r100 = RoomContext.Companion;
        RoomContext r101 = RoomContext.a.c(r100, this.dataCenter, 0, 2);
        if (r101 == null) goto L7;
        m<Long> r102 = r101.getVsHybridPanelHeight();
        if (r102 == null) goto L7;
        r102.setValue(Long.valueOf(xq()));
    L7:
        RoomContext r103 = RoomContext.a.c(r100, this.dataCenter, 0, 2);
        if (r103 == null) goto L14;
        j<Unit> r104 = r103.isFirstFrameShown();
        if (r104 == null) goto L14;
        Maybe<sh6.b<Unit>> r105 = r104.b();
        if (r105 == null) goto L14;
        r105.subscribe(new b(this));
    L14:
        L7(OpenVsPanelEvent.class, new c(this));
        L7(OpenNativePanelEvent.class, new d(this));
        ALogger.i("VsBottomPanelManagerWidget", WidgetCostModule.TYPE_ON_CREATE);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        StringBuilder r101 = new StringBuilder("onMessage-");
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.getIntType());
    L6:
        r101.append(r102);
        r101.append(",show=");
        HybridDialog r103 = this.f111841a;
        if (r103 == null) goto L11;
        Dialog r104 = r103.getDialog();
        if (r104 == null) goto L11;
        boolean r105 = r104.isShowing();
    L12:
        r101.append(r105);
        ALogger.i("VsBottomPanelManagerWidget", r101.toString());
        if (r100 == null) goto L25;
        HybridDialog r106 = this.f111841a;
        if (r106 == null) goto L26;
        Dialog r107 = r106.getDialog();
        if (r107 != null) goto L19;
        return;
    L19:
        if (r107.isShowing() == true) goto L22;
        return;
    L22:
        if ((r100 instanceof jn) == false) goto L28;
        ((SingleSubscribeProxy) Single.just(((jn) r100).getExtra()).observeOn(Schedulers.io()).map(zn1.c.f572909a).map(zn1.d.f572910a).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new zn1.e(this));
        return;
    L28:
        return;
    L26:
        return;
    L25:
        return;
    L11:
        r105 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static final void wq(HybridBottomPanelManagerWidget r100, long r101) {
        r100.getClass();
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new zn1.a(r100, r101)).observeOn(AndroidSchedulers.mainThread()).as(r100.autoDispose())).subscribe(new zn1.b(r100));
    }

    public final <T> void L7(Class<T> r100, Consumer<T> r101) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r101);
    }
}
