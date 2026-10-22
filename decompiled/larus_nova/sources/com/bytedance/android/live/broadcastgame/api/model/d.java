package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/d;", "", "", "on", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: on, reason: collision with root package name */
    @SerializedName("on")
    private final boolean f59337on;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.f59337on == ((d) r100).f59337on) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f59337on;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ChatroomScreencastConfig(on=" + this.f59337on + ")";
    }

    public d() {
        this.f59337on = false;
    }

    public final boolean a() {
        return this.f59337on;
    }
}
