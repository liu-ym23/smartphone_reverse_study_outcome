package wa;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import com.stepos.textinputlayout.EditTextWithClearIcon;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditTextWithClearIcon f13647a;

    public c(EditTextWithClearIcon editTextWithClearIcon) {
        this.f13647a = editTextWithClearIcon;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i10 = EditTextWithClearIcon.f8106c;
        EditTextWithClearIcon editTextWithClearIcon = this.f13647a;
        if (editTextWithClearIcon.length() <= 0) {
            editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (editTextWithClearIcon.f8108b) {
            editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds(editTextWithClearIcon.f8107a, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, editTextWithClearIcon.f8107a, (Drawable) null);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
