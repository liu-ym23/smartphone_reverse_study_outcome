package androidx.compose.ui.input.pointer;

import C7.c;
import S7.n;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a7\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\n\u001a#\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\f\u001aK\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\u000e\u001a-\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\u000f\u001aO\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0010\"\u0004\u0018\u00010\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\u0012\u001a1\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0010\"\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\u0013\u001a3\u0010\u0016\u001a\u00020\u00152\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0019\"\u001a\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u001e\"\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!\"\u0014\u0010#\u001a\u00020\"8\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "LH7/c;", "LC7/r;", "", "block", "pointerInput", "(Landroidx/compose/ui/Modifier;LS7/n;)Landroidx/compose/ui/Modifier;", "key1", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;LS7/n;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/Modifier;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;LS7/n;)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/Modifier;", "", "keys", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;LS7/n;)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/Modifier;", "pointerInputHandler", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "SuspendingPointerInputModifierNode", "(LS7/n;)Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputEventHandler", "(Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "", "PointerInputModifierNoParamError", "Ljava/lang/String;", "getPointerInputModifierNoParamError$annotations", "()V", "Landroidx/compose/ui/input/pointer/PointerEvent;", "EmptyPointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "", "WITH_TIMEOUT_MICRO_DELAY_MILLIS", "J", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SuspendingPointerInputFilterKt {
    private static final PointerEvent EmptyPointerEvent = new PointerEvent(EmptyList.f4893a);
    private static final String PointerInputModifierNoParamError = "Modifier.pointerInput must provide one or more 'key' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.";
    public static final long WITH_TIMEOUT_MICRO_DELAY_MILLIS = 8;

    @c
    public static final /* synthetic */ SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode(n nVar) {
        return new SuspendingPointerInputModifierNodeImpl((Object) null, (Object) null, (Object[]) null, nVar);
    }

    private static /* synthetic */ void getPointerInputModifierNoParamError$annotations() {
    }

    @c
    public static final Modifier pointerInput(Modifier modifier, n nVar) {
        throw new IllegalStateException(PointerInputModifierNoParamError);
    }

    public static final SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode(PointerInputEventHandler pointerInputEventHandler) {
        return new SuspendingPointerInputModifierNodeImpl((Object) null, (Object) null, (Object[]) null, pointerInputEventHandler);
    }

    public static final Modifier pointerInput(Modifier modifier, Object obj, PointerInputEventHandler pointerInputEventHandler) {
        return modifier.then(new SuspendPointerInputElement(obj, null, null, pointerInputEventHandler, 6, null));
    }

    public static final Modifier pointerInput(Modifier modifier, Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler) {
        return modifier.then(new SuspendPointerInputElement(obj, obj2, null, pointerInputEventHandler, 4, null));
    }

    public static final Modifier pointerInput(Modifier modifier, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        return modifier.then(new SuspendPointerInputElement(null, null, objArr, pointerInputEventHandler, 3, null));
    }
}
