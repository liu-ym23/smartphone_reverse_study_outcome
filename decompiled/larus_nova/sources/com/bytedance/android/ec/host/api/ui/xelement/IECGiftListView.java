package com.bytedance.android.ec.host.api.ui.xelement;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014JN\u0010\f\u001a\u00020\n2D\u0010\u000b\u001a@\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/host/api/ui/xelement/IECGiftListView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "state", "", "", "data", "", "reporter", "setStateChangeReporter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ContentInset", "VideoSize", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IECGiftListView extends FrameLayout {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/host/api/ui/xelement/IECGiftListView$ContentInset;", "Ljava/io/Serializable;", "top", "", "left", "bottom", "right", "(FFFF)V", "getBottom", "()F", "setBottom", "(F)V", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ContentInset implements Serializable {
        private float bottom;
        private float left;
        private float right;
        private float top;

        public ContentInset() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }

        public final float getBottom() {
            return this.bottom;
        }

        public final float getLeft() {
            return this.left;
        }

        public final float getRight() {
            return this.right;
        }

        public final float getTop() {
            return this.top;
        }

        public final void setBottom(float r100) {
            this.bottom = r100;
        }

        public final void setLeft(float r100) {
            this.left = r100;
        }

        public final void setRight(float r100) {
            this.right = r100;
        }

        public final void setTop(float r100) {
            this.top = r100;
        }

        public ContentInset(float r100, float r101, float r102, float r103) {
            this.top = r100;
            this.left = r101;
            this.bottom = r102;
            this.right = r103;
        }

        public /* synthetic */ ContentInset(float r100, float r101, float r102, float r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = 0.0f;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 0.0f;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = 0.0f;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = 0.0f;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/host/api/ui/xelement/IECGiftListView$VideoSize;", "Ljava/io/Serializable;", "width", "", "height", "(FF)V", "getHeight", "()F", "setHeight", "(F)V", "getWidth", "setWidth", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VideoSize implements Serializable {
        private float height;
        private float width;

        public VideoSize() {
            float r100 = 0.0f;
            this(r100, r100, 3, null);
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getWidth() {
            return this.width;
        }

        public final void setHeight(float r100) {
            this.height = r100;
        }

        public final void setWidth(float r100) {
            this.width = r100;
        }

        public VideoSize(float r100, float r101) {
            this.width = r100;
            this.height = r101;
        }

        public /* synthetic */ VideoSize(float r100, float r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 200.0f;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 326.0f;
        L8:
            this(r100, r101);
        }
    }

    public IECGiftListView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IECGiftListView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void setStateChangeReporter(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100);

    public IECGiftListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ IECGiftListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
