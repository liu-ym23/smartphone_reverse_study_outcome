package com.byted.mgl.merge.service.api.liveplayer;

import android.graphics.Point;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.byted.mgl.merge.service.api.liveplayer.listener.IGameTTLivePlayerListener;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0005\u001c\u001d\u001e\u001f J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J.\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\tH&¨\u0006!"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer;", "", "getPlayState", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$PlayerState;", "getVideoSize", "Landroid/graphics/Point;", "isPlaying", "", "muted", "", "pause", "play", "release", BasicTestActionHandler.TEST_ACTION_RESET, "setDataSource", "url", "", "headers", "", "extraConfig", "Lorg/json/JSONObject;", "setListener", "listener", "Lcom/byted/mgl/merge/service/api/liveplayer/listener/IGameTTLivePlayerListener;", "setSurface", "surface", "Landroid/view/Surface;", "stop", "DisplayMode", "LiveError", "ObjectFit", ExifInterface.TAG_ORIENTATION, "PlayerState", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface IGameTTLivePlayer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$DisplayMode;", "", "objectFit", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$ObjectFit;", "displayOrientation", "Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$Orientation;", "(Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$ObjectFit;Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$Orientation;)V", "getDisplayOrientation", "()Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$Orientation;", "getObjectFit", "()Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$ObjectFit;", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
    public static final class DisplayMode {
        private final Orientation displayOrientation;
        private final ObjectFit objectFit;

        public final Orientation getDisplayOrientation() {
            return this.displayOrientation;
        }

        public final ObjectFit getObjectFit() {
            return this.objectFit;
        }

        public DisplayMode(ObjectFit r100, Orientation r101) {
            this.objectFit = r100;
            this.displayOrientation = r101;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$LiveError;", "", "code", "", "message", "", "info", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getInfo", "()Ljava/lang/String;", "getMessage", "toString", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
    public static final class LiveError {
        private final int code;
        private final String info;
        private final String message;

        public String toString() {
            return "LivePlayer_Error{code: " + this.code + ", msg: " + this.message + ", info: " + this.info + "}.";
        }

        public final int getCode() {
            return this.code;
        }

        public final String getInfo() {
            return this.info;
        }

        public final String getMessage() {
            return this.message;
        }

        public LiveError(int r100, String r101, String r102) {
            this.code = r100;
            this.message = r101;
            this.info = r102;
        }

        public /* synthetic */ LiveError(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$ObjectFit;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONTAIN", "FILLCROP", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
    public static final enum ObjectFit extends Enum<ObjectFit> {
        private static final /* synthetic */ ObjectFit[] $VALUES = null;
        public static final ObjectFit CONTAIN = null;
        public static final ObjectFit FILLCROP = null;
        private final String value;

        static {
            ObjectFit r100 = new ObjectFit("CONTAIN", 0, LynxVideoManagerLite.CONTAIN);
            CONTAIN = r100;
            ObjectFit r101 = new ObjectFit("FILLCROP", 1, "fillCrop");
            FILLCROP = r101;
            $VALUES = new ObjectFit[]{r100, r101};
        }

        public static ObjectFit valueOf(String r100) {
            return (ObjectFit) a.a(ObjectFit.class, r100);
        }

        public static ObjectFit[] values() {
            return (ObjectFit[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        private ObjectFit(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$Orientation;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VERTICAL", "HORIZONTAL", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
    public static final enum Orientation extends Enum<Orientation> {
        private static final /* synthetic */ Orientation[] $VALUES = null;
        public static final Orientation HORIZONTAL = null;
        public static final Orientation VERTICAL = null;
        private final String value;

        static {
            Orientation r100 = new Orientation("VERTICAL", 0, "vertical");
            VERTICAL = r100;
            Orientation r101 = new Orientation("HORIZONTAL", 1, "horizontal");
            HORIZONTAL = r101;
            $VALUES = new Orientation[]{r100, r101};
        }

        public static Orientation valueOf(String r100) {
            return (Orientation) a.a(Orientation.class, r100);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        private Orientation(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/byted/mgl/merge/service/api/liveplayer/IGameTTLivePlayer$PlayerState;", "", "(Ljava/lang/String;I)V", ErrorCode.INIT, "FETCHING", "PREPARED", "PLAYING", "STALLING", "STOPPED", "COMPLETED", "ERROR", "STREAM_DRY_UP", "REQUEST_PLAY_URL_ERROR", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
    public static final enum PlayerState extends Enum<PlayerState> {
        private static final /* synthetic */ PlayerState[] $VALUES = null;
        public static final PlayerState COMPLETED = null;
        public static final PlayerState ERROR = null;
        public static final PlayerState FETCHING = null;
        public static final PlayerState INIT = null;
        public static final PlayerState PLAYING = null;
        public static final PlayerState PREPARED = null;
        public static final PlayerState REQUEST_PLAY_URL_ERROR = null;
        public static final PlayerState STALLING = null;
        public static final PlayerState STOPPED = null;
        public static final PlayerState STREAM_DRY_UP = null;

        static {
            PlayerState r100 = new PlayerState(ErrorCode.INIT, 0);
            INIT = r100;
            PlayerState r101 = new PlayerState("FETCHING", 1);
            FETCHING = r101;
            PlayerState r102 = new PlayerState("PREPARED", 2);
            PREPARED = r102;
            PlayerState r103 = new PlayerState("PLAYING", 3);
            PLAYING = r103;
            PlayerState r104 = new PlayerState("STALLING", 4);
            STALLING = r104;
            PlayerState r105 = new PlayerState("STOPPED", 5);
            STOPPED = r105;
            PlayerState r106 = new PlayerState("COMPLETED", 6);
            COMPLETED = r106;
            PlayerState r107 = new PlayerState("ERROR", 7);
            ERROR = r107;
            PlayerState r108 = new PlayerState("STREAM_DRY_UP", 8);
            STREAM_DRY_UP = r108;
            PlayerState r109 = new PlayerState("REQUEST_PLAY_URL_ERROR", 9);
            REQUEST_PLAY_URL_ERROR = r109;
            $VALUES = new PlayerState[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        }

        public static PlayerState valueOf(String r100) {
            return (PlayerState) a.a(PlayerState.class, r100);
        }

        public static PlayerState[] values() {
            return (PlayerState[]) $VALUES.clone();
        }

        private PlayerState(String r100, int r101) {
            super(r100, r101);
        }
    }

    PlayerState getPlayState();

    Point getVideoSize();

    boolean isPlaying();

    void muted(boolean r100);

    void pause();

    void play();

    void release();

    void reset();

    void setDataSource(String r100, Map<String, String> r101, JSONObject r102);

    void setListener(IGameTTLivePlayerListener r100);

    void setSurface(Surface r100);

    void stop();
}
