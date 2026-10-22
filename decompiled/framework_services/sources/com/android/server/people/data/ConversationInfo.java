package com.android.server.people.data;

import android.app.people.ConversationStatus;
import android.content.LocusId;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ConversationInfo {
    private static final boolean DEBUG = false;
    private static final int FLAG_BUBBLED = 4;
    private static final int FLAG_CONTACT_STARRED = 32;
    private static final int FLAG_DEMOTED = 64;
    private static final int FLAG_IMPORTANT = 1;
    private static final int FLAG_NOTIFICATION_SILENCED = 2;
    private static final int FLAG_PERSON_BOT = 16;
    private static final int FLAG_PERSON_IMPORTANT = 8;
    private static final String TAG = null;
    private static final int VERSION = 1;
    private String mContactPhoneNumber;
    private Uri mContactUri;
    private int mConversationFlags;
    private long mCreationTimestamp;
    private Map<String, ConversationStatus> mCurrStatuses;
    private long mLastEventTimestamp;
    private LocusId mLocusId;
    private String mNotificationChannelId;
    private String mParentNotificationChannelId;
    private int mShortcutFlags;
    private String mShortcutId;

    static class Builder {
        private String mContactPhoneNumber;
        private Uri mContactUri;
        private int mConversationFlags;
        private long mCreationTimestamp;
        private Map<String, ConversationStatus> mCurrStatuses;
        private long mLastEventTimestamp;
        private LocusId mLocusId;
        private String mNotificationChannelId;
        private String mParentNotificationChannelId;
        private int mShortcutFlags;
        private String mShortcutId;

        /* JADX INFO: renamed from: -$$Nest$fgetmContactPhoneNumber, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6508$$Nest$fgetmContactPhoneNumber(Builder r0) {
            return r0.mContactPhoneNumber;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmContactUri, reason: not valid java name */
        static /* bridge */ /* synthetic */ Uri m6509$$Nest$fgetmContactUri(Builder r0) {
            return r0.mContactUri;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConversationFlags, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6510$$Nest$fgetmConversationFlags(Builder r0) {
            return r0.mConversationFlags;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCreationTimestamp, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m6511$$Nest$fgetmCreationTimestamp(Builder r2) {
            return r2.mCreationTimestamp;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCurrStatuses, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m6512$$Nest$fgetmCurrStatuses(Builder r0) {
            return r0.mCurrStatuses;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastEventTimestamp, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m6513$$Nest$fgetmLastEventTimestamp(Builder r2) {
            return r2.mLastEventTimestamp;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLocusId, reason: not valid java name */
        static /* bridge */ /* synthetic */ LocusId m6514$$Nest$fgetmLocusId(Builder r0) {
            return r0.mLocusId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNotificationChannelId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6515$$Nest$fgetmNotificationChannelId(Builder r0) {
            return r0.mNotificationChannelId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmParentNotificationChannelId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6516$$Nest$fgetmParentNotificationChannelId(Builder r0) {
            return r0.mParentNotificationChannelId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShortcutFlags, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6517$$Nest$fgetmShortcutFlags(Builder r0) {
            return r0.mShortcutFlags;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShortcutId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6518$$Nest$fgetmShortcutId(Builder r0) {
            return r0.mShortcutId;
        }

        Builder() {
            this.mCurrStatuses = new HashMap();
        }

        Builder(ConversationInfo conversationInfo) {
            this.mCurrStatuses = new HashMap();
            if (this.mShortcutId != null) goto L5;
            this.mShortcutId = ConversationInfo.m6507$$Nest$fgetmShortcutId(conversationInfo);
        L6:
            this.mLocusId = ConversationInfo.m6503$$Nest$fgetmLocusId(conversationInfo);
            this.mContactUri = ConversationInfo.m6498$$Nest$fgetmContactUri(conversationInfo);
            this.mContactPhoneNumber = ConversationInfo.m6497$$Nest$fgetmContactPhoneNumber(conversationInfo);
            this.mNotificationChannelId = ConversationInfo.m6504$$Nest$fgetmNotificationChannelId(conversationInfo);
            this.mParentNotificationChannelId = ConversationInfo.m6505$$Nest$fgetmParentNotificationChannelId(conversationInfo);
            this.mLastEventTimestamp = ConversationInfo.m6502$$Nest$fgetmLastEventTimestamp(conversationInfo);
            this.mCreationTimestamp = ConversationInfo.m6500$$Nest$fgetmCreationTimestamp(conversationInfo);
            this.mShortcutFlags = ConversationInfo.m6506$$Nest$fgetmShortcutFlags(conversationInfo);
            this.mConversationFlags = ConversationInfo.m6499$$Nest$fgetmConversationFlags(conversationInfo);
            this.mCurrStatuses = ConversationInfo.m6501$$Nest$fgetmCurrStatuses(conversationInfo);
            return;
        L5:
            Preconditions.checkArgument(this.mShortcutId.equals(ConversationInfo.m6507$$Nest$fgetmShortcutId(conversationInfo)));
            goto L6
        }

        Builder setShortcutId(String shortcutId) {
            this.mShortcutId = shortcutId;
            return this;
        }

        Builder setLocusId(LocusId locusId) {
            this.mLocusId = locusId;
            return this;
        }

        Builder setContactUri(Uri contactUri) {
            this.mContactUri = contactUri;
            return this;
        }

        Builder setContactPhoneNumber(String phoneNumber) {
            this.mContactPhoneNumber = phoneNumber;
            return this;
        }

        Builder setNotificationChannelId(String notificationChannelId) {
            this.mNotificationChannelId = notificationChannelId;
            return this;
        }

        Builder setParentNotificationChannelId(String parentNotificationChannelId) {
            this.mParentNotificationChannelId = parentNotificationChannelId;
            return this;
        }

        Builder setLastEventTimestamp(long lastEventTimestamp) {
            this.mLastEventTimestamp = lastEventTimestamp;
            return this;
        }

        Builder setCreationTimestamp(long creationTimestamp) {
            this.mCreationTimestamp = creationTimestamp;
            return this;
        }

        Builder setShortcutFlags(int shortcutFlags) {
            this.mShortcutFlags = shortcutFlags;
            return this;
        }

        Builder setConversationFlags(int conversationFlags) {
            this.mConversationFlags = conversationFlags;
            return this;
        }

        Builder setImportant(boolean value) {
            return setConversationFlag(1, value);
        }

        Builder setNotificationSilenced(boolean value) {
            return setConversationFlag(2, value);
        }

        Builder setBubbled(boolean value) {
            return setConversationFlag(4, value);
        }

        Builder setDemoted(boolean value) {
            return setConversationFlag(64, value);
        }

        Builder setPersonImportant(boolean value) {
            return setConversationFlag(8, value);
        }

        Builder setPersonBot(boolean value) {
            return setConversationFlag(16, value);
        }

        Builder setContactStarred(boolean value) {
            return setConversationFlag(32, value);
        }

        private Builder setConversationFlag(int flags, boolean value) {
            if (value == false) goto L6;
            return addConversationFlags(flags);
        L6:
            return removeConversationFlags(flags);
        }

        private Builder addConversationFlags(int flags) {
            this.mConversationFlags |= flags;
            return this;
        }

        private Builder removeConversationFlags(int flags) {
            this.mConversationFlags &= ~flags;
            return this;
        }

        Builder setStatuses(List<ConversationStatus> statuses) {
            this.mCurrStatuses.clear();
            if (statuses == null) goto L8;
            Iterator<ConversationStatus> r0 = statuses.iterator();
        L6:
            if (r0.hasNext() == false) goto L8;
            ConversationStatus status = r0.next();
            this.mCurrStatuses.put(status.getId(), status);
        L8:
            return this;
        }

        Builder addOrUpdateStatus(ConversationStatus status) {
            this.mCurrStatuses.put(status.getId(), status);
            return this;
        }

        Builder clearStatus(String statusId) {
            this.mCurrStatuses.remove(statusId);
            return this;
        }

        ConversationInfo build() {
            this.mShortcutId.getClass();
            return new ConversationInfo(this, null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ConversationFlags {
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContactPhoneNumber, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6497$$Nest$fgetmContactPhoneNumber(ConversationInfo r0) {
        return r0.mContactPhoneNumber;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContactUri, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m6498$$Nest$fgetmContactUri(ConversationInfo r0) {
        return r0.mContactUri;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConversationFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6499$$Nest$fgetmConversationFlags(ConversationInfo r0) {
        return r0.mConversationFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCreationTimestamp, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6500$$Nest$fgetmCreationTimestamp(ConversationInfo r2) {
        return r2.mCreationTimestamp;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrStatuses, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m6501$$Nest$fgetmCurrStatuses(ConversationInfo r0) {
        return r0.mCurrStatuses;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastEventTimestamp, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6502$$Nest$fgetmLastEventTimestamp(ConversationInfo r2) {
        return r2.mLastEventTimestamp;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocusId, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocusId m6503$$Nest$fgetmLocusId(ConversationInfo r0) {
        return r0.mLocusId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationChannelId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6504$$Nest$fgetmNotificationChannelId(ConversationInfo r0) {
        return r0.mNotificationChannelId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmParentNotificationChannelId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6505$$Nest$fgetmParentNotificationChannelId(ConversationInfo r0) {
        return r0.mParentNotificationChannelId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShortcutFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6506$$Nest$fgetmShortcutFlags(ConversationInfo r0) {
        return r0.mShortcutFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShortcutId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6507$$Nest$fgetmShortcutId(ConversationInfo r0) {
        return r0.mShortcutId;
    }

    /* synthetic */ ConversationInfo(Builder r1, ConversationInfoIA r2) {
        this(r1);
    }

    static {
        TAG = ConversationInfo.class.getSimpleName();
    }

    private ConversationInfo(Builder builder) {
        this.mShortcutId = Builder.m6518$$Nest$fgetmShortcutId(builder);
        this.mLocusId = Builder.m6514$$Nest$fgetmLocusId(builder);
        this.mContactUri = Builder.m6509$$Nest$fgetmContactUri(builder);
        this.mContactPhoneNumber = Builder.m6508$$Nest$fgetmContactPhoneNumber(builder);
        this.mNotificationChannelId = Builder.m6515$$Nest$fgetmNotificationChannelId(builder);
        this.mParentNotificationChannelId = Builder.m6516$$Nest$fgetmParentNotificationChannelId(builder);
        this.mLastEventTimestamp = Builder.m6513$$Nest$fgetmLastEventTimestamp(builder);
        this.mCreationTimestamp = Builder.m6511$$Nest$fgetmCreationTimestamp(builder);
        this.mShortcutFlags = Builder.m6517$$Nest$fgetmShortcutFlags(builder);
        this.mConversationFlags = Builder.m6510$$Nest$fgetmConversationFlags(builder);
        this.mCurrStatuses = Builder.m6512$$Nest$fgetmCurrStatuses(builder);
    }

    public String getShortcutId() {
        return this.mShortcutId;
    }

    LocusId getLocusId() {
        return this.mLocusId;
    }

    Uri getContactUri() {
        return this.mContactUri;
    }

    String getContactPhoneNumber() {
        return this.mContactPhoneNumber;
    }

    String getNotificationChannelId() {
        return this.mNotificationChannelId;
    }

    String getParentNotificationChannelId() {
        return this.mParentNotificationChannelId;
    }

    long getLastEventTimestamp() {
        return this.mLastEventTimestamp;
    }

    long getCreationTimestamp() {
        return this.mCreationTimestamp;
    }

    public boolean isShortcutLongLived() {
        return hasShortcutFlags(8192);
    }

    public boolean isShortcutCachedForNotification() {
        return hasShortcutFlags(16384);
    }

    public boolean isImportant() {
        return hasConversationFlags(1);
    }

    public boolean isNotificationSilenced() {
        return hasConversationFlags(2);
    }

    public boolean isBubbled() {
        return hasConversationFlags(4);
    }

    public boolean isDemoted() {
        return hasConversationFlags(64);
    }

    public boolean isPersonImportant() {
        return hasConversationFlags(8);
    }

    public boolean isPersonBot() {
        return hasConversationFlags(16);
    }

    public boolean isContactStarred() {
        return hasConversationFlags(32);
    }

    public Collection<ConversationStatus> getStatuses() {
        return this.mCurrStatuses.values();
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof ConversationInfo) == true) goto L8;
        return false;
    L8:
        ConversationInfo other = (ConversationInfo) obj;
        if (Objects.equals(this.mShortcutId, other.mShortcutId) == false) goto L32;
        if (Objects.equals(this.mLocusId, other.mLocusId) == false) goto L32;
        if (Objects.equals(this.mContactUri, other.mContactUri) == false) goto L32;
        if (Objects.equals(this.mContactPhoneNumber, other.mContactPhoneNumber) == false) goto L32;
        if (Objects.equals(this.mNotificationChannelId, other.mNotificationChannelId) == false) goto L32;
        if (Objects.equals(this.mParentNotificationChannelId, other.mParentNotificationChannelId) == false) goto L32;
        if (Objects.equals(Long.valueOf(this.mLastEventTimestamp), Long.valueOf(other.mLastEventTimestamp)) == false) goto L32;
        if (this.mCreationTimestamp != other.mCreationTimestamp) goto L32;
        if (this.mShortcutFlags != other.mShortcutFlags) goto L32;
        if (this.mConversationFlags != other.mConversationFlags) goto L32;
        if (Objects.equals(this.mCurrStatuses, other.mCurrStatuses) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mShortcutId, this.mLocusId, this.mContactUri, this.mContactPhoneNumber, this.mNotificationChannelId, this.mParentNotificationChannelId, Long.valueOf(this.mLastEventTimestamp), Long.valueOf(this.mCreationTimestamp), Integer.valueOf(this.mShortcutFlags), Integer.valueOf(this.mConversationFlags), this.mCurrStatuses});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConversationInfo {");
        sb.append("shortcutId=");
        sb.append(this.mShortcutId);
        sb.append(", locusId=");
        sb.append(this.mLocusId);
        sb.append(", contactUri=");
        sb.append(this.mContactUri);
        sb.append(", phoneNumber=");
        sb.append(this.mContactPhoneNumber);
        sb.append(", notificationChannelId=");
        sb.append(this.mNotificationChannelId);
        sb.append(", parentNotificationChannelId=");
        sb.append(this.mParentNotificationChannelId);
        sb.append(", lastEventTimestamp=");
        sb.append(this.mLastEventTimestamp);
        sb.append(", creationTimestamp=");
        sb.append(this.mCreationTimestamp);
        sb.append(", statuses=");
        sb.append(this.mCurrStatuses);
        sb.append(", shortcutFlags=0x");
        sb.append(Integer.toHexString(this.mShortcutFlags));
        sb.append(" [");
        if (isShortcutLongLived() == false) goto L6;
        sb.append("Liv");
    L6:
        if (isShortcutCachedForNotification() == false) goto L8;
        sb.append("Cac");
    L8:
        sb.append("]");
        sb.append(", conversationFlags=0x");
        sb.append(Integer.toHexString(this.mConversationFlags));
        sb.append(" [");
        if (isImportant() == false) goto L12;
        sb.append("Imp");
    L12:
        if (isNotificationSilenced() == false) goto L15;
        sb.append("Sil");
    L15:
        if (isBubbled() == false) goto L18;
        sb.append("Bub");
    L18:
        if (isDemoted() == false) goto L21;
        sb.append("Dem");
    L21:
        if (isPersonImportant() == false) goto L24;
        sb.append("PIm");
    L24:
        if (isPersonBot() == false) goto L27;
        sb.append("Bot");
    L27:
        if (isContactStarred() == false) goto L29;
        sb.append("Sta");
    L29:
        sb.append("]}");
        return sb.toString();
    }

    private boolean hasShortcutFlags(int flags) {
        if ((this.mShortcutFlags & flags) != flags) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasConversationFlags(int flags) {
        if ((this.mConversationFlags & flags) != flags) goto L5;
        return true;
    L5:
        return false;
    }

    void writeToProto(ProtoOutputStream protoOutputStream) {
        protoOutputStream.write(1138166333441L, this.mShortcutId);
        if (this.mLocusId == null) goto L6;
        long locusIdToken = protoOutputStream.start(1146756268034L);
        protoOutputStream.write(1138166333441L, this.mLocusId.getId());
        protoOutputStream.end(locusIdToken);
    L6:
        if (this.mContactUri == null) goto L9;
        protoOutputStream.write(1138166333443L, this.mContactUri.toString());
    L9:
        if (this.mNotificationChannelId == null) goto L12;
        protoOutputStream.write(1138166333444L, this.mNotificationChannelId);
    L12:
        if (this.mParentNotificationChannelId == null) goto L14;
        protoOutputStream.write(1138166333448L, this.mParentNotificationChannelId);
    L14:
        protoOutputStream.write(1112396529673L, this.mLastEventTimestamp);
        protoOutputStream.write(1112396529674L, this.mCreationTimestamp);
        protoOutputStream.write(1120986464261L, this.mShortcutFlags);
        protoOutputStream.write(1120986464262L, this.mConversationFlags);
        if (this.mContactPhoneNumber == null) goto L18;
        protoOutputStream.write(1138166333447L, this.mContactPhoneNumber);
        return;
    }

    byte[] getBackupPayload() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        out.writeUTF(this.mShortcutId);     // Catch: IOException -> L7
        String r3 = "";
        if (this.mLocusId == null) goto L9;
        String r2 = this.mLocusId.getId();     // Catch: IOException -> L7
    L10:
        out.writeUTF(r2);     // Catch: IOException -> L7
        if (this.mContactUri == null) goto L13;
        String r4 = this.mContactUri.toString();     // Catch: IOException -> L7
    L14:
        out.writeUTF(r4);     // Catch: IOException -> L7
        if (this.mNotificationChannelId == null) goto L17;
        String r5 = this.mNotificationChannelId;     // Catch: IOException -> L7
    L18:
        out.writeUTF(r5);     // Catch: IOException -> L7
        out.writeInt(this.mShortcutFlags);     // Catch: IOException -> L7
        out.writeInt(this.mConversationFlags);     // Catch: IOException -> L7
        if (this.mContactPhoneNumber == null) goto L21;
        String r6 = this.mContactPhoneNumber;     // Catch: IOException -> L7
    L22:
        out.writeUTF(r6);     // Catch: IOException -> L7
        if (this.mParentNotificationChannelId == null) goto L25;
        r3 = this.mParentNotificationChannelId;     // Catch: IOException -> L7
    L25:
        out.writeUTF(r3);     // Catch: IOException -> L7
        out.writeLong(this.mLastEventTimestamp);     // Catch: IOException -> L7
        out.writeInt(1);     // Catch: IOException -> L7
        out.writeLong(this.mCreationTimestamp);     // Catch: IOException -> L7
        return baos.toByteArray();
    L21:
        r6 = "";
        goto L22
    L17:
        r5 = "";
        goto L18
    L13:
        r4 = "";
        goto L14
    L9:
        r2 = "";
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to write fields to backup payload.", e);
        return null;
    }

    static ConversationInfo readFromProto(ProtoInputStream protoInputStream) throws IOException {
        Builder builder = new Builder();
    L4:
        if (protoInputStream.nextField() == (-1)) goto L25;
        switch(protoInputStream.getFieldNumber()) {
            case 1: goto L23;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        builder.setCreationTimestamp(protoInputStream.readLong(1112396529674L));
        goto L4
    L9:
        builder.setLastEventTimestamp(protoInputStream.readLong(1112396529673L));
        goto L4
    L10:
        builder.setParentNotificationChannelId(protoInputStream.readString(1138166333448L));
        goto L4
    L11:
        builder.setContactPhoneNumber(protoInputStream.readString(1138166333447L));
        goto L4
    L12:
        builder.setConversationFlags(protoInputStream.readInt(1120986464262L));
        goto L4
    L13:
        builder.setShortcutFlags(protoInputStream.readInt(1120986464261L));
        goto L4
    L14:
        builder.setNotificationChannelId(protoInputStream.readString(1138166333444L));
        goto L4
    L15:
        builder.setContactUri(Uri.parse(protoInputStream.readString(1138166333443L)));
        goto L4
    L16:
        long locusIdToken = protoInputStream.start(1146756268034L);
    L18:
        if (protoInputStream.nextField() == (-1)) goto L22;
        if (protoInputStream.getFieldNumber() != 1) goto L18;
        builder.setLocusId(new LocusId(protoInputStream.readString(1138166333441L)));
        goto L18
    L22:
        protoInputStream.end(locusIdToken);
        goto L4
    L23:
        builder.setShortcutId(protoInputStream.readString(1138166333441L));
        goto L4
    L7:
        Slog.w(TAG, "Could not read undefined field: " + protoInputStream.getFieldNumber());
        goto L4
    L25:
        return builder.build();
    }

    static ConversationInfo readFromBackupPayload(byte[] payload) {
        Builder builder = new Builder();
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(payload));
        builder.setShortcutId(in.readUTF());     // Catch: IOException -> L6
        String locusId = in.readUTF();     // Catch: IOException -> L6
        if (TextUtils.isEmpty(locusId) == true) goto L8;
        builder.setLocusId(new LocusId(locusId));     // Catch: IOException -> L6
    L8:
        String contactUri = in.readUTF();     // Catch: IOException -> L6
        if (TextUtils.isEmpty(contactUri) == true) goto L11;
        builder.setContactUri(Uri.parse(contactUri));     // Catch: IOException -> L6
    L11:
        String notificationChannelId = in.readUTF();     // Catch: IOException -> L6
        if (TextUtils.isEmpty(notificationChannelId) == true) goto L14;
        builder.setNotificationChannelId(notificationChannelId);     // Catch: IOException -> L6
    L14:
        builder.setShortcutFlags(in.readInt());     // Catch: IOException -> L6
        builder.setConversationFlags(in.readInt());     // Catch: IOException -> L6
        String contactPhoneNumber = in.readUTF();     // Catch: IOException -> L6
        if (TextUtils.isEmpty(contactPhoneNumber) == true) goto L17;
        builder.setContactPhoneNumber(contactPhoneNumber);     // Catch: IOException -> L6
    L17:
        String parentNotificationChannelId = in.readUTF();     // Catch: IOException -> L6
        if (TextUtils.isEmpty(parentNotificationChannelId) == true) goto L20;
        builder.setParentNotificationChannelId(parentNotificationChannelId);     // Catch: IOException -> L6
    L20:
        builder.setLastEventTimestamp(in.readLong());     // Catch: IOException -> L6
        int payloadVersion = maybeReadVersion(in);     // Catch: IOException -> L6
        if (payloadVersion != 1) goto L24;
        builder.setCreationTimestamp(in.readLong());     // Catch: IOException -> L6
    L24:
        return builder.build();
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to read conversation info fields from backup payload.", e);
        return null;
    }

    private static int maybeReadVersion(DataInputStream in) throws IOException {
        return in.readInt();
    L5:
        return 0;
    }
}
