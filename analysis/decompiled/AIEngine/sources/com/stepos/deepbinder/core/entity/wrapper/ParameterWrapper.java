package com.stepos.deepbinder.core.entity.wrapper;

import android.os.IBinder;
import com.stepos.backend.onnx.SmsParseCpuModel;
import com.stepos.core.ota.d;
import com.stepos.cpuset.c;
import com.stepos.deepbinder.core.entity.pool.ObjectPool;
import f.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class ParameterWrapper extends BaseWrapper {
    private static final String TAG = "ParameterWrapper";
    private IBinder clientServiceBinder;
    private Object data;
    private int flowFlag;
    private int hashCodeValue;
    private long timeStamp;
    public static final Companion Companion = new Companion(null);
    private static final ObjectPool<ParameterWrapper> pool = new ObjectPool<>(SmsParseCpuModel.MAX_SEQ_LEN, new c(12), new o6.a(6));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ParameterWrapper obtain() {
            return (ParameterWrapper) ParameterWrapper.pool.borrowObject();
        }

        private Companion() {
        }
    }

    private ParameterWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterWrapper pool$lambda$6() {
        return new ParameterWrapper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n pool$lambda$7(ParameterWrapper wrapper) {
        g.f(wrapper, "wrapper");
        wrapper.setName("");
        wrapper.clientServiceBinder = null;
        wrapper.data = null;
        wrapper.flowFlag = -1;
        wrapper.hashCodeValue = -1;
        wrapper.timeStamp = -1L;
        return n.f10413a;
    }

    public final IBinder getClientServiceBinder() {
        return this.clientServiceBinder;
    }

    public final Object getData() {
        return this.data;
    }

    public final int getFlowFlag() {
        return this.flowFlag;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    @Override // com.stepos.deepbinder.core.entity.wrapper.BaseWrapper
    public void recycle() {
        pool.returnObject(this);
    }

    public final void setClientServiceBinder(IBinder iBinder) {
        this.clientServiceBinder = iBinder;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final void setFlowFlag(int i10) {
        this.flowFlag = i10;
    }

    public final void setHashCodeValue(int i10) {
        this.hashCodeValue = i10;
    }

    public final void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public String toString() {
        String name = getName();
        int i10 = this.flowFlag;
        int i11 = this.hashCodeValue;
        long j10 = this.timeStamp;
        boolean z = this.data != null;
        StringBuilder sbF = h0.e.f("ParameterWrapper(name='", name, "', flowFlag=", i10, ", hashCodeValue=");
        d.s(sbF, i11, ", timeStamp=", j10);
        sbF.append(", hasData=");
        sbF.append(z);
        sbF.append(")");
        return sbF.toString();
    }

    public final ParameterWrapper withClientServiceBinder(IBinder iBinder) {
        this.clientServiceBinder = iBinder;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper withData(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper.withData(java.lang.Object):com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper");
    }

    public final ParameterWrapper withFlowFlag(int i10) {
        this.flowFlag = i10;
        return this;
    }

    public final ParameterWrapper withHashCodeValue(int i10) {
        this.hashCodeValue = i10;
        return this;
    }

    public final ParameterWrapper withParameterName(String name) {
        g.f(name, "name");
        setName(name);
        return this;
    }

    public final ParameterWrapper withTimeStamp(long j10) {
        this.timeStamp = j10;
        return this;
    }
}
