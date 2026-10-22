package com.stepos.aiengine.args;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000fJ\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/aiengine/args/MattingOptionBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "", "angle", "setRotateAngle", "(I)Lcom/stepos/aiengine/args/MattingOptionBundle;", "getRotateAngle", "()I", "", MattingOptionBundle.KEY_RETURN_IMAGE, "setReturnImage", "(Z)Lcom/stepos/aiengine/args/MattingOptionBundle;", "isReturnImage", "()Z", "unlimited", "setUnlimitedProportion", "isUnlimitedProportion", "toBundle", "()Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MattingOptionBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_RETURN_IMAGE = "returnImage";
    public static final String KEY_ROTATE_ANGLE = "rotateAngle";
    public static final String KEY_UNLIMITED_PROPORTION = "unlimitedProportion";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/args/MattingOptionBundle$Companion;", "", "<init>", "()V", "KEY_ROTATE_ANGLE", "", "KEY_RETURN_IMAGE", "KEY_UNLIMITED_PROPORTION", "fromBundle", "Lcom/stepos/aiengine/args/MattingOptionBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final MattingOptionBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new MattingOptionBundle(bundle);
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MattingOptionBundle() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final int getRotateAngle() {
        return this.bundle.getInt(KEY_ROTATE_ANGLE, 0);
    }

    public final boolean isReturnImage() {
        return this.bundle.getBoolean(KEY_RETURN_IMAGE, true);
    }

    public final boolean isUnlimitedProportion() {
        return this.bundle.getBoolean(KEY_UNLIMITED_PROPORTION, false);
    }

    public final MattingOptionBundle setReturnImage(boolean returnImage) {
        this.bundle.putBoolean(KEY_RETURN_IMAGE, returnImage);
        return this;
    }

    public final MattingOptionBundle setRotateAngle(int angle) {
        this.bundle.putInt(KEY_ROTATE_ANGLE, angle);
        return this;
    }

    public final MattingOptionBundle setUnlimitedProportion(boolean unlimited) {
        this.bundle.putBoolean(KEY_UNLIMITED_PROPORTION, unlimited);
        return this;
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public MattingOptionBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        this.bundle = bundle;
    }

    public /* synthetic */ MattingOptionBundle(Bundle bundle, int i10, i iVar) {
        this((i10 & 1) != 0 ? new Bundle() : bundle);
    }
}
