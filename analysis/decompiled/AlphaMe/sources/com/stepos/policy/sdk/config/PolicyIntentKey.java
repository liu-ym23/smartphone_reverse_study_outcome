package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/stepos/policy/sdk/config/PolicyIntentKey;", "", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes.dex */
public @interface PolicyIntentKey {

    @NotNull
    public static final String BANNER_TITLE = "banner_title";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String HEAD_TITLE = "head_title";

    @NotNull
    public static final String LIST_HEAD_TITLE = "list_head_title";

    @NotNull
    public static final String PERMISSION_KEY = "permission_key";

    @NotNull
    public static final String PERMISSION_SUMMARY = "permission_summary";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/policy/sdk/config/PolicyIntentKey$Companion;", "", "()V", "BANNER_TITLE", "", "HEAD_TITLE", "LIST_HEAD_TITLE", "PERMISSION_KEY", "PERMISSION_SUMMARY", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String BANNER_TITLE = "banner_title";

        @NotNull
        public static final String HEAD_TITLE = "head_title";

        @NotNull
        public static final String LIST_HEAD_TITLE = "list_head_title";

        @NotNull
        public static final String PERMISSION_KEY = "permission_key";

        @NotNull
        public static final String PERMISSION_SUMMARY = "permission_summary";

        private Companion() {
        }
    }
}
