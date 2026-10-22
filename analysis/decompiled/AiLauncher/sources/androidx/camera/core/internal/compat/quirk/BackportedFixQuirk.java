package androidx.camera.core.internal.compat.quirk;

import K.s0;
import Y8.h;
import android.annotation.SuppressLint;
import androidx.camera.core.internal.compat.quirk.BackportedFixQuirk;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import p9.InterfaceC5063a;
import r0.C5196a;
import r0.c;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/camera/core/internal/compat/quirk/BackportedFixQuirk;", "LK/s0;", "<init>", "()V", "Lr0/c;", "f", "()Lr0/c;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public abstract class BackportedFixQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final h<C5196a> f11594c = C4848b.b(new InterfaceC5063a() { // from class: R.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return BackportedFixQuirk.e();
        }
    });

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/camera/core/internal/compat/quirk/BackportedFixQuirk$a;", "", "<init>", "()V", "Lr0/a;", "backportedFixManager$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lr0/a;", "backportedFixManager", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.core.internal.compat.quirk.BackportedFixQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final C5196a a() {
            return (C5196a) BackportedFixQuirk.f11594c.getValue();
        }

        public Companion() {
        }
    }

    public static final C5196a e() {
        return new C5196a();
    }

    public abstract c f();

    public final boolean g() {
        return !INSTANCE.a().b(f());
    }
}
