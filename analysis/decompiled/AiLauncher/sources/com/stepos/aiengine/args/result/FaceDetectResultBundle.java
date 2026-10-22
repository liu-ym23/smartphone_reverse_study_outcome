package com.stepos.aiengine.args.result;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001&B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0011J\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0011J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0011J\u0015\u0010\u001b\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u000bJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceDetectResultBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "", "getFaceCount", "()I", "index", "getX", "(I)I", "getY", "getWidth", "getHeight", "", "getScore", "(I)F", "", "getToken", "(I)Ljava/lang/String;", "", "hasYaw", "(I)Z", "getYaw", "getPitch", "getRoll", "hasLandmarks", "getLandmarkCount", "", "getLandmarks", "(I)[F", "hasException", "()Z", "getException", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceDetectResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceDetectResultBundle$Companion;", "", "<init>", "()V", "fromBundle", "Lcom/stepos/aiengine/args/result/FaceDetectResultBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final FaceDetectResultBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new FaceDetectResultBundle(bundle, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ FaceDetectResultBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final String getException() {
        return this.bundle.getString("exception");
    }

    public final int getFaceCount() {
        return this.bundle.getInt("face_count", 0);
    }

    public final int getHeight(int index) {
        return this.bundle.getInt("face_" + index + "_height", 0);
    }

    public final int getLandmarkCount(int index) {
        return this.bundle.getInt("face_" + index + "_landmark_count", 0);
    }

    public final float[] getLandmarks(int index) {
        return this.bundle.getFloatArray("face_" + index + "_landmarks");
    }

    public final float getPitch(int index) {
        return this.bundle.getFloat("face_" + index + "_pitch", 0.0f);
    }

    public final float getRoll(int index) {
        return this.bundle.getFloat("face_" + index + "_roll", 0.0f);
    }

    public final float getScore(int index) {
        return this.bundle.getFloat("face_" + index + "_score", 0.0f);
    }

    public final String getToken(int index) {
        String string = this.bundle.getString("face_" + index + "_token", "");
        p.h(string, "getString(...)");
        return string;
    }

    public final int getWidth(int index) {
        return this.bundle.getInt("face_" + index + "_width", 0);
    }

    public final int getX(int index) {
        return this.bundle.getInt("face_" + index + "_x", 0);
    }

    public final int getY(int index) {
        return this.bundle.getInt("face_" + index + "_y", 0);
    }

    public final float getYaw(int index) {
        return this.bundle.getFloat("face_" + index + "_yaw", 0.0f);
    }

    public final boolean hasException() {
        return this.bundle.containsKey("exception");
    }

    public final boolean hasLandmarks(int index) {
        return this.bundle.containsKey("face_" + index + "_landmarks");
    }

    public final boolean hasYaw(int index) {
        return this.bundle.containsKey("face_" + index + "_yaw");
    }

    public FaceDetectResultBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
