package com.bytedance.android.live.base.model.user;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/base/model/user/MyLiveTab;", "", "()V", "bizName", "", "getBizName", "()Ljava/lang/String;", "setBizName", "(Ljava/lang/String;)V", "extra", "Lcom/bytedance/android/live/base/model/user/MyLiveTab$Extra;", "getExtra", "()Lcom/bytedance/android/live/base/model/user/MyLiveTab$Extra;", "setExtra", "(Lcom/bytedance/android/live/base/model/user/MyLiveTab$Extra;)V", "items", "", "Lcom/bytedance/android/live/base/model/user/MyLiveTabItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "Extra", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MyLiveTab implements vh7.h {

    @SerializedName(MapMonitorConst.BIZ_NAME)
    protected String bizName;

    @SerializedName("extra")
    protected Extra extra;

    @SerializedName("items")
    protected List<MyLiveTabItem> items;

    @SerializedName("title")
    protected String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/base/model/user/MyLiveTab$Extra;", "", "()V", ChameleonOpenTracker.ParamKey.COST, "", "getCost", "()J", "setCost", "(J)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "nextQueryIndex", "getNextQueryIndex", "setNextQueryIndex", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra implements vh7.h {

        @SerializedName(ChameleonOpenTracker.ParamKey.COST)
        protected long cost;

        @SerializedName("has_more")
        protected boolean hasMore;

        @SerializedName("next_query_index")
        protected long nextQueryIndex;

        public Extra() {
        }

        public final long getCost() {
            return this.cost;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final long getNextQueryIndex() {
            return this.nextQueryIndex;
        }

        public Extra(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.hasMore = am3.h.a(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.nextQueryIndex = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.cost = r100.j();
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }

        public final void setCost(long r100) {
            this.cost = r100;
        }

        public final void setHasMore(boolean r100) {
            this.hasMore = r100;
        }

        public final void setNextQueryIndex(long r100) {
            this.nextQueryIndex = r100;
        }
    }

    public MyLiveTab() {
    }

    public MyLiveTab(am3.g r100) {
        this.items = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.bizName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.title = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.items.add(new MyLiveTabItem(r100));
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.extra = new Extra(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final List<MyLiveTabItem> getItems() {
        return this.items;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setBizName(String r100) {
        this.bizName = r100;
    }

    public final void setExtra(Extra r100) {
        this.extra = r100;
    }

    public final void setItems(List<MyLiveTabItem> r100) {
        this.items = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
