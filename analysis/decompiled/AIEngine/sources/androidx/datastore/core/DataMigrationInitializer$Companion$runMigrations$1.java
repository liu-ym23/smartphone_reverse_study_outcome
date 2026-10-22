package androidx.datastore.core;

import java.io.Serializable;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
/* loaded from: classes.dex */
final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Serializable f1582a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f1583b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1584c;

    /* renamed from: d, reason: collision with root package name */
    public int f1585d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1584c = obj;
        this.f1585d |= Integer.MIN_VALUE;
        return a.a(null, null, this);
    }
}
