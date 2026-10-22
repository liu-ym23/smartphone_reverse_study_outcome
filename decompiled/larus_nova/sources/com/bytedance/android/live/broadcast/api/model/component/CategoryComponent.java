package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.live.broadcast.api.model.CategoryNode;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.CategoryComponent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;", "", "()V", "base", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "nodeMap", "", "", "Lcom/bytedance/android/live/broadcast/api/model/CategoryNode;", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryComponent implements h {

    @SerializedName("base")
    public BaseComponentModel base;

    @SerializedName("select_node")
    public Map<Integer, CategoryNode> nodeMap;

    public CategoryComponent() {
    }

    public CategoryComponent(g r110) {
        this.nodeMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.base = new BaseComponentModel(r110);
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r102 = r110.c();
        Integer r103 = null;
        CategoryNode r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = Integer.valueOf(r110.i());
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = new CategoryNode(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r102);
        Map<Integer, CategoryNode> r106 = this.nodeMap;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L27:
        r110.d(r100);
    }
}
