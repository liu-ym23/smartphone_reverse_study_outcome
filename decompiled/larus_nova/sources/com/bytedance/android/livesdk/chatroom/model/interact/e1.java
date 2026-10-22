package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dR\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/e1;", "Lvh7/c;", "", "getUserId", "()J", "setUserId", "(J)V", "getUserId$annotations", "()V", "userId", "", "getNeedPush", "()Z", "setNeedPush", "(Z)V", "getNeedPush$annotations", "needPush", "getAppId", "setAppId", "getAppId$annotations", "appId", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getAction$annotations", "action", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e1 extends vh7.c<e1> {
    public static final a Companion = null;
    public static final String REPLY_ACTION_APPLY = "apply";
    public static final String REPLY_ACTION_DEFAULT = "";
    public static final String REPLY_ACTION_JOIN_CHORUS = "join_chorus";
    public static final String REPLY_ACTION_NONE = "none";
    public static final String REPLY_ACTION_PREPARE_REPLY = "prepare_reply";
    public static final String REPLY_ACTION_REPLY = "reply";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106950a = null;

        public a() {
        }

        static {
            f106950a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f106950a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "action")
    String getAction();

    @FieldName(name = "app_id")
    long getAppId();

    @FieldName(name = "need_push")
    boolean getNeedPush();

    @FieldName(name = "user_id")
    long getUserId();

    @FieldName(name = "action#setter")
    void setAction(String r100);

    @FieldName(name = "app_id#setter")
    void setAppId(long r100);

    @FieldName(name = "need_push#setter")
    void setNeedPush(boolean r100);

    @FieldName(name = "user_id#setter")
    void setUserId(long r100);
}
