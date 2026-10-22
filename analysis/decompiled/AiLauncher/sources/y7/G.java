package y7;

import A7.C0742j;
import A7.C0743k;
import A7.C0744l;
import A7.C0746n;
import A7.C0755x;
import A7.C0757z;
import A7.K;
import A7.L;
import A7.P;
import A7.S;
import A7.Y;
import A7.Z;
import android.content.Context;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import y7.q;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000f\u0010\bR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\u0015\u0010\bR \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u000b\u0010\b¨\u0006\u001a"}, d2 = {"Ly7/G;", "", "<init>", "()V", "Ly7/C;", "LA7/n;", Const.INTENT_KEY_PKGNAME, "Ly7/C;", "()Ly7/C;", "Blur", "LA7/Z;", "c", "f", "Stroke", "LA7/L;", Const.INTENT_KEY_UMID, "InnerShadow", "LA7/S;", "e", "Refraction", "LA7/k;", Const.INTENT_KEY_APIKEY, "Blend", "LA7/z;", Const.INTENT_KEY_BACKGROUND_COMMAND, "GlassText", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public static final G f43879a = new G();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final C<C0746n> Blur = new C0744l();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final C<Z> Stroke = new Y();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final C<L> InnerShadow = new K();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final C<S> Refraction = new P();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final C<C0743k> Blend = new C0742j();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final C<C0757z> GlassText = new C0755x();

    @Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0014\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0014\u0010'\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Ly7/G$a;", "Ly7/C;", "LA7/B;", "<init>", "()V", "e", "()LA7/B;", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "Landroid/view/View;", "view", "params", "Ly7/s;", Const.INTENT_KEY_UMID, "(Landroid/view/View;LA7/B;)Ly7/s;", "Ly7/q;", "tier", "y7/G$a$a", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ly7/q;)Ly7/G$a$a;", "LA7/A;", Const.INTENT_KEY_PKGNAME, "LA7/A;", "impl", "c", "Ly7/C;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ly7/C;", "TOP_SHORT", "f", "BOTTOM_SHORT", "getTOP_TALL", "TOP_TALL", "", "getId", "()Ljava/lang/String;", "id", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements C<A7.B> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f43886a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final A7.A impl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final C<A7.B> TOP_SHORT;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public static final C<A7.B> BOTTOM_SHORT;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public static final C<A7.B> TOP_TALL;

        @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"y7/G$a$a", "Ly7/C;", "LA7/B;", Const.INTENT_KEY_UMID, "()LA7/B;", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "Landroid/view/View;", "view", "params", "Ly7/s;", "c", "(Landroid/view/View;LA7/B;)Ly7/s;", "", "getId", "()Ljava/lang/String;", "id", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* renamed from: y7.G$a$a, reason: collision with other inner class name */
        public static final class C0557a implements C<A7.B> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f43891a;

            public C0557a(q qVar) {
                this.f43891a = qVar;
            }

            @Override // y7.C
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public s a(View view, A7.B params) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(params, "params");
                return a.impl.a(view, params);
            }

            @Override // y7.C
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public A7.B get$params() {
                A7.B b10 = new A7.B();
                r.c(b10, this.f43891a);
                return b10;
            }

            @Override // y7.C
            public String getId() {
                return a.impl.getId();
            }

            @Override // y7.C
            public boolean isSupported(Context context) {
                kotlin.jvm.internal.p.i(context, "context");
                return a.impl.isSupported(context);
            }
        }

        static {
            a aVar = new a();
            f43886a = aVar;
            impl = new A7.A();
            q.Companion companion = q.INSTANCE;
            TOP_SHORT = aVar.h(companion.c());
            BOTTOM_SHORT = aVar.h(companion.b());
            TOP_TALL = aVar.h(companion.d());
        }

        @Override // y7.C
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public s a(View view, A7.B params) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(params, "params");
            return impl.a(view, params);
        }

        @Override // y7.C
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public A7.B get$params() {
            return impl.get$params();
        }

        public final C<A7.B> f() {
            return BOTTOM_SHORT;
        }

        public final C<A7.B> g() {
            return TOP_SHORT;
        }

        @Override // y7.C
        public String getId() {
            return impl.getId();
        }

        public final C0557a h(q tier) {
            return new C0557a(tier);
        }

        @Override // y7.C
        public boolean isSupported(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            return impl.isSupported(context);
        }
    }

    public final C<C0743k> a() {
        return Blend;
    }

    public final C<C0746n> b() {
        return Blur;
    }

    public final C<C0757z> c() {
        return GlassText;
    }

    public final C<L> d() {
        return InnerShadow;
    }

    public final C<S> e() {
        return Refraction;
    }

    public final C<Z> f() {
        return Stroke;
    }
}
