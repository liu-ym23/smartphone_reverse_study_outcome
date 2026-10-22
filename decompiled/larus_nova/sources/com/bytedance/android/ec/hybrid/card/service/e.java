package com.bytedance.android.ec.hybrid.card.service;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes44.dex */
public interface e extends d {
    com.bytedance.android.ec.hybrid.card.api.a a(Context r100, String r101, String r102);

    com.bytedance.android.ec.hybrid.card.api.a b(String r100);

    void c(Context r100, String r101);

    CopyOnWriteArraySet<Integer> d(String r100);
}
