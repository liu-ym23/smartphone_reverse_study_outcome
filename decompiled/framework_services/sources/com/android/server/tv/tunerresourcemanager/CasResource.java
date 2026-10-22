package com.android.server.tv.tunerresourcemanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class CasResource {
    private int mAvailableSessionNum;
    final long mHandle;
    private int mMaxSessionNum;
    private Map<Integer, Integer> mOwnerClientIdsToSessionNum;
    private final int mSystemId;

    public static class Builder {
        private final long mHandle;
        protected int mMaxSessionNum;
        private int mSystemId;

        /* JADX INFO: renamed from: -$$Nest$fgetmHandle, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m8994$$Nest$fgetmHandle(Builder r2) {
            return r2.mHandle;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSystemId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8995$$Nest$fgetmSystemId(Builder r0) {
            return r0.mSystemId;
        }

        Builder(long handle, int systemId) {
            this.mHandle = handle;
            this.mSystemId = systemId;
        }

        public Builder maxSessionNum(int maxSessionNum) {
            this.mMaxSessionNum = maxSessionNum;
            return this;
        }

        public CasResource build() {
            CasResource cas = new CasResource(this);
            return cas;
        }
    }

    CasResource(Builder builder) {
        this.mOwnerClientIdsToSessionNum = new HashMap();
        this.mHandle = Builder.m8994$$Nest$fgetmHandle(builder);
        this.mSystemId = Builder.m8995$$Nest$fgetmSystemId(builder);
        this.mMaxSessionNum = builder.mMaxSessionNum;
        this.mAvailableSessionNum = builder.mMaxSessionNum;
    }

    public long getHandle() {
        return this.mHandle;
    }

    public int getSystemId() {
        return this.mSystemId;
    }

    public int getMaxSessionNum() {
        return this.mMaxSessionNum;
    }

    public int getUsedSessionNum() {
        return this.mMaxSessionNum - this.mAvailableSessionNum;
    }

    public boolean isFullyUsed() {
        if (this.mAvailableSessionNum != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateMaxSessionNum(int maxSessionNum) {
        this.mAvailableSessionNum = Math.max(0, this.mAvailableSessionNum + (maxSessionNum - this.mMaxSessionNum));
        this.mMaxSessionNum = maxSessionNum;
    }

    public void setOwner(int ownerId) {
        if (this.mOwnerClientIdsToSessionNum.get(Integer.valueOf(ownerId)) != null) goto L5;
        int sessionNum = 1;
    L6:
        this.mOwnerClientIdsToSessionNum.put(Integer.valueOf(ownerId), Integer.valueOf(sessionNum));
        this.mAvailableSessionNum--;
        return;
    L5:
        sessionNum = this.mOwnerClientIdsToSessionNum.get(Integer.valueOf(ownerId)).intValue() + 1;
        goto L6
    }

    public void removeOwner(int ownerId) {
        if (this.mOwnerClientIdsToSessionNum.containsKey(Integer.valueOf(ownerId)) == false) goto L6;
        this.mAvailableSessionNum += this.mOwnerClientIdsToSessionNum.get(Integer.valueOf(ownerId)).intValue();
        this.mOwnerClientIdsToSessionNum.remove(Integer.valueOf(ownerId));
        return;
    }

    public void removeSession(int ownerId) {
        if (this.mOwnerClientIdsToSessionNum.containsKey(Integer.valueOf(ownerId)) == false) goto L8;
        int sessionNum = this.mOwnerClientIdsToSessionNum.get(Integer.valueOf(ownerId)).intValue();
        if (sessionNum <= 0) goto L9;
        this.mOwnerClientIdsToSessionNum.put(Integer.valueOf(ownerId), Integer.valueOf(sessionNum - 1));
        this.mAvailableSessionNum++;
        return;
    L9:
        return;
    }

    public boolean hasOpenSessions(int ownerId) {
        if (this.mOwnerClientIdsToSessionNum.get(Integer.valueOf(ownerId)).intValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<Integer> getOwnerClientIds() {
        return this.mOwnerClientIdsToSessionNum.keySet();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("CasResource[systemId=");
        r0.append(this.mSystemId);
        r0.append(", isFullyUsed=");
        if (this.mAvailableSessionNum != 0) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", maxSessionNum=");
        r0.append(this.mMaxSessionNum);
        r0.append(", ownerClients=");
        r0.append(ownersMapToString());
        r0.append("]");
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    protected String ownersMapToString() {
        StringBuilder string = new StringBuilder("{");
        Iterator<Integer> r1 = this.mOwnerClientIdsToSessionNum.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        int clienId = r1.next().intValue();
        string.append(" clientId=");
        string.append(clienId);
        string.append(", owns session num=");
        string.append(this.mOwnerClientIdsToSessionNum.get(Integer.valueOf(clienId)));
        string.append(",");
        goto L4
    L6:
        string.append("}");
        return string.toString();
    }
}
