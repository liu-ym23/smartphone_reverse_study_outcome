package com.stepos.aiengine.args;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.core.data.ContentParams;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/args/ExecutionBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "toBundle", "()Landroid/os/Bundle;", "target", "LY8/t;", "mergeInto", "Lcom/stepos/core/data/ContentParams$Builder;", "builder", "applyTo", "(Lcom/stepos/core/data/ContentParams$Builder;)Lcom/stepos/core/data/ContentParams$Builder;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExecutionBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_EXECUTION_PREFERENCE = "execution_preference";
    public static final String PREF_AUTO = "auto";
    public static final String PREF_CLOUD = "cloud";
    public static final String PREF_LOCAL = "local";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Lcom/stepos/aiengine/args/ExecutionBundle$Companion;", "", "<init>", "()V", "Lcom/stepos/aiengine/args/ExecutionBundle;", "auto", "()Lcom/stepos/aiengine/args/ExecutionBundle;", "localOnly", "cloudOnly", "", UxipConstants.f30680s, "preference", "(Ljava/lang/String;)Lcom/stepos/aiengine/args/ExecutionBundle;", "executionPreference", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Landroid/os/Bundle;", "bundle", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/ExecutionBundle;", "", "hasExecutionParams", "(Landroid/os/Bundle;)Z", "target", "execution", "LY8/t;", "mergeInto", "(Landroid/os/Bundle;Lcom/stepos/aiengine/args/ExecutionBundle;)V", "KEY_EXECUTION_PREFERENCE", "Ljava/lang/String;", "PREF_AUTO", "PREF_LOCAL", "PREF_CLOUD", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ ExecutionBundle build$default(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "auto";
            }
            return companion.build(str);
        }

        public final ExecutionBundle auto() {
            return new ExecutionBundle(new Bundle(), null);
        }

        public final ExecutionBundle build(String executionPreference) {
            p.i(executionPreference, "executionPreference");
            Bundle bundle = new Bundle();
            if (!p.d(executionPreference, "auto")) {
                bundle.putString(ExecutionBundle.KEY_EXECUTION_PREFERENCE, executionPreference);
            }
            return new ExecutionBundle(bundle, null);
        }

        public final ExecutionBundle cloudOnly() {
            return preference(ExecutionBundle.PREF_CLOUD);
        }

        public final ExecutionBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new ExecutionBundle(new Bundle(bundle), null);
        }

        public final boolean hasExecutionParams(Bundle bundle) {
            p.i(bundle, "bundle");
            return bundle.containsKey(ExecutionBundle.KEY_EXECUTION_PREFERENCE);
        }

        public final ExecutionBundle localOnly() {
            return preference("local");
        }

        public final void mergeInto(Bundle target, ExecutionBundle execution) {
            p.i(target, "target");
            if (execution != null) {
                execution.mergeInto(target);
            }
        }

        public final ExecutionBundle preference(String value) {
            p.i(value, "value");
            Bundle bundle = new Bundle();
            bundle.putString(ExecutionBundle.KEY_EXECUTION_PREFERENCE, value);
            return new ExecutionBundle(bundle, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ ExecutionBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final ContentParams.Builder applyTo(ContentParams.Builder builder) {
        String string;
        p.i(builder, "builder");
        if (this.bundle.containsKey(KEY_EXECUTION_PREFERENCE) && (string = this.bundle.getString(KEY_EXECUTION_PREFERENCE)) != null) {
            builder.putString(KEY_EXECUTION_PREFERENCE, string);
        }
        return builder;
    }

    public final void mergeInto(Bundle target) {
        p.i(target, "target");
        target.putAll(this.bundle);
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public ExecutionBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
