package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f4556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoomDatabase.d f4557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f4558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RoomDatabase.JournalMode f4560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f4561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f4562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Intent f4563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f4564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f4566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f4567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final File f4568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Callable f4569p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f4570q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f4571r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f4572s;

    public h(Context r12, String r13, SupportSQLiteOpenHelper.Factory r14, RoomDatabase.d r15, List r16, boolean r17, RoomDatabase.JournalMode r18, Executor r19, Executor r20, Intent r21, boolean r22, boolean r23, Set r24, String r25, File r26, Callable r27, RoomDatabase.e r28, List r29, List r30) {
        kotlin.jvm.internal.q.g(r12, "context");
        kotlin.jvm.internal.q.g(r14, "sqliteOpenHelperFactory");
        kotlin.jvm.internal.q.g(r15, "migrationContainer");
        kotlin.jvm.internal.q.g(r18, "journalMode");
        kotlin.jvm.internal.q.g(r19, "queryExecutor");
        kotlin.jvm.internal.q.g(r20, "transactionExecutor");
        kotlin.jvm.internal.q.g(r29, "typeConverters");
        kotlin.jvm.internal.q.g(r30, "autoMigrationSpecs");
        this.f4554a = r12;
        this.f4555b = r13;
        this.f4556c = r14;
        this.f4557d = r15;
        this.f4558e = r16;
        this.f4559f = r17;
        this.f4560g = r18;
        this.f4561h = r19;
        this.f4562i = r20;
        this.f4563j = r21;
        this.f4564k = r22;
        this.f4565l = r23;
        this.f4566m = r24;
        this.f4567n = r25;
        this.f4568o = r26;
        this.f4569p = r27;
        this.f4570q = r29;
        this.f4571r = r30;
        if (r21 == null) goto L5;
        boolean r10 = true;
    L6:
        this.f4572s = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public boolean a(int r10, int r11) {
        if (r10 <= r11) goto L8;
        if (this.f4565l == false) goto L8;
        return false;
    L8:
        if (this.f4564k == false) goto L15;
        Set r12 = this.f4566m;
        if (r12 != null) goto L12;
    L13:
        return true;
    L12:
        if (r12.contains(Integer.valueOf(r10)) == false) goto L13;
        return false;
    L15:
        return false;
    }
}
