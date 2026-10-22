package p0;

import android.text.InputFilter;
import android.widget.TextView;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends z {

    /* renamed from: b, reason: collision with root package name */
    public final g f4656b;

    public h(TextView textView) {
        this.f4656b = new g(textView);
    }

    @Override // k4.z
    public final void G(boolean z) {
        if (androidx.emoji2.text.j.f608k != null) {
            this.f4656b.G(z);
        }
    }

    @Override // k4.z
    public final void H(boolean z) {
        g gVar = this.f4656b;
        if (androidx.emoji2.text.j.f608k != null) {
            gVar.H(z);
        } else {
            gVar.d = z;
        }
    }

    @Override // k4.z
    public final InputFilter[] v(InputFilter[] inputFilterArr) {
        return !(androidx.emoji2.text.j.f608k != null) ? inputFilterArr : this.f4656b.v(inputFilterArr);
    }
}
