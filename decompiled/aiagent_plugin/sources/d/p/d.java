package d.p;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DurationUnitJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f38678a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f38679b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f38680c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f38681d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f38682e = null;
    public static final d f = null;
    public static final d g = null;
    private static final /* synthetic */ d[] i = null;
    private static final /* synthetic */ d.d.a j = null;
    private final TimeUnit h;

    private static final /* synthetic */ d[] b() {
        return new d[]{f38678a, f38679b, f38680c, f38681d, f38682e, f, g};
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(i.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    private d(String r1, int r2, TimeUnit r3) {
        super(r1, r2);
        this.h = r3;
    }

    public final TimeUnit a() {
        return this.h;
    }

    static {
        f38678a = new d("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f38679b = new d("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        f38680c = new d("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f38681d = new d("SECONDS", 3, TimeUnit.SECONDS);
        f38682e = new d("MINUTES", 4, TimeUnit.MINUTES);
        f = new d("HOURS", 5, TimeUnit.HOURS);
        g = new d("DAYS", 6, TimeUnit.DAYS);
        d[] r0 = b();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
