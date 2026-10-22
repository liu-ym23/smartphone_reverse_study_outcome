package com.bytedance.android.shopping.anchorv3.activities.quick.base.event;

import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
public interface b {
    void appendEventParams(Pair<String, String>... r100);

    void doEventAction(String r100, Pair<String, String>... r101);

    void initEventContext(Pair<String, String>... r100);
}
