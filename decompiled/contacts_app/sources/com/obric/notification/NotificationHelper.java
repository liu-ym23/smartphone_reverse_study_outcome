package com.obric.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.PendingIntentCompat;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.Intelligentcall.activity.IntelligentSettingsActivity;
import com.obric.callsummary.bean.CallSummary;
import com.obric.model.CallFeatureModel;
import com.obric.model.bean.CallFeatureBean;
import com.obric.utils.CallContactInfoUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0006J$\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0006J9\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010#\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/notification/NotificationHelper;", "", "()V", "MAX_CONTENT_LENGTH", "", "NOTIFICATION_ICON_BADGE_SHOW", "", "RECORD_DONE_NOTIFICATION_CHANNEL_ID", "SMALL_ICON_USE_APP_ICON", "STATUS_BAR_USE_APP_ICON", "TAG", "callCreateTimePhoneNumber2notificationId", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "", "callSummaryFinishedListeners", "Lcom/obric/model/CallFeatureModel$CallSummaryFinishedListener;", "recordDoneNotificationId", "cancelAllRecordNotification", "", "context", "Landroid/content/Context;", "cancelRecordNotification", "callCreateTime", "phoneNumber", "getSummaryText", "callSummaryTitle", "callSummary", "sendCallNotification", "sendNotification", "sendRecordDoneNotification", "id", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "truncateString", "text", "maxLength", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NotificationHelper {
    public static final NotificationHelper INSTANCE = null;
    private static final int MAX_CONTENT_LENGTH = 20;
    private static final String NOTIFICATION_ICON_BADGE_SHOW = "obric_notif_icon_badge_show";
    private static final String RECORD_DONE_NOTIFICATION_CHANNEL_ID = "record_done_notification_channel";
    public static final String SMALL_ICON_USE_APP_ICON = "small_icon_use_app_icon";
    public static final String STATUS_BAR_USE_APP_ICON = "status_bar_use_app_icon";
    private static final String TAG = "NotificationHelper";
    private static final ConcurrentHashMap<Pair<Long, String>, Integer> callCreateTimePhoneNumber2notificationId = null;
    private static final ConcurrentHashMap<Pair<Long, String>, CallFeatureModel.CallSummaryFinishedListener> callSummaryFinishedListeners = null;
    private static int recordDoneNotificationId;

    private NotificationHelper() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getCallCreateTimePhoneNumber2notificationId$p() {
        return callCreateTimePhoneNumber2notificationId;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getCallSummaryFinishedListeners$p() {
        return callSummaryFinishedListeners;
    }

    public static final /* synthetic */ int access$getRecordDoneNotificationId$p() {
        return recordDoneNotificationId;
    }

    public static final /* synthetic */ String access$getSummaryText(NotificationHelper r0, Context r1, String r2, String r3) {
        return r0.getSummaryText(r1, r2, r3);
    }

    public static final /* synthetic */ void access$sendRecordDoneNotification(NotificationHelper r0, Context r1, long r2, String r4, String r5, Integer r6) {
        r0.sendRecordDoneNotification(r1, r2, r4, r5, r6);
    }

    public static final /* synthetic */ void access$setRecordDoneNotificationId$p(int r0) {
        recordDoneNotificationId = r0;
    }

    static {
        INSTANCE = new NotificationHelper();
        callCreateTimePhoneNumber2notificationId = new ConcurrentHashMap();
        callSummaryFinishedListeners = new ConcurrentHashMap(4, 0.9f, 1);
    }

    static /* synthetic */ String truncateString$default(NotificationHelper r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 20;
    L6:
        return r0.truncateString(r1, r2);
    }

    private final String truncateString(String r3, int r4) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if (r3.length() <= r4) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        String r5 = r3;
    L10:
        if (r5 == null) goto L17;
        StringBuilder r1 = new StringBuilder();
        String r6 = r5.substring(0, r4);
        Intrinsics.checkNotNullExpressionValue(r6, "substring(...)");
        String r7 = r1.append(r6).append("...").toString();
        if (r7 != null) goto L15;
        return r3;
    L15:
        return r7;
    L17:
        return r3;
    L9:
        r5 = null;
        goto L10
    L6:
        r2 = false;
        goto L7
    }

    public final void sendNotification(final Context r10, final long r11, final String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "phoneNumber");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "sendNotification");
        if (CallFeatureModel.INSTANCE.getSummarizingDataSet().contains(new Pair(Long.valueOf(r11), r13)) == false) goto L5;
        CallFeatureModel.CallSummaryFinishedListener r0 = new NotificationHelper$sendNotification$listener$1(r11, r13, r10);
        callSummaryFinishedListeners.put(new Pair(Long.valueOf(r11), r13), r0);
        CallFeatureModel.INSTANCE.addCallSummaryFinishedListener(r0);
        sendRecordDoneNotification(r10, r11, r13, r10.getString(R.string.intelligent_call_done_notification_content_loading), null);
        return;
    L5:
        CallFeatureBean r1 = CallFeatureModel.INSTANCE.getCallFeature(r11, r13);
        String r2 = null;
        if (r1 == null) goto L10;
        CallSummary r3 = r1.getSummary();
        if (r3 == null) goto L10;
        String r4 = r3.getTitle();
    L11:
        CallFeatureBean r5 = CallFeatureModel.INSTANCE.getCallFeature(r11, r13);
        if (r5 == null) goto L16;
        CallSummary r6 = r5.getSummary();
        if (r6 == null) goto L16;
        r2 = r6.getSummary();
    L16:
        sendRecordDoneNotification(r10, r11, r13, getSummaryText(r10, r4, r2), null);
        return;
    L10:
        r4 = null;
        goto L11
    }

    public final void cancelRecordNotification(Context r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "phoneNumber");
        ConcurrentHashMap<Pair<Long, String>, CallFeatureModel.CallSummaryFinishedListener> r2 = callSummaryFinishedListeners;
        CallFeatureModel.CallSummaryFinishedListener r0 = r2.get(new Pair(Long.valueOf(r4), r6));
        if (r0 == null) goto L5;
        CallFeatureModel.INSTANCE.removeCallSummaryFinishedListener(r0);
    L5:
        r2.remove(new Pair(Long.valueOf(r4), r6));
        ConcurrentHashMap<Pair<Long, String>, Integer> r5 = callCreateTimePhoneNumber2notificationId;
        Integer r1 = r5.get(new Pair(Long.valueOf(r4), r6));
        if (r1 == null) goto L8;
        Object r7 = r3.getSystemService("notification");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) r7).cancel(r1.intValue());
    L8:
        r5.remove(new Pair(Long.valueOf(r4), r6));
    }

    public final void cancelAllRecordNotification(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ConcurrentHashMap<Pair<Long, String>, Integer> r2 = callCreateTimePhoneNumber2notificationId;
        if (r2.isEmpty() == true) goto L5;
    L7:
        Object r4 = r3.getSystemService("notification");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager r5 = (NotificationManager) r4;
        Collection<Integer> r6 = r2.values();
        Intrinsics.checkNotNullExpressionValue(r6, "callCreateTimePhoneNumber2notificationId.values");
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        Integer r0 = (Integer) r7.next();
        Intrinsics.checkNotNullExpressionValue(r0, "it");
        r5.cancel(r0.intValue());
        goto L9
    L11:
        Collection<CallFeatureModel.CallSummaryFinishedListener> r8 = callSummaryFinishedListeners.values();
        Intrinsics.checkNotNullExpressionValue(r8, "callSummaryFinishedListeners.values");
        Iterator<T> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        CallFeatureModel.CallSummaryFinishedListener r10 = (CallFeatureModel.CallSummaryFinishedListener) r9.next();
        CallFeatureModel r1 = CallFeatureModel.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r10, "it");
        r1.removeCallSummaryFinishedListener(r10);
        goto L13
    L15:
        callSummaryFinishedListeners.clear();
        return;
    L5:
        if (callSummaryFinishedListeners.isEmpty() == false) goto L7;
    }

    public final void sendCallNotification(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r4 = r5.getSystemService("notification");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager r6 = (NotificationManager) r4;
        r6.createNotificationChannel(new NotificationChannel(RECORD_DONE_NOTIFICATION_CHANNEL_ID, "incall", 3));
        Intent r0 = new Intent(r5, IntelligentSettingsActivity.class);
        r0.setFlags(268435456);
        Unit r1 = Unit.INSTANCE;
        PendingIntent r2 = PendingIntentCompat.getActivity(r5, 0, r0, 201326592, false);
        Intrinsics.checkNotNullExpressionValue(r2, "getActivity(\n           …          false\n        )");
        Notification r7 = new NotificationCompat.Builder(r5, RECORD_DONE_NOTIFICATION_CHANNEL_ID).setSmallIcon(R.drawable.ic_o).setContentTitle(r5.getString(R.string.intelligent_notification_title)).setContentText(r5.getString(R.string.intelligent_notification_msg)).setContentIntent(r2).setAutoCancel(true).build();
        Intrinsics.checkNotNullExpressionValue(r7, "Builder(context, RECORD_…\n                .build()");
        r6.notify(0, r7);
    }

    private final String getSummaryText(Context r7, String r8, String r9) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getSummaryText call");
        String r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        String r6 = r7.getString(R.string.intelligent_call_done_notification_content, new Object[]{truncateString$default(this, r8, 0, 2, null)});
        Intrinsics.checkNotNullExpressionValue(r6, "{\n            context.ge…lSummaryTitle))\n        }");
        return r6;
    L12:
        String r10 = r9;
        if (r10 != null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        if (r11 == true) goto L21;
        String r12 = r7.getString(R.string.intelligent_call_done_notification_content, new Object[]{truncateString$default(this, r9, 0, 2, null)});
        Intrinsics.checkNotNullExpressionValue(r12, "{\n            context.ge…g(callSummary))\n        }");
        return r12;
    L21:
        String r13 = r7.getString(R.string.intelligent_call_done_notification_content_default);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n            context.ge…ontent_default)\n        }");
        return r13;
    L15:
        if (r10.length() == 0) goto L18;
        r11 = false;
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final void sendRecordDoneNotification(final Context r13, final long r14, final String r16, final String r17, final Integer r18) {
        Object r0 = r13.getSystemService("notification");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        final NotificationManager r8 = (NotificationManager) r0;
        r8.createNotificationChannel(new NotificationChannel(RECORD_DONE_NOTIFICATION_CHANNEL_ID, "incall", 3));
        if (r18 == null) goto L5;
        int r1 = r18.intValue();
    L6:
        final int r6 = r1;
        new CallContactInfoUtils(r13).getContact(r16, new AnonymousClass1(this, r16, r13, r14, r6, r17, r8, r18));
        return;
    L5:
        r1 = recordDoneNotificationId;
        goto L6
    }
}
