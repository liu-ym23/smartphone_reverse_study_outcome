package q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import n3.InterfaceC4938b;

/* renamed from: q3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5147c {

    /* renamed from: a, reason: collision with root package name */
    public final Map f38603a = new HashMap();

    /* renamed from: q3.c$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Class f38604a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC4938b f38605b;

        public <RemoteT extends AbstractC5146b> a(Class<RemoteT> cls, InterfaceC4938b<Object> interfaceC4938b) {
            this.f38604a = cls;
            this.f38605b = interfaceC4938b;
        }

        public final InterfaceC4938b a() {
            return this.f38605b;
        }

        public final Class b() {
            return this.f38604a;
        }
    }

    public C5147c(Set<a> set) {
        for (a aVar : set) {
            this.f38603a.put(aVar.b(), aVar.a());
        }
    }
}
