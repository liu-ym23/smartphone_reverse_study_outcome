package android.ss.com.vboost.i;

import android.content.Context;
import android.ss.com.vboost.CapabilityScheduler;
import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.Status;
import android.ss.com.vboost.VboostListener;
import android.ss.com.vboost.utils.LogUtil;
import android.ss.com.vboost.utils.RomUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f4684e = "c";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static android.ss.com.vboost.utils.c<Context> f4685f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RomUtils.a f4686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f4687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f4688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.ss.com.vboost.utils.c<List<VboostListener.SystemListener>> f4689d;

    public static class a extends android.ss.com.vboost.utils.c<Context> {
        public a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public Context initialValue() {
            if (CapabilityScheduler.getInitialConfigProvider() == null) goto L6;
            LogUtil.info(c.c(), "register context.");
            return CapabilityScheduler.getInitialConfigProvider().getContext();
        L6:
            return null;
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ Context initialValue() {
            return initialValue();
        }
    }

    public class b extends android.ss.com.vboost.utils.c<List<VboostListener.SystemListener>> {
        public b(c r100) {
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ List<VboostListener.SystemListener> initialValue() {
            return initialValue2();
        }

        @Override // android.ss.com.vboost.utils.c
        /* JADX INFO: renamed from: initialValue, reason: avoid collision after fix types in other method */
        public List<VboostListener.SystemListener> initialValue2() {
            ArrayList r100 = new ArrayList();
            if (CapabilityScheduler.getInitialConfigProvider() != null) goto L5;
        L7:
            return r100;
        L5:
            if (CapabilityScheduler.getInitialConfigProvider().getSystemListener() == null) goto L7;
            r100.add(CapabilityScheduler.getInitialConfigProvider().getSystemListener());
            goto L7
        }
    }

    /* JADX INFO: renamed from: android.ss.com.vboost.i.c$c, reason: collision with other inner class name */
    public static /* synthetic */ class C0092c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4690a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4691b = null;

        static {
            int[] r100 = new int[CapabilityType.values().length];
            f4691b = r100;
            r100[CapabilityType.CPU_FREQ_MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L66:
            f4691b[CapabilityType.GPU_FREQ_MAX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L50:
            f4691b[CapabilityType.BUS_FREQ_MAX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L62:
            f4691b[CapabilityType.UFS_FREQ_MAX.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L68:
            f4691b[CapabilityType.CPU_FREQ_MIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L52:
            f4691b[CapabilityType.GPU_FREQ_MIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L54:
            f4691b[CapabilityType.BUS_FREQ_MIN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L76:
            f4691b[CapabilityType.UFS_FREQ_MIN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L44:
            f4691b[CapabilityType.CPU_AFFINITY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L34
        L70:
            f4691b[CapabilityType.TASK_PRIORITY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L35
        L74:
            f4691b[CapabilityType.PRESET_SCENE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L36
        L58:
            f4691b[CapabilityType.THUMB_FETCH.ordinal()] = 12;     // Catch: NoSuchFieldError -> L37
        L64:
            f4691b[CapabilityType.VIBRATE_ENHANCE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L38
        L48:
            f4691b[CapabilityType.NETWORK_ENHANCE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L39
        L20:
            int[] r101 = new int[RomUtils.a.values().length];
            f4690a = r101;
            r101[RomUtils.a.f4775b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L78:
            f4690a[RomUtils.a.f4776c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L46:
            f4690a[RomUtils.a.f4778e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L56:
            f4690a[RomUtils.a.f4779f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
            return;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f4692a = null;

        static {
            f4692a = new c(null);
        }

        public static /* synthetic */ c a() {
            return f4692a;
        }
    }

    static {
        f4685f = new a();
    }

    private c() {
        this.f4686a = RomUtils.a.f4774a;
        this.f4689d = new b(this);
        this.f4686a = RomUtils.getRomType();
        if (this.f4687b != null) goto L18;
        String r100 = f4684e;
        LogUtil.info(r100, "create " + this.f4686a + " provider.");
        int r101 = C0092c.f4690a[this.f4686a.ordinal()];
        if (r101 != 1) goto L7;
        h r102 = l.a(f4685f.get());
    L17:
        this.f4687b = r102;
        goto L18
    L7:
        if (r101 != 2) goto L9;
        r102 = android.ss.com.vboost.i.b.a(f4685f.get());
        goto L17
    L9:
        if (r101 != 3) goto L11;
        r102 = e.a(f4685f.get());
        goto L17
    L11:
        if (r101 == 4) goto L13;
        LogUtil.warn(r100, "Not implement provider of this device " + this.f4686a + "!");
        goto L18
    L13:
        r102 = m.a(f4685f.get());
    L18:
        this.f4688c = new f(f4685f.get());
    }

    public /* synthetic */ c(a r100) {
        this();
    }

    public static void a(Context r100) {
        f4685f.set(r100);
        e();
    }

    public static /* synthetic */ String c() {
        return f4684e;
    }

    public static Context d() {
        return f4685f.get();
    }

    private i d(android.ss.com.vboost.request.d r110) {
        i r100 = new i(r110.f4738a);
        r110.f4757t = r100;
        switch(C0092c.f4691b[r100.f4708a.ordinal()]) {
            case 1: goto L56;
            case 2: goto L56;
            case 3: goto L56;
            case 4: goto L56;
            case 5: goto L56;
            case 6: goto L56;
            case 7: goto L56;
            case 8: goto L56;
            case 9: goto L48;
            case 10: goto L38;
            case 11: goto L26;
            case 12: goto L18;
            case 13: goto L10;
            case 14: goto L6;
            default: goto L4;
        };
    L4:
        return null;
    L38:
        k r101 = k.a();
        g r102 = g.f4706b;
        android.ss.com.vboost.i.d r103 = (android.ss.com.vboost.i.d) r101.a(r102, r100.f4708a).get(r110.f4739b);
        if (r103 != null) goto L42;
        LogUtil.warn(f4684e, "No level regulation set！！！");
        return null;
    L42:
        r100.f4715h = r110.f4741d;
        r100.f4710c = r103.f4694a;
        if (r103.f4695b != r102) goto L45;
        h r111 = this.f4688c;
    L46:
        r100.f4709b = r111;
        return r100;
    L45:
        r111 = this.f4687b;
        goto L46
    L48:
        r100.f4715h = r110.f4741d;
        r100.f4714g = r110.f4743f;
        h r104 = this.f4687b;
        if (r104 != null) goto L51;
    L53:
        h r112 = this.f4688c;
    L54:
        r100.f4709b = r112;
        return r100;
    L51:
        if (r104.a(r110.f4738a) == false) goto L53;
        r112 = this.f4687b;
        goto L54
    L56:
        h r105 = this.f4687b;
        if (r105 != null) goto L59;
    L85:
        h r106 = this.f4687b;
        if (r106 == null) goto L97;
        if (r106.a(r110.f4738a) == false) goto L97;
        r100.f4709b = this.f4687b;
        android.ss.com.vboost.i.d r107 = (android.ss.com.vboost.i.d) k.a().a(g.f4705a, r100.f4708a).get(r110.f4739b);
        if (r107 != null) goto L93;
        LogUtil.warn(f4684e, "No level regulation set！！！");
        return null;
    L93:
        long r108 = r110.f4740c;
        int r113 = r107.f4696c;
        if (r108 > r113) goto L104;
    L105:
        r100.f4713f = r108;
        r100.f4710c = r107.f4694a;
    L106:
        return r100;
    L104:
        r108 = r113;
    L97:
        if (this.f4688c.a(r110.f4738a) == false) goto L107;
        r100.f4709b = this.f4688c;
        r107 = (android.ss.com.vboost.i.d) k.a().a(g.f4706b, r100.f4708a).get(r110.f4739b);
        if (r107 != null) goto L102;
        LogUtil.warn(f4684e, "No level regulation set！！！");
        return null;
    L102:
        r108 = r110.f4740c;
        r113 = r107.f4696c;
        if (r108 <= r113) goto L105;
    L107:
        LogUtil.warn(f4684e, "No provider support this capability!!!");
        return null;
    L59:
        if (r105.a(r100.f4708a) == false) goto L85;
        if (this.f4688c.a(r100.f4708a) == false) goto L85;
        k r109 = k.a();
        g r114 = g.f4705a;
        android.ss.com.vboost.i.d r115 = (android.ss.com.vboost.i.d) r109.a(r114, r100.f4708a).get(r110.f4739b);
        if (r115 != null) goto L66;
        LogUtil.warn(f4684e, "No level regulation set！！！");
        return null;
    L66:
        long r116 = r110.f4740c;
        if (r116 > r115.f4696c) goto L69;
        r100.f4713f = r116;
        r100.f4710c = r115.f4694a;
        if (r115.f4695b != g.f4706b) goto L83;
    L82:
        h r117 = this.f4688c;
    L84:
        r100.f4709b = r117;
    L83:
        r117 = this.f4687b;
        goto L84
    L69:
        if (r115.a(r110.f4739b, (int) r116) == false) goto L77;
        android.ss.com.vboost.i.d r118 = (android.ss.com.vboost.i.d) k.a().a(r114, r100.f4708a).get(r115.f4697d);
        if (r118 != null) goto L74;
        LogUtil.warn(f4684e, "Fallback level regulation is not set！！！");
        return null;
    L74:
        r100.f4713f = r110.f4740c;
        r100.f4710c = r118.f4694a;
        if (r118.f4695b != g.f4706b) goto L83;
    L77:
        r100.f4710c = r115.f4694a;
        r100.f4713f = r115.f4696c;
        if (r115.f4695b != g.f4706b) goto L83;
    L6:
        if (this.f4687b.a(r100.f4708a) == false) goto L8;
        r100.f4709b = this.f4687b;
    L8:
        return r100;
    L10:
        if (this.f4688c.a(r100.f4708a) == false) goto L14;
        r100.f4712e = r110.f4745h;
        h r119 = this.f4688c;
    L12:
        r100.f4709b = r119;
    L16:
        return r100;
    L14:
        if (this.f4687b.a(r100.f4708a) == false) goto L16;
        r119 = this.f4687b;
        goto L12
    L18:
        if (this.f4688c.a(r100.f4708a) == false) goto L22;
        h r120 = this.f4688c;
    L20:
        r100.f4709b = r120;
    L24:
        return r100;
    L22:
        if (this.f4687b.a(r100.f4708a) == false) goto L24;
        r120 = this.f4687b;
        goto L20
    L26:
        if (this.f4688c.a(r100.f4708a) == false) goto L30;
        h r121 = this.f4688c;
    L28:
        r100.f4709b = r121;
    L32:
        j r122 = new j(r110.f4744g);
        r100.f4711d = r122;
        if (r110.f4747j == false) goto L35;
        Status r123 = Status.END;
    L36:
        r122.f4717b = r123;
        return r100;
    L35:
        r123 = Status.BEGIN;
        goto L36
    L30:
        if (this.f4687b.a(r100.f4708a) == false) goto L32;
        r121 = this.f4687b;
        goto L28
    }

    public static c e() {
        if (f4685f.get() != null) goto L7;
        LogUtil.warn(f4684e, "Some provider must inject a application context!!!");
        return null;
    L7:
        return d.a();
    }

    public Set<CapabilityType> a() {
        return ((android.ss.com.vboost.i.a) this.f4688c).a();
    }

    public void a(VboostListener.SystemListener r100) {
        this.f4689d.get().add(r100);
    }

    public boolean a(CapabilityType r100) {
        LogUtil.debug(f4684e, "name:" + r100.getName() + "  index:" + r100.getIndex());
        return ((android.ss.com.vboost.i.a) this.f4688c).b(r100);
    }

    public boolean a(android.ss.com.vboost.request.d r100) {
        h r101 = this.f4687b;
        if (r101 == null) goto L7;
        if (r101.a(r100.f4738a) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.f4688c.a(r100.f4738a) == true) goto L8;
        return false;
    }

    public Object b(android.ss.com.vboost.request.d r100) {
        i r101 = d(r100);
        if (r101 == null) goto L8;
        h r102 = r101.f4709b;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.b(r101);
    L8:
        return null;
    }

    public void b() {
        if (android.ss.com.vboost.utils.a.a() == false) goto L23;
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L18
        r100.put(Constants.OperatorKey.KEY_VENDOR, this.f4686a.name());     // Catch: JSONException -> L18
        if (this.f4687b == null) goto L11;
        boolean r101 = true;
    L12:
        r100.put("vendorInit", r101);     // Catch: JSONException -> L18
        r100.put("platform", android.ss.com.vboost.h.d.a().name());     // Catch: JSONException -> L18
        r100.put("platformInit", android.ss.com.vboost.h.d.b());     // Catch: JSONException -> L18
        android.ss.com.vboost.utils.a.a("vboost_event_launch", r100, "behavior");     // Catch: JSONException -> L18
        return;
    L11:
        r101 = false;
    L18:
        e = move-exception;
        LogUtil.error(f4684e, e.getMessage());
        return;
    }

    public void b(VboostListener.SystemListener r100) {
        this.f4689d.get().remove(r100);
        Iterator<VboostListener.SystemListener> r101 = this.f4689d.get().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r100 != r101.next()) goto L4;
        r101.remove();
        goto L4
    }

    public Object c(android.ss.com.vboost.request.d r100) {
        if (r100.f4747j == false) goto L5;
        i r101 = r100.f4757t;
    L6:
        if (r101 == null) goto L14;
        h r102 = r101.f4709b;
        if (r102 == null) goto L16;
        j r103 = r101.f4711d;
        if (r103 == null) goto L13;
        r103.f4717b = Status.END;
    L13:
        return r102.a(r101);
    L16:
        return null;
    L14:
        return null;
    L5:
        r101 = d(r100);
        goto L6
    }
}
