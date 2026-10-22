package com.bytedance.android.ec.core.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes43.dex */
public class i implements z0, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45606b;

    public final int hashCode() {
        String r100 = this.f45605a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + r102;
        String r104 = this.f45606b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return (r103 * 37) + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        int r100 = this.f45605a.length();
        String r101 = this.f45606b;
        if (r101 == null) goto L5;
        r100 = r100 + (r101.length() + 1);
    L5:
        l r102 = new l(r100);
        r102.a(this.f45605a);
        if (this.f45606b == null) goto L9;
        r102.a(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.a(this.f45606b);
    L9:
        return r102.toString();
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.bytedance.android.ec.core.utils.z0
    public final String getName() {
        return this.f45605a;
    }

    @Override // com.bytedance.android.ec.core.utils.z0
    public final String getValue() {
        return this.f45606b;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((r100 instanceof z0) == false) goto L21;
        i r101 = (i) r100;
        if (this.f45605a.equals(r101.f45605a) == false) goto L22;
        String r102 = this.f45606b;
        String r103 = r101.f45606b;
        if (r102 != null) goto L17;
        if (r103 != null) goto L16;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L23;
        return true;
    L23:
        return false;
    L16:
        r104 = false;
        goto L18
    L17:
        r104 = r102.equals(r103);
        goto L18
    L22:
        return false;
    L21:
        return false;
    }

    public i(String r100, String r101) {
        if (r100 == null) goto L7;
        this.f45605a = r100;
        this.f45606b = r101;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
