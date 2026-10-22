package com.android.ttcjpaysdk.base.framework.container.lifecycle;

import androidx.core.app.NotificationCompat;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.media.MediaScene;
import com.ss.android.lark.camera_export.CameraParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/lifecycle/IStdUiLifecycle;", "", "dispatchBackPressed", "", "backType", "Lcom/android/ttcjpaysdk/base/framework/container/lifecycle/IStdUiLifecycle$BackType;", "onBackPressed", "onHide", "", "onInterceptBackPressed", SendEventContainerMethodParamModel.EventKinds.onShow, "BackType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IStdUiLifecycle {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/lifecycle/IStdUiLifecycle$BackType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "<set-?>", "getType", "()Ljava/lang/String;", "setBackType", "", MediaScene.SYSTEM, MediaScene.NAVIGATION, "CUSTOM", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BackType extends Enum<BackType> {
        private static final /* synthetic */ BackType[] $VALUES = null;
        public static final BackType CUSTOM = null;
        public static final BackType NAVIGATION = null;
        public static final BackType SYSTEM = null;
        private String type;

        private static final /* synthetic */ BackType[] $values() {
            return new BackType[]{SYSTEM, NAVIGATION, CUSTOM};
        }

        public static BackType valueOf(String r100) {
            return (BackType) a.a(BackType.class, r100);
        }

        public static BackType[] values() {
            return (BackType[]) $VALUES.clone();
        }

        static {
            SYSTEM = new BackType(MediaScene.SYSTEM, 0, CameraParam.TYPE_SYSTEM_CAMERA);
            NAVIGATION = new BackType(MediaScene.NAVIGATION, 1, NotificationCompat.CATEGORY_NAVIGATION);
            CUSTOM = new BackType("CUSTOM", 2, "custom");
            $VALUES = $values();
        }

        public final String getType() {
            return this.type;
        }

        public final void setBackType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            if (this != CUSTOM) goto L6;
            this.type = r100;
            return;
        }

        private BackType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean dispatchBackPressed(IStdUiLifecycle r100, BackType r101) {
            Intrinsics.checkNotNullParameter(r101, "backType");
            return false;
        }

        public static boolean onBackPressed(IStdUiLifecycle r100, BackType r101) {
            Intrinsics.checkNotNullParameter(r101, "backType");
            return false;
        }

        public static void onHide(IStdUiLifecycle r100) {
        }

        public static boolean onInterceptBackPressed(IStdUiLifecycle r100, BackType r101) {
            Intrinsics.checkNotNullParameter(r101, "backType");
            return false;
        }

        public static void onShow(IStdUiLifecycle r100) {
        }
    }

    boolean dispatchBackPressed(BackType r100);

    boolean onBackPressed(BackType r100);

    void onHide();

    boolean onInterceptBackPressed(BackType r100);

    void onShow();
}
