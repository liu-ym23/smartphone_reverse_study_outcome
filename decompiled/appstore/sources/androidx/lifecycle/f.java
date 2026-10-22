package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class f implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultLifecycleObserver f3523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleEventObserver f3524b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3525a = null;

        static {
            int[] r10 = new int[Lifecycle.Event.values().length];
            r10[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r10[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r10[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r10[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r10[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r10[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r10[Lifecycle.Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f3525a = r10;
        }
    }

    public f(DefaultLifecycleObserver r10, LifecycleEventObserver r11) {
        kotlin.jvm.internal.q.g(r10, "defaultLifecycleObserver");
        this.f3523a = r10;
        this.f3524b = r11;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        kotlin.jvm.internal.q.g(r10, "source");
        kotlin.jvm.internal.q.g(r11, "event");
        switch(a.f3525a[r11.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L13;
        };
    L7:
        this.f3523a.onDestroy(r10);
        goto L13
    L8:
        this.f3523a.onStop(r10);
        goto L13
    L9:
        this.f3523a.onPause(r10);
        goto L13
    L10:
        this.f3523a.onResume(r10);
        goto L13
    L11:
        this.f3523a.onStart(r10);
        goto L13
    L12:
        this.f3523a.onCreate(r10);
    L13:
        LifecycleEventObserver r12 = this.f3524b;
        if (r12 == null) goto L17;
        r12.onStateChanged(r10, r11);
        return;
    L17:
        return;
    L6:
        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    }
}
