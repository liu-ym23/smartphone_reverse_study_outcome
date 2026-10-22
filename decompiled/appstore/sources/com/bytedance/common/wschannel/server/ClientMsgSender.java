package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ClientMsgSender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ISender f7061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f7062b;

    public interface ISender {
        void sendMsg(Intent r10);

        void tryResendMsg();
    }

    public static /* synthetic */ class a {
    }

    public class b implements ISender {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f7063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClientMsgSender f7064b;

        public b(ClientMsgSender r10, Context r11) {
            this.f7064b = r10;
            this.f7063a = r11;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void sendMsg(Intent r10) {
            this.f7063a.startService(r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void tryResendMsg() {
        }
    }

    public class c implements ISender {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f7065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Messenger f7066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LinkedBlockingDeque f7067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ServiceConnection f7068d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7069e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f7070f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Runnable f7071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Runnable f7072h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AtomicInteger f7073i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ClientMsgSender f7074j;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f7075a;

            public a(c r10) {
                this.f7075a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object r10 = c.a(this.f7075a);
                monitor-enter(r10);
                Logger.d("WsChannelSdk", "mBindServiceTimeoutRunnable run");     // Catch: Throwable -> L7
                if (c.b(this.f7075a) == false) goto L9;
                c.c(this.f7075a, false);     // Catch: Throwable -> L7
            L9:
                monitor-exit(r10);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f7076a;

            public b(c r10) {
                this.f7076a = r10;
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
                    com.bytedance.common.wschannel.server.ClientMsgSender$c r0 = r3.f7076a
                    java.lang.Object r0 = com.bytedance.common.wschannel.server.ClientMsgSender.c.a(r0)
                    monitor-enter(r0)
                    com.bytedance.common.wschannel.server.ClientMsgSender$c r1 = r3.f7076a     // Catch: java.lang.Throwable -> L1f
                    android.content.ServiceConnection r1 = com.bytedance.common.wschannel.server.ClientMsgSender.c.d(r1)     // Catch: java.lang.Throwable -> L1f
                    if (r1 == 0) goto L23
                    com.bytedance.common.wschannel.server.ClientMsgSender$c r1 = r3.f7076a     // Catch: java.lang.Throwable -> L1f
                    android.content.Context r1 = com.bytedance.common.wschannel.server.ClientMsgSender.c.f(r1)     // Catch: java.lang.Throwable -> L1f
                    com.bytedance.common.wschannel.server.ClientMsgSender$c r2 = r3.f7076a     // Catch: java.lang.Throwable -> L1f
                    android.content.ServiceConnection r2 = com.bytedance.common.wschannel.server.ClientMsgSender.c.d(r2)     // Catch: java.lang.Throwable -> L1f
                    r1.unbindService(r2)     // Catch: java.lang.Throwable -> L1f
                    goto L23
                L1f:
                    r1 = move-exception
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L37
                L23:
                    com.bytedance.common.wschannel.server.ClientMsgSender$c r1 = r3.f7076a     // Catch: java.lang.Throwable -> L37
                    r2 = 0
                    com.bytedance.common.wschannel.server.ClientMsgSender.c.e(r1, r2)     // Catch: java.lang.Throwable -> L37
                    com.bytedance.common.wschannel.server.ClientMsgSender$c r3 = r3.f7076a     // Catch: java.lang.Throwable -> L37
                    com.bytedance.common.wschannel.server.ClientMsgSender.c.g(r3, r2)     // Catch: java.lang.Throwable -> L37
                    java.lang.String r3 = "WsChannelSdk"
                    java.lang.String r1 = "mDisconnectRunnable timeout"
                    com.bytedance.common.utility.Logger.d(r3, r1)     // Catch: java.lang.Throwable -> L37
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L37
                    return
                L37:
                    r3 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L37
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.server.ClientMsgSender.c.b.run():void");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.ClientMsgSender$c$c, reason: collision with other inner class name */
        public class ServiceConnectionC0088c implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f7077a;

            public ServiceConnectionC0088c(c r10) {
                this.f7077a = r10;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r10, IBinder r11) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceConnected name = " + r10.toString());
            L5:
                Object r12 = c.a(this.f7077a);
                monitor-enter(r12);
                c.i(this.f7077a);     // Catch: Throwable -> L18
                if (r10 == null) goto L20;
                if (r11 == null) goto L20;
                c.g(this.f7077a, new Messenger(r11));     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L13
                c.j(this.f7077a);     // Catch: Throwable -> L13
            L15:
                Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L18
                c.c(this.f7077a, false);     // Catch: Throwable -> L18
                monitor-exit(r12);     // Catch: Throwable -> L18
                return;
            L13:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L18
            L20:
                monitor-exit(r12);     // Catch: Throwable -> L18
                return;
            L18:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r10) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r10.toString());
            L5:
                Object r11 = c.a(this.f7077a);
                monitor-enter(r11);
                if (r10 != null) goto L21;
                monitor-exit(r11);     // Catch: Throwable -> L10
                return;
            L21:
                Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L14
                c.g(this.f7077a, null);     // Catch: Throwable -> L14
                c.f(this.f7077a).unbindService(this);     // Catch: Throwable -> L14
            L16:
                Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L10
                c.c(this.f7077a, false);     // Catch: Throwable -> L10
                c.h(this.f7077a);     // Catch: Throwable -> L10
                c.i(this.f7077a);     // Catch: Throwable -> L10
                monitor-exit(r11);     // Catch: Throwable -> L10
                return;
            L14:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                throw th;
            }

            public /* synthetic */ ServiceConnectionC0088c(c r10, a r11) {
                this(r10);
            }
        }

        public c(ClientMsgSender r10, Context r11) {
            this.f7074j = r10;
            this.f7067c = new LinkedBlockingDeque();
            this.f7069e = false;
            this.f7070f = new Object();
            this.f7071g = new a(this);
            this.f7072h = new b(this);
            this.f7073i = new AtomicInteger(0);
            this.f7065a = r11;
        }

        public static /* synthetic */ Object a(c r10) {
            return r10.f7070f;
        }

        public static /* synthetic */ boolean b(c r10) {
            return r10.f7069e;
        }

        public static /* synthetic */ boolean c(c r10, boolean r11) {
            r10.f7069e = r11;
            return r11;
        }

        public static /* synthetic */ ServiceConnection d(c r10) {
            return r10.f7068d;
        }

        public static /* synthetic */ ServiceConnection e(c r10, ServiceConnection r11) {
            r10.f7068d = r11;
            return r11;
        }

        public static /* synthetic */ Context f(c r10) {
            return r10.f7065a;
        }

        public static /* synthetic */ Messenger g(c r10, Messenger r11) {
            r10.f7066b = r11;
            return r11;
        }

        public static /* synthetic */ void h(c r10) {
            r10.n();
        }

        public static /* synthetic */ void i(c r10) {
            r10.m();
        }

        public static /* synthetic */ void j(c r10) {
            r10.l();
        }

        public final void k() {
            if (Logger.debug() == false) goto L10;
            Logger.d("WsChannelSdk", "doBindService");
        L10:
            this.f7068d = new ServiceConnectionC0088c(this, null);     // Catch: Throwable -> L7
            this.f7065a.bindService(new Intent(this.f7065a, ClientMsgSender.a(this.f7074j)), this.f7068d, 1);     // Catch: Throwable -> L7
            p();     // Catch: Throwable -> L7
            this.f7069e = true;     // Catch: Throwable -> L7
            Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            m();
            this.f7069e = false;
            Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
            th.printStackTrace();
        }

        public final void l() {
        L18:
        L11:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.f7067c.peek() == null) goto L14;
            Intent r10 = (Intent) this.f7067c.poll();     // Catch: Throwable -> L11
            if (r10 == null) goto L6;
            o(r10);     // Catch: Throwable -> L9 DeadObjectException -> L13
        L13:
            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L11
            this.f7066b = null;     // Catch: Throwable -> L11
            this.f7067c.offerFirst(r10);     // Catch: Throwable -> L11
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L11
            goto L18
        L6:
            return;
        L14:
            q();     // Catch: Throwable -> L11
        }

        public final void m() {
            cf.b.b().a().removeCallbacks(this.f7071g);
        }

        public final void n() {
            cf.b.b().a().removeCallbacks(this.f7072h);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        public final void o(Intent r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            Logger.d("WsChannelSdk", "sendMsg msg = " + r10);
        L7:
            Messenger r11 = this.f7066b;
            Message r12 = new Message();
            r12.what = WsConstants.MSG_INTENT;
            r12.getData().putParcelable(WsConstants.DATA_INTENT, r10);
            if (r11 != null) goto L10;
            return;
        L10:
            r11.send(r12);
        }

        public final void p() {
            m();
            cf.b.b().a().postDelayed(this.f7071g, TimeUnit.SECONDS.toMillis(7));
        }

        public final synchronized void q() {
            monitor-enter(this);
            n();     // Catch: Throwable -> L6
            cf.b.b().a().postDelayed(this.f7072h, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void sendMsg(Intent r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            r10.putExtra(WsConstants.MSG_COUNT, this.f7073i.addAndGet(1));
        L7:
            Object r11 = this.f7070f;
            monitor-enter(r11);
            n();     // Catch: Throwable -> L15
            this.f7067c.offer(r10);     // Catch: Throwable -> L15
            if (this.f7066b == null) goto L12;
            l();     // Catch: Throwable -> L15
        L19:
            monitor-exit(r11);     // Catch: Throwable -> L15
            return;
        L12:
            if (this.f7069e == false) goto L17;
            monitor-exit(r11);     // Catch: Throwable -> L15
            return;
        L17:
            k();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void tryResendMsg() {
            if (this.f7067c.size() > 0) goto L5;
            return;
        L5:
            if (this.f7066b != null) goto L22;
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            Object r10 = this.f7070f;
            monitor-enter(r10);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.f7067c.size() > 0) goto L11;
        L15:
            monitor-exit(r10);     // Catch: Throwable -> L13
            return;
        L11:
            if (this.f7066b != null) goto L15;
            k();     // Catch: Throwable -> L13
            goto L15
        }
    }

    public ClientMsgSender(Context r10, Class r11) {
        if (r10.getApplicationInfo().targetSdkVersion < 26) goto L5;
        this.f7061a = new c(this, r10);
    L6:
        this.f7062b = r11;
        return;
    L5:
        this.f7061a = new b(this, r10);
        goto L6
    }

    public static /* synthetic */ Class a(ClientMsgSender r10) {
        return r10.f7062b;
    }

    public void b(Intent r10) {
        this.f7061a.sendMsg(r10);
    }

    public void c() {
        this.f7061a.tryResendMsg();
    }
}
