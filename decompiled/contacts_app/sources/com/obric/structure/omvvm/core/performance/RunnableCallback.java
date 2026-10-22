package com.obric.structure.omvvm.core.performance;

import android.view.Choreographer;
import androidx.core.os.TraceCompat;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommitWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/obric/structure/omvvm/core/performance/RunnableCallback;", "Landroid/view/Choreographer$FrameCallback;", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "getAction", "()Ljava/lang/Runnable;", "doFrame", "", "frameTimeNanos", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RunnableCallback implements Choreographer.FrameCallback {
    private final Runnable action;

    public RunnableCallback(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        this.action = r2;
    }

    public final Runnable getAction() {
        return this.action;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r1) {
        TraceCompat.beginSection("commit#runnable");
        this.action.run();
        TraceCompat.endSection();
    }
}
