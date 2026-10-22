package com.stepos.aiengine.args.result;

import Z8.C1173v;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleImageBundle;
import com.stepos.aiengine.data.ContourHierarchy;
import com.stepos.aiengine.data.ImageContour;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\t¢\u0006\u0004\b\u000f\u0010\fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/args/result/SegmentResultBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/args/SingleImageBundle;", "getImage", "()Lcom/stepos/aiengine/args/SingleImageBundle;", "", "Lcom/stepos/aiengine/data/ImageContour;", "getContours", "()Ljava/util/List;", "Lcom/stepos/aiengine/data/ContourHierarchy;", "Lcom/stepos/aiengine/data/OpenCVHierarchy;", "getHierarchies", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SegmentResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/args/result/SegmentResultBundle$Companion;", "", "<init>", "()V", "fromBundle", "Lcom/stepos/aiengine/args/result/SegmentResultBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SegmentResultBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new SegmentResultBundle(bundle);
        }

        public Companion() {
        }
    }

    public SegmentResultBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        this.bundle = bundle;
    }

    public final List<ImageContour> getContours() {
        return C1173v.m();
    }

    public final String getException() {
        return this.bundle.getString("exception");
    }

    public final List<ContourHierarchy> getHierarchies() {
        return C1173v.m();
    }

    public final SingleImageBundle getImage() {
        Bitmap bitmap = (Bitmap) this.bundle.getParcelable("result_bitmap", Bitmap.class);
        if (bitmap == null) {
            return null;
        }
        return SingleImageBundle.Companion.fromBitmap$default(SingleImageBundle.INSTANCE, bitmap, 0, 2, null);
    }

    public final boolean hasException() {
        return this.bundle.containsKey("exception");
    }
}
