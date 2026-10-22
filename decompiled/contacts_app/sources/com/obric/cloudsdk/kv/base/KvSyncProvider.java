package com.obric.cloudsdk.kv.base;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.android.contacts.ContactsUtils;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.android.contacts.common.SimContactsConstants;
import com.obric.cloudsdk.kv.SdkGlobals;
import com.obric.cloudsdk.kv.room.AbsDatabase;
import com.obric.cloudsdk.kv.room.DbManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KvSyncProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016JM\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001dJ1\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\u001c\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020&H\u0016JO\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\f\u001a\u00020\u00062\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010+J;\u0010,\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040/*\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvSyncProvider;", "Landroid/content/ContentProvider;", "()V", "AUTHORITY", "", "CONTENT_URI_FILE", "Landroid/net/Uri;", "CONTENT_URI_SYNC_STATE", "uriMatcher", "Landroid/content/UriMatcher;", "bulkInsert", "", "uri", "valuesArray", "", "Landroid/content/ContentValues;", "(Landroid/net/Uri;[Landroid/content/ContentValues;)I", "call", "Landroid/os/Bundle;", "method", "arg", "extras", "createSQLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "projection", CallLogListAdapter.PAYLOAD_SELECTION, "selectionArgs", "sortOrder", "tableName", "([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQuery;", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "initUriMatcher", "", "insert", "values", "isSensitiveData", "", "key", "onCreate", "query", "Landroid/database/Cursor;", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "nonSensitiveValues", "", "Companion", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KvSyncProvider extends ContentProvider {
    public static final Companion Companion = null;
    private static final String TABLE_FILE = "kv_file_info";
    private static final int TABLE_FILE_ID = 2;
    private static final String TABLE_SYNC_STATE = "data_sync_state";
    private static final int TABLE_SYNC_STATE_ID = 1;
    private String AUTHORITY;
    private Uri CONTENT_URI_FILE;
    private Uri CONTENT_URI_SYNC_STATE;
    private final UriMatcher uriMatcher;

    /* JADX INFO: compiled from: KvSyncProvider.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvSyncProvider$Companion;", "", "()V", "TABLE_FILE", "", "TABLE_FILE_ID", "", "TABLE_SYNC_STATE", "TABLE_SYNC_STATE_ID", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KvSyncProvider() {
        this.uriMatcher = new UriMatcher(-1);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context r0 = getContext();
        if (r0 == null) goto L5;
        String r1 = r0.getPackageName();
    L6:
        this.AUTHORITY = r1 + ".KvSyncProvider";
        KvLog.INSTANCE.i("KvSyncProvider", "onCreate, AUTHORITY:" + this.AUTHORITY);
        initUriMatcher();
        return true;
    L5:
        r1 = null;
        goto L6
    }

    private final void initUriMatcher() {
        this.CONTENT_URI_SYNC_STATE = Uri.parse("content://" + this.AUTHORITY + "/data_sync_state");
        this.CONTENT_URI_FILE = Uri.parse("content://" + this.AUTHORITY + "/kv_file_info");
        this.uriMatcher.addURI(this.AUTHORITY, TABLE_FILE, 2);
        this.uriMatcher.addURI(this.AUTHORITY, TABLE_SYNC_STATE, 1);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        int r0 = this.uriMatcher.match(r9);
        if (r0 != 1) goto L5;
        String r1 = TABLE_SYNC_STATE;
    L10:
        KvLog.INSTANCE.i("KvSyncProvider", "query start, uri: " + r9);
        SupportSQLiteQuery r2 = createSQLiteQuery(r10, r11, r12, r13, r1);
        AbsDatabase r3 = DbManager.INSTANCE.getInstance(getContext());
        ContentResolver r4 = null;
        if (r3 == null) goto L17;
        SupportSQLiteOpenHelper r5 = r3.getOpenHelper();
        if (r5 == null) goto L17;
        SupportSQLiteDatabase r6 = r5.getReadableDatabase();
        if (r6 == null) goto L17;
        Cursor r7 = r6.query(r2);
    L18:
        if (r7 == null) goto L23;
        Context r8 = getContext();
        if (r8 == null) goto L22;
        r4 = r8.getContentResolver();
    L22:
        r7.setNotificationUri(r4, r9);
    L23:
        KvLog r14 = KvLog.INSTANCE;
        StringBuilder r15 = new StringBuilder("query end, uri: ").append(r9).append(", projection:");
        String r16 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
        StringBuilder r17 = r15.append(r16).append(", selection:").append(r11).append(", selectionArgs:");
        String r18 = Arrays.toString(r12);
        Intrinsics.checkNotNullExpressionValue(r18, "toString(...)");
        r14.i("KvSyncProvider", r17.append(r18).append(", sortOrder:").append(r13).toString());
        return r7;
    L17:
        r7 = null;
        goto L18
    L5:
        if (r0 != 2) goto L8;
        r1 = TABLE_FILE;
        goto L10
    L8:
        throw new IllegalArgumentException("Unknown URI: " + r9);
    }

    private final SupportSQLiteQuery createSQLiteQuery(String[] r4, String r5, String[] r6, String r7, String r8) {
        StringBuilder r3 = new StringBuilder("SELECT ");
        boolean r0 = false;
        if (r4 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r3.append(ContactsUtils.CHAR_STAR);
    L15:
        r3.append(" FROM " + r8);
        String r9 = r5;
        if (r9 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == true) goto L24;
        r3.append(" WHERE ").append(r5);
    L24:
        String r11 = r7;
        if (r11 != null) goto L27;
    L28:
        r0 = true;
    L29:
        if (r0 == true) goto L32;
        r3.append(" ORDER BY ").append(r7);
    L32:
        return new SimpleSQLiteQuery(r3.toString(), r6);
    L27:
        if (r11.length() != 0) goto L29;
    L18:
        if (r9.length() == 0) goto L21;
        r10 = false;
        goto L22
    L14:
        r3.append(TextUtils.join(SimContactsConstants.EMAIL_SEP, r4));
        goto L15
    L5:
        if (r4.length != 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r12 = false;
        goto L8
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        KvLog.INSTANCE.i("KvSyncProvider", "getType, uri: " + r3);
        return null;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri r20, ContentValues[] r21) {
        Intrinsics.checkNotNullParameter(r20, "uri");
        Intrinsics.checkNotNullParameter(r21, "valuesArray");
        KvLog.INSTANCE.i("KvSyncProvider", "bulkInsert， start, uri: " + r20 + ", valuesArray:" + r21);
        int r0 = this.uriMatcher.match(r20);
        if (r0 == 1) goto L8;
        if (r0 != 2) goto L7;
        String r1 = TABLE_FILE;
    L9:
        String r6 = r1;
        AbsDatabase r2 = DbManager.INSTANCE.getInstance(getContext());
        if (r2 == null) goto L14;
        SupportSQLiteOpenHelper r3 = r2.getOpenHelper();
        if (r3 == null) goto L14;
        SupportSQLiteDatabase r8 = r3.getWritableDatabase();
    L16:
        if (r8 != null) goto L18;
        return 0;
    L18:
        r8.beginTransaction();
        int r9 = r21.length;     // Catch: Throwable -> L40
        int r10 = 0;
        int r11 = 0;
    L20:
        if (r10 >= r9) goto L30;
    L24:
        if (r8.insert(r6, 2, r21[r10]) == (-1)) goto L29;
        r11 = r11 + 1;
    L29:
        r10 = r10 + 1;     // Catch: Throwable -> L40
    L26:
        e = move-exception;
        KvLog.e$default(KvLog.INSTANCE, "KvSyncProvider", "bulkInsert，SQLiteConstraintException:" + e.getMessage(), null, 4, null);     // Catch: Throwable -> L40
        goto L29
    L30:
        r8.setTransactionSuccessful();     // Catch: Throwable -> L40
        r8.endTransaction();
        if (r11 <= 0) goto L38;
        Context r4 = getContext();
        if (r4 == null) goto L38;
        ContentResolver r5 = r4.getContentResolver();
        if (r5 == null) goto L38;
        r5.notifyChange(r20, null);
    L38:
        KvLog.INSTANCE.i("KvSyncProvider", "bulkInsert，rowsInserted:" + r11);
        return r11;
    L40:
        th = move-exception;
        r8.endTransaction();
        throw th;
    L14:
        r8 = null;
        goto L16
    L7:
        throw new IllegalArgumentException("Unknown URI: " + r20);
    L8:
        r1 = TABLE_SYNC_STATE;
        goto L9
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r13, ContentValues r14) {
        Intrinsics.checkNotNullParameter(r13, "uri");
        if (r14 != null) goto L5;
        return null;
    L5:
        KvLog.INSTANCE.i("KvSyncProvider", "insert， uri: " + r13 + ", value: " + nonSensitiveValues(r14));
        int r1 = this.uriMatcher.match(r13);
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        String r2 = TABLE_FILE;
    L35:
        AbsDatabase r3 = DbManager.INSTANCE.getInstance(getContext());     // Catch: SQLiteConstraintException -> L22
        if (r3 == null) goto L21;
        SupportSQLiteOpenHelper r4 = r3.getOpenHelper();     // Catch: SQLiteConstraintException -> L22
        if (r4 == null) goto L21;
        SupportSQLiteDatabase r5 = r4.getWritableDatabase();     // Catch: SQLiteConstraintException -> L22
        if (r5 == null) goto L21;
        Long r15 = Long.valueOf(r5.insert(r2, 2, r14));     // Catch: SQLiteConstraintException -> L22
    L24:
        if (r15 != null) goto L27;
    L28:
        Context r12 = getContext();
        if (r12 == null) goto L34;
        ContentResolver r16 = r12.getContentResolver();
        if (r16 == null) goto L34;
        r16.notifyChange(r13, null);
    L34:
        return Uri.withAppendedPath(r13, String.valueOf(r15));
    L27:
        if (r15.longValue() != (-1)) goto L28;
        return null;
    L21:
        r15 = null;
    L22:
        e = move-exception;
        KvLog.e$default(KvLog.INSTANCE, "KvSyncProvider", "insert，SQLiteConstraintException:" + e.getMessage(), null, 4, null);
        r15 = -1L;
        goto L24
    L10:
        throw new IllegalArgumentException("Unknown URI: " + r13);
    L11:
        r2 = TABLE_SYNC_STATE;
        goto L35
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r4, String r5, String[] r6) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        int r0 = this.uriMatcher.match(r4);
        if (r0 != 1) goto L5;
        String r1 = TABLE_SYNC_STATE;
    L10:
        AbsDatabase r2 = DbManager.INSTANCE.getInstance(getContext());
        if (r2 == null) goto L17;
        SupportSQLiteOpenHelper r3 = r2.getOpenHelper();
        if (r3 == null) goto L17;
        SupportSQLiteDatabase r7 = r3.getWritableDatabase();
        if (r7 == null) goto L17;
        Integer r8 = Integer.valueOf(r7.delete(r1, r5, r6));
    L18:
        Context r9 = getContext();
        if (r9 == null) goto L23;
        ContentResolver r10 = r9.getContentResolver();
        if (r10 == null) goto L23;
        r10.notifyChange(r4, null);
    L23:
        KvLog r11 = KvLog.INSTANCE;
        StringBuilder r12 = new StringBuilder("delete， uri: ").append(r4).append(", selection:").append(r5).append(", selectionArgs:");
        String r13 = Arrays.toString(r6);
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
        r11.i("KvSyncProvider", r12.append(r13).toString());
        if (r8 != null) goto L28;
        return 0;
    L28:
        return r8.intValue();
    L17:
        r8 = null;
        goto L18
    L5:
        if (r0 != 2) goto L8;
        r1 = TABLE_FILE;
        goto L10
    L8:
        throw new IllegalArgumentException("Unknown URI: " + r4);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r9, ContentValues r10, String r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        if (r10 != null) goto L5;
        return 0;
    L5:
        KvLog r1 = KvLog.INSTANCE;
        StringBuilder r2 = new StringBuilder("update， uri: ").append(r9).append(", values: ").append(nonSensitiveValues(r10)).append(", selection:").append(r11).append(", selectionArgs:");
        String r3 = Arrays.toString(r12);
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        r1.i("KvSyncProvider", r2.append(r3).toString());
        int r4 = this.uriMatcher.match(r9);
        if (r4 != 1) goto L8;
        String r5 = TABLE_SYNC_STATE;
    L13:
        String r6 = r5;
        AbsDatabase r7 = DbManager.INSTANCE.getInstance(getContext());     // Catch: SQLiteConstraintException -> L22
        if (r7 == null) goto L24;
        SupportSQLiteOpenHelper r8 = r7.getOpenHelper();     // Catch: SQLiteConstraintException -> L22
        if (r8 == null) goto L24;
        SupportSQLiteDatabase r13 = r8.getWritableDatabase();     // Catch: SQLiteConstraintException -> L22
        if (r13 == null) goto L24;
        Integer r14 = Integer.valueOf(r13.update(r6, 2, r10, r11, r12));     // Catch: SQLiteConstraintException -> L22
    L25:
        if (r14 != null) goto L27;
    L33:
        if (r14 != null) goto L35;
        return 0;
    L35:
        return r14.intValue();
    L27:
        if (r14.intValue() <= 0) goto L33;
        Context r15 = getContext();
        if (r15 == null) goto L33;
        ContentResolver r16 = r15.getContentResolver();
        if (r16 == null) goto L33;
        r16.notifyChange(r9, null);
    L24:
        r14 = null;
    L22:
        e = move-exception;
        KvLog.e$default(KvLog.INSTANCE, "KvSyncProvider", "update，SQLiteConstraintException:" + e.getMessage(), null, 4, null);
        goto L24
    L8:
        if (r4 != 2) goto L11;
        r5 = TABLE_FILE;
        goto L13
    L11:
        throw new IllegalArgumentException("Unknown URI: " + r9);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.content.ContentProvider
    public Bundle call(String r12, String r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "method");
        KvLog.INSTANCE.d("KvSyncProvider", "call, method: " + r12 + ", arg: " + r13 + ", extras: " + r14);
        if (Intrinsics.areEqual(KvConstant.METHOD_IS_CURRENT_SYNCABLE, r12) == false) goto L6;
        boolean r11 = SdkGlobals.INSTANCE.getSyncInfo().isCurrentSyncable();
        Bundle r15 = new Bundle();
        r15.putBoolean(KvConstant.KEY_IS_CURRENT_SYNCABLE, r11);
        return r15;
    L6:
        Integer r3 = null;
        if (Intrinsics.areEqual(KvConstant.METHOD_UPDATE_SYNC_STATUS, r12) == false) goto L15;
        if (r14 == null) goto L10;
        r3 = Integer.valueOf(r14.getInt("state"));
    L10:
        KvLog.INSTANCE.d("KvSyncProvider", "call, syncStatus: " + r3);
        if (r3 == null) goto L14;
        KvSyncManager.INSTANCE.onSyncStateChanged(r3.intValue());
    L14:
        return super.call(r12, r13, r14);
    L15:
        String r4 = "";
        if (Intrinsics.areEqual(KvConstant.METHOD_UPDATE_SYNC_STATUS_WITH_EXTRA_INFO, r12) == false) goto L33;
        if (r14 == null) goto L19;
        r3 = Integer.valueOf(r14.getInt("state"));
    L19:
        if (r14 == null) goto L21;
        int r0 = r14.getInt("error_code");
    L22:
        if (r14 == null) goto L27;
        String r1 = r14.getString(KvConstant.KV_SYNC_ERROR_MSG);
        if (r1 == null) goto L27;
        r4 = r1;
    L27:
        KvLog.INSTANCE.d("KvSyncProvider", "call, syncStatusWithExtraInfo: " + r3 + ", errorCode: " + r0 + ", errorMsg: " + r4);
        if (r3 == null) goto L31;
        KvSyncManager.INSTANCE.onSyncStateChangedWithExtraInfo(r3.intValue(), r14);
    L31:
        return super.call(r12, r13, r14);
    L21:
        r0 = -1;
        goto L22
    L33:
        if (Intrinsics.areEqual(KvConstant.METHOD_GET_SYNC_CONFIG, r12) == true) goto L35;
        boolean r2 = false;
        int r5 = 0;
        int r6 = 0;
        boolean r7 = false;
        if (Intrinsics.areEqual(KvConstant.METHOD_UPDATE_FILE_TASK_INIT, r12) == false) goto L57;
        if (r14 == null) goto L40;
        int r16 = r14.getInt(KvConstant.KV_LOCAL_UPSERT_COUNT);
    L41:
        if (r14 == null) goto L43;
        int r17 = r14.getInt(KvConstant.KV_LOCAL_DELETE_COUNT);
    L44:
        if (r14 == null) goto L46;
        int r18 = r14.getInt(KvConstant.KV_CLOUD_UPSERT_COUNT);
    L47:
        if (r14 == null) goto L49;
        r5 = r14.getInt(KvConstant.KV_CLOUD_DELETE_COUNT);
    L49:
        if (r16 != 0) goto L53;
        if (r17 != 0) goto L53;
        if (r18 != 0) goto L53;
        if (r5 != 0) goto L53;
    L55:
        return new Bundle();
    L53:
        KvSyncManager.INSTANCE.notifyFileTaskInit(r16, r17, r18, r5);
        goto L55
    L46:
        r18 = 0;
        goto L47
    L43:
        r17 = 0;
        goto L44
    L40:
        r16 = 0;
        goto L41
    L57:
        if (Intrinsics.areEqual(KvConstant.METHOD_UPDATE_FILE_TASK_PROGRESS, r12) == false) goto L85;
        if (r14 == null) goto L60;
        int r8 = r14.getInt(KvConstant.KV_TASK_TYPE);
    L61:
        if (r14 == null) goto L66;
        String r19 = r14.getString(KvConstant.KV_UNIQUE_ID);
        if (r19 == null) goto L66;
        String r9 = r19;
    L67:
        if (r14 == null) goto L72;
        String r110 = r14.getString(KvConstant.KV_CLOUD_ID);
        if (r110 == null) goto L72;
        String r10 = r110;
    L73:
        if (r14 == null) goto L75;
        r6 = r14.getInt(KvConstant.KV_FAIL_CODE);
    L75:
        int r20 = r6;
        if (r14 == null) goto L81;
        String r111 = r14.getString(KvConstant.KV_FAIL_MSG);
        if (r111 == null) goto L81;
        String r112 = r111;
    L82:
        KvSyncManager.INSTANCE.notifyFileTaskProgress(r8, r9, r10, r20, r112);
        return new Bundle();
    L81:
        r112 = "";
    L72:
        r10 = "";
    L66:
        r9 = "";
        goto L67
    L60:
        r8 = 0;
        goto L61
    L85:
        if (Intrinsics.areEqual(KvConstant.METHOD_UPDATE_SWITCH_CHANGED, r12) == false) goto L91;
        if (r14 == null) goto L88;
        r7 = r14.getBoolean(KvConstant.KV_IS_SWITCH_ON);
    L88:
        KvSyncManager.INSTANCE.notifySwitchChanged(r7);
        return new Bundle();
    L91:
        if (Intrinsics.areEqual(KvConstant.METHOD_UPDATE_SYNC_SETTINGS_CHANGED, r12) == false) goto L97;
        if (r14 == null) goto L94;
        r2 = r14.getBoolean(KvConstant.KV_IS_SWITCH_ON);
    L94:
        KvSyncManager.INSTANCE.notifySyncSettingsChanged(r2);
        return new Bundle();
    L97:
        if (Intrinsics.areEqual(KvConstant.METHOD_TRY_RENAME_LOCAL_FILE, r12) == false) goto L109;
        if (r14 == null) goto L100;
        long r113 = r14.getLong(KvConstant.KV_DATA_ID);
    L101:
        if (r14 == null) goto L106;
        String r114 = r14.getString(KvConstant.KV_NEW_FILE_NAME);
        if (r114 == null) goto L106;
        r4 = r114;
    L106:
        boolean r115 = KvSyncManager.INSTANCE.tryRenameLocalFile(r113, r4);
        Bundle r116 = new Bundle();
        r116.putBoolean(KvConstant.KV_IS_SUCCESS, r115);
        return r116;
    L100:
        r113 = -1;
        goto L101
    L109:
        return super.call(r12, r13, r14);
    L35:
        return KvSyncManager.INSTANCE.getSyncConfig();
    }

    private final List<String> nonSensitiveValues(ContentValues r5) {
        ArrayList r0 = new ArrayList();
        Set<Map.Entry<String, Object>> r6 = r5.valueSet();
        Intrinsics.checkNotNullExpressionValue(r6, "valueSet()");
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r7.next();
        Object r2 = r1.getKey();
        Intrinsics.checkNotNullExpressionValue(r2, "it.key");
        if (isSensitiveData((String) r2) == true) goto L4;
        r0.add(((String) r1.getKey()) + '=' + r1.getValue());
        goto L4
    L8:
        return r0;
    }

    private final boolean isSensitiveData(String r1) {
        return Intrinsics.areEqual(r1, "uid");
    }
}
