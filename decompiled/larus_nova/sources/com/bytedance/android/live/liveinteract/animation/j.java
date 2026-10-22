package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class j<T> implements Comparator<T> {
    public j() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ILinkPlayerInfoBridge) r100).getUserPosition()), Integer.valueOf(((ILinkPlayerInfoBridge) r101).getUserPosition()));
    }
}
