package androidx.datastore.core;

import J0.c;
import J0.g;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import p9.p;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u0003*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer;", ExifInterface.GPS_DIRECTION_TRUE, "", Const.INTENT_KEY_APIKEY, "Companion", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DataMigrationInitializer<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ;\u0010\u000f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer$Companion;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "LJ0/c;", "migrations", "Lkotlin/Function2;", "LJ0/g;", "Le9/c;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Lp9/p;", "api", "c", "(Ljava/util/List;LJ0/g;Le9/c;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final <T> p<g<T>, InterfaceC4014c<? super t>, Object> b(List<? extends c<T>> migrations) {
            kotlin.jvm.internal.p.i(migrations, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(migrations, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Throwable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0089 -> B:25:0x006c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008c -> B:25:0x006c). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <T> java.lang.Object c(java.util.List<? extends J0.c<T>> r6, J0.g<T> r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r8 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.f13265e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13265e = r1
                goto L18
            L13:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r5, r8)
            L18:
                java.lang.Object r5 = r0.f13263c
                java.lang.Object r8 = f9.C4063a.g()
                int r1 = r0.f13265e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L46
                if (r1 == r3) goto L3e
                if (r1 != r2) goto L36
                java.lang.Object r6 = r0.f13262b
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r0.f13261a
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
                kotlin.C4849c.b(r5)     // Catch: java.lang.Throwable -> L34
                goto L6c
            L34:
                r5 = move-exception
                goto L85
            L36:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L3e:
                java.lang.Object r6 = r0.f13261a
                java.util.List r6 = (java.util.List) r6
                kotlin.C4849c.b(r5)
                goto L60
            L46:
                kotlin.C4849c.b(r5)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r1 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r4 = 0
                r1.<init>(r6, r5, r4)
                r0.f13261a = r5
                r0.f13265e = r3
                java.lang.Object r6 = r7.a(r1, r0)
                if (r6 != r8) goto L5f
                goto L84
            L5f:
                r6 = r5
            L60:
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r6 = r6.iterator()
                r7 = r5
            L6c:
                boolean r5 = r6.hasNext()
                if (r5 == 0) goto L97
                java.lang.Object r5 = r6.next()
                p9.l r5 = (p9.InterfaceC5074l) r5
                r0.f13261a = r7     // Catch: java.lang.Throwable -> L34
                r0.f13262b = r6     // Catch: java.lang.Throwable -> L34
                r0.f13265e = r2     // Catch: java.lang.Throwable -> L34
                java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L34
                if (r5 != r8) goto L6c
            L84:
                return r8
            L85:
                T r1 = r7.f34820a
                if (r1 != 0) goto L8c
                r7.f34820a = r5
                goto L6c
            L8c:
                kotlin.jvm.internal.p.f(r1)
                T r1 = r7.f34820a
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                Y8.d.a(r1, r5)
                goto L6c
            L97:
                T r5 = r7.f34820a
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 != 0) goto La0
                Y8.t r5 = Y8.t.f7040a
                return r5
            La0:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.c(java.util.List, J0.g, e9.c):java.lang.Object");
        }

        public Companion() {
        }
    }
}
