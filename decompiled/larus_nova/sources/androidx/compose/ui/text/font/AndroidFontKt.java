package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0014\u001a\b\u0010\u0015\u001a\u00020\u0016H\u0002¨\u0006\u0017"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "path", "", "assetManager", "Landroid/content/res/AssetManager;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-MuC2MFs", "(Ljava/lang/String;Landroid/content/res/AssetManager;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "file", "Ljava/io/File;", "Font-Ej4NQ78", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "generateAndroidFontKtForApiCompatibility", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidFontKt {
    private static final void generateAndroidFontKtForApiCompatibility() {
    }

    /* JADX INFO: renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m7055FontEj4NQ78(ParcelFileDescriptor r100, FontWeight r101, int r102, FontVariation.Settings r110) {
        return new AndroidFileDescriptorFont(r100, r101, r102, r110, null);
    }

    /* JADX INFO: renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m7056FontEj4NQ78(File r100, FontWeight r101, int r102, FontVariation.Settings r110) {
        return new AndroidFileFont(r100, r101, r102, r110, null);
    }

    /* JADX INFO: renamed from: Font-MuC2MFs, reason: not valid java name */
    public static final Font m7059FontMuC2MFs(String r100, AssetManager r101, FontWeight r110, int r111, FontVariation.Settings r112) {
        return new AndroidAssetFont(r101, r100, r110, r111, r112, null);
    }

    /* JADX INFO: renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m7057FontEj4NQ78$default(ParcelFileDescriptor r100, FontWeight r101, int r102, FontVariation.Settings r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = FontWeight.Companion.getNormal();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = FontStyle.Companion.m7119getNormal_LCdwA();
    L9:
        if ((r104 & 8) == 0) goto L12;
        r103 = FontVariation.INSTANCE.m7134Settings6EWAqTQ(r101, r102, new FontVariation.Setting[0]);
    L12:
        return m7055FontEj4NQ78(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m7058FontEj4NQ78$default(File r100, FontWeight r101, int r102, FontVariation.Settings r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = FontWeight.Companion.getNormal();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = FontStyle.Companion.m7119getNormal_LCdwA();
    L9:
        if ((r104 & 8) == 0) goto L12;
        r103 = FontVariation.INSTANCE.m7134Settings6EWAqTQ(r101, r102, new FontVariation.Setting[0]);
    L12:
        return m7056FontEj4NQ78(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: Font-MuC2MFs$default, reason: not valid java name */
    public static /* synthetic */ Font m7060FontMuC2MFs$default(String r100, AssetManager r101, FontWeight r102, int r103, FontVariation.Settings r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r102 = FontWeight.Companion.getNormal();
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = FontStyle.Companion.m7119getNormal_LCdwA();
    L9:
        if ((r105 & 16) == 0) goto L12;
        r104 = FontVariation.INSTANCE.m7134Settings6EWAqTQ(r102, r103, new FontVariation.Setting[0]);
    L12:
        return m7059FontMuC2MFs(r100, r101, r102, r103, r104);
    }
}
