package com.bytedance.android.shopping.store.tabkit.events;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import com.bytedance.android.livehostapi.platform.IHostAction;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010%\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 ¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/events/SecurityMonitorEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "()V", "bizTag", "", "getBizTag", "()Ljava/lang/String;", "setBizTag", "(Ljava/lang/String;)V", "fullUrl", "getFullUrl", "setFullUrl", "originScheme", "getOriginScheme", "setOriginScheme", "ruleType", "getRuleType", "setRuleType", "ruleTypeV2", "getRuleTypeV2", "setRuleTypeV2", "settingSource", "getSettingSource", "setSettingSource", "url", "getUrl", "setUrl", "verifyMode", "", "getVerifyMode", "()Ljava/lang/Integer;", "setVerifyMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "verifyModeV2", "getVerifyModeV2", "setVerifyModeV2", "version", "getVersion", "setVersion", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SecurityMonitorEvent extends BaseMetricsEvent2 {

    @EventKey("biz_tag")
    private String bizTag;

    @EventKey("full_url")
    private String fullUrl;

    @EventKey(IHostAction.ORIGIN_SCHEME)
    private String originScheme;

    @EventKey("rule_type")
    private String ruleType;

    @EventKey("ruleType")
    private String ruleTypeV2;

    @EventKey("setting_source")
    private String settingSource;

    @EventKey("url")
    private String url;

    @EventKey("verify_mode")
    private Integer verifyMode;

    @EventKey("verifyMode")
    private Integer verifyModeV2;

    @EventKey("version")
    private Integer version;

    public SecurityMonitorEvent() {
        super("ec_tabkit_security_monitor");
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final String getFullUrl() {
        return this.fullUrl;
    }

    public final String getOriginScheme() {
        return this.originScheme;
    }

    public final String getRuleType() {
        return this.ruleType;
    }

    public final String getRuleTypeV2() {
        return this.ruleTypeV2;
    }

    public final String getSettingSource() {
        return this.settingSource;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getVerifyMode() {
        return this.verifyMode;
    }

    public final Integer getVerifyModeV2() {
        return this.verifyModeV2;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final void setBizTag(String r100) {
        this.bizTag = r100;
    }

    public final void setFullUrl(String r100) {
        this.fullUrl = r100;
    }

    public final void setOriginScheme(String r100) {
        this.originScheme = r100;
    }

    public final void setRuleType(String r100) {
        this.ruleType = r100;
    }

    public final void setRuleTypeV2(String r100) {
        this.ruleTypeV2 = r100;
    }

    public final void setSettingSource(String r100) {
        this.settingSource = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setVerifyMode(Integer r100) {
        this.verifyMode = r100;
    }

    public final void setVerifyModeV2(Integer r100) {
        this.verifyModeV2 = r100;
    }

    public final void setVersion(Integer r100) {
        this.version = r100;
    }
}
