package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AutoClosingRoomOpenHelper implements d, androidx.sqlite.db.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.sqlite.db.d f2597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.room.a f2599c;

    private static final class KeepAliveCursor implements Cursor {
        private final androidx.room.a mAutoCloser;
        private final Cursor mDelegate;

        KeepAliveCursor(Cursor r3, androidx.room.a r4) {
            this.mDelegate = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.aiagent.plugin");
            this.mAutoCloser = r4;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mDelegate.close();
            this.mAutoCloser.b();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.mDelegate.isClosed();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.mDelegate.getCount();
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.mDelegate.getPosition();
        }

        @Override // android.database.Cursor
        public boolean move(int r1) {
            return this.mDelegate.move(r1);
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int r1) {
            return this.mDelegate.moveToPosition(r1);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.mDelegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.mDelegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.mDelegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.mDelegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.mDelegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.mDelegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.mDelegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.mDelegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String r1) {
            return this.mDelegate.getColumnIndex(r1);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String r1) {
            return this.mDelegate.getColumnIndexOrThrow(r1);
        }

        @Override // android.database.Cursor
        public String getColumnName(int r1) {
            return this.mDelegate.getColumnName(r1);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.mDelegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.mDelegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int r1) {
            return this.mDelegate.getBlob(r1);
        }

        @Override // android.database.Cursor
        public String getString(int r1) {
            return this.mDelegate.getString(r1);
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int r1, CharArrayBuffer r2) {
            this.mDelegate.copyStringToBuffer(r1, r2);
        }

        @Override // android.database.Cursor
        public short getShort(int r1) {
            return this.mDelegate.getShort(r1);
        }

        @Override // android.database.Cursor
        public int getInt(int r1) {
            return this.mDelegate.getInt(r1);
        }

        @Override // android.database.Cursor
        public long getLong(int r1) {
            return this.mDelegate.getLong(r1);
        }

        @Override // android.database.Cursor
        public float getFloat(int r1) {
            return this.mDelegate.getFloat(r1);
        }

        @Override // android.database.Cursor
        public double getDouble(int r1) {
            return this.mDelegate.getDouble(r1);
        }

        @Override // android.database.Cursor
        public int getType(int r1) {
            return this.mDelegate.getType(r1);
        }

        @Override // android.database.Cursor
        public boolean isNull(int r1) {
            return this.mDelegate.isNull(r1);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.mDelegate.deactivate();
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.mDelegate.requery();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver r1) {
            this.mDelegate.registerContentObserver(r1);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver r1) {
            this.mDelegate.unregisterContentObserver(r1);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver r1) {
            this.mDelegate.registerDataSetObserver(r1);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver r1) {
            this.mDelegate.unregisterDataSetObserver(r1);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver r1, Uri r2) {
            this.mDelegate.setNotificationUri(r1, r2);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver r3, List<Uri> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            androidx.sqlite.db.b.e.a(this.mDelegate, r3, r5);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return androidx.sqlite.db.b.C0076b.a(this.mDelegate);
        }

        @Override // android.database.Cursor
        public List<Uri> getNotificationUris() {
            return androidx.sqlite.db.b.e.a(this.mDelegate);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.mDelegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle r1) {
            androidx.sqlite.db.b.d.a(this.mDelegate, r1);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.mDelegate.getExtras();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle r1) {
            return this.mDelegate.respond(r1);
        }
    }

    static final class a implements androidx.sqlite.db.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.room.a f2600a;

        private static /* synthetic */ Object b(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r3 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static /* synthetic */ Integer lambda$Bb28M3Ilrm5FbBgTL97rs00PsUA(String r0, int r1, ContentValues r2, String r3, Object[] r4, androidx.sqlite.db.c r5) {
            return a(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ Boolean lambda$RnkE7w1vxujw0NiNONMEpbVKV2M(androidx.sqlite.db.c r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$XzjHFyCatiBZAzn1_vcODH-p3bU, reason: not valid java name */
        public static /* synthetic */ Object m7lambda$XzjHFyCatiBZAzn1_vcODHp3bU(int r0, androidx.sqlite.db.c r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ Long lambda$Zu0Akbk3Vh2B3q3jocaMaUJLuHk(String r0, int r1, ContentValues r2, androidx.sqlite.db.c r3) {
            return a(r0, r1, r2, r3);
        }

        public static /* synthetic */ Object lambda$avjoDpFDDdjKDNW3io3urpHXprg(String r0, androidx.sqlite.db.c r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ Integer lambda$gf7jgzKFSulbfsOYZ96NhIu5R9k(String r0, String r1, Object[] r2, androidx.sqlite.db.c r3) {
            return a(r0, r1, r2, r3);
        }

        public static /* synthetic */ Object lambda$to38ZXcvD_GWJlIYSuHqgsBCo20(androidx.sqlite.db.c r0) {
            return b(r0);
        }

        a(androidx.room.a r1) {
            this.f2600a = r1;
        }

        void a() {
            this.f2600a.a($$Lambda$AutoClosingRoomOpenHelper$a$to38ZXcvD_GWJlIYSuHqgsBCo20.INSTANCE);
        }

        @Override // androidx.sqlite.db.c
        public androidx.sqlite.db.g a(String r2) {
            return new b(r2, this.f2600a);
        }

        @Override // androidx.sqlite.db.c
        public void b() {
            this.f2600a.a().b();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.f2600a.b();
            throw th;
        }

        @Override // androidx.sqlite.db.c
        public void c() {
            this.f2600a.a().c();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.f2600a.b();
            throw th;
        }

        @Override // androidx.sqlite.db.c
        public void d() {
            if (this.f2600a.c() == null) goto L11;
            this.f2600a.c().d();     // Catch: Throwable -> L7
            this.f2600a.b();
            return;
        L7:
            th = move-exception;
            this.f2600a.b();
            throw th;
        L11:
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.c
        public void e() {
            androidx.sqlite.db.c r1 = this.f2600a.c();
            if (r1 == null) goto L7;
            r1.e();
            return;
        L7:
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.c
        public boolean f() {
            if (this.f2600a.c() != null) goto L7;
            return false;
        L7:
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.f2600a.a($$Lambda$mExFPpV4YZSc9RCJZbPAW7WEJOk.INSTANCE), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }

        @Override // androidx.sqlite.db.c
        public void a(final int r2) {
            this.f2600a.a(new $$Lambda$AutoClosingRoomOpenHelper$a$XzjHFyCatiBZAzn1_vcODHp3bU(r2));
        }

        private static /* synthetic */ Object a(int r2, androidx.sqlite.db.c r3) {
            ((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).a(r2);
            return null;
        }

        @Override // androidx.sqlite.db.c
        public Cursor query(String r2) {
            Cursor r3 = this.f2600a.a().query(r2);     // Catch: Throwable -> L5
            return new KeepAliveCursor(r3, this.f2600a);
        L5:
            th = move-exception;
            this.f2600a.b();
            throw th;
        }

        @Override // androidx.sqlite.db.c
        public Cursor query(String r2, Object[] r3) {
            Cursor r4 = this.f2600a.a().query(r2, r3);     // Catch: Throwable -> L5
            return new KeepAliveCursor(r4, this.f2600a);
        L5:
            th = move-exception;
            this.f2600a.b();
            throw th;
        }

        @Override // androidx.sqlite.db.c
        public Cursor query(androidx.sqlite.db.f r3) {
            androidx.sqlite.db.f r4 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
            Cursor r5 = this.f2600a.a().query(r4);     // Catch: Throwable -> L6
            return new KeepAliveCursor(r5, this.f2600a);
        L6:
            th = move-exception;
            this.f2600a.b();
            throw th;
        }

        @Override // androidx.sqlite.db.c
        public Cursor query(androidx.sqlite.db.f r3, CancellationSignal r4) {
            androidx.sqlite.db.f r5 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
            Cursor r6 = this.f2600a.a().query(r5, r4);     // Catch: Throwable -> L6
            return new KeepAliveCursor(r6, this.f2600a);
        L6:
            th = move-exception;
            this.f2600a.b();
            throw th;
        }

        private static /* synthetic */ Long a(String r2, int r3, ContentValues r4, androidx.sqlite.db.c r5) {
            return Long.valueOf(((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r5, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).insert(r2, r3, r4));
        }

        @Override // androidx.sqlite.db.c
        public long insert(final String r2, final int r3, final ContentValues r4) {
            return ((Long) ZeusTransformUtils.preCheckCast(this.f2600a.a(new $$Lambda$AutoClosingRoomOpenHelper$a$Zu0Akbk3Vh2B3q3jocaMaUJLuHk(r2, r3, r4)), Long.class, "com.obric.aiagent.plugin")).longValue();
        }

        @Override // androidx.sqlite.db.c
        public int delete(final String r2, final String r3, final Object[] r4) {
            return ((Integer) ZeusTransformUtils.preCheckCast(this.f2600a.a(new $$Lambda$AutoClosingRoomOpenHelper$a$gf7jgzKFSulbfsOYZ96NhIu5R9k(r2, r3, r4)), Integer.class, "com.obric.aiagent.plugin")).intValue();
        }

        private static /* synthetic */ Integer a(String r2, String r3, Object[] r4, androidx.sqlite.db.c r5) {
            return Integer.valueOf(((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r5, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).delete(r2, r3, r4));
        }

        private static /* synthetic */ Integer a(String r6, int r7, ContentValues r8, String r9, Object[] r10, androidx.sqlite.db.c r11) {
            return Integer.valueOf(((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r11, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).update(r6, r7, r8, r9, r10));
        }

        @Override // androidx.sqlite.db.c
        public int update(final String r8, final int r9, final ContentValues r10, final String r11, final Object[] r12) {
            return ((Integer) ZeusTransformUtils.preCheckCast(this.f2600a.a(new $$Lambda$AutoClosingRoomOpenHelper$a$Bb28M3Ilrm5FbBgTL97rs00PsUA(r8, r9, r10, r11, r12)), Integer.class, "com.obric.aiagent.plugin")).intValue();
        }

        @Override // androidx.sqlite.db.c
        public void b(final String r2) {
            this.f2600a.a(new $$Lambda$AutoClosingRoomOpenHelper$a$avjoDpFDDdjKDNW3io3urpHXprg(r2));
        }

        private static /* synthetic */ Object a(String r2, androidx.sqlite.db.c r3) {
            ((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).b(r2);
            return null;
        }

        @Override // androidx.sqlite.db.c
        public boolean g() {
            androidx.sqlite.db.c r0 = this.f2600a.c();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.g();
        }

        @Override // androidx.sqlite.db.c
        public String h() {
            return (String) ZeusTransformUtils.preCheckCast(this.f2600a.a($$Lambda$j2HBdUmM5jQEhM4ad6TWPvNFEc.INSTANCE), String.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.sqlite.db.c
        public boolean i() {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.f2600a.a($$Lambda$AutoClosingRoomOpenHelper$a$RnkE7w1vxujw0NiNONMEpbVKV2M.INSTANCE), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }

        private static /* synthetic */ Boolean a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r3 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT < 16) goto L7;
            return Boolean.valueOf(r3.i());
        L7:
            return false;
        }

        @Override // androidx.sqlite.db.c
        public List<Pair<String, String>> j() {
            return (List) ZeusTransformUtils.preCheckCast(this.f2600a.a($$Lambda$UjLkJyYixpAkwYB6VgqvpCJQnc.INSTANCE), List.class, "com.obric.aiagent.plugin");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f2600a.d();
        }
    }

    private static class b implements androidx.sqlite.db.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<Object> f2602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.room.a f2603c;

        public static /* synthetic */ Object lambda$O7dCbai56QzjrHmq1wUClCw5xLA(b r0, androidx.a.a.c.a r1, androidx.sqlite.db.c r2) {
            return r0.a(r1, r2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        b(String r2, androidx.room.a r3) {
            this.f2602b = new ArrayList();
            this.f2601a = r2;
            this.f2603c = r3;
        }

        private <T> T a(androidx.a.a.c.a<androidx.sqlite.db.g, T> r3) {
            final androidx.a.a.c.a r4 = (androidx.a.a.c.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.a.a.c.a.class, "com.obric.aiagent.plugin");
            return (T) this.f2603c.a(new $$Lambda$AutoClosingRoomOpenHelper$b$O7dCbai56QzjrHmq1wUClCw5xLA(this, r4));
        }

        private /* synthetic */ Object a(androidx.a.a.c.a r3, androidx.sqlite.db.c r4) {
            androidx.a.a.c.a r5 = (androidx.a.a.c.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.a.a.c.a.class, "com.obric.aiagent.plugin");
            androidx.sqlite.db.g r6 = ((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r4, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).a(this.f2601a);
            a(r6);
            return r5.apply(r6);
        }

        private void a(androidx.sqlite.db.g r6) {
            androidx.sqlite.db.g r7 = (androidx.sqlite.db.g) ZeusTransformUtils.wrapperContextForParams(r6, androidx.sqlite.db.g.class, "com.obric.aiagent.plugin");
            int r0 = 0;
        L4:
            if (r0 >= this.f2602b.size()) goto L21;
            int r2 = r0 + 1;
            Object r1 = this.f2602b.get(r0);
            if (r1 != null) goto L9;
            r7.a(r2);
        L20:
            r0 = r2;
            goto L4
        L9:
            if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L12;
            r7.a(r2, ((Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.aiagent.plugin")).longValue());
            goto L20
        L12:
            if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L15;
            r7.a(r2, ((Double) ZeusTransformUtils.preCheckCast(r1, Double.class, "com.obric.aiagent.plugin")).doubleValue());
            goto L20
        L15:
            if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L18;
            r7.a(r2, (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"));
            goto L20
        L18:
            if ((r1 instanceof byte[]) == false) goto L20;
            r7.a(r2, (byte[]) ZeusTransformUtils.preCheckCast(r1, byte[].class, "com.obric.aiagent.plugin"));
            goto L20
        }

        private void a(int r4, Object r5) {
            int r6 = r4 - 1;
            if (r6 < this.f2602b.size()) goto L7;
            int r0 = this.f2602b.size();
        L5:
            if (r0 > r6) goto L7;
            this.f2602b.add(null);
            r0 = r0 + 1;
        L7:
            this.f2602b.set(r6, r5);
        }

        @Override // androidx.sqlite.db.g
        public int a() {
            return ((Integer) ZeusTransformUtils.preCheckCast(a($$Lambda$SFcR2qHTIOeF25xCCpAP72_CMjo.INSTANCE), Integer.class, "com.obric.aiagent.plugin")).intValue();
        }

        @Override // androidx.sqlite.db.g
        public long b() {
            return ((Long) ZeusTransformUtils.preCheckCast(a($$Lambda$wYc8pS6_PXh3mr45jL2VzvjRZkY.INSTANCE), Long.class, "com.obric.aiagent.plugin")).longValue();
        }

        @Override // androidx.sqlite.db.e
        public void a(int r2) {
            a(r2, null);
        }

        @Override // androidx.sqlite.db.e
        public void a(int r1, long r2) {
            a(r1, Long.valueOf(r2));
        }

        @Override // androidx.sqlite.db.e
        public void a(int r1, double r2) {
            a(r1, Double.valueOf(r2));
        }

        @Override // androidx.sqlite.db.e
        public void a(int r1, String r2) {
            a(r1, r2);
        }

        @Override // androidx.sqlite.db.e
        public void a(int r1, byte[] r2) {
            a(r1, r2);
        }
    }

    AutoClosingRoomOpenHelper(androidx.sqlite.db.d r3, androidx.room.a r4) {
        androidx.sqlite.db.d r5 = (androidx.sqlite.db.d) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.d.class, "com.obric.aiagent.plugin");
        this.f2597a = r5;
        this.f2599c = r4;
        r4.a(r5);
        this.f2598b = new a(r4);
    }

    @Override // androidx.sqlite.db.d
    public String a() {
        return this.f2597a.a();
    }

    @Override // androidx.sqlite.db.d
    public void a(boolean r1) {
        this.f2597a.a(r1);
    }

    @Override // androidx.sqlite.db.d
    public androidx.sqlite.db.c b() {
        this.f2598b.a();
        return this.f2598b;
    }

    @Override // androidx.sqlite.db.d
    public androidx.sqlite.db.c c() {
        this.f2598b.a();
        return this.f2598b;
    }

    @Override // androidx.sqlite.db.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2598b.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        androidx.room.b.e.a(e);
    }

    androidx.room.a d() {
        return this.f2599c;
    }

    @Override // androidx.room.d
    public androidx.sqlite.db.d e() {
        return this.f2597a;
    }
}
