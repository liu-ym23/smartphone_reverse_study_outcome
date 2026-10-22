package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u0082\u0001\u0001\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/PausedComposition;", "", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "", "resume", "(Landroidx/compose/runtime/ShouldPauseCallback;)Z", "LC7/r;", "apply", "()V", "cancel", "isComplete", "()Z", "isApplied", "isCancelled", "Landroidx/compose/runtime/PausedCompositionImpl;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PausedComposition {
    void apply();

    void cancel();

    boolean isApplied();

    boolean isCancelled();

    boolean isComplete();

    boolean resume(ShouldPauseCallback shouldPause);
}
