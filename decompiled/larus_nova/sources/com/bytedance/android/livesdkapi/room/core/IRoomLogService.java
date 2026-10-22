package com.bytedance.android.livesdkapi.room.core;

import com.bytedance.android.live.base.IService;
import java.util.Map;
import kotlin.Metadata;
import tw2.b;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010JF\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&JF\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/core/IRoomLogService;", "Lcom/bytedance/android/live/base/IService;", "Ltw2/b;", "iTrackData", "", "msg", "", "priority", "", "e", "", "", "extras", "", "logCore", "logFull", "Companion", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomLogService extends IService {
    public static final Companion Companion = null;
    public static final int ERROR = 2;
    public static final int INFO = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/core/IRoomLogService$Companion;", "", "()V", "ERROR", "", "INFO", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int ERROR = 2;
        public static final int INFO = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logCore$default(IRoomLogService r100, b r101, String r102, int r103, Throwable r110, Map r111, int r112, Object r113) {
            if (r113 != null) goto L18;
            if ((r112 & 4) == 0) goto L6;
            int r104 = 1;
        L8:
            if ((r112 & 8) == 0) goto L10;
            Throwable r105 = null;
        L12:
            if ((r112 & 16) == 0) goto L14;
            Map r106 = null;
        L15:
            r100.logCore(r101, r102, r104, r105, r106);
            return;
        L14:
            r106 = r111;
            goto L15
        L10:
            r105 = r110;
            goto L12
        L6:
            r104 = r103;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logCore");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logFull$default(IRoomLogService r100, b r101, String r102, int r103, Throwable r110, Map r111, int r112, Object r113) {
            if (r113 != null) goto L18;
            if ((r112 & 4) == 0) goto L6;
            int r104 = 1;
        L8:
            if ((r112 & 8) == 0) goto L10;
            Throwable r105 = null;
        L12:
            if ((r112 & 16) == 0) goto L14;
            Map r106 = null;
        L15:
            r100.logFull(r101, r102, r104, r105, r106);
            return;
        L14:
            r106 = r111;
            goto L15
        L10:
            r105 = r110;
            goto L12
        L6:
            r104 = r103;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logFull");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void logCore(b r100, String r101, int r102, Throwable r103, Map<String, ? extends Object> r104);

    void logFull(b r100, String r101, int r102, Throwable r103, Map<String, ? extends Object> r104);
}
