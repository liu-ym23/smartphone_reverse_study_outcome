package com.alibaba.gaiax.context;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.api.GXITrackListener;
import com.alibaba.gaiax.model.GXTemplateData;
import com.alibaba.gaiax.model.GXTrack;
import com.alibaba.gaiax.render.node.GXNode;
import com.alibaba.gaiax.render.node.GXTemplateNode;
import com.alibaba.gaiax.render.node.text.GXDirtyText;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.template.GXMeasureSize;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.alibaba.gaiax.utils.ThreadPoolUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 g2\u00020\u0001:\u0001gB3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010`\u001a\u00020aJ\u0006\u0010b\u001a\u00020aJ\u0006\u0010c\u001a\u00020aJ\u0006\u0010d\u001a\u00020aJ\u0006\u0010e\u001a\u00020aJ\b\u0010f\u001a\u000202H\u0016R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R(\u00100\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010X\u001a\u00020Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006h"}, d2 = {"Lcom/alibaba/gaiax/context/GXTemplateContext;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "size", "Lcom/alibaba/gaiax/template/GXMeasureSize;", "templateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "templateInfo", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "visualTemplateNode", "Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "(Landroid/content/Context;Lcom/alibaba/gaiax/template/GXMeasureSize;Lcom/alibaba/gaiax/template/GXTemplateItem;Lcom/alibaba/gaiax/template/GXTemplateInfo;Lcom/alibaba/gaiax/render/node/GXTemplateNode;)V", "blurViews", "", "Lcom/alibaba/gaiax/render/view/basic/GXView;", "getBlurViews", "()Ljava/util/Set;", "setBlurViews", "(Ljava/util/Set;)V", "containers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/alibaba/gaiax/render/view/container/GXContainer;", "getContainers", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "setContainers", "(Ljava/util/concurrent/CopyOnWriteArraySet;)V", "getContext", "()Landroid/content/Context;", "dirtyTexts", "Lcom/alibaba/gaiax/render/node/text/GXDirtyText;", "getDirtyTexts", "setDirtyTexts", "indexPosition", "", "getIndexPosition", "()I", "setIndexPosition", "(I)V", "isAppear", "", "()Z", "setAppear", "(Z)V", "isDirty", "setDirty", "isFlexGrowLayout", "setFlexGrowLayout", "manualTrackMap", "", "", "Lcom/alibaba/gaiax/model/GXTrack;", "getManualTrackMap", "()Ljava/util/Map;", "setManualTrackMap", "(Ljava/util/Map;)V", "onImageDrawableListener", "Lcom/alibaba/gaiax/render/view/basic/GXImageView$GXImageViewListener;", "getOnImageDrawableListener", "()Lcom/alibaba/gaiax/render/view/basic/GXImageView$GXImageViewListener;", "setOnImageDrawableListener", "(Lcom/alibaba/gaiax/render/view/basic/GXImageView$GXImageViewListener;)V", "rootNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "getRootNode", "()Lcom/alibaba/gaiax/render/node/GXNode;", "setRootNode", "(Lcom/alibaba/gaiax/render/node/GXNode;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getSize", "()Lcom/alibaba/gaiax/template/GXMeasureSize;", "setSize", "(Lcom/alibaba/gaiax/template/GXMeasureSize;)V", "templateData", "Lcom/alibaba/gaiax/model/GXTemplateData;", "getTemplateData", "()Lcom/alibaba/gaiax/model/GXTemplateData;", "setTemplateData", "(Lcom/alibaba/gaiax/model/GXTemplateData;)V", "getTemplateInfo", "()Lcom/alibaba/gaiax/template/GXTemplateInfo;", "getTemplateItem", "()Lcom/alibaba/gaiax/template/GXTemplateItem;", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPoolExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "getVisualTemplateNode", "()Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "setVisualTemplateNode", "(Lcom/alibaba/gaiax/render/node/GXTemplateNode;)V", "initBlurViews", "", "initContainers", "initImageDrawableListener", "manualExposure", "release", "toString", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTemplateContext {
    public static final Companion Companion = null;
    private Set<GXView> blurViews;
    private CopyOnWriteArraySet<GXContainer> containers;
    private final Context context;
    private Set<GXDirtyText> dirtyTexts;
    private int indexPosition;
    private boolean isAppear;
    private boolean isDirty;
    private boolean isFlexGrowLayout;
    private Map<String, GXTrack> manualTrackMap;
    private GXImageView.GXImageViewListener onImageDrawableListener;
    private GXNode rootNode;
    private View rootView;
    private GXMeasureSize size;
    private GXTemplateData templateData;
    private final GXTemplateInfo templateInfo;
    private final GXTemplateItem templateItem;
    private final ThreadPoolExecutor threadPoolExecutor;
    private GXTemplateNode visualTemplateNode;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0012"}, d2 = {"Lcom/alibaba/gaiax/context/GXTemplateContext$Companion;", "", "()V", "clearContext", "", "targetView", "Landroid/view/View;", "createContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "gxMeasureSize", "Lcom/alibaba/gaiax/template/GXMeasureSize;", "gxTemplateInfo", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "gxVisualTemplateNode", "Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "getContext", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void clearContext(View r100) {
            if ((r100 instanceof GXIRootView) == false) goto L6;
            ((GXIRootView) r100).setTemplateContext(null);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final GXTemplateContext getContext(View r100) {
            if ((r100 instanceof GXIRootView) == true) goto L5;
            return null;
        L5:
            return ((GXIRootView) r100).getTemplateContext();
        }

        public final GXTemplateContext createContext(GXTemplateItem r100, GXMeasureSize r110, GXTemplateInfo r111, GXTemplateNode r112) {
            Intrinsics.checkNotNullParameter(r100, "gxTemplateItem");
            Intrinsics.checkNotNullParameter(r110, "gxMeasureSize");
            Intrinsics.checkNotNullParameter(r111, "gxTemplateInfo");
            return new GXTemplateContext(r100.getContext(), r110, r100, r111, r112, null);
        }

        public static /* synthetic */ GXTemplateContext createContext$default(Companion r100, GXTemplateItem r101, GXMeasureSize r102, GXTemplateInfo r103, GXTemplateNode r104, int r105, Object r106) {
            if ((r105 & 8) == 0) goto L6;
            r104 = null;
        L6:
            return r100.createContext(r101, r102, r103, r104);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ GXTemplateContext(Context r100, GXMeasureSize r101, GXTemplateItem r102, GXTemplateInfo r103, GXTemplateNode r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    public final void initBlurViews() {
        if (this.blurViews != null) goto L6;
        this.blurViews = new LinkedHashSet();
        return;
    }

    public final void initContainers() {
        if (this.containers != null) goto L6;
        this.containers = new CopyOnWriteArraySet();
        return;
    }

    public final void initImageDrawableListener() {
        if (this.onImageDrawableListener != null) goto L6;
        this.onImageDrawableListener = new AnonymousClass1(this);
        return;
    }

    public final void manualExposure() {
        Map<String, GXTrack> r100 = this.manualTrackMap;
        if (r100 == null) goto L12;
        Iterator<Map.Entry<String, GXTrack>> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L20;
        Map.Entry<String, GXTrack> r102 = r101.next();
        GXTemplateData r103 = this.templateData;
        if (r103 == null) goto L6;
        GXITrackListener r104 = r103.getTrackListener();
        if (r104 == null) goto L6;
        r104.onManualExposureTrackEvent(r102.getValue());
        goto L6
    L20:
        return;
    }

    public final void release() {
        Set<GXView> r100 = this.blurViews;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        CopyOnWriteArraySet<GXContainer> r101 = this.containers;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        this.isDirty = false;
        Set<GXDirtyText> r102 = this.dirtyTexts;
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        this.dirtyTexts = null;
        this.templateData = null;
        this.rootView = null;
        this.visualTemplateNode = null;
        GXNode r103 = this.rootNode;
        if (r103 == null) goto L14;
        r103.release();
    L14:
        this.rootNode = null;
        this.threadPoolExecutor.shutdownNow();
    }

    public String toString() {
        return "GXTemplateContext(context=" + this.context + ", isDirty=" + this.isDirty + ", size=" + this.size + ", templateItem='" + this.templateItem + "' rootView=" + this.rootView + ')';
    }

    public final Set<GXView> getBlurViews() {
        return this.blurViews;
    }

    public final CopyOnWriteArraySet<GXContainer> getContainers() {
        return this.containers;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Set<GXDirtyText> getDirtyTexts() {
        return this.dirtyTexts;
    }

    public final int getIndexPosition() {
        return this.indexPosition;
    }

    public final Map<String, GXTrack> getManualTrackMap() {
        return this.manualTrackMap;
    }

    public final GXImageView.GXImageViewListener getOnImageDrawableListener() {
        return this.onImageDrawableListener;
    }

    public final GXNode getRootNode() {
        return this.rootNode;
    }

    public final View getRootView() {
        return this.rootView;
    }

    public final GXMeasureSize getSize() {
        return this.size;
    }

    public final GXTemplateData getTemplateData() {
        return this.templateData;
    }

    public final GXTemplateInfo getTemplateInfo() {
        return this.templateInfo;
    }

    public final GXTemplateItem getTemplateItem() {
        return this.templateItem;
    }

    public final ThreadPoolExecutor getThreadPoolExecutor() {
        return this.threadPoolExecutor;
    }

    public final GXTemplateNode getVisualTemplateNode() {
        return this.visualTemplateNode;
    }

    public final boolean isAppear() {
        return this.isAppear;
    }

    public final boolean isDirty() {
        return this.isDirty;
    }

    public final boolean isFlexGrowLayout() {
        return this.isFlexGrowLayout;
    }

    public final void setAppear(boolean r100) {
        this.isAppear = r100;
    }

    public final void setBlurViews(Set<GXView> r100) {
        this.blurViews = r100;
    }

    public final void setContainers(CopyOnWriteArraySet<GXContainer> r100) {
        this.containers = r100;
    }

    public final void setDirty(boolean r100) {
        this.isDirty = r100;
    }

    public final void setDirtyTexts(Set<GXDirtyText> r100) {
        this.dirtyTexts = r100;
    }

    public final void setFlexGrowLayout(boolean r100) {
        this.isFlexGrowLayout = r100;
    }

    public final void setIndexPosition(int r100) {
        this.indexPosition = r100;
    }

    public final void setManualTrackMap(Map<String, GXTrack> r100) {
        this.manualTrackMap = r100;
    }

    public final void setOnImageDrawableListener(GXImageView.GXImageViewListener r100) {
        this.onImageDrawableListener = r100;
    }

    public final void setRootNode(GXNode r100) {
        this.rootNode = r100;
    }

    public final void setRootView(View r100) {
        this.rootView = r100;
    }

    public final void setSize(GXMeasureSize r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.size = r100;
    }

    public final void setTemplateData(GXTemplateData r100) {
        this.templateData = r100;
    }

    public final void setVisualTemplateNode(GXTemplateNode r100) {
        this.visualTemplateNode = r100;
    }

    private GXTemplateContext(Context r100, GXMeasureSize r101, GXTemplateItem r102, GXTemplateInfo r103, GXTemplateNode r104) {
        this.context = r100;
        this.size = r101;
        this.templateItem = r102;
        this.templateInfo = r103;
        this.visualTemplateNode = r104;
        this.indexPosition = -1;
        this.threadPoolExecutor = ThreadPoolUtils.INSTANCE.newSingleThreadPool();
    }

    public /* synthetic */ GXTemplateContext(Context r100, GXMeasureSize r101, GXTemplateItem r102, GXTemplateInfo r110, GXTemplateNode r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
