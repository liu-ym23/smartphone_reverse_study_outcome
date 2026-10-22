package com.android.server.people.data;

import android.content.LocusId;
import android.net.Uri;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import com.google.android.collect.Lists;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class ConversationStore {
    private static final String CONVERSATIONS_FILE_NAME = "conversations";
    private static final int CONVERSATION_INFOS_END_TOKEN = -1;
    private static final String TAG = null;
    private final Map<Uri, String> mContactUriToShortcutIdMap;
    private final Map<String, ConversationInfo> mConversationInfoMap;
    private ConversationInfosProtoDiskReadWriter mConversationInfosProtoDiskReadWriter;
    private final Map<LocusId, String> mLocusIdToShortcutIdMap;
    private final Map<String, String> mNotifChannelIdToShortcutIdMap;
    private final File mPackageDir;
    private final Map<String, String> mPhoneNumberToShortcutIdMap;
    private final ScheduledExecutorService mScheduledExecutorService;

    private static class ConversationInfosProtoDiskReadWriter extends AbstractProtoDiskReadWriter<List<ConversationInfo>> {
        private final String mConversationInfoFileName;

        /* JADX INFO: renamed from: $r8$lambda$E-7jjZ3xQYRfTadaonRcW3zdsVs, reason: not valid java name */
        public static /* synthetic */ void m6520$r8$lambda$E7jjZ3xQYRfTadaonRcW3zdsVs(ProtoOutputStream r0, List r1) {
            lambda$protoStreamWriter$0(r0, r1);
        }

        public static /* synthetic */ List $r8$lambda$QBg9gJJcoBw7LkDbnD8P_ajDers(ProtoInputStream r0) {
            return lambda$protoStreamReader$1(r0);
        }

        ConversationInfosProtoDiskReadWriter(File rootDir, String conversationInfoFileName, ScheduledExecutorService scheduledExecutorService) {
            super(rootDir, scheduledExecutorService);
            this.mConversationInfoFileName = conversationInfoFileName;
        }

        @Override // com.android.server.people.data.AbstractProtoDiskReadWriter
        AbstractProtoDiskReadWriter.ProtoStreamWriter<List<ConversationInfo>> protoStreamWriter() {
            return new ConversationStore$ConversationInfosProtoDiskReadWriter$$ExternalSyntheticLambda1();
        }

        private static /* synthetic */ void lambda$protoStreamWriter$0(ProtoOutputStream protoOutputStream, List data) {
            Iterator r0 = data.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ConversationInfo conversationInfo = (ConversationInfo) r0.next();
            long token = protoOutputStream.start(2246267895809L);
            conversationInfo.writeToProto(protoOutputStream);
            protoOutputStream.end(token);
            goto L4
        }

        @Override // com.android.server.people.data.AbstractProtoDiskReadWriter
        AbstractProtoDiskReadWriter.ProtoStreamReader<List<ConversationInfo>> protoStreamReader() {
            return new ConversationStore$ConversationInfosProtoDiskReadWriter$$ExternalSyntheticLambda0();
        }

        private static /* synthetic */ List lambda$protoStreamReader$1(ProtoInputStream protoInputStream) {
            List<ConversationInfo> results = Lists.newArrayList();
        L15:
        L10:
            e = move-exception;
            Slog.e(ConversationStore.m6519$$Nest$sfgetTAG(), "Failed to read protobuf input stream.", e);
        L14:
            return results;
        L4:
            if (protoInputStream.nextField() == (-1)) goto L14;
            if (protoInputStream.getFieldNumber() != 1) goto L15;
            long token = protoInputStream.start(2246267895809L);     // Catch: IOException -> L10
            ConversationInfo conversationInfo = ConversationInfo.readFromProto(protoInputStream);     // Catch: IOException -> L10
            protoInputStream.end(token);     // Catch: IOException -> L10
            results.add(conversationInfo);     // Catch: IOException -> L10
            goto L15
        }

        void scheduleConversationsSave(List<ConversationInfo> conversationInfos) {
            scheduleSave(this.mConversationInfoFileName, conversationInfos);
        }

        void saveConversationsImmediately(List<ConversationInfo> conversationInfos) {
            saveImmediately(this.mConversationInfoFileName, conversationInfos);
        }

        void deleteConversationsFile() {
            delete(this.mConversationInfoFileName);
        }
    }

    public static /* synthetic */ void $r8$lambda$bbezRNjojDv1JpDhGUn462JKUkw(DataOutputStream r0, ConversationInfo r1) {
        lambda$getBackupPayload$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6519$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = ConversationStore.class.getSimpleName();
    }

    ConversationStore(File packageDir, ScheduledExecutorService scheduledExecutorService) {
        this.mConversationInfoMap = new ArrayMap();
        this.mLocusIdToShortcutIdMap = new ArrayMap();
        this.mContactUriToShortcutIdMap = new ArrayMap();
        this.mPhoneNumberToShortcutIdMap = new ArrayMap();
        this.mNotifChannelIdToShortcutIdMap = new ArrayMap();
        this.mScheduledExecutorService = scheduledExecutorService;
        this.mPackageDir = packageDir;
    }

    void loadConversationsFromDisk() {
        ConversationInfosProtoDiskReadWriter conversationInfosProtoDiskReadWriter = getConversationInfosProtoDiskReadWriter();
        if (conversationInfosProtoDiskReadWriter != null) goto L5;
        return;
    L5:
        List<ConversationInfo> conversationsOnDisk = conversationInfosProtoDiskReadWriter.read(CONVERSATIONS_FILE_NAME);
        if (conversationsOnDisk != null) goto L8;
        return;
    L8:
        Iterator<ConversationInfo> r2 = conversationsOnDisk.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ConversationInfo conversationInfo = r2.next();
        updateConversationsInMemory(conversationInfo);
        goto L10
    }

    void saveConversationsToDisk() {
        ConversationInfosProtoDiskReadWriter conversationInfosProtoDiskReadWriter = getConversationInfosProtoDiskReadWriter();
        if (conversationInfosProtoDiskReadWriter == null) goto L11;
        monitor-enter(this);
        List<ConversationInfo> conversations = new ArrayList(this.mConversationInfoMap.values());     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        conversationInfosProtoDiskReadWriter.saveConversationsImmediately(conversations);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void addOrUpdate(ConversationInfo conversationInfo) {
        updateConversationsInMemory(conversationInfo);
        scheduleUpdateConversationsOnDisk();
    }

    ConversationInfo deleteConversation(String shortcutId) {
        monitor-enter(this);
        ConversationInfo conversationInfo = this.mConversationInfoMap.remove(shortcutId);     // Catch: Throwable -> L8
        if (conversationInfo != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return null;
    L10:
        LocusId locusId = conversationInfo.getLocusId();     // Catch: Throwable -> L8
        if (locusId == null) goto L13;
        this.mLocusIdToShortcutIdMap.remove(locusId);     // Catch: Throwable -> L8
    L13:
        Uri contactUri = conversationInfo.getContactUri();     // Catch: Throwable -> L8
        if (contactUri == null) goto L16;
        this.mContactUriToShortcutIdMap.remove(contactUri);     // Catch: Throwable -> L8
    L16:
        String phoneNumber = conversationInfo.getContactPhoneNumber();     // Catch: Throwable -> L8
        if (phoneNumber == null) goto L19;
        this.mPhoneNumberToShortcutIdMap.remove(phoneNumber);     // Catch: Throwable -> L8
    L19:
        String notifChannelId = conversationInfo.getNotificationChannelId();     // Catch: Throwable -> L8
        if (notifChannelId == null) goto L22;
        this.mNotifChannelIdToShortcutIdMap.remove(notifChannelId);     // Catch: Throwable -> L8
    L22:
        monitor-exit(this);     // Catch: Throwable -> L8
        scheduleUpdateConversationsOnDisk();
        return conversationInfo;
    L8:
        th = move-exception;
        throw th;
    }

    void forAllConversations(Consumer<ConversationInfo> consumer) {
        monitor-enter(this);
        List<ConversationInfo> conversations = new ArrayList(this.mConversationInfoMap.values());     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        Iterator<ConversationInfo> r1 = conversations.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ConversationInfo ci = r1.next();
        consumer.accept(ci);
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    synchronized ConversationInfo getConversation(String shortcutId) {
        monitor-enter(this);
        if (shortcutId != null) goto L11;
        ConversationInfo r0 = null;
    L9:
        monitor-exit(this);
        return r0;
    L11:
        r0 = this.mConversationInfoMap.get(shortcutId);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    synchronized ConversationInfo getConversationByLocusId(LocusId locusId) {
        monitor-enter(this);
        ConversationInfo r0 = getConversation(this.mLocusIdToShortcutIdMap.get(locusId));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized ConversationInfo getConversationByContactUri(Uri contactUri) {
        monitor-enter(this);
        ConversationInfo r0 = getConversation(this.mContactUriToShortcutIdMap.get(contactUri));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized ConversationInfo getConversationByPhoneNumber(String phoneNumber) {
        monitor-enter(this);
        ConversationInfo r0 = getConversation(this.mPhoneNumberToShortcutIdMap.get(phoneNumber));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized ConversationInfo getConversationByNotificationChannelId(String notifChannelId) {
        monitor-enter(this);
        ConversationInfo r0 = getConversation(this.mNotifChannelIdToShortcutIdMap.get(notifChannelId));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void onDestroy() {
        monitor-enter(this);
        this.mConversationInfoMap.clear();     // Catch: Throwable -> L9
        this.mContactUriToShortcutIdMap.clear();     // Catch: Throwable -> L9
        this.mLocusIdToShortcutIdMap.clear();     // Catch: Throwable -> L9
        this.mNotifChannelIdToShortcutIdMap.clear();     // Catch: Throwable -> L9
        this.mPhoneNumberToShortcutIdMap.clear();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        ConversationInfosProtoDiskReadWriter writer = getConversationInfosProtoDiskReadWriter();
        if (writer == null) goto L14;
        writer.deleteConversationsFile();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    byte[] getBackupPayload() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final DataOutputStream conversationInfosOut = new DataOutputStream(baos);
        forAllConversations(new ConversationStore$$ExternalSyntheticLambda0(conversationInfosOut));
        conversationInfosOut.writeInt(-1);     // Catch: IOException -> L6
        return baos.toByteArray();
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to write conversation infos end token to backup payload.", e);
        return null;
    }

    private static /* synthetic */ void lambda$getBackupPayload$0(DataOutputStream conversationInfosOut, ConversationInfo conversationInfo) {
        byte[] backupPayload = conversationInfo.getBackupPayload();
        if (backupPayload != null) goto L10;
        return;
    L10:
        conversationInfosOut.writeInt(backupPayload.length);     // Catch: IOException -> L7
        conversationInfosOut.write(backupPayload);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to write conversation info to backup payload.", e);
    }

    void restore(byte[] payload) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(payload));
        int conversationInfoSize = in.readInt();     // Catch: IOException -> L9
    L5:
        if (conversationInfoSize == (-1)) goto L19;
        byte[] conversationInfoPayload = new byte[conversationInfoSize];     // Catch: IOException -> L9
        in.readFully(conversationInfoPayload, 0, conversationInfoSize);     // Catch: IOException -> L9
        ConversationInfo conversationInfo = ConversationInfo.readFromBackupPayload(conversationInfoPayload);     // Catch: IOException -> L9
        if (conversationInfo == null) goto L12;
        addOrUpdate(conversationInfo);     // Catch: IOException -> L9
    L12:
        conversationInfoSize = in.readInt();     // Catch: IOException -> L9
        goto L5
    L19:
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to read conversation info from payload.", e);
    }

    private synchronized void updateConversationsInMemory(ConversationInfo conversationInfo) {
        monitor-enter(this);
        this.mConversationInfoMap.put(conversationInfo.getShortcutId(), conversationInfo);     // Catch: Throwable -> L6
        LocusId locusId = conversationInfo.getLocusId();     // Catch: Throwable -> L6
        if (locusId == null) goto L8;
        this.mLocusIdToShortcutIdMap.put(locusId, conversationInfo.getShortcutId());     // Catch: Throwable -> L6
    L8:
        Uri contactUri = conversationInfo.getContactUri();     // Catch: Throwable -> L6
        if (contactUri == null) goto L11;
        this.mContactUriToShortcutIdMap.put(contactUri, conversationInfo.getShortcutId());     // Catch: Throwable -> L6
    L11:
        String phoneNumber = conversationInfo.getContactPhoneNumber();     // Catch: Throwable -> L6
        if (phoneNumber == null) goto L14;
        this.mPhoneNumberToShortcutIdMap.put(phoneNumber, conversationInfo.getShortcutId());     // Catch: Throwable -> L6
    L14:
        String notifChannelId = conversationInfo.getNotificationChannelId();     // Catch: Throwable -> L6
        if (notifChannelId == null) goto L17;
        this.mNotifChannelIdToShortcutIdMap.put(notifChannelId, conversationInfo.getShortcutId());     // Catch: Throwable -> L6
    L17:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void scheduleUpdateConversationsOnDisk() {
        ConversationInfosProtoDiskReadWriter conversationInfosProtoDiskReadWriter = getConversationInfosProtoDiskReadWriter();
        if (conversationInfosProtoDiskReadWriter == null) goto L11;
        monitor-enter(this);
        List<ConversationInfo> conversations = new ArrayList(this.mConversationInfoMap.values());     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        conversationInfosProtoDiskReadWriter.scheduleConversationsSave(conversations);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private ConversationInfosProtoDiskReadWriter getConversationInfosProtoDiskReadWriter() {
        if (this.mPackageDir.exists() == true) goto L7;
        Slog.e(TAG, "Package data directory does not exist: " + this.mPackageDir.getAbsolutePath());
        return null;
    L7:
        if (this.mConversationInfosProtoDiskReadWriter != null) goto L10;
        this.mConversationInfosProtoDiskReadWriter = new ConversationInfosProtoDiskReadWriter(this.mPackageDir, CONVERSATIONS_FILE_NAME, this.mScheduledExecutorService);
    L10:
        return this.mConversationInfosProtoDiskReadWriter;
    }
}
