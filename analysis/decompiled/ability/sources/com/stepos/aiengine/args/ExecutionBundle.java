package com.stepos.aiengine.args;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import d5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/aiengine/args/ExecutionBundle;", "", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", TypedValues.AttributesType.S_TARGET, "LC7/r;", "mergeInto", "(Landroid/os/Bundle;)V", "Ld5/b;", "builder", "applyTo", "(Ld5/b;)Ld5/b;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExecutionBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_EXECUTION_PREFERENCE = "execution_preference";
    public static final String PREF_AUTO = "auto";
    public static final String PREF_CLOUD = "cloud";
    public static final String PREF_LOCAL = "local";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3486a;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/stepos/aiengine/args/ExecutionBundle$Companion;", "", "Lcom/stepos/aiengine/args/ExecutionBundle;", "auto", "()Lcom/stepos/aiengine/args/ExecutionBundle;", "localOnly", "cloudOnly", "", "value", "preference", "(Ljava/lang/String;)Lcom/stepos/aiengine/args/ExecutionBundle;", "executionPreference", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Landroid/os/Bundle;", "bundle", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/ExecutionBundle;", "", "hasExecutionParams", "(Landroid/os/Bundle;)Z", TypedValues.AttributesType.S_TARGET, "execution", "LC7/r;", "mergeInto", "(Landroid/os/Bundle;Lcom/stepos/aiengine/args/ExecutionBundle;)V", "KEY_EXECUTION_PREFERENCE", "Ljava/lang/String;", "PREF_AUTO", "PREF_LOCAL", "PREF_CLOUD", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public static /* synthetic */ ExecutionBundle build$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "auto";
            }
            return companion.build(str);
        }

        public final ExecutionBundle auto() {
            return new ExecutionBundle(new Bundle(), null);
        }

        public final ExecutionBundle build(String executionPreference) {
            k.f(executionPreference, "executionPreference");
            Bundle bundle = new Bundle();
            if (!executionPreference.equals("auto")) {
                bundle.putString(ExecutionBundle.KEY_EXECUTION_PREFERENCE, executionPreference);
            }
            return new ExecutionBundle(bundle, null);
        }

        public final ExecutionBundle cloudOnly() {
            return preference(ExecutionBundle.PREF_CLOUD);
        }

        public final ExecutionBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new ExecutionBundle(new Bundle(bundle), null);
        }

        public final boolean hasExecutionParams(Bundle bundle) {
            k.f(bundle, "bundle");
            return bundle.containsKey(ExecutionBundle.KEY_EXECUTION_PREFERENCE);
        }

        public final ExecutionBundle localOnly() {
            return preference(ExecutionBundle.PREF_LOCAL);
        }

        public final void mergeInto(Bundle target, ExecutionBundle execution) {
            k.f(target, "target");
            if (execution != null) {
                execution.mergeInto(target);
            }
        }

        public final ExecutionBundle preference(String value) {
            k.f(value, "value");
            Bundle bundle = new Bundle();
            bundle.putString(ExecutionBundle.KEY_EXECUTION_PREFERENCE, value);
            return new ExecutionBundle(bundle, null);
        }
    }

    public ExecutionBundle(Bundle bundle, e eVar) {
        this.f3486a = bundle;
    }

    public final b applyTo(b builder) {
        String string;
        k.f(builder, "builder");
        Bundle bundle = this.f3486a;
        if (bundle.containsKey(KEY_EXECUTION_PREFERENCE) && (string = bundle.getString(KEY_EXECUTION_PREFERENCE)) != null) {
            builder.e(KEY_EXECUTION_PREFERENCE, string);
        }
        return builder;
    }

    public final void mergeInto(Bundle target) {
        k.f(target, "target");
        target.putAll(this.f3486a);
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3486a);
    }
}
