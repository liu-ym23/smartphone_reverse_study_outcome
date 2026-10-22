package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class AndroidResourceSignature implements Key {
    private final Key applicationVersion;
    private final int nightMode;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.applicationVersion, this.nightMode);
    }

    public static Key obtain(Context r100) {
        Key r101 = ApplicationVersionSignature.obtain(r100);
        return new AndroidResourceSignature(r100.getResources().getConfiguration().uiMode & 48, r101);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof AndroidResourceSignature) == false) goto L10;
        AndroidResourceSignature r101 = (AndroidResourceSignature) r100;
        if (this.nightMode == r101.nightMode) goto L7;
        return false;
    L7:
        if (this.applicationVersion.equals(r101.applicationVersion) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        this.applicationVersion.updateDiskCacheKey(r100);
        r100.update(ByteBuffer.allocate(4).putInt(this.nightMode).array());
    }

    private AndroidResourceSignature(int r100, Key r101) {
        this.nightMode = r100;
        this.applicationVersion = r101;
    }
}
