package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    private static final String ANDROID_PACKAGE_NAME = "android";
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int MISSING_RESOURCE_ID = 0;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;
    private final Context context;

    public ResourceDrawableDecoder(Context r10) {
        this.context = r10.getApplicationContext();
    }

    @NonNull
    private Context findContextForPackage(Uri r10, String r11) {
        if (r11.equals(this.context.getPackageName()) == true) goto L5;
        return this.context.createPackageContext(r11, 0);
    L8:
        e = move-exception;
        if (r11.contains(this.context.getPackageName()) == false) goto L14;
        return this.context;
    L14:
        throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + r10, e);
    L5:
        return this.context;
    }

    @DrawableRes
    private int findResourceIdFromResourceIdUri(Uri r10) {
        return Integer.parseInt(r10.getPathSegments().get(0));
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Unrecognized Uri format: " + r10, e);
    }

    @DrawableRes
    private int findResourceIdFromTypeAndNameResourceUri(Context r10, Uri r11) {
        List<String> r12 = r11.getPathSegments();
        String r13 = r11.getAuthority();
        String r14 = r12.get(0);
        String r15 = r12.get(1);
        int r16 = r10.getResources().getIdentifier(r15, r14, r13);
        if (r16 != 0) goto L5;
        r16 = Resources.getSystem().getIdentifier(r15, r14, ANDROID_PACKAGE_NAME);
    L5:
        if (r16 == 0) goto L8;
        return r16;
    L8:
        throw new IllegalArgumentException("Failed to find resource id for: " + r11);
    }

    @DrawableRes
    private int findResourceIdFromUri(Context r10, Uri r11) {
        List<String> r12 = r11.getPathSegments();
        if (r12.size() != 2) goto L7;
        return findResourceIdFromTypeAndNameResourceUri(r10, r11);
    L7:
        if (r12.size() != 1) goto L11;
        return findResourceIdFromResourceIdUri(r11);
    L11:
        throw new IllegalArgumentException("Unrecognized Uri format: " + r11);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public /* bridge */ /* synthetic */ Resource<Drawable> decode(@NonNull Uri r10, int r11, int r12, @NonNull Options r13) throws IOException {
        return decode2(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(@NonNull Uri r10, @NonNull Options r11) throws IOException {
        return handles2(r10, r11);
    }

    @Nullable
    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Drawable> decode2(@NonNull Uri r10, int r11, int r12, @NonNull Options r13) {
        Context r14 = findContextForPackage(r10, r10.getAuthority());
        int r15 = findResourceIdFromUri(r14, r10);
        return NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(this.context, r14, r15));
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull Uri r10, @NonNull Options r11) {
        return r10.getScheme().equals("android.resource");
    }
}
