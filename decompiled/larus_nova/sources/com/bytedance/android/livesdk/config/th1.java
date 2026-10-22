package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/th1;", "", "", "rom", "Ljava/lang/String;", "getRom", "()Ljava/lang/String;", "romKey", "getRomKey", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class th1 {

    @SerializedName("rom")
    private final String rom;

    @SerializedName("rom_key")
    private final String romKey;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof th1) == false) goto L10;
        th1 r101 = (th1) r100;
        if (Intrinsics.areEqual(this.rom, r101.rom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.romKey, r101.romKey) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.rom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.romKey;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SysRom(rom=" + this.rom + ", romKey=" + this.romKey + ")";
    }

    public th1() {
        Intrinsics.checkNotNullParameter("", "rom");
        Intrinsics.checkNotNullParameter("", "romKey");
        this.rom = "";
        this.romKey = "";
    }
}
