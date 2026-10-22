package stepai.aios.guiexecutor.api;

import D7.N;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.dsl.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!Jp\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiOptions;", "", InjectExperienceResult.REASON_TIMEOUT, "", "retryCount", "", "retryDelay", "failurePolicy", "Lstepai/aios/guiexecutor/api/FailurePolicy;", "waitForIdle", "", "captureScreenshot", "resources", "", "Lstepai/aios/guiexecutor/api/GuiResource;", "priority", WindowStateInfo.KEY_DISPLAY_ID, AppAgent.CONSTRUCT, "(JIJLstepai/aios/guiexecutor/api/FailurePolicy;ZZLjava/util/Set;ILjava/lang/Integer;)V", "getTimeout", "()J", "getRetryCount", "()I", "getRetryDelay", "getFailurePolicy", "()Lstepai/aios/guiexecutor/api/FailurePolicy;", "getWaitForIdle", "()Z", "getCaptureScreenshot", "getResources", "()Ljava/util/Set;", "getPriority", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JIJLstepai/aios/guiexecutor/api/FailurePolicy;ZZLjava/util/Set;ILjava/lang/Integer;)Lstepai/aios/guiexecutor/api/GuiOptions;", "equals", "other", "hashCode", "toString", "", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean captureScreenshot;
    private final Integer displayId;
    private final FailurePolicy failurePolicy;
    private final int priority;
    private final Set<GuiResource> resources;
    private final int retryCount;
    private final long retryDelay;
    private final long timeout;
    private final boolean waitForIdle;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b¨\u0006\r"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiOptions$Companion;", "", AppAgent.CONSTRUCT, "()V", "default", "Lstepai/aios/guiexecutor/api/GuiOptions;", "withTimeout", InjectExperienceResult.REASON_TIMEOUT, "", "withRetry", "count", "", "delay", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ GuiOptions withRetry$default(Companion companion, int i, long j5, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                j5 = 500;
            }
            return companion.withRetry(i, j5);
        }

        /* renamed from: default, reason: not valid java name */
        public final GuiOptions m7369default() {
            return new GuiOptions(0L, 0, 0L, null, false, false, null, 0, null, 511, null);
        }

        public final GuiOptions withRetry(int count, long delay) {
            return new GuiOptions(0L, count, delay, null, false, false, null, 0, null, TypedValues.PositionType.TYPE_SIZE_PERCENT, null);
        }

        public final GuiOptions withTimeout(long timeout) {
            return new GuiOptions(timeout, 0, 0L, null, false, false, null, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE, null);
        }

        private Companion() {
        }
    }

    public GuiOptions() {
        this(0L, 0, 0L, null, false, false, null, 0, null, 511, null);
    }

    public static /* synthetic */ GuiOptions copy$default(GuiOptions guiOptions, long j5, int i, long j6, FailurePolicy failurePolicy, boolean z10, boolean z11, Set set, int i6, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j5 = guiOptions.timeout;
        }
        long j10 = j5;
        if ((i10 & 2) != 0) {
            i = guiOptions.retryCount;
        }
        return guiOptions.copy(j10, i, (i10 & 4) != 0 ? guiOptions.retryDelay : j6, (i10 & 8) != 0 ? guiOptions.failurePolicy : failurePolicy, (i10 & 16) != 0 ? guiOptions.waitForIdle : z10, (i10 & 32) != 0 ? guiOptions.captureScreenshot : z11, (i10 & 64) != 0 ? guiOptions.resources : set, (i10 & 128) != 0 ? guiOptions.priority : i6, (i10 & 256) != 0 ? guiOptions.displayId : num);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRetryCount() {
        return this.retryCount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRetryDelay() {
        return this.retryDelay;
    }

    /* renamed from: component4, reason: from getter */
    public final FailurePolicy getFailurePolicy() {
        return this.failurePolicy;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getWaitForIdle() {
        return this.waitForIdle;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCaptureScreenshot() {
        return this.captureScreenshot;
    }

    public final Set<GuiResource> component7() {
        return this.resources;
    }

    /* renamed from: component8, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final GuiOptions copy(long timeout, int retryCount, long retryDelay, FailurePolicy failurePolicy, boolean waitForIdle, boolean captureScreenshot, Set<? extends GuiResource> resources, int priority, Integer displayId) {
        k.f(failurePolicy, "failurePolicy");
        k.f(resources, "resources");
        return new GuiOptions(timeout, retryCount, retryDelay, failurePolicy, waitForIdle, captureScreenshot, resources, priority, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiOptions)) {
            return false;
        }
        GuiOptions guiOptions = (GuiOptions) other;
        return this.timeout == guiOptions.timeout && this.retryCount == guiOptions.retryCount && this.retryDelay == guiOptions.retryDelay && this.failurePolicy == guiOptions.failurePolicy && this.waitForIdle == guiOptions.waitForIdle && this.captureScreenshot == guiOptions.captureScreenshot && k.b(this.resources, guiOptions.resources) && this.priority == guiOptions.priority && k.b(this.displayId, guiOptions.displayId);
    }

    public final boolean getCaptureScreenshot() {
        return this.captureScreenshot;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final FailurePolicy getFailurePolicy() {
        return this.failurePolicy;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final Set<GuiResource> getResources() {
        return this.resources;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final long getRetryDelay() {
        return this.retryDelay;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final boolean getWaitForIdle() {
        return this.waitForIdle;
    }

    public int hashCode() {
        int iA = a.a(this.priority, (this.resources.hashCode() + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d((this.failurePolicy.hashCode() + androidx.appfunctions.metadata.a.c(a.a(this.retryCount, Long.hashCode(this.timeout) * 31, 31), 31, this.retryDelay)) * 31, 31, this.waitForIdle), 31, this.captureScreenshot)) * 31, 31);
        Integer num = this.displayId;
        return iA + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        long j5 = this.timeout;
        int i = this.retryCount;
        long j6 = this.retryDelay;
        FailurePolicy failurePolicy = this.failurePolicy;
        boolean z10 = this.waitForIdle;
        boolean z11 = this.captureScreenshot;
        Set<GuiResource> set = this.resources;
        int i6 = this.priority;
        Integer num = this.displayId;
        StringBuilder sb = new StringBuilder("GuiOptions(timeout=");
        sb.append(j5);
        sb.append(", retryCount=");
        sb.append(i);
        b.y(j6, ", retryDelay=", ", failurePolicy=", sb);
        sb.append(failurePolicy);
        sb.append(", waitForIdle=");
        sb.append(z10);
        sb.append(", captureScreenshot=");
        sb.append(z11);
        sb.append(", resources=");
        sb.append(set);
        sb.append(", priority=");
        sb.append(i6);
        sb.append(", displayId=");
        sb.append(num);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuiOptions(long j5, int i, long j6, FailurePolicy failurePolicy, boolean z10, boolean z11, Set<? extends GuiResource> resources, int i6, Integer num) {
        k.f(failurePolicy, "failurePolicy");
        k.f(resources, "resources");
        this.timeout = j5;
        this.retryCount = i;
        this.retryDelay = j6;
        this.failurePolicy = failurePolicy;
        this.waitForIdle = z10;
        this.captureScreenshot = z11;
        this.resources = resources;
        this.priority = i6;
        this.displayId = num;
    }

    public /* synthetic */ GuiOptions(long j5, int i, long j6, FailurePolicy failurePolicy, boolean z10, boolean z11, Set set, int i6, Integer num, int i10, e eVar) {
        this((i10 & 1) != 0 ? 60000L : j5, (i10 & 2) != 0 ? 0 : i, (i10 & 4) != 0 ? 500L : j6, (i10 & 8) != 0 ? FailurePolicy.FAIL_FAST : failurePolicy, (i10 & 16) != 0 ? true : z10, (i10 & 32) != 0 ? false : z11, (i10 & 64) != 0 ? N.Q(GuiResource.UI) : set, (i10 & 128) != 0 ? 0 : i6, (i10 & 256) != 0 ? null : num);
    }
}
