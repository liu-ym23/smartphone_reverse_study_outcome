package com.android.contacts.util;

import android.content.Context;
import android.widget.ImageView;
import com.android.contacts.R;
import obric.widget.TitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class TitleBarUtil {

    public interface TitleBarRes {
        public static final int ADD = 2131234947;
        public static final int BACK = 2131231636;
        public static final int CANCEL = 2131231639;
        public static final int DONE = 2131234955;
        public static final int DONE_20 = 2131234956;
        public static final int DONE_22_WHITE = 2131234957;
        public static final int EDIT = 2131234971;
        public static final int FILTER = 2131234973;
        public static final int HIGHLIGHT_DELETE = 2131234989;
        public static final int HIGHLIGHT_DONE = 2131232127;
        public static final int HIGHLIGHT_EDIT = 2131234998;
        public static final int HIGHLIGHT_SELECT = 2131235006;
        public static final int MENU = 2131231658;
        public static final int SELECT = 2131235015;
        public static final int SETTINGS = 2131235023;
        public static final int SETTINGS_TITLE = 2131234812;
        public static final int SHARE = 2131235031;
        public static final int SORT = 2131235039;
    }

    public static final int getLeftRes(boolean r0) {
        if (r0 == false) goto L4;
        return R.drawable.icon_back_22_22;
    L4:
        return R.drawable.icon_cancel_22_22;
    }

    public TitleBarUtil() {
    }

    public static final ImageView addLeftIcon(TitleBar r1, int r2) {
        ImageView r0 = onlyAddLeftIcon(r1, r2);
        r0.setContentDescription(getResDesc(r1.getContext(), r2));
        return r0;
    }

    public static final ImageView onlyAddLeftIcon(TitleBar r0, int r1) {
        return r0.addLeftImageView(r1);
    }

    public static final ImageView addRightIcon(TitleBar r1, int r2) {
        ImageView r0 = onlyAddRightIcon(r1, r2);
        r0.setContentDescription(getResDesc(r1.getContext(), r2));
        return r0;
    }

    public static final ImageView onlyAddRightIcon(TitleBar r0, int r1) {
        return r0.addRightImageView(r1);
    }

    public static final void updateIcon(ImageView r1, int r2) {
        r1.setImageResource(r2);
        r1.setContentDescription(getResDesc(r1.getContext(), r2));
    }

    public static final CharSequence getResDesc(Context r0, int r1) {
        switch(r1) {
            case 2131231636: goto L19;
            case 2131231639: goto L17;
            case 2131232127: goto L15;
            case 2131234947: goto L13;
            case 2131234955: goto L15;
            case 2131234971: goto L11;
            case 2131234989: goto L9;
            case 2131234998: goto L11;
            case 2131235006: goto L7;
            case 2131235015: goto L7;
            case 2131235023: goto L5;
            default: goto L20;
        };
    L20:
        return "";
    L5:
        return r0.getText(R.string.common_settings);
    L7:
        return r0.getText(R.string.btn_select);
    L9:
        return r0.getText(R.string.common_delete);
    L11:
        return r0.getText(R.string.common_edit);
    L13:
        return r0.getText(R.string.btn_add);
    L15:
        return r0.getText(R.string.common_done);
    L17:
        return r0.getText(R.string.common_cancel);
    L19:
        return r0.getText(R.string.common_back);
    }
}
