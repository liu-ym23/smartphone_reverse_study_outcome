package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.ComboHint")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ExtraComboHintFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/u;", "", "comboHintScene$delegate", "Ljava/lang/Object;", "getComboHintScene", "()I", "comboHintScene", "", "Lcom/bytedance/android/livesdk/gift/model/ExtraComboHintDataFlexImpl;", "comboHintData$delegate", "getComboHintData", "()Ljava/util/List;", "comboHintData", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExtraComboHintFlexImpl extends FlexModelBase<u> implements u, vh7.h {

    @SerializedName("combo_hint_data")
    protected List<ExtraComboHintDataFlexImpl> _$$comboHintData;

    @SerializedName("combo_hint_scene")
    protected int _$$comboHintScene;

    public ExtraComboHintFlexImpl() {
        super(u.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.u
    public final List<ExtraComboHintDataFlexImpl> getComboHintData() {
        return this._$$comboHintData;
    }

    @Override // com.bytedance.android.livesdk.gift.model.u
    public final int getComboHintScene() {
        return this._$$comboHintScene;
    }

    public ExtraComboHintFlexImpl(am3.g r100) {
        super(u.class);
        this._$$comboHintData = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$comboHintScene = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$comboHintData.add(new ExtraComboHintDataFlexImpl(r100));
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}
