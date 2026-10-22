package com.stepos.aiengine.args.result;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceEmbedResultBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "", "getFeatureCount", "()I", "index", "", "getVector", "(I)[F", "getDim", "(I)I", "", "getToken", "(I)Ljava/lang/String;", "", "hasQuality", "(I)Z", "", "getQuality", "(I)F", "hasException", "()Z", "getException", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceEmbedResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceEmbedResultBundle$Companion;", "", "<init>", "()V", "fromBundle", "Lcom/stepos/aiengine/args/result/FaceEmbedResultBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final FaceEmbedResultBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new FaceEmbedResultBundle(bundle, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ FaceEmbedResultBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final int getDim(int index) {
        return this.bundle.getInt("feature_" + index + "_dim", 0);
    }

    public final String getException() {
        return this.bundle.getString("exception");
    }

    public final int getFeatureCount() {
        return this.bundle.getInt("feature_count", 0);
    }

    public final float getQuality(int index) {
        return this.bundle.getFloat("feature_" + index + "_quality", -1.0f);
    }

    public final String getToken(int index) {
        String string = this.bundle.getString("feature_" + index + "_token", "");
        p.h(string, "getString(...)");
        return string;
    }

    public final float[] getVector(int index) {
        return this.bundle.getFloatArray("feature_" + index + "_vector");
    }

    public final boolean hasException() {
        return this.bundle.containsKey("exception");
    }

    public final boolean hasQuality(int index) {
        return this.bundle.containsKey("feature_" + index + "_quality");
    }

    public FaceEmbedResultBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
