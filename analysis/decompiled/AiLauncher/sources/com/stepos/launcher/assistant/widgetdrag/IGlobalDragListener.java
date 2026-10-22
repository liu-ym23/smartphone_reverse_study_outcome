package com.stepos.launcher.assistant.widgetdrag;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;

/* loaded from: classes.dex */
public interface IGlobalDragListener {
    boolean cancelDragAndDrop();

    DragEvent getDragEvent(int i10);

    GlobalDragItemInfo getDragItemInfo();

    void register(View view);

    void setDragListener(OnDragListener onDragListener);

    boolean startDrag(View view, GlobalDragItemInfo globalDragItemInfo);

    boolean startDrag(View view, GlobalDragItemInfo globalDragItemInfo, Bundle bundle, int i10);

    void unregister(View view);
}
