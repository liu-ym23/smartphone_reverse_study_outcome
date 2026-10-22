package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/SettType;", "", "UnDeFined", "Accept", "RefuseByTimeOut", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SettType extends Enum<SettType> {
    public static final SettType Accept = null;
    public static final SettType RefuseByTimeOut = null;
    public static final SettType UnDeFined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettType[] f147080a = null;

    static {
        SettType r100 = new SettType("UnDeFined", 0);
        UnDeFined = r100;
        SettType r101 = new SettType("Accept", 1);
        Accept = r101;
        SettType r102 = new SettType("RefuseByTimeOut", 2);
        RefuseByTimeOut = r102;
        f147080a = new SettType[]{r100, r101, r102};
    }

    public static SettType valueOf(String r100) {
        return (SettType) r27.a.a(SettType.class, r100);
    }

    public static SettType[] values() {
        return (SettType[]) f147080a.clone();
    }

    public SettType(String r100, int r101) {
        super(r100, r101);
    }
}
