package com.alibaba.gaiax.render.view.container;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.drawable.GXRoundCornerBorderGradientDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXContainer;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "getTemplateContext", "onBindData", "", "data", "Lorg/json/JSONObject;", "setRoundCornerBorder", "borderColor", "borderWidth", "", "radius", "", "setRoundCornerRadius", "setTemplateContext", "gxContext", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class GXContainer extends RecyclerView implements GXIViewBindData, GXIRootView, GXIRoundCorner {
    private GXTemplateContext gxTemplateContext;

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(JSONObject r100) {
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public GXTemplateContext getTemplateContext() {
        return this.gxTemplateContext;
    }

    public GXContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "radius");
        if (r100.length != 8) goto L22;
        boolean r101 = false;
        final float r102 = r100[0];
        float r103 = r100[2];
        float r104 = r100[4];
        float r105 = r100[6];
        if (r102 != r103) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L10;
        return;
    L10:
        if (r103 != r104) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == true) goto L15;
        return;
    L15:
        if (r104 != r105) goto L17;
        r101 = true;
    L17:
        if (r101 == true) goto L19;
        return;
    L19:
        if (r102 <= 0.0f) goto L26;
        setClipToOutline(true);
        setOutlineProvider(new AnonymousClass1(this, r102));
        return;
    L26:
        return;
    L12:
        r107 = false;
        goto L13
    L7:
        r106 = false;
        goto L8
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public void setTemplateContext(GXTemplateContext r100) {
        this.gxTemplateContext = r100;
    }

    public GXContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public GXContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int r100, float r101, float[] r102) {
        Intrinsics.checkNotNullParameter(r102, "radius");
        if (r102.length != 8) goto L8;
        GXRoundCornerBorderGradientDrawable r103 = new GXRoundCornerBorderGradientDrawable();
        r103.setShape(0);
        r103.setCornerRadii(r102);
        r103.setStroke((int) r101, r100);
        if (Build.VERSION.SDK_INT < 23) goto L9;
        setForeground(r103);
        return;
    L9:
        return;
    }
}
