package com.android.server.wm;

import android.hardware.display.DisplayManagerInternal;
import android.util.ArraySet;
import android.util.SparseArray;
import android.view.DisplayInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class PossibleDisplayInfoMapper {
    private static final boolean DEBUG = false;
    private static final String TAG = "PossibleDisplayInfoMapper";
    private final SparseArray<Set<DisplayInfo>> mDisplayInfos;
    private final DisplayManagerInternal mDisplayManagerInternal;

    PossibleDisplayInfoMapper(DisplayManagerInternal displayManagerInternal) {
        this.mDisplayInfos = new SparseArray();
        this.mDisplayManagerInternal = displayManagerInternal;
    }

    public List<DisplayInfo> getPossibleDisplayInfos(int displayId) {
        updatePossibleDisplayInfos(displayId);
        if (this.mDisplayInfos.contains(displayId) == true) goto L7;
        return new ArrayList();
    L7:
        return List.copyOf(this.mDisplayInfos.get(displayId));
    }

    public void updatePossibleDisplayInfos(int displayId) {
        Set<DisplayInfo> displayInfos = this.mDisplayManagerInternal.getPossibleDisplayInfo(displayId);
        updateDisplayInfos(displayInfos);
    }

    public void removePossibleDisplayInfos(int displayId) {
        this.mDisplayInfos.remove(displayId);
    }

    private void updateDisplayInfos(Set<DisplayInfo> displayInfos) {
        this.mDisplayInfos.clear();
        Iterator<DisplayInfo> r0 = displayInfos.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DisplayInfo di = r0.next();
        Set<DisplayInfo> priorDisplayInfos = this.mDisplayInfos.get(di.displayId, new ArraySet());
        priorDisplayInfos.add(di);
        this.mDisplayInfos.put(di.displayId, priorDisplayInfos);
        goto L4
    }
}
