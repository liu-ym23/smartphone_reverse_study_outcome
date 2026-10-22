package com.android.contacts.calllog.blocked;

import android.net.Uri;
import com.android.contacts.common.dialog.CallSubjectDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockedCall.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\f¨\u0006\""}, d2 = {"Lcom/android/contacts/calllog/blocked/BlockedCall;", "", "()V", "AUTHORITY", "", "BCL_DATETIME", "BCL_INTERCEPT_TYPE", "BCL_PHONE_NUMBER", "BCL_SLOT_ID", "BLACKLIST_URI", "Landroid/net/Uri;", "getBLACKLIST_URI", "()Landroid/net/Uri;", "BLOCKED_CALLS_PROJECTION", "", "getBLOCKED_CALLS_PROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "BLOCKED_CALL_LOG_URI", "getBLOCKED_CALL_LOG_URI", "BLOCKED_CALL_URI", "getBLOCKED_CALL_URI", "DATETIME", "", "ID", "INTERCEPT_TYPE", "KEY_IN_WHITE_LIST", "KEY_WHITE_LIST", "METHOD_CALL_INTERCEPT_ADD_STATUS", "METHOD_CLEAR_CALL_INTERCEPT_ADD_STATUS", CallSubjectDialog.ARG_NUMBER, "SLOT_ID", "WHITELIST_URI", "getWHITELIST_URI", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockedCall {
    public static final String AUTHORITY = "com.obric.nodisturb.provider";
    public static final String BCL_DATETIME = "bcl_datetime";
    public static final String BCL_INTERCEPT_TYPE = "bcl_intercept_type";
    public static final String BCL_PHONE_NUMBER = "bcl_phone_number";
    public static final String BCL_SLOT_ID = "bcl_slot_id";
    private static final Uri BLACKLIST_URI = null;
    private static final String[] BLOCKED_CALLS_PROJECTION = null;
    private static final Uri BLOCKED_CALL_LOG_URI = null;
    private static final Uri BLOCKED_CALL_URI = null;
    public static final int DATETIME = 2;
    public static final int ID = 0;
    public static final BlockedCall INSTANCE = null;
    public static final int INTERCEPT_TYPE = 3;
    public static final String KEY_IN_WHITE_LIST = "inwhitelist";
    public static final String KEY_WHITE_LIST = "whitelist";
    public static final String METHOD_CALL_INTERCEPT_ADD_STATUS = "callinterceptaddstatus";
    public static final String METHOD_CLEAR_CALL_INTERCEPT_ADD_STATUS = "clearcallinterceptaddstatus";
    public static final int NUMBER = 1;
    public static final int SLOT_ID = 4;
    private static final Uri WHITELIST_URI = null;

    private BlockedCall() {
    }

    public final Uri getWHITELIST_URI() {
        return WHITELIST_URI;
    }

    public final Uri getBLACKLIST_URI() {
        return BLACKLIST_URI;
    }

    public final Uri getBLOCKED_CALL_LOG_URI() {
        return BLOCKED_CALL_LOG_URI;
    }

    public final Uri getBLOCKED_CALL_URI() {
        return BLOCKED_CALL_URI;
    }

    public final String[] getBLOCKED_CALLS_PROJECTION() {
        return BLOCKED_CALLS_PROJECTION;
    }

    static {
        INSTANCE = new BlockedCall();
        Uri r0 = Uri.parse("content://com.obric.nodisturb.provider/whitelistcount");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(this)");
        WHITELIST_URI = r0;
        Uri r1 = Uri.parse("content://com.obric.nodisturb.provider/blacklistcount");
        Intrinsics.checkNotNullExpressionValue(r1, "parse(this)");
        BLACKLIST_URI = r1;
        Uri r2 = Uri.parse("content://com.obric.nodisturb.provider/blockedcalllog");
        Intrinsics.checkNotNullExpressionValue(r2, "parse(this)");
        BLOCKED_CALL_LOG_URI = r2;
        Uri r3 = Uri.parse("content://com.obric.nodisturb.provider");
        Intrinsics.checkNotNullExpressionValue(r3, "parse(this)");
        BLOCKED_CALL_URI = r3;
        BLOCKED_CALLS_PROJECTION = new String[]{"_id", BCL_PHONE_NUMBER, BCL_DATETIME, BCL_INTERCEPT_TYPE, BCL_SLOT_ID};
    }
}
