package com.stepos.aiengine.args;

import android.os.Bundle;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle;", "", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "", "getPointsX", "()[I", "getPointsY", "getPointsLabel", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InteractiveSegmentPointsBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_POINTS_LABEL = "points_label";
    public static final String KEY_POINTS_X = "points_x";
    public static final String KEY_POINTS_Y = "points_y";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3487a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle$Companion;", "", "", "xs", "ys", "labels", "Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "([I[I[I)Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle;", "foregroundOnly", "([I[I)Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle;", "Landroid/os/Bundle;", "bundle", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle;", "", "KEY_POINTS_X", "Ljava/lang/String;", "KEY_POINTS_Y", "KEY_POINTS_LABEL", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final InteractiveSegmentPointsBundle build(int[] xs, int[] ys, int[] labels) {
            k.f(xs, "xs");
            k.f(ys, "ys");
            k.f(labels, "labels");
            Bundle bundle = new Bundle();
            bundle.putIntArray(InteractiveSegmentPointsBundle.KEY_POINTS_X, xs);
            bundle.putIntArray(InteractiveSegmentPointsBundle.KEY_POINTS_Y, ys);
            bundle.putIntArray(InteractiveSegmentPointsBundle.KEY_POINTS_LABEL, labels);
            return new InteractiveSegmentPointsBundle(bundle, null);
        }

        public final InteractiveSegmentPointsBundle foregroundOnly(int[] xs, int[] ys) {
            k.f(xs, "xs");
            k.f(ys, "ys");
            int length = xs.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = 1;
            }
            return build(xs, ys, iArr);
        }

        public final InteractiveSegmentPointsBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new InteractiveSegmentPointsBundle(bundle, null);
        }
    }

    public InteractiveSegmentPointsBundle(Bundle bundle, e eVar) {
        this.f3487a = bundle;
    }

    public final int[] getPointsLabel() {
        int[] intArray = this.f3487a.getIntArray(KEY_POINTS_LABEL);
        return intArray == null ? new int[0] : intArray;
    }

    public final int[] getPointsX() {
        int[] intArray = this.f3487a.getIntArray(KEY_POINTS_X);
        return intArray == null ? new int[0] : intArray;
    }

    public final int[] getPointsY() {
        int[] intArray = this.f3487a.getIntArray(KEY_POINTS_Y);
        return intArray == null ? new int[0] : intArray;
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3487a);
    }
}
