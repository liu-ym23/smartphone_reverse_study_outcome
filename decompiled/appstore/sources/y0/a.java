package y0;

import android.app.Activity;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.agent.v2.instrumentation.BatteryAgent;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.n;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedanceos.common.networkv2.params.NetValue;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import e1.i;
import e1.j;
import e1.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends v1.a implements BatteryUtils.ChargeListener {
    public static final Object C = null;
    public final TaskRunnable A;
    public final TaskRunnable B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f25879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f25880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f25881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f25882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f25883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f25884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile long f25885m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f25886n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f25887o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f25888p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f25889q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f25890r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String[] f25891s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f25892t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f25893u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public HashMap f25894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HashMap f25895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f25896x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HashMap f25897y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f25898z;

    /* JADX INFO: renamed from: y0.a$a, reason: collision with other inner class name */
    public class RunnableC0407a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f25899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f25900b;

        public RunnableC0407a(a r10, boolean r11) {
            this.f25900b = r10;
            this.f25899a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                java.lang.Object r0 = y0.a.u()
                monitor-enter(r0)
                boolean r1 = w0.c.B()     // Catch: java.lang.Throwable -> L28
                if (r1 == 0) goto L2a
                java.lang.String r1 = s1.b.f24484b     // Catch: java.lang.Throwable -> L28
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
                r2.<init>()     // Catch: java.lang.Throwable -> L28
                java.lang.String r3 = "ChargingStatusChange:"
                r2.append(r3)     // Catch: java.lang.Throwable -> L28
                boolean r3 = r5.f25899a     // Catch: java.lang.Throwable -> L28
                r2.append(r3)     // Catch: java.lang.Throwable -> L28
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L28
                java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L28
                s1.c.d(r1, r2)     // Catch: java.lang.Throwable -> L28
                goto L2a
            L28:
                r1 = move-exception
                goto L50
            L2a:
                y0.a r1 = r5.f25900b     // Catch: java.lang.Throwable -> L28
                boolean r1 = y0.a.v(r1)     // Catch: java.lang.Throwable -> L28
                y0.a r2 = r5.f25900b     // Catch: java.lang.Throwable -> L28
                java.util.Map r2 = y0.a.w(r2)     // Catch: java.lang.Throwable -> L28
                java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L28
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L28
            L3e:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L28
                if (r3 == 0) goto L55
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L28
                com.bytedance.apm.battery.stats.IBatteryStats r3 = (com.bytedance.apm.battery.stats.IBatteryStats) r3     // Catch: java.lang.Throwable -> L28
                boolean r4 = r5.f25899a     // Catch: java.lang.Throwable -> L28
                r3.onChargeStatusChange(r4, r1)     // Catch: java.lang.Throwable -> L28
                goto L3e
            L50:
                java.lang.String r2 = "ChargingStatusChange"
                i6.a.d(r1, r2)     // Catch: java.lang.Throwable -> L5e
            L55:
                y0.a r1 = r5.f25900b     // Catch: java.lang.Throwable -> L5e
                boolean r5 = r5.f25899a     // Catch: java.lang.Throwable -> L5e
                y0.a.x(r1, r5)     // Catch: java.lang.Throwable -> L5e
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                return
            L5e:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: y0.a.RunnableC0407a.run():void");
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25901a;

        public b(a r10) {
            this.f25901a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                java.lang.Object r0 = y0.a.u()
                monitor-enter(r0)
                r1 = 1
                boolean r2 = w0.c.B()     // Catch: java.lang.Throwable -> L18
                if (r2 == 0) goto L1a
                java.lang.String r2 = s1.b.f24484b     // Catch: java.lang.Throwable -> L18
                java.lang.String r3 = "onChangeToFront, record data"
                java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L18
                s1.c.d(r2, r3)     // Catch: java.lang.Throwable -> L18
                goto L1a
            L18:
                r2 = move-exception
                goto L45
            L1a:
                java.lang.String r2 = "APM-Battery"
                java.lang.String r3 = "ToFrontIn"
                s1.a.d(r2, r3)     // Catch: java.lang.Throwable -> L18
                y0.a r2 = r5.f25901a     // Catch: java.lang.Throwable -> L18
                boolean r2 = y0.a.y(r2, r1)     // Catch: java.lang.Throwable -> L18
                y0.a r3 = r5.f25901a     // Catch: java.lang.Throwable -> L18
                java.util.Map r3 = y0.a.w(r3)     // Catch: java.lang.Throwable -> L18
                java.util.Collection r3 = r3.values()     // Catch: java.lang.Throwable -> L18
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L18
            L35:
                boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L18
                if (r4 == 0) goto L4a
                java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L18
                com.bytedance.apm.battery.stats.IBatteryStats r4 = (com.bytedance.apm.battery.stats.IBatteryStats) r4     // Catch: java.lang.Throwable -> L18
                r4.onFront(r2)     // Catch: java.lang.Throwable -> L18
                goto L35
            L45:
                java.lang.String r3 = "recordFrontData"
                i6.a.d(r2, r3)     // Catch: java.lang.Throwable -> L60
            L4a:
                d1.a r2 = d1.a.h()     // Catch: java.lang.Throwable -> L60
                com.bytedance.apm.core.ActivityLifeObserver r3 = com.bytedance.apm.core.ActivityLifeObserver.getInstance()     // Catch: java.lang.Throwable -> L60
                java.lang.String r3 = r3.getTopActivityClassName()     // Catch: java.lang.Throwable -> L60
                r2.p(r3)     // Catch: java.lang.Throwable -> L60
                y0.a r5 = r5.f25901a     // Catch: java.lang.Throwable -> L60
                y0.a.A(r5, r1)     // Catch: java.lang.Throwable -> L60
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
                return
            L60:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: y0.a.b.run():void");
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25902a;

        public c(a r10) {
            this.f25902a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                java.lang.Object r0 = y0.a.u()
                monitor-enter(r0)
                boolean r1 = w0.c.B()     // Catch: java.lang.Throwable -> L17
                if (r1 == 0) goto L19
                java.lang.String r1 = s1.b.f24484b     // Catch: java.lang.Throwable -> L17
                java.lang.String r2 = "onChangeToBack, record data"
                java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L17
                s1.c.d(r1, r2)     // Catch: java.lang.Throwable -> L17
                goto L19
            L17:
                r1 = move-exception
                goto L45
            L19:
                java.lang.String r1 = "APM-Battery"
                java.lang.String r2 = "ToBackIn"
                s1.a.d(r1, r2)     // Catch: java.lang.Throwable -> L17
                y0.a r1 = r4.f25902a     // Catch: java.lang.Throwable -> L17
                r2 = 1
                boolean r1 = y0.a.y(r1, r2)     // Catch: java.lang.Throwable -> L17
                y0.a r2 = r4.f25902a     // Catch: java.lang.Throwable -> L17
                java.util.Map r2 = y0.a.w(r2)     // Catch: java.lang.Throwable -> L17
                java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L17
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L17
            L35:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L17
                if (r3 == 0) goto L4a
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L17
                com.bytedance.apm.battery.stats.IBatteryStats r3 = (com.bytedance.apm.battery.stats.IBatteryStats) r3     // Catch: java.lang.Throwable -> L17
                r3.onBack(r1)     // Catch: java.lang.Throwable -> L17
                goto L35
            L45:
                java.lang.String r2 = "recordBackgroundData"
                i6.a.d(r1, r2)     // Catch: java.lang.Throwable -> L52
            L4a:
                y0.a r4 = r4.f25902a     // Catch: java.lang.Throwable -> L52
                r1 = 0
                y0.a.A(r4, r1)     // Catch: java.lang.Throwable -> L52
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L52
                return
            L52:
                r4 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L52
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: y0.a.c.run():void");
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25903a;

        public d(a r10) {
            this.f25903a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                java.lang.Object r0 = y0.a.u()
                monitor-enter(r0)
                boolean r1 = w0.c.B()     // Catch: java.lang.Throwable -> L2e
                if (r1 == 0) goto L30
                java.lang.String r1 = s1.b.f24484b     // Catch: java.lang.Throwable -> L2e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
                r2.<init>()     // Catch: java.lang.Throwable -> L2e
                java.lang.String r3 = "onTimer record, current is background? : "
                r2.append(r3)     // Catch: java.lang.Throwable -> L2e
                com.bytedance.apm.core.ActivityLifeObserver r3 = com.bytedance.apm.core.ActivityLifeObserver.getInstance()     // Catch: java.lang.Throwable -> L2e
                boolean r3 = r3.isForeground()     // Catch: java.lang.Throwable -> L2e
                r2.append(r3)     // Catch: java.lang.Throwable -> L2e
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2e
                java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L2e
                s1.c.d(r1, r2)     // Catch: java.lang.Throwable -> L2e
                goto L30
            L2e:
                r11 = move-exception
                goto L96
            L30:
                java.lang.String r1 = "APM-Battery"
                java.lang.String r2 = "OnTimerIn"
                s1.a.d(r1, r2)     // Catch: java.lang.Throwable -> L2e
                y0.a r1 = r11.f25903a     // Catch: java.lang.Throwable -> L2e
                r2 = 1
                boolean r1 = y0.a.y(r1, r2)     // Catch: java.lang.Throwable -> L2e
                y0.a r3 = r11.f25903a     // Catch: java.lang.Throwable -> L2e
                java.util.Map r3 = y0.a.w(r3)     // Catch: java.lang.Throwable -> L2e
                java.util.Collection r3 = r3.values()     // Catch: java.lang.Throwable -> L2e
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L2e
            L4c:
                boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L2e
                if (r4 == 0) goto L5c
                java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L2e
                com.bytedance.apm.battery.stats.IBatteryStats r4 = (com.bytedance.apm.battery.stats.IBatteryStats) r4     // Catch: java.lang.Throwable -> L2e
                r4.onTimer(r1)     // Catch: java.lang.Throwable -> L2e
                goto L4c
            L5c:
                long r3 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L2e
                y0.a r1 = r11.f25903a     // Catch: java.lang.Throwable -> L2e
                boolean r1 = y0.a.n(r1)     // Catch: java.lang.Throwable -> L2e
                if (r1 == 0) goto L9b
                y0.a r1 = r11.f25903a     // Catch: java.lang.Throwable -> L2e
                long r5 = y0.a.o(r1)     // Catch: java.lang.Throwable -> L2e
                long r5 = r3 - r5
                y0.a r1 = r11.f25903a     // Catch: java.lang.Throwable -> L2e
                long r7 = y0.a.q(r1)     // Catch: java.lang.Throwable -> L2e
                r9 = 60000(0xea60, double:2.9644E-319)
                long r7 = r7 * r9
                int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                r5 = 0
                if (r1 <= 0) goto L80
                goto L81
            L80:
                r2 = r5
            L81:
                boolean r1 = w0.c.F()     // Catch: java.lang.Throwable -> L2e
                if (r1 == 0) goto L9b
                if (r2 == 0) goto L9b
                d1.a r1 = d1.a.h()     // Catch: java.lang.Throwable -> L2e
                r1.k(r5)     // Catch: java.lang.Throwable -> L2e
                y0.a r11 = r11.f25903a     // Catch: java.lang.Throwable -> L2e
                y0.a.p(r11, r3)     // Catch: java.lang.Throwable -> L2e
                goto L9b
            L96:
                java.lang.String r1 = "onStart"
                i6.a.d(r11, r1)     // Catch: java.lang.Throwable -> L9d
            L9b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L9d
                return
            L9d:
                r11 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L9d
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: y0.a.d.run():void");
        }
    }

    public class e implements TaskRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25904a;

        public e(a r10) {
            this.f25904a = r10;
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public String getTaskName() {
            return "BatteryCollector-mTimerRunnable";
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25904a.h();
        }
    }

    public class f implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25905a;

        public f(a r10) {
            this.f25905a = r10;
        }

        public int a(x1.a r10, x1.a r11) {
            return (int) (r11.f25417c - r10.f25417c);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((x1.a) r10, (x1.a) r11);
        }
    }

    public class g implements TaskRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25906a;

        public g(a r10) {
            this.f25906a = r10;
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public String getTaskName() {
            return "BatteryCollector-UpdateThreadRecord";
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.r(this.f25906a);     // Catch: Throwable -> L7
            if (a.z(this.f25906a) == false) goto L11;
            if (a.s(this.f25906a).containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_FRONT_CAPTURE_PERIOD) == false) goto L9;
            int r10 = ((Integer) a.s(this.f25906a).get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_FRONT_CAPTURE_PERIOD)).intValue();     // Catch: Throwable -> L7
        L14:
            AsyncEventManager.e().d(a.t(this.f25906a), r10 * 1000);     // Catch: Throwable -> L7
            return;
        L9:
            r10 = 5;
            goto L14
        L11:
            if (a.s(this.f25906a).containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_BACKGROUND_CAPTURE_PERIOD) == false) goto L13;
            r10 = ((Integer) a.s(this.f25906a).get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_BACKGROUND_CAPTURE_PERIOD)).intValue();     // Catch: Throwable -> L7
            goto L14
        L13:
            r10 = 20;
        L7:
            th = move-exception;
            i6.a.d(th, "mUpdateThreadRecordRunnable");
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25907a = null;

        static {
            f25907a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f25907a;
        }
    }

    static {
        C = new Object();
    }

    public /* synthetic */ a(RunnableC0407a r10) {
        this();
    }

    public static /* synthetic */ boolean A(a r10, boolean r11) {
        r10.f25881i = r11;
        return r11;
    }

    public static a E() {
        return h.a();
    }

    public static /* synthetic */ boolean n(a r10) {
        return r10.f25882j;
    }

    public static /* synthetic */ long o(a r10) {
        return r10.f25885m;
    }

    public static /* synthetic */ long p(a r10, long r11) {
        r10.f25885m = r11;
        return r11;
    }

    public static /* synthetic */ long q(a r10) {
        return r10.f25884l;
    }

    public static /* synthetic */ void r(a r10) {
        r10.P();
    }

    public static /* synthetic */ HashMap s(a r10) {
        return r10.f25897y;
    }

    public static /* synthetic */ TaskRunnable t(a r10) {
        return r10.B;
    }

    public static /* synthetic */ Object u() {
        return C;
    }

    public static /* synthetic */ boolean v(a r10) {
        return r10.M();
    }

    public static /* synthetic */ Map w(a r10) {
        return r10.f25879g;
    }

    public static /* synthetic */ boolean x(a r10, boolean r11) {
        r10.f25898z = r11;
        return r11;
    }

    public static /* synthetic */ boolean y(a r10, boolean r11) {
        return r10.N(r11);
    }

    public static /* synthetic */ boolean z(a r10) {
        return r10.f25881i;
    }

    public final boolean B() {
        if (BatteryAgent.hasHook() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f25897y.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE) == true) goto L7;
    L8:
        return true;
    L7:
        if (((Integer) this.f25897y.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE)).intValue() == 0) goto L9;
        goto L8
    }

    public Map C() {
        return this.f25879g;
    }

    public String D() {
        return this.f25893u;
    }

    public void F(boolean r10) {
        this.f25887o = r10;
        c();
    }

    public final boolean G() {
        if (Build.VERSION.SDK_INT <= this.f25889q) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean H() {
        return this.f25888p;
    }

    public final boolean I(long r10) {
        if (this.f25881i == false) goto L13;
        if (this.f25897y.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FRONT_VALID_DURATION) == false) goto L7;
        int r11 = ((Integer) this.f25897y.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FRONT_VALID_DURATION)).intValue();
    L9:
        if (r10 > (r11 * 1000)) goto L11;
        return false;
    L11:
        return true;
    L7:
        r11 = 20;
        goto L9
    L13:
        if (this.f25897y.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_BACKGROUND_VALID_DURATION) == false) goto L15;
        int r12 = ((Integer) this.f25897y.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_BACKGROUND_VALID_DURATION)).intValue();
    L17:
        if (r10 > (r12 * 1000)) goto L19;
        return false;
    L19:
        return true;
    L15:
        r12 = 60;
        goto L17
    }

    public final void J(long r12) {
        int r10 = 5;
        if (this.f25881i == true) goto L12;
        if (TextUtils.isEmpty(this.f25893u) == false) goto L12;
        if (this.f25897y.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_BACKGROUND_THRESHOLD) == false) goto L10;
        int r11 = ((Integer) this.f25897y.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_BACKGROUND_THRESHOLD)).intValue();
    L15:
        Map<String, BatteryAgent.MethodExecutedValue> r13 = BatteryAgent.filterResultAndClear((((long) r11) * r12) / 100);
        if (I(r12) == false) goto L41;
        JSONObject r14 = new JSONObject();
        int r15 = 0;
        boolean r16 = true;
        if (r13.isEmpty() == true) goto L24;
        JSONArray r17 = new JSONArray();
        Iterator<Map.Entry<String, BatteryAgent.MethodExecutedValue>> r18 = r13.entrySet().iterator();
    L21:
        if (r18.hasNext() == false) goto L23;
        Map.Entry<String, BatteryAgent.MethodExecutedValue> r19 = r18.next();
        JSONObject r20 = new JSONObject();
        r20.putOpt("method", r19.getKey());
        r20.putOpt("exe_count", Integer.valueOf(r19.getValue().getCount()));
        r20.putOpt("cpu_cost", Integer.valueOf(r19.getValue().getCost()));
        r17.put(r20);
        goto L21
    L23:
        r14.putOpt("functions", r17);
        boolean r21 = true;
    L26:
        if (this.f25895w.isEmpty() == true) goto L34;
        ArrayList r22 = new ArrayList(this.f25895w.values());
        Collections.sort(r22, new f(this));
        JSONArray r23 = new JSONArray();
        if (this.f25897y.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_COUNT) == false) goto L31;
        r10 = ((Integer) this.f25897y.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_COUNT)).intValue();
    L31:
        if (r15 >= Math.min(r22.size(), r10)) goto L33;
        x1.a r24 = (x1.a) r22.get(r15);
        JSONObject r25 = new JSONObject();
        r15 = r15 + 1;
        r25.putOpt(NetValue.TYPE_RANK, Integer.valueOf(r15));
        r25.putOpt("thread_name", r24.f25416b);
        r25.putOpt("cpu_cost", Long.valueOf(r24.f25417c));
        r23.put(r25);
        goto L31
    L33:
        r14.putOpt("threads", r23);
    L35:
        if (r16 == false) goto L41;
        if (this.f25881i == false) goto L39;
        String r26 = d1.a.h().g();
    L40:
        JSONObject r27 = new JSONObject();
        r27.putOpt("scene", r26);
        JSONObject r28 = new JSONObject();
        r28.putOpt("stay_duration", Long.valueOf(r12));
        s1.a.d(Constants.TAG_BATTERY_LOCAL, "scene:" + r26 + " stayDuration:" + r12 + " data:" + r14.toString());
        ApmAgent.h("monitor_expend_function", r27, r28, r14);
        goto L41
    L39:
        r26 = "background";
        goto L40
    L34:
        r16 = r21;
        goto L35
    L24:
        r21 = false;
    L41:
        O();
        return;
    L10:
        r11 = 2;
    L12:
        if (this.f25897y.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_FRONT_THRESHOLD) == false) goto L14;
        r11 = ((Integer) this.f25897y.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_FRONT_THRESHOLD)).intValue();
        goto L15
    L14:
        r11 = 5;
        goto L15
    }

    public final void K() {
        if (G() == false) goto L5;
        return;
    L5:
        s1.a.d(Constants.TAG_BATTERY, "ToBack");
        d1.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.e().c(new c(this));
    }

    public final void L(String r10) {
        if (G() == false) goto L5;
        return;
    L5:
        s1.a.d(Constants.TAG_BATTERY, "ToFront:" + r10);
        d1.a.h().p(r10);
        AsyncEventManager.e().c(new b(this));
    }

    public final boolean M() {
        return N(false);
    }

    public final boolean N(boolean r19) {
        long r10 = SystemClock.elapsedRealtime();
        long r11 = r10 - this.f25880h;
        if (r11 <= AnimationConstants.DURATION_2000L) goto L6;
        boolean r12 = true;
    L5:
        boolean r14 = r12;
        if (this.f25880h == (-1)) goto L15;
        if (r14 == false) goto L15;
        boolean r17 = r14;
        d1.a.h().l(new p1.a(this.f25881i, System.currentTimeMillis(), BatteryTypeInf.BATTERY_GROUND_RECORD, this.f25898z, r11, this.f25893u));
        if (this.f25881i == false) goto L17;
        if (r11 <= 7200000) goto L17;
        HashMap r13 = new HashMap();
        r13.put("duration", String.valueOf(r11));
        i6.a.b("BatterErrorDuration", r13);
    L17:
        if (this.f25880h == (-1)) goto L22;
        if (r19 == false) goto L22;
        if (B() == false) goto L22;
        J(r11);
    L22:
        this.f25880h = r10;
        return r17;
    L15:
        r17 = r14;
        goto L17
    L6:
        r12 = false;
        goto L5
    }

    public final void O() {
        this.f25894v.clear();
        this.f25895w.clear();
        LinkedList r10 = x1.b.a(Process.myPid());
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L13;
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L14;
        x1.a r12 = (x1.a) r11.next();
        this.f25894v.put(Integer.valueOf(r12.f25415a), r12);
        goto L9
    L14:
        return;
    }

    public final void P() {
        if (this.f25894v.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedList r10 = x1.b.a(Process.myPid());
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.isEmpty() == true) goto L32;
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L33;
        x1.a r12 = (x1.a) r11.next();
        if (this.f25894v.containsKey(Integer.valueOf(r12.f25415a)) == false) goto L16;
        long r13 = r12.f25417c - ((x1.a) this.f25894v.get(Integer.valueOf(r12.f25415a))).f25417c;
    L18:
        if (r13 <= 0) goto L12;
        long r14 = (long) ((r13 / this.f25896x) * 1000.0d);
        if (this.f25895w.containsKey(Integer.valueOf(r12.f25415a)) == true) goto L21;
        this.f25895w.put(Integer.valueOf(r12.f25415a), new x1.a(r12.f25415a, r12.f25416b, r14));
        goto L12
    L21:
        ((x1.a) this.f25895w.get(Integer.valueOf(r12.f25415a))).a(r14);
        goto L12
    L16:
        r13 = r12.f25417c;
        goto L18
    L33:
        return;
    }

    @Override // v1.a
    public void b(JSONObject r14) {
        this.f25883k = r14.optLong(SlardarSettingsConsts.PERF_BATTERY_RECORD_INTERVAL, 10);
        this.f25884l = r14.optLong(SlardarSettingsConsts.PERF_BATTERY_REPORT_INTERVAL, 30);
        int r10 = r14.optInt("enable_upload", 0);
        if (r10 == 1) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.f25882j = r11;
        this.f25889q = r14.optInt(SlardarSettingsConsts.PERF_BATTERY_SUPPORT_MAX_API_LEVEL, this.f25889q);
        if (w0.c.B() == false) goto L12;
        s1.c.c(s1.b.f24484b, new String[]{"mRecordInterval:" + this.f25883k + ",mBatteryCollectEnabled" + r10});
    L12:
        if (this.f25882j == true) goto L17;
        if (this.f25887o == true) goto L17;
        this.f25879g.clear();
        ActivityLifeObserver.getInstance().unregister(this);
        BatteryUtils.g(w0.c.g(), this);
    L20:
        if (r14.optInt(SlardarSettingsConsts.PERF_BATTERY_TRACE_ENABLE, 0) != 1) goto L22;
        boolean r12 = true;
    L23:
        this.f25888p = r12;
        if (this.f25888p == false) goto L26;
        z0.a.k(r14.optLong("max_single_wake_lock_hold_time_second", 120) * 1000);
        z0.a.n(r14.optInt("max_total_wake_lock_acquire_count", 5));
        z0.a.o(r14.optLong("max_total_wake_lock_hold_time_second", 240) * 1000);
        z0.a.p(r14.optInt("max_wake_up_alarm_invoke_count", 5));
        z0.a.i(r14.optInt("max_normal_alarm_invoke_count", 10));
        z0.a.j(r14.optLong("max_single_loc_request_time_second", 120) * 1000);
        z0.a.l(r14.optInt("max_total_loc_request_count", 5));
        z0.a.m(r14.optLong("max_total_loc_request_time_second", 240) * 1000);
    L26:
        JSONObject r13 = r14.optJSONObject(SlardarSettingsConsts.PERF_BATTERY_CPU_MONITOR_CONFIG);
        if (r13 == null) goto L37;
        Iterator<String> r15 = r13.keys();
    L30:
        if (r15.hasNext() == false) goto L37;
        String r16 = r15.next();
        if (SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE.equals(r16) == true) goto L33;
        int r17 = r13.optInt(r16, 0);
        if (r17 <= 0) goto L30;
        this.f25897y.put(r16, Integer.valueOf(r17));
        goto L30
    L33:
        this.f25897y.put(r16, Integer.valueOf(r13.optInt(r16, 1)));
    L37:
        this.f25886n = n.d(r14, SlardarSettingsConsts.PERF_BATTERY_SCENE_BLACK_LIST);
        if (B() == false) goto L49;
        AsyncEventManager.e().c(this.B);
        O();
        return;
    L49:
        return;
    L22:
        r12 = false;
    L17:
        if (r14.optInt(SlardarSettingsConsts.PERF_BATTERY_NET_ALL_INTERFACE_ENABLE, 0) != 1) goto L20;
        this.f25879g.put(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, new i());
        goto L20
    L5:
        if (this.f25883k <= 0) goto L7;
        r11 = true;
        goto L8
    }

    @Override // v1.a
    public boolean e() {
        return false;
    }

    @Override // v1.a
    public void g() {
        if (G() == false) goto L5;
        return;
    L5:
        s1.a.d(Constants.TAG_BATTERY, "Battery init process" + w0.c.h());
        this.f25881i = ActivityLifeObserver.getInstance().isForeground();
        this.f25891s[1] = ActivityLifeObserver.getInstance().getTopActivityClassName();
        this.f25896x = com.bytedance.apm.util.b.h(100);
        this.f25898z = BatteryUtils.d(w0.c.g(), this);
        e1.d r10 = new e1.d();
        e1.g r11 = new e1.g();
        k r12 = new k();
        c1.a r13 = new c1.a();     // Catch: Throwable -> L8
        r13.a(BatteryTypeInf.BATTERY_ALARM, r10);     // Catch: Throwable -> L8
        r13.a("location", r11);     // Catch: Throwable -> L8
        r13.a(BatteryTypeInf.BATTERY_POWER_LOCK, r12);     // Catch: Throwable -> L8
        r13.b();     // Catch: Throwable -> L8
        this.f25879g.put(BatteryTypeInf.BATTERY_ALARM, r10);     // Catch: Throwable -> L8
        this.f25879g.put("location", r11);     // Catch: Throwable -> L8
        this.f25879g.put(BatteryTypeInf.BATTERY_POWER_LOCK, r12);     // Catch: Throwable -> L8
    L10:
        e1.f r14 = new e1.f();
        j r15 = new j();
        e1.h r16 = new e1.h();
        e1.e r17 = new e1.e();
        this.f25879g.put(BatteryTypeInf.BATTERY_CPU_ACTIVE, r14);
        this.f25879g.put("traffic", r15);
        this.f25879g.put(BatteryTypeInf.BATTERY_PACKETS, r16);
        this.f25879g.put(BatteryTypeInf.BATTERY_CONSUME, r17);
        this.f25885m = SystemClock.elapsedRealtime();
        return;
    L8:
        th = move-exception;
        s1.a.a(Constants.TAG_BATTERY, "SYSTEM_SERVICE_FETCHERS hook failed: " + th.getMessage());
        goto L10
    }

    @Override // v1.a
    public void h() {
        if (G() == false) goto L5;
        return;
    L5:
        if (this.f25879g.isEmpty() == true) goto L13;
        s1.a.d(Constants.TAG_BATTERY, "OnTimer");
        long r10 = m();
        if (r10 <= 0) goto L10;
        AsyncEventManager.e().d(this.A, r10);
    L10:
        d1.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.e().c(new d(this));
        return;
    }

    @Override // v1.a
    public long m() {
        return this.f25883k * 60000;
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r10) {
        super.onActivityResume(r10);
        String[] r11 = this.f25891s;
        r11[0] = r11[1];
        r11[1] = r10.getClass().getName();
        if (TextUtils.equals(r10.getClass().getName(), this.f25890r) == false) goto L5;
    L7:
        this.f25890r = null;
        return;
    L5:
        if (TextUtils.isEmpty(this.f25891s[0]) == true) goto L7;
        L(this.f25891s[0]);
        goto L7
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        K();
    }

    @Override // com.bytedance.apm.battery.util.BatteryUtils.ChargeListener
    public void onChange(boolean r10) {
        if (this.f25879g.isEmpty() == false) goto L5;
        return;
    L5:
        d1.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.e().c(new RunnableC0407a(this, r10));
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        super.onFront(r10);
        this.f25890r = r10.getClass().getName();
        L(ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    @Override // v1.a, com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        super.onReady();
        if (w0.c.F() == true) goto L5;
        return;
    L5:
        if (this.f25882j == false) goto L9;
        d1.a.h().k(true);
        this.f25885m = SystemClock.elapsedRealtime();
        return;
    }

    public a() {
        this.f25879g = new ConcurrentHashMap();
        this.f25880h = -1;
        this.f25882j = false;
        this.f25884l = 30;
        this.f25885m = -1;
        this.f25889q = 32;
        this.f25891s = new String[2];
        this.f25892t = new ArrayList();
        this.f25894v = new HashMap();
        this.f25895w = new HashMap();
        this.f25897y = new HashMap();
        this.A = new e(this);
        this.B = new g(this);
        this.f24971e = "battery";
    }
}
