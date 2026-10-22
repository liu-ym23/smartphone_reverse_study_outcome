package s7;

import android.graphics.RuntimeShader;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.BackendHint;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013¨\u0006\u0014"}, d2 = {"Ls7/c;", "", "", "source", "Lcom/stepos/motionkit/BackendHint;", "backendType", "Landroid/graphics/RuntimeShader;", "runtimeShader", "<init>", "(Ljava/lang/String;Lcom/stepos/motionkit/BackendHint;Landroid/graphics/RuntimeShader;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Lcom/stepos/motionkit/BackendHint;", "getBackendType", "()Lcom/stepos/motionkit/BackendHint;", "c", "Landroid/graphics/RuntimeShader;", "()Landroid/graphics/RuntimeShader;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final BackendHint backendType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final RuntimeShader runtimeShader;

    public c(String source, BackendHint backendType, RuntimeShader runtimeShader) {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(backendType, "backendType");
        this.source = source;
        this.backendType = backendType;
        this.runtimeShader = runtimeShader;
    }

    /* renamed from: a, reason: from getter */
    public final RuntimeShader getRuntimeShader() {
        return this.runtimeShader;
    }

    /* renamed from: b, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public /* synthetic */ c(String str, BackendHint backendHint, RuntimeShader runtimeShader, int i10, kotlin.jvm.internal.i iVar) {
        this(str, backendHint, (i10 & 4) != 0 ? null : runtimeShader);
    }
}
