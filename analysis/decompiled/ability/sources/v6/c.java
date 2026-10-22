package v6;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.stepos.textinputlayout.EditTextWithClearIcon;
import com.stepos.textinputlayout.TextInputLayout;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public final class c implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6783a;
    public final /* synthetic */ View b;

    public /* synthetic */ c(int i, View view) {
        this.f6783a = i;
        this.b = view;
    }

    private final void a(int i, int i6, int i10, CharSequence charSequence) {
    }

    private final void b(int i, int i6, int i10, CharSequence charSequence) {
    }

    private final void c(int i, int i6, int i10, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.f6783a;
        View view = this.b;
        switch (i) {
            case 0:
                EditTextWithClearIcon editTextWithClearIcon = (EditTextWithClearIcon) view;
                int i6 = EditTextWithClearIcon.c;
                if (editTextWithClearIcon.length() <= 0) {
                    editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    break;
                } else if (!editTextWithClearIcon.b) {
                    editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, editTextWithClearIcon.f4077a, (Drawable) null);
                    break;
                } else {
                    editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds(editTextWithClearIcon.f4077a, (Drawable) null, (Drawable) null, (Drawable) null);
                    break;
                }
            default:
                Field field = TextInputLayout.u;
                ((TextInputLayout) view).e(true);
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        int i11 = this.f6783a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        switch (this.f6783a) {
            case 0:
                break;
            default:
                TextInputLayout textInputLayout = (TextInputLayout) this.b;
                EditText editText = textInputLayout.b;
                if (editText != null && editText.getText().length() == 0) {
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout.b.setBackgroundTintList(null);
                    break;
                }
                break;
        }
    }
}
