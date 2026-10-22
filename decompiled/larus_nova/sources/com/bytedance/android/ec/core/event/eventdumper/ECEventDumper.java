package com.bytedance.android.ec.core.event.eventdumper;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.bytedance.android.ec.core.event.eventdumper.model.ClassInfo;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedClassInfo;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEvent;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventBatch;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventKey;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventParam;
import com.bytedance.android.ec.core.event.eventdumper.model.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/ECEventDumper;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECEventDumper extends BroadcastReceiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ug.a f44011c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f44012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f44013e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f44014f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f44015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f44016h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f44017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f44018b;

    public static final class a {
        public a() {
        }

        public static String a(StackTraceElement[] r100) {
            StringBuilder r101 = new StringBuilder("stack trace: \n");
            int r102 = r100.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            StackTraceElement r104 = r100[r103];
            r101.append("     at ");
            r101.append(r104.toString());
            r101.append("\n");
            r103 = r103 + 1;
            goto L3
        L6:
            return r101.toString();
        }

        public static void c(tg.a r210) {
            Intrinsics.checkNotNullParameter(r210, "dumpedEvent");
            if (ECEventDumper.f44012d == true) goto L5;
            return;
        L5:
            StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
            ug.a r101 = ECEventDumper.f44011c;
            String r102 = r210.getEventName();
            Map<DumpedEventKey, DumpedEventParam> r103 = r210.getDumpedDumpedEventParams();
            String r104 = a(r100);
            DumpedClassInfo r105 = new DumpedClassInfo();
            ClassInfo r106 = new ClassInfo();
            r106.setClassFileName(r210.getClass().getSimpleName().concat(".kt"));
            Package r110 = r210.getClass().getPackage();
            if (r110 == null) goto L8;
            String r111 = r110.getName();
        L9:
            r106.setPkName(r111);
            Unit r112 = Unit.INSTANCE;
            r105.setEventClassInfo(r106);
            StackTraceElement r107 = (StackTraceElement) ArraysKt.getOrNull(r100, 4);
            if (r107 == null) goto L12;
            ClassInfo r108 = new ClassInfo();
            r108.setClassFileName(r107.getFileName());
            LinkedList r113 = new LinkedList(StringsKt.split$default(r107.getClassName(), new String[]{"."}, false, 0, 6, null));
            r113.removeLast();
            r108.setPkName(CollectionsKt.joinToString$default(r113, ".", null, null, 0, null, null, 62, null));
            r108.setLine(Integer.valueOf(r107.getLineNumber()));
            r105.setPostLocationClassInfo(r108);
        L12:
            r101.a(new DumpedEvent(r102, r103, r104, 0, r105, null, Integer.valueOf(r210.getEventClassVersion()), 40, null));
            return;
        L8:
            r111 = null;
            goto L9
        }

        public static boolean d(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r101 = Process.myPid();
            Object r102 = r100.getSystemService("activity");
            String r103 = null;
            if ((r102 instanceof ActivityManager) == true) goto L5;
            r102 = null;
        L5:
            ActivityManager r104 = (ActivityManager) r102;
            if (r104 == null) goto L25;
            List<ActivityManager.RunningAppProcessInfo> r105 = r104.getRunningAppProcesses();
            if (r105 == null) goto L25;
            Iterator<T> r106 = r105.iterator();
        L12:
            if (r106.hasNext() == false) goto L19;
            Object r107 = r106.next();
            if (((ActivityManager.RunningAppProcessInfo) r107).pid != r101) goto L16;
            boolean r108 = true;
        L17:
            if (r108 == false) goto L12;
        L20:
            ActivityManager.RunningAppProcessInfo r109 = (ActivityManager.RunningAppProcessInfo) r107;
            if (r109 == null) goto L24;
            r103 = r109.processName;
        L24:
            return Intrinsics.areEqual(r103, "com.ss.android.ugc.aweme");
        L16:
            r108 = false;
            goto L17
        L19:
            r107 = null;
        L25:
            return false;
        }

        public static void b(String r210, Map r211) {
            Intrinsics.checkNotNullParameter(r210, "eventName");
            if (ECEventDumper.f44012d == true) goto L5;
            return;
        L5:
            StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
            HashMap r101 = new HashMap();
            if (r211 == null) goto L11;
            Iterator r102 = r211.entrySet().iterator();
        L9:
            if (r102.hasNext() == false) goto L11;
            Map.Entry r103 = (Map.Entry) r102.next();
            String r104 = (String) r103.getKey();
            Object r105 = r103.getValue();
            r101.put(new DumpedEventKey(r104, false, 2, null), new DumpedEventParam(String.valueOf(r105), false, null, 6, null));
        L11:
            ug.a r110 = ECEventDumper.f44011c;
            String r106 = a(r100);
            DumpedClassInfo r107 = new DumpedClassInfo();
            StackTraceElement r108 = (StackTraceElement) ArraysKt.getOrNull(r100, 5);
            if (r108 == null) goto L14;
            ClassInfo r109 = new ClassInfo();
            r109.setClassFileName(r108.getFileName());
            LinkedList r111 = new LinkedList(StringsKt.split$default(r108.getClassName(), new String[]{"."}, false, 0, 6, null));
            r111.removeLast();
            Unit r112 = Unit.INSTANCE;
            r109.setPkName(CollectionsKt.joinToString$default(r111, ".", null, null, 0, null, null, 62, null));
            r109.setLine(Integer.valueOf(r108.getLineNumber()));
            r107.setPostLocationClassInfo(r109);
        L14:
            Unit r113 = Unit.INSTANCE;
            r110.a(new DumpedEvent(r210, r101, r106, 0, r107, null, -1, 40, null));
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ECEventDumper> f44019a;

        public b(ECEventDumper r100) {
            Intrinsics.checkNotNullParameter(r100, "eventDumper");
            this.f44019a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            int r101 = r100.what;
            int r102 = ECEventDumper.f44014f;
            if (r101 != r102) goto L8;
            ECEventDumper r103 = this.f44019a.get();
            if (r103 == null) goto L9;
            ECEventDumper.f44012d = false;
            ECEventDumper.f44011c.f549980a.clear();
            r103.f44018b.removeMessages(r102);
            return;
        L9:
            return;
        }
    }

    static {
        f44016h = new a();
        f44011c = new ug.a();
        f44013e = 3000;
        f44014f = 1;
    }

    public ECEventDumper() {
        this.f44017a = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.f44018b = new b(this);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L7;
        Bundle r102 = r101.getExtras();
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.getInt("cmd_type"));
    L8:
        int r104 = 0;
        if (r103 != null) goto L12;
    L24:
        if (r103 != null) goto L27;
    L29:
        if (r103 != null) goto L32;
        return;
    L32:
        if (r103.intValue() != 2) goto L41;
        f44012d = false;
        f44011c.f549980a.clear();
        this.f44018b.removeMessages(f44014f);
        setResultData(GsonProtectorUtils.toJson(this.f44017a, new Result(true, null, 2, null)));
        return;
    L41:
        return;
    L27:
        if (r103.intValue() != 1) goto L29;
        f44012d = true;
        this.f44018b.sendEmptyMessageDelayed(f44014f, f44013e);
        setResultData(GsonProtectorUtils.toJson(this.f44017a, new Result(true, null, 2, null)));
        return;
    L12:
        if (r103.intValue() != 3) goto L24;
        if (f44012d == false) goto L23;
        this.f44018b.removeMessages(f44014f);
        ug.a r105 = f44011c;
        r105.getClass();
        ArrayList r106 = new ArrayList();
    L17:
        if (r104 >= 10) goto L22;
        if (r105.f549980a.peekFirst() == null) goto L21;
        r106.add(r105.f549980a.pop());
    L21:
        r104 = r104 + 1;
        goto L17
    L22:
        setResultData(GsonProtectorUtils.toJson(this.f44017a, new DumpedEventBatch(new Result(true, null, 2, null), r106)));
        this.f44018b.sendEmptyMessageDelayed(f44014f, f44013e);
        return;
    L23:
        setResultData(GsonProtectorUtils.toJson(this.f44017a, new DumpedEventBatch(new Result(false, "not start"), null)));
        return;
    L7:
        r103 = null;
        goto L8
    }
}
