package com.android.ttcjpaysdk.base.framework.container.view.base;

import android.graphics.Bitmap;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J#\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/IImgApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/ImgUiInfo;", "setBitmap", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "setTalkback", "contentDescription", "", "focusable", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IImgApiView extends IApiView<ImgUiInfo> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void setTalkback(IImgApiView r100, String r101, Boolean r102) {
        }

        public static Theme getTheme(IImgApiView r100) {
            return IApiView.DefaultImpls.getTheme(r100);
        }

        public static void setTheme(IImgApiView r100, Theme r101) {
            Intrinsics.checkNotNullParameter(r101, "theme");
            IApiView.DefaultImpls.setTheme(r100, r101);
        }

        public static /* synthetic */ void setTalkback$default(IImgApiView r100, String r101, Boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.setTalkback(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTalkback");
        }
    }

    void setBitmap(Bitmap r100);

    void setTalkback(String r100, Boolean r101);
}
