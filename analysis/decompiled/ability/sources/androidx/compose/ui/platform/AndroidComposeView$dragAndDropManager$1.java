package androidx.compose.ui.platform;

import S7.o;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class AndroidComposeView$dragAndDropManager$1 extends FunctionReferenceImpl implements o {
    public AndroidComposeView$dragAndDropManager$1(Object obj) {
        super(3, obj, AndroidComposeView.class, "startDrag", "startDrag-12SF9DM(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", 0);
    }

    @Override // S7.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m5971invoke12SF9DM((DragAndDropTransferData) obj, ((Size) obj2).m3969unboximpl(), (S7.k) obj3);
    }

    /* renamed from: invoke-12SF9DM, reason: not valid java name */
    public final Boolean m5971invoke12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j5, S7.k kVar) {
        return Boolean.valueOf(((AndroidComposeView) this.receiver).m5969startDrag12SF9DM(dragAndDropTransferData, j5, kVar));
    }
}
