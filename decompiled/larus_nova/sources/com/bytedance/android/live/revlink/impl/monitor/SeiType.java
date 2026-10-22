package com.bytedance.android.live.revlink.impl.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/monitor/SeiType;", "", "FirstSei", "NormalSei", "BeforeCreate", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeiType extends Enum<SeiType> {
    public static final SeiType BeforeCreate = null;
    public static final SeiType FirstSei = null;
    public static final SeiType NormalSei = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeiType[] f93058a = null;

    static {
        SeiType r100 = new SeiType("FirstSei", 0);
        FirstSei = r100;
        SeiType r101 = new SeiType("NormalSei", 1);
        NormalSei = r101;
        SeiType r102 = new SeiType("BeforeCreate", 2);
        BeforeCreate = r102;
        f93058a = new SeiType[]{r100, r101, r102};
    }

    public static SeiType valueOf(String r100) {
        return (SeiType) r27.a.a(SeiType.class, r100);
    }

    public static SeiType[] values() {
        return (SeiType[]) f93058a.clone();
    }

    public SeiType(String r100, int r101) {
        super(r100, r101);
    }
}
