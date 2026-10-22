package com.stepos.core.deepbinder;

import com.stepos.deepbinder.annotation.type.Callback;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Callback
/* loaded from: classes.dex */
public interface IModelChangeListener {
    void onModelChanged(String str, int i10, int i11, String str2);

    void onModelRollback(String str, int i10, int i11, String str2);

    void onRecycle();
}
