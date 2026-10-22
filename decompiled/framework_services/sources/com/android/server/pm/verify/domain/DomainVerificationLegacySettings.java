package com.android.server.pm.verify.domain;

import android.content.pm.IntentFilterVerificationInfo;
import android.util.ArrayMap;
import android.util.SparseIntArray;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.SettingsXml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationLegacySettings {
    public static final String ATTR_PACKAGE_NAME = "packageName";
    public static final String ATTR_STATE = "state";
    public static final String ATTR_USER_ID = "userId";
    public static final String TAG_DOMAIN_VERIFICATIONS_LEGACY = "domain-verifications-legacy";
    public static final String TAG_USER_STATE = "user-state";
    public static final String TAG_USER_STATES = "user-states";
    private final Object mLock;
    private final ArrayMap<String, LegacyState> mStates;

    static class LegacyState {
        private boolean attached;
        private IntentFilterVerificationInfo mInfo;
        private SparseIntArray mUserStates;

        LegacyState() {
        }

        public IntentFilterVerificationInfo getInfo() {
            return this.mInfo;
        }

        public int getUserState(int userId) {
            return this.mUserStates.get(userId, 0);
        }

        public SparseIntArray getUserStates() {
            return this.mUserStates;
        }

        public void setInfo(IntentFilterVerificationInfo info) {
            this.mInfo = info;
        }

        public void addUserState(int userId, int state) {
            if (this.mUserStates != null) goto L5;
            this.mUserStates = new SparseIntArray(1);
        L5:
            this.mUserStates.put(userId, state);
        }

        public boolean isAttached() {
            return this.attached;
        }

        public void markAttached() {
            this.attached = true;
        }
    }

    public DomainVerificationLegacySettings() {
        this.mLock = new Object();
        this.mStates = new ArrayMap();
    }

    public void add(String packageName, IntentFilterVerificationInfo info) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        getOrCreateStateLocked(packageName).setInfo(info);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void add(String packageName, int userId, int state) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        getOrCreateStateLocked(packageName).addUserState(userId, state);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getUserState(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LegacyState state = this.mStates.get(packageName);     // Catch: Throwable -> L9
        if (state == null) goto L12;
        int r2 = state.getUserState(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    public SparseIntArray getUserStates(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LegacyState state = this.mStates.get(packageName);     // Catch: Throwable -> L9
        if (state == null) goto L12;
        SparseIntArray r2 = state.getUserStates();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public IntentFilterVerificationInfo remove(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LegacyState state = this.mStates.get(packageName);     // Catch: Throwable -> L11
        if (state != null) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L7:
        if (state.isAttached() == true) goto L13;
        state.markAttached();     // Catch: Throwable -> L11
        IntentFilterVerificationInfo r2 = state.getInfo();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    private LegacyState getOrCreateStateLocked(String packageName) {
        LegacyState state = this.mStates.get(packageName);
        if (state != null) goto L6;
        LegacyState state2 = new LegacyState();
        this.mStates.put(packageName, state2);
        return state2;
    L6:
        return state;
    }

    public void writeSettings(TypedXmlSerializer xmlSerializer) throws IOException {
        SettingsXml.Serializer serializer = SettingsXml.serializer(xmlSerializer);
        SettingsXml.WriteSection ignored = serializer.startSection(TAG_DOMAIN_VERIFICATIONS_LEGACY);     // Catch: Throwable -> L39
        Object r4 = this.mLock;     // Catch: Throwable -> L45
        monitor-enter(r4);     // Catch: Throwable -> L45
        int statesSize = this.mStates.size();     // Catch: Throwable -> L24
        int stateIndex = 0;
    L8:
        if (stateIndex >= statesSize) goto L35;
        LegacyState state = this.mStates.valueAt(stateIndex);     // Catch: Throwable -> L24
        SparseIntArray userStates = state.getUserStates();     // Catch: Throwable -> L24
        if (userStates == null) goto L26;
        String packageName = this.mStates.keyAt(stateIndex);     // Catch: Throwable -> L24
        SettingsXml.WriteSection userStatesSection = serializer.startSection(TAG_USER_STATES).attribute("packageName", packageName);     // Catch: Throwable -> L24
        int userStatesSize = userStates.size();     // Catch: Throwable -> L18
        int userStateIndex = 0;
    L15:
        if (userStateIndex >= userStatesSize) goto L21;
        int userId = userStates.keyAt(userStateIndex);     // Catch: Throwable -> L18
        int userState = userStates.valueAt(userStateIndex);     // Catch: Throwable -> L18
        userStatesSection.startSection("user-state").attribute("userId", userId).attribute("state", userState).finish();     // Catch: Throwable -> L18
        userStateIndex = userStateIndex + 1;
        goto L15
    L21:
        if (userStatesSection == null) goto L26;
        userStatesSection.close();     // Catch: Throwable -> L24
    L18:
        th = move-exception;
        if (userStatesSection == null) goto L76;
        userStatesSection.close();     // Catch: Throwable -> L30
    L77:
        throw th;     // Catch: Throwable -> L24
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L76:
        throw th;     // Catch: Throwable -> L24
    L26:
        stateIndex = stateIndex + 1;
        goto L8
    L35:
        monitor-exit(r4);     // Catch: Throwable -> L24
        if (ignored == null) goto L41;
        ignored.close();     // Catch: Throwable -> L39
    L41:
        serializer.close();
        return;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        if (ignored == null) goto L78;
        ignored.close();     // Catch: Throwable -> L50
    L79:
        throw th;     // Catch: Throwable -> L39
    L50:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L78:
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (serializer == null) goto L80;
        serializer.close();     // Catch: Throwable -> L57
        throw th;
    L57:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L80:
        throw th;
    }

    public void readSettings(TypedXmlPullParser xmlParser) throws IOException, XmlPullParserException {
        SettingsXml.ChildSection child = SettingsXml.parser(xmlParser).children();
    L4:
        if (child.moveToNext() == false) goto L8;
        if (TAG_USER_STATES.equals(child.getName()) == false) goto L4;
        readUserStates(child);
        goto L4
    }

    private void readUserStates(SettingsXml.ReadSection section) {
        String packageName = section.getString("packageName");
        Object r1 = this.mLock;
        monitor-enter(r1);
        LegacyState legacyState = getOrCreateStateLocked(packageName);     // Catch: Throwable -> L10
        SettingsXml.ChildSection child = section.children();     // Catch: Throwable -> L10
    L6:
        if (child.moveToNext() == false) goto L13;
        if ("user-state".equals(child.getName()) == false) goto L6;
        readUserState(child, legacyState);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void readUserState(SettingsXml.ReadSection section, LegacyState legacyState) {
        int userId = section.getInt("userId");
        int state = section.getInt("state");
        legacyState.addUserState(userId, state);
    }
}
