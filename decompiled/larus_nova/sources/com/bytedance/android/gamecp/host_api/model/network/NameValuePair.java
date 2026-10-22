package com.bytedance.android.gamecp.host_api.model.network;

import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;

/* JADX INFO: loaded from: classes44.dex */
public class NameValuePair implements Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + r102;
        String r104 = this.value;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return (r103 * 37) + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        if (this.value == null) goto L5;
        StringBuilder r100 = new StringBuilder((this.name.length() + 1) + this.value.length());
        r100.append(this.name);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(this.value);
        return r100.toString();
    L5:
        return this.name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NameValuePair) == false) goto L19;
        NameValuePair r101 = (NameValuePair) r100;
        if (this.name.equals(r101.name) == false) goto L17;
        String r102 = this.value;
        String r103 = r101.value;
        if (r102 != null) goto L14;
        if (r103 != null) goto L13;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        return true;
    L13:
        r104 = false;
        goto L15
    L14:
        r104 = r102.equals(r103);
    L17:
        return false;
    L19:
        return false;
    }

    public NameValuePair(String r100, String r101) {
        if (r100 == null) goto L7;
        this.name = r100;
        this.value = r101;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
