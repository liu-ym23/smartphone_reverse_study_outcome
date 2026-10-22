package androidx.compose.ui.platform;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/WindowInfo;", "", "isWindowFocused", "", "()Z", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "()I", "containerSize", "Landroidx/compose/ui/unit/IntSize;", "getContainerSize-YbymL2g", "()J", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface WindowInfo {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.WindowInfo$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$getContainerSize-YbymL2g, reason: not valid java name */
        public static long m6749$default$getContainerSizeYbymL2g(WindowInfo r100) {
            long r101 = Integer.MIN_VALUE;
            return IntSize.m7714constructorimpl((r101 & BodyPartID.bodyIdMax) | (r101 << 32));
        }

        /* JADX INFO: renamed from: $default$getKeyboardModifiers-k7X9c1A, reason: not valid java name */
        public static int m6750$default$getKeyboardModifiersk7X9c1A(WindowInfo r100) {
            return WindowInfoImpl.Companion.getGlobalKeyboardModifiers$ui_release().getValue().m6194unboximpl();
        }
    }

    /* JADX INFO: renamed from: getContainerSize-YbymL2g */
    long mo6714getContainerSizeYbymL2g();

    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A */
    int mo6715getKeyboardModifiersk7X9c1A();

    boolean isWindowFocused();
}
