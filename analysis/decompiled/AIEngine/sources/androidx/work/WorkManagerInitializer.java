package androidx.work;

import android.content.Context;
import androidx.work.a;
import h2.j;
import h2.r;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WorkManagerInitializer implements b2.b<r> {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2798a = j.f("WrkMgrInitializer");

    @Override // b2.b
    public final List<Class<? extends b2.b<?>>> a() {
        return Collections.EMPTY_LIST;
    }

    @Override // b2.b
    public final r b(Context context) {
        j.d().a(f2798a, "Initializing WorkManager with default configuration.");
        a aVar = new a(new a.C0021a());
        g.f(context, "context");
        androidx.work.impl.b.b(context, aVar);
        androidx.work.impl.b bVarA = androidx.work.impl.b.a(context);
        g.e(bVarA, "getInstance(context)");
        return bVarA;
    }
}
