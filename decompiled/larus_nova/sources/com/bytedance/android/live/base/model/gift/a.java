package com.bytedance.android.live.base.model.gift;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eR\u001a\u0010\u0007\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/base/model/gift/a;", "Lvh7/c;", "", "getHasAudienceAuthSwitch", "()Z", "getHasAudienceAuthSwitch$annotations", "()V", "hasAudienceAuthSwitch", "", "getAuthSwitch", "()J", "getAuthSwitch$annotations", "authSwitch", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {
    public static final long AUDIENCE_SEND_GIFT_SWITCH_CLOSE = 2;
    public static final long AUDIENCE_SEND_GIFT_SWITCH_OPEN = 1;
    public static final C0936a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.base.model.gift.a$a, reason: collision with other inner class name */
    public static final class C0936a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0936a f58833a = null;

        public C0936a() {
        }

        static {
            f58833a = new C0936a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = C0936a.f58833a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "auth_switch")
    long getAuthSwitch();

    @FieldName(name = "has_audience_auth_switch")
    boolean getHasAudienceAuthSwitch();
}
