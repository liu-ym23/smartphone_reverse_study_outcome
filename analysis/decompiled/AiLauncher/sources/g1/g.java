package g1;

import Y8.t;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import g1.g;
import h1.C4122b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\tj\u0002`\nH\u0007¢\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0017"}, d2 = {"Lg1/g;", "", "Lh1/b;", "impl", "<init>", "(Lh1/b;)V", "LY8/t;", "c", "()V", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "savedState", Const.INTENT_KEY_UMID, "(Landroid/os/Bundle;)V", "outBundle", "e", Const.INTENT_KEY_APIKEY, "Lh1/b;", "Lg1/e;", Const.INTENT_KEY_PKGNAME, "Lg1/e;", "()Lg1/e;", "savedStateRegistry", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C4122b impl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final e savedStateRegistry;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lg1/g$a;", "", "<init>", "()V", "Lg1/h;", "owner", "Lg1/g;", Const.INTENT_KEY_PKGNAME, "(Lg1/h;)Lg1/g;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: g1.g$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final t c(h hVar) {
            hVar.getLifecycle().a(new C4090a(hVar));
            return t.f7040a;
        }

        public final g b(final h owner) {
            p.i(owner, "owner");
            return new g(new C4122b(owner, new InterfaceC5063a() { // from class: g1.f
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return g.Companion.c(owner);
                }
            }), null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ g(C4122b c4122b, kotlin.jvm.internal.i iVar) {
        this(c4122b);
    }

    public static final g a(h hVar) {
        return INSTANCE.b(hVar);
    }

    /* renamed from: b, reason: from getter */
    public final e getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    public final void c() {
        this.impl.f();
    }

    public final void d(Bundle savedState) {
        this.impl.h(savedState);
    }

    public final void e(Bundle outBundle) {
        p.i(outBundle, "outBundle");
        this.impl.i(outBundle);
    }

    public g(C4122b c4122b) {
        this.impl = c4122b;
        this.savedStateRegistry = new e(c4122b);
    }
}
