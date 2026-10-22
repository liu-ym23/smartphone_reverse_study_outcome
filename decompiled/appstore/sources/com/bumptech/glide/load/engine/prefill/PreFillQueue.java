package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class PreFillQueue {
    private final Map<PreFillType, Integer> bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List<PreFillType> keyList;

    public PreFillQueue(Map<PreFillType, Integer> r10) {
        this.bitmapsPerType = r10;
        this.keyList = new ArrayList(r10.keySet());
        Iterator<Integer> r11 = r10.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        this.bitmapsRemaining += r11.next().intValue();
        goto L4
    }

    public int getSize() {
        return this.bitmapsRemaining;
    }

    public boolean isEmpty() {
        if (this.bitmapsRemaining != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public PreFillType remove() {
        PreFillType r10 = this.keyList.get(this.keyIndex);
        Integer r11 = this.bitmapsPerType.get(r10);
        if (r11.intValue() != 1) goto L5;
        this.bitmapsPerType.remove(r10);
        this.keyList.remove(this.keyIndex);
    L6:
        this.bitmapsRemaining--;
        if (this.keyList.isEmpty() == false) goto L9;
        int r12 = 0;
    L10:
        this.keyIndex = r12;
        return r10;
    L9:
        r12 = (this.keyIndex + 1) % this.keyList.size();
        goto L10
    L5:
        this.bitmapsPerType.put(r10, Integer.valueOf(r11.intValue() - 1));
        goto L6
    }
}
