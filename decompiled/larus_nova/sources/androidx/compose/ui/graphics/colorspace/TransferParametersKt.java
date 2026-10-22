package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TypePQish", "", "TypeHLGish", "isSpecialG", "", "gamma", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransferParametersKt {
    public static final double TypeHLGish = -3.0d;
    public static final double TypePQish = -2.0d;

    private static final boolean isSpecialG(double r100) {
        if (r100 != (-2.0d)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return true;
    L8:
        if (r100 != (-3.0d)) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$isSpecialG(double r100) {
        return isSpecialG(r100);
    }
}
