package com.obric.feedback.sdk;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.os.Bundle;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.obric.cloudsdk.kv.base.KvConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeedbackSdk.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ<\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/feedback/sdk/FeedbackSdk;", "", "()V", "FEEDBACK_PROVIDER_AUTHORITY", "", "METHOD_TRIGGER_FEEDBACK", "METHOD_TRIGGER_FEEDBACK_CUSTOM_FILES", "TAG", "appInfoProvider", "Lcom/obric/feedback/sdk/IAppInfoProvider;", "application", "Landroid/app/Application;", "logger", "Lcom/obric/feedback/sdk/IFeedbackSdkLogger;", "getAppInfoProvider", "getAppInfoProvider$feedbacksdk_release", "getLogger", "init", "", "provider", "triggerContactsFeedbackWithEncryption", "Landroid/os/Bundle;", "problemDesc", "audioPathList", "", "logFilePathList", "suppressNotification", "", "triggerFeedback", "customFilePathList", "feedbacksdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FeedbackSdk {
    private static final String FEEDBACK_PROVIDER_AUTHORITY = "com.obric.feedback.provider";
    public static final FeedbackSdk INSTANCE = null;
    private static final String METHOD_TRIGGER_FEEDBACK = "trigger_feedback";
    private static final String METHOD_TRIGGER_FEEDBACK_CUSTOM_FILES = "trigger_feedback_custom_files";
    private static final String TAG = "FeedbackSdk";
    private static IAppInfoProvider appInfoProvider;
    private static Application application;
    private static IFeedbackSdkLogger logger;

    static {
        INSTANCE = new FeedbackSdk();
    }

    public final Bundle triggerContactsFeedbackWithEncryption(String r9, List<String> r10, List<String> r11) {
        Intrinsics.checkNotNullParameter(r9, "problemDesc");
        return triggerContactsFeedbackWithEncryption$default(this, r9, r10, r11, false, 8, null);
    }

    private FeedbackSdk() {
    }

    public final void init(Application r1, IAppInfoProvider r2, IFeedbackSdkLogger r3) {
        Intrinsics.checkNotNullParameter(r1, "application");
        Intrinsics.checkNotNullParameter(r2, "provider");
        Intrinsics.checkNotNullParameter(r3, "logger");
        application = r1;
        appInfoProvider = r2;
        logger = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Bundle triggerFeedback$default(FeedbackSdk r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.triggerFeedback(r1, r2);
    }

    public final Bundle triggerFeedback(String r19, List<String> r20) {
        Intrinsics.checkNotNullParameter(r19, "problemDesc");
        Application r1 = application;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getPackageName();
    L6:
        String r4 = r3;
        boolean r5 = true;
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L20;
        IFeedbackSdkLogger r0 = logger;
        if (r0 == null) goto L18;
        r0.e(TAG, "package name is null");
    L18:
        Bundle r7 = new Bundle();
        r7.putBoolean("success", false);
        r7.putString(KvConstant.KV_SYNC_ERROR_MSG, "package name is null");
        return r7;
    L20:
        Application r8 = application;
        if (r8 == null) goto L25;
        ContentResolver r9 = r8.getContentResolver();
        if (r9 == null) goto L25;
        ContentProviderClient r10 = r9.acquireUnstableContentProviderClient(FEEDBACK_PROVIDER_AUTHORITY);
    L26:
        if (r10 != null) goto L32;
        IFeedbackSdkLogger r11 = logger;
        if (r11 == null) goto L30;
        r11.e(TAG, "acquire content provider client failed");
    L30:
        Bundle r12 = new Bundle();
        r12.putBoolean("success", false);
        r12.putString(KvConstant.KV_SYNC_ERROR_MSG, "acquire content provider client failed");
        return r12;
    L32:
        Bundle r13 = new Bundle();
        r13.putString("from_package", r3);
        r13.putString("problem_desc", r19);
        if (r20 == null) goto L36;
        ArrayList<String> r14 = (ArrayList) CollectionsKt.toCollection(r20, new ArrayList());
        if (r14 == null) goto L36;
    L37:
        r13.putStringArrayList("file_path_list", r14);
        IAppInfoProvider r15 = appInfoProvider;
        if (r15 == null) goto L40;
        String r16 = r15.getUid();
    L41:
        String r17 = r16;
        if (r17 != null) goto L44;
    L47:
        boolean r18 = true;
    L48:
        if (r18 == true) goto L54;
        IAppInfoProvider r21 = appInfoProvider;
        if (r21 == null) goto L52;
        String r22 = r21.getUid();
    L53:
        r13.putString("user_id", r22);
        goto L54
    L52:
        r22 = null;
    L54:
        IAppInfoProvider r23 = appInfoProvider;
        if (r23 == null) goto L57;
        String r24 = r23.getDid();
    L58:
        String r25 = r24;
        if (r25 != null) goto L61;
    L64:
        if (r5 == true) goto L70;
        IAppInfoProvider r26 = appInfoProvider;
        if (r26 == null) goto L68;
        String r27 = r26.getDid();
    L69:
        r13.putString("device_id", r27);
        goto L70
    L68:
        r27 = null;
    L70:
        IAppInfoProvider r28 = appInfoProvider;
        if (r28 == null) goto L73;
        long r29 = r28.getTraceContentTimeWindow();
    L74:
        r13.putLong("trace_time_window", r29);
        IFeedbackSdkLogger r30 = logger;
        if (r30 == null) goto L77;
        r30.i(TAG, "trigger feedback, extras: " + r13);
    L77:
        Bundle r31 = r10.call(METHOD_TRIGGER_FEEDBACK, r19, r13);
        IFeedbackSdkLogger r32 = logger;
        if (r32 == null) goto L80;
        r32.i(TAG, "trigger feedback result: " + r31);
    L80:
        r10.close();
        StringBuilder r33 = new StringBuilder("trigger feedback result: ");
        if (r31 == null) goto L85;
        Set<String> r34 = r31.keySet();
        if (r34 == null) goto L85;
        r2 = CollectionsKt.joinToString$default(r34, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null);
    L85:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r33.append(r2).toString());
        return r31;
    L73:
        r29 = 0;
        goto L74
    L61:
        if (r25.length() == 0) goto L64;
        r5 = false;
        goto L64
    L57:
        r24 = null;
        goto L58
    L44:
        if (r17.length() == 0) goto L47;
        r18 = false;
        goto L48
    L40:
        r16 = null;
    L36:
        r14 = new ArrayList();
    L25:
        r10 = null;
        goto L26
    L9:
        if (r4.length() == 0) goto L12;
        r6 = false;
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    public static /* synthetic */ Bundle triggerContactsFeedbackWithEncryption$default(FeedbackSdk r0, String r1, List r2, List r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.triggerContactsFeedbackWithEncryption(r1, r2, r3, r4);
    }

    public final Bundle triggerContactsFeedbackWithEncryption(String r12, List<String> r13, List<String> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "problemDesc");
        IFeedbackSdkLogger r11 = logger;
        if (r11 == null) goto L5;
        r11.i(TAG, "triggerFeedbackCustomFiles called with problemDesc: " + r12 + ", customFilePathList: " + r14);
    L5:
        Application r16 = application;
        String r1 = null;
        if (r16 == null) goto L8;
        String r17 = r16.getPackageName();
    L9:
        String r2 = r17;
        boolean r3 = true;
        if (r2 != null) goto L12;
    L15:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L23;
        IFeedbackSdkLogger r18 = logger;
        if (r18 == null) goto L21;
        r18.e(TAG, "package name is null");
    L21:
        Bundle r19 = new Bundle();
        r19.putBoolean("success", false);
        r19.putString(KvConstant.KV_SYNC_ERROR_MSG, "package name is null");
        return r19;
    L23:
        Application r5 = application;
        if (r5 == null) goto L28;
        ContentResolver r6 = r5.getContentResolver();
        if (r6 == null) goto L28;
        ContentProviderClient r7 = r6.acquireUnstableContentProviderClient(FEEDBACK_PROVIDER_AUTHORITY);
    L29:
        if (r7 != null) goto L35;
        IFeedbackSdkLogger r110 = logger;
        if (r110 == null) goto L33;
        r110.e(TAG, "acquire content provider client failed");
    L33:
        Bundle r111 = new Bundle();
        r111.putBoolean("success", false);
        r111.putString(KvConstant.KV_SYNC_ERROR_MSG, "acquire content provider client failed");
        return r111;
    L35:
        Bundle r8 = new Bundle();
        r8.putString("from_package", r17);
        r8.putString("problem_desc", r12);
        if (r14 == null) goto L39;
        ArrayList<String> r112 = (ArrayList) CollectionsKt.toCollection(r14, new ArrayList());
        if (r112 == null) goto L39;
    L40:
        r8.putStringArrayList("file_path_list", r112);
        if (r13 == null) goto L44;
        ArrayList<String> r113 = (ArrayList) CollectionsKt.toCollection(r13, new ArrayList());
        if (r113 == null) goto L44;
    L45:
        r8.putStringArrayList("audio_file_path_list", r113);
        IAppInfoProvider r114 = appInfoProvider;
        if (r114 == null) goto L48;
        String r115 = r114.getUid();
    L49:
        String r116 = r115;
        if (r116 != null) goto L52;
    L55:
        boolean r117 = true;
    L56:
        if (r117 == true) goto L62;
        IAppInfoProvider r118 = appInfoProvider;
        if (r118 == null) goto L60;
        String r119 = r118.getUid();
    L61:
        r8.putString("user_id", r119);
        goto L62
    L60:
        r119 = null;
    L62:
        IAppInfoProvider r120 = appInfoProvider;
        if (r120 == null) goto L65;
        String r121 = r120.getDid();
    L66:
        String r122 = r121;
        if (r122 != null) goto L69;
    L72:
        if (r3 == true) goto L78;
        IAppInfoProvider r123 = appInfoProvider;
        if (r123 == null) goto L76;
        String r124 = r123.getDid();
    L77:
        r8.putString("device_id", r124);
        goto L78
    L76:
        r124 = null;
    L78:
        IAppInfoProvider r125 = appInfoProvider;
        if (r125 == null) goto L81;
        long r126 = r125.getTraceContentTimeWindow();
    L82:
        r8.putLong("trace_time_window", r126);
        r8.putBoolean("suppress_notification", r15);
        IFeedbackSdkLogger r127 = logger;
        if (r127 == null) goto L85;
        r127.i(TAG, "trigger feedback custom files, extras: " + r8);
    L85:
        Bundle r128 = r7.call(METHOD_TRIGGER_FEEDBACK_CUSTOM_FILES, r12, r8);
        IFeedbackSdkLogger r129 = logger;
        if (r129 == null) goto L88;
        r129.i(TAG, "trigger feedback custom files result: " + r128);
    L88:
        r7.close();
        StringBuilder r130 = new StringBuilder("trigger feedback custom files result: ");
        if (r128 == null) goto L93;
        Set<String> r131 = r128.keySet();
        if (r131 == null) goto L93;
        r1 = CollectionsKt.joinToString$default(r131, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null);
    L93:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r130.append(r1).toString());
        return r128;
    L81:
        r126 = 0;
        goto L82
    L69:
        if (r122.length() == 0) goto L72;
        r3 = false;
        goto L72
    L65:
        r121 = null;
        goto L66
    L52:
        if (r116.length() == 0) goto L55;
        r117 = false;
        goto L56
    L48:
        r115 = null;
    L44:
        r113 = new ArrayList();
    L39:
        r112 = new ArrayList();
    L28:
        r7 = null;
        goto L29
    L12:
        if (r2.length() == 0) goto L15;
        r4 = false;
        goto L17
    L8:
        r17 = null;
        goto L9
    }

    public final IAppInfoProvider getAppInfoProvider$feedbacksdk_release() {
        return appInfoProvider;
    }

    public final IFeedbackSdkLogger getLogger() {
        return logger;
    }
}
