package com.bytedance.android.ec.window.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u000e$B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/window/base/view/ECWindowVideoView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "getVideoView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCoverView", "Lcom/bytedance/android/ec/window/base/view/ECWindowVideoView$ScaleType;", "scaleType", "", "setScaleType", "", "coverUrl", "setCoverUrl", "Lcom/bytedance/android/ec/window/base/view/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/window/base/view/h;", "getAwemeVideoListener", "()Lcom/bytedance/android/ec/window/base/view/h;", "setAwemeVideoListener", "(Lcom/bytedance/android/ec/window/base/view/h;)V", "awemeVideoListener", "b", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getPlayNotificationView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "playNotificationView", "Landroid/util/AttributeSet;", "c", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ScaleType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECWindowVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f49872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f49873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AttributeSet f49874c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/view/ECWindowVideoView$ScaleType;", "", "FIT_CENTER", "CENTER_CROP", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ScaleType extends Enum<ScaleType> {
        public static final ScaleType CENTER_CROP = null;
        public static final ScaleType FIT_CENTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScaleType[] f49875a = null;

        static {
            ScaleType r100 = new ScaleType("FIT_CENTER", 0);
            FIT_CENTER = r100;
            ScaleType r101 = new ScaleType("CENTER_CROP", 1);
            CENTER_CROP = r101;
            f49875a = new ScaleType[]{r100, r101};
        }

        public static ScaleType valueOf(String r100) {
            return (ScaleType) r27.a.a(ScaleType.class, r100);
        }

        public static ScaleType[] values() {
            return (ScaleType[]) f49875a.clone();
        }

        public ScaleType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public abstract SimpleDraweeView getCoverView();

    public abstract View getVideoView();

    public abstract void setCoverUrl(String r100);

    public abstract void setScaleType(ScaleType r100);

    public final AttributeSet getAttrs() {
        return this.f49874c;
    }

    public final h getAwemeVideoListener() {
        return this.f49872a;
    }

    public final SimpleDraweeView getPlayNotificationView() {
        return this.f49873b;
    }

    public final void setAwemeVideoListener(h r100) {
        this.f49872a = r100;
    }

    public ECWindowVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f49874c = r101;
        this.f49873b = new SimpleDraweeView(r100);
    }
}
