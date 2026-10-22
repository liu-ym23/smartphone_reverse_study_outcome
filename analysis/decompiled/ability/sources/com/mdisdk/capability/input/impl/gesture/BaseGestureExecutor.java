package com.mdisdk.capability.input.impl.gesture;

import A4.b;
import android.os.Handler;
import android.os.Looper;
import android.view.i;
import com.mdisdk.capability.input.EventCallback;
import com.mdisdk.capability.input.adapter.InputManagerAdapter;
import com.mdisdk.capability.input.impl.InputEventFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public abstract class BaseGestureExecutor {
    private static final ExecutorService GESTURE_EXECUTOR = Executors.newSingleThreadExecutor(new b(6));
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    protected final InputManagerAdapter adapter;
    protected final InputEventFactory factory;

    public BaseGestureExecutor(InputManagerAdapter inputManagerAdapter, InputEventFactory inputEventFactory) {
        if (inputManagerAdapter == null || inputEventFactory == null) {
            throw new IllegalArgumentException("Adapter and factory cannot be null");
        }
        this.adapter = inputManagerAdapter;
        this.factory = inputEventFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$execute$1(boolean z10, EventCallback eventCallback, String str) {
        if (z10) {
            eventCallback.onSuccess();
            return;
        }
        if (str == null) {
            str = "Unknown error";
        }
        eventCallback.onFailure(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$2(int i, EventCallback eventCallback) {
        String str;
        boolean zExecuteInternal;
        try {
            zExecuteInternal = executeInternal(i);
            str = null;
        } catch (Exception e) {
            str = "Gesture execution failed: " + e.getMessage();
            zExecuteInternal = false;
        }
        if (eventCallback != null) {
            MAIN_HANDLER.post(new a(zExecuteInternal, eventCallback, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "GestureExecutor-Thread");
        thread.setPriority(10);
        return thread;
    }

    public void execute(int i, EventCallback eventCallback) {
        GESTURE_EXECUTOR.execute(new i(i, 3, this, eventCallback));
    }

    public abstract boolean executeInternal(int i);

    public float lerp(float f, float f7, float f9) {
        return B7.a.b(f7, f, f9, f);
    }

    public void sleepSafely(long j5) throws InterruptedException {
        if (j5 <= 0) {
            return;
        }
        try {
            Thread.sleep(j5);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
