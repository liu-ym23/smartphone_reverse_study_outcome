package com.alibaba.gaiax.api;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.model.GXTemplateData;
import com.alibaba.gaiax.template.GXMeasureSize;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u001b"}, d2 = {"Lcom/alibaba/gaiax/api/IGXTemplateEngine;", "", "bindData", "", "gxView", "Landroid/view/View;", "gxTemplateData", "Lcom/alibaba/gaiax/model/GXTemplateData;", "gxMeasureSize", "Lcom/alibaba/gaiax/template/GXMeasureSize;", "asyncBinding", "", "onSuccess", "Lkotlin/Function0;", "createView", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "destroyView", "targetView", "getGXViewById", "id", "", "init", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", LynxVideoManagerLite.EVENT_ON_APPEAR, "onDisappear", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IGXTemplateEngine {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void bindData$default(IGXTemplateEngine r100, View r101, GXTemplateData r102, GXMeasureSize r110, boolean r111, Function0 r112, int r113, Object r114) {
            if (r114 != null) goto L18;
            if ((r113 & 4) == 0) goto L6;
            GXMeasureSize r103 = null;
        L8:
            if ((r113 & 8) == 0) goto L10;
            boolean r104 = false;
        L12:
            if ((r113 & 16) == 0) goto L14;
            Function0 r105 = null;
        L15:
            r100.bindData(r101, r102, r103, r104, r105);
            return;
        L14:
            r105 = r112;
            goto L15
        L10:
            r104 = r111;
            goto L12
        L6:
            r103 = r110;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindData");
        }
    }

    void bindData(View r100, GXTemplateData r101, GXMeasureSize r102, boolean r103, Function0<Unit> r104);

    View createView(GXTemplateItem r100, GXMeasureSize r101);

    void destroyView(View r100);

    View getGXViewById(View r100, String r101);

    IGXTemplateEngine init(Context r100);

    void onAppear(View r100);

    void onDisappear(View r100);
}
