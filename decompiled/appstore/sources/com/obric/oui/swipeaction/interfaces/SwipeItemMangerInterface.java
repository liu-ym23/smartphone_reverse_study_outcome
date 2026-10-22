package com.obric.oui.swipeaction.interfaces;

import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.util.Attributes$Mode;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SwipeItemMangerInterface {
    void closeAllExcept(OSwipeLayout r10);

    void closeAllItems();

    void closeItem(int r10);

    Attributes$Mode getMode();

    List<Integer> getOpenItems();

    List<OSwipeLayout> getOpenLayouts();

    boolean isOpen(int r10);

    void openItem(int r10);

    void removeShownLayouts(OSwipeLayout r10);

    void setMode(Attributes$Mode r10);
}
