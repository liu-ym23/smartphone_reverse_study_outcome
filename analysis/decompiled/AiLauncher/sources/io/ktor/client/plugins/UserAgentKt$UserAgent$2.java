package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.internal.AdaptedFunctionReference;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class UserAgentKt$UserAgent$2 extends AdaptedFunctionReference implements InterfaceC5063a<UserAgentConfig> {
    public static final UserAgentKt$UserAgent$2 INSTANCE = new UserAgentKt$UserAgent$2();

    public UserAgentKt$UserAgent$2() {
        super(0, UserAgentConfig.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p9.InterfaceC5063a
    public final UserAgentConfig invoke() {
        return new UserAgentConfig(null, 1, null);
    }
}
