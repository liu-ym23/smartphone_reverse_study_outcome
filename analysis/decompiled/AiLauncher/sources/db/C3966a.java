package db;

import Ua.M0;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.i;
import vc.f;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u00040\u00012\u00020\u0005:\u0001\u0012B#\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0011\u001a\u00020\u000e2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bR)\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Ldb/a;", "LUa/M0;", "", "", "Lkotlinx/coroutines/slf4j/MDCContextMap;", "Lkotlin/coroutines/a;", "contextMap", "<init>", "(Ljava/util/Map;)V", "Lkotlin/coroutines/d;", "context", "l1", "(Lkotlin/coroutines/d;)Ljava/util/Map;", "oldState", "LY8/t;", "h1", "(Lkotlin/coroutines/d;Ljava/util/Map;)V", "k1", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "getContextMap", "()Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "kotlinx-coroutines-slf4j"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: db.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3966a extends kotlin.coroutines.a implements M0<Map<String, ? extends String>> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<String, String> contextMap;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldb/a$a;", "Lkotlin/coroutines/d$c;", "Ldb/a;", "<init>", "()V", "kotlinx-coroutines-slf4j"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: db.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion implements d.c<C3966a> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3966a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // Ua.M0
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void e0(d context, Map<String, String> oldState) {
        k1(oldState);
    }

    public final void k1(Map<String, String> contextMap) {
        if (contextMap == null) {
            f.a();
        } else {
            f.f(contextMap);
        }
    }

    @Override // Ua.M0
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public Map<String, String> f1(d context) {
        Map<String, String> mapC = f.c();
        k1(this.contextMap);
        return mapC;
    }

    public /* synthetic */ C3966a(Map map, int i10, i iVar) {
        this((i10 & 1) != 0 ? f.c() : map);
    }

    public C3966a(Map<String, String> map) {
        super(INSTANCE);
        this.contextMap = map;
    }
}
