package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TransitionSet.java */
/* JADX INFO: loaded from: classes.dex */
public class v extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2865a;
    boolean i;
    private ArrayList<s> j;
    private boolean k;
    private int l;

    /* JADX INFO: compiled from: TransitionSet.java */
    static class a extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        v f2868a;

        a(v r1) {
            this.f2868a = r1;
        }

        @Override // androidx.transition.t, androidx.transition.s.d
        public void onTransitionStart(s r1) {
            if (this.f2868a.i == true) goto L6;
            this.f2868a.f();
            this.f2868a.i = true;
            return;
        }

        @Override // androidx.transition.t, androidx.transition.s.d
        public void onTransitionEnd(s r3) {
            this.f2868a.f2865a--;
            if (this.f2868a.f2865a != 0) goto L5;
            this.f2868a.i = false;
            this.f2868a.g();
        L5:
            r3.b(this);
        }
    }

    @Override // androidx.transition.s
    public /* synthetic */ s a(long r1) {
        return c(r1);
    }

    @Override // androidx.transition.s
    public /* synthetic */ s a(TimeInterpolator r3) {
        return b((TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, TimeInterpolator.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.transition.s
    public /* synthetic */ s a(s.d r3) {
        return c((s.d) ZeusTransformUtils.wrapperContextForParams(r3, s.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.transition.s
    public /* synthetic */ s b(long r1) {
        return d(r1);
    }

    @Override // androidx.transition.s
    public /* synthetic */ s b(s.d r3) {
        return d((s.d) ZeusTransformUtils.wrapperContextForParams(r3, s.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.transition.s
    public /* synthetic */ Object clone() {
        return l();
    }

    public v() {
        this.j = new ArrayList();
        this.k = true;
        this.i = false;
        this.l = 0;
    }

    public v a(int r3) {
        if (r3 == 0) goto L8;
        if (r3 != 1) goto L7;
        this.k = false;
    L9:
        return this;
    L7:
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + r3);
    L8:
        this.k = true;
        goto L9
    }

    public v a(s r5) {
        b(r5);
        if (this.f2856b < 0) goto L6;
        r5.a(this.f2856b);
    L6:
        if ((this.l & 1) == 0) goto L9;
        r5.a(d());
    L9:
        if ((this.l & 2) == 0) goto L12;
        r5.a(k());
    L12:
        if ((this.l & 4) == 0) goto L15;
        r5.a(i());
    L15:
        if ((this.l & 8) == 0) goto L17;
        r5.a(j());
    L17:
        return this;
    }

    private void b(s r2) {
        this.j.add(r2);
        r2.f2859e = this;
    }

    public v c(long r6) {
        super.a(r6);
        if (this.f2856b < 0) goto L9;
        ArrayList<s> r0 = this.j;
        if (r0 == null) goto L9;
        int r1 = r0.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r2), s.class, "com.obric.aiagent.plugin")).a(r6);
        r2 = r2 + 1;
    L9:
        return this;
    }

    public v d(long r1) {
        return (v) ZeusTransformUtils.preCheckCast(super.b(r1), v.class, "com.obric.aiagent.plugin");
    }

    public v b(TimeInterpolator r6) {
        TimeInterpolator r7 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r6, TimeInterpolator.class, "com.obric.aiagent.plugin");
        this.l |= 1;
        ArrayList<s> r0 = this.j;
        if (r0 == null) goto L8;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L8;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r2), s.class, "com.obric.aiagent.plugin")).a(r7);
        r2 = r2 + 1;
    L8:
        return (v) ZeusTransformUtils.preCheckCast(super.a(r7), v.class, "com.obric.aiagent.plugin");
    }

    public v c(s.d r3) {
        return (v) ZeusTransformUtils.preCheckCast(super.a((s.d) ZeusTransformUtils.wrapperContextForParams(r3, s.d.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.transition.s
    public s a(View r5, boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.j.size()) goto L7;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r0), s.class, "com.obric.aiagent.plugin")).a(r5, r6);
        r0 = r0 + 1;
        goto L4
    L7:
        return super.a(r5, r6);
    }

    public v d(s.d r3) {
        return (v) ZeusTransformUtils.preCheckCast(super.b((s.d) ZeusTransformUtils.wrapperContextForParams(r3, s.d.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.transition.s
    public void a(o r5) {
        super.a(r5);
        this.l |= 4;
        if (this.j == null) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= this.j.size()) goto L10;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r0), s.class, "com.obric.aiagent.plugin")).a(r5);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    private void n() {
        a r0 = new a(this);
        Iterator<s> r1 = this.j.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.aiagent.plugin")).a(r0);
        goto L4
    L6:
        this.f2865a = this.j.size();
    }

    @Override // androidx.transition.s
    public void a(ViewGroup r13, x r14, x r15, ArrayList<w> r16, ArrayList<w> r17) {
        long r1 = c();
        int r3 = this.j.size();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L14;
        s r6 = (s) ZeusTransformUtils.preCheckCast(this.j.get(r4), s.class, "com.obric.aiagent.plugin");
        if (r1 <= 0) goto L13;
        if (this.k == true) goto L9;
        if (r4 != 0) goto L13;
    L9:
        long r9 = r6.c();
        if (r9 <= 0) goto L12;
        r6.b(r9 + r1);
        goto L13
    L12:
        r6.b(r1);
    L13:
        r6.a(r13, r14, r15, r16, r17);
        r4 = r4 + 1;
        goto L3
    }

    @Override // androidx.transition.s
    public void e() {
        if (this.j.isEmpty() == false) goto L6;
        f();
        g();
        return;
    L6:
        n();
        if (this.k == true) goto L15;
        int r0 = 1;
    L10:
        if (r0 >= this.j.size()) goto L12;
        s r2 = (s) ZeusTransformUtils.preCheckCast(this.j.get(r0 - 1), s.class, "com.obric.aiagent.plugin");
        final s r3 = (s) ZeusTransformUtils.preCheckCast(this.j.get(r0), s.class, "com.obric.aiagent.plugin");
        r2.a(new AnonymousClass1(this, r3));
        r0 = r0 + 1;
        goto L10
    L12:
        s r5 = (s) ZeusTransformUtils.preCheckCast(this.j.get(0), s.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L19;
        r5.e();
        return;
    L19:
        return;
    L15:
        Iterator<s> r6 = this.j.iterator();
    L17:
        if (r6.hasNext() == false) goto L23;
        ((s) ZeusTransformUtils.preCheckCast(r6.next(), s.class, "com.obric.aiagent.plugin")).e();
        goto L17
    }

    @Override // androidx.transition.s
    public void a(w r4) {
        if (b(r4.f2870b) == false) goto L10;
        Iterator<s> r3 = this.j.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.aiagent.plugin");
        if (r0.b(r4.f2870b) == false) goto L6;
        r0.a(r4);
        r4.f2871c.add(r0);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.s
    public void b(w r4) {
        if (b(r4.f2870b) == false) goto L10;
        Iterator<s> r3 = this.j.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.aiagent.plugin");
        if (r0.b(r4.f2870b) == false) goto L6;
        r0.b(r4);
        r4.f2871c.add(r0);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.s
    void c(w r6) {
        super.c(r6);
        int r0 = this.j.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r1), s.class, "com.obric.aiagent.plugin")).c(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.s
    public void c(View r6) {
        super.c(r6);
        int r0 = this.j.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r1), s.class, "com.obric.aiagent.plugin")).c(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.s
    public void d(View r6) {
        super.d(r6);
        int r0 = this.j.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r1), s.class, "com.obric.aiagent.plugin")).d(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.s
    public void h() {
        super.h();
        int r0 = this.j.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r1), s.class, "com.obric.aiagent.plugin")).h();
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.s
    public void a(u r6) {
        super.a(r6);
        this.l |= 2;
        int r0 = this.j.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r1), s.class, "com.obric.aiagent.plugin")).a(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.s
    public void a(s.c r6) {
        super.a(r6);
        this.l |= 8;
        int r0 = this.j.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((s) ZeusTransformUtils.preCheckCast(this.j.get(r1), s.class, "com.obric.aiagent.plugin")).a(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.transition.s
    String a(String r6) {
        String r0 = super.a(r6);
        int r1 = 0;
    L4:
        if (r1 >= this.j.size()) goto L6;
        r0 = r0 + "\n" + ((s) ZeusTransformUtils.preCheckCast(this.j.get(r1), s.class, "com.obric.aiagent.plugin")).a(r6 + "  ");
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // androidx.transition.s
    public s l() {
        v r0 = (v) ZeusTransformUtils.preCheckCast(super.l(), v.class, "com.obric.aiagent.plugin");
        r0.j = new ArrayList();
        int r1 = this.j.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.b(((s) ZeusTransformUtils.preCheckCast(this.j.get(r3), s.class, "com.obric.aiagent.plugin")).l());
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }
}
