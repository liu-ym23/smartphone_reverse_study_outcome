package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.livesdk.livecommerce.model.ECV2DelayParam;
import com.bytedance.android.livesdk.livecommerce.model.ECV2OpenPriceTriggerInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;
import si2.a0;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends sg2.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f152681g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f152682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f152683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f152684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECV2DelayParam f152685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECV2PopMsgProductInfo f152686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECV2OpenPriceTriggerInfo f152687f;

    public static final class a {
        public static b a(a0 r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            b r101 = new b();
            r101.f152682a = r100.msgType;
            r101.f152683b = r100.bubbleType;
            r101.f152684c = r100.promotionId;
            r101.f152685d = r100.delayParam;
            r101.f152686e = r100.productInfo;
            r101.f152687f = r100.openPriceTriggerInfo;
            r101.setCommon(r100.getCommon());
            return r101;
        }
    }

    static {
    }

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public b() {
    }
}
