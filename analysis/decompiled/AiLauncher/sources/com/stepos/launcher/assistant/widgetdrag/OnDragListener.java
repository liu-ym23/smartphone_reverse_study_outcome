package com.stepos.launcher.assistant.widgetdrag;

import android.view.DragEvent;
import android.view.SurfaceControl;
import android.view.View;

/* loaded from: classes.dex */
public interface OnDragListener {
    void onDragDrop(View view, DragEvent dragEvent, SurfaceControl surfaceControl, GlobalDragItemInfo globalDragItemInfo);

    default void onDragEnded(View view, DragEvent dragEvent, GlobalDragItemInfo globalDragItemInfo) {
    }

    default void onDragEntered(View view, DragEvent dragEvent, GlobalDragItemInfo globalDragItemInfo) {
    }

    default void onDragExited(View view, DragEvent dragEvent, GlobalDragItemInfo globalDragItemInfo) {
    }

    default void onDragLocation(View view, DragEvent dragEvent, GlobalDragItemInfo globalDragItemInfo) {
    }

    default void onDragStart(View view, DragEvent dragEvent, GlobalDragItemInfo globalDragItemInfo) {
    }
}
