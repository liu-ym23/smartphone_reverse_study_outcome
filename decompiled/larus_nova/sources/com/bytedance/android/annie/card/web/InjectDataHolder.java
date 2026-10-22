package com.bytedance.android.annie.card.web;

import android.webkit.JavascriptInterface;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.ec.slice.SliceInitService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/card/web/InjectDataHolder;", "", "", "getGlobalProps", "getInitialProps", "getInjectInitData", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class InjectDataHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f39147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f39148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f39149c;

    @JavascriptInterface
    public final String getGlobalProps() {
        return this.f39147a;
    }

    @JavascriptInterface
    public final String getInitialProps() {
        return this.f39148b;
    }

    @JavascriptInterface
    public final String getInjectInitData() {
        return this.f39149c;
    }

    public InjectDataHolder(String r100, String r101) {
        Intrinsics.checkNotNullParameter(SliceInitService.DEFAULT_SWITCH, "globalProps");
        Intrinsics.checkNotNullParameter(r100, BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);
        Intrinsics.checkNotNullParameter(r101, "injectInitData");
        this.f39147a = SliceInitService.DEFAULT_SWITCH;
        this.f39148b = r100;
        this.f39149c = r101;
    }
}
