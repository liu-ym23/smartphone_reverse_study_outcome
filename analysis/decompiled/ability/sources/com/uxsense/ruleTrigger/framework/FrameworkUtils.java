package com.uxsense.ruleTrigger.framework;

import android.content.Intent;
import android.util.Log;
import androidx.constraintlayout.core.dsl.a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class FrameworkUtils {
    private static final String METHOD_SET_APEX_SERVICE = "setApexService";
    private static final String TAG = "FrameworkUtils";

    public static void setApexService(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class.forName("android.view.ViewContentUtils").getMethod(METHOD_SET_APEX_SERVICE, Intent.class).invoke(null, intent);
            Log.d(TAG, "setApexService method invoked successfully");
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("setApexService ClassNotFoundException: "), TAG);
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("setApexService IllegalAccessException: "), TAG);
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("setApexService NoSuchMethodException: "), TAG);
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("setApexService InvocationTargetException: "), TAG);
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("setApexService Exception: "), TAG);
        }
    }
}
