package com.android.server.credentials;

import android.credentials.CredentialDescription;
import android.credentials.RegisterCredentialDescriptionRequest;
import android.credentials.UnregisterCredentialDescriptionRequest;
import android.service.credentials.CredentialEntry;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class CredentialDescriptionRegistry {
    private static final int MAX_ALLOWED_CREDENTIAL_DESCRIPTIONS = 128;
    private static final int MAX_ALLOWED_ENTRIES_PER_PROVIDER = 16;
    private static final SparseArray<CredentialDescriptionRegistry> sCredentialDescriptionSessionPerUser = null;
    private static final ReentrantLock sLock = null;
    private Map<String, Set<CredentialDescription>> mCredentialDescriptions;
    private int mTotalDescriptionCount;

    public static final class FilterResult {
        final List<CredentialEntry> mCredentialEntries;
        final Set<String> mElementKeys;
        final String mPackageName;

        FilterResult(String packageName, Set<String> elementKeys, List<CredentialEntry> credentialEntries) {
            this.mPackageName = packageName;
            this.mElementKeys = elementKeys;
            this.mCredentialEntries = credentialEntries;
        }
    }

    static {
        sCredentialDescriptionSessionPerUser = new SparseArray();
        sLock = new ReentrantLock();
    }

    public static CredentialDescriptionRegistry forUser(int userId) {
        sLock.lock();
        CredentialDescriptionRegistry session = sCredentialDescriptionSessionPerUser.get(userId, null);     // Catch: Throwable -> L7
        if (session != null) goto L9;
        session = new CredentialDescriptionRegistry();     // Catch: Throwable -> L7
        sCredentialDescriptionSessionPerUser.put(userId, session);     // Catch: Throwable -> L7
    L9:
        sLock.unlock();
        return session;
    L7:
        th = move-exception;
        sLock.unlock();
        throw th;
    }

    public static void clearUserSession(int userId) {
        sLock.lock();
        sCredentialDescriptionSessionPerUser.remove(userId);     // Catch: Throwable -> L6
        sLock.unlock();
        return;
    L6:
        th = move-exception;
        sLock.unlock();
        throw th;
    }

    static void clearAllSessions() {
        sLock.lock();
        sCredentialDescriptionSessionPerUser.clear();     // Catch: Throwable -> L6
        sLock.unlock();
        return;
    L6:
        th = move-exception;
        sLock.unlock();
        throw th;
    }

    static void setSession(int userId, CredentialDescriptionRegistry credentialDescriptionRegistry) {
        sLock.lock();
        sCredentialDescriptionSessionPerUser.put(userId, credentialDescriptionRegistry);     // Catch: Throwable -> L6
        sLock.unlock();
        return;
    L6:
        th = move-exception;
        sLock.unlock();
        throw th;
    }

    private CredentialDescriptionRegistry() {
        this.mCredentialDescriptions = new HashMap();
        this.mTotalDescriptionCount = 0;
    }

    public void executeRegisterRequest(RegisterCredentialDescriptionRequest request, String callingPackageName) {
        if (this.mCredentialDescriptions.containsKey(callingPackageName) == true) goto L6;
        this.mCredentialDescriptions.put(callingPackageName, new HashSet());
    L6:
        if (this.mTotalDescriptionCount <= 128) goto L8;
        return;
    L8:
        if (this.mCredentialDescriptions.get(callingPackageName).size() > 16) goto L12;
        Set<CredentialDescription> descriptions = request.getCredentialDescriptions();
        int size = this.mCredentialDescriptions.get(callingPackageName).size();
        this.mCredentialDescriptions.get(callingPackageName).addAll(descriptions);
        this.mTotalDescriptionCount += this.mCredentialDescriptions.get(callingPackageName).size() - size;
        return;
    }

    public void executeUnregisterRequest(UnregisterCredentialDescriptionRequest request, String callingPackageName) {
        if (this.mCredentialDescriptions.containsKey(callingPackageName) == false) goto L6;
        int size = this.mCredentialDescriptions.get(callingPackageName).size();
        this.mCredentialDescriptions.get(callingPackageName).removeAll(request.getCredentialDescriptions());
        this.mTotalDescriptionCount -= size - this.mCredentialDescriptions.get(callingPackageName).size();
        return;
    }

    public Set<FilterResult> getFilteredResultForProvider(String packageName, Set<String> requestedKeyElements) {
        Set<FilterResult> result = new HashSet();
        if (this.mCredentialDescriptions.containsKey(packageName) == true) goto L5;
        return result;
    L5:
        Set<CredentialDescription> currentSet = this.mCredentialDescriptions.get(packageName);
        Iterator<CredentialDescription> r2 = currentSet.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        CredentialDescription containedDescription = r2.next();
        if (checkForMatch(containedDescription.getSupportedElementKeys(), requestedKeyElements) == false) goto L7;
        result.add(new FilterResult(packageName, containedDescription.getSupportedElementKeys(), containedDescription.getCredentialEntries()));
        goto L7
    L12:
        return result;
    }

    public Set<FilterResult> getMatchingProviders(Set<Set<String>> supportedElementKeys) {
        Set<FilterResult> result = new HashSet();
        Iterator<String> r1 = this.mCredentialDescriptions.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        String packageName = r1.next();
        Set<CredentialDescription> currentSet = this.mCredentialDescriptions.get(packageName);
        Iterator<CredentialDescription> r4 = currentSet.iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        CredentialDescription containedDescription = r4.next();
        if (canProviderSatisfyAny(containedDescription.getSupportedElementKeys(), supportedElementKeys) == false) goto L7;
        result.add(new FilterResult(packageName, containedDescription.getSupportedElementKeys(), containedDescription.getCredentialEntries()));
        goto L7
    L13:
        return result;
    }

    void evictProviderWithPackageName(String packageName) {
        if (this.mCredentialDescriptions.containsKey(packageName) == false) goto L6;
        this.mCredentialDescriptions.remove(packageName);
        return;
    }

    private static boolean canProviderSatisfyAny(Set<String> registeredElementKeys, Set<Set<String>> requestedElementKeys) {
        Iterator<Set<String>> r0 = requestedElementKeys.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Set<String> requestedUnflattenedString = r0.next();
        if (registeredElementKeys.containsAll(requestedUnflattenedString) == false) goto L4;
        return true;
    L10:
        return false;
    }

    static boolean checkForMatch(Set<String> registeredElementKeys, Set<String> requestedElementKeys) {
        return registeredElementKeys.containsAll(requestedElementKeys);
    }
}
