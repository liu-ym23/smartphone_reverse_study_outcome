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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J*\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H&J\u0013\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0001\u0010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/obric/appstore/network/entity/PageResp;", "T", "", Card.KEY_HAS_MORE, "", "(Z)V", "data", "", "getData", "()Ljava/util/List;", "extras", "getHasMore", "()Z", "copy", "getExtras", "S", "()Ljava/lang/Object;", "setExtras", "", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PageResp<T> {

    @Nullable
    private Object extras;

    @SerializedName(ServerElements.HAS_MORE)
    private final boolean hasMore;

    public PageResp() {
        boolean r10 = false;
        this(r10, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageResp copy$default(PageResp r10, List r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 1) == 0) goto L7;
        r11 = r10.getData();
    L7:
        if ((r13 & 2) == 0) goto L10;
        r12 = r10.hasMore;
    L10:
        return r10.copy(r11, r12);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    @NotNull
    public abstract PageResp<T> copy(@Nullable List<? extends T> r10, boolean r11);

    @Nullable
    public abstract List<T> getData();

    @Nullable
    public final <S> S getExtras() {
        S r10 = (S) this.extras;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final void setExtras(@Nullable Object r10) {
        this.extras = r10;
    }

    public PageResp(boolean r10) {
        this.hasMore = r10;
    }

    public /* synthetic */ PageResp(boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = false;
    L5:
        this(r10);
    }
}
