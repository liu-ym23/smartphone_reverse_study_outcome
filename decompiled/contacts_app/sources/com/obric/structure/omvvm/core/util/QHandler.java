package com.obric.structure.omvvm.core.util;

import android.os.Handler;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/obric/structure/omvvm/core/util/QHandler;", "", "handler", "Landroid/os/Handler;", "sync", "", "(Landroid/os/Handler;Z)V", "getSync$omvvm_core_release", "()Z", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "", "runnable", "Lkotlin/Function0;", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QHandler {
    private final Handler handler;
    private final boolean sync;

    public static /* synthetic */ void $r8$lambda$14e6vJfOC4e7XP_7oC0ziYvu76s(Function0 r0) {
        post$lambda$0(r0);
    }

    public QHandler(Handler r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.handler = r2;
        this.sync = r3;
    }

    public final boolean getSync$omvvm_core_release() {
        return this.sync;
    }

    public final void post(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (this.sync == false) goto L5;
        r2.invoke();
        return;
    L5:
        this.handler.post(new QHandler$$ExternalSyntheticLambda0(r2));
    }

    private static final void post$lambda$0(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }
}
