package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, a> f43095f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SkuApiMonitor f43096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f43097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f43098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f43099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f43100e;

    /* JADX INFO: renamed from: com.bytedance.android.ec.common.impl.sku.monitor.a$a, reason: collision with other inner class name */
    public static final class C0784a {
        public static a a(String r100) {
            return (a) ((LinkedHashMap) a.f43095f).get(r100);
        }
    }

    static {
        f43095f = new LinkedHashMap();
    }

    public a(SkuParams r100) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        this.f43096a = new SkuApiMonitor();
        this.f43097b = new b(r100);
        this.f43098c = new d(r100);
        this.f43099d = new e(r100);
        this.f43100e = new c(r100);
    }
}
