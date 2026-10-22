package androidx.compose.runtime;

import S7.n;
import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 0*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J5\u0010\u001d\u001a\u00020\u00072\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00070\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\nJ#\u0010#\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010+\u001a\u00028\u00008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\u0005¨\u00061"}, d2 = {"Landroidx/compose/runtime/RecordingApplier;", "N", "Landroidx/compose/runtime/Applier;", "root", AppAgent.CONSTRUCT, "(Ljava/lang/Object;)V", "node", "LC7/r;", "down", "up", "()V", "", "index", "count", "remove", "(II)V", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "move", "(III)V", "clear", "instance", "insertBottomUp", "(ILjava/lang/Object;)V", "insertTopDown", "Lkotlin/Function2;", "", "block", "value", "apply", "(LS7/n;Ljava/lang/Object;)V", "reuse", "applier", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "rememberManager", "playTo", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/internal/RememberEventDispatcher;)V", "Landroidx/collection/MutableIntList;", "operations", "Landroidx/collection/MutableIntList;", "Landroidx/collection/MutableObjectList;", "instances", "Landroidx/collection/MutableObjectList;", "current", "Ljava/lang/Object;", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecordingApplier<N> implements Applier<N> {
    public static final int APPLY = 7;
    public static final int CLEAR = 4;
    public static final int DOWN = 1;
    public static final int INSERT_BOTTOM_UP = 5;
    public static final int INSERT_TOP_DOWN = 6;
    public static final int MOVE = 3;
    public static final int REMOVE = 2;
    public static final int REUSE = 8;
    public static final int UP = 0;
    private N current;
    public static final int $stable = 8;
    private final MutableIntList operations = new MutableIntList(0, 1, null);
    private final MutableObjectList<Object> instances = new MutableObjectList<>(0, 1, null);

    public RecordingApplier(N n) {
        this.current = n;
    }

    @Override // androidx.compose.runtime.Applier
    public void apply(n block, Object value) {
        this.operations.add(7);
        this.instances.add(block);
        this.instances.add(value);
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        this.operations.add(4);
    }

    @Override // androidx.compose.runtime.Applier
    public void down(N node) {
        this.operations.add(1);
        this.instances.add(node);
    }

    @Override // androidx.compose.runtime.Applier
    public N getCurrent() {
        return this.current;
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int index, N instance) {
        this.operations.add(5);
        this.operations.add(index);
        this.instances.add(instance);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int index, N instance) {
        this.operations.add(6);
        this.operations.add(index);
        this.instances.add(instance);
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int from, int to, int count) {
        this.operations.add(3);
        this.operations.add(from);
        this.operations.add(to);
        this.operations.add(count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void playTo(Applier<N> applier, RememberEventDispatcher rememberManager) {
        Exception exc;
        Exception exc2;
        int i;
        int i6;
        MutableIntList mutableIntList = this.operations;
        int i10 = mutableIntList._size;
        MutableObjectList<Object> mutableObjectList = this.instances;
        int i11 = 0;
        MutableObjectList mutableObjectList2 = new MutableObjectList(0, 1, null);
        applier.onBeginChanges();
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i11 + 1;
            try {
                try {
                    switch (mutableIntList.get(i11)) {
                        case 0:
                            applier.up();
                            i11 = i13;
                        case 1:
                            int i14 = i12 + 1;
                            applier.down(mutableObjectList.get(i12));
                            i12 = i14;
                            i11 = i13;
                        case 2:
                            int i15 = i11 + 2;
                            i11 += 3;
                            applier.remove(mutableIntList.get(i13), mutableIntList.get(i15));
                        case 3:
                            int i16 = i11 + 2;
                            try {
                                i = i11 + 3;
                            } catch (Exception e) {
                                exc = e;
                                i13 = i16;
                            }
                            try {
                                i11 += 4;
                                applier.move(mutableIntList.get(i13), mutableIntList.get(i16), mutableIntList.get(i));
                            } catch (Exception e6) {
                                exc = e6;
                                i13 = i;
                                throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i13, exc);
                            }
                        case 4:
                            applier.clear();
                            i11 = i13;
                        case 5:
                            i11 += 2;
                            i6 = i12 + 1;
                            applier.insertBottomUp(mutableIntList.get(i13), mutableObjectList.get(i12));
                            i12 = i6;
                        case 6:
                            i11 += 2;
                            try {
                                i6 = i12 + 1;
                                applier.insertTopDown(mutableIntList.get(i13), mutableObjectList.get(i12));
                                i12 = i6;
                            } catch (Exception e9) {
                                exc2 = e9;
                                i13 = i11;
                                exc = exc2;
                                throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i13, exc);
                            }
                        case 7:
                            int i17 = i12 + 1;
                            Object obj = mutableObjectList.get(i12);
                            kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
                            p.e(2, obj);
                            i12 += 2;
                            applier.apply((n) obj, mutableObjectList.get(i17));
                            i11 = i13;
                        case 8:
                            Object current = applier.getCurrent();
                            if (current instanceof ComposeNodeLifecycleCallback) {
                                rememberManager.dispatchOnDeactivateIfNecessary((ComposeNodeLifecycleCallback) current);
                            }
                            mutableObjectList2.add(current);
                            applier.reuse();
                            i11 = i13;
                        default:
                            i11 = i13;
                    }
                } catch (Throwable th) {
                    applier.onEndChanges();
                    throw th;
                }
            } catch (Exception e10) {
                exc2 = e10;
                exc = exc2;
                throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i13, exc);
            }
        }
        if (i12 != mutableObjectList.getSize()) {
            ComposerKt.composeImmediateRuntimeError("Applier operation size mismatch");
        }
        mutableObjectList.clear();
        mutableIntList.clear();
        applier.onEndChanges();
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int index, int count) {
        this.operations.add(2);
        this.operations.add(index);
        this.operations.add(count);
    }

    @Override // androidx.compose.runtime.Applier
    public void reuse() {
        this.operations.add(8);
    }

    public void setCurrent(N n) {
        this.current = n;
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        this.operations.add(0);
    }
}
