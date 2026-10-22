package jb;

import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f20958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RunMode f20959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RepeatMode f20960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f20961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference f20962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f20963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f20965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f20966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f20967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f20968l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f20969m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f20970n;

    public c() {
        this.f20958b = 60.0f;
        this.f20959c = RunMode.PARALLEL;
        this.f20960d = RepeatMode.NORMAL;
        this.f20961e = t.i();
        this.f20964h = -1;
        this.f20965i = 1.0f;
        this.f20969m = true;
    }

    public final void A(float r10) {
        this.f20958b = r10;
    }

    public final void B(View r10) {
        if (r10 == null) goto L4;
        boolean r11 = true;
    L5:
        this.f20969m = r11;
        this.f20962f = new WeakReference(r10);
        return;
    L4:
        r11 = false;
        goto L5
    }

    public final void a(boolean r10) {
        WeakReference r11 = this.f20962f;
        if (r11 == null) goto L5;
        r11.clear();
    L5:
        Iterator r12 = this.f20961e.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        ((gb.a) r12.next()).m(false, false, r10);
        goto L7
    L9:
        this.f20963g = 0;
        this.f20964h = -1;
        this.f20965i = 1.0f;
        this.f20966j = false;
        this.f20967k = 0;
        this.f20968l = 0;
    }

    public final long b() {
        return this.f20968l;
    }

    public final List c() {
        return this.f20961e;
    }

    public final int d() {
        return this.f20964h;
    }

    public final long e() {
        return this.f20957a;
    }

    public final long f() {
        return this.f20967k;
    }

    public final RepeatMode g() {
        return this.f20960d;
    }

    public final RunMode h() {
        return this.f20959c;
    }

    public final float i() {
        return this.f20965i;
    }

    public final long j() {
        return this.f20963g;
    }

    public final float k() {
        return this.f20958b;
    }

    public final View l() {
        WeakReference r10 = this.f20962f;
        if (r10 != null) goto L7;
        return null;
    L7:
        return (View) r10.get();
    }

    public final boolean m() {
        List r10 = this.f20961e;
        if (r10 != null) goto L5;
    L7:
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if (((gb.a) r11.next()).l() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return false;
    }

    public final boolean n() {
        return this.f20970n;
    }

    public final boolean o() {
        return this.f20966j;
    }

    public final boolean p() {
        return this.f20969m;
    }

    public final void q(long r10) {
        this.f20968l = r10;
    }

    public final void r(List r10) {
        q.g(r10, "animationInfos");
        this.f20961e = r10;
    }

    public final void s(int r10) {
        this.f20964h = r10;
    }

    public final void t(long r10) {
        this.f20957a = r10;
    }

    public final void u(boolean r10) {
        this.f20970n = r10;
    }

    public final void v(long r10) {
        this.f20967k = r10;
    }

    public final void w(RepeatMode r10) {
        q.g(r10, "repeatMode");
        this.f20960d = r10;
    }

    public final void x(RunMode r10) {
        q.g(r10, "runMode");
        this.f20959c = r10;
    }

    public final void y(float r10) {
        this.f20965i = r10;
    }

    public final void z(long r10) {
        this.f20963g = r10;
    }
}
