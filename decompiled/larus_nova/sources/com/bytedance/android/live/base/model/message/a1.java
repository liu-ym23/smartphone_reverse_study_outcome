package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/base/model/message/a1;", "Lvh7/c;", "", "getFinishReason", "()I", "finishReason", "", "getFinishAwemeUserId", "()J", "finishAwemeUserId", "", "getFinishOpenUserId", "()Ljava/lang/String;", "finishOpenUserId", "getFinishUserIdStr", "finishUserIdStr", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a1 extends vh7.c<a1> {
    public static final a Companion = null;
    public static final int FinishGuestBattleReason_COND_LIMIT = 5;
    public static final int FinishGuestBattleReason_CUT_SHORT = 2;
    public static final int FinishGuestBattleReason_FALLBACK = 3;
    public static final int FinishGuestBattleReason_LINKMIC_CLOSE = 6;
    public static final int FinishGuestBattleReason_LIVE_CLOSE = 7;
    public static final int FinishGuestBattleReason_NORMAL = 1;
    public static final int FinishGuestBattleReason_SCENE_CHANGE = 4;
    public static final int FinishGuestBattleReason_UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f58856a = null;

        public a() {
        }

        static {
            f58856a = new a();
        }
    }

    static {
        Companion = a.f58856a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "finish_user_id")
    @Deprecated(message = "这个方法仅作为兼容生成给前端json数据使用，不要在native代码使用此方法\n      使用getFinishUserIdStr进行替代！！")
    long getFinishAwemeUserId();

    @FieldName(name = "finish_open_id")
    @Deprecated(message = "这个方法仅作为兼容生成给前端json数据使用，不要在native代码使用此方法\n      使用getFinishUserIdStr进行替代！！")
    String getFinishOpenUserId();

    @FieldName(name = "reason")
    int getFinishReason();

    @FieldName(name = "finish_user_id_str")
    String getFinishUserIdStr();
}
