package com.android.server.textclassifier;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import android.util.Log;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class IconsContentProvider extends ContentProvider {
    private static final String MIME_TYPE = "image/png";
    private static final String TAG = "IconsContentProvider";
    private final ContentProvider.PipeDataWriter<Pair<IconsUriHelper.ResourceInfo, Integer>> mWriter;

    /* JADX INFO: renamed from: $r8$lambda$50-SRK6Xe3xvo6fS_ueXGxS44_U, reason: not valid java name */
    public static /* synthetic */ void m8467$r8$lambda$50SRK6Xe3xvo6fS_ueXGxS44_U(IconsContentProvider r0, ParcelFileDescriptor r1, Uri r2, String r3, Bundle r4, Pair r5) {
        r0.lambda$new$0(r1, r2, r3, r4, r5);
    }

    public IconsContentProvider() {
        this.mWriter = new IconsContentProvider$$ExternalSyntheticLambda0(this);
    }

    private /* synthetic */ void lambda$new$0(ParcelFileDescriptor writeSide, Uri uri, String mimeType, Bundle bundle, Pair args) {
        OutputStream out = new ParcelFileDescriptor.AutoCloseOutputStream(writeSide);     // Catch: Exception -> L6
        IconsUriHelper.ResourceInfo res = (IconsUriHelper.ResourceInfo) args.first;     // Catch: Throwable -> L8
        int userId = ((Integer) args.second).intValue();     // Catch: Throwable -> L8
        Drawable drawable = Icon.createWithResource(res.packageName, res.id).loadDrawableAsUser(getContext(), userId);     // Catch: Throwable -> L8
        getBitmap(drawable).compress(Bitmap.CompressFormat.PNG, 100, out);     // Catch: Throwable -> L8
        out.close();     // Catch: Exception -> L6
        return;
    L8:
        th = move-exception;
        out.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Exception -> L6
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "Error retrieving icon for uri: " + uri, e);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String mode) {
        IconsUriHelper.ResourceInfo res = IconsUriHelper.getInstance().getResourceInfo(uri);
        if (res != null) goto L16;
        Log.e(TAG, "No icon found for uri: " + uri);
        return null;
    L16:
        Pair<IconsUriHelper.ResourceInfo, Integer> args = new Pair(res, Integer.valueOf(UserHandle.getCallingUserId()));     // Catch: IOException -> L12
        Uri uri2 = uri;
        return openPipeHelper(uri2, MIME_TYPE, null, args, this.mWriter);
    L10:
        e = move-exception;
        IOException e = e;
    L14:
        Log.e(TAG, "Error opening pipe helper for icon at uri: " + uri2, e);
        return null;
    L12:
        e = move-exception;
        uri2 = uri;
        e = e;
        goto L14
    }

    private static Bitmap getBitmap(Drawable drawable) {
        if (drawable.getIntrinsicWidth() <= 0) goto L9;
        if (drawable.getIntrinsicHeight() <= 0) goto L9;
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    L9:
        throw new IllegalStateException("The icon is zero-sized");
    }

    public static boolean sameIcon(Drawable one, Drawable two) {
        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
        getBitmap(one).compress(Bitmap.CompressFormat.PNG, 100, stream1);
        ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
        getBitmap(two).compress(Bitmap.CompressFormat.PNG, 100, stream2);
        return Arrays.equals(stream1.toByteArray(), stream2.toByteArray());
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return MIME_TYPE;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
