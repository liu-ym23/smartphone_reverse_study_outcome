package i1;

import android.content.res.TypedArray;
import android.util.SparseArray;
import android.view.View;
import w1.o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int f3134a;

    /* renamed from: b, reason: collision with root package name */
    public int f3135b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3136c;
    public final Object d;

    public d(View view) {
        this.d = new int[2];
        this.f3136c = view;
    }

    public d(o oVar, a4.d dVar) {
        this.f3136c = new SparseArray();
        this.d = oVar;
        TypedArray typedArray = (TypedArray) dVar.f97c;
        this.f3134a = typedArray.getResourceId(28, 0);
        this.f3135b = typedArray.getResourceId(53, 0);
    }
}
