package com.stepos.aiengine.args.result;

import Z8.C1173v;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleImageBundle;
import com.stepos.aiengine.data.ContourHierarchy;
import com.stepos.aiengine.data.ImageContour;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\f¢\u0006\u0004\b\u0012\u0010\u000fJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/args/result/MattingResultBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/args/SingleImageBundle;", "getImage", "()Lcom/stepos/aiengine/args/SingleImageBundle;", "Landroid/graphics/Rect;", "getRegion", "()Landroid/graphics/Rect;", "", "Lcom/stepos/aiengine/data/ImageContour;", "getContours", "()Ljava/util/List;", "Lcom/stepos/aiengine/data/ContourHierarchy;", "Lcom/stepos/aiengine/data/OpenCVHierarchy;", "getHierarchies", "", "getProportion", "()F", "", "getSampleSize", "()I", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MattingResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/args/result/MattingResultBundle$Companion;", "", "<init>", "()V", "fromBundle", "Lcom/stepos/aiengine/args/result/MattingResultBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final MattingResultBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new MattingResultBundle(bundle);
        }

        public Companion() {
        }
    }

    public MattingResultBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        this.bundle = bundle;
    }

    public final List<ImageContour> getContours() {
        int[] intArray = this.bundle.getIntArray("mat_contours");
        if (intArray != null && intArray.length != 0) {
            ArrayList arrayList = new ArrayList();
            int i10 = intArray[0];
            int i11 = 1;
            int i12 = 0;
            while (i12 < i10) {
                int i13 = i11 + 1;
                int i14 = intArray[i11];
                ArrayList arrayList2 = new ArrayList(i14);
                for (int i15 = 0; i15 < i14; i15++) {
                    int i16 = i13 + 1;
                    int i17 = intArray[i13];
                    i13 += 2;
                    arrayList2.add(new Point(i17, intArray[i16]));
                }
                arrayList.add(new ImageContour(arrayList2));
                i12++;
                i11 = i13;
            }
            return arrayList;
        }
        return C1173v.m();
    }

    public final String getException() {
        return this.bundle.getString("exception");
    }

    public final List<ContourHierarchy> getHierarchies() {
        int[] intArray = this.bundle.getIntArray("mat_hierarchies");
        if (intArray != null && intArray.length % 4 == 0) {
            int length = intArray.length / 4;
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 4;
                arrayList.add(new ContourHierarchy(intArray[i11], intArray[i11 + 1], intArray[i11 + 2], intArray[i11 + 3]));
            }
            return arrayList;
        }
        return C1173v.m();
    }

    public final SingleImageBundle getImage() {
        Bitmap bitmap = (Bitmap) this.bundle.getParcelable("result_bitmap", Bitmap.class);
        if (bitmap == null) {
            return null;
        }
        return SingleImageBundle.Companion.fromBitmap$default(SingleImageBundle.INSTANCE, bitmap, 0, 2, null);
    }

    public final float getProportion() {
        return this.bundle.getFloat("mat_proportion", 0.0f);
    }

    public final Rect getRegion() {
        int[] intArray = this.bundle.getIntArray("mat_region");
        if (intArray != null && intArray.length >= 4) {
            return new Rect(intArray[0], intArray[1], intArray[2], intArray[3]);
        }
        return null;
    }

    public final int getSampleSize() {
        return this.bundle.getInt("mat_sample_size", 1);
    }

    public final boolean hasException() {
        return this.bundle.containsKey("exception");
    }
}
