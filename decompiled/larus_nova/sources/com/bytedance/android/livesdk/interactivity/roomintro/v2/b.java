package com.bytedance.android.livesdk.interactivity.roomintro.v2;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((RoomIntroLabel) r100).getShowOrder()), Long.valueOf(((RoomIntroLabel) r101).getShowOrder()));
    }
}
