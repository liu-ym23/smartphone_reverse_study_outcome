package o0;

import android.view.View;
import java.util.ArrayList;

/* renamed from: o0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0804j implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f13716a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f13717b;

    public C0804j(View view, ArrayList arrayList) {
        this.f13716a = view;
        this.f13717b = arrayList;
    }

    @Override // o0.q
    public final void a() {
    }

    @Override // o0.q
    public final void b() {
    }

    @Override // o0.q
    public final void d(s sVar) {
    }

    @Override // o0.q
    public final void e(s sVar) {
        sVar.y(this);
        sVar.a(this);
    }

    @Override // o0.q
    public final void f(s sVar) {
        sVar.y(this);
        this.f13716a.setVisibility(8);
        ArrayList arrayList = this.f13717b;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((View) arrayList.get(i4)).setVisibility(0);
        }
    }
}
