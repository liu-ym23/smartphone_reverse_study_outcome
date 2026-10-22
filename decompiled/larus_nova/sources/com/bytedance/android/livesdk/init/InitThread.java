package com.bytedance.android.livesdk.init;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/init/InitThread;", "", AccountType.MAIN, "BACK_GROUND", "WITH_CALLER", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InitThread extends Enum<InitThread> {
    public static final InitThread BACK_GROUND = null;
    public static final InitThread MAIN = null;
    public static final InitThread WITH_CALLER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InitThread[] f132648a = null;

    static {
        InitThread r100 = new InitThread(AccountType.MAIN, 0);
        MAIN = r100;
        InitThread r101 = new InitThread("BACK_GROUND", 1);
        BACK_GROUND = r101;
        InitThread r102 = new InitThread("WITH_CALLER", 2);
        WITH_CALLER = r102;
        f132648a = new InitThread[]{r100, r101, r102};
    }

    public static InitThread valueOf(String r100) {
        return (InitThread) r27.a.a(InitThread.class, r100);
    }

    public static InitThread[] values() {
        return (InitThread[]) f132648a.clone();
    }

    public InitThread(String r100, int r101) {
        super(r100, r101);
    }
}
