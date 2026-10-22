package com.bumptech.glide.load.engine.prefill;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
final class PreFillQueue {
    private final Map<PreFillType, Integer> bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List<PreFillType> keyList;

    public boolean isEmpty() {
        if (this.bitmapsRemaining != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public PreFillType remove() {
        PreFillType r100 = (PreFillType) ListProtector.get(this.keyList, this.keyIndex);
        Integer r101 = this.bitmapsPerType.get(r100);
        if (r101.intValue() != 1) goto L5;
        this.bitmapsPerType.remove(r100);
        ListProtector.remove(this.keyList, this.keyIndex);
    L6:
        this.bitmapsRemaining--;
        if (this.keyList.isEmpty() == false) goto L9;
        int r102 = 0;
    L10:
        this.keyIndex = r102;
        return r100;
    L9:
        r102 = (this.keyIndex + 1) % this.keyList.size();
        goto L10
    L5:
        this.bitmapsPerType.put(r100, Integer.valueOf(r101.intValue() - 1));
        goto L6
    }

    public int getSize() {
        return this.bitmapsRemaining;
    }

    public PreFillQueue(Map<PreFillType, Integer> r100) {
        this.bitmapsPerType = r100;
        this.keyList = new ArrayList(r100.keySet());
        Iterator<Integer> r101 = r100.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        this.bitmapsRemaining += r101.next().intValue();
        goto L4
    }
}
