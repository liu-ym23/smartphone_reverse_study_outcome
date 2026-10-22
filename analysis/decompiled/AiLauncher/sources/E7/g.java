package E7;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.annotation.BaseUrl;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import tb.C5528A;
import tb.C5530C;
import tb.v;
import tb.w;
import yc.n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019¨\u0006\u001b"}, d2 = {"LE7/g;", "Ltb/w;", "Lkotlin/Function1;", "", "baseUrlResolver", "<init>", "(Lp9/l;)V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "rawBaseUrl", "Ltb/v;", "c", "(Ljava/lang/String;)Ltb/v;", "original", "target", Const.INTENT_KEY_PKGNAME, "(Ltb/v;Ltb/v;)Ltb/v;", "Lp9/l;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "urlCache", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<String, String> baseUrlResolver;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, v> urlCache;

    /* JADX WARN: Multi-variable type inference failed */
    public g(InterfaceC5074l<? super String, String> baseUrlResolver) {
        p.i(baseUrlResolver, "baseUrlResolver");
        this.baseUrlResolver = baseUrlResolver;
        this.urlCache = new ConcurrentHashMap<>();
    }

    public final void a() {
        this.urlCache.clear();
    }

    public final v b(v original, v target) {
        return original.j().t(target.getScheme()).g(target.getHost()).n(target.getPort()).c();
    }

    public final v c(String rawBaseUrl) {
        ConcurrentHashMap<String, v> concurrentHashMap = this.urlCache;
        v vVarD = concurrentHashMap.get(rawBaseUrl);
        if (vVarD == null) {
            vVarD = v.INSTANCE.d(rawBaseUrl);
            if (vVarD == null) {
                return null;
            }
            v vVarPutIfAbsent = concurrentHashMap.putIfAbsent(rawBaseUrl, vVarD);
            if (vVarPutIfAbsent != null) {
                vVarD = vVarPutIfAbsent;
            }
        }
        return vVarD;
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) {
        v vVarC;
        Method methodA;
        BaseUrl baseUrl;
        p.i(chain, "chain");
        C5528A request = chain.getRequest();
        n nVar = (n) request.j(n.class);
        String strKey = (nVar == null || (methodA = nVar.a()) == null || (baseUrl = (BaseUrl) methodA.getAnnotation(BaseUrl.class)) == null) ? null : baseUrl.key();
        String strE = request.e("Stepos-Base-Url");
        if (strKey == null) {
            strKey = strE;
        }
        if (strKey == null || H.x0(strKey)) {
            return chain.i(request);
        }
        String strInvoke = this.baseUrlResolver.invoke(strKey);
        return (strInvoke == null || (vVarC = c(strInvoke)) == null) ? chain.i(request.i().q("Stepos-Base-Url").b()) : chain.i(request.i().u(b(request.getUrl(), vVarC)).q("Stepos-Base-Url").b());
    }
}
