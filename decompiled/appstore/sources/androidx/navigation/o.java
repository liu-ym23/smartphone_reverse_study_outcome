package androidx.navigation;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.k0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3916b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f3917c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3918a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a(Class r10) {
            kotlin.jvm.internal.q.g(r10, "navigatorClass");
            String r11 = (String) o.a().get(r10);
            if (r11 != null) goto L13;
            Navigator.Name r12 = (Navigator.Name) r10.getAnnotation(Navigator.Name.class);
            if (r12 == null) goto L7;
            r11 = r12.value();
        L9:
            if (b(r11) == false) goto L12;
            o.a().put(r10, r11);
            goto L13
        L12:
            throw new IllegalArgumentException(("No @Navigator.Name annotation found for " + r10.getSimpleName()).toString());
        L7:
            r11 = null;
        L13:
            kotlin.jvm.internal.q.d(r11);
            return r11;
        }

        public final boolean b(String r10) {
            if (r10 != null) goto L4;
        L6:
            return false;
        L4:
            if (r10.length() <= 0) goto L6;
            return true;
        }

        public a() {
        }
    }

    static {
        f3916b = new a(null);
        f3917c = new LinkedHashMap();
    }

    public o() {
        this.f3918a = new LinkedHashMap();
    }

    public static final /* synthetic */ Map a() {
        return f3917c;
    }

    public final Navigator b(Navigator r10) {
        kotlin.jvm.internal.q.g(r10, "navigator");
        return c(f3916b.a(r10.getClass()), r10);
    }

    public Navigator c(String r10, Navigator r11) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "navigator");
        if (f3916b.b(r10) == false) goto L23;
        Navigator r12 = (Navigator) this.f3918a.get(r10);
        if (kotlin.jvm.internal.q.b(r12, r11) == false) goto L7;
        return r11;
    L7:
        boolean r13 = false;
        if (r12 == null) goto L13;
        if (r12.c() != true) goto L13;
        r13 = true;
    L13:
        if (r13 == true) goto L21;
        if (r11.c() == true) goto L19;
        return (Navigator) this.f3918a.put(r10, r11);
    L19:
        throw new IllegalStateException(("Navigator " + r11 + " is already attached to another NavController").toString());
    L21:
        throw new IllegalStateException(("Navigator " + r11 + " is replacing an already attached " + r12).toString());
    L23:
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public Navigator d(String r10) {
        kotlin.jvm.internal.q.g(r10, "name");
        if (f3916b.b(r10) == false) goto L10;
        Navigator r11 = (Navigator) this.f3918a.get(r10);
        if (r11 == null) goto L8;
        return r11;
    L8:
        throw new IllegalStateException("Could not find Navigator with name \"" + r10 + "\". You must call NavController.addNavigator() for each navigation type.");
    L10:
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public final Map e() {
        return k0.s(this.f3918a);
    }
}
