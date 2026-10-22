package com.android.contacts.common.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.common.R;
import com.android.contacts.common.util.ViewUtil;

/* JADX INFO: loaded from: classes.dex */
public class ContactListPinnedHeaderView extends TextView {
    public ContactListPinnedHeaderView(Context r5, AttributeSet r6, View r7) {
        super(r5, r6);
        if (R.styleable.ContactListItemView != null) goto L5;
        return;
    L5:
        TypedArray r8 = getContext().obtainStyledAttributes(r6, R.styleable.ContactListItemView);
        int r9 = r8.getColor(R.styleable.ContactListItemView_list_item_background_color, -1);
        int r0 = r8.getDimensionPixelSize(R.styleable.ContactListItemView_list_item_text_offset_top, 0);
        int r1 = r8.getDimensionPixelSize(R.styleable.ContactListItemView_list_item_padding_left, 0);
        int r2 = getResources().getDimensionPixelSize(R.dimen.contact_list_section_header_width) + r1;
        r8.recycle();
        setBackgroundColor(r9);
        setTextAppearance(getContext(), R.style.SectionHeaderStyle);
        setLayoutParams(new LinearLayout.LayoutParams(r2, -2));
        setLayoutDirection(r7.getLayoutDirection());
        if (ViewUtil.isViewLayoutRtl(this) == false) goto L8;
        int r10 = 5;
    L9:
        setGravity(r10 | 16);
        setPaddingRelative(getPaddingStart() + r1, getPaddingTop() + (r0 * 2), getPaddingEnd(), getPaddingBottom());
        return;
    L8:
        r10 = 3;
        goto L9
    }

    public void setSectionHeaderTitle(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        setText(r2);
        setVisibility(0);
        return;
    L5:
        setVisibility(8);
    }
}
