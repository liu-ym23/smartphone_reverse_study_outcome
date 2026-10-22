package com.stepos.aiengine.args;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.autonavi.aps.amapapi.config.Const;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\bJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/args/SingleImageBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "()V", "toBundle", "()Landroid/os/Bundle;", "", "getRotateAngle", "()I", "getBundle", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", MattingOptionBundle.KEY_ROTATE_ANGLE, "LY8/t;", "putUri", "(Landroid/content/Context;Landroid/net/Uri;I)V", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SingleImageBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_BITMAP = "bitmap";
    public static final String KEY_BITMAP_HEIGHT = "bitmap.h";
    public static final String KEY_BITMAP_WIDTH = "bitmap.w";
    public static final String KEY_FILE_DESCRIPTOR = "file_descriptor";
    public static final String KEY_ROTATE_ANGLE = "rotate_angle";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/stepos/aiengine/args/SingleImageBundle$Companion;", "", "<init>", "()V", "KEY_BITMAP", "", "KEY_FILE_DESCRIPTOR", "KEY_BITMAP_WIDTH", "KEY_BITMAP_HEIGHT", "KEY_ROTATE_ANGLE", "fromBitmap", "Lcom/stepos/aiengine/args/SingleImageBundle;", "bitmap", "Landroid/graphics/Bitmap;", MattingOptionBundle.KEY_ROTATE_ANGLE, "", "fromPath", "path", "fromFileDescriptor", SingleFileBundle.KEY_FILE_DESCRIPTOR, "Landroid/os/ParcelFileDescriptor;", "fromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "fromBundle", "bundle", "Landroid/os/Bundle;", "from", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ SingleImageBundle from$default(Companion companion, Bitmap bitmap, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return companion.from(bitmap, i10);
        }

        public static /* synthetic */ SingleImageBundle fromBitmap$default(Companion companion, Bitmap bitmap, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return companion.fromBitmap(bitmap, i10);
        }

        public static /* synthetic */ SingleImageBundle fromFileDescriptor$default(Companion companion, ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return companion.fromFileDescriptor(parcelFileDescriptor, i10);
        }

        public static /* synthetic */ SingleImageBundle fromPath$default(Companion companion, String str, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return companion.fromPath(str, i10);
        }

        public static /* synthetic */ SingleImageBundle fromUri$default(Companion companion, Context context, Uri uri, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i10 = 0;
            }
            return companion.fromUri(context, uri, i10);
        }

        public final SingleImageBundle from(Context context, Uri uri) {
            p.i(context, "context");
            p.i(uri, "uri");
            return from$default(this, context, uri, 0, 4, null);
        }

        public final SingleImageBundle fromBitmap(Bitmap bitmap, int rotateAngle) {
            p.i(bitmap, "bitmap");
            Bundle bundle = new Bundle();
            bundle.putParcelable("bitmap", bitmap);
            bundle.putInt(SingleImageBundle.KEY_BITMAP_WIDTH, bitmap.getWidth());
            bundle.putInt(SingleImageBundle.KEY_BITMAP_HEIGHT, bitmap.getHeight());
            bundle.putInt("rotate_angle", rotateAngle);
            return new SingleImageBundle(bundle);
        }

        public final SingleImageBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new SingleImageBundle(bundle);
        }

        public final SingleImageBundle fromFileDescriptor(ParcelFileDescriptor fd, int rotateAngle) {
            p.i(fd, "fd");
            Bundle bundle = new Bundle();
            bundle.putParcelable("file_descriptor", fd);
            bundle.putInt("rotate_angle", rotateAngle);
            return new SingleImageBundle(bundle);
        }

        public final SingleImageBundle fromPath(String path, int rotateAngle) {
            p.i(path, "path");
            Bundle bundle = new Bundle();
            bundle.putString("path", path);
            bundle.putInt("rotate_angle", rotateAngle);
            return new SingleImageBundle(bundle);
        }

        public final SingleImageBundle fromUri(Context context, Uri uri, int rotateAngle) throws FileNotFoundException {
            p.i(context, "context");
            p.i(uri, "uri");
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                return fromFileDescriptor(parcelFileDescriptorOpenFileDescriptor, rotateAngle);
            }
            throw new IllegalArgumentException("Cannot open URI: " + uri);
        }

        public Companion() {
        }

        public static /* synthetic */ SingleImageBundle from$default(Companion companion, Context context, Uri uri, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i10 = 0;
            }
            return companion.from(context, uri, i10);
        }

        public final SingleImageBundle from(Bitmap bitmap) {
            p.i(bitmap, "bitmap");
            return from$default(this, bitmap, 0, 2, null);
        }

        public final SingleImageBundle from(Bitmap bitmap, int rotateAngle) {
            p.i(bitmap, "bitmap");
            return fromBitmap(bitmap, rotateAngle);
        }

        public final SingleImageBundle from(Context context, Uri uri, int rotateAngle) {
            p.i(context, "context");
            p.i(uri, "uri");
            return fromUri(context, uri, rotateAngle);
        }
    }

    public SingleImageBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        this.bundle = bundle;
    }

    public static final SingleImageBundle from(Context context, Uri uri) {
        return INSTANCE.from(context, uri);
    }

    public static /* synthetic */ void putUri$default(SingleImageBundle singleImageBundle, Context context, Uri uri, int i10, int i11, Object obj) throws FileNotFoundException {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        singleImageBundle.putUri(context, uri, i10);
    }

    public final Bundle getBundle() {
        return toBundle();
    }

    public final int getRotateAngle() {
        return this.bundle.getInt("rotate_angle", 0);
    }

    public final void putUri(Context context, Uri uri, int rotateAngle) throws FileNotFoundException {
        p.i(context, "context");
        p.i(uri, "uri");
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            this.bundle.putParcelable("file_descriptor", parcelFileDescriptorOpenFileDescriptor);
            this.bundle.putInt("rotate_angle", rotateAngle);
        } else {
            throw new IllegalArgumentException("Cannot open URI: " + uri);
        }
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public SingleImageBundle() {
        this(new Bundle());
    }

    public static final SingleImageBundle from(Context context, Uri uri, int i10) {
        return INSTANCE.from(context, uri, i10);
    }

    public static final SingleImageBundle from(Bitmap bitmap) {
        return INSTANCE.from(bitmap);
    }

    public static final SingleImageBundle from(Bitmap bitmap, int i10) {
        return INSTANCE.from(bitmap, i10);
    }
}
