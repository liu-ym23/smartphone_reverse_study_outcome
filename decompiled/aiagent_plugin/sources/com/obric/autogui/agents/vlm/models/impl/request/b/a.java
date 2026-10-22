package com.obric.autogui.agents.vlm.models.impl.request.b;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IStdModelInferencingError.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IStdModelInferencingError.kt */
    public static final enum EnumC0705a extends Enum<EnumC0705a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0705a f28035a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0705a f28036b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ EnumC0705a[] f28037c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f28038d = null;

        private static final /* synthetic */ EnumC0705a[] a() {
            return new EnumC0705a[]{f28035a, f28036b};
        }

        private EnumC0705a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f28035a = new EnumC0705a("RETRY_IF_POSSIBLE", 0);
            f28036b = new EnumC0705a("ABORT_TASK", 1);
            EnumC0705a[] r0 = a();
            f28037c = r0;
            f28038d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0705a valueOf(String r2) {
            return (EnumC0705a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0705a.class, r2), EnumC0705a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0705a[] values() {
            return (EnumC0705a[]) ZeusTransformUtils.preCheckCast(f28037c.clone(), EnumC0705a[].class, "com.obric.aiagent.plugin");
        }
    }

    b a();

    String a(Context r1);

    EnumC0705a b();
}
