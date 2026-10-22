package com.stepos.aiengine.args;

import D7.q;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\b\"\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/aiengine/args/QueryAlgorithmBundle;", "", AppAgent.CONSTRUCT, "()V", "", QueryAlgorithmBundle.KEY_CATEGORY, "setCategory", "(Ljava/lang/String;)Lcom/stepos/aiengine/args/QueryAlgorithmBundle;", "", "algorithmIds", "setAbilities", "([Ljava/lang/String;)Lcom/stepos/aiengine/args/QueryAlgorithmBundle;", "", "supportedOnly", "setSupportedOnly", "(Z)Lcom/stepos/aiengine/args/QueryAlgorithmBundle;", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class QueryAlgorithmBundle {
    public static final String KEY_ABILITIES = "abilities";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_SUPPORTED_ONLY = "supported_only";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3494a = new Bundle();

    public final Bundle getBundle() {
        return new Bundle(this.f3494a);
    }

    public final QueryAlgorithmBundle setAbilities(String... algorithmIds) {
        k.f(algorithmIds, "algorithmIds");
        this.f3494a.putStringArrayList("abilities", new ArrayList<>(q.I0(algorithmIds)));
        return this;
    }

    public final QueryAlgorithmBundle setCategory(String category) {
        k.f(category, "category");
        this.f3494a.putString(KEY_CATEGORY, category);
        return this;
    }

    public final QueryAlgorithmBundle setSupportedOnly(boolean supportedOnly) {
        this.f3494a.putBoolean(KEY_SUPPORTED_ONLY, supportedOnly);
        return this;
    }
}
