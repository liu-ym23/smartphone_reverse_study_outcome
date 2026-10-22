package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements CancellationSignal.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1740a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f(Object obj, int i) {
        this.f1740a = i;
        this.b = obj;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        int i = this.f1740a;
        Object obj = this.b;
        switch (i) {
            case 0:
                HandwritingGestureApi34.previewHandwritingGesture$lambda$9((TextFieldSelectionManager) obj);
                break;
            default:
                HandwritingGestureApi34.previewHandwritingGesture$lambda$1((TransformedTextFieldState) obj);
                break;
        }
    }
}
