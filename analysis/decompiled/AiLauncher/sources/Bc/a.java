package Bc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f1577a;

    public static Context a() {
        Context context = f1577a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("Please call `#init(Context)` method to initialize jLatexMath");
    }

    public static InputStream b(String str) {
        try {
            return a().getAssets().open("org/scilab/forge/jlatexmath/" + str);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void c(Context context) {
        f1577a = context.getApplicationContext();
    }

    public static Typeface d(String str) {
        return Typeface.createFromAsset(a().getAssets(), "org/scilab/forge/jlatexmath/" + str);
    }
}
