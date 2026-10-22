package g1;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import g1.C4090a;
import h1.C4122b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0011\nB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a¨\u0006\u001c"}, d2 = {"Lg1/e;", "", "Lh1/b;", "impl", "<init>", "(Lh1/b;)V", "", "key", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroid/os/Bundle;", "Lg1/e$b;", Const.JSON_KEY_PROVIDER, "LY8/t;", "c", "(Ljava/lang/String;Lg1/e$b;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lg1/e$b;", "Ljava/lang/Class;", "Lg1/e$a;", "clazz", Const.INTENT_KEY_UMID, "(Ljava/lang/Class;)V", "Lh1/b;", "Lg1/a$b;", "Lg1/a$b;", "recreatorProvider", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C4122b impl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public C4090a.b recreatorProvider;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lg1/e$a;", "", "Lg1/h;", "owner", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lg1/h;)V", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void a(h owner);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lg1/e$b;", "", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", Const.INTENT_KEY_APIKEY, "()Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        Bundle a();
    }

    public e(C4122b impl) {
        p.i(impl, "impl");
        this.impl = impl;
    }

    public final Bundle a(String key) {
        p.i(key, "key");
        return this.impl.c(key);
    }

    public final b b(String key) {
        p.i(key, "key");
        return this.impl.d(key);
    }

    public final void c(String key, b provider) {
        p.i(key, "key");
        p.i(provider, "provider");
        this.impl.j(key, provider);
    }

    public final void d(Class<? extends a> clazz) throws NoSuchMethodException, SecurityException {
        p.i(clazz, "clazz");
        if (!this.impl.getIsAllowingSavingState()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        C4090a.b bVar = this.recreatorProvider;
        if (bVar == null) {
            bVar = new C4090a.b(this);
        }
        this.recreatorProvider = bVar;
        try {
            clazz.getDeclaredConstructor(null);
            C4090a.b bVar2 = this.recreatorProvider;
            if (bVar2 != null) {
                String name = clazz.getName();
                p.h(name, "getName(...)");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
