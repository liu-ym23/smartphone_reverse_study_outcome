package androidx.compose.runtime.internal;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ,\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0018\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J<\u0010\u001b\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u001aH\u0086\b¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010&J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b,\u0010+J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b-\u0010+J\r\u0010.\u001a\u00020\u0007¢\u0006\u0004\b.\u0010\u0003J\u0015\u0010/\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020$¢\u0006\u0004\b/\u0010&J\u001b\u00102\u001a\u00020\u00072\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000500¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000100¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0007¢\u0006\u0004\b6\u0010\u0003J\r\u00107\u001a\u00020\u0007¢\u0006\u0004\b7\u0010\u0003R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u00108R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00109R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010:R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00050;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010:R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010:R \u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010:R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010=R$\u0010C\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020B\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010F\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006J"}, d2 = {"Landroidx/compose/runtime/internal/RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/RememberObserverHolder;", "list", "LC7/r;", "dispatchRememberList", "(Landroidx/compose/runtime/collection/MutableVector;)V", "", "instance", "recordLeaving", "(Ljava/lang/Object;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "withComposeStackTrace", "(Ljava/lang/Object;LS7/a;)Ljava/lang/Object;", "", "Landroidx/compose/runtime/RememberObserver;", "abandoning", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "traceContext", "prepare", "(Ljava/util/Set;Landroidx/compose/runtime/tooling/CompositionErrorContext;)V", "Lkotlin/Function1;", "use", "(Ljava/util/Set;Landroidx/compose/runtime/tooling/CompositionErrorContext;LS7/k;)V", "clear", "remembering", "(Landroidx/compose/runtime/RememberObserverHolder;)V", "forgetting", "effect", "sideEffect", "(LS7/a;)V", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "deactivating", "(Landroidx/compose/runtime/ComposeNodeLifecycleCallback;)V", "releasing", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "rememberPausingScope", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "startResumingScope", "endResumingScope", "dispatchRememberObservers", "dispatchOnDeactivateIfNecessary", "Landroidx/collection/ScatterSet;", "ignoreSet", "ignoreForgotten", "(Landroidx/collection/ScatterSet;)V", "extractRememberSet", "()Landroidx/collection/ScatterSet;", "dispatchSideEffects", "dispatchAbandons", "Ljava/util/Set;", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/collection/MutableScatterSet;", "rememberSet", "Landroidx/collection/MutableScatterSet;", "currentRememberingList", "leaving", "sideEffects", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/internal/PausedCompositionRemembers;", "pausedPlaceholders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/Stack;", "nestedRemembersLists", "Ljava/util/ArrayList;", "ignoreLeavingSet", "Landroidx/collection/ScatterSet;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RememberEventDispatcher implements RememberManager {
    public static final int $stable = 8;
    private Set<RememberObserver> abandoning;
    private MutableVector<RememberObserverHolder> currentRememberingList;
    private ScatterSet<RememberObserverHolder> ignoreLeavingSet;
    private final MutableVector<Object> leaving;
    private ArrayList nestedRemembersLists;
    private MutableScatterMap<RecomposeScopeImpl, PausedCompositionRemembers> pausedPlaceholders;
    private MutableScatterSet<ComposeNodeLifecycleCallback> releasing;
    private MutableScatterSet<RememberObserverHolder> rememberSet;
    private final MutableVector<RememberObserverHolder> remembering;
    private final MutableVector<S7.a> sideEffects;
    private CompositionErrorContext traceContext;

    public RememberEventDispatcher() {
        MutableVector<RememberObserverHolder> mutableVector = new MutableVector<>(new RememberObserverHolder[16], 0);
        this.remembering = mutableVector;
        this.rememberSet = ScatterSetKt.mutableScatterSetOf();
        this.currentRememberingList = mutableVector;
        this.leaving = new MutableVector<>(new Object[16], 0);
        this.sideEffects = new MutableVector<>(new S7.a[16], 0);
    }

    private final void dispatchRememberList(MutableVector<RememberObserverHolder> list) {
        Set<RememberObserver> set = this.abandoning;
        if (set == null) {
            return;
        }
        RememberObserverHolder[] rememberObserverHolderArr = list.content;
        int size = list.getSize();
        for (int i = 0; i < size; i++) {
            RememberObserverHolder rememberObserverHolder = rememberObserverHolderArr[i];
            RememberObserver wrapped = rememberObserverHolder.getWrapped();
            set.remove(wrapped);
            try {
                wrapped.onRemembered();
            } catch (Throwable th) {
                CompositionErrorContext compositionErrorContext = this.traceContext;
                if (compositionErrorContext != null) {
                    compositionErrorContext.attachComposeStackTrace(th, rememberObserverHolder);
                }
                throw th;
            }
        }
    }

    private static final boolean forgetting$removeFrom(RememberObserverHolder rememberObserverHolder, MutableVector<RememberObserverHolder> mutableVector) {
        RememberObserverHolder[] rememberObserverHolderArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            RememberObserver wrapped = rememberObserverHolderArr[i].getWrapped();
            if (wrapped instanceof PausedCompositionRemembers) {
                MutableVector<RememberObserverHolder> pausedRemembers = ((PausedCompositionRemembers) wrapped).getPausedRemembers();
                if (pausedRemembers.remove(rememberObserverHolder) || forgetting$removeFrom(rememberObserverHolder, pausedRemembers)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void recordLeaving(Object instance) {
        this.leaving.add(instance);
    }

    private final <T> T withComposeStackTrace(Object instance, S7.a block) {
        try {
            return (T) block.invoke();
        } catch (Throwable th) {
            CompositionErrorContext compositionErrorContext = this.traceContext;
            if (compositionErrorContext != null) {
                compositionErrorContext.attachComposeStackTrace(th, instance);
            }
            throw th;
        }
    }

    public final void clear() {
        this.abandoning = null;
        this.traceContext = null;
        this.remembering.clear();
        this.rememberSet.clear();
        this.currentRememberingList = this.remembering;
        this.leaving.clear();
        this.sideEffects.clear();
        this.releasing = null;
        this.pausedPlaceholders = null;
        this.nestedRemembersLists = null;
    }

    @Override // androidx.compose.runtime.RememberManager
    public void deactivating(ComposeNodeLifecycleCallback instance) {
        recordLeaving(instance);
    }

    public final void dispatchAbandons() {
        Set<RememberObserver> set = this.abandoning;
        if (set == null || set.isEmpty()) {
            return;
        }
        Object objBeginSection = Trace.INSTANCE.beginSection("Compose:abandons");
        try {
            Iterator<RememberObserver> it = set.iterator();
            while (it.hasNext()) {
                RememberObserver next = it.next();
                it.remove();
                next.onAbandoned();
            }
        } finally {
            Trace.INSTANCE.endSection(objBeginSection);
        }
    }

    public final void dispatchOnDeactivateIfNecessary(ComposeNodeLifecycleCallback instance) {
        if (this.leaving.remove(instance)) {
            instance.onDeactivate();
        }
    }

    public final void dispatchRememberObservers() {
        Object objBeginSection;
        Set<RememberObserver> set = this.abandoning;
        if (set == null) {
            return;
        }
        this.ignoreLeavingSet = null;
        if (this.leaving.getSize() != 0) {
            objBeginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
            try {
                ScatterSet scatterSet = this.releasing;
                int size = this.leaving.getSize();
                while (true) {
                    size--;
                    if (-1 >= size) {
                        break;
                    }
                    Object obj = this.leaving.content[size];
                    try {
                        if (obj instanceof RememberObserverHolder) {
                            RememberObserver wrapped = ((RememberObserverHolder) obj).getWrapped();
                            set.remove(wrapped);
                            wrapped.onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            if (scatterSet == null || !scatterSet.contains(obj)) {
                                ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                            } else {
                                ((ComposeNodeLifecycleCallback) obj).onRelease();
                            }
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.remembering.getSize() != 0) {
            Trace trace = Trace.INSTANCE;
            objBeginSection = trace.beginSection("Compose:onRemembered");
            try {
                dispatchRememberList(this.remembering);
                trace.endSection(objBeginSection);
            } finally {
                Trace.INSTANCE.endSection(objBeginSection);
            }
        }
    }

    public final void dispatchSideEffects() {
        if (this.sideEffects.getSize() != 0) {
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
            try {
                MutableVector<S7.a> mutableVector = this.sideEffects;
                S7.a[] aVarArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    aVarArr[i].invoke();
                }
                this.sideEffects.clear();
                Trace.INSTANCE.endSection(objBeginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(objBeginSection);
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.RememberManager
    public void endResumingScope(RecomposeScopeImpl scope) {
        MutableVector<RememberObserverHolder> mutableVector;
        MutableScatterMap<RecomposeScopeImpl, PausedCompositionRemembers> mutableScatterMap = this.pausedPlaceholders;
        if (mutableScatterMap == null || mutableScatterMap.get(scope) == null) {
            return;
        }
        ArrayList arrayList = this.nestedRemembersLists;
        if (arrayList != null && (mutableVector = (MutableVector) Stack.m3468popimpl(arrayList)) != null) {
            this.currentRememberingList = mutableVector;
        }
        mutableScatterMap.remove(scope);
    }

    public final ScatterSet<RememberObserverHolder> extractRememberSet() {
        if (!this.rememberSet.isNotEmpty()) {
            return null;
        }
        MutableScatterSet<RememberObserverHolder> mutableScatterSet = this.rememberSet;
        this.rememberSet = ScatterSetKt.mutableScatterSetOf();
        this.remembering.clear();
        return mutableScatterSet;
    }

    @Override // androidx.compose.runtime.RememberManager
    public void forgetting(RememberObserverHolder instance) {
        if (this.rememberSet.contains(instance)) {
            this.rememberSet.remove(instance);
            if (!this.currentRememberingList.remove(instance) && !this.remembering.remove(instance)) {
                forgetting$removeFrom(instance, this.remembering);
            }
            Set<RememberObserver> set = this.abandoning;
            if (set == null) {
                return;
            } else {
                set.add(instance.getWrapped());
            }
        }
        ScatterSet<RememberObserverHolder> scatterSet = this.ignoreLeavingSet;
        if (scatterSet == null || !scatterSet.contains(instance)) {
            recordLeaving(instance);
        }
    }

    public final void ignoreForgotten(ScatterSet<RememberObserverHolder> ignoreSet) {
        this.ignoreLeavingSet = ignoreSet;
    }

    public final void prepare(Set<RememberObserver> abandoning, CompositionErrorContext traceContext) {
        clear();
        this.abandoning = abandoning;
        this.traceContext = traceContext;
    }

    @Override // androidx.compose.runtime.RememberManager
    public void releasing(ComposeNodeLifecycleCallback instance) {
        MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSetMutableScatterSetOf = this.releasing;
        if (mutableScatterSetMutableScatterSetOf == null) {
            mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            this.releasing = mutableScatterSetMutableScatterSetOf;
        }
        mutableScatterSetMutableScatterSetOf.plusAssign((MutableScatterSet<ComposeNodeLifecycleCallback>) instance);
        recordLeaving(instance);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void rememberPausingScope(RecomposeScopeImpl scope) {
        Set<RememberObserver> set = this.abandoning;
        if (set == null) {
            return;
        }
        PausedCompositionRemembers pausedCompositionRemembers = new PausedCompositionRemembers(set);
        MutableScatterMap<RecomposeScopeImpl, PausedCompositionRemembers> mutableScatterMapMutableScatterMapOf = this.pausedPlaceholders;
        if (mutableScatterMapMutableScatterMapOf == null) {
            mutableScatterMapMutableScatterMapOf = ScatterMapKt.mutableScatterMapOf();
            this.pausedPlaceholders = mutableScatterMapMutableScatterMapOf;
        }
        mutableScatterMapMutableScatterMapOf.set(scope, pausedCompositionRemembers);
        this.currentRememberingList.add(new RememberObserverHolder(pausedCompositionRemembers, null));
    }

    @Override // androidx.compose.runtime.RememberManager
    public void remembering(RememberObserverHolder instance) {
        this.currentRememberingList.add(instance);
        this.rememberSet.add(instance);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void sideEffect(S7.a effect) {
        this.sideEffects.add(effect);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void startResumingScope(RecomposeScopeImpl scope) {
        MutableScatterMap<RecomposeScopeImpl, PausedCompositionRemembers> mutableScatterMap = this.pausedPlaceholders;
        PausedCompositionRemembers pausedCompositionRemembers = mutableScatterMap != null ? mutableScatterMap.get(scope) : null;
        if (pausedCompositionRemembers != null) {
            ArrayList arrayListM3459constructorimpl$default = this.nestedRemembersLists;
            if (arrayListM3459constructorimpl$default == null) {
                arrayListM3459constructorimpl$default = Stack.m3459constructorimpl$default(null, 1, null);
                this.nestedRemembersLists = arrayListM3459constructorimpl$default;
            }
            Stack.m3469pushimpl(arrayListM3459constructorimpl$default, this.currentRememberingList);
            this.currentRememberingList = pausedCompositionRemembers.getPausedRemembers();
        }
    }

    public final void use(Set<RememberObserver> abandoning, CompositionErrorContext traceContext, S7.k block) {
        try {
            prepare(abandoning, traceContext);
            block.invoke(this);
        } finally {
            clear();
        }
    }
}
