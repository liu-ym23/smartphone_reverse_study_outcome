package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/SeiLyricsInfo;", "", SlcFlexDirection.FLEX_ROW, "", "lyrics", "", "(ILjava/lang/String;)V", "getLyrics", "()Ljava/lang/String;", "setLyrics", "(Ljava/lang/String;)V", "getRow", "()I", "setRow", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeiLyricsInfo {

    @SerializedName("lyrics")
    private String lyrics;

    @SerializedName(SlcFlexDirection.FLEX_ROW)
    private int row;

    /* JADX WARN: Multi-variable type inference failed */
    public SeiLyricsInfo() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SeiLyricsInfo copy$default(SeiLyricsInfo r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.row;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.lyrics;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.row;
    }

    public final String component2() {
        return this.lyrics;
    }

    public final SeiLyricsInfo copy(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "lyrics");
        return new SeiLyricsInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SeiLyricsInfo) == false) goto L10;
        SeiLyricsInfo r101 = (SeiLyricsInfo) r100;
        if (this.row == r101.row) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lyrics, r101.lyrics) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.row * 31;
        String r101 = this.lyrics;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "SeiLyricsInfo(row=" + this.row + ", lyrics=" + this.lyrics + ")";
    }

    public final String getLyrics() {
        return this.lyrics;
    }

    public final int getRow() {
        return this.row;
    }

    public final void setLyrics(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lyrics = r100;
    }

    public final void setRow(int r100) {
        this.row = r100;
    }

    public SeiLyricsInfo(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "lyrics");
        this.row = r100;
        this.lyrics = r101;
    }

    public /* synthetic */ SeiLyricsInfo(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
