package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.open.api.CounterContributor")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/CounterContributorFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/scoreboard/dto/b;", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "avatar$delegate", "getAvatar", "avatar", "points$delegate", "getPoints", "points", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CounterContributorFlexImpl extends FlexModelBase<b> implements b, vh7.h {

    @SerializedName("avatar")
    protected String _$$avatar;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("points")
    protected String _$$points;

    public CounterContributorFlexImpl() {
        super(b.class);
        this._$$name = "";
        this._$$avatar = "";
        this._$$points = "";
    }

    public CounterContributorFlexImpl(am3.g r100) {
        super(b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$name = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$avatar = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$points = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$name != null) goto L19;
        this._$$name = "";
    L19:
        if (this._$$avatar != null) goto L22;
        this._$$avatar = "";
    L22:
        if (this._$$points != null) goto L37;
        this._$$points = "";
        return;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.b
    public final String getAvatar() {
        return this._$$avatar;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.b
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.b
    public final String getPoints() {
        return this._$$points;
    }
}
