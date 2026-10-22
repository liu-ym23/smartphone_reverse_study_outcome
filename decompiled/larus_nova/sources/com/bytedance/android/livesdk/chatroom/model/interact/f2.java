package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/f2;", "Lvh7/c;", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "getLinkMicTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/multiscene/a;", "getLinkMicTeamFightInfo$annotations", "()V", "linkMicTeamFightInfo", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f2 extends vh7.c<f2> {
    public static final a Companion = null;
    public static final int UpdateTeamfightTeamType_Player = 1;
    public static final int UpdateTeamfightTeamType_Position = 2;
    public static final int UpdateTeamfightTeamType_UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106951a = null;

        public a() {
        }

        static {
            f106951a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f106951a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "teamfight_info")
    com.bytedance.android.live.liveinteract.multiscene.a getLinkMicTeamFightInfo();
}
