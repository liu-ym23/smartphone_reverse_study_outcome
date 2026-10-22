package com.bytedance.applet.debugger;

import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.JsonObject;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J2\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/applet/debugger/AppletDebuggerAgentTraceApi;", "", "saveDebugToken", "Lcom/larus/network/bean/BizResponse;", "", "request", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAgentTrace", "Lcom/bytedance/applet/debugger/AppletDebuggerAgentTraceData;", "logId", "", "token", "xTtToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppletDebuggerAgentTraceApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f191692a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f191693a = null;

        static {
            f191693a = new a();
        }

        public a() {
        }
    }

    static {
        f191692a = a.f191693a;
    }

    @GET("/app_developer/debugger/agent_trace")
    Object getAgentTrace(@Query("log_id") String r100, @Query("token") String r101, @Header(LoginVerifyService.X_TT_TOKEN) String r102, Continuation<? super BizResponse<e>> r103);

    @POST("/alice/debug/save_token")
    Object saveDebugToken(@Body JsonObject r100, Continuation<? super BizResponse<Unit>> r101);
}
