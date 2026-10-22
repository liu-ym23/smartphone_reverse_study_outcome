package com.stepos.aiengine.args.result;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleImageBundle;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000bJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000bJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/args/result/InpaintResultBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/args/SingleImageBundle;", "getImage", "()Lcom/stepos/aiengine/args/SingleImageBundle;", "", "getX", "()F", "getY", "getScale", "getWidth", "getHeight", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InpaintResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/args/result/InpaintResultBundle$Companion;", "", "<init>", "()V", "fromBundle", "Lcom/stepos/aiengine/args/result/InpaintResultBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final InpaintResultBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new InpaintResultBundle(bundle);
        }

        public Companion() {
        }
    }

    public InpaintResultBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        this.bundle = bundle;
    }

    public final String getException() {
        return this.bundle.getString("exception");
    }

    public final float getHeight() {
        return this.bundle.getFloat(Const.INTENT_KEY_BACKGROUND_NOTIFICATION, 0.0f);
    }

    public final SingleImageBundle getImage() {
        Bitmap bitmap = (Bitmap) this.bundle.getParcelable("result_bitmap", Bitmap.class);
        if (bitmap == null) {
            return null;
        }
        return SingleImageBundle.Companion.fromBitmap$default(SingleImageBundle.INSTANCE, bitmap, 0, 2, null);
    }

    public final float getScale() {
        return this.bundle.getFloat(ConstConfig.KEY_VIEW_SCALE_PROPERTY, 0.0f);
    }

    public final float getWidth() {
        return this.bundle.getFloat("w", 0.0f);
    }

    public final float getX() {
        return this.bundle.getFloat("x", 0.0f);
    }

    public final float getY() {
        return this.bundle.getFloat("y", 0.0f);
    }

    public final boolean hasException() {
        return this.bundle.containsKey("exception");
    }
}
