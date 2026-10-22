package com.bytedance.android.livesdkapi.depend.model.live.toolbar;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/ToolbarPermutationRule;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarPermutationRule;", "()V", "componentSequence", "", "", "getComponentSequence", "()Ljava/util/List;", "setComponentSequence", "(Ljava/util/List;)V", "groupPriority", "getGroupPriority", "setGroupPriority", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToolbarPermutationRule extends FlexModelBase<IToolbarPermutationRule> implements IToolbarPermutationRule, h {

    @SerializedName("ComponentSequence")
    protected List<Integer> componentSequence;

    @SerializedName("GroupPriority")
    protected List<Integer> groupPriority;

    public ToolbarPermutationRule() {
        super(IToolbarPermutationRule.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarPermutationRule
    public List<Integer> getComponentSequence() {
        return this.componentSequence;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarPermutationRule
    public List<Integer> getGroupPriority() {
        return this.groupPriority;
    }

    public ToolbarPermutationRule(g r100) {
        super(IToolbarPermutationRule.class);
        this.groupPriority = new ArrayList();
        this.componentSequence = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L9;
        List<Integer> r104 = this.componentSequence;
    L12:
        r104.add(Integer.valueOf(r100.i()));
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L11:
        r104 = this.groupPriority;
        goto L12
    L13:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarPermutationRule
    public void setComponentSequence(List<Integer> r100) {
        this.componentSequence = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarPermutationRule
    public void setGroupPriority(List<Integer> r100) {
        this.groupPriority = r100;
    }
}
