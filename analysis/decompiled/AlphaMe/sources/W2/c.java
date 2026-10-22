package W2;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.stepos.textinputlayout.EditTextWithClearIcon;
import com.stepos.textinputlayout.TextInputLayout;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class c implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2023a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2024b;

    public /* synthetic */ c(int i4, View view) {
        this.f2023a = i4;
        this.f2024b = view;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i4 = this.f2023a;
        View view = this.f2024b;
        switch (i4) {
            case 0:
                EditTextWithClearIcon editTextWithClearIcon = (EditTextWithClearIcon) view;
                int i5 = EditTextWithClearIcon.f12383c;
                if (editTextWithClearIcon.length() <= 0) {
                    editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    break;
                } else if (!editTextWithClearIcon.f12385b) {
                    editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, editTextWithClearIcon.f12384a, (Drawable) null);
                    break;
                } else {
                    editTextWithClearIcon.setCompoundDrawablesWithIntrinsicBounds(editTextWithClearIcon.f12384a, (Drawable) null, (Drawable) null, (Drawable) null);
                    break;
                }
            default:
                Field field = TextInputLayout.f12386u;
                ((TextInputLayout) view).e(true);
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        switch (this.f2023a) {
            case 0:
                break;
            default:
                TextInputLayout textInputLayout = (TextInputLayout) this.f2024b;
                EditText editText = textInputLayout.f12390b;
                if (editText != null && editText.getText().length() == 0) {
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout.f12390b.setBackgroundTintList(null);
                    break;
                }
                break;
        }
    }
}
