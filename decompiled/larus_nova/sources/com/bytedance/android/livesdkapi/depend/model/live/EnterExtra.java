package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/EnterExtra;", "", "isOfficialChannel", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterExtra {
    private final boolean isOfficialChannel;

    public static /* synthetic */ EnterExtra copy$default(EnterExtra r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.isOfficialChannel;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.isOfficialChannel;
    }

    public final EnterExtra copy(boolean r100) {
        return new EnterExtra(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EnterExtra) == true) goto L6;
        return false;
    L6:
        if (this.isOfficialChannel == ((EnterExtra) r100).isOfficialChannel) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        boolean r100 = this.isOfficialChannel;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public String toString() {
        return "EnterExtra(isOfficialChannel=" + this.isOfficialChannel + ")";
    }

    public final boolean isOfficialChannel() {
        return this.isOfficialChannel;
    }

    public EnterExtra(boolean r100) {
        this.isOfficialChannel = r100;
    }
}
