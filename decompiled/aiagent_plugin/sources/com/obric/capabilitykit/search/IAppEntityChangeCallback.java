package com.obric.capabilitykit.search;

import com.obric.capabilitykit.entity.search.EntityChangeResult;

/* JADX INFO: loaded from: classes4.dex */
public interface IAppEntityChangeCallback {
    void onChange(EntityChangeResult r1);

    void onError(int r1, String r2);
}
