package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002'(R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R&\u0010\u0012\u001a\u00060\u000bj\u0002`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0016\u001a\u00060\u000bj\u0002`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R&\u0010\u001a\u001a\u00060\u000bj\u0002`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\t\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w1;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/t;", "", "getMatchStatus", "()I", "setMatchStatus", "(I)V", "getMatchStatus$annotations", "()V", "matchStatus", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/TimeInt64;", "getExpectTime", "()J", "setExpectTime", "(J)V", "getExpectTime$annotations", "expectTime", "getDefaultWaitLimit", "setDefaultWaitLimit", "getDefaultWaitLimit$annotations", "defaultWaitLimit", "getInviteLimitSec", "setInviteLimitSec", "getInviteLimitSec$annotations", "inviteLimitSec", "", "Lcom/bytedance/android/livesdk/link/model/w1$c;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPreviewUsers", "()Ljava/util/List;", "getPreviewUsers$annotations", "previewUsers", "getMatchType", "setMatchType", "getMatchType$annotations", "matchType", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w1 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.t>, com.bytedance.android.livesdk.link.model.bridge.t {
    public static final a Companion = null;
    public static final int MATCH_STATUS_CANCEL_ACTIVELY = 1;
    public static final int MATCH_STATUS_CANCEL_PASSIVELY = 2;
    public static final int MATCH_STATUS_FAILED = 3;
    public static final int MATCH_STATUS_START = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147103a = null;

        public a() {
        }

        static {
            f147103a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w1$c;", "Lvh7/c;", "", "getNickName", "()Ljava/lang/String;", "getNickName$annotations", "()V", "nickName", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatar", "()Lpy/k;", "getAvatar$annotations", "avatar", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "avatar")
        py.k getAvatar();

        @FieldName(name = InstantPlayContext.NICKNAME)
        String getNickName();
    }

    static {
        Companion = a.f147103a;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.t, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.t, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "default_wait_limit")
    long getDefaultWaitLimit();

    @FieldName(name = "expect_time")
    long getExpectTime();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invite_limit_sec")
    long getInviteLimitSec();

    @FieldName(name = "match_status")
    int getMatchStatus();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    long getMatchType();

    @FieldName(name = "preview_user_list")
    List<c> getPreviewUsers();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @FieldName(name = "default_wait_limit#setter")
    void setDefaultWaitLimit(long r100);

    @FieldName(name = "expect_time#setter")
    void setExpectTime(long r100);

    @FieldName(name = "invite_limit_sec#setter")
    void setInviteLimitSec(long r100);

    @FieldName(name = "match_status#setter")
    void setMatchStatus(int r100);

    @FieldName(name = "match_type#setter")
    void setMatchType(long r100);
}
