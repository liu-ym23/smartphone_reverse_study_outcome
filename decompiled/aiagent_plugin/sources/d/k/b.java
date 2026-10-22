package d.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Random;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends d.k.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f38512b;

    /* JADX INFO: compiled from: PlatformRandom.kt */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        @Override // java.lang.ThreadLocal
        public /* synthetic */ Random initialValue() {
            return a();
        }

        public Random a() {
            return new Random();
        }
    }

    public b() {
        this.f38512b = new a();
    }

    @Override // d.k.a
    public Random a() {
        Random r2 = this.f38512b.get();
        o.c(r2, "get(...)");
        return (Random) ZeusTransformUtils.preCheckCast(r2, Random.class, "com.obric.aiagent.plugin");
    }
}
