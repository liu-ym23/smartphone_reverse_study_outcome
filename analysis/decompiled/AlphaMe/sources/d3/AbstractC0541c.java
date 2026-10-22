package d3;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: d3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0541c {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f12447a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        f12447a = method;
    }
}
