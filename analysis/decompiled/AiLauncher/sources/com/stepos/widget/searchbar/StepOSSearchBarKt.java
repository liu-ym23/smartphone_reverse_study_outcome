package com.stepos.widget.searchbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.stepos.widget.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¨\u0006\b"}, d2 = {"resolveSearchBarInputHeight", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "StepOSWidget_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSSearchBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int resolveSearchBarInputHeight(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.stepos_searchbar_input_height);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSSearchBar, i10, i11);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSSearchBar_steposSearchBarInputHeight, dimensionPixelSize);
        typedArrayObtainStyledAttributes.recycle();
        if (dimensionPixelSize2 > 0) {
            return dimensionPixelSize2;
        }
        throw new IllegalArgumentException(("steposSearchBarInputHeight must be > 0 but was " + dimensionPixelSize2).toString());
    }
}
