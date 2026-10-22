package com.android.contacts.util;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class DialogManager {
    public static final String VIEW_ID_KEY = "view_id";
    private final Activity mActivity;
    private boolean mUseDialogId2;

    public interface DialogShowingView {
        Dialog createDialog(Bundle r1);
    }

    public interface DialogShowingViewActivity {
        DialogManager getDialogManager();
    }

    public static final boolean isManagedId(int r1) {
        if (r1 != R.id.dialog_manager_id_1) goto L5;
    L8:
        return true;
    L5:
        if (r1 == R.id.dialog_manager_id_2) goto L8;
        return false;
    }

    static /* synthetic */ Activity access$000(DialogManager r0) {
        return r0.mActivity;
    }

    public DialogManager(Activity r2) {
        this.mUseDialogId2 = false;
        if (r2 == null) goto L7;
        this.mActivity = r2;
        return;
    L7:
        throw new IllegalArgumentException("activity must not be null");
    }

    public void showDialogInView(View r3, Bundle r4) {
        int r5 = r3.getId();
        if (r4.containsKey(VIEW_ID_KEY) == true) goto L15;
        if (r5 == (-1)) goto L13;
        r4.putInt(VIEW_ID_KEY, r5);
        if (this.mUseDialogId2 == false) goto L9;
        int r6 = R.id.dialog_manager_id_2;
    L10:
        this.mActivity.showDialog(r6, r4);
        return;
    L9:
        r6 = R.id.dialog_manager_id_1;
        goto L10
    L13:
        throw new IllegalArgumentException("View does not have a proper ViewId");
    L15:
        throw new IllegalArgumentException("Bundle already contains a view_id");
    }

    public Dialog onCreateDialog(final int r4, Bundle r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r4 != R.id.dialog_manager_id_1) goto L9;
        this.mUseDialogId2 = true;
    L12:
        if (r5.containsKey(VIEW_ID_KEY) == false) goto L25;
        int r1 = r5.getInt(VIEW_ID_KEY);
        KeyEvent.Callback r2 = this.mActivity.findViewById(r1);
        if (r2 != null) goto L16;
    L23:
        return null;
    L16:
        if ((r2 instanceof DialogShowingView) == false) goto L23;
        Dialog r6 = ((DialogShowingView) r2).createDialog(r5);
        if (r6 != null) goto L21;
        return r6;
    L21:
        r6.setOnDismissListener(new AnonymousClass1(this, r4));
        return r6;
    L25:
        throw new IllegalArgumentException("Bundle does not contain a ViewId");
    L9:
        if (r4 != R.id.dialog_manager_id_2) goto L26;
        this.mUseDialogId2 = false;
        goto L12
    L26:
        return null;
    }
}
