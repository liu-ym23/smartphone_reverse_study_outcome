package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorDialogManager {
    public static final String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
    public static final String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
    public static final String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";
    protected static final String TAG_ERROR_DIALOG = "de.greenrobot.eventbus.error_dialog";
    protected static final String TAG_ERROR_DIALOG_MANAGER = "de.greenrobot.eventbus.error_dialog_manager";
    public static ErrorDialogFragmentFactory<?> factory;

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {
        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;

        public HoneycombManagerFragment() {
        }

        public static void attachTo(Activity r10, Object r11, boolean r12, Bundle r13) {
            FragmentManager r14 = r10.getFragmentManager();
            HoneycombManagerFragment r15 = (HoneycombManagerFragment) r14.findFragmentByTag(ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
            if (r15 != null) goto L5;
            r15 = new HoneycombManagerFragment();
            r14.beginTransaction().add(r15, ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER).commit();
            r14.executePendingTransactions();
        L5:
            r15.finishAfterDialog = r12;
            r15.argumentsForErrorDialog = r13;
            r15.executionScope = r11;
        }

        public void onEventMainThread(ThrowableFailureEvent r10) {
            if (ErrorDialogManager.access$000(this.executionScope, r10) == true) goto L5;
            return;
        L5:
            ErrorDialogManager.checkLogException(r10);
            FragmentManager r11 = getFragmentManager();
            r11.executePendingTransactions();
            DialogFragment r12 = (DialogFragment) r11.findFragmentByTag(ErrorDialogManager.TAG_ERROR_DIALOG);
            if (r12 == null) goto L8;
            r12.dismiss();
        L8:
            DialogFragment r13 = (DialogFragment) ErrorDialogManager.factory.prepareErrorFragment(r10, this.finishAfterDialog, this.argumentsForErrorDialog);
            if (r13 == null) goto L12;
            r13.show(r11, ErrorDialogManager.TAG_ERROR_DIALOG);
            return;
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.eventBus.unregister(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            EventBus r10 = ErrorDialogManager.factory.config.getEventBus();
            this.eventBus = r10;
            r10.register(this);
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {
        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;
        private boolean skipRegisterOnNextResume;

        public SupportManagerFragment() {
        }

        public static void attachTo(Activity r10, Object r11, boolean r12, Bundle r13) {
            androidx.fragment.app.FragmentManager r14 = ((FragmentActivity) r10).getSupportFragmentManager();
            SupportManagerFragment r15 = (SupportManagerFragment) r14.i0(ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
            if (r15 != null) goto L5;
            r15 = new SupportManagerFragment();
            r14.o().e(r15, ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER).j();
            r14.e0();
        L5:
            r15.finishAfterDialog = r12;
            r15.argumentsForErrorDialog = r13;
            r15.executionScope = r11;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle r10) {
            super.onCreate(r10);
            EventBus r11 = ErrorDialogManager.factory.config.getEventBus();
            this.eventBus = r11;
            r11.register(this);
            this.skipRegisterOnNextResume = true;
        }

        public void onEventMainThread(ThrowableFailureEvent r10) {
            if (ErrorDialogManager.access$000(this.executionScope, r10) == true) goto L5;
            return;
        L5:
            ErrorDialogManager.checkLogException(r10);
            androidx.fragment.app.FragmentManager r11 = getFragmentManager();
            r11.e0();
            androidx.fragment.app.DialogFragment r12 = (androidx.fragment.app.DialogFragment) r11.i0(ErrorDialogManager.TAG_ERROR_DIALOG);
            if (r12 == null) goto L8;
            r12.dismiss();
        L8:
            androidx.fragment.app.DialogFragment r13 = (androidx.fragment.app.DialogFragment) ErrorDialogManager.factory.prepareErrorFragment(r10, this.finishAfterDialog, this.argumentsForErrorDialog);
            if (r13 == null) goto L12;
            r13.show(r11, ErrorDialogManager.TAG_ERROR_DIALOG);
            return;
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.eventBus.unregister(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.skipRegisterOnNextResume == false) goto L5;
            this.skipRegisterOnNextResume = false;
            return;
        L5:
            EventBus r10 = ErrorDialogManager.factory.config.getEventBus();
            this.eventBus = r10;
            r10.register(this);
        }
    }

    public ErrorDialogManager() {
    }

    public static /* synthetic */ boolean access$000(Object r10, ThrowableFailureEvent r11) {
        return isInExecutionScope(r10, r11);
    }

    public static void attachTo(Activity r10) {
        attachTo(r10, false, null);
    }

    public static void checkLogException(ThrowableFailureEvent r10) {
        ErrorDialogConfig r11 = factory.config;
        if (r11.logExceptions == false) goto L9;
        String r12 = r11.tagForLoggingExceptions;
        if (r12 != null) goto L7;
        r12 = EventBus.TAG;
    L7:
        Log.i(r12, "Error dialog manager received exception", r10.throwable);
        return;
    }

    private static boolean isInExecutionScope(Object r10, ThrowableFailureEvent r11) {
        if (r11 == null) goto L9;
        Object r12 = r11.getExecutionScope();
        if (r12 != null) goto L6;
        return true;
    L6:
        if (r12.equals(r10) == true) goto L12;
        return false;
    L12:
        return true;
    L9:
        return true;
    }

    private static boolean isSupportActivity(Activity r10) {
        Class<?> r11 = r10.getClass();
    L3:
        r11 = r11.getSuperclass();
        if (r11 == null) goto L24;
        String r12 = r11.getName();
        if (r12.equals("androidx.fragment.app.FragmentActivity") == true) goto L7;
        if (r12.startsWith("com.actionbarsherlock.app") == false) goto L20;
        if (r12.endsWith(".SherlockActivity") == true) goto L18;
        if (r12.endsWith(".SherlockListActivity") == true) goto L18;
        if (r12.endsWith(".SherlockPreferenceActivity") == false) goto L20;
    L18:
        throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + r12);
    L20:
        if (r12.equals("android.app.Activity") == false) goto L3;
        return false;
    L7:
        return true;
    L24:
        throw new RuntimeException("Illegal activity type: " + r10.getClass());
    }

    public static void attachTo(Activity r10, boolean r11) {
        attachTo(r10, r11, null);
    }

    public static void attachTo(Activity r10, boolean r11, Bundle r12) {
        attachTo(r10, r10.getClass(), r11, r12);
    }

    public static void attachTo(Activity r10, Object r11, boolean r12, Bundle r13) {
        if (factory == null) goto L10;
        if (isSupportActivity(r10) == false) goto L7;
        SupportManagerFragment.attachTo(r10, r11, r12, r13);
        return;
    L7:
        HoneycombManagerFragment.attachTo(r10, r11, r12, r13);
        return;
    L10:
        throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }
}
