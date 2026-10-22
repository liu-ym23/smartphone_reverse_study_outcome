package com.obric.oui.picker.reels.pickers;

import android.content.Context;
import android.util.AttributeSet;
import java.util.function.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J+\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "FT", "DT", "", "build", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)Ljava/lang/Object;", "setOnChangedListener", "", "listener", "Ljava/util/function/Consumer;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OReelPickerBuilder<FT, DT> {

    public static final class a {
        public static /* synthetic */ Object a(OReelPickerBuilder r10, Context r11, AttributeSet r12, int r13, int r14, Object r15) {
            if (r15 != null) goto L12;
            if ((r14 & 2) == 0) goto L7;
            r12 = null;
        L7:
            if ((r14 & 4) == 0) goto L10;
            r13 = 0;
        L10:
            return r10.build(r11, r12, r13);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
        }
    }

    FT build(@NotNull Context r10, @Nullable AttributeSet r11, int r12);

    void setOnChangedListener(@NotNull Consumer<DT> r10);
}
