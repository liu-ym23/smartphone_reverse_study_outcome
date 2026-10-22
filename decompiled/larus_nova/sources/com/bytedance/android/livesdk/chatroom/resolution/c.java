package com.bytedance.android.livesdk.chatroom.resolution;

import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((LiveCoreSDKData.Quality) r101).getLevel()), Integer.valueOf(((LiveCoreSDKData.Quality) r100).getLevel()));
    }
}
