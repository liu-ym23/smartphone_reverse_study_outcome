package com.bytedance.android.livehostapi.business.depend.largefont;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H'J\u0010\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/largefont/IHostLargeFontService;", "", "noZoom", "", "view", "Landroid/view/View;", "Landroid/view/ViewGroup;", "", "number", "", "noZoomAll", "noZoomType", "", "NoZoomType", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostLargeFontService {
    public static final int NO_FONT_SCALE = 2;
    public static final int NO_VIEW_ZOOM = 1;
    public static final int NO_VIEW_ZOOM_IGNORE_TEXT = 3;
    public static final int NO_ZOOM_ALL = 0;
    public static final NoZoomType NoZoomType = null;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.largefont.IHostLargeFontService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            NoZoomType r100 = IHostLargeFontService.NoZoomType;
        }

        public static /* synthetic */ void noZoomAll$default(IHostLargeFontService r100, ViewGroup r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = 1;
        L6:
            r100.noZoomAll(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: noZoomAll");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void noZoomAll$default(IHostLargeFontService r100, ViewGroup r101, int r102, int r103, Object r104) {
            CC.noZoomAll$default(r100, r101, r102, r103, r104);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/largefont/IHostLargeFontService$NoZoomType;", "", "()V", "NO_FONT_SCALE", "", "NO_VIEW_ZOOM", "NO_VIEW_ZOOM_IGNORE_TEXT", "NO_ZOOM_ALL", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NoZoomType {
        static final /* synthetic */ NoZoomType $$INSTANCE = null;
        public static final int NO_FONT_SCALE = 2;
        public static final int NO_VIEW_ZOOM = 1;
        public static final int NO_VIEW_ZOOM_IGNORE_TEXT = 3;
        public static final int NO_ZOOM_ALL = 0;

        private NoZoomType() {
        }

        static {
            $$INSTANCE = new NoZoomType();
        }
    }

    static {
        NoZoomType = NoZoomType.$$INSTANCE;
    }

    float noZoom(Number r100);

    void noZoom(View r100);

    @Deprecated(message = "请使用noZoomAll")
    void noZoom(ViewGroup r100);

    void noZoomAll(ViewGroup r100, int r101);
}
