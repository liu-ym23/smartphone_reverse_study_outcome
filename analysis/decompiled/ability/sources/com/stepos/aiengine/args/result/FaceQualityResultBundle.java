package com.stepos.aiengine.args.result;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceQualityResultBundle;", "", "", "getScore", "()F", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FaceQualityResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_QUALITY_SCORE = "quality_score";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3500a;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceQualityResultBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/args/result/FaceQualityResultBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/result/FaceQualityResultBundle;", "", "KEY_QUALITY_SCORE", "Ljava/lang/String;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final FaceQualityResultBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new FaceQualityResultBundle(bundle, null);
        }
    }

    public FaceQualityResultBundle(Bundle bundle, e eVar) {
        this.f3500a = bundle;
    }

    public final String getException() {
        return this.f3500a.getString("exception");
    }

    public final float getScore() {
        return this.f3500a.getFloat(KEY_QUALITY_SCORE, -1.0f);
    }

    public final boolean hasException() {
        return this.f3500a.containsKey("exception");
    }
}
