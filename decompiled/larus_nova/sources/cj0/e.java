package cj0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements rj0.h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f23907h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f23908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f23911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<rj0.h.a> f23912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ILinkPlayerInfoBridge f23913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f23914g;

    public static final class a {
        public static rj0.h a() {
            m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r100 == null) goto L15;
            IRoom r101 = r100.getValue();
            if (r101 == null) goto L15;
            if (r101.isLiveTypeAudio() != true) goto L15;
            com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
            com.bytedance.android.live.liveinteract.voicechat.d r102 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
            if (r102 == null) goto L12;
            rj0.h r103 = r102.videoStylePaidLinkManager();
            if (r103 == null) goto L12;
            return r103;
        L12:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r104 = IVoiceChatGuestService.a.a();
            if (r104 != null) goto L25;
        L22:
            return null;
        L25:
            return r104.videoStylePaidLinkManager();
        L15:
            rj0.k.f537953m2.getClass();
            rj0.k r105 = rj0.k.a.a();
            if (r105 == null) goto L19;
            e r106 = r105.paidLinkManager();
            if (r106 == null) goto L19;
            return r106;
        L19:
            rj0.l.f537955n2.getClass();
            rj0.l r107 = rj0.l.a.a();
            if (r107 == null) goto L22;
            return r107.paidLinkManager();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f23915a;

        public b(e r100) {
            this.f23915a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r111 = (Long) r110;
            e r112 = this.f23915a;
            if (r112.f23914g == false) goto L5;
        L17:
            e r113 = this.f23915a;
            Iterator r100 = ((HashMap) r113.f23911d).entrySet().iterator();
            boolean r101 = false;
        L19:
            if (r100.hasNext() == false) goto L27;
            Map.Entry r102 = (Map.Entry) r100.next();
            if (((Number) r102.getValue()).longValue() >= 1000) goto L22;
            if (((Number) r102.getValue()).longValue() <= 0) goto L19;
            r102.setValue(0L);
        L26:
            r101 = true;
            goto L19
        L22:
            r102.setValue(Long.valueOf(((Number) r102.getValue()).longValue() - 1000));
            goto L26
        L27:
            if (r101 == false) goto L32;
            Iterator<rj0.h.a> r103 = r113.f23912e.iterator();
        L30:
            if (r103.hasNext() == false) goto L41;
            r103.next().v3(r113.f23911d);
            goto L30
        L41:
            return;
        L32:
            return;
        L5:
            if (r112.j() == false) goto L17;
            if (r112.f23909b == 0) goto L17;
            long r104 = r112.f23910c;
            if (r104 > 0) goto L12;
            ALogger.e("ttlive_link_paid", "selfRemainingTime=" + r112.f23910c + " invalid");
            goto L17
        L12:
            r112.f23910c = r104 - 1000;
            Iterator<rj0.h.a> r105 = r112.f23912e.iterator();
        L14:
            if (r105.hasNext() == false) goto L16;
            r105.next().B0(r112.f23910c);
            goto L14
        L16:
            r112.h(true, null);
            goto L17
        }
    }

    static {
    }

    @Override // rj0.h
    public final void d() {
        this.f23913f = null;
    }

    @Override // rj0.h
    public final boolean b() {
        if (this.f23909b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g() {
        com.bytedance.android.live.core.utils.rxutils.j.a r100 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        this.f23908a = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
    }

    public final void i() {
        Disposable r100 = this.f23908a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f23912e.clear();
    }

    public final boolean j() {
        if (this.f23914g == false) goto L6;
        return false;
    L6:
        if (hd0.c.f().h() == true) goto L11;
        rj0.l.f537955n2.getClass();
        rj0.l r100 = rj0.l.a.a();
        if (r100 != null) goto L10;
        return false;
    L10:
        if (r100.isEngineOn() == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // rj0.h
    public final long a() {
        return this.f23910c;
    }

    @Override // rj0.h
    public final Map<String, Long> c() {
        return this.f23911d;
    }

    public e(boolean r100) {
        this.f23914g = r100;
        this.f23911d = new HashMap();
        this.f23912e = new CopyOnWriteArrayList();
    }

    @Override // rj0.h
    public final void e(rj0.h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f23912e.add(r100);
    }

    @Override // rj0.h
    public final void f(rj0.h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f23912e.remove(r100);
    }

    public final void k(List<? extends ILinkPlayerInfoBridge> r110) {
        Intrinsics.checkNotNullParameter(r110, "list");
        if (j() == false) goto L28;
        Iterator<T> r100 = r110.iterator();
    L6:
        Object r101 = null;
        if (r100.hasNext() == false) goto L14;
        Object r102 = r100.next();
        IBaseUser r103 = ((ILinkPlayerInfoBridge) r102).getUser();
        if (r103 == null) goto L12;
        r101 = r103.getIdString();
    L12:
        if (Intrinsics.areEqual(r101, je0.d.b0()) == false) goto L6;
        r101 = r102;
    L14:
        ILinkPlayerInfoBridge r104 = (ILinkPlayerInfoBridge) r101;
        if (r104 == null) goto L28;
        long r105 = r104.getExpectLeaveTime();
        this.f23909b = r105;
        if (r105 == 0) goto L28;
        long r106 = fj0.e.m(r104);
        long r111 = 1000;
        long r112 = (r105 - r106) * r111;
        this.f23910c = r112;
        if (r112 > 0) goto L23;
        this.f23910c = 0;
    L23:
        Iterator<rj0.h.a> r107 = this.f23912e.iterator();
    L25:
        if (r107.hasNext() == false) goto L27;
        r107.next().B0(this.f23910c);
        goto L25
    L27:
        h(false, Long.valueOf(r106));
        ALogger.e("ttlive_link_paid", "onlineListChange selfRemainingTime=" + (this.f23910c / r111) + "s  selfExpectLeaveTime=" + r105);
    L28:
        HashMap r108 = new HashMap();
        Iterator<T> r109 = r110.iterator();
    L30:
        if (r109.hasNext() == false) goto L41;
        ILinkPlayerInfoBridge r113 = (ILinkPlayerInfoBridge) r109.next();
        IBaseUser r114 = r113.getUser();
        if (r114 == null) goto L30;
        String r115 = r114.getIdString();
        if (r115 == null) goto L30;
        long r116 = r113.getExpectLeaveTime();
        long r117 = fj0.e.m(r113);
        if (r116 == 0) goto L30;
        long r118 = (r116 - r117) * ((long) 1000);
        if (r118 > 0) goto L40;
        r118 = 0;
    L40:
        r108.put(r115, Long.valueOf(r118));
        goto L30
    L41:
        Iterator r119 = r108.entrySet().iterator();
    L43:
        if (r119.hasNext() == false) goto L45;
        Map.Entry r120 = (Map.Entry) r119.next();
        ALogger.i("ttlive_link_paid", "updateCountDown uid=" + ((String) r120.getKey()) + " remaining=" + ((Number) r120.getValue()).longValue());
        goto L43
    L45:
        ((HashMap) this.f23911d).clear();
        ((HashMap) this.f23911d).putAll(r108);
        Iterator<rj0.h.a> r121 = this.f23912e.iterator();
    L47:
        if (r121.hasNext() == false) goto L49;
        r121.next().v3(this.f23911d);
        goto L47
    }

    public final void h(boolean r100, Long r101) {
        long r102 = this.f23910c;
        if (r102 >= 1000) goto L16;
        if (r100 == false) goto L6;
        int r103 = fj0.d.f477462a;
        fj0.d.b(r102, this.f23909b);
    L8:
        if (je0.d.A() == false) goto L12;
        rj0.l.f537955n2.getClass();
        rj0.l r104 = rj0.l.a.a();
        if (r104 == null) goto L17;
        rj0.l.b.d(r104, 203, true, true, 8);
        return;
    L17:
        return;
    L12:
        rj0.l.f537955n2.getClass();
        rj0.l r105 = rj0.l.a.a();
        if (r105 == null) goto L19;
        rj0.l.b.d(r105, 203, true, false, 8);
        return;
    L19:
        return;
    L6:
        int r106 = fj0.d.f477462a;
        fj0.d.a(r102, this.f23909b, r101);
        goto L8
    }
}
