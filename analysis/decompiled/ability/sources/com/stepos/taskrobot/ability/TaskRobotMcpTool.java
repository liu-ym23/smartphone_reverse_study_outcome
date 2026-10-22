package com.stepos.taskrobot.ability;

import C7.r;
import J7.c;
import N9.j;
import S7.o;
import a6.AbstractC0304a;
import com.google.gson.JsonObject;
import com.mdisdk.Task;
import com.mdisdk.action.FlingAction;
import com.mdisdk.action.KeyEventAction;
import com.mdisdk.action.LongClickAction;
import com.mdisdk.action.MoveAppAction;
import com.mdisdk.action.OpenAppAction;
import com.mdisdk.action.ScaleAction;
import com.mdisdk.action.SetTextAction;
import com.mdisdk.action.SwipeAction;
import com.mdisdk.action.WaitAction;
import com.mdisdk.capability.model.WindowStateInfo;
import f6.AbstractC1436a;
import g1.AbstractC1451a;
import io.modelcontextprotocol.spec.McpSchema;
import j9.m;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/taskrobot/ability/TaskRobotMcpTool;", "", "ability_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskRobotMcpTool {
    public static final /* synthetic */ TaskRobotMcpTool[] c;
    public static final /* synthetic */ K7.a d;

    /* renamed from: a, reason: collision with root package name */
    public final String f4002a;
    public final SuspendLambda b;

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$1", f = "TaskRobotMcpTool.kt", l = {12}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4003a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(3, (H7.c) obj3);
            anonymousClass1.b = (a) obj;
            anonymousClass1.c = (Map) obj2;
            return anonymousClass1.invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                com.stepos.taskrobot.ability.a r0 = r8.b
                java.util.Map r1 = r8.c
                java.util.Map r1 = (java.util.Map) r1
                kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r3 = r8.f4003a
                r4 = 1
                if (r3 == 0) goto L1b
                if (r3 != r4) goto L13
                kotlin.b.b(r9)
                return r9
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1b:
                kotlin.b.b(r9)
                r9 = 0
                r8.b = r9
                r8.c = r9
                r8.f4003a = r4
                r0.getClass()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r3 = "handleTaskCreate enter: args="
                r8.<init>(r3)
                r8.append(r1)
                java.lang.String r8 = r8.toString()
                java.lang.String r3 = "ability"
                f6.AbstractC1436a.d(r3, r8, r4)
                java.lang.String r8 = "taskName"
                java.lang.String r5 = N9.j.A(r8, r1)
                if (r5 == 0) goto L4c
                boolean r6 = j9.m.s0(r5)
                if (r6 != 0) goto L4a
                r9 = r5
            L4a:
                if (r9 != 0) goto L4e
            L4c:
                java.lang.String r9 = "default"
            L4e:
                java.lang.String r5 = "reuse"
                java.lang.Boolean r1 = N9.j.r(r5, r1)
                if (r1 == 0) goto L5b
                boolean r1 = r1.booleanValue()
                goto L5c
            L5b:
                r1 = r4
            L5c:
                com.mdisdk.Task r1 = r0.e(r9, r1)
                if (r1 != 0) goto L6b
                r8 = 20101(0x4e85, float:2.8168E-41)
                java.lang.String r9 = "Failed to create task. MDI SDK may not be available."
                io.modelcontextprotocol.spec.McpSchema$CallToolResult r8 = a6.AbstractC0304a.a(r8, r9)
                goto L9c
            L6b:
                r0.e = r9
                int r0 = r1.getDisplayId()
                java.lang.String r5 = " displayId="
                java.lang.String r6 = " → set as lastActiveTask"
                java.lang.String r7 = "handleTaskCreate: name="
                java.lang.String r0 = androidx.constraintlayout.core.dsl.a.d(r0, r7, r9, r5, r6)
                f6.AbstractC1436a.d(r3, r0, r4)
                com.google.gson.JsonObject r0 = new com.google.gson.JsonObject
                r0.<init>()
                r0.addProperty(r8, r9)
                int r8 = r1.getDisplayId()
                java.lang.Integer r9 = new java.lang.Integer
                r9.<init>(r8)
                java.lang.String r8 = "displayId"
                r0.addProperty(r8, r9)
                java.lang.String r8 = r0.toString()
                io.modelcontextprotocol.spec.McpSchema$CallToolResult r8 = a6.AbstractC0304a.b(r8)
            L9c:
                if (r8 != r2) goto L9f
                return r2
            L9f:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.ability.TaskRobotMcpTool.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$10", f = "TaskRobotMcpTool.kt", l = {21}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$10, reason: invalid class name */
    public static final class AnonymousClass10 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4004a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass10 anonymousClass10 = new AnonymousClass10(3, (H7.c) obj3);
            anonymousClass10.b = (a) obj;
            anonymousClass10.c = (Map) obj2;
            return anonymousClass10.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4004a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4004a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleFling enter: args=" + map, true);
            Float fU = j.u("startX", map);
            Float fU2 = j.u("startY", map);
            Float fU3 = j.u("velocityX", map);
            Float fU4 = j.u("velocityY", map);
            Long lW = j.w("durationMs", map);
            long jLongValue = lW != null ? lW.longValue() : 500L;
            if (fU == null || fU2 == null || fU3 == null || fU4 == null) {
                AbstractC1436a.b("ability", "handleFling invalid request: startX, startY, velocityX, velocityY required", true);
                objA = AbstractC0304a.a(20001, "startX, startY, velocityX, velocityY required");
            } else {
                Task taskE = aVar.e(aVar.l(map), true);
                objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new FlingAction(fU.floatValue(), fU2.floatValue(), fU3.floatValue(), fU4.floatValue(), jLongValue, null, ""), this);
            }
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$11", f = "TaskRobotMcpTool.kt", l = {22}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$11, reason: invalid class name */
    public static final class AnonymousClass11 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4005a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass11 anonymousClass11 = new AnonymousClass11(3, (H7.c) obj3);
            anonymousClass11.b = (a) obj;
            anonymousClass11.c = (Map) obj2;
            return anonymousClass11.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4005a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4005a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleScale enter: args=" + map, true);
            Float fU = j.u("centerX", map);
            Float fU2 = j.u("centerY", map);
            Float fU3 = j.u("startDistance", map);
            Float fU4 = j.u("endDistance", map);
            Long lW = j.w("durationMs", map);
            long jLongValue = lW != null ? lW.longValue() : 500L;
            if (fU == null || fU2 == null || fU3 == null || fU4 == null) {
                AbstractC1436a.b("ability", "handleScale invalid request: centerX, centerY, startDistance, endDistance required", true);
                objA = AbstractC0304a.a(20001, "centerX, centerY, startDistance, endDistance required");
            } else {
                Task taskE = aVar.e(aVar.l(map), true);
                objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new ScaleAction(fU.floatValue(), fU2.floatValue(), fU3.floatValue(), fU4.floatValue(), jLongValue, null, ""), this);
            }
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$12", f = "TaskRobotMcpTool.kt", l = {23}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$12, reason: invalid class name */
    public static final class AnonymousClass12 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4006a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass12 anonymousClass12 = new AnonymousClass12(3, (H7.c) obj3);
            anonymousClass12.b = (a) obj;
            anonymousClass12.c = (Map) obj2;
            return anonymousClass12.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4006a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4006a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleSetText enter: args=" + map, true);
            String strA = j.A("content", map);
            Integer numV = j.v("x", map);
            Integer numV2 = j.v("y", map);
            if (strA == null || numV == null || numV2 == null) {
                AbstractC1436a.b("ability", "handleSetText invalid request: content, x, y required", true);
                objA = AbstractC0304a.a(20001, "content, x, y required");
            } else {
                Task taskE = aVar.e(aVar.l(map), true);
                objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new SetTextAction(strA, numV, numV2, null, null, null, null, ""), this);
            }
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$13", f = "TaskRobotMcpTool.kt", l = {24}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$13, reason: invalid class name */
    public static final class AnonymousClass13 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4007a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass13 anonymousClass13 = new AnonymousClass13(3, (H7.c) obj3);
            anonymousClass13.b = (a) obj;
            anonymousClass13.c = (Map) obj2;
            return anonymousClass13.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4007a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4007a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleKeyEvent enter: args=" + map, true);
            Integer numV = j.v("keyCode", map);
            if (numV != null) {
                int iIntValue = numV.intValue();
                Task taskE = aVar.e(aVar.l(map), true);
                objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new KeyEventAction(iIntValue, null, ""), this);
            } else {
                objA = AbstractC0304a.a(20001, "keyCode required");
            }
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$14", f = "TaskRobotMcpTool.kt", l = {25}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$14, reason: invalid class name */
    public static final class AnonymousClass14 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4008a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass14 anonymousClass14 = new AnonymousClass14(3, (H7.c) obj3);
            anonymousClass14.b = (a) obj;
            anonymousClass14.c = (Map) obj2;
            return anonymousClass14.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4008a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4008a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleBack enter: args=" + map, true);
            Task taskE = aVar.e(aVar.l(map), true);
            Object objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new KeyEventAction(4, null, ""), this);
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$15", f = "TaskRobotMcpTool.kt", l = {26}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$15, reason: invalid class name */
    public static final class AnonymousClass15 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4009a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass15 anonymousClass15 = new AnonymousClass15(3, (H7.c) obj3);
            anonymousClass15.b = (a) obj;
            anonymousClass15.c = (Map) obj2;
            return anonymousClass15.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4009a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4009a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleHome enter: args=" + map, true);
            Task taskE = aVar.e(aVar.l(map), true);
            Object objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new KeyEventAction(3, null, ""), this);
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$16", f = "TaskRobotMcpTool.kt", l = {27}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$16, reason: invalid class name */
    public static final class AnonymousClass16 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4010a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass16 anonymousClass16 = new AnonymousClass16(3, (H7.c) obj3);
            anonymousClass16.b = (a) obj;
            anonymousClass16.c = (Map) obj2;
            return anonymousClass16.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4010a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4010a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleWait enter: args=" + map, true);
            Long lW = j.w("durationMs", map);
            long jV = AbstractC1451a.v(lW != null ? lW.longValue() : 1000L, 0L, 30000L);
            Task taskE = aVar.e(aVar.l(map), true);
            Object objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new WaitAction(jV, null, ""), this);
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$17", f = "TaskRobotMcpTool.kt", l = {28}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$17, reason: invalid class name */
    public static final class AnonymousClass17 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4011a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass17 anonymousClass17 = new AnonymousClass17(3, (H7.c) obj3);
            anonymousClass17.b = (a) obj;
            anonymousClass17.c = (Map) obj2;
            return anonymousClass17.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4011a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4011a = 1;
            Object objG = aVar.g(map, this);
            return objG == coroutineSingletons ? coroutineSingletons : objG;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$18", f = "TaskRobotMcpTool.kt", l = {29}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$18, reason: invalid class name */
    public static final class AnonymousClass18 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4012a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass18 anonymousClass18 = new AnonymousClass18(3, (H7.c) obj3);
            anonymousClass18.b = (a) obj;
            anonymousClass18.c = (Map) obj2;
            return anonymousClass18.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4012a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4012a = 1;
            Object objI = aVar.i(map, this);
            return objI == coroutineSingletons ? coroutineSingletons : objI;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$19", f = "TaskRobotMcpTool.kt", l = {30}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$19, reason: invalid class name */
    public static final class AnonymousClass19 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4013a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass19 anonymousClass19 = new AnonymousClass19(3, (H7.c) obj3);
            anonymousClass19.b = (a) obj;
            anonymousClass19.c = (Map) obj2;
            return anonymousClass19.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            McpSchema.CallToolResult callToolResultB;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4013a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4013a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleSetOmniDisplayImeEnabled enter: args=" + map, true);
            String strL = aVar.l(map);
            Boolean boolR = j.r("enable", map);
            boolean zBooleanValue = boolR != null ? boolR.booleanValue() : false;
            Task taskE = aVar.e(strL, true);
            if (taskE == null) {
                callToolResultB = AbstractC0304a.a(20101, "Failed to get/create task");
            } else {
                taskE.setOmniDisplayImeEnabled(zBooleanValue);
                AbstractC1436a.d("ability", "handleSetOmniDisplayImeEnabled success: name=" + strL + " enable=" + zBooleanValue, true);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("message", "setOmniDisplayImeEnabled succeeded");
                callToolResultB = AbstractC0304a.b(jsonObject.toString());
            }
            return callToolResultB == coroutineSingletons ? coroutineSingletons : callToolResultB;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$2", f = "TaskRobotMcpTool.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ a f4014a;
        public /* synthetic */ Map b;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(3, (H7.c) obj3);
            anonymousClass2.f4014a = (a) obj;
            anonymousClass2.b = (Map) obj2;
            return anonymousClass2.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.f4014a;
            Map args = this.b;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            aVar.getClass();
            k.f(args, "args");
            AbstractC1436a.d("ability", "handleTaskFinish enter: args=" + args, true);
            String strL = aVar.l(args);
            Boolean boolR = j.r("ignoreActions", args);
            boolean zBooleanValue = boolR != null ? boolR.booleanValue() : false;
            Task taskF = aVar.f(strL);
            if (taskF == null) {
                return AbstractC0304a.a(20102, "Task '" + strL + "' not found");
            }
            if (k.b(aVar.e, strL)) {
                aVar.e = null;
            }
            aVar.c.remove(strL);
            try {
                taskF.finish(zBooleanValue);
                AbstractC1436a.d("ability", "handleTaskFinish success: name=" + strL + " ignoreActions=" + zBooleanValue, true);
                return AbstractC0304a.b(null);
            } catch (Throwable th) {
                AbstractC1436a.c("ability", "handleTaskFinish failed: name=" + strL + " ignoreActions=" + zBooleanValue, th);
                return AbstractC0304a.a(20103, "task.finish failed: " + th.getMessage());
            }
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$3", f = "TaskRobotMcpTool.kt", l = {14}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4015a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(3, (H7.c) obj3);
            anonymousClass3.b = (a) obj;
            anonymousClass3.c = (Map) obj2;
            return anonymousClass3.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4015a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4015a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleOpenApp enter: args=" + map, true);
            String strA = j.A("packageName", map);
            if (strA == null || m.s0(strA)) {
                AbstractC1436a.b("ability", "handleOpenApp invalid request: packageName required", true);
                objA = AbstractC0304a.a(20001, "packageName required");
            } else {
                Task taskE = aVar.e(aVar.l(map), true);
                objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new OpenAppAction(strA, null, null, null, ""), this);
            }
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$4", f = "TaskRobotMcpTool.kt", l = {15}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4016a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(3, (H7.c) obj3);
            anonymousClass4.b = (a) obj;
            anonymousClass4.c = (Map) obj2;
            return anonymousClass4.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4016a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4016a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleMoveApp enter: args=" + map, true);
            String strA = j.A("packageName", map);
            if (strA == null || m.s0(strA)) {
                AbstractC1436a.b("ability", "handleMoveApp invalid request: packageName required", true);
                objA = AbstractC0304a.a(20001, "packageName required");
            } else {
                Integer numV = j.v("toDisplayId", map);
                if (numV != null) {
                    int iIntValue = numV.intValue();
                    Boolean boolR = j.r("toTop", map);
                    boolean zBooleanValue = boolR != null ? boolR.booleanValue() : true;
                    Task taskE = aVar.e(aVar.l(map), true);
                    objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new MoveAppAction(strA, iIntValue, Boolean.valueOf(zBooleanValue), null, ""), this);
                } else {
                    objA = AbstractC0304a.a(20001, "toDisplayId required");
                }
            }
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$5", f = "TaskRobotMcpTool.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ a f4017a;
        public /* synthetic */ Map b;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(3, (H7.c) obj3);
            anonymousClass5.f4017a = (a) obj;
            anonymousClass5.b = (Map) obj2;
            return anonymousClass5.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.f4017a;
            Map args = this.b;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            aVar.getClass();
            k.f(args, "args");
            AbstractC1436a.d("ability", "handleTopApp enter: args=" + args, true);
            String strL = aVar.l(args);
            Integer numV = j.v(WindowStateInfo.KEY_DISPLAY_ID, args);
            Task taskF = aVar.f(strL);
            if (taskF == null) {
                return AbstractC0304a.a(20102, "Task '" + strL + "' not found. Create it first with mdi_task_create");
            }
            try {
                String topApp = taskF.getTopApp(numV);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("packageName", topApp == null ? "" : topApp);
                if (topApp == null) {
                    topApp = "";
                }
                AbstractC1436a.d("ability", "handleTopApp success: name=" + strL + " displayId=" + numV + " topApp=" + topApp, true);
                return AbstractC0304a.b(jsonObject.toString());
            } catch (Throwable th) {
                AbstractC1436a.c("ability", "handleTopApp failed: name=" + strL + " displayId=" + numV, th);
                return AbstractC0304a.a(20103, "topApp failed: " + th.getMessage());
            }
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$6", f = "TaskRobotMcpTool.kt", l = {17}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4018a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(3, (H7.c) obj3);
            anonymousClass6.b = (a) obj;
            anonymousClass6.c = (Map) obj2;
            return anonymousClass6.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4018a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4018a = 1;
            Object objH = aVar.h(map, this);
            return objH == coroutineSingletons ? coroutineSingletons : objH;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$7", f = "TaskRobotMcpTool.kt", l = {18}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$7, reason: invalid class name */
    public static final class AnonymousClass7 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4019a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass7 anonymousClass7 = new AnonymousClass7(3, (H7.c) obj3);
            anonymousClass7.b = (a) obj;
            anonymousClass7.c = (Map) obj2;
            return anonymousClass7.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4019a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4019a = 1;
            Object objH = aVar.h(map, this);
            return objH == coroutineSingletons ? coroutineSingletons : objH;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$8", f = "TaskRobotMcpTool.kt", l = {19}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$8, reason: invalid class name */
    public static final class AnonymousClass8 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4020a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass8 anonymousClass8 = new AnonymousClass8(3, (H7.c) obj3);
            anonymousClass8.b = (a) obj;
            anonymousClass8.c = (Map) obj2;
            return anonymousClass8.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4020a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4020a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleLongClick enter: args=" + map, true);
            Integer numV = j.v("x", map);
            Integer numV2 = j.v("y", map);
            if (numV == null || numV2 == null) {
                AbstractC1436a.b("ability", "handleLongClick invalid request: x and y required", true);
                objA = AbstractC0304a.a(20001, "x and y required");
            } else {
                Long lW = j.w("durationMs", map);
                long jLongValue = lW != null ? lW.longValue() : 1000L;
                Task taskE = aVar.e(aVar.l(map), true);
                objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new LongClickAction(numV.intValue(), numV2.intValue(), jLongValue, null, "", "", ""), this);
            }
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMcpTool$9", f = "TaskRobotMcpTool.kt", l = {20}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/stepos/taskrobot/ability/a;", "mdi", "", "", "", "a", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "<anonymous>", "(Lcom/stepos/taskrobot/ability/a;Ljava/util/Map;)Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMcpTool$9, reason: invalid class name */
    public static final class AnonymousClass9 extends SuspendLambda implements o {

        /* renamed from: a, reason: collision with root package name */
        public int f4021a;
        public /* synthetic */ a b;
        public /* synthetic */ Map c;

        @Override // S7.o
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass9 anonymousClass9 = new AnonymousClass9(3, (H7.c) obj3);
            anonymousClass9.b = (a) obj;
            anonymousClass9.c = (Map) obj2;
            return anonymousClass9.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            a aVar = this.b;
            Map map = this.c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4021a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            this.b = null;
            this.c = null;
            this.f4021a = 1;
            aVar.getClass();
            AbstractC1436a.d("ability", "handleSwipe enter: args=" + map, true);
            Float fU = j.u("startX", map);
            Float fU2 = j.u("startY", map);
            Float fU3 = j.u("endX", map);
            Float fU4 = j.u("endY", map);
            Long lW = j.w("durationMs", map);
            long jLongValue = lW != null ? lW.longValue() : 300L;
            Integer numV = j.v("steps", map);
            int iIntValue = numV != null ? numV.intValue() : 10;
            if (fU == null || fU2 == null || fU3 == null || fU4 == null) {
                AbstractC1436a.b("ability", "handleSwipe invalid request: startX, startY, endX, endY required", true);
                objA = AbstractC0304a.a(20001, "startX, startY, endX, endY required");
            } else {
                Task taskE = aVar.e(aVar.l(map), true);
                objA = taskE == null ? AbstractC0304a.a(20101, "Failed to get/create task") : aVar.c(taskE, new SwipeAction(fU.floatValue(), fU2.floatValue(), fU3.floatValue(), fU4.floatValue(), jLongValue, iIntValue, null, "", "", ""), this);
            }
            return objA == coroutineSingletons ? coroutineSingletons : objA;
        }
    }

    static {
        TaskRobotMcpTool[] taskRobotMcpToolArr = {new TaskRobotMcpTool("TaskCreate", 0, "mdi_task_create", new AnonymousClass1(3, null)), new TaskRobotMcpTool("TaskFinish", 1, "mdi_task_finish", new AnonymousClass2(3, null)), new TaskRobotMcpTool("OpenApp", 2, "mdi_open_app", new AnonymousClass3(3, null)), new TaskRobotMcpTool("MoveApp", 3, "mdi_move_app", new AnonymousClass4(3, null)), new TaskRobotMcpTool("TopApp", 4, "mdi_top_app", new AnonymousClass5(3, null)), new TaskRobotMcpTool("Click", 5, "mdi_click", new AnonymousClass6(3, null)), new TaskRobotMcpTool("Tap", 6, "mdi_tap", new AnonymousClass7(3, null)), new TaskRobotMcpTool("LongClick", 7, "mdi_long_click", new AnonymousClass8(3, null)), new TaskRobotMcpTool("Swipe", 8, "mdi_swipe", new AnonymousClass9(3, null)), new TaskRobotMcpTool("Fling", 9, "mdi_fling", new AnonymousClass10(3, null)), new TaskRobotMcpTool("Scale", 10, "mdi_scale", new AnonymousClass11(3, null)), new TaskRobotMcpTool("SetText", 11, "mdi_set_text", new AnonymousClass12(3, null)), new TaskRobotMcpTool("KeyEvent", 12, "mdi_key_event", new AnonymousClass13(3, null)), new TaskRobotMcpTool("Back", 13, "mdi_back", new AnonymousClass14(3, null)), new TaskRobotMcpTool("Home", 14, "mdi_home", new AnonymousClass15(3, null)), new TaskRobotMcpTool("Wait", 15, "mdi_wait", new AnonymousClass16(3, null)), new TaskRobotMcpTool("Capture", 16, "mdi_capture", new AnonymousClass17(3, null)), new TaskRobotMcpTool("Snapshot", 17, "mdi_snapshot", new AnonymousClass18(3, null)), new TaskRobotMcpTool("ImeEnable", 18, "mdi_ime_enable", new AnonymousClass19(3, null))};
        c = taskRobotMcpToolArr;
        d = kotlin.enums.a.a(taskRobotMcpToolArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskRobotMcpTool(String str, int i, String str2, o oVar) {
        this.f4002a = str2;
        this.b = (SuspendLambda) oVar;
    }

    public static TaskRobotMcpTool valueOf(String str) {
        return (TaskRobotMcpTool) Enum.valueOf(TaskRobotMcpTool.class, str);
    }

    public static TaskRobotMcpTool[] values() {
        return (TaskRobotMcpTool[]) c.clone();
    }
}
