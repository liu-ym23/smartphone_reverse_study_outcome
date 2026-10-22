package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillValue;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J \u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/autofill/PlatformAutofillManagerImpl;", "Landroidx/compose/ui/autofill/PlatformAutofillManager;", "platformAndroidManager", "Landroid/view/autofill/AutofillManager;", "<init>", "(Landroid/view/autofill/AutofillManager;)V", "getPlatformAndroidManager", "()Landroid/view/autofill/AutofillManager;", "notifyViewEntered", "", "view", "Landroid/view/View;", "semanticsId", "", "bounds", "Landroid/graphics/Rect;", "notifyViewExited", "notifyValueChanged", "autofillValue", "Landroid/view/autofill/AutofillValue;", "notifyViewVisibilityChanged", "isVisible", "", "commit", "cancel", "requestAutofill", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformAutofillManagerImpl implements PlatformAutofillManager {
    public static final int $stable = 8;
    private final android.view.autofill.AutofillManager platformAndroidManager;

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void cancel() {
        this.platformAndroidManager.cancel();
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void commit() {
        this.platformAndroidManager.commit();
    }

    public final android.view.autofill.AutofillManager getPlatformAndroidManager() {
        return this.platformAndroidManager;
    }

    public PlatformAutofillManagerImpl(android.view.autofill.AutofillManager r100) {
        this.platformAndroidManager = r100;
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void notifyViewExited(View r100, int r101) {
        this.platformAndroidManager.notifyViewExited(r100, r101);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void notifyValueChanged(View r100, int r101, AutofillValue r102) {
        this.platformAndroidManager.notifyValueChanged(r100, r101, r102);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void notifyViewEntered(View r100, int r101, Rect r102) {
        this.platformAndroidManager.notifyViewEntered(r100, r101, r102);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void notifyViewVisibilityChanged(View r100, int r101, boolean r102) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        AutofillApi27Helper.INSTANCE.notifyViewVisibilityChanged(r100, this.platformAndroidManager, r101, r102);
        return;
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void requestAutofill(View r100, int r101, Rect r102) {
        this.platformAndroidManager.requestAutofill(r100, r101, r102);
    }
}
