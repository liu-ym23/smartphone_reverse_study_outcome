package com.stepos.deepbinder.core.entity.ext;

import java.util.ArrayList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
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
        g.f(items, "items");
        this.blacklistedItems = items;
        return this;
    }

    public final BlackAndWhiteConfig setWhitelistedItems(ArrayList<String> items) {
        g.f(items, "items");
        this.whitelistedItems = items;
        return this;
    }
}
