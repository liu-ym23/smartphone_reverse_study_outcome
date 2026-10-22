package f5;

import java.io.Serializable;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i implements h, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final i f2626a = new i();

    public final int hashCode() {
        return 0;
    }

    @Override // f5.h
    public final f o(g key) {
        p.e(key, "key");
        return null;
    }

    @Override // f5.h
    public final h s(g key) {
        p.e(key, "key");
        return this;
    }

    @Override // f5.h
    public final h t(h context) {
        p.e(context, "context");
        return context;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // f5.h
    public final Object z(Object obj, p5.p pVar) {
        return obj;
    }
}
