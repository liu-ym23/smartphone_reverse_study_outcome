package com.android.server.display.plugin;

import android.content.Context;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface PluginsProvider {
    List<Plugin> getPlugins(Context r1, PluginStorage r2, Set<PluginType<?>> r3);
}
