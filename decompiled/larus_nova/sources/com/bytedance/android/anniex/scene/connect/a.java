package com.bytedance.android.anniex.scene.connect;

import java.util.Comparator;
import java.util.Map;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Double) ((Pair) ((Map.Entry) r101).getValue()).getSecond(), (Double) ((Pair) ((Map.Entry) r100).getValue()).getSecond());
    }
}
