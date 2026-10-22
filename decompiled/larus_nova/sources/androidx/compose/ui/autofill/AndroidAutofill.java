package androidx.compose.ui.autofill;

import android.view.View;
import android.view.autofill.AutofillId;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/autofill/AndroidAutofill;", "Landroidx/compose/ui/autofill/Autofill;", "view", "Landroid/view/View;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "<init>", "(Landroid/view/View;Landroidx/compose/ui/autofill/AutofillTree;)V", "getView", "()Landroid/view/View;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "autofillManager", "Landroid/view/autofill/AutofillManager;", "getAutofillManager", "()Landroid/view/autofill/AutofillManager;", "rootAutofillId", "Landroid/view/autofill/AutofillId;", "getRootAutofillId", "()Landroid/view/autofill/AutofillId;", "setRootAutofillId", "(Landroid/view/autofill/AutofillId;)V", "requestAutofillForNode", "", "autofillNode", "Landroidx/compose/ui/autofill/AutofillNode;", "cancelAutofillForNode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidAutofill implements Autofill {
    public static final int $stable = 8;
    private final android.view.autofill.AutofillManager autofillManager;
    private final AutofillTree autofillTree;
    private AutofillId rootAutofillId;
    private final View view;

    public final android.view.autofill.AutofillManager getAutofillManager() {
        return this.autofillManager;
    }

    public final AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final AutofillId getRootAutofillId() {
        return this.rootAutofillId;
    }

    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public void cancelAutofillForNode(AutofillNode r100) {
        this.autofillManager.notifyViewExited(this.view, r100.getId());
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public void requestAutofillForNode(AutofillNode r100) {
        Rect r101 = r100.getBoundingBox();
        if (r101 == null) goto L7;
        this.autofillManager.notifyViewEntered(this.view, r100.getId(), new android.graphics.Rect(Math.round(r101.getLeft()), Math.round(r101.getTop()), Math.round(r101.getRight()), Math.round(r101.getBottom())));
        return;
    L7:
        throw new IllegalStateException("requestAutofill called before onChildPositioned()".toString());
    }

    public final void setRootAutofillId(AutofillId r100) {
        this.rootAutofillId = r100;
    }

    public AndroidAutofill(View r100, AutofillTree r101) {
        this.view = r100;
        this.autofillTree = r101;
        android.view.autofill.AutofillManager r102 = (android.view.autofill.AutofillManager) r100.getContext().getSystemService(android.view.autofill.AutofillManager.class);
        if (r102 == null) goto L14;
        this.autofillManager = r102;
        r100.setImportantForAutofill(1);
        AutofillIdCompat r103 = ViewCompatShims.getAutofillId(r100);
        if (r103 == null) goto L7;
        AutofillId r104 = r103.toAutofillId();
    L8:
        if (r104 == null) goto L11;
        this.rootAutofillId = r104;
        return;
    L11:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    L7:
        r104 = null;
        goto L8
    L14:
        throw new IllegalStateException("Autofill service could not be located.".toString());
    }
}
