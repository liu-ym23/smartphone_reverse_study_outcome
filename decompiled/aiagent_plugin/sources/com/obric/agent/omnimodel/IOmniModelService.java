package com.obric.agent.omnimodel;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: IOmniModelService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IOmniModelService {
    public static final a Companion = null;
    public static final String MESSAGE_EXT_KEY = "o_complex_task_model";
    public static final String MODEL_LITE = "doubao-2.0-sft-omni-agent.0706";
    public static final String MODEL_TURBO = "doubao-2.1-turbo-sft-omni-agent.0803";

    /* JADX INFO: compiled from: IOmniModelService.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f15385a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final f<com.obric.agent.omnimodel.a> f15386b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final f<Gson> f15387c = null;

        public static /* synthetic */ com.obric.agent.omnimodel.a lambda$H1NqdsCFVj7zweEU9DPxRntFNMk() {
            return d();
        }

        public static /* synthetic */ Gson lambda$N882CpLQ3RWqTgDlt9PINUupy50() {
            return e();
        }

        private a() {
        }

        public static final /* synthetic */ Gson a(a r0) {
            return r0.c();
        }

        static {
            f15385a = new a();
            f15386b = g.a($$Lambda$IOmniModelService$a$H1NqdsCFVj7zweEU9DPxRntFNMk.INSTANCE);
            f15387c = g.a($$Lambda$IOmniModelService$a$N882CpLQ3RWqTgDlt9PINUupy50.INSTANCE);
        }

        private final com.obric.agent.omnimodel.a b() {
            return (com.obric.agent.omnimodel.a) ZeusTransformUtils.preCheckCast(f15386b.b(), com.obric.agent.omnimodel.a.class, "com.obric.aiagent.plugin");
        }

        private static final com.obric.agent.omnimodel.a d() {
            return new com.obric.agent.omnimodel.a();
        }

        private final Gson c() {
            return (Gson) ZeusTransformUtils.preCheckCast(f15387c.b(), Gson.class, "com.obric.aiagent.plugin");
        }

        private static final Gson e() {
            return new Gson();
        }

        public final IOmniModelService a() {
            IOmniModelService r0 = (IOmniModelService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniModelService.class), IOmniModelService.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            return r0;
        L5:
            return (IOmniModelService) ZeusTransformUtils.preCheckCast(b(), IOmniModelService.class, "com.obric.aiagent.plugin");
        }

        public final String a(String r5) {
            if (r5 == null) goto L11;
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
            Appendable r6 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin");
            int r1 = 0;
        L5:
            if (r1 >= r4.length()) goto L10;
            char r2 = r4.charAt(r1);
            if (d.o.a.a(r2) == true) goto L9;
            r6.append(r2);
        L9:
            r1 = r1 + 1;
            goto L5
        L10:
            String r7 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r6, StringBuilder.class, "com.obric.aiagent.plugin")).toString();
            o.c(r7, "toString(...)");
        L12:
            if (r7 != null) goto L18;
            return "";
        L18:
            return r7;
        L11:
            r7 = null;
            goto L12
        }
    }

    /* JADX INFO: compiled from: IOmniModelService.kt */
    public static final class b {
        public static String a(IOmniModelService r2, c r3) {
            IOmniModelService r4 = (IOmniModelService) ZeusTransformUtils.wrapperContextForParams(r2, IOmniModelService.class, "com.obric.aiagent.plugin");
            o.e(r3, "entry");
            String r5 = a.a(IOmniModelService.Companion).toJson(r3);
            o.c(r5, "toJson(...)");
            return r5;
        }

        public static c a(IOmniModelService r9, String r10) {
            IOmniModelService r11 = (IOmniModelService) ZeusTransformUtils.wrapperContextForParams(r9, IOmniModelService.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L41;
            Object r3 = null;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
            r10 = null;
        L8:
            if (r10 == null) goto L41;
            n.a r0 = n.f38560a;     // Catch: Throwable -> L12
            Object r1 = n.f((c) ZeusTransformUtils.preCheckCast(a.a(IOmniModelService.Companion).fromJson(r10, c.class), c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        L15:
            if (n.b(r1) == false) goto L17;
            r1 = null;
        L17:
            c r2 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L39;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
            r2 = null;
        L23:
            if (r2 == null) goto L39;
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.availableEntries(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L26:
            if (r4.hasNext() == false) goto L35;
            Object r5 = r4.next();
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(r6.b(), r2.b()) == true) goto L30;
        L32:
            boolean r7 = false;
        L33:
            if (r7 == false) goto L26;
            r3 = r5;
            goto L35
        L30:
            if (o.a(IOmniModelService.Companion.a(r6.a()), IOmniModelService.Companion.a(r2.a())) == false) goto L32;
            r7 = true;
        L35:
            c r8 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L39;
            return r8;
        L39:
            return r11.getEntryByDisplayModel(r10);
        L12:
            th = move-exception;
            n.a r12 = n.f38560a;
            r1 = n.f(d.o.a(th));
        L41:
            return r11.defaultEntry();
        }
    }

    /* JADX INFO: compiled from: IOmniModelService.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("display_model")
        private final String f15388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("model")
        private final String f15389b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15388a, r6.f15388a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15389b, r6.f15389b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f15388a.hashCode() * 31) + this.f15389b.hashCode();
        }

        public String toString() {
            return "ModelEntry(displayModel=" + this.f15388a + ", model=" + this.f15389b + ')';
        }

        public c(String r2, String r3) {
            o.e(r2, "displayModel");
            o.e(r3, "model");
            this.f15388a = r2;
            this.f15389b = r3;
        }

        public final String a() {
            return this.f15388a;
        }

        public final String b() {
            return this.f15389b;
        }
    }

    static {
        Companion = a.f15385a;
    }

    List<c> availableEntries();

    String defaultDisplayModel();

    c defaultEntry();

    String eventTaskDefaultDisplayModel();

    c getEntryByDisplayModel(String r1);

    c getEntryByModel(String r1);

    c parseEntryFromJson(String r1);

    String toExtValue(c r1);
}
