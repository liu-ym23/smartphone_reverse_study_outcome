package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.livead.ICommerceMessage;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.config.cb;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarTransformWidgetBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarTransformWidgetBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, vlc.l, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f117040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f117041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f117042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public yo2.e f117043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f117044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.event.h0 f117045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public vlc.d f117046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f117047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f117048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DataCenter f117049j;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICommerceMessage f117050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ToolbarTransformWidgetBehavior f117051b;

        public a(ICommerceMessage r100, ToolbarTransformWidgetBehavior r101) {
            this.f117050a = r100;
            this.f117051b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if ((!Intrinsics.areEqual(((j0) r100).a(), Boolean.TRUE)) == false) goto L6;
            ToolbarTransformWidgetBehavior.a(this.f117051b, this.f117050a);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICommerceMessage f117052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ToolbarTransformWidgetBehavior f117053b;

        public b(ICommerceMessage r100, ToolbarTransformWidgetBehavior r101) {
            this.f117052a = r100;
            this.f117053b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ToolbarTransformWidgetBehavior.a(this.f117053b, this.f117052a);
            ((Throwable) r100).printStackTrace();
        }
    }

    public static final class c implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f117054a = null;

        static {
            f117054a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarTransformWidgetBehavior f117055a;

        public d(ToolbarTransformWidgetBehavior r100) {
            this.f117055a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ToolbarTransformWidgetBehavior.b(this.f117055a);
        }
    }

    public static final class e implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarTransformWidgetBehavior f117056a;

        public e(ToolbarTransformWidgetBehavior r100) {
            this.f117056a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            DataCenter r101 = this.f117056a.f117049j;
            if (r101 == null) goto L5;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r102 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r101.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
        L7:
            if (this.f117056a.f117045f.getType() != 1) goto L9;
        L17:
            if (r102 == null) goto L19;
            r102.f116665n = true;
        L19:
            DataCenter r103 = this.f117056a.f117049j;
            if (r103 == null) goto L23;
            r103.put("data_live_mini_app_commerce_status", r102);
        L23:
            if (this.f117056a.f117045f.getType() != 2) goto L25;
            xs2.b.a().post(new zg1.g3());
        L25:
            this.f117056a.f117045f.f123348a = 0;
            return;
        L9:
            if (this.f117056a.f117045f.getType() == 3) goto L17;
            if (this.f117056a.f117045f.getType() == 4) goto L17;
            if (this.f117056a.f117045f.getType() != 2) goto L19;
            if (r102 == null) goto L19;
            r102.f116665n = false;
            goto L19
        L5:
            r102 = null;
            goto L7
        }
    }

    public static final class f implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarTransformWidgetBehavior f117057a;

        public f(ToolbarTransformWidgetBehavior r100) {
            this.f117057a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            DataCenter r101 = this.f117057a.f117049j;
            if (r101 == null) goto L5;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r102 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r101.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
        L7:
            if (this.f117057a.f117045f.getType() != 1) goto L9;
        L17:
            if (r102 == null) goto L19;
            r102.f116665n = true;
        L19:
            DataCenter r103 = this.f117057a.f117049j;
            if (r103 == null) goto L23;
            r103.put("data_live_mini_app_commerce_status", r102);
        L23:
            if (this.f117057a.f117045f.getType() != 2) goto L25;
            xs2.b.a().post(new zg1.g3());
        L25:
            this.f117057a.f117045f.f123348a = 0;
            return;
        L9:
            if (this.f117057a.f117045f.getType() == 3) goto L17;
            if (this.f117057a.f117045f.getType() == 4) goto L17;
            if (this.f117057a.f117045f.getType() != 2) goto L19;
            if (r102 == null) goto L19;
            r102.f116665n = false;
            goto L19
        L5:
            r102 = null;
            goto L7
        }
    }

    public final class g implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f117058a;

        public g(Function1 r100) {
            this.f117058a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f117058a.invoke(r100);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 c() {
        if (this.f117048i == false) goto L6;
        return com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.f117049j);
    L6:
        return com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.f117049j);
    }

    public final void e() {
        String r100 = cb.f119933a.getValue();
        if ((((IHostApp) jc1.k.n(IHostApp.class)).getCurrentActivity() instanceof FragmentActivity) == false) goto L23;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        return;
    L11:
        if (((Boolean) SettingKeyUtils.f158790f.getValue()).booleanValue() == true) goto L20;
        com.bytedance.android.live.browser.webview.fragment.o r102 = ((IBrowserService) jc1.k.n(IBrowserService.class)).buildWebDialog(r100).setWidth((int) com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.y()));
        r102.f64387b = 484;
        r102.d(8);
        r102.f64388c = 0;
        r102.f64394i = 80;
        r102.a(-1);
        r102.f64403r = true;
        BaseWebDialogFragment r103 = r102.build();
        Context r104 = this.f117047h;
        if ((r104 instanceof FragmentActivity) == false) goto L19;
        LiveDialogFragment.a r105 = LiveDialogFragment.Companion;
        if (r104 == null) goto L18;
        r105.getClass();
        LiveDialogFragment.a.a((FragmentActivity) r104, r103);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L19:
        r103.setOnDismissListener(new e(this));
    L21:
        d("live_icon_click");
        return;
    L20:
        ((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialogWithListener(this.f117047h, x6.a.a(r100).appendQueryParameter("type", "popup").appendQueryParameter("width", String.valueOf((int) com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.y()))).appendQueryParameter("height", "484").appendQueryParameter("radius", "8").appendQueryParameter(GXTemplateKey.FLEXBOX_MARGIN, "0").appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom").appendQueryParameter("mask_click_disable", "0").build(), null, new f(this));
        goto L21
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        DataCenter r100 = this.f117049j;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r101 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r100.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L6:
        String r102 = com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b());
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L12;
        Boolean r103 = com.bytedance.android.livesdk.chatroom.utils.k0.d(r102).getValue();
        if (r103 != null) goto L11;
        return false;
    L11:
        return r103.booleanValue();
    L12:
        Boolean r104 = com.bytedance.android.livesdk.chatroom.utils.k0.d(r102).getValue();
        if (r104 == null) goto L15;
        boolean r105 = r104.booleanValue();
    L16:
        if (r105 == false) goto L24;
        if (r101 == null) goto L19;
        boolean r106 = r101.f116656e;
    L20:
        if (r106 == false) goto L25;
        return true;
    L25:
        return false;
    L19:
        r106 = false;
        goto L20
    L24:
        return false;
    L15:
        r105 = false;
        goto L16
    L5:
        r101 = null;
        goto L6
    }

    public final Context getContext() {
        return this.f117047h;
    }

    public static final void b(ToolbarTransformWidgetBehavior r100) {
        r100.getClass();
        String r101 = com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b());
        int r102 = com.bytedance.android.livesdk.chatroom.utils.k0.f114530a;
        Intrinsics.checkNotNullParameter(r101, "key");
        Boolean r103 = Boolean.FALSE;
        Boolean r104 = (Boolean) new com.bytedance.android.livesdk.sharedpref.e("transform_widget_unfold_pop_up_shown_" + r101, r103).getValue();
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == true) goto L12;
        Intrinsics.checkNotNullParameter(r101, "key");
        if (Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e("is_card_shown_".concat(r101), r103).getValue(), r105) == true) goto L14;
        Intrinsics.checkNotNullParameter(r101, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("transform_widget_unfold_pop_up_shown_".concat(r101), r103), r105);
        View r106 = LayoutInflater.from(r100.f117047h).inflate(R.layout.ttlive_view_transform_widget_tip, null);
        r106.setOnClickListener(new p5(r100));
        View r107 = r106.findViewById(R.id.tv_content);
        if (r107 == null) goto L11;
        ((TextView) r107).setText(R.string.ttlive_increase_click_widget_tip);
        yo2.e r108 = new yo2.e(r100.f117047h);
        r108.f568642d = r106;
        r108.f568643e = 0;
        r108.f568651m = 5;
        r108.f568652n = true;
        r108.f568650l = true;
        r108.f568645g = true;
        r108.a();
        r100.f117043d = r108;
        View r109 = r100.f117041b;
        Intrinsics.checkNotNull(r109);
        r108.i(r109, 1, 0, 0, -4);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        if (this.f117048i == true) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r101 = c();
        if (this.f117048i == false) goto L7;
        ToolbarButton r102 = ToolbarButton.TRANSFORM_WIDGET_MORE;
    L9:
        if (r101.n(r102) == true) goto L11;
        d("live_icon_show");
    L11:
        CompositeDisposable r103 = this.f117044e;
        if (r103 == null) goto L14;
        r103.add(((SingleSubscribeProxy) Single.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.f117047h))).subscribe(new d(this)));
        goto L14
    L7:
        r102 = ToolbarButton.TRANSFORM_WIDGET;
    L14:
        View r104 = this.f117041b;
        if (r104 == null) goto L18;
        r104.setAlpha(1.0f);
        return;
    }

    public final void d(String r100) {
        Pair[] r101 = new Pair[5];
        r101[0] = TuplesKt.to("tag", "live_ad");
        r101[1] = TuplesKt.to("refer", "icon");
        JSONObject r102 = new JSONObject();
        Room r103 = this.f117040a;
        if (r103 == null) goto L5;
        String r104 = r103.getOwnerUserIdString();
    L6:
        r102.put("anchor_id", r104);
        Room r105 = this.f117040a;
        if (r105 == null) goto L9;
        Long r106 = Long.valueOf(r105.f162599id);
    L10:
        r102.put("room_id", r106);
        r102.put(IPerformanceManager.Params.room_type, "anchor");
        if (this.f117048i == false) goto L13;
        String r107 = "more_buttons";
    L14:
        r102.put("live_position", r107);
        Unit r108 = Unit.INSTANCE;
        r101[2] = TuplesKt.to("ad_extra_data", r102.toString());
        String r109 = "1";
        r101[3] = TuplesKt.to("is_ad_live_event", "1");
        RoomContext r110 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r110 == null) goto L21;
        com.bytedance.live.datacontext.m<Boolean> r111 = r110.isCleanMode();
        if (r111 == null) goto L21;
        if (r111.getValue().booleanValue() != true) goto L21;
    L22:
        r101[4] = TuplesKt.to("if_clear_mode", r109);
        ((IHostLog) jc1.k.n(IHostLog.class)).logV3(r100, MapsKt.mapOf(r101));
        return;
    L21:
        r109 = "0";
        goto L22
    L13:
        r107 = NewBroadcastMonitor.STAGE.TOOLBAR;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public final void f(int r100) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r101 = c();
        if (this.f117048i == false) goto L17;
        ToolbarButton r102 = ToolbarButton.TRANSFORM_WIDGET_MORE;
    L18:
        r101.c(r102.extended());
        return;
    L17:
        r102 = ToolbarButton.TRANSFORM_WIDGET;
        goto L18
    L7:
        if (r100 != 8) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r103 = c();
        if (this.f117048i == false) goto L12;
        ToolbarButton r104 = ToolbarButton.TRANSFORM_WIDGET_MORE;
    L13:
        r103.i(r104.extended());
        return;
    L12:
        r104 = ToolbarButton.TRANSFORM_WIDGET;
        goto L13
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.hashCode() == 919040494) goto L12;
        return;
    L12:
        if (r103.equals("data_live_mini_app_commerce_status") == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L80;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r104 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r101.getData();
        if (r104 == null) goto L70;
        DataCenter r105 = this.f117049j;
        if (r105 == null) goto L21;
        Boolean r106 = (Boolean) r105.get("data_is_anchor", Boolean.FALSE);
    L23:
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L25;
        r102 = r104;
    L25:
        if (r102 != null) goto L27;
        return;
    L27:
        if (r102.f116656e == true) goto L29;
        f(8);
        return;
    L29:
        if (this.f117048i == false) goto L45;
        if (tb1.c.f545229a == true) goto L33;
    L36:
        boolean r107 = false;
    L37:
        if (r107 == true) goto L41;
        f(0);
        View r108 = this.f117041b;
        if (r108 == null) goto L72;
        r108.setAlpha(0.5f);
        return;
    L72:
        return;
    L41:
        f(0);
        View r109 = this.f117041b;
        if (r109 == null) goto L74;
        r109.setAlpha(1.0f);
        return;
    L74:
        return;
    L33:
        if (r102.h() != 0) goto L36;
        r107 = true;
        goto L37
    L45:
        if (r102.h() == 1) goto L48;
        f(8);
        return;
    L48:
        if (this.f117048i == true) goto L59;
        if (r102.f116665n == false) goto L59;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r110 = c();
        if (this.f117048i == false) goto L54;
        ToolbarButton r111 = ToolbarButton.TRANSFORM_WIDGET_MORE;
    L56:
        if (r110.n(r111) == true) goto L59;
        d("live_icon_show");
        goto L59
    L54:
        r111 = ToolbarButton.TRANSFORM_WIDGET;
    L59:
        if (this.f117048i == true) goto L63;
        CompositeDisposable r112 = this.f117044e;
        if (r112 == null) goto L63;
        r112.add(((SingleSubscribeProxy) Single.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.f117047h))).subscribe(new n5(this)));
    L63:
        View r113 = this.f117041b;
        if (r113 == null) goto L66;
        r113.setAlpha(1.0f);
    L66:
        f(0);
        return;
    L21:
        r106 = null;
        goto L23
    L70:
        return;
    L80:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        String r111 = com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b());
        if (this.f117048i == false) goto L47;
        Room r100 = this.f117040a;
        if (r100 == null) goto L7;
        long r101 = r100.f162599id;
    L8:
        long r102 = r101;
        final ToolbarBroadcastFunction r103 = ToolbarBroadcastFunction.TRANSFORM_WIDGET;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L13;
        BottomToolbarViewModel.a r104 = BottomToolbarViewModel.Companion;
        DataCenter r105 = this.f117049j;
        r104.getClass();
        BottomToolbarViewModel r106 = BottomToolbarViewModel.a.a(r105);
        if (r106 == null) goto L42;
        r106.openChangeDialog(this.f117047h, r102, r103, new o5(this));
    L42:
        com.bytedance.android.livesdk.sharedpref.f.d(com.bytedance.android.livesdk.chatroom.utils.k0.d(r111), Boolean.FALSE);
        View r112 = this.f117042c;
        if (r112 == null) goto L51;
        r112.setVisibility(8);
        return;
    L51:
        return;
    L13:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r107 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.f117049j);
        if (r107.h() != 1) goto L17;
        ToolbarBroadcastFunction r108 = r103;
    L41:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.e(this.f117047h, r107, r102, r108, r103, new ToolbarTransformWidgetBehavior$showReplaceDialog$2(this), new ToolbarTransformWidgetBehavior$showReplaceDialog$3(this, r103));
        goto L42
    L17:
        if (r107.f() != 1) goto L20;
        ToolbarBroadcastFunction r109 = ToolbarBroadcastFunction.MINI_APP;
    L40:
        r108 = r109;
        goto L41
    L20:
        if (r107.b() != 1) goto L23;
        r109 = ToolbarBroadcastFunction.COMMERCE;
        goto L40
    L23:
        if (r107.c() != 1) goto L26;
        r109 = ToolbarBroadcastFunction.GAME_PROMOTE;
        goto L40
    L26:
        if (r107.j() != 1) goto L29;
        r109 = ToolbarBroadcastFunction.WELFARE;
        goto L40
    L29:
        if (r107.d() != 1) goto L32;
        r109 = ToolbarBroadcastFunction.GROUP_PURCHASE;
        goto L40
    L32:
        if (r107.e() != 1) goto L34;
        r109 = ToolbarBroadcastFunction.MIX_MINI_APP;
        goto L40
    L34:
        boolean r113 = tb1.c.f545229a;
        if (r107.g() != 1) goto L38;
        r109 = ToolbarBroadcastFunction.MINI_GAME;
        goto L40
    L38:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L46;
        r109 = ToolbarBroadcastFunction.COMMERCE;
        goto L40
    L46:
        throw new IllegalStateException("cant has other button unfold");
    L7:
        r101 = 0;
        goto L8
    L47:
        e();
        int r114 = com.bytedance.android.livesdk.chatroom.utils.k0.f114530a;
        Intrinsics.checkNotNullParameter(r111, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("is_first_show_unfold_transform_widget_" + r111, Boolean.TRUE), Boolean.FALSE);
        View r115 = this.f117042c;
        if (r115 == null) goto L53;
        r115.setVisibility(8);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getIntType() == 2001) goto L9;
    L11:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L16;
        r100 = null;
    L16:
        if (r100 == null) goto L34;
        ICommerceMessage r102 = (ICommerceMessage) r100;
        if (r102.getMessageType() != 3) goto L20;
    L25:
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L36;
        com.bytedance.live.datacontext.m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L37;
        Room r105 = r104.getValue();
        if (r105 == null) goto L38;
        ((GetUsingCardApi) com.bytedance.android.live.network.c.b().e(GetUsingCardApi.class)).checkUsingGroup(r105.getRoomId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r102, this), new b(r102, this), c.f117054a);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L20:
        if (r102.getMessageType() == 5) goto L25;
        if (r102.getMessageType() == 1) goto L25;
        if (r102.getMessageType() == 2) goto L25;
        return;
    L34:
        return;
    L9:
        if ((r100 instanceof ICommerceMessage) == false) goto L11;
        r101 = true;
        goto L13
    }

    public static final void a(ToolbarTransformWidgetBehavior r100, ICommerceMessage r110) {
        r100.getClass();
        long r101 = r110.getMessageType();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r102 = null;
        if (r101 != 3) goto L19;
        DataCenter r103 = r100.f117049j;
        if (r103 == null) goto L7;
        Boolean r104 = (Boolean) r103.get("data_is_anchor", Boolean.FALSE);
    L9:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L75;
        DataCenter r105 = r100.f117049j;
        if (r105 == null) goto L13;
        r102 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r105.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L13:
        if (r102 == null) goto L15;
        r102.f116656e = true;
    L15:
        DataCenter r106 = r100.f117049j;
        if (r106 == null) goto L76;
        r106.put("data_live_mini_app_commerce_status", r102);
        return;
    L76:
        return;
    L75:
        return;
    L7:
        r104 = null;
        goto L9
    L19:
        if (r101 != 5) goto L37;
        DataCenter r111 = r100.f117049j;
        if (r111 == null) goto L23;
        Boolean r112 = (Boolean) r111.get("data_is_anchor", Boolean.FALSE);
    L25:
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L78;
        DataCenter r113 = r100.f117049j;
        if (r113 == null) goto L29;
        r102 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r113.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L29:
        if (r102 == null) goto L31;
        r102.f116656e = false;
    L31:
        if (r102 == null) goto L33;
        r102.f116665n = false;
    L33:
        DataCenter r107 = r100.f117049j;
        if (r107 == null) goto L79;
        r107.put("data_live_mini_app_commerce_status", r102);
        return;
    L79:
        return;
    L78:
        return;
    L23:
        r112 = null;
        goto L25
    L37:
        if (r101 != 1) goto L58;
        DataCenter r108 = r100.f117049j;
        if (r108 == null) goto L41;
        Boolean r109 = (Boolean) r108.get("data_is_anchor", Boolean.FALSE);
    L43:
        if (Intrinsics.areEqual(r109, Boolean.TRUE) == false) goto L81;
        DataCenter r114 = r100.f117049j;
        if (r114 == null) goto L47;
        r102 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r114.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L47:
        if (r102 != null) goto L49;
    L50:
        if (r102 == null) goto L52;
        r102.f116665n = true;
    L52:
        if (r102 == null) goto L54;
        r102.k(ToolbarBroadcastFunction.TRANSFORM_WIDGET);
    L54:
        DataCenter r115 = r100.f117049j;
        if (r115 == null) goto L83;
        r115.put("data_live_mini_app_commerce_status", r102);
        return;
    L83:
        return;
    L49:
        if (r102.f116665n != true) goto L50;
        return;
    L81:
        return;
    L41:
        r109 = null;
        goto L43
    L58:
        if (r101 != 2) goto L85;
        DataCenter r116 = r100.f117049j;
        if (r116 == null) goto L62;
        Boolean r117 = (Boolean) r116.get("data_is_anchor", Boolean.FALSE);
    L64:
        if (Intrinsics.areEqual(r117, Boolean.TRUE) == false) goto L86;
        DataCenter r118 = r100.f117049j;
        if (r118 == null) goto L68;
        r102 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r118.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L68:
        if (r102 != null) goto L70;
        return;
    L70:
        if (r102.f116665n != true) goto L88;
        r102.f116665n = false;
        DataCenter r119 = r100.f117049j;
        if (r119 == null) goto L89;
        r119.put("data_live_mini_app_commerce_status", r102);
        return;
    L89:
        return;
    L88:
        return;
    L86:
        return;
    L62:
        r117 = null;
        goto L64
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        vlc.d r102 = this.f117046g;
        if (r102 == null) goto L5;
        r102.removeMessageListener(this);
    L5:
        CompositeDisposable r103 = this.f117044e;
        if (r103 == null) goto L9;
        r103.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f117041b = r100;
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r101.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2())).f116656e == false) goto L5;
        int r102 = 0;
    L6:
        f(r102);
        this.f117044e = new CompositeDisposable();
        if (this.f117048i == true) goto L16;
        this.f117042c = r100.findViewById(R.id.view_red_dot);
        String r103 = com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b());
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        int r104 = com.bytedance.android.livesdk.chatroom.utils.k0.f114530a;
        Intrinsics.checkNotNullParameter(r103, "key");
        String r105 = "is_first_show_unfold_transform_widget_".concat(r103);
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e(r105, r106).getValue(), r106) == false) goto L16;
        View r107 = this.f117042c;
        if (r107 == null) goto L16;
        r107.setVisibility(0);
    L16:
        this.f117040a = (Room) r101.get("data_room", null);
        this.f117049j = r101;
        r101.observe("data_live_mini_app_commerce_status", this, true);
        CompositeDisposable r108 = this.f117044e;
        if (r108 == null) goto L20;
        r108.add(xs2.b.a().b(com.bytedance.android.livesdk.event.h0.class).subscribe(new g(new ToolbarTransformWidgetBehavior$onLoad$1(this))));
    L20:
        if (this.f117048i == false) goto L22;
        d("live_icon_show");
    L22:
        vlc.d r109 = (vlc.d) r101.get("data_message_manager", null);
        this.f117046g = r109;
        if (r109 == null) goto L26;
        r109.addMessageListener(2001, this);
        return;
    L26:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public ToolbarTransformWidgetBehavior(Context r100, boolean r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f117047h = r100;
        this.f117048i = r101;
        this.f117049j = r102;
        this.f117045f = new com.bytedance.android.livesdk.event.h0(0);
    }
}
