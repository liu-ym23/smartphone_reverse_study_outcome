package com.obric.callsummary.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.GlobalProxyLancet;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.contactprovider.tableinfo.CallFeature;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.settings.SettingsProviderHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: compiled from: CallSummaryWidget.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J \u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001fJG\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"0!2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\u001a\u0010+\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0012H\u0007J$\u0010/\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u000201H\u0007J\u0018\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u0004H\u0007J\u0010\u00106\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/callsummary/widget/CallSummaryWidget;", "", "()V", "ACTION_WIDGET_SWITCH_ON", "", "BROADCAST_TARGET_PACKAGE_NAME", "INTENT_PARAMS_CALL_SUMMARY_ID", "PROVIDER_BUNDLE_DATA_DATA_ID_TAG", "PROVIDER_BUNDLE_PARAMS_DATA", "PROVIDER_BUNDLE_PARAMS_DATA_CREATE_TIME", "PROVIDER_BUNDLE_PARAMS_DATA_ID", "PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY", "PROVIDER_BUNDLE_PARAMS_EXTRAS_END_TIME", "PROVIDER_BUNDLE_PARAMS_EXTRAS_START_TIME", "PROVIDER_BUNDLE_PARAMS_SRC_APP", "TAG", "switchUpdateListeners", "", "Lcom/obric/callsummary/widget/CallSummaryWidget$SettingsSwitchUpdateListener;", "findAllCallSummary", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "getCallCreateTimeAndPhoneNumber", "Lkotlin/Pair;", CallFeatureEntityUtilKt.PARAM_KEY_CALL_FlAG, "getCallCreateTimeSection", "", "(Landroid/os/Bundle;)[Ljava/lang/String;", "getCallFeatureEntity", "", "Lkotlin/Triple;", "contentResolver", "Landroid/content/ContentResolver;", CallLogListAdapter.PAYLOAD_SELECTION, "selectionArgs", "(Landroid/content/ContentResolver;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "getEndOfTodayTimestamp", "", "getStartOfTodayTimestamp", "getWidgetDate", "removeSwitchUpdateListener", "", "listener", "setCallSummaryAndRecordSwitchOn", "summaryOn", "", "recordOn", "setCallTag", "callCreate", "phoneNumber", "setSwitchUpdateListener", "SettingsSwitchUpdateListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryWidget {
    public static final String ACTION_WIDGET_SWITCH_ON = "com.bytedance.obric.airecordassistant.ACTION_ENABLE_WIDGET";
    public static final String BROADCAST_TARGET_PACKAGE_NAME = "com.bytedance.obric.airecordassistant";
    public static final CallSummaryWidget INSTANCE = null;
    public static final String INTENT_PARAMS_CALL_SUMMARY_ID = "summary_id";
    public static final String PROVIDER_BUNDLE_DATA_DATA_ID_TAG = "@@";
    public static final String PROVIDER_BUNDLE_PARAMS_DATA = "data";
    public static final String PROVIDER_BUNDLE_PARAMS_DATA_CREATE_TIME = "create_time";
    public static final String PROVIDER_BUNDLE_PARAMS_DATA_ID = "id";
    public static final String PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY = "summary";
    public static final String PROVIDER_BUNDLE_PARAMS_EXTRAS_END_TIME = "end_time";
    public static final String PROVIDER_BUNDLE_PARAMS_EXTRAS_START_TIME = "start_time";
    public static final String PROVIDER_BUNDLE_PARAMS_SRC_APP = "src_app";
    public static final String TAG = "CallSummaryWidget";
    private static final List<SettingsSwitchUpdateListener> switchUpdateListeners = null;

    /* JADX INFO: compiled from: CallSummaryWidget.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/callsummary/widget/CallSummaryWidget$SettingsSwitchUpdateListener;", "", "onSwitchUpdate", "", "summaryOn", "", "recordOn", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SettingsSwitchUpdateListener {

        /* JADX INFO: compiled from: CallSummaryWidget.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onSwitchUpdate$default(SettingsSwitchUpdateListener r1, boolean r2, boolean r3, int r4, Object r5) {
                if (r5 != null) goto L12;
                if ((r4 & 1) == 0) goto L7;
                r2 = true;
            L7:
                if ((r4 & 2) == 0) goto L9;
                r3 = true;
            L9:
                r1.onSwitchUpdate(r2, r3);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSwitchUpdate");
            }
        }

        void onSwitchUpdate(boolean r1, boolean r2);
    }

    /* JADX INFO: renamed from: com.obric.callsummary.widget.CallSummaryWidget$findAllCallSummary$1, reason: invalid class name */
    /* JADX INFO: compiled from: CallSummaryWidget.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.widget.CallSummaryWidget$findAllCallSummary$1", f = "CallSummaryWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<String>>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Bundle $extras;
        int label;

        AnonymousClass1(Context r1, Bundle r2, Continuation<? super AnonymousClass1> r3) {
            this.$context = r1;
            this.$extras = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$context, this.$extras, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super ArrayList<String>> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super ArrayList<String>> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L28;
            ResultKt.throwOnFailure(r6);
            CallSummaryWidget r7 = CallSummaryWidget.INSTANCE;
            ContentResolver r0 = this.$context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(r0, "context.contentResolver");
            List r5 = CallSummaryWidget.access$getCallFeatureEntity(r7, r0, CallFeature.CALL_CREATE_TIME + " >= ? AND " + CallFeature.CALL_CREATE_TIME + " <= ?", CallSummaryWidget.access$getCallCreateTimeSection(CallSummaryWidget.INSTANCE, this.$extras));
            ArrayList r8 = new ArrayList();
            if (r5.isEmpty() == false) goto L7;
            return r8;
        L7:
            Iterator r9 = r5.iterator();
        L9:
            if (r9.hasNext() == false) goto L26;
            Triple r1 = (Triple) r9.next();
            boolean r2 = true;
            if (((CharSequence) r1.getFirst()).length() <= 0) goto L13;
            boolean r3 = true;
        L14:
            if (r3 == false) goto L9;
            if (((CharSequence) r1.getSecond()).length() <= 0) goto L18;
            boolean r4 = true;
        L19:
            if (r4 == false) goto L9;
            if (((CharSequence) r1.getThird()).length() > 0) goto L24;
            r2 = false;
        L24:
            if (r2 == false) goto L9;
            JSONObject r10 = new JSONObject();
            r10.put("id", CallSummaryWidget.setCallTag(Long.parseLong((String) r1.getFirst()), (String) r1.getSecond()));
            r10.put(CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_CREATE_TIME, Long.parseLong((String) r1.getFirst()));
            r10.put(CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, r1.getThird());
            r8.add(r10.toString());
            goto L9
        L18:
            r4 = false;
            goto L19
        L13:
            r3 = false;
            goto L14
        L26:
            return r8;
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.callsummary.widget.CallSummaryWidget$getWidgetDate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallSummaryWidget.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.widget.CallSummaryWidget$getWidgetDate$1", f = "CallSummaryWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Bundle $extras;
        int label;

        C02431(Context r1, Bundle r2, Continuation<? super C02431> r3) {
            this.$context = r1;
            this.$extras = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02431(this.$context, this.$extras, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Bundle> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Bundle> r2) {
            return ((C02431) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            Bundle r4 = new Bundle();
            r4.putString(CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_SRC_APP, "com.android.contacts");
            r4.putStringArrayList("data", CallSummaryWidget.access$findAllCallSummary(CallSummaryWidget.INSTANCE, this.$context, this.$extras));
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallSummaryWidget.TAG, "data bundle " + r4);
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private CallSummaryWidget() {
    }

    public static final /* synthetic */ ArrayList access$findAllCallSummary(CallSummaryWidget r0, Context r1, Bundle r2) {
        return r0.findAllCallSummary(r1, r2);
    }

    public static final /* synthetic */ String[] access$getCallCreateTimeSection(CallSummaryWidget r0, Bundle r1) {
        return r0.getCallCreateTimeSection(r1);
    }

    public static final /* synthetic */ List access$getCallFeatureEntity(CallSummaryWidget r0, ContentResolver r1, String r2, String[] r3) {
        return r0.getCallFeatureEntity(r1, r2, r3);
    }

    static {
        INSTANCE = new CallSummaryWidget();
        switchUpdateListeners = new ArrayList();
    }

    @JvmStatic
    public static final Bundle getWidgetDate(Context r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return (Bundle) BuildersKt.runBlocking(Dispatchers.getIO(), new C02431(r3, r4, null));
    }

    @JvmStatic
    public static final Pair<String, String> getCallCreateTimeAndPhoneNumber(String r8) {
        String r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "getCallCreateTimeAndPhoneNumber callFlag is null or blank, return null.");
        return null;
    L13:
        List r2 = StringsKt.split$default(r0, new String[]{"@@"}, false, 0, 6, null);
        if (r2.size() == 2) goto L17;
        return null;
    L17:
        return new Pair(r2.get(0), r2.get(1));
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    @JvmStatic
    public static final String setCallTag(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
        return r1 + "@@" + r3;
    }

    public static /* synthetic */ void setCallSummaryAndRecordSwitchOn$default(Context r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = true;
    L8:
        setCallSummaryAndRecordSwitchOn(r1, r2, r3);
    }

    @JvmStatic
    public static final void setCallSummaryAndRecordSwitchOn(Context r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "setCallSummaryAndRecordSwitchOn call");
        SharedPreferences r0 = PreferenceManager.getDefaultSharedPreferences(r3);
        if (r0.getBoolean("should_show_tutorial_popup", true) == false) goto L6;
        if (r4 == false) goto L6;
        r0.edit().putBoolean("should_show_tutorial_popup", false).apply();
    L6:
        SettingsProviderHelper.INSTANCE.setAutoRecordEnabled(r3, r5);
        Iterator<SettingsSwitchUpdateListener> r6 = switchUpdateListeners.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r6.next().onSwitchUpdate(r4, r5);
        goto L8
    }

    @JvmStatic
    public static final void setSwitchUpdateListener(SettingsSwitchUpdateListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        switchUpdateListeners.add(r1);
    }

    @JvmStatic
    public static final void removeSwitchUpdateListener(SettingsSwitchUpdateListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        switchUpdateListeners.remove(r1);
    }

    private final ArrayList<String> findAllCallSummary(Context r3, Bundle r4) {
        return (ArrayList) BuildersKt.runBlocking(Dispatchers.getIO(), new AnonymousClass1(r3, r4, null));
    }

    private final String[] getCallCreateTimeSection(Bundle r8) {
        long r0 = getStartOfTodayTimestamp();
        long r2 = getEndOfTodayTimestamp();
        if (r8 == null) goto L5;
        CallSummaryWidget r7 = INSTANCE;
        r0 = r8.getLong("start_time", r7.getStartOfTodayTimestamp());
        r2 = r8.getLong("end_time", r7.getEndOfTodayTimestamp());
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getCallCreateTimeSection startTime: " + r0 + ", endTime: " + r2);
        String[] r9 = new String[2];
        int r5 = 0;
    L6:
        if (r5 >= 2) goto L8;
        r9[r5] = "";
        r5 = r5 + 1;
        goto L6
    L8:
        r9[0] = String.valueOf(r0);
        r9[1] = String.valueOf(r2);
        return r9;
    }

    private final List<Triple<String, String, String>> getCallFeatureEntity(ContentResolver r11, String r12, String[] r13) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getCallFeatureEntity selection: " + r12 + ", selectionArgs: " + r13);
        ArrayList r0 = new ArrayList();
        Cursor r14 = r11.query(ObricCallLogProviderHelper.INSTANCE.getCallFeatureUri(), null, r12, r13, null, null);
        if (r14 == null) goto L56;
        Cursor r15 = r14;
        Cursor r16 = r15;     // Catch: Throwable -> L50
        if (r16.moveToFirst() == true) goto L10;
        ArrayList r1 = r0;     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r15, null);
        return r1;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getCallFeatureEntity count: " + r16.getCount());     // Catch: Throwable -> L50
    L11:
        int r10 = r16.getColumnIndex(CallFeature.CALL_CREATE_TIME);     // Catch: Throwable -> L50
        int r17 = r16.getColumnIndex(CallFeature.PHONE_NUMBER);     // Catch: Throwable -> L50
        int r3 = r16.getColumnIndex(CallFeature.SUMMARY);     // Catch: Throwable -> L50
        if (r3 == (-1)) goto L47;
        if (r10 == (-1)) goto L47;
        if (r17 == (-1)) goto L47;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L28
        String r18 = r16.getString(r10);     // Catch: Throwable -> L28
        String r19 = r16.getString(r17);     // Catch: Throwable -> L26
        String r5 = r16.getString(r3);     // Catch: Throwable -> L24
        Object r6 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L32:
        Throwable r7 = Result.m806exceptionOrNullimpl(r6);     // Catch: Throwable -> L50
        if (r7 == null) goto L37;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get data error:", r7);     // Catch: Throwable -> L50
    L37:
        if (r18 != null) goto L39;
        r18 = "";
    L39:
        if (r19 != null) goto L41;
        r19 = "";
    L41:
        if (r5 != null) goto L43;
        r5 = "";
    L43:
        r0.add(new Triple(r18, r19, r5));     // Catch: Throwable -> L50
        if (r16.moveToNext() == true) goto L11;
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r15, null);
    L22:
        th = th;
    L31:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L50
        r6 = Result.m803constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L50
    L24:
        th = th;
        r5 = null;
    L26:
        th = th;
        r19 = null;
    L30:
        r5 = r19;
    L28:
        th = th;
        r18 = null;
        r19 = null;
    L47:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get index error! Return.");     // Catch: Throwable -> L50
        ArrayList r2 = r0;     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r15, null);
        return r2;
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L56:
        return r0;
    }

    private final long getStartOfTodayTimestamp() {
        Calendar r2 = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(r2, "getInstance()");
        r2.set(11, 0);
        r2.set(12, 0);
        r2.set(13, 0);
        r2.set(14, 0);
        return r2.getTimeInMillis();
    }

    private final long getEndOfTodayTimestamp() {
        Calendar r2 = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(r2, "getInstance()");
        r2.set(11, 23);
        r2.set(12, 59);
        r2.set(13, 59);
        r2.set(14, 999);
        return r2.getTimeInMillis();
    }
}
