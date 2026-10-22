package com.stepos.deepbinder.core.entity.ext;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u001e\u0010\u000b\u001a\u00020\u00002\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u001e\u0010\r\u001a\u00020\u00002\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/deepbinder/core/entity/ext/BlackAndWhiteConfig;", "", AppAgent.CONSTRUCT, "()V", "blacklistedItems", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "whitelistedItems", "getBlacklistedItems", "getWhitelistedItems", "setBlacklistedItems", "items", "setWhitelistedItems", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlackAndWhiteConfig {
    private ArrayList<String> blacklistedItems;
    private ArrayList<String> whitelistedItems;

    public final ArrayList<String> getBlacklistedItems() {
        ArrayList<String> arrayList = this.blacklistedItems;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final ArrayList<String> getWhitelistedItems() {
        ArrayList<String> arrayList = this.whitelistedItems;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final BlackAndWhiteConfig setBlacklistedItems(ArrayList<String> items) {
        k.f(items, "items");
        this.blacklistedItems = items;
        return this;
    }

    public final BlackAndWhiteConfig setWhitelistedItems(ArrayList<String> items) {
        k.f(items, "items");
        this.whitelistedItems = items;
        return this;
    }
}
