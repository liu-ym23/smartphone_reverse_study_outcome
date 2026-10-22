package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.SurvivalConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR/\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ISurvivalConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/k9;", "", "Lcom/bytedance/android/livesdk/link/model/ISurvivalConfig_IStageFlexImpl;", "stages$delegate", "Ljava/lang/Object;", "getStages", "()Ljava/util/List;", "stages", "", "<set-?>", "outAnimationUrl$delegate", "getOutAnimationUrl", "()Ljava/lang/String;", "setOutAnimationUrl", "(Ljava/lang/String;)V", "outAnimationUrl", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISurvivalConfigFlexImpl extends FlexModelBase<k9> implements k9, vh7.h {

    @SerializedName("out_animation_url")
    protected String _$$outAnimationUrl;

    @SerializedName("stages")
    protected List<ISurvivalConfig_IStageFlexImpl> _$$stages;

    public ISurvivalConfigFlexImpl() {
        super(k9.class);
    }

    public ISurvivalConfigFlexImpl(am3.g r100) {
        super(k9.class);
        this._$$stages = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$stages.add(new ISurvivalConfig_IStageFlexImpl(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$outAnimationUrl = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.k9
    public final String getOutAnimationUrl() {
        return this._$$outAnimationUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.k9
    public final List<ISurvivalConfig_IStageFlexImpl> getStages() {
        return this._$$stages;
    }

    @Override // com.bytedance.android.livesdk.link.model.k9
    public final void setOutAnimationUrl(String r100) {
        this._$$outAnimationUrl = r100;
    }
}
