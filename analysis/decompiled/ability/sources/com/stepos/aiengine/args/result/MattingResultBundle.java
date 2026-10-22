package com.stepos.aiengine.args.result;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleImageBundle;
import com.stepos.aiengine.data.ContourHierarchy;
import com.stepos.aiengine.data.ImageContour;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\f¢\u0006\u0004\b\u0012\u0010\u000fJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/stepos/aiengine/args/result/MattingResultBundle;", "", "Landroid/os/Bundle;", "bundle", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/args/SingleImageBundle;", "getImage", "()Lcom/stepos/aiengine/args/SingleImageBundle;", "Landroid/graphics/Rect;", "getRegion", "()Landroid/graphics/Rect;", "", "Lcom/stepos/aiengine/data/ImageContour;", "getContours", "()Ljava/util/List;", "Lcom/stepos/aiengine/data/ContourHierarchy;", "Lcom/stepos/aiengine/data/OpenCVHierarchy;", "getHierarchies", "", "getProportion", "()F", "", "getSampleSize", "()I", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MattingResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3503a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/aiengine/args/result/MattingResultBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/args/result/MattingResultBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/result/MattingResultBundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final MattingResultBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new MattingResultBundle(bundle);
        }
    }

    public MattingResultBundle(Bundle bundle) {
        k.f(bundle, "bundle");
        this.f3503a = bundle;
    }

    public final List<ImageContour> getContours() {
        int[] intArray = this.f3503a.getIntArray("mat_contours");
        if (intArray != null && intArray.length != 0) {
            ArrayList arrayList = new ArrayList();
            int i = intArray[0];
            int i6 = 1;
            int i10 = 0;
            while (i10 < i) {
                int i11 = i6 + 1;
                int i12 = intArray[i6];
                ArrayList arrayList2 = new ArrayList(i12);
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = i11 + 1;
                    int i15 = intArray[i11];
                    i11 += 2;
                    arrayList2.add(new Point(i15, intArray[i14]));
                }
                arrayList.add(new ImageContour(arrayList2));
                i10++;
                i6 = i11;
            }
            return arrayList;
        }
        return EmptyList.f4893a;
    }

    public final String getException() {
        return this.f3503a.getString("exception");
    }

    public final List<ContourHierarchy> getHierarchies() {
        int[] intArray = this.f3503a.getIntArray("mat_hierarchies");
        if (intArray != null && intArray.length % 4 == 0) {
            int length = intArray.length / 4;
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                int i6 = i * 4;
                arrayList.add(new ContourHierarchy(intArray[i6], intArray[i6 + 1], intArray[i6 + 2], intArray[i6 + 3]));
            }
            return arrayList;
        }
        return EmptyList.f4893a;
    }

    public final SingleImageBundle getImage() {
        Bitmap bitmap = (Bitmap) this.f3503a.getParcelable(ImageResultBundle.KEY_RESULT_BITMAP, Bitmap.class);
        if (bitmap == null) {
            return null;
        }
        return SingleImageBundle.Companion.fromBitmap$default(SingleImageBundle.INSTANCE, bitmap, 0, 2, null);
    }

    public final float getProportion() {
        return this.f3503a.getFloat("mat_proportion", 0.0f);
    }

    public final Rect getRegion() {
        int[] intArray = this.f3503a.getIntArray("mat_region");
        if (intArray != null && intArray.length >= 4) {
            return new Rect(intArray[0], intArray[1], intArray[2], intArray[3]);
        }
        return null;
    }

    public final int getSampleSize() {
        return this.f3503a.getInt("mat_sample_size", 1);
    }

    public final boolean hasException() {
        return this.f3503a.containsKey("exception");
    }
}
