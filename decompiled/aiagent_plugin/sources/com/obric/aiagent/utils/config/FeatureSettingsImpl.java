package com.obric.aiagent.utils.config;

import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig;
import d.h.b.aa;
import d.h.b.h;

/* JADX INFO: compiled from: FeatureSettingsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FeatureSettingsImpl implements IFeatureSettingsConfig {
    public static final a Companion = null;
    public static final String TAG = "FeatureSettingsImpl";

    /* JADX INFO: compiled from: FeatureSettingsImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public FeatureSettingsImpl() {
    }

    @Override // com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig
    public FeatureConfigMap getFeatureConfigMap() {
        if (at.a(aa.b(IFlowSettingsIDL.class)) != null) goto L5;
        ILogDepend.Companion.i(TAG, "IFlowSettingsIDL is null");
    L5:
        IFlowSettingsIDL r2 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r2 == null) goto L10;
        FeatureConfigMap r3 = r2.getFeatureConfigMap();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return new FeatureConfigMap(null, 1, null);
    }
}
