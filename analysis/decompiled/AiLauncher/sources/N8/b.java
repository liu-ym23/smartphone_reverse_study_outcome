package N8;

import android.content.Context;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f4889a;

    public b(float f10) {
        this.f4889a = f10;
    }

    public static b a(Context context) {
        return new b(context.getResources().getDisplayMetrics().density);
    }

    public int b(int i10) {
        return (int) ((i10 * this.f4889a) + 0.5f);
    }
}
