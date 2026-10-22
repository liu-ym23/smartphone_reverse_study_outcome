package com.android.server.hdmi;

import android.util.FastImmutableArraySet;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
final class HdmiCecMessageCache {
    private static final FastImmutableArraySet<Integer> CACHEABLE_OPCODES = null;
    private final SparseArray<SparseArray<HdmiCecMessage>> mCache;

    static {
        CACHEABLE_OPCODES = new FastImmutableArraySet(new Integer[]{71, 132, 135, 158});
    }

    HdmiCecMessageCache() {
        this.mCache = new SparseArray();
    }

    public HdmiCecMessage getMessage(int address, int opcode) {
        SparseArray<HdmiCecMessage> messages = this.mCache.get(address);
        if (messages != null) goto L7;
        return null;
    L7:
        return messages.get(opcode);
    }

    public void flushMessagesFrom(int address) {
        this.mCache.remove(address);
    }

    public void flushAll() {
        this.mCache.clear();
    }

    public void cacheMessage(HdmiCecMessage message) {
        int opcode = message.getOpcode();
        if (isCacheable(opcode) == true) goto L5;
        return;
    L5:
        int source = message.getSource();
        SparseArray<HdmiCecMessage> messages = this.mCache.get(source);
        if (messages != null) goto L8;
        messages = new SparseArray();
        this.mCache.put(source, messages);
    L8:
        messages.put(opcode, message);
    }

    private boolean isCacheable(int opcode) {
        return CACHEABLE_OPCODES.contains(Integer.valueOf(opcode));
    }
}
