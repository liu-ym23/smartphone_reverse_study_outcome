package com.bytedance.android.monitorV2.hybridSetting.entity;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class HybridSettingInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f163089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f163090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f163091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f163092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f163093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f163094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f163095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f163096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f163097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f163098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f163099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IThirdConfig f163100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<String> f163101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f163102n;

    public static abstract class IThirdConfig {
        public IThirdConfig() {
        }

        public boolean isThirdPartyUrl(String r100) {
            return false;
        }
    }

    public HybridSettingInitConfig() {
    }

    public final List<String> a() {
        if (CollectionUtils.isEmpty(this.f163101m) == false) goto L9;
        if (TextUtils.equals(this.f163090b, "https://mon-va.byteoversea.com") == false) goto L7;
        this.f163101m = Collections.singletonList(new String(Base64.decode("aHR0cHM6Ly9tb24uaXNuc3Nkay5jb20vbW9uaXRvci9hcHBtb25pdG9yL3YyL3NldHRpbmdz", 0)));
        goto L9
    L7:
        this.f163101m = Collections.singletonList(new String(Base64.decode("aHR0cHM6Ly9tb24uc25zc2RrLmNvbS9tb25pdG9yL2FwcG1vbml0b3IvdjIvc2V0dGluZ3M=", 0)));
    L9:
        return this.f163101m;
    }

    public final List<String> b() {
        if (CollectionUtils.isEmpty(this.f163102n) == false) goto L9;
        if (TextUtils.equals(this.f163090b, "https://mon-va.byteoversea.com") == false) goto L7;
        this.f163102n = Collections.singletonList(new String(Base64.decode("aHR0cHM6Ly9tb24uaXNuc3Nkay5jb20vbW9uaXRvci9jb2xsZWN0Lw==", 0)));
        goto L9
    L7:
        this.f163102n = Collections.singletonList(new String(Base64.decode("aHR0cHM6Ly9tb24uc25zc2RrLmNvbS9tb25pdG9yL2NvbGxlY3Qv", 0)));
    L9:
        return this.f163102n;
    }
}
