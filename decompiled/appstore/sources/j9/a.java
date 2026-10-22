package j9;

import android.content.res.Resources;
import android.util.TypedValue;
import yf.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f20948b = 0;

    static {
        f20947a = new a();
        f20948b = b.b(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics()));
    }

    public a() {
    }

    public final int a() {
        return f20948b;
    }
}
