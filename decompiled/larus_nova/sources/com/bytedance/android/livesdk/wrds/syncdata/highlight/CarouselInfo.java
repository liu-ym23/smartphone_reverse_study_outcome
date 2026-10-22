package com.bytedance.android.livesdk.wrds.syncdata.highlight;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CarouselInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/CarouselInfo;", "", "()V", "itemGroup", "", "", "getItemGroup", "()Ljava/util/List;", "setItemGroup", "(Ljava/util/List;)V", "time", "getTime", "()J", "setTime", "(J)V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarouselInfo implements h {

    @SerializedName("item_group")
    protected List<Long> itemGroup;

    @SerializedName("time")
    protected long time;

    public CarouselInfo() {
    }

    public final List<Long> getItemGroup() {
        return this.itemGroup;
    }

    public final long getTime() {
        return this.time;
    }

    public CarouselInfo(g r100) {
        this.itemGroup = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.time = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.itemGroup.add(Long.valueOf(r100.j()));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setItemGroup(List<Long> r100) {
        this.itemGroup = r100;
    }

    public final void setTime(long r100) {
        this.time = r100;
    }
}
