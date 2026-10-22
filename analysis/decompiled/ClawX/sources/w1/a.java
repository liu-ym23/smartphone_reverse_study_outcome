package w1;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6080a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f6081b;

    public /* synthetic */ a(p pVar, int i8) {
        this.f6080a = i8;
        this.f6081b = pVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i8 = this.f6080a;
        p pVar = this.f6081b;
        switch (i8) {
            case 0:
                e eVar = (e) pVar;
                EditText editText = eVar.f6092i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    eVar.p();
                    break;
                }
                break;
            case 1:
                ((l) pVar).t();
                break;
            default:
                s sVar = (s) pVar;
                EditText editText2 = sVar.f6167f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = sVar.f6167f;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        sVar.f6167f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        sVar.f6167f.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        sVar.f6167f.setSelection(selectionEnd);
                    }
                    sVar.p();
                    break;
                }
                break;
        }
    }
}
