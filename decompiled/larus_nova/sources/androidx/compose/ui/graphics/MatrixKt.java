package androidx.compose.ui.graphics;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u000b*\u00020\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"dot", "", Keys.API_PARAM_KEY_M1, "Landroidx/compose/ui/graphics/Matrix;", SlcFlexDirection.FLEX_ROW, "", Keys.API_PARAM_KEY_M2, "column", "dot-p89u6pk", "([FI[FI)F", "isIdentity", "", "isIdentity-58bKbWc", "([F)Z", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MatrixKt {
    /* JADX INFO: renamed from: isIdentity-58bKbWc, reason: not valid java name */
    public static final boolean m5102isIdentity58bKbWc(float[] r100) {
        if (r100.length >= 16) goto L6;
        return false;
    L6:
        if (r100[0] != 1.0f) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        return false;
    L11:
        if (r100[1] != 0.0f) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L16;
        return false;
    L16:
        if (r100[2] != 0.0f) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == true) goto L21;
        return false;
    L21:
        if (r100[3] != 0.0f) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == true) goto L26;
        return false;
    L26:
        if (r100[4] != 0.0f) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == true) goto L31;
        return false;
    L31:
        if (r100[5] != 1.0f) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == true) goto L36;
        return false;
    L36:
        if (r100[6] != 0.0f) goto L38;
        boolean r107 = true;
    L39:
        if (r107 == true) goto L41;
        return false;
    L41:
        if (r100[7] != 0.0f) goto L43;
        boolean r108 = true;
    L44:
        if (r108 == true) goto L46;
        return false;
    L46:
        if (r100[8] != 0.0f) goto L48;
        boolean r109 = true;
    L49:
        if (r109 == true) goto L51;
        return false;
    L51:
        if (r100[9] != 0.0f) goto L53;
        boolean r110 = true;
    L54:
        if (r110 == true) goto L56;
        return false;
    L56:
        if (r100[10] != 1.0f) goto L58;
        boolean r111 = true;
    L59:
        if (r111 == true) goto L61;
        return false;
    L61:
        if (r100[11] != 0.0f) goto L63;
        boolean r112 = true;
    L64:
        if (r112 == true) goto L66;
        return false;
    L66:
        if (r100[12] != 0.0f) goto L68;
        boolean r113 = true;
    L69:
        if (r113 == true) goto L71;
        return false;
    L71:
        if (r100[13] != 0.0f) goto L73;
        boolean r114 = true;
    L74:
        if (r114 == true) goto L76;
        return false;
    L76:
        if (r100[14] != 0.0f) goto L78;
        boolean r115 = true;
    L79:
        if (r115 == true) goto L81;
        return false;
    L81:
        if (r100[15] != 1.0f) goto L83;
        boolean r116 = true;
    L84:
        if (r116 == false) goto L102;
        return true;
    L102:
        return false;
    L83:
        r116 = false;
        goto L84
    L78:
        r115 = false;
        goto L79
    L73:
        r114 = false;
        goto L74
    L68:
        r113 = false;
        goto L69
    L63:
        r112 = false;
        goto L64
    L58:
        r111 = false;
        goto L59
    L53:
        r110 = false;
        goto L54
    L48:
        r109 = false;
        goto L49
    L43:
        r108 = false;
        goto L44
    L38:
        r107 = false;
        goto L39
    L33:
        r106 = false;
        goto L34
    L28:
        r105 = false;
        goto L29
    L23:
        r104 = false;
        goto L24
    L18:
        r103 = false;
        goto L19
    L13:
        r102 = false;
        goto L14
    L8:
        r101 = false;
        goto L9
    }

    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m5101dotp89u6pk(float[] r100, int r101, float[] r102, int r103) {
        int r104 = r101 * 4;
        return (((r100[r104 + 0] * r102[0 + r103]) + (r100[r104 + 1] * r102[4 + r103])) + (r100[r104 + 2] * r102[8 + r103])) + (r100[r104 + 3] * r102[12 + r103]);
    }
}
