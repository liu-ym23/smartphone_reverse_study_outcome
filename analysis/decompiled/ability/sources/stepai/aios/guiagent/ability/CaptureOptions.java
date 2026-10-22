package stepai.aios.guiagent.ability;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lstepai/aios/guiagent/ability/CaptureOptions;", "", "scenario", "Lstepai/aios/guiagent/ability/CaptureScenario;", "uploadImage", "", "includeTraceKey", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/ability/CaptureScenario;ZZ)V", "getScenario", "()Lstepai/aios/guiagent/ability/CaptureScenario;", "getUploadImage", "()Z", "getIncludeTraceKey", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CaptureOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean includeTraceKey;
    private final CaptureScenario scenario;
    private final boolean uploadImage;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lstepai/aios/guiagent/ability/CaptureOptions$Companion;", "", AppAgent.CONSTRUCT, "()V", "forMainLoop", "Lstepai/aios/guiagent/ability/CaptureOptions;", "uploadImage", "", "forTakeover", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ CaptureOptions forMainLoop$default(Companion companion, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = true;
            }
            return companion.forMainLoop(z10);
        }

        public static /* synthetic */ CaptureOptions forTakeover$default(Companion companion, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = false;
            }
            return companion.forTakeover(z10);
        }

        public final CaptureOptions forMainLoop(boolean uploadImage) {
            return new CaptureOptions(CaptureScenario.MAIN_LOOP, uploadImage, false, 4, null);
        }

        public final CaptureOptions forTakeover(boolean uploadImage) {
            return new CaptureOptions(CaptureScenario.TAKEOVER, uploadImage, false, 4, null);
        }

        private Companion() {
        }
    }

    public CaptureOptions(CaptureScenario scenario, boolean z10, boolean z11) {
        k.f(scenario, "scenario");
        this.scenario = scenario;
        this.uploadImage = z10;
        this.includeTraceKey = z11;
    }

    public static /* synthetic */ CaptureOptions copy$default(CaptureOptions captureOptions, CaptureScenario captureScenario, boolean z10, boolean z11, int i, Object obj) {
        if ((i & 1) != 0) {
            captureScenario = captureOptions.scenario;
        }
        if ((i & 2) != 0) {
            z10 = captureOptions.uploadImage;
        }
        if ((i & 4) != 0) {
            z11 = captureOptions.includeTraceKey;
        }
        return captureOptions.copy(captureScenario, z10, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final CaptureScenario getScenario() {
        return this.scenario;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getUploadImage() {
        return this.uploadImage;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIncludeTraceKey() {
        return this.includeTraceKey;
    }

    public final CaptureOptions copy(CaptureScenario scenario, boolean uploadImage, boolean includeTraceKey) {
        k.f(scenario, "scenario");
        return new CaptureOptions(scenario, uploadImage, includeTraceKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureOptions)) {
            return false;
        }
        CaptureOptions captureOptions = (CaptureOptions) other;
        return this.scenario == captureOptions.scenario && this.uploadImage == captureOptions.uploadImage && this.includeTraceKey == captureOptions.includeTraceKey;
    }

    public final boolean getIncludeTraceKey() {
        return this.includeTraceKey;
    }

    public final CaptureScenario getScenario() {
        return this.scenario;
    }

    public final boolean getUploadImage() {
        return this.uploadImage;
    }

    public int hashCode() {
        return Boolean.hashCode(this.includeTraceKey) + a.d(this.scenario.hashCode() * 31, 31, this.uploadImage);
    }

    public String toString() {
        CaptureScenario captureScenario = this.scenario;
        boolean z10 = this.uploadImage;
        boolean z11 = this.includeTraceKey;
        StringBuilder sb = new StringBuilder("CaptureOptions(scenario=");
        sb.append(captureScenario);
        sb.append(", uploadImage=");
        sb.append(z10);
        sb.append(", includeTraceKey=");
        return B7.a.s(sb, z11, ")");
    }

    public /* synthetic */ CaptureOptions(CaptureScenario captureScenario, boolean z10, boolean z11, int i, e eVar) {
        this(captureScenario, (i & 2) != 0 ? captureScenario == CaptureScenario.MAIN_LOOP : z10, (i & 4) != 0 ? true : z11);
    }
}
