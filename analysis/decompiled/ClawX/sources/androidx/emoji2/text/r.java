package androidx.emoji2.text;

import android.text.TextUtils;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f625a;

    /* renamed from: b, reason: collision with root package name */
    public final String f626b;

    public /* synthetic */ r(String str, int i8) {
        this.f625a = i8;
        this.f626b = str;
    }

    @Override // androidx.emoji2.text.q
    public boolean b(CharSequence charSequence, int i8, int i9, z zVar) {
        if (!TextUtils.equals(charSequence.subSequence(i8, i9), this.f626b)) {
            return true;
        }
        zVar.f652c = (zVar.f652c & 3) | 4;
        return false;
    }

    public String toString() {
        switch (this.f625a) {
            case 1:
                return "<" + this.f626b + '>';
            case 2:
                return m0.f.f(new StringBuilder("Phase('"), this.f626b, "')");
            default:
                return super.toString();
        }
    }

    @Override // androidx.emoji2.text.q
    public Object getResult() {
        return this;
    }
}
