package j9;

import D7.AbstractC0209a;
import D7.v;
import g1.AbstractC1451a;
import java.util.Iterator;
import java.util.regex.Matcher;

/* renamed from: j9.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1617k extends AbstractC0209a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f4787a;

    public C1617k(l lVar) {
        this.f4787a = lVar;
    }

    public final C1615i b(int i) {
        Matcher matcher = this.f4787a.f4788a;
        Y7.f fVarX = AbstractC1451a.X(matcher.start(i), matcher.end(i));
        if (fVarX.f1569a < 0) {
            return null;
        }
        String strGroup = matcher.group(i);
        kotlin.jvm.internal.k.e(strGroup, "group(...)");
        return new C1615i(strGroup, fVarX);
    }

    @Override // D7.AbstractC0209a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof C1615i) {
            return super.contains((C1615i) obj);
        }
        return false;
    }

    @Override // D7.AbstractC0209a
    public final int getSize() {
        return this.f4787a.f4788a.groupCount() + 1;
    }

    @Override // D7.AbstractC0209a, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new i9.n(kotlin.sequences.a.m0(v.s0(H4.o.F(this)), new com.stepos.taskrobot.llmapi.stepfun.g(this, 4)));
    }
}
