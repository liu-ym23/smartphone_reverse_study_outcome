package com.stepos.aiengine.args.result;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceEmbedResultBundle;", "", "", "getFeatureCount", "()I", "index", "", "getVector", "(I)[F", "getDim", "(I)I", "", "getToken", "(I)Ljava/lang/String;", "", "hasQuality", "(I)Z", "", "getQuality", "(I)F", "hasException", "()Z", "getException", "()Ljava/lang/String;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FaceEmbedResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3499a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceEmbedResultBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/args/result/FaceEmbedResultBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/result/FaceEmbedResultBundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final FaceEmbedResultBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new FaceEmbedResultBundle(bundle, null);
        }
    }

    public FaceEmbedResultBundle(Bundle bundle, e eVar) {
        this.f3499a = bundle;
    }

    public final int getDim(int index) {
        return this.f3499a.getInt("feature_" + index + "_dim", 0);
    }

    public final String getException() {
        return this.f3499a.getString("exception");
    }

    public final int getFeatureCount() {
        return this.f3499a.getInt("feature_count", 0);
    }

    public final float getQuality(int index) {
        return this.f3499a.getFloat("feature_" + index + "_quality", -1.0f);
    }

    public final String getToken(int index) {
        String string = this.f3499a.getString("feature_" + index + "_token", "");
        k.e(string, "getString(...)");
        return string;
    }

    public final float[] getVector(int index) {
        return this.f3499a.getFloatArray("feature_" + index + "_vector");
    }

    public final boolean hasException() {
        return this.f3499a.containsKey("exception");
    }

    public final boolean hasQuality(int index) {
        return this.f3499a.containsKey("feature_" + index + "_quality");
    }
}
