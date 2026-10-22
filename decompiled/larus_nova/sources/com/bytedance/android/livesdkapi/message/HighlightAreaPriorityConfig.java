package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "", "()V", "locationPriority", "", "getLocationPriority", "()J", "setLocationPriority", "(J)V", "showPriority", "getShowPriority", "setShowPriority", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HighlightAreaPriorityConfig implements h {

    @SerializedName("LocationPriority")
    protected long locationPriority;

    @SerializedName("ShowPriority")
    protected long showPriority;

    public HighlightAreaPriorityConfig() {
        this.locationPriority = -1990;
        this.showPriority = -1990;
    }

    public final long getLocationPriority() {
        return this.locationPriority;
    }

    public final long getShowPriority() {
        return this.showPriority;
    }

    public HighlightAreaPriorityConfig(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.locationPriority = r100.j();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.showPriority = r100.j();
        r102 = r102 | 2;
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L15;
        this.locationPriority = -1990;
    L15:
        if ((r102 & 2) != 0) goto L27;
        this.showPriority = -1990;
        return;
    }

    public final void setLocationPriority(long r100) {
        this.locationPriority = r100;
    }

    public final void setShowPriority(long r100) {
        this.showPriority = r100;
    }
}
