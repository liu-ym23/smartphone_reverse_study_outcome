package y2;

import android.content.Context;
import com.google.android.gms.common.internal.C1667h;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzai;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import r3.C5209c;

/* renamed from: y2.A, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5918A {

    /* renamed from: i, reason: collision with root package name */
    public static final zzai f43802i = zzai.d("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: a, reason: collision with root package name */
    public final String f43803a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43804b;

    /* renamed from: c, reason: collision with root package name */
    public final t f43805c;

    /* renamed from: d, reason: collision with root package name */
    public final r3.l f43806d;

    /* renamed from: e, reason: collision with root package name */
    public final D2.i f43807e;

    /* renamed from: f, reason: collision with root package name */
    public final D2.i f43808f;

    /* renamed from: g, reason: collision with root package name */
    public final String f43809g;

    /* renamed from: h, reason: collision with root package name */
    public final int f43810h;

    public C5918A(Context context, final r3.l lVar, t tVar, String str) {
        new HashMap();
        new HashMap();
        this.f43803a = context.getPackageName();
        this.f43804b = C5209c.a(context);
        this.f43806d = lVar;
        this.f43805c = tVar;
        K.a();
        this.f43809g = str;
        this.f43807e = com.google.mlkit.common.sdkinternal.a.a().b(new Callable() { // from class: y2.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f43840a.a();
            }
        });
        com.google.mlkit.common.sdkinternal.a aVarA = com.google.mlkit.common.sdkinternal.a.a();
        Objects.requireNonNull(lVar);
        this.f43808f = aVarA.b(new Callable() { // from class: y2.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lVar.a();
            }
        });
        zzai zzaiVar = f43802i;
        this.f43810h = zzaiVar.containsKey(str) ? DynamiteModule.b(context, (String) zzaiVar.get(str)) : -1;
    }

    public final /* synthetic */ String a() throws Exception {
        return C1667h.a().b(this.f43809g);
    }
}
