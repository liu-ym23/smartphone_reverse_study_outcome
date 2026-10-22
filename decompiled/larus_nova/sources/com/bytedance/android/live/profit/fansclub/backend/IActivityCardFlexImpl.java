package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.fansclub.GetFansclubHomepageResult.Data.ActivityCard")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015R)\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IActivityCardFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IActivityCard;", "", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "title", "subTitle$delegate", "getSubTitle", "subTitle", "iconUrl$delegate", "getIconUrl", "iconUrl", "jumpSchema$delegate", "getJumpSchema", "jumpSchema", "", "type$delegate", "getType", "()Ljava/lang/Long;", "type", "", "extra$delegate", "getExtra", "()Ljava/util/Map;", "extra", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IActivityCardFlexImpl extends FlexModelBase<IActivityCard> implements IActivityCard, h {

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("icon_url")
    protected String _$$iconUrl;

    @SerializedName("jump_schema")
    protected String _$$jumpSchema;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected String _$$subTitle;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("type")
    protected Long _$$type;

    public IActivityCardFlexImpl() {
        super(IActivityCard.class);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final String getIconUrl() {
        return this._$$iconUrl;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final String getJumpSchema() {
        return this._$$jumpSchema;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IActivityCard
    public final Long getType() {
        return this._$$type;
    }

    public IActivityCardFlexImpl(g r110) {
        super(IActivityCard.class);
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        g.a r102 = decodeExtensionFields(r101, r110);
        switch(r101) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = am3.h.c(r110);
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = am3.h.c(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<String, String> r107 = this._$$extra;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this._$$type = Long.valueOf(r110.j());
        goto L3
    L26:
        this._$$jumpSchema = am3.h.c(r110);
        goto L3
    L27:
        this._$$iconUrl = am3.h.c(r110);
        goto L3
    L28:
        this._$$subTitle = am3.h.c(r110);
        goto L3
    L29:
        this._$$title = am3.h.c(r110);
        goto L3
    L7:
        am3.h.d(r102, r110);
        goto L3
    L30:
        r110.d(r100);
        setThreadSafe(true);
    }
}
