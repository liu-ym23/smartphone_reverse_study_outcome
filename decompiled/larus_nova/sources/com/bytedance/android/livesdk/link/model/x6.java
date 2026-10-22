package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0011R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R:\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/x6;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/n1;", "", "getMatchType", "()J", "getMatchType$annotations", "()V", "matchType", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getRoleLinkMicMap", "()Ljava/util/Map;", "getRoleLinkMicMap$annotations", "roleLinkMicMap", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x6 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.n1>, com.bytedance.android.livesdk.link.model.bridge.n1 {
    public static final a Companion = null;
    public static final int ROLE_INVITEE = 3;
    public static final int ROLE_INVITEE_FOLLOWER = 4;
    public static final int ROLE_INVITER = 1;
    public static final int ROLE_INVITER_FOLLOWER = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147105a = null;

        public a() {
        }

        static {
            f147105a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f147105a;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.n1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.n1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invite_role")
    /* synthetic */ int getInviteRole();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    long getMatchType();

    @FieldName(name = "role_linkmic_map")
    Map<Long, String> getRoleLinkMicMap();
}
