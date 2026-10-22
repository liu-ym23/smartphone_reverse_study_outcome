package U;

import S.C0098d;
import S.M;
import V.k;
import Z2.F;
import android.content.Context;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
public final class c implements ReadOnlyProperty {

    /* renamed from: a, reason: collision with root package name */
    public final String f1879a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f1880b;

    /* renamed from: c, reason: collision with root package name */
    public final F f1881c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1882d;

    /* renamed from: e, reason: collision with root package name */
    public volatile V.d f1883e;

    public c(Function1 produceMigrations, F scope) {
        Intrinsics.checkNotNullParameter("policy_sdk_data", "name");
        Intrinsics.checkNotNullParameter(produceMigrations, "produceMigrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f1879a = "policy_sdk_data";
        this.f1880b = produceMigrations;
        this.f1881c = scope;
        this.f1882d = new Object();
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object obj, KProperty property) {
        V.d dVar;
        Context thisRef = (Context) obj;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        V.d dVar2 = this.f1883e;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this.f1882d) {
            try {
                if (this.f1883e == null) {
                    Context applicationContext = thisRef.getApplicationContext();
                    Function1 function1 = this.f1880b;
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    List migrations = (List) function1.invoke(applicationContext);
                    F scope = this.f1881c;
                    b produceFile = new b(0, applicationContext, this);
                    Intrinsics.checkNotNullParameter(migrations, "migrations");
                    Intrinsics.checkNotNullParameter(scope, "scope");
                    Intrinsics.checkNotNullParameter(produceFile, "produceFile");
                    k serializer = k.f1927a;
                    V.e produceFile2 = new V.e(produceFile, 0);
                    Intrinsics.checkNotNullParameter(serializer, "serializer");
                    Intrinsics.checkNotNullParameter(migrations, "migrations");
                    Intrinsics.checkNotNullParameter(scope, "scope");
                    Intrinsics.checkNotNullParameter(produceFile2, "produceFile");
                    com.google.android.gms.common.internal.f fVar = new com.google.android.gms.common.internal.f();
                    Intrinsics.checkNotNullParameter(migrations, "migrations");
                    this.f1883e = new V.d(new M(produceFile2, CollectionsKt.listOf(new C0098d(migrations, null)), fVar, scope));
                }
                dVar = this.f1883e;
                Intrinsics.checkNotNull(dVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }
}
