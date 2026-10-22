package com.byted.mgl.merge.base.api.internal.delegate;

import android.content.Context;
import com.bytedance.bdp.bdpbase.ipc.c;
import com.bytedance.bdp.bdpbase.ipc.r;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public interface IDelegateIpc {
    c.b getBdpIpcBuilder(Context r100);

    c getMainBdpIPC();

    void registerToHolder(List<r> r100);
}
