package com.tmall.wireless.tangram;

import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface Engine extends ServiceManager {
    void refresh();

    void refresh(boolean r10);

    void replaceCard(Card r10, Card r11);

    void replaceCells(Card r10, List<BaseCell> r11);

    void scrollToPosition(Card r10);

    void scrollToPosition(BaseCell r10);

    void topPosition(Card r10);

    void topPosition(BaseCell r10);
}
