package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0002\r\u000eR\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/f7;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getAction", "()I", "action", "Lcom/bytedance/android/livesdk/message/model/f7$b;", "getUser", "()Lcom/bytedance/android/livesdk/message/model/f7$b;", "user", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface f7 extends vh7.c<f7>, yh6.c {
    public static final a Companion = null;
    public static final int ECOM_ACTION_JOIN = 2;
    public static final int ECOM_ACTION_QUIT = 3;
    public static final int ECOM_ACTION_UNKNOWN = 0;
    public static final int ECOM_ACTION_UPGRADE = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153638a = null;

        public a() {
        }

        static {
            f153638a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/f7$b;", "Lvh7/c;", "", "getUserId", "()J", "userId", "", "getLevel", "()I", "level", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public interface b extends vh7.c<b> {
        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        int getLevel();

        long getUserId();
    }

    static {
        Companion = a.f153638a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    int getAction();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    b getUser();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
