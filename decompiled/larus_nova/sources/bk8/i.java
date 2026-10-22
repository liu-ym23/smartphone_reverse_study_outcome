package bk8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f19381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f19382c;

    public final Context getContext() {
        return this.f19380a;
    }

    public i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f19380a = r100;
        this.f19381b = LazyKt.lazy(new g(this));
        this.f19382c = LazyKt.lazy(new h());
    }
}
