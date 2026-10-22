package androidx.compose.runtime.tooling;

import androidx.compose.runtime.ExperimentalComposeRuntimeApi;
import androidx.compose.runtime.RecomposeScope;
import kotlin.Metadata;

@ExperimentalComposeRuntimeApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/tooling/CompositionObserver;", "", "Landroidx/compose/runtime/tooling/ObservableComposition;", "composition", "LC7/r;", "onBeginComposition", "(Landroidx/compose/runtime/tooling/ObservableComposition;)V", "Landroidx/compose/runtime/RecomposeScope;", "scope", "onScopeEnter", "(Landroidx/compose/runtime/RecomposeScope;)V", "value", "onReadInScope", "(Landroidx/compose/runtime/RecomposeScope;Ljava/lang/Object;)V", "onScopeExit", "onEndComposition", "onScopeInvalidated", "onScopeDisposed", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CompositionObserver {
    void onBeginComposition(ObservableComposition composition);

    void onEndComposition(ObservableComposition composition);

    void onReadInScope(RecomposeScope scope, Object value);

    void onScopeDisposed(RecomposeScope scope);

    void onScopeEnter(RecomposeScope scope);

    void onScopeExit(RecomposeScope scope);

    void onScopeInvalidated(RecomposeScope scope, Object value);
}
