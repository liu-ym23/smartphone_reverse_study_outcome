package io.ktor.server.engine;

import io.ktor.server.engine.ShutDownUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class ShutDownUrl$Companion$ApplicationCallPlugin$1 extends FunctionReferenceImpl implements InterfaceC5063a<ShutDownUrl.Config> {
    public static final ShutDownUrl$Companion$ApplicationCallPlugin$1 INSTANCE = new ShutDownUrl$Companion$ApplicationCallPlugin$1();

    public ShutDownUrl$Companion$ApplicationCallPlugin$1() {
        super(0, ShutDownUrl.Config.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p9.InterfaceC5063a
    public final ShutDownUrl.Config invoke() {
        return new ShutDownUrl.Config();
    }
}
