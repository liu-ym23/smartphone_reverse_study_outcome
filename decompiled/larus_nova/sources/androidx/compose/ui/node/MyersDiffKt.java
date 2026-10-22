package androidx.compose.ui.node;

import com.amap.api.col.s.ce;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0012\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0002\u001a \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001aO\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aW\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001aW\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001b\u001a\r\u0010\u001d\u001a\u00020\u0003*\u00020\rH\u0082\b\u001a8\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0016H\u0000\u001a\u001c\u0010%\u001a\u00020\b*\u00020\u00162\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002¨\u0006("}, d2 = {"calculateDiff", "Landroidx/compose/ui/node/IntStack;", "oldSize", "", "newSize", "cb", "Landroidx/compose/ui/node/DiffCallback;", "applyDiff", "", "diagonals", "callback", "executeDiff", "midPoint", "", "oldStart", "oldEnd", "newStart", "newEnd", "forward", "Landroidx/compose/ui/node/CenteredArray;", "backward", "snake", "", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "d", "forward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "backward-4l5_RBY", "toInt", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "swap", RXScreenCaptureService.KEY_INDEX, ce.f26395j, "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MyersDiffKt {
    private static final int toInt(boolean r100) {
        return r100 ? 1 : 0;
    }

    private static final void applyDiff(IntStack r100, DiffCallback r101) {
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r102 >= r100.getSize()) goto L13;
        int r105 = r102 + 2;
        int r106 = r100.get(r102) - r100.get(r105);
        int r107 = r100.get(r102 + 1) - r100.get(r105);
        int r108 = r100.get(r105);
        r102 = r102 + 3;
    L6:
        if (r103 >= r106) goto L8;
        r101.remove(r104, r103);
        r103 = r103 + 1;
    L8:
        if (r104 >= r107) goto L10;
        r101.insert(r104);
        r104 = r104 + 1;
    L10:
        int r109 = r108 - 1;
        if (r108 <= 0) goto L4;
        r101.same(r103, r104);
        r103 = r103 + 1;
        r104 = r104 + 1;
        r108 = r109;
        goto L10
    }

    public static final /* synthetic */ void access$swap(int[] r100, int r101, int r102) {
        swap(r100, r101, r102);
    }

    private static final IntStack calculateDiff(int r210, int r211, DiffCallback r212) {
        int r100 = ((r210 + r211) + 1) / 2;
        IntStack r101 = new IntStack(r100 * 3);
        IntStack r102 = new IntStack(r100 * 4);
        r102.pushRange(0, r210, 0, r211);
        int r103 = (r100 * 2) + 1;
        int[] r104 = CenteredArray.m6395constructorimpl(new int[r103]);
        int[] r105 = CenteredArray.m6395constructorimpl(new int[r103]);
        int[] r110 = Snake.m6625constructorimpl(new int[5]);
    L4:
        if (r102.isNotEmpty() == false) goto L12;
        int r111 = r102.pop();
        int r112 = r102.pop();
        int r113 = r102.pop();
        int r114 = r102.pop();
        int[] r213 = r110;
        if (m6515midPointq5eDKzI(r114, r113, r112, r111, r212, r104, r105, r213) == true) goto L8;
        r110 = r213;
        goto L4
    L8:
        if (Math.min(r213[2] - r213[0], r213[3] - r213[1]) <= 0) goto L10;
        Snake.m6623addDiagonalToStackimpl(r213, r101);
    L10:
        r102.pushRange(r114, r213[0], r112, r213[1]);
        r102.pushRange(r213[2], r113, r213[3], r111);
        r110 = r213;
        goto L4
    L12:
        r101.sortDiagonals();
        r101.pushDiagonal(r210, r211, 0);
        return r101;
    }

    public static final void executeDiff(int r100, int r101, DiffCallback r102) {
        applyDiff(calculateDiff(r100, r101, r102), r102);
    }

    private static final void swap(int[] r100, int r101, int r102) {
        int r103 = r100[r101];
        r100[r101] = r100[r102];
        r100[r102] = r103;
    }

    public static final void fillSnake(int r100, int r101, int r102, int r103, boolean r104, int[] r105) {
        if (r105.length >= 5) goto L5;
        return;
    L5:
        r105[0] = r100;
        r105[1] = r101;
        r105[2] = r102;
        r105[3] = r103;
        r105[4] = r104 ? 1 : 0;
    }

    /* JADX INFO: renamed from: midPoint-q5eDKzI, reason: not valid java name */
    private static final boolean m6515midPointq5eDKzI(int r110, int r111, int r112, int r210, DiffCallback r211, int[] r212, int[] r213, int[] r214) {
        int r100 = r111 - r110;
        int r101 = r210 - r112;
        if (r100 < 1) goto L15;
        if (r101 < 1) goto L15;
        int r113 = ((r100 + r101) + 1) / 2;
        CenteredArray.m6401setimpl(r212, 1, r110);
        CenteredArray.m6401setimpl(r213, 1, r111);
        int r102 = 0;
    L7:
        if (r102 >= r113) goto L15;
        int r114 = r102;
        if (m6514forward4l5_RBY(r110, r111, r112, r210, r211, r212, r213, r102, r214) == true) goto L10;
        if (m6513backward4l5_RBY(r110, r111, r112, r210, r211, r212, r213, r114, r214) == true) goto L13;
        r102 = r114 + 1;
        goto L7
    L13:
        return true;
    L10:
        return true;
    L15:
        return false;
    }

    /* JADX INFO: renamed from: backward-4l5_RBY, reason: not valid java name */
    private static final boolean m6513backward4l5_RBY(int r110, int r111, int r112, int r113, DiffCallback r210, int[] r211, int[] r212, int r213, int[] r214) {
        int r100 = (r111 - r110) - (r113 - r112);
        if ((r100 & 1) != 0) goto L5;
        boolean r101 = true;
    L6:
        int r102 = -r213;
        int r103 = r102;
    L7:
        if (r103 > r213) goto L40;
        if (r103 == r102) goto L14;
        if (r103 != r213) goto L11;
    L13:
        int r114 = CenteredArray.m6398getimpl(r212, r103 - 1);
        int r115 = r114 - 1;
    L15:
        int r116 = r113 - ((r111 - r115) - r103);
        if (r213 == 0) goto L18;
        int r117 = 1;
    L19:
        if (r115 != r114) goto L21;
        int r118 = 1;
    L22:
        int r119 = (r117 & r118) + r116;
    L23:
        if (r115 <= r110) goto L29;
        if (r116 <= r112) goto L29;
        if (r210.areItemsTheSame(r115 - 1, r116 - 1) == false) goto L29;
        r115 = r115 - 1;
        r116 = r116 - 1;
    L29:
        CenteredArray.m6401setimpl(r212, r103, r115);
        if (r101 == false) goto L39;
        int r120 = r100 - r103;
        if (r120 < r102) goto L39;
        if (r120 > r213) goto L39;
        if (CenteredArray.m6398getimpl(r211, r120) < r115) goto L39;
        fillSnake(r115, r116, r114, r119, true, r214);
        return true;
    L39:
        r103 = r103 + 2;
        goto L7
    L21:
        r118 = 0;
        goto L22
    L18:
        r117 = 0;
        goto L19
    L11:
        if (CenteredArray.m6398getimpl(r212, r103 + 1) >= CenteredArray.m6398getimpl(r212, r103 - 1)) goto L13;
    L14:
        r114 = CenteredArray.m6398getimpl(r212, r103 + 1);
        r115 = r114;
        goto L15
    L40:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: forward-4l5_RBY, reason: not valid java name */
    private static final boolean m6514forward4l5_RBY(int r110, int r111, int r112, int r113, DiffCallback r210, int[] r211, int[] r212, int r213, int[] r214) {
        int r100 = (r111 - r110) - (r113 - r112);
        if ((Math.abs(r100) & 1) != 1) goto L5;
        boolean r101 = true;
    L6:
        int r102 = -r213;
        int r103 = r102;
    L7:
        if (r103 > r213) goto L41;
        if (r103 == r102) goto L14;
        if (r103 != r213) goto L11;
    L13:
        int r114 = CenteredArray.m6398getimpl(r211, r103 - 1);
        int r115 = r114 + 1;
    L15:
        int r116 = (r112 + (r115 - r110)) - r103;
        if (r213 == 0) goto L18;
        int r117 = 1;
    L19:
        if (r115 != r114) goto L21;
        int r118 = 1;
    L22:
        int r119 = r116 - (r117 & r118);
    L23:
        if (r115 >= r111) goto L29;
        if (r116 >= r113) goto L29;
        if (r210.areItemsTheSame(r115, r116) == false) goto L29;
        r115 = r115 + 1;
        r116 = r116 + 1;
    L29:
        CenteredArray.m6401setimpl(r211, r103, r115);
        if (r101 == false) goto L40;
        int r120 = r100 - r103;
        if (r120 < (r102 + 1)) goto L40;
        if (r120 > (r213 - 1)) goto L40;
        if (CenteredArray.m6398getimpl(r212, r120) > r115) goto L40;
        fillSnake(r114, r119, r115, r116, false, r214);
        return true;
    L40:
        r103 = r103 + 2;
        goto L7
    L21:
        r118 = 0;
        goto L22
    L18:
        r117 = 0;
        goto L19
    L11:
        if (CenteredArray.m6398getimpl(r211, r103 + 1) <= CenteredArray.m6398getimpl(r211, r103 - 1)) goto L13;
    L14:
        r114 = CenteredArray.m6398getimpl(r211, r103 + 1);
        r115 = r114;
        goto L15
    L41:
        return false;
    L5:
        r101 = false;
        goto L6
    }
}
