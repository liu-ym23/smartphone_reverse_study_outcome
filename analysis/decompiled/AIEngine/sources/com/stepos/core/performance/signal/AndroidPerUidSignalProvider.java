package com.stepos.core.performance.signal;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AndroidPerUidSignalProvider implements PerUidSignalProvider {
    public static final Companion Companion = new Companion(null);
    private static final PerUidSignalProvider EMPTY = new PerUidSignalProvider() { // from class: com.stepos.core.performance.signal.AndroidPerUidSignalProvider$Companion$EMPTY$1
        @Override // com.stepos.core.performance.signal.PerUidSignalProvider
        public boolean isFocused(int i10) {
            return false;
        }

        @Override // com.stepos.core.performance.signal.PerUidSignalProvider
        public AdjSegment readAdjSegment(int i10) {
            return AdjSegment.LT400;
        }
    };
    private static final String TAG = "PerUidSignalProvider";
    private final ActivityManager am;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AdjSegment.values().length];
                try {
                    iArr[AdjSegment.LT100.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AdjSegment.LT400.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AdjSegment.GE400.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String importanceName(int i10) {
            return i10 != 100 ? i10 != 125 ? i10 != 200 ? i10 != 230 ? i10 != 300 ? i10 != 400 ? i10 != 1000 ? "其他" : "已退出" : "后台缓存" : "服务" : "可感知" : "可见" : "前台服务" : "前台";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String segmentDesc(AdjSegment adjSegment) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[adjSegment.ordinal()];
            if (i10 == 1) {
                return "前台";
            }
            if (i10 == 2) {
                return "可感知/服务";
            }
            if (i10 == 3) {
                return "后台，会触发降档";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final PerUidSignalProvider getEMPTY() {
            return AndroidPerUidSignalProvider.EMPTY;
        }

        private Companion() {
        }
    }

    public AndroidPerUidSignalProvider(Context context) {
        g.f(context, "context");
        Object systemService = context.getSystemService("activity");
        this.am = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
    }

    @Override // com.stepos.core.performance.signal.PerUidSignalProvider
    public boolean isFocused(int i10) {
        Object objA;
        try {
            ActivityManager activityManager = this.am;
            objA = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        List<ActivityManager.RunningAppProcessInfo> list = (List) (objA instanceof Result.Failure ? null : objA);
        if (list == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            if (runningAppProcessInfo.uid == i10 && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    @Override // com.stepos.core.performance.signal.PerUidSignalProvider
    public AdjSegment readAdjSegment(int i10) {
        Object objA;
        int i11;
        try {
            ActivityManager activityManager = this.am;
            objA = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        List<ActivityManager.RunningAppProcessInfo> list = (List) (objA instanceof Result.Failure ? null : objA);
        if (list == null) {
            Log.i(TAG, "读取 uid=" + i10 + " 段位：拿不到运行进程列表，按中性档 LT400 处理");
            return AdjSegment.LT400;
        }
        String str = "";
        int i12 = Integer.MAX_VALUE;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            if (runningAppProcessInfo.uid == i10 && (i11 = runningAppProcessInfo.importance) < i12) {
                str = runningAppProcessInfo.processName;
                i12 = i11;
            }
        }
        if (i12 == Integer.MAX_VALUE) {
            Log.i(TAG, "读取 uid=" + i10 + " 段位：该应用当前不在运行进程列表，按中性档 LT400 处理");
            return AdjSegment.LT400;
        }
        AdjSegment adjSegment = i12 <= 125 ? AdjSegment.LT100 : i12 < 400 ? AdjSegment.LT400 : AdjSegment.GE400;
        Companion companion = Companion;
        String strImportanceName = companion.importanceName(i12);
        String strSegmentDesc = companion.segmentDesc(adjSegment);
        StringBuilder sbE = h0.e.e("读取 uid=", i10, " 段位：最靠前台进程=", str, " importance=");
        h0.e.h(i12, " (", strImportanceName, ") → 判定为 ", sbE);
        sbE.append(adjSegment);
        sbE.append(" (");
        sbE.append(strSegmentDesc);
        sbE.append(")");
        Log.i(TAG, sbE.toString());
        return adjSegment;
    }
}
