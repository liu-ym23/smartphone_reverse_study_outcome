package com.bytedance.android.livesdkapi.depend.model.live.episode;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MarkDetail;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMarkDetail;", "()V", "itemMarkList1", "", "", "getItemMarkList1", "()Ljava/util/List;", "setItemMarkList1", "(Ljava/util/List;)V", "item_MarkList2", "getItem_MarkList2", "setItem_MarkList2", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarkDetail extends FlexModelBase<IMarkDetail> implements IMarkDetail, h {

    @SerializedName("item_mark_list_v1")
    protected List<String> itemMarkList1;

    @SerializedName("item_mark_list_v2")
    protected List<String> item_MarkList2;

    public MarkDetail() {
        super(IMarkDetail.class);
    }

    public MarkDetail(g r100) {
        super(IMarkDetail.class);
        this.itemMarkList1 = new ArrayList();
        this.item_MarkList2 = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L9;
        List<String> r104 = this.item_MarkList2;
    L12:
        r104.add(am3.h.c(r100));
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L11:
        r104 = this.itemMarkList1;
        goto L12
    L13:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMarkDetail
    public List<String> getItemMarkList1() {
        return this.itemMarkList1;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMarkDetail
    public List<String> getItem_MarkList2() {
        return this.item_MarkList2;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMarkDetail
    public void setItemMarkList1(List<String> r100) {
        this.itemMarkList1 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMarkDetail
    public void setItem_MarkList2(List<String> r100) {
        this.item_MarkList2 = r100;
    }
}
