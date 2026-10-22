package org.tensorflow.lite;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InterpreterApi.java */
/* JADX INFO: loaded from: classes5.dex */
public interface c extends AutoCloseable {

    /* JADX INFO: compiled from: InterpreterApi.java */
    public static class a {

        /* JADX INFO: renamed from: org.tensorflow.lite.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: InterpreterApi.java */
        public static final enum EnumC1097a extends Enum<EnumC1097a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC1097a f40585a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC1097a f40586b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC1097a f40587c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC1097a[] f40588d = null;

            private EnumC1097a(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumC1097a valueOf(String r2) {
                return (EnumC1097a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC1097a.class, r2), EnumC1097a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC1097a[] values() {
                return (EnumC1097a[]) ZeusTransformUtils.preCheckCast(f40588d.clone(), EnumC1097a[].class, "com.obric.aiagent.plugin");
            }

            static {
                EnumC1097a r0 = new EnumC1097a("FROM_APPLICATION_ONLY", 0);
                f40585a = r0;
                EnumC1097a r1 = new EnumC1097a("FROM_SYSTEM_ONLY", 1);
                f40586b = r1;
                EnumC1097a r3 = new EnumC1097a("PREFER_SYSTEM_OVER_APPLICATION", 2);
                f40587c = r3;
                f40588d = new EnumC1097a[]{r0, r1, r3};
            }
        }
    }
}
