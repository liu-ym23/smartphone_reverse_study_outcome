package androidx.compose.ui.node;

import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\u001a'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aO\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001aW\u0010\u0014\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001aW\u0010\u0015\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001f\u0010\u001e\u001a\u0014\u0010 \u001a\u00020\u0000*\u00020\u0018H\u0082\b¢\u0006\u0004\b \u0010!\u001a?\u0010(\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0016H\u0000¢\u0006\u0004\b(\u0010)\u001a#\u0010,\u001a\u00020\n*\u00020\u00162\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0002¢\u0006\u0004\b,\u0010-¨\u0006."}, d2 = {"", "oldSize", "newSize", "Landroidx/compose/ui/node/DiffCallback;", "cb", "Landroidx/compose/ui/node/IntStack;", "calculateDiff", "(IILandroidx/compose/ui/node/DiffCallback;)Landroidx/compose/ui/node/IntStack;", "diagonals", "callback", "LC7/r;", "applyDiff", "(Landroidx/compose/ui/node/IntStack;Landroidx/compose/ui/node/DiffCallback;)V", "executeDiff", "(IILandroidx/compose/ui/node/DiffCallback;)V", "oldStart", "oldEnd", "newStart", "newEnd", "Landroidx/compose/ui/node/CenteredArray;", "forward", "backward", "", "snake", "", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "midPoint", "d", "forward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "backward-4l5_RBY", "toInt", "(Z)I", "startX", "startY", "endX", "endY", "reverse", SettingsConfig.KEY_DATA, "fillSnake", "(IIIIZ[I)V", "i", "j", "swap", "([III)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MyersDiffKt {
    private static final void applyDiff(IntStack intStack, DiffCallback diffCallback) {
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        while (i < intStack.getLastIndex()) {
            int i11 = i + 2;
            int i12 = intStack.get(i) - intStack.get(i11);
            int i13 = intStack.get(i + 1) - intStack.get(i11);
            int i14 = intStack.get(i11);
            i += 3;
            while (i6 < i12) {
                diffCallback.remove(i10, i6);
                i6++;
            }
            while (i10 < i13) {
                diffCallback.insert(i10);
                i10++;
            }
            while (true) {
                int i15 = i14 - 1;
                if (i14 > 0) {
                    diffCallback.same(i6, i10);
                    i6++;
                    i10++;
                    i14 = i15;
                }
            }
        }
    }

    /* renamed from: backward-4l5_RBY, reason: not valid java name */
    private static final boolean m5814backward4l5_RBY(int i, int i6, int i10, int i11, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i12, int[] iArr3) {
        int iM5691getimpl;
        int i13;
        int i14;
        int i15 = (i6 - i) - (i11 - i10);
        boolean z10 = (i15 & 1) == 0;
        int i16 = -i12;
        for (int i17 = i16; i17 <= i12; i17 += 2) {
            if (i17 == i16 || (i17 != i12 && CenteredArray.m5691getimpl(iArr2, i17 + 1) < CenteredArray.m5691getimpl(iArr2, i17 - 1))) {
                iM5691getimpl = CenteredArray.m5691getimpl(iArr2, i17 + 1);
                i13 = iM5691getimpl;
            } else {
                iM5691getimpl = CenteredArray.m5691getimpl(iArr2, i17 - 1);
                i13 = iM5691getimpl - 1;
            }
            int i18 = i11 - ((i6 - i13) - i17);
            int i19 = ((i12 != 0 ? 1 : 0) & (i13 == iM5691getimpl ? 1 : 0)) + i18;
            while (i13 > i && i18 > i10) {
                if (!diffCallback.areItemsTheSame(i13 - 1, i18 - 1)) {
                    break;
                }
                i13--;
                i18--;
            }
            CenteredArray.m5694setimpl(iArr2, i17, i13);
            if (z10 && (i14 = i15 - i17) >= i16 && i14 <= i12) {
                if (CenteredArray.m5691getimpl(iArr, i14) >= i13) {
                    fillSnake(i13, i18, iM5691getimpl, i19, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final IntStack calculateDiff(int i, int i6, DiffCallback diffCallback) {
        char c = 1;
        int i10 = ((i + i6) + 1) / 2;
        IntStack intStack = new IntStack(i10 * 3);
        IntStack intStack2 = new IntStack(i10 * 4);
        intStack2.pushRange(0, i, 0, i6);
        int i11 = (i10 * 2) + 1;
        int[] iArrM5688constructorimpl = CenteredArray.m5688constructorimpl(new int[i11]);
        int[] iArrM5688constructorimpl2 = CenteredArray.m5688constructorimpl(new int[i11]);
        int[] iArrM5929constructorimpl = Snake.m5929constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int iPop = intStack2.pop();
            int iPop2 = intStack2.pop();
            int iPop3 = intStack2.pop();
            int iPop4 = intStack2.pop();
            int[] iArr = iArrM5929constructorimpl;
            if (m5816midPointq5eDKzI(iPop4, iPop3, iPop2, iPop, diffCallback, iArrM5688constructorimpl, iArrM5688constructorimpl2, iArrM5929constructorimpl)) {
                char c2 = c;
                if (Math.min(iArr[2] - iArr[0], iArr[3] - iArr[c]) > 0) {
                    Snake.m5927addDiagonalToStackimpl(iArr, intStack);
                }
                intStack2.pushRange(iPop4, iArr[0], iPop2, iArr[c2]);
                intStack2.pushRange(iArr[2], iPop3, iArr[3], iPop);
                iArrM5929constructorimpl = iArr;
                c = c2;
            } else {
                iArrM5929constructorimpl = iArr;
            }
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i, i6, 0);
        return intStack;
    }

    public static final void executeDiff(int i, int i6, DiffCallback diffCallback) {
        applyDiff(calculateDiff(i, i6, diffCallback), diffCallback);
    }

    public static final void fillSnake(int i, int i6, int i10, int i11, boolean z10, int[] iArr) {
        if (iArr.length < 5) {
            return;
        }
        iArr[0] = i;
        iArr[1] = i6;
        iArr[2] = i10;
        iArr[3] = i11;
        iArr[4] = z10 ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* renamed from: forward-4l5_RBY, reason: not valid java name */
    private static final boolean m5815forward4l5_RBY(int i, int i6, int i10, int i11, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i12, int[] iArr3) {
        int iM5691getimpl;
        int i13;
        ?? r16;
        int i14 = (i6 - i) - (i11 - i10);
        int i15 = 1;
        boolean z10 = (Math.abs(i14) & 1) == 1;
        int i16 = -i12;
        int i17 = i16;
        while (i17 <= i12) {
            if (i17 == i16 || (i17 != i12 && CenteredArray.m5691getimpl(iArr, i17 + 1) > CenteredArray.m5691getimpl(iArr, i17 - 1))) {
                iM5691getimpl = CenteredArray.m5691getimpl(iArr, i17 + 1);
                i13 = iM5691getimpl;
            } else {
                iM5691getimpl = CenteredArray.m5691getimpl(iArr, i17 - 1);
                i13 = iM5691getimpl + 1;
            }
            int i18 = ((i13 - i) + i10) - i17;
            int i19 = i18 - ((i12 != 0 ? i15 : 0) & (i13 == iM5691getimpl ? i15 : 0));
            while (i13 < i6 && i18 < i11) {
                if (!diffCallback.areItemsTheSame(i13, i18)) {
                    break;
                }
                i13++;
                i18++;
            }
            CenteredArray.m5694setimpl(iArr, i17, i13);
            if (z10) {
                int i20 = i14 - i17;
                r16 = i15;
                r16 = r16;
                if (i20 >= i16 + 1) {
                    r16 = r16;
                    if (i20 <= i12 - 1) {
                        if (CenteredArray.m5691getimpl(iArr2, i20) <= i13) {
                            fillSnake(iM5691getimpl, i19, i13, i18, false, iArr3);
                            return r16;
                        }
                    }
                }
                i17 += 2;
                i15 = r16;
            } else {
                r16 = i15;
            }
            i17 += 2;
            i15 = r16;
        }
        return false;
    }

    /* renamed from: midPoint-q5eDKzI, reason: not valid java name */
    private static final boolean m5816midPointq5eDKzI(int i, int i6, int i10, int i11, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i12 = i6 - i;
        int i13 = i11 - i10;
        if (i12 >= 1 && i13 >= 1) {
            int i14 = ((i12 + i13) + 1) / 2;
            int[] iArr4 = iArr;
            CenteredArray.m5694setimpl(iArr4, 1, i);
            int[] iArr5 = iArr2;
            CenteredArray.m5694setimpl(iArr5, 1, i6);
            int i15 = 0;
            while (i15 < i14) {
                if (m5815forward4l5_RBY(i, i6, i10, i11, diffCallback, iArr4, iArr5, i15, iArr3) || m5814backward4l5_RBY(i, i6, i10, i11, diffCallback, iArr, iArr2, i15, iArr3)) {
                    return true;
                }
                i15++;
                iArr4 = iArr;
                iArr5 = iArr2;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void swap(int[] iArr, int i, int i6) {
        int i10 = iArr[i];
        iArr[i] = iArr[i6];
        iArr[i6] = i10;
    }

    private static final int toInt(boolean z10) {
        return z10 ? 1 : 0;
    }
}
