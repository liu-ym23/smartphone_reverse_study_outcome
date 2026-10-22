package Tb;

import Yb.AbstractC1128b;
import Yb.w;
import ac.AbstractC1280a;
import ac.C1282c;
import ac.InterfaceC1287h;
import java.util.List;
import org.commonmark.internal.LinkReferenceDefinitionParser;

/* loaded from: classes5.dex */
public class q extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final w f6012a = new w();

    /* renamed from: b, reason: collision with root package name */
    public LinkReferenceDefinitionParser f6013b = new LinkReferenceDefinitionParser();

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void b(Zb.a aVar) {
        CharSequence charSequenceD = this.f6013b.d();
        if (charSequenceD.length() > 0) {
            aVar.n(charSequenceD.toString(), this.f6012a);
        }
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean c() {
        return true;
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        return !interfaceC1287h.a() ? C1282c.b(interfaceC1287h.getIndex()) : C1282c.d();
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f6012a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void f(CharSequence charSequence) {
        this.f6013b.f(charSequence);
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void g() {
        if (this.f6013b.d().length() == 0) {
            this.f6012a.l();
        }
    }

    public CharSequence i() {
        return this.f6013b.d();
    }

    public List<Yb.r> j() {
        return this.f6013b.c();
    }
}
