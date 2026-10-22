package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    public UnitDrawableDecoder() {
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Drawable r100, Options r101) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(Drawable r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Drawable> decode(Drawable r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Drawable> decode2(Drawable r100, int r101, int r102, Options r103) {
        return NonOwnedDrawableResource.newInstance(r100);
    }
}
