package V0;

import android.graphics.Bitmap;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1928a;

    /* renamed from: b, reason: collision with root package name */
    public final float f1929b;

    /* renamed from: c, reason: collision with root package name */
    public final Bitmap f1930c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1931d;

    public a(String simpleText, float f4, Bitmap imgWithBox, ArrayList outputRawResult) {
        Intrinsics.checkNotNullParameter(simpleText, "simpleText");
        Intrinsics.checkNotNullParameter(imgWithBox, "imgWithBox");
        Intrinsics.checkNotNullParameter(outputRawResult, "outputRawResult");
        this.f1928a = simpleText;
        this.f1929b = f4;
        this.f1930c = imgWithBox;
        this.f1931d = outputRawResult;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f1928a, aVar.f1928a) && Float.compare(this.f1929b, aVar.f1929b) == 0 && Intrinsics.areEqual(this.f1930c, aVar.f1930c) && Intrinsics.areEqual(this.f1931d, aVar.f1931d);
    }

    public final int hashCode() {
        return this.f1931d.hashCode() + ((this.f1930c.hashCode() + ((Float.hashCode(this.f1929b) + (this.f1928a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "OcrResult(simpleText=" + this.f1928a + ", inferenceTime=" + this.f1929b + ", imgWithBox=" + this.f1930c + ", outputRawResult=" + this.f1931d + ")";
    }
}
