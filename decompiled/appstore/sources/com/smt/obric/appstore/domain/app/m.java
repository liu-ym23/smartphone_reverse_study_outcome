package com.smt.obric.appstore.domain.app;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m {
    public static final /* synthetic */ Integer a(String r10) {
        return b(r10);
    }

    public static final Integer b(String r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        switch(r10.hashCode()) {
            case -2092690800: goto L20;
            case -1091966885: goto L16;
            case 814389169: goto L13;
            case 1362212369: goto L9;
            default: goto L28;
        };
    L28:
        return null;
    L9:
        if (r10.equals("sys_app_silence") == true) goto L24;
        return null;
    L24:
        return 3;
    L13:
        if (r10.equals("sys_app_default") == true) goto L26;
        return null;
    L26:
        return 1;
    L16:
        if (r10.equals("sys_app_force") == true) goto L27;
        return null;
    L27:
        return 2;
    L20:
        if (r10.equals("sys_app_silence_mobile") == true) goto L23;
        return null;
    L23:
        return 4;
    }
}
