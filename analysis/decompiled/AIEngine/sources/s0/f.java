package s0;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Callable;
import s0.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements Callable<j.a> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11843a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f11844b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f11845c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11846d;

    public f(String str, Context context, e eVar, int i10) {
        this.f11843a = str;
        this.f11844b = context;
        this.f11845c = eVar;
        this.f11846d = i10;
    }

    @Override // java.util.concurrent.Callable
    public final j.a call() {
        return j.b(this.f11843a, this.f11844b, List.of(this.f11845c), this.f11846d);
    }
}
