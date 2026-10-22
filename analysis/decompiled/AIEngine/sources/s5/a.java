package s5;

import java.util.concurrent.Future;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface a {
    default Future<Boolean> a(String str) {
        throw new UnsupportedOperationException("submitRisk is only for async modules");
    }

    boolean b(String str);

    default boolean c() {
        return false;
    }
}
