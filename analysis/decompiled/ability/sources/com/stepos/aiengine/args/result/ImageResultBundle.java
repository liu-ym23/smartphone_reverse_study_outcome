package com.stepos.aiengine.args.result;

import android.graphics.Bitmap;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/args/result/ImageResultBundle;", "", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "", "getWidth", "()I", "getHeight", "getFormat", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_RESULT_BITMAP = "result_bitmap";
    public static final String KEY_RESULT_FORMAT = "result_format";
    public static final String KEY_RESULT_HEIGHT = "result_height";
    public static final String KEY_RESULT_WIDTH = "result_width";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3501a;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/args/result/ImageResultBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/args/result/ImageResultBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/result/ImageResultBundle;", "", "KEY_RESULT_BITMAP", "Ljava/lang/String;", "KEY_RESULT_WIDTH", "KEY_RESULT_HEIGHT", "KEY_RESULT_FORMAT", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final ImageResultBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new ImageResultBundle(bundle, null);
        }
    }

    public ImageResultBundle(Bundle bundle, e eVar) {
        this.f3501a = bundle;
    }

    public final Bitmap getBitmap() {
        return (Bitmap) this.f3501a.getParcelable(KEY_RESULT_BITMAP);
    }

    public final String getException() {
        return this.f3501a.getString("exception");
    }

    public final int getFormat() {
        return this.f3501a.getInt(KEY_RESULT_FORMAT, 0);
    }

    public final int getHeight() {
        return this.f3501a.getInt(KEY_RESULT_HEIGHT, 0);
    }

    public final int getWidth() {
        return this.f3501a.getInt(KEY_RESULT_WIDTH, 0);
    }

    public final boolean hasException() {
        return this.f3501a.containsKey("exception");
    }
}
