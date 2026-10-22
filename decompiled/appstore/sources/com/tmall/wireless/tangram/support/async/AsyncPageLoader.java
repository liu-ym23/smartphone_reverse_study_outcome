package com.tmall.wireless.tangram.support.async;

import androidx.annotation.NonNull;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface AsyncPageLoader {

    public interface LoadedCallback {
        void fail(boolean r10);

        void finish(List<BaseCell> r10, boolean r11);

        void finish(boolean r10);
    }

    void loadData(int r10, @NonNull Card r11, @NonNull LoadedCallback r12);
}
