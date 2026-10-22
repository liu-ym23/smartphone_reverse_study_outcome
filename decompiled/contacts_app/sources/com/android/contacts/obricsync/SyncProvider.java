package com.android.contacts.obricsync;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.obric.privacy.PrivacyUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016JO\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0017¢\u0006\u0002\u0010\u0019J9\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/contacts/obricsync/SyncProvider;", "Landroid/content/ContentProvider;", "()V", "CONTACT_DATA_CODE", "", "uriMatcher", "Landroid/content/UriMatcher;", "delete", "uri", "Landroid/net/Uri;", CallLogListAdapter.PAYLOAD_SELECTION, "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SyncProvider extends ContentProvider {
    private static final String AUTHORITY = null;
    private static final Uri CONTENT_URI_CONTACT_SYNC = null;
    public static final Companion Companion = null;
    private static final String PATH_CONTACT_DATA = null;
    private final int CONTACT_DATA_CODE;
    private UriMatcher uriMatcher;

    /* JADX INFO: compiled from: SyncProvider.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/android/contacts/obricsync/SyncProvider$Companion;", "", "()V", "AUTHORITY", "", "getAUTHORITY", "()Ljava/lang/String;", "CONTENT_URI_CONTACT_SYNC", "Landroid/net/Uri;", "getCONTENT_URI_CONTACT_SYNC", "()Landroid/net/Uri;", "PATH_CONTACT_DATA", "getPATH_CONTACT_DATA", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final String getAUTHORITY() {
            return SyncProvider.access$getAUTHORITY$cp();
        }

        public final String getPATH_CONTACT_DATA() {
            return SyncProvider.access$getPATH_CONTACT_DATA$cp();
        }

        public final Uri getCONTENT_URI_CONTACT_SYNC() {
            return SyncProvider.access$getCONTENT_URI_CONTACT_SYNC$cp();
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    public SyncProvider() {
        this.CONTACT_DATA_CODE = 1;
        UriMatcher r1 = new UriMatcher(-1);
        this.uriMatcher = r1;
        r1.addURI(AUTHORITY, PATH_CONTACT_DATA, 1);
    }

    public static final /* synthetic */ String access$getAUTHORITY$cp() {
        return AUTHORITY;
    }

    public static final /* synthetic */ Uri access$getCONTENT_URI_CONTACT_SYNC$cp() {
        return CONTENT_URI_CONTACT_SYNC;
    }

    public static final /* synthetic */ String access$getPATH_CONTACT_DATA$cp() {
        return PATH_CONTACT_DATA;
    }

    static {
        Companion = new Companion(null);
        AUTHORITY = "com.android.contacts.SyncProvider";
        PATH_CONTACT_DATA = SyncContractKt.TAB_NAME_SYNC;
        Uri r0 = Uri.parse("content://com.android.contacts.SyncProvider/" + SyncContractKt.TAB_NAME_SYNC);
        Intrinsics.checkNotNullExpressionValue(r0, "parse(\"content://$AUTHORITY/$PATH_CONTACT_DATA\")");
        CONTENT_URI_CONTACT_SYNC = r0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r11, String[] r12, String r13, String[] r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        Cursor r1 = null;
        if (PrivacyUtils.hasBasePermissionAndAgree(r0) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#call method query, but privacy not ok");
        return null;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#query " + r11);
        if (this.uriMatcher.match(r11) != this.CONTACT_DATA_CODE) goto L14;
        Context r10 = getContext();
        if (r10 == null) goto L13;
        ContentResolver r4 = r10.getContentResolver();
        if (r4 == null) goto L13;
        r1 = r4.query(SyncContractKt.getContactSyncUri(), r12, r13, r14, r15);
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#query " + r1);
    L15:
        return r1;
    L14:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#query null");
        goto L15
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        if (this.uriMatcher.match(r2) != this.CONTACT_DATA_CODE) goto L5;
        return SyncContractKt.CONTENT_TYPE;
    L5:
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r4, ContentValues r5) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        if (PrivacyUtils.hasBasePermissionAndAgree(r0) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#insert method insert, but privacy not ok");
        return null;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#insert call");
        if (this.uriMatcher.match(r4) != this.CONTACT_DATA_CODE) goto L13;
        Context r3 = getContext();
        if (r3 != null) goto L11;
        return null;
    L11:
        return ContentUris.withAppendedId(CONTENT_URI_CONTACT_SYNC, SyncToLocalUtils.insertContact(r3, r5));
    L13:
        throw new UnsupportedOperationException("Cannot insert that URI: " + r4);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r5, String r6, String[] r7) {
        Intrinsics.checkNotNullParameter(r5, "uri");
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        if (PrivacyUtils.hasBasePermissionAndAgree(r0) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#delete method delete, but privacy not ok");
        return -1;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#delete " + r5);
        if (this.uriMatcher.match(r5) != this.CONTACT_DATA_CODE) goto L13;
        Context r4 = getContext();
        if (r4 != null) goto L11;
        return -1;
    L11:
        return SyncToLocalUtils.deleteContact(r4, r6, r7);
    L13:
        throw new UnsupportedOperationException("Cannot delete that URI: " + r5);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r4, ContentValues r5, String r6, String[] r7) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        if (PrivacyUtils.hasBasePermissionAndAgree(r0) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#update method update, but privacy not ok");
        return -1;
    L7:
        if (this.uriMatcher.match(r4) != this.CONTACT_DATA_CODE) goto L17;
        Context r3 = getContext();
        if (r3 == null) goto L14;
        boolean r8 = SyncToLocalUtils.updateContact(r3, r5, r6, r7);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "SyncProvider#update updateSuc = " + r8);
        if (r8 == false) goto L18;
        return 1;
    L18:
        return 0;
    L14:
        return 0;
    L17:
        throw new UnsupportedOperationException("Cannot update that URI: " + r4);
    }
}
