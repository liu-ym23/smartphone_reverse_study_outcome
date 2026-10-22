package com.bytedance.android.livesdkapi.depend.model.live.pay;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
public interface ISubscribeMemberMark extends c<ISubscribeMemberMark> {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "subscribe_member_watch_free")
    boolean getSubscribeMemberFree();
}
