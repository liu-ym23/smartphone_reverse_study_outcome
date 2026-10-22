package androidx.webkit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class ProxyConfig {
    private static final String BYPASS_RULE_REMOVE_IMPLICIT = "<-loopback>";
    private static final String BYPASS_RULE_SIMPLE_NAMES = "<local>";
    private static final String DIRECT = "direct://";
    public static final String MATCH_ALL_SCHEMES = "*";
    public static final String MATCH_HTTP = "http";
    public static final String MATCH_HTTPS = "https";
    private List<String> mBypassRules;
    private List<ProxyRule> mProxyRules;
    private boolean mReverseBypass;

    public static final class Builder {
        private List<String> mBypassRules;
        private List<ProxyRule> mProxyRules;
        private boolean mReverseBypass;

        public Builder addDirect() {
            return addDirect("*");
        }

        public ProxyConfig build() {
            return new ProxyConfig(proxyRules(), bypassRules(), reverseBypass());
        }

        public Builder bypassSimpleHostnames() {
            return addBypassRule(ProxyConfig.BYPASS_RULE_SIMPLE_NAMES);
        }

        public Builder removeImplicitRules() {
            return addBypassRule(ProxyConfig.BYPASS_RULE_REMOVE_IMPLICIT);
        }

        public Builder() {
            this.mReverseBypass = false;
            this.mProxyRules = new ArrayList();
            this.mBypassRules = new ArrayList();
        }

        private List<String> bypassRules() {
            return this.mBypassRules;
        }

        private List<ProxyRule> proxyRules() {
            return this.mProxyRules;
        }

        private boolean reverseBypass() {
            return this.mReverseBypass;
        }

        public Builder(ProxyConfig r100) {
            this.mReverseBypass = false;
            this.mProxyRules = r100.getProxyRules();
            this.mBypassRules = r100.getBypassRules();
            this.mReverseBypass = r100.isReverseBypassEnabled();
        }

        public Builder addBypassRule(String r100) {
            this.mBypassRules.add(r100);
            return this;
        }

        public Builder addDirect(String r100) {
            this.mProxyRules.add(new ProxyRule(r100, ProxyConfig.DIRECT));
            return this;
        }

        public Builder addProxyRule(String r100) {
            this.mProxyRules.add(new ProxyRule(r100));
            return this;
        }

        public Builder setReverseBypassEnabled(boolean r100) {
            this.mReverseBypass = r100;
            return this;
        }

        public Builder addProxyRule(String r100, String r101) {
            this.mProxyRules.add(new ProxyRule(r101, r100));
            return this;
        }
    }

    public static final class ProxyRule {
        private String mSchemeFilter;
        private String mUrl;

        public String getSchemeFilter() {
            return this.mSchemeFilter;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public ProxyRule(String r100) {
            this("*", r100);
        }

        public ProxyRule(String r100, String r101) {
            this.mSchemeFilter = r100;
            this.mUrl = r101;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProxyScheme {
    }

    public List<String> getBypassRules() {
        return Collections.unmodifiableList(this.mBypassRules);
    }

    public List<ProxyRule> getProxyRules() {
        return Collections.unmodifiableList(this.mProxyRules);
    }

    public boolean isReverseBypassEnabled() {
        return this.mReverseBypass;
    }

    public ProxyConfig(List<ProxyRule> r100, List<String> r101, boolean r102) {
        this.mProxyRules = r100;
        this.mBypassRules = r101;
        this.mReverseBypass = r102;
    }
}
