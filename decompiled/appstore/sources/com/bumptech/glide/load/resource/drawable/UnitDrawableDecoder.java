package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    public UnitDrawableDecoder() {
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public /* bridge */ /* synthetic */ Resource<Drawable> decode(@NonNull Drawable r10, int r11, int r12, @NonNull Options r13) throws IOException {
        return decode2(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull Drawable r10, @NonNull Options r11) {
        return true;
    }

    @Nullable
    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Drawable> decode2(@NonNull Drawable r10, int r11, int r12, @NonNull Options r13) {
        return NonOwnedDrawableResource.newInstance(r10);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(@NonNull Drawable r10, @NonNull Options r11) throws IOException {
        return handles2(r10, r11);
    }
}
