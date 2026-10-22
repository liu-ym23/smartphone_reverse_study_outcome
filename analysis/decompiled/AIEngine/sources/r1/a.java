package r1;

import com.stepos.core.ota.d;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final y f11681a = new y();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f11682b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f11683c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f11684d;

    public static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                d.q(autoCloseable);
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }
}
