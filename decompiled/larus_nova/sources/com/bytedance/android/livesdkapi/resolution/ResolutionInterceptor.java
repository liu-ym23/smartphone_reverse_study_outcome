package com.bytedance.android.livesdkapi.resolution;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J*\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/resolution/ResolutionInterceptor;", "", "interceptLevel", "", "getInterceptLevel", "()I", "setInterceptLevel", "(I)V", "getResolutionLevelBySdkKey", "streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "resolutionSdkKey", "", "getResolutionQualityByLevel", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "level", "getResolutionSdkKeyByLevel", "intercept", "Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$PickResult;", "roomId", "", "defaultResolutionKey", "resolutionScene", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ResolutionInterceptor {
    public static final Companion Companion = null;
    public static final String FLOAT_WINDOW_RESOLUTION = "float_window_resolution";
    public static final String INNER_FLOAT_WINDOW_RESOLUTION = "inner_float_window_resolution";
    public static final String PREVIEW_RESOLUTION = "preview_resolution";
    public static final String PULL_STREAM_RESOLUTION = "pull_stream_resolution";
    public static final String SMALL_WINDOW_RESOLUTION = "small_window_resolution";
    public static final String TAG = "ResolutionInterceptor";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/resolution/ResolutionInterceptor$Companion;", "", "()V", "FLOAT_WINDOW_RESOLUTION", "", "INNER_FLOAT_WINDOW_RESOLUTION", "PREVIEW_RESOLUTION", "PULL_STREAM_RESOLUTION", "SMALL_WINDOW_RESOLUTION", "TAG", "useForBuildRequest", "", "getUseForBuildRequest", "()Z", "setUseForBuildRequest", "(Z)V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String FLOAT_WINDOW_RESOLUTION = "float_window_resolution";
        public static final String INNER_FLOAT_WINDOW_RESOLUTION = "inner_float_window_resolution";
        public static final String PREVIEW_RESOLUTION = "preview_resolution";
        public static final String PULL_STREAM_RESOLUTION = "pull_stream_resolution";
        public static final String SMALL_WINDOW_RESOLUTION = "small_window_resolution";
        public static final String TAG = "ResolutionInterceptor";
        private static boolean useForBuildRequest;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }

        public final boolean getUseForBuildRequest() {
            return useForBuildRequest;
        }

        public final void setUseForBuildRequest(boolean r100) {
            useForBuildRequest = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static int getResolutionLevelBySdkKey(ResolutionInterceptor r100, IBaseStreamUrl r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "streamUrl");
            Intrinsics.checkNotNullParameter(r102, "resolutionSdkKey");
            Iterator<T> r103 = ResolutionInterceptorKt.safeGetQualityList(r101).iterator();
        L3:
            Object r104 = null;
            if (r103.hasNext() == false) goto L12;
            Object r105 = r103.next();
            IQuality r106 = (IQuality) r105;
            if (r106 == null) goto L8;
            String r107 = r106.getSdkKey();
        L10:
            if (Intrinsics.areEqual(r107, r102) == false) goto L3;
        L13:
            IQuality r108 = (IQuality) r105;
            if (r108 == null) goto L16;
            int r109 = r108.getLevel();
        L17:
            if (r109 != 0) goto L43;
            ILiveCoreSDKData r110 = r101.getLiveCoreSDKData();
            if (r110 == null) goto L44;
            List<IQuality> r111 = r110.getQualityList();
            if (r111 == null) goto L45;
            Iterator<T> r112 = r111.iterator();
        L25:
            if (r112.hasNext() == false) goto L33;
            Object r113 = r112.next();
            IQuality r114 = (IQuality) r113;
            if (r114 == null) goto L29;
            String r115 = r114.getSdkKey();
        L31:
            if (Intrinsics.areEqual(r115, r102) == false) goto L25;
            r104 = r113;
            goto L33
        L29:
            r115 = null;
        L33:
            IQuality r116 = (IQuality) r104;
            if (r116 != null) goto L36;
            return 0;
        L36:
            return r116.getLevel();
        L45:
            return 0;
        L44:
            return 0;
        L43:
            return r109;
        L16:
            r109 = 0;
            goto L17
        L8:
            r107 = null;
            goto L10
        L12:
            r105 = null;
            goto L13
        }

        public static IQuality getResolutionQualityByLevel(ResolutionInterceptor r100, StreamUrl r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "streamUrl");
            List<IQuality> r103 = r101.qualityList;
            Object r104 = null;
            if (r103 == null) goto L17;
            Iterator<T> r105 = r103.iterator();
        L6:
            if (r105.hasNext() == false) goto L15;
            Object r106 = r105.next();
            IQuality r107 = (IQuality) r106;
            if (r107 != null) goto L10;
        L12:
            boolean r108 = false;
        L13:
            if (r108 == false) goto L6;
        L16:
            IQuality r109 = (IQuality) r106;
        L18:
            if (r109 != null) goto L36;
            LiveCoreSDKData r110 = r101.getLiveCoreSDKData();
            if (r110 == null) goto L47;
            List<IQuality> r111 = r110.getQualityList();
            if (r111 == null) goto L48;
            Iterator<T> r112 = r111.iterator();
        L25:
            if (r112.hasNext() == false) goto L49;
            Object r113 = r112.next();
            IQuality r114 = (IQuality) r113;
            if (r114 != null) goto L29;
        L31:
            boolean r115 = false;
        L32:
            if (r115 == false) goto L25;
            r104 = r113;
            goto L49
        L29:
            if (r114.getLevel() != r102) goto L31;
            r115 = true;
        L49:
            return (IQuality) r104;
        L48:
            return null;
        L47:
            return null;
        L36:
            return r109;
        L10:
            if (r107.getLevel() != r102) goto L12;
            r108 = true;
            goto L13
        L15:
            r106 = null;
            goto L16
        L17:
            r109 = null;
            goto L18
        }

        public static String getResolutionSdkKeyByLevel(ResolutionInterceptor r100, IBaseStreamUrl r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "streamUrl");
            Iterator<T> r103 = ResolutionInterceptorKt.safeGetQualityList(r101).iterator();
        L3:
            Object r104 = null;
            if (r103.hasNext() == false) goto L13;
            Object r105 = r103.next();
            IQuality r106 = (IQuality) r105;
            if (r106 != null) goto L8;
        L10:
            boolean r107 = false;
        L11:
            if (r107 == false) goto L3;
        L14:
            IQuality r108 = (IQuality) r105;
            String r109 = "";
            if (r108 == null) goto L18;
            String r110 = r108.getSdkKey();
            if (r110 == null) goto L18;
        L20:
            if (r110.length() != 0) goto L22;
            boolean r111 = true;
        L23:
            if (r111 == false) goto L57;
            ILiveCoreSDKData r112 = r101.getLiveCoreSDKData();
            if (r112 == null) goto L46;
            List<IQuality> r113 = r112.getQualityList();
            if (r113 == null) goto L46;
            Iterator<T> r114 = r113.iterator();
        L30:
            if (r114.hasNext() == false) goto L39;
            Object r115 = r114.next();
            IQuality r116 = (IQuality) r115;
            if (r116 != null) goto L34;
        L36:
            boolean r117 = false;
        L37:
            if (r117 == false) goto L30;
            r104 = r115;
            goto L39
        L34:
            if (r116.getLevel() != r102) goto L36;
            r117 = true;
        L39:
            IQuality r118 = (IQuality) r104;
            if (r118 == null) goto L46;
            String r119 = r118.getSdkKey();
            if (r119 == null) goto L46;
            r109 = r119;
        L46:
            return r109;
        L57:
            return r110;
        L22:
            r111 = false;
        L18:
            r110 = "";
            goto L20
        L8:
            if (r106.getLevel() != r102) goto L10;
            r107 = true;
            goto L11
        L13:
            r105 = null;
            goto L14
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int getInterceptLevel();

    int getResolutionLevelBySdkKey(IBaseStreamUrl r100, String r101);

    IQuality getResolutionQualityByLevel(StreamUrl r100, int r101);

    String getResolutionSdkKeyByLevel(IBaseStreamUrl r100, int r101);

    PlayerResolution.PickResult intercept(long r100, IBaseStreamUrl r101, String r102, String r103);

    void setInterceptLevel(int r100);
}
