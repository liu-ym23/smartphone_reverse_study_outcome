package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: MatchResult.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface i {

    /* JADX INFO: compiled from: MatchResult.kt */
    public static final class a {
        public static b a(i r2) {
            return new b((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MatchResult.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i f38638a;

        public b(i r3) {
            i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "match");
            this.f38638a = r4;
        }

        public final i a() {
            return this.f38638a;
        }
    }

    d.l.j a();

    String b();

    g c();

    List<String> d();

    b e();

    i f();
}
