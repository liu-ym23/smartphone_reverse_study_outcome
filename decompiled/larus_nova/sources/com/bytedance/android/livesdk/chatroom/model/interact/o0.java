package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/o0;", "Lvh7/c;", "", "getMsgType", "()I", "getMsgType$annotations", "()V", "msgType", "Lcom/bytedance/android/livesdk/chatroom/model/interact/p0;", "getOpenContent", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/p0;", "getOpenContent$annotations", "openContent", "Lcom/bytedance/android/livesdk/chatroom/model/interact/m0;", "getCloseContent", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/m0;", "getCloseContent$annotations", "closeContent", "Lcom/bytedance/android/livesdk/chatroom/model/interact/r0;", "getUpdateContent", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/r0;", "getUpdateContent$annotations", "updateContent", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o0 extends vh7.c<o0> {
    public static final a Companion = null;
    public static final int LinkmicStarWishMessageType_Close = 2;
    public static final int LinkmicStarWishMessageType_GiftItemChanged = 4;
    public static final int LinkmicStarWishMessageType_NONE = 0;
    public static final int LinkmicStarWishMessageType_Open = 1;
    public static final int LinkmicStarWishMessageType_Update = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106953a = null;

        public a() {
        }

        static {
            f106953a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f106953a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "close_content")
    m0 getCloseContent();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    int getMsgType();

    @FieldName(name = "open_content")
    p0 getOpenContent();

    @FieldName(name = "update_content")
    r0 getUpdateContent();
}
