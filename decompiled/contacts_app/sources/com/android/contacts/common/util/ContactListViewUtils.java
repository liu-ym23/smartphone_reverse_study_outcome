package com.android.contacts.common.util;

import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.android.contacts.common.R;
import com.android.vcard.VCardConfig;

/* JADX INFO: loaded from: classes.dex */
public class ContactListViewUtils {
    private static final double TEXT_LEFT_PADDING_TO_CARD_PADDING_RATIO = 1.1d;

    public ContactListViewUtils() {
    }

    static /* synthetic */ void access$000(ListView r0, int r1, int r2, int r3) {
        addPaddingToView(r0, r1, r2, r3);
    }

    private static void addPaddingToView(ListView r2, int r3, int r4, int r5) {
        if (r4 <= 0) goto L6;
        if (r5 <= 0) goto L7;
        int r6 = (int) ((r3 * (((double) r4) / ((double) ((r4 * 2) + r5)))) * TEXT_LEFT_PADDING_TO_CARD_PADDING_RATIO);
        r2.setPadding(r6, r2.getPaddingTop(), r6, r2.getPaddingBottom());
        r2.setClipToPadding(false);
        r2.setScrollBarStyle(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        return;
    L7:
        return;
    }

    public static void applyCardPaddingToView(Resources r3, final ListView r4, final View r5) {
        final int r0 = r3.getInteger(R.integer.contact_list_space_layout_weight);
        final int r6 = r3.getInteger(R.integer.contact_list_card_layout_weight);
        if (r0 <= 0) goto L10;
        if (r6 <= 0) goto L11;
        r5.setBackgroundResource(0);
        View r2 = r5.findViewById(R.id.list_card);
        if (r2 == null) goto L9;
        r2.setVisibility(0);
        SchedulingUtils.doOnPreDraw(r4, false, new AnonymousClass1(r4, r5, r0, r6));
        return;
    L9:
        throw new RuntimeException("Your content must have a list card view who can be turned visible whenever it is necessary.");
    L11:
        return;
    }
}
