package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.ui.OUIChip;

/* JADX INFO: loaded from: classes2.dex */
public class SearchChipsView extends ConstraintLayout {
    public static final int BLUE = 145;
    public static final int BROWN = 144;
    public static final int CHIPS_MAX_LINES = 1;
    public static final int GRAY = 148;
    public static final int GRAY_ICON = 147;
    public static final int RED = 2;
    public static final int RED_ICON = 4;
    public static final int WHITE = 0;
    public static final int WHITE_ICON = 1;
    public static final int WHITE_SEARCH_ICON = 146;
    public static final int YELLOW = 8;
    private final OUIChip mChip;
    private int mType;

    public SearchChipsView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ void g(SearchChipsView r10, View.OnClickListener r11, View r12) {
        r10.lambda$setOnClickListener$0(r11, r12);
    }

    private /* synthetic */ void lambda$setOnClickListener$0(View.OnClickListener r10, View r11) {
        if (r10 == null) goto L5;
        r10.onClick(this);
        return;
    }

    private void updateBackgroundAndTextColor() {
        OUIChip r10 = this.mChip;
        Context r11 = getContext();
        int r12 = R$color.oui_bg_base_2_2_low_elevation;
        r10.setBackgroundColor(r11.getColor(r12));
        int r13 = this.mType;
        if (r13 != 0) goto L5;
    L19:
        this.mChip.getIcon().setVisibility(8);
        this.mChip.setTint(getContext().getColor(r12));
        return;
    L5:
        if (r13 != 1) goto L7;
        this.mChip.getIcon().setVisibility(0);
        this.mChip.getIcon().setImageResource(R$drawable.oui_icon_time_0_7);
        this.mChip.setTint(getContext().getColor(r12));
        return;
    L7:
        if (r13 != 2) goto L9;
        this.mChip.getIcon().setVisibility(8);
        this.mChip.setTint(getContext().getColor(R$color.oui_red_1));
        return;
    L9:
        if (r13 == 4) goto L16;
        if (r13 == 8) goto L19;
        switch(r13) {
            case 144: goto L19;
            case 145: goto L19;
            case 146: goto L15;
            case 147: goto L14;
            case 148: goto L13;
            default: goto L27;
        };
    L13:
        this.mChip.getIcon().setVisibility(8);
        this.mChip.setTint(getContext().getColor(R$color.oui_fill_element_2));
        return;
    L14:
        this.mChip.getIcon().setVisibility(0);
        this.mChip.getIcon().setImageResource(R$drawable.oui_icon_time_0_7);
        this.mChip.setTint(getContext().getColor(R$color.oui_fill_element_2));
        return;
    L15:
        this.mChip.getIcon().setVisibility(0);
        this.mChip.getIcon().setImageResource(R$drawable.oui_icon_search);
        this.mChip.setTint(getContext().getColor(r12));
        return;
    L27:
        return;
    L16:
        this.mChip.getIcon().setVisibility(0);
        this.mChip.getIcon().setImageResource(R$drawable.oui_icon_fire);
        this.mChip.setTint(getContext().getColor(R$color.oui_red_1));
    }

    public CharSequence getText() {
        return this.mChip.getTextView().getText();
    }

    public int getType() {
        return this.mType;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable final View.OnClickListener r10) {
        this.mChip.setOnClickListener(new d(this, r10));
    }

    public void setText(CharSequence r10) {
        this.mChip.getTextView().setText(r10);
    }

    public void setType(int r10) {
        this.mType = r10;
        updateBackgroundAndTextColor();
    }

    public SearchChipsView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public SearchChipsView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mType = 0;
        LayoutInflater.from(getContext()).inflate(R$layout.app_search_chips, this);
        OUIChip r13 = (OUIChip) findViewById(R$id.chip);
        this.mChip = r13;
        r13.setEnableChecked(false);
        setBackgroundResource(R$drawable.oui_search_chips_background);
        setClickable(true);
        setType(0);
    }
}
