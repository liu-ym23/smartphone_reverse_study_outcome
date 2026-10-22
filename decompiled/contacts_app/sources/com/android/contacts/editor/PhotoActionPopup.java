package com.android.contacts.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.ui.dialog.OUIDialogHelper;
import com.obric.ui.dialog.action.ActionButtonStyle;
import com.obric.ui.dialog.action.ActionDialogItemData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PhotoActionPopup {
    public static final int MODE_NO_PHOTO = 0;
    public static final int MODE_PHOTO_ALLOW_PRIMARY = 3;
    public static final int MODE_PHOTO_DISALLOW_PRIMARY = 2;
    public static final int MODE_READ_ONLY_ALLOW_PRIMARY = 1;
    public static final String TAG = "PhotoActionPopup";

    private static final class ChoiceListItem {
        public static final int ID_PICK_PHOTO = 2;
        public static final int ID_REMOVE = 3;
        public static final int ID_TAKE_PHOTO = 1;
        public static final int ID_USE_AS_PRIMARY = 0;
        private final String mCaption;
        private final int mId;

        public ChoiceListItem(int r1, String r2) {
            this.mId = r1;
            this.mCaption = r2;
        }

        public String toString() {
            return this.mCaption;
        }

        public int getId() {
            return this.mId;
        }
    }

    public interface Listener {
        void onPickFromGalleryChosen();

        void onRemovePictureChosen();

        void onTakePhotoChosen();

        void onUseAsPrimaryChosen();
    }

    public PhotoActionPopup() {
    }

    static /* synthetic */ void access$000(OActionDialog[] r0) {
        dismissDialog(r0);
    }

    public static ListPopupWindow createPopupMenu(Context r6, View r7, final Listener r8, int r9) {
        final ArrayList r0 = new ArrayList(4);
        if (r9 == 3) goto L5;
        if (r9 == 1) goto L5;
    L7:
        if (r9 == 2) goto L9;
        if (r9 == 3) goto L9;
    L10:
        if (r9 == 0) goto L13;
        if (r9 == 3) goto L13;
        if (r9 == 2) goto L13;
    L17:
        if (r9 == 0) goto L20;
        if (r9 == 3) goto L20;
        if (r9 == 2) goto L20;
    L24:
        ArrayAdapter r10 = new ArrayAdapter(r6, R.layout.select_dialog_item, r0);
        final ListPopupWindow r2 = new ListPopupWindow(r6);
        AdapterView.OnItemClickListener r4 = new AnonymousClass1(r0, r2, r8);
        r2.setAnchorView(r7);
        r2.setAdapter(r10);
        r2.setOnItemClickListener(r4);
        r2.setWidth(r6.getResources().getDimensionPixelSize(R.dimen.photo_action_popup_width));
        r2.setModal(true);
        r2.setInputMethodMode(2);
        return r2;
    L20:
        if (r9 != 0) goto L22;
        int r11 = R.string.pick_photo;
    L23:
        r0.add(new ChoiceListItem(2, r6.getString(r11)));
        goto L24
    L22:
        r11 = R.string.pick_new_photo;
    L13:
        if (r9 != 0) goto L15;
        int r5 = R.string.take_photo;
    L16:
        r0.add(new ChoiceListItem(1, r6.getString(r5)));
        goto L17
    L15:
        r5 = R.string.take_new_photo;
    L9:
        r0.add(new ChoiceListItem(3, r6.getString(R.string.removePhoto)));
    L5:
        r0.add(new ChoiceListItem(0, r6.getString(R.string.use_photo_as_primary)));
        goto L7
    }

    public static OActionDialog createMenuDialog(Context r4, Listener r5, int r6) {
        OActionDialog r7 = OUIDialogHelper.getActionDialog(r4, r4.getString(R.string.edit_avatar), "", getPhotoActionItemData(r4, r5, r6, r1), true);
        OActionDialog[] r1 = {r7};
        return r7;
    }

    private static List<ActionDialogItemData> getPhotoActionItemData(Context r7, final Listener r8, int r9, final OActionDialog[] r10) {
        ArrayList r0 = new ArrayList();
        if (r9 != 3) goto L5;
    L6:
        r0.add(new ActionDialogItemData(r7.getString(R.string.use_photo_as_primary), ActionButtonStyle.Neutral, new AnonymousClass2(r8, r10)));
    L8:
        if (r9 == 2) goto L10;
        if (r9 == 3) goto L10;
    L11:
        if (r9 == 0) goto L14;
        if (r9 == 3) goto L14;
        if (r9 == 2) goto L14;
    L18:
        if (r9 == 0) goto L21;
        if (r9 == 3) goto L21;
        if (r9 == 2) goto L21;
    L22:
        return r0;
    L21:
        r0.add(new ActionDialogItemData(r7.getString(R.string.pick_photo_as_avatar), ActionButtonStyle.Neutral, new AnonymousClass5(r8, r10)));
        r0.add(new ActionDialogItemData(r7.getString(R.string.common_cancel), ActionButtonStyle.Neutral, new AnonymousClass6(r10)));
    L14:
        if (r9 != 0) goto L16;
        int r3 = R.string.take_photo;
    L17:
        r0.add(new ActionDialogItemData(r7.getString(r3), ActionButtonStyle.Neutral, new AnonymousClass4(r8, r10)));
        goto L18
    L16:
        r3 = R.string.take_new_photo;
    L10:
        r0.add(new ActionDialogItemData(r7.getString(R.string.removePhoto), ActionButtonStyle.Neutral, new AnonymousClass3(r8, r10)));
        goto L11
    L5:
        if (r9 != 1) goto L8;
        goto L6
    }

    private static void dismissDialog(OActionDialog[] r2) {
        OActionDialog r1 = r2[0];
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isShowing() == false) goto L9;
        r2[0].dismiss();
        return;
    }

    private static View genContentView(View r10, ArrayList<String> r11, ArrayList<View.OnClickListener> r12) {
        LinearLayout r0 = new LinearLayout(r10.getContext());
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(r10.getContext(), 5.0d));
        int r1 = Math.min(r11.size(), r12.size());
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L5;
        OButton r6 = (OButton) LayoutInflater.from(r10.getContext()).inflate(R.layout.sheet_button_left_center_black, null);
        r6.setText(r11.get(r5));
        r6.setOnClickListener(r12.get(r5));
        r6.setWidth(ContactsUtils.dipTopx(r10.getContext(), 296.0d));
        r6.setHeight(ContactsUtils.dipTopx(r10.getContext(), 56.0d));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r7.bottomMargin = ContactsUtils.dipTopx(r10.getContext(), 5.0d);
        r0.addView(r6, r7);
        r5 = r5 + 1;
        goto L3
    L5:
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(r10.getContext(), 15.0d));
        return r0;
    }

    private static View genHeaderView(View r3, final OInsetSheet r4) {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(r3.getContext());
        r0.setShowLeftBack(false);
        r0.setTitleText(r3.getResources().getString(R.string.edit_avatar));
        OButton r5 = r0.createNeutralButton(r3.getContext(), r0.mRightContainer);
        r5.setButtonSourceBitmap(R.drawable.o_ic_close);
        r5.setOnClickListener(new AnonymousClass7(r4));
        return r0;
    }
}
