package w1;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s extends p {

    /* renamed from: e, reason: collision with root package name */
    public final int f6166e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f6167f;

    /* renamed from: g, reason: collision with root package name */
    public final a f6168g;

    public s(o oVar, int i8) {
        super(oVar);
        this.f6166e = R.drawable.design_password_eye;
        this.f6168g = new a(this, 2);
        if (i8 != 0) {
            this.f6166e = i8;
        }
    }

    @Override // w1.p
    public final void b() {
        p();
    }

    @Override // w1.p
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // w1.p
    public final int d() {
        return this.f6166e;
    }

    @Override // w1.p
    public final View.OnClickListener f() {
        return this.f6168g;
    }

    @Override // w1.p
    public final boolean j() {
        return true;
    }

    @Override // w1.p
    public final boolean k() {
        EditText editText = this.f6167f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // w1.p
    public final void l(EditText editText) {
        this.f6167f = editText;
        p();
    }

    @Override // w1.p
    public final void q() {
        EditText editText = this.f6167f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f6167f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // w1.p
    public final void r() {
        EditText editText = this.f6167f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
