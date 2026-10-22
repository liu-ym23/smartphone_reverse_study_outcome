package com.bytedance.android.livesdk.arch.state.source;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/arch/state/source/PsType;", "", "Unknown", "EnterRoomDataFilter", "DispatchMsg", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PsType extends Enum<PsType> {
    public static final PsType DispatchMsg = null;
    public static final PsType EnterRoomDataFilter = null;
    public static final PsType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PsType[] f103849a = null;

    static {
        PsType r100 = new PsType("Unknown", 0);
        Unknown = r100;
        PsType r101 = new PsType("EnterRoomDataFilter", 1);
        EnterRoomDataFilter = r101;
        PsType r102 = new PsType("DispatchMsg", 2);
        DispatchMsg = r102;
        f103849a = new PsType[]{r100, r101, r102};
    }

    public static PsType valueOf(String r100) {
        return (PsType) a.a(PsType.class, r100);
    }

    public static PsType[] values() {
        return (PsType[]) f103849a.clone();
    }

    public PsType(String r100, int r101) {
        super(r100, r101);
    }
}
