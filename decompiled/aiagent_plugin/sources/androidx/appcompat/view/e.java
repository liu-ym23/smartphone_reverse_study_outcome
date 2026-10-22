package androidx.appcompat.view;

import android.view.animation.Interpolator;
import androidx.core.view.ae;
import androidx.core.view.af;
import androidx.core.view.ag;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<ae> f308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    af f309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Interpolator f311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f312e;
    private final ag f;

    public e() {
        this.f310c = -1;
        this.f = new AnonymousClass1(this);
        this.f308a = new ArrayList();
    }

    public e a(ae r2) {
        if (this.f312e == true) goto L5;
        this.f308a.add(r2);
    L5:
        return this;
    }

    public e a(ae r3, ae r4) {
        this.f308a.add(r3);
        r4.b(r3.a());
        this.f308a.add(r4);
        return this;
    }

    public void a() {
        if (this.f312e == false) goto L5;
        return;
    L5:
        Iterator<ae> r0 = this.f308a.iterator();
    L7:
        if (r0.hasNext() == false) goto L18;
        ae r1 = (ae) ZeusTransformUtils.preCheckCast(r0.next(), ae.class, "com.obric.aiagent.plugin");
        long r2 = this.f310c;
        if (r2 < 0) goto L11;
        r1.a(r2);
    L11:
        Interpolator r3 = this.f311d;
        if (r3 == null) goto L15;
        r1.a(r3);
    L15:
        if (this.f309b == null) goto L17;
        r1.a(this.f);
    L17:
        r1.c();
        goto L7
    L18:
        this.f312e = true;
    }

    void b() {
        this.f312e = false;
    }

    public void c() {
        if (this.f312e == true) goto L5;
        return;
    L5:
        Iterator<ae> r0 = this.f308a.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((ae) ZeusTransformUtils.preCheckCast(r0.next(), ae.class, "com.obric.aiagent.plugin")).b();
        goto L7
    L9:
        this.f312e = false;
    }

    public e a(long r2) {
        if (this.f312e == true) goto L5;
        this.f310c = r2;
    L5:
        return this;
    }

    public e a(Interpolator r3) {
        Interpolator r4 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r3, Interpolator.class, "com.obric.aiagent.plugin");
        if (this.f312e == true) goto L5;
        this.f311d = r4;
    L5:
        return this;
    }

    public e a(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.aiagent.plugin");
        if (this.f312e == true) goto L5;
        this.f309b = r4;
    L5:
        return this;
    }
}
