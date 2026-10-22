package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: WidgetGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f732b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<androidx.constraintlayout.a.c.e> f733a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f736e;
    ArrayList<a> f;
    private int g;

    /* JADX INFO: compiled from: WidgetGroup.java */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<androidx.constraintlayout.a.c.e> f737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f741e;
        int f;
        int g;
        final /* synthetic */ o h;

        public a(o r1, androidx.constraintlayout.a.c.e r2, androidx.constraintlayout.a.d r3, int r4) {
            this.h = r1;
            this.f737a = new WeakReference(r2);
            this.f738b = r3.b(r2.A);
            this.f739c = r3.b(r2.B);
            this.f740d = r3.b(r2.C);
            this.f741e = r3.b(r2.D);
            this.f = r3.b(r2.E);
            this.g = r4;
        }
    }

    static {
    }

    public o(int r3) {
        this.f733a = new ArrayList();
        this.f734c = -1;
        this.f735d = false;
        this.f736e = 0;
        this.f = null;
        this.g = -1;
        int r0 = f732b;
        f732b = r0 + 1;
        this.f734c = r0;
        this.f736e = r3;
    }

    public int a() {
        return this.f736e;
    }

    public int b() {
        return this.f734c;
    }

    public boolean a(androidx.constraintlayout.a.c.e r2) {
        if (this.f733a.contains(r2) == false) goto L6;
        return false;
    L6:
        this.f733a.add(r2);
        return true;
    }

    public void a(boolean r1) {
        this.f735d = r1;
    }

    private String c() {
        int r1 = this.f736e;
        if (r1 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r1 != 1) goto L11;
        return "Vertical";
    L11:
        if (r1 != 2) goto L14;
        return "Both";
    L14:
        return "Unknown";
    }

    public String toString() {
        String r0 = c() + " [" + this.f734c + "] <";
        Iterator<androidx.constraintlayout.a.c.e> r4 = this.f733a.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0 = r0 + " " + ((androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).C();
        goto L4
    L7:
        return r0 + " >";
    }

    public void a(int r5, o r6) {
        Iterator<androidx.constraintlayout.a.c.e> r0 = this.f733a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        androidx.constraintlayout.a.c.e r1 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        r6.a(r1);
        if (r5 == 0) goto L7;
        r1.ax = r6.b();
        goto L4
    L7:
        r1.aw = r6.b();
        goto L4
    L9:
        this.g = r6.f734c;
    }

    public int a(androidx.constraintlayout.a.d r2, int r3) {
        if (this.f733a.size() != 0) goto L7;
        return 0;
    L7:
        return a(r2, this.f733a, r3);
    }

    private int a(androidx.constraintlayout.a.d r7, ArrayList<androidx.constraintlayout.a.c.e> r8, int r9) {
        int r0 = 0;
        androidx.constraintlayout.a.c.f r1 = (androidx.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(((androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r8.get(0), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).A(), androidx.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin");
        r7.b();
        r1.a(r7, false);
        int r2 = 0;
    L4:
        if (r2 >= r8.size()) goto L6;
        ((androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r8.get(r2), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).a(r7, false);
        r2 = r2 + 1;
        goto L4
    L6:
        if (r9 != 0) goto L11;
        if (r1.aG <= 0) goto L11;
        androidx.constraintlayout.a.c.b.a(r1, r7, r8, 0);
    L11:
        if (r9 == 1) goto L13;
    L28:
        r7.f();     // Catch: Exception -> L17
    L19:
        this.f = new ArrayList();
    L21:
        if (r0 >= r8.size()) goto L23;
        this.f.add(new a(this, (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r8.get(r0), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin"), r7, r9));
        r0 = r0 + 1;
        goto L21
    L23:
        if (r9 != 0) goto L27;
        int r6 = r7.b(r1.A);
        int r10 = r7.b(r1.C);
        r7.b();
    L26:
        return r10 - r6;
    L27:
        r6 = r7.b(r1.B);
        r10 = r7.b(r1.D);
        r7.b();
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L13:
        if (r1.aH <= 0) goto L28;
        androidx.constraintlayout.a.c.b.a(r1, r7, r8, 1);
        goto L28
    }

    public void a(int r1) {
        this.f736e = r1;
    }

    public void a(ArrayList<o> r6) {
        int r0 = this.f733a.size();
        if (this.g == (-1)) goto L12;
        if (r0 <= 0) goto L12;
        int r1 = 0;
    L7:
        if (r1 >= r6.size()) goto L12;
        o r2 = (o) ZeusTransformUtils.preCheckCast(r6.get(r1), o.class, "com.obric.aiagent.plugin");
        if (this.g != r2.f734c) goto L11;
        a(this.f736e, r2);
    L11:
        r1 = r1 + 1;
    L12:
        if (r0 != 0) goto L18;
        r6.remove(this);
        return;
    }
}
