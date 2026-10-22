package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public interface c<T> {
    void dynamicSort(List<b> r100);

    List<T> getDynamicData(Function1<? super T, Boolean> r100);

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h getDynamicStatus(b r100);

    f getServerConfigStyleInfo(int r100);

    f getServerConfigStyleInfo(b r100);

    boolean needDynamicSort();

    boolean needDynamicStatus();
}
