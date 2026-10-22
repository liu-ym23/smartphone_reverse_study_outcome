package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b*\u001a\r\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0019\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001c\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\u001d\u0010\u001b\"\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0015\u0010\u000b\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\n\"\u0015\u0010\r\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n\"\u0015\u0010\u000f\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n\"\u0015\u0010\u0011\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\n\"\u0015\u0010\u0017\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\n\"\u0015\u0010\u001e\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\n\"\u0015\u0010 \u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b!\u0010\n\"\u0015\u0010\"\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b#\u0010\n\"\u0015\u0010$\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b%\u0010\n\"\u0015\u0010&\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b'\u0010\n\"\u0015\u0010(\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b)\u0010\n\"\u0015\u0010*\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b+\u0010\n\"\u0015\u0010,\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b-\u0010\n\"\u0015\u0010.\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b/\u0010\n\"\u0015\u00100\u001a\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b1\u0010\n*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010\u0002\"\u00020\u00012\u00020\u0001¨\u00062"}, d2 = {"NativePointerButtons", "", "NativePointerKeyboardModifiers", "EmptyPointerKeyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "()I", "isPrimaryPressed", "", "Landroidx/compose/ui/input/pointer/PointerButtons;", "isPrimaryPressed-aHzCx-E", "(I)Z", "isSecondaryPressed", "isSecondaryPressed-aHzCx-E", "isTertiaryPressed", "isTertiaryPressed-aHzCx-E", "isBackPressed", "isBackPressed-aHzCx-E", "isForwardPressed", "isForwardPressed-aHzCx-E", "isPressed", "buttonIndex", "isPressed-bNIWhpI", "(II)Z", "areAnyPressed", "getAreAnyPressed-aHzCx-E", "indexOfFirstPressed", "indexOfFirstPressed-aHzCx-E", "(I)I", "indexOfLastPressed", "indexOfLastPressed-aHzCx-E", "isCtrlPressed", "isCtrlPressed-5xRPYO0", "isMetaPressed", "isMetaPressed-5xRPYO0", "isAltPressed", "isAltPressed-5xRPYO0", "isAltGraphPressed", "isAltGraphPressed-5xRPYO0", "isSymPressed", "isSymPressed-5xRPYO0", "isShiftPressed", "isShiftPressed-5xRPYO0", "isFunctionPressed", "isFunctionPressed-5xRPYO0", "isCapsLockOn", "isCapsLockOn-5xRPYO0", "isScrollLockOn", "isScrollLockOn-5xRPYO0", "isNumLockOn", "isNumLockOn-5xRPYO0", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PointerEvent_androidKt {
    public static final int EmptyPointerKeyboardModifiers() {
        return PointerKeyboardModifiers.m6189constructorimpl(0);
    }

    /* JADX INFO: renamed from: getAreAnyPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m6086getAreAnyPressedaHzCxE(int r100) {
        if (r100 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: indexOfFirstPressed-aHzCx-E, reason: not valid java name */
    public static final int m6087indexOfFirstPressedaHzCxE(int r100) {
        if (r100 != 0) goto L5;
        return -1;
    L5:
        int r101 = (r100 & 96) >>> 5;
        int r102 = (r100 & (-97)) | r101;
        int r103 = 0;
    L7:
        if ((r102 & 1) != 0) goto L9;
        r103 = r103 + 1;
        r102 = r102 >>> 1;
        goto L7
    L9:
        return r103;
    }

    /* JADX INFO: renamed from: indexOfLastPressed-aHzCx-E, reason: not valid java name */
    public static final int m6088indexOfLastPressedaHzCxE(int r100) {
        int r101 = (r100 & 96) >>> 5;
        int r102 = (r100 & (-97)) | r101;
        int r103 = -1;
    L3:
        if (r102 == 0) goto L5;
        r103 = r103 + 1;
        r102 = r102 >>> 1;
        goto L3
    L5:
        return r103;
    }

    /* JADX INFO: renamed from: isAltGraphPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m6089isAltGraphPressed5xRPYO0(int r100) {
        return false;
    }

    /* JADX INFO: renamed from: isAltPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m6090isAltPressed5xRPYO0(int r100) {
        if ((r100 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isBackPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m6091isBackPressedaHzCxE(int r100) {
        if ((r100 & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isCapsLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m6092isCapsLockOn5xRPYO0(int r100) {
        if ((r100 & 1048576) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isCtrlPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m6093isCtrlPressed5xRPYO0(int r100) {
        if ((r100 & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isForwardPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m6094isForwardPressedaHzCxE(int r100) {
        if ((r100 & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isFunctionPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m6095isFunctionPressed5xRPYO0(int r100) {
        if ((r100 & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isMetaPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m6096isMetaPressed5xRPYO0(int r100) {
        if ((r100 & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isNumLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m6097isNumLockOn5xRPYO0(int r100) {
        if ((r100 & 2097152) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isPrimaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m6099isPrimaryPressedaHzCxE(int r100) {
        if ((r100 & 33) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isScrollLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m6100isScrollLockOn5xRPYO0(int r100) {
        if ((r100 & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isSecondaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m6101isSecondaryPressedaHzCxE(int r100) {
        if ((r100 & 66) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isShiftPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m6102isShiftPressed5xRPYO0(int r100) {
        if ((r100 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: isSymPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m6103isSymPressed5xRPYO0(int r100) {
        if ((r100 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isTertiaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m6104isTertiaryPressedaHzCxE(int r100) {
        if ((r100 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isPressed-bNIWhpI, reason: not valid java name */
    public static final boolean m6098isPressedbNIWhpI(int r100, int r101) {
        if (r101 == 0) goto L20;
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L15;
        if ((r100 & (1 << (r101 + 2))) != 0) goto L23;
    L17:
        return false;
    L23:
        return true;
    L15:
        if ((r100 & (1 << r101)) == 0) goto L17;
        return true;
    L22:
        return m6101isSecondaryPressedaHzCxE(r100);
    L20:
        return m6099isPrimaryPressedaHzCxE(r100);
    }
}
