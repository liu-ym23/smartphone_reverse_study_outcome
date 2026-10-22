package com.android.contacts.obricsync;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.android.contacts.obricsync.contact.ContactParamList;
import com.android.contacts.obricsync.contact.ContactSync;
import com.google.gson.Gson;
import com.obric.cloudsdk.kv.base.KvSyncManager;
import com.obric.contactsdk.CallSmsDataDonation;
import com.obric.contactsdk.ContactChange;
import com.obric.contactsdk.ContactChangeListener;
import com.obric.contactsdk.loader.ContractKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ObricSyncUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0007J\r\u0010&\u001a\u00020\u0004H\u0000¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0019H\u0007J\u001e\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/android/contacts/obricsync/ObricSyncUtils;", "", "()V", "ENABLE_SNAPSHOT_BULK_CONVERGENCE", "", "TAG", "", "absSyncInfo", "com/android/contacts/obricsync/ObricSyncUtils$absSyncInfo$1", "Lcom/android/contacts/obricsync/ObricSyncUtils$absSyncInfo$1;", "callSmsDataDonationlistener", "Lcom/obric/contactsdk/CallSmsDataDonation;", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "listener", "Lcom/obric/contactsdk/ContactChangeListener;", "logger", "com/android/contacts/obricsync/ObricSyncUtils$logger$1", "Lcom/android/contacts/obricsync/ObricSyncUtils$logger$1;", "snapshotBulkConverger", "Lcom/android/contacts/obricsync/ObricSyncSnapshotBulkConverger;", "convertIdsToList", "", "", "ids", "getContactSync", "Lcom/android/contacts/obricsync/contact/ContactSync;", "values", "Landroid/content/ContentValues;", "getValueList", "Lcom/android/contacts/obricsync/contact/ContactParamList;", "str", "init", "", "context", "Landroid/content/Context;", "isSnapshotBulkConvergenceEnabledForTest", "isSnapshotBulkConvergenceEnabledForTest$app_QssiCnRelease", "scheduleSnapshotCleanup", ContactSaveService.EXTRA_CONTACT_ID, "updateListener", "uris", "Landroid/net/Uri;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObricSyncUtils {
    private static final boolean ENABLE_SNAPSHOT_BULK_CONVERGENCE = false;
    public static final ObricSyncUtils INSTANCE = null;
    public static final String TAG = "ObricSync";
    private static final ObricSyncUtils$absSyncInfo$1 absSyncInfo = null;
    private static CallSmsDataDonation callSmsDataDonationlistener;
    private static Handler handler;
    private static final HandlerThread handlerThread = null;
    private static ContactChangeListener listener;
    private static final ObricSyncUtils$logger$1 logger = null;
    private static ObricSyncSnapshotBulkConverger snapshotBulkConverger;

    /* JADX INFO: renamed from: com.android.contacts.obricsync.ObricSyncUtils$updateListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricSyncUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.obricsync.ObricSyncUtils$updateListener$1", f = "ObricSyncUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<Uri> $uris;
        int label;

        public static /* synthetic */ void $r8$lambda$9IU2tRmwBVNTt0C6gpXIRKEsAy4(Context r0, List r1) {
            invokeSuspend$lambda$5$lambda$1(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$BFz4aXWOS47ci0YLL_Ae5l6Av60(Context r0, List r1) {
            invokeSuspend$lambda$5$lambda$3(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$Q3r6aQm0wAA3PuhTMqScEJmVYEo(Context r0, List r1) {
            invokeSuspend$lambda$5$lambda$2(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$UvkLBsHu9rpS73MTU3Jj5ELJ7ks(Context r0) {
            invokeSuspend$lambda$5$lambda$4(r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        C02091(List<? extends Uri> r1, Context r2, Continuation<? super C02091> r3) {
            this.$uris = r1;
            this.$context = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02091(this.$uris, this.$context, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C02091) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L55;
            ResultKt.throwOnFailure(r10);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "updateListener uris = [" + this.$uris + DefaultContactListAdapter.SNIPPET_END_MATCH);
            List<Uri> r11 = this.$uris;
            final Context r9 = this.$context;
            Iterator<T> r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L53;
            Uri r2 = (Uri) r12.next();
            String r3 = null;
            if (r2 == null) goto L10;
            String r4 = r2.getQueryParameter("id");
        L11:
            if (r2 == null) goto L13;
            String r5 = r2.getQueryParameter(ContractKt.PARAM_ACTION_ACTION);
        L14:
            if (r2 == null) goto L16;
            String r6 = r2.getQueryParameter(ContractKt.PARAM_ACTION_URI);
        L17:
            if (r6 == null) goto L21;
            Uri r7 = Uri.parse(r6);
            if (r7 == null) goto L21;
            r3 = r7.getQueryParameter(SyncContractKt.OBRIC_CALLER_IS_SYNCADAPTER);
        L21:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ObricSyncUtils.TAG, "updateListener ids = [" + r4 + "], action:[" + r5 + "], callerIsSyncadapter = [" + r3 + "] , uri:[" + r2 + "], queryUri:[" + r6 + DefaultContactListAdapter.SNIPPET_END_MATCH);
            if (TextUtils.equals(r3, "true") == true) goto L6;
            final List<Long> r8 = ObricSyncUtils.INSTANCE.convertIdsToList(r4);
            if (r5 == null) goto L6;
            switch(r5.hashCode()) {
                case -1352294148: goto L47;
                case -1335458389: goto L41;
                case -1183792455: goto L35;
                case -838846263: goto L29;
                default: goto L6;
            };
        L29:
            if (r5.equals("update") == false) goto L6;
            Handler r13 = ObricSyncUtils.access$getHandler$p();
            if (r13 == null) goto L6;
            Boxing.boxBoolean(r13.post(new ObricSyncUtils$updateListener$1$$ExternalSyntheticLambda1(r9, r8)));
            goto L6
        L35:
            if (r5.equals("insert") == false) goto L6;
            Handler r14 = ObricSyncUtils.access$getHandler$p();
            if (r14 == null) goto L6;
            Boxing.boxBoolean(r14.post(new ObricSyncUtils$updateListener$1$$ExternalSyntheticLambda0(r9, r8)));
            goto L6
        L41:
            if (r5.equals("delete") == false) goto L6;
            Handler r15 = ObricSyncUtils.access$getHandler$p();
            if (r15 == null) goto L6;
            Boxing.boxBoolean(r15.post(new ObricSyncUtils$updateListener$1$$ExternalSyntheticLambda2(r9, r8)));
            goto L6
        L47:
            if (r5.equals(ContractKt.OBRIC_ACTION_CREATE) == false) goto L6;
            Handler r16 = ObricSyncUtils.access$getHandler$p();
            if (r16 == null) goto L6;
            Boxing.boxBoolean(r16.post(new ObricSyncUtils$updateListener$1$$ExternalSyntheticLambda3(r9)));
            goto L6
        L16:
            r6 = null;
            goto L17
        L13:
            r5 = null;
            goto L14
        L10:
            r4 = null;
            goto L11
        L53:
            return Unit.INSTANCE;
        L55:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final void invokeSuspend$lambda$5$lambda$1(Context r1, List r2) {
            LocalToSyncUtils.insert2Sync(r1, r2, true);
        }

        private static final void invokeSuspend$lambda$5$lambda$2(Context r3, List r4) {
            LocalToSyncUtils.update2Sync$default(r3, r4, false, 4, null);
        }

        private static final void invokeSuspend$lambda$5$lambda$3(Context r0, List r1) {
            LocalToSyncUtils.delete2Sync(r0, r1);
        }

        private static final void invokeSuspend$lambda$5$lambda$4(Context r0) {
            LocalToSyncUtils.createTabLocal2Sync(r0);
        }
    }

    public final boolean isSnapshotBulkConvergenceEnabledForTest$app_QssiCnRelease() {
        return false;
    }

    private ObricSyncUtils() {
    }

    public static final /* synthetic */ Handler access$getHandler$p() {
        return handler;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.contacts.obricsync.ObricSyncUtils$absSyncInfo$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.contacts.obricsync.ObricSyncUtils$logger$1] */
    static {
        INSTANCE = new ObricSyncUtils();
        absSyncInfo = new ObricSyncUtils$absSyncInfo$1();
        logger = new ObricSyncUtils$logger$1();
        HandlerThread r0 = new HandlerThread(TAG);
        handlerThread = r0;
        r0.start();
        handler = new Handler(r0.getLooper());
    }

    @JvmStatic
    public static final void init(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (callSmsDataDonationlistener != null) goto L5;
        callSmsDataDonationlistener = new CallSmsDataDonation(r3);
    L5:
        CallSmsDataDonation r0 = callSmsDataDonationlistener;
        if (r0 == null) goto L8;
        r0.initContactsDataAwareness();
    L8:
        KvSyncManager.INSTANCE.init(r3, absSyncInfo, logger);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "[SYNC-BULK-CLEANUP] bulk converge disabled, query hot-path mitigation remains enabled");
        listener = new AnonymousClass1(r3);
        ContactChange r4 = ContactChange.INSTANCE;
        ContactChangeListener r1 = listener;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.contactsdk.ContactChangeListener");
        r4.addChangeListener(r1);
    }

    @JvmStatic
    public static final void scheduleSnapshotCleanup(long r2) {
        if (r2 > 0) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "[SYNC-BULK-CLEANUP] schedule ignored, bulk converge disabled, contactId=" + r2);
    }

    private static final void scheduleSnapshotCleanup$lambda$0() {
        ObricSyncSnapshotBulkConverger r0 = snapshotBulkConverger;
        if (r0 == null) goto L6;
        r0.schedule(30000);
        return;
    }

    public final void updateListener(Context r7, List<? extends Uri> r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "uris");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C02091(r8, r7, null), 3, null);
    }

    public final ContactSync getContactSync(ContentValues r30) {
        if (r30 == null) goto L5;
        String r3 = r30.getAsString("name");
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        String r8 = "";
    L10:
        if (r30 == null) goto L12;
        String r5 = r30.getAsString(SyncContractKt.COLUMN_FIRST_NAME);
    L13:
        if (r5 != null) goto L15;
        String r9 = "";
    L16:
        if (r30 == null) goto L18;
        String r6 = r30.getAsString(SyncContractKt.COLUMN_LAST_NAME);
    L19:
        if (r6 != null) goto L21;
        String r10 = "";
    L22:
        if (r30 == null) goto L24;
        String r7 = r30.getAsString(SyncContractKt.COLUMN_COMPANY);
    L25:
        if (r7 != null) goto L27;
        String r11 = "";
    L28:
        if (r30 == null) goto L30;
        String r12 = r30.getAsString(SyncContractKt.COLUMN_ADDRESS);
    L31:
        if (r12 != null) goto L33;
        r12 = "";
    L33:
        if (r30 == null) goto L35;
        String r13 = r30.getAsString("phone_number");
    L36:
        if (r13 != null) goto L38;
        String r14 = "";
    L39:
        if (r30 == null) goto L41;
        String r15 = r30.getAsString(SyncContractKt.COLUMN_ID_CARDS);
    L42:
        if (r15 != null) goto L44;
        String r16 = "";
    L45:
        if (r30 == null) goto L47;
        String r17 = r30.getAsString("email");
    L48:
        if (r17 != null) goto L50;
        String r18 = "";
    L51:
        if (r30 == null) goto L53;
        byte[] r19 = r30.getAsByteArray(SyncContractKt.COLUMN_AVATAR);
    L54:
        if (r30 == null) goto L56;
        String r20 = r30.getAsString(SyncContractKt.COLUMN_NOTE);
    L57:
        if (r20 != null) goto L59;
        String r110 = "";
    L60:
        if (r30 == null) goto L62;
        String r21 = r30.getAsString(SyncContractKt.COLUMN_NICK_NAME);
    L63:
        if (r21 != null) goto L65;
        String r22 = "";
    L66:
        if (r30 == null) goto L68;
        String r23 = r30.getAsString(SyncContractKt.COLUMN_IM);
    L69:
        if (r23 != null) goto L71;
        String r111 = "";
    L72:
        if (r30 == null) goto L74;
        String r24 = r30.getAsString(SyncContractKt.COLUMN_WEBSITE);
    L75:
        if (r24 != null) goto L77;
        String r27 = "";
    L78:
        if (r30 == null) goto L80;
        Integer r25 = r30.getAsInteger(SyncContractKt.COLUMN_GENDER);
    L81:
        if (r25 != null) goto L83;
        int r26 = -1;
    L84:
        if (r30 == null) goto L86;
        String r28 = r30.getAsString(SyncContractKt.COLUMN_BIRTHDAY);
    L87:
        if (r28 != null) goto L89;
        r28 = "";
    L89:
        if (r30 == null) goto L91;
        String r2 = r30.getAsString(SyncContractKt.COLUMN_INTER_ADDRESS);
    L92:
        if (r2 != null) goto L94;
        r2 = "";
    L94:
        if (r30 == null) goto L96;
        String r112 = r30.getAsString(SyncContractKt.COLUMN_RELATION);
    L97:
        if (r112 == null) goto L100;
        r4 = r112;
    L100:
        int r29 = r26;
        String r113 = r110;
        String r114 = r22;
        String r115 = r27;
        String r210 = r2;
        ContactSync r1 = new ContactSync(-1, r8, r9, r10, r11, r113, getValueList(r14), getValueList(r18), r114, getValueList(r16), r19, getValueList(r111), r115, getValueList(r28), getValueList(r12), r210, getValueList(r4), 0, 131072, null);
        if (r29 == (-1)) goto L104;
        r1.setGenderCode(r29);
        return r1;
    L104:
        return r1;
    L96:
        r112 = null;
        goto L97
    L91:
        r2 = null;
        goto L92
    L86:
        r28 = null;
        goto L87
    L83:
        r26 = r25.intValue();
        goto L84
    L80:
        r25 = null;
        goto L81
    L77:
        r27 = r24;
        goto L78
    L74:
        r24 = null;
        goto L75
    L71:
        r111 = r23;
        goto L72
    L68:
        r23 = null;
        goto L69
    L65:
        r22 = r21;
        goto L66
    L62:
        r21 = null;
        goto L63
    L59:
        r110 = r20;
        goto L60
    L56:
        r20 = null;
        goto L57
    L53:
        r19 = null;
        goto L54
    L50:
        r18 = r17;
        goto L51
    L47:
        r17 = null;
        goto L48
    L44:
        r16 = r15;
        goto L45
    L41:
        r15 = null;
        goto L42
    L38:
        r14 = r13;
        goto L39
    L35:
        r13 = null;
        goto L36
    L30:
        r12 = null;
        goto L31
    L27:
        r11 = r7;
        goto L28
    L24:
        r7 = null;
        goto L25
    L21:
        r10 = r6;
        goto L22
    L18:
        r6 = null;
        goto L19
    L15:
        r9 = r5;
        goto L16
    L12:
        r5 = null;
        goto L13
    L9:
        r8 = r3;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private final ContactParamList getValueList(String r2) {
        Gson r1 = new Gson();
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L13;
    L11:
        return null;
    L13:
        return (ContactParamList) r1.fromJson(r2, ContactParamList.class);
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, String.valueOf(e));
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final List<Long> convertIdsToList(String r8) {
        ArrayList r7 = new ArrayList();
        String r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L30;
        return r7;
    L30:
        List r9 = StringsKt.split$default(r8, new String[]{SimContactsConstants.EMAIL_SEP}, false, 0, 6, null);     // Catch: Exception -> L23
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));     // Catch: Exception -> L23
        Iterator r10 = r9.iterator();     // Catch: Exception -> L23
    L13:
        if (r10.hasNext() == false) goto L15;
        r2.add(StringsKt.trim((String) r10.next()).toString());     // Catch: Exception -> L23
        goto L13
    L15:
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L23
        Iterator r3 = r2.iterator();     // Catch: Exception -> L23
    L17:
        if (r3.hasNext() == false) goto L21;
        Long r4 = StringsKt.toLongOrNull((String) r3.next());     // Catch: Exception -> L23
        if (r4 == null) goto L17;
        r11.add(r4);     // Catch: Exception -> L23
        goto L17
    L21:
        ArrayList r12 = r11;     // Catch: Exception -> L23
    L25:
        Iterator r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L29;
        r7.add(Long.valueOf(((Number) r13.next()).longValue()));
        goto L27
    L29:
        return r7;
    L23:
        e = move-exception;
        System.out.println("Error converting ids to list: " + e.getMessage());
        r12 = new ArrayList();
        goto L25
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
