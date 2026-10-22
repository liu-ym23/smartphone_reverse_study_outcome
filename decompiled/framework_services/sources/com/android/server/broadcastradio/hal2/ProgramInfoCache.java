package com.android.server.broadcastradio.hal2;

import android.hardware.broadcastradio.V2_0.ProgramIdentifier;
import android.hardware.broadcastradio.V2_0.ProgramInfo;
import android.hardware.broadcastradio.V2_0.ProgramListChunk;
import android.hardware.radio.ProgramList;
import android.hardware.radio.ProgramSelector;
import android.hardware.radio.RadioManager;
import android.hardware.radio.UniqueProgramIdentifier;
import android.util.ArrayMap;
import android.util.ArraySet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class ProgramInfoCache {
    private static final int MAX_NUM_MODIFIED_PER_CHUNK = 100;
    private static final int MAX_NUM_REMOVED_PER_CHUNK = 500;
    private boolean mComplete;
    private final ProgramList.Filter mFilter;
    private final ArrayMap<ProgramSelector.Identifier, ArrayMap<UniqueProgramIdentifier, RadioManager.ProgramInfo>> mProgramInfoMap;

    ProgramInfoCache(ProgramList.Filter filter) {
        this.mProgramInfoMap = new ArrayMap();
        this.mComplete = true;
        this.mFilter = filter;
    }

    ProgramInfoCache(ProgramList.Filter filter, boolean complete, RadioManager.ProgramInfo... programInfos) {
        this.mProgramInfoMap = new ArrayMap();
        this.mComplete = true;
        this.mFilter = filter;
        this.mComplete = complete;
        int i = 0;
    L4:
        if (i >= programInfos.length) goto L7;
        putInfo(programInfos[i]);
        i = i + 1;
        goto L4
    }

    List<RadioManager.ProgramInfo> toProgramInfoList() {
        List<RadioManager.ProgramInfo> programInfoList = new ArrayList();
        int index = 0;
    L4:
        if (index >= this.mProgramInfoMap.size()) goto L7;
        programInfoList.addAll(this.mProgramInfoMap.valueAt(index).values());
        index = index + 1;
        goto L4
    L7:
        return programInfoList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProgramInfoCache(mComplete = ");
        sb.append(this.mComplete);
        sb.append(", mFilter = ");
        sb.append(this.mFilter);
        sb.append(", mProgramInfoMap = [");
        int index = 0;
    L4:
        if (index >= this.mProgramInfoMap.size()) goto L10;
        ArrayMap<UniqueProgramIdentifier, RadioManager.ProgramInfo> entries = this.mProgramInfoMap.valueAt(index);
        int entryIndex = 0;
    L7:
        if (entryIndex >= entries.size()) goto L9;
        sb.append(", ");
        sb.append(entries.valueAt(entryIndex));
        entryIndex = entryIndex + 1;
        goto L7
    L9:
        index = index + 1;
        goto L4
    L10:
        sb.append("]");
        return sb.toString();
    }

    public boolean isComplete() {
        return this.mComplete;
    }

    public ProgramList.Filter getFilter() {
        return this.mFilter;
    }

    void updateFromHalProgramListChunk(ProgramListChunk chunk) {
        if (chunk.purge == false) goto L5;
        this.mProgramInfoMap.clear();
    L5:
        Iterator<ProgramInfo> r0 = chunk.modified.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ProgramInfo halProgramInfo = r0.next();
        RadioManager.ProgramInfo programInfo = Convert.programInfoFromHal(halProgramInfo);
        putInfo(programInfo);
        goto L7
    L9:
        Iterator<ProgramIdentifier> r1 = chunk.removed.iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        ProgramIdentifier halProgramId = r1.next();
        this.mProgramInfoMap.remove(Convert.programIdentifierFromHal(halProgramId));
        goto L11
    L13:
        this.mComplete = chunk.complete;
    }

    List<ProgramList.Chunk> filterAndUpdateFrom(ProgramInfoCache other, boolean purge) {
        return filterAndUpdateFromInternal(other, purge, 100, 500);
    }

    List<ProgramList.Chunk> filterAndUpdateFromInternal(ProgramInfoCache other, boolean purge, int maxNumModifiedPerChunk, int maxNumRemovedPerChunk) {
        if (purge == false) goto L5;
        this.mProgramInfoMap.clear();
    L5:
        if (this.mProgramInfoMap.isEmpty() == false) goto L7;
        boolean purge2 = true;
    L8:
        ArraySet<RadioManager.ProgramInfo> modified = new ArraySet();
        ArraySet<UniqueProgramIdentifier> removed = new ArraySet();
        int index = 0;
    L10:
        if (index >= this.mProgramInfoMap.size()) goto L12;
        removed.addAll(this.mProgramInfoMap.valueAt(index).keySet());
        index = index + 1;
        goto L10
    L12:
        int index2 = 0;
    L14:
        if (index2 >= other.mProgramInfoMap.size()) goto L27;
        ProgramSelector.Identifier id = other.mProgramInfoMap.keyAt(index2);
        if (passesFilter(id) == false) goto L26;
        ArrayMap<UniqueProgramIdentifier, RadioManager.ProgramInfo> entries = other.mProgramInfoMap.valueAt(index2);
        int entryIndex = 0;
    L20:
        if (entryIndex >= entries.size()) goto L26;
        removed.remove(entries.keyAt(entryIndex));
        RadioManager.ProgramInfo newInfo = entries.valueAt(entryIndex);
        if (shouldIncludeInModified(newInfo) == false) goto L25;
        putInfo(newInfo);
        modified.add(newInfo);
    L25:
        entryIndex = entryIndex + 1;
    L26:
        index2 = index2 + 1;
        goto L14
    L27:
        int removedIndex = 0;
    L29:
        if (removedIndex >= removed.size()) goto L31;
        removeUniqueId(removed.valueAt(removedIndex));
        removedIndex = removedIndex + 1;
        goto L29
    L31:
        this.mComplete = other.mComplete;
        return buildChunks(purge2, this.mComplete, modified, maxNumModifiedPerChunk, removed, maxNumRemovedPerChunk);
    L7:
        purge2 = purge;
        goto L8
    }

    List<ProgramList.Chunk> filterAndApplyChunk(ProgramListChunk chunk) {
        return filterAndApplyChunkInternal(chunk, 100, 500);
    }

    List<ProgramList.Chunk> filterAndApplyChunkInternal(ProgramListChunk chunk, int maxNumModifiedPerChunk, int maxNumRemovedPerChunk) {
        if (chunk.purge == false) goto L5;
        this.mProgramInfoMap.clear();
    L5:
        Set<RadioManager.ProgramInfo> modified = new ArraySet();
        Iterator<ProgramInfo> r0 = chunk.modified.iterator();
    L7:
        if (r0.hasNext() == false) goto L14;
        ProgramInfo halProgramInfo = r0.next();
        RadioManager.ProgramInfo info = Convert.programInfoFromHal(halProgramInfo);
        ProgramSelector.Identifier primaryId = info.getSelector().getPrimaryId();
        if (passesFilter(primaryId) == false) goto L7;
        if (shouldIncludeInModified(info) == false) goto L7;
        putInfo(info);
        modified.add(info);
        goto L7
    L14:
        Set<UniqueProgramIdentifier> removed = new ArraySet();
        Iterator<ProgramIdentifier> r1 = chunk.removed.iterator();
    L16:
        if (r1.hasNext() == false) goto L25;
        ProgramIdentifier halProgramId = r1.next();
        ProgramSelector.Identifier removedId = Convert.programIdentifierFromHal(halProgramId);
        if (removedId == null) goto L16;
        if (this.mProgramInfoMap.containsKey(removedId) == false) goto L16;
        removed.addAll(this.mProgramInfoMap.get(removedId).keySet());
        this.mProgramInfoMap.remove(removedId);
        goto L16
    L25:
        if (modified.isEmpty() == true) goto L27;
    L34:
        this.mComplete = chunk.complete;
        return buildChunks(chunk.purge, this.mComplete, modified, maxNumModifiedPerChunk, removed, maxNumRemovedPerChunk);
    L27:
        if (removed.isEmpty() == false) goto L34;
        if (this.mComplete != chunk.complete) goto L34;
        if (chunk.purge == true) goto L34;
        return null;
    }

    private boolean passesFilter(ProgramSelector.Identifier id) {
        if (this.mFilter != null) goto L6;
        return true;
    L6:
        if (this.mFilter.getIdentifierTypes().isEmpty() == true) goto L11;
        if (this.mFilter.getIdentifierTypes().contains(Integer.valueOf(id.getType())) == true) goto L11;
        return false;
    L11:
        if (this.mFilter.getIdentifiers().isEmpty() == true) goto L16;
        if (this.mFilter.getIdentifiers().contains(id) == true) goto L16;
        return false;
    L16:
        if (this.mFilter.areCategoriesIncluded() == false) goto L18;
    L20:
        return true;
    L18:
        if (id.isCategoryType() == false) goto L20;
        return false;
    }

    private void putInfo(RadioManager.ProgramInfo info) {
        ProgramSelector.Identifier primaryId = info.getSelector().getPrimaryId();
        if (this.mProgramInfoMap.containsKey(primaryId) == true) goto L5;
        this.mProgramInfoMap.put(primaryId, new ArrayMap());
    L5:
        this.mProgramInfoMap.get(primaryId).put(new UniqueProgramIdentifier(info.getSelector()), info);
    }

    private void removeUniqueId(UniqueProgramIdentifier uniqueId) {
        ProgramSelector.Identifier primaryId = uniqueId.getPrimaryId();
        if (this.mProgramInfoMap.containsKey(primaryId) == true) goto L5;
        return;
    L5:
        this.mProgramInfoMap.get(primaryId).remove(uniqueId);
        if (this.mProgramInfoMap.get(primaryId).isEmpty() == false) goto L9;
        this.mProgramInfoMap.remove(primaryId);
        return;
    }

    private boolean shouldIncludeInModified(RadioManager.ProgramInfo newInfo) {
        ProgramSelector.Identifier primaryId = newInfo.getSelector().getPrimaryId();
        RadioManager.ProgramInfo oldInfo = null;
        if (this.mProgramInfoMap.containsKey(primaryId) == false) goto L6;
        UniqueProgramIdentifier uniqueId = new UniqueProgramIdentifier(newInfo.getSelector());
        RadioManager.ProgramInfo oldInfo2 = this.mProgramInfoMap.get(primaryId).get(uniqueId);
        oldInfo = oldInfo2;
    L6:
        if (oldInfo != null) goto L9;
        return true;
    L9:
        if (this.mFilter == null) goto L15;
        if (this.mFilter.areModificationsExcluded() == false) goto L15;
        return false;
    L15:
        return true ^ oldInfo.equals(newInfo);
    }

    private static int roundUpFraction(int numerator, int denominator) {
        int r0 = numerator / denominator;
        if ((numerator % denominator) <= 0) goto L5;
        int r1 = 1;
    L7:
        return r0 + r1;
    L5:
        r1 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    private static List<ProgramList.Chunk> buildChunks(boolean r16, boolean r17, Collection<RadioManager.ProgramInfo> r18, int r19, Collection<UniqueProgramIdentifier> r20, int r21) {
        if (r16 == false) goto L4;
        Collection<UniqueProgramIdentifier> r0 = null;
    L5:
        ?? r1 = r16;
        if (r18 == null) goto L8;
        ?? r2 = Math.max(r1, roundUpFraction(r18.size(), r19));
    L9:
        if (r0 == null) goto L11;
        ?? r3 = Math.max(r2, roundUpFraction(r0.size(), r21));
    L12:
        if (r3 == 0) goto L14;
        int r4 = 0;
        int r5 = 0;
        Iterator<RadioManager.ProgramInfo> r6 = null;
        Iterator<UniqueProgramIdentifier> r7 = null;
        if (r18 == null) goto L18;
        r4 = roundUpFraction(r18.size(), r3);
        r6 = r18.iterator();
    L18:
        if (r0 == null) goto L20;
        r5 = roundUpFraction(r0.size(), r3);
        r7 = r0.iterator();
    L20:
        ArrayList r8 = new ArrayList(r3);
        int r9 = 0;
    L21:
        if (r9 >= r3) goto L47;
        ArraySet r10 = new ArraySet();
        ArraySet r11 = new ArraySet();
        if (r6 == null) goto L29;
        int r12 = 0;
    L25:
        if (r12 >= r4) goto L29;
        if (r6.hasNext() == false) goto L29;
        r10.add(r6.next());
        r12 = r12 + 1;
    L29:
        if (r7 == null) goto L36;
        int r13 = 0;
    L31:
        if (r13 >= r5) goto L36;
        if (r7.hasNext() == false) goto L36;
        r11.add(r7.next());
        r13 = r13 + 1;
    L36:
        if (r16 == false) goto L39;
        if (r9 != 0) goto L39;
        boolean r15 = true;
    L40:
        if (r17 == true) goto L42;
    L44:
        boolean r14 = false;
    L45:
        r8.add(new ProgramList.Chunk(r15, r14, r10, r11));
        r9 = r9 + 1;
        goto L21
    L42:
        if (r9 != (r3 - 1)) goto L44;
        r14 = true;
    L39:
        r15 = false;
        goto L40
    L47:
        return r8;
    L14:
        return new ArrayList();
    L11:
        r3 = r2;
        goto L12
    L8:
        r2 = r1;
        goto L9
    L4:
        r0 = r20;
        goto L5
    }
}
