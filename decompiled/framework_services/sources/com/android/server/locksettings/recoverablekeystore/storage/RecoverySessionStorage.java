package com.android.server.locksettings.recoverablekeystore.storage;

import android.util.SparseArray;
import com.android.internal.widget.LockPatternUtils;
import java.util.ArrayList;
import java.util.Iterator;
import javax.security.auth.Destroyable;

/* JADX INFO: loaded from: classes2.dex */
public class RecoverySessionStorage implements Destroyable {
    private final SparseArray<ArrayList<Entry>> mSessionsByUid;

    public static class Entry implements Destroyable {
        private final byte[] mKeyClaimant;
        private final byte[] mLskfHash;
        private final String mSessionId;
        private final byte[] mVaultParams;

        /* JADX INFO: renamed from: -$$Nest$fgetmSessionId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5492$$Nest$fgetmSessionId(Entry r0) {
            return r0.mSessionId;
        }

        public Entry(String sessionId, byte[] lskfHash, byte[] keyClaimant, byte[] vaultParams) {
            this.mLskfHash = lskfHash;
            this.mSessionId = sessionId;
            this.mKeyClaimant = keyClaimant;
            this.mVaultParams = vaultParams;
        }

        public byte[] getLskfHash() {
            return this.mLskfHash;
        }

        public byte[] getKeyClaimant() {
            return this.mKeyClaimant;
        }

        public byte[] getVaultParams() {
            return this.mVaultParams;
        }

        @Override // javax.security.auth.Destroyable
        public void destroy() {
            LockPatternUtils.zeroize(this.mLskfHash);
            LockPatternUtils.zeroize(this.mKeyClaimant);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$PEeZ1_XljN40HyjHdIgJGx-FV_o, reason: not valid java name */
    public static /* synthetic */ boolean m5491$r8$lambda$PEeZ1_XljN40HyjHdIgJGxFV_o(String r0, Entry r1) {
        return lambda$remove$0(r0, r1);
    }

    public RecoverySessionStorage() {
        this.mSessionsByUid = new SparseArray();
    }

    public Entry get(int uid, String sessionId) {
        ArrayList<Entry> userEntries = this.mSessionsByUid.get(uid);
        if (userEntries != null) goto L5;
        return null;
    L5:
        Iterator<Entry> r2 = userEntries.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Entry entry = r2.next();
        if (sessionId.equals(Entry.m5492$$Nest$fgetmSessionId(entry)) == false) goto L7;
        return entry;
    L12:
        return null;
    }

    public void add(int uid, Entry entry) {
        if (this.mSessionsByUid.get(uid) != null) goto L5;
        this.mSessionsByUid.put(uid, new ArrayList());
    L5:
        this.mSessionsByUid.get(uid).add(entry);
    }

    public void remove(int uid, final String sessionId) {
        if (this.mSessionsByUid.get(uid) != null) goto L5;
        return;
    L5:
        this.mSessionsByUid.get(uid).removeIf(new RecoverySessionStorage$$ExternalSyntheticLambda0(sessionId));
    }

    private static /* synthetic */ boolean lambda$remove$0(String sessionId, Entry session) {
        return Entry.m5492$$Nest$fgetmSessionId(session).equals(sessionId);
    }

    public void remove(int uid) {
        ArrayList<Entry> entries = this.mSessionsByUid.get(uid);
        if (entries != null) goto L5;
        return;
    L5:
        Iterator<Entry> r1 = entries.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Entry entry = r1.next();
        entry.destroy();
        goto L7
    L9:
        this.mSessionsByUid.remove(uid);
    }

    public int size() {
        int size = 0;
        int numberOfUsers = this.mSessionsByUid.size();
        int i = 0;
    L3:
        if (i >= numberOfUsers) goto L6;
        ArrayList<Entry> entries = this.mSessionsByUid.valueAt(i);
        size = size + entries.size();
        i = i + 1;
        goto L3
    L6:
        return size;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        int numberOfUids = this.mSessionsByUid.size();
        int i = 0;
    L3:
        if (i >= numberOfUids) goto L10;
        ArrayList<Entry> entries = this.mSessionsByUid.valueAt(i);
        Iterator<Entry> r3 = entries.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Entry entry = r3.next();
        entry.destroy();
        goto L6
    L8:
        i = i + 1;
        goto L3
    }
}
