package E7;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import tb.C5528A;
import tb.C5530C;
import tb.w;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"LE7/c;", "Ltb/w;", "Landroid/content/Context;", "context", "", "clientType", "", "startOaidOnFirstRequest", "<init>", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Z", "c", "Landroid/content/Context;", "appContext", Const.INTENT_KEY_UMID, "LY8/h;", "f", "()Ljava/lang/String;", "appVersionName", "e", "appVersionCode", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String clientType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean startOaidOnFirstRequest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context appContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Y8.h appVersionName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Y8.h appVersionCode;

    public c(Context context, String clientType, boolean z10) {
        p.i(context, "context");
        p.i(clientType, "clientType");
        this.clientType = clientType;
        this.startOaidOnFirstRequest = z10;
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
        this.appVersionName = C4848b.b(new InterfaceC5063a() { // from class: E7.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return c.d(this.f2389a);
            }
        });
        this.appVersionCode = C4848b.b(new InterfaceC5063a() { // from class: E7.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return c.c(this.f2390a);
            }
        });
    }

    public static final String c(c cVar) {
        return String.valueOf(J7.a.f3739a.a(cVar.appContext));
    }

    public static final String d(c cVar) {
        return J7.a.f3739a.b(cVar.appContext);
    }

    public final String e() {
        return (String) this.appVersionCode.getValue();
    }

    public final String f() {
        return (String) this.appVersionName.getValue();
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) {
        p.i(chain, "chain");
        if (this.startOaidOnFirstRequest) {
            J7.c.d(this.appContext);
        }
        C5528A.a aVarA = chain.getRequest().i().a("zy-device-id", J7.c.b());
        J7.a aVar = J7.a.f3739a;
        C5528A.a aVarA2 = aVarA.a("zy-device-model", aVar.d()).a("zy-device-brand", aVar.c()).a("zy-client-type", this.clientType);
        String languageTag = Locale.getDefault().toLanguageTag();
        p.h(languageTag, "toLanguageTag(...)");
        return chain.i(aVarA2.a("zy-client-lang", languageTag).a("zy-system-ver", aVar.e()).a("zy-app-ver-name", f()).a("zy-app-ver-code", e()).b());
    }

    public /* synthetic */ c(Context context, String str, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? "Android" : str, (i10 & 4) != 0 ? false : z10);
    }
}
