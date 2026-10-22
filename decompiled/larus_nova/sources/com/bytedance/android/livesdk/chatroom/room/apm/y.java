package com.bytedance.android.livesdk.chatroom.room.apm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class y implements q81.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, CopyOnWriteArrayList<APMEvent>> f110745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f110746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f110747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ILivePlayerClient f110748d;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110750b;

        public a(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110749a = r100;
            this.f110750b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110750b.f110745a;
            if (r102 == null) goto L13;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L14;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 == null) goto L10;
            String r105 = String.valueOf(r101.booleanValue());
            if (r105 == null) goto L10;
        L11:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "surfaceReady", r105));
            return;
        L10:
            r105 = "";
            goto L11
        L14:
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f110751a;

        public b(y r100, q81.a r101) {
            this.f110751a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110751a.f110745a;
            if (r102 == null) goto L8;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("black_screen");
            if (r103 == null) goto L9;
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "BS detected: " + r101));
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110753b;

        public c(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110752a = r100;
            this.f110753b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110753b.f110745a;
            if (r102 == null) goto L8;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("black_screen");
            if (r103 == null) goto L9;
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, r101));
            return;
        L9:
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110755b;

        public d(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110754a = r100;
            this.f110755b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110755b.f110745a;
            if (r102 == null) goto L13;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L14;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 == null) goto L10;
            String r105 = String.valueOf(r101.booleanValue());
            if (r105 == null) goto L10;
        L11:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "playing", r105));
            return;
        L10:
            r105 = "";
            goto L11
        L14:
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110757b;

        public e(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110756a = r100;
            this.f110757b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110757b.f110745a;
            if (r102 == null) goto L13;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L14;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 == null) goto L10;
            String r105 = String.valueOf(r101.booleanValue());
            if (r105 == null) goto L10;
        L11:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "stopped", r105));
            return;
        L10:
            r105 = "";
            goto L11
        L14:
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110759b;

        public f(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110758a = r100;
            this.f110759b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110759b.f110745a;
            if (r102 == null) goto L13;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L14;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 == null) goto L10;
            String r105 = String.valueOf(r101.booleanValue());
            if (r105 == null) goto L10;
        L11:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "released", r105));
            return;
        L10:
            r105 = "";
            goto L11
        L14:
            return;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110761b;

        public g(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110760a = r100;
            this.f110761b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L15;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110761b.f110745a;
            if (r102 == null) goto L16;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L17;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 == null) goto L12;
            String r105 = String.valueOf(r101.booleanValue());
            if (r105 == null) goto L12;
        L13:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "firstFrame", r105));
            return;
        L12:
            r105 = "";
            goto L13
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110763b;

        public h(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110762a = r100;
            this.f110763b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if ((!Intrinsics.areEqual(r101, this.f110763b.f110746b)) == false) goto L16;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110763b.f110745a;
            if (r102 == null) goto L14;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L14;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 == null) goto L12;
            String r105 = String.valueOf(r101.booleanValue());
            if (r105 == null) goto L12;
        L13:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "playerMute", r105));
        L12:
            r105 = "";
        L14:
            this.f110763b.f110746b = r101;
            return;
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110765b;

        public i(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110764a = r100;
            this.f110765b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110765b.f110745a;
            if (r102 == null) goto L11;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L12;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 != null) goto L9;
            r101 = "";
        L9:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "playerMediaError", r101));
            return;
        L12:
            return;
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110767b;

        public j(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110766a = r100;
            this.f110767b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L15;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110767b.f110745a;
            if (r102 == null) goto L16;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L17;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 == null) goto L12;
            String r105 = String.valueOf(r101.booleanValue());
            if (r105 == null) goto L12;
        L13:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "startPullStream", r105));
            return;
        L12:
            r105 = "";
            goto L13
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class k<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f110768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f110769b;

        public k(LifecycleOwner r100, y r101, q81.a r102) {
            this.f110768a = r100;
            this.f110769b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IRenderView r101 = (IRenderView) r100;
            HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110769b.f110745a;
            if (r102 == null) goto L13;
            CopyOnWriteArrayList<APMEvent> r103 = r102.get("player");
            if (r103 == null) goto L14;
            APMEvent.Level r104 = APMEvent.Level.I;
            if (r101 == null) goto L10;
            String r105 = String.valueOf(r101.hashCode());
            if (r105 == null) goto L10;
        L11:
            r103.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r104, "bindRenderView", r105));
            return;
        L10:
            r105 = "";
            goto L11
        L14:
            return;
        }
    }

    public static final class l {
    }

    static {
    }

    @Override // q81.f
    public final Object b() {
        return this.f110745a;
    }

    @Override // q81.f
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HashMap<String, CopyOnWriteArrayList<APMEvent>> r102 = this.f110745a;
        if (r102 != null) goto L5;
    L12:
        HashMap<String, CopyOnWriteArrayList<APMEvent>> r103 = this.f110745a;
        if (r103 == null) goto L19;
        CopyOnWriteArrayList<APMEvent> r104 = new CopyOnWriteArrayList();
        r104.add(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, r100 + ": " + r101));
        Unit r105 = Unit.INSTANCE;
        CopyOnWriteArrayList<APMEvent> r106 = r103.put(r100, r104);
        return;
    L19:
        return;
    L5:
        if (r102.containsKey(r100) != true) goto L12;
        HashMap<String, CopyOnWriteArrayList<APMEvent>> r107 = this.f110745a;
        if (r107 == null) goto L16;
        CopyOnWriteArrayList<APMEvent> r108 = r107.get(r100);
        if (r108 == null) goto L17;
        r108.add(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, r100 + ": " + r101));
        return;
    L17:
        return;
    }

    public y(LifecycleOwner r100, p0 r101, ILivePlayerClient r102, q81.a r110) {
        this.f110747c = r100;
        this.f110748d = r102;
        this.f110746b = Boolean.FALSE;
        if (r100 == null) goto L56;
        HashMap<String, CopyOnWriteArrayList<APMEvent>> r103 = new HashMap(4);
        CopyOnWriteArrayList<APMEvent> r104 = new CopyOnWriteArrayList();
        APMEvent.Level r105 = APMEvent.Level.I;
        r104.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r105, ReportCardMonitorPlugin.EVENT_NAME, "black_screen"));
        Unit r106 = Unit.INSTANCE;
        r103.put("black_screen", r104);
        CopyOnWriteArrayList<APMEvent> r107 = new CopyOnWriteArrayList();
        StringBuilder r108 = new StringBuilder("player@");
        if (r102 == null) goto L7;
        int r109 = r102.hashCode();
    L8:
        r108.append(r109);
        r107.add(com.bytedance.android.live.livepullstream.api.apm.a.c(r105, ReportCardMonitorPlugin.EVENT_NAME, r108.toString()));
        r103.put("player", r107);
        this.f110745a = r103;
        if (r101 == null) goto L13;
        MutableLiveData<String> r111 = r101.getTraceApmEvent();
        if (r111 == null) goto L13;
        r111.observe(r100, new c(r100, this, r110));
    L13:
        if (r102 == null) goto L43;
        IRoomEventHub r112 = r102.getEventHub();
        if (r112 == null) goto L43;
        MutableLiveData<Boolean> r113 = r112.getPlaying();
        if (r113 == null) goto L19;
        r113.observe(r100, new d(r100, this, r110));
    L19:
        MutableLiveData<Boolean> r114 = r112.getStopped();
        if (r114 == null) goto L22;
        r114.observe(r100, new e(r100, this, r110));
    L22:
        MutableLiveData<Boolean> r115 = r112.getReleased();
        if (r115 == null) goto L25;
        r115.observe(r100, new f(r100, this, r110));
    L25:
        MutableLiveData<Boolean> r116 = r112.getFirstFrame();
        if (r116 == null) goto L28;
        r116.observe(r100, new g(r100, this, r110));
    L28:
        MutableLiveData<Boolean> r117 = r112.getPlayerMute();
        if (r117 == null) goto L31;
        r117.observe(r100, new h(r100, this, r110));
    L31:
        MutableLiveData<String> r118 = r112.getPlayerMediaError();
        if (r118 == null) goto L34;
        r118.observe(r100, new i(r100, this, r110));
    L34:
        MutableLiveData<Boolean> r119 = r112.getStartPullStream();
        if (r119 == null) goto L37;
        r119.observe(r100, new j(r100, this, r110));
    L37:
        MutableLiveData<IRenderView> r120 = r112.getBindRenderView();
        if (r120 == null) goto L40;
        r120.observe(r100, new k(r100, this, r110));
    L40:
        MutableLiveData<Boolean> r121 = r112.getSurfaceReady();
        if (r121 == null) goto L43;
        r121.observe(r100, new a(r100, this, r110));
    L43:
        q81.a.C7298a r122 = null;
        if (r110 == null) goto L46;
        q81.a.C7298a r123 = r110.getEventHub();
    L48:
        if ((r123 instanceof q81.a.C7298a) == false) goto L51;
        r122 = r123;
    L51:
        if (r122 == null) goto L57;
        MutableLiveData<String> r124 = r122.f532020b;
        if (r124 == null) goto L58;
        r124.observe(r100, new b(this, r110));
        return;
    L58:
        return;
    L57:
        return;
    L46:
        r123 = null;
        goto L48
    L7:
        r109 = 0;
        goto L8
    }
}
