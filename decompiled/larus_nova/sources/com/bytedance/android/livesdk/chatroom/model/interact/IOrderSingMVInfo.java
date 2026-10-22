package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/IOrderSingMVInfo;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVBaseInfo;", "getMvBaseInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVBaseInfo;", "setMvBaseInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVBaseInfo;)V", "getMvBaseInfo$annotations", "()V", "mvBaseInfo", "", "isHighQuality", "()Z", "isHighQuality$annotations", "isLocked", "isLocked$annotations", "", "getMvType", "()I", "getMvType$annotations", "mvType", "getPlayStatus", "getPlayStatus$annotations", "playStatus", "", "getUserId", "()Ljava/lang/String;", "userId", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IOrderSingMVInfo extends vh7.c<IOrderSingMVInfo> {
    public static final a Companion = null;
    public static final int CustomizeMV = 2;
    public static final int NoMVPlay = 0;
    public static final int OfficialMV = 1;
    public static final int PlayLater = 2;
    public static final int Playing = 1;
    public static final int UnknownMVType = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106928a = null;

        public a() {
        }

        static {
            f106928a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f106928a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "mv_base_info")
    IMVBaseInfo getMvBaseInfo();

    @FieldName(name = "mv_type")
    int getMvType();

    @FieldName(name = "play_status")
    int getPlayStatus();

    String getUserId();

    @FieldName(name = "is_high_quality")
    boolean isHighQuality();

    @FieldName(name = "is_locked")
    boolean isLocked();

    @FieldName(name = "mv_base_info#setter")
    void setMvBaseInfo(IMVBaseInfo r100);
}
