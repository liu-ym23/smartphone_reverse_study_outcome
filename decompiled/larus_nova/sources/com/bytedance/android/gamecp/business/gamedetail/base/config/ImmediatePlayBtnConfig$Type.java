package com.bytedance.android.gamecp.business.gamedetail.base.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/gamecp/business/gamedetail/base/config/ImmediatePlayBtnConfig$Type", "", "Lcom/bytedance/android/gamecp/business/gamedetail/base/config/ImmediatePlayBtnConfig$Type;", "CloudGame", "MiniGame", "MiniPlay", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ImmediatePlayBtnConfig$Type extends Enum<ImmediatePlayBtnConfig$Type> {
    public static final ImmediatePlayBtnConfig$Type CloudGame = null;
    public static final ImmediatePlayBtnConfig$Type MiniGame = null;
    public static final ImmediatePlayBtnConfig$Type MiniPlay = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImmediatePlayBtnConfig$Type[] f53478a = null;

    static {
        ImmediatePlayBtnConfig$Type r100 = new ImmediatePlayBtnConfig$Type("CloudGame", 0);
        CloudGame = r100;
        ImmediatePlayBtnConfig$Type r101 = new ImmediatePlayBtnConfig$Type("MiniGame", 1);
        MiniGame = r101;
        ImmediatePlayBtnConfig$Type r102 = new ImmediatePlayBtnConfig$Type("MiniPlay", 2);
        MiniPlay = r102;
        f53478a = new ImmediatePlayBtnConfig$Type[]{r100, r101, r102};
    }

    public static ImmediatePlayBtnConfig$Type valueOf(String r100) {
        return (ImmediatePlayBtnConfig$Type) a.a(ImmediatePlayBtnConfig$Type.class, r100);
    }

    public static ImmediatePlayBtnConfig$Type[] values() {
        return (ImmediatePlayBtnConfig$Type[]) f53478a.clone();
    }

    public ImmediatePlayBtnConfig$Type(String r100, int r101) {
        super(r100, r101);
    }
}
