package cf9;

import com.larus.im.internal.rtcsdk.impl.p0;
import ff9.i;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<i.b, Unit> f23554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Future<?>> f23555b;

    public static final class a {
    }

    static {
    }

    public g(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f23554a = r100;
        this.f23555b = new AtomicReference();
    }
}
