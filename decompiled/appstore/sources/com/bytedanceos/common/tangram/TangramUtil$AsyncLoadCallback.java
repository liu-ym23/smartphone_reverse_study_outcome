package com.bytedanceos.common.tangram;

import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.support.async.AsyncLoader;
import com.tmall.wireless.tangram.support.async.AsyncPageLoader;

/* JADX INFO: loaded from: classes2.dex */
public interface TangramUtil$AsyncLoadCallback {
    void loadData(Card r10, AsyncLoader.LoadedCallback r11);

    void loadPageData(int r10, Card r11, AsyncPageLoader.LoadedCallback r12);
}
