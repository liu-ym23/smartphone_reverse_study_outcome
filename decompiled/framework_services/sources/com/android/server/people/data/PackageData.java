package com.android.server.people.data;

import android.content.LocusId;
import android.os.FileUtils;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.android.server.cpu.CpuInfoReader$$ExternalSyntheticLambda2;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class PackageData {
    private final ConversationStore mConversationStore;
    private final EventStore mEventStore;
    private final Predicate<String> mIsDefaultDialerPredicate;
    private final Predicate<String> mIsDefaultSmsAppPredicate;
    private final File mPackageDataDir;
    private final String mPackageName;
    private final int mUserId;

    /* JADX INFO: renamed from: $r8$lambda$2gC3ee-TK2KfMp_EW5yogGMyV_s, reason: not valid java name */
    public static /* synthetic */ boolean m6560$r8$lambda$2gC3eeTK2KfMp_EW5yogGMyV_s(PackageData r0, String r1) {
        return r0.lambda$pruneOrphanEvents$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$YMvpBQv5v3uJmd8CHNi5xr6vnIM(PackageData r0, String r1) {
        return r0.lambda$pruneOrphanEvents$0(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ch76XIACNEe4stFyvA7XHBlp3Z0(PackageData r0, String r1) {
        return r0.lambda$pruneOrphanEvents$2(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$tL10daRE2Q0FbmDSU2PXhKJD0JM(PackageData r0, String r1) {
        return r0.lambda$pruneOrphanEvents$3(r1);
    }

    PackageData(String packageName, int userId, Predicate<String> isDefaultDialerPredicate, Predicate<String> isDefaultSmsAppPredicate, ScheduledExecutorService scheduledExecutorService, File perUserPeopleDataDir) {
        this.mPackageName = packageName;
        this.mUserId = userId;
        this.mPackageDataDir = new File(perUserPeopleDataDir, this.mPackageName);
        this.mPackageDataDir.mkdirs();
        this.mConversationStore = new ConversationStore(this.mPackageDataDir, scheduledExecutorService);
        this.mEventStore = new EventStore(this.mPackageDataDir, scheduledExecutorService);
        this.mIsDefaultDialerPredicate = isDefaultDialerPredicate;
        this.mIsDefaultSmsAppPredicate = isDefaultSmsAppPredicate;
    }

    static Map<String, PackageData> packagesDataFromDisk(int userId, Predicate<String> isDefaultDialerPredicate, Predicate<String> isDefaultSmsAppPredicate, ScheduledExecutorService scheduledExecutorService, File perUserPeopleDataDir) {
        Map<String, PackageData> results = new ArrayMap();
        File r8 = perUserPeopleDataDir;
        File[] packageDirs = r8.listFiles(new CpuInfoReader$$ExternalSyntheticLambda2());
        if (packageDirs != null) goto L5;
        return results;
    L5:
        int r9 = packageDirs.length;
        int r10 = 0;
    L6:
        if (r10 >= r9) goto L8;
        File packageDir = packageDirs[r10];
        PackageData packageData = new PackageData(packageDir.getName(), userId, isDefaultDialerPredicate, isDefaultSmsAppPredicate, scheduledExecutorService, r8);
        packageData.loadFromDisk();
        results.put(packageDir.getName(), packageData);
        r10 = r10 + 1;
        r8 = perUserPeopleDataDir;
        goto L6
    L8:
        return results;
    }

    private void loadFromDisk() {
        this.mConversationStore.loadConversationsFromDisk();
        this.mEventStore.loadFromDisk();
    }

    void saveToDisk() {
        this.mConversationStore.saveConversationsToDisk();
        this.mEventStore.saveToDisk();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public void forAllConversations(Consumer<ConversationInfo> consumer) {
        this.mConversationStore.forAllConversations(consumer);
    }

    public ConversationInfo getConversationInfo(String shortcutId) {
        return getConversationStore().getConversation(shortcutId);
    }

    public EventHistory getEventHistory(String shortcutId) {
        AggregateEventHistoryImpl result = new AggregateEventHistoryImpl();
        ConversationInfo conversationInfo = this.mConversationStore.getConversation(shortcutId);
        if (conversationInfo != null) goto L5;
        return result;
    L5:
        EventHistory shortcutEventHistory = getEventStore().getEventHistory(0, shortcutId);
        if (shortcutEventHistory == null) goto L8;
        result.addEventHistory(shortcutEventHistory);
    L8:
        LocusId locusId = conversationInfo.getLocusId();
        if (locusId == null) goto L13;
        EventHistory locusEventHistory = getEventStore().getEventHistory(1, locusId.getId());
        if (locusEventHistory == null) goto L13;
        result.addEventHistory(locusEventHistory);
    L13:
        String phoneNumber = conversationInfo.getContactPhoneNumber();
        if (TextUtils.isEmpty(phoneNumber) == false) goto L17;
        return result;
    L17:
        if (isDefaultDialer() == false) goto L22;
        EventHistory callEventHistory = getEventStore().getEventHistory(2, phoneNumber);
        if (callEventHistory == null) goto L22;
        result.addEventHistory(callEventHistory);
    L22:
        if (isDefaultSmsApp() == false) goto L26;
        EventHistory smsEventHistory = getEventStore().getEventHistory(3, phoneNumber);
        if (smsEventHistory == null) goto L26;
        result.addEventHistory(smsEventHistory);
    L26:
        return result;
    }

    public EventHistory getClassLevelEventHistory(String className) {
        EventHistory eventHistory = getEventStore().getEventHistory(4, className);
        if (eventHistory == null) goto L6;
        return eventHistory;
    L6:
        return new AggregateEventHistoryImpl();
    }

    public boolean isDefaultDialer() {
        return this.mIsDefaultDialerPredicate.test(this.mPackageName);
    }

    public boolean isDefaultSmsApp() {
        return this.mIsDefaultSmsAppPredicate.test(this.mPackageName);
    }

    ConversationStore getConversationStore() {
        return this.mConversationStore;
    }

    EventStore getEventStore() {
        return this.mEventStore;
    }

    void deleteDataForConversation(String shortcutId) {
        ConversationInfo conversationInfo = this.mConversationStore.deleteConversation(shortcutId);
        if (conversationInfo != null) goto L5;
        return;
    L5:
        this.mEventStore.deleteEventHistory(0, shortcutId);
        if (conversationInfo.getLocusId() == null) goto L8;
        this.mEventStore.deleteEventHistory(1, conversationInfo.getLocusId().getId());
    L8:
        String phoneNumber = conversationInfo.getContactPhoneNumber();
        if (TextUtils.isEmpty(phoneNumber) == false) goto L11;
        return;
    L11:
        if (isDefaultDialer() == false) goto L14;
        this.mEventStore.deleteEventHistory(2, phoneNumber);
    L14:
        if (isDefaultSmsApp() == false) goto L18;
        this.mEventStore.deleteEventHistory(3, phoneNumber);
        return;
    }

    void pruneOrphanEvents() {
        this.mEventStore.pruneOrphanEventHistories(0, new PackageData$$ExternalSyntheticLambda0(this));
        this.mEventStore.pruneOrphanEventHistories(1, new PackageData$$ExternalSyntheticLambda1(this));
        if (isDefaultDialer() == false) goto L6;
        this.mEventStore.pruneOrphanEventHistories(2, new PackageData$$ExternalSyntheticLambda2(this));
    L6:
        if (isDefaultSmsApp() == false) goto L9;
        this.mEventStore.pruneOrphanEventHistories(3, new PackageData$$ExternalSyntheticLambda3(this));
        return;
    }

    private /* synthetic */ boolean lambda$pruneOrphanEvents$0(String key) {
        if (this.mConversationStore.getConversation(key) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ boolean lambda$pruneOrphanEvents$1(String key) {
        if (this.mConversationStore.getConversationByLocusId(new LocusId(key)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ boolean lambda$pruneOrphanEvents$2(String key) {
        if (this.mConversationStore.getConversationByPhoneNumber(key) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ boolean lambda$pruneOrphanEvents$3(String key) {
        if (this.mConversationStore.getConversationByPhoneNumber(key) == null) goto L5;
        return true;
    L5:
        return false;
    }

    void onDestroy() {
        this.mEventStore.onDestroy();
        this.mConversationStore.onDestroy();
        FileUtils.deleteContentsAndDir(this.mPackageDataDir);
    }
}
