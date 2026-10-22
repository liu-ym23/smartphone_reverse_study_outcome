package com.android.ttcjpaysdk.base.framework.container.view.base.abs;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.HybridViewController.IHybridApiView;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import id4.c;
import jd4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001\tB\u000f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/HybridViewController;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "R", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/HybridViewController$IHybridApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;", "viewUIInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;)V", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "IHybridApiView", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class HybridViewController<T extends IViewUiInfo, R extends IHybridApiView<T>> extends AbsBaseViewController<T, R> {
    private T viewUIInfo;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/HybridViewController$IHybridApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "Lid4/c;", "", "eventName", "Lorg/json/JSONObject;", "params", "", "sendJsEvent", "startLoad", "onViewShow", "onViewHide", "release", "base-context_release"}, k = 1, mv = {1, 6, 0})
    public interface IHybridApiView<T extends IViewUiInfo> extends IApiView<T>, c {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static <T extends IViewUiInfo> Theme getTheme(IHybridApiView<T> r100) {
                return IApiView.DefaultImpls.getTheme(r100);
            }

            public static <T extends IViewUiInfo> void setTheme(IHybridApiView<T> r100, Theme r101) {
                Intrinsics.checkNotNullParameter(r101, "theme");
                IApiView.DefaultImpls.setTheme(r100, r101);
            }
        }

        /* JADX WARN: Incorrect return type in method signature: <T::Ljd4/a;>(Ljava/lang/Class<TT;>;)TT; */
        /* synthetic */ a getCtx(Class r100);

        void onViewHide();

        void onViewShow();

        /* JADX WARN: Incorrect types in method signature: <T::Ljd4/a;>(Ljava/lang/Class<TT;>;TT;)V */
        /* synthetic */ void putCtx(Class r100, a r101);

        @Override // cd4.p, com.android.ttcjpaysdk.base.framework.container.abs.IRelease
        void release();

        /* synthetic */ <T extends a> void removeCtx(Class<T> r100);

        void sendJsEvent(String r100, JSONObject r101);

        void startLoad();
    }

    public HybridViewController(T r100) {
        super(r100);
        this.viewUIInfo = r100;
    }
}
