package androidx.room.concurrent;

import S7.a;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"Landroidx/room/concurrent/CloseBarrier;", "Lkotlin/Function0;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "ifNotClosed", "(Landroidx/room/concurrent/CloseBarrier;LS7/a;)V", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CloseBarrierKt {
    public static final void ifNotClosed(CloseBarrier closeBarrier, a action) {
        k.f(closeBarrier, "<this>");
        k.f(action, "action");
        if (closeBarrier.block$room_runtime()) {
            try {
                action.invoke();
            } finally {
                closeBarrier.unblock$room_runtime();
            }
        }
    }
}
