package com.bytedance.android.shopping.vo;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/vo/ShopColumnVO;", "Ljava/io/Serializable;", "()V", "canReverse", "", "getCanReverse", "()Z", "setCanReverse", "(Z)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "selected", "getSelected", "setSelected", "sort", "", "getSort", "()I", "setSort", "(I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopColumnVO implements Serializable {
    private boolean canReverse;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f187190id;
    private String name;
    private boolean selected;
    private int sort;

    public ShopColumnVO() {
        this.f187190id = "";
        this.name = "";
    }

    public final boolean getCanReverse() {
        return this.canReverse;
    }

    public final String getId() {
        return this.f187190id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final int getSort() {
        return this.sort;
    }

    public final void setCanReverse(boolean r100) {
        this.canReverse = r100;
    }

    public final void setId(String r100) {
        this.f187190id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }

    public final void setSort(int r100) {
        this.sort = r100;
    }
}
