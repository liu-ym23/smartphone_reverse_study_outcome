package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ProtobufToStringOutput {
    private static final ThreadLocal<OutputMode> outputMode = null;

    private static final enum OutputMode extends java.lang.Enum<OutputMode> {
        private static final /* synthetic */ OutputMode[] $VALUES = null;
        public static final OutputMode DEBUG_FORMAT = null;
        public static final OutputMode TEXT_FORMAT = null;

        private static /* synthetic */ OutputMode[] $values() {
            return new OutputMode[]{DEBUG_FORMAT, TEXT_FORMAT};
        }

        private OutputMode(String r1, int r2) {
            super(r1, r2);
        }

        public static OutputMode valueOf(String r2) {
            return (OutputMode) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(OutputMode.class, r2), OutputMode.class, "com.obric.aiagent.plugin");
        }

        public static OutputMode[] values() {
            return (OutputMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OutputMode[].class, "com.obric.aiagent.plugin");
        }

        static {
            DEBUG_FORMAT = new OutputMode("DEBUG_FORMAT", 0);
            TEXT_FORMAT = new OutputMode("TEXT_FORMAT", 1);
            $VALUES = $values();
        }
    }

    static {
        outputMode = ThreadLocal.withInitial($$Lambda$ProtobufToStringOutput$zsFHwd0Edg1HYgggSb6Iyf7mqPU.INSTANCE);
    }

    static /* synthetic */ OutputMode lambda$static$0() {
        return OutputMode.TEXT_FORMAT;
    }

    private ProtobufToStringOutput() {
    }

    private static OutputMode setOutputMode(OutputMode r4) {
        ThreadLocal<OutputMode> r0 = outputMode;
        OutputMode r1 = (OutputMode) ZeusTransformUtils.preCheckCast(r0.get(), OutputMode.class, "com.obric.aiagent.plugin");
        r0.set(r4);
        return r1;
    }

    private static void callWithSpecificFormat(Runnable r2, OutputMode r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        OutputMode r5 = setOutputMode(r3);
        r4.run();     // Catch: Throwable -> L6
        setOutputMode(r5);
        return;
    L6:
        th = move-exception;
        setOutputMode(r5);
        throw th;
    }

    public static void callWithDebugFormat(Runnable r2) {
        callWithSpecificFormat((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), OutputMode.DEBUG_FORMAT);
    }

    public static void callWithTextFormat(Runnable r2) {
        callWithSpecificFormat((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), OutputMode.TEXT_FORMAT);
    }

    public static boolean shouldOutputDebugFormat() {
        if (outputMode.get() != OutputMode.DEBUG_FORMAT) goto L5;
        return true;
    L5:
        return false;
    }
}
