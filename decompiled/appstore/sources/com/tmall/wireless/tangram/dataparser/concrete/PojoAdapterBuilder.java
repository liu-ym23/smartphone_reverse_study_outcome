package com.tmall.wireless.tangram.dataparser.concrete;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.IAdapterBuilder;
import com.tmall.wireless.tangram.structure.BaseCell;

/* JADX INFO: loaded from: classes4.dex */
public class PojoAdapterBuilder implements IAdapterBuilder<Card, BaseCell> {
    public PojoAdapterBuilder() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.IAdapterBuilder
    public /* bridge */ /* synthetic */ GroupBasicAdapter<Card, BaseCell> newAdapter(@NonNull Context r10, @NonNull VirtualLayoutManager r11, @NonNull ServiceManager r12) {
        return newAdapter2(r10, r11, r12);
    }

    @Override // com.tmall.wireless.tangram.dataparser.IAdapterBuilder
    /* JADX INFO: renamed from: newAdapter, reason: avoid collision after fix types in other method */
    public GroupBasicAdapter<Card, BaseCell> newAdapter2(@NonNull Context r10, @NonNull VirtualLayoutManager r11, @NonNull ServiceManager r12) {
        return new PojoGroupBasicAdapter(r10, r11, (BaseCellBinderResolver) r12.getService(BaseCellBinderResolver.class), (BaseCardBinderResolver) r12.getService(BaseCardBinderResolver.class), (MVHelper) r12.getService(MVHelper.class));
    }
}
