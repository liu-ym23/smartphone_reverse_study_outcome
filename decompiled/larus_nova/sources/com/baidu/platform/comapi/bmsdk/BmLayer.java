package com.baidu.platform.comapi.bmsdk;

import android.graphics.PointF;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes39.dex */
public class BmLayer extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<BmDrawItem> f32781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f32782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f32783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f32784d;

    private static native boolean nativeAddDrawItem(long r100, long r101);

    private static native boolean nativeAddDrawItemAbove(long r100, long r101, long r102);

    private static native boolean nativeAddDrawItemBelow(long r100, long r101, long r102);

    private static native boolean nativeAddDrawItemByZIndex(long r100, long r101, int r102);

    private static native boolean nativeClearDrawItems(long r100);

    private static native boolean nativeCommitUpdate(long r100);

    private static native long nativeCreate();

    private static native Bundle nativeGetDrawItemRect(long r100, int r101, int r102, int r103, int r104);

    private static native long nativeGetLayerId(long r100);

    private static native boolean nativeHandleClick(long r100, int r101, int r102, int r103, long[] r104);

    private static native boolean nativeRemoveDrawItem(long r100, long r101);

    private static native boolean nativeSDKHandleClick(long r100, int r101, int r102, int r103, long[] r104, Bundle r105);

    private static native boolean nativeSetClickable(long r100, boolean r101);

    private static native boolean nativeSetCollideByArea(long r100, boolean r101);

    private static native boolean nativeSetCollisionBaseMap(long r100, boolean r101);

    private static native boolean nativeSetShowLevel(long r100, int r101, int r102);

    private static native boolean nativeSetVisibility(long r100, int r101);

    private static native boolean nativeUpdateDrawItemZIndex(long r100, long r101, int r102);

    public boolean a() {
        boolean r100 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L28 InterruptedException -> L33
        if (r100 == true) goto L41;
        if (r100 == false) goto L7;
        this.mNativeLock.readLock().unlock();
    L7:
        return false;
    L41:
        long r101 = getNativeInstance();     // Catch: Throwable -> L25 InterruptedException -> L27
        if (r101 != 0) goto L14;
        if (r100 == false) goto L13;
        this.mNativeLock.readLock().unlock();
    L13:
        return false;
    L14:
        Object r102 = this.f32784d;     // Catch: Throwable -> L25 InterruptedException -> L27
        monitor-enter(r102);     // Catch: Throwable -> L25 InterruptedException -> L27
        this.f32781a.clear();     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
        boolean r103 = nativeClearDrawItems(r101);     // Catch: Throwable -> L25 InterruptedException -> L27
        if (r100 == false) goto L21;
        this.mNativeLock.readLock().unlock();
    L21:
        return r103;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25 InterruptedException -> L27
    L25:
        Throwable th10 = th;
    L30:
        if (r100 == false) goto L32;
        this.mNativeLock.readLock().unlock();
    L32:
        throw th10;
    L34:
        if (r100 == false) goto L36;
        this.mNativeLock.readLock().unlock();
    L36:
        return false;
    L33:
        r100 = false;
    L28:
        th = move-exception;
        th10 = th;
        r100 = false;
        goto L30
    }

    public boolean b() {
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
            java.util.concurrent.locks.ReadWriteLock r1 = r6.mNativeLock     // Catch: java.lang.Throwable -> L3d java.lang.InterruptedException -> L48
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L3d java.lang.InterruptedException -> L48
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L3d java.lang.InterruptedException -> L48
            r3 = 2000(0x7d0, double:9.88E-321)
            boolean r1 = r1.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L3d java.lang.InterruptedException -> L48
            if (r1 != 0) goto L1b
            java.util.concurrent.locks.ReadWriteLock r1 = r6.mNativeLock
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            return r0
        L1b:
            long r1 = r6.getNativeInstance()     // Catch: java.lang.Throwable -> L3d java.lang.InterruptedException -> L48
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L2f
            java.util.concurrent.locks.ReadWriteLock r1 = r6.mNativeLock
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            return r0
        L2f:
            boolean r0 = nativeCommitUpdate(r1)     // Catch: java.lang.Throwable -> L3d java.lang.InterruptedException -> L48
            java.util.concurrent.locks.ReadWriteLock r1 = r6.mNativeLock
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            return r0
        L3d:
            r0 = move-exception
            java.util.concurrent.locks.ReadWriteLock r1 = r6.mNativeLock
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            throw r0
        L48:
            java.util.concurrent.locks.ReadWriteLock r1 = r6.mNativeLock
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.bmsdk.BmLayer.b():boolean");
    }

    public long c() {
        if (this.f32783c != 0) goto L21;
        boolean r100 = false;
        r100 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L11 Throwable -> L14
        if (r100 == false) goto L12;
        long r101 = getNativeInstance();     // Catch: InterruptedException -> L11 Throwable -> L14
        if (r101 == 0) goto L12;
        this.f32783c = nativeGetLayerId(r101);     // Catch: InterruptedException -> L11 Throwable -> L14
    L12:
        if (r100 == false) goto L21;
    L19:
        this.mNativeLock.readLock().unlock();
    L14:
        th = move-exception;
        if (r100 == false) goto L17;
        this.mNativeLock.readLock().unlock();
    L17:
        throw th;
    L18:
        if (r100 == true) goto L19;
    L21:
        return this.f32783c;
    }

    public BmLayer() {
        super(1, nativeCreate());
        this.f32781a = new ArrayList();
        this.f32782b = null;
        this.f32783c = 0;
        this.f32784d = new Object();
    }

    public BmLayer(boolean r100) {
        super(1, nativeCreate());
        this.f32781a = new ArrayList();
        this.f32782b = null;
        this.f32783c = 0;
        this.f32784d = new Object();
        boolean r101 = false;
        r101 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
        if (r101 == false) goto L10;
        long r102 = getNativeInstance();     // Catch: InterruptedException -> L9 Throwable -> L12
        if (r102 == 0) goto L10;
        nativeSetCollisionBaseMap(r102, r100);     // Catch: InterruptedException -> L9 Throwable -> L12
    L10:
        if (r101 == false) goto L21;
    L17:
        this.mNativeLock.readLock().unlock();
        return;
    L21:
        return;
    L12:
        th = move-exception;
        if (r101 == false) goto L15;
        this.mNativeLock.readLock().unlock();
    L15:
        throw th;
    L16:
        if (r101 == true) goto L17;
    }

    public boolean a(BmDrawItem r100) {
        boolean r101 = false;
        if (r100 != null) goto L51;
        return false;
    L51:
        boolean r102 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L42 InterruptedException -> L46
        if (r102 == true) goto L53;
        if (r102 == false) goto L9;
        this.mNativeLock.readLock().unlock();
    L9:
        return false;
    L53:
        long r103 = getNativeInstance();     // Catch: Throwable -> L39 InterruptedException -> L41
        if (r103 != 0) goto L16;
        if (r102 == false) goto L15;
        this.mNativeLock.readLock().unlock();
    L15:
        return false;
    L16:
        Object r104 = this.f32784d;     // Catch: Throwable -> L39 InterruptedException -> L41
        monitor-enter(r104);     // Catch: Throwable -> L39 InterruptedException -> L41
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39 InterruptedException -> L41
    L19:
        if (this.f32781a.contains(r100) == true) goto L24;
        monitor-exit(r104);     // Catch: Throwable -> L36
        if (r102 == false) goto L23;
        this.mNativeLock.readLock().unlock();
    L23:
        return false;
    L24:
        this.f32781a.remove(r100);     // Catch: Throwable -> L36
        monitor-exit(r104);     // Catch: Throwable -> L36
        long r105 = r100.getNativeInstance();     // Catch: Throwable -> L39 InterruptedException -> L41
        if (r105 != 0) goto L32;
        if (r102 == false) goto L31;
        this.mNativeLock.readLock().unlock();
    L31:
        return false;
    L32:
        boolean r106 = nativeRemoveDrawItem(r103, r105);     // Catch: Throwable -> L39 InterruptedException -> L41
        if (r102 == false) goto L35;
        this.mNativeLock.readLock().unlock();
    L35:
        return r106;
    L39:
        th = th;
        r101 = r102;
    L43:
        if (r101 == false) goto L45;
        this.mNativeLock.readLock().unlock();
    L45:
        throw th;
    L47:
        if (r102 == false) goto L49;
        this.mNativeLock.readLock().unlock();
    L49:
        return false;
    L46:
        r102 = false;
    L42:
        th = th;
        goto L43
    }

    public BmDrawItem a(String r100) {
        Object r101 = this.f32784d;
        monitor-enter(r101);
        Iterator<BmDrawItem> r102 = this.f32781a.iterator();     // Catch: Throwable -> L16
    L6:
        if (r102.hasNext() == false) goto L13;
        BmDrawItem r103 = r102.next();     // Catch: Throwable -> L16
        if (r100.isEmpty() == true) goto L6;
        if (r103.getName().equals(r100) == false) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r103;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public void a(c r100) {
        this.f32782b = r100;
    }

    public boolean a(String r110, BmDrawItem r111) {
        boolean r100 = false;
        boolean r101 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L49 InterruptedException -> L53
        if (r101 == true) goto L59;
        if (r101 == false) goto L7;
        this.mNativeLock.readLock().unlock();
    L7:
        return false;
    L59:
        long r102 = getNativeInstance();     // Catch: Throwable -> L46 InterruptedException -> L48
        if (r102 != 0) goto L14;
        if (r101 == false) goto L13;
        this.mNativeLock.readLock().unlock();
    L13:
        return false;
    L14:
        Object r103 = this.f32784d;     // Catch: Throwable -> L46 InterruptedException -> L48
        monitor-enter(r103);     // Catch: Throwable -> L46 InterruptedException -> L48
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46 InterruptedException -> L48
    L17:
        if (TextUtils.isEmpty(r110) == true) goto L24;
        int r104 = this.f32781a.size();     // Catch: Throwable -> L43
        int r105 = 0;
    L19:
        if (r105 >= r104) goto L24;
        if (r110.equals(this.f32781a.get(r105).getName()) == true) goto L22;
        r105 = r105 + 1;     // Catch: Throwable -> L43
        goto L19
    L22:
        long r106 = this.f32781a.get(r105).getNativeInstance();     // Catch: Throwable -> L43
        this.f32781a.add(r105 + 1, r111);     // Catch: Throwable -> L43
    L26:
        if (r106 != 0) goto L28;
        this.f32781a.add(r111);     // Catch: Throwable -> L43
    L28:
        monitor-exit(r103);     // Catch: Throwable -> L43
        if (r111 != null) goto L31;
        long r107 = 0;
    L34:
        if (r107 != 0) goto L39;
        if (r101 == false) goto L37;
        this.mNativeLock.readLock().unlock();
    L37:
        return false;
    L39:
        boolean r112 = nativeAddDrawItemAbove(r102, r106, r107);     // Catch: Throwable -> L46 InterruptedException -> L48
        if (r101 == false) goto L42;
        this.mNativeLock.readLock().unlock();
    L42:
        return r112;
    L31:
        r107 = r111.getNativeInstance();     // Catch: Throwable -> L46 InterruptedException -> L48
        goto L34
    L24:
        r106 = 0;
    L46:
        th = th;
        r100 = r101;
    L50:
        if (r100 == false) goto L52;
        this.mNativeLock.readLock().unlock();
    L52:
        throw th;
    L54:
        if (r101 == false) goto L56;
        this.mNativeLock.readLock().unlock();
    L56:
        return false;
    L53:
        r101 = false;
    L49:
        th = th;
        goto L50
    }

    public boolean a(BmDrawItem r110, int r111) {
        boolean r100 = false;
        boolean r101 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L37 InterruptedException -> L41
        if (r101 == true) goto L47;
        if (r101 == false) goto L7;
        this.mNativeLock.readLock().unlock();
    L7:
        return false;
    L47:
        long r102 = getNativeInstance();     // Catch: Throwable -> L34 InterruptedException -> L36
        if (r102 != 0) goto L14;
        if (r101 == false) goto L13;
        this.mNativeLock.readLock().unlock();
    L13:
        return false;
    L14:
        if (r110 == null) goto L17;
        long r103 = r110.getNativeInstance();     // Catch: Throwable -> L34 InterruptedException -> L36
    L19:
        if (r103 != 0) goto L23;
        if (r101 == false) goto L22;
        this.mNativeLock.readLock().unlock();
    L22:
        return false;
    L23:
        Object r104 = this.f32784d;     // Catch: Throwable -> L34 InterruptedException -> L36
        monitor-enter(r104);     // Catch: Throwable -> L34 InterruptedException -> L36
        this.f32781a.add(r110);     // Catch: Throwable -> L31
        monitor-exit(r104);     // Catch: Throwable -> L31
        boolean r112 = nativeAddDrawItemByZIndex(r102, r103, r111);     // Catch: Throwable -> L34 InterruptedException -> L36
        if (r101 == false) goto L30;
        this.mNativeLock.readLock().unlock();
    L30:
        return r112;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34 InterruptedException -> L36
    L17:
        r103 = 0;
    L34:
        th = th;
        r100 = r101;
    L38:
        if (r100 == false) goto L40;
        this.mNativeLock.readLock().unlock();
    L40:
        throw th;
    L42:
        if (r101 == false) goto L44;
        this.mNativeLock.readLock().unlock();
    L44:
        return false;
    L41:
        r101 = false;
    L37:
        th = th;
        goto L38
    }

    public boolean a(BmDrawItem r100, short r110) {
        boolean r101 = false;
        if (r100 != null) goto L39;
        return false;
    L39:
        boolean r102 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L29 InterruptedException -> L33
        if (r102 == true) goto L37;
        if (r102 == false) goto L9;
        this.mNativeLock.readLock().unlock();
    L9:
        return false;
    L37:
        long r103 = getNativeInstance();     // Catch: Throwable -> L26 InterruptedException -> L28
        if (r103 != 0) goto L16;
        if (r102 == false) goto L15;
        this.mNativeLock.readLock().unlock();
    L15:
        return false;
    L16:
        long r104 = r100.getNativeInstance();     // Catch: Throwable -> L26 InterruptedException -> L28
        if (r104 != 0) goto L22;
        if (r102 == false) goto L21;
        this.mNativeLock.readLock().unlock();
    L21:
        return false;
    L22:
        boolean r105 = nativeUpdateDrawItemZIndex(r103, r104, r110);     // Catch: Throwable -> L26 InterruptedException -> L28
        if (r102 == false) goto L25;
        this.mNativeLock.readLock().unlock();
    L25:
        return r105;
    L26:
        th = th;
        r101 = r102;
    L30:
        if (r101 == false) goto L32;
        this.mNativeLock.readLock().unlock();
    L32:
        throw th;
    L34:
        if (r102 == false) goto L36;
        this.mNativeLock.readLock().unlock();
    L36:
        return false;
    L33:
        r102 = false;
    L29:
        th = th;
        goto L30
    }

    public BmDrawItem a(int r110, int r111, int r112) {
        long[] r100 = {0, 0, -1};
        Bundle r101 = new Bundle();
        boolean r113 = false;
        int r114 = 0;
        boolean r115 = false;
        boolean r116 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L41 InterruptedException -> L45
        if (r116 == true) goto L50;
        if (r116 == false) goto L7;
        this.mNativeLock.readLock().unlock();
    L7:
        return null;
    L50:
        long r102 = getNativeInstance();     // Catch: Throwable -> L38 InterruptedException -> L40
        if (r102 != 0) goto L15;
        if (r116 == false) goto L13;
        this.mNativeLock.readLock().unlock();
    L13:
        return null;
    L15:
        boolean r103 = nativeSDKHandleClick(r102, r110, r111, r112, r100, r101);     // Catch: Throwable -> L38 InterruptedException -> L40
        if (r116 == false) goto L18;
        this.mNativeLock.readLock().unlock();
    L18:
        if (r103 == true) goto L20;
    L37:
        return null;
    L20:
        if (this.f32782b == null) goto L37;
        long r104 = r100[0];
        if (r104 == 0) goto L37;
        Object r105 = this.f32784d;
        monitor-enter(r105);
    L49:
    L34:
        th = move-exception;
        throw th;
    L26:
        if (r114 >= this.f32781a.size()) goto L32;
        BmDrawItem r106 = this.f32781a.get(r114);     // Catch: Throwable -> L34
        if (r106.getNativeInstance() == r104) goto L29;
        r114 = r114 + 1;     // Catch: Throwable -> L34
        goto L49
    L29:
        monitor-exit(r105);     // Catch: Throwable -> L34
        return r106;
    L32:
        monitor-exit(r105);     // Catch: Throwable -> L34
        goto L37
    L40:
        r115 = r116;
    L38:
        th = th;
        r113 = r116;
    L42:
        if (r113 == false) goto L44;
        this.mNativeLock.readLock().unlock();
    L44:
        throw th;
    L41:
        th = th;
    L46:
        if (r115 == false) goto L48;
        this.mNativeLock.readLock().unlock();
    L48:
        return null;
    }

    public boolean a(int r110, int r111, int r112, boolean r210, boolean r211) {
        long[] r100 = {0, 0, -1};
        Bundle r101 = new Bundle();
        boolean r113 = false;
        boolean r114 = this.mNativeLock.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L70 InterruptedException -> L74
        if (r114 == true) goto L80;
        if (r114 == false) goto L7;
        this.mNativeLock.readLock().unlock();
    L7:
        return false;
    L80:
        long r102 = getNativeInstance();     // Catch: Throwable -> L67 InterruptedException -> L69
        if (r102 != 0) goto L15;
        if (r114 == false) goto L13;
        this.mNativeLock.readLock().unlock();
    L13:
        return false;
    L15:
        boolean r103 = nativeSDKHandleClick(r102, r110, r111, r112, r100, r101);     // Catch: Throwable -> L67 InterruptedException -> L69
        if (r114 == false) goto L18;
        this.mNativeLock.readLock().unlock();
    L18:
        if (r103 == true) goto L20;
    L66:
        return r103;
    L20:
        if (this.f32782b == null) goto L66;
        long r104 = r100[0];
        if (r104 == 0) goto L66;
        Object r105 = this.f32784d;
        monitor-enter(r105);
        int r106 = 0;
    L78:
    L63:
        th = move-exception;
        throw th;
    L27:
        if (r106 >= this.f32781a.size()) goto L61;
        BmDrawItem r107 = this.f32781a.get(r106);     // Catch: Throwable -> L63
        if (r107.getNativeInstance() == r104) goto L30;
        r106 = r106 + 1;     // Catch: Throwable -> L63
        goto L78
    L30:
        long r115 = r100[1];     // Catch: Throwable -> L63
        if (r115 != 0) goto L33;
    L38:
        BmBaseUI r108 = null;
    L40:
        if (r101.containsKey("hole_index") == false) goto L43;
        r107.a(r101.getInt("hole_index"));     // Catch: Throwable -> L63
    L43:
        if (r101.containsKey("multipoint_index") == false) goto L45;
        ((BmMultiPoint) r107).e(r101.getInt("multipoint_index"));     // Catch: Throwable -> L63
    L45:
        if (r210 == false) goto L50;
        if (r211 == false) goto L61;
        if (r108 == null) goto L49;
        this.f32782b.a(r107, r108);     // Catch: Throwable -> L63
        goto L61
    L49:
        this.f32782b.a(r107);     // Catch: Throwable -> L63
        goto L61
    L50:
        if (r108 == null) goto L52;
        this.f32782b.a(r107, r108);     // Catch: Throwable -> L63
    L54:
        if (r101.containsKey("relativePt") == false) goto L61;
        float[] r109 = r101.getFloatArray("relativePt");     // Catch: Throwable -> L63
        if (r109 == null) goto L61;
        if (r109.length < 2) goto L61;
        this.f32782b.a(r107, new PointF(r109[0], r109[1]));     // Catch: Throwable -> L63
        goto L61
    L52:
        this.f32782b.a(r107);     // Catch: Throwable -> L63
        goto L54
    L33:
        if ((r107 instanceof BmBaseMarker) == false) goto L36;
        r108 = ((BmBaseMarker) r107).b(r115);     // Catch: Throwable -> L63
        goto L40
    L36:
        if ((r107 instanceof Bm3DModel) == false) goto L38;
        r108 = ((Bm3DModel) r107).b(r115);     // Catch: Throwable -> L63
    L61:
        monitor-exit(r105);     // Catch: Throwable -> L63
        goto L66
    L67:
        th = th;
        r113 = r114;
    L71:
        if (r113 == false) goto L73;
        this.mNativeLock.readLock().unlock();
    L73:
        throw th;
    L75:
        if (r114 == false) goto L77;
        this.mNativeLock.readLock().unlock();
    L77:
        return false;
    L74:
        r114 = false;
    L70:
        th = th;
        goto L71
    }
}
