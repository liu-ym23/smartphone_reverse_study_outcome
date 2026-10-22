package a4;

import android.text.TextUtils;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements q, y4.e {

    /* renamed from: c, reason: collision with root package name */
    public String f192c;

    @Override // a4.q
    public boolean b(CharSequence charSequence, int i, int i3, z zVar) {
        if (!TextUtils.equals(charSequence.subSequence(i, i3), this.f192c)) {
            return true;
        }
        zVar.f219c = (zVar.f219c & 3) | 4;
        return false;
    }

    @Override // y4.e
    public String n() {
        return this.f192c;
    }

    @Override // a4.q
    public Object getResult() {
        return this;
    }

    @Override // y4.e
    public void g(y4.d dVar) {
    }
}
