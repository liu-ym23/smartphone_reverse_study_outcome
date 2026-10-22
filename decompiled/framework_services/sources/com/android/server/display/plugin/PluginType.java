package com.android.server.display.plugin;

import com.android.server.display.plugin.types.HdrBoostOverride;

/* JADX INFO: loaded from: classes2.dex */
public class PluginType<T> {
    public static final PluginType<HdrBoostOverride> HDR_BOOST_OVERRIDE = null;
    final String mName;
    final Class<T> mType;

    static {
        HDR_BOOST_OVERRIDE = new PluginType(HdrBoostOverride.class, "hdr_boost_override");
    }

    PluginType(Class<T> type, String name) {
        this.mType = type;
        this.mName = name;
    }

    public String toString() {
        return "PluginType{mType=" + this.mType + ", mName=" + this.mName + '}';
    }
}
