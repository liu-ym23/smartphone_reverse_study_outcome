package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface m {
    s findContainButtonById(int r100);

    List<Integer> getAllShowedDataListIds();

    n getCheckManager();

    int getComponentByGroupId(int r100);

    int getComponentIndex(int r100);

    List<ToolbarButton> getFoldButtons(Boolean r100);

    boolean isComponentShowing(int r100);

    void refreshExistComponent(int r100);
}
