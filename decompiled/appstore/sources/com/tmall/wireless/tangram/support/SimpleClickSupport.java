package com.tmall.wireless.tangram.support;

import android.view.View;
import androidx.collection.ArrayMap;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.dataparser.concrete.Cell;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.util.LogUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SimpleClickSupport {
    private static final int BRIDGE = 64;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final String ON_CLICK_METHOD_NAME = "onClick";
    private static final String ON_CLICK_METHOD_POSTFIX = "Click";
    private static final String ON_CLICK_METHOD_PREFIX = "on";
    private static final int SYNTHETIC = 4096;
    private static final String TAG = "SimpleClickSupport";
    private static final Map<Class<?>, List<Class<?>>> cellTypesCache = null;
    private final Map<Class<?>, OnClickMethod> mOnClickMethods;
    private boolean optimizedMode;

    public static class OnClickMethod {
        Method method;
        int paramLength;

        public OnClickMethod(int r10, Method r11) {
            this.paramLength = r10;
            this.method = r11;
        }
    }

    static {
        cellTypesCache = new ConcurrentHashMap();
    }

    public SimpleClickSupport() {
        this.mOnClickMethods = new ArrayMap();
    }

    private void findClickMethods(Method[] r12) {
        int r10 = r12.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L35;
        Method r13 = r12[r11];
        String r14 = r13.getName();
        if (r14.equals("onClick") == true) goto L9;
        if (r14.startsWith("onClick") == false) goto L9;
    L12:
        int r15 = r13.getModifiers();
        if ((r15 & 1) == 0) goto L34;
        if ((r15 & MODIFIERS_IGNORE) != 0) goto L34;
        Class<?>[] r16 = r13.getParameterTypes();
        if (r16.length != 3) goto L19;
    L20:
        Class<?> r17 = r16[0];
        Class<?> r18 = r16[1];
        Class<?> r19 = r16[2];
        if (View.class.isAssignableFrom(r17) == false) goto L34;
        if (BaseCell.class.isAssignableFrom(r18) == false) goto L34;
        if (r19.equals(Integer.TYPE) == true) goto L29;
        if (r19.equals(Integer.class) == false) goto L34;
    L29:
        if (r16.length == 4) goto L31;
        this.mOnClickMethods.put(r17, new OnClickMethod(3, r13));
        goto L34
    L31:
        if (Map.class.isAssignableFrom(r16[3]) == false) goto L34;
        this.mOnClickMethods.put(r17, new OnClickMethod(4, r13));
        goto L34
    L19:
        if (r16.length == 4) goto L20;
    L34:
        r11 = r11 + 1;
    L9:
        if (r14.startsWith(ON_CLICK_METHOD_PREFIX) == false) goto L34;
        if (r14.endsWith(ON_CLICK_METHOD_POSTFIX) == false) goto L34;
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

    public void defaultClick(View r10, BaseCell r11, int r12) {
    }

    public void onClick(View r10, BaseCell r11, int r12) {
        if ((r11 instanceof Cell) == false) goto L5;
        onClick(r10, (Cell) r11, r12);
        return;
    L5:
        onClick(r10, r11, r12, null);
    }

    public void setOptimizedMode(boolean r10) {
        this.optimizedMode = r10;
    }

    public void onClick(View r10, Cell r11, int r12) {
        onClick(r10, r11, r12, null);
    }

    public void onClick(View r10, BaseCell r11, int r12, Map<String, Object> r13) {
        if (this.optimizedMode == false) goto L6;
        defaultClick(r10, r11, r12);
        return;
    L6:
        if (this.mOnClickMethods.isEmpty() == false) goto L8;
        findClickMethods(getClass().getMethods());
    L8:
        Iterator<Class<?>> r14 = lookupCellTypes(r10.getClass()).iterator();
    L10:
        if (r14.hasNext() == false) goto L28;
        Class<?> r15 = r14.next();
        if (r15.equals(View.class) == true) goto L10;
        if (this.mOnClickMethods.containsKey(r15) == false) goto L10;
        OnClickMethod r16 = this.mOnClickMethods.get(r15);
        int r17 = r16.paramLength;     // Catch: Exception -> L21
        if (r17 == 3) goto L19;
        if (r17 != 4) goto L10;
        r16.method.invoke(this, new Object[]{r10, r11, Integer.valueOf(r12), r13});     // Catch: Exception -> L21
        return;
    L19:
        r16.method.invoke(this, new Object[]{r10, r11, Integer.valueOf(r12)});     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        LogUtils.e(TAG, "Invoke onClick method error: " + i.d(e), e);
        goto L10
    L28:
        defaultClick(r10, r11, r12);
    }
}
