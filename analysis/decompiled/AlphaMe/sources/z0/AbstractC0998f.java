package z0;

import android.content.Context;
import androidx.appcompat.app.o;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: z0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0998f {

    /* renamed from: a, reason: collision with root package name */
    public final E0.a f16397a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f16398b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f16399c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f16400d;

    /* renamed from: e, reason: collision with root package name */
    public Object f16401e;

    public AbstractC0998f(Context context, E0.a taskExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        this.f16397a = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f16398b = applicationContext;
        this.f16399c = new Object();
        this.f16400d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(Object obj) {
        synchronized (this.f16399c) {
            Object obj2 = this.f16401e;
            if (obj2 == null || !Intrinsics.areEqual(obj2, obj)) {
                this.f16401e = obj;
                ((E0.c) this.f16397a).f403d.execute(new o(9, CollectionsKt.toList(this.f16400d), this));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public abstract void c();

    public abstract void d();
}
