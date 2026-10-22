package androidx.datastore.core;

import J0.c;
import J0.g;
import Y8.t;
import androidx.datastore.core.DataMigrationInitializer;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LJ0/g;", "api", "LY8/t;", "<anonymous>", "(LJ0/g;)V"}, k = 3, mv = {1, 5, 1})
@InterfaceC4112d(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataMigrationInitializer$Companion$getInitializer$1<T> extends SuspendLambda implements p<g<T>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f13258a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13259b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<c<T>> f13260c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DataMigrationInitializer$Companion$getInitializer$1(List<? extends c<T>> list, InterfaceC4014c<? super DataMigrationInitializer$Companion$getInitializer$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f13260c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        DataMigrationInitializer$Companion$getInitializer$1 dataMigrationInitializer$Companion$getInitializer$1 = new DataMigrationInitializer$Companion$getInitializer$1(this.f13260c, interfaceC4014c);
        dataMigrationInitializer$Companion$getInitializer$1.f13259b = obj;
        return dataMigrationInitializer$Companion$getInitializer$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(g<T> gVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DataMigrationInitializer$Companion$getInitializer$1) create(gVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f13258a;
        if (i10 == 0) {
            C4849c.b(obj);
            g gVar = (g) this.f13259b;
            DataMigrationInitializer.Companion companion = DataMigrationInitializer.INSTANCE;
            List<c<T>> list = this.f13260c;
            this.f13258a = 1;
            if (companion.c(list, gVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
