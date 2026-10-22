package v;

import D.C;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.x;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v.C5649f;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lv/f;", "Landroidx/camera/core/impl/x;", "Landroidx/camera/core/impl/Config;", "config", "", "unused", "<init>", "(Landroidx/camera/core/impl/Config;Z)V", "(Landroidx/camera/core/impl/Config;)V", "getConfig", "()Landroidx/camera/core/impl/Config;", "R", "Landroidx/camera/core/impl/Config;", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: v.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5649f implements x {

    /* renamed from: R, reason: collision with root package name and from kotlin metadata */
    public final Config config;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \b2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\r"}, d2 = {"Lv/f$a;", "LD/C;", "Lv/f;", "<init>", "()V", "Landroidx/camera/core/impl/t;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/core/impl/t;", Const.INTENT_KEY_PKGNAME, "()Lv/f;", "Landroidx/camera/core/impl/u;", "Landroidx/camera/core/impl/u;", "mutableOptionsBundle", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: v.f$a */
    public static final class a implements C<C5649f> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final u mutableOptionsBundle;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lv/f$a$a;", "", "<init>", "()V", "Landroidx/camera/core/impl/Config;", "config", "Lv/f$a;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/impl/Config;)Lv/f$a;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: v.f$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public static final boolean c(a aVar, Config config, Config.a it) {
                p.i(it, "it");
                aVar.a().q(it, config.h(it), config.a(it));
                return true;
            }

            public final a b(final Config config) {
                p.i(config, "config");
                final a aVar = new a();
                config.c("camera2.captureRequest.option.", new Config.b() { // from class: v.e
                    @Override // androidx.camera.core.impl.Config.b
                    public final boolean a(Config.a aVar2) {
                        return C5649f.a.Companion.c(aVar, config, aVar2);
                    }
                });
                return aVar;
            }

            public Companion() {
            }
        }

        public a() {
            u uVarK0 = u.k0();
            p.h(uVarK0, "create(...)");
            this.mutableOptionsBundle = uVarK0;
        }

        @Override // D.C
        public t a() {
            return this.mutableOptionsBundle;
        }

        public C5649f b() {
            v vVarJ0 = v.j0(this.mutableOptionsBundle);
            p.h(vVarJ0, "from(...)");
            return new C5649f(vVarJ0);
        }
    }

    public C5649f(Config config, boolean z10) {
        this.config = config;
    }

    @Override // androidx.camera.core.impl.x
    public Config getConfig() {
        return this.config;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5649f(Config config) {
        this(config, false);
        p.i(config, "config");
    }
}
