package com.obric.aiagent.rom.compat.api;

import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IFeatureSettingsConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IFeatureSettingsConfig {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IFeatureSettingsConfig.kt */
    public static final class a implements IFeatureSettingsConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f18922a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IFeatureSettingsConfig f18923b;

        static {
            f18922a = new a();
        }

        @Override // com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig
        public FeatureConfigMap getFeatureConfigMap() {
            return this.f18923b.getFeatureConfigMap();
        }

        private a() {
            this.f18923b = (IFeatureSettingsConfig) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFeatureSettingsConfig.class), IFeatureSettingsConfig.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = a.f18922a;
    }

    FeatureConfigMap getFeatureConfigMap();
}
