package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.obric.oui.lisitem.OListItemGeneral;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(30)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/selection/OActionSheetItemView;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setIcon", "", "drawable", "Landroid/graphics/drawable/Drawable;", "setTitle", "str", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheetItemView extends OListItemGeneral {
    public OActionSheetItemView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setShowBackground(true);
    }

    public final void setIcon(@Nullable Drawable r10) {
        setContentImage(r10);
    }

    public final void setTitle(@NotNull String r10) {
        q.g(r10, "str");
        setTitleString(r10);
    }
}
