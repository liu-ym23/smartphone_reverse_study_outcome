package com.tmall.wireless.tangram.support.async;

import androidx.annotation.NonNull;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface AsyncLoader {

    public interface LoadedCallback {
        void fail(boolean r10);

        void finish();

        void finish(List<BaseCell> r10);
    }

    void loadData(Card r10, @NonNull LoadedCallback r11);
}
