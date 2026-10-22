package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001$R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\"\u0010\u000f\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b \u0010\u0004¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/base/model/message/x5;", "Lvh7/c;", "", "getChannel", "()Ljava/lang/String;", "getChannel$annotations", "()V", "channel", "getGameId", "getGameId$annotations", "gameId", "getInitParam", "setInitParam", "(Ljava/lang/String;)V", "getInitParam$annotations", "initParam", "", "getInitType", "()J", "getInitType$annotations", "initType", "getVideoSimulcast", "getVideoSimulcast$annotations", "videoSimulcast", "getVideoSimulcastIndex", "getVideoSimulcastIndex$annotations", "videoSimulcastIndex", "Lcom/bytedance/android/live/base/model/message/w5;", "getHamletAvatarInit", "()Lcom/bytedance/android/live/base/model/message/w5;", "getHamletAvatarInit$annotations", "hamletAvatarInit", "getRtcAppId", "getRtcAppId$annotations", "rtcAppId", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x5 extends vh7.c<x5> {
    public static final a Companion = null;
    public static final long XplayInitType_HamletAvatar = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f58900a = null;

        public a() {
        }

        static {
            f58900a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f58900a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "channel")
    String getChannel();

    @FieldName(name = "game_id")
    String getGameId();

    @FieldName(name = "hamlet_avatar_init")
    w5 getHamletAvatarInit();

    @FieldName(name = "init_param")
    String getInitParam();

    @FieldName(name = "init_type")
    long getInitType();

    @FieldName(name = "rtc_app_id")
    String getRtcAppId();

    @FieldName(name = "video_simulcast")
    String getVideoSimulcast();

    @FieldName(name = "video_simulcast_index")
    long getVideoSimulcastIndex();

    @FieldName(name = "init_param#setter")
    void setInitParam(String r100);
}
