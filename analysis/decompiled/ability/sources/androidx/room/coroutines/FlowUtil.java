package androidx.room.coroutines;

import C7.r;
import S7.k;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.d;
import p9.c;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "", "", "tableNames", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteConnection;", "block", "Lp9/c;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;LS7/k;)Lp9/c;", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> c createFlow(final RoomDatabase db, final boolean z10, String[] tableNames, final k block) {
        kotlin.jvm.internal.k.f(db, "db");
        kotlin.jvm.internal.k.f(tableNames, "tableNames");
        kotlin.jvm.internal.k.f(block, "block");
        final c cVarB = d.b(db.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(tableNames, tableNames.length), true), -1);
        return new c() { // from class: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "LC7/r;", "emit", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements p9.d {
                final /* synthetic */ k $block$inlined;
                final /* synthetic */ RoomDatabase $db$inlined;
                final /* synthetic */ boolean $inTransaction$inlined;
                final /* synthetic */ p9.d $this_unsafeFlow;

                @J7.c(c = "androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2", f = "FlowBuilder.kt", l = {220, 219}, m = "emit")
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(H7.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(p9.d dVar, RoomDatabase roomDatabase, boolean z10, k kVar) {
                    this.$this_unsafeFlow = dVar;
                    this.$db$inlined = roomDatabase;
                    this.$inTransaction$inlined = z10;
                    this.$block$inlined = kVar;
                }

                /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                
                    if (r6.emit(r8, r0) == r1) goto L22;
                 */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // p9.d
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r7, H7.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = (androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = new androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3a
                        if (r2 == r4) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.b.b(r8)
                        goto L61
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        java.lang.Object r6 = r0.L$0
                        p9.d r6 = (p9.d) r6
                        kotlin.b.b(r8)
                        goto L55
                    L3a:
                        kotlin.b.b(r8)
                        p9.d r8 = r6.$this_unsafeFlow
                        java.util.Set r7 = (java.util.Set) r7
                        androidx.room.RoomDatabase r7 = r6.$db$inlined
                        boolean r2 = r6.$inTransaction$inlined
                        S7.k r6 = r6.$block$inlined
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r6 = androidx.room.util.DBUtil.performSuspending(r7, r4, r2, r6, r0)
                        if (r6 != r1) goto L52
                        goto L60
                    L52:
                        r5 = r8
                        r8 = r6
                        r6 = r5
                    L55:
                        r7 = 0
                        r0.L$0 = r7
                        r0.label = r3
                        java.lang.Object r6 = r6.emit(r8, r0)
                        if (r6 != r1) goto L61
                    L60:
                        return r1
                    L61:
                        C7.r r6 = C7.r.f317a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, H7.c):java.lang.Object");
                }
            }

            @Override // p9.c
            public Object collect(p9.d dVar, H7.c cVar) {
                Object objCollect = cVarB.collect(new AnonymousClass2(dVar, db, z10, block), cVar);
                return objCollect == CoroutineSingletons.f4909a ? objCollect : r.f317a;
            }
        };
    }
}
