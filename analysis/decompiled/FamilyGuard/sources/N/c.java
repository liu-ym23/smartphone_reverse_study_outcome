package N;

import android.content.Context;
import com.stepos.minor.Minor;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;
import j4.k;
import j4.l;
import java.io.File;
import java.util.List;
import m4.InterfaceC0868a;
import s4.I;

/* loaded from: classes.dex */
public final class c implements InterfaceC0868a<Context, L.f<O.d>> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4163a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0772l<Context, List<L.d<O.d>>> f4164b;

    /* renamed from: c, reason: collision with root package name */
    private final I f4165c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f4166d;

    /* renamed from: e, reason: collision with root package name */
    private volatile L.f<O.d> f4167e;

    static final class a extends l implements InterfaceC0761a<File> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4168a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f4169b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, c cVar) {
            super(0);
            this.f4168a = context;
            this.f4169b = cVar;
        }

        @Override // i4.InterfaceC0761a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            Context context = this.f4168a;
            k.f(context, "applicationContext");
            return b.a(context, this.f4169b.f4163a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String str, M.b<O.d> bVar, InterfaceC0772l<? super Context, ? extends List<? extends L.d<O.d>>> interfaceC0772l, I i5) {
        k.g(str, Minor.COLUMN_NAME);
        k.g(interfaceC0772l, "produceMigrations");
        k.g(i5, "scope");
        this.f4163a = str;
        this.f4164b = interfaceC0772l;
        this.f4165c = i5;
        this.f4166d = new Object();
    }

    @Override // m4.InterfaceC0868a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public L.f<O.d> a(Context context, p4.h<?> hVar) {
        L.f<O.d> fVar;
        k.g(context, "thisRef");
        k.g(hVar, "property");
        L.f<O.d> fVar2 = this.f4167e;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (this.f4166d) {
            try {
                if (this.f4167e == null) {
                    Context applicationContext = context.getApplicationContext();
                    O.c cVar = O.c.f4283a;
                    InterfaceC0772l<Context, List<L.d<O.d>>> interfaceC0772l = this.f4164b;
                    k.f(applicationContext, "applicationContext");
                    this.f4167e = cVar.a(null, interfaceC0772l.invoke(applicationContext), this.f4165c, new a(applicationContext, this));
                }
                fVar = this.f4167e;
                k.d(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }
}
