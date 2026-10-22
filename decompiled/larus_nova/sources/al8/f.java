package al8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f4194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f4195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f4196d;

    public final Context getContext() {
        return this.f4193a;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f4193a = r100;
        this.f4194b = LazyKt.lazy(new a(this));
        this.f4195c = LazyKt.lazy(new b());
        this.f4196d = LazyKt.lazy(new c(this));
    }
}
