package com.tmall.wireless.tangram.structure.view;

import com.tmall.wireless.tangram.structure.BaseCell;

/* JADX INFO: loaded from: classes4.dex */
public interface ITangramViewLifeCycle {
    void cellInited(BaseCell r10);

    void postBindView(BaseCell r10);

    void postUnBindView(BaseCell r10);
}
