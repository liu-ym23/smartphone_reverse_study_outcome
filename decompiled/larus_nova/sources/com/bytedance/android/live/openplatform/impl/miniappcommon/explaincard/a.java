package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public interface a<T> {
    View getExplainCardView();

    Function0<Unit> getOnBtnClickBlock();

    Function0<Unit> getOnClickBlock();

    Function0<Unit> getOnCloseBlock();

    void setData(T r100);

    void setOnBtnClickBlock(Function0<Unit> r100);

    void setOnClickBlock(Function0<Unit> r100);

    void setOnCloseBlock(Function0<Unit> r100);

    void setSupplementInfo(com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r100);
}
