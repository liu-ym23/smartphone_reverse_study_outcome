package com.bytedance.android.livesdk.gamecp;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.bytedance.android.livesdkapi.gamecp.IGameCpService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J,\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001bH\u0016J.\u0010\u001c\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010 \u001a\u00020\u0015*\u0004\u0018\u00010!H\u0002¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/GameCpServiceImpl;", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService;", "()V", "action", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Lcom/google/gson/JsonObject;", "logParams", "cancelDownload", "createGamePromoteDetailDialog", "Landroidx/appcompat/app/AppCompatDialogFragment;", "gameDetailData", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$GameDetailData;", "dismissListener", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IGameDetailDialogDismissListener;", "genDownloadToken", "", "getDownloadList", "status", "", "callback", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IDownloadListCallback;", "logMonitorLinkEvent", "scene", "eventName", "", "subscribeDownloadGame", "listener", "Lcom/bytedance/android/livesdkapi/gamecp/IGameCpService$IGameDownloadListener;", "unSubscribeDownloadGame", "optString", "Lcom/google/gson/JsonElement;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public class GameCpServiceImpl implements IGameCpService {

    public static final class a implements dw.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f125386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsonObject f125387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JsonObject f125388c;

        @Override // dw.e
        public final void onGranted() {
            boolean r100 = kv.a.f506226a;
            xr.f r101 = kv.a.b();
            if (r101 == null) goto L8;
            xr.b r102 = r101.p1();
            if (r102 == null) goto L9;
            r102.X0(this.f125386a, this.f125387b, this.f125388c);
            return;
        L9:
            return;
        }

        public a(Context r100, JsonObject r101, JsonObject r102) {
            this.f125386a = r100;
            this.f125387b = r101;
            this.f125388c = r102;
        }
    }

    public static final class b implements com.bytedance.android.gamecp.base.core.service.depend.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGameCpService.IGameDetailDialogDismissListener f125389a;

        @Override // com.bytedance.android.gamecp.base.core.service.depend.l
        public final void onDismiss() {
            IGameCpService.IGameDetailDialogDismissListener r100 = this.f125389a;
            if (r100 == null) goto L6;
            r100.onDismiss();
            return;
        }

        public b(IGameCpService.IGameDetailDialogDismissListener r100) {
            this.f125389a = r100;
        }
    }

    public static final class c implements com.bytedance.android.gamecp.base.core.service.depend.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGameCpService.IDownloadListCallback f125390a;

        public c(IGameCpService.IDownloadListCallback r100) {
            this.f125390a = r100;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.c
        public final void onResult(JSONObject r100) {
            IGameCpService.IDownloadListCallback r101 = this.f125390a;
            if (r101 == null) goto L6;
            r101.get(r100);
            return;
        }
    }

    public static final class d implements com.bytedance.android.gamecp.base.core.service.depend.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGameCpService.IGameDownloadListener f125391a;

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onInstallFailed(int r100) {
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onJumpInstall(int r100) {
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void passThrough(int r100) {
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onCancel() {
            IGameCpService.IGameDownloadListener r100 = this.f125391a;
            if (r100 == null) goto L6;
            r100.onCancel();
            return;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onReady() {
            IGameCpService.IGameDownloadListener r100 = this.f125391a;
            if (r100 == null) goto L6;
            r100.onReady();
            return;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onUpdate() {
            IGameCpService.IGameDownloadListener r100 = this.f125391a;
            if (r100 == null) goto L6;
            r100.onUpdate();
            return;
        }

        public d(IGameCpService.IGameDownloadListener r100) {
            this.f125391a = r100;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onDownloaded(String r100) {
            IGameCpService.IGameDownloadListener r101 = this.f125391a;
            if (r101 == null) goto L6;
            r101.onDownloaded(r100);
            return;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onError(int r100) {
            IGameCpService.IGameDownloadListener r101 = this.f125391a;
            if (r101 == null) goto L6;
            r101.onError(r100);
            return;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onInstalled(com.bytedance.android.gamecp.base.core.service.depend.v r100) {
            Intrinsics.checkNotNullParameter(r100, "installedFinishData");
            IGameCpService.IGameDownloadListener r101 = this.f125391a;
            if (r101 == null) goto L6;
            r101.onInstalled();
            return;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onPause(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
            Intrinsics.checkNotNullParameter(r100, "progressData");
            IGameCpService.IGameDownloadListener r101 = this.f125391a;
            if (r101 == null) goto L6;
            r101.onPause(r100.f51437a);
            return;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onProgress(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
            Intrinsics.checkNotNullParameter(r100, "progressData");
            IGameCpService.ProgressData r101 = new IGameCpService.ProgressData(r100.f51437a, r100.f51438b, r100.f51439c, r100.f51440d);
            IGameCpService.IGameDownloadListener r102 = this.f125391a;
            if (r102 == null) goto L6;
            r102.onProgress(r101);
            return;
        }
    }

    public GameCpServiceImpl() {
    }

    @Override // com.bytedance.android.livesdkapi.gamecp.IGameCpService
    public int genDownloadToken() {
        boolean r100 = kv.a.f506226a;
        xr.f r101 = kv.a.b();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.genDownloadToken();
    }

    private final String optString(JsonElement r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        String r103 = r100.getAsString();     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == true) goto L15;
        r101 = r104;
    L15:
        String r105 = (String) r101;
        if (r105 != null) goto L21;
        return "";
    L21:
        return r105;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.android.livesdkapi.gamecp.IGameCpService
    public void action(Context r100, JsonObject r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        bw.e r103 = com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService();
        String r104 = optString(r101.get("gameId"));
        Integer r105 = StringsKt.toIntOrNull(optString(r101.get("downloadStatus")));
        if (r105 == null) goto L5;
        r105.intValue();
    L5:
        r103.f0(r104, new a(r100, r101, r102));
    }

    @Override // com.bytedance.android.livesdkapi.gamecp.IGameCpService
    public void cancelDownload(Context r100, JsonObject r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r103 = kv.a.f506226a;
        xr.f r104 = kv.a.b();
        if (r104 == null) goto L6;
        r104.cancelDownloadGame(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamecp.IGameCpService
    public AppCompatDialogFragment createGamePromoteDetailDialog(IGameCpService.GameDetailData r100, JsonObject r101, IGameCpService.IGameDetailDialogDismissListener r102) {
        Intrinsics.checkNotNullParameter(r100, "gameDetailData");
        com.bytedance.android.gamecp.base.core.service.depend.a r103 = new com.bytedance.android.gamecp.base.core.service.depend.a();
        r103.f51406a = r100.getGameId();
        r103.f51407b = r100.getAttributionId();
        r103.f51408c = "3";
        boolean r104 = kv.a.f506226a;
        xr.f r105 = kv.a.b();
        if (r105 != null) goto L7;
        return null;
    L7:
        return r105.a2(r103, r101, new b(r102));
    }

    @Override // com.bytedance.android.livesdkapi.gamecp.IGameCpService
    public void logMonitorLinkEvent(int r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "params");
        boolean r103 = kv.a.f506226a;
        xr.f r104 = kv.a.b();
        if (r104 == null) goto L6;
        r104.logMonitorLinkEvent(r100, r101, r102, true);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamecp.IGameCpService
    public void unSubscribeDownloadGame(Context r100, JsonObject r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r103 = kv.a.f506226a;
        xr.f r104 = kv.a.b();
        if (r104 == null) goto L6;
        r104.N0(r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamecp.IGameCpService
    public void getDownloadList(Context r100, String r101, JsonObject r102, IGameCpService.IDownloadListCallback r103) {
        Intrinsics.checkNotNullParameter(r101, "status");
        boolean r104 = kv.a.f506226a;
        xr.f r105 = kv.a.b();
        if (r105 == null) goto L6;
        r105.r2(r101, new c(r103));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamecp.IGameCpService
    public void subscribeDownloadGame(Context r100, JsonObject r101, JsonObject r102, IGameCpService.IGameDownloadListener r103) {
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r104 = kv.a.f506226a;
        xr.f r105 = kv.a.b();
        if (r105 == null) goto L6;
        r105.C1(r101, new d(r103));
        return;
    }
}
