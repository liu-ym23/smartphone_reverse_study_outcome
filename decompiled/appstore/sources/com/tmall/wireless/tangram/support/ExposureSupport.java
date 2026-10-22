package com.tmall.wireless.tangram.support;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.util.LogUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExposureSupport {
    private static final int BRIDGE = 64;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final String ON_EXPOSURE_METHOD_NAME = "onExposure";
    private static final String ON_EXPOSURE_METHOD_POSTFIX = "Exposure";
    private static final String ON_EXPOSURE_METHOD_PREFIX = "on";
    private static final String ON_TRACE_METHOD_NAME = "onTrace";
    private static final String ON_TRACE_METHOD_POSTFIX = "Trace";
    private static final String ON_TRACE_METHOD_PREFIX = "on";
    private static final int SYNTHETIC = 4096;
    private static final String TAG = "ExposureSupport";
    private static final Map<Class<?>, List<Class<?>>> cellTypesCache = null;
    private final Map<Class<?>, OnTraceMethod> mOnExposureMethods;
    private final Map<Class<?>, OnTraceMethod> mOnTraceMethods;
    private boolean optimizedMode;

    public static class OnTraceMethod {
        Method method;
        int paramLength;

        public OnTraceMethod(int r10, Method r11) {
            this.paramLength = r10;
            this.method = r11;
        }
    }

    static {
        cellTypesCache = new ConcurrentHashMap();
    }

    public ExposureSupport() {
        this.mOnTraceMethods = new ArrayMap();
        this.mOnExposureMethods = new ArrayMap();
    }

    private void findExposureMethods(Method[] r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L28;
        Method r13 = r10[r12];
        String r14 = r13.getName();
        if (r14.equals("onExposure") == true) goto L9;
        if (r14.startsWith("onExposure") == false) goto L9;
    L12:
        int r15 = r13.getModifiers();
        if ((r15 & 1) == 0) goto L27;
        if ((r15 & MODIFIERS_IGNORE) != 0) goto L27;
        Class<?>[] r16 = r13.getParameterTypes();
        if (r16.length != 3) goto L27;
        Class<?> r17 = r16[0];
        Class<?> r18 = r16[1];
        Class<?> r19 = r16[2];
        if (View.class.isAssignableFrom(r17) == false) goto L27;
        if (BaseCell.class.isAssignableFrom(r18) == false) goto L27;
        if (r19.equals(Integer.TYPE) == false) goto L25;
    L26:
        this.mOnExposureMethods.put(r17, new OnTraceMethod(3, r13));
        goto L27
    L25:
        if (r19.equals(Integer.class) == true) goto L26;
    L27:
        r12 = r12 + 1;
    L9:
        if (r14.startsWith("on") == false) goto L27;
        if (r14.endsWith(ON_EXPOSURE_METHOD_POSTFIX) == false) goto L27;
    }

    private void findTraceMethods(Method[] r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L28;
        Method r13 = r10[r12];
        String r14 = r13.getName();
        if (r14.equals(ON_TRACE_METHOD_NAME) == true) goto L9;
        if (r14.startsWith(ON_TRACE_METHOD_NAME) == false) goto L9;
    L12:
        int r15 = r13.getModifiers();
        if ((r15 & 1) == 0) goto L27;
        if ((r15 & MODIFIERS_IGNORE) != 0) goto L27;
        Class<?>[] r16 = r13.getParameterTypes();
        if (r16.length != 3) goto L27;
        Class<?> r17 = r16[0];
        Class<?> r18 = r16[1];
        Class<?> r19 = r16[2];
        if (View.class.isAssignableFrom(r17) == false) goto L27;
        if (BaseCell.class.isAssignableFrom(r18) == false) goto L27;
        if (r19.equals(Integer.TYPE) == false) goto L25;
    L26:
        this.mOnTraceMethods.put(r17, new OnTraceMethod(3, r13));
        goto L27
    L25:
        if (r19.equals(Integer.class) == true) goto L26;
    L27:
        r12 = r12 + 1;
    L9:
        if (r14.startsWith("on") == false) goto L27;
        if (r14.endsWith(ON_TRACE_METHOD_POSTFIX) == false) goto L27;
    }

    private List<Class<?>> lookupCellTypes(Class<?> r10) {
        List<Class<?>> r11 = cellTypesCache.get(r10);
        if (r11 != null) goto L10;
        r11 = new ArrayList();
        Class<?> r12 = r10;
    L5:
        if (r12 == null) goto L9;
        if (r12.equals(BaseCell.class) == true) goto L9;
        r11.add(r12);
        r12 = r12.getSuperclass();
    L9:
        cellTypesCache.put(r10, r11);
    L10:
        return r11;
    }

    public void attachTrackInfoToView(View r10, BaseCell r11, int r12) {
    }

    public void defaultExposureCell(@NonNull View r10, @NonNull BaseCell r11, int r12) {
    }

    public void defaultTrace(@NonNull View r10, @NonNull BaseCell r11, int r12) {
    }

    public void onExposure(@NonNull View r10, @NonNull BaseCell r11, int r12) {
        if (this.optimizedMode == false) goto L6;
        defaultExposureCell(r10, r11, r12);
        return;
    L6:
        if (this.mOnExposureMethods.isEmpty() == false) goto L8;
    L9:
        Method[] r13 = getClass().getMethods();
        findTraceMethods(r13);
        findExposureMethods(r13);
    L10:
        Iterator<Class<?>> r14 = lookupCellTypes(r10.getClass()).iterator();
    L12:
        if (r14.hasNext() == false) goto L25;
        Class<?> r15 = r14.next();
        if (r15.equals(View.class) == true) goto L12;
        if (this.mOnExposureMethods.containsKey(r15) == false) goto L12;
        OnTraceMethod r16 = this.mOnExposureMethods.get(r15);
    L23:
        e = move-exception;
        LogUtils.e(TAG, "Invoke onExposure method error: " + i.d(e), e);
        goto L12
    L20:
        if (r16.paramLength != 3) goto L12;
        r16.method.invoke(this, new Object[]{r10, r11, Integer.valueOf(r12)});     // Catch: Exception -> L23
        return;
    L25:
        defaultExposureCell(r10, r11, r12);
        return;
    L8:
        if (this.mOnTraceMethods.isEmpty() == false) goto L10;
        goto L9
    }

    public abstract void onExposure(@NonNull Card r10, int r11, int r12);

    public void onExposureReaptly(@NonNull Card r10, int r11, int r12) {
    }

    public void onTrace(@NonNull View r10, @NonNull BaseCell r11, int r12) {
        if (this.optimizedMode == false) goto L6;
        defaultTrace(r10, r11, r12);
        return;
    L6:
        if (this.mOnExposureMethods.isEmpty() == false) goto L8;
    L9:
        Method[] r13 = getClass().getMethods();
        findTraceMethods(r13);
        findExposureMethods(r13);
    L10:
        Iterator<Class<?>> r14 = lookupCellTypes(r10.getClass()).iterator();
    L12:
        if (r14.hasNext() == false) goto L25;
        Class<?> r15 = r14.next();
        if (r15.equals(View.class) == true) goto L12;
        if (this.mOnTraceMethods.containsKey(r15) == false) goto L12;
        OnTraceMethod r16 = this.mOnTraceMethods.get(r15);
    L23:
        e = move-exception;
        LogUtils.e(TAG, "Invoke Trace method error: " + i.d(e), e);
        goto L12
    L20:
        if (r16.paramLength != 3) goto L12;
        r16.method.invoke(this, new Object[]{r10, r11, Integer.valueOf(r12)});     // Catch: Exception -> L23
        return;
    L25:
        defaultTrace(r10, r11, r12);
        return;
    L8:
        if (this.mOnTraceMethods.isEmpty() == false) goto L10;
        goto L9
    }

    public void setOptimizedMode(boolean r10) {
        this.optimizedMode = r10;
    }

    public void attachTrackInfoToView(View r10, BaseCell r11, int r12, HashMap<String, Object> r13) {
    }
}
