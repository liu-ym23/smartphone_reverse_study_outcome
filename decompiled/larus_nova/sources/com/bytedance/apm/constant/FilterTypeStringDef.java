package com.bytedance.apm.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes14.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface FilterTypeStringDef {
    public static final String BLOCK = "block_monitor";
    public static final String CPU = "cpu";
    public static final String DROP_FRAME_STACK = "drop_frame_stack";
    public static final String FPS = "fps";
    public static final String FPS_DROP = "fps_drop";
    public static final String MEMORY = "memory";
}
