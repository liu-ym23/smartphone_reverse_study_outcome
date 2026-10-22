package com.bytedance.android.live.ktv.common.model.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/SetBgmFunctionType;", "", "KSONG", "MULTI_KTV", "PREVIEW_SONGS", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SetBgmFunctionType extends Enum<SetBgmFunctionType> {
    public static final SetBgmFunctionType KSONG = null;
    public static final SetBgmFunctionType MULTI_KTV = null;
    public static final SetBgmFunctionType PREVIEW_SONGS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SetBgmFunctionType[] f69991a = null;

    static {
        SetBgmFunctionType r100 = new SetBgmFunctionType("KSONG", 0);
        KSONG = r100;
        SetBgmFunctionType r101 = new SetBgmFunctionType("MULTI_KTV", 1);
        MULTI_KTV = r101;
        SetBgmFunctionType r102 = new SetBgmFunctionType("PREVIEW_SONGS", 2);
        PREVIEW_SONGS = r102;
        f69991a = new SetBgmFunctionType[]{r100, r101, r102};
    }

    public static SetBgmFunctionType valueOf(String r100) {
        return (SetBgmFunctionType) r27.a.a(SetBgmFunctionType.class, r100);
    }

    public static SetBgmFunctionType[] values() {
        return (SetBgmFunctionType[]) f69991a.clone();
    }

    public SetBgmFunctionType(String r100, int r101) {
        super(r100, r101);
    }
}
