package com.stepos.aiengine.args;

import Z8.r;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\b\"\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/stepos/aiengine/args/QueryAlgorithmBundle;", "", "<init>", "()V", "", QueryAlgorithmBundle.KEY_CATEGORY, "setCategory", "(Ljava/lang/String;)Lcom/stepos/aiengine/args/QueryAlgorithmBundle;", "", "algorithmIds", "setAbilities", "([Ljava/lang/String;)Lcom/stepos/aiengine/args/QueryAlgorithmBundle;", "", "supportedOnly", "setSupportedOnly", "(Z)Lcom/stepos/aiengine/args/QueryAlgorithmBundle;", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "bundle", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QueryAlgorithmBundle {
    public static final String KEY_ABILITIES = "abilities";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_SUPPORTED_ONLY = "supported_only";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle = new Bundle();

    public final Bundle getBundle() {
        return new Bundle(this.bundle);
    }

    public final QueryAlgorithmBundle setAbilities(String... algorithmIds) {
        p.i(algorithmIds, "algorithmIds");
        this.bundle.putStringArrayList("abilities", new ArrayList<>(r.T0(algorithmIds)));
        return this;
    }

    public final QueryAlgorithmBundle setCategory(String category) {
        p.i(category, "category");
        this.bundle.putString(KEY_CATEGORY, category);
        return this;
    }

    public final QueryAlgorithmBundle setSupportedOnly(boolean supportedOnly) {
        this.bundle.putBoolean(KEY_SUPPORTED_ONLY, supportedOnly);
        return this;
    }
}
