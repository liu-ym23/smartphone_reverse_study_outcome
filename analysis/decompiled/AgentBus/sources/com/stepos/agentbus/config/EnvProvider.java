package com.stepos.agentbus.config;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentbus/config/EnvProvider;", "", "isTestEnv", "", "currentEnv", "", "Companion", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface EnvProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String ENV_PROD = "prod";
    public static final String ENV_TEST = "test";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentbus/config/EnvProvider$Companion;", "", "<init>", "()V", "ENV_PROD", "", "ENV_TEST", "PROD", "Lcom/stepos/agentbus/config/EnvProvider;", "getPROD", "()Lcom/stepos/agentbus/config/EnvProvider;", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public static final String ENV_PROD = "prod";
        public static final String ENV_TEST = "test";
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final EnvProvider PROD = new EnvProvider() { // from class: com.stepos.agentbus.config.EnvProvider$Companion$PROD$1
            @Override // com.stepos.agentbus.config.EnvProvider
            public String currentEnv() {
                return "prod";
            }

            @Override // com.stepos.agentbus.config.EnvProvider
            public boolean isTestEnv() {
                return false;
            }
        };

        private Companion() {
        }

        public final EnvProvider getPROD() {
            return PROD;
        }
    }

    String currentEnv();

    boolean isTestEnv();
}
