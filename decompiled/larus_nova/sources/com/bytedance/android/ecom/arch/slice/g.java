package com.bytedance.android.ecom.arch.slice;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.slices.SliceTypeAdapter;
import com.bytedance.android.ecom.arch.slice.style.SlcStyle;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@JsonAdapter(SliceTypeAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/g;", "Lcom/bytedance/android/ecom/arch/slice/adapter/b;", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface g extends com.bytedance.android.ecom.arch.slice.adapter.b, Cloneable {

    public static final class a {
        public static /* synthetic */ void a(g r100, Map r101, boolean r102, int r103) {
            if ((r103 & 4) == 0) goto L5;
            r102 = true;
        L5:
            r100.updateData(r101, 0, r102);
        }
    }

    g clone();

    Object getConfig(String r100);

    Map<String, Object> getData();

    b getExposure();

    p getParent();

    IAction getShowAction();

    String getSliceId();

    String getSliceType();

    Map<String, SlcStyle> getSpecialStyle();

    SlcStyle getStyle();

    Map<String, String> getTrackMeta();

    String getViewType();

    boolean isFooter();

    boolean isHeader();

    void setFooter(boolean r100);

    void setHeader(boolean r100);

    void setParent(p r100);

    void setSliceRebindTarget(h r100);

    void updateData(Map<String, ? extends Object> r100, @SliceUpdateMode int r101, boolean r102);
}
