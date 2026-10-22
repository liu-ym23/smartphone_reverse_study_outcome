package com.bytedance.android.livehostapi.business.depend.share;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J<\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&J`\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H&J:\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&JF\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0015\u001a\u00020\u0003H\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/IQrCodeShareHelper;", "", "getOriginalPicViewId", "", "getPicNum", "getQrCodeContainerId", "getSaveView", "Landroid/view/ViewGroup;", "index", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callback", "Lcom/bytedance/android/livehostapi/business/depend/share/IViewLoadCallback;", "extraInfo", "", "", "customBottom", "Landroid/view/View;", "waterMarkSize", "Lkotlin/Pair;", "getShowView", "getWatermarkContainerId", "Companion", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IQrCodeShareHelper {
    public static final Companion Companion = null;
    public static final String IMAGE_SAVING_GUIDE = "image_saving_guide";
    public static final int NO_WATERMARK = 0;
    public static final String SEARCH_GUIDE = "search_guide";

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getWatermarkContainerId(IQrCodeShareHelper r100) {
            return 0;
        }

        static {
            Companion r100 = IQrCodeShareHelper.Companion;
        }

        public static /* synthetic */ int access$getWatermarkContainerId$jd(IQrCodeShareHelper r100) {
            return $default$getWatermarkContainerId(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewGroup getSaveView$default(IQrCodeShareHelper r100, int r101, Context r102, IViewLoadCallback r103, Map r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = null;
        L7:
            return r100.getSaveView(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSaveView");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewGroup getShowView$default(IQrCodeShareHelper r100, int r101, Context r102, IViewLoadCallback r103, Map r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = null;
        L7:
            return r100.getShowView(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShowView");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewGroup getShowView$default(IQrCodeShareHelper r100, int r101, Context r102, IViewLoadCallback r110, Map r111, View r112, int r113, Object r114) {
            if (r114 != null) goto L14;
            if ((r113 & 8) == 0) goto L6;
            Map r103 = null;
        L8:
            if ((r113 & 16) == 0) goto L10;
            View r104 = null;
        L12:
            return r100.getShowView(r101, r102, r110, r103, r104);
        L10:
            r104 = r112;
            goto L12
        L6:
            r103 = r111;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShowView");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewGroup getSaveView$default(IQrCodeShareHelper r100, int r110, Context r111, IViewLoadCallback r112, Map r113, View r114, Pair r115, int r116, Object r117) {
            if (r117 != null) goto L18;
            if ((r116 & 8) == 0) goto L6;
            Map r101 = null;
        L8:
            if ((r116 & 16) == 0) goto L10;
            View r102 = null;
        L12:
            if ((r116 & 32) == 0) goto L14;
            Pair r103 = null;
        L16:
            return r100.getSaveView(r110, r111, r112, r101, r102, r103);
        L14:
            r103 = r115;
            goto L16
        L10:
            r102 = r114;
            goto L12
        L6:
            r101 = r113;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSaveView");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/IQrCodeShareHelper$Companion;", "", "()V", "IMAGE_SAVING_GUIDE", "", "NO_WATERMARK", "", "SEARCH_GUIDE", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String IMAGE_SAVING_GUIDE = "image_saving_guide";
        public static final int NO_WATERMARK = 0;
        public static final String SEARCH_GUIDE = "search_guide";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static int getWatermarkContainerId(IQrCodeShareHelper r100) {
            return CC.access$getWatermarkContainerId$jd(r100);
        }

        public static /* synthetic */ ViewGroup getSaveView$default(IQrCodeShareHelper r100, int r101, Context r102, IViewLoadCallback r103, Map r104, int r105, Object r106) {
            return CC.getSaveView$default(r100, r101, r102, r103, r104, r105, r106);
        }

        public static /* synthetic */ ViewGroup getShowView$default(IQrCodeShareHelper r100, int r101, Context r102, IViewLoadCallback r103, Map r104, int r105, Object r106) {
            return CC.getShowView$default(r100, r101, r102, r103, r104, r105, r106);
        }

        public static /* synthetic */ ViewGroup getShowView$default(IQrCodeShareHelper r100, int r101, Context r102, IViewLoadCallback r103, Map r104, View r105, int r106, Object r107) {
            return CC.getShowView$default(r100, r101, r102, r103, r104, r105, r106, r107);
        }

        public static /* synthetic */ ViewGroup getSaveView$default(IQrCodeShareHelper r100, int r101, Context r102, IViewLoadCallback r103, Map r104, View r105, Pair r106, int r107, Object r108) {
            return CC.getSaveView$default(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int getOriginalPicViewId();

    int getPicNum();

    int getQrCodeContainerId();

    ViewGroup getSaveView(int r100, Context r101, IViewLoadCallback r102, Map<String, String> r103);

    ViewGroup getSaveView(int r100, Context r101, IViewLoadCallback r102, Map<String, String> r103, View r104, Pair<Integer, Integer> r105);

    ViewGroup getShowView(int r100, Context r101, IViewLoadCallback r102, Map<String, String> r103);

    ViewGroup getShowView(int r100, Context r101, IViewLoadCallback r102, Map<String, String> r103, View r104);

    int getWatermarkContainerId();
}
