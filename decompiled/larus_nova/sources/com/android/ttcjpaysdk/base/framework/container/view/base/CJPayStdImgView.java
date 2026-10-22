package com.android.ttcjpaysdk.base.framework.container.view.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.AbsBaseViewController;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.BaseViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.stdresource.CJPayStdIcon;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0016J!\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdImgView;", "Landroid/widget/ImageView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/IImgApiView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "uiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/ImgUiInfo;", "refresh", "", "viewUIInfo", "setBitmap", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "setClickListener", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "setTalkback", "contentDescription", "", "focusable", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "setTheme", "theme", "Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;", "ImgViewController", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayStdImgView extends ImageView implements IImgApiView {
    private ImgUiInfo uiInfo;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/CJPayStdImgView$ImgViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/ImgUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/IImgApiView;", "imgUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/ImgUiInfo;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ImgViewController extends AbsBaseViewController<ImgUiInfo, IImgApiView> {
        /* JADX WARN: Multi-variable type inference failed */
        public ImgViewController() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public ImgViewController(ImgUiInfo r100) {
            super(r100);
        }

        public /* synthetic */ ImgViewController(ImgUiInfo r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.abs.ITheme
    public Theme getTheme() {
        return IImgApiView.DefaultImpls.getTheme(this);
    }

    public CJPayStdImgView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.uiInfo = new ImgUiInfo(null, null, null, 7, null);
    }

    public void refresh(ImgUiInfo r100) {
        if (r100 == null) goto L12;
        this.uiInfo = r100;
        if (r100.getCustomIcon() == null) goto L6;
        setImageBitmap(r100.getCustomIcon());
        return;
    L6:
        CJPayStdIcon r101 = r100.getIconType();
        if (r101 == null) goto L14;
        Drawable r102 = r101.asDrawable(getContext(), r100.getBaseViewUiInfo().getTheme());
        if (r102 == null) goto L15;
        setImageDrawable(r102);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.IImgApiView
    public void setBitmap(Bitmap r100) {
        if (r100 == null) goto L5;
        setImageBitmap(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView
    public void setClickListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this, new AnonymousClass1(r100));
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.abs.ITheme
    public void setTheme(Theme r110) {
        Intrinsics.checkNotNullParameter(r110, "theme");
        ImgUiInfo r100 = this.uiInfo;
        refresh(ImgUiInfo.copy$default(r100, BaseViewUiInfo.copy$default(r100.getBaseViewUiInfo(), null, 0, 0, 0, r110, 15, null), null, null, 6, null));
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView
    public /* bridge */ /* synthetic */ void refresh(IViewUiInfo r100) {
        refresh((ImgUiInfo) r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.IImgApiView
    public void setTalkback(String r100, Boolean r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L7:
        if (r102 == false) goto L12;
        setContentDescription(r100);
        if (r101 == null) goto L13;
        r101.booleanValue();
        setFocusable(r101.booleanValue());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        r102 = true;
        goto L7
    }
}
