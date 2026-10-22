package x6;

import android.content.Context;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b extends u6.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f25438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z6.d f25439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f25440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f25441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f25442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z6.f f25443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f25444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z6.b f25445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f25446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f25447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map f25448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public z6.e f25449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public x6.a f25450p;

    public class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25451a;

        public a(b r10) {
            this.f25451a = r10;
        }

        public int a(f r10, f r11) {
            return (int) (r11.d() - r10.d());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((f) r10, (f) r11);
        }
    }

    public b(Context r10, IAssistStat r11) {
        super(r10, r11);
        this.f25437c = false;
        this.f25438d = 0;
        this.f25439e = new z6.d();
        this.f25440f = new e();
        this.f25441g = new HashMap();
        this.f25442h = new HashMap();
        this.f25443i = new z6.f();
        this.f25444j = new c();
        this.f25445k = new z6.b();
        this.f25446l = new d();
        this.f25447m = new HashMap();
        this.f25448n = new HashMap();
        this.f25449o = new z6.e();
        this.f25450p = new x6.a();
    }

    public void A(long r13) {
        c r10 = (c) this.f25443i.b();
        d r11 = (d) this.f25445k.b();
        if (r10 == null) goto L52;
        if (r11 == null) goto L53;
        r10.calculateDelta(this.f25444j);
        if (this.f24887b.getConfig().f() == false) goto L10;
        r10.a(this.f25444j);
    L10:
        if (this.f24887b.getConfig().g() == false) goto L12;
        x6.a r12 = (x6.a) this.f25449o.b();
        r12.calculateDelta(this.f25450p);
        r12.a(this.f25450p);
        a7.a.a("current cpu idle stat : " + r12);
        this.f25450p = r12;
        r10.j(r12.c());
        a7.a.a("current cpu usage stat : " + r10);
    L12:
        long r14 = r10.c();
        long r15 = r13 - this.f25438d;
        r11.calculateDelta(this.f25446l);
        r11.i(r14);
        r11.g(r15);
        if (this.f24887b.getConfig().h() == false) goto L38;
        ArrayList r16 = a7.b.c();
        HashSet r17 = new HashSet();
        Iterator r18 = r16.iterator();
    L16:
        if (r18.hasNext() == false) goto L24;
        Long r19 = (Long) r18.next();
        long r20 = r19.longValue();
        z6.c r110 = (z6.c) this.f25447m.get(r19);
        if (r110 != null) goto L20;
        r110 = new z6.c(r20);
        this.f25447m.put(r19, r110);
    L20:
        f r111 = (f) r110.b();
        if (r111 == null) goto L22;
        r111.calculateDelta((f) this.f25448n.get(r19));
        r111.i(r14);
        r111.g(r15);
        this.f25448n.put(r19, r111);
        a7.a.a("current tid stat : " + r111);
        goto L16
    L22:
        r17.add(r19);
        a7.a.a("dead tid found from refresh thread usage: " + r20);
        goto L16
    L24:
        Set r112 = this.f25447m.keySet();
        if (r112 != null) goto L27;
    L34:
        Iterator r113 = r17.iterator();
    L36:
        if (r113.hasNext() == false) goto L38;
        Long r114 = (Long) r113.next();
        r114.longValue();
        this.f25447m.remove(r114);
        this.f25448n.remove(r114);
        goto L36
    L27:
        if (r112.isEmpty() == true) goto L34;
        Iterator r115 = r112.iterator();
    L30:
        if (r115.hasNext() == false) goto L34;
        Long r116 = (Long) r115.next();
        if (r16.contains(r116) == true) goto L30;
        r17.add(r116);
        a7.a.a("dead tid found from compare last thread usage: " + r116);
    L38:
        this.f25444j = r10;
        this.f25446l = r11;
        return;
    L53:
        return;
    }

    @Override // u6.b
    public void a() {
        if (this.f25437c == false) goto L6;
        this.f25437c = false;
        c();
        return;
    }

    @Override // u6.b
    public void b() {
        if (this.f25437c == true) goto L6;
        this.f25437c = true;
        y();
        return;
    }

    public final void c() {
        this.f25440f.i();
        this.f25441g.clear();
        this.f25442h.clear();
        this.f25444j.i();
        this.f25446l.f();
        this.f25447m.clear();
        this.f25448n.clear();
        this.f25450p.g();
    }

    public final List d(List r21, long r22) {
        if (r21 == null) goto L27;
        long r10 = 0;
        if (r22 <= 0) goto L37;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r21.iterator();
    L9:
        if (r12.hasNext() == false) goto L26;
        LinkedHashMap r13 = (LinkedHashMap) r12.next();
        ArrayList r14 = new ArrayList();
        int r15 = r13.size() / 4;
        Iterator r16 = r13.entrySet().iterator();
        int r17 = 0;
        long r18 = r10;
        long r19 = r18;
        int r110 = 0;
    L12:
        if (r16.hasNext() == false) goto L25;
        Map.Entry r111 = (Map.Entry) r16.next();
        Long r112 = (Long) r111.getKey();
        Long r113 = (Long) r111.getValue();
        if (r112 == null) goto L12;
        if (r113 == null) goto L12;
        r19 = r19 + r113.longValue();
        if (r17 >= 3) goto L23;
        if (r110 >= r15) goto L22;
        r18 = r18 + r113.longValue();
        r110 = r110 + 1;
        goto L12
    L22:
        r14.add(Integer.valueOf((int) ((r18 / r22) * 100.0d)));
        r18 = r113.longValue();
        r17 = r17 + 1;
        r110 = 1;
        goto L12
    L23:
        if (r17 != 3) goto L12;
        r18 = r18 + r113.longValue();
        goto L12
    L25:
        double r20 = r22;
        r14.add(Integer.valueOf((int) ((r18 / r20) * 100.0d)));
        r14.add(Integer.valueOf((int) ((r19 / r20) * 100.0d)));
        r11.add(r14);
        r10 = 0;
        goto L9
    L26:
        return r11;
    L37:
        return null;
    L27:
        return null;
    }

    public final IAssistStat.c e(List r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        boolean r10 = w(r11.size());
        boolean r12 = x(r11.size());
        IAssistStat.c r13 = new IAssistStat.c();
        Iterator r14 = r11.iterator();
        int r15 = 0;
    L7:
        if (r14.hasNext() == false) goto L26;
        List r16 = (List) r14.next();
        if (r16 == null) goto L7;
        if (r16.size() < 5) goto L7;
        if (r15 != 0) goto L16;
        r13.f8223a = ((Integer) r16.get(0)).intValue();
        r13.f8224b = ((Integer) r16.get(1)).intValue();
        r13.f8225c = ((Integer) r16.get(2)).intValue();
        r13.f8226d = ((Integer) r16.get(3)).intValue();
        float r17 = ((Integer) r16.get(4)).intValue();
        r13.f8223a = r17;
        r13.f8227e = r17;
    L16:
        if (r15 != 1) goto L19;
        if (r12 == false) goto L19;
        r13.f8228f = ((Integer) r16.get(0)).intValue();
        r13.f8229g = ((Integer) r16.get(1)).intValue();
        r13.f8230h = ((Integer) r16.get(2)).intValue();
        r13.f8231i = ((Integer) r16.get(3)).intValue();
        r13.f8232j = ((Integer) r16.get(4)).intValue();
    L19:
        if (r15 != 1) goto L22;
        if (r10 == false) goto L22;
        r13.f8228f = 0.0f;
        r13.f8229g = 0.0f;
        r13.f8230h = 0.0f;
        r13.f8231i = 0.0f;
        r13.f8232j = 0.0f;
        r13.f8233k = ((Integer) r16.get(0)).intValue();
        r13.f8234l = ((Integer) r16.get(1)).intValue();
        r13.f8235m = ((Integer) r16.get(2)).intValue();
        r13.f8236n = ((Integer) r16.get(3)).intValue();
        r13.f8237o = ((Integer) r16.get(4)).intValue();
    L22:
        if (r15 != 2) goto L25;
        if (r12 == false) goto L25;
        r13.f8233k = ((Integer) r16.get(0)).intValue();
        r13.f8234l = ((Integer) r16.get(1)).intValue();
        r13.f8235m = ((Integer) r16.get(2)).intValue();
        r13.f8236n = ((Integer) r16.get(3)).intValue();
        r13.f8237o = ((Integer) r16.get(4)).intValue();
    L25:
        r15 = r15 + 1;
        goto L7
    L26:
        return r13;
    }

    public double f() {
        if (this.f24887b.getConfig().d() == true) goto L5;
        return 0.0d;
    L5:
        return this.f25446l.a();
    }

    public List g() {
        if (this.f24887b.getConfig().e() == true) goto L5;
        return null;
    L5:
        return this.f25440f.c();
    }

    public double h() {
        if (this.f24887b.getConfig().d() == true) goto L5;
        return 0.0d;
    L5:
        return this.f25446l.c();
    }

    public List i() {
        if (this.f24887b.getConfig().e() == true) goto L5;
        return null;
    L5:
        return d(this.f25440f.c(), this.f25440f.g());
    }

    public IAssistStat.c j() {
        if (this.f24887b.getConfig().e() == true) goto L5;
        return null;
    L5:
        return e(i());
    }

    public List k() {
        if (this.f24887b.getConfig().d() == true) goto L5;
        return null;
    L5:
        if (this.f24887b.getConfig().h() == false) goto L10;
        ArrayList r10 = new ArrayList(this.f25448n.values());
        Collections.sort(r10, new a(this));
        return r10;
    L10:
        return null;
    }

    public List l() {
        if (this.f24887b.getConfig().d() == true) goto L5;
        return null;
    L5:
        if (this.f24887b.getConfig().f() == true) goto L7;
        return null;
    L7:
        return this.f25444j.d();
    }

    public List m() {
        if (this.f24887b.getConfig().f() == true) goto L5;
        return null;
    L5:
        if (this.f24887b.getConfig().d() == true) goto L7;
        return null;
    L7:
        return d(this.f25444j.d(), this.f25444j.c());
    }

    public IAssistStat.c n() {
        if (this.f24887b.getConfig().f() == true) goto L5;
        return null;
    L5:
        if (this.f24887b.getConfig().d() == true) goto L7;
        return null;
    L7:
        return e(m());
    }

    public double o() {
        if (this.f24887b.getConfig().g() == true) goto L5;
        return 0.0d;
    L5:
        if (this.f24887b.getConfig().d() == true) goto L7;
        return 0.0d;
    L7:
        return this.f25444j.b();
    }

    public double p(int r10) {
        if (this.f24887b.getConfig().d() == true) goto L5;
        return 0.0d;
    L5:
        if (this.f24887b.getConfig().h() == false) goto L12;
        f r11 = (f) this.f25448n.get(Long.valueOf(r10));
        if (r11 != null) goto L9;
        return 0.0d;
    L9:
        return r11.a();
    L12:
        return 0.0d;
    }

    public f q(int r10) {
        if (this.f24887b.getConfig().d() == true) goto L5;
        return null;
    L5:
        if (this.f24887b.getConfig().h() == true) goto L7;
        return null;
    L7:
        return (f) this.f25448n.get(Long.valueOf(r10));
    }

    public List r(int r10) {
        if (this.f24887b.getConfig().e() == false) goto L8;
        e r11 = (e) this.f25442h.get(Long.valueOf(r10));
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.b();
    L8:
        return null;
    }

    public List s(int r10) {
        if (this.f24887b.getConfig().e() == false) goto L8;
        e r11 = (e) this.f25442h.get(Long.valueOf(r10));
        if (r11 != null) goto L7;
        return null;
    L7:
        return d(r11.b(), r11.f());
    L8:
        return null;
    }

    public IAssistStat.c t(int r10) {
        if (this.f24887b.getConfig().e() == true) goto L5;
        return null;
    L5:
        return e(s(r10));
    }

    public double u(int r10) {
        if (this.f24887b.getConfig().d() == true) goto L5;
        return 0.0d;
    L5:
        if (this.f24887b.getConfig().h() == false) goto L12;
        f r11 = (f) this.f25448n.get(Long.valueOf(r10));
        if (r11 != null) goto L9;
        return 0.0d;
    L9:
        return r11.c();
    L12:
        return 0.0d;
    }

    public List v(int r10) {
        if (this.f24887b.getConfig().d() == true) goto L5;
        return null;
    L5:
        if (this.f24887b.getConfig().h() == false) goto L16;
        if (r10 <= 0) goto L17;
        List r11 = k();
        if (r11 == null) goto L18;
        int r12 = r11.size();
        if (r10 <= r12) goto L13;
        r10 = r12;
    L13:
        return r11.subList(0, r10);
    L18:
        return null;
    L17:
        return null;
    L16:
        return null;
    }

    public final boolean w(int r10) {
        if (r10 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean x(int r10) {
        if (r10 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public void y() {
        if (this.f25437c == false) goto L12;
        long r10 = System.currentTimeMillis();
        if (this.f24887b.getConfig().d() == false) goto L8;
        A(r10);
    L8:
        if (this.f24887b.getConfig().e() == false) goto L10;
        z();
    L10:
        this.f25438d = r10;
        return;
    }

    public void z() {
        e r10 = (e) this.f25439e.b();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.calculateDelta(this.f25440f);
        this.f25440f = r10;
        ArrayList r11 = a7.b.c();
        HashSet r12 = new HashSet();
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L19;
        Long r14 = (Long) r13.next();
        long r15 = r14.longValue();
        z6.d r16 = (z6.d) this.f25441g.get(r14);
        if (r16 != null) goto L11;
        r16 = new z6.d((int) r15);
        this.f25441g.put(r14, r16);
    L11:
        e r17 = (e) r16.b();
        if (r17 == null) goto L13;
        r17.calculateDelta((e) this.f25442h.get(r14));
        this.f25442h.put(r14, r17);
        if (a7.b.a() != r15) goto L17;
        a7.a.a("not merge main thread, id:" + r15);
    L18:
        a7.a.a("current tid " + r15 + " stat : " + r17);
        a7.a.a("current tid " + r15 + " delta : " + r17.f());
        goto L7
    L17:
        this.f25440f.merge(r17);
        goto L18
    L13:
        r12.add(r14);
        a7.a.a("dead tid found from refresh cpu freq stat: " + r15);
        goto L7
    L19:
        Set r18 = this.f25441g.keySet();
        if (r18 != null) goto L22;
    L29:
        Iterator r19 = r12.iterator();
    L31:
        if (r19.hasNext() == false) goto L33;
        Long r20 = (Long) r19.next();
        r20.longValue();
        this.f25441g.remove(r20);
        this.f25442h.remove(r20);
        goto L31
    L33:
        return;
    L22:
        if (r18.isEmpty() == true) goto L29;
        Iterator r21 = r18.iterator();
    L25:
        if (r21.hasNext() == false) goto L29;
        Long r22 = (Long) r21.next();
        if (r11.contains(r22) == true) goto L25;
        r12.add(r22);
        a7.a.a("dead tid found from compare last cpu freq stat: " + r22);
        goto L25
    }
}
