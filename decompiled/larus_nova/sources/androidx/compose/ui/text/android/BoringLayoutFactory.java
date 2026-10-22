package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJZ\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\r¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/android/BoringLayoutFactory;", "", "<init>", "()V", "measure", "Landroid/text/BoringLayout$Metrics;", "text", "", "paint", "Landroid/text/TextPaint;", "textDir", "Landroid/text/TextDirectionHeuristic;", "create", "Landroid/text/BoringLayout;", "width", "", "metrics", "alignment", "Landroid/text/Layout$Alignment;", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isFallbackLineSpacingEnabled", "layout", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BoringLayoutFactory {
    public static final int $stable = 0;
    public static final BoringLayoutFactory INSTANCE = null;

    static {
        INSTANCE = new BoringLayoutFactory();
    }

    private BoringLayoutFactory() {
    }

    public final boolean isFallbackLineSpacingEnabled(BoringLayout r100) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return BoringLayoutFactory33.isFallbackLineSpacingEnabled(r100);
    }

    public final BoringLayout.Metrics measure(CharSequence r100, TextPaint r101, TextDirectionHeuristic r102) {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        return BoringLayoutFactory33.isBoring(r100, r101, r102);
    L6:
        return BoringLayoutFactoryDefault.isBoring(r100, r101, r102);
    }

    public final BoringLayout create(CharSequence r110, TextPaint r111, int r112, BoringLayout.Metrics r113, Layout.Alignment r114, boolean r115, boolean r210, TextUtils.TruncateAt r211, int r212) {
        boolean r100 = true;
        if (r112 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("negative width");
    L8:
        if (r212 >= 0) goto L11;
        r100 = false;
    L11:
        if (r100 == true) goto L14;
        InlineClassHelperKt.throwIllegalArgumentException("negative ellipsized width");
    L14:
        if (Build.VERSION.SDK_INT < 33) goto L17;
        return BoringLayoutFactory33.create(r110, r111, r112, r114, 1.0f, 0.0f, r113, r115, r210, r211, r212);
    L17:
        return BoringLayoutFactoryDefault.create(r110, r111, r112, r114, 1.0f, 0.0f, r113, r115, r211, r212);
    L5:
        r101 = false;
        goto L6
    }

    public static /* synthetic */ BoringLayout create$default(BoringLayoutFactory r110, CharSequence r111, TextPaint r112, int r113, BoringLayout.Metrics r114, Layout.Alignment r115, boolean r116, boolean r117, TextUtils.TruncateAt r210, int r211, int r212, Object r213) {
        if ((r212 & 16) == 0) goto L5;
        Layout.Alignment r100 = Layout.Alignment.ALIGN_NORMAL;
    L7:
        if ((r212 & 32) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r212 & 64) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r212 & 128) == 0) goto L17;
        TextUtils.TruncateAt r118 = null;
    L19:
        if ((r212 & 256) == 0) goto L21;
        int r119 = r113;
    L23:
        return r110.create(r111, r112, r113, r114, r100, r101, r102, r118, r119);
    L21:
        r119 = r211;
        goto L23
    L17:
        r118 = r210;
        goto L19
    L13:
        r102 = r117;
        goto L15
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }
}
