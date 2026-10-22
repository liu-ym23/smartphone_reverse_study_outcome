package com.stepos.config.dag.loader;

import com.stepos.config.dag.ConfigBean;
import com.stepos.config.dag.ConfigInitException;
import com.stepos.config.dag.ConfigurationRegistry;

/* loaded from: classes.dex */
public interface ConfigLoader {
    Object getConfigData(String str);

    void parseConfig(String str, ConfigBean configBean, ConfigurationRegistry configurationRegistry) throws ConfigInitException;
}
