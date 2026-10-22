package K8;

import K8.a;
import N8.d;
import Yb.u;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import u8.e;

/* loaded from: classes4.dex */
public class c extends a.b<u, a> {

    /* renamed from: a, reason: collision with root package name */
    public final Map<u, Spanned> f4137a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final int f4138b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4139c;

    public static class a extends a.c {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f4140a;

        public a(int i10, View view) {
            TextView textView;
            super(view);
            if (i10 != 0) {
                textView = (TextView) a(i10);
            } else {
                if (!(view instanceof TextView)) {
                    throw new IllegalStateException("TextView is not root of layout (specify TextView ID explicitly): " + view);
                }
                textView = (TextView) view;
            }
            this.f4140a = textView;
            textView.setSpannableFactory(d.a());
        }
    }

    public c(int i10, int i11) {
        this.f4138b = i10;
        this.f4139c = i11;
    }

    public static c h(int i10) {
        return new c(i10, 0);
    }

    @Override // K8.a.b
    public void b() {
        this.f4137a.clear();
    }

    @Override // K8.a.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(e eVar, a aVar, u uVar) {
        Spanned spannedE = this.f4137a.get(uVar);
        if (spannedE == null) {
            spannedE = eVar.e(uVar);
            this.f4137a.put(uVar, spannedE);
        }
        eVar.g(aVar.f4140a, spannedE);
    }

    @Override // K8.a.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a(this.f4139c, layoutInflater.inflate(this.f4138b, viewGroup, false));
    }
}
