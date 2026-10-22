package com.bytedance.android.live.multilink.layoutconfig.resource.producer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/resource/producer/ProducerResStep;", "", "LocalCache", "GeckoOffline", "LocalAssets", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ProducerResStep extends Enum<ProducerResStep> {
    public static final ProducerResStep GeckoOffline = null;
    public static final ProducerResStep LocalAssets = null;
    public static final ProducerResStep LocalCache = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProducerResStep[] f83577a = null;

    static {
        ProducerResStep r100 = new ProducerResStep("LocalCache", 0);
        LocalCache = r100;
        ProducerResStep r101 = new ProducerResStep("GeckoOffline", 1);
        GeckoOffline = r101;
        ProducerResStep r102 = new ProducerResStep("LocalAssets", 2);
        LocalAssets = r102;
        f83577a = new ProducerResStep[]{r100, r101, r102};
    }

    public static ProducerResStep valueOf(String r100) {
        return (ProducerResStep) a.a(ProducerResStep.class, r100);
    }

    public static ProducerResStep[] values() {
        return (ProducerResStep[]) f83577a.clone();
    }

    public ProducerResStep(String r100, int r101) {
        super(r100, r101);
    }
}
