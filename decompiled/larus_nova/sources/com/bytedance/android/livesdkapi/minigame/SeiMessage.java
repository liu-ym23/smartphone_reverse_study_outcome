package com.bytedance.android.livesdkapi.minigame;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/SeiMessage;", "", "type", "", "action", "", "msg", "(ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getMsg", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SeiMessage {
    private final String action;
    private final String msg;
    private final int type;

    public static /* synthetic */ SeiMessage copy$default(SeiMessage r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.action;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.msg;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.action;
    }

    public final String component3() {
        return this.msg;
    }

    public final SeiMessage copy(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        return new SeiMessage(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SeiMessage) == false) goto L12;
        SeiMessage r101 = (SeiMessage) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.action;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.msg;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "SeiMessage(type=" + this.type + ", action=" + this.action + ", msg=" + this.msg + ")";
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getType() {
        return this.type;
    }

    public SeiMessage(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        this.type = r100;
        this.action = r101;
        this.msg = r102;
    }
}
