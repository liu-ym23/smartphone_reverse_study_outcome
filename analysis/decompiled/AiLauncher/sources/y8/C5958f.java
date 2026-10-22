package y8;

import Yb.AbstractC1128b;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;

/* renamed from: y8.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5958f extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final C5956d f43952a = new C5956d();

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f43953b = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public boolean f43954c;

    /* renamed from: y8.f$a */
    public static class a extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            CharSequence charSequenceB = interfaceC1287h.b();
            return ((charSequenceB != null ? charSequenceB.length() : 0) > 1 && '$' == charSequenceB.charAt(0) && '$' == charSequenceB.charAt(1)) ? AbstractC1285f.d(new C5958f()).b(interfaceC1287h.getIndex() + 2) : AbstractC1285f.c();
        }
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        return this.f43954c ? C1282c.c() : C1282c.b(interfaceC1287h.getIndex());
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f43952a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void f(CharSequence charSequence) {
        if (this.f43953b.length() > 0) {
            this.f43953b.append('\n');
        }
        this.f43953b.append(charSequence);
        int length = this.f43953b.length();
        if (length > 1) {
            boolean z10 = '$' == this.f43953b.charAt(length + (-1)) && '$' == this.f43953b.charAt(length + (-2));
            this.f43954c = z10;
            if (z10) {
                this.f43953b.replace(length - 2, length, "");
            }
        }
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void g() {
        this.f43952a.o(this.f43953b.toString());
    }
}
