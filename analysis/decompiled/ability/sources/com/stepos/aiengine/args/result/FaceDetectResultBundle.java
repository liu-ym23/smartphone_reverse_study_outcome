package com.stepos.aiengine.args.result;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0007J\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\rJ\u0015\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u0015\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0007J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceDetectResultBundle;", "", "", "getFaceCount", "()I", "index", "getX", "(I)I", "getY", "getWidth", "getHeight", "", "getScore", "(I)F", "", "getToken", "(I)Ljava/lang/String;", "", "hasYaw", "(I)Z", "getYaw", "getPitch", "getRoll", "hasLandmarks", "getLandmarkCount", "", "getLandmarks", "(I)[F", "hasException", "()Z", "getException", "()Ljava/lang/String;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FaceDetectResultBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3498a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/aiengine/args/result/FaceDetectResultBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/args/result/FaceDetectResultBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/result/FaceDetectResultBundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final FaceDetectResultBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new FaceDetectResultBundle(bundle, null);
        }
    }

    public FaceDetectResultBundle(Bundle bundle, e eVar) {
        this.f3498a = bundle;
    }

    public final String getException() {
        return this.f3498a.getString("exception");
    }

    public final int getFaceCount() {
        return this.f3498a.getInt("face_count", 0);
    }

    public final int getHeight(int index) {
        return this.f3498a.getInt("face_" + index + "_height", 0);
    }

    public final int getLandmarkCount(int index) {
        return this.f3498a.getInt("face_" + index + "_landmark_count", 0);
    }

    public final float[] getLandmarks(int index) {
        return this.f3498a.getFloatArray("face_" + index + "_landmarks");
    }

    public final float getPitch(int index) {
        return this.f3498a.getFloat("face_" + index + "_pitch", 0.0f);
    }

    public final float getRoll(int index) {
        return this.f3498a.getFloat("face_" + index + "_roll", 0.0f);
    }

    public final float getScore(int index) {
        return this.f3498a.getFloat("face_" + index + "_score", 0.0f);
    }

    public final String getToken(int index) {
        String string = this.f3498a.getString("face_" + index + "_token", "");
        k.e(string, "getString(...)");
        return string;
    }

    public final int getWidth(int index) {
        return this.f3498a.getInt("face_" + index + "_width", 0);
    }

    public final int getX(int index) {
        return this.f3498a.getInt("face_" + index + "_x", 0);
    }

    public final int getY(int index) {
        return this.f3498a.getInt("face_" + index + "_y", 0);
    }

    public final float getYaw(int index) {
        return this.f3498a.getFloat("face_" + index + "_yaw", 0.0f);
    }

    public final boolean hasException() {
        return this.f3498a.containsKey("exception");
    }

    public final boolean hasLandmarks(int index) {
        return this.f3498a.containsKey("face_" + index + "_landmarks");
    }

    public final boolean hasYaw(int index) {
        return this.f3498a.containsKey("face_" + index + "_yaw");
    }
}
