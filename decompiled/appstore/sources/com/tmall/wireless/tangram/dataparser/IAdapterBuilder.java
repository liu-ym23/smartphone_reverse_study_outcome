package com.tmall.wireless.tangram.dataparser;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.core.service.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public interface IAdapterBuilder<L, C> {
    GroupBasicAdapter<L, C> newAdapter(@NonNull Context r10, @NonNull VirtualLayoutManager r11, @NonNull ServiceManager r12);
}
