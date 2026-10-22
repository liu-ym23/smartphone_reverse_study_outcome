package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchTabFrame;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTabFrame;", "()V", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "color", "getColor", "setColor", "tabs", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTab;", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchTabFrame extends FlexModelBase<IMatchTabFrame> implements IMatchTabFrame, h {

    @SerializedName("background_color")
    protected String backgroundColor;

    @SerializedName("color")
    protected String color;

    @SerializedName("tabs")
    protected List<? extends IMatchTab> tabs;

    public MatchTabFrame() {
        super(IMatchTabFrame.class);
        this.tabs = new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTabFrame
    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTabFrame
    public String getColor() {
        return this.color;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTabFrame
    public List<IMatchTab> getTabs() {
        return this.tabs;
    }

    public MatchTabFrame(g r100) {
        super(IMatchTabFrame.class);
        this.tabs = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.tabs.add(f.a(r100, IMatchTab.class));
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.color = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 4) goto L11;
        this.backgroundColor = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this.tabs.isEmpty() == false) goto L31;
        this.tabs = new ArrayList();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTabFrame
    public void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTabFrame
    public void setColor(String r100) {
        this.color = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTabFrame
    public void setTabs(List<? extends IMatchTab> r100) {
        this.tabs = r100;
    }
}
