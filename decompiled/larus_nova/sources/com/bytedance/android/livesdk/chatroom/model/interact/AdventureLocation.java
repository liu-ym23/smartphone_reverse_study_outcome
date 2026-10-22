package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.AdventureLocation")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureLocation;", "", "()V", "x", "", "getX", "()J", "setX", "(J)V", "y", "getY", "setY", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdventureLocation implements vh7.h {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    protected long f106922x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    protected long f106923y;

    public AdventureLocation() {
    }

    public final long getX() {
        return this.f106922x;
    }

    public final long getY() {
        return this.f106923y;
    }

    public AdventureLocation(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.f106922x = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.f106923y = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setX(long r100) {
        this.f106922x = r100;
    }

    public final void setY(long r100) {
        this.f106923y = r100;
    }
}
