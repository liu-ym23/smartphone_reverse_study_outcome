package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends y {
    private static TimeInterpolator i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.u>> f2500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<ArrayList<b>> f2501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<ArrayList<a>> f2502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<RecyclerView.u> f2503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList<RecyclerView.u> f2504e;
    ArrayList<RecyclerView.u> f;
    ArrayList<RecyclerView.u> g;
    private ArrayList<RecyclerView.u> j;
    private ArrayList<RecyclerView.u> k;
    private ArrayList<b> l;
    private ArrayList<a> m;

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.u f2511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.u f2512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2513c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2514d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2515e;
        public int f;

        private a(RecyclerView.u r1, RecyclerView.u r2) {
            this.f2511a = r1;
            this.f2512b = r2;
        }

        a(RecyclerView.u r1, RecyclerView.u r2, int r3, int r4, int r5, int r6) {
            this(r1, r2);
            this.f2513c = r3;
            this.f2514d = r4;
            this.f2515e = r5;
            this.f = r6;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2511a + ", newHolder=" + this.f2512b + ", fromX=" + this.f2513c + ", fromY=" + this.f2514d + ", toX=" + this.f2515e + ", toY=" + this.f + '}';
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.u f2516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2519d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2520e;

        b(RecyclerView.u r1, int r2, int r3, int r4, int r5) {
            this.f2516a = r1;
            this.f2517b = r2;
            this.f2518c = r3;
            this.f2519d = r4;
            this.f2520e = r5;
        }
    }

    public i() {
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.f2500a = new ArrayList();
        this.f2501b = new ArrayList();
        this.f2502c = new ArrayList();
        this.f2503d = new ArrayList();
        this.f2504e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void a() {
        boolean r0 = !this.j.isEmpty();
        boolean r1 = !this.l.isEmpty();
        boolean r2 = !this.m.isEmpty();
        boolean r3 = !this.k.isEmpty();
        if (r0 == true) goto L8;
        if (r1 == true) goto L8;
        if (r3 == true) goto L8;
        if (r2 == true) goto L8;
        return;
    L8:
        Iterator<RecyclerView.u> r4 = this.j.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        u((RecyclerView.u) ZeusTransformUtils.preCheckCast(r4.next(), RecyclerView.u.class, "com.obric.aiagent.plugin"));
        goto L10
    L12:
        this.j.clear();
        if (r1 == false) goto L18;
        final ArrayList<b> r5 = new ArrayList();
        r5.addAll(this.l);
        this.f2501b.add(r5);
        this.l.clear();
        Runnable r7 = new AnonymousClass1(this, r5);
        if (r0 == false) goto L17;
        ViewCompat.a(((b) ZeusTransformUtils.preCheckCast(r5.get(0), b.class, "com.obric.aiagent.plugin")).f2516a.f2390a, r7, g());
        goto L18
    L17:
        r7.run();
    L18:
        if (r2 == false) goto L23;
        final ArrayList<a> r6 = new ArrayList();
        r6.addAll(this.m);
        this.f2502c.add(r6);
        this.m.clear();
        Runnable r8 = new AnonymousClass2(this, r6);
        if (r0 == false) goto L22;
        ViewCompat.a(((a) ZeusTransformUtils.preCheckCast(r6.get(0), a.class, "com.obric.aiagent.plugin")).f2511a.f2390a, r8, g());
        goto L23
    L22:
        r8.run();
    L23:
        if (r3 == false) goto L42;
        final ArrayList<RecyclerView.u> r9 = new ArrayList();
        r9.addAll(this.k);
        this.f2500a.add(r9);
        this.k.clear();
        Runnable r10 = new AnonymousClass3(this, r9);
        if (r0 == true) goto L30;
        if (r1 == true) goto L30;
        if (r2 == true) goto L30;
        r10.run();
        return;
    L30:
        long r11 = 0;
        if (r0 == false) goto L33;
        long r12 = g();
    L34:
        if (r1 == false) goto L36;
        long r13 = e();
    L37:
        if (r2 == false) goto L39;
        r11 = h();
    L39:
        ViewCompat.a(((RecyclerView.u) ZeusTransformUtils.preCheckCast(r9.get(0), RecyclerView.u.class, "com.obric.aiagent.plugin")).f2390a, r10, r12 + Math.max(r13, r11));
        return;
    L36:
        r13 = 0;
        goto L37
    L33:
        r12 = 0;
        goto L34
    }

    @Override // androidx.recyclerview.widget.y
    public boolean a(RecyclerView.u r1) {
        v(r1);
        this.j.add(r1);
        return true;
    }

    private void u(final RecyclerView.u r5) {
        final View r0 = r5.f2390a;
        final ViewPropertyAnimator r1 = r0.animate();
        this.f.add(r5);
        r1.setDuration(g()).alpha(0.0f).setListener(new DefaultItemAnimator$4(this, r5, r1, r0)).start();
    }

    @Override // androidx.recyclerview.widget.y
    public boolean b(RecyclerView.u r3) {
        v(r3);
        r3.f2390a.setAlpha(0.0f);
        this.k.add(r3);
        return true;
    }

    void c(final RecyclerView.u r6) {
        final View r0 = r6.f2390a;
        final ViewPropertyAnimator r1 = r0.animate();
        this.f2503d.add(r6);
        r1.alpha(1.0f).setDuration(f()).setListener(new DefaultItemAnimator$5(this, r6, r0, r1)).start();
    }

    @Override // androidx.recyclerview.widget.y
    public boolean a(RecyclerView.u r9, int r10, int r11, int r12, int r13) {
        View r0 = r9.f2390a;
        int r4 = r10 + ((int) r9.f2390a.getTranslationX());
        int r5 = r11 + ((int) r9.f2390a.getTranslationY());
        v(r9);
        int r14 = r12 - r4;
        int r15 = r13 - r5;
        if (r14 != 0) goto L7;
        if (r15 != 0) goto L7;
        j(r9);
        return false;
    L7:
        if (r14 == 0) goto L9;
        r0.setTranslationX(-r14);
    L9:
        if (r15 == 0) goto L11;
        r0.setTranslationY(-r15);
    L11:
        this.l.add(new b(r9, r4, r5, r12, r13));
        return true;
    }

    void b(final RecyclerView.u r8, int r9, int r10, int r11, int r12) {
        final View r4 = r8.f2390a;
        final int r3 = r11 - r9;
        final int r5 = r12 - r10;
        if (r3 == 0) goto L5;
        r4.animate().translationX(0.0f);
    L5:
        if (r5 == 0) goto L7;
        r4.animate().translationY(0.0f);
    L7:
        final ViewPropertyAnimator r6 = r4.animate();
        this.f2504e.add(r8);
        r6.setDuration(e()).setListener(new DefaultItemAnimator$6(this, r8, r3, r4, r5, r6)).start();
    }

    @Override // androidx.recyclerview.widget.y
    public boolean a(RecyclerView.u r9, RecyclerView.u r10, int r11, int r12, int r13, int r14) {
        if (r9 == r10) goto L4;
        float r0 = r9.f2390a.getTranslationX();
        float r1 = r9.f2390a.getTranslationY();
        float r2 = r9.f2390a.getAlpha();
        v(r9);
        int r3 = (int) ((r13 - r11) - r0);
        int r4 = (int) ((r14 - r12) - r1);
        r9.f2390a.setTranslationX(r0);
        r9.f2390a.setTranslationY(r1);
        r9.f2390a.setAlpha(r2);
        if (r10 == null) goto L8;
        v(r10);
        r10.f2390a.setTranslationX(-r3);
        r10.f2390a.setTranslationY(-r4);
        r10.f2390a.setAlpha(0.0f);
    L8:
        this.m.add(new a(r9, r10, r11, r12, r13, r14));
        return true;
    L4:
        return a(r9, r11, r12, r13, r14);
    }

    void a(final a r7) {
        RecyclerView.u r0 = r7.f2511a;
        final View r1 = null;
        if (r0 != null) goto L5;
        final View r2 = null;
    L6:
        RecyclerView.u r3 = r7.f2512b;
        if (r3 == null) goto L10;
        r1 = r3.f2390a;
    L10:
        if (r2 == null) goto L12;
        final ViewPropertyAnimator r4 = r2.animate().setDuration(h());
        this.g.add(r7.f2511a);
        r4.translationX(r7.f2515e - r7.f2513c);
        r4.translationY(r7.f - r7.f2514d);
        r4.alpha(0.0f).setListener(new DefaultItemAnimator$7(this, r7, r4, r2)).start();
    L12:
        if (r1 == null) goto L15;
        final ViewPropertyAnimator r5 = r1.animate();
        this.g.add(r7.f2512b);
        r5.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new DefaultItemAnimator$8(this, r7, r5, r1)).start();
        return;
    L15:
        return;
    L5:
        r2 = r0.f2390a;
        goto L6
    }

    private void a(List<a> r5, RecyclerView.u r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        int r0 = r7.size() - 1;
    L3:
        if (r0 < 0) goto L12;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r7.get(r0), a.class, "com.obric.aiagent.plugin");
        if (a(r2, r6) == false) goto L11;
        if (r2.f2511a != null) goto L11;
        if (r2.f2512b != null) goto L11;
        r7.remove(r2);
    L11:
        r0 = r0 - 1;
        goto L3
    }

    private void b(a r2) {
        if (r2.f2511a == null) goto L6;
        a(r2, r2.f2511a);
    L6:
        if (r2.f2512b == null) goto L9;
        a(r2, r2.f2512b);
        return;
    }

    private boolean a(a r5, RecyclerView.u r6) {
        boolean r3 = false;
        if (r5.f2512b != r6) goto L6;
        r5.f2512b = null;
    L8:
        r6.f2390a.setAlpha(1.0f);
        r6.f2390a.setTranslationX(0.0f);
        r6.f2390a.setTranslationY(0.0f);
        a(r6, r3);
        return true;
    L6:
        if (r5.f2511a != r6) goto L10;
        r5.f2511a = null;
        r3 = true;
        goto L8
    L10:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void d(RecyclerView.u r10) {
        View r0 = r10.f2390a;
        r0.animate().cancel();
        int r1 = this.l.size();
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L9;
        if (((b) ZeusTransformUtils.preCheckCast(this.l.get(r1), b.class, "com.obric.aiagent.plugin")).f2516a != r10) goto L3;
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        j(r10);
        this.l.remove(r1);
        goto L3
    L9:
        a(this.m, r10);
        if (this.j.remove(r10) == false) goto L13;
        r0.setAlpha(1.0f);
        i(r10);
    L13:
        if (this.k.remove(r10) == false) goto L15;
        r0.setAlpha(1.0f);
        k(r10);
    L15:
        int r2 = this.f2502c.size() - 1;
    L16:
        if (r2 < 0) goto L21;
        ArrayList r5 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f2502c.get(r2), ArrayList.class, "com.obric.aiagent.plugin");
        a(r5, r10);
        if (r5.isEmpty() == false) goto L20;
        this.f2502c.remove(r2);
    L20:
        r2 = r2 - 1;
        goto L16
    L21:
        int r3 = this.f2501b.size() - 1;
    L22:
        if (r3 < 0) goto L32;
        ArrayList r6 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f2501b.get(r3), ArrayList.class, "com.obric.aiagent.plugin");
        int r7 = r6.size() - 1;
    L24:
        if (r7 < 0) goto L31;
        if (((b) ZeusTransformUtils.preCheckCast(r6.get(r7), b.class, "com.obric.aiagent.plugin")).f2516a == r10) goto L27;
        r7 = r7 - 1;
        goto L24
    L27:
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        j(r10);
        r6.remove(r7);
        if (r6.isEmpty() == false) goto L31;
        this.f2501b.remove(r3);
    L31:
        r3 = r3 - 1;
        goto L22
    L32:
        int r4 = this.f2500a.size() - 1;
    L33:
        if (r4 < 0) goto L40;
        ArrayList r8 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f2500a.get(r4), ArrayList.class, "com.obric.aiagent.plugin");
        if (r8.remove(r10) == false) goto L39;
        r0.setAlpha(1.0f);
        k(r10);
        if (r8.isEmpty() == false) goto L39;
        this.f2500a.remove(r4);
    L39:
        r4 = r4 - 1;
        goto L33
    L40:
        this.f.remove(r10);
        this.f2503d.remove(r10);
        this.g.remove(r10);
        this.f2504e.remove(r10);
        c();
    }

    private void v(RecyclerView.u r3) {
        if (i != null) goto L5;
        i = new ValueAnimator().getInterpolator();
    L5:
        r3.f2390a.animate().setInterpolator(i);
        d(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean b() {
        if (this.k.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.m.isEmpty() == false) goto L26;
        if (this.l.isEmpty() == false) goto L26;
        if (this.j.isEmpty() == false) goto L26;
        if (this.f2504e.isEmpty() == false) goto L26;
        if (this.f.isEmpty() == false) goto L26;
        if (this.f2503d.isEmpty() == false) goto L26;
        if (this.g.isEmpty() == false) goto L26;
        if (this.f2501b.isEmpty() == false) goto L26;
        if (this.f2500a.isEmpty() == false) goto L26;
        if (this.f2502c.isEmpty() == false) goto L26;
        return false;
    }

    void c() {
        if (b() == true) goto L6;
        i();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void d() {
        int r0 = this.l.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.l.get(r0), b.class, "com.obric.aiagent.plugin");
        View r3 = r2.f2516a.f2390a;
        r3.setTranslationY(0.0f);
        r3.setTranslationX(0.0f);
        j(r2.f2516a);
        this.l.remove(r0);
        goto L3
    L6:
        int r1 = this.j.size() - 1;
    L7:
        if (r1 < 0) goto L9;
        i((RecyclerView.u) ZeusTransformUtils.preCheckCast(this.j.get(r1), RecyclerView.u.class, "com.obric.aiagent.plugin"));
        this.j.remove(r1);
        r1 = r1 - 1;
        goto L7
    L9:
        int r4 = this.k.size();
    L10:
        r4 = r4 - 1;
        if (r4 < 0) goto L13;
        RecyclerView.u r5 = (RecyclerView.u) ZeusTransformUtils.preCheckCast(this.k.get(r4), RecyclerView.u.class, "com.obric.aiagent.plugin");
        r5.f2390a.setAlpha(1.0f);
        k(r5);
        this.k.remove(r4);
        goto L10
    L13:
        int r6 = this.m.size() - 1;
    L14:
        if (r6 < 0) goto L16;
        b((a) ZeusTransformUtils.preCheckCast(this.m.get(r6), a.class, "com.obric.aiagent.plugin"));
        r6 = r6 - 1;
        goto L14
    L16:
        this.m.clear();
        if (b() == true) goto L19;
        return;
    L19:
        int r7 = this.f2501b.size() - 1;
    L20:
        if (r7 < 0) goto L28;
        ArrayList r8 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f2501b.get(r7), ArrayList.class, "com.obric.aiagent.plugin");
        int r9 = r8.size() - 1;
    L22:
        if (r9 < 0) goto L27;
        b r10 = (b) ZeusTransformUtils.preCheckCast(r8.get(r9), b.class, "com.obric.aiagent.plugin");
        View r11 = r10.f2516a.f2390a;
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        j(r10.f2516a);
        r8.remove(r9);
        if (r8.isEmpty() == false) goto L26;
        this.f2501b.remove(r8);
    L26:
        r9 = r9 - 1;
        goto L22
    L27:
        r7 = r7 - 1;
        goto L20
    L28:
        int r12 = this.f2500a.size() - 1;
    L29:
        if (r12 < 0) goto L37;
        ArrayList r13 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f2500a.get(r12), ArrayList.class, "com.obric.aiagent.plugin");
        int r14 = r13.size() - 1;
    L31:
        if (r14 < 0) goto L36;
        RecyclerView.u r15 = (RecyclerView.u) ZeusTransformUtils.preCheckCast(r13.get(r14), RecyclerView.u.class, "com.obric.aiagent.plugin");
        r15.f2390a.setAlpha(1.0f);
        k(r15);
        r13.remove(r14);
        if (r13.isEmpty() == false) goto L35;
        this.f2500a.remove(r13);
    L35:
        r14 = r14 - 1;
        goto L31
    L36:
        r12 = r12 - 1;
        goto L29
    L37:
        int r16 = this.f2502c.size() - 1;
    L38:
        if (r16 < 0) goto L46;
        ArrayList r17 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f2502c.get(r16), ArrayList.class, "com.obric.aiagent.plugin");
        int r18 = r17.size() - 1;
    L40:
        if (r18 < 0) goto L45;
        b((a) ZeusTransformUtils.preCheckCast(r17.get(r18), a.class, "com.obric.aiagent.plugin"));
        if (r17.isEmpty() == false) goto L44;
        this.f2502c.remove(r17);
    L44:
        r18 = r18 - 1;
        goto L40
    L45:
        r16 = r16 - 1;
        goto L38
    L46:
        a(this.f);
        a(this.f2504e);
        a(this.f2503d);
        a(this.g);
        i();
    }

    void a(List<RecyclerView.u> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        int r5 = r3.size() - 1;
    L3:
        if (r5 < 0) goto L5;
        ((RecyclerView.u) ZeusTransformUtils.preCheckCast(r3.get(r5), RecyclerView.u.class, "com.obric.aiagent.plugin")).f2390a.animate().cancel();
        r5 = r5 - 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public boolean a(RecyclerView.u r3, List<Object> r4) {
        List<Object> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.a(r3, r5) == true) goto L8;
        return false;
    }
}
