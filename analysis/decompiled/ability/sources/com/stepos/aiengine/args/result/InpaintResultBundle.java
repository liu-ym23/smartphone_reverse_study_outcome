package com.stepos.aiengine.args.result;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleImageBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000bJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000bJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/aiengine/args/result/InpaintResultBundle;", "", "Landroid/os/Bundle;", "bundle", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/args/SingleImageBundle;", "getImage", "()Lcom/stepos/aiengine/args/SingleImageBundle;", "", "getX", "()F", "getY", "getScale", "getWidth", "getHeight", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InpaintResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3502a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/aiengine/args/result/InpaintResultBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/args/result/InpaintResultBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/result/InpaintResultBundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final InpaintResultBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new InpaintResultBundle(bundle);
        }
    }

    public InpaintResultBundle(Bundle bundle) {
        k.f(bundle, "bundle");
        this.f3502a = bundle;
    }

    public final String getException() {
        return this.f3502a.getString("exception");
    }

    public final float getHeight() {
        return this.f3502a.getFloat("h", 0.0f);
    }

    public final SingleImageBundle getImage() {
        Bitmap bitmap = (Bitmap) this.f3502a.getParcelable(ImageResultBundle.KEY_RESULT_BITMAP, Bitmap.class);
        if (bitmap == null) {
            return null;
        }
        return SingleImageBundle.Companion.fromBitmap$default(SingleImageBundle.INSTANCE, bitmap, 0, 2, null);
    }

    public final float getScale() {
        return this.f3502a.getFloat("scale", 0.0f);
    }

    public final float getWidth() {
        return this.f3502a.getFloat("w", 0.0f);
    }

    public final float getX() {
        return this.f3502a.getFloat("x", 0.0f);
    }

    public final float getY() {
        return this.f3502a.getFloat("y", 0.0f);
    }

    public final boolean hasException() {
        return this.f3502a.containsKey("exception");
    }
}
