package com.bytedance.services.apm.api;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public interface IZstdDict {
    Pair<byte[], String> getDictAndDictVersion();

    void setDomain(String r1);
}
