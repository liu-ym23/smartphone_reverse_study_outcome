package com.android.server.wm;

import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.MotionEvent;
import android.view.WindowManagerPolicyConstants;
import com.android.server.UiThread;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PointerEventDispatcher extends InputEventReceiver {
    private final ArrayList<WindowManagerPolicyConstants.PointerEventListener> mListeners;
    private WindowManagerPolicyConstants.PointerEventListener[] mListenersArray;

    public PointerEventDispatcher(InputChannel inputChannel) {
        super(inputChannel, UiThread.getHandler().getLooper());
        this.mListeners = new ArrayList();
        this.mListenersArray = new WindowManagerPolicyConstants.PointerEventListener[0];
    }

    public void onInputEvent(InputEvent event) {
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
            r0 = 0
            boolean r1 = r6 instanceof android.view.MotionEvent     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L3e
            int r1 = r6.getSource()     // Catch: java.lang.Throwable -> L3a
            r1 = r1 & 2
            if (r1 == 0) goto L3e
            r1 = r6
            android.view.MotionEvent r1 = (android.view.MotionEvent) r1     // Catch: java.lang.Throwable -> L3a
            java.util.ArrayList<android.view.WindowManagerPolicyConstants$PointerEventListener> r2 = r5.mListeners     // Catch: java.lang.Throwable -> L3a
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L3a
            android.view.WindowManagerPolicyConstants$PointerEventListener[] r3 = r5.mListenersArray     // Catch: java.lang.Throwable -> L29
            if (r3 != 0) goto L2b
            java.util.ArrayList<android.view.WindowManagerPolicyConstants$PointerEventListener> r3 = r5.mListeners     // Catch: java.lang.Throwable -> L29
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L29
            android.view.WindowManagerPolicyConstants$PointerEventListener[] r3 = new android.view.WindowManagerPolicyConstants.PointerEventListener[r3]     // Catch: java.lang.Throwable -> L29
            r5.mListenersArray = r3     // Catch: java.lang.Throwable -> L29
            java.util.ArrayList<android.view.WindowManagerPolicyConstants$PointerEventListener> r3 = r5.mListeners     // Catch: java.lang.Throwable -> L29
            android.view.WindowManagerPolicyConstants$PointerEventListener[] r4 = r5.mListenersArray     // Catch: java.lang.Throwable -> L29
            r3.toArray(r4)     // Catch: java.lang.Throwable -> L29
            goto L2b
        L29:
            r3 = move-exception
            goto L3c
        L2b:
            android.view.WindowManagerPolicyConstants$PointerEventListener[] r3 = r5.mListenersArray     // Catch: java.lang.Throwable -> L29
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
            r2 = 0
        L2f:
            int r4 = r3.length     // Catch: java.lang.Throwable -> L3a
            if (r2 >= r4) goto L3e
            r4 = r3[r2]     // Catch: java.lang.Throwable -> L3a
            r4.onPointerEvent(r1)     // Catch: java.lang.Throwable -> L3a
            int r2 = r2 + 1
            goto L2f
        L3a:
            r1 = move-exception
            goto L43
        L3c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
            throw r3     // Catch: java.lang.Throwable -> L3a
        L3e:
            r5.finishInputEvent(r6, r0)
            return
        L43:
            r5.finishInputEvent(r6, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.wm.PointerEventDispatcher.onInputEvent(android.view.InputEvent):void");
    }

    public void registerInputEventListener(WindowManagerPolicyConstants.PointerEventListener listener) {
        ArrayList<WindowManagerPolicyConstants.PointerEventListener> r0 = this.mListeners;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.contains(listener) == true) goto L12;
        this.mListeners.add(listener);     // Catch: Throwable -> L9
        this.mListenersArray = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("registerInputEventListener: trying to register" + listener + " twice.");     // Catch: Throwable -> L9
    }

    public void unregisterInputEventListener(WindowManagerPolicyConstants.PointerEventListener listener) {
        ArrayList<WindowManagerPolicyConstants.PointerEventListener> r0 = this.mListeners;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.contains(listener) == false) goto L12;
        this.mListeners.remove(listener);     // Catch: Throwable -> L9
        this.mListenersArray = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("unregisterInputEventListener: " + listener + " not registered.");     // Catch: Throwable -> L9
    }

    public void dispose() {
        super.dispose();
        ArrayList<WindowManagerPolicyConstants.PointerEventListener> r0 = this.mListeners;
        monitor-enter(r0);
        this.mListeners.clear();     // Catch: Throwable -> L7
        this.mListenersArray = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
