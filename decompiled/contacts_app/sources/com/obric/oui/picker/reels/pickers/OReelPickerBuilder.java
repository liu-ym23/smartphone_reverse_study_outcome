package com.obric.oui.picker.reels.pickers;

import android.content.Context;
import android.util.AttributeSet;
import java.util.function.Consumer;
import kotlin.Metadata;

/* JADX INFO: compiled from: OReelPickerBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J+\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "FT", "DT", "", "build", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)Ljava/lang/Object;", "setOnChangedListener", "", "listener", "Ljava/util/function/Consumer;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OReelPickerBuilder<FT, DT> {

    /* JADX INFO: compiled from: OReelPickerBuilder.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object build$default(OReelPickerBuilder r0, Context r1, AttributeSet r2, int r3, int r4, Object r5) {
            if (r5 != null) goto L12;
            if ((r4 & 2) == 0) goto L7;
            r2 = null;
        L7:
            if ((r4 & 4) == 0) goto L10;
            r3 = 0;
        L10:
            return r0.build(r1, r2, r3);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
        }
    }

    FT build(Context r1, AttributeSet r2, int r3);

    void setOnChangedListener(Consumer<DT> r1);
}
