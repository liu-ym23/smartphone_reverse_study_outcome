package com.android.server.am;

import android.app.ActivityManager;
import android.app.ApplicationErrorReport;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.os.StabTrace;
import android.provider.Settings;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.os.ProcfsMemoryUtil;
import com.android.internal.os.anr.AnrLatencyTracker;
import com.android.server.Watchdog;
import com.android.server.am.trace.SmartTraceUtils;
import com.android.server.scene.SceneUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
class ProcessErrorStateRecord {
    private String mAnrAnnotation;
    private AppNotRespondingDialog.Data mAnrData;
    final ProcessRecord mApp;
    private boolean mBad;
    private Runnable mCrashHandler;
    private boolean mCrashing;
    private ActivityManager.ProcessErrorStateInfo mCrashingReport;
    private boolean mDefered;
    private final ErrorDialogController mDialogController;
    private ComponentName mErrorReportReceiver;
    private boolean mForceCrashReport;
    private boolean mNotResponding;
    private ActivityManager.ProcessErrorStateInfo mNotRespondingReport;
    private final ActivityManagerGlobalLock mProcLock;
    private final ActivityManagerService mService;

    public static /* synthetic */ void $r8$lambda$1SErgedD3L1MO4qox_3h28fgaEY(ProcessErrorStateRecord r0) {
        r0.lambda$appNotResponding$6();
    }

    public static /* synthetic */ void $r8$lambda$F06Nb3nHkv58Y7Kc0ZJesSPylQA() {
        lambda$appNotResponding$2();
    }

