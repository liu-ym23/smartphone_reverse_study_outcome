package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    private static final String ANDROID_PACKAGE_NAME = "android";
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int MISSING_RESOURCE_ID = 0;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;
    private final Context context;

    public ResourceDrawableDecoder(Context r100) {
        this.context = r100.getApplicationContext();
    }

    private int findResourceIdFromResourceIdUri(Uri r100) {
        return CastIntegerProtector.parseInt((String) ListProtector.get(r100.getPathSegments(), 0));
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Unrecognized Uri format: " + r100, e);
    }

    private Context findContextForPackage(Uri r100, String r101) {
        if (r101.equals(this.context.getPackageName()) == true) goto L5;
        return this.context.createPackageContext(r101, 0);
    L8:
        e = move-exception;
        if (r101.contains(this.context.getPackageName()) == false) goto L14;
        return this.context;
    L14:
        throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + r100, e);
    L5:
        return this.context;
    }

    private int findResourceIdFromTypeAndNameResourceUri(Context r100, Uri r101) {
        List<String> r102 = r101.getPathSegments();
        String r103 = r101.getAuthority();
        String r104 = (String) ListProtector.get(r102, 0);
        String r105 = (String) ListProtector.get(r102, 1);
        int r106 = r100.getResources().getIdentifier(r105, r104, r103);
        if (r106 != 0) goto L5;
        r106 = Resources.getSystem().getIdentifier(r105, r104, "android");
    L5:
        if (r106 == 0) goto L8;
        return r106;
    L8:
        throw new IllegalArgumentException("Failed to find resource id for: " + r101);
    }

    private int findResourceIdFromUri(Context r100, Uri r101) {
        List<String> r102 = r101.getPathSegments();
        if (r102.size() != 2) goto L7;
        return findResourceIdFromTypeAndNameResourceUri(r100, r101);
    L7:
        if (r102.size() != 1) goto L11;
        return findResourceIdFromResourceIdUri(r101);
    L11:
        throw new IllegalArgumentException("Unrecognized Uri format: " + r101);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r100, Options r101) {
        return r100.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(Uri r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Drawable> decode2(Uri r100, int r101, int r102, Options r103) {
        Context r104 = findContextForPackage(r100, r100.getAuthority());
        int r105 = findResourceIdFromUri(r104, r100);
        return NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(this.context, r104, r105));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Drawable> decode(Uri r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }
}
