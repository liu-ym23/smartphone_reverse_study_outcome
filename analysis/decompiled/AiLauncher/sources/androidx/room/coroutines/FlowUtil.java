package androidx.room.coroutines;

import Xa.b;
import Xa.c;
import Xa.d;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import i1.InterfaceC4160b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "", "", "tableNames", "Lkotlin/Function1;", "Li1/b;", "block", "LXa/b;", Const.INTENT_KEY_APIKEY, "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Lp9/l;)LXa/b;", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowUtil {
    public static final <R> b<R> a(final RoomDatabase db2, final boolean z10, String[] tableNames, final InterfaceC5074l<? super InterfaceC4160b, ? extends R> block) {
        p.i(db2, "db");
        p.i(tableNames, "tableNames");
        p.i(block, "block");
        final b bVarO = d.o(db2.t().j((String[]) Arrays.copyOf(tableNames, tableNames.length), true));
        return new b<R>() { // from class: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ c f14688a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RoomDatabase f14689b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ boolean f14690c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ InterfaceC5074l f14691d;

                @InterfaceC4112d(c = "androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2", f = "FlowBuilder.kt", l = {220, 219}, m = "emit")
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f14692a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f14693b;

                    /* renamed from: c, reason: collision with root package name */
                    public Object f14694c;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f14692a = obj;
                        this.f14693b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(c cVar, RoomDatabase roomDatabase, boolean z10, InterfaceC5074l interfaceC5074l) {
                    this.f14688a = cVar;
                    this.f14689b = roomDatabase;
                    this.f14690c = z10;
                    this.f14691d = interfaceC5074l;
                }

                /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
                
                    if (r6.emit(r8, r0) == r1) goto L22;
                 */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r7, e9.InterfaceC4014c r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = (androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f14693b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f14693b = r1
                        goto L18
                    L13:
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = new androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f14692a
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.f14693b
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.C4849c.b(r8)
                        goto L63
                    L2c:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L34:
                        java.lang.Object r6 = r0.f14694c
                        Xa.c r6 = (Xa.c) r6
                        kotlin.C4849c.b(r8)
                        goto L57
                    L3c:
                        kotlin.C4849c.b(r8)
                        Xa.c r8 = r6.f14688a
                        java.util.Set r7 = (java.util.Set) r7
                        androidx.room.RoomDatabase r7 = r6.f14689b
                        boolean r2 = r6.f14690c
                        p9.l r6 = r6.f14691d
                        r0.f14694c = r8
                        r0.f14693b = r4
                        java.lang.Object r6 = f1.C4031a.e(r7, r4, r2, r6, r0)
                        if (r6 != r1) goto L54
                        goto L62
                    L54:
                        r5 = r8
                        r8 = r6
                        r6 = r5
                    L57:
                        r7 = 0
                        r0.f14694c = r7
                        r0.f14693b = r3
                        java.lang.Object r6 = r6.emit(r8, r0)
                        if (r6 != r1) goto L63
                    L62:
                        return r1
                    L63:
                        Y8.t r6 = Y8.t.f7040a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c cVar, InterfaceC4014c interfaceC4014c) {
                Object objCollect = bVarO.collect(new AnonymousClass2(cVar, db2, z10, block), interfaceC4014c);
                return objCollect == C4063a.g() ? objCollect : t.f7040a;
            }
        };
    }
}
