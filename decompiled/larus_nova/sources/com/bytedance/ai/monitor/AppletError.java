package com.bytedance.ai.monitor;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.ai.utils.g;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletError extends AppletMonitorableEvent {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AppletErrorCode f37123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ErrorLevel f37124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f37125m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f37126n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/monitor/AppletError$ErrorLevel;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Warn", "Error", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorLevel extends Enum<ErrorLevel> {
        public static final ErrorLevel Error = null;
        public static final ErrorLevel Warn = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrorLevel[] f37127a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f37128b = null;
        private final int type;

        public static EnumEntries<ErrorLevel> getEntries() {
            return f37128b;
        }

        static {
            ErrorLevel r100 = new ErrorLevel("Warn", 0, 1);
            Warn = r100;
            ErrorLevel r101 = new ErrorLevel("Error", 1, 2);
            Error = r101;
            ErrorLevel[] r102 = {r100, r101};
            f37127a = r102;
            f37128b = EnumEntriesKt.enumEntries(r102);
        }

        public static ErrorLevel[] values() {
            return (ErrorLevel[]) f37127a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static ErrorLevel valueOf(String r100) {
            return (ErrorLevel) r27.a.a(ErrorLevel.class, r100);
        }

        public ErrorLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.putOpt("packageId", this.f37145f);     // Catch: Throwable -> L5
        r100.putOpt("appId", this.f37146g);     // Catch: Throwable -> L5
        r100.putOpt("code", Integer.valueOf(this.f37123k.getType()));     // Catch: Throwable -> L5
        r100.putOpt(DyVerifyEventConstants.EventParam.ERROR_NAME, this.f37123k.name());     // Catch: Throwable -> L5
        r100.putOpt("message", this.f37125m);     // Catch: Throwable -> L5
        r100.putOpt("level", this.f37124l);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r100.putOpt("ai_sdk_version", "1.15.0-rc.7"));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L10;
        g.f37637a.w("AppletError", "Exception when get category: " + r103);
    L10:
        return r100;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final boolean b() {
        if (super.b() == true) goto L5;
        return false;
    L5:
        if (this.f37123k == AppletErrorCode.SUCCESS) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final JSONObject n() {
        if (b() == false) goto L5;
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L8
        AppletMonitorableEvent.l("recovery_suggestion", null, r100);     // Catch: JSONException -> L8
        AppletMonitorableEvent.l("error_stack", this.f37126n, r100);     // Catch: JSONException -> L8
        r100.putOpt(PlayerResolution.SDKKEY.ORIGIN, this.f37142c.name());     // Catch: JSONException -> L8
        r100.put(VideoSurfaceTexture.KEY_TIME, this.f37144e);     // Catch: JSONException -> L8
        AppletMonitorableEvent.c(this.f37147h, r100);     // Catch: JSONException -> L8
        AppletMonitorableEvent.j(r100);     // Catch: JSONException -> L8
        return r100;
    L8:
        e = move-exception;
        g.f37637a.d("AppletError", "failed to convert error to json: " + e.getMessage());
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    public AppletError(AppletErrorCode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        ErrorLevel r102 = ErrorLevel.Error;
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "level");
        super("applet_error");
        this.f37123k = r100;
        this.f37125m = r101;
        this.f37124l = r102;
        Intrinsics.checkNotNullParameter("error_event", "<set-?>");
        this.f37141b = "error_event";
    }
}
