package Z6;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.objectbox.BoxStore;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"LZ6/d;", "", "Lio/objectbox/BoxStore;", "boxStore", "<init>", "(Lio/objectbox/BoxStore;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "entityClass", "LZ6/a;", "c", "(Lw9/d;)LZ6/a;", Const.INTENT_KEY_APIKEY, "Lio/objectbox/BoxStore;", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "repositoryCache", "Companion", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static volatile d f7296c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final BoxStore boxStore;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<InterfaceC5745d<?>, a<?>> repositoryCache;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"LZ6/d$a;", "", "<init>", "()V", "Lio/objectbox/BoxStore;", "boxStore", "LZ6/d;", Const.INTENT_KEY_APIKEY, "(Lio/objectbox/BoxStore;)LZ6/d;", "INSTANCE", "LZ6/d;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: Z6.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final d a(BoxStore boxStore) {
            d dVar;
            p.i(boxStore, "boxStore");
            d dVar2 = d.f7296c;
            if (dVar2 != null) {
                return dVar2;
            }
            synchronized (this) {
                dVar = d.f7296c;
                if (dVar == null) {
                    dVar = new d(boxStore, null);
                    d.f7296c = dVar;
                }
            }
            return dVar;
        }

        public Companion() {
        }
    }

    public /* synthetic */ d(BoxStore boxStore, i iVar) {
        this(boxStore);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> a<T> c(InterfaceC5745d<T> entityClass) {
        p.i(entityClass, "entityClass");
        Map<InterfaceC5745d<?>, a<?>> map = this.repositoryCache;
        Object objA = map.get(entityClass);
        if (objA == null) {
            objA = c.f7295a.a(this.boxStore, entityClass);
            map.put(entityClass, objA);
        }
        p.g(objA, "null cannot be cast to non-null type com.stepos.datacenter.core.structured.BaseRepository<T of com.stepos.datacenter.core.structured.RepositoryManager.getRepository>");
        return (a) objA;
    }

    public d(BoxStore boxStore) {
        this.boxStore = boxStore;
        this.repositoryCache = new LinkedHashMap();
    }
}
