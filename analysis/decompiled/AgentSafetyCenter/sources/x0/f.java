package x0;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends AutofillManager.AutofillCallback {

    /* renamed from: a, reason: collision with root package name */
    public static final f f15515a = new f();

    @Override // android.view.autofill.AutofillManager.AutofillCallback
    public final void onAutofillEvent(View view, int i, int i3) {
        super.onAutofillEvent(view, i, i3);
        Log.d("Autofill Status", i3 != 1 ? i3 != 2 ? i3 != 3 ? "Unknown status event." : "Autofill popup isn't shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account" : "Autofill popup was hidden." : "Autofill popup was shown.");
    }
}
