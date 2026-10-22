package androidx.compose.ui.spatial;

import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\r\u0010\u0011\u001a\u00020\u0006*\u00020\u0001H\u0080\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001f\u0010\n\u001a\u00020\u0001*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\r\"\u001f\u0010\u000e\u001a\u00020\u0001*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2 = {"isSet", "", "Landroidx/compose/ui/unit/IntOffset;", "isSet--gyyYBs", "(J)Z", "analyzeComponents", "", "Landroidx/compose/ui/graphics/Matrix;", "analyzeComponents-58bKbWc", "([F)I", "isIdentity", "isIdentity$annotations", "(I)V", "(I)Z", "hasNonTranslationComponents", "getHasNonTranslationComponents$annotations", "getHasNonTranslationComponents", "toInt", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RectManagerKt {
    private static final boolean getHasNonTranslationComponents(int r100) {
        if ((r100 & 2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ void getHasNonTranslationComponents$annotations(int r100) {
    }

    private static final boolean isIdentity(int r100) {
        if (r100 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ void isIdentity$annotations(int r100) {
    }

    public static final int toInt(boolean r100) {
        return r100 ? 1 : 0;
    }

    /* JADX INFO: renamed from: access$analyzeComponents-58bKbWc, reason: not valid java name */
    public static final /* synthetic */ int m6793access$analyzeComponents58bKbWc(float[] r100) {
        return m6795analyzeComponents58bKbWc(r100);
    }

    /* JADX INFO: renamed from: access$isSet--gyyYBs, reason: not valid java name */
    public static final /* synthetic */ boolean m6794access$isSetgyyYBs(long r100) {
        return m6796isSetgyyYBs(r100);
    }

    /* JADX INFO: renamed from: analyzeComponents-58bKbWc, reason: not valid java name */
    private static final int m6795analyzeComponents58bKbWc(float[] r100) {
        int r101 = 0;
        if (r100.length >= 16) goto L6;
        return 0;
    L6:
        if (r100[0] != 1.0f) goto L8;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
    L52:
        int r103 = 0;
    L54:
        if (r100[12] != 0.0f) goto L56;
        boolean r104 = true;
    L57:
        if (r104 == false) goto L75;
        if (r100[13] != 0.0f) goto L61;
        boolean r105 = true;
    L62:
        if (r105 == false) goto L75;
        if (r100[14] != 0.0f) goto L66;
        boolean r106 = true;
    L67:
        if (r106 == false) goto L75;
        if (r100[15] != 1.0f) goto L71;
        boolean r107 = true;
    L72:
        if (r107 == false) goto L75;
        r101 = 1;
        goto L75
    L71:
        r107 = false;
        goto L72
    L66:
        r106 = false;
        goto L67
    L61:
        r105 = false;
    L75:
        return (r103 << 1) | r101;
    L56:
        r104 = false;
        goto L57
    L12:
        if (r100[1] != 0.0f) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L52;
        if (r100[2] != 0.0f) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L52;
        if (r100[4] != 0.0f) goto L24;
        boolean r110 = true;
    L25:
        if (r110 == false) goto L52;
        if (r100[5] != 1.0f) goto L29;
        boolean r111 = true;
    L30:
        if (r111 == false) goto L52;
        if (r100[6] != 0.0f) goto L34;
        boolean r112 = true;
    L35:
        if (r112 == false) goto L52;
        if (r100[8] != 0.0f) goto L39;
        boolean r113 = true;
    L40:
        if (r113 == false) goto L52;
        if (r100[9] != 0.0f) goto L44;
        boolean r114 = true;
    L45:
        if (r114 == false) goto L52;
        if (r100[10] != 1.0f) goto L49;
        boolean r115 = true;
    L50:
        if (r115 == false) goto L52;
        r103 = 1;
        goto L54
    L49:
        r115 = false;
        goto L50
    L44:
        r114 = false;
        goto L45
    L39:
        r113 = false;
        goto L40
    L34:
        r112 = false;
        goto L35
    L29:
        r111 = false;
        goto L30
    L24:
        r110 = false;
        goto L25
    L19:
        r109 = false;
        goto L20
    L14:
        r108 = false;
        goto L15
    L8:
        r102 = false;
        goto L10
    }

    /* JADX INFO: renamed from: isSet--gyyYBs, reason: not valid java name */
    private static final boolean m6796isSetgyyYBs(long r100) {
        return !IntOffset.m7675equalsimpl0(r100, IntOffset.Companion.m7686getMaxnOccac());
    }
}
