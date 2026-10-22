package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/PriceInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPriceInfo;", "()V", "priceList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IStandardMoney;", "getPriceList", "()Ljava/util/List;", "setPriceList", "(Ljava/util/List;)V", "StandardMoney", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceInfo extends FlexModelBase<IPriceInfo> implements IPriceInfo, h {

    @SerializedName("priceList")
    protected List<? extends IStandardMoney> priceList;

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/PriceInfo$StandardMoney;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IStandardMoney;", "()V", "currencyName", "", "getCurrencyName", "()Ljava/lang/String;", "setCurrencyName", "(Ljava/lang/String;)V", "money", "", "getMoney", "()J", "setMoney", "(J)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StandardMoney extends FlexModelBase<IStandardMoney> implements IStandardMoney, h {

        @SerializedName("currency_name")
        protected String currencyName;

        @SerializedName("money")
        protected long money;

        public StandardMoney() {
            super(IStandardMoney.class);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStandardMoney
        public String getCurrencyName() {
            return this.currencyName;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStandardMoney
        public long getMoney() {
            return this.money;
        }

        public StandardMoney(g r100) {
            super(IStandardMoney.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.money = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.currencyName = am3.h.c(r100);
            goto L3
        L9:
            am3.h.d(r103, r100);
            goto L3
        L12:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStandardMoney
        public void setCurrencyName(String r100) {
            this.currencyName = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStandardMoney
        public void setMoney(long r100) {
            this.money = r100;
        }
    }

    public PriceInfo() {
        super(IPriceInfo.class);
    }

    public PriceInfo(g r100) {
        super(IPriceInfo.class);
        this.priceList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.priceList.add(f.a(r100, IStandardMoney.class));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPriceInfo
    public List<IStandardMoney> getPriceList() {
        return this.priceList;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IPriceInfo
    public void setPriceList(List<? extends IStandardMoney> r100) {
        this.priceList = r100;
    }
}
