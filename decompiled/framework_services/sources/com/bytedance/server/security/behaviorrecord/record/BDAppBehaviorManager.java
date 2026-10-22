package com.bytedance.server.security.behaviorrecord.record;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.server.security.behaviorrecord.AppBehaviorConst;
import com.bytedance.server.security.behaviorrecord.IBDAppBehaviorRecord;
import com.bytedance.server.security.behaviorrecord.data.BehaviorRecordStorage;
import com.bytedance.server.security.broadcast.BDSecurityBroadcast;
import com.bytedance.server.security.broadcast.ISecurityBroadcastPlugin;
import com.bytedance.server.security.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public class BDAppBehaviorManager implements IBDAppBehaviorRecord {
    private static final Object S_LOCK_RECORD = null;
    private static final String TAG = "BDAppBehaviorManager";
    private static final Set<Integer> mIgnoreOps = null;
    private static final Set<String> mWhiteListPackages = null;
    private boolean isStopRecord;
    private Handler mBehaviorRecordHandler;
    private final BehaviorRecordStorage mBehaviorRecordStorage;
    private Context mContext;
    private final Map<String, String> mRecentLocationRecord;
    private final BlockingQueue<AppBehaviorInfo> mRecordQueue;
    private final LinkedHashMap<String, AppBehaviorInfo> mRecords;

    private class BDBroadcastReceiver implements ISecurityBroadcastPlugin {
        final /* synthetic */ BDAppBehaviorManager this$0;

        public static /* synthetic */ void $r8$lambda$T8sToUqPyDqFt9stkrShVFlmGrQ(StringBuilder r0, AppBehaviorInfo r1) {
            lambda$onReceive$0(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$zB6gPSUmACfm-g0PTBGLtQmRtbs, reason: not valid java name */
        public static /* synthetic */ void m10559$r8$lambda$zB6gPSUmACfmg0PTBGLtQmRtbs(BDBroadcastReceiver r0) {
            r0.lambda$onReceive$1();
        }

        /* synthetic */ BDBroadcastReceiver(BDAppBehaviorManager r1, BDAppBehaviorManagerIA r2) {
            this(r1);
        }

        private BDBroadcastReceiver(BDAppBehaviorManager r1) {
            this.this$0 = r1;
        }

        @Override // com.bytedance.server.security.broadcast.ISecurityBroadcastPlugin
        public void onReceive(Context context, Intent intent) {
            if (intent != null) goto L4;
            return;
        L4:
            if ("android.intent.action.ACTION_SHUTDOWN".equals(intent.getAction()) == true) goto L6;
            return;
        L6:
            if (BDAppBehaviorManager.m10550$$Nest$fgetisStopRecord(this.this$0) == false) goto L8;
            return;
        L8:
            Log.d(BDAppBehaviorManager.TAG, "shutdown save");
            BDAppBehaviorManager.m10551$$Nest$fgetmBehaviorRecordHandler(this.this$0).post(new BDAppBehaviorManager$BDBroadcastReceiver$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$onReceive$1() {
            Object r0 = BDAppBehaviorManager.m10558$$Nest$sfgetS_LOCK_RECORD();
            monitor-enter(r0);
            final StringBuilder builder = new StringBuilder();     // Catch: Throwable -> L6 Exception -> L8
            BDAppBehaviorManager.m10555$$Nest$fgetmRecords(this.this$0).values().forEach(new BDAppBehaviorManager$BDBroadcastReceiver$$ExternalSyntheticLambda1(builder));     // Catch: Throwable -> L6 Exception -> L8
            BDAppBehaviorManager.m10552$$Nest$fgetmBehaviorRecordStorage(this.this$0).writeRecord(builder.toString(), ((AppBehaviorInfo) ((Map.Entry) BDAppBehaviorManager.m10555$$Nest$fgetmRecords(this.this$0).entrySet().iterator().next()).getValue()).recordTime);     // Catch: Throwable -> L6 Exception -> L8
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        L8:
            e = move-exception;
            Log.e(BDAppBehaviorManager.TAG, "shutdown save occur exception, " + e.getMessage());     // Catch: Throwable -> L6
            goto L10
        }

        private static /* synthetic */ void lambda$onReceive$0(StringBuilder builder, AppBehaviorInfo behaviorInfo) {
            builder.append(behaviorInfo.toString());
            builder.append(System.lineSeparator());
        }
    }

    private class BehaviorRecordRun implements Runnable {
        final /* synthetic */ BDAppBehaviorManager this$0;

        /* synthetic */ BehaviorRecordRun(BDAppBehaviorManager r1, BDAppBehaviorManagerIA r2) {
            this(r1);
        }

        private BehaviorRecordRun(BDAppBehaviorManager r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = BDAppBehaviorManager.m10558$$Nest$sfgetS_LOCK_RECORD();     // Catch: InterruptedException -> L19
            monitor-enter(r0);     // Catch: InterruptedException -> L19
            AppBehaviorInfo behaviorInfo = (AppBehaviorInfo) BDAppBehaviorManager.m10554$$Nest$fgetmRecordQueue(this.this$0).take();     // Catch: Throwable -> L8
            if (behaviorInfo.isValid() == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            Log.d(BDAppBehaviorManager.TAG, "size: " + BDAppBehaviorManager.m10555$$Nest$fgetmRecords(this.this$0).size() + " " + behaviorInfo.toString());     // Catch: Throwable -> L8
            if (AppBehaviorConst.LOCATION_OP_NAME.contains(behaviorInfo.opName) == false) goto L13;
            BDAppBehaviorManager.m10556$$Nest$mmergeRecords(this.this$0, behaviorInfo, (String) BDAppBehaviorManager.m10553$$Nest$fgetmRecentLocationRecord(this.this$0).getOrDefault(behaviorInfo.getUniqueAppKey(), null), 20000);     // Catch: Throwable -> L8
        L14:
            BDAppBehaviorManager.m10557$$Nest$msaveRecordLocked(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L13:
            BDAppBehaviorManager.m10555$$Nest$fgetmRecords(this.this$0).put(behaviorInfo.getUniqueKey(), behaviorInfo);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L19
        L19:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    private static class SingleTonHolder {
        private static final BDAppBehaviorManager INSTANCE = null;

        /* JADX INFO: renamed from: -$$Nest$sfgetINSTANCE, reason: not valid java name */
        static /* bridge */ /* synthetic */ BDAppBehaviorManager m10560$$Nest$sfgetINSTANCE() {
            return INSTANCE;
        }

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new BDAppBehaviorManager(null);
        }
    }

    public static /* synthetic */ void $r8$lambda$3pZCKa05tr_hxOoneQ4RW8wlRqg(BDAppBehaviorManager r0, boolean r1) {
        r0.lambda$stopAppRecord$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$vpJRR2d9_OEj4eH5ZYh5zXblNfQ(StringBuilder r0, AppBehaviorInfo r1) {
        lambda$saveRecordLocked$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetisStopRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10550$$Nest$fgetisStopRecord(BDAppBehaviorManager r0) {
        return r0.isStopRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBehaviorRecordHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m10551$$Nest$fgetmBehaviorRecordHandler(BDAppBehaviorManager r0) {
        return r0.mBehaviorRecordHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBehaviorRecordStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ BehaviorRecordStorage m10552$$Nest$fgetmBehaviorRecordStorage(BDAppBehaviorManager r0) {
        return r0.mBehaviorRecordStorage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecentLocationRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m10553$$Nest$fgetmRecentLocationRecord(BDAppBehaviorManager r0) {
        return r0.mRecentLocationRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecordQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ BlockingQueue m10554$$Nest$fgetmRecordQueue(BDAppBehaviorManager r0) {
        return r0.mRecordQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkedHashMap m10555$$Nest$fgetmRecords(BDAppBehaviorManager r0) {
        return r0.mRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$mmergeRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10556$$Nest$mmergeRecords(BDAppBehaviorManager r0, AppBehaviorInfo r1, String r2, long r3) {
        r0.mergeRecords(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msaveRecordLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10557$$Nest$msaveRecordLocked(BDAppBehaviorManager r0) {
        r0.saveRecordLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetS_LOCK_RECORD, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10558$$Nest$sfgetS_LOCK_RECORD() {
        return S_LOCK_RECORD;
    }

    /* synthetic */ BDAppBehaviorManager(BDAppBehaviorManagerIA r1) {
        this();
    }

    static {
        S_LOCK_RECORD = new Object();
        mIgnoreOps = new HashSet(Arrays.asList(new Integer[]{86, 84, 82}));
        mWhiteListPackages = new HashSet(Arrays.asList(new String[]{"com.larus.nova", "com.obric.assistantaiagent", "com.obric.aikernel", "com.obric.matrix", "com.obric.memorydata", "com.obric.autoaction"}));
    }

    private BDAppBehaviorManager() {
        this.mRecordQueue = new LinkedBlockingQueue();
        this.mRecords = new LinkedHashMap();
        this.mBehaviorRecordStorage = new BehaviorRecordStorage();
        this.mRecentLocationRecord = new HashMap();
        this.isStopRecord = false;
        HandlerThread mRecordThread = new HandlerThread("bdbehaviorrecord");     // Catch: Exception -> L5
        mRecordThread.start();     // Catch: Exception -> L5
        this.mBehaviorRecordHandler = new Handler(mRecordThread.getLooper());     // Catch: Exception -> L5
        this.isStopRecord = this.mBehaviorRecordStorage.isStopRecord();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "BDAppBehaviorManager init occur exception, " + e.getMessage());
    }

    public static BDAppBehaviorManager getInstance() {
        return SingleTonHolder.m10560$$Nest$sfgetINSTANCE();
    }

    public void init(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.server.security.behaviorrecord.IBDAppBehaviorRecord
    public void recordBehaviorLocked(long startTime, int opId, String packageName, int uid, int uidState, int operation) {
        if (this.isStopRecord == false) goto L6;
        return;
    L6:
        if (mIgnoreOps.contains(Integer.valueOf(opId)) == false) goto L9;
        return;
    L9:
        if (uid >= 10000) goto L11;
        return;
    L11:
        ApplicationInfo appInfo = getApplicationInfo(packageName);
        if (appInfo != null) goto L14;
    L25:
        this.mRecordQueue.add(new AppBehaviorInfo(0, opId, operation, packageName, startTime, uid, 200, Utils.getUserIdFromUid(uid), 1));     // Catch: Exception -> L22
        this.mBehaviorRecordHandler.post(new BehaviorRecordRun(this, null));     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        Log.e(TAG, "recordBehavior occur exception, " + e.getMessage());
        return;
    L14:
        if (mWhiteListPackages.contains(packageName) == true) goto L25;
        if ((appInfo.flags & 1) == 0) goto L18;
        return;
    L18:
        if ((appInfo.flags & 128) == 0) goto L25;
    }

    private ApplicationInfo getApplicationInfo(String pkgName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        ApplicationInfo appInfo = packageManager.getApplicationInfo(pkgName, 0);     // Catch: PackageManager.NameNotFoundException -> L5
        return appInfo;
    L6:
        Log.e(TAG, "package not found: " + pkgName);
        return null;
    }

    public List<String> getLatestRecord() {
        Object r0 = S_LOCK_RECORD;
        monitor-enter(r0);
        List<String> r1 = (List) this.mRecords.values().stream().map(new BDAppBehaviorManager$$ExternalSyntheticLambda1()).collect(Collectors.toList());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAppRecordEnable() {
        Object r0 = S_LOCK_RECORD;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.isStopRecord == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void stopAppRecord(final boolean isStop) {
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
            java.lang.Object r0 = com.bytedance.server.security.behaviorrecord.record.BDAppBehaviorManager.S_LOCK_RECORD
            monitor-enter(r0)
            boolean r1 = r5.isStopRecord     // Catch: java.lang.Throwable -> L9 java.lang.Exception -> L16
            if (r6 != r1) goto Lb
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            return
        L9:
            r1 = move-exception
            goto L46
        Lb:
            android.os.Handler r1 = r5.mBehaviorRecordHandler     // Catch: java.lang.Throwable -> L9 java.lang.Exception -> L16
            com.bytedance.server.security.behaviorrecord.record.BDAppBehaviorManager$$ExternalSyntheticLambda2 r2 = new com.bytedance.server.security.behaviorrecord.record.BDAppBehaviorManager$$ExternalSyntheticLambda2     // Catch: java.lang.Throwable -> L9 java.lang.Exception -> L16
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L9 java.lang.Exception -> L16
            r1.post(r2)     // Catch: java.lang.Throwable -> L9 java.lang.Exception -> L16
            goto L33
        L16:
            r1 = move-exception
            java.lang.String r2 = "BDAppBehaviorManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9
            r3.<init>()     // Catch: java.lang.Throwable -> L9
            java.lang.String r4 = "stop service failed, "
            r3.append(r4)     // Catch: java.lang.Throwable -> L9
            java.lang.String r4 = r1.getMessage()     // Catch: java.lang.Throwable -> L9
            r3.append(r4)     // Catch: java.lang.Throwable -> L9
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L9
            android.util.Log.e(r2, r3)     // Catch: java.lang.Throwable -> L9
        L33:
            r5.isStopRecord = r6     // Catch: java.lang.Throwable -> L9
            java.util.concurrent.BlockingQueue<com.bytedance.server.security.behaviorrecord.record.AppBehaviorInfo> r1 = r5.mRecordQueue     // Catch: java.lang.Throwable -> L9
            r1.clear()     // Catch: java.lang.Throwable -> L9
            java.util.LinkedHashMap<java.lang.String, com.bytedance.server.security.behaviorrecord.record.AppBehaviorInfo> r1 = r5.mRecords     // Catch: java.lang.Throwable -> L9
            r1.clear()     // Catch: java.lang.Throwable -> L9
            java.util.Map<java.lang.String, java.lang.String> r1 = r5.mRecentLocationRecord     // Catch: java.lang.Throwable -> L9
            r1.clear()     // Catch: java.lang.Throwable -> L9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            return
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.server.security.behaviorrecord.record.BDAppBehaviorManager.stopAppRecord(boolean):void");
    }

    private /* synthetic */ void lambda$stopAppRecord$0(boolean isStop) {
        this.mBehaviorRecordStorage.stopRecord(isStop);
    }

    private void mergeRecords(AppBehaviorInfo behaviorInfo, String recordKey, long duration) {
        Object r0 = S_LOCK_RECORD;
        monitor-enter(r0);
        AppBehaviorInfo recentRecord = this.mRecords.get(recordKey);     // Catch: Throwable -> L7
        int behaviorInfoMinute = calculateMinute(behaviorInfo.recordTime);     // Catch: Throwable -> L7
        if (recentRecord == null) goto L9;
        int recentRecordMinute = calculateMinute(recentRecord.recordTime);     // Catch: Throwable -> L7
    L11:
        if (TextUtils.isEmpty(recordKey) == true) goto L25;
        if (recentRecord == null) goto L25;
        if ((behaviorInfo.recordTime - recentRecord.recordTime) > duration) goto L25;
        if ((behaviorInfoMinute - recentRecordMinute) > 0) goto L25;
        if (recentRecord.operation != 1) goto L21;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L21:
        if (behaviorInfo.operation != 1) goto L23;
        recentRecord.operation = behaviorInfo.operation;     // Catch: Throwable -> L7
    L25:
        this.mRecentLocationRecord.put(behaviorInfo.getUniqueAppKey(), behaviorInfo.getUniqueKey());     // Catch: Throwable -> L7
        this.mRecords.put(behaviorInfo.getUniqueKey(), behaviorInfo);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        recentRecordMinute = behaviorInfoMinute;
    L7:
        th = move-exception;
        throw th;
    }

    private void saveRecordLocked() {
        if (this.mRecords.size() >= 100) goto L5;
        return;
    L5:
        final StringBuilder builder = new StringBuilder();
        this.mRecords.values().forEach(new BDAppBehaviorManager$$ExternalSyntheticLambda0(builder));
        this.mBehaviorRecordStorage.writeRecord(builder.toString(), this.mRecords.entrySet().iterator().next().getValue().recordTime);
        this.mRecords.clear();
        this.mRecentLocationRecord.clear();
    }

    private static /* synthetic */ void lambda$saveRecordLocked$1(StringBuilder builder, AppBehaviorInfo behaviorInfo) {
        builder.append(behaviorInfo.toString());
        builder.append(System.lineSeparator());
    }

    public void registerBroadcast() {
        BDSecurityBroadcast.registerPlugin("behaviorrecord", new ArrayList(Collections.singletonList("android.intent.action.ACTION_SHUTDOWN")), new BDBroadcastReceiver(this, null));
    }

    private int calculateMinute(long millis) {
        TimeZone tz = TimeZone.getDefault();
        int offset = tz.getOffset(System.currentTimeMillis());
        long localMillis = ((long) offset) + millis;
        int totalMinutes = (int) ((localMillis / 60000) % 1440);
        int minute = totalMinutes % 60;
        return minute;
    }
}
