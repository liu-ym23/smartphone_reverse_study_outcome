package com.tmall.wireless.tangram.dataparser;

import androidx.annotation.Nullable;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DataParser<T, C, L> {
    public DataParser() {
    }

    @Nullable
    public abstract List<L> parseComponent(@Nullable T r10, ServiceManager r11);

    @Nullable
    public abstract List<C> parseGroup(@Nullable T r10, ServiceManager r11);
}
