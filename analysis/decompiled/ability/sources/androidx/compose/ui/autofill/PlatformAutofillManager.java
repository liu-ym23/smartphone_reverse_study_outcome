package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.view.View;
import android.view.autofill.AutofillValue;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;

@RequiresApi(26)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\ba\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH&¢\u0006\u0004\b\u0017\u0010\u0016J'\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/autofill/PlatformAutofillManager;", "", "Landroid/view/View;", "view", "", "semanticsId", "Landroid/graphics/Rect;", "bounds", "LC7/r;", "notifyViewEntered", "(Landroid/view/View;ILandroid/graphics/Rect;)V", "notifyViewExited", "(Landroid/view/View;I)V", "Landroid/view/autofill/AutofillValue;", "autofillValue", "notifyValueChanged", "(Landroid/view/View;ILandroid/view/autofill/AutofillValue;)V", "", "isVisible", "notifyViewVisibilityChanged", "(Landroid/view/View;IZ)V", "commit", "()V", "cancel", "requestAutofill", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PlatformAutofillManager {
    void cancel();

    void commit();

    void notifyValueChanged(View view, int semanticsId, AutofillValue autofillValue);

    void notifyViewEntered(View view, int semanticsId, Rect bounds);

    void notifyViewExited(View view, int semanticsId);

    void notifyViewVisibilityChanged(View view, int semanticsId, boolean isVisible);

    void requestAutofill(View view, int semanticsId, Rect bounds);
}
