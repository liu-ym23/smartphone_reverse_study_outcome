package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.SeasonBasicInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBasicInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBasicInfo;", "", "seasonType$delegate", "Ljava/lang/Object;", "getSeasonType", "()Ljava/lang/Integer;", "seasonType", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SeasonBasicInfoFlexImpl extends FlexModelBase<SeasonBasicInfo> implements SeasonBasicInfo, h {

    @SerializedName("season_type")
    protected Integer _$$seasonType;

    public SeasonBasicInfoFlexImpl() {
        super(SeasonBasicInfo.class);
        this._$$seasonType = $defaultValue_seasonType$();
    }

    public final Integer $defaultValue_seasonType$() {
        return SeasonBasicInfo.DefaultImpls.getSeasonType(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.SeasonBasicInfo
    public final Integer getSeasonType() {
        return this._$$seasonType;
    }

    public SeasonBasicInfoFlexImpl(g r100) {
        super(SeasonBasicInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$seasonType = Integer.valueOf(r100.i());
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$seasonType != null) goto L19;
        this._$$seasonType = $defaultValue_seasonType$();
        return;
    }
}
