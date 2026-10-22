package bk8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f19377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f19378c;

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f19376a = r100;
        this.f19377b = LazyKt.lazy(new d(this));
        this.f19378c = LazyKt.lazy(new e(this));
    }
}
