package com.obric.feedback.sdk;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.obric.cloudsdk.kv.base.KvConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeedbackSdkProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016JO\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001bJ;\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/obric/feedback/sdk/FeedbackSdkProvider;", "Landroid/content/ContentProvider;", "()V", "call", "Landroid/os/Bundle;", "method", "", "arg", "extras", "delete", "", "uri", "Landroid/net/Uri;", CallLogListAdapter.PAYLOAD_SELECTION, "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "feedbacksdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FeedbackSdkProvider extends ContentProvider {
    public static final Companion Companion = null;
    private static final String KEY_DID = "device_id";
    private static final String KEY_TRACE_TIME_WINDOW = "trace_time_window";
    private static final String KEY_UID = "user_id";
    private static final String METHOD_GET_APP_INFO = "get_app_info";
    private static final String PKG_FEEDBACK = "com.obric.feedback";
    private static final String TAG = "FeedbackSdkProvider";

    /* JADX INFO: compiled from: FeedbackSdkProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/feedback/sdk/FeedbackSdkProvider$Companion;", "", "()V", "KEY_DID", "", "KEY_TRACE_TIME_WINDOW", "KEY_UID", "METHOD_GET_APP_INFO", "PKG_FEEDBACK", "TAG", "feedbacksdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public FeedbackSdkProvider() {
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r3, String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "method");
        String r0 = getCallingPackage();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (Intrinsics.areEqual(r0, PKG_FEEDBACK) == true) goto L13;
        IFeedbackSdkLogger r2 = FeedbackSdk.INSTANCE.getLogger();
        if (r2 == null) goto L10;
        r2.e(TAG, "call ERROR, " + r0 + " not in white list, extras: " + r5);
    L10:
        Bundle r6 = new Bundle();
        r6.putBoolean("success", false);
        r6.putString(KvConstant.KV_SYNC_ERROR_MSG, r0 + " not in white list");
        return r6;
    L13:
        if (Intrinsics.areEqual(r3, METHOD_GET_APP_INFO) == false) goto L27;
        Bundle r7 = new Bundle();
        IAppInfoProvider r8 = FeedbackSdk.INSTANCE.getAppInfoProvider$feedbacksdk_release();
        String r9 = null;
        if (r8 == null) goto L17;
        String r10 = r8.getDid();
    L18:
        r7.putString("device_id", r10);
        IAppInfoProvider r11 = FeedbackSdk.INSTANCE.getAppInfoProvider$feedbacksdk_release();
        if (r11 == null) goto L21;
        r9 = r11.getUid();
    L21:
        r7.putString(KEY_UID, r9);
        IAppInfoProvider r12 = FeedbackSdk.INSTANCE.getAppInfoProvider$feedbacksdk_release();
        if (r12 == null) goto L24;
        long r13 = r12.getTraceContentTimeWindow();
    L25:
        r7.putLong(KEY_TRACE_TIME_WINDOW, r13);
        return r7;
    L24:
        r13 = 0;
        goto L25
    L17:
        r10 = null;
        goto L18
    L27:
        return super.call(r3, r4, r5);
    }
}
