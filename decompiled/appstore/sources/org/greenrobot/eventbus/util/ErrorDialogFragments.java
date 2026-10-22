package org.greenrobot.eventbus.util;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorDialogFragments {
    public static int ERROR_DIALOG_ICON;
    public static Class<?> EVENT_TYPE_ON_CLICK;

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        public Honeycomb() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            ErrorDialogFragments.handleOnClick(r10, r11, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle r10) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        public Support() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            ErrorDialogFragments.handleOnClick(r10, r11, getActivity(), getArguments());
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r10) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }
    }

    static {
    }

    public ErrorDialogFragments() {
    }

    public static Dialog createDialog(Context r10, Bundle r11, DialogInterface.OnClickListener r12) {
        AlertDialog.Builder r13 = new AlertDialog.Builder(r10);
        r13.setTitle(r11.getString(ErrorDialogManager.KEY_TITLE));
        r13.setMessage(r11.getString(ErrorDialogManager.KEY_MESSAGE));
        int r14 = ERROR_DIALOG_ICON;
        if (r14 == 0) goto L5;
        r13.setIcon(r14);
    L5:
        r13.setPositiveButton(R.string.ok, r12);
        return r13.create();
    }

    public static void handleOnClick(DialogInterface r10, int r11, Activity r12, Bundle r13) {
        Class<?> r14 = EVENT_TYPE_ON_CLICK;
        if (r14 == null) goto L10;
        Object r15 = r14.newInstance();     // Catch: Exception -> L6
        ErrorDialogManager.factory.config.getEventBus().post(r15);
    L6:
        e = move-exception;
        throw new RuntimeException("Event cannot be constructed", e);
    L10:
        if (r13.getBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, false) == false) goto L16;
        if (r12 == null) goto L17;
        r12.finish();
        return;
    L17:
        return;
    }
}
