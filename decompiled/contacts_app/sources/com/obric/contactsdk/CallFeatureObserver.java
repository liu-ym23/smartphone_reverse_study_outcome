package com.obric.contactsdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.obric.callandsms.common.CallSmsEntityChangeObserver;
import com.obric.callandsms.common.Logger;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.contactsdk.loader.CallHistoryEntityUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallFeatureObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/contactsdk/CallFeatureObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "mContext", "Landroid/content/Context;", "(Landroid/os/Handler;Landroid/content/Context;)V", "delayMillis", "", "getHandler", "()Landroid/os/Handler;", "getMContext", "()Landroid/content/Context;", "pendingCallSummaryFlag", "", "", "updateCallSummaryDataRunnable", "Ljava/lang/Runnable;", "convertCallFlagToList", "", "ids", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "Companion", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallFeatureObserver extends ContentObserver {
    public static final Companion Companion = null;
    public static final String TAG = "CallFeatureObserver";
    private final long delayMillis;
    private final Handler handler;
    private final Context mContext;
    private final Set<String> pendingCallSummaryFlag;
    private final Runnable updateCallSummaryDataRunnable;

    /* JADX INFO: compiled from: CallFeatureObserver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/contactsdk/CallFeatureObserver$Companion;", "", "()V", "TAG", "", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$c-XdsRpFuTGpD92JuSgXcKe0TC4, reason: not valid java name */
    public static /* synthetic */ void m350$r8$lambda$cXdsRpFuTGpD92JuSgXcKe0TC4(CallFeatureObserver r0) {
        updateCallSummaryDataRunnable$lambda$1(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public CallFeatureObserver(Handler r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r3, "mContext");
        super(r2);
        this.handler = r2;
        this.mContext = r3;
        this.pendingCallSummaryFlag = new LinkedHashSet();
        this.delayMillis = 1000;
        this.updateCallSummaryDataRunnable = new CallFeatureObserver$$ExternalSyntheticLambda0(this);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    private static final void updateCallSummaryDataRunnable$lambda$1(CallFeatureObserver r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if ((!r4.pendingCallSummaryFlag.isEmpty()) == false) goto L17;
        List<String> r0 = CallHistoryEntityUtilKt.getCallLogIdByCallFlags(r4.mContext, CollectionsKt.toList(r4.pendingCallSummaryFlag));
        Logger.INSTANCE.d(TAG, "updateCallSummaryDataRunnable: " + r0);
        r4.pendingCallSummaryFlag.clear();
        ContentResolver r1 = r4.mContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r1, "mContext.contentResolver");
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Long r5 = StringsKt.toLongOrNull((String) r3.next());
        if (r5 == null) goto L6;
        r2.add(r5);
        goto L6
    L10:
        CallSmsEntityChangeObserver.INSTANCE.bulkIndex(CallHistoryEntityUtilKt.filterExpiredCallHistoryEntities(CallHistoryEntityUtilKt.queryCallLogsByIds(r1, r2, r4.mContext)));
        return;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r5, Uri r6) {
        super.onChange(r5, r6);
        String r7 = null;
        if (r6 == null) goto L5;
        String r0 = r6.getQueryParameter(CallFeatureEntityUtilKt.PARAM_KEY_CALL_FlAG);
    L6:
        if (r6 == null) goto L8;
        r7 = r6.getQueryParameter(CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
    L8:
        Logger r8 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder("onChange: action [").append(r7).append("], callFlags [");
        String r3 = r0;
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        r8.d(TAG, r2.append(r4).append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString());
        if (r7 == null) goto L41;
        if (r0 == null) goto L44;
        List<String> r9 = convertCallFlagToList(r0);
        int r1 = r7.hashCode();
        if (r1 == (-1335458389)) goto L32;
        if (r1 == (-1183792455)) goto L29;
        if (r1 == (-838846263)) goto L26;
        return;
    L26:
        if (r7.equals("update") == false) goto L48;
    L33:
        Set<String> r10 = this.pendingCallSummaryFlag;
        monitor-enter(r10);
        this.pendingCallSummaryFlag.addAll(r9);     // Catch: Throwable -> L38
        monitor-exit(r10);
        this.handler.removeCallbacks(this.updateCallSummaryDataRunnable);
        this.handler.postDelayed(this.updateCallSummaryDataRunnable, this.delayMillis);
        return;
    L38:
        th = move-exception;
        throw th;
    L48:
        return;
    L29:
        if (r7.equals("insert") == true) goto L33;
        return;
    L32:
        if (r7.equals("delete") == true) goto L33;
        return;
    L44:
        return;
    L41:
        return;
    L11:
        if (r3.length() == 0) goto L14;
        r4 = false;
        goto L15
    L5:
        r0 = null;
        goto L6
    }

    public final List<String> convertCallFlagToList(String r8) {
        ArrayList r7 = new ArrayList();
        String r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        return r7;
    L20:
        List r9 = StringsKt.split$default(r8, new String[]{SimContactsConstants.EMAIL_SEP}, false, 0, 6, null);     // Catch: Exception -> L17
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));     // Catch: Exception -> L17
        Iterator r10 = r9.iterator();     // Catch: Exception -> L17
    L13:
        if (r10.hasNext() == false) goto L15;
        r2.add(StringsKt.trim((String) r10.next()).toString());     // Catch: Exception -> L17
        goto L13
    L15:
        return r2;
    L17:
        e = move-exception;
        System.out.println("Error converting call flags to list: " + e.getMessage());
        return r7;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
