package com.obric.aiagent.apm.impl;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.apm.log.AndroidLogcatInst;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.q;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SysLogDependImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SysLogDependImpl implements ISysLogDepend {
    private final List<AndroidLogcatInst> insts;

    public SysLogDependImpl() {
        this.insts = p.a(AndroidLogcatInst.INSTANCE);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void v(String r4, String r5) {
        o.e(r4, "tag");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.insts, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AndroidLogcatInst) ZeusTransformUtils.preCheckCast(r3.next(), AndroidLogcatInst.class, "com.obric.aiagent.plugin")).v(r4, r5);
        goto L4
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void d(String r4, String r5) {
        o.e(r4, "tag");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.insts, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AndroidLogcatInst) ZeusTransformUtils.preCheckCast(r3.next(), AndroidLogcatInst.class, "com.obric.aiagent.plugin")).d(r4, r5);
        goto L4
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void i(String r4, String r5) {
        o.e(r4, "tag");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.insts, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AndroidLogcatInst) ZeusTransformUtils.preCheckCast(r3.next(), AndroidLogcatInst.class, "com.obric.aiagent.plugin")).i(r4, r5);
        goto L4
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r4, String r5) {
        o.e(r4, "tag");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.insts, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AndroidLogcatInst) ZeusTransformUtils.preCheckCast(r3.next(), AndroidLogcatInst.class, "com.obric.aiagent.plugin")).w(r4, r5);
        goto L4
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r4, String r5, Throwable r6) {
        o.e(r4, "tag");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.insts, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AndroidLogcatInst) ZeusTransformUtils.preCheckCast(r3.next(), AndroidLogcatInst.class, "com.obric.aiagent.plugin")).w(r4, r5, r6);
        goto L4
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r4, Throwable r5) {
        o.e(r4, "tag");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.insts, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AndroidLogcatInst) ZeusTransformUtils.preCheckCast(r3.next(), AndroidLogcatInst.class, "com.obric.aiagent.plugin")).w(r4, r5);
        goto L4
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void e(String r4, String r5) {
        o.e(r4, "tag");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.insts, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AndroidLogcatInst) ZeusTransformUtils.preCheckCast(r3.next(), AndroidLogcatInst.class, "com.obric.aiagent.plugin")).e(r4, r5);
        goto L4
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void e(String r4, String r5, Throwable r6) {
        o.e(r4, "tag");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.insts, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((AndroidLogcatInst) ZeusTransformUtils.preCheckCast(r3.next(), AndroidLogcatInst.class, "com.obric.aiagent.plugin")).e(r4, r5, r6);
        goto L4
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public boolean isDebug() {
        return AndroidLogcatInst.INSTANCE.isDebug();
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public String getDirPath() {
        return AndroidLogcatInst.INSTANCE.getDirPath();
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void uploadAllLog(String r2, q<? super Boolean, ? super Integer, ? super String, x> r3) {
        q<? super Boolean, ? super Integer, ? super String, x> r1 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        o.e(r2, DBHelper.BATTERY_COL_SCENE);
        AndroidLogcatInst.INSTANCE.uploadAllLog(r2, r1);
    }
}
