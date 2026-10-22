package androidx.compose.ui.platform;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"invertTo", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InvertMatrixKt {
    /* JADX INFO: renamed from: invertTo-JiSxe2E, reason: not valid java name */
    public static final boolean m6708invertToJiSxe2E(float[] r410, float[] r411) {
        if (r410.length >= 16) goto L5;
        return false;
    L5:
        if (r411.length < 16) goto L20;
        float r100 = r410[0];
        float r101 = r410[1];
        float r102 = r410[2];
        float r103 = r410[3];
        float r110 = r410[4];
        float r111 = r410[5];
        float r112 = r410[6];
        float r113 = r410[7];
        float r114 = r410[8];
        float r115 = r410[9];
        float r210 = r410[10];
        float r211 = r410[11];
        float r116 = r410[12];
        float r212 = r410[13];
        float r310 = r410[14];
        float r104 = r410[15];
        float r311 = (r100 * r111) - (r101 * r110);
        float r312 = (r100 * r112) - (r102 * r110);
        float r313 = (r100 * r113) - (r103 * r110);
        float r314 = (r101 * r112) - (r102 * r111);
        float r315 = (r101 * r113) - (r103 * r111);
        float r316 = (r102 * r113) - (r103 * r112);
        float r317 = (r114 * r212) - (r115 * r116);
        float r318 = (r114 * r310) - (r210 * r116);
        float r412 = (r114 * r104) - (r211 * r116);
        float r413 = (r115 * r310) - (r210 * r212);
        float r414 = (r115 * r104) - (r211 * r212);
        float r415 = (r210 * r104) - (r211 * r310);
        float r416 = (((((r311 * r415) - (r312 * r414)) + (r313 * r413)) + (r314 * r412)) - (r315 * r318)) + (r316 * r317);
        if (r416 != 0.0f) goto L10;
        boolean r417 = true;
    L11:
        if (r417 == true) goto L13;
        float r418 = 1.0f / r416;
        r411[0] = (((r111 * r415) - (r112 * r414)) + (r113 * r413)) * r418;
        r411[1] = ((((-r101) * r415) + (r102 * r414)) - (r103 * r413)) * r418;
        r411[2] = (((r212 * r316) - (r310 * r315)) + (r104 * r314)) * r418;
        r411[3] = ((((-r115) * r316) + (r210 * r315)) - (r211 * r314)) * r418;
        float r105 = -r110;
        r411[4] = (((r105 * r415) + (r112 * r412)) - (r113 * r318)) * r418;
        r411[5] = (((r415 * r100) - (r102 * r412)) + (r103 * r318)) * r418;
        float r106 = -r116;
        r411[6] = (((r106 * r316) + (r310 * r313)) - (r104 * r312)) * r418;
        r411[7] = (((r316 * r114) - (r210 * r313)) + (r211 * r312)) * r418;
        r411[8] = (((r110 * r414) - (r111 * r412)) + (r113 * r317)) * r418;
        r411[9] = ((((-r100) * r414) + (r412 * r101)) - (r103 * r317)) * r418;
        r411[10] = (((r116 * r315) - (r212 * r313)) + (r104 * r311)) * r418;
        r411[11] = ((((-r114) * r315) + (r313 * r115)) - (r211 * r311)) * r418;
        r411[12] = (((r105 * r413) + (r111 * r318)) - (r112 * r317)) * r418;
        r411[13] = (((r100 * r413) - (r101 * r318)) + (r102 * r317)) * r418;
        r411[14] = (((r106 * r314) + (r212 * r312)) - (r310 * r311)) * r418;
        r411[15] = (((r114 * r314) - (r115 * r312)) + (r210 * r311)) * r418;
    L13:
        if (r416 != 0.0f) goto L15;
        boolean r107 = true;
    L17:
        return !r107;
    L15:
        r107 = false;
        goto L17
    L10:
        r417 = false;
        goto L11
    L20:
        return false;
    }
}
