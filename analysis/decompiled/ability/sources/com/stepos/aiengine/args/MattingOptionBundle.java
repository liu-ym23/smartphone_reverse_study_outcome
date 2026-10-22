package com.stepos.aiengine.args;

import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000fJ\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/args/MattingOptionBundle;", "", "Landroid/os/Bundle;", "bundle", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;)V", "", "angle", "setRotateAngle", "(I)Lcom/stepos/aiengine/args/MattingOptionBundle;", "getRotateAngle", "()I", "", MattingOptionBundle.KEY_RETURN_IMAGE, "setReturnImage", "(Z)Lcom/stepos/aiengine/args/MattingOptionBundle;", "isReturnImage", "()Z", "unlimited", "setUnlimitedProportion", "isUnlimitedProportion", "toBundle", "()Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MattingOptionBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_RETURN_IMAGE = "returnImage";
    public static final String KEY_ROTATE_ANGLE = "rotateAngle";
    public static final String KEY_UNLIMITED_PROPORTION = "unlimitedProportion";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3489a;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/args/MattingOptionBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/args/MattingOptionBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/MattingOptionBundle;", "", "KEY_ROTATE_ANGLE", "Ljava/lang/String;", "KEY_RETURN_IMAGE", "KEY_UNLIMITED_PROPORTION", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final MattingOptionBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new MattingOptionBundle(bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MattingOptionBundle() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final int getRotateAngle() {
        return this.f3489a.getInt(KEY_ROTATE_ANGLE, 0);
    }

    public final boolean isReturnImage() {
        return this.f3489a.getBoolean(KEY_RETURN_IMAGE, true);
    }

    public final boolean isUnlimitedProportion() {
        return this.f3489a.getBoolean(KEY_UNLIMITED_PROPORTION, false);
    }

    public final MattingOptionBundle setReturnImage(boolean returnImage) {
        this.f3489a.putBoolean(KEY_RETURN_IMAGE, returnImage);
        return this;
    }

    public final MattingOptionBundle setRotateAngle(int angle) {
        this.f3489a.putInt(KEY_ROTATE_ANGLE, angle);
        return this;
    }

    public final MattingOptionBundle setUnlimitedProportion(boolean unlimited) {
        this.f3489a.putBoolean(KEY_UNLIMITED_PROPORTION, unlimited);
        return this;
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3489a);
    }

    public MattingOptionBundle(Bundle bundle) {
        k.f(bundle, "bundle");
        this.f3489a = bundle;
    }

    public /* synthetic */ MattingOptionBundle(Bundle bundle, int i, e eVar) {
        this((i & 1) != 0 ? new Bundle() : bundle);
    }
}
