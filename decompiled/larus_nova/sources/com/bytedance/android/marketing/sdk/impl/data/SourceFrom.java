package com.bytedance.android.marketing.sdk.impl.data;

import com.bytedance.locallife.cube.PrefetchTiming;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/data/SourceFrom;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "JSB", "CLIENT", "ROUTER", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SourceFrom extends Enum<SourceFrom> {
    public static final SourceFrom CLIENT = null;
    public static final SourceFrom JSB = null;
    public static final SourceFrom ROUTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SourceFrom[] f162782a = null;
    private final String value;

    static {
        SourceFrom r100 = new SourceFrom("JSB", 0, PrefetchTiming.JSB);
        JSB = r100;
        SourceFrom r101 = new SourceFrom("CLIENT", 1, "client");
        CLIENT = r101;
        SourceFrom r102 = new SourceFrom("ROUTER", 2, PrefetchTiming.ROUTER);
        ROUTER = r102;
        f162782a = new SourceFrom[]{r100, r101, r102};
    }

    public static SourceFrom valueOf(String r100) {
        return (SourceFrom) r27.a.a(SourceFrom.class, r100);
    }

    public static SourceFrom[] values() {
        return (SourceFrom[]) f162782a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public SourceFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
