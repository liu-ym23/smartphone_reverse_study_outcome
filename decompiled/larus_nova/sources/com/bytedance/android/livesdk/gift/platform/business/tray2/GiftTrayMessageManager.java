package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.os.Message;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import i12.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftTrayMessageManager implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static GiftTrayMessageManager f130310r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<NormalGiftMessage> f130311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, NormalGiftMessage> f130312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<NormalGiftMessage> f130313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, NormalGiftMessage> f130314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, NormalGiftMessage> f130315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, HashSet<NormalGiftMessage>> f130316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NormalGiftMessage f130317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public NormalGiftMessage f130318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s02.c f130319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f130320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y f130321k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f130322l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f130323m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f130324n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f130325o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f130326p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f130327q;

    public static final class a {
        public static GiftTrayMessageManager a() {
            if (GiftTrayMessageManager.f130310r == null) goto L5;
        L15:
            GiftTrayMessageManager r100 = GiftTrayMessageManager.f130310r;
            Intrinsics.checkNotNull(r100);
            return r100;
        L5:
            monitor-enter(GiftTrayMessageManager.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (GiftTrayMessageManager.f130310r != null) goto L9;
            GiftTrayMessageManager.f130310r = new GiftTrayMessageManager();     // Catch: Throwable -> L12
        L9:
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(GiftTrayMessageManager.class);
            goto L15
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f130328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f130329d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f130330e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f130331f;

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final void a() {
            this.f130328c.getClass();
            this.f130329d.a();
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public void update() {
            this.f130328c.update();
            this.f130329d.update();
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final NormalGiftMessage b() {
            long r100 = SystemClock.uptimeMillis();
            NormalGiftMessage r101 = this.f130328c.b();
            long r102 = SystemClock.uptimeMillis();
            List<NormalGiftMessage> r103 = this.f130332a;
            if (r103.isEmpty() == true) goto L9;
            ArrayList r104 = new ArrayList();
            int r105 = new Random().nextInt(r103.size());
            int r106 = r103.size();
            int r107 = 0;
        L6:
            if (r107 >= r106) goto L8;
            ListProtector.add(r104, r107, ListProtector.get(r103, (r107 + r105) % r103.size()));
            r107 = r107 + 1;
            goto L6
        L8:
            r103 = r104;
        L9:
            e r108 = this.f130329d;
            r108.getClass();
            Intrinsics.checkNotNullParameter(r103, "list");
            r108.f130332a = r103;
            long r109 = SystemClock.uptimeMillis();
            NormalGiftMessage r110 = this.f130329d.b();
            long r111 = SystemClock.uptimeMillis();
            if (r110 != null) goto L12;
            d.c("getHighMessage optimize null");
        L15:
            return r101;
        L12:
            if (r110 != r101) goto L14;
            long r112 = r102 - r100;
            this.f130330e += r112;
            long r113 = r111 - r109;
            this.f130331f += r113;
            d.c("getHighMessage optimize success:" + r112 + " vs " + r113);
            d.c("getHighMessage optimize total duration:" + this.f130330e + " vs " + this.f130331f);
            goto L15
        L14:
            d.c("getHighMessage optimize fail");
            goto L15
        }

        public b(List<NormalGiftMessage> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            super(r100, r101);
            this.f130328c = new c(r100, r101);
            this.f130329d = new e(r100, r101);
        }
    }

    public static final class c extends d {
        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public void update() {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final NormalGiftMessage b() {
            CollectionsKt.sort(this.f130332a);
            return (NormalGiftMessage) CollectionsKt.first(this.f130332a);
        }

        public c(List r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            super(r100, 500);
        }

        public c(List<NormalGiftMessage> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            super(r100, r101);
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<NormalGiftMessage> f130332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f130333b;

        public abstract void a();

        public abstract NormalGiftMessage b();

        public abstract void update();

        public static void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (v.a() == false) goto L6;
            GiftTrayMessageManager r101 = GiftTrayMessageManager.f130310r;
            jy0.b.a("GiftTrayMessageManager", r100);
            return;
        }

        public d(List<NormalGiftMessage> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.f130332a = r100;
            this.f130333b = r101;
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f130334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public NormalGiftMessage f130335d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f130336e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f130337f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f130338g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f130339h;

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final void a() {
            this.f130335d = null;
            this.f130336e = 0;
            this.f130334c = 0;
            this.f130338g = 0;
            this.f130337f = 0;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public final NormalGiftMessage b() {
            if (this.f130336e <= this.f130334c) goto L7;
            NormalGiftMessage r100 = this.f130335d;
            if (r100 == null) goto L7;
        L8:
            int r101 = 1;
            if (r100 == null) goto L11;
            this.f130338g++;
        L30:
            this.f130337f++;
            StringBuilder r102 = new StringBuilder("getHighMessage cache ");
            if (r101 == 0) goto L33;
            String r103 = "success";
        L34:
            r102.append(r103);
            r102.append(" size=");
            r102.append(this.f130332a.size());
            r102.append(" rate:");
            r102.append(this.f130338g);
            r102.append('/');
            r102.append(this.f130337f);
            d.c(r102.toString());
            return r100;
        L33:
            r103 = "failed";
            goto L34
        L11:
            if (this.f130339h == true) goto L13;
        L27:
            CollectionsKt.sort(this.f130332a);
        L28:
            r100 = (NormalGiftMessage) CollectionsKt.first(this.f130332a);
            this.f130335d = r100;
            this.f130336e = SystemClock.uptimeMillis();
            r101 = 0;
            goto L30
        L13:
            if (this.f130332a.size() >= (this.f130333b - 2)) goto L27;
            List<NormalGiftMessage> r104 = this.f130332a;
            int r105 = com.bytedance.android.livesdk.gift.platform.business.tray2.a.f130359a;
            Intrinsics.checkNotNullParameter(r104, "list");
            if (r104.isEmpty() == true) goto L28;
            if (r104.size() == 1) goto L28;
            Comparable r106 = (Comparable) CollectionsKt.first(r104);
            Comparable r107 = (Comparable) CollectionsKt.first(r104);
            int r108 = r104.size();
            int r109 = 0;
        L20:
            if (r101 >= r108) goto L25;
            Comparable r110 = (Comparable) ListProtector.get(r104, r101);
            if (r110.compareTo(r106) >= 0) goto L24;
            r109 = r101;
            r106 = r110;
        L24:
            r101 = r101 + 1;
            goto L20
        L25:
            if (r109 == 0) goto L28;
            Comparable r111 = (Comparable) CollectionsKt.first(r104);
            ListProtector.set(r104, 0, r106);
            ListProtector.set(r104, r109, r111);
        L7:
            r100 = null;
            goto L8
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager.d
        public void update() {
            this.f130334c = SystemClock.uptimeMillis();
        }

        public e(List r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            super(r100, r101);
            this.f130339h = true;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    public final void c() {
        ((HashMap) this.f130312b).clear();
        ((ArrayList) this.f130311a).clear();
        ((HashMap) this.f130314d).clear();
        ((ArrayList) this.f130313c).clear();
        this.f130327q.a();
        ((LinkedHashMap) this.f130315e).clear();
        ((LinkedHashMap) this.f130316f).clear();
        this.f130320j = true;
    }

    public final NormalGiftMessage d() {
        if (((ArrayList) this.f130311a).size() <= 0) goto L6;
        CollectionsKt.sort(this.f130311a);
        return (NormalGiftMessage) CollectionsKt.first(this.f130311a);
    L6:
        if (((ArrayList) this.f130313c).size() > 0) goto L11;
        return null;
    L11:
        return this.f130327q.b();
    }

    public final int e() {
        return ((Number) com.bytedance.android.livesdk.gift.platform.business.e.f129016b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.f129015a[0])).intValue();
    }

    public final int f() {
        return ((ArrayList) this.f130311a).size() + ((ArrayList) this.f130313c).size();
    }

    public final void m() {
        if (this.f130323m == true) goto L7;
        if (this.f130324n == true) goto L7;
    L11:
        if (this.f130322l == false) goto L14;
        ALogger.d("PauseAnim", "tryConsumePriorityMessage return due to isScrolling");
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "isScrolling is true, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.e("isScrolling:true");
        return;
    L14:
        boolean r100 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        if (((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).getNeedShowGiftEffectSwitch() == true) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "needShowGiftEffectSwitch is false, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.e("needShowGiftEffectSwitch:false");
        return;
    L19:
        if (((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).getGiftTraySwitch() == true) goto L23;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "getGiftTraySwitch is false, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.e("getGiftTraySwitch:false");
        return;
    L23:
        if (((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).getGiftTraySwitch() == true) goto L27;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "needShowGiftTraySwitch is false, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.e("needShowGiftEffectSwitch:false");
        return;
    L27:
        if (this.f130323m == false) goto L30;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "isBackground  is true, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.e("isBackground:true");
        return;
    L30:
        NormalGiftMessage r101 = d();
        if (r101 == null) goto L33;
        j3 r102 = r101.D;
    L34:
        if (r102 == null) goto L42;
        j3 r103 = r101.D;
        if (r103 == null) goto L38;
        long r104 = r103.getEndTime();
    L40:
        if (r104 >= (com.bytedance.live.kmp.util.e.b() / ((long) 1000))) goto L42;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("GiftTrayMessageManager", "消息过期丢弃，message id is " + r101.f129790t.getCommonData().getMessageId() + ", isLocal is " + r101.f129792v);
        i(r101, false);
        m();
        goto L42
    L38:
        r104 = Long.MAX_VALUE;
    L42:
        if (r101 == null) goto L47;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.g(Long.valueOf(r101.f129771a), "run onConsumeMessage", GiftTrayMessageManager$tryConsumePriorityMessage$1$1.INSTANCE);
        y r105 = this.f130321k;
        if (r105 == null) goto L46;
        r105.Lc(r101);
        goto L47
    L46:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftTrayMessageManager", "mListener is null ");
    L47:
        if (r101 == null) goto L49;
        return;
    L49:
        if (f() == 0) goto L53;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "tryConsumePriorityMessage: message is null " + f());
        return;
    L53:
        return;
    L33:
        r102 = null;
    L7:
        if (LiveInfraSettingKeys.LIVE_ANIMATION_LEAK.getValue().giftTray == false) goto L11;
        ALogger.d("LiveAnimationLeak", "tryConsumePriorityMessage isBackground=" + this.f130323m + ", isClear=" + this.f130324n);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "isBackground | isClear is true, cannot consume msg");
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.e("isBackground|isClear:true");
    }

    public GiftTrayMessageManager() {
        this.f130311a = new ArrayList();
        this.f130312b = new HashMap();
        ArrayList r100 = new ArrayList();
        this.f130313c = r100;
        this.f130314d = new HashMap();
        this.f130315e = new LinkedHashMap();
        this.f130316f = new LinkedHashMap();
        this.f130320j = true;
        new WeakHandler(this);
        ReadOnlyProperty r101 = com.bytedance.android.livesdk.gift.platform.business.e.F;
        KProperty<?>[] r102 = com.bytedance.android.livesdk.gift.platform.business.e.f129015a;
        this.f130326p = ((Boolean) r101.getValue(null, r102[30])).booleanValue();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.f129017c.getValue(null, r102[1])).booleanValue() == true) goto L5;
        d r103 = new c(r100);
    L11:
        this.f130327q = r103;
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.f129022h.getValue(null, r102[6])).booleanValue() == true) goto L7;
    L9:
        r103 = new e(r100, e());
        goto L11
    L7:
        if (v.a() == false) goto L9;
        r103 = new b(r100, e());
        goto L11
    }

    public final int n() {
        NormalGiftMessage r100 = d();
        if (r100 == null) goto L66;
        NormalGiftMessage r101 = this.f130317g;
        long r102 = 0;
        if (r101 != null) goto L7;
    L12:
        Boolean r103 = null;
        if (r101 == null) goto L15;
        Boolean r104 = Boolean.valueOf(r101.f129792v);
    L16:
        NormalGiftMessage r105 = this.f130318h;
        if (r105 == null) goto L20;
        r103 = Boolean.valueOf(r105.f129792v);
    L20:
        if (Intrinsics.areEqual(r104, r103) == false) goto L48;
        NormalGiftMessage r106 = this.f130317g;
        if (r106 == null) goto L24;
        long r107 = r106.getTotalMoney();
    L25:
        NormalGiftMessage r108 = this.f130318h;
        if (r108 == null) goto L28;
        long r109 = r108.getTotalMoney();
    L30:
        if (r107 <= r109) goto L48;
    L31:
        boolean r110 = r100.f129792v;
        if (r110 == false) goto L37;
        NormalGiftMessage r111 = this.f130318h;
        if (r111 == null) goto L37;
        if (r111.f129792v == true) goto L37;
    L47:
        return 1;
    L37:
        if (r110 == true) goto L69;
        NormalGiftMessage r112 = this.f130318h;
        if (r112 != null) goto L41;
        return 0;
    L41:
        if (r112.f129792v == true) goto L71;
        long r113 = r100.getTotalMoney();
        NormalGiftMessage r114 = this.f130318h;
        if (r114 == null) goto L46;
        r102 = r114.getTotalMoney();
    L46:
        if (r113 > r102) goto L47;
        return 0;
    L71:
        return 0;
    L69:
        return 0;
    L28:
        r109 = 0;
        goto L30
    L24:
        r107 = 0;
    L48:
        boolean r115 = r100.f129792v;
        if (r115 == false) goto L54;
        NormalGiftMessage r116 = this.f130317g;
        if (r116 == null) goto L54;
        if (r116.f129792v == true) goto L54;
        return 2;
    L54:
        if (r115 == true) goto L73;
        NormalGiftMessage r117 = this.f130317g;
        if (r117 != null) goto L58;
        return 0;
    L58:
        if (r117.f129792v == true) goto L75;
        long r118 = r100.getTotalMoney();
        NormalGiftMessage r119 = this.f130317g;
        if (r119 == null) goto L63;
        r102 = r119.getTotalMoney();
    L63:
        if (r118 <= r102) goto L76;
        return 2;
    L76:
        return 0;
    L75:
        return 0;
    L73:
        return 0;
    L15:
        r104 = null;
        goto L16
    L7:
        if (r101.f129792v != true) goto L12;
        NormalGiftMessage r120 = this.f130318h;
        if (r120 == null) goto L12;
        if (r120.f129792v == false) goto L31;
    L66:
        return 0;
    }

    public static void k(NormalGiftMessage r100) {
        if (r100 != null) goto L4;
    L6:
        if (r100 == null) goto L9;
        r100.x(r100.f129783m + ((long) r100.f129784n));
        r100.f129784n = 0;
        return;
    L9:
        return;
    L4:
        if (r100.f129792v != true) goto L6;
    }

    public final void a(NormalGiftMessage r100) {
        r100.f129778h = System.currentTimeMillis();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.d(Long.valueOf(r100.f129771a), "GiftTrayMessageManager  addMessage ");
        if (r100.f129792v == false) goto L18;
        if (e() != (-1)) goto L7;
    L12:
        ((ArrayList) this.f130311a).add(r100);
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L15;
    L16:
        ((HashMap) this.f130312b).put(r100.u(), r100);
    L34:
        if (this.f130316f.containsKey(r100.v()) == true) goto L36;
        this.f130316f.put(r100.v(), new HashSet());
    L36:
        HashSet r101 = (HashSet) ((LinkedHashMap) this.f130316f).get(r100.v());
        if (r101 == null) goto L40;
        r101.add(r100);
        return;
    L40:
        return;
    L15:
        if (b02.a.b(r100) == false) goto L34;
    L7:
        if (((ArrayList) this.f130311a).size() < e()) goto L12;
        NormalGiftMessage r102 = (NormalGiftMessage) CollectionsKt.last(this.f130311a);
        if (r102.h(r100) != 1) goto L11;
        i(r102, true);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "remove one message self size:" + ((ArrayList) this.f130311a).size());
        goto L12
    L11:
        return;
    L18:
        if (this.f130325o == false) goto L21;
        return;
    L21:
        if (e() != (-1)) goto L23;
    L28:
        ((ArrayList) this.f130313c).add(r100);
        this.f130327q.update();
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L31;
    L32:
        ((HashMap) this.f130314d).put(r100.u(), r100);
        goto L34
    L31:
        if (b02.a.b(r100) == false) goto L34;
    L23:
        if (((ArrayList) this.f130313c).size() < e()) goto L28;
        NormalGiftMessage r103 = (NormalGiftMessage) CollectionsKt.last(this.f130313c);
        if (r103.h(r100) != 1) goto L27;
        i(r103, true);
        goto L28
    }

    public final void b(NormalGiftMessage r100) {
        if (r100 == null) goto L46;
        Map<String, HashSet<NormalGiftMessage>> r101 = this.f130316f;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        HashSet r103 = (HashSet) r102.get(r100.v());
        if (r103 == null) goto L47;
        Iterator r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L27;
        NormalGiftMessage r105 = (NormalGiftMessage) r104.next();
        boolean r106 = false;
        if (r105 == null) goto L20;
        if (Intrinsics.areEqual(this.f130317g, r105) == false) goto L14;
    L19:
        r106 = true;
        goto L20
    L14:
        if (Intrinsics.areEqual(this.f130318h, r105) == true) goto L19;
        Map<String, NormalGiftMessage> r107 = this.f130312b;
        HashMap r108 = (HashMap) r107;
        if (r108.containsKey(r105.u()) == true) goto L19;
        Map<String, NormalGiftMessage> r109 = this.f130314d;
        HashMap r110 = (HashMap) r109;
        if (r110.containsKey(r105.u()) == true) goto L19;
    L20:
        if (r106 == false) goto L7;
        StringBuilder r111 = new StringBuilder("can't remove since wait groupId: ");
        r111.append(r105.f129782l);
        r111.append(" + giftId: ");
        h2 r112 = r105.f129793w;
        if (r112 == null) goto L24;
        Long r113 = Long.valueOf(r112.getId());
    L25:
        r111.append(r113);
        jy0.b.a("GiftTrayMessageManager", r111.toString());
        return;
    L24:
        r113 = null;
        goto L25
    L27:
        Iterator r114 = r103.iterator();
    L29:
        if (r114.hasNext() == false) goto L33;
        NormalGiftMessage r115 = (NormalGiftMessage) r114.next();
        if (this.f130315e.containsKey(r115.u()) == false) goto L29;
        this.f130315e.remove(r115.u());
        goto L29
    L33:
        HashSet<NormalGiftMessage> r116 = this.f130316f.remove(r100.v());
        return;
    L47:
        return;
    }

    public final void g(NormalGiftMessage r110) {
        if (r110 == null) goto L150;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a r100 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e;
        r100.f132072b.d(Long.valueOf(r110.f129771a), "GiftTrayMessageManager newMessage run");
        if ((r110.f129790t instanceof o7) == true) goto L7;
    L18:
        Object r101 = null;
        if (b02.a.b(r110) == true) goto L40;
        if ((r110 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L40;
        if (r110.f129786p == false) goto L25;
        return;
    L25:
        i12.e r102 = o.b();
        if (r102 == null) goto L28;
        Object r103 = m.f163449e.d(r102, GiftDataStorageService.class);
    L29:
        GiftDataStorageService r104 = (GiftDataStorageService) r103;
        if (r104 == null) goto L32;
        r104.f131264d += r110.f129781k * r110.f129783m;
    L32:
        i12.e r105 = o.b();
        if (r105 == null) goto L35;
        r101 = m.f163449e.d(r105, GiftDataStorageService.class);
    L35:
        GiftDataStorageService r106 = (GiftDataStorageService) r101;
        if (r106 == null) goto L38;
        r106.f131263c += r110.f129781k * r110.f129783m;
    L38:
        a(r110);
        goto L150
    L28:
        r103 = null;
    L40:
        if ((r110 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == false) goto L42;
        a(r110);
        goto L150
    L42:
        List<n3> r107 = r110.F;
        if (r107 != null) goto L45;
    L48:
        boolean r108 = true;
    L49:
        if (r108 == true) goto L56;
        if (r110.f129786p == true) goto L53;
    L54:
        a(r110);
        goto L150
    L53:
        if (LiveInfraSettingKeys.FORCE_ALLOW_REPEAT_END_SHOW_TRAY.getValue().booleanValue() == false) goto L150;
    L56:
        if (r110.f129786p == true) goto L63;
        j3 r109 = r110.D;
        if (r109 == null) goto L63;
        if (r109.getEndTime() >= (com.bytedance.live.kmp.util.e.b() / ((long) 1000))) goto L63;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("GiftTrayMessageManager", "消息过期丢弃，message id is " + r110.f129790t.getCommonData().getMessageId() + ", isLocal is " + r110.f129792v);
    L63:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.H.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.f129015a[32])).booleanValue() == false) goto L107;
        NormalGiftMessage r111 = this.f130317g;
        if (r111 == null) goto L67;
        String r112 = r111.u();
    L68:
        NormalGiftMessage r113 = this.f130318h;
        if (r113 == null) goto L71;
        r101 = r113.u();
    L71:
        String r114 = r110.u();
        if (Intrinsics.areEqual(r112, r114) == false) goto L75;
        NormalGiftMessage r115 = this.f130317g;
        Intrinsics.checkNotNull(r115);
        o(r115, r110);
        goto L150
    L75:
        if (Intrinsics.areEqual(r101, r114) == false) goto L78;
        NormalGiftMessage r116 = this.f130318h;
        Intrinsics.checkNotNull(r116);
        o(r116, r110);
        goto L150
    L78:
        if (((HashMap) this.f130312b).containsKey(r114) == false) goto L83;
        NormalGiftMessage r117 = (NormalGiftMessage) ((HashMap) this.f130312b).get(r114);
        if (r117 == null) goto L150;
        o(r117, r110);
        goto L150
    L83:
        if (((HashMap) this.f130314d).containsKey(r114) == false) goto L89;
        NormalGiftMessage r118 = (NormalGiftMessage) ((HashMap) this.f130314d).get(r114);
        if (r118 == null) goto L87;
        o(r118, r110);
    L87:
        this.f130327q.update();
        goto L150
    L89:
        if (this.f130315e.containsKey(r114) == false) goto L98;
        NormalGiftMessage r119 = (NormalGiftMessage) ((LinkedHashMap) this.f130315e).get(r114);
        if (r110.f129786p == false) goto L95;
        if (r119 == null) goto L94;
        l(r119, r110);
    L94:
        this.f130315e.remove(r114);
        goto L150
    L95:
        if (r119 == null) goto L150;
        o(r119, r110);
        this.f130315e.remove(r114);
        a(r119);
        goto L150
    L98:
        if (r110.f129786p == true) goto L100;
    L106:
        a(r110);
        goto L150
    L100:
        if ((r110 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L106;
        s02.c r120 = this.f130319i;
        if (r120 == null) goto L104;
        r120.a(r110.f129775e, r110.f129787q, r110.f129772b, r110.r(), r110.f129783m);
    L104:
        r100.f132072b.f(Long.valueOf(r110.f129771a), "is IGift End");
        return;
    L67:
        r112 = null;
        goto L68
    L107:
        NormalGiftMessage r121 = this.f130317g;
        if (r121 == null) goto L110;
        String r122 = r121.u();
    L112:
        if (Intrinsics.areEqual(r122, r110.u()) == false) goto L114;
        NormalGiftMessage r123 = this.f130317g;
        Intrinsics.checkNotNull(r123);
        o(r123, r110);
        goto L150
    L114:
        NormalGiftMessage r124 = this.f130318h;
        if (r124 == null) goto L118;
        r101 = r124.u();
    L118:
        if (Intrinsics.areEqual(r101, r110.u()) == false) goto L121;
        NormalGiftMessage r125 = this.f130318h;
        Intrinsics.checkNotNull(r125);
        o(r125, r110);
        goto L150
    L121:
        if (((HashMap) this.f130312b).containsKey(r110.u()) == false) goto L126;
        NormalGiftMessage r126 = (NormalGiftMessage) ((HashMap) this.f130312b).get(r110.u());
        if (r126 == null) goto L150;
        o(r126, r110);
        goto L150
    L126:
        if (((HashMap) this.f130314d).containsKey(r110.u()) == false) goto L132;
        NormalGiftMessage r127 = (NormalGiftMessage) ((HashMap) this.f130314d).get(r110.u());
        if (r127 == null) goto L130;
        o(r127, r110);
    L130:
        this.f130327q.update();
        goto L150
    L132:
        if (this.f130315e.containsKey(r110.u()) == false) goto L141;
        NormalGiftMessage r128 = (NormalGiftMessage) ((LinkedHashMap) this.f130315e).get(r110.u());
        if (r110.f129786p == false) goto L138;
        if (r128 == null) goto L137;
        l(r128, r110);
    L137:
        this.f130315e.remove(r110.u());
        goto L150
    L138:
        if (r128 == null) goto L150;
        o(r128, r110);
        this.f130315e.remove(r110.u());
        a(r128);
        goto L150
    L141:
        if (r110.f129786p == true) goto L143;
    L149:
        a(r110);
        goto L150
    L143:
        if ((r110 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L149;
        s02.c r129 = this.f130319i;
        if (r129 == null) goto L147;
        r129.a(r110.f129775e, r110.f129787q, r110.f129772b, r110.r(), r110.f129783m);
    L147:
        r100.f132072b.f(Long.valueOf(r110.f129771a), "is IGift End");
        return;
    L110:
        r122 = null;
        goto L112
    L45:
        if (r107.isEmpty() == true) goto L48;
        r108 = false;
        goto L49
    L7:
        if (r110.r().isBannedInTray() == false) goto L18;
        if (r110.r().isBannedInChat() == false) goto L11;
        return;
    L11:
        if (r110.f129786p == true) goto L13;
        return;
    L13:
        if ((r110 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L159;
        s02.c r130 = this.f130319i;
        if (r130 == null) goto L160;
        r130.a(r110.f129775e, r110.f129787q, r110.f129772b, r110.r(), r110.f129783m);
        return;
    L160:
        return;
    L159:
        return;
    L150:
        if (r110 != null) goto L153;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "newMessage is null");
    L153:
        if (this.f130320j == false) goto L155;
        m();
        return;
    L155:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("GiftTrayMessageManager", "mHasIdleTray is false,skip.. queue size:" + f());
    }

    public final void h(gm2.d r100) {
        GiftContext r101 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.i<k> r102 = r101.getMessageDispatcher();
        if (r102 == null) goto L9;
        k r103 = r102.getValue();
        if (r103 == null) goto L9;
        NormalGiftMessage r104 = r103.a(r100);
    L10:
        g(r104);
        return;
    L9:
        r104 = null;
        goto L10
    }

    public final void j(NormalGiftMessage r100) {
        if (Intrinsics.areEqual(this.f130318h, r100) == false) goto L6;
        this.f130318h = null;
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L15;
        if (b02.a.b(r100) == true) goto L15;
        return;
    L15:
        if (r100.f129784n != 0) goto L29;
        if (r100.f129786p == false) goto L19;
    L27:
        b(r100);
        return;
    L19:
        if (this.f130315e.size() <= e()) goto L23;
        if (((Boolean) nz1.a.P.getValue(null, nz1.a.f521324a[40])).booleanValue() == true) goto L27;
    L23:
        if (r100.P == true) goto L25;
    L26:
        this.f130315e.put(r100.u(), r100);
        goto L27
    L25:
        if (r100.Q == true) goto L27;
    L29:
        if (r100.P == false) goto L34;
        if (r100.Q == false) goto L34;
        return;
    L34:
        if (r100.f129792v == false) goto L36;
        ((ArrayList) this.f130311a).add(r100);
        Map<String, NormalGiftMessage> r101 = this.f130312b;
        HashMap r102 = (HashMap) r101;
        r102.put(r100.u(), r100);
        return;
    L36:
        ((ArrayList) this.f130313c).add(r100);
        Map<String, NormalGiftMessage> r103 = this.f130314d;
        HashMap r104 = (HashMap) r103;
        r104.put(r100.u(), r100);
        this.f130327q.update();
        return;
    L6:
        if (Intrinsics.areEqual(this.f130317g, r100) == false) goto L8;
        this.f130317g = null;
        goto L8
    }

    public final void i(NormalGiftMessage r100, boolean r101) {
        if (r100 == null) goto L29;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.d(Long.valueOf(r100.f129771a), "removeOneMessage");
        if (r101 == false) goto L18;
        if (this.f130326p == false) goto L18;
        int r102 = ((ArrayList) this.f130311a).lastIndexOf(r100);
        if (r102 != (-1)) goto L10;
    L12:
        int r103 = ((ArrayList) this.f130313c).lastIndexOf(r100);
        if (r103 != (-1)) goto L15;
    L23:
        Map<String, NormalGiftMessage> r104 = this.f130312b;
        HashMap r105 = (HashMap) r104;
        if (r105.containsKey(r100.u()) == false) goto L26;
        Map<String, NormalGiftMessage> r106 = this.f130312b;
        HashMap r107 = (HashMap) r106;
        r107.remove(r100.u());
    L26:
        Map<String, NormalGiftMessage> r108 = this.f130314d;
        HashMap r109 = (HashMap) r108;
        if (r109.containsKey(r100.u()) == false) goto L29;
        Map<String, NormalGiftMessage> r110 = this.f130314d;
        HashMap r111 = (HashMap) r110;
        r111.remove(r100.u());
        goto L29
    L15:
        if (r103 >= ((ArrayList) this.f130313c).size()) goto L23;
        ListProtector.remove(this.f130313c, r103);
        this.f130327q.update();
        goto L23
    L10:
        if (r102 >= ((ArrayList) this.f130311a).size()) goto L12;
        ListProtector.remove(this.f130311a, r102);
    L18:
        if (((ArrayList) this.f130311a).contains(r100) == false) goto L21;
        ((ArrayList) this.f130311a).remove(r100);
    L21:
        if (((ArrayList) this.f130313c).contains(r100) == false) goto L23;
        ((ArrayList) this.f130313c).remove(r100);
        this.f130327q.update();
    L29:
        b(r100);
    }

    public final void l(NormalGiftMessage r110, NormalGiftMessage r111) {
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.f(Long.valueOf(r111.f129771a), "tag end");
        r110.f129786p = true;
        r110.f129787q = r111.f129787q;
        HashSet r100 = (HashSet) ((LinkedHashMap) this.f130316f).get(r111.v());
        if (r100 == null) goto L8;
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((NormalGiftMessage) r101.next()).f129786p = true;
    L8:
        b(r110);
        i12.e r102 = o.b();
        if (r102 == null) goto L11;
        Object r103 = m.f163449e.d(r102, GiftDataStorageService.class);
    L12:
        GiftDataStorageService r104 = (GiftDataStorageService) r103;
        if (r104 == null) goto L16;
        r104.f131263c += r111.f129781k * r111.f129783m;
    L16:
        if ((r111 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L25;
        s02.c r105 = this.f130319i;
        if (r105 == null) goto L21;
        r105.a(r111.f129775e, r111.f129787q, r111.f129772b, r111.r(), r111.f129783m);
    L21:
        if (r110.f129792v == false) goto L26;
        d0.m(r111);
        return;
    L26:
        return;
    L25:
        return;
    L11:
        r103 = null;
        goto L12
    }

    public final void o(NormalGiftMessage r100, NormalGiftMessage r101) {
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132072b.f(Long.valueOf(r101.f129771a), "GiftTrayMessageManager  updateMessage ");
        r100.f129778h = System.currentTimeMillis();
        boolean r102 = r100.f129786p;
        if (r102 == true) goto L5;
    L7:
        if (r102 == false) goto L9;
    L11:
        if (r102 == false) goto L13;
        return;
    L13:
        if (r101.f129786p == true) goto L27;
        r100.r().setTrayInfo(r101.r().getTrayInfo());
        if (Intrinsics.areEqual(r100, this.f130317g) == false) goto L17;
    L22:
        r100.w(r101);
        return;
    L17:
        if (Intrinsics.areEqual(r100, this.f130318h) == true) goto L22;
        if (r100.f129792v == true) goto L22;
        r100.x(r100.f129783m + ((long) r100.f129784n));
        r100.f129784n = 0;
        r100.w(r101);
        return;
    L27:
        return;
    L9:
        if (r101.f129786p == false) goto L11;
        l(r100, r101);
        return;
    L5:
        if (r101.f129786p == true) goto L7;
        r100.f129786p = false;
        r100.f129787q = "";
        r100.w(r101);
    }
}
