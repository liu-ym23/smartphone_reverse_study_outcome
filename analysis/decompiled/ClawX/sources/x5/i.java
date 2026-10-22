package x5;

import java.util.Iterator;
import java.util.regex.Matcher;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends c5.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f6296a;

    public i(j jVar) {
        this.f6296a = jVar;
    }

    @Override // c5.b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof g) {
            return super.contains((g) obj);
        }
        return false;
    }

    @Override // c5.b
    public final int f() {
        return this.f6296a.f6297a.groupCount() + 1;
    }

    public final g g(int i8) {
        Matcher matcher = this.f6296a.f6297a;
        u5.f fVarR0 = v.r0(matcher.start(i8), matcher.end(i8));
        if (fVarR0.f5663a < 0) {
            return null;
        }
        String strGroup = matcher.group(i8);
        kotlin.jvm.internal.p.d(strGroup, "group(...)");
        return new g(strGroup, fVarR0);
    }

    @Override // c5.b, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new r4.f(new w5.g(c5.m.q0(new u5.f(0, f() - 1, 1)), new c5.a(16, this), 1));
    }
}
