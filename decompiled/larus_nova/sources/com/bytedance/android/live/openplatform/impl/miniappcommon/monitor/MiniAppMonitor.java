package com.bytedance.android.live.openplatform.impl.miniappcommon.monitor;

import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniAppMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f85046a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/monitor/MiniAppMonitor$ExceptionType;", "", "Mount", "Unmount", LogFilterName.ROOM, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ExceptionType extends Enum<ExceptionType> {
        public static final ExceptionType Mount = null;
        public static final ExceptionType Room = null;
        public static final ExceptionType Unmount = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExceptionType[] f85047a = null;

        static {
            ExceptionType r100 = new ExceptionType("Mount", 0);
            Mount = r100;
            ExceptionType r101 = new ExceptionType("Unmount", 1);
            Unmount = r101;
            ExceptionType r102 = new ExceptionType(LogFilterName.ROOM, 2);
            Room = r102;
            f85047a = new ExceptionType[]{r100, r101, r102};
        }

        public static ExceptionType valueOf(String r100) {
            return (ExceptionType) a.a(ExceptionType.class, r100);
        }

        public static ExceptionType[] values() {
            return (ExceptionType[]) f85047a.clone();
        }

        public ExceptionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public static void a(ExceptionType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "exceptionType");
        Intrinsics.checkNotNullParameter(r101, "exceptionMsg");
        g r102 = u.l();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("exception_type", r100.name());
        r103.put("exception_msg", r101);
        Unit r104 = Unit.INSTANCE;
        r102.sendLog("livesdk_miniapp_exception_monitor", r103, new Object[]{Room.class});
    }
}
