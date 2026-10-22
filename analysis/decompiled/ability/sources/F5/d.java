package F5;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f551a;

    static {
        new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        f551a = Executors.newSingleThreadExecutor(new A4.b(1));
    }
}
