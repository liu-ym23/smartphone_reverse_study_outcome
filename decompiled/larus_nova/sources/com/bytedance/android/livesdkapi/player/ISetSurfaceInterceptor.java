package com.bytedance.android.livesdkapi.player;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/ISetSurfaceInterceptor;", "", "intercept", "Lcom/bytedance/android/livesdkapi/player/ISetSurfaceInterceptor$MODE;", "client", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "surface", "MODE", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISetSurfaceInterceptor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/ISetSurfaceInterceptor$MODE;", "", "(Ljava/lang/String;I)V", "ADD", "DEFAULT", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MODE extends Enum<MODE> {
        private static final /* synthetic */ MODE[] $VALUES = null;
        public static final MODE ADD = null;
        public static final MODE DEFAULT = null;

        static {
            MODE r100 = new MODE("ADD", 0);
            ADD = r100;
            MODE r101 = new MODE("DEFAULT", 1);
            DEFAULT = r101;
            $VALUES = new MODE[]{r100, r101};
        }

        public static MODE valueOf(String r100) {
            return (MODE) a.a(MODE.class, r100);
        }

        public static MODE[] values() {
            return (MODE[]) $VALUES.clone();
        }

        private MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    MODE intercept(ILivePlayerClient r100, Object r101);
}
