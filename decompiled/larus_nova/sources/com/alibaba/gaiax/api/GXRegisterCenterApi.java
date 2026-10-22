package com.alibaba.gaiax.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.alibaba.gaiax.template.GXDataBinding;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.GXTemplate;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\r\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0010"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi;", "", "()V", "GXIExtensionBizMap", "GXIExtensionColor", "GXIExtensionDataBinding", "GXIExtensionException", "GXIExtensionExpression", "GXIExtensionFontFamily", "GXIExtensionSize", "GXIExtensionStaticProperty", "GXIExtensionTemplateSource", "GXIExtensionViewClass", "GXImageDownloadCallback", "GXImageLoader", "GXMonitor", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXRegisterCenterApi {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionBizMap;", "", "convert", "", MapController.ITEM_LAYER_TAG, "Lcom/alibaba/gaiax/template/GXTemplateItem;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionBizMap {
        void convert(GXTemplateItem r100);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionColor;", "", "convert", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "value", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionColor {
        Integer convert(Context r100, String r101);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionDataBinding;", "", "create", "Lcom/alibaba/gaiax/template/GXDataBinding;", "expVersion", "", "value", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionDataBinding {
        GXDataBinding create(String r100, Object r101);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0004j\u0002`\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionException;", "", a.KEY_EXCEPTION, "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionException {
        void exception(Exception r100);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionExpression;", "", "create", "Lcom/alibaba/gaiax/template/GXIExpression;", "expVersion", "", "value", "isTrue", "", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionExpression {
        GXIExpression create(String r100, Object r101);

        boolean isTrue(String r100, Object r101);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionFontFamily;", "", "fontFamily", "Landroid/graphics/Typeface;", "fontFamilyName", "", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionFontFamily {
        Typeface fontFamily(String r100);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionSize;", "", "convert", "", "value", "(F)Ljava/lang/Float;", "create", "", "(Ljava/lang/String;)Ljava/lang/Float;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionSize {
        Float convert(float r100);

        Float create(String r100);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionStaticProperty;", "", "convert", "params", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionStaticProperty$GXParams;", "GXParams", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionStaticProperty {

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionStaticProperty$GXParams;", "", "propertyName", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getPropertyName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class GXParams {
            private final String propertyName;
            private final Object value;

            public static /* synthetic */ GXParams copy$default(GXParams r100, String r101, Object r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.propertyName;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.value;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.propertyName;
            }

            public final Object component2() {
                return this.value;
            }

            public final GXParams copy(String r100, Object r101) {
                Intrinsics.checkNotNullParameter(r100, "propertyName");
                Intrinsics.checkNotNullParameter(r101, "value");
                return new GXParams(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof GXParams) == true) goto L8;
                return false;
            L8:
                GXParams r101 = (GXParams) r100;
                if (Intrinsics.areEqual(this.propertyName, r101.propertyName) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.value, r101.value) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.propertyName.hashCode() * 31) + this.value.hashCode();
            }

            public String toString() {
                return "GXParams(propertyName=" + this.propertyName + ", value=" + this.value + ')';
            }

            public final String getPropertyName() {
                return this.propertyName;
            }

            public final Object getValue() {
                return this.value;
            }

            public GXParams(String r100, Object r101) {
                Intrinsics.checkNotNullParameter(r100, "propertyName");
                Intrinsics.checkNotNullParameter(r101, "value");
                this.propertyName = r100;
                this.value = r101;
            }
        }

        Object convert(GXParams r100);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;", "", "getTemplate", "Lcom/alibaba/gaiax/template/GXTemplate;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionTemplateSource {
        GXTemplate getTemplate(GXTemplateItem r100);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionViewClass;", "", "convert", "", "value", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionViewClass {
        String convert(String r100);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXImageDownloadCallback;", "", "()V", LynxVideoManagerLite.EVENT_ON_ERROR, "", "onSuccess", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class GXImageDownloadCallback {
        public GXImageDownloadCallback() {
        }

        public void onError() {
        }

        public abstract void onSuccess(Bitmap r100);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXImageLoader;", "", "loadImage", "", "imageUrl", "", "callback", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXImageDownloadCallback;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXImageLoader {
        void loadImage(String r100, GXImageDownloadCallback r101);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXMonitor;", "", "onImageLoadSuccess", "", DyPayConstant.KEY_START_TIME, "", "uri", "", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXMonitor {
        void onImageLoadSuccess(long r100, String r101);
    }

    public GXRegisterCenterApi() {
    }
}
