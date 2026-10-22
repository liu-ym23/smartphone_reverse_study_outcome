package com.bytedance.android.livesdkapi;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/Scope;", "", "(Ljava/lang/String;I)V", "EXTERNAL", "INTERNAL", "BOTH", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Scope extends Enum<Scope> {
    private static final /* synthetic */ Scope[] $VALUES = null;
    public static final Scope BOTH = null;
    public static final Scope EXTERNAL = null;
    public static final Scope INTERNAL = null;

    static {
        Scope r100 = new Scope("EXTERNAL", 0);
        EXTERNAL = r100;
        Scope r101 = new Scope("INTERNAL", 1);
        INTERNAL = r101;
        Scope r102 = new Scope("BOTH", 2);
        BOTH = r102;
        $VALUES = new Scope[]{r100, r101, r102};
    }

    public static Scope valueOf(String r100) {
        return (Scope) a.a(Scope.class, r100);
    }

    public static Scope[] values() {
        return (Scope[]) $VALUES.clone();
    }

    private Scope(String r100, int r101) {
        super(r100, r101);
    }
}
