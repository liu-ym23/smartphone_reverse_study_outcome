package w1;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public int f6178a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f6179b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f6180c;

    public u(TextInputLayout textInputLayout, EditText editText) {
        this.f6180c = textInputLayout;
        this.f6179b = editText;
        this.f6178a = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) throws Resources.NotFoundException {
        TextInputLayout textInputLayout = this.f6180c;
        textInputLayout.w(!textInputLayout.C0, false);
        if (textInputLayout.f1373m) {
            textInputLayout.p(editable);
        }
        if (textInputLayout.f1389u) {
            textInputLayout.x(editable);
        }
        EditText editText = this.f6179b;
        int lineCount = editText.getLineCount();
        int i8 = this.f6178a;
        if (lineCount != i8) {
            if (lineCount < i8) {
                int minimumHeight = editText.getMinimumHeight();
                int i9 = textInputLayout.f1392v0;
                if (minimumHeight != i9) {
                    editText.setMinimumHeight(i9);
                }
            }
            this.f6178a = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }
}
