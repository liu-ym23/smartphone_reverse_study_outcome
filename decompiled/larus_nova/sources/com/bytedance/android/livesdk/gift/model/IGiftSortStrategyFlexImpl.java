package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.GiftSortStrategy")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b7\u00108R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\r0\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0010R+\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010 \u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR+\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR\u001b\u0010)\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010(R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\u0010RC\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003008V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftSortStrategyFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/a2;", "", "<set-?>", "scene$delegate", "Ljava/lang/Object;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "scene", "", "", "giftIds$delegate", "getGiftIds", "()Ljava/util/List;", "setGiftIds", "(Ljava/util/List;)V", "giftIds", "tagIds$delegate", "getTagIds", "tagIds", "startTime$delegate", "getStartTime", "()J", "setStartTime", "(J)V", DyPayConstant.KEY_START_TIME, "endTime$delegate", "getEndTime", "setEndTime", "endTime", "extra$delegate", "getExtra", "setExtra", "extra", "", "strategyType$delegate", "getStrategyType", "()I", ControlRule.KEY_STRATEGY_TYPE, "updateType$delegate", "getUpdateType", "updateType", "effectedGiftIds$delegate", "getEffectedGiftIds", "effectedGiftIds", "", "eventTrack$delegate", "getEventTrack", "()Ljava/util/Map;", "setEventTrack", "(Ljava/util/Map;)V", "eventTrack", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftSortStrategyFlexImpl extends FlexModelBase<a2> implements a2, vh7.h {

    @SerializedName("effected_gift_ids")
    protected List<Long> _$$effectedGiftIds;

    @SerializedName("end_time")
    protected long _$$endTime;

    @SerializedName("event_track")
    protected Map<String, String> _$$eventTrack;

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("gift_ids")
    protected List<Long> _$$giftIds;

    @SerializedName("scene")
    protected String _$$scene;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long _$$startTime;

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE)
    protected int _$$strategyType;

    @SerializedName("tag_ids")
    protected List<Long> _$$tagIds;

    @SerializedName(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE)
    protected int _$$updateType;

    public IGiftSortStrategyFlexImpl() {
        super(a2.class);
        this._$$scene = "";
        this._$$giftIds = $defaultValue_giftIds$();
        this._$$tagIds = $defaultValue_tagIds$();
        this._$$extra = "";
        this._$$effectedGiftIds = $defaultValue_effectedGiftIds$();
        this._$$eventTrack = $defaultValue_eventTrack$();
    }

    public final List<Long> $defaultValue_effectedGiftIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final Map<String, String> $defaultValue_eventTrack$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final List<Long> $defaultValue_giftIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<Long> $defaultValue_tagIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final List<Long> getEffectedGiftIds() {
        return this._$$effectedGiftIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final long getEndTime() {
        return this._$$endTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final Map<String, String> getEventTrack() {
        return this._$$eventTrack;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final List<Long> getGiftIds() {
        return this._$$giftIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final String getScene() {
        return this._$$scene;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final int getStrategyType() {
        return this._$$strategyType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final List<Long> getTagIds() {
        return this._$$tagIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final int getUpdateType() {
        return this._$$updateType;
    }

    public IGiftSortStrategyFlexImpl(am3.g r110) {
        super(a2.class);
        this._$$giftIds = new ArrayList();
        this._$$tagIds = new ArrayList();
        this._$$effectedGiftIds = new ArrayList();
        this._$$eventTrack = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L35;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        switch(r101) {
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L8;
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
        Map<String, String> r107 = this._$$eventTrack;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        List<Long> r108 = this._$$effectedGiftIds;
    L33:
        r108.add(Long.valueOf(r110.j()));
        goto L3
    L26:
        this._$$updateType = r110.i();
        goto L3
    L27:
        this._$$strategyType = r110.i();
        goto L3
    L28:
        this._$$extra = am3.h.c(r110);
        goto L3
    L29:
        this._$$endTime = r110.j();
        goto L3
    L30:
        this._$$startTime = r110.j();
        goto L3
    L31:
        r108 = this._$$tagIds;
        goto L33
    L32:
        r108 = this._$$giftIds;
        goto L33
    L34:
        this._$$scene = am3.h.c(r110);
        goto L3
    L7:
        am3.h.d(r102, r110);
        goto L3
    L35:
        r110.d(r100);
        setThreadSafe(true);
        if (this._$$scene != null) goto L39;
        this._$$scene = "";
    L39:
        if (this._$$giftIds.isEmpty() == false) goto L42;
        this._$$giftIds = $defaultValue_giftIds$();
    L42:
        if (this._$$tagIds.isEmpty() == false) goto L45;
        this._$$tagIds = $defaultValue_tagIds$();
    L45:
        if (this._$$extra != null) goto L48;
        this._$$extra = "";
    L48:
        if (this._$$effectedGiftIds.isEmpty() == false) goto L51;
        this._$$effectedGiftIds = $defaultValue_effectedGiftIds$();
    L51:
        if (this._$$eventTrack != null) goto L87;
        this._$$eventTrack = $defaultValue_eventTrack$();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setEndTime(long r100) {
        this._$$endTime = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setEventTrack(Map<String, String> r100) {
        this._$$eventTrack = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setExtra(String r100) {
        this._$$extra = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setGiftIds(List<Long> r100) {
        this._$$giftIds = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setScene(String r100) {
        this._$$scene = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setStartTime(long r100) {
        this._$$startTime = r100;
    }
}
