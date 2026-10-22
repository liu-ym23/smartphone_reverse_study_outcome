package com.obric.autogui.common.api.platform.display;

import android.content.Context;
import android.view.MotionEvent;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.d.a;
import d.d.b;
import d.m;
import d.x;
import java.util.Collection;

/* JADX INFO: compiled from: DisplayAccessor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DisplayAccessor {

    /* JADX INFO: compiled from: DisplayAccessor.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Collection getTopDisplayedApps$default(DisplayAccessor r2, int r3, boolean r4, int r5, Object r6) {
            DisplayAccessor r7 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r2, DisplayAccessor.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L8;
            r4 = false;
        L8:
            return r7.getTopDisplayedApps(r3, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTopDisplayedApps");
        }

        public static /* synthetic */ boolean moveTaskTo$default(DisplayAccessor r2, Context r3, int r4, DisplayAccessor r5, boolean r6, int r7, Object r8) {
            DisplayAccessor r9 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r2, DisplayAccessor.class, "com.obric.aiagent.plugin");
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            DisplayAccessor r11 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r5, DisplayAccessor.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 8) == 0) goto L8;
            r6 = false;
        L8:
            return r9.moveTaskTo(r10, r4, r11, r6);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveTaskTo");
        }
    }

    /* JADX INFO: compiled from: DisplayAccessor.kt */
    public static final enum Rotation extends Enum<Rotation> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Rotation[] $VALUES = null;
        public static final Rotation Rotation0 = null;
        public static final Rotation Rotation180 = null;
        public static final Rotation Rotation270 = null;
        public static final Rotation Rotation90 = null;
        private final float degree;
        private final int enumValue;

        private static final /* synthetic */ Rotation[] $values() {
            return new Rotation[]{Rotation0, Rotation90, Rotation180, Rotation270};
        }

        public static a<Rotation> getEntries() {
            return $ENTRIES;
        }

        private Rotation(String r1, int r2, float r3, int r4) {
            super(r1, r2);
            this.degree = r3;
            this.enumValue = r4;
        }

        public final float getDegree() {
            return this.degree;
        }

        public final int getEnumValue() {
            return this.enumValue;
        }

        static {
            Rotation0 = new Rotation("Rotation0", 0, 0.0f, 0);
            Rotation90 = new Rotation("Rotation90", 1, 90.0f, 1);
            Rotation180 = new Rotation("Rotation180", 2, 180.0f, 2);
            Rotation270 = new Rotation("Rotation270", 3, 270.0f, 3);
            Rotation[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static Rotation valueOf(String r2) {
            return (Rotation) ZeusTransformUtils.preCheckCast(Enum.valueOf(Rotation.class, r2), Rotation.class, "com.obric.aiagent.plugin");
        }

        public static Rotation[] values() {
            return (Rotation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Rotation[].class, "com.obric.aiagent.plugin");
        }
    }

    Object captureDisplay(Context r1, ScreenshotConfig r2, d<? super ScreenshotResult> r3);

    Object destroy(d<? super x> r1);

    m<Integer, Integer> getDecoratedDimensions();

    int getDisplayId();

    Rotation getRotation();

    m<Integer, Integer> getSpawnedDimensions();

    DisplayedAppInfo getTopDisplayedApp();

    Collection<DisplayedAppInfo> getTopDisplayedApps(int r1, boolean r2);

    boolean injectIntoDisplay(MotionEvent r1);

    boolean isDestroyed();

    boolean isPackageVisible(String r1);

    boolean moveTaskTo(Context r1, int r2, DisplayAccessor r3, boolean r4);

    void registerStatusListener(DisplayStatusListener r1);
}
