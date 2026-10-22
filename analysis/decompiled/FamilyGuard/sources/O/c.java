package O;

import f4.C0722b;
import i4.InterfaceC0761a;
import j4.k;
import j4.l;
import java.io.File;
import java.util.List;
import s4.I;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f4283a = new c();

    static final class a extends l implements InterfaceC0761a<File> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0761a<File> f4284a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(InterfaceC0761a<? extends File> interfaceC0761a) {
            super(0);
            this.f4284a = interfaceC0761a;
        }

        @Override // i4.InterfaceC0761a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File fileInvoke = this.f4284a.invoke();
            String strB = C0722b.b(fileInvoke);
            h hVar = h.f4291a;
            if (k.b(strB, hVar.f())) {
                return fileInvoke;
            }
            throw new IllegalStateException(("File extension for file: " + fileInvoke + " does not match required extension for Preferences file: " + hVar.f()).toString());
        }
    }

    private c() {
    }

    public final L.f<d> a(M.b<d> bVar, List<? extends L.d<d>> list, I i5, InterfaceC0761a<? extends File> interfaceC0761a) {
        k.g(list, "migrations");
        k.g(i5, "scope");
        k.g(interfaceC0761a, "produceFile");
        return new b(L.g.f3691a.a(h.f4291a, bVar, list, i5, new a(interfaceC0761a)));
    }
}
