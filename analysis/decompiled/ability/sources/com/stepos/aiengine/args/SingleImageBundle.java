package com.stepos.aiengine.args;

import B7.a;
import C7.c;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\bJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/aiengine/args/SingleImageBundle;", "", "Landroid/os/Bundle;", "bundle", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;)V", "()V", "toBundle", "()Landroid/os/Bundle;", "", "getRotateAngle", "()I", "getBundle", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", MattingOptionBundle.KEY_ROTATE_ANGLE, "LC7/r;", "putUri", "(Landroid/content/Context;Landroid/net/Uri;I)V", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SingleImageBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_BITMAP = "bitmap";
    public static final String KEY_BITMAP_HEIGHT = "bitmap.h";
    public static final String KEY_BITMAP_WIDTH = "bitmap.w";
    public static final String KEY_FILE_DESCRIPTOR = "file_descriptor";
    public static final String KEY_ROTATE_ANGLE = "rotate_angle";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3496a;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\bJ)\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u001d¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/args/SingleImageBundle$Companion;", "", "Landroid/graphics/Bitmap;", "bitmap", "", MattingOptionBundle.KEY_ROTATE_ANGLE, "Lcom/stepos/aiengine/args/SingleImageBundle;", "fromBitmap", "(Landroid/graphics/Bitmap;I)Lcom/stepos/aiengine/args/SingleImageBundle;", "", SingleFileBundle.KEY_PATH, "fromPath", "(Ljava/lang/String;I)Lcom/stepos/aiengine/args/SingleImageBundle;", "Landroid/os/ParcelFileDescriptor;", SingleFileBundle.KEY_FILE_DESCRIPTOR, "fromFileDescriptor", "(Landroid/os/ParcelFileDescriptor;I)Lcom/stepos/aiengine/args/SingleImageBundle;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "fromUri", "(Landroid/content/Context;Landroid/net/Uri;I)Lcom/stepos/aiengine/args/SingleImageBundle;", "Landroid/os/Bundle;", "bundle", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/SingleImageBundle;", TypedValues.TransitionType.S_FROM, "KEY_BITMAP", "Ljava/lang/String;", "KEY_FILE_DESCRIPTOR", "KEY_BITMAP_WIDTH", "KEY_BITMAP_HEIGHT", "KEY_ROTATE_ANGLE", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public static /* synthetic */ SingleImageBundle from$default(Companion companion, Bitmap bitmap, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i = 0;
            }
            return companion.from(bitmap, i);
        }

        public static /* synthetic */ SingleImageBundle fromBitmap$default(Companion companion, Bitmap bitmap, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i = 0;
            }
            return companion.fromBitmap(bitmap, i);
        }

        public static /* synthetic */ SingleImageBundle fromFileDescriptor$default(Companion companion, ParcelFileDescriptor parcelFileDescriptor, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i = 0;
            }
            return companion.fromFileDescriptor(parcelFileDescriptor, i);
        }

        public static /* synthetic */ SingleImageBundle fromPath$default(Companion companion, String str, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i = 0;
            }
            return companion.fromPath(str, i);
        }

        public static /* synthetic */ SingleImageBundle fromUri$default(Companion companion, Context context, Uri uri, int i, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                i = 0;
            }
            return companion.fromUri(context, uri, i);
        }

        public final SingleImageBundle from(Context context, Uri uri) {
            k.f(context, "context");
            k.f(uri, "uri");
            return from$default(this, context, uri, 0, 4, null);
        }

        public final SingleImageBundle fromBitmap(Bitmap bitmap, int rotateAngle) {
            k.f(bitmap, "bitmap");
            Bundle bundle = new Bundle();
            bundle.putParcelable("bitmap", bitmap);
            bundle.putInt(SingleImageBundle.KEY_BITMAP_WIDTH, bitmap.getWidth());
            bundle.putInt(SingleImageBundle.KEY_BITMAP_HEIGHT, bitmap.getHeight());
            bundle.putInt(SingleImageBundle.KEY_ROTATE_ANGLE, rotateAngle);
            return new SingleImageBundle(bundle);
        }

        public final SingleImageBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new SingleImageBundle(bundle);
        }

        public final SingleImageBundle fromFileDescriptor(ParcelFileDescriptor fd, int rotateAngle) {
            k.f(fd, "fd");
            Bundle bundle = new Bundle();
            bundle.putParcelable(SingleImageBundle.KEY_FILE_DESCRIPTOR, fd);
            bundle.putInt(SingleImageBundle.KEY_ROTATE_ANGLE, rotateAngle);
            return new SingleImageBundle(bundle);
        }

        @c
        public final SingleImageBundle fromPath(String path, int rotateAngle) {
            k.f(path, "path");
            Bundle bundle = new Bundle();
            bundle.putString(SingleFileBundle.KEY_PATH, path);
            bundle.putInt(SingleImageBundle.KEY_ROTATE_ANGLE, rotateAngle);
            return new SingleImageBundle(bundle);
        }

        public final SingleImageBundle fromUri(Context context, Uri uri, int rotateAngle) throws FileNotFoundException {
            k.f(context, "context");
            k.f(uri, "uri");
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                return fromFileDescriptor(parcelFileDescriptorOpenFileDescriptor, rotateAngle);
            }
            throw new IllegalArgumentException(a.j("Cannot open URI: ", uri));
        }

        public static /* synthetic */ SingleImageBundle from$default(Companion companion, Context context, Uri uri, int i, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                i = 0;
            }
            return companion.from(context, uri, i);
        }

        public final SingleImageBundle from(Bitmap bitmap) {
            k.f(bitmap, "bitmap");
            return from$default(this, bitmap, 0, 2, null);
        }

        public final SingleImageBundle from(Bitmap bitmap, int rotateAngle) {
            k.f(bitmap, "bitmap");
            return fromBitmap(bitmap, rotateAngle);
        }

        public final SingleImageBundle from(Context context, Uri uri, int rotateAngle) {
            k.f(context, "context");
            k.f(uri, "uri");
            return fromUri(context, uri, rotateAngle);
        }
    }

    public SingleImageBundle(Bundle bundle) {
        k.f(bundle, "bundle");
        this.f3496a = bundle;
    }

    public static final SingleImageBundle from(Context context, Uri uri) {
        return INSTANCE.from(context, uri);
    }

    public static /* synthetic */ void putUri$default(SingleImageBundle singleImageBundle, Context context, Uri uri, int i, int i6, Object obj) throws FileNotFoundException {
        if ((i6 & 4) != 0) {
            i = 0;
        }
        singleImageBundle.putUri(context, uri, i);
    }

    public final Bundle getBundle() {
        return toBundle();
    }

    public final int getRotateAngle() {
        return this.f3496a.getInt(KEY_ROTATE_ANGLE, 0);
    }

    public final void putUri(Context context, Uri uri, int rotateAngle) throws FileNotFoundException {
        k.f(context, "context");
        k.f(uri, "uri");
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            throw new IllegalArgumentException(a.j("Cannot open URI: ", uri));
        }
        Bundle bundle = this.f3496a;
        bundle.putParcelable(KEY_FILE_DESCRIPTOR, parcelFileDescriptorOpenFileDescriptor);
        bundle.putInt(KEY_ROTATE_ANGLE, rotateAngle);
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3496a);
    }

    public SingleImageBundle() {
        this(new Bundle());
    }

    public static final SingleImageBundle from(Context context, Uri uri, int i) {
        return INSTANCE.from(context, uri, i);
    }

    public static final SingleImageBundle from(Bitmap bitmap) {
        return INSTANCE.from(bitmap);
    }

    public static final SingleImageBundle from(Bitmap bitmap, int i) {
        return INSTANCE.from(bitmap, i);
    }
}
