package kotlin.jvm.internal;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import w9.InterfaceC5744c;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkotlin/jvm/internal/s;", "Lkotlin/jvm/internal/f;", "Ljava/lang/Class;", "jClass", "", "moduleName", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/Class;", "m", "()Ljava/lang/Class;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "", "Lw9/c;", "()Ljava/util/Collection;", "members", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class s implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Class<?> jClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String moduleName;

    public s(Class<?> jClass, String moduleName) {
        p.i(jClass, "jClass");
        p.i(moduleName, "moduleName");
        this.jClass = jClass;
        this.moduleName = moduleName;
    }

    @Override // w9.InterfaceC5747f
    public Collection<InterfaceC5744c<?>> b() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object other) {
        return (other instanceof s) && p.d(m(), ((s) other).m());
    }

    public int hashCode() {
        return m().hashCode();
    }

    @Override // kotlin.jvm.internal.f
    public Class<?> m() {
        return this.jClass;
    }

    public String toString() {
        return m().toString() + " (Kotlin reflection is not available)";
    }
}
