package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0010¢\u0006\u0002\b\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/font/AndroidAssetFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(Landroid/content/res/AssetManager;Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAssetManager", "()Landroid/content/res/AssetManager;", "getPath", "()Ljava/lang/String;", "doLoad", "Landroid/graphics/Typeface;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "doLoad$ui_text", "cacheKey", "getCacheKey", "toString", "equals", "", "other", "", "hashCode", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidAssetFont extends AndroidPreloadedFont {
    public static final int $stable = 0;
    private final AssetManager assetManager;
    private final String cacheKey;
    private final String path;

    public /* synthetic */ AndroidAssetFont(AssetManager r100, String r101, FontWeight r102, int r103, FontVariation.Settings r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + getVariationSettings().hashCode();
    }

    public String toString() {
        return "Font(assetManager, path=" + this.path + ", weight=" + getWeight() + ", style=" + FontStyle.m7114toStringimpl(mo7064getStyle_LCdwA()) + ')';
    }

    public final AssetManager getAssetManager() {
        return this.assetManager;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String getCacheKey() {
        return this.cacheKey;
    }

    public final String getPath() {
        return this.path;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public android.graphics.Typeface doLoad$ui_text(Context r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        return TypefaceBuilderCompat.INSTANCE.createFromAssets(this.assetManager, this.path, r100, getVariationSettings());
    L6:
        return android.graphics.Typeface.createFromAsset(this.assetManager, this.path);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AndroidAssetFont) == true) goto L8;
        return false;
    L8:
        AndroidAssetFont r101 = (AndroidAssetFont) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getVariationSettings(), r101.getVariationSettings()) == true) goto L14;
        return false;
    L14:
        return true;
    }

    private AndroidAssetFont(AssetManager r100, String r101, FontWeight r102, int r103, FontVariation.Settings r104) {
        super(r102, r103, r104, null);
        this.assetManager = r100;
        this.path = r101;
        setTypeface$ui_text(doLoad$ui_text(null));
        this.cacheKey = "asset:" + r101;
    }

    public /* synthetic */ AndroidAssetFont(AssetManager r100, String r101, FontWeight r110, int r111, FontVariation.Settings r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        r110 = FontWeight.Companion.getNormal();
    L5:
        FontWeight r102 = r110;
        if ((r113 & 8) == 0) goto L8;
        r111 = FontStyle.Companion.m7119getNormal_LCdwA();
    L8:
        this(r100, r101, r102, r111, r112, null);
    }
}
