package com.bytedanceos.common.tangram;

import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;

/* JADX INFO: loaded from: classes2.dex */
public interface Bind<T> {
    void bindData(T r10, BaseCell r11);

    void bindStyle(Style r10, BaseCell r11);

    void unBind();
}
