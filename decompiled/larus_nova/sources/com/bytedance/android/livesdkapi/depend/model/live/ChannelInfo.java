package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ChannelInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ChannelInfo;", "", "()V", "dimension", "", "getDimension", "()I", "setDimension", "(I)V", "layout", "getLayout", "setLayout", Constants.OperatorKey.KEY_VENDOR, "getVendor", "setVendor", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ChannelInfo implements h {

    @SerializedName("dimension")
    protected int dimension;

    @SerializedName("layout")
    protected int layout;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    protected int f162579vendor;

    public ChannelInfo() {
    }

    public final int getDimension() {
        return this.dimension;
    }

    public final int getLayout() {
        return this.layout;
    }

    public final int getVendor() {
        return this.f162579vendor;
    }

    public ChannelInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.f162579vendor = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.layout = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.dimension = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setDimension(int r100) {
        this.dimension = r100;
    }

    public final void setLayout(int r100) {
        this.layout = r100;
    }

    public final void setVendor(int r100) {
        this.f162579vendor = r100;
    }
}
