package com.stepos.core.ability;

import com.stepos.core.common.storage.ModelPathStore;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements ModelPathStore.OnPathChangedListener {
    @Override // com.stepos.core.common.storage.ModelPathStore.OnPathChangedListener
    public final void onPathChanged(String str, String str2) {
        AbilityManager.initialize$lambda$26(str, str2);
    }
}
