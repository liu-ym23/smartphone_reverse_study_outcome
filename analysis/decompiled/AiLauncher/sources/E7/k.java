package E7;

import La.D;
import O6.l;
import com.autonavi.aps.amapapi.config.Const;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import tb.C5528A;
import tb.C5530C;
import tb.w;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\rB!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"LE7/k;", "Ltb/w;", "", "headerName", "Lkotlin/Function0;", "idGenerator", "<init>", "(Ljava/lang/String;Lp9/a;)V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lp9/a;", "c", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class k implements w {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String headerName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<String> idGenerator;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LE7/k$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E7.k$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a() {
            String string = UUID.randomUUID().toString();
            p.h(string, "toString(...)");
            return D.T(string, l.DATE_SEPARATOR, "", false, 4, null);
        }

        public Companion() {
        }
    }

    public k(String headerName, InterfaceC5063a<String> idGenerator) {
        p.i(headerName, "headerName");
        p.i(idGenerator, "idGenerator");
        this.headerName = headerName;
        this.idGenerator = idGenerator;
    }

    public static final String b() {
        return INSTANCE.a();
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) {
        p.i(chain, "chain");
        C5528A request = chain.getRequest();
        return request.e(this.headerName) != null ? chain.i(request) : chain.i(request.i().l(this.headerName, this.idGenerator.invoke()).b());
    }

    public /* synthetic */ k(String str, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "X-Request-Id" : str, (i10 & 2) != 0 ? new InterfaceC5063a() { // from class: E7.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return k.b();
            }
        } : interfaceC5063a);
    }
}
