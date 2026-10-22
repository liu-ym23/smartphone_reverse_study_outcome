package androidx.lifecycle.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: CreationExtras.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<b<?>, Object> f1966a;

    /* JADX INFO: renamed from: androidx.lifecycle.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CreationExtras.kt */
    public static final class C0057a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0057a f1967a = null;

        static {
            f1967a = new C0057a();
        }

        @Override // androidx.lifecycle.a.a
        public <T> T a(b<T> r2) {
            o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "key");
            return null;
        }

        private C0057a() {
        }
    }

    /* JADX INFO: compiled from: CreationExtras.kt */
    public interface b<T> {
    }

    public abstract <T> T a(b<T> r1);

    public a() {
        this.f1966a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final Map<b<?>, Object> a() {
        return this.f1966a;
    }
}
