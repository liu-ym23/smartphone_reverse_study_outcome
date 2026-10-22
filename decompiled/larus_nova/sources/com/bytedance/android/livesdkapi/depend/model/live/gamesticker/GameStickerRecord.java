package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerRecord;", "", "ver", "", "type", "id", "", "(IIJ)V", "getId", "()J", "getType", "()I", "getVer", "setVer", "(I)V", "equals", "", "other", "hashCode", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GameStickerRecord {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f162620id;
    private final int type;
    private int ver;

    public int hashCode() {
        int r100 = this.type * 31;
        long r101 = this.f162620id;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "GameStickerRecord(ver=" + this.ver + ", type=" + this.type + ", id=" + this.f162620id + ')';
    }

    public final long getId() {
        return this.f162620id;
    }

    public final int getType() {
        return this.type;
    }

    public final int getVer() {
        return this.ver;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(GameStickerRecord.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        GameStickerRecord r102 = (GameStickerRecord) r100;
        if (this.type == r102.type) goto L17;
        return false;
    L17:
        if (this.f162620id == r102.f162620id) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerRecord");
    L8:
        r101 = null;
        goto L10
    }

    public final void setVer(int r100) {
        this.ver = r100;
    }

    public GameStickerRecord(int r100, int r101, long r102) {
        this.ver = r100;
        this.type = r101;
        this.f162620id = r102;
    }

    public /* synthetic */ GameStickerRecord(int r100, int r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100, r101, r102);
    }
}
