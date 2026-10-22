package com.uxsense.rule;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.uxsense.base.parse.ParseRule;
import com.uxsense.core.pattern.ParentFilter;
import com.uxsense.core.pattern.ViewPattern;
import com.uxsense.parse.MetadataConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/uxsense/rule/ParseRuleBuilder;", "", "", "packageName", "windowTitle", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "Lkotlin/Function1;", "Lcom/uxsense/rule/MetadataConfigBuilder;", "LC7/r;", "block", "metadata", "(LS7/k;)V", "Lcom/uxsense/base/parse/ParseRule;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/uxsense/base/parse/ParseRule;", "Ljava/lang/String;", "activityClass", "getActivityClass", "()Ljava/lang/String;", "setActivityClass", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "Lcom/uxsense/core/pattern/ViewPattern;", "viewPattern", "Lcom/uxsense/core/pattern/ViewPattern;", "getViewPattern", "()Lcom/uxsense/core/pattern/ViewPattern;", "setViewPattern", "(Lcom/uxsense/core/pattern/ViewPattern;)V", "Lcom/uxsense/core/pattern/ParentFilter;", "parentFilter", "Lcom/uxsense/core/pattern/ParentFilter;", "getParentFilter", "()Lcom/uxsense/core/pattern/ParentFilter;", "setParentFilter", "(Lcom/uxsense/core/pattern/ParentFilter;)V", "Lcom/uxsense/parse/MetadataConfig;", "metadataConfig", "Lcom/uxsense/parse/MetadataConfig;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ParseRuleBuilder {
    private String activityClass;
    private String appVersion;
    private MetadataConfig metadataConfig;
    private final String packageName;
    private ParentFilter parentFilter;
    private ViewPattern viewPattern;
    private final String windowTitle;

    public ParseRuleBuilder(String packageName, String windowTitle) {
        k.f(packageName, "packageName");
        k.f(windowTitle, "windowTitle");
        this.packageName = packageName;
        this.windowTitle = windowTitle;
    }

    public final ParseRule build() {
        if (this.viewPattern == null) {
            throw new IllegalArgumentException("viewPattern is required");
        }
        String str = this.packageName;
        String str2 = this.windowTitle;
        String str3 = this.activityClass;
        String str4 = this.appVersion;
        ViewPattern viewPattern = this.viewPattern;
        k.c(viewPattern);
        return new ParseRule(str, str2, str3, str4, viewPattern, this.parentFilter, this.metadataConfig);
    }

    public final String getActivityClass() {
        return this.activityClass;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final ParentFilter getParentFilter() {
        return this.parentFilter;
    }

    public final ViewPattern getViewPattern() {
        return this.viewPattern;
    }

    public final void metadata(S7.k block) {
        k.f(block, "block");
        MetadataConfigBuilder metadataConfigBuilder = new MetadataConfigBuilder();
        block.invoke(metadataConfigBuilder);
        this.metadataConfig = metadataConfigBuilder.build();
    }

    public final void setActivityClass(String str) {
        this.activityClass = str;
    }

    public final void setAppVersion(String str) {
        this.appVersion = str;
    }

    public final void setParentFilter(ParentFilter parentFilter) {
        this.parentFilter = parentFilter;
    }

    public final void setViewPattern(ViewPattern viewPattern) {
        this.viewPattern = viewPattern;
    }
}
