package u8;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import u8.e;

/* loaded from: classes4.dex */
public class h extends e {

    /* renamed from: a, reason: collision with root package name */
    public final TextView.BufferType f42484a;

    /* renamed from: b, reason: collision with root package name */
    public final Zb.d f42485b;

    /* renamed from: c, reason: collision with root package name */
    public final n f42486c;

    /* renamed from: d, reason: collision with root package name */
    public final g f42487d;

    /* renamed from: e, reason: collision with root package name */
    public final List<i> f42488e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f42489f;

    public h(TextView.BufferType bufferType, e.b bVar, Zb.d dVar, n nVar, g gVar, List<i> list, boolean z10) {
        this.f42484a = bufferType;
        this.f42485b = dVar;
        this.f42486c = nVar;
        this.f42487d = gVar;
        this.f42488e = list;
        this.f42489f = z10;
    }

    @Override // u8.e
    public g b() {
        return this.f42487d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, u8.i] */
    @Override // u8.e
    public <P extends i> P c(Class<P> cls) {
        P p10 = null;
        for (i iVar : this.f42488e) {
            if (cls.isAssignableFrom(iVar.getClass())) {
                p10 = iVar;
            }
        }
        return p10;
    }

    @Override // u8.e
    public Yb.u d(String str) {
        Iterator<i> it = this.f42488e.iterator();
        while (it.hasNext()) {
            str = it.next().g(str);
        }
        return this.f42485b.c(str);
    }

    @Override // u8.e
    public Spanned e(Yb.u uVar) {
        Iterator<i> it = this.f42488e.iterator();
        while (it.hasNext()) {
            it.next().d(uVar);
        }
        m mVarA = this.f42486c.a();
        uVar.a(mVarA);
        Iterator<i> it2 = this.f42488e.iterator();
        while (it2.hasNext()) {
            it2.next().b(uVar, mVarA);
        }
        return mVarA.builder().m();
    }

    @Override // u8.e
    public void f(TextView textView, String str) {
        g(textView, h(str));
    }

    @Override // u8.e
    public void g(TextView textView, Spanned spanned) {
        Iterator<i> it = this.f42488e.iterator();
        while (it.hasNext()) {
            it.next().j(textView, spanned);
        }
        textView.setText(spanned, this.f42484a);
        Iterator<i> it2 = this.f42488e.iterator();
        while (it2.hasNext()) {
            it2.next().e(textView);
        }
    }

    @Override // u8.e
    public Spanned h(String str) {
        Spanned spannedE = e(d(str));
        return (TextUtils.isEmpty(spannedE) && this.f42489f && !TextUtils.isEmpty(str)) ? new SpannableStringBuilder(str) : spannedE;
    }
}
