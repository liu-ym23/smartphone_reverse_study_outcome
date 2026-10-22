package com.obric.contactprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.calllog.ContactInfo;
import com.android.contacts.calllog.ContactInfoHelper;
import com.android.contacts.calllog.blocked.data.BlockedCallEntity;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.widget.CallSummaryWidget;
import com.obric.contactprovider.bean.CallSummaryASRMessageBean;
import com.obric.contactprovider.tableinfo.CallFeature;
import com.obric.contactprovider.tableinfo.CallSummaryASRMessage;
import com.obric.contactprovider.tableinfo.RecordASRMessage;
import com.obric.contactprovider.tableinfo.RecordInfo;
import com.obric.database.entity.CallFeatureEntity;
import com.obric.database.entity.RecordASRMessageEntity;
import com.obric.database.entity.RecordInfoEntity;
import com.obric.settings.SettingsProviderHelper;
import com.obric.utils.GlobalUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ObricCallLogProviderHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$J\u0016\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020*J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0,2\u0006\u0010-\u001a\u00020.J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020&0,2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0004\u0018\u00010$2\u0006\u0010-\u001a\u00020.J$\u00103\u001a\b\u0012\u0004\u0012\u00020\"0,2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020\u0004J5\u00103\u001a\b\u0012\u0004\u0012\u00020\"0,2\u0006\u0010-\u001a\u00020.2\b\u00105\u001a\u0004\u0018\u00010\u00042\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000107H\u0002¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0002J$\u0010<\u001a\b\u0012\u0004\u0012\u00020=0,2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020\u0004J@\u0010>\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0,\u0012\u0004\u0012\u00020\u000b0?2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000bJ$\u0010B\u001a\b\u0012\u0004\u0012\u00020C0,2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020\u0004J$\u0010D\u001a\b\u0012\u0004\u0012\u00020&0,2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020\u0004J5\u0010D\u001a\b\u0012\u0004\u0012\u00020&0,2\u0006\u0010-\u001a\u00020.2\b\u00105\u001a\u0004\u0018\u00010\u00042\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000107H\u0002¢\u0006\u0002\u00108J\u0010\u0010E\u001a\u00020F2\u0006\u0010-\u001a\u00020.H\u0002J&\u0010G\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010H\u001a\u0002012\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bJ3\u0010I\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010J\u001a\u00020K2\u0006\u00105\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000407H\u0002¢\u0006\u0002\u0010LJ\u001e\u0010M\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010H\u001a\u0002012\u0006\u0010N\u001a\u00020OR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001c\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u001f\u0010\u0015¨\u0006P"}, d2 = {"Lcom/obric/contactprovider/ObricCallLogProviderHelper;", "", "()V", "AUTHORITY", "", "CALL_FEATURE_ADD_STATUS_PARAM_KEY", "CALL_FEATURE_PATH", "CALL_FEATURE_REMOVE_STATUS_PARAM_KEY", "CALL_FEATURE_UPDATE_STATUS_PARAM_KEY", "CALL_SUMMARY_ASR_MESSAGE_PATH", "OWNER_AI", "", "OWNER_OTHER", "OWNER_SELF", "RECORD_ASR_MESSAGE_PATH", "RECORD_INFO_PATH", "SCHEME_CONTENT", "TAG", "callFeatureUri", "Landroid/net/Uri;", "getCallFeatureUri", "()Landroid/net/Uri;", "callFeatureUri$delegate", "Lkotlin/Lazy;", "callSummaryASRMessageUri", "getCallSummaryASRMessageUri", "callSummaryASRMessageUri$delegate", "recordASRMessageUri", "getRecordASRMessageUri", "recordASRMessageUri$delegate", "recordInfoUri", "getRecordInfoUri", "recordInfoUri$delegate", "callFeatureCursor2Entity", "Lcom/obric/database/entity/CallFeatureEntity;", "cursor", "Landroid/database/Cursor;", "cursor2Entity", "Lcom/obric/database/entity/RecordInfoEntity;", "cursorToBlockedCallEntity", "Lcom/android/contacts/calllog/blocked/data/BlockedCallEntity;", "isMultiSimCard", "", "getAllCallFeatureEntity", "", "context", "Landroid/content/Context;", "getAllRecordInfo", "callCreateTime", "", "getAllRecordInfoCursorDesc", "getCallFeatureEntity", "phoneNumber", CallLogListAdapter.PAYLOAD_SELECTION, "selectionArgs", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "getCallFeatureUpdateStatusUri", "add", "remove", "getCallSummaryASRMessageBean", "Lcom/obric/contactprovider/bean/CallSummaryASRMessageBean;", "getCallSummaryASRMessageBeanFromStartToEnd", "Lkotlin/Pair;", "startId", "endId", "getRecordASRMessageEntity", "Lcom/obric/database/entity/RecordASRMessageEntity;", "getRecordInfoEntity", "sendDataChangeBroadcast", "", "updateCallFeatureStatusToObricCallLog", "id", "updateCallFeatureToObricCallLog", "values", "Landroid/content/ContentValues;", "(Landroid/content/Context;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "updateCallSummaryToObricCallLogById", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "Lcom/obric/callsummary/bean/CallSummary;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObricCallLogProviderHelper {
    private static final String AUTHORITY = "call_log_obric";
    private static final String CALL_FEATURE_ADD_STATUS_PARAM_KEY = "call_feature_add_status";
    private static final String CALL_FEATURE_PATH = "call_feature";
    private static final String CALL_FEATURE_REMOVE_STATUS_PARAM_KEY = "call_feature_remove_status";
    private static final String CALL_FEATURE_UPDATE_STATUS_PARAM_KEY = "call_feature_update_status";
    private static final String CALL_SUMMARY_ASR_MESSAGE_PATH = "call_summary_asr_message";
    public static final ObricCallLogProviderHelper INSTANCE = null;
    public static final int OWNER_AI = 3;
    public static final int OWNER_OTHER = 2;
    public static final int OWNER_SELF = 1;
    private static final String RECORD_ASR_MESSAGE_PATH = "record_asr_message";
    private static final String RECORD_INFO_PATH = "record_info";
    private static final String SCHEME_CONTENT = "content";
    private static final String TAG = "ObricCallLogProviderHelper";
    private static final Lazy callFeatureUri$delegate = null;
    private static final Lazy callSummaryASRMessageUri$delegate = null;
    private static final Lazy recordASRMessageUri$delegate = null;
    private static final Lazy recordInfoUri$delegate = null;

    private ObricCallLogProviderHelper() {
    }

    static {
        INSTANCE = new ObricCallLogProviderHelper();
        callSummaryASRMessageUri$delegate = LazyKt.lazy(ObricCallLogProviderHelper$callSummaryASRMessageUri$2.INSTANCE);
        recordASRMessageUri$delegate = LazyKt.lazy(ObricCallLogProviderHelper$recordASRMessageUri$2.INSTANCE);
        callFeatureUri$delegate = LazyKt.lazy(ObricCallLogProviderHelper$callFeatureUri$2.INSTANCE);
        recordInfoUri$delegate = LazyKt.lazy(ObricCallLogProviderHelper$recordInfoUri$2.INSTANCE);
    }

    public final Uri getCallSummaryASRMessageUri() {
        Object r1 = callSummaryASRMessageUri$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-callSummaryASRMessageUri>(...)");
        return (Uri) r1;
    }

    public final Uri getRecordASRMessageUri() {
        Object r1 = recordASRMessageUri$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-recordASRMessageUri>(...)");
        return (Uri) r1;
    }

    public final Uri getCallFeatureUri() {
        Object r1 = callFeatureUri$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-callFeatureUri>(...)");
        return (Uri) r1;
    }

    public final Uri getRecordInfoUri() {
        Object r1 = recordInfoUri$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-recordInfoUri>(...)");
        return (Uri) r1;
    }

    private final Uri getCallFeatureUpdateStatusUri(int r3, int r4) {
        Uri r2 = getCallFeatureUri().buildUpon().appendQueryParameter(CALL_FEATURE_UPDATE_STATUS_PARAM_KEY, "true").appendQueryParameter(CALL_FEATURE_ADD_STATUS_PARAM_KEY, String.valueOf(r3)).appendQueryParameter(CALL_FEATURE_REMOVE_STATUS_PARAM_KEY, String.valueOf(r4)).build();
        Intrinsics.checkNotNullExpressionValue(r2, "callFeatureUri.buildUpon…g())\n            .build()");
        return r2;
    }

    public final List<CallSummaryASRMessageBean> getCallSummaryASRMessageBean(Context r27, long r28, String r30) {
        String r3 = r30;
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
        ArrayList r5 = new ArrayList();
        String r6 = r3;
        boolean r8 = true;
        if (r6.length() != 0) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
        Pair r9 = new Pair(CallSummaryASRMessage.CALL_CREATE_TIME + "=?", new String[]{String.valueOf(r28)});
    L10:
        Cursor r10 = r27.getContentResolver().query(getCallSummaryASRMessageUri(), new String[]{CallSummaryASRMessage.ASR_TEXT, CallSummaryASRMessage.OWNER, CallSummaryASRMessage.IS_CONFERENCE, CallSummaryASRMessage.DURATION}, (String) r9.component1(), (String[]) r9.component2(), CallSummaryASRMessage.START_TIME + " ASC", null);
        if (r10 == null) goto L98;
        Cursor r11 = r10;
        Cursor r14 = r11;     // Catch: Throwable -> L91
        if (r14.moveToFirst() == true) goto L22;
        StringBuilder r0 = new StringBuilder("asr_state_trace summary_asr_empty callCreateTime=").append(r28).append(" selectionHasPhone=");     // Catch: Throwable -> L91
        if (r3.length() > 0) goto L19;
        r8 = false;
    L19:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r0.append(r8).toString());     // Catch: Throwable -> L91
        CloseableKt.closeFinally(r11, null);
        return r5;
    L22:
        int r4 = r14.getColumnIndex(CallSummaryASRMessage.ASR_TEXT);     // Catch: Throwable -> L91
        int r15 = r14.getColumnIndex(CallSummaryASRMessage.OWNER);     // Catch: Throwable -> L91
        int r12 = r14.getColumnIndex(CallSummaryASRMessage.IS_CONFERENCE);     // Catch: Throwable -> L91
        int r13 = r14.getColumnIndex(CallSummaryASRMessage.DURATION);     // Catch: Throwable -> L91
        if (r4 == (-1)) goto L88;
        if (r15 == (-1)) goto L88;
        if (r12 == (-1)) goto L88;
        if (r13 == (-1)) goto L88;
        String r16 = ContactsUtils.getCurrentCountryIso(r27);     // Catch: Throwable -> L91
        ContactInfoHelper r17 = new ContactInfoHelper(r27, r16);     // Catch: Throwable -> L91
        LinkedHashMap r18 = new LinkedHashMap();     // Catch: Throwable -> L91
    L30:
        if (r14.isNull(r12) == false) goto L32;
        Integer r19 = null;
    L33:
        if (r19 == null) goto L35;
        int r110 = r19.intValue();     // Catch: Throwable -> L91
    L36:
        int r111 = r14.getInt(r15);     // Catch: Throwable -> L91
        int r22 = r15;
        if (r111 != 1) goto L39;
        String r112 = r27.getString(R.string.callSummarySelfName);     // Catch: Throwable -> L91
    L76:
        Intrinsics.checkNotNullExpressionValue(r112, "when (it.getInt(ownerInd…      }\n                }");     // Catch: Throwable -> L91
        String r20 = r14.getString(r4);     // Catch: Throwable -> L91
        int r113 = r4;
        Intrinsics.checkNotNullExpressionValue(r20, "it.getString(asrTextIndex)");     // Catch: Throwable -> L91
        if (r14.isNull(r13) == false) goto L79;
        Long r21 = null;
    L80:
        if (r21 == null) goto L82;
        long r23 = r21.longValue();     // Catch: Throwable -> L91
    L83:
        int r24 = r13;
        String r25 = r16;
        r5.add(new CallSummaryASRMessageBean(r20, r112, r23));     // Catch: Throwable -> L91
        if (r14.moveToNext() == false) goto L85;
        r3 = r30;
        r13 = r24;
        r4 = r113;
        r12 = r12;
        r15 = r22;
        r16 = r25;
        goto L30
    L85:
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L91
        CloseableKt.closeFinally(r11, null);
        goto L98
    L82:
        r23 = 0;
        goto L83
    L79:
        r21 = Long.valueOf(r14.getLong(r13));     // Catch: Throwable -> L91
        goto L80
    L39:
        if (r111 == 2) goto L45;
        if (r111 == 3) goto L43;
        r112 = r27.getString(R.string.unknown);     // Catch: Throwable -> L91
        goto L76
    L43:
        r112 = r27.getString(R.string.callSummarySelfName);     // Catch: Throwable -> L91
        goto L76
    L45:
        if (r110 == 0) goto L48;
        r112 = r27.getString(R.string.common_conference_call);     // Catch: Throwable -> L91
        goto L76
    L48:
        if (r3.length() <= 0) goto L50;
        boolean r114 = true;
    L51:
        if (r114 == false) goto L74;
        r112 = (String) r18.get(r3);     // Catch: Throwable -> L91
        String r115 = r112;     // Catch: Throwable -> L91
        if (r115 != null) goto L55;
    L58:
        boolean r116 = true;
    L59:
        if (r116 == false) goto L76;
        ContactInfo r117 = r17.lookupNumber(r3, r16);     // Catch: Throwable -> L91
        if (r117 == null) goto L63;
        r112 = r117.name;     // Catch: Throwable -> L91
    L64:
        if (r112 != null) goto L66;
        r112 = "";
    L68:
        if (r112.length() != 0) goto L70;
        boolean r118 = true;
    L71:
        if (r118 == false) goto L73;
        r112 = r27.getString(R.string.callSummaryOtherName);     // Catch: Throwable -> L91
        Intrinsics.checkNotNullExpressionValue(r112, "context.getString(R.string.callSummaryOtherName)");     // Catch: Throwable -> L91
    L73:
        r18.put(r3, r112);     // Catch: Throwable -> L91
        goto L76
    L70:
        r118 = false;
        goto L71
    L66:
        Intrinsics.checkNotNullExpressionValue(r112, "result?.name ?: \"\"");     // Catch: Throwable -> L91
        goto L68
    L63:
        r112 = null;
        goto L64
    L55:
        if (r115.length() == 0) goto L58;
        r116 = false;
        goto L59
    L74:
        r112 = r27.getString(R.string.callSummaryOtherName);     // Catch: Throwable -> L91
        Intrinsics.checkNotNullExpressionValue(r112, "{\n                      …                        }");     // Catch: Throwable -> L91
        goto L76
    L50:
        r114 = false;
        goto L51
    L35:
        r110 = 0;
        goto L36
    L32:
        r19 = Integer.valueOf(r14.getInt(r12));     // Catch: Throwable -> L91
    L88:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get index error! Return.");     // Catch: Throwable -> L91
        CloseableKt.closeFinally(r11, null);
        return r5;
    L91:
        th = move-exception;
        throw th;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L98:
        StringBuilder r1 = new StringBuilder("asr_state_trace summary_asr_loaded callCreateTime=").append(r28).append(" selectionHasPhone=");
        if (r6.length() <= 0) goto L101;
        boolean r29 = true;
    L102:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r1.append(r29).append(" asrCount=").append(r5.size()).toString());
        if (SettingsProviderHelper.getContactsLogEnable$default(SettingsProviderHelper.INSTANCE, r27, false, 2, null) == false) goto L109;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "============================ getCallSummaryASRMessageBean show asr list ============================");
        Iterator r2 = r5.iterator();
    L106:
        if (r2.hasNext() == false) goto L108;
        CallSummaryASRMessageBean r31 = (CallSummaryASRMessageBean) r2.next();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "asr is " + r31.getName() + ':' + r31.getAsrText() + '\n');
        goto L106
    L108:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "============================ getCallSummaryASRMessageBean end  asr list ============================");
    L109:
        return r5;
    L101:
        r29 = false;
        goto L102
    L9:
        r9 = new Pair(CallSummaryASRMessage.CALL_CREATE_TIME + "=? AND " + CallSummaryASRMessage.PHONE_NUMBER + "=?", new String[]{String.valueOf(r28), r3});
        goto L10
    L5:
        r7 = false;
        goto L7
    }

    public final Pair<List<CallSummaryASRMessageBean>, Integer> getCallSummaryASRMessageBeanFromStartToEnd(Context r23, long r24, String r26, int r27, int r28) {
        Context r0 = r23;
        String r1 = r26;
        int r2 = r27;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "phoneNumber");
        ArrayList r4 = new ArrayList();
        if (r1.length() != 0) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L9;
        Pair r6 = new Pair(CallSummaryASRMessage.CALL_CREATE_TIME + "=?", new String[]{String.valueOf(r24)});
    L10:
        Cursor r7 = r23.getContentResolver().query(getCallSummaryASRMessageUri(), new String[]{CallSummaryASRMessage.ID, CallSummaryASRMessage.ASR_TEXT, CallSummaryASRMessage.OWNER, CallSummaryASRMessage.IS_CONFERENCE, CallSummaryASRMessage.DURATION}, (String) r6.component1(), (String[]) r6.component2(), CallSummaryASRMessage.START_TIME + " ASC", null);
        if (r7 == null) goto L113;
        Cursor r8 = r7;
        Cursor r9 = r8;     // Catch: Throwable -> L105
        if (r9.moveToFirst() == false) goto L118;
        int r10 = r9.getColumnIndex(CallSummaryASRMessage.ID);     // Catch: Throwable -> L105
        int r13 = r9.getColumnIndex(CallSummaryASRMessage.ASR_TEXT);     // Catch: Throwable -> L105
        int r14 = r9.getColumnIndex(CallSummaryASRMessage.OWNER);     // Catch: Throwable -> L105
        int r15 = r9.getColumnIndex(CallSummaryASRMessage.IS_CONFERENCE);     // Catch: Throwable -> L105
        int r11 = r9.getColumnIndex(CallSummaryASRMessage.DURATION);     // Catch: Throwable -> L105
        if (r13 == (-1)) goto L99;
        if (r14 == (-1)) goto L99;
        if (r15 == (-1)) goto L99;
        if (r11 == (-1)) goto L99;
        String r12 = ContactsUtils.getCurrentCountryIso(r23);     // Catch: Throwable -> L105
        ContactInfoHelper r16 = new ContactInfoHelper(r0, r12);     // Catch: Throwable -> L105
        LinkedHashMap r17 = new LinkedHashMap();     // Catch: Throwable -> L105
        int r18 = r2;
    L122:
    L97:
        th = th;
        Cursor r3 = r8;
    L107:
        Throwable r19 = th;
    L120:
        throw r19;     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        CloseableKt.closeFinally(r3, r19);
        throw th;
    L30:
        if (r9.isNull(r10) == false) goto L32;
        Integer r110 = null;
    L33:
        if (r110 == null) goto L35;
        int r111 = r110.intValue();     // Catch: Throwable -> L97
    L36:
        if (r111 < r2) goto L91;
        if (r111 > r28) goto L91;
        int r20 = RangesKt.coerceAtLeast(r18, r111);     // Catch: Throwable -> L97
        if (r9.isNull(r15) == false) goto L42;
        Integer r112 = null;
    L43:
        if (r112 == null) goto L45;
        int r113 = r112.intValue();     // Catch: Throwable -> L97
    L46:
        int r21 = r9.getInt(r14);     // Catch: Throwable -> L97
        if (r21 != 1) goto L49;
        String r22 = r0.getString(R.string.callSummarySelfName);     // Catch: Throwable -> L97
    L83:
        Intrinsics.checkNotNullExpressionValue(r22, "when (it.getInt(ownerInd…      }\n                }");     // Catch: Throwable -> L97
        String r114 = r9.getString(r13);     // Catch: Throwable -> L97
        Intrinsics.checkNotNullExpressionValue(r114, "it.getString(asrTextIndex)");     // Catch: Throwable -> L97
        if (r9.isNull(r11) == false) goto L86;
        Long r25 = null;
    L87:
        if (r25 == null) goto L89;
        long r29 = r25.longValue();     // Catch: Throwable -> L97
    L90:
        r4.add(new CallSummaryASRMessageBean(r114, r22, r29));     // Catch: Throwable -> L97
        r18 = r20;
    L93:
        if (r9.moveToNext() == false) goto L94;
        r0 = r23;
        r10 = r10;
        r1 = r26;
        r14 = r14;
        goto L122
    L94:
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L97
        CloseableKt.closeFinally(r8, null);
        r2 = r18;
        goto L113
    L89:
        r29 = 0;
        goto L90
    L86:
        r25 = Long.valueOf(r9.getLong(r11));     // Catch: Throwable -> L97
        goto L87
    L49:
        if (r21 == 2) goto L51;
        r22 = r0.getString(R.string.unknown);     // Catch: Throwable -> L97
        goto L83
    L51:
        if (r113 == 0) goto L54;
        r22 = r0.getString(R.string.common_conference_call);     // Catch: Throwable -> L97
        goto L83
    L54:
        if (r1.length() <= 0) goto L56;
        boolean r31 = true;
    L58:
        if (r31 == false) goto L81;
        r22 = (String) r17.get(r1);     // Catch: Throwable -> L97
        String r115 = r22;     // Catch: Throwable -> L97
        if (r115 != null) goto L62;
    L65:
        boolean r116 = true;
    L66:
        if (r116 == false) goto L83;
        ContactInfo r32 = r16.lookupNumber(r1, r12);     // Catch: Throwable -> L97
        if (r32 == null) goto L70;
        r22 = r32.name;     // Catch: Throwable -> L97
    L71:
        if (r22 != null) goto L73;
        r22 = "";
    L75:
        if (r22.length() != 0) goto L77;
        boolean r117 = true;
    L78:
        if (r117 == false) goto L80;
        r22 = r0.getString(R.string.callSummaryOtherName);     // Catch: Throwable -> L97
        Intrinsics.checkNotNullExpressionValue(r22, "context.getString(R.string.callSummaryOtherName)");     // Catch: Throwable -> L97
    L80:
        r17.put(r1, r22);     // Catch: Throwable -> L97
        goto L83
    L77:
        r117 = false;
        goto L78
    L73:
        Intrinsics.checkNotNullExpressionValue(r22, "result?.name ?: \"\"");     // Catch: Throwable -> L97
        goto L75
    L70:
        r22 = null;
        goto L71
    L62:
        if (r115.length() == 0) goto L65;
        r116 = false;
        goto L66
    L81:
        r22 = r0.getString(R.string.callSummaryOtherName);     // Catch: Throwable -> L97
        Intrinsics.checkNotNullExpressionValue(r22, "{\n                      …                        }");     // Catch: Throwable -> L97
        goto L83
    L56:
        r31 = false;
        goto L58
    L45:
        r113 = 0;
        goto L46
    L42:
        r112 = Integer.valueOf(r9.getInt(r15));     // Catch: Throwable -> L97
    L91:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "getCallSummaryASRMessageBeanFromStartToEnd not id = " + r111 + ", startId = " + r2 + ", endId = " + r28 + ' ');     // Catch: Throwable -> L97
        goto L93
    L35:
        r111 = 0;
        goto L36
    L32:
        r110 = Integer.valueOf(r9.getInt(r10));     // Catch: Throwable -> L97
    L99:
        r3 = r8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get index error! Return.");     // Catch: Throwable -> L103
        Pair<List<CallSummaryASRMessageBean>, Integer> r33 = new Pair(r4, Integer.valueOf(r28));     // Catch: Throwable -> L103
        CloseableKt.closeFinally(r3, null);
        return r33;
    L103:
        th = th;
        goto L107
    L118:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getCallSummaryASRMessageBeanFromStartToEnd cursor is empty!");     // Catch: Throwable -> L19
        Pair<List<CallSummaryASRMessageBean>, Integer> r34 = new Pair(r4, Integer.valueOf(r28));     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r8, null);
        return r34;
    L19:
        th = move-exception;
        r19 = th;
        r3 = r8;
    L105:
        th = th;
        r3 = r8;
    L113:
        return new Pair(r4, Integer.valueOf(r2));
    L9:
        r6 = new Pair(CallSummaryASRMessage.CALL_CREATE_TIME + "=? AND " + CallSummaryASRMessage.PHONE_NUMBER + "=?", new String[]{String.valueOf(r24), r1});
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    public final List<RecordASRMessageEntity> getRecordASRMessageEntity(Context r33, long r34, String r36) {
        Intrinsics.checkNotNullParameter(r33, "context");
        Intrinsics.checkNotNullParameter(r36, "phoneNumber");
        ArrayList r1 = new ArrayList();
        if (r36.length() != 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        Pair r0 = new Pair(RecordASRMessage.CALL_CREATE_TIME + "=?", new String[]{String.valueOf(r34)});
    L10:
        Cursor r2 = r33.getContentResolver().query(getRecordASRMessageUri(), null, (String) r0.component1(), (String[]) r0.component2(), null, null);
        if (r2 == null) goto L62;
        Cursor r4 = r2;
        Cursor r5 = r4;     // Catch: Throwable -> L56
        if (r5.moveToFirst() == true) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getRecordASRMessageEntityByCallCreateTime cursor is empty!");     // Catch: Throwable -> L56
        CloseableKt.closeFinally(r4, null);
        return r1;
    L19:
        int r6 = r5.getColumnIndex(RecordASRMessage.ID);     // Catch: Throwable -> L56
        int r7 = r5.getColumnIndex(RecordASRMessage.CALL_CREATE_TIME);     // Catch: Throwable -> L56
        int r8 = r5.getColumnIndex(RecordASRMessage.ASR_TEXT);     // Catch: Throwable -> L56
        int r9 = r5.getColumnIndex(RecordASRMessage.OWNER);     // Catch: Throwable -> L56
        int r10 = r5.getColumnIndex(RecordASRMessage.PHONE_NUMBER);     // Catch: Throwable -> L56
        int r11 = r5.getColumnIndex(RecordASRMessage.PART_ID);     // Catch: Throwable -> L56
        int r12 = r5.getColumnIndex(RecordASRMessage.PART_START_TIME);     // Catch: Throwable -> L56
        int r13 = r5.getColumnIndex(RecordASRMessage.PART_DURATION);     // Catch: Throwable -> L56
        int r14 = r5.getColumnIndex(RecordASRMessage.START_TIME);     // Catch: Throwable -> L56
        int r15 = r5.getColumnIndex(RecordASRMessage.DURATION);     // Catch: Throwable -> L56
        int r16 = r5.getColumnIndex(RecordASRMessage.IS_CONFERENCE);     // Catch: Throwable -> L56
        if (r6 == (-1)) goto L53;
        if (r7 == (-1)) goto L53;
        if (r8 == (-1)) goto L53;
        if (r9 == (-1)) goto L53;
        if (r10 == (-1)) goto L53;
        if (r11 == (-1)) goto L53;
        if (r12 == (-1)) goto L53;
        if (r13 == (-1)) goto L53;
        if (r14 == (-1)) goto L53;
        if (r15 == (-1)) goto L53;
        if (r16 == (-1)) goto L53;
    L32:
        long r17 = r5.getLong(r7);     // Catch: Throwable -> L56
        String r18 = r5.getString(r8);     // Catch: Throwable -> L56
        int r35 = r7;
        Intrinsics.checkNotNullExpressionValue(r18, "it.getString(asrTextIndex)");     // Catch: Throwable -> L56
        int r20 = r5.getInt(r9);     // Catch: Throwable -> L56
        String r19 = r5.getString(r10);     // Catch: Throwable -> L56
        int r37 = r8;
        Intrinsics.checkNotNullExpressionValue(r19, "it.getString(phoneNumberIndex)");     // Catch: Throwable -> L56
        if (r5.isNull(r11) == false) goto L35;
        Integer r22 = null;
    L37:
        if (r5.isNull(r12) == false) goto L39;
        Long r23 = null;
    L41:
        if (r5.isNull(r13) == false) goto L43;
        Long r24 = null;
    L44:
        long r25 = r5.getLong(r14);     // Catch: Throwable -> L56
        long r27 = r5.getLong(r15);     // Catch: Throwable -> L56
        if (r5.isNull(r16) == false) goto L47;
        Integer r29 = null;
    L48:
        r1.add(new RecordASRMessageEntity(r17, r18, r20, r19, r22, r23, r24, r25, r27, r29, r5.getLong(r6)));     // Catch: Throwable -> L56
        if (r5.moveToNext() == false) goto L50;
        r7 = r35;
        r8 = r37;
        goto L32
    L50:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L56
        CloseableKt.closeFinally(r4, null);
        goto L62
    L47:
        r29 = Integer.valueOf(r5.getInt(r16));     // Catch: Throwable -> L56
        goto L48
    L43:
        r24 = Long.valueOf(r5.getLong(r13));     // Catch: Throwable -> L56
        goto L44
    L39:
        r23 = Long.valueOf(r5.getLong(r12));     // Catch: Throwable -> L56
        goto L41
    L35:
        r22 = Integer.valueOf(r5.getInt(r11));     // Catch: Throwable -> L56
    L53:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get index error! Return.");     // Catch: Throwable -> L56
        CloseableKt.closeFinally(r4, null);
        return r1;
    L56:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L62:
        return r1;
    L9:
        r0 = new Pair(RecordASRMessage.CALL_CREATE_TIME + "=? AND " + RecordASRMessage.PHONE_NUMBER + "=?", new String[]{String.valueOf(r34), r36});
        goto L10
    L5:
        r3 = false;
        goto L7
    }

    public final List<RecordInfoEntity> getRecordInfoEntity(Context r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "phoneNumber");
        return getRecordInfoEntity(r4, RecordInfo.CALL_CREATE_TIME + "=? AND " + RecordInfo.PHONE_NUMBER + "=?", new String[]{String.valueOf(r5), r7});
    }

    public final List<RecordInfoEntity> getAllRecordInfo(Context r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return getRecordInfoEntity(r1, null, null);
    }

    public final Cursor getAllRecordInfoCursorDesc(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        return r9.getContentResolver().query(getRecordInfoUri(), null, null, null, RecordInfo.ID + " DESC", null);
    }

    private final List<RecordInfoEntity> getRecordInfoEntity(Context r21, String r22, String[] r23) {
        ArrayList r0 = new ArrayList();
        Cursor r1 = r21.getContentResolver().query(getRecordInfoUri(), null, r22, r23, null, null);
        if (r1 == null) goto L31;
        Cursor r2 = r1;
        Cursor r3 = r2;     // Catch: Throwable -> L25
        if (r3.moveToFirst() == true) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getRecordInfoEntityByCallCreateTime cursor is empty!");     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r2, null);
        return r0;
    L11:
        int r4 = r3.getColumnIndex(RecordInfo.ID);     // Catch: Throwable -> L25
        int r6 = r3.getColumnIndex(RecordInfo.CALL_CREATE_TIME);     // Catch: Throwable -> L25
        int r7 = r3.getColumnIndex(RecordInfo.PATH);     // Catch: Throwable -> L25
        int r8 = r3.getColumnIndex(RecordInfo.PHONE_NUMBER);     // Catch: Throwable -> L25
        int r9 = r3.getColumnIndex(RecordInfo.DURATION);     // Catch: Throwable -> L25
        if (r4 == (-1)) goto L22;
        if (r6 == (-1)) goto L22;
        if (r7 == (-1)) goto L22;
        if (r8 == (-1)) goto L22;
        if (r9 == (-1)) goto L22;
    L18:
        long r12 = r3.getLong(r6);     // Catch: Throwable -> L25
        String r14 = r3.getString(r7);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r14, "it.getString(pathIndex)");     // Catch: Throwable -> L25
        String r15 = r3.getString(r8);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r15, "it.getString(phoneNumberIndex)");     // Catch: Throwable -> L25
        r0.add(new RecordInfoEntity(r12, r14, r15, r3.getLong(r9), r3.getLong(r4)));     // Catch: Throwable -> L25
        if (r3.moveToNext() == true) goto L18;
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r2, null);
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get index error! Return.");     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r2, null);
        return r0;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L31:
        return r0;
    }

    public final BlockedCallEntity cursorToBlockedCallEntity(Cursor r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "cursor");
        long r1 = r11.getLong(0);
        String r3 = r11.getString(1);
        long r4 = r11.getLong(2);
        int r6 = r11.getInt(3);
        if (r11.isNull(4) == false) goto L5;
        Integer r13 = null;
    L6:
        if (r13 == null) goto L8;
        int r9 = r13.intValue();
    L10:
        return new BlockedCallEntity(r1, r3, r4, r6, 6, r12 ? 1 : 0, r9);
    L8:
        r9 = 0;
        goto L10
    L5:
        r13 = Integer.valueOf(r11.getInt(4));
        goto L6
    }

    public final RecordInfoEntity cursor2Entity(Cursor r15) {
        Intrinsics.checkNotNullParameter(r15, "cursor");
        int r14 = r15.getColumnIndex(RecordInfo.ID);
        int r0 = r15.getColumnIndex(RecordInfo.CALL_CREATE_TIME);
        int r1 = r15.getColumnIndex(RecordInfo.PATH);
        int r2 = r15.getColumnIndex(RecordInfo.PHONE_NUMBER);
        int r3 = r15.getColumnIndex(RecordInfo.DURATION);
        if (r14 == (-1)) goto L11;
        if (r0 == (-1)) goto L11;
        if (r1 == (-1)) goto L11;
        if (r2 == (-1)) goto L11;
        if (r3 == (-1)) goto L11;
        long r6 = r15.getLong(r0);
        String r8 = r15.getString(r1);
        Intrinsics.checkNotNullExpressionValue(r8, "cursor.getString(pathIndex)");
        String r9 = r15.getString(r2);
        Intrinsics.checkNotNullExpressionValue(r9, "cursor.getString(phoneNumberIndex)");
        return new RecordInfoEntity(r6, r8, r9, r15.getLong(r3), r15.getLong(r14));
    L11:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get index error! Return.");
        return new RecordInfoEntity(-1, "", "", 0, -1);
    }

    public final CallFeatureEntity callFeatureCursor2Entity(Cursor r19) {
        String r1 = null;
        if (r19 != null) goto L5;
        return null;
    L5:
        int r2 = r19.getColumnIndex(CallFeature.ID);
        int r3 = r19.getColumnIndex(CallFeature.CALL_CREATE_TIME);
        int r4 = r19.getColumnIndex(CallFeature.FEATURE);
        int r5 = r19.getColumnIndex(CallFeature.STATUS);
        int r6 = r19.getColumnIndex(CallFeature.SUMMARY);
        int r7 = r19.getColumnIndex(CallFeature.PHONE_NUMBER);
        if (r2 == (-1)) goto L23;
        if (r3 == (-1)) goto L23;
        if (r4 == (-1)) goto L23;
        if (r5 == (-1)) goto L23;
        if (r6 == (-1)) goto L23;
        if (r7 == (-1)) goto L23;
        long r10 = r19.getLong(r3);
        int r12 = r19.getInt(r4);
        int r13 = r19.getInt(r5);
        if (r19.isNull(r6) == false) goto L16;
        String r14 = null;
    L18:
        if (r19.isNull(r7) == true) goto L22;
        r1 = r19.getString(r7);
    L22:
        return new CallFeatureEntity(r10, r12, r13, r14, r1, r19.getLong(r2));
    L16:
        r14 = r19.getString(r6);
    L23:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get index error! Return.");
        return null;
    }

    public final List<CallFeatureEntity> getCallFeatureEntity(Context r6, long r7, String r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r9, "phoneNumber");
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Pair r10 = new Pair(CallFeature.CALL_CREATE_TIME + "=?", new String[]{String.valueOf(r7)});
    L10:
        return getCallFeatureEntity(r6, (String) r10.component1(), (String[]) r10.component2());
    L8:
        r10 = new Pair(CallFeature.CALL_CREATE_TIME + "=? AND (" + CallFeature.PHONE_NUMBER + "=? OR " + CallFeature.PHONE_NUMBER + " IS NULL)", new String[]{String.valueOf(r7), r9});
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final List<CallFeatureEntity> getAllCallFeatureEntity(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return getCallFeatureEntity(r2, null, null);
    }

    private final List<CallFeatureEntity> getCallFeatureEntity(Context r22, String r23, String[] r24) {
        ArrayList r0 = new ArrayList();
        Cursor r1 = r22.getContentResolver().query(getCallFeatureUri(), null, r23, r24, null, null);
        if (r1 == null) goto L40;
        Cursor r2 = r1;
        Cursor r3 = r2;     // Catch: Throwable -> L34
        if (r3.moveToFirst() == true) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getAllCallFeatureEntity cursor is empty!");     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r2, null);
        return r0;
    L11:
        int r4 = r3.getColumnIndex(CallFeature.ID);     // Catch: Throwable -> L34
        int r6 = r3.getColumnIndex(CallFeature.CALL_CREATE_TIME);     // Catch: Throwable -> L34
        int r7 = r3.getColumnIndex(CallFeature.FEATURE);     // Catch: Throwable -> L34
        int r8 = r3.getColumnIndex(CallFeature.STATUS);     // Catch: Throwable -> L34
        int r9 = r3.getColumnIndex(CallFeature.SUMMARY);     // Catch: Throwable -> L34
        int r10 = r3.getColumnIndex(CallFeature.PHONE_NUMBER);     // Catch: Throwable -> L34
        if (r4 == (-1)) goto L31;
        if (r6 == (-1)) goto L31;
        if (r7 == (-1)) goto L31;
        if (r8 == (-1)) goto L31;
        if (r9 == (-1)) goto L31;
        if (r10 == (-1)) goto L31;
    L19:
        long r13 = r3.getLong(r6);     // Catch: Throwable -> L34
        int r15 = r3.getInt(r7);     // Catch: Throwable -> L34
        int r16 = r3.getInt(r8);     // Catch: Throwable -> L34
        if (r3.isNull(r9) == false) goto L22;
        String r17 = null;
    L24:
        if (r3.isNull(r10) == false) goto L26;
        String r18 = null;
    L27:
        r0.add(new CallFeatureEntity(r13, r15, r16, r17, r18, r3.getLong(r4)));     // Catch: Throwable -> L34
        if (r3.moveToNext() == true) goto L19;
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r2, null);
        goto L40
    L26:
        r18 = r3.getString(r10);     // Catch: Throwable -> L34
        goto L27
    L22:
        r17 = r3.getString(r9);     // Catch: Throwable -> L34
    L31:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Get index error! Return.");     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r2, null);
        return r0;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L40:
        return r0;
    }

    public final int updateCallSummaryToObricCallLogById(Context r12, long r13, CallSummary r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r15, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        ObricCallLogProviderHelper r3 = this;     // Catch: Throwable -> L15
        String r4 = GlobalUtils.INSTANCE.getGson().toJson(r15, CallSummary.class);     // Catch: Throwable -> L15
        ContentValues r5 = new ContentValues();     // Catch: Throwable -> L15
        r5.put(CallFeature.SUMMARY, r4);     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        boolean r7 = true;
        int r8 = updateCallFeatureToObricCallLog(r12, r5, CallFeature.ID + "=?", new String[]{String.valueOf(r13)});     // Catch: Throwable -> L15
        int r11 = updateCallFeatureStatusToObricCallLog(r12, r13, 1, 0);     // Catch: Throwable -> L15
        StringBuilder r14 = new StringBuilder("db write done id=").append(r13).append(" summaryError=").append(r15.getErrorCode()).append(" textEmpty=");     // Catch: Throwable -> L15
        String r16 = r15.getSummary();     // Catch: Throwable -> L15
        if (r16 != null) goto L6;
    L9:
        StringBuilder r17 = r14.append(r7).append(" textLen=");     // Catch: Throwable -> L15
        String r18 = r15.getSummary();     // Catch: Throwable -> L15
        if (r18 == null) goto L12;
        int r19 = r18.length();     // Catch: Throwable -> L15
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, r17.append(r19).append(" updateCount=").append(r8).append(" statusCount=").append(r11).toString());     // Catch: Throwable -> L15
        Object r110 = Result.m803constructorimpl(Integer.valueOf(r11));     // Catch: Throwable -> L15
    L17:
        Throwable r111 = Result.m806exceptionOrNullimpl(r110);
        if (r111 == null) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "updateCallSummaryToObricCallLogById error!", r111);
        r110 = 0;
    L22:
        return ((Number) r110).intValue();
    L12:
        r19 = 0;
        goto L13
    L6:
        if (r16.length() == 0) goto L9;
        r7 = false;
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final int updateCallFeatureToObricCallLog(Context r5, ContentValues r6, String r7, String[] r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        ObricCallLogProviderHelper r3 = this;     // Catch: Throwable -> L8
        int r9 = r5.getContentResolver().update(getCallFeatureUri(), r6, r7, r8);     // Catch: Throwable -> L8
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "updateCallSummaryToObricCallLog count is " + r9);     // Catch: Throwable -> L8
        if (r9 <= 0) goto L6;
        sendDataChangeBroadcast(r5);     // Catch: Throwable -> L8
    L6:
        Object r4 = Result.m803constructorimpl(Integer.valueOf(r9));     // Catch: Throwable -> L8
    L10:
        Throwable r10 = Result.m806exceptionOrNullimpl(r4);
        if (r10 == null) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "saveCallSummaryToObricCallLog error!", r10);
        r4 = 0;
    L15:
        return ((Number) r4).intValue();
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r4 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final int updateCallFeatureStatusToObricCallLog(Context r4, long r5, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        ObricCallLogProviderHelper r3 = this;     // Catch: Throwable -> L5
        ContentResolver r6 = r4.getContentResolver();     // Catch: Throwable -> L5
        Uri r9 = getCallFeatureUpdateStatusUri(r7, r8);     // Catch: Throwable -> L5
        ContentValues r10 = new ContentValues();     // Catch: Throwable -> L5
        r10.put(CallFeature.ID, Long.valueOf(r5));     // Catch: Throwable -> L5
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L5
        int r12 = r6.update(r9, r10, null, null);     // Catch: Throwable -> L5
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "updateCallFeatureStatusToObricCallLog count is " + r12);     // Catch: Throwable -> L5
        Object r13 = Result.m803constructorimpl(Integer.valueOf(r12));     // Catch: Throwable -> L5
    L7:
        Throwable r14 = Result.m806exceptionOrNullimpl(r13);
        if (r14 == null) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "updateCallFeatureStatusToObricCallLog error!", r14);
        r13 = 0;
    L12:
        return ((Number) r13).intValue();
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void sendDataChangeBroadcast(Context r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "sendDataChangeBroadcast to AIRecordAssistant");
        Intent r1 = new Intent("com.bytedance.obric.airecordassistant.ACTION_DATA_CHANGE");
        r1.setPackage(CallSummaryWidget.BROADCAST_TARGET_PACKAGE_NAME);
        r2.sendBroadcast(r1);
    }
}
