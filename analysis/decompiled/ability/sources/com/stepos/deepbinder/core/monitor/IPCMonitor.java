package com.stepos.deepbinder.core.monitor;

import B7.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.tools.IPCThreadCaller;
import io.modelcontextprotocol.spec.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/deepbinder/core/monitor/IPCMonitor;", "", AppAgent.CONSTRUCT, "()V", "MODULE_NAME", "", "TAG", "isMonitorValid", "", "IpcState", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IPCMonitor {
    private static final String MODULE_NAME = "DeepBinder";
    private static final String TAG = "IPCMonitor";
    public static final IPCMonitor INSTANCE = new IPCMonitor();
    private static volatile boolean isMonitorValid = true;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0005R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u0005R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u0005¨\u00060"}, d2 = {"Lcom/stepos/deepbinder/core/monitor/IPCMonitor$IpcState;", "", "", "type", AppAgent.CONSTRUCT, "(I)V", "", "register", "()Z", "isDegrade", "LC7/r;", "changeDegrade", "(Z)V", "commit", "()V", "", "toString", "()Ljava/lang/String;", "I", "serviceName", "Ljava/lang/String;", "getServiceName", "setServiceName", "(Ljava/lang/String;)V", "methodName", "getMethodName", "setMethodName", "result", "getResult", "()I", "setResult", "degrade", "getDegrade", "setDegrade", "", "costTime", "J", "getCostTime", "()J", "setCostTime", "(J)V", "invokeTime", "getInvokeTime", "setInvokeTime", "dataSize", "getDataSize", "setDataSize", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class IpcState {
        private static volatile boolean isRegistered;
        private long costTime;
        private int dataSize;
        private int degrade;
        private long invokeTime;
        private String methodName;
        private int result;
        private String serviceName;
        private final int type;

        public IpcState(int i) {
            this.type = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized boolean register() {
            if (!IPCMonitor.isMonitorValid) {
                return false;
            }
            if (isRegistered) {
                return true;
            }
            isRegistered = true;
            return isRegistered;
        }

        public final void changeDegrade(boolean isDegrade) {
            this.degrade = isDegrade ? 1 : 0;
        }

        public final void commit() {
            if (IPCMonitor.isMonitorValid) {
                IPCThreadCaller.INSTANCE.post(false, true, new c(this, 1));
            }
        }

        public final long getCostTime() {
            return this.costTime;
        }

        public final int getDataSize() {
            return this.dataSize;
        }

        public final int getDegrade() {
            return this.degrade;
        }

        public final long getInvokeTime() {
            return this.invokeTime;
        }

        public final String getMethodName() {
            return this.methodName;
        }

        public final int getResult() {
            return this.result;
        }

        public final String getServiceName() {
            return this.serviceName;
        }

        public final void setCostTime(long j5) {
            this.costTime = j5;
        }

        public final void setDataSize(int i) {
            this.dataSize = i;
        }

        public final void setDegrade(int i) {
            this.degrade = i;
        }

        public final void setInvokeTime(long j5) {
            this.invokeTime = j5;
        }

        public final void setMethodName(String str) {
            this.methodName = str;
        }

        public final void setResult(int i) {
            this.result = i;
        }

        public final void setServiceName(String str) {
            this.serviceName = str;
        }

        public String toString() {
            String str = this.serviceName;
            String str2 = this.methodName;
            int i = this.type;
            int i6 = this.result;
            int i10 = this.degrade;
            long j5 = this.costTime;
            long j6 = this.invokeTime;
            int i11 = this.dataSize;
            StringBuilder sbW = a.w("IpcState{serviceName='", str, "', methodName='", str2, "', type=");
            androidx.constraintlayout.core.dsl.a.y(sbW, i, ", result=", i6, ", degrade=");
            sbW.append(i10);
            sbW.append(", costTime=");
            sbW.append(j5);
            b.y(j6, ", invokeTime=", ", dataSize=", sbW);
            return androidx.appfunctions.metadata.a.o(sbW, "}", i11);
        }
    }

    private IPCMonitor() {
    }
}
