package androidx.compose.runtime;

import S7.n;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\u00020\u00032\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\rH&¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001d\u001a\u00020\u00032\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a0\u0019H'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0003H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H&¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u0003H&¢\u0006\u0004\b&\u0010$J\u000f\u0010'\u001a\u00020\u0003H&¢\u0006\u0004\b'\u0010$J\u000f\u0010(\u001a\u00020\u0003H&¢\u0006\u0004\b(\u0010$J\u000f\u0010)\u001a\u00020\u0003H'¢\u0006\u0004\b)\u0010$J5\u0010.\u001a\u00028\u0000\"\u0004\b\u0000\u0010*2\b\u0010+\u001a\u0004\u0018\u00010\u00002\u0006\u0010-\u001a\u00020,2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H&¢\u0006\u0004\b.\u0010/J\u001b\u00102\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000100H&¢\u0006\u0004\b2\u00103R\u0014\u00104\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0018R\u0014\u00106\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0018\u0082\u0001\u00017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00068À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/Composition;", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "composeContent", "(LS7/n;)V", "", "", "values", "recordModificationsOf", "(Ljava/util/Set;)V", "", "observesAnyOf", "(Ljava/util/Set;)Z", "block", "prepareCompose", "(LS7/a;)V", "value", "recordReadOf", "(Ljava/lang/Object;)V", "recordWriteOf", "recompose", "()Z", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "references", "insertMovableContent", "(Ljava/util/List;)V", "Landroidx/compose/runtime/MovableContentState;", "state", "disposeUnusedMovableContent", "(Landroidx/compose/runtime/MovableContentState;)V", "applyChanges", "()V", "applyLateChanges", "changesApplied", "abandonChanges", "invalidateAll", "verifyConsistent", "R", TypedValues.TransitionType.S_TO, "", "groupIndex", "delegateInvalidations", "(Landroidx/compose/runtime/ControlledComposition;ILS7/a;)Ljava/lang/Object;", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "getAndSetShouldPauseCallback", "(Landroidx/compose/runtime/ShouldPauseCallback;)Landroidx/compose/runtime/ShouldPauseCallback;", "isComposing", "getHasPendingChanges", "hasPendingChanges", "Landroidx/compose/runtime/CompositionImpl;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ControlledComposition extends Composition {
    void abandonChanges();

    void applyChanges();

    void applyLateChanges();

    void changesApplied();

    void composeContent(n content);

    <R> R delegateInvalidations(ControlledComposition to, int groupIndex, S7.a block);

    @InternalComposeApi
    void disposeUnusedMovableContent(MovableContentState state);

    ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback shouldPause);

    boolean getHasPendingChanges();

    @InternalComposeApi
    void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references);

    void invalidateAll();

    boolean isComposing();

    boolean observesAnyOf(Set<? extends Object> values);

    void prepareCompose(S7.a block);

    boolean recompose();

    void recordModificationsOf(Set<? extends Object> values);

    void recordReadOf(Object value);

    void recordWriteOf(Object value);

    @InternalComposeApi
    void verifyConsistent();
}
