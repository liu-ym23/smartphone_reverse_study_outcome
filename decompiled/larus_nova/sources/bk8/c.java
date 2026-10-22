package bk8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f19372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f19373c;

    public final Context getContext() {
        return this.f19371a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f19371a = r100;
        this.f19372b = LazyKt.lazy(new a(this));
        this.f19373c = LazyKt.lazy(new b());
    }
}
