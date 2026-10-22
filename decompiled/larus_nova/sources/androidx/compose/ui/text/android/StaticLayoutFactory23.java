package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.StaticLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory23;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "<init>", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    public StaticLayoutFactory23() {
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout create(StaticLayoutParams r100) {
        StaticLayout.Builder r101 = StaticLayout.Builder.obtain(r100.getText(), r100.getStart(), r100.getEnd(), r100.getPaint(), r100.getWidth());
        r101.setTextDirection(r100.getTextDir());
        r101.setAlignment(r100.getAlignment());
        r101.setMaxLines(r100.getMaxLines());
        r101.setEllipsize(r100.getEllipsize());
        r101.setEllipsizedWidth(r100.getEllipsizedWidth());
        r101.setLineSpacing(r100.getLineSpacingExtra(), r100.getLineSpacingMultiplier());
        r101.setIncludePad(r100.getIncludePadding());
        r101.setBreakStrategy(r100.getBreakStrategy());
        r101.setHyphenationFrequency(r100.getHyphenationFrequency());
        r101.setIndents(r100.getLeftIndents(), r100.getRightIndents());
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 26) goto L6;
        StaticLayoutFactory26.setJustificationMode(r101, r100.getJustificationMode());
    L6:
        if (r102 < 28) goto L9;
        StaticLayoutFactory28.setUseLineSpacingFromFallbacks(r101, r100.getUseFallbackLineSpacing());
    L9:
        if (r102 < 33) goto L12;
        StaticLayoutFactory33.setLineBreakConfig(r101, r100.getLineBreakStyle(), r100.getLineBreakWordStyle());
    L12:
        if (r102 < 35) goto L15;
        StaticLayoutFactory35.disableUseBoundsForWidth(r101);
    L15:
        return r101.build();
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public boolean isFallbackLineSpacingEnabled(StaticLayout r100, boolean r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 33) goto L6;
        return StaticLayoutFactory33.isFallbackLineSpacingEnabled(r100);
    L6:
        if (r102 >= 28) goto L11;
        return false;
    L11:
        return r101;
    }
}
