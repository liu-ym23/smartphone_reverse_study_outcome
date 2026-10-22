package com.bytedance.als.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/als/monitor/ComponentLifecycle;", "", "ON_INIT", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "als_release"}, k = 1, mv = {1, 4, 1})
public final enum ComponentLifecycle extends Enum<ComponentLifecycle> {
    public static final ComponentLifecycle ON_CREATE = null;
    public static final ComponentLifecycle ON_DESTROY = null;
    public static final ComponentLifecycle ON_INIT = null;
    public static final ComponentLifecycle ON_PAUSE = null;
    public static final ComponentLifecycle ON_RESUME = null;
    public static final ComponentLifecycle ON_START = null;
    public static final ComponentLifecycle ON_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentLifecycle[] f38096a = null;

    static {
        ComponentLifecycle r100 = new ComponentLifecycle("ON_INIT", 0);
        ON_INIT = r100;
        ComponentLifecycle r101 = new ComponentLifecycle("ON_CREATE", 1);
        ON_CREATE = r101;
        ComponentLifecycle r102 = new ComponentLifecycle("ON_START", 2);
        ON_START = r102;
        ComponentLifecycle r103 = new ComponentLifecycle("ON_RESUME", 3);
        ON_RESUME = r103;
        ComponentLifecycle r104 = new ComponentLifecycle("ON_PAUSE", 4);
        ON_PAUSE = r104;
        ComponentLifecycle r105 = new ComponentLifecycle("ON_STOP", 5);
        ON_STOP = r105;
        ComponentLifecycle r106 = new ComponentLifecycle("ON_DESTROY", 6);
        ON_DESTROY = r106;
        f38096a = new ComponentLifecycle[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ComponentLifecycle valueOf(String r100) {
        return (ComponentLifecycle) a.a(ComponentLifecycle.class, r100);
    }

    public static ComponentLifecycle[] values() {
        return (ComponentLifecycle[]) f38096a.clone();
    }

    public ComponentLifecycle(String r100, int r101) {
        super(r100, r101);
    }
}
