package com.bytedance.android.ecom.arch.slice.action;

import com.bytedance.android.ecom.arch.slice.render.elements.SlcTypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@JsonAdapter(SlcTypeAdapterFactory.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "Ljava/io/Serializable;", SlcCommonAction.KEY_ACTIONS, "", "getActions", "()Ljava/util/List;", "disable", "", "getDisable", "()Z", "exposureThreshold", "", "getExposureThreshold", "()F", "params", "", "", "", "getParams", "()Ljava/util/Map;", "scrollCallbackThreshold", "", "getScrollCallbackThreshold", "()J", "type", "getType", "()Ljava/lang/String;", "slice-render_release"}, k = 1, mv = {1, 1, 16})
public interface IAction extends Serializable {
    List<IAction> getActions();

    boolean getDisable();

    float getExposureThreshold();

    Map<String, Object> getParams();

    long getScrollCallbackThreshold();

    String getType();
}
