package com.stepos.dylog;

import java.util.Collections;

/* loaded from: classes.dex */
public final class SurfaceControlDynamicalLogHelper {
    private static final String CLASS_NAME = "android.view.SurfaceControlRegistry";
    private static final String FIELD_DYLOG_MANAGED = "sCallStackDebuggingDyLogManaged";
    private static final String FIELD_ENABLED = "sCallStackDebuggingEnabled";
    private static final String FIELD_LOG_ALL_ON_APPLY = "sLogAllTxCallsOnApply";
    private static final String FIELD_MATCH_CALL = "sCallStackDebuggingMatchCall";
    private static final String FIELD_MATCH_NAME = "sCallStackDebuggingMatchName";

    private SurfaceControlDynamicalLogHelper() {
    }

    public static void apply(String matchCall) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException {
        try {
            Class<?> clazz = Class.forName(CLASS_NAME);
            boolean enable = (matchCall == null || matchCall.isEmpty()) ? false : true;
            ReflectDynamicalLogHelper.setDynamicalConfig(clazz, Collections.singletonList(FIELD_DYLOG_MANAGED), enable);
            ReflectDynamicalLogHelper.setStringField(clazz, FIELD_MATCH_CALL, enable ? matchCall : "");
            ReflectDynamicalLogHelper.setStringField(clazz, FIELD_MATCH_NAME, "");
            ReflectDynamicalLogHelper.setDynamicalConfig(clazz, Collections.singletonList(FIELD_ENABLED), enable);
            boolean logAllOnApply = enable && matchCall.toLowerCase().contains("apply");
            ReflectDynamicalLogHelper.setDynamicalConfig(clazz, Collections.singletonList(FIELD_LOG_ALL_ON_APPLY), logAllOnApply);
        } catch (ClassNotFoundException e) {
        }
    }
}
