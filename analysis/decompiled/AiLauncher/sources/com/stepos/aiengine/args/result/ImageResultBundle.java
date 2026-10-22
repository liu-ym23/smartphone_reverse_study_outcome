package com.stepos.aiengine.args.result;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/aiengine/args/result/ImageResultBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "", "getWidth", "()I", "getHeight", "getFormat", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_RESULT_BITMAP = "result_bitmap";
    public static final String KEY_RESULT_FORMAT = "result_format";
    public static final String KEY_RESULT_HEIGHT = "result_height";
    public static final String KEY_RESULT_WIDTH = "result_width";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/args/result/ImageResultBundle$Companion;", "", "<init>", "()V", "KEY_RESULT_BITMAP", "", "KEY_RESULT_WIDTH", "KEY_RESULT_HEIGHT", "KEY_RESULT_FORMAT", "fromBundle", "Lcom/stepos/aiengine/args/result/ImageResultBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final ImageResultBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new ImageResultBundle(bundle, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ ImageResultBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final Bitmap getBitmap() {
        return (Bitmap) this.bundle.getParcelable("result_bitmap");
    }

    public final String getException() {
        return this.bundle.getString("exception");
    }

    public final int getFormat() {
        return this.bundle.getInt("result_format", 0);
    }

    public final int getHeight() {
        return this.bundle.getInt("result_height", 0);
    }

    public final int getWidth() {
        return this.bundle.getInt("result_width", 0);
    }

    public final boolean hasException() {
        return this.bundle.containsKey("exception");
    }

    public ImageResultBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
