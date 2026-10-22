package androidx.compose.ui.unit.fontscaling;

import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.unit.InlineClassHelperKt;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0005H\u0007J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\nH\u0002J&\u0010$\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\nH\u0002J\u0013\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\u0005H\u0082\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterFactory;", "", "<init>", "()V", "ScaleKeyMultiplier", "", "CommonFontSizes", "", "sLookupTables", "Landroidx/collection/SparseArrayCompat;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "getSLookupTables$annotations", "getSLookupTables", "()Landroidx/collection/SparseArrayCompat;", "setSLookupTables", "(Landroidx/collection/SparseArrayCompat;)V", "LookupTablesWriteLock", "", "[Ljava/lang/Object;", "MinScaleForNonLinear", "isNonLinearFontScalingActive", "", "fontScale", "forScale", "createInterpolatedTableBetween", "start", "end", "interpolationPoint", "getKey", "", "getScaleFromKey", "key", "put", "", "scaleKey", "fontScaleConverter", "putInto", CopyContentTypeString.TABLE, MonitorConstants.CONNECT_TYPE_GET, "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FontScaleConverterFactory {
    public static final int $stable = 0;
    private static final float[] CommonFontSizes = null;
    public static final FontScaleConverterFactory INSTANCE = null;
    private static final Object[] LookupTablesWriteLock = null;
    private static final float MinScaleForNonLinear = 1.03f;
    private static final float ScaleKeyMultiplier = 100.0f;
    private static volatile SparseArrayCompat<FontScaleConverter> sLookupTables;

    private FontScaleConverterFactory() {
    }

    private final int getKey(float r100) {
        return (int) (r100 * ScaleKeyMultiplier);
    }

    public static /* synthetic */ void getSLookupTables$annotations() {
    }

    private final float getScaleFromKey(int r100) {
        return r100 / ScaleKeyMultiplier;
    }

    public final boolean isNonLinearFontScalingActive(float r100) {
        if (r100 < MinScaleForNonLinear) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        FontScaleConverterFactory r100 = new FontScaleConverterFactory();
        INSTANCE = r100;
        CommonFontSizes = new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier};
        boolean r101 = false;
        sLookupTables = new SparseArrayCompat(0, 1, null);
        Object[] r102 = new Object[0];
        LookupTablesWriteLock = r102;
        monitor-enter(r102);
        r100.putInto(sLookupTables, 1.15f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, ScaleKeyMultiplier}));     // Catch: Throwable -> L13
        r100.putInto(sLookupTables, 1.3f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, ScaleKeyMultiplier}));     // Catch: Throwable -> L13
        r100.putInto(sLookupTables, 1.5f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, ScaleKeyMultiplier}));     // Catch: Throwable -> L13
        r100.putInto(sLookupTables, 1.8f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, ScaleKeyMultiplier}));     // Catch: Throwable -> L13
        r100.putInto(sLookupTables, 2.0f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, ScaleKeyMultiplier}));     // Catch: Throwable -> L13
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        if ((r100.getScaleFromKey(sLookupTables.keyAt(0)) - 0.01f) <= MinScaleForNonLinear) goto L9;
        r101 = true;
    L9:
        if (r101 == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException("You should only apply non-linear scaling to font scales > 1");
    L11:
        $stable = 8;
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final SparseArrayCompat<FontScaleConverter> getSLookupTables() {
        return sLookupTables;
    }

    private final FontScaleConverter get(float r100) {
        return sLookupTables.get(getKey(r100));
    }

    public final FontScaleConverter forScale(float r110) {
        if (isNonLinearFontScalingActive(r110) == true) goto L6;
        return null;
    L6:
        FontScaleConverter r100 = INSTANCE.get(r110);
        if (r100 == null) goto L9;
        return r100;
    L9:
        int r101 = sLookupTables.indexOfKey(getKey(r110));
        if (r101 >= 0) goto L12;
        int r102 = (-(r101 + 1)) - 1;
        int r103 = r102 + 1;
        if (r103 < sLookupTables.size()) goto L16;
        FontScaleConverterTable r104 = new FontScaleConverterTable(new float[]{1.0f}, new float[]{r110});
        put(r110, r104);
        return r104;
    L16:
        if (r102 >= 0) goto L18;
        float[] r105 = CommonFontSizes;
        FontScaleConverter r106 = new FontScaleConverterTable(r105, r105);
        float r107 = 1.0f;
    L19:
        FontScaleConverter r108 = createInterpolatedTableBetween(r106, sLookupTables.valueAt(r103), MathUtils.INSTANCE.constrainedMap(0.0f, 1.0f, r107, getScaleFromKey(sLookupTables.keyAt(r103)), r110));
        put(r110, r108);
        return r108;
    L18:
        float r109 = getScaleFromKey(sLookupTables.keyAt(r102));
        r106 = sLookupTables.valueAt(r102);
        r107 = r109;
        goto L19
    L12:
        return sLookupTables.valueAt(r101);
    }

    public final void setSLookupTables(SparseArrayCompat<FontScaleConverter> r100) {
        sLookupTables = r100;
    }

    private final void put(float r100, FontScaleConverter r101) {
        Object[] r102 = LookupTablesWriteLock;
        monitor-enter(r102);
        SparseArrayCompat<FontScaleConverter> r103 = sLookupTables.clone();     // Catch: Throwable -> L7
        INSTANCE.putInto(r103, r100, r101);     // Catch: Throwable -> L7
        sLookupTables = r103;     // Catch: Throwable -> L7
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final FontScaleConverter createInterpolatedTableBetween(FontScaleConverter r100, FontScaleConverter r101, float r102) {
        float[] r103 = CommonFontSizes;
        float[] r104 = new float[r103.length];
        int r105 = r103.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L6;
        float r107 = CommonFontSizes[r106];
        float r108 = r100.convertSpToDp(r107);
        float r109 = r101.convertSpToDp(r107);
        r104[r106] = MathUtils.INSTANCE.lerp(r108, r109, r102);
        r106 = r106 + 1;
        goto L3
    L6:
        return new FontScaleConverterTable(CommonFontSizes, r104);
    }

    private final void putInto(SparseArrayCompat<FontScaleConverter> r100, float r101, FontScaleConverter r102) {
        r100.put(getKey(r101), r102);
    }
}
