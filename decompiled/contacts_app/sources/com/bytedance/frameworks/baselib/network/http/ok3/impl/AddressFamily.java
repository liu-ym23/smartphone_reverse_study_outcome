package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes2.dex */
final enum AddressFamily extends Enum<AddressFamily> {
    private static final /* synthetic */ AddressFamily[] $VALUES = null;
    public static final AddressFamily ADDRESS_FAMILY_IPV4 = null;
    public static final AddressFamily ADDRESS_FAMILY_IPV6 = null;
    public static final AddressFamily ADDRESS_FAMILY_UNSPECIFIED = null;

    static {
        AddressFamily r0 = new AddressFamily("ADDRESS_FAMILY_UNSPECIFIED", 0);
        ADDRESS_FAMILY_UNSPECIFIED = r0;
        AddressFamily r1 = new AddressFamily("ADDRESS_FAMILY_IPV4", 1);
        ADDRESS_FAMILY_IPV4 = r1;
        AddressFamily r3 = new AddressFamily("ADDRESS_FAMILY_IPV6", 2);
        ADDRESS_FAMILY_IPV6 = r3;
        $VALUES = new AddressFamily[]{r0, r1, r3};
    }

    private AddressFamily(String r1, int r2) {
        super(r1, r2);
    }

    public static AddressFamily valueOf(String r1) {
        return (AddressFamily) Enum.valueOf(AddressFamily.class, r1);
    }

    public static AddressFamily[] values() {
        return (AddressFamily[]) $VALUES.clone();
    }
}
