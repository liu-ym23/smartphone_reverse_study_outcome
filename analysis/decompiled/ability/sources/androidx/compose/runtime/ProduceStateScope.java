package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H¦@¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/ProduceStateScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/MutableState;", "Lm9/z;", "Lkotlin/Function0;", "LC7/r;", "onDispose", "", "awaitDispose", "(LS7/a;LH7/c;)Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ProduceStateScope<T> extends MutableState<T>, InterfaceC1733z {
    Object awaitDispose(S7.a aVar, H7.c<?> cVar);

    @Override // m9.InterfaceC1733z
    /* synthetic */ H7.h getCoroutineContext();
}
