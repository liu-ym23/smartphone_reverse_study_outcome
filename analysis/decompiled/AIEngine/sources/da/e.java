package da;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f8418a;

    static {
        new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        f8418a = Executors.newSingleThreadExecutor(new a6.d(4));
    }
}
