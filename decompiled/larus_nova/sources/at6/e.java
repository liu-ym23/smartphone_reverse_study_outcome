package at6;

import com.bytedance.ies.commerce.common_utils.event.api.ISubscriber;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f16263a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f16264b = null;

    public static final class a implements ISubscriber {
        public a() {
        }

        @Override // com.bytedance.ies.commerce.common_utils.event.api.ISubscriber
        public final void onEvent(String r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "data");
            FLogger.f375446a.i("LifeAppletBridgeRelay", "relay event=" + r101 + " sessionId=" + r100);
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
            Object r104 = Result.m9449constructorimpl(JsonParser.parseString(r102.toString()).getAsJsonObject());     // Catch: Throwable -> L5
        L8:
            if (Result.m9455isFailureimpl(r104) == false) goto L10;
            r104 = null;
        L10:
            JsonObject r105 = (JsonObject) r104;
            if (r105 != null) goto L13;
            r105 = new JsonObject();
        L13:
            l3.a r106 = new l3.a(r101, r105, 4);
            r106.f507199d = "com.flow.shorthand";
            l3.d.c(r106);
            return;
        L5:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        }
    }

    static {
        f16263a = new AtomicBoolean(false);
        f16264b = new a();
    }
}
