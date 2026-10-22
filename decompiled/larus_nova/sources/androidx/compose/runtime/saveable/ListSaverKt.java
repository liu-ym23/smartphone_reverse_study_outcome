package androidx.compose.runtime.saveable;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a}\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000422\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b0\u0006¢\u0006\u0002\b\f2)\u0010\r\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00040\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e¨\u0006\u0010"}, d2 = {"listSaver", "Landroidx/compose/runtime/saveable/Saver;", "Original", "", "Saveable", SVGRenderEngine.SAVE, "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "", "Lkotlin/ExtensionFunctionType;", SVGRenderEngine.RESTORE, "Lkotlin/Function1;", "list", "runtime-saveable"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListSaverKt {
    public static /* synthetic */ Object a(Function2 r100, SaverScope r101, Object r102) {
        return listSaver$lambda$1(r100, r101, r102);
    }

    public static final <Original, Saveable> Saver<Original, Object> listSaver(final Function2<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> r100, Function1<? super List<? extends Saveable>, ? extends Original> r101) {
        Function2 r102 = new a(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, Original of androidx.compose.runtime.saveable.ListSaverKt.listSaver?>");
        return SaverKt.Saver(r102, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r101, 1));
    }

    private static final Object listSaver$lambda$1(Function2 r100, SaverScope r101, Object r102) {
        List r103 = (List) r100.invoke(r101, r102);
        List r104 = r103;
        int r105 = r104.size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L13;
        Object r107 = ListProtector.get(r103, r106);
        if (r107 == null) goto L11;
        if (r101.canBeSaved(r107) == true) goto L11;
        throw new IllegalArgumentException(("item at index " + r106 + " can't be saved: " + r107).toString());
    L11:
        r106 = r106 + 1;
        goto L3
    L13:
        if ((!r104.isEmpty()) == true) goto L21;
        return null;
    L21:
        return new ArrayList(r104);
    }
}
