package com.obric.aiagent.executionengine.eventstaskmanager.migration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.room.p;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: MigrationProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MigrationProvider extends PluginContentProvider {
    public static final a Companion = null;
    public static final String KEY_ADDON_DIR = "addon_dir";
    public static final String METHOD_MIGRATION_EXPORT = "method_migration_export";
    public static final String METHOD_MIGRATION_RESTORE = "method_migration_restore";
    private static final long RESTORE_SUCCESS_KILL_DELAY_MS = 200;
    private static final String TAG = "MigrationProvider";
    private final f migrationOperations$delegate;

    /* JADX INFO: compiled from: MigrationProvider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ List lambda$RulTSd8wXtSgxam5W7fzlfhdNts() {
        return migrationOperations_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$dbSjkPsZ3Nk563gG-7372eTdWuY, reason: not valid java name */
    public static /* synthetic */ void m171lambda$dbSjkPsZ3Nk563gG7372eTdWuY(int r0) {
        scheduleProcessKill$lambda$3(r0);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public MigrationProvider() {
        this.migrationOperations$delegate = g.a($$Lambda$MigrationProvider$RulTSd8wXtSgxam5W7fzlfhdNts.INSTANCE);
    }

    private final List<b<? extends p>> getMigrationOperations() {
        return (List) ZeusTransformUtils.preCheckCast(this.migrationOperations$delegate.b(), List.class, "com.obric.aiagent.plugin");
    }

    private static final List migrationOperations_delegate$lambda$0() {
        return d.a.p.b(new b[]{new com.obric.aiagent.executionengine.eventstaskmanager.migration.a(), new d()});
    }

    public Bundle call(String r4, String r5, Bundle r6) {
        o.e(r4, "method");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "call method: " + r4 + ", arg: " + r5 + ", extras: " + r6);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        validateMigrationDbNames();
        if (o.a(r4, METHOD_MIGRATION_EXPORT) == false) goto L11;
        String r7 = getAddonDir(r6, "export");
        if (r7 != null) goto L18;
        return null;
    L18:
        return resultBundle(exportDatabases(r7));
    L11:
        if (o.a(r4, METHOD_MIGRATION_RESTORE) == false) goto L16;
        String r8 = getAddonDir(r6, "restore");
        if (r8 != null) goto L20;
        return null;
    L20:
        return resultBundle(restoreDatabases(r0, r8));
    L16:
        return super.call(r4, r5, r6);
    }

    private final void validateMigrationDbNames() {
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        Iterator<b<? extends p>> r4 = getMigrationOperations().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        String r1 = ((b) ZeusTransformUtils.preCheckCast(r4.next(), b.class, "com.obric.aiagent.plugin")).b();
        if (r0.add(r1) == true) goto L4;
        throw new IllegalStateException("Duplicate migration DB name found: " + r1);
    }

    private final String getAddonDir(Bundle r3, String r4) {
        if (r3 == null) goto L5;
        String r5 = r3.getString(KEY_ADDON_DIR);
    L6:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L16;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "addon_dir is empty for " + r4);
        return null;
    L16:
        return r5;
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    private final boolean exportDatabases(String r6) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Start exporting migration databases to " + r6);
        Iterator<b<? extends p>> r5 = getMigrationOperations().iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin");
        String r1 = r0.b();
        p r2 = r0.c();
        if (r2 == null) goto L7;
        if (c.f17455a.a(r2, r1, r6) == false) goto L11;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Exported database: " + r1);
        goto L4
    L11:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "Failed to export database: " + r1);
        return false;
    L7:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "Database for " + r1 + " is null");
        return false;
    L14:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Export migration databases finished");
        return true;
    }

    private final boolean restoreDatabases(Context r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Start restoring migration databases from " + r9);
        Iterator<b<? extends p>> r0 = getMigrationOperations().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        b<? extends p> r2 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin");
        String r4 = r2.b();
        File r5 = new File(r9, r4);
        if (r5.exists() == false) goto L7;
        if (restoreSingleDatabase(r10, r2, r5, r4) == true) goto L4;
        boolean r11 = false;
    L12:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Restore migration databases finished, success=" + r11);
        if (r11 == false) goto L15;
        scheduleProcessKill();
    L15:
        return r11;
    L7:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "Backup file not found for restore: " + r5.getAbsolutePath());
        goto L4
    L11:
        r11 = true;
        goto L12
    }

    private final void scheduleProcessKill() {
        final int r4 = Process.myPid();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "All restore operations succeeded, schedule process kill in 200ms, pid=" + r4);
        new Handler(Looper.getMainLooper()).postDelayed(new $$Lambda$MigrationProvider$dbSjkPsZ3Nk563gG7372eTdWuY(r4), RESTORE_SUCCESS_KILL_DELAY_MS);
    }

    private static final void scheduleProcessKill$lambda$3(int r3) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Kill process after restore success, pid=" + r3);
        Process.killProcess(r3);
    }

    private final boolean restoreSingleDatabase(Context r9, b<? extends p> r10, File r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        b r14 = (b) ZeusTransformUtils.wrapperContextForParams(r10, b.class, "com.obric.aiagent.plugin");
        o.a(r14, "null cannot be cast to non-null type com.obric.aiagent.executionengine.eventstaskmanager.migration.IDatabaseMigrationOperation<androidx.room.RoomDatabase>");     // Catch: Exception -> L21
        p r2 = null;
        String r3 = null;
        p r4 = r14.b(r13, r11);     // Catch: Throwable -> L14
        r3 = r4.b().a();     // Catch: Throwable -> L12
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Opened restored DB " + r12 + " from " + r11.getAbsolutePath());     // Catch: Throwable -> L12
        r14.a(r13, r4);     // Catch: Throwable -> L12
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Merged restored DB " + r12 + " successfully");     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        r4.g();     // Catch: Exception -> L21
    L10:
        if (r3 == null) goto L29;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Delete restored DB file " + r3 + " result=" + r13.deleteDatabase(r3));     // Catch: Exception -> L21
        return true;
    L29:
        return true;
    L12:
        th = th;
        String r15 = r3;
        r2 = r4;
    L16:
        if (r2 == null) goto L18;
        r2.g();     // Catch: Exception -> L21
    L18:
        if (r15 == null) goto L20;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Delete restored DB file " + r15 + " result=" + r13.deleteDatabase(r15));     // Catch: Exception -> L21
    L20:
        throw th;     // Catch: Exception -> L21
    L14:
        th = th;
        r15 = null;
    L21:
        e = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Exception during restore of database " + r12, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    private final Bundle resultBundle(boolean r2) {
        Bundle r1 = new Bundle();
        r1.putBoolean("ok", r2);
        return r1;
    }
}
