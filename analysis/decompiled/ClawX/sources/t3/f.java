package t3;

import io.ktor.client.engine.android.AndroidEngineContainer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlin.jvm.internal.p;
import w5.k;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final x3.a f5582a;

    static {
        try {
            Iterator it = Arrays.asList(new AndroidEngineContainer()).iterator();
            p.d(it, "iterator(...)");
            Iterator it2 = ((w5.a) k.w0(it)).iterator();
            if (((e) (!it2.hasNext() ? null : it2.next())) == null) {
                throw new IllegalStateException("Failed to find HTTP client engine implementation: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html");
            }
            f5582a = x3.a.f6253a;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
