package com.stepos.aiengine.args.result;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceQualityResultBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "", "getScore", "()F", "", "hasException", "()Z", "", "getException", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceQualityResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_QUALITY_SCORE = "quality_score";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceQualityResultBundle$Companion;", "", "<init>", "()V", "KEY_QUALITY_SCORE", "", "fromBundle", "Lcom/stepos/aiengine/args/result/FaceQualityResultBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final FaceQualityResultBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new FaceQualityResultBundle(bundle, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ FaceQualityResultBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final String getException() {
        return this.bundle.getString("exception");
    }

    public final float getScore() {
        return this.bundle.getFloat(KEY_QUALITY_SCORE, -1.0f);
    }

    public final boolean hasException() {
        return this.bundle.containsKey("exception");
    }

    public FaceQualityResultBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
