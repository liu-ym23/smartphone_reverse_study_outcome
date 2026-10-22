package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ChorusUserType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ConcertBizIdType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback$Code;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.DynamicConcertStatusChangeEventType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbDataContext;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import zg1.a1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\u001eJ\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/concert_stage/biz/ConcertStageComponent;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lgd2/f;", "Lgd2/d;", "getConcertEarMonitor", "", "interactID", "", "setMainSingerInteractId", "Landroidx/lifecycle/ViewModelStore;", ce.f26395j, "Lkotlin/Lazy;", "getViewModelStorage", "()Landroidx/lifecycle/ViewModelStore;", "viewModelStorage", "Landroid/content/Context;", "B", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext", "Landroid/view/ViewGroup;", "C", "Landroid/view/ViewGroup;", "getContainerView", "()Landroid/view/ViewGroup;", "containerView", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ConcertStageComponent extends FrameLayout implements Observer<KVData>, ViewModelStoreOwnerCompat, gd2.f {
    public final j A;
    public final Context B;
    public final ViewGroup C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f143700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f143701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f143702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f143703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f143704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f143705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<gd2.b> f143706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x f143707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f143708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f143709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f143710k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m f143711l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a f143712m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public js1.a f143713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SurfaceView f143714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f143715p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f143716q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public z0 f143717r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f143718s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f143719t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public DataCenter f143720u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f143721v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f143722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ConcertStageComponent$usbReceiver$1 f143723x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l f143724y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final i f143725z;

    public static final class a {
    }

    static {
    }

    private final ViewModelStore getViewModelStorage() {
        return (ViewModelStore) this.f143709j.getValue();
    }

    @Override // gd2.f
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat, androidx.lifecycle.ViewModelStoreOwner
    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.CC.$default$getViewModelStore(this);
    }

    @Override // android.view.View, gd2.f
    public final void onConfigurationChanged(Configuration r100) {
    }

    @Override // gd2.f
    public final boolean b() {
        x r100 = this.f143707h;
        JoinChorusConcertStatus r101 = null;
        if (r100 == null) goto L5;
        JoinChorusConcertStatus r102 = r100.f143757c;
    L7:
        if (r102 == JoinChorusConcertStatus.JOINED) goto L14;
        if (r100 == null) goto L11;
        r101 = r100.f143757c;
    L11:
        if (r101 == JoinChorusConcertStatus.JOINING) goto L14;
        return false;
    L14:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    @Override // gd2.f
    public final boolean d() {
        js1.a r100 = this.f143713n;
        if (r100 == null) goto L13;
        vb6.g r101 = r100.f500178a;
        if (r101 == null) goto L13;
        yb6.e r102 = r101.j();
        if (r102 == null) goto L13;
        yb6.n r103 = r102.K();
        if (r103 == null) goto L13;
        if (r103.f567105e != true) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // gd2.f
    public final void onPause() {
        x r100 = this.f143707h;
        if (r100 == null) goto L5;
        JoinChorusConcertStatus r101 = r100.f143757c;
    L7:
        if (r101 != JoinChorusConcertStatus.JOINED) goto L15;
        js1.a r102 = this.f143713n;
        if (r102 == null) goto L15;
        vb6.g r103 = r102.f500178a;
        if (r103 == null) goto L15;
        yb6.e r104 = r103.j();
        if (r104 == null) goto L15;
        r104.Y("onPause");
    L15:
        w.b("ConcertStageComponent", "onPause, localJoinState = " + this.f143707h);
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // gd2.f
    public final void onResume() {
        l(new ConcertStageComponent$updateStageSize$1(this));
        int r100 = getResources().getConfiguration().orientation;
        if (this.f143705f == r100) goto L9;
        this.f143705f = r100;
        DynamicConcertStatusChangeEventType r101 = DynamicConcertStatusChangeEventType.onScreenOrientationChange;
        JsonObject r102 = new JsonObject();
        if (r100 != 2) goto L7;
        String r103 = "landscape";
    L8:
        r102.addProperty("orientation", r103);
        Unit r104 = Unit.INSTANCE;
        e(new hd2.b(r101, r102));
        goto L9
    L7:
        r103 = "portrait";
    L9:
        x r105 = this.f143707h;
        if (r105 == null) goto L12;
        JoinChorusConcertStatus r106 = r105.f143757c;
    L14:
        if (r106 != JoinChorusConcertStatus.JOINED) goto L22;
        js1.a r107 = this.f143713n;
        if (r107 == null) goto L22;
        vb6.g r108 = r107.f500178a;
        if (r108 == null) goto L22;
        yb6.e r109 = r108.j();
        if (r109 == null) goto L22;
        r109.L("onResume");
    L22:
        w.b("ConcertStageComponent", "onResume, localJoinState = " + this.f143707h);
        return;
    L12:
        r106 = null;
        goto L14
    }

    public final int k() {
        int r100 = getResources().getConfiguration().orientation;
        if (r100 != 1) goto L5;
        int r101 = Math.min(s1.y(), s1.f(375.0f));
        this.f143703d = r101;
        this.f143702c = r101 / this.f143704e;
        return r101;
    L5:
        if (r100 == 2) goto L11;
        return this.f143703d;
    L11:
        return Math.min((int) (this.f143704e * this.f143702c), (int) (s1.y() * this.f143701b));
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat
    public final ViewModelStore tf() {
        return getViewModelStorage();
    }

    @Override // gd2.f
    public gd2.d getConcertEarMonitor() {
        return this.f143715p;
    }

    public final ViewGroup getContainerView() {
        return this.C;
    }

    public final Context getMContext() {
        return this.B;
    }

    public static final void j(final ConcertStageComponent r100) {
        if (r100.f143719t == false) goto L5;
        return;
    L5:
        if (r100.f143714o == null) goto L16;
        hd0.c.f().k(2);
        boolean r101 = de2.b.f468051a;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L10;
    L13:
        r100.f143719t = true;
        r100.l(new ConcertStageComponent$handleLinkSuccess$1(r100));
        return;
    L10:
        if (de2.b.f468051a == true) goto L13;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("function_type2", "chorus");
        de2.b.a("livesdk_guest_connection_success", r102);
        de2.b.f468053c = System.currentTimeMillis();
        de2.b.f468051a = true;
        de2.b.f468052b = false;
        goto L13
    }

    @Override // gd2.f
    public final void a(VSChorusConcertWidget.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        w.b("ConcertStageComponent", "unregisterChorusListener, listener: " + r100);
        this.f143706g.remove(r100);
    }

    @Override // gd2.f
    public final void c(VSChorusConcertWidget.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        w.b("ConcertStageComponent", "registerChorusListener, listener: " + r100);
        if (this.f143706g.contains(r100) == true) goto L6;
        this.f143706g.add(r100);
        return;
    }

    @Override // gd2.f
    public final void e(hd2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        m r101 = this.f143711l;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "event");
        JsonObject r102 = new JsonObject();
        r102.addProperty("type", r100.f484586a.getTypeName());
        r102.add("data", r100.f484587b);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r103 = r101.f143745a;
        if (r103 == null) goto L9;
        r103.sendJsEvent("onChorusConcertStatusChange", r102);
        return;
    L9:
        return;
    }

    @Override // gd2.f
    public final JsonObject g(hd2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "getStatus");
        com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a r101 = this.f143712m;
        if (r101 == null) goto L21;
        Intrinsics.checkNotNullParameter(r100, "getStatus");
        String r102 = r100.f484583a;
        boolean r103 = true;
        if (r102.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L11;
        return new JsonObject();
    L11:
        if (r100.getType().length() == 0) goto L14;
        r103 = false;
    L14:
        if (r103 == true) goto L24;
        ConcertBizIdType.Companion.getClass();
        ConcertBizIdType r105 = ConcertBizIdType.a.a(r102);
        ce2.a r106 = (ce2.a) ((LinkedHashMap) r101.f143770a).get(r105);
        if (r106 == null) goto L26;
        JsonObject r107 = r106.b(r100);
        if (r107 == null) goto L26;
        return r107;
    L26:
        return new JsonObject();
    L24:
        return new JsonObject();
    L7:
        r104 = false;
        goto L8
    L21:
        return null;
    }

    public final void l(Function1<? super gd2.b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Iterator<gd2.b> r101 = this.f143706g.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(KVData r100) {
        KVData r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        String r102 = r101.getKey();
        int r103 = r102.hashCode();
        Object r104 = null;
        if (r103 == (-1238735384)) goto L31;
        if (r103 == (-374564286)) goto L17;
        if (r103 == 382648113) goto L10;
        return;
    L10:
        if (r102.equals("cmd_concert_stage_status") == false) goto L70;
        Object r105 = r101.getData();
        if ((r105 instanceof StageStatus) == false) goto L15;
        r104 = r105;
    L15:
        final StageStatus r106 = (StageStatus) r104;
        l(new AnonymousClass2(r106));
        return;
    L70:
        return;
    L17:
        if (r102.equals(ChorusJsbDataContext.CMD_START_RTC_ENGINE) == false) goto L72;
        this.f143718s = true;
        if (this.f143717r == null) goto L29;
        com.bytedance.live.datacontext.j<vlc.d> r107 = com.bytedance.android.live.liveinteract.api.utils.m.i().getMessageManager();
        if (r107 == null) goto L29;
        vlc.d r108 = r107.getValue();
        if (r108 == null) goto L29;
        z0 r109 = this.f143717r;
        if (r109 == null) goto L28;
        r108.j((tlc.d) r109, true);
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L29:
        this.f143717r = null;
        return;
    L72:
        return;
    L31:
        if (r102.equals(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE) == false) goto L74;
        Object r110 = r101.getData();
        if ((r110 instanceof x) == true) goto L35;
        r110 = null;
    L35:
        this.f143707h = (x) r110;
        l(new AnonymousClass1(this));
        StringBuilder r111 = new StringBuilder("link state ");
        r111.append((Integer) hd0.c.f().f481009b);
        r111.append(" localJoinState ");
        x r112 = this.f143707h;
        if (r112 == null) goto L40;
        JoinChorusConcertStatus r113 = r112.f143757c;
        if (r113 == null) goto L40;
        Integer r114 = Integer.valueOf(r113.getValue());
    L41:
        r111.append(r114);
        w.b("ConcertStageComponent", r111.toString());
        x r115 = this.f143707h;
        if (r115 == null) goto L46;
        JoinChorusConcertStatus r116 = r115.f143757c;
        if (r116 == null) goto L46;
        Integer r117 = Integer.valueOf(r116.getValue());
    L47:
        int r118 = JoinChorusConcertStatus.LEAVING.getValue();
        if (r117 != null) goto L51;
    L63:
        int r119 = JoinChorusConcertStatus.JOINED.getValue();
        if (r117 != null) goto L67;
        return;
    L67:
        if (r117.intValue() != r119) goto L79;
        this.f143722w = false;
        return;
    L79:
        return;
    L51:
        if (r117.intValue() != r118) goto L63;
        this.f143717r = null;
        x r120 = this.f143707h;
        if (r120 != null) goto L55;
    L56:
        x r121 = this.f143707h;
        if (r121 != null) goto L59;
    L60:
        this.f143722w = true;
        DataCenter r122 = this.f143720u;
        if (r122 == null) goto L77;
        r122.put("cmd_interact_state_change", new a1(4));
        return;
    L77:
        return;
    L59:
        if (r121.f143756b != ChorusUserType.ChorusUserType_Fallback.getType()) goto L60;
        return;
    L55:
        if (r120.f143756b != ChorusUserType.ChorusUserType_Cdn.getType()) goto L56;
        return;
    L46:
        r117 = null;
    L40:
        r114 = null;
        goto L41
    }

    @Override // gd2.f
    public void setMainSingerInteractId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactID");
        w.b("ConcertStageComponent", "setMainSingerInteractId, interactID: " + r100);
        this.f143716q = r100;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageComponent$usbReceiver$1] */
    public ConcertStageComponent(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100);
        this.B = r100;
        this.C = r101;
        this.f143701b = 0.8f;
        this.f143702c = 3.409091f;
        this.f143703d = s1.f(375.0f);
        int r102 = s1.f(110.0f);
        this.f143704e = r102;
        this.f143705f = 1;
        this.f143706g = new CopyOnWriteArrayList();
        this.f143709j = LazyKt.lazy(ConcertStageComponent$viewModelStorage$2.INSTANCE);
        this.f143710k = new CompositeDisposable();
        this.f143716q = "";
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L5;
        r103.width = k();
        r103.height = r102;
        r101.setVisibility(0);
        r101.setLayoutParams(r103);
    L5:
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View r104 = LayoutInflater.from(r100).inflate(R.layout.ttlive_concert_stage_layout, r101, false);
        if ((r104 instanceof ViewGroup) == true) goto L8;
        r104 = null;
    L8:
        ViewGroup r105 = (ViewGroup) r104;
        this.f143721v = r105;
        r101.addView(r105);
        w.b("ConcertStageComponent", "init, contentView: " + r105 + " ;; containerView: " + r101);
        this.f143723x = new ConcertStageComponent$usbReceiver$1();
        this.f143724y = new l(this);
        this.f143725z = new i(this);
        this.A = new j(this);
    }

    @Override // gd2.f
    public final void h(hd2.c r100, com.bytedance.android.live.liveinteract.jsbridge.method.h.b r101) {
        Intrinsics.checkNotNullParameter(r100, "updateStatus");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a r102 = this.f143712m;
        if (r102 == null) goto L22;
        Intrinsics.checkNotNullParameter(r100, "updateStatus");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r103 = r100.f484588a;
        boolean r104 = true;
        if (r103.length() != 0) goto L7;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.a(IConcertUpdateStatusCallback$Code.Failed, "bizId is null", null);
        return;
    L12:
        if (r100.getType().length() == 0) goto L15;
        r104 = false;
    L15:
        if (r104 == false) goto L17;
        r101.a(IConcertUpdateStatusCallback$Code.Failed, "type is null", null);
        return;
    L17:
        ConcertBizIdType.Companion.getClass();
        ConcertBizIdType r106 = ConcertBizIdType.a.a(r103);
        ce2.a r107 = (ce2.a) ((LinkedHashMap) r102.f143770a).get(r106);
        if (r107 == null) goto L20;
        r107.a(r100, r101);
        return;
    L20:
        r101.a(IConcertUpdateStatusCallback$Code.Failed, "bizId is not support", null);
        return;
    L7:
        r105 = false;
        goto L9
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void i(Context r100, ConcertStageComponent$usbReceiver$1 r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
