package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ErrorDialogFragmentFactory<T> {
    protected final ErrorDialogConfig config;

    @TargetApi(11)
    public static class Honeycomb extends ErrorDialogFragmentFactory<Fragment> {
        public Honeycomb(ErrorDialogConfig r10) {
            super(r10);
        }

        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        public /* bridge */ /* synthetic */ Fragment createErrorFragment(ThrowableFailureEvent r10, Bundle r11) {
            return createErrorFragment(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        public Fragment createErrorFragment(ThrowableFailureEvent r10, Bundle r11) {
            ErrorDialogFragments.Honeycomb r12 = new ErrorDialogFragments.Honeycomb();
            r12.setArguments(r11);
            return r12;
        }
    }

    public static class Support extends ErrorDialogFragmentFactory<androidx.fragment.app.Fragment> {
        public Support(ErrorDialogConfig r10) {
            super(r10);
        }

        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        public /* bridge */ /* synthetic */ androidx.fragment.app.Fragment createErrorFragment(ThrowableFailureEvent r10, Bundle r11) {
            return createErrorFragment(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        public androidx.fragment.app.Fragment createErrorFragment(ThrowableFailureEvent r10, Bundle r11) {
            ErrorDialogFragments.Support r12 = new ErrorDialogFragments.Support();
            r12.setArguments(r11);
            return r12;
        }
    }

    public ErrorDialogFragmentFactory(ErrorDialogConfig r10) {
        this.config = r10;
    }

    public abstract T createErrorFragment(ThrowableFailureEvent r10, Bundle r11);

    public String getMessageFor(ThrowableFailureEvent r10, Bundle r11) {
        int r12 = this.config.getMessageIdForThrowable(r10.throwable);
        return this.config.resources.getString(r12);
    }

    public String getTitleFor(ThrowableFailureEvent r10, Bundle r11) {
        ErrorDialogConfig r12 = this.config;
        return r12.resources.getString(r12.defaultTitleId);
    }

    public T prepareErrorFragment(ThrowableFailureEvent r10, boolean r11, Bundle r12) {
        if (r10.isSuppressErrorUi() == false) goto L6;
        return null;
    L6:
        if (r12 == null) goto L8;
        Bundle r13 = (Bundle) r12.clone();
    L10:
        if (r13.containsKey(ErrorDialogManager.KEY_TITLE) == true) goto L13;
        r13.putString(ErrorDialogManager.KEY_TITLE, getTitleFor(r10, r13));
    L13:
        if (r13.containsKey(ErrorDialogManager.KEY_MESSAGE) == true) goto L16;
        r13.putString(ErrorDialogManager.KEY_MESSAGE, getMessageFor(r10, r13));
    L16:
        if (r13.containsKey(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG) == true) goto L19;
        r13.putBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, r11);
    L19:
        if (r13.containsKey(ErrorDialogManager.KEY_EVENT_TYPE_ON_CLOSE) == true) goto L24;
        Class<?> r14 = this.config.defaultEventTypeOnDialogClosed;
        if (r14 == null) goto L24;
        r13.putSerializable(ErrorDialogManager.KEY_EVENT_TYPE_ON_CLOSE, r14);
    L24:
        if (r13.containsKey(ErrorDialogManager.KEY_ICON_ID) == true) goto L29;
        int r15 = this.config.defaultDialogIconId;
        if (r15 == 0) goto L29;
        r13.putInt(ErrorDialogManager.KEY_ICON_ID, r15);
    L29:
        return createErrorFragment(r10, r13);
    L8:
        r13 = new Bundle();
        goto L10
    }
}
