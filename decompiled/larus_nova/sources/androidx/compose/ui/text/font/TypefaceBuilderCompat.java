package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J$\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J$\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceBuilderCompat;", "", "<init>", "()V", "createFromAssets", "Landroid/graphics/Typeface;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "createFromFile", "file", "Ljava/io/File;", "createFromFileDescriptor", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "toVariationSettings", "", "Landroid/graphics/fonts/FontVariationAxis;", "(Landroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)[Landroid/graphics/fonts/FontVariationAxis;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TypefaceBuilderCompat {
    public static final TypefaceBuilderCompat INSTANCE = null;

    static {
        INSTANCE = new TypefaceBuilderCompat();
    }

    private TypefaceBuilderCompat() {
    }

    private final FontVariationAxis[] toVariationSettings(FontVariation.Settings r100, Context r101) {
        if (r101 == null) goto L5;
        Density r102 = AndroidDensity_androidKt.Density(r101);
    L8:
        return PlatformFontVariationSettings_androidKt.toAndroidArray(r100, r102, PlatformFontVariationSettings_androidKt.getFontWeightAdjustment(r101));
    L5:
        if (r100.getNeedsDensity$ui_text() == true) goto L10;
        r102 = DensityKt.Density(1.0f, 1.0f);
        goto L8
    L10:
        throw new IllegalStateException("Required density, but not provided");
    }

    public final android.graphics.Typeface createFromFile(File r100, Context r101, FontVariation.Settings r102) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return new android.graphics.Typeface.Builder(r100).setFontVariationSettings(toVariationSettings(r102, r101)).build();
    }

    public final android.graphics.Typeface createFromFileDescriptor(ParcelFileDescriptor r100, Context r101, FontVariation.Settings r102) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return new android.graphics.Typeface.Builder(r100.getFileDescriptor()).setFontVariationSettings(toVariationSettings(r102, r101)).build();
    }

    public final android.graphics.Typeface createFromAssets(AssetManager r100, String r101, Context r102, FontVariation.Settings r103) {
        if (r102 != null) goto L6;
        return null;
    L6:
        return new android.graphics.Typeface.Builder(r100, r101).setFontVariationSettings(toVariationSettings(r103, r102)).build();
    }
}
