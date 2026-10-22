package s9;

import java.util.Arrays;
import java.util.Collection;
import java.util.ServiceConfigurationError;
import n9.C1746b;

/* renamed from: s9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1924d {

    /* renamed from: a, reason: collision with root package name */
    public static final Collection f5998a;

    static {
        try {
            f5998a = kotlin.sequences.a.o0(kotlin.sequences.a.c0(Arrays.asList(new C1746b()).iterator()));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
