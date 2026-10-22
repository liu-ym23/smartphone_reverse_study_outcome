package com.bytedance.android.live.base.model.user;

/* JADX INFO: loaded from: classes45.dex */
public final enum ProfileConstant$ProfileType extends Enum<ProfileConstant$ProfileType> {
    public static final ProfileConstant$ProfileType HONOUR = null;
    public static final ProfileConstant$ProfileType SHOP = null;
    public static final ProfileConstant$ProfileType WINDOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProfileConstant$ProfileType[] f58937a = null;
    private int type;

    static {
        ProfileConstant$ProfileType r100 = new ProfileConstant$ProfileType("HONOUR", 0, 0);
        HONOUR = r100;
        ProfileConstant$ProfileType r101 = new ProfileConstant$ProfileType("SHOP", 1, 1);
        SHOP = r101;
        ProfileConstant$ProfileType r102 = new ProfileConstant$ProfileType("WINDOW", 2, 2);
        WINDOW = r102;
        f58937a = new ProfileConstant$ProfileType[]{r100, r101, r102};
    }

    public static ProfileConstant$ProfileType[] values() {
        return (ProfileConstant$ProfileType[]) f58937a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static ProfileConstant$ProfileType valueOf(String r100) {
        return (ProfileConstant$ProfileType) r27.a.a(ProfileConstant$ProfileType.class, r100);
    }

    public ProfileConstant$ProfileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
