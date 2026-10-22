package com.bytedance.android.live.utility.plugin_adapter;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/utility/plugin_adapter/IPluginClassFinder;", "Lcom/bytedance/android/live/base/IService;", "enable", "", "findClass", "Ljava/lang/Class;", "clazz", "", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPluginClassFinder extends IService {
    boolean enable();

    Class<?> findClass(String r100) throws ClassNotFoundException;
}
