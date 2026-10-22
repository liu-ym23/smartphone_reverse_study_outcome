package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@InterfaceC4112d(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
/* loaded from: classes.dex */
public final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f13261a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13262b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f13263c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DataMigrationInitializer.Companion f13264d;

    /* renamed from: e, reason: collision with root package name */
    public int f13265e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$1(DataMigrationInitializer.Companion companion, InterfaceC4014c<? super DataMigrationInitializer$Companion$runMigrations$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f13264d = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13263c = obj;
        this.f13265e |= Integer.MIN_VALUE;
        return this.f13264d.c(null, null, this);
    }
}
