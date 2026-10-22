package com.bytedance.android.shopping.feed.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/feed/enums/InflowMainCardLocationType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "HALF", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InflowMainCardLocationType extends Enum<InflowMainCardLocationType> {
    public static final InflowMainCardLocationType HALF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InflowMainCardLocationType[] f174441a = null;
    private final String type;

    static {
        InflowMainCardLocationType r100 = new InflowMainCardLocationType();
        HALF = r100;
        f174441a = new InflowMainCardLocationType[]{r100};
    }

    public static InflowMainCardLocationType valueOf(String r100) {
        return (InflowMainCardLocationType) a.a(InflowMainCardLocationType.class, r100);
    }

    public static InflowMainCardLocationType[] values() {
        return (InflowMainCardLocationType[]) f174441a.clone();
    }

    public InflowMainCardLocationType() {
        super("HALF", 0);
        this.type = "";
    }

    public final String getType() {
        return this.type;
    }
}
