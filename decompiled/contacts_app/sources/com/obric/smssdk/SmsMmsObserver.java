package com.obric.smssdk;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.android.contacts.common.SimContactsConstants;
import com.obric.callandsms.common.CallSmsEntityChangeObserver;
import com.obric.callandsms.common.Logger;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SmsMmsObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/smssdk/SmsMmsObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "context", "Landroid/content/Context;", "(Landroid/os/Handler;Landroid/content/Context;)V", "delayMillis", "", "getHandler", "()Landroid/os/Handler;", "pendingDeleteMmsIds", "", "", "pendingDeleteSmsIds", "pendingIndexMmsIds", "pendingIndexSmsIds", "pendingUpdateMmsIds", "pendingUpdateSmsIds", "updateDeleteRunnable", "Ljava/lang/Runnable;", "updateIndexRunnable", "onChange", "", "selfChange", "", "notifyWithActionUri", "Landroid/net/Uri;", "printMessageEntity", "messageList", "", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "Companion", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SmsMmsObserver extends ContentObserver {
    public static final Companion Companion = null;
    private static final String DELETE_ACTION = "delete";
    private static final String INSERT_ACTION = "insert";
    private static final String TAG = "SmsMmsObserver";
    private static final String UPDATE_ACTION = "update";
    private final Context context;
    private final long delayMillis;
    private final Handler handler;
    private final Set<String> pendingDeleteMmsIds;
    private final Set<String> pendingDeleteSmsIds;
    private final Set<String> pendingIndexMmsIds;
    private final Set<String> pendingIndexSmsIds;
    private final Set<String> pendingUpdateMmsIds;
    private final Set<String> pendingUpdateSmsIds;
    private final Runnable updateDeleteRunnable;
    private final Runnable updateIndexRunnable;

    /* JADX INFO: compiled from: SmsMmsObserver.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/smssdk/SmsMmsObserver$Companion;", "", "()V", "DELETE_ACTION", "", "INSERT_ACTION", "TAG", "UPDATE_ACTION", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$fOKCvQLYR4pvd0CcTn1cReAg9is(SmsMmsObserver r0) {
        updateDeleteRunnable$lambda$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$lSYrA-A1eInpKpeUKJn1UNp9RjI, reason: not valid java name */
    public static /* synthetic */ void m767$r8$lambda$lSYrAA1eInpKpeUKJn1UNp9RjI(SmsMmsObserver r0) {
        updateIndexRunnable$lambda$0(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public SmsMmsObserver(Handler r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2);
        this.handler = r2;
        this.context = r3;
        this.pendingIndexSmsIds = new LinkedHashSet();
        this.pendingDeleteSmsIds = new LinkedHashSet();
        this.pendingUpdateSmsIds = new LinkedHashSet();
        this.pendingIndexMmsIds = new LinkedHashSet();
        this.pendingDeleteMmsIds = new LinkedHashSet();
        this.pendingUpdateMmsIds = new LinkedHashSet();
        this.delayMillis = 1000;
        this.updateIndexRunnable = new SmsMmsObserver$$ExternalSyntheticLambda0(this);
        this.updateDeleteRunnable = new SmsMmsObserver$$ExternalSyntheticLambda1(this);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    private static final void updateIndexRunnable$lambda$0(SmsMmsObserver r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (((!r4.pendingIndexSmsIds.isEmpty()) | (!r4.pendingUpdateSmsIds.isEmpty())) == false) goto L8;
        List<String> r0 = CollectionsKt.toList(CollectionsKt.union(r4.pendingIndexSmsIds, r4.pendingUpdateSmsIds));
        r4.pendingIndexSmsIds.clear();
        r4.pendingUpdateSmsIds.clear();
        List<MessageEntity> r1 = SmsMmsDatabaseUtil.INSTANCE.getSmsMmsByRowIds(r0, SmsMmsDatabaseUtil.SMS_TYPE, r4.context);
        r4.printMessageEntity(r1);
        if ((!r1.isEmpty()) == false) goto L8;
        CallSmsEntityChangeObserver.INSTANCE.bulkIndex(r1);
    L8:
        if (((!r4.pendingIndexMmsIds.isEmpty()) | (!r4.pendingUpdateMmsIds.isEmpty())) == false) goto L13;
        List<String> r2 = CollectionsKt.toList(CollectionsKt.union(r4.pendingIndexMmsIds, r4.pendingUpdateMmsIds));
        r4.pendingIndexMmsIds.clear();
        r4.pendingUpdateMmsIds.clear();
        List<MessageEntity> r3 = SmsMmsDatabaseUtil.INSTANCE.getSmsMmsByRowIds(r2, SmsMmsDatabaseUtil.MMS_TYPE, r4.context);
        r4.printMessageEntity(r3);
        if ((!r3.isEmpty()) == false) goto L14;
        CallSmsEntityChangeObserver.INSTANCE.bulkIndex(r3);
        return;
    L14:
        return;
    }

    private static final void updateDeleteRunnable$lambda$3(SmsMmsObserver r9) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        if ((!r9.pendingDeleteSmsIds.isEmpty()) == false) goto L10;
        Set<String> r0 = r9.pendingDeleteSmsIds;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r5.add("sms_" + ((String) r1.next()));
        goto L6
    L8:
        ArrayList r6 = r5;
        Logger.INSTANCE.d(TAG, "updateDeleteRunnable: " + r6);
        r9.pendingDeleteSmsIds.clear();
        CallSmsEntityChangeObserver.INSTANCE.bulkDelete(r6, 101);
    L10:
        if ((!r9.pendingDeleteMmsIds.isEmpty()) == false) goto L19;
        Set<String> r2 = r9.pendingDeleteMmsIds;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        r7.add("mms_" + ((String) r3.next()));
        goto L13
    L15:
        ArrayList r8 = r7;
        Logger.INSTANCE.d(TAG, "updateDeleteRunnable: " + r8);
        r9.pendingDeleteMmsIds.clear();
        CallSmsEntityChangeObserver.INSTANCE.bulkDelete(r8, 101);
        return;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r9, Uri r10) {
        Logger.INSTANCE.d(TAG, "Observer changed!!!, uri = " + r10);
        String r11 = null;
        if (r10 == null) goto L5;
        String r0 = r10.getQueryParameter("type");
    L6:
        if (r10 == null) goto L8;
        String r1 = r10.getQueryParameter(CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
    L9:
        if (r10 == null) goto L11;
        r11 = r10.getQueryParameter("rowIds");
    L11:
        if (r0 == null) goto L98;
        if (r1 == null) goto L117;
        if (r11 == null) goto L118;
        List r12 = StringsKt.split$default(r11, new String[]{SimContactsConstants.EMAIL_SEP}, false, 0, 6, null);
        int r13 = r1.hashCode();
        if (r13 == (-1335458389)) goto L65;
        if (r13 == (-1183792455)) goto L44;
        if (r13 == (-838846263)) goto L23;
        return;
    L23:
        if (r1.equals("update") == true) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(r0, SmsMmsDatabaseUtil.SMS_TYPE) == false) goto L35;
        Set<String> r14 = this.pendingUpdateSmsIds;
        monitor-enter(r14);
        this.pendingUpdateSmsIds.addAll(r12);     // Catch: Throwable -> L32
        monitor-exit(r14);
    L39:
        this.handler.removeCallbacks(this.updateIndexRunnable);
        this.handler.postDelayed(this.updateIndexRunnable, this.delayMillis);
        return;
    L32:
        th = move-exception;
        throw th;
    L35:
        Set<String> r15 = this.pendingUpdateMmsIds;
        monitor-enter(r15);
        this.pendingUpdateMmsIds.addAll(r12);     // Catch: Throwable -> L40
        monitor-exit(r15);
    L40:
        th = move-exception;
        throw th;
    L44:
        if (r1.equals("insert") == true) goto L47;
        return;
    L47:
        if (Intrinsics.areEqual(r0, SmsMmsDatabaseUtil.SMS_TYPE) == false) goto L56;
        Set<String> r16 = this.pendingIndexSmsIds;
        monitor-enter(r16);
        this.pendingIndexSmsIds.addAll(r12);     // Catch: Throwable -> L53
        monitor-exit(r16);
    L60:
        this.handler.removeCallbacks(this.updateIndexRunnable);
        this.handler.postDelayed(this.updateIndexRunnable, this.delayMillis);
        return;
    L53:
        th = move-exception;
        throw th;
    L56:
        Set<String> r17 = this.pendingIndexMmsIds;
        monitor-enter(r17);
        this.pendingIndexMmsIds.addAll(r12);     // Catch: Throwable -> L61
        monitor-exit(r17);
    L61:
        th = move-exception;
        throw th;
    L65:
        if (r1.equals("delete") == true) goto L68;
        return;
    L68:
        if (Intrinsics.areEqual(r0, SmsMmsDatabaseUtil.SMS_TYPE) == false) goto L83;
        Set<String> r18 = this.pendingDeleteSmsIds;
        monitor-enter(r18);
        this.pendingDeleteSmsIds.addAll(r12);     // Catch: Throwable -> L80
        Set r19 = CollectionsKt.intersect(this.pendingDeleteSmsIds, this.pendingUpdateSmsIds);     // Catch: Throwable -> L80
        if ((!r19.isEmpty()) == false) goto L74;
        this.pendingUpdateSmsIds.removeAll(r19);     // Catch: Throwable -> L80
    L74:
        Set r20 = CollectionsKt.intersect(this.pendingDeleteSmsIds, this.pendingIndexSmsIds);     // Catch: Throwable -> L80
        if ((!r20.isEmpty()) == false) goto L77;
        this.pendingIndexSmsIds.removeAll(r20);     // Catch: Throwable -> L80
        this.pendingDeleteSmsIds.removeAll(r20);     // Catch: Throwable -> L80
    L77:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L80
        monitor-exit(r18);
    L93:
        this.handler.removeCallbacks(this.updateDeleteRunnable);
        this.handler.postDelayed(this.updateDeleteRunnable, this.delayMillis);
        return;
    L80:
        th = move-exception;
        throw th;
    L83:
        Set<String> r110 = this.pendingDeleteMmsIds;
        monitor-enter(r110);
        this.pendingDeleteMmsIds.addAll(r12);     // Catch: Throwable -> L95
        Set r22 = CollectionsKt.intersect(this.pendingDeleteMmsIds, this.pendingUpdateMmsIds);     // Catch: Throwable -> L95
        if ((!r22.isEmpty()) == false) goto L88;
        this.pendingUpdateMmsIds.removeAll(r22);     // Catch: Throwable -> L95
    L88:
        Set r23 = CollectionsKt.intersect(this.pendingDeleteMmsIds, this.pendingIndexMmsIds);     // Catch: Throwable -> L95
        if ((!r23.isEmpty()) == false) goto L91;
        this.pendingDeleteMmsIds.removeAll(r23);     // Catch: Throwable -> L95
        this.pendingIndexMmsIds.removeAll(r23);     // Catch: Throwable -> L95
    L91:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L95
        monitor-exit(r110);
    L95:
        th = move-exception;
        throw th;
    L118:
        return;
    L117:
        return;
    L98:
        return;
    L8:
        r1 = null;
        goto L9
    L5:
        r0 = null;
        goto L6
    }

    private final void printMessageEntity(List<MessageEntity> r4) {
        Iterator<T> r3 = r4.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        MessageEntity r5 = (MessageEntity) r3.next();
        Logger.INSTANCE.d(TAG, "printMessageEntity, msg_id = " + r5.getId() + ", status = " + r5.getMessageStatusType());
        goto L4
    }
}
