package s4;

import Z3.i;
import i4.InterfaceC0772l;
import java.io.Closeable;

/* renamed from: s4.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1071f0 extends AbstractC1056E implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20347c = new a(null);

    /* renamed from: s4.f0$a */
    public static final class a extends Z3.b<AbstractC1056E, AbstractC1071f0> {

        /* renamed from: s4.f0$a$a, reason: collision with other inner class name */
        static final class C0238a extends j4.l implements InterfaceC0772l<i.b, AbstractC1071f0> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0238a f20348a = new C0238a();

            C0238a() {
                super(1);
            }

            @Override // i4.InterfaceC0772l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AbstractC1071f0 invoke(i.b bVar) {
                if (bVar instanceof AbstractC1071f0) {
                    return (AbstractC1071f0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
            super(AbstractC1056E.f20298b, C0238a.f20348a);
        }
    }
}
