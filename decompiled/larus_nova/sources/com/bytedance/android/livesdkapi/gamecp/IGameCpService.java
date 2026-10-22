package com.bytedance.android.livesdkapi.gamecp;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0005\u001f !\"#J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J.\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J,\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001aH&J.\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J$\u0010\u001e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService;", "Lcom/bytedance/android/live/base/IService;", "action", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Lcom/google/gson/JsonObject;", "logParams", "cancelDownload", "createGamePromoteDetailDialog", "Landroidx/appcompat/app/AppCompatDialogFragment;", "gameDetailData", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$GameDetailData;", "dismissListener", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IGameDetailDialogDismissListener;", "genDownloadToken", "", "getDownloadList", "status", "", "callback", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IDownloadListCallback;", "logMonitorLinkEvent", "scene", "eventName", "", "subscribeDownloadGame", "listener", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IGameDownloadListener;", "unSubscribeDownloadGame", "GameDetailData", "IDownloadListCallback", "IGameDetailDialogDismissListener", "IGameDownloadListener", "ProgressData", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCpService extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$GameDetailData;", "", "()V", "attributionId", "", "getAttributionId", "()Ljava/lang/String;", "setAttributionId", "(Ljava/lang/String;)V", "gameId", "getGameId", "setGameId", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GameDetailData {
        public static final Companion Companion = null;
        public static final String PROMOTE_SCENE_OFFICIAL_SAAS = "3";
        private String attributionId;
        private String gameId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$GameDetailData$Companion;", "", "()V", "PROMOTE_SCENE_OFFICIAL_SAAS", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public GameDetailData() {
        }

        public final String getAttributionId() {
            return this.attributionId;
        }

        public final String getGameId() {
            return this.gameId;
        }

        public final void setAttributionId(String r100) {
            this.attributionId = r100;
        }

        public final void setGameId(String r100) {
            this.gameId = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IDownloadListCallback;", "", MonitorConstants.CONNECT_TYPE_GET, "", "downloadList", "Lorg/json/JSONObject;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IDownloadListCallback {
        void get(JSONObject r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IGameDetailDialogDismissListener;", "", "onDismiss", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IGameDetailDialogDismissListener {
        void onDismiss();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IGameDownloadListener;", "", "onCancel", "", "onDownloaded", "filePath", "", LynxVideoManagerLite.EVENT_ON_ERROR, "errorCode", "", "onInstalled", "onPause", "progress", "onProgress", "progressData", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$ProgressData;", "onReady", "onUpdate", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IGameDownloadListener {
        void onCancel();

        void onDownloaded(String r100);

        void onError(int r100);

        void onInstalled();

        void onPause(int r100);

        void onProgress(ProgressData r100);

        void onReady();

        void onUpdate();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$ProgressData;", "", "progress", "", "speed", "", "progressTransformed", "speedTransformed", "(ILjava/lang/String;ILjava/lang/String;)V", "getProgress", "()I", "getProgressTransformed", "getSpeed", "()Ljava/lang/String;", "getSpeedTransformed", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ProgressData {
        private final int progress;
        private final int progressTransformed;
        private final String speed;
        private final String speedTransformed;

        public ProgressData() {
            this(0, null, 0, null, 15, null);
        }

        public static /* synthetic */ ProgressData copy$default(ProgressData r100, int r101, String r102, int r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.progress;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.speed;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.progressTransformed;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.speedTransformed;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.progress;
        }

        public final String component2() {
            return this.speed;
        }

        public final int component3() {
            return this.progressTransformed;
        }

        public final String component4() {
            return this.speedTransformed;
        }

        public final ProgressData copy(int r100, String r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "speed");
            Intrinsics.checkNotNullParameter(r103, "speedTransformed");
            return new ProgressData(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ProgressData) == false) goto L14;
            ProgressData r101 = (ProgressData) r100;
            if (this.progress == r101.progress) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.speed, r101.speed) == true) goto L10;
            return false;
        L10:
            if (this.progressTransformed == r101.progressTransformed) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.speedTransformed, r101.speedTransformed) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            int r100 = this.progress * 31;
            String r101 = this.speed;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (((r100 + r103) * 31) + this.progressTransformed) * 31;
            String r105 = this.speedTransformed;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "ProgressData(progress=" + this.progress + ", speed=" + this.speed + ", progressTransformed=" + this.progressTransformed + ", speedTransformed=" + this.speedTransformed + ")";
        }

        public final int getProgress() {
            return this.progress;
        }

        public final int getProgressTransformed() {
            return this.progressTransformed;
        }

        public final String getSpeed() {
            return this.speed;
        }

        public final String getSpeedTransformed() {
            return this.speedTransformed;
        }

        public ProgressData(int r100, String r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "speed");
            Intrinsics.checkNotNullParameter(r103, "speedTransformed");
            this.progress = r100;
            this.speed = r101;
            this.progressTransformed = r102;
            this.speedTransformed = r103;
        }

        public /* synthetic */ ProgressData(int r100, String r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = "0Kb/s";
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = 0;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = "0Kb/s";
        L14:
            this(r100, r101, r102, r103);
        }
    }

    void action(Context r100, JsonObject r101, JsonObject r102);

    void cancelDownload(Context r100, JsonObject r101, JsonObject r102);

    AppCompatDialogFragment createGamePromoteDetailDialog(GameDetailData r100, JsonObject r101, IGameDetailDialogDismissListener r102);

    int genDownloadToken();

    void getDownloadList(Context r100, String r101, JsonObject r102, IDownloadListCallback r103);

    void logMonitorLinkEvent(int r100, String r101, Map<String, String> r102);

    void subscribeDownloadGame(Context r100, JsonObject r101, JsonObject r102, IGameDownloadListener r103);

    void unSubscribeDownloadGame(Context r100, JsonObject r101, JsonObject r102);
}
