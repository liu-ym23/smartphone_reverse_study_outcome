package androidx.compose.material3.internal.colorUtil;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¨\u0006\u0005"}, d2 = {"lerp", "", "start", "stop", "amount", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Frame_androidKt {
    private static final float lerp(float r100, float r101, float r102) {
        return ((1.0f - r102) * r100) + (r102 * r101);
    }

    public static final /* synthetic */ float access$lerp(float r100, float r101, float r102) {
        return lerp(r100, r101, r102);
    }
}
