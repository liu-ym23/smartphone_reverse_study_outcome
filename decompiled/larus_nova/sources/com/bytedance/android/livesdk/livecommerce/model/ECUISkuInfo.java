package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
public final class ECUISkuInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f149456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f149457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f149458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f149459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECUICampaign f149460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f149461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f149462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f149463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f149464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f149465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f149466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f149467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f149468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f149469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f149470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f149471p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Map<String, String> f149472q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f149473r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f149474s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f149475t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ECUIActivity f149476u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ECUIAskExplainInfo f149477v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f149478w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECUISkuInfo$PreSellInfo;", "Ljava/io/Serializable;", "preSellType", "", "deliveryDelayDec", "", "preDelayDesc", "(ILjava/lang/String;Ljava/lang/String;)V", "getDeliveryDelayDec", "()Ljava/lang/String;", "getPreDelayDesc", "getPreSellType", "()I", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreSellInfo implements Serializable {
        private final String deliveryDelayDec;
        private final String preDelayDesc;
        private final int preSellType;

        public final String getDeliveryDelayDec() {
            return this.deliveryDelayDec;
        }

        public final String getPreDelayDesc() {
            return this.preDelayDesc;
        }

        public final int getPreSellType() {
            return this.preSellType;
        }

        public PreSellInfo(int r100, String r101, String r102) {
            this.preSellType = r100;
            this.deliveryDelayDec = r101;
            this.preDelayDesc = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f149479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f149480b;

        public a(String[] r100, long r101) {
            this.f149479a = r100;
            this.f149480b = r101;
        }
    }

    public ECUISkuInfo() {
        this.f149459d = "";
        this.f149464i = -1;
        this.f149475t = "";
    }

    public final ECUIActivity getActivity() {
        return this.f149476u;
    }
}
