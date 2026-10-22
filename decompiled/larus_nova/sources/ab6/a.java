package ab6;

import com.alipay.sdk.m.p.e;
import com.bytedance.kmp.gamecp.base.message.model.b;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lab6/a;", "", "", e.f25671s, "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "Lcom/bytedance/kmp/gamecp/base/message/model/b;", "teamInfo", "Lcom/bytedance/kmp/gamecp/base/message/model/b;", "getTeamInfo", "()Lcom/bytedance/kmp/gamecp/base/message/model/b;", "c", "(Lcom/bytedance/kmp/gamecp/base/message/model/b;)V", "Lcom/bytedance/kmp/gamecp/base/message/model/a;", "applyListInfo", "Lcom/bytedance/kmp/gamecp/base/message/model/a;", "getApplyListInfo", "()Lcom/bytedance/kmp/gamecp/base/message/model/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/kmp/gamecp/base/message/model/a;)V", "<init>", "()V", "kmp-gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.game.biz.teamPlay.ObserveTeamPlayUpdatedResponse")
public final class a {

    @SerializedName("apply_list_info")
    private com.bytedance.kmp.gamecp.base.message.model.a applyListInfo;

    @SerializedName(e.f25671s)
    private String method;

    @SerializedName("team_info")
    private b teamInfo;

    public a() {
        this.method = "";
    }

    public final void a(com.bytedance.kmp.gamecp.base.message.model.a r100) {
        this.applyListInfo = r100;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.method = r100;
    }

    public final void c(b r100) {
        this.teamInfo = r100;
    }
}
