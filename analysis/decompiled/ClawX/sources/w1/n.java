package w1;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f6117a;

    public n(o oVar) {
        this.f6117a = oVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        o oVar = this.f6117a;
        m mVar = oVar.f6138w;
        if (oVar.f6135t == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = oVar.f6135t;
        if (editText != null) {
            editText.removeTextChangedListener(mVar);
            if (oVar.f6135t.getOnFocusChangeListener() == oVar.b().e()) {
                oVar.f6135t.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        oVar.f6135t = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(mVar);
        }
        oVar.b().l(oVar.f6135t);
        oVar.j(oVar.b());
    }
}
