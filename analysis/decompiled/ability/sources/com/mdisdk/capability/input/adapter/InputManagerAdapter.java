package com.mdisdk.capability.input.adapter;

import android.hardware.input.InputManager;
import android.view.InputEvent;
import com.mdisdk.base.ALog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class InputManagerAdapter {
    private static final int INJECT_INPUT_EVENT_MODE_ASYNC = 0;
    private static final String TAG = "InputManagerAdapter";
    private Method injectInputEventMethod;
    private Object inputManager;
    private Method setDisplayIdMethod;

    public boolean initialize() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class cls = Integer.TYPE;
        if (this.inputManager != null) {
            return true;
        }
        try {
            Method declaredMethod = InputManager.class.getDeclaredMethod("getInstance", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            this.inputManager = objInvoke;
            if (objInvoke == null) {
                ALog.e(TAG, "Failed to get InputManager instance", null);
                return false;
            }
            try {
                this.injectInputEventMethod = objInvoke.getClass().getMethod("injectInputEvent", InputEvent.class, cls, cls);
            } catch (NoSuchMethodException unused) {
                this.injectInputEventMethod = this.inputManager.getClass().getMethod("injectInputEvent", InputEvent.class, cls);
            }
            this.setDisplayIdMethod = InputEvent.class.getMethod("setDisplayId", cls);
            ALog.d(TAG, "InputManagerAdapter initialized successfully", null);
            return true;
        } catch (Exception e) {
            ALog.e(TAG, "Failed to initialize InputManagerAdapter: " + e.getMessage(), null);
            this.inputManager = null;
            this.injectInputEventMethod = null;
            this.setDisplayIdMethod = null;
            return false;
        }
    }

    public boolean injectInputEvent(InputEvent inputEvent, int i) {
        if (!isAvailable()) {
            ALog.w(TAG, "InputManagerAdapter not available", null);
            return false;
        }
        if (inputEvent == null) {
            ALog.w(TAG, "InputEvent is null", null);
            return false;
        }
        try {
            this.setDisplayIdMethod.invoke(inputEvent, Integer.valueOf(i));
            return Boolean.TRUE.equals(this.injectInputEventMethod.getParameterTypes().length == 3 ? this.injectInputEventMethod.invoke(this.inputManager, inputEvent, 0, -1) : this.injectInputEventMethod.invoke(this.inputManager, inputEvent, 0));
        } catch (IllegalAccessException e) {
            ALog.e(TAG, "Access denied when injecting event: " + e.getMessage(), null);
            return false;
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            StringBuilder sb = new StringBuilder("Failed to inject event: ");
            sb.append(cause != null ? cause.getMessage() : e6.getMessage());
            ALog.e(TAG, sb.toString(), null);
            return false;
        } catch (Exception e9) {
            ALog.e(TAG, "Unexpected error when injecting event: " + e9.getMessage(), null);
            return false;
        }
    }

    public boolean isAvailable() {
        return (this.inputManager == null || this.injectInputEventMethod == null || this.setDisplayIdMethod == null) ? false : true;
    }

    public void release() {
        this.inputManager = null;
        this.injectInputEventMethod = null;
        this.setDisplayIdMethod = null;
        ALog.d(TAG, "InputManagerAdapter released", null);
    }
}
