package e8;

import com.autonavi.aps.amapapi.config.Const;
import eb.InterfaceC4021a;
import eb.f;
import eb.g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00150\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Le8/c;", "", "<init>", "()V", "Le8/b;", "config", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Le8/b;)V", "", Const.INTENT_KEY_PKGNAME, "Z", "initialized", "Leb/a;", "c", "Leb/a;", "initMutex", Const.INTENT_KEY_UMID, "Le8/b;", "currentConfig", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/g;", "e", "Ljava/util/concurrent/atomic/AtomicReference;", "currentJob", "Leb/g;", "f", "Leb/g;", "globalSemaphore", "Ljava/util/concurrent/ConcurrentHashMap;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/concurrent/ConcurrentHashMap;", "concurrentJobs", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: e8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4011c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static boolean initialized;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static g globalSemaphore;

    /* renamed from: a, reason: collision with root package name */
    public static final C4011c f32340a = new C4011c();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final InterfaceC4021a initMutex = f.b(false, 1, null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static UploadConfig currentConfig = new UploadConfig(null, null, null, null, null, false, null, 0, 0, 511, null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final AtomicReference<kotlinx.coroutines.g> currentJob = new AtomicReference<>(null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentHashMap<String, kotlinx.coroutines.g> concurrentJobs = new ConcurrentHashMap<>();

    public final void a(UploadConfig config) {
        p.i(config, "config");
        currentConfig = config;
        initialized = false;
        globalSemaphore = null;
    }
}
