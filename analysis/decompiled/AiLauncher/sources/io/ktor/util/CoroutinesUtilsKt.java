package io.ktor.util;

import La.D;
import Ua.J;
import Ua.L0;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/g;", "", "offset", "LY8/t;", "printDebugTree", "(Lkotlinx/coroutines/g;I)V", "parent", "Lkotlin/coroutines/d;", "SilentSupervisor", "(Lkotlinx/coroutines/g;)Lkotlin/coroutines/d;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutinesUtilsKt {
    public static final kotlin.coroutines.d SilentSupervisor(kotlinx.coroutines.g gVar) {
        return L0.a(gVar).plus(new CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1(J.INSTANCE));
    }

    public static /* synthetic */ kotlin.coroutines.d SilentSupervisor$default(kotlinx.coroutines.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = null;
        }
        return SilentSupervisor(gVar);
    }

    public static final void printDebugTree(kotlinx.coroutines.g gVar, int i10) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        System.out.println((Object) (D.P(" ", i10) + gVar));
        Iterator<kotlinx.coroutines.g> it = gVar.getChildren().iterator();
        while (it.hasNext()) {
            printDebugTree(it.next(), i10 + 2);
        }
        if (i10 == 0) {
            System.out.println();
        }
    }

    public static /* synthetic */ void printDebugTree$default(kotlinx.coroutines.g gVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        printDebugTree(gVar, i10);
    }
}
