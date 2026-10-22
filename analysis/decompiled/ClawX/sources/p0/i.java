package p0;

import android.widget.EditText;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends androidx.emoji2.text.g {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f4657a;

    public i(EditText editText) {
        this.f4657a = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.g
    public final void a() {
        j.a((EditText) this.f4657a.get(), 1);
    }
}
