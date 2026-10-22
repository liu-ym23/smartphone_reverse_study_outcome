package com.obric.structure.omvvm.core.config;

import android.os.Handler;
import com.obric.structure.omvvm.core.extension.QConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/structure/omvvm/core/config/DefaultConfig;", "Lcom/obric/structure/omvvm/core/extension/QConfig;", "()V", "channel", "", "handler", "Landroid/os/Handler;", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultConfig implements QConfig {
    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public String channel() {
        return "";
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public Handler handler() {
        return null;
    }

    public DefaultConfig() {
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public boolean enableInsight() {
        return QConfig.DefaultImpls.enableInsight(this);
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public boolean fixAsyncQuery() {
        return QConfig.DefaultImpls.fixAsyncQuery(this);
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public boolean fixModuleViewAddError() {
        return QConfig.DefaultImpls.fixModuleViewAddError(this);
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public boolean fixQContextLifecycleLeak() {
        return QConfig.DefaultImpls.fixQContextLifecycleLeak(this);
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public boolean fixQLiveDataMemLeak() {
        return QConfig.DefaultImpls.fixQLiveDataMemLeak(this);
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public int frameMinLimit() {
        return QConfig.DefaultImpls.frameMinLimit(this);
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public QMonitorConfig monitorCig() {
        return QConfig.DefaultImpls.monitorCig(this);
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public boolean openVsyncWorker() {
        return QConfig.DefaultImpls.openVsyncWorker(this);
    }

    @Override // com.obric.structure.omvvm.core.extension.QConfig
    public void uploadLog(String r1) {
        QConfig.DefaultImpls.uploadLog(this, r1);
    }
}
