package com.stepos.aiengine.api.task;

import android.os.Bundle;
import android.os.Process;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.constant.Constants;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.twoway.FlowType;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u000fJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019J\u0010\u0010\u001e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0019JL\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b!\u0010\u001cJ\u0010\u0010\"\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\"\u0010\u0019J\u001a\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b4\u0010\u0019¨\u00066"}, d2 = {"Lcom/stepos/aiengine/api/task/AlgorithmToken;", "", "", "identity", "", "result", "reasonCode", "", "message", "uid", Constants.PARAM_PID, AppAgent.CONSTRUCT, "(JIILjava/lang/String;II)V", "", "isResultSuccess", "()Z", "isResultFailed", "isResultCanceled", "hasResult", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "component1", "()J", "component2", "()I", "component3", "component4", "()Ljava/lang/String;", "component5", "component6", "copy", "(JIILjava/lang/String;II)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "a", "J", "getIdentity", "b", "I", "getResult", "c", "getReasonCode", "d", "Ljava/lang/String;", "getMessage", "e", "getUid", "f", "getPid", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AlgorithmToken {
    public static final int REASON_CODE_CLIENT_EXCEPTION = -1;
    public static final int REASON_CODE_DEAD_OBJECT = -2;
    public static final int REASON_CODE_LOAD_ALGORITHM_FAIL = -3;
    public static final int REASON_CODE_SERVER_EXCEPTION = 0;
    public static final int REASON_CODE_SIGNATURE_MISMATCH = -4;
    public static final int RESULT_CANCELED = -2;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_NONE = 0;
    public static final int RESULT_SUCCEEDED = 1;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long identity;

    /* renamed from: b, reason: from kotlin metadata */
    public final int result;

    /* renamed from: c, reason: from kotlin metadata */
    public final int reasonCode;

    /* renamed from: d, reason: from kotlin metadata */
    public final String message;

    /* renamed from: e, reason: from kotlin metadata */
    public final int uid;

    /* renamed from: f, reason: from kotlin metadata */
    public final int pid;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final AtomicLong g = new AtomicLong(System.currentTimeMillis());

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010 \u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0014\u0010!\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0010R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/aiengine/api/task/AlgorithmToken$Companion;", "", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "submit", "()Lcom/stepos/aiengine/api/task/AlgorithmToken;", "", "message", "", "reasonCode", FlowType.FAILED, "(Ljava/lang/String;I)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "Landroid/os/Bundle;", "bundle", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "RESULT_NONE", "I", "RESULT_SUCCEEDED", "RESULT_FAILED", "RESULT_CANCELED", "REASON_CODE_SIGNATURE_MISMATCH", "REASON_CODE_LOAD_ALGORITHM_FAIL", "REASON_CODE_DEAD_OBJECT", "REASON_CODE_CLIENT_EXCEPTION", "REASON_CODE_SERVER_EXCEPTION", "KEY_API", "Ljava/lang/String;", "KEY_ID", "KEY_RESULT", "KEY_REASON_CODE", "KEY_REASON", "KEY_UID", "KEY_PID", "API_VERSION", "Ljava/util/concurrent/atomic/AtomicLong;", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public static /* synthetic */ AlgorithmToken failed$default(Companion companion, String str, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i = -1;
            }
            return companion.failed(str, i);
        }

        public final AlgorithmToken failed(String message, int reasonCode) {
            k.f(message, "message");
            return new AlgorithmToken(-1L, -1, reasonCode, message, 0, 0, 48, null);
        }

        public final AlgorithmToken fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            long j5 = bundle.getLong("id", -1L);
            int i = bundle.getInt("result", 0);
            int i6 = bundle.getInt("reason.code", 0);
            String string = bundle.getString("reason", "");
            return new AlgorithmToken(j5, i, i6, string == null ? "" : string, bundle.getInt("uid", 0), bundle.getInt(Constants.PARAM_PID, 0));
        }

        public final AlgorithmToken submit() {
            return new AlgorithmToken(AlgorithmToken.g.incrementAndGet(), 0, 0, null, Process.myUid(), Process.myPid(), 12, null);
        }
    }

    public AlgorithmToken(long j5, int i, int i6, String message, int i10, int i11) {
        k.f(message, "message");
        this.identity = j5;
        this.result = i;
        this.reasonCode = i6;
        this.message = message;
        this.uid = i10;
        this.pid = i11;
    }

    public static /* synthetic */ AlgorithmToken copy$default(AlgorithmToken algorithmToken, long j5, int i, int i6, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            j5 = algorithmToken.identity;
        }
        long j6 = j5;
        if ((i12 & 2) != 0) {
            i = algorithmToken.result;
        }
        int i13 = i;
        if ((i12 & 4) != 0) {
            i6 = algorithmToken.reasonCode;
        }
        int i14 = i6;
        if ((i12 & 8) != 0) {
            str = algorithmToken.message;
        }
        String str2 = str;
        if ((i12 & 16) != 0) {
            i10 = algorithmToken.uid;
        }
        int i15 = i10;
        if ((i12 & 32) != 0) {
            i11 = algorithmToken.pid;
        }
        return algorithmToken.copy(j6, i13, i14, str2, i15, i11);
    }

    public static final AlgorithmToken failed(String str, int i) {
        return INSTANCE.failed(str, i);
    }

    public static final AlgorithmToken fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    public static final AlgorithmToken submit() {
        return INSTANCE.submit();
    }

    /* renamed from: component1, reason: from getter */
    public final long getIdentity() {
        return this.identity;
    }

    /* renamed from: component2, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    /* renamed from: component3, reason: from getter */
    public final int getReasonCode() {
        return this.reasonCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUid() {
        return this.uid;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPid() {
        return this.pid;
    }

    public final AlgorithmToken copy(long identity, int result, int reasonCode, String message, int uid, int pid) {
        k.f(message, "message");
        return new AlgorithmToken(identity, result, reasonCode, message, uid, pid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlgorithmToken)) {
            return false;
        }
        AlgorithmToken algorithmToken = (AlgorithmToken) other;
        return this.identity == algorithmToken.identity && this.result == algorithmToken.result && this.reasonCode == algorithmToken.reasonCode && k.b(this.message, algorithmToken.message) && this.uid == algorithmToken.uid && this.pid == algorithmToken.pid;
    }

    public final long getIdentity() {
        return this.identity;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getPid() {
        return this.pid;
    }

    public final int getReasonCode() {
        return this.reasonCode;
    }

    public final int getResult() {
        return this.result;
    }

    public final int getUid() {
        return this.uid;
    }

    public final boolean hasResult() {
        return this.result != 0;
    }

    public int hashCode() {
        return Integer.hashCode(this.pid) + a.a(this.uid, B7.a.c(a.a(this.reasonCode, a.a(this.result, Long.hashCode(this.identity) * 31, 31), 31), 31, this.message), 31);
    }

    public final boolean isResultCanceled() {
        return this.result == -2;
    }

    public final boolean isResultFailed() {
        return this.result == -1;
    }

    public final boolean isResultSuccess() {
        return this.result == 1;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("api", 3);
        bundle.putLong("id", this.identity);
        bundle.putInt("result", this.result);
        bundle.putInt("reason.code", this.reasonCode);
        bundle.putString("reason", this.message);
        bundle.putInt("uid", this.uid);
        bundle.putInt(Constants.PARAM_PID, this.pid);
        return bundle;
    }

    public String toString() {
        return "AlgorithmToken(identity=" + this.identity + ", result=" + this.result + ", reasonCode=" + this.reasonCode + ", message=" + this.message + ", uid=" + this.uid + ", pid=" + this.pid + ")";
    }

    public /* synthetic */ AlgorithmToken(long j5, int i, int i6, String str, int i10, int i11, int i12, e eVar) {
        this(j5, (i12 & 2) != 0 ? 0 : i, (i12 & 4) != 0 ? 0 : i6, (i12 & 8) != 0 ? "" : str, (i12 & 16) != 0 ? 0 : i10, (i12 & 32) != 0 ? 0 : i11);
    }
}
