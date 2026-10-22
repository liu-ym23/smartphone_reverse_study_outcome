package com.bytedance.android.livesdkapi.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/WtnPlayEvent;", "", "state", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "(ILjava/lang/Object;)V", "getObj", "()Ljava/lang/Object;", "getState", "()I", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WtnPlayEvent {
    public static final Companion Companion = null;
    private static final int STATE_CLOSED = 0;
    private static final int STATE_FALLBACKED = 0;
    private static final int STATE_IDLE = 0;
    private static final int STATE_INIT = 0;
    private static final int STATE_PLAYING = 0;
    private final Object obj;
    private final int state;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/WtnPlayEvent$Companion;", "", "()V", "STATE_CLOSED", "", "getSTATE_CLOSED", "()I", "STATE_FALLBACKED", "getSTATE_FALLBACKED", "STATE_IDLE", "getSTATE_IDLE", "STATE_INIT", "getSTATE_INIT", "STATE_PLAYING", "getSTATE_PLAYING", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final int getSTATE_CLOSED() {
            return WtnPlayEvent.access$getSTATE_CLOSED$cp();
        }

        public final int getSTATE_FALLBACKED() {
            return WtnPlayEvent.access$getSTATE_FALLBACKED$cp();
        }

        public final int getSTATE_IDLE() {
            return WtnPlayEvent.access$getSTATE_IDLE$cp();
        }

        public final int getSTATE_INIT() {
            return WtnPlayEvent.access$getSTATE_INIT$cp();
        }

        public final int getSTATE_PLAYING() {
            return WtnPlayEvent.access$getSTATE_PLAYING$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        STATE_INIT = 1;
        STATE_PLAYING = 2;
        STATE_CLOSED = 3;
        STATE_FALLBACKED = 4;
    }

    public static final /* synthetic */ int access$getSTATE_CLOSED$cp() {
        return STATE_CLOSED;
    }

    public static final /* synthetic */ int access$getSTATE_FALLBACKED$cp() {
        return STATE_FALLBACKED;
    }

    public static final /* synthetic */ int access$getSTATE_IDLE$cp() {
        return STATE_IDLE;
    }

    public static final /* synthetic */ int access$getSTATE_INIT$cp() {
        return STATE_INIT;
    }

    public static final /* synthetic */ int access$getSTATE_PLAYING$cp() {
        return STATE_PLAYING;
    }

    public final Object getObj() {
        return this.obj;
    }

    public final int getState() {
        return this.state;
    }

    public WtnPlayEvent(int r100, Object r101) {
        this.state = r100;
        this.obj = r101;
    }
}
