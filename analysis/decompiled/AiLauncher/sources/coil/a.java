package coil;

import A1.k;
import Y8.j;
import Z8.C1173v;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import coil.decode.c;
import coil.fetch.f;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x1.InterfaceC5843b;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001)B«\u0001\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00120\u0010\b\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u00050\u0002\u0012(\u0010\n\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u00050\u0002\u0012(\u0010\f\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u00050\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J?\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 J?\u0010$\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b$\u0010%J\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,RA\u0010\b\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u00050\u00028\u0006¢\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b.\u0010,R9\u0010\n\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u00050\u00028\u0006¢\u0006\f\n\u0004\b+\u0010*\u001a\u0004\b/\u0010,R9\u0010\f\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u00050\u00028\u0006¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010,R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0006¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b)\u0010,¨\u00060"}, d2 = {"Lcoil/a;", "", "", "Lcoil/intercept/a;", "interceptors", "Lkotlin/Pair;", "Ly1/d;", "Ljava/lang/Class;", "mappers", "Lx1/b;", "keyers", "Lcoil/fetch/f$a;", "fetcherFactories", "Lcoil/decode/c$a;", "decoderFactories", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "()V", "data", "LA1/k;", "options", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;LA1/k;)Ljava/lang/Object;", "", "f", "(Ljava/lang/Object;LA1/k;)Ljava/lang/String;", "Lcoil/c;", "imageLoader", "", "startIndex", "Lcoil/fetch/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Object;LA1/k;Lcoil/c;I)Lkotlin/Pair;", "Lw1/c;", "result", "Lcoil/decode/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw1/c;LA1/k;Lcoil/c;I)Lkotlin/Pair;", "Lcoil/a$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcoil/a$a;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "c", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "e", Const.INTENT_KEY_UMID, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<coil.intercept.a> interceptors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<Pair<y1.d<? extends Object, ? extends Object>, Class<? extends Object>>> mappers;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final List<Pair<InterfaceC5843b<? extends Object>, Class<? extends Object>>> keyers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<Pair<f.a<? extends Object>, Class<? extends Object>>> fetcherFactories;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final List<c.a> decoderFactories;

    public /* synthetic */ a(List list, List list2, List list3, List list4, List list5, i iVar) {
        this(list, list2, list3, list4, list5);
    }

    public final List<c.a> a() {
        return this.decoderFactories;
    }

    public final List<Pair<f.a<? extends Object>, Class<? extends Object>>> b() {
        return this.fetcherFactories;
    }

    public final List<coil.intercept.a> c() {
        return this.interceptors;
    }

    public final List<Pair<InterfaceC5843b<? extends Object>, Class<? extends Object>>> d() {
        return this.keyers;
    }

    public final List<Pair<y1.d<? extends Object, ? extends Object>, Class<? extends Object>>> e() {
        return this.mappers;
    }

    public final String f(Object data, k options) {
        List<Pair<InterfaceC5843b<? extends Object>, Class<? extends Object>>> list = this.keyers;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Pair<InterfaceC5843b<? extends Object>, Class<? extends Object>> pair = list.get(i10);
            InterfaceC5843b<? extends Object> interfaceC5843bA = pair.a();
            if (pair.b().isAssignableFrom(data.getClass())) {
                p.g(interfaceC5843bA, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String strA = interfaceC5843bA.a(data, options);
                if (strA != null) {
                    return strA;
                }
            }
        }
        return null;
    }

    public final Object g(Object data, k options) {
        List<Pair<y1.d<? extends Object, ? extends Object>, Class<? extends Object>>> list = this.mappers;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Pair<y1.d<? extends Object, ? extends Object>, Class<? extends Object>> pair = list.get(i10);
            y1.d<? extends Object, ? extends Object> dVarA = pair.a();
            if (pair.b().isAssignableFrom(data.getClass())) {
                p.g(dVarA, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                Object objA = dVarA.a(data, options);
                if (objA != null) {
                    data = objA;
                }
            }
        }
        return data;
    }

    public final C0194a h() {
        return new C0194a(this);
    }

    public final Pair<coil.decode.c, Integer> i(w1.c result, k options, c imageLoader, int startIndex) {
        int size = this.decoderFactories.size();
        while (startIndex < size) {
            coil.decode.c cVarA = this.decoderFactories.get(startIndex).a(result, options, imageLoader);
            if (cVarA != null) {
                return j.a(cVarA, Integer.valueOf(startIndex));
            }
            startIndex++;
        }
        return null;
    }

    public final Pair<f, Integer> j(Object data, k options, c imageLoader, int startIndex) {
        int size = this.fetcherFactories.size();
        while (startIndex < size) {
            Pair<f.a<? extends Object>, Class<? extends Object>> pair = this.fetcherFactories.get(startIndex);
            f.a<? extends Object> aVarA = pair.a();
            if (pair.b().isAssignableFrom(data.getClass())) {
                p.g(aVarA, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                f fVarA = aVarA.a(data, options, imageLoader);
                if (fVarA != null) {
                    return j.a(fVarA, Integer.valueOf(startIndex));
                }
            }
            startIndex++;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends coil.intercept.a> list, List<? extends Pair<? extends y1.d<? extends Object, ? extends Object>, ? extends Class<? extends Object>>> list2, List<? extends Pair<? extends InterfaceC5843b<? extends Object>, ? extends Class<? extends Object>>> list3, List<? extends Pair<? extends f.a<? extends Object>, ? extends Class<? extends Object>>> list4, List<? extends c.a> list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.fetcherFactories = list4;
        this.decoderFactories = list5;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J7\u0010\f\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0010\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0014\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR@\u0010#\u001a(\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n0!0\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\"\u0010\u001fR<\u0010%\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n0!0\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b$\u0010\u001fR<\u0010'\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n0!0\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b&\u0010\u001fR \u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b(\u0010\u001f¨\u0006*"}, d2 = {"Lcoil/a$a;", "", "<init>", "()V", "Lcoil/a;", "registry", "(Lcoil/a;)V", ExifInterface.GPS_DIRECTION_TRUE, "Ly1/d;", "mapper", "Ljava/lang/Class;", "type", Const.INTENT_KEY_UMID, "(Ly1/d;Ljava/lang/Class;)Lcoil/a$a;", "Lx1/b;", "keyer", "c", "(Lx1/b;Ljava/lang/Class;)Lcoil/a$a;", "Lcoil/fetch/f$a;", "factory", Const.INTENT_KEY_PKGNAME, "(Lcoil/fetch/f$a;Ljava/lang/Class;)Lcoil/a$a;", "Lcoil/decode/c$a;", Const.INTENT_KEY_APIKEY, "(Lcoil/decode/c$a;)Lcoil/a$a;", "e", "()Lcoil/a;", "", "Lcoil/intercept/a;", "Ljava/util/List;", "getInterceptors$coil_base_release", "()Ljava/util/List;", "interceptors", "Lkotlin/Pair;", "getMappers$coil_base_release", "mappers", "getKeyers$coil_base_release", "keyers", Const.INTENT_KEY_BACKGROUND_COMMAND, "fetcherFactories", "f", "decoderFactories", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: coil.a$a, reason: collision with other inner class name */
    public static final class C0194a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<coil.intercept.a> interceptors;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final List<Pair<y1.d<? extends Object, ?>, Class<? extends Object>>> mappers;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final List<Pair<InterfaceC5843b<? extends Object>, Class<? extends Object>>> keyers;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final List<Pair<f.a<? extends Object>, Class<? extends Object>>> fetcherFactories;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final List<c.a> decoderFactories;

        public C0194a() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.keyers = new ArrayList();
            this.fetcherFactories = new ArrayList();
            this.decoderFactories = new ArrayList();
        }

        public final C0194a a(c.a factory) {
            this.decoderFactories.add(factory);
            return this;
        }

        public final <T> C0194a b(f.a<T> factory, Class<T> type) {
            this.fetcherFactories.add(j.a(factory, type));
            return this;
        }

        public final <T> C0194a c(InterfaceC5843b<T> keyer, Class<T> type) {
            this.keyers.add(j.a(keyer, type));
            return this;
        }

        public final <T> C0194a d(y1.d<T, ?> mapper, Class<T> type) {
            this.mappers.add(j.a(mapper, type));
            return this;
        }

        public final a e() {
            return new a(F1.c.a(this.interceptors), F1.c.a(this.mappers), F1.c.a(this.keyers), F1.c.a(this.fetcherFactories), F1.c.a(this.decoderFactories), null);
        }

        public final List<c.a> f() {
            return this.decoderFactories;
        }

        public final List<Pair<f.a<? extends Object>, Class<? extends Object>>> g() {
            return this.fetcherFactories;
        }

        public C0194a(a aVar) {
            this.interceptors = F.p1(aVar.c());
            this.mappers = F.p1(aVar.e());
            this.keyers = F.p1(aVar.d());
            this.fetcherFactories = F.p1(aVar.b());
            this.decoderFactories = F.p1(aVar.a());
        }
    }

    public a() {
        this(C1173v.m(), C1173v.m(), C1173v.m(), C1173v.m(), C1173v.m());
    }
}
