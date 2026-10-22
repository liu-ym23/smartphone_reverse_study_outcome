package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public IconCompatParcelizer() {
    }

    public static IconCompat read(androidx.versionedparcelable.a r4) {
        IconCompat r0 = new IconCompat();
        r0.f1199a = r4.b(r0.f1199a, 1);
        r0.f1201c = r4.b(r0.f1201c, 2);
        r0.f1202d = r4.b(r0.f1202d, 3);
        r0.f1203e = r4.b(r0.f1203e, 4);
        r0.f = r4.b(r0.f, 5);
        r0.g = (ColorStateList) ZeusTransformUtils.preCheckCast(r4.b(r0.g, 6), ColorStateList.class, "com.obric.aiagent.plugin");
        r0.j = r4.b(r0.j, 7);
        r0.k = r4.b(r0.k, 8);
        r0.g();
        return r0;
    }

    public static void write(IconCompat r3, androidx.versionedparcelable.a r4) {
        r4.a(true, true);
        r3.a(r4.a());
        if ((-1) == r3.f1199a) goto L6;
        r4.a(r3.f1199a, 1);
    L6:
        if (r3.f1201c == null) goto L9;
        r4.a(r3.f1201c, 2);
    L9:
        if (r3.f1202d == null) goto L12;
        r4.a(r3.f1202d, 3);
    L12:
        if (r3.f1203e == 0) goto L15;
        r4.a(r3.f1203e, 4);
    L15:
        if (r3.f == 0) goto L18;
        r4.a(r3.f, 5);
    L18:
        if (r3.g == null) goto L21;
        r4.a(r3.g, 6);
    L21:
        if (r3.j == null) goto L24;
        r4.a(r3.j, 7);
    L24:
        if (r3.k == null) goto L27;
        r4.a(r3.k, 8);
        return;
    }
}
