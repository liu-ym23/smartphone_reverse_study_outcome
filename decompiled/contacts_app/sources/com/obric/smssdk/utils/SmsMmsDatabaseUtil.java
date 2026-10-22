package com.obric.smssdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import androidx.room.FtsOptions;
import bytedanceos.app.mms.verification.VerificationManager;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.obricsync.SyncContractKt;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.callandsms.common.Logger;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import com.obric.smssdk.SmsMmsColumnsMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SmsMmsDatabaseUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001IB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u000200J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u0004H\u0002J\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050-2\u0006\u0010/\u001a\u000200J2\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002080-072\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0007J(\u0010>\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010/\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010C\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0007J*\u0010D\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200J \u0010G\u001a\b\u0012\u0004\u0012\u0002050-2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010F\u001a\u00020\u000fH\u0002J\u0018\u0010H\u001a\b\u0012\u0004\u0012\u0002050-2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0019\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u000e\u0010\u001b\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b!\u0010\u0011R\u0019\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b#\u0010\u0011R\u0019\u0010$\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\nR\u0019\u0010&\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\nR\u0019\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b)\u0010\u0011R\u000e\u0010*\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/smssdk/utils/SmsMmsDatabaseUtil;", "", "()V", "MESSAGE_TYPE_RETRIEVE_CONF", "", "MESSAGE_TYPE_SEND_REQ", "MMS_CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getMMS_CONTENT_URI", "()Landroid/net/Uri;", "MMS_DRAFT_CONTENT_URI", "getMMS_DRAFT_CONTENT_URI", "MMS_PROJECTION", "", "", "getMMS_PROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "MMS_SMS_CANONICAL_URI", "getMMS_SMS_CANONICAL_URI", "MMS_SMS_CONTENT_URI", "getMMS_SMS_CONTENT_URI", "MMS_SMS_OBSERVER_URI", "getMMS_SMS_OBSERVER_URI", "MMS_SMS_THREAD_URI", "getMMS_SMS_THREAD_URI", "MMS_TYPE", "PROJECTION", "getPROJECTION", "SAMPLE_MMS_DRAFT_PROJECTION", "getSAMPLE_MMS_DRAFT_PROJECTION", "SAMPLE_PROJECTION", "getSAMPLE_PROJECTION", "SAMPLE_SMS_DRAFT_PROJECTION", "getSAMPLE_SMS_DRAFT_PROJECTION", "SMS_CONTENT_URI", "getSMS_CONTENT_URI", "SMS_DRAFT_CONTENT_URI", "getSMS_DRAFT_CONTENT_URI", "SMS_PROJECTION", "getSMS_PROJECTION", "SMS_TYPE", "TAG", "getAllMessages", "", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "context", "Landroid/content/Context;", "getMessageStatus", "Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "code", "getMessageSyncSamples", "Lcom/obric/smssdk/utils/SmsMmsDatabaseUtil$MessageSyncSample;", "getMmsPart", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "mmsId", "createTime", "", "contentResolver", "Landroid/content/ContentResolver;", "getMmsSmsInfo", "cursor", "Landroid/database/Cursor;", "mmsSmsType", "getPhoneNumberByThreadId", "threadId", "getSmsMmsByRowIds", "rowIds", "type", "parseDraftSampleEntities", "parseSampleEntities", "MessageSyncSample", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SmsMmsDatabaseUtil {
    public static final SmsMmsDatabaseUtil INSTANCE = null;
    public static final int MESSAGE_TYPE_RETRIEVE_CONF = 132;
    public static final int MESSAGE_TYPE_SEND_REQ = 128;
    private static final Uri MMS_CONTENT_URI = null;
    private static final Uri MMS_DRAFT_CONTENT_URI = null;
    private static final String[] MMS_PROJECTION = null;
    private static final Uri MMS_SMS_CANONICAL_URI = null;
    private static final Uri MMS_SMS_CONTENT_URI = null;
    private static final Uri MMS_SMS_OBSERVER_URI = null;
    private static final Uri MMS_SMS_THREAD_URI = null;
    public static final String MMS_TYPE = "mms";
    private static final String[] PROJECTION = null;
    private static final String[] SAMPLE_MMS_DRAFT_PROJECTION = null;
    private static final String[] SAMPLE_PROJECTION = null;
    private static final String[] SAMPLE_SMS_DRAFT_PROJECTION = null;
    private static final Uri SMS_CONTENT_URI = null;
    private static final Uri SMS_DRAFT_CONTENT_URI = null;
    private static final String[] SMS_PROJECTION = null;
    public static final String SMS_TYPE = "sms";
    public static final String TAG = "SmsMmsDatabaseUtil";

    /* JADX INFO: compiled from: SmsMmsDatabaseUtil.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/smssdk/utils/SmsMmsDatabaseUtil$MessageSyncSample;", "", "rowId", "", "type", "", "lastModifyTime", "(JLjava/lang/String;J)V", "getLastModifyTime", "()J", "getRowId", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MessageSyncSample {
        private final long lastModifyTime;
        private final long rowId;
        private final String type;

        public static /* synthetic */ MessageSyncSample copy$default(MessageSyncSample r6, long r7, String r9, long r10, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.rowId;
        L5:
            long r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r9 = r6.type;
        L8:
            String r3 = r9;
            if ((r12 & 4) == 0) goto L12;
            r10 = r6.lastModifyTime;
        L12:
            return r6.copy(r1, r3, r10);
        }

        public final long component1() {
            return this.rowId;
        }

        public final String component2() {
            return this.type;
        }

        public final long component3() {
            return this.lastModifyTime;
        }

        public final MessageSyncSample copy(long r7, String r9, long r10) {
            Intrinsics.checkNotNullParameter(r9, "type");
            return new MessageSyncSample(r7, r9, r10);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof MessageSyncSample) == true) goto L8;
            return false;
        L8:
            MessageSyncSample r9 = (MessageSyncSample) r8;
            if (this.rowId == r9.rowId) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r9.type) == true) goto L15;
            return false;
        L15:
            if (this.lastModifyTime == r9.lastModifyTime) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.rowId) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.lastModifyTime);
        }

        public String toString() {
            return "MessageSyncSample(rowId=" + this.rowId + ", type=" + this.type + ", lastModifyTime=" + this.lastModifyTime + ')';
        }

        public MessageSyncSample(long r2, String r4, long r5) {
            Intrinsics.checkNotNullParameter(r4, "type");
            this.rowId = r2;
            this.type = r4;
            this.lastModifyTime = r5;
        }

        public final long getRowId() {
            return this.rowId;
        }

        public final String getType() {
            return this.type;
        }

        public final long getLastModifyTime() {
            return this.lastModifyTime;
        }
    }

    private SmsMmsDatabaseUtil() {
    }

    public final String[] getPROJECTION() {
        return PROJECTION;
    }

    static {
        INSTANCE = new SmsMmsDatabaseUtil();
        PROJECTION = new String[]{"transport_type", "_id", TracingConstants.KEY_THREAD_NAME, SyncContractKt.COLUMN_ADDRESS, "body", "date", "date_sent", "type", "date", "date_sent", "m_type", "msg_box", "text_only", "ct_t"};
        SMS_PROJECTION = new String[]{"_id", TracingConstants.KEY_THREAD_NAME, SyncContractKt.COLUMN_ADDRESS, "body", "date", "date_sent", "type"};
        MMS_PROJECTION = new String[]{"_id", TracingConstants.KEY_THREAD_NAME, "date", "date_sent", "m_type", "msg_box", "text_only", "ct_t"};
        SAMPLE_PROJECTION = new String[]{"transport_type", "_id", "date", "date", "m_type"};
        SAMPLE_SMS_DRAFT_PROJECTION = new String[]{"_id", "date"};
        SAMPLE_MMS_DRAFT_PROJECTION = new String[]{"_id", "date", "m_type"};
        MMS_SMS_CONTENT_URI = Uri.parse("content://mms-sms/complete-conversations");
        SMS_CONTENT_URI = Uri.parse("content://sms");
        MMS_CONTENT_URI = Uri.parse("content://mms");
        MMS_SMS_THREAD_URI = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter(FtsOptions.TOKENIZER_SIMPLE, "true").build();
        MMS_SMS_CANONICAL_URI = Uri.parse("content://mms-sms/canonical-addresses");
        MMS_SMS_OBSERVER_URI = Uri.parse("content://sms_change_with_action");
        SMS_DRAFT_CONTENT_URI = Uri.parse("content://sms/draft");
        MMS_DRAFT_CONTENT_URI = Uri.parse("content://mms/drafts");
    }

    public final String[] getSMS_PROJECTION() {
        return SMS_PROJECTION;
    }

    public final String[] getMMS_PROJECTION() {
        return MMS_PROJECTION;
    }

    public final String[] getSAMPLE_PROJECTION() {
        return SAMPLE_PROJECTION;
    }

    public final String[] getSAMPLE_SMS_DRAFT_PROJECTION() {
        return SAMPLE_SMS_DRAFT_PROJECTION;
    }

    public final String[] getSAMPLE_MMS_DRAFT_PROJECTION() {
        return SAMPLE_MMS_DRAFT_PROJECTION;
    }

    public final Uri getMMS_SMS_CONTENT_URI() {
        return MMS_SMS_CONTENT_URI;
    }

    public final Uri getSMS_CONTENT_URI() {
        return SMS_CONTENT_URI;
    }

    public final Uri getMMS_CONTENT_URI() {
        return MMS_CONTENT_URI;
    }

    public final Uri getMMS_SMS_THREAD_URI() {
        return MMS_SMS_THREAD_URI;
    }

    public final Uri getMMS_SMS_CANONICAL_URI() {
        return MMS_SMS_CANONICAL_URI;
    }

    public final Uri getMMS_SMS_OBSERVER_URI() {
        return MMS_SMS_OBSERVER_URI;
    }

    public final Uri getSMS_DRAFT_CONTENT_URI() {
        return SMS_DRAFT_CONTENT_URI;
    }

    public final Uri getMMS_DRAFT_CONTENT_URI() {
        return MMS_DRAFT_CONTENT_URI;
    }

    public final List<MessageEntity> getAllMessages(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Logger.INSTANCE.i(TAG, "in getAllMessages");
        ContentResolver r10 = r11.getContentResolver();
        if (r10 == null) goto L5;
        ArrayList r0 = new ArrayList();
        Cursor r2 = r10.query(MMS_SMS_CONTENT_URI, PROJECTION, null, null, null);     // Catch: Exception -> L30
        SmsMmsDatabaseUtil r8 = INSTANCE;     // Catch: Throwable -> L25
        r0.addAll(r8.getMmsSmsInfo(r2, r11, null));     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L30
        Cursor r3 = r10.query(SMS_DRAFT_CONTENT_URI, SMS_PROJECTION, null, null, null);     // Catch: Exception -> L30
        r0.addAll(r8.getMmsSmsInfo(r3, r11, SMS_TYPE));     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r3, null);     // Catch: Exception -> L30
        Cursor r12 = r10.query(MMS_DRAFT_CONTENT_URI, MMS_PROJECTION, null, null, null);     // Catch: Exception -> L30
        r0.addAll(r8.getMmsSmsInfo(r12, r11, MMS_TYPE));     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L30
    L32:
        Logger.INSTANCE.i(TAG, "getAllMessages size = " + r0.size());
        return r0;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "getAllMessages error", e);
        goto L32
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<MessageSyncSample> getMessageSyncSamples(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        ContentResolver r11 = r10.getContentResolver();
        if (r11 == null) goto L5;
        ArrayList r0 = new ArrayList();
        Cursor r1 = r11.query(MMS_SMS_CONTENT_URI, SAMPLE_PROJECTION, null, null, null);     // Catch: Exception -> L16
        SmsMmsDatabaseUtil r3 = INSTANCE;     // Catch: Throwable -> L11
        r0.addAll(r3.parseSampleEntities(r1));     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r1, null);     // Catch: Exception -> L16
    L41:
        Cursor r2 = r11.query(SMS_DRAFT_CONTENT_URI, SAMPLE_SMS_DRAFT_PROJECTION, null, null, null);     // Catch: Exception -> L34
        SmsMmsDatabaseUtil r8 = INSTANCE;     // Catch: Throwable -> L29
        r0.addAll(r8.parseDraftSampleEntities(r2, SMS_TYPE));     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L34
        Cursor r12 = r11.query(MMS_DRAFT_CONTENT_URI, SAMPLE_MMS_DRAFT_PROJECTION, null, null, null);     // Catch: Exception -> L34
        r0.addAll(r8.parseDraftSampleEntities(r12, MMS_TYPE));     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L34
    L36:
        return r0;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L34
        throw th;     // Catch: Exception -> L34
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L34
        throw th;     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "getMessageSyncSamples draft query error", e);
        goto L36
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Exception -> L16
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "getMessageSyncSamples main query error", e);
        goto L41
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<MessageEntity> getMmsSmsInfo(Cursor r33, Context r34, String r35) {
        SmsMmsDatabaseUtil r0 = this;
        Cursor r1 = r33;
        Intrinsics.checkNotNullParameter(r34, "context");
        ContentResolver r2 = r34.getContentResolver();
        ArrayList r4 = new ArrayList();
        if (r1 == null) goto L51;
        SmsMmsColumnsMap r5 = new SmsMmsColumnsMap(r1);
        Logger.INSTANCE.i(TAG, "getMmsSmsInfo(), cursor size = " + r33.getCount());
    L6:
        if (r33.moveToNext() == false) goto L51;
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        ArrayList r18 = new ArrayList();
        String r9 = "";
        if (r35 != null) goto L12;
        String r10 = r1.getString(r5.getColumnMsgType());
        if (r10 != null) goto L13;
        r10 = "";
    L13:
        long r11 = r1.getLong(r5.getColumnThreadId());
        String r13 = String.valueOf(r1.getLong(r5.getColumnMsgId()));
        if (Intrinsics.areEqual(r10, SMS_TYPE) == true) goto L15;
        if (Intrinsics.areEqual(r10, MMS_TYPE) == false) goto L41;
        int r8 = r1.getInt(r5.getColumnMmsMessageType());
        if (r8 == 128) goto L39;
        if (r8 != 132) goto L6;
    L39:
        long r3 = r1.getLong(r5.getColumnMmsDate()) * 1000;
        Intrinsics.checkNotNullExpressionValue(r2, "contentResolver");
        List<String> r12 = r0.getPhoneNumberByThreadId(r11, r2);
        Pair<String, List<FileEntity>> r14 = r0.getMmsPart(r13, r3, r2);
        String r15 = r14.getFirst();
        TypeIntrinsics.asMutableList(r7).addAll(r14.getSecond());
        MessageStatusTypeEnum r16 = r0.getMessageStatus(r1.getInt(r5.getColumnMmsMessageBox()));
        long r19 = r3;
        List<String> r17 = r12;
        String r110 = r15;
    L40:
        MessageTypeEnum r20 = null;
    L42:
        Iterator<T> r111 = r17.iterator();
    L44:
        if (r111.hasNext() == false) goto L49;
        String r112 = (String) r111.next();
        Intrinsics.checkNotNullExpressionValue(r2, "contentResolver");
        String r113 = ContactEntityUtilKt.getContactIdByPhoneNumber(r2, r112);
        Logger.INSTANCE.d(TAG, "contactId = " + r113);
        if (r113 == null) goto L44;
        TypeIntrinsics.asMutableList(r18).add(new ContactEntity(r113, 0, 0, "", null));
        goto L44
    L49:
        MessageEntity r21 = new MessageEntity(r10 + '_' + r13, r3, r19, r17, r110, r18);
        r21.setMessageType(r20);
        r21.setFiles(r7);
        r21.setMessageStatusType(r16);
        TypeIntrinsics.asMutableList(r4).add(r21);
        r0 = this;
        r1 = r33;
        r4 = r4;
        goto L6
    L41:
        r4 = r4;
        r3 = -1;
        r19 = -1;
        r17 = r6;
        r110 = "";
        r20 = null;
        r16 = null;
        goto L42
    L15:
        r19 = r1.getLong(r5.getColumnSmsDate());
        String r114 = r1.getString(r5.getColumnSmsAddress());
        if (r114 != null) goto L18;
        r114 = "";
    L18:
        String r115 = r114;
        if (TextUtils.isEmpty(r115) == false) goto L21;
        Intrinsics.checkNotNullExpressionValue(r2, "contentResolver");
        r6 = r0.getPhoneNumberByThreadId(r11, r2);
    L22:
        String r116 = r1.getString(r5.getColumnSmsBody());
        if (r116 == null) goto L26;
        r9 = r116;
    L26:
        MessageStatusTypeEnum r117 = r0.getMessageStatus(r1.getInt(r5.getColumnSmsType()));
        if (VerificationManager.getInstance(r34).parseVerificationCode(r9) != null) goto L29;
    L31:
        r17 = r6;
        r110 = r9;
        r16 = r117;
        r3 = r19;
        goto L40
    L29:
        if (r117 != MessageStatusTypeEnum.INBOX) goto L31;
        r4 = r4;
        r17 = r6;
        r110 = r9;
        r16 = r117;
        r20 = MessageTypeEnum.VERIFICATION_CODE;
        r3 = r19;
        goto L42
    L21:
        TypeIntrinsics.asMutableList(r6).add(new Regex("\\s").replace(r115, ""));
        goto L22
    L12:
        r10 = r35;
    L51:
        return r4;
    }

    public final List<String> getPhoneNumberByThreadId(long r20, ContentResolver r22) {
        Intrinsics.checkNotNullParameter(r22, "contentResolver");
        if (r20 <= 0) goto L5;
        ArrayList r5 = new ArrayList();
        Cursor r0 = r22.query(MMS_SMS_THREAD_URI, new String[]{"recipient_ids"}, "_id = " + r20, null, null);     // Catch: Exception -> L71
        if (r0 == null) goto L24;
        Cursor r4 = r0;     // Catch: Exception -> L71
        Cursor r1 = r4;     // Catch: Throwable -> L17
        if (r1.moveToFirst() == false) goto L13;
        String r2 = r1.getString(0);     // Catch: Throwable -> L17
    L14:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L71
    L26:
        if (TextUtils.isEmpty(r2) == true) goto L28;
        Logger.INSTANCE.d(TAG, "in getPhoneNumberByThreadId, spaceSepIds = " + r2);     // Catch: Exception -> L71
        if (r2 == null) goto L44;
        List r3 = StringsKt.split$default(r2, new String[]{HanziToPinyin.Token.SEPARATOR}, false, 0, 6, null);     // Catch: Exception -> L71
        if (r3 == null) goto L44;
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L71
        Iterator r8 = r3.iterator();     // Catch: Exception -> L71
    L35:
        if (r8.hasNext() == false) goto L43;
        Long r9 = Long.valueOf(Long.parseLong((String) r8.next()));     // Catch: NumberFormatException -> L39 Exception -> L71
    L41:
        if (r9 == null) goto L35;
        r7.add(r9);     // Catch: Exception -> L71
        goto L35
    L39:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "in function getPhoneNumberByThreadId", e);     // Catch: Exception -> L71
        r9 = null;
        goto L41
    L43:
        ArrayList r10 = r7;     // Catch: Exception -> L71
    L46:
        if (r10.isEmpty() == true) goto L48;
        Cursor r11 = r22.query(MMS_SMS_CANONICAL_URI, null, "_id in " + StringsKt.replace$default(StringsKt.replace$default(r10.toString(), "[", "(", false, 4, null), "]", ")", false, 4, null), null, null);     // Catch: Exception -> L71
        if (r11 == null) goto L73;
        Cursor r12 = r11;     // Catch: Exception -> L71
        Cursor r13 = r12;     // Catch: Throwable -> L64
    L54:
        if (r13.moveToNext() == false) goto L61;
        String r14 = r13.getString(r13.getColumnIndex(SyncContractKt.COLUMN_ADDRESS));     // Catch: Throwable -> L64
        if (r14 == null) goto L58;
        String r15 = new Regex("\\s").replace(r14, "");     // Catch: Throwable -> L64
    L59:
        if (r15 == null) goto L54;
        Logger.INSTANCE.d(TAG, "in getPhoneNumberByThreadId, address != null");     // Catch: Throwable -> L64
        r5.add(r15);     // Catch: Throwable -> L64
        goto L54
    L58:
        r15 = null;
        goto L59
    L61:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L71
        goto L73
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L71
        throw th;     // Catch: Exception -> L71
    L73:
        return r5;
    L48:
        return CollectionsKt.emptyList();
    L44:
        r10 = CollectionsKt.emptyList();     // Catch: Exception -> L71
        goto L46
    L28:
        return CollectionsKt.emptyList();
    L13:
        r2 = null;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L71
        throw th;     // Catch: Exception -> L71
    L24:
        r2 = null;
    L71:
        Logger.e$default(Logger.INSTANCE, TAG, "in getPhoneNumberByThreadId", null, 4, null);
        goto L73
    L5:
        return CollectionsKt.emptyList();
    }

    public final Pair<String, List<FileEntity>> getMmsPart(String r21, long r22, ContentResolver r24) {
        Intrinsics.checkNotNullParameter(r21, "mmsId");
        Intrinsics.checkNotNullParameter(r24, "contentResolver");
        Cursor r0 = r24.query(Uri.parse(Telephony.Mms.CONTENT_URI.toString()).buildUpon().appendPath(r21).appendPath("part").build(), null, null, null, null);
        ArrayList r1 = new ArrayList();
        Logger.INSTANCE.i(TAG, "in getMmsPart, cursor = " + r0);
        String r2 = "";
        if (r0 == null) goto L24;
        Cursor r3 = r0;
        Cursor r4 = r3;     // Catch: Throwable -> L17
    L7:
        if (r4.moveToNext() == false) goto L15;
        long r5 = r4.getLong(r4.getColumnIndex("_id"));     // Catch: Throwable -> L17
        String r7 = r4.getString(r4.getColumnIndex("ct"));     // Catch: Throwable -> L17
        String r8 = r4.getString(r4.getColumnIndex("text"));     // Catch: Throwable -> L17
        String r9 = r4.getString(r4.getColumnIndex("_data"));     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r7, "application/smil") == true) goto L7;
        if (r8 != null) goto L12;
        if (r9 == null) goto L7;
        Uri r6 = Uri.withAppendedPath(Uri.parse("content://mms/part"), String.valueOf(r5));     // Catch: Throwable -> L17
        Logger.INSTANCE.i(TAG, "partUri = " + r6 + ", filePath = " + r9);     // Catch: Throwable -> L17
        String r14 = new File(r9).getName();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r14, "File(data).name");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r6, "partUri");     // Catch: Throwable -> L17
        r1.add(new FileEntity(r9, r22, r22, r14, 0, r6, FileTypeEnum.FILE, r7));     // Catch: Throwable -> L17
        goto L7
    L12:
        r2 = r8;
        goto L7
    L15:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r3, null);
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L24:
        return new Pair(r2, r1);
    }

    public final List<MessageEntity> getSmsMmsByRowIds(List<String> r12, String r13, Context r14) {
        Intrinsics.checkNotNullParameter(r12, "rowIds");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "context");
        ContentResolver r0 = r14.getContentResolver();
        if (r0 == null) goto L5;
        String r3 = "_id IN (" + CollectionsKt.joinToString$default(r12, SimContactsConstants.EMAIL_SEP, null, null, 0, null, SmsMmsDatabaseUtil$getSmsMmsByRowIds$selection$1.INSTANCE, 30, null) + ')';
        String[] r4 = (String[]) r12.toArray(new String[0]);
        Logger r11 = Logger.INSTANCE;
        StringBuilder r15 = new StringBuilder("selection = ").append(r3).append(", selectionArgs = ");
        String r1 = Arrays.toString(r4);
        Intrinsics.checkNotNullExpressionValue(r1, "toString(this)");
        r11.d(TAG, r15.append(r1).toString());
    L12:
        Logger.e$default(Logger.INSTANCE, TAG, "in getSmsMmsByRowIds, query failed!!!", null, 4, null);
        Cursor r16 = null;
    L13:
        Cursor r2 = r16;
        Cursor r5 = r2;     // Catch: Throwable -> L17
        List<MessageEntity> r17 = INSTANCE.getMmsSmsInfo(r16, r14, r13);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r2, null);
        return r17;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L8:
        if (Intrinsics.areEqual(r13, SMS_TYPE) == false) goto L10;
        r16 = r0.query(SMS_CONTENT_URI, SMS_PROJECTION, r3, r4, null);     // Catch: Exception -> L12
    L24:
        goto L13
    L10:
        r16 = r0.query(MMS_CONTENT_URI, MMS_PROJECTION, r3, r4, null);     // Catch: Exception -> L12
        goto L24
    L5:
        return CollectionsKt.emptyList();
    }

    private final MessageStatusTypeEnum getMessageStatus(int r1) {
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L22;
        if (r1 == 4) goto L21;
        if (r1 == 5) goto L20;
        return null;
    L20:
        return MessageStatusTypeEnum.SEND_FAILED;
    L21:
        return MessageStatusTypeEnum.SENDING;
    L22:
        return MessageStatusTypeEnum.DRAFT;
    L23:
        return MessageStatusTypeEnum.OUTBOX;
    L18:
        return MessageStatusTypeEnum.INBOX;
    }

    private final List<MessageSyncSample> parseSampleEntities(Cursor r14) {
        ArrayList r13 = new ArrayList();
        if (r14 == null) goto L5;
        int r0 = r14.getColumnIndex("transport_type");
        int r1 = r14.getColumnIndex("_id");
        int r3 = r14.getColumnIndex("date");
        int r2 = r14.getColumnIndex("date");
        int r4 = r14.getColumnIndex("m_type");
    L8:
        if (r14.moveToNext() == false) goto L45;
        if (r0 < 0) goto L11;
        String r5 = r14.getString(r0);
    L12:
        String r9 = r5;
        if (r1 < 0) goto L15;
        long r6 = r14.getLong(r1);
    L16:
        long r7 = r6;
        String r8 = r9;
        if (r8 != null) goto L19;
    L22:
        boolean r10 = true;
    L23:
        if (r10 == true) goto L8;
        long r11 = 0;
        if (r7 <= 0) goto L8;
        if (Intrinsics.areEqual(r9, SMS_TYPE) == true) goto L29;
        if (Intrinsics.areEqual(r9, MMS_TYPE) == false) goto L8;
        if (r4 < 0) goto L36;
        int r12 = r14.getInt(r4);
    L38:
        if (r12 == 128) goto L42;
        if (r12 != 132) goto L8;
    L42:
        if (r2 < 0) goto L44;
        r11 = r14.getLong(r2);
    L44:
        r13.add(new MessageSyncSample(r7, r9, 1000 * r11));
        goto L8
    L36:
        r12 = -1;
        goto L38
    L29:
        if (r3 < 0) goto L31;
        r11 = r14.getLong(r3);
    L31:
        r13.add(new MessageSyncSample(r7, r9, r11));
        goto L8
    L19:
        if (r8.length() == 0) goto L22;
        r10 = false;
        goto L23
    L15:
        r6 = -1;
        goto L16
    L11:
        r5 = null;
        goto L12
    L45:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<MessageSyncSample> parseDraftSampleEntities(Cursor r14, String r15) {
        ArrayList r13 = new ArrayList();
        if (r14 == null) goto L5;
        int r0 = r14.getColumnIndex("_id");
        if (Intrinsics.areEqual(r15, SMS_TYPE) == false) goto L10;
        int r1 = r14.getColumnIndex("date");
    L14:
        if (Intrinsics.areEqual(r15, MMS_TYPE) == false) goto L16;
        int r2 = r14.getColumnIndex("m_type");
    L18:
        if (r14.moveToNext() == false) goto L40;
        if (r0 < 0) goto L21;
        long r5 = r14.getLong(r0);
    L22:
        long r8 = r5;
        long r6 = 0;
        if (r8 <= 0) goto L18;
        if (Intrinsics.areEqual(r15, MMS_TYPE) == false) goto L34;
        if (r2 < 0) goto L28;
        int r7 = r14.getInt(r2);
    L30:
        if (r7 == 128) goto L34;
        if (r7 == 132) goto L34;
    L28:
        r7 = -1;
    L34:
        if (r1 < 0) goto L37;
        r6 = r14.getLong(r1);
    L37:
        if (Intrinsics.areEqual(r15, MMS_TYPE) == false) goto L39;
        r6 = r6 * 1000;
    L39:
        r13.add(new MessageSyncSample(r8, r15, r6));
        goto L18
    L21:
        r5 = -1;
        goto L22
    L40:
        return r13;
    L16:
        r2 = -1;
        goto L18
    L10:
        if (Intrinsics.areEqual(r15, MMS_TYPE) == false) goto L12;
        r1 = r14.getColumnIndex("date");
        goto L14
    L12:
        r1 = -1;
        goto L14
    L5:
        return CollectionsKt.emptyList();
    }
}
