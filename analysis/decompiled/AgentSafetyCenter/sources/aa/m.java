package aa;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements TextWatcher {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ n f333c;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        n nVar = this.f333c;
        nVar.f341m = 0;
        nVar.c();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i3, int i10) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i10) {
    }
}
