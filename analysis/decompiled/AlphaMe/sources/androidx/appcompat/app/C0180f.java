package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.T;
import androidx.appcompat.widget.V;
import stepos.support.v7.app.X;
import stepos.support.v7.app.Z;

/* renamed from: androidx.appcompat.app.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0180f implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2591a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2592b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2593c;

    public /* synthetic */ C0180f(int i4, Object obj, Object obj2) {
        this.f2591a = i4;
        this.f2593c = obj;
        this.f2592b = obj2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        int i5 = this.f2591a;
        Object obj = this.f2592b;
        Object obj2 = this.f2593c;
        switch (i5) {
            case 0:
                C0182h c0182h = (C0182h) obj2;
                C0185k c0185k = (C0185k) obj;
                c0182h.f2610n.onClick(c0185k.f2634b, i4);
                if (!c0182h.f2614r) {
                    c0185k.f2634b.dismiss();
                    break;
                }
                break;
            case 1:
                T t4 = (T) obj2;
                t4.f2965E.setSelection(i4);
                V v4 = t4.f2965E;
                if (v4.getOnItemClickListener() != null) {
                    v4.performItemClick(view, i4, t4.f2962B.getItemId(i4));
                }
                t4.dismiss();
                break;
            default:
                X x4 = (X) obj2;
                Z z4 = (Z) obj;
                x4.f14361a.f14465q.onClick(z4.f14403e, i4);
                if (!x4.f14361a.f14467s) {
                    z4.f14403e.dismiss();
                    break;
                }
                break;
        }
    }
}
