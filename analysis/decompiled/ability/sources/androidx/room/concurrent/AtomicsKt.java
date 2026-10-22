package androidx.room.concurrent;

import S7.k;
import androidx.annotation.RestrictTo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u0006*\u00060\u0000j\u0002`\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/room/concurrent/AtomicInt;", "Lkotlin/Function1;", "", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "loop", "(Ljava/util/concurrent/atomic/AtomicInteger;LS7/k;)Ljava/lang/Void;", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class AtomicsKt {
    public static final Void loop(AtomicInteger atomicInteger, k action) {
        kotlin.jvm.internal.k.f(atomicInteger, "<this>");
        kotlin.jvm.internal.k.f(action, "action");
        while (true) {
            action.invoke(Integer.valueOf(atomicInteger.get()));
        }
    }
}
