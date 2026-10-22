package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.dress.PlayerDecoration")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IPlayerDecorationFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/q;", "", "leadingDecoration$delegate", "Ljava/lang/Object;", "getLeadingDecoration", "()Ljava/lang/String;", "leadingDecoration", "laggingDecoration$delegate", "getLaggingDecoration", "laggingDecoration", "leadingLastDecoration$delegate", "getLeadingLastDecoration", "leadingLastDecoration", "laggingLastDecoration$delegate", "getLaggingLastDecoration", "laggingLastDecoration", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPlayerDecorationFlexImpl extends FlexModelBase<q> implements q, vh7.h {

    @SerializedName("lagging_decoration_id")
    protected String _$$laggingDecoration;

    @SerializedName("lagging_last_decoration_id")
    protected String _$$laggingLastDecoration;

    @SerializedName("leading_decoration_id")
    protected String _$$leadingDecoration;

    @SerializedName("leading_last_decoration_id")
    protected String _$$leadingLastDecoration;

    public IPlayerDecorationFlexImpl() {
        super(q.class);
    }

    public IPlayerDecorationFlexImpl(am3.g r100) {
        super(q.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$leadingDecoration = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$laggingDecoration = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$leadingLastDecoration = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$laggingLastDecoration = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.q
    public final String getLaggingDecoration() {
        return this._$$laggingDecoration;
    }

    @Override // com.bytedance.android.live.profit.dress.config.q
    public final String getLaggingLastDecoration() {
        return this._$$laggingLastDecoration;
    }

    @Override // com.bytedance.android.live.profit.dress.config.q
    public final String getLeadingDecoration() {
        return this._$$leadingDecoration;
    }

    @Override // com.bytedance.android.live.profit.dress.config.q
    public final String getLeadingLastDecoration() {
        return this._$$leadingLastDecoration;
    }
}
