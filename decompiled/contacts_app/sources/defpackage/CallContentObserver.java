package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.android.contacts.common.SimContactsConstants;
import com.obric.callandsms.common.CallSmsEntityChangeObserver;
import com.obric.callandsms.common.Logger;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.contactsdk.ContactChange;
import com.obric.contactsdk.HandlerUtils;
import com.obric.contactsdk.loader.CallHistoryEntityUtilKt;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import com.obric.contactsdk.loader.ContractKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallContentObserver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"LCallContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "mContext", "Landroid/content/Context;", "(Landroid/os/Handler;Landroid/content/Context;)V", "delayMillis", "", "getHandler", "()Landroid/os/Handler;", "getMContext", "()Landroid/content/Context;", "pendingContactUris", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Landroid/net/Uri;", "pendingDeleteCallLogIds", "", "kotlin.jvm.PlatformType", "pendingDeleteContactIds", "pendingDeleteContactUris", "pendingIndexCallLogIds", "pendingIndexContactIds", "pendingIndexContactUris", "updateDeleteRunnable", "Ljava/lang/Runnable;", "updateIndexRunnable", "updateUriRunnable", "convertIdsToList", "", "ids", "onChange", "", "selfChange", "", "uri", "queryEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entityIds", "entityType", "", "Companion", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallContentObserver extends ContentObserver {
    public static final Companion Companion = null;
    public static final String TAG = "CallContentObserver";
    private final long delayMillis;
    private final Handler handler;
    private final Context mContext;
    private final CopyOnWriteArraySet<Uri> pendingContactUris;
    private final CopyOnWriteArraySet<String> pendingDeleteCallLogIds;
    private final CopyOnWriteArraySet<String> pendingDeleteContactIds;
    private final CopyOnWriteArraySet<Uri> pendingDeleteContactUris;
    private final CopyOnWriteArraySet<String> pendingIndexCallLogIds;
    private final CopyOnWriteArraySet<String> pendingIndexContactIds;
    private final CopyOnWriteArraySet<Uri> pendingIndexContactUris;
    private final Runnable updateDeleteRunnable;
    private final Runnable updateIndexRunnable;
    private final Runnable updateUriRunnable;

    /* JADX INFO: compiled from: CallContentObserver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"LCallContentObserver$Companion;", "", "()V", "TAG", "", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$MQHdTLR0mCfdpt-7fS6LvWtiUSM, reason: not valid java name */
    public static /* synthetic */ void m0$r8$lambda$MQHdTLR0mCfdpt7fS6LvWtiUSM(CallContentObserver r0) {
        updateIndexRunnable$lambda$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$b0OH3O_s6RqTNCVOObKUs65Gm3I(CallContentObserver r0) {
        updateUriRunnable$lambda$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$gqnwcygslxMiqJ8aRdQpZAAGqpQ(CallContentObserver r0) {
        updateDeleteRunnable$lambda$1(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public CallContentObserver(Handler r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r3, "mContext");
        super(r2);
        this.handler = r2;
        this.mContext = r3;
        this.pendingIndexCallLogIds = new CopyOnWriteArraySet(CollectionsKt.emptyList());
        this.pendingIndexContactIds = new CopyOnWriteArraySet(CollectionsKt.emptyList());
        this.pendingDeleteContactIds = new CopyOnWriteArraySet(CollectionsKt.emptyList());
        this.pendingDeleteCallLogIds = new CopyOnWriteArraySet(CollectionsKt.emptyList());
        this.pendingIndexContactUris = new CopyOnWriteArraySet(CollectionsKt.emptyList());
        this.pendingDeleteContactUris = new CopyOnWriteArraySet(CollectionsKt.emptyList());
        this.pendingContactUris = new CopyOnWriteArraySet(CollectionsKt.emptyList());
        this.delayMillis = 1000;
        this.updateIndexRunnable = new CallContentObserver$$ExternalSyntheticLambda0(this);
        this.updateDeleteRunnable = new CallContentObserver$$ExternalSyntheticLambda1(this);
        this.updateUriRunnable = new CallContentObserver$$ExternalSyntheticLambda2(this);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    private static final void updateIndexRunnable$lambda$0(CallContentObserver r7) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        if ((!r7.pendingIndexCallLogIds.isEmpty()) == false) goto L6;
        List<String> r0 = CollectionsKt.toList(r7.pendingIndexCallLogIds);
        Logger.INSTANCE.d(TAG, "updateIndexRunnable: " + r0);
        r7.pendingIndexCallLogIds.clear();
        List<AppEntity> r3 = CallHistoryEntityUtilKt.filterExpiredCallHistoryEntities(r7.queryEntities(r0, 202));
        Logger.INSTANCE.d(TAG, "updateIndexRunnable CALL_HISTORY: " + r0 + ", after filter: " + r3.size());
        CallSmsEntityChangeObserver.INSTANCE.bulkIndex(r3);
    L6:
        if ((!r7.pendingIndexContactIds.isEmpty()) == false) goto L9;
        List<String> r1 = CollectionsKt.toList(r7.pendingIndexContactIds);
        r7.pendingIndexContactIds.clear();
        List<AppEntity> r8 = r7.queryEntities(r1, 201);
        Logger.INSTANCE.d(TAG, "updateIndexRunnable CONTACT: " + r1 + ", after filter: " + r8.size());
        CallSmsEntityChangeObserver.INSTANCE.bulkIndex(r8);
        return;
    }

    private static final void updateDeleteRunnable$lambda$1(CallContentObserver r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if ((!r5.pendingDeleteContactIds.isEmpty()) == false) goto L6;
        List<String> r0 = CollectionsKt.toList(r5.pendingDeleteContactIds);
        Logger.INSTANCE.d(TAG, "updateDeleteRunnable: " + r0);
        r5.pendingDeleteContactIds.clear();
        CallSmsEntityChangeObserver.INSTANCE.bulkDelete(r0, 201);
    L6:
        if ((!r5.pendingDeleteCallLogIds.isEmpty()) == false) goto L9;
        List<String> r1 = CollectionsKt.toList(r5.pendingDeleteCallLogIds);
        Logger.INSTANCE.d(TAG, "updateDeleteRunnable: " + r1);
        r5.pendingDeleteCallLogIds.clear();
        CallSmsEntityChangeObserver.INSTANCE.bulkDelete(r1, 202);
        return;
    }

    private static final void updateUriRunnable$lambda$2(CallContentObserver r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if ((!r1.pendingContactUris.isEmpty()) == false) goto L6;
        List<? extends Uri> r0 = CollectionsKt.toList(r1.pendingContactUris);
        r1.pendingContactUris.clear();
        ContactChange.INSTANCE.update(r0);
        return;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r7, Uri r8) {
        super.onChange(r7, r8);
        String r9 = null;
        if (r8 == null) goto L5;
        String r0 = r8.getQueryParameter(ContractKt.PARAM_ACTION_DOMAIN);
    L6:
        if (r8 == null) goto L8;
        String r1 = r8.getQueryParameter("type");
    L9:
        if (r8 == null) goto L11;
        r9 = r8.getQueryParameter("id");
    L11:
        Logger.INSTANCE.d(TAG, "onChange: " + r0 + ' ' + r1 + ' ' + r9 + ' ' + r8);
        if (r0 == null) goto L88;
        if (r1 == null) goto L99;
        if (r9 == null) goto L100;
        List<String> r10 = convertIdsToList(r9);
        if (Intrinsics.areEqual(r0, ContractKt.PARAM_ACTION_DOMAIN_CALLLOG) == false) goto L19;
        char r2 = 202;
    L23:
        if (Intrinsics.areEqual(r1, "index") == false) goto L49;
        if (r2 != 202) goto L33;
        CopyOnWriteArraySet<String> r3 = this.pendingIndexCallLogIds;
        monitor-enter(r3);
        this.pendingIndexCallLogIds.addAll(r10);     // Catch: Throwable -> L30
        monitor-exit(r3);
    L30:
        th = move-exception;
        throw th;
    L33:
        if (r2 != 201) goto L42;
        CopyOnWriteArraySet<String> r4 = this.pendingIndexCallLogIds;
        monitor-enter(r4);
        this.pendingIndexContactIds.addAll(r10);     // Catch: Throwable -> L39
        monitor-exit(r4);
    L39:
        th = move-exception;
        throw th;
    L42:
        Handler r11 = HandlerUtils.INSTANCE.getHandler();
        if (r11 == null) goto L45;
        r11.removeCallbacks(this.updateIndexRunnable);
    L45:
        Handler r12 = HandlerUtils.INSTANCE.getHandler();
        if (r12 == null) goto L74;
        r12.postDelayed(this.updateIndexRunnable, this.delayMillis);
    L74:
        if (r2 != 201) goto L101;
        CopyOnWriteArraySet<Uri> r13 = this.pendingContactUris;
        monitor-enter(r13);
        this.pendingContactUris.add(r8);     // Catch: Throwable -> L85
        monitor-exit(r13);
        Handler r14 = HandlerUtils.INSTANCE.getHandler();
        if (r14 == null) goto L82;
        r14.removeCallbacks(this.updateUriRunnable);
    L82:
        Handler r15 = HandlerUtils.INSTANCE.getHandler();
        if (r15 == null) goto L102;
        r15.postDelayed(this.updateUriRunnable, this.delayMillis);
        return;
    L102:
        return;
    L85:
        th = move-exception;
        throw th;
    L101:
        return;
    L49:
        if (Intrinsics.areEqual(r1, "delete") == false) goto L74;
        if (r2 != 202) goto L59;
        CopyOnWriteArraySet<String> r5 = this.pendingDeleteCallLogIds;
        monitor-enter(r5);
        this.pendingDeleteCallLogIds.addAll(r10);     // Catch: Throwable -> L56
        monitor-exit(r5);
    L56:
        th = move-exception;
        throw th;
    L59:
        if (r2 != 201) goto L68;
        CopyOnWriteArraySet<String> r6 = this.pendingDeleteContactIds;
        monitor-enter(r6);
        this.pendingDeleteContactIds.addAll(r10);     // Catch: Throwable -> L65
        monitor-exit(r6);
    L65:
        th = move-exception;
        throw th;
    L68:
        Handler r16 = HandlerUtils.INSTANCE.getHandler();
        if (r16 == null) goto L71;
        r16.removeCallbacks(this.updateDeleteRunnable);
    L71:
        Handler r17 = HandlerUtils.INSTANCE.getHandler();
        if (r17 == null) goto L74;
        r17.postDelayed(this.updateDeleteRunnable, this.delayMillis);
        goto L74
    L19:
        if (Intrinsics.areEqual(r0, ContractKt.PARAM_ACTION_DOMAIN_CONTACTS) == false) goto L21;
        r2 = 201;
        goto L23
    L21:
        r2 = 0;
        goto L23
    L100:
        return;
    L99:
        return;
    L88:
        return;
    L8:
        r1 = null;
        goto L9
    L5:
        r0 = null;
        goto L6
    }

    private final List<AppEntity> queryEntities(List<String> r8, int r9) {
        if (r9 != 201) goto L5;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        Long r0 = StringsKt.toLongOrNull((String) r11.next());
        if (r0 == null) goto L16;
        r10.add(r0);
        goto L16
    L20:
        ArrayList r12 = r10;
        Logger.INSTANCE.d(TAG, "queryEntities: " + r12);
        ContentResolver r13 = this.mContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r13, "mContext.contentResolver");
        List<AppEntity> r14 = CollectionsKt.toMutableList(ContactEntityUtilKt.queryContactsByIds(r13, r12, false, true));
        String r15 = ContactEntityUtilKt.getProfileContactsId(this.mContext, r12);
        if (r15 == null) goto L24;
        Logger.INSTANCE.d(TAG, "queryEntities has profile: " + r15);
        ContentResolver r7 = this.mContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r7, "mContext.contentResolver");
        r14.addAll(ContactEntityUtilKt.queryContactsByIds(r7, CollectionsKt.mutableListOf(new Long[]{Long.valueOf(Long.parseLong(r15))}), true, false));
    L24:
        return r14;
    L5:
        if (r9 != 202) goto L35;
        ContentResolver r16 = this.mContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r16, "mContext.contentResolver");
        ArrayList r1 = new ArrayList();
        Iterator<T> r17 = r8.iterator();
    L9:
        if (r17.hasNext() == false) goto L36;
        Long r2 = StringsKt.toLongOrNull((String) r17.next());
        if (r2 == null) goto L9;
        r1.add(r2);
        goto L9
    L36:
        return CallHistoryEntityUtilKt.queryCallLogsByIds(r16, r1, this.mContext);
    L35:
        return CollectionsKt.emptyList();
    }

    public final List<String> convertIdsToList(String r8) {
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
        System.out.println("Error converting ids to list: " + e.getMessage());
        return r7;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
