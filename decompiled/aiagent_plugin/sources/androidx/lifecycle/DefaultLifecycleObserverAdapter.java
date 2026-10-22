package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DefaultLifecycleObserverAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f1919b;

    /* JADX INFO: compiled from: DefaultLifecycleObserverAdapter.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1920a = null;

        static {
            int[] r0 = new int[i.a.values().length];
            r0[i.a.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[i.a.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[i.a.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[i.a.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[i.a.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[i.a.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[i.a.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f1920a = r0;
        }
    }

    public DefaultLifecycleObserverAdapter(d r3, m r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "defaultLifecycleObserver");
        this.f1918a = r5;
        this.f1919b = r6;
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r3, i.a r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "event");
        switch(a.f1920a[r4.ordinal()]) {
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
        this.f1918a.e(r5);
        goto L13
    L8:
        this.f1918a.d(r5);
        goto L13
    L9:
        this.f1918a.c(r5);
        goto L13
    L10:
        this.f1918a.onResume(r5);
        goto L13
    L11:
        this.f1918a.b(r5);
        goto L13
    L12:
        this.f1918a.a(r5);
    L13:
        m r2 = this.f1919b;
        if (r2 == null) goto L17;
        r2.onStateChanged(r5, r4);
        return;
    L17:
        return;
    L6:
        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    }
}
