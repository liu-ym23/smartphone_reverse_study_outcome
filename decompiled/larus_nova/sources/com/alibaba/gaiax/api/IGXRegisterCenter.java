package com.alibaba.gaiax.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dH&J\u001a\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%H&J$\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)H&J\u001c\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\n\u0010,\u001a\u0006\u0012\u0002\b\u00030-H&J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u000200H&J\u0010\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u000203H&J\b\u00104\u001a\u000205H&¨\u00066"}, d2 = {"Lcom/alibaba/gaiax/api/IGXRegisterCenter;", "", "registerExperiment", "key", "", "value", "registerExtensionBizMapRelation", "extensionBizMap", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionBizMap;", "registerExtensionColor", "extensionColor", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionColor;", "registerExtensionDataBinding", "databindingExtensionDataBinding", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionDataBinding;", "registerExtensionException", "extensionException", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionException;", "registerExtensionExpression", "extensionExpression", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionExpression;", "registerExtensionFontFamily", "extensionFontFamily", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionFontFamily;", "registerExtensionSize", "extensionSize", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionSize;", "registerExtensionStaticProperty", "extensionStaticProperty", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionStaticProperty;", "registerExtensionTemplateSource", "source", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;", "priority", "", "registerExtensionViewClass", "viewClassConvertor", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionViewClass;", "registerExtensionViewSupport", "viewType", "viewCreator", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "registerGXMonitor", "monitor", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXMonitor;", "registerImageLoader", "imageLoader", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXImageLoader;", BasicTestActionHandler.TEST_ACTION_RESET, "", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IGXRegisterCenter {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ IGXRegisterCenter registerExtensionTemplateSource$default(IGXRegisterCenter r100, GXRegisterCenterApi.GXIExtensionTemplateSource r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = 0;
        L7:
            return r100.registerExtensionTemplateSource(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerExtensionTemplateSource");
        }
    }

    IGXRegisterCenter registerExperiment(String r100, Object r101);

    IGXRegisterCenter registerExtensionBizMapRelation(GXRegisterCenterApi.GXIExtensionBizMap r100);

    IGXRegisterCenter registerExtensionColor(GXRegisterCenterApi.GXIExtensionColor r100);

    IGXRegisterCenter registerExtensionDataBinding(GXRegisterCenterApi.GXIExtensionDataBinding r100);

    IGXRegisterCenter registerExtensionException(GXRegisterCenterApi.GXIExtensionException r100);

    IGXRegisterCenter registerExtensionExpression(GXRegisterCenterApi.GXIExtensionExpression r100);

    IGXRegisterCenter registerExtensionFontFamily(GXRegisterCenterApi.GXIExtensionFontFamily r100);

    IGXRegisterCenter registerExtensionSize(GXRegisterCenterApi.GXIExtensionSize r100);

    IGXRegisterCenter registerExtensionStaticProperty(GXRegisterCenterApi.GXIExtensionStaticProperty r100);

    IGXRegisterCenter registerExtensionTemplateSource(GXRegisterCenterApi.GXIExtensionTemplateSource r100, int r101);

    IGXRegisterCenter registerExtensionViewClass(GXRegisterCenterApi.GXIExtensionViewClass r100);

    IGXRegisterCenter registerExtensionViewSupport(String r100, Class<?> r101);

    IGXRegisterCenter registerExtensionViewSupport(String r100, Function1<? super Context, ? extends View> r101);

    IGXRegisterCenter registerGXMonitor(GXRegisterCenterApi.GXMonitor r100);

    IGXRegisterCenter registerImageLoader(GXRegisterCenterApi.GXImageLoader r100);

    void reset();
}
