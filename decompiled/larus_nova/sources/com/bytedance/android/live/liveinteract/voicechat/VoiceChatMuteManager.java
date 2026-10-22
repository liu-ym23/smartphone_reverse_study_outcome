package com.bytedance.android.live.liveinteract.voicechat;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.ac1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/VoiceChatMuteManager;", "Lcom/bytedance/android/live/liveinteract/voicechat/b;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceChatMuteManager implements com.bytedance.android.live.liveinteract.voicechat.b, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f80002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f80003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f80004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f80005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f80006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Boolean> f80007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f80008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f80009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f80010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f80011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ac1 f80012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f80013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f80014m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final VoiceChatMuteManager$listCallback$1 f80015n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f80016o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final IRoom f80017p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f80018q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final y f80019r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DataCenter f80020s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.voicechat.a f80021t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LifecycleOwner f80022u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j1 f80023v;

    public interface a {
        void C(String r100);

        void Q(String r100, Throwable r101);

        void V(String r100);

        void i0(String r100, Throwable r101);
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f80024a = null;

        static {
            f80024a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return LinkWRDSHelper.d(r101);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatMuteManager f80025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f80026b;

        public c(VoiceChatMuteManager r100, String r101) {
            this.f80025a = r100;
            this.f80026b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.network.response.e r111 = (com.bytedance.android.live.network.response.e) r110;
            if (r111 == null) goto L9;
            r1 r100 = (r1) r111.data;
            if (r100 == null) goto L9;
            dn0.c r101 = (dn0.c) this.f80025a.f80023v.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
            if (r101 == null) goto L9;
            r101.Z(this.f80026b, r100.getAckMessage(), AckFromSource.VOICE_CHAT_SILENCE_API);
        L9:
            InteractLinkFullLinkMonitor.X(this.f80026b, System.currentTimeMillis() - this.f80025a.f80009h, r111.logId);
            r1 r102 = (r1) r111.data;
            String r103 = null;
            if (r102 == null) goto L34;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r104 = r102.getLinkedUsers();
            if (r104 == null) goto L34;
            Iterator<T> r105 = r104.iterator();
        L15:
            if (r105.hasNext() == false) goto L23;
            T r106 = r105.next();
            IBaseUser r107 = ((com.bytedance.android.livesdk.link.model.bridge.k) r106).getUser();
            if (r107 == null) goto L19;
            String r108 = r107.getIdString();
        L21:
            if (Intrinsics.areEqual(r108, je0.d.b0()) == false) goto L15;
        L24:
            com.bytedance.android.livesdk.link.model.bridge.k r109 = (com.bytedance.android.livesdk.link.model.bridge.k) r106;
            if (r109 == null) goto L34;
            if (r109.getSilenceStatus() != 0) goto L34;
            String r112 = this.f80026b;
            r1 r113 = (r1) r111.data;
            if (r113 == null) goto L33;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r114 = r113.getLinkedUsers();
            if (r114 == null) goto L33;
            r103 = je0.d.g0(r114);
        L33:
            x.c0(r112, r103, true);
            ALogger.i("voice_chat", "resetSilenceStatus success but unSilence");
            return;
        L19:
            r108 = null;
            goto L21
        L23:
            r106 = null;
        L34:
            String r115 = this.f80026b;
            r1 r116 = (r1) r111.data;
            if (r116 == null) goto L39;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r117 = r116.getLinkedUsers();
            if (r117 == null) goto L39;
            r103 = je0.d.g0(r117);
        L39:
            x.c0(r115, r103, false);
            r1 r118 = (r1) r111.data;
            if (r118 == null) goto L44;
            List<com.bytedance.android.livesdk.link.model.bridge.k> r119 = r118.getLinkedUsers();
            if (r119 == null) goto L44;
            this.f80025a.f80019r.S4(r119, ((r1) r111.data).getClientUiInfo(), ((r1) r111.data).getVersion(), "resetSilence");
        L44:
            this.f80025a.f80021t.G4(true, LiveCommonConstants.REASON_RESET_LAST_SILENCE);
            MutableLiveData<Boolean> r120 = this.f80025a.f80007f;
            Boolean r121 = Boolean.TRUE;
            r120.postValue(r121);
            this.f80025a.f80020s.put("data_self_is_silenced", r121);
            ALogger.i("voice_chat", "resetSilenceStatus success");
            f2.b(R.string.ttlive_live_interact_ktv_reset_silence_toast, 0);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatMuteManager f80027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f80028b;

        public d(VoiceChatMuteManager r100, String r101) {
            this.f80027a = r100;
            this.f80028b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            je0.d.Q(this.f80027a.f80004c, r101);
            String r102 = this.f80028b;
            long r103 = this.f80027a.f80009h;
            InteractLinkFullLinkMonitor.W(r102, System.currentTimeMillis() - r103, r101);
            ALogger.i("voice_chat", "resetSilenceStatus failed");
            String r104 = this.f80028b;
            int r105 = x.f77572a;
            Intrinsics.checkNotNullParameter(r104, "targetId");
            LinkedHashMap r106 = new LinkedHashMap();
            r106.put("target_user_id", r104);
            x.X(r101, r106);
            x.t0("resume_last_silence_failed", r106);
        }
    }

    public static boolean r(long r100) {
        if (r100 > 12000) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= BaseConstants.Time.DAY) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final boolean i() {
        return this.f80021t.O5();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final boolean isMute() {
        Boolean r100 = this.f80007f.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final void j() {
        this.f80007f.setValue(Boolean.FALSE);
        this.f80022u.getLifecycle().addObserver(this);
        this.f80019r.Q4(this.f80015n);
    }

    public final void n() {
        this.f80006e.clear();
        this.f80005d.clear();
        this.f80022u.getLifecycle().removeObserver(this);
        this.f80019r.T4(this.f80015n);
    }

    public final int o() {
        ILinkPlayerInfoBridge r100 = this.f80019r.p(je0.d.b0(), tc0.c.h().f545349f);
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getSilenceStatus();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        ALogger.i("voice_chat", this.f80004c + " onPause");
        this.f80008g = true;
        this.f80011j = System.currentTimeMillis();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ALogger.i("voice_chat", this.f80004c + " onResume");
        this.f80008g = false;
        this.f80011j = System.currentTimeMillis();
    }

    public final boolean p() {
        if (this.f80014m == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f80019r.f76333t <= 0) goto L7;
        return true;
    }

    public final boolean q() {
        if (this.f80002a == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f80003b == true) goto L8;
        return false;
    }

    public final void v() {
        Intrinsics.checkNotNullParameter("match apply", "reason");
        ALogger.i("voice_chat", "silenceSelfByServer, reason=match apply");
        DataCenter r100 = this.f80020s;
        Boolean r101 = Boolean.TRUE;
        r100.put("data_self_is_silenced", r101);
        this.f80021t.G4(true, "match apply");
        this.f80007f.postValue(r101);
        Iterator<a> r102 = this.f80005d.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().V(je0.d.b0());
        goto L4
    }

    public final void s() {
        String r100 = je0.d.b0();
        this.f80009h = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r100);
        this.f80006e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(this.f80017p.getId(), d5.c(r100), r100, 0, true).subscribeOn(Schedulers.io()).flatMap(b.f80024a).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r100), new d(this, r100)));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f80005d.add(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final boolean e(boolean r100) {
        ILinkPlayerInfoBridge r101 = this.f80019r.p(je0.d.b0(), tc0.c.h().f545349f);
        if (this.f80018q == true) goto L11;
        if (r100 == false) goto L11;
        if (r101 != null) goto L8;
    L10:
        return false;
    L8:
        if (r101.getSilenceStatus() == 2) goto L10;
    L11:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void g(a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f80005d.remove(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        u(this, r100, false, false, null, null, 28);
    }

    public final void k(String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        this.f80007f.setValue(Boolean.TRUE);
        ALogger.i("voice_chat", "autoMuteSelf ".concat(r110));
        u(this, je0.d.b0(), true, true, r110, null, 16);
    }

    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f80007f.setValue(Boolean.FALSE);
        ALogger.i("voice_chat", "autoUnMuteSelf ".concat(r100));
        w(this, je0.d.b0(), true, r100, null, 20);
    }

    public final void m(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if ((r100 instanceof ApiServerException) == true) goto L5;
        return;
    L5:
        int r101 = ((ApiServerException) r100).getErrorCode();
        if (r101 == 4004031) goto L8;
        if (r101 == 4004054) goto L8;
        return;
    L8:
        int r102 = o();
        Boolean r103 = this.f80021t.t0();
        if (r102 != 0) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == false) goto L22;
        if (r101 != 4004054) goto L14;
        String r104 = "unsilence failed not allowed";
    L16:
        if (this.f80012k.enableReqFailedCheck == false) goto L18;
        this.f80021t.G4(true, r104);
        DataCenter r105 = this.f80020s;
        Boolean r106 = Boolean.TRUE;
        r105.put("data_self_is_silenced", r106);
        this.f80007f.postValue(r106);
    L18:
        int r107 = x.f77572a;
        Intrinsics.checkNotNullParameter(r104, "errorMsg");
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("error_msg", r104);
        r108.put("error_code", Integer.valueOf(r101));
        r108.put("list_status", Integer.valueOf(r102));
        x.t0("check_mute_when_request_failed", r108);
        return;
    L14:
        r104 = "silence failed already mute";
        goto L16
    }

    public final void t(boolean r100) {
        this.f80009h = System.currentTimeMillis();
        this.f80007f.postValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void b(String r100, MediaOperation.a r110) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (this.f80018q == false) goto L5;
        u(this, je0.d.b0(), true, false, r100, r110, 4);
        return;
    L5:
        u(this, je0.d.b0(), true, false, r100, r110, 4);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void c(LifecycleOwner r100, Observer<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f80007f.observe(r100, r101);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void f(String r100, MediaOperation.a r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        w(this, r100, false, null, r101, 12);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.b
    public final void d(String r100, boolean r110, MediaOperation.a r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (r110 == false) goto L8;
        String r101 = je0.d.b0();
        if (this.f80003b == true) goto L11;
        this.f80003b = true;
        this.f80009h = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.n0(r101);
        this.f80006e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(this.f80017p.getId(), d5.c(r101), r101, true).subscribeOn(Schedulers.io()).flatMap(i.f80293a).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r101, r112), new k(this, r101)));
        return;
    L11:
        return;
    L8:
        w(this, je0.d.b0(), true, r100, r111, 4);
    }

    public static void w(VoiceChatMuteManager r110, String r111, boolean r112, String r113, MediaOperation.a r114, int r115) {
        if ((r115 & 8) == 0) goto L6;
        r113 = "";
    L6:
        if ((r115 & 16) == 0) goto L9;
        r114 = null;
    L9:
        if (r110.f80003b == true) goto L13;
        r110.f80003b = true;
        r110.f80009h = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.n0(r111);
        String r100 = r113;
        r110.f80006e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(r110.f80017p.getId(), r111, r111).subscribeOn(Schedulers.io()).flatMap(o.f80443a).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(r110, r111, r100, false, r112, r114), new q(r110, r111, r100, false, r114)));
        return;
    }

    public VoiceChatMuteManager(IRoom r100, boolean r101, y r102, DataCenter r103, com.bytedance.android.live.liveinteract.voicechat.a r104, LifecycleOwner r105, j1 r106) {
        Intrinsics.checkNotNullParameter(r100, "mRoom");
        Intrinsics.checkNotNullParameter(r102, "mInfoCenter");
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        Intrinsics.checkNotNullParameter(r104, "muteImpl");
        Intrinsics.checkNotNullParameter(r105, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r106, "multiLinkRoomScopeProvider");
        this.f80017p = r100;
        this.f80018q = r101;
        this.f80019r = r102;
        this.f80020s = r103;
        this.f80021t = r104;
        this.f80022u = r105;
        this.f80023v = r106;
        this.f80004c = "VoiceChatMuteManager";
        this.f80005d = new CopyOnWriteArrayList();
        this.f80006e = new CompositeDisposable();
        this.f80007f = new MutableLiveData();
        this.f80009h = System.currentTimeMillis();
        this.f80010i = System.currentTimeMillis();
        this.f80011j = System.currentTimeMillis();
        ReadOnlyProperty r107 = vm2.d.f555902m5;
        KProperty<?>[] r108 = vm2.d.f555776a;
        this.f80012k = (ac1) r107.getValue(null, r108[322(0x142, float:4.51E-43)]);
        this.f80013l = ((Boolean) vm2.d.f555852h5.getValue(null, r108[317(0x13d, float:4.44E-43)])).booleanValue();
        if (vm2.d.m().enable == true) goto L5;
    L7:
        boolean r109 = false;
    L8:
        this.f80014m = r109;
        this.f80015n = new VoiceChatMuteManager$listCallback$1(this);
        return;
    L5:
        if (vm2.d.P() == false) goto L7;
        r109 = true;
        goto L8
    }

    public static void u(VoiceChatMuteManager r110, String r111, boolean r210, boolean r211, String r212, MediaOperation.a r213, int r214) {
        if ((r214 & 4) == 0) goto L5;
        boolean r112 = false;
    L7:
        if ((r214 & 8) == 0) goto L9;
        String r113 = "";
    L11:
        if ((r214 & 16) == 0) goto L13;
        MediaOperation.a r114 = null;
    L15:
        if (r110.f80002a == true) goto L19;
        r110.f80002a = true;
        r110.f80009h = System.currentTimeMillis();
        long r115 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r111);
        r110.f80006e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(r110.f80017p.getId(), r111, r111, r112 ? 1 : 0).subscribeOn(Schedulers.io()).flatMap(l.f80303a).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r110, r111, r112 ? 1 : 0, r113, r115, r112, r210, r114), new n(r110, r111, r115, r113, r112, r114)));
        return;
    L19:
        return;
    L13:
        r114 = r213;
        goto L15
    L9:
        r113 = r212;
        goto L11
    L5:
        r112 = r211;
        goto L7
    }
}
