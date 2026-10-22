package tc;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final ColorMatrixColorFilter a(int r10) {
        return new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r10), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r10), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r10), 0.0f, 0.0f, 0.0f, (Color.alpha(r10) * 1.0f) / PrivateKeyType.INVALID, 0.0f});
    }
}
