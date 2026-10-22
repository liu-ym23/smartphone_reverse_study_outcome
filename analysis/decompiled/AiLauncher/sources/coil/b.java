package coil;

import A1.e;
import A1.g;
import A1.k;
import A1.o;
import B1.Size;
import android.graphics.Bitmap;
import coil.b;
import coil.fetch.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import u1.C5569b;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 02\u00020\u0001:\u00025\u0005J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0011\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0012\u0010\u000fJ!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u0018H\u0017¢\u0006\u0004\b\"\u0010#J1\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010$H\u0017¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020'H\u0017¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020'H\u0017¢\u0006\u0004\b*\u0010)J\u001f\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0017¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0017¢\u0006\u0004\b/\u0010.J\u0017\u00100\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b0\u0010\u0006J\u001f\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u000201H\u0017¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u000204H\u0017¢\u0006\u0004\b5\u00106ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00067À\u0006\u0003"}, d2 = {"Lcoil/b;", "LA1/g$b;", "LA1/g;", "request", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LA1/g;)V", "l", "LB1/g;", ContentDisposition.Parameters.Size, Const.INTENT_KEY_BACKGROUND_COMMAND, "(LA1/g;LB1/g;)V", "", "input", "r", "(LA1/g;Ljava/lang/Object;)V", "output", "f", "q", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LA1/g;Ljava/lang/String;)V", "Lcoil/fetch/f;", "fetcher", "LA1/k;", "options", "e", "(LA1/g;Lcoil/fetch/f;LA1/k;)V", "Lw1/b;", "result", "k", "(LA1/g;Lcoil/fetch/f;LA1/k;Lw1/b;)V", "Lcoil/decode/c;", "decoder", "o", "(LA1/g;Lcoil/decode/c;LA1/k;)V", "Lu1/b;", "p", "(LA1/g;Lcoil/decode/c;LA1/k;Lu1/b;)V", "Landroid/graphics/Bitmap;", "n", "(LA1/g;Landroid/graphics/Bitmap;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LE1/b;", "transition", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LA1/g;LE1/b;)V", "m", Const.INTENT_KEY_APIKEY, "LA1/e;", Const.INTENT_KEY_UMID, "(LA1/g;LA1/e;)V", "LA1/o;", "c", "(LA1/g;LA1/o;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface b extends g.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f15558a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f15557b = new a();

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil/b$a", "Lcoil/b;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements b {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lcoil/b$b;", "", "<init>", "()V", "Lcoil/b;", ModelFlowMeta.PLAN_NONE, "Lcoil/b;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: coil.b$b, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15558a = new Companion();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcoil/b$c;", "", "LA1/g;", "request", "Lcoil/b;", "c", "(LA1/g;)Lcoil/b;", Const.INTENT_KEY_APIKEY, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = Companion.f15561a;

        /* renamed from: b, reason: collision with root package name */
        public static final c f15560b = new c() { // from class: t1.b
            @Override // coil.b.c
            public final coil.b c(g gVar) {
                return b.c.a(gVar);
            }
        };

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lcoil/b$c$a;", "", "<init>", "()V", "Lcoil/b$c;", ModelFlowMeta.PLAN_NONE, "Lcoil/b$c;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* renamed from: coil.b$c$a, reason: from kotlin metadata */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Companion f15561a = new Companion();
        }

        static b a(g gVar) {
            return b.f15557b;
        }

        b c(g request);
    }

    @Override // A1.g.b
    default void a(g request) {
    }

    @Override // A1.g.b
    default void b(g request) {
    }

    @Override // A1.g.b
    default void c(g request, o result) {
    }

    @Override // A1.g.b
    default void d(g request, e result) {
    }

    default void e(g request, f fetcher, k options) {
    }

    default void f(g request, Object output) {
    }

    default void g(g request, Size size) {
    }

    default void h(g request, String output) {
    }

    default void i(g request, Bitmap output) {
    }

    default void j(g request, E1.b transition) {
    }

    default void k(g request, f fetcher, k options, w1.b result) {
    }

    default void l(g request) {
    }

    default void m(g request, E1.b transition) {
    }

    default void n(g request, Bitmap input) {
    }

    default void o(g request, coil.decode.c decoder, k options) {
    }

    default void p(g request, coil.decode.c decoder, k options, C5569b result) {
    }

    default void q(g request, Object input) {
    }

    default void r(g request, Object input) {
    }
}
