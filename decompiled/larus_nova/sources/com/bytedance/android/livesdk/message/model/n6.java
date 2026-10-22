package com.bytedance.android.livesdk.message.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001dR\u001c\u0010\t\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u00020\u00138&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\u00020\u00138&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/n6;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getStatus", "()I", "setStatus", "(I)V", "status", "getReason", "setReason", "reason", "Lpy/k;", "getAnimation", "()Lpy/k;", "setAnimation", "(Lpy/k;)V", GXTemplateKey.GAIAX_ANIMATION, "", "getId", "()J", "setId", "(J)V", "id", "getBattleId", "setBattleId", "battleId", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n6 extends vh7.c<n6>, yh6.c {
    public static final a Companion = null;
    public static final int REASON_BOX = 3;
    public static final int REASON_GIFT = 2;
    public static final int REASON_MVP = 1;
    public static final int REASON_UNKNOWN = 0;
    public static final int STATUS_FAILURE = 2;
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153671a = null;

        public a() {
        }

        static {
            f153671a = new a();
        }
    }

    static {
        Companion = a.f153671a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    py.k getAnimation();

    long getBattleId();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    long getId();

    int getReason();

    int getStatus();

    void setAnimation(py.k r100);

    void setBattleId(long r100);

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    void setId(long r100);

    void setReason(int r100);

    void setStatus(int r100);
}
