package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchTab;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTab;", "()V", "id", "", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchTab extends FlexModelBase<IMatchTab> implements IMatchTab, h {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected Long f162624id;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("title")
    protected String title;

    public MatchTab() {
        super(IMatchTab.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTab
    public Long getId() {
        return this.f162624id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTab
    public String getSchema() {
        return this.schema;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTab
    public String getTitle() {
        return this.title;
    }

    public MatchTab(g r100) {
        super(IMatchTab.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.schema = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.f162624id = Long.valueOf(r100.j());
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTab
    public void setId(Long r100) {
        this.f162624id = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTab
    public void setSchema(String r100) {
        this.schema = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTab
    public void setTitle(String r100) {
        this.title = r100;
    }
}
