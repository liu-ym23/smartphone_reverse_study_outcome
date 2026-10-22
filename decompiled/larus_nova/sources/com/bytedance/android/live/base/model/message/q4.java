package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface q4 extends vh7.c<q4> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = ITTVideoEngineEventSource.KEY_VOLUME)
    double getVolume();
}