    public static /* synthetic */ void $r8$lambda$JOKp8PxRjJQFJ_muW70RAHBH8YU(ProcessErrorStateRecord r0, AnrLatencyTracker r1, String r2) {
        r0.lambda$appNotResponding$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$hmeP4SgVM-wKLFwe9elqPdGyiMo, reason: not valid java name */
    public static /* synthetic */ void m1555$r8$lambda$hmeP4SgVMwKLFwe9elqPdGyiMo(ProcessErrorStateRecord r0) {
        r0.lambda$appNotResponding$5();
    }

    public static /* synthetic */ void $r8$lambda$iJnj86igrSWbTddnzSwFSnBtv04(ProcessErrorStateRecord r0, AnrLatencyTracker r1) {
        r0.lambda$appNotResponding$1(r1);
    }

    public static /* synthetic */ ArrayList $r8$lambda$owk29lk9HBK5Rm8BXqJsW21pN8s(ProcessErrorStateRecord r0, AnrLatencyTracker r1, boolean r2, boolean r3, int r4, boolean r5, ArrayList r6) {
        return r0.lambda$appNotResponding$4(r1, r2, r3, r4, r5, r6);
    }

    boolean isBad() {
        return this.mBad;
    }

    void setBad(boolean bad) {
        this.mBad = bad;
    }

    boolean isCrashing() {
        return this.mCrashing;
    }

    void setCrashing(boolean crashing) {
        this.mCrashing = crashing;
        this.mApp.getWindowProcessController().setCrashing(crashing);
    }

    boolean isForceCrashReport() {
        return this.mForceCrashReport;
    }

    void setForceCrashReport(boolean forceCrashReport) {
        this.mForceCrashReport = forceCrashReport;
    }

    boolean isNotResponding() {
        return this.mNotResponding;
    }

    void setNotResponding(boolean notResponding) {
        this.mNotResponding = notResponding;
        this.mApp.getWindowProcessController().setNotResponding(notResponding);
    }

    boolean isDefered() {
        return this.mDefered;
    }

    void setDefered(boolean defer) {
        this.mDefered = defer;
    }

    Runnable getCrashHandler() {
        return this.mCrashHandler;
    }

    void setCrashHandler(Runnable crashHandler) {
        this.mCrashHandler = crashHandler;
    }

    ActivityManager.ProcessErrorStateInfo getCrashingReport() {
        return this.mCrashingReport;
    }

    void setCrashingReport(ActivityManager.ProcessErrorStateInfo crashingReport) {
        this.mCrashingReport = crashingReport;
    }

    String getAnrAnnotation() {
        return this.mAnrAnnotation;
    }

    void setAnrAnnotation(String anrAnnotation) {
        this.mAnrAnnotation = anrAnnotation;
    }

    ActivityManager.ProcessErrorStateInfo getNotRespondingReport() {
        return this.mNotRespondingReport;
    }

    void setNotRespondingReport(ActivityManager.ProcessErrorStateInfo notRespondingReport) {
        this.mNotRespondingReport = notRespondingReport;
    }

    ComponentName getErrorReportReceiver() {
        return this.mErrorReportReceiver;
    }

    void setErrorReportReceiver(ComponentName errorReportReceiver) {
        this.mErrorReportReceiver = errorReportReceiver;
    }

    ErrorDialogController getDialogController() {
        return this.mDialogController;
    }

    void setAnrData(AppNotRespondingDialog.Data data) {
        this.mAnrData = data;
    }

    AppNotRespondingDialog.Data getAnrData() {
        return this.mAnrData;
    }

    ProcessErrorStateRecord(ProcessRecord app) {
        this.mApp = app;
        this.mService = app.mService;
        this.mProcLock = this.mService.mProcLock;
        this.mDialogController = new ErrorDialogController(app);
    }

    boolean skipAnrLocked(String annotation) {
        if (this.mService.mAtmInternal.isShuttingDown() == false) goto L7;
        Slog.i("ActivityManager", "During shutdown skipping ANR: " + this + " " + annotation);
        return true;
    L7:
        if (isNotResponding() == false) goto L11;
        Slog.i("ActivityManager", "Skipping duplicate ANR: " + this + " " + annotation);
        return true;
    L11:
        if (isCrashing() == false) goto L15;
        Slog.i("ActivityManager", "Crashing app skipping ANR: " + this + " " + annotation);
        return true;
    L15:
        if (this.mApp.isKilledByAm() == false) goto L19;
        Slog.i("ActivityManager", "App already killed by AM skipping ANR: " + this + " " + annotation);
        return true;
    L19:
        if (this.mApp.isKilled() == false) goto L23;
        Slog.i("ActivityManager", "Skipping died app ANR: " + this + " " + annotation);
        return true;
    L23:
        if (this.mApp.getPid() != 0) goto L26;
        Slog.i("ActivityManager", "skip died app ANR: " + annotation + ",previous crashed pid=" + this.mApp.mCrashPid);
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Failed to calculate best type for var: r15v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v24 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v28 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v28 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v28 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v28 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v29 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v29 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v33 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v33 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v20 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v20 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v28 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    void appNotResponding(java.lang.String r65, android.content.pm.ApplicationInfo r66, java.lang.String r67, com.android.server.wm.WindowProcessController r68, boolean r69, com.android.internal.os.TimeoutRecord r70, java.util.concurrent.ExecutorService r71, boolean r72, boolean r73) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x099f: MOVE (r6v33 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (2 ??[int, float, short, byte, char]) A[DECLARE_VAR] (LINE:876) in method: com.android.server.am.ProcessErrorStateRecord.appNotResponding(java.lang.String, android.content.pm.ApplicationInfo, java.lang.String, com.android.server.wm.WindowProcessController, boolean, com.android.internal.os.TimeoutRecord, java.util.concurrent.ExecutorService, boolean, boolean):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 3370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.am.ProcessErrorStateRecord.appNotResponding(java.lang.String, android.content.pm.ApplicationInfo, java.lang.String, com.android.server.wm.WindowProcessController, boolean, com.android.internal.os.TimeoutRecord, java.util.concurrent.ExecutorService, boolean, boolean):void");
    }

    private /* synthetic */ void lambda$appNotResponding$0(AnrLatencyTracker latencyTracker, String annotation) {
        latencyTracker.waitingOnAMSLockStarted();
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        latencyTracker.waitingOnAMSLockEnded();     // Catch: Throwable -> L8
        setAnrAnnotation(annotation);     // Catch: Throwable -> L8
        this.mApp.killLocked("anr", 6, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$appNotResponding$1(AnrLatencyTracker latencyTracker) {
        latencyTracker.updateCpuStatsNowCalled();
        this.mService.updateCpuStatsNow();
        latencyTracker.updateCpuStatsNowReturned();
    }

    private static /* synthetic */ void lambda$appNotResponding$2() {
        StabTrace.writeTraceInfoToFile("/data/stabd/trace_system_server.txt");
    }

    private static /* synthetic */ void lambda$appNotResponding$3(int pid, int ppid, ArrayList firstPids, SparseBooleanArray lastPids, ProcessRecord r) {
        if (r != null) goto L4;
        return;
    L4:
        if (r.getThread() == null) goto L26;
        int myPid = r.getPid();
        if (myPid <= 0) goto L27;
        if (myPid == pid) goto L28;
        if (myPid != ppid) goto L10;
        return;
    L10:
        if (myPid != ActivityManagerService.MY_PID) goto L12;
        return;
    L12:
        if (r.isPersistent() == false) goto L17;
        firstPids.add(Integer.valueOf(myPid));
        if (ActivityManagerDebugConfig.DEBUG_ANR == false) goto L31;
        Slog.i("ActivityManager", "Adding persistent proc: " + r);
        return;
    L31:
        return;
    L17:
        if (r.mServices.isTreatedLikeActivity() == false) goto L21;
        firstPids.add(Integer.valueOf(myPid));
        if (ActivityManagerDebugConfig.DEBUG_ANR == false) goto L33;
        Slog.i("ActivityManager", "Adding likely IME: " + r);
        return;
    L33:
        return;
    L21:
        lastPids.put(myPid, true);
        if (ActivityManagerDebugConfig.DEBUG_ANR == false) goto L35;
        Slog.i("ActivityManager", "Adding ANR proc: " + r);
        return;
    L35:
        return;
    L28:
        return;
    L27:
        return;
    }

    private /* synthetic */ ArrayList lambda$appNotResponding$4(AnrLatencyTracker latencyTracker, boolean isSilentAnr, boolean onlyDumpSelf, int pid, boolean smTraceEnabled, ArrayList firstPids) throws Exception {
        latencyTracker.nativePidCollectionStarted();
        ArrayList<Integer> nativePids = null;
        String[] nativeProcs = null;
        int r3 = 0;
        if (this.mApp.info.isSystemApp() == false) goto L5;
    L8:
        boolean isSystemApp = true;
    L9:
        if (isSystemApp == false) goto L21;
        if (isSilentAnr == true) goto L21;
        if (onlyDumpSelf == true) goto L21;
        if (smTraceEnabled == true) goto L15;
    L16:
        nativePids = Watchdog.getInstance().getInterestingNativePidsMore(pid, false);
        if (Binder.getBinderTargetPid(pid, pid, true) != ActivityManagerService.MY_PID) goto L47;
        ArrayList<Integer> nativePidsMore = Watchdog.getInstance().getInterestingNativeBinderPids(ActivityManagerService.MY_PID);
        if (nativePidsMore.isEmpty() == true) goto L47;
        LinkedHashSet<Integer> pidSet = new LinkedHashSet(nativePidsMore);
        pidSet.addAll(nativePids);
        nativePids = new ArrayList(pidSet);
    L47:
        latencyTracker.nativePidCollectionEnded();
        if (Build.isDebuggable() == false) goto L53;
        if (firstPids.contains(Integer.valueOf(ActivityManagerService.MY_PID)) == true) goto L53;
        firstPids.add(Integer.valueOf(ActivityManagerService.MY_PID));
    L53:
        if (firstPids.contains(Integer.valueOf(ActivityManagerService.MY_PID)) == false) goto L58;
        if (nativePids == null) goto L58;
        if (nativePids.contains(Integer.valueOf(ActivityManagerService.MY_PID)) == false) goto L58;
        Integer systemServerPid = Integer.valueOf(ActivityManagerService.MY_PID);
        nativePids.remove(systemServerPid);
    L58:
        return nativePids;
    L15:
        if (SmartTraceUtils.isDumpPredefinedPidsEnabled() == false) goto L47;
    L21:
        int i = 0;
    L23:
        if (i >= Watchdog.NATIVE_STACKS_OF_INTEREST.length) goto L28;
        if (Watchdog.NATIVE_STACKS_OF_INTEREST[i].equals(this.mApp.processName) == true) goto L26;
        i = i + 1;
        goto L23
    L26:
        nativeProcs = new String[]{this.mApp.processName};
    L28:
        if (nativeProcs != null) goto L30;
        int[] pids = null;
    L31:
        if (pids == null) goto L36;
        nativePids = new ArrayList(pids.length);
        int r6 = pids.length;
    L34:
        if (r3 >= r6) goto L36;
        int i2 = pids[r3];
        nativePids.add(Integer.valueOf(i2));
        r3 = r3 + 1;
    L36:
        int serverPid = Binder.getBinderTargetPid(pid, pid, true);
        if (serverPid <= 0) goto L47;
        Slog.i("ActivityManager", "pid=" + pid + " it's main thread binder server pid=" + serverPid);
        if (nativePids != null) goto L41;
        nativePids = new ArrayList();
    L41:
        nativePids.add(Integer.valueOf(serverPid));
        if (Build.IS_DEBUGGABLE == false) goto L47;
        ArrayList<Integer> nativePidsMore2 = Watchdog.getInstance().getInterestingNativeBinderPids(serverPid);
        if (nativePidsMore2.isEmpty() == true) goto L47;
        LinkedHashSet<Integer> pidSet2 = new LinkedHashSet(nativePidsMore2);
        pidSet2.addAll(nativePids);
        nativePids = new ArrayList(pidSet2);
        goto L47
    L30:
        pids = Process.getPidsForCommands(nativeProcs);
        goto L31
    L5:
        if (this.mApp.info.isSystemExt() == true) goto L8;
        isSystemApp = false;
        goto L9
    }

    private /* synthetic */ void lambda$appNotResponding$5() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mApp.killLocked("anr", 6, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$appNotResponding$6() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.mServices.scheduleServiceTimeoutLocked(this.mApp);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void makeAppNotRespondingLSP(String activity, String shortMsg, String longMsg) {
        setNotResponding(true);
        if (this.mService.mAppErrors == null) goto L6;
        this.mNotRespondingReport = this.mService.mAppErrors.generateProcessError(this.mApp, 2, activity, shortMsg, longMsg, null);
    L6:
        startAppProblemLSP();
        this.mApp.getWindowProcessController().stopFreezingActivities();
    }

    private boolean isSmartTraceEnabled(boolean isSilentAnr) {
        if (SmartTraceUtils.isSmartTraceEnabled() == false) goto L9;
        if (isSilentAnr == false) goto L8;
        if (isSilentAnr == false) goto L9;
        if (SmartTraceUtils.isSmartTraceEnabledOnBgApp() == false) goto L9;
    L8:
        return true;
    L9:
        return false;
    }

    private boolean isPerfettoDumpEnabled(boolean isSilentAnr) {
        if (SmartTraceUtils.isPerfettoDumpEnabled() == false) goto L9;
        if (isSilentAnr == false) goto L8;
        if (isSilentAnr == false) goto L9;
        if (SmartTraceUtils.isPerfettoDumpEnabledOnBgApp() == false) goto L9;
    L8:
        return true;
    L9:
        return false;
    }

    private boolean shouldDeferAppNotResponding(boolean isSilentAnr) {
        if (isSmartTraceEnabled(isSilentAnr) == false) goto L5;
    L8:
        return true;
    L5:
        if (isPerfettoDumpEnabled(isSilentAnr) == true) goto L8;
        return false;
    }

    void startAppProblemLSP() {
        this.mErrorReportReceiver = null;
        int[] r0 = this.mService.mUserController.getCurrentProfileIds();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int userId = r0[r2];
        if (this.mApp.userId != userId) goto L7;
        this.mErrorReportReceiver = ApplicationErrorReport.getErrorReportReceiver(this.mService.mContext, this.mApp.info.packageName, this.mApp.info.flags);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        this.mService.getBroadcastQueue().onApplicationProblemLocked(this.mApp);
    }

    private boolean isInterestingForBackgroundTraces() {
        if (this.mApp.getPid() != ActivityManagerService.MY_PID) goto L6;
        return true;
    L6:
        if (this.mApp.isInterestingToUserLocked() == false) goto L8;
        return true;
    L8:
        if (this.mApp.info == null) goto L12;
        if (SceneUtils.PKG_SYS_UI.equals(this.mApp.info.packageName) == false) goto L12;
        return true;
    L12:
        if (this.mApp.mState.hasTopUi() == false) goto L14;
        return true;
    L14:
        if (this.mApp.mState.hasOverlayUi() == true) goto L22;
        return false;
    L22:
        return true;
    }

    private boolean getShowBackground() {
        ContentResolver resolver = this.mService.mContext.getContentResolver();
        if (Settings.Secure.getIntForUser(resolver, "anr_show_background", 0, resolver.getUserId()) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private LinkedHashMap<String, String> buildMemoryHeadersFor(int pid) {
        if (pid > 0) goto L6;
        Slog.i("ActivityManager", "Memory header requested with invalid pid: " + pid);
        return null;
    L6:
        ProcfsMemoryUtil.MemorySnapshot snapshot = ProcfsMemoryUtil.readMemorySnapshotFromProcfs(pid);
        if (snapshot != null) goto L10;
        Slog.i("ActivityManager", "Failed to get memory snapshot for pid:" + pid);
        return null;
    L10:
        LinkedHashMap<String, String> memoryHeaders = new LinkedHashMap();
        memoryHeaders.put("RssHwmKb", Integer.toString(snapshot.rssHighWaterMarkInKilobytes));
        memoryHeaders.put("RssKb", Integer.toString(snapshot.rssInKilobytes));
        memoryHeaders.put("RssAnonKb", Integer.toString(snapshot.anonRssInKilobytes));
        memoryHeaders.put("RssShmemKb", Integer.toString(snapshot.rssShmemKilobytes));
        memoryHeaders.put("VmSwapKb", Integer.toString(snapshot.swapInKilobytes));
        return memoryHeaders;
    }

    boolean isSilentAnr() {
        if (getShowBackground() == false) goto L5;
    L7:
        return false;
    L5:
        if (isInterestingForBackgroundTraces() == true) goto L7;
        return true;
    }

    boolean isMonitorCpuUsage() {
        AppProfiler r0 = this.mService.mAppProfiler;
        return true;
    }

    void onCleanupApplicationRecordLSP() {
        getDialogController().clearAllErrorDialogs();
        setCrashing(false);
        setNotResponding(false);
    }

    void dump(PrintWriter pw, String prefix, long nowUptime) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
    L15:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L5:
        if (this.mCrashing == false) goto L7;
    L17:
        pw.print(prefix);     // Catch: Throwable -> L15
        pw.print(" mCrashing=" + this.mCrashing);     // Catch: Throwable -> L15
        pw.print(" " + this.mDialogController.getCrashDialogs());     // Catch: Throwable -> L15
        pw.print(" mNotResponding=" + this.mNotResponding);     // Catch: Throwable -> L15
        pw.print(" " + this.mDialogController.getAnrDialogs());     // Catch: Throwable -> L15
        pw.print(" bad=" + this.mBad);     // Catch: Throwable -> L15
        if (this.mErrorReportReceiver == null) goto L20;
        pw.print(" errorReportReceiver=");     // Catch: Throwable -> L15
        pw.print(this.mErrorReportReceiver.flattenToShortString());     // Catch: Throwable -> L15
    L20:
        pw.println();     // Catch: Throwable -> L15
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L15
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L7:
        if (this.mDialogController.hasCrashDialogs() == true) goto L17;
        if (this.mNotResponding == true) goto L17;
        if (this.mDialogController.hasAnrDialogs() == true) goto L17;
        if (this.mBad == false) goto L21;
        goto L21
    }
}
