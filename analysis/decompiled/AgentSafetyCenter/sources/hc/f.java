package hc;

import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.regex.Matcher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    public Matcher f5461a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f5462b;

    /* renamed from: c, reason: collision with root package name */
    public e f5463c;

    public final List a() {
        if (this.f5463c == null) {
            e eVar = new e(false, 0);
            eVar.f5460g = this;
            VarHandle.storeStoreFence();
            this.f5463c = eVar;
        }
        e eVar2 = this.f5463c;
        eVar2.getClass();
        return eVar2;
    }
}
