package com.obric.appstore.network.entity;

import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/appstore/network/entity/PageListResp;", "T", "Lcom/obric/appstore/network/entity/PageResp;", ServerElements.LIST, "", Card.KEY_HAS_MORE, "", "(Ljava/util/List;Z)V", "data", "getData", "()Ljava/util/List;", "getList", "copy", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PageListResp<T> extends PageResp<T> {

    @SerializedName(ServerElements.LIST)
    @Nullable
    private final List<T> list;

    public /* synthetic */ PageListResp(List r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        this(r10, r11);
    }

    @Override // com.obric.appstore.network.entity.PageResp
    @NotNull
    public PageResp<T> copy(@Nullable List<? extends T> r10, boolean r11) {
        return new PageListResp(r10, r11);
    }

    @Override // com.obric.appstore.network.entity.PageResp
    @Nullable
    public List<T> getData() {
        return this.list;
    }

    @Nullable
    public final List<T> getList() {
        return this.list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageListResp(@Nullable List<? extends T> r10, boolean r11) {
        super(r11);
        this.list = r10;
    }
}
