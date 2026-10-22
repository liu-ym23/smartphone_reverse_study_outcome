package com.obric.aiagent.platform.depend;

import android.os.Process;
import com.obric.aiagent.platform.AIAgentPlatform;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.f.c;
import d.g;
import d.n;
import d.o.o;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.Reader;

/* JADX INFO: compiled from: IRuntimeContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IRuntimeContext {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: IRuntimeContext.kt */
    public static final class Companion implements IRuntimeContext {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final f<IRuntimeContext> impl$delegate = null;

        public static /* synthetic */ IRuntimeContext lambda$y5gTbaPMg2cc1houoJBdulO7m2c() {
            return impl_delegate$lambda$0();
        }

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            impl$delegate = g.a($$Lambda$IRuntimeContext$Companion$y5gTbaPMg2cc1houoJBdulO7m2c.INSTANCE);
        }

        private final IRuntimeContext getImpl() {
            return (IRuntimeContext) ZeusTransformUtils.preCheckCast(impl$delegate.b(), IRuntimeContext.class, "com.obric.aiagent.plugin");
        }

        private static final IRuntimeContext impl_delegate$lambda$0() {
            IAIAgentPlatform r0 = AIAgentPlatform.INSTANCE.get$platform_release();
            if (r0 == null) goto L6;
            IRuntimeContext r1 = r0.getRuntimeContext();
            if (r1 == null) goto L6;
            return r1;
        L6:
            IRuntimeContext r2 = (IRuntimeContext) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IRuntimeContext.class, false, false), IRuntimeContext.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L9;
            return r2;
        L9:
            return (IRuntimeContext) ZeusTransformUtils.preCheckCast(Default.INSTANCE, IRuntimeContext.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public boolean isMainProcess() {
            return getImpl().isMainProcess();
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public int getProcessId() {
            return getImpl().getProcessId();
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public String getProcessName() {
            return getImpl().getProcessName();
        }
    }

    /* JADX INFO: compiled from: IRuntimeContext.kt */
    private static final class Default implements IRuntimeContext {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public boolean isMainProcess() {
            String r5 = getProcessName();
            if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(":", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L6;
            return false;
        L6:
            return d.h.b.o.a(r5, IAppContext.Companion.getPackageName());
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public int getProcessId() {
            return Process.myPid();
        }

        @Override // com.obric.aiagent.platform.depend.IRuntimeContext
        public String getProcessName() {
            n.a r0 = n.f38560a;     // Catch: Throwable -> L34
            Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new FileReader("/proc/" + Process.myPid() + "/cmdline"), Reader.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
            String r2 = ((BufferedReader) ZeusTransformUtils.preCheckCast(r1, BufferedReader.class, "com.obric.aiagent.plugin")).readLine();     // Catch: Throwable -> L29
            d.h.b.o.a(r2);     // Catch: Throwable -> L29
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L27;
            d.h.b.o.a(r2);     // Catch: Throwable -> L29
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
            int r5 = r4.length() - 1;     // Catch: Throwable -> L29
            int r6 = 0;
            boolean r7 = false;
        L11:
            if (r6 > r5) goto L26;
            if (r7 == true) goto L14;
            int r8 = r6;
        L16:
            if (d.h.b.o.a(r4.charAt(r8), 32) > 0) goto L18;
            boolean r9 = true;
        L19:
            if (r7 == false) goto L20;
            if (r9 == false) goto L26;
            r5 = r5 - 1;     // Catch: Throwable -> L29
            goto L11
        L20:
            if (r9 == false) goto L21;
            r6 = r6 + 1;     // Catch: Throwable -> L29
            goto L11
        L21:
            r7 = true;
            goto L11
        L18:
            r9 = false;
            goto L19
        L14:
            r8 = r5;
        L26:
            r2 = r4.subSequence(r6, r5 + 1).toString();     // Catch: Throwable -> L29
        L27:
            c.a(r1, null);     // Catch: Throwable -> L34
            Object r10 = n.f(r2);     // Catch: Throwable -> L34
        L36:
            Throwable r11 = n.c(r10);
            if (r11 == null) goto L41;
            r11.printStackTrace();
            r10 = "";
        L41:
            return (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        L8:
            r3 = false;
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            c.a(r1, th);     // Catch: Throwable -> L34
            throw th;     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            n.a r12 = n.f38560a;
            r10 = n.f(d.o.a(th));
            goto L36
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int getProcessId();

    String getProcessName();

    boolean isMainProcess();
}
