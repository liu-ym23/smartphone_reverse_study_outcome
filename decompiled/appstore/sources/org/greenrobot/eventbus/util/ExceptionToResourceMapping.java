package org.greenrobot.eventbus.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ExceptionToResourceMapping {
    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap;

    public ExceptionToResourceMapping() {
        this.throwableToMsgIdMap = new HashMap();
    }

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> r10, int r11) {
        this.throwableToMsgIdMap.put(r10, Integer.valueOf(r11));
        return this;
    }

    public Integer mapThrowable(Throwable r10) {
        int r11 = 20;
        Throwable r12 = r10;
    L3:
        Integer r13 = mapThrowableFlat(r12);
        if (r13 != null) goto L5;
        r12 = r12.getCause();
        r11 = r11 - 1;
        if (r11 <= 0) goto L10;
        if (r12 == r10) goto L10;
        if (r12 != null) goto L3;
    L10:
        Log.d("EventBus", "No specific message resource ID found for " + r10);
        return null;
    L5:
        return r13;
    }

    public Integer mapThrowableFlat(Throwable r10) {
        Class<?> r11 = r10.getClass();
        Integer r12 = this.throwableToMsgIdMap.get(r11);
        if (r12 != null) goto L13;
        Iterator<Map.Entry<Class<? extends Throwable>, Integer>> r13 = this.throwableToMsgIdMap.entrySet().iterator();
        Class<? extends Throwable> r14 = null;
    L6:
        if (r13.hasNext() == false) goto L13;
        Map.Entry<Class<? extends Throwable>, Integer> r15 = r13.next();
        Class<? extends Throwable> r16 = r15.getKey();
        if (r16.isAssignableFrom(r11) == false) goto L6;
        if (r14 == null) goto L12;
        if (r14.isAssignableFrom(r16) == false) goto L6;
    L12:
        r12 = r15.getValue();
        r14 = r16;
    L13:
        return r12;
    }
}
