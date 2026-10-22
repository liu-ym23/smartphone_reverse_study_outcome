package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R:\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR:\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMarkDetail;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getItemMarkList1", "()Ljava/util/List;", "setItemMarkList1", "(Ljava/util/List;)V", "getItemMarkList1$annotations", "()V", "itemMarkList1", "getItem_MarkList2", "setItem_MarkList2", "getItem_MarkList2$annotations", "item_MarkList2", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMarkDetail extends c<IMarkDetail> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "item_mark_list_v1")
        public static /* synthetic */ void getItemMarkList1$annotations() {
        }

        @FieldName(name = "item_mark_list_v2")
        public static /* synthetic */ void getItem_MarkList2$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "item_mark_list_v1")
    List<String> getItemMarkList1();

    @FieldName(name = "item_mark_list_v2")
    List<String> getItem_MarkList2();

    @FieldName(name = "item_mark_list_v1#setter")
    void setItemMarkList1(List<String> r100);

    @FieldName(name = "item_mark_list_v2#setter")
    void setItem_MarkList2(List<String> r100);
}
