package com.android.ttcjpaysdk.base.utils;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes28.dex */
public abstract class CJPayDebouncingOnClickListener implements View.OnClickListener {
    static final long DEFAULT_INTERVAL = 500;
    private static final Runnable ENABLE_AGAIN = null;
    static boolean enabled = true;
    private IHandler finalHandler;
    private List<IHandler> interceptorHandlers;
    private long interval;

    public interface IHandler {
        void handle(View r100);
    }

    public interface Interceptor extends IHandler {
        boolean match(View r100);
    }

    public abstract void doClick(View r100);

    static {
        ENABLE_AGAIN = new AnonymousClass1();
    }

    public CJPayDebouncingOnClickListener() {
        this(500);
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public long getInterval() {
        return this.interval;
    }

    public CJPayDebouncingOnClickListener(long r100) {
        this.interval = r100;
    }

    private boolean handleInterceptor(View r100) {
        List<IHandler> r101 = this.interceptorHandlers;
        if (r101 != null) goto L5;
        return true;
    L5:
        Iterator<IHandler> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L20;
        IHandler r103 = r102.next();
        if (r103 == null) goto L7;
        if (r103.getClass().isAssignableFrom(IHandler.class) == true) goto L13;
        if ((r103 instanceof Interceptor) == false) goto L7;
        if (((Interceptor) r103).match(r100) == false) goto L7;
        r103.handle(r100);
        return false;
    L13:
        r103.handle(r100);
        goto L7
    L20:
        return true;
    }

    private void onFinal(View r100) {
        IHandler r101 = this.finalHandler;
        if (r101 == null) goto L6;
        r101.handle(r100);
        return;
    }

    public static void setEnabled(boolean r100) {
        enabled = r100;
    }

    public CJPayDebouncingOnClickListener intercept(Interceptor r100) {
        if (this.interceptorHandlers != null) goto L5;
        this.interceptorHandlers = new ArrayList();
    L5:
        if (r100 == null) goto L7;
        this.interceptorHandlers.add(r100);
    L7:
        return this;
    }

    public CJPayDebouncingOnClickListener next(final Function1<View, Unit> r100) {
        if (this.interceptorHandlers != null) goto L5;
        this.interceptorHandlers = new ArrayList();
    L5:
        if (r100 == null) goto L7;
        this.interceptorHandlers.add(new AnonymousClass2(this, r100));
    L7:
        return this;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (enabled == false) goto L9;
        enabled = false;
        r100.postDelayed(ENABLE_AGAIN, this.interval);
        if (handleInterceptor(r100) == false) goto L7;
        doClick(r100);
    L7:
        onFinal(r100);
        return;
    }

    public CJPayDebouncingOnClickListener onFinally(final Function1<View, Unit> r100) {
        if (r100 == null) goto L4;
        this.finalHandler = new AnonymousClass3(this, r100);
    L4:
        return this;
    }

    public void setInterval(long r100) {
        this.interval = r100;
    }
}
