package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001\rR\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/r7;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getUpdateType", "()I", "updateType", "Lcom/bytedance/android/livesdk/gift/model/a2;", "getGiftSortStrategy", "()Lcom/bytedance/android/livesdk/gift/model/a2;", "giftSortStrategy", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r7 extends vh7.c<r7>, yh6.c {
    public static final a Companion = null;
    public static final int UPDATE_GIFT_AND_ASSET_LIST = 2;
    public static final int UPDATE_GIFT_CACHE_AND_UI = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153694a = null;

        public a() {
        }

        static {
            f153694a = new a();
        }
    }

    static {
        Companion = a.f153694a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    com.bytedance.android.livesdk.gift.model.a2 getGiftSortStrategy();

    int getUpdateType();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
