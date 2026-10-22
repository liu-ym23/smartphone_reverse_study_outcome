package s0;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import s0.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements Callable<j.a> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11848a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f11849b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f11850c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11851d;

    public h(String str, Context context, ArrayList arrayList, int i10) {
        this.f11848a = str;
        this.f11849b = context;
        this.f11850c = arrayList;
        this.f11851d = i10;
    }

    @Override // java.util.concurrent.Callable
    public final j.a call() {
        try {
            return j.b(this.f11848a, this.f11849b, this.f11850c, this.f11851d);
        } catch (Throwable unused) {
            return new j.a(-3);
        }
    }
}
