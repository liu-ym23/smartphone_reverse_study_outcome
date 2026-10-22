package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.font.FontVariation;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.SingleFileBundle;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\r\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0014\u001a\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", SingleFileBundle.KEY_PATH, "Landroid/content/res/AssetManager;", "assetManager", "Landroidx/compose/ui/text/font/FontWeight;", "weight", "Landroidx/compose/ui/text/font/FontStyle;", "style", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "variationSettings", "Landroidx/compose/ui/text/font/Font;", "Font-MuC2MFs", "(Ljava/lang/String;Landroid/content/res/AssetManager;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "Font", "Ljava/io/File;", BffConstant.Type.File, "Font-Ej4NQ78", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "Landroid/os/ParcelFileDescriptor;", "fileDescriptor", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "LC7/r;", "generateAndroidFontKtForApiCompatibility", "()V", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidFontKt {
    @Stable
    /* renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m6369FontEj4NQ78(File file, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        return new AndroidFileFont(file, fontWeight, i, settings, null);
    }

    /* renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m6371FontEj4NQ78$default(File file, FontWeight fontWeight, int i, FontVariation.Settings settings, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i6 & 4) != 0) {
            i = FontStyle.INSTANCE.m6429getNormal_LCdwA();
        }
        if ((i6 & 8) != 0) {
            settings = FontVariation.INSTANCE.m6444Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m6369FontEj4NQ78(file, fontWeight, i, settings);
    }

    @Stable
    /* renamed from: Font-MuC2MFs, reason: not valid java name */
    public static final Font m6372FontMuC2MFs(String str, AssetManager assetManager, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        return new AndroidAssetFont(assetManager, str, fontWeight, i, settings, null);
    }

    /* renamed from: Font-MuC2MFs$default, reason: not valid java name */
    public static /* synthetic */ Font m6373FontMuC2MFs$default(String str, AssetManager assetManager, FontWeight fontWeight, int i, FontVariation.Settings settings, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i6 & 8) != 0) {
            i = FontStyle.INSTANCE.m6429getNormal_LCdwA();
        }
        if ((i6 & 16) != 0) {
            settings = FontVariation.INSTANCE.m6444Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m6372FontMuC2MFs(str, assetManager, fontWeight, i, settings);
    }

    private static final void generateAndroidFontKtForApiCompatibility() {
    }

    @Stable
    @RequiresApi(26)
    /* renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m6368FontEj4NQ78(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        return new AndroidFileDescriptorFont(parcelFileDescriptor, fontWeight, i, settings, null);
    }

    /* renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m6370FontEj4NQ78$default(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i, FontVariation.Settings settings, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i6 & 4) != 0) {
            i = FontStyle.INSTANCE.m6429getNormal_LCdwA();
        }
        if ((i6 & 8) != 0) {
            settings = FontVariation.INSTANCE.m6444Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m6368FontEj4NQ78(parcelFileDescriptor, fontWeight, i, settings);
    }
}
