package com.bytedance.android.live.profit.dress.api;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/dress/api/LoadTriggeredBy;", "", "", "value", "I", "getValue", "()I", "EnterRoom", ServiceType.IM, "Getting", "Other", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LoadTriggeredBy extends Enum<LoadTriggeredBy> {
    public static final LoadTriggeredBy EnterRoom = null;
    public static final LoadTriggeredBy Getting = null;
    public static final LoadTriggeredBy Message = null;
    public static final LoadTriggeredBy Other = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadTriggeredBy[] f87079a = null;
    private final int value;

    static {
        LoadTriggeredBy r100 = new LoadTriggeredBy("EnterRoom", 0, 0);
        EnterRoom = r100;
        LoadTriggeredBy r101 = new LoadTriggeredBy(ServiceType.IM, 1, 1);
        Message = r101;
        LoadTriggeredBy r102 = new LoadTriggeredBy("Getting", 2, 2);
        Getting = r102;
        LoadTriggeredBy r103 = new LoadTriggeredBy("Other", 3, -1);
        Other = r103;
        f87079a = new LoadTriggeredBy[]{r100, r101, r102, r103};
    }

    public static LoadTriggeredBy valueOf(String r100) {
        return (LoadTriggeredBy) a.a(LoadTriggeredBy.class, r100);
    }

    public static LoadTriggeredBy[] values() {
        return (LoadTriggeredBy[]) f87079a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LoadTriggeredBy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
