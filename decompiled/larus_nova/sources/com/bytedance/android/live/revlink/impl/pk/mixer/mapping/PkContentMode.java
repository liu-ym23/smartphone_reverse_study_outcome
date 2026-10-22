package com.bytedance.android.live.revlink.impl.pk.mixer.mapping;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/mixer/mapping/PkContentMode;", "", "NormalPk", "PkWithGuest", "PkWithGame", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkContentMode extends Enum<PkContentMode> {
    public static final PkContentMode NormalPk = null;
    public static final PkContentMode PkWithGame = null;
    public static final PkContentMode PkWithGuest = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkContentMode[] f96722a = null;

    static {
        PkContentMode r100 = new PkContentMode("NormalPk", 0);
        NormalPk = r100;
        PkContentMode r101 = new PkContentMode("PkWithGuest", 1);
        PkWithGuest = r101;
        PkContentMode r102 = new PkContentMode("PkWithGame", 2);
        PkWithGame = r102;
        f96722a = new PkContentMode[]{r100, r101, r102};
    }

    public static PkContentMode valueOf(String r100) {
        return (PkContentMode) a.a(PkContentMode.class, r100);
    }

    public static PkContentMode[] values() {
        return (PkContentMode[]) f96722a.clone();
    }

    public PkContentMode(String r100, int r101) {
        super(r100, r101);
    }
}
