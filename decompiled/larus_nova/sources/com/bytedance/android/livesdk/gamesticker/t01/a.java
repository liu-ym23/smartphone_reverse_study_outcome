package com.bytedance.android.livesdk.gamesticker.t01;

import com.bytedance.android.livesdk.chatroom.model.r3;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((r3) r100).a()), Integer.valueOf(((r3) r101).a()));
    }
}
