package com.bytedance.lego.init.monitor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InitMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum Category extends Enum<Category> {
    private static final /* synthetic */ Category[] $VALUES = null;
    public static final Category CHECK_PERIOD_EXCEPTION = null;
    public static final Category INIT_TASK_IN_MAIN = null;
    public static final Category INSTANCE_CLASS_EXCEPTION = null;
    public static final Category ON_PERIOD_EXCEPTION = null;
    public static final Category ON_PERIOD_TIMEOUT = null;
    public static final Category OTHER_EXCEPTION = null;
    public static final Category PERIOD_TIMEOUT_EXCEPTION = null;
    public static final Category RUN_TAK_EXCEPTION = null;
    public static final Category TASK_COUNT_EXCEPTION = null;
    public static final Category TASK_TIMEOUT_EXCEPTION = null;
    public static final Category TASK_TIMEOUT_EXCEPTION_REAL = null;
    private final String value;

    public static Category valueOf(String r2) {
        return (Category) ZeusTransformUtils.preCheckCast(Enum.valueOf(Category.class, r2), Category.class, "com.obric.aiagent.plugin");
    }

    public static Category[] values() {
        return (Category[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Category[].class, "com.obric.aiagent.plugin");
    }

    public Category(String r2, int r3, String r4) {
        o.d(r4, "value");
        super(r2, r3);
        this.value = r4;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        Category r1 = new Category("CHECK_PERIOD_EXCEPTION", 0, "check_period_exception");
        CHECK_PERIOD_EXCEPTION = r1;
        Category r2 = new Category("ON_PERIOD_TIMEOUT", 1, "on_period_timeout");
        ON_PERIOD_TIMEOUT = r2;
        Category r3 = new Category("ON_PERIOD_EXCEPTION", 2, "on_period_exception");
        ON_PERIOD_EXCEPTION = r3;
        Category r4 = new Category("INIT_TASK_IN_MAIN", 3, "init_tasks_in_main");
        INIT_TASK_IN_MAIN = r4;
        Category r5 = new Category("INSTANCE_CLASS_EXCEPTION", 4, "instance_class_exception");
        INSTANCE_CLASS_EXCEPTION = r5;
        Category r6 = new Category("TASK_COUNT_EXCEPTION", 5, "task_count_exception");
        TASK_COUNT_EXCEPTION = r6;
        Category r7 = new Category("RUN_TAK_EXCEPTION", 6, "run_task_exception");
        RUN_TAK_EXCEPTION = r7;
        Category r8 = new Category("PERIOD_TIMEOUT_EXCEPTION", 7, "period_timeout_exception");
        PERIOD_TIMEOUT_EXCEPTION = r8;
        Category r9 = new Category("TASK_TIMEOUT_EXCEPTION", 8, "task_timeout_exception");
        TASK_TIMEOUT_EXCEPTION = r9;
        Category r10 = new Category("TASK_TIMEOUT_EXCEPTION_REAL", 9, "task_timeout_exception_real");
        TASK_TIMEOUT_EXCEPTION_REAL = r10;
        Category r11 = new Category("OTHER_EXCEPTION", 10, "other_exception");
        OTHER_EXCEPTION = r11;
        $VALUES = new Category[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }
}
