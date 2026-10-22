package com.stepos.aiengine.args;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "toBundle", "()Landroid/os/Bundle;", "", "getPointsX", "()[I", "getPointsY", "getPointsLabel", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InteractiveSegmentPointsBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_POINTS_LABEL = "points_label";
    public static final String KEY_POINTS_X = "points_x";
    public static final String KEY_POINTS_Y = "points_y";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle$Companion;", "", "<init>", "()V", "KEY_POINTS_X", "", "KEY_POINTS_Y", "KEY_POINTS_LABEL", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/stepos/aiengine/args/InteractiveSegmentPointsBundle;", "xs", "", "ys", "labels", "foregroundOnly", "fromBundle", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final InteractiveSegmentPointsBundle build(int[] xs, int[] ys, int[] labels) {
            p.i(xs, "xs");
            p.i(ys, "ys");
            p.i(labels, "labels");
            Bundle bundle = new Bundle();
            bundle.putIntArray("points_x", xs);
            bundle.putIntArray("points_y", ys);
            bundle.putIntArray("points_label", labels);
            return new InteractiveSegmentPointsBundle(bundle, null);
        }

        public final InteractiveSegmentPointsBundle foregroundOnly(int[] xs, int[] ys) {
            p.i(xs, "xs");
            p.i(ys, "ys");
            int length = xs.length;
            int[] iArr = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = 1;
            }
            return build(xs, ys, iArr);
        }

        public final InteractiveSegmentPointsBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new InteractiveSegmentPointsBundle(bundle, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ InteractiveSegmentPointsBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final int[] getPointsLabel() {
        int[] intArray = this.bundle.getIntArray("points_label");
        return intArray == null ? new int[0] : intArray;
    }

    public final int[] getPointsX() {
        int[] intArray = this.bundle.getIntArray("points_x");
        return intArray == null ? new int[0] : intArray;
    }

    public final int[] getPointsY() {
        int[] intArray = this.bundle.getIntArray("points_y");
        return intArray == null ? new int[0] : intArray;
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public InteractiveSegmentPointsBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
