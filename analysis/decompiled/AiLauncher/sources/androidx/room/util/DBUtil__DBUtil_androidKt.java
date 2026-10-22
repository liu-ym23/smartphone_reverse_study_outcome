package androidx.room.util;

import androidx.room.RoomDatabase;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.y;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import i1.InterfaceC4160b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import l9.b;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001aB\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006H\u0087@¢\u0006\u0004\b\t\u0010\n\u001aA\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a<\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006H\u0087@¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "db", "", "isReadOnly", "inTransaction", "Lkotlin/Function1;", "Li1/b;", "block", Const.INTENT_KEY_UMID, "(Landroidx/room/RoomDatabase;ZZLp9/l;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "(Landroidx/room/RoomDatabase;ZZLp9/l;)Ljava/lang/Object;", "Le9/c;", "", "c", "(Landroidx/room/RoomDatabase;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lkotlin/coroutines/d;", Const.INTENT_KEY_APIKEY, "(Landroidx/room/RoomDatabase;ZLe9/c;)Ljava/lang/Object;", "Ljava/io/File;", "databaseFile", "", "e", "(Ljava/io/File;)I", "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/util/DBUtil")
/* loaded from: classes.dex */
public final /* synthetic */ class DBUtil__DBUtil_androidKt {
    public static final Object a(RoomDatabase roomDatabase, boolean z10, InterfaceC4014c<? super d> interfaceC4014c) {
        y yVar = (y) interfaceC4014c.getContext().get(y.INSTANCE);
        d transactionDispatcher = yVar != null ? yVar.getTransactionDispatcher() : null;
        if (roomDatabase.F()) {
            return transactionDispatcher != null ? roomDatabase.v().plus(transactionDispatcher) : z10 ? roomDatabase.C() : roomDatabase.v();
        }
        d dVarV = roomDatabase.v();
        if (transactionDispatcher == null) {
            transactionDispatcher = EmptyCoroutineContext.f34779a;
        }
        return dVarV.plus(transactionDispatcher);
    }

    public static final <R> R b(RoomDatabase db2, boolean z10, boolean z11, InterfaceC5074l<? super InterfaceC4160b, ? extends R> block) {
        p.i(db2, "db");
        p.i(block, "block");
        db2.f();
        db2.g();
        d dVar = db2.B().get();
        if (dVar == null) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return (R) RunBlockingUninterruptible_androidKt.a(new DBUtil__DBUtil_androidKt$performBlocking$1(dVar, db2, z11, z10, block, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object c(androidx.room.RoomDatabase r11, p9.InterfaceC5074l<? super e9.InterfaceC4014c<? super R>, ? extends java.lang.Object> r12, e9.InterfaceC4014c<? super R> r13) throws java.lang.Throwable {
        /*
            boolean r1 = r13 instanceof androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1
            if (r1 == 0) goto L14
            r1 = r13
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1) r1
            int r2 = r1.f14910d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r2 & r4
            if (r6 == 0) goto L14
            int r2 = r2 - r4
            r1.f14910d = r2
        L12:
            r6 = r1
            goto L1a
        L14:
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1
            r1.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r0 = r6.f14909c
            java.lang.Object r7 = f9.C4063a.g()
            int r1 = r6.f14910d
            r2 = 4
            r4 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L51
            if (r1 == r9) goto L4d
            if (r1 == r8) goto L49
            if (r1 == r4) goto L3d
            if (r1 != r2) goto L35
            kotlin.C4849c.b(r0)
            return r0
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            java.lang.Object r1 = r6.f14908b
            p9.l r1 = (p9.InterfaceC5074l) r1
            java.lang.Object r3 = r6.f14907a
            androidx.room.RoomDatabase r3 = (androidx.room.RoomDatabase) r3
            kotlin.C4849c.b(r0)
            goto L9f
        L49:
            kotlin.C4849c.b(r0)
            return r0
        L4d:
            kotlin.C4849c.b(r0)
            return r0
        L51:
            kotlin.C4849c.b(r0)
            boolean r0 = r11.F()
            if (r0 == 0) goto L69
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2
            r0.<init>(r11, r12, r10)
            r6.f14910d = r9
            java.lang.Object r0 = androidx.room.s.e(r11, r0, r6)
            if (r0 != r7) goto L68
            goto Lb2
        L68:
            return r0
        L69:
            boolean r0 = r11.F()
            if (r0 == 0) goto L90
            boolean r0 = r11.M()
            if (r0 == 0) goto L90
            boolean r0 = r11.G()
            if (r0 == 0) goto L90
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1
            r2 = 0
            r4 = 0
            r1 = 1
            r3 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f14910d = r8
            r1 = 0
            java.lang.Object r0 = r11.U(r1, r0, r6)
            if (r0 != r7) goto L8f
            goto Lb2
        L8f:
            return r0
        L90:
            r6.f14907a = r11
            r6.f14908b = r12
            r6.f14910d = r4
            java.lang.Object r0 = f1.C4031a.b(r11, r9, r6)
            if (r0 != r7) goto L9d
            goto Lb2
        L9d:
            r3 = r11
            r1 = r12
        L9f:
            kotlin.coroutines.d r0 = (kotlin.coroutines.d) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r4 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r4.<init>(r10, r3, r1)
            r6.f14907a = r10
            r6.f14908b = r10
            r6.f14910d = r2
            java.lang.Object r0 = Ua.C1056g.j(r0, r4, r6)
            if (r0 != r7) goto Lb3
        Lb2:
            return r7
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.c(androidx.room.RoomDatabase, p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object d(androidx.room.RoomDatabase r14, boolean r15, boolean r16, p9.InterfaceC5074l<? super i1.InterfaceC4160b, ? extends R> r17, e9.InterfaceC4014c<? super R> r18) throws java.lang.Throwable {
        /*
            r0 = r18
            boolean r1 = r0 instanceof androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1) r1
            int r2 = r1.f14919f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f14919f = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r6.f14918e
            java.lang.Object r7 = f9.C4063a.g()
            int r1 = r6.f14919f
            r2 = 3
            r3 = 2
            r8 = 1
            if (r1 == 0) goto L53
            if (r1 == r8) goto L4f
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L33
            kotlin.C4849c.b(r0)
            return r0
        L33:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3b:
            boolean r14 = r6.f14917d
            boolean r15 = r6.f14916c
            java.lang.Object r1 = r6.f14915b
            p9.l r1 = (p9.InterfaceC5074l) r1
            java.lang.Object r3 = r6.f14914a
            androidx.room.RoomDatabase r3 = (androidx.room.RoomDatabase) r3
            kotlin.C4849c.b(r0)
            r12 = r14
            r13 = r1
            r10 = r3
        L4d:
            r11 = r15
            goto L99
        L4f:
            kotlin.C4849c.b(r0)
            return r0
        L53:
            kotlin.C4849c.b(r0)
            boolean r0 = r14.F()
            if (r0 == 0) goto L7f
            boolean r0 = r14.M()
            if (r0 == 0) goto L7f
            boolean r0 = r14.G()
            if (r0 == 0) goto L7f
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1
            r4 = 0
            r3 = r14
            r2 = r15
            r1 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r2 = r0
            r6.f14919f = r8
            java.lang.Object r14 = r14.U(r15, r2, r6)
            if (r14 != r7) goto L7e
            goto Lae
        L7e:
            return r14
        L7f:
            r4 = r16
            r6.f14914a = r14
            r5 = r17
            r6.f14915b = r5
            r6.f14916c = r15
            r6.f14917d = r4
            r6.f14919f = r3
            java.lang.Object r3 = f1.C4031a.b(r14, r4, r6)
            if (r3 != r7) goto L94
            goto Lae
        L94:
            r10 = r14
            r0 = r3
            r12 = r4
            r13 = r5
            goto L4d
        L99:
            kotlin.coroutines.d r0 = (kotlin.coroutines.d) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r8 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r9 = 0
            r8.<init>(r9, r10, r11, r12, r13)
            r14 = 0
            r6.f14914a = r14
            r6.f14915b = r14
            r6.f14919f = r2
            java.lang.Object r14 = Ua.C1056g.j(r0, r8, r6)
            if (r14 != r7) goto Laf
        Lae:
            return r7
        Laf:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.d(androidx.room.RoomDatabase, boolean, boolean, p9.l, e9.c):java.lang.Object");
    }

    public static final int e(File databaseFile) throws IOException {
        p.i(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i10 = byteBufferAllocate.getInt();
            b.a(channel, null);
            return i10;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(channel, th);
                throw th2;
            }
        }
    }
}
