package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OIndexPopupWindowLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\u00020\u00162\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ0\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexPopupWindowLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "popupContainerView", "Landroid/view/View;", "popupImageView", "Landroid/widget/ImageView;", "popupTextView", "Landroid/widget/TextView;", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "setPopupWindow", "(Landroid/widget/PopupWindow;)V", "hidePopup", "", "isShowing", "", "setStyle", "textColor", "", "background", "Landroid/graphics/drawable/Drawable;", "showPopup", "letter", "bitmap", "Landroid/graphics/Bitmap;", MaterialConfigFormatNames.X, "centerY", "minTop", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OIndexPopupWindowLayout extends LinearLayout {
    private final String TAG;
    private View popupContainerView;
    private ImageView popupImageView;
    private TextView popupTextView;
    private PopupWindow popupWindow;

    public /* synthetic */ OIndexPopupWindowLayout(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OIndexPopupWindowLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.TAG = "OIndexPopupWindowLayout";
        View r5 = LayoutInflater.from(r3).inflate(R.layout.o_index_scrollbar_popup_circle, null);
        this.popupContainerView = r5.findViewById(R.id.popup_container);
        this.popupImageView = (ImageView) r5.findViewById(R.id.popup_img);
        this.popupTextView = (TextView) r5.findViewById(R.id.popup_text);
        this.popupWindow = new PopupWindow(r5, -2, -2, false);
    }

    public final PopupWindow getPopupWindow() {
        return this.popupWindow;
    }

    public final void setPopupWindow(PopupWindow r1) {
        this.popupWindow = r1;
    }

    public final void setStyle(int r4, Drawable r5) {
        TextView r0 = this.popupTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r4);
    L6:
        ImageView r1 = this.popupImageView;
        if (r1 == null) goto L10;
        r1.setImageTintList(ColorStateList.valueOf(r4));
    L10:
        ImageView r2 = this.popupImageView;
        if (r2 == null) goto L14;
        r2.setColorFilter(new BlendModeColorFilter(r4, BlendMode.SRC_IN));
    L14:
        View r3 = this.popupContainerView;
        if (r3 == null) goto L19;
        r3.setBackground(r5);
        return;
    }

    public final void showPopup(String r3, Bitmap r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "letter");
        if (r4 != null) goto L16;
        TextView r8 = this.popupTextView;
        if (r8 == null) goto L8;
        r8.setText(r3);
    L8:
        ImageView r9 = this.popupImageView;
        if (r9 == null) goto L12;
        r9.setVisibility(8);
    L12:
        TextView r10 = this.popupTextView;
        if (r10 == null) goto L28;
        r10.setVisibility(0);
    L28:
        PopupWindow r11 = this.popupWindow;
        if (r11 != null) goto L32;
        L.w(this.TAG, "showPopup skipped: popupWindow is null.");
        return;
    L32:
        View r12 = r11.getContentView();
        if (r12 != null) goto L36;
        L.w(this.TAG, "showPopup skipped: contentView is null.");
        return;
    L36:
        int r13 = RangesKt.coerceAtLeast(r6 - (r12.getMeasuredHeight() / 2), r7);
        if (r11.isShowing() == true) goto L39;
        OIndexPopupWindowLayout r2 = this;
        r11.setElevation(OUnitExtensionKt.vdp(r2, 45));
        r11.showAtLocation(r2, 0, r5, r13);
        r12.setElevation(0.0f);
        return;
    L39:
        r11.update(r5, r13, -2, -2);
        return;
    L16:
        TextView r14 = this.popupTextView;
        if (r14 == null) goto L20;
        r14.setVisibility(8);
    L20:
        ImageView r15 = this.popupImageView;
        if (r15 == null) goto L24;
        r15.setVisibility(0);
    L24:
        ImageView r16 = this.popupImageView;
        if (r16 == null) goto L28;
        r16.setImageBitmap(r4);
        goto L28
    }

    public final void hidePopup() {
        PopupWindow r0 = this.popupWindow;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L14;
        PopupWindow r3 = this.popupWindow;
        if (r3 == null) goto L15;
        r3.dismiss();
        return;
    L15:
        return;
    L14:
        return;
    L6:
        if (r0.isShowing() != true) goto L8;
        r1 = true;
        goto L8
    }

    public final boolean isShowing() {
        PopupWindow r2 = this.popupWindow;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.isShowing() == true) goto L8;
        return false;
    L8:
        return true;
    }
}
