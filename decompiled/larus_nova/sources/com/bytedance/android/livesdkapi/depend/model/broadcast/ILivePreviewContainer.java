package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH&J\b\u0010\r\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\tH&J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewContainer;", "", "createStartLiveFragment", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IStartLiveFragment;", "force", "", "getFragment", "Landroidx/fragment/app/Fragment;", "handleUserVerifyResult", "", "paramsMap", "Ljava/util/HashMap;", "", "onHideFragment", "onShowBlessingSticker", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "type", "", "onShowFragment", "registerExtraCameraListener", "listener", "registerLivePreviewContainerListener", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewContainerBaseListener;", "setBundle", "bundle", "Landroid/os/Bundle;", "setCameraType", "camera", "Companion", "LiveCameraType", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewContainer {
    public static final Companion Companion = null;
    public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_HEIGHT = "camera_height";
    public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_TYPE = "camera_type";
    public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_WIDTH = "camera_width";
    public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_ENABLE_CAMERA2_FEATURE = "enable_camera2_feature";
    public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_INJECT_SURFACE = "inject_surface";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewContainer$Companion;", "", "()V", "LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_HEIGHT", "", "LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_TYPE", "LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_WIDTH", "LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_ENABLE_CAMERA2_FEATURE", "LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_INJECT_SURFACE", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_HEIGHT = "camera_height";
        public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_TYPE = "camera_type";
        public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_CAMERA_WIDTH = "camera_width";
        public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_ENABLE_CAMERA2_FEATURE = "enable_camera2_feature";
        public static final String LIVE_PREVIEW_CONTAINER_BUNDLE_KEY_INJECT_SURFACE = "inject_surface";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static IStartLiveFragment createStartLiveFragment(ILivePreviewContainer r100, boolean r101) {
            return null;
        }

        public static void registerExtraCameraListener(ILivePreviewContainer r100, Object r101) {
        }

        public static void registerLivePreviewContainerListener(ILivePreviewContainer r100, ILivePreviewContainerBaseListener r101) {
        }

        public static void setCameraType(ILivePreviewContainer r100, int r101) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewContainer$LiveCameraType;", "", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LiveCameraType {
        public static final Companion Companion = null;
        public static final int LIVE_CAMERA_TYPE_LIVE_CORE_PREVIEW = 3;
        public static final int LIVE_CAMERA_TYPE_LIVE_CORE_RENDER = 2;
        public static final int LIVE_CAMERA_TYPE_OLD_LIVE_CORE_RENDER = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewContainer$LiveCameraType$Companion;", "", "()V", "LIVE_CAMERA_TYPE_LIVE_CORE_PREVIEW", "", "LIVE_CAMERA_TYPE_LIVE_CORE_RENDER", "LIVE_CAMERA_TYPE_OLD_LIVE_CORE_RENDER", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int LIVE_CAMERA_TYPE_LIVE_CORE_PREVIEW = 3;
            public static final int LIVE_CAMERA_TYPE_LIVE_CORE_RENDER = 2;
            public static final int LIVE_CAMERA_TYPE_OLD_LIVE_CORE_RENDER = 1;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    IStartLiveFragment createStartLiveFragment(boolean r100);

    Fragment getFragment();

    void handleUserVerifyResult(HashMap<String, String> r100);

    void onHideFragment();

    void onShowBlessingSticker(Sticker r100, int r101);

    void onShowFragment();

    void registerExtraCameraListener(Object r100);

    void registerLivePreviewContainerListener(ILivePreviewContainerBaseListener r100);

    void setBundle(Bundle r100);

    void setCameraType(int r100);
}
