package com.stepos.aiengine.api.task;

import android.os.Bundle;
import android.os.Process;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u000fJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019J\u0010\u0010\u001e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0019JL\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b!\u0010\u001cJ\u0010\u0010\"\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\"\u0010\u0019J\u001a\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b4\u0010\u0019¨\u00066"}, d2 = {"Lcom/stepos/aiengine/api/task/AlgorithmToken;", "", "", e.f30860s, "", "result", "reasonCode", "", "message", "uid", "pid", "<init>", "(JIILjava/lang/String;II)V", "", "isResultSuccess", "()Z", "isResultFailed", "isResultCanceled", "hasResult", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "component1", "()J", "component2", "()I", "component3", "component4", "()Ljava/lang/String;", "component5", "component6", ChatTracker.CLICK_COPY, "(JIILjava/lang/String;II)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", "getIdentity", Const.INTENT_KEY_PKGNAME, "I", "getResult", "c", "getReasonCode", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "getMessage", "e", "getUid", "f", "getPid", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
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

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long identity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int result;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int reasonCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String message;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final int uid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final int pid;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicLong f23687g = new AtomicLong(System.currentTimeMillis());

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u001a\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u0005H\u0007J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/api/task/AlgorithmToken$Companion;", "", "<init>", "()V", "RESULT_NONE", "", "RESULT_SUCCEEDED", "RESULT_FAILED", "RESULT_CANCELED", "REASON_CODE_SIGNATURE_MISMATCH", "REASON_CODE_LOAD_ALGORITHM_FAIL", "REASON_CODE_DEAD_OBJECT", "REASON_CODE_CLIENT_EXCEPTION", "REASON_CODE_SERVER_EXCEPTION", "KEY_API", "", "KEY_ID", "KEY_RESULT", "KEY_REASON_CODE", "KEY_REASON", "KEY_UID", "KEY_PID", "API_VERSION", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "submit", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "failed", "message", "reasonCode", "fromBundle", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ AlgorithmToken failed$default(Companion companion, String str, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = -1;
            }
            return companion.failed(str, i10);
        }

        public final AlgorithmToken failed(String message, int reasonCode) {
            p.i(message, "message");
            return new AlgorithmToken(-1L, -1, reasonCode, message, 0, 0, 48, null);
        }

        public final AlgorithmToken fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            long j10 = bundle.getLong("id", -1L);
            int i10 = bundle.getInt("result", 0);
            int i11 = bundle.getInt("reason.code", 0);
            String string = bundle.getString("reason", "");
            return new AlgorithmToken(j10, i10, i11, string == null ? "" : string, bundle.getInt("uid", 0), bundle.getInt("pid", 0));
        }

        public final AlgorithmToken submit() {
            return new AlgorithmToken(AlgorithmToken.f23687g.incrementAndGet(), 0, 0, null, Process.myUid(), Process.myPid(), 12, null);
        }

        public Companion() {
        }
    }

    public AlgorithmToken(long j10, int i10, int i11, String message, int i12, int i13) {
        p.i(message, "message");
        this.identity = j10;
        this.result = i10;
        this.reasonCode = i11;
        this.message = message;
        this.uid = i12;
        this.pid = i13;
    }

    public static /* synthetic */ AlgorithmToken copy$default(AlgorithmToken algorithmToken, long j10, int i10, int i11, String str, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            j10 = algorithmToken.identity;
        }
        long j11 = j10;
        if ((i14 & 2) != 0) {
            i10 = algorithmToken.result;
        }
        int i15 = i10;
        if ((i14 & 4) != 0) {
            i11 = algorithmToken.reasonCode;
        }
        int i16 = i11;
        if ((i14 & 8) != 0) {
            str = algorithmToken.message;
        }
        String str2 = str;
        if ((i14 & 16) != 0) {
            i12 = algorithmToken.uid;
        }
        int i17 = i12;
        if ((i14 & 32) != 0) {
            i13 = algorithmToken.pid;
        }
        return algorithmToken.copy(j11, i15, i16, str2, i17, i13);
    }

    public static final AlgorithmToken failed(String str, int i10) {
        return INSTANCE.failed(str, i10);
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
        p.i(message, "message");
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
        return this.identity == algorithmToken.identity && this.result == algorithmToken.result && this.reasonCode == algorithmToken.reasonCode && p.d(this.message, algorithmToken.message) && this.uid == algorithmToken.uid && this.pid == algorithmToken.pid;
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
        return (((((((((Long.hashCode(this.identity) * 31) + Integer.hashCode(this.result)) * 31) + Integer.hashCode(this.reasonCode)) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.uid)) * 31) + Integer.hashCode(this.pid);
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
        bundle.putInt("pid", this.pid);
        return bundle;
    }

    public String toString() {
        return "AlgorithmToken(identity=" + this.identity + ", result=" + this.result + ", reasonCode=" + this.reasonCode + ", message=" + this.message + ", uid=" + this.uid + ", pid=" + this.pid + ")";
    }

    public /* synthetic */ AlgorithmToken(long j10, int i10, int i11, String str, int i12, int i13, int i14, i iVar) {
        this(j10, (i14 & 2) != 0 ? 0 : i10, (i14 & 4) != 0 ? 0 : i11, (i14 & 8) != 0 ? "" : str, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? 0 : i13);
    }
}
