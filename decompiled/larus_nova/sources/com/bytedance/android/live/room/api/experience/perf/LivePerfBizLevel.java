package com.bytedance.android.live.room.api.experience.perf;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/room/api/experience/perf/LivePerfBizLevel;", "", "", "level", "I", "getLevel", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", "Default", DiagnoseResult.DIAGNOSE_LEVEL_P0, DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePerfBizLevel extends Enum<LivePerfBizLevel> {
    public static final a Companion = null;
    public static final LivePerfBizLevel Default = null;
    public static final LivePerfBizLevel P0 = null;
    public static final LivePerfBizLevel P1 = null;
    public static final LivePerfBizLevel P2 = null;
    public static final LivePerfBizLevel Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePerfBizLevel[] f98905a = null;
    private final int level;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LivePerfBizLevel a(int r100) {
            LivePerfBizLevel[] r101 = LivePerfBizLevel.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            LivePerfBizLevel r104 = r101[r103];
            if (r104.getLevel() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return LivePerfBizLevel.Unknown;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    static {
        LivePerfBizLevel r100 = new LivePerfBizLevel("Unknown", 0, -1996);
        Unknown = r100;
        LivePerfBizLevel r101 = new LivePerfBizLevel("Default", 1, -1);
        Default = r101;
        LivePerfBizLevel r102 = new LivePerfBizLevel(DiagnoseResult.DIAGNOSE_LEVEL_P0, 2, 0);
        P0 = r102;
        LivePerfBizLevel r103 = new LivePerfBizLevel(DiagnoseResult.DIAGNOSE_LEVEL_P1, 3, 1);
        P1 = r103;
        LivePerfBizLevel r104 = new LivePerfBizLevel(DiagnoseResult.DIAGNOSE_LEVEL_P2, 4, 2);
        P2 = r104;
        f98905a = new LivePerfBizLevel[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    @JvmStatic
    public static final LivePerfBizLevel mapPerfBizLevel(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static LivePerfBizLevel valueOf(String r100) {
        return (LivePerfBizLevel) r27.a.a(LivePerfBizLevel.class, r100);
    }

    public static LivePerfBizLevel[] values() {
        return (LivePerfBizLevel[]) f98905a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public LivePerfBizLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
