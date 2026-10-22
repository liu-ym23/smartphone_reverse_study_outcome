package com.obric.autogui.platforms.tools.c;

import android.content.Context;
import android.graphics.Bitmap;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.screen.capture.IAutoActionCollectingApi;
import com.obric.autogui.common.api.platform.screen.capture.IScreenOperationListener;
import com.obric.autogui.common.api.platform.screen.capture.OScreenEvent;
import com.obric.memorydata.sdk.screencapture.ScreenCaptureManager;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import com.obric.memorydata.sdk.screencapture.event.AppStateEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.obric.memorydata.sdk.screencapture.rule.AppStateEventRule;
import com.obric.memorydata.sdk.screencapture.rule.InputMethodEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenTouchEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: MemoryDataCollectingApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAutoActionCollectingApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<IScreenOperationListener> f30136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScreenTouchEventRule f30137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScreenEventReaction f30138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScreenEventReaction f30139e;
    private final ScreenEventReaction f;
    private volatile boolean g;

    /* JADX INFO: compiled from: MemoryDataCollectingApiImpl.kt */
    private final class a implements com.obric.memorydata.sdk.screencapture.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f30140a;

        public a(b r1) {
            this.f30140a = r1;
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(int r5, String r6) {
            o.e(r6, "errorMessage");
            Loog.INSTANCE.e(b.a(this.f30140a), "onError: " + r5 + ", " + r6);
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(b.b(this.f30140a), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            ((IScreenOperationListener) ZeusTransformUtils.preCheckCast(r4.next(), IScreenOperationListener.class, "com.obric.aiagent.plugin")).onError(r5, r6);
            goto L4
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(ScreenEvent r6, ScreenData r7) {
            o.e(r6, "event");
            o.e(r7, "data");
            Loog.INSTANCE.i(b.a(this.f30140a), "onEvent: " + r6 + ", " + r7);
            OScreenEvent r0 = com.obric.autogui.platforms.tools.c.a.a(r6);
            Bitmap r1 = r7.getScreenshot();
            if (r0 != null) goto L6;
            Loog.INSTANCE.e(b.a(this.f30140a), "onEvent: " + r6 + ", " + r7 + ", oEvent is null");
            return;
        L6:
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(b.b(this.f30140a), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            ((IScreenOperationListener) ZeusTransformUtils.preCheckCast(r5.next(), IScreenOperationListener.class, "com.obric.aiagent.plugin")).onEvent(r0, r1);
            goto L8
        }
    }

    @Override // com.obric.autogui.common.api.platform.screen.capture.IAutoActionCollectingApi
    public boolean isSupported() {
        return true;
    }

    public b() {
        this.f30135a = "ScreenOperationApiImpl";
        this.f30136b = new CopyOnWriteArrayList();
        ScreenTouchEventRule r1 = new ScreenTouchEventRule(p.b(new ScreenTouchEvent.b[]{ScreenTouchEvent.b.f33872a, ScreenTouchEvent.b.f33874c, ScreenTouchEvent.b.f33875d, ScreenTouchEvent.b.f33876e, ScreenTouchEvent.b.f, ScreenTouchEvent.b.f33873b}), 0, 2, null);
        this.f30137c = r1;
        this.f30138d = new ScreenEventReaction(null, (ScreenEventRule) ZeusTransformUtils.preCheckCast(r1, ScreenEventRule.class, "com.obric.aiagent.plugin"), new TaskOptions(new ScreenshotOption(0.5f, false, 0, null, p.a(AOHostAppTools.INSTANCE.getHostAppPackage()), false, null, 110, null), null, 2, null), 1, null);
        this.f30139e = new ScreenEventReaction(null, (ScreenEventRule) ZeusTransformUtils.preCheckCast(new InputMethodEventRule(null, 1, null), ScreenEventRule.class, "com.obric.aiagent.plugin"), new TaskOptions(new ScreenshotOption(0.5f, false, 0, null, p.a(AOHostAppTools.INSTANCE.getHostAppPackage()), false, null, 110, null), null, 2, null), 1, null);
        this.f = new ScreenEventReaction(null, (ScreenEventRule) ZeusTransformUtils.preCheckCast(new AppStateEventRule(AppStateEvent.a.f33857a), ScreenEventRule.class, "com.obric.aiagent.plugin"), null, 5, null);
    }

    public static final /* synthetic */ String a(b r0) {
        return r0.f30135a;
    }

    public static final /* synthetic */ CopyOnWriteArrayList b(b r0) {
        return r0.f30136b;
    }

    @Override // com.obric.autogui.common.api.platform.screen.capture.IAutoActionCollectingApi
    public void unregisterScreenOperationListener(IScreenOperationListener r3) {
        IScreenOperationListener r4 = (IScreenOperationListener) ZeusTransformUtils.wrapperContextForParams(r3, IScreenOperationListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.f30136b.remove(r4);
        if (this.f30136b.isEmpty() == false) goto L6;
        ScreenCaptureManager.INSTANCE.unregister(this.f30138d);
        ScreenCaptureManager.INSTANCE.unregister(this.f30139e);
        ScreenCaptureManager.INSTANCE.unregister(this.f);
        this.g = false;
        return;
    }

    @Override // com.obric.autogui.common.api.platform.screen.capture.IAutoActionCollectingApi
    public boolean initCollecting(Context r2, boolean r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        Loog.INSTANCE.w(this.f30135a, "The Collecting API isn't initialized as we are not running as a standalone app.");
        return false;
    }

    @Override // com.obric.autogui.common.api.platform.screen.capture.IAutoActionCollectingApi
    public void registerScreenOperationListener(IScreenOperationListener r4) {
        IScreenOperationListener r5 = (IScreenOperationListener) ZeusTransformUtils.wrapperContextForParams(r4, IScreenOperationListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "listener");
        a();
        this.f30136b.add(r5);
        Loog.INSTANCE.d(this.f30135a, "registerScreenOperationListener: " + this.g);
    }

    private final synchronized void a() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r8)
            boolean r0 = r8.g     // Catch: java.lang.Throwable -> L98
            if (r0 != 0) goto L96
            java.lang.Class<com.obric.autogui.platforms.tools.c.b> r0 = com.obric.autogui.platforms.tools.c.b.class
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L98
            r1 = 32
            boolean r2 = r8.g     // Catch: java.lang.Throwable -> L93
            if (r2 != 0) goto L8f
            com.obric.memorydata.sdk.screencapture.ScreenCaptureManager r2 = com.obric.memorydata.sdk.screencapture.ScreenCaptureManager.INSTANCE     // Catch: java.lang.Throwable -> L93
            android.content.Context r3 = r8.getContext()     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = "com.obric.aiagent.plugin"
            android.content.Context r3 = com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContext(r3, r4)     // Catch: java.lang.Throwable -> L93
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            java.lang.String r5 = "com.obric.aiagent.plugin"
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r3, r4, r5)     // Catch: java.lang.Throwable -> L93
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Throwable -> L93
            com.obric.memorydata.sdk.screencapture.ScreenEventReaction r4 = r8.f30138d     // Catch: java.lang.Throwable -> L93
            com.obric.autogui.platforms.tools.c.b$a r5 = new com.obric.autogui.platforms.tools.c.b$a     // Catch: java.lang.Throwable -> L93
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L93
            java.lang.Class<com.obric.memorydata.sdk.screencapture.b> r6 = com.obric.memorydata.sdk.screencapture.b.class
            java.lang.String r7 = "com.obric.aiagent.plugin"
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, r6, r7)     // Catch: java.lang.Throwable -> L93
            com.obric.memorydata.sdk.screencapture.b r5 = (com.obric.memorydata.sdk.screencapture.b) r5     // Catch: java.lang.Throwable -> L93
            r2.register(r3, r4, r5, r1)     // Catch: java.lang.Throwable -> L93
            com.obric.memorydata.sdk.screencapture.ScreenCaptureManager r2 = com.obric.memorydata.sdk.screencapture.ScreenCaptureManager.INSTANCE     // Catch: java.lang.Throwable -> L93
            android.content.Context r3 = r8.getContext()     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = "com.obric.aiagent.plugin"
            android.content.Context r3 = com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContext(r3, r4)     // Catch: java.lang.Throwable -> L93
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            java.lang.String r5 = "com.obric.aiagent.plugin"
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r3, r4, r5)     // Catch: java.lang.Throwable -> L93
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Throwable -> L93
            com.obric.memorydata.sdk.screencapture.ScreenEventReaction r4 = r8.f30139e     // Catch: java.lang.Throwable -> L93
            com.obric.autogui.platforms.tools.c.b$a r5 = new com.obric.autogui.platforms.tools.c.b$a     // Catch: java.lang.Throwable -> L93
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L93
            java.lang.Class<com.obric.memorydata.sdk.screencapture.b> r6 = com.obric.memorydata.sdk.screencapture.b.class
            java.lang.String r7 = "com.obric.aiagent.plugin"
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, r6, r7)     // Catch: java.lang.Throwable -> L93
            com.obric.memorydata.sdk.screencapture.b r5 = (com.obric.memorydata.sdk.screencapture.b) r5     // Catch: java.lang.Throwable -> L93
            r2.register(r3, r4, r5, r1)     // Catch: java.lang.Throwable -> L93
            com.obric.memorydata.sdk.screencapture.ScreenCaptureManager r2 = com.obric.memorydata.sdk.screencapture.ScreenCaptureManager.INSTANCE     // Catch: java.lang.Throwable -> L93
            android.content.Context r3 = r8.getContext()     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = "com.obric.aiagent.plugin"
            android.content.Context r3 = com.volcengine.zeus.transform.ZeusTransformUtils.wrapperContext(r3, r4)     // Catch: java.lang.Throwable -> L93
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            java.lang.String r5 = "com.obric.aiagent.plugin"
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r3, r4, r5)     // Catch: java.lang.Throwable -> L93
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Throwable -> L93
            com.obric.memorydata.sdk.screencapture.ScreenEventReaction r4 = r8.f     // Catch: java.lang.Throwable -> L93
            com.obric.autogui.platforms.tools.c.b$a r5 = new com.obric.autogui.platforms.tools.c.b$a     // Catch: java.lang.Throwable -> L93
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L93
            java.lang.Class<com.obric.memorydata.sdk.screencapture.b> r6 = com.obric.memorydata.sdk.screencapture.b.class
            java.lang.String r7 = "com.obric.aiagent.plugin"
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, r6, r7)     // Catch: java.lang.Throwable -> L93
            com.obric.memorydata.sdk.screencapture.b r5 = (com.obric.memorydata.sdk.screencapture.b) r5     // Catch: java.lang.Throwable -> L93
            r2.register(r3, r4, r5, r1)     // Catch: java.lang.Throwable -> L93
            r1 = 1
            r8.g = r1     // Catch: java.lang.Throwable -> L93
        L8f:
            d.x r1 = d.x.f38692a     // Catch: java.lang.Throwable -> L93
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L98
            goto L96
        L93:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L98
            throw r1     // Catch: java.lang.Throwable -> L98
        L96:
            monitor-exit(r8)
            return
        L98:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.autogui.platforms.tools.c.b.a():void");
    }

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }
}
