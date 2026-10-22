package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.j;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.k;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.m;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.q;
import com.bytedance.android.livesdk.vscore_api.paidlive.n;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.scope.l;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class PaidRoomTempWatchAbility implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f160035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f160036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NextLiveData<Integer> f160037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f160038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Number f160039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f160040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f160041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f160042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f160043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k f160044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f160045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f160046l;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.j
    public final void Lg() {
        q r100 = this.f160042h;
        if (r100 != null) goto L5;
    L6:
        if (r100 == null) goto L8;
        k r101 = r100.f159422i;
    L9:
        if (r101 != null) goto L12;
    L10:
        a("forceUpdateConversionCardVisibility failed");
        return;
    L12:
        if (r100 == null) goto L17;
        this.f160046l.l().getTempWatchCardForceVisible().setValue(Boolean.TRUE);
        k r102 = r100.f159422i;
        if (r102 == null) goto L18;
        r102.jb(true);
        return;
    L18:
        return;
    L17:
        return;
    L8:
        r101 = null;
        goto L9
    L5:
        if (r100.f159421h == false) goto L10;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.j
    public final void X5() {
        q r100 = this.f160042h;
        if (r100 != null) goto L5;
    L12:
        a("stop timing!");
        q r101 = this.f160042h;
        if (r101 != null) goto L15;
    L30:
        Disposable r102 = this.f160041g;
        if (r102 == null) goto L33;
        r102.dispose();
    L33:
        c(0);
        return;
    L15:
        if (r101.f159423j == false) goto L21;
        m r103 = this.f160043i;
        if (r103 == null) goto L21;
        if (r103 == null) goto L21;
        r103.Tn();
    L21:
        if (r101.f159421h == false) goto L30;
        if (this.f160044j == null) goto L30;
        this.f160046l.l().getTempWatchCardForceVisible().setValue(Boolean.FALSE);
        k r104 = this.f160044j;
        if (r104 == null) goto L27;
        r104.jb(false);
    L27:
        k r105 = this.f160044j;
        if (r105 == null) goto L30;
        r105.reset();
        goto L30
    L5:
        if (r100.f159415b != true) goto L12;
        Disposable r106 = this.f160041g;
        if (r106 == null) goto L11;
        if (r106 == null) goto L12;
        if (r106.isDisposed() != true) goto L12;
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Disposable r100 = this.f160041g;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f160041g = null;
        a("onStop");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.j
    public final NextLiveData<Integer> Jl() {
        return this.f160037c;
    }

    public PaidRoomTempWatchAbility(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f160046l = r100;
        this.f160035a = "PaidRoomTempWatchAbility[" + hashCode() + "][" + r100.i0() + "][" + r100.w0() + ']';
        this.f160036b = LazyKt.lazy(PaidRoomTempWatchAbility$localDurationInfo$2.INSTANCE);
        NextLiveData<Integer> r101 = new NextLiveData();
        r101.setValue(0);
        Unit r102 = Unit.INSTANCE;
        this.f160037c = r101;
        this.f160038d = LazyKt.lazy(new PaidRoomTempWatchAbility$durationMap$2(this));
        this.f160039e = 0;
        this.f160040f = 10;
        this.f160045k = "";
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.j
    public final void N4(long r100) {
        a("updateCurWatchDuration:" + r100 + " from outside,current:" + this.f160039e.longValue());
        if (this.f160046l.l().getDebugMode().getValue().booleanValue() == false) goto L10;
        Long r101 = Long.valueOf(r100);
        this.f160039e = r101;
        q r102 = this.f160042h;
        if (r102 == null) goto L7;
        long r103 = r102.f159419f;
    L8:
        this.f160040f = r103 - r101.longValue();
        return;
    L7:
        r103 = 180;
        goto L8
    L10:
        q r104 = this.f160042h;
        if (r104 != null) goto L13;
        return;
    L13:
        if ((r100 - this.f160039e.longValue()) <= 5) goto L17;
        Long r105 = Long.valueOf(r100);
        this.f160039e = r105;
        this.f160040f = r104.f159419f - r105.longValue();
        a("update remainWatchDuration to " + this.f160040f);
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.j
    public final void Yj(Long r110) {
        a("timing! remainDuration: " + r110);
        Long r100 = null;
        if (l.b(this.f160046l) == true) goto L10;
        Disposable r111 = this.f160041g;
        if (r111 == null) goto L7;
        r111.dispose();
    L7:
        this.f160041g = null;
        a("timing! wtf scope has not enter, dispose");
        return;
    L10:
        if (NetworkUtils.f(s1.getContext()) == true) goto L13;
        a("netWork is not Avaliable");
        return;
    L13:
        a("timing! currentTempWatchConfig: " + this.f160042h);
        q r101 = this.f160042h;
        if (r101 != null) goto L16;
        return;
    L16:
        if (r110 == null) goto L18;
        this.f160040f = r110.longValue();
        this.f160039e = Long.valueOf(r101.f159419f - r110.longValue());
    L54:
        ((HashMap) this.f160038d.getValue()).put(r101.f159418e, this.f160039e);
        com.bytedance.android.livesdk.sharedpref.e r112 = (com.bytedance.android.livesdk.sharedpref.e) this.f160036b.getValue();
        HashMap r102 = (HashMap) this.f160038d.getValue();
        r112.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r112, r102);
        if (this.f160046l.l().isCleared() == true) goto L61;
        com.bytedance.live.datacontext.m<Triple<Long, Long, Long>> r113 = this.f160046l.l().getPaidTempWatchRemainTime();
        Long r103 = Long.valueOf(this.f160039e.longValue());
        q r104 = this.f160042h;
        if (r104 == null) goto L59;
        long r105 = r104.f159419f;
    L60:
        r113.setValue(new Triple(r103, Long.valueOf(r105), Long.valueOf(this.f160040f)));
        goto L61
    L59:
        r105 = 0;
    L61:
        a("timing! current total duration : " + this.f160039e + " , remainWatchDuration , local remainWatchDuration :" + this.f160040f + ", sceneContext:" + this.f160046l.l());
        long r106 = this.f160040f;
        if (r106 > 0) goto L75;
        if (r101.f159423j == false) goto L69;
        m r114 = this.f160043i;
        if (r114 == null) goto L69;
        r114.Tn();
    L69:
        if (r101.f159421h == false) goto L73;
        k r115 = this.f160044j;
        if (r115 == null) goto L73;
        r115.jb(false);
    L73:
        c(2);
        return;
    L75:
        if (r101.f159423j == false) goto L80;
        m r116 = this.f160043i;
        if (r116 == null) goto L80;
        r116.C0(r106);
    L80:
        if (r101.f159421h == false) goto L86;
        k r117 = this.f160044j;
        if (r117 == null) goto L86;
        r117.jb(true);
        k r118 = this.f160044j;
        if (r118 == null) goto L86;
        r118.C0(this.f160040f);
    L86:
        n r119 = r101.f159414a;
        if (r119 == null) goto L92;
        n.c(r119, new com.bytedance.android.livesdk.vscore_api.paidlive.j.n());
        return;
    L92:
        return;
    L18:
        if (r101.f159417d == false) goto L44;
        ILivePlayerClient r120 = this.f160046l.D().a().invoke();
        if (r120 == null) goto L26;
        IRoomEventHub r121 = r120.getEventHub();
        if (r121 == null) goto L26;
        MutableLiveData<Boolean> r122 = r121.getFirstFrame();
        if (r122 == null) goto L26;
        Boolean r123 = r122.getValue();
    L28:
        if (Intrinsics.areEqual(r123, Boolean.TRUE) == true) goto L44;
        if (this.f160046l.w0().isInRoom() == false) goto L49;
        com.bytedance.android.livesdk.vscore_api.paidlive.d r124 = this.f160046l.D().getRoomContext();
        if (r124 == null) goto L40;
        com.bytedance.live.datacontext.m<Room> r125 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.b(r124);
        if (r125 == null) goto L40;
        Room r126 = r125.getValue();
        if (r126 == null) goto L40;
        PaidLiveData r127 = r126.getPaidLiveData();
        if (r127 == null) goto L40;
        r100 = r127.needRefreshStream();
    L40:
        if (r100 == null) goto L49;
        if (r100.longValue() == 1) goto L44;
    L49:
        boolean r128 = false;
    L51:
        if (r128 == false) goto L54;
        this.f160040f--;
        this.f160039e = Long.valueOf(this.f160039e.longValue() + 1);
    L26:
        r123 = null;
    L44:
        VideoContext r129 = this.f160046l.D().d();
        if (r129 != null) goto L47;
    L50:
        r128 = true;
        goto L51
    L47:
        if (r129.t0() == true) goto L49;
        goto L49
    }

    public final void a(String r100) {
        ALogger.d(this.f160035a, " " + r100);
    }

    public final void c(int r100) {
        a("onTempWatchStateChange: " + this.f160037c.getValue() + " ->" + r100);
        this.f160037c.setValue(Integer.valueOf(r100));
        q r101 = this.f160042h;
        if (r101 == null) goto L11;
        n r102 = r101.f159414a;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r100 != 2) goto L13;
        n.c(r102, new com.bytedance.android.livesdk.vscore_api.paidlive.j.n());
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.j
    public final void i5(q r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        Integer r100 = this.f160037c.getValue();
        if (r100 != null) goto L8;
    L10:
        a("startTempWatch");
        this.f160037c.setValue(1);
        this.f160042h = r110;
        if (r110.f159423j == false) goto L19;
        if (this.f160043i != null) goto L15;
        this.f160043i = r110.f159424k;
    L15:
        m r101 = this.f160043i;
        if (r101 == null) goto L19;
        r101.k8(true);
    L19:
        if (r110.f159421h == false) goto L27;
        if (this.f160044j != null) goto L23;
        this.f160044j = r110.f159422i;
    L23:
        k r102 = this.f160044j;
        if (r102 == null) goto L27;
        r102.jb(true);
    L27:
        if (r110.f159415b == true) goto L30;
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e, "paidlive_audience_start_temp_watch", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("need_time_count", "false")}), null, this.f160046l.w0().name(), this.f160046l.i0().name(), 4, null);
        return;
    L30:
        q r103 = this.f160042h;
        if (r103 != null) goto L33;
    L49:
        if (r103 == null) goto L51;
        long r104 = r103.f159420g;
    L52:
        Long r105 = Long.valueOf(r104);
    L53:
        this.f160039e = r105;
        long r106 = r110.f159419f - r105.longValue();
        this.f160040f = r106;
        long r107 = 9;
        if (1 <= r106) goto L57;
    L59:
        this.f160040f = r106;
        if (r106 > 0) goto L62;
        Yj(null);
    L62:
        Disposable r108 = this.f160041g;
        if (r108 == null) goto L65;
        r108.dispose();
    L65:
        this.f160041g = null;
        this.f160041g = Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this), new g(this));
        if ((!Intrinsics.areEqual(this.f160045k, r110.f159418e)) == false) goto L68;
        Yj(Long.valueOf(this.f160040f));
        this.f160045k = r110.f159418e;
    L68:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e, "paidlive_audience_start_temp_watch", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("need_time_count", "true"), TuplesKt.to("cur_watch_duration", this.f160039e.toString()), TuplesKt.to("max_duration", String.valueOf(r110.f159419f)), TuplesKt.to("remain_watch_duration", String.valueOf(this.f160040f))}), null, this.f160046l.w0().name(), this.f160046l.i0().name(), 4, null);
        return;
    L57:
        if (r107 < r106) goto L59;
        r106 = 10;
        goto L59
    L51:
        r104 = 0;
        goto L52
    L33:
        if (r103.f159416c != true) goto L49;
        if (this.f160046l.l().getDebugMode().getValue().booleanValue() == false) goto L40;
        ALogger.w(this.f160035a, "debug Mode on, only use durationMap");
        HashMap r109 = (HashMap) this.f160038d.getValue();
        String r111 = r110.f159418e;
        Object r112 = r109.get(r111);
        if (r112 != null) goto L39;
        r112 = 0;
        r109.put(r111, r112);
    L39:
        long r113 = ((Number) r112).longValue();
    L48:
        r105 = Long.valueOf(r113);
        goto L53
    L40:
        q r114 = this.f160042h;
        if (r114 == null) goto L43;
        long r115 = r114.f159420g;
    L44:
        HashMap r116 = (HashMap) this.f160038d.getValue();
        String r117 = r110.f159418e;
        Object r118 = r116.get(r117);
        if (r118 != null) goto L47;
        r118 = 0;
        r116.put(r117, r118);
    L47:
        r113 = Math.max(r115, ((Number) r118).longValue());
        goto L48
    L43:
        r115 = 0;
        goto L44
    L8:
        if (r100.intValue() != 1) goto L10;
    }
}
