package com.bytedance.android.livesdk.room.state;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/room/state/WidgetLevel;", "", "FS", DiagnoseResult.DIAGNOSE_LEVEL_P0, DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, AccountType.ALL, "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WidgetLevel extends Enum<WidgetLevel> {
    public static final WidgetLevel ALL = null;
    public static final WidgetLevel FS = null;
    public static final WidgetLevel P0 = null;
    public static final WidgetLevel P1 = null;
    public static final WidgetLevel P2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WidgetLevel[] f157822a = null;

    static {
        WidgetLevel r100 = new WidgetLevel("FS", 0);
        FS = r100;
        WidgetLevel r101 = new WidgetLevel(DiagnoseResult.DIAGNOSE_LEVEL_P0, 1);
        P0 = r101;
        WidgetLevel r102 = new WidgetLevel(DiagnoseResult.DIAGNOSE_LEVEL_P1, 2);
        P1 = r102;
        WidgetLevel r103 = new WidgetLevel(DiagnoseResult.DIAGNOSE_LEVEL_P2, 3);
        P2 = r103;
        WidgetLevel r104 = new WidgetLevel(AccountType.ALL, 4);
        ALL = r104;
        f157822a = new WidgetLevel[]{r100, r101, r102, r103, r104};
    }

    public static WidgetLevel valueOf(String r100) {
        return (WidgetLevel) a.a(WidgetLevel.class, r100);
    }

    public static WidgetLevel[] values() {
        return (WidgetLevel[]) f157822a.clone();
    }

    public WidgetLevel(String r100, int r101) {
        super(r100, r101);
    }
}
