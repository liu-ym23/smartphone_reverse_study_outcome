package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BlendModeColorFilterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: BlendModeColorFilterCompat.java */
    static class a {
        static ColorFilter a(int r3, Object r4) {
            return new BlendModeColorFilter(r3, (BlendMode) ZeusTransformUtils.preCheckCast(r4, BlendMode.class, "com.obric.aiagent.plugin"));
        }
    }

    public static ColorFilter a(int r3, c r4) {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Object r5 = d.a.a(r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return a.a(r3, r5);
    L8:
        PorterDuff.Mode r6 = d.a(r4);
        if (r6 != null) goto L11;
        return null;
    L11:
        return new PorterDuffColorFilter(r3, r6);
    }
}
