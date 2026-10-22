package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/pkTray/TrayActionType;", "", "DEFAULT", "Enter", "Exit", UserChangedCallback.CHANGE_TYPE_UPDATE, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TrayActionType extends Enum<TrayActionType> {
    public static final TrayActionType DEFAULT = null;
    public static final TrayActionType Enter = null;
    public static final TrayActionType Exit = null;
    public static final TrayActionType Update = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TrayActionType[] f130032a = null;

    static {
        TrayActionType r100 = new TrayActionType("DEFAULT", 0);
        DEFAULT = r100;
        TrayActionType r101 = new TrayActionType("Enter", 1);
        Enter = r101;
        TrayActionType r102 = new TrayActionType("Exit", 2);
        Exit = r102;
        TrayActionType r103 = new TrayActionType(UserChangedCallback.CHANGE_TYPE_UPDATE, 3);
        Update = r103;
        f130032a = new TrayActionType[]{r100, r101, r102, r103};
    }

    public static TrayActionType valueOf(String r100) {
        return (TrayActionType) r27.a.a(TrayActionType.class, r100);
    }

    public static TrayActionType[] values() {
        return (TrayActionType[]) f130032a.clone();
    }

    public TrayActionType(String r100, int r101) {
        super(r100, r101);
    }
}
