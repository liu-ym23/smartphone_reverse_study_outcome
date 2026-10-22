package s7;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.BackendHint;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ls7/b;", "", "<init>", "()V", "Ls7/e;", "definition", "Ls7/j;", "config", "Landroid/content/Context;", "context", "Lcom/stepos/motionkit/BackendHint;", Const.INTENT_KEY_APIKEY, "(Ls7/e;Ls7/j;Landroid/content/Context;)Lcom/stepos/motionkit/BackendHint;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f40073a = new b();

    public final BackendHint a(EffectDefinition definition, j config, Context context) {
        kotlin.jvm.internal.p.i(definition, "definition");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(context, "context");
        BackendHint backend = config.getBackend();
        BackendHint backendHint = BackendHint.AUTO;
        return backend != backendHint ? config.getBackend() : definition.getBackendHint() != backendHint ? definition.getBackendHint() : BackendHint.RUNTIME_SHADER;
    }
}
