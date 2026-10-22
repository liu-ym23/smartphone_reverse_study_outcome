package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceCertPluginOptConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "preload_cert", "", "preload_config", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceCertPluginOptConfig$CJPayCertPluginPreloadConfig;", "Lkotlin/collections/ArrayList;", "preload_ticket", "retry_aliyun_plugin", "upgrade_load_api", "CJPayCertPluginPreloadConfig", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceCertPluginOptConfig implements CJPayObject, Serializable {
    public String preload_cert;
    public ArrayList<CJPayCertPluginPreloadConfig> preload_config;
    public String preload_ticket;
    public String retry_aliyun_plugin;
    public String upgrade_load_api;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceCertPluginOptConfig$CJPayCertPluginPreloadConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "delay_time", "", "risk_source", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayCertPluginPreloadConfig implements CJPayObject, Serializable {
        public long delay_time;
        public String risk_source;

        public CJPayCertPluginPreloadConfig() {
            this.risk_source = "";
        }
    }

    public CJPayFaceCertPluginOptConfig() {
        this.upgrade_load_api = "1";
        this.retry_aliyun_plugin = "1";
        this.preload_ticket = "0";
        this.preload_cert = "0";
        this.preload_config = new ArrayList();
    }
}
