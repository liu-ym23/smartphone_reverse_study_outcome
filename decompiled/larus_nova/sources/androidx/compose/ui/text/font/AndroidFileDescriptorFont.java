package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0010¢\u0006\u0002\b\u0012J\b\u0010\u0017\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFileDescriptorFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFileDescriptor", "()Landroid/os/ParcelFileDescriptor;", "doLoad", "Landroid/graphics/Typeface;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "doLoad$ui_text", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidFileDescriptorFont extends AndroidPreloadedFont {
    public static final int $stable = 0;
    private final String cacheKey;
    private final ParcelFileDescriptor fileDescriptor;

    public /* synthetic */ AndroidFileDescriptorFont(ParcelFileDescriptor r100, FontWeight r101, int r102, FontVariation.Settings r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public String toString() {
        return "Font(fileDescriptor=" + this.fileDescriptor + ", weight=" + getWeight() + ", style=" + FontStyle.m7114toStringimpl(mo7064getStyle_LCdwA()) + ')';
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String getCacheKey() {
        return this.cacheKey;
    }

    public final ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public android.graphics.Typeface doLoad$ui_text(Context r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return TypefaceBuilderCompat.INSTANCE.createFromFileDescriptor(this.fileDescriptor, r100, getVariationSettings());
    L7:
        throw new IllegalArgumentException("Cannot create font from file descriptor for SDK < 26");
    }

    private AndroidFileDescriptorFont(ParcelFileDescriptor r100, FontWeight r101, int r102, FontVariation.Settings r103) {
        super(r101, r102, r103, null);
        this.fileDescriptor = r100;
        setTypeface$ui_text(doLoad$ui_text(null));
    }

    public /* synthetic */ AndroidFileDescriptorFont(ParcelFileDescriptor r100, FontWeight r101, int r102, FontVariation.Settings r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 2) == 0) goto L5;
        r101 = FontWeight.Companion.getNormal();
    L5:
        FontWeight r103 = r101;
        if ((r111 & 4) == 0) goto L8;
        r102 = FontStyle.Companion.m7119getNormal_LCdwA();
    L8:
        this(r100, r103, r102, r110, null);
    }
}
