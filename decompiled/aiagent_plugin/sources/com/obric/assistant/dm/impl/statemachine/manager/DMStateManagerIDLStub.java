package com.obric.assistant.dm.impl.statemachine.manager;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDLSPI;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.ipc.utils.f;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.assistant.dm.api.statemachine.core.b;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: DMStateManagerIDLStub.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DMStateManagerIDLStub implements IAgentDMStateManagerIDLSPI {
    public static final a Companion = null;
    private static final String TAG = "DMStateManagerIDLStub";
    private final RemoteCallbackList<IAgentDMStateListenerIDL> listeners;
    private final ReentrantReadWriteLock lock;

    /* JADX INFO: renamed from: com.obric.assistant.dm.impl.statemachine.manager.DMStateManagerIDLStub$1, reason: invalid class name */
    /* JADX INFO: compiled from: DMStateManagerIDLStub.kt */
    public static final class AnonymousClass1 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DMStateManagerIDLStub f22563a;

        public static /* synthetic */ x lambda$EhxlA1P7co2ilJpTK8BCcxB3inM(TaskInfo r0, State r1, DMTaskInfo r2, DMTaskState r3, DMTaskState r4, IAgentDMStateListenerIDL r5) {
            return a(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ x lambda$OsOpmwwgMyFNozVoM9XW_KyRfds(DMTaskInfo r0, IAgentDMStateListenerIDL r1) {
            return b(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$uaqGwo17G4-qirMrqgc-NfAnJzU, reason: not valid java name */
        public static /* synthetic */ x m428lambda$uaqGwo17G4qirMrqgcNfAnJzU(DMStateInfo r0, IAgentDMStateListenerIDL r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ x lambda$v8EYyC2igsZPJRgbhoLxJzlacio(DMTaskInfo r0, IAgentDMStateListenerIDL r1) {
            return a(r0, r1);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r1, State r2, DMEvent r3, Exception r4) {
            o.e(r1, "taskInfo");
            o.e(r2, "currentState");
            o.e(r4, "exception");
        }

        AnonymousClass1(DMStateManagerIDLStub r1) {
            this.f22563a = r1;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(DMState r3) {
            o.e(r3, "status");
            final DMStateInfo r4 = com.obric.assistant.dm.api.statemachine.a.a.f22458a.a(r3);
            ReentrantReadWriteLock r0 = DMStateManagerIDLStub.access$getLock$p(this.f22563a);
            DMStateManagerIDLStub r2 = this.f22563a;
            ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
            r1.lock();
            f.a(DMStateManagerIDLStub.access$getListeners$p(r2), new $$Lambda$DMStateManagerIDLStub$1$uaqGwo17G4qirMrqgcNfAnJzU(r4));     // Catch: Throwable -> L6
            x r5 = x.f38692a;     // Catch: Throwable -> L6
            r1.unlock();
            return;
        L6:
            th = move-exception;
            r1.unlock();
            throw th;
        }

        private static final x a(DMStateInfo r2, IAgentDMStateListenerIDL r3) {
            IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
            o.e(r4, "it");
            r4.onDMStateChanged(r2);     // Catch: Exception -> L6
        L5:
            return x.f38692a;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r3) {
            o.e(r3, "taskInfo");
            final DMTaskInfo r4 = com.obric.assistant.dm.api.statemachine.a.a.f22458a.a(r3);
            ReentrantReadWriteLock r0 = DMStateManagerIDLStub.access$getLock$p(this.f22563a);
            DMStateManagerIDLStub r2 = this.f22563a;
            ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
            r1.lock();
            f.a(DMStateManagerIDLStub.access$getListeners$p(r2), new $$Lambda$DMStateManagerIDLStub$1$v8EYyC2igsZPJRgbhoLxJzlacio(r4));     // Catch: Throwable -> L6
            x r5 = x.f38692a;     // Catch: Throwable -> L6
            r1.unlock();
            return;
        L6:
            th = move-exception;
            r1.unlock();
            throw th;
        }

        private static final x a(DMTaskInfo r2, IAgentDMStateListenerIDL r3) {
            IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
            o.e(r4, "it");
            r4.onTaskAdded(r2);     // Catch: Exception -> L6
        L5:
            return x.f38692a;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void b(TaskInfo r3) {
            o.e(r3, "taskInfo");
            final DMTaskInfo r4 = com.obric.assistant.dm.api.statemachine.a.a.f22458a.a(r3);
            ReentrantReadWriteLock r0 = DMStateManagerIDLStub.access$getLock$p(this.f22563a);
            DMStateManagerIDLStub r2 = this.f22563a;
            ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
            r1.lock();
            f.a(DMStateManagerIDLStub.access$getListeners$p(r2), new $$Lambda$DMStateManagerIDLStub$1$OsOpmwwgMyFNozVoM9XW_KyRfds(r4));     // Catch: Throwable -> L6
            x r5 = x.f38692a;     // Catch: Throwable -> L6
            r1.unlock();
            return;
        L6:
            th = move-exception;
            r1.unlock();
            throw th;
        }

        private static final x b(DMTaskInfo r2, IAgentDMStateListenerIDL r3) {
            IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
            o.e(r4, "it");
            r4.onTaskEnd(r2);     // Catch: Exception -> L6
        L5:
            return x.f38692a;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(final TaskInfo r7, State r8, final State r9, DMEvent r10) {
            o.e(r7, "taskInfo");
            o.e(r9, "newState");
            final DMTaskInfo r3 = com.obric.assistant.dm.api.statemachine.a.a.f22458a.a(r7);
            com.obric.assistant.dm.api.statemachine.a.a r11 = com.obric.assistant.dm.api.statemachine.a.a.f22458a;
            o.a(r8, "null cannot be cast to non-null type com.obric.assistant.dm.api.statemachine.core.TaskState");
            final DMTaskState r4 = r11.a((TaskState) ZeusTransformUtils.preCheckCast(r8, TaskState.class, "com.obric.aiagent.plugin"));
            final DMTaskState r5 = com.obric.assistant.dm.api.statemachine.a.a.f22458a.a((TaskState) ZeusTransformUtils.preCheckCast(r9, TaskState.class, "com.obric.aiagent.plugin"));
            ReentrantReadWriteLock r12 = DMStateManagerIDLStub.access$getLock$p(this.f22563a);
            DMStateManagerIDLStub r6 = this.f22563a;
            ReentrantReadWriteLock.ReadLock r13 = r12.readLock();
            r13.lock();
            f.a(DMStateManagerIDLStub.access$getListeners$p(r6), new $$Lambda$DMStateManagerIDLStub$1$EhxlA1P7co2ilJpTK8BCcxB3inM(r7, r9, r3, r4, r5));     // Catch: Throwable -> L6
            x r14 = x.f38692a;     // Catch: Throwable -> L6
            r13.unlock();
            return;
        L6:
            th = move-exception;
            r13.unlock();
            throw th;
        }

        private static final x a(TaskInfo r3, State r4, DMTaskInfo r5, DMTaskState r6, DMTaskState r7, IAgentDMStateListenerIDL r8) {
            IAgentDMStateListenerIDL r9 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r8, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
            o.e(r9, "it");
            ILogDepend.Companion.d(DMStateManagerIDLStub.TAG, r3.getTaskId() + ' ' + r4.getStateName() + r9);     // Catch: Exception -> L6
            r9.onTaskStateChanged(r5, r6, r7);     // Catch: Exception -> L6
        L5:
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: DMStateManagerIDLStub.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public DMStateManagerIDLStub() {
        this.listeners = new RemoteCallbackList();
        this.lock = new ReentrantReadWriteLock();
        IDialogStateManager r0 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.registerDMStateListener((b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), b.class, "com.obric.aiagent.plugin"));
        return;
    }

    public static final /* synthetic */ RemoteCallbackList access$getListeners$p(DMStateManagerIDLStub r0) {
        return r0.listeners;
    }

    public static final /* synthetic */ ReentrantReadWriteLock access$getLock$p(DMStateManagerIDLStub r0) {
        return r0.lock;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentDMStateManagerIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void registerDMStateListener(IAgentDMStateListenerIDL r8) {
        IAgentDMStateListenerIDL r9 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r8, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        ReentrantReadWriteLock r0 = this.lock;
        ReentrantReadWriteLock.ReadLock r2 = r0.readLock();
        int r4 = 0;
        if (r0.getWriteHoldCount() != 0) goto L5;
        int r3 = r0.getReadHoldCount();
    L6:
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L9;
        r2.unlock();
        r5 = r5 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r1 = r0.writeLock();
        r1.lock();
        this.listeners.register((IInterface) ZeusTransformUtils.preCheckCast(r9, IInterface.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
    L11:
        if (r4 >= r3) goto L13;
        r2.lock();
        r4 = r4 + 1;
        goto L11
    L13:
        r1.unlock();
        if (r9 == null) goto L30;
        r9.onDMStateChanged(getCurrentDMSteate());     // Catch: Exception -> L22
        return;
    L31:
        return;
    L30:
        return;
    L17:
        th = move-exception;
    L18:
        if (r4 >= r3) goto L20;
        r2.lock();
        r4 = r4 + 1;
        goto L18
    L20:
        r1.unlock();
        throw th;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void unRegisterDMStateListener(IAgentDMStateListenerIDL r7) {
        IAgentDMStateListenerIDL r8 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r7, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        ReentrantReadWriteLock r0 = this.lock;
        ReentrantReadWriteLock.ReadLock r2 = r0.readLock();
        int r4 = 0;
        if (r0.getWriteHoldCount() != 0) goto L5;
        int r3 = r0.getReadHoldCount();
    L6:
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L9;
        r2.unlock();
        r5 = r5 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r1 = r0.writeLock();
        r1.lock();
        this.listeners.unregister((IInterface) ZeusTransformUtils.preCheckCast(r8, IInterface.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
    L11:
        if (r4 >= r3) goto L13;
        r2.lock();
        r4 = r4 + 1;
        goto L11
    L13:
        r1.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r4 >= r3) goto L18;
        r2.lock();
        r4 = r4 + 1;
        goto L16
    L18:
        r1.unlock();
        throw th;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public DMStateInfo getCurrentDMSteate() {
        IDialogStateManager r2 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        DMState r3 = r2.getCurrentDMState();
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return com.obric.assistant.dm.api.statemachine.a.a.f22458a.a(r3);
    L5:
        r3 = null;
        goto L6
    }
}
