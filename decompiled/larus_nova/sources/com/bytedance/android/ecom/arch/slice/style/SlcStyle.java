package com.bytedance.android.ecom.arch.slice.style;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.render.SlcBackground;
import com.bytedance.android.ecom.arch.slice.render.context.b;
import com.bytedance.android.ecom.arch.slice.render.l;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes44.dex */
@JsonAdapter(SlcStyleTypeAdapter.class)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0087\b\u0018\u0000 a2\u00020\u0001:\u0001bB!\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007¢\u0006\u0004\b^\u0010_B\u001f\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b^\u0010`J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0003J#\u0010\f\u001a\u00020\u00002\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0001J\t\u0010\r\u001a\u00020\bHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\tHÖ\u0003R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR%\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"R%\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\"R\u001d\u0010+\u001a\u0004\u0018\u00010'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010*R\u001d\u0010.\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010\u001dR\u001d\u00102\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u00101R\u001d\u00105\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0013\u001a\u0004\b4\u00101R\u001d\u00108\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0013\u001a\u0004\b7\u00101R\u001d\u0010;\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0013\u001a\u0004\b:\u00101R#\u0010@\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0013\u0012\u0004\b>\u0010?\u001a\u0004\b=\u00101R#\u0010D\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bA\u0010\u0013\u0012\u0004\bC\u0010?\u001a\u0004\bB\u00101R\u001d\u0010I\u001a\u0004\u0018\u00010E8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0013\u001a\u0004\bG\u0010HR\u001d\u0010L\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0013\u001a\u0004\bK\u00101R\u001d\u0010O\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0013\u001a\u0004\bN\u0010\u001dR\u001d\u0010S\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0013\u001a\u0004\bQ\u0010RR\u001d\u0010V\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0013\u001a\u0004\bU\u0010\u001dR#\u0010Z\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bW\u0010\u0013\u0012\u0004\bY\u0010?\u001a\u0004\bX\u00101R'\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010[\u001a\u0004\b\\\u0010]¨\u0006c"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/style/SlcStyle;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ecom/arch/slice/render/context/b;", "slcDisplayMetrics", "", "widthPx", "heightPx", "", "", "", "component1", "attrs", "copy", "toString", "hashCode", "other", "", "equals", "width$delegate", "Lkotlin/Lazy;", "getWidth", "()Ljava/lang/Object;", "width", "height$delegate", "getHeight", "height", "", "aspectRatio$delegate", "getAspectRatio", "()Ljava/lang/Float;", "aspectRatio", "", "padding$delegate", "getPadding", "()Ljava/util/List;", GXTemplateKey.FLEXBOX_PADDING, "margin$delegate", "getMargin", GXTemplateKey.FLEXBOX_MARGIN, "Lcom/bytedance/android/ecom/arch/slice/render/l;", "radius$delegate", "getRadius", "()Lcom/bytedance/android/ecom/arch/slice/render/l;", "radius", "borderWidth$delegate", "getBorderWidth", "borderWidth", "borderColor$delegate", "getBorderColor", "()Ljava/lang/String;", "borderColor", "borderStyle$delegate", "getBorderStyle", "borderStyle", "bgImg$delegate", "getBgImg", "bgImg", "bgColor$delegate", "getBgColor", "bgColor", "visibility$delegate", "getVisibility", "getVisibility$annotations", "()V", RemoteMessageConst.Notification.VISIBILITY, "display$delegate", "getDisplay", "getDisplay$annotations", "display", "Lcom/bytedance/android/ecom/arch/slice/render/SlcBackground;", "background$delegate", "getBackground", "()Lcom/bytedance/android/ecom/arch/slice/render/SlcBackground;", "background", "fontColor$delegate", "getFontColor", "fontColor", "fontSize$delegate", "getFontSize", "fontSize", "fontWeight$delegate", "getFontWeight", "()Ljava/lang/Integer;", "fontWeight", "opacity$delegate", "getOpacity", GXTemplateKey.STYLE_OPACITY, "fontStyle$delegate", "getFontStyle", "getFontStyle$annotations", "fontStyle", "Ljava/util/Map;", "getAttrs", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcStyle implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final Lazy aspectRatio$delegate;
    private final Map<String, Object> attrs;
    private final Lazy background$delegate;
    private final Lazy bgColor$delegate;
    private final Lazy bgImg$delegate;
    private final Lazy borderColor$delegate;
    private final Lazy borderStyle$delegate;
    private final Lazy borderWidth$delegate;
    private final Lazy display$delegate;
    private final Lazy fontColor$delegate;
    private final Lazy fontSize$delegate;
    private final Lazy fontStyle$delegate;
    private final Lazy fontWeight$delegate;
    private final Lazy height$delegate;
    private final Lazy margin$delegate;
    private final Lazy opacity$delegate;
    private final Lazy padding$delegate;
    private final Lazy radius$delegate;
    private final Lazy visibility$delegate;
    private final Lazy width$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlcStyle() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlcStyle copy$default(SlcStyle r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.attrs;
    L6:
        return r100.copy(r101);
    }

    public static /* synthetic */ void getDisplay$annotations() {
    }

    public static /* synthetic */ void getFontStyle$annotations() {
    }

    public static /* synthetic */ void getVisibility$annotations() {
    }

    public final Map<String, Object> component1() {
        return this.attrs;
    }

    public final SlcStyle copy(Map<String, ? extends Object> r100) {
        return new SlcStyle(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SlcStyle) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.attrs, ((SlcStyle) r100).attrs) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final Float getAspectRatio() {
        return (Float) this.aspectRatio$delegate.getValue();
    }

    public final SlcBackground getBackground() {
        return (SlcBackground) this.background$delegate.getValue();
    }

    public final String getBgColor() {
        return (String) this.bgColor$delegate.getValue();
    }

    public final String getBgImg() {
        return (String) this.bgImg$delegate.getValue();
    }

    public final String getBorderColor() {
        return (String) this.borderColor$delegate.getValue();
    }

    public final String getBorderStyle() {
        return (String) this.borderStyle$delegate.getValue();
    }

    public final Float getBorderWidth() {
        return (Float) this.borderWidth$delegate.getValue();
    }

    public final String getDisplay() {
        return (String) this.display$delegate.getValue();
    }

    public final String getFontColor() {
        return (String) this.fontColor$delegate.getValue();
    }

    public final Float getFontSize() {
        return (Float) this.fontSize$delegate.getValue();
    }

    public final String getFontStyle() {
        return (String) this.fontStyle$delegate.getValue();
    }

    public final Integer getFontWeight() {
        return (Integer) this.fontWeight$delegate.getValue();
    }

    public final Object getHeight() {
        return this.height$delegate.getValue();
    }

    public final List<Object> getMargin() {
        return (List) this.margin$delegate.getValue();
    }

    public final Float getOpacity() {
        return (Float) this.opacity$delegate.getValue();
    }

    public final List<Object> getPadding() {
        return (List) this.padding$delegate.getValue();
    }

    public final l getRadius() {
        return (l) this.radius$delegate.getValue();
    }

    public final String getVisibility() {
        return (String) this.visibility$delegate.getValue();
    }

    public final Object getWidth() {
        return this.width$delegate.getValue();
    }

    public int hashCode() {
        Map<String, Object> r100 = this.attrs;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "SlcStyle(attrs=" + this.attrs + ")";
    }

    public final Map<String, Object> getAttrs() {
        return this.attrs;
    }

    public SlcStyle(Map<String, ? extends Object> r100) {
        this.attrs = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.width$delegate = LazyKt.lazy(r101, new SlcStyle$width$2(this));
        this.height$delegate = LazyKt.lazy(r101, new SlcStyle$height$2(this));
        this.aspectRatio$delegate = LazyKt.lazy(r101, new SlcStyle$aspectRatio$2(this));
        this.padding$delegate = LazyKt.lazy(r101, new SlcStyle$padding$2(this));
        this.margin$delegate = LazyKt.lazy(r101, new SlcStyle$margin$2(this));
        this.radius$delegate = LazyKt.lazy(r101, new SlcStyle$radius$2(this));
        this.borderWidth$delegate = LazyKt.lazy(r101, new SlcStyle$borderWidth$2(this));
        this.borderColor$delegate = LazyKt.lazy(r101, new SlcStyle$borderColor$2(this));
        this.borderStyle$delegate = LazyKt.lazy(r101, new SlcStyle$borderStyle$2(this));
        this.bgImg$delegate = LazyKt.lazy(r101, new SlcStyle$bgImg$2(this));
        this.bgColor$delegate = LazyKt.lazy(r101, new SlcStyle$bgColor$2(this));
        this.visibility$delegate = LazyKt.lazy(r101, new SlcStyle$visibility$2(this));
        this.display$delegate = LazyKt.lazy(r101, new SlcStyle$display$2(this));
        this.background$delegate = LazyKt.lazy(r101, new SlcStyle$background$2(this));
        this.fontColor$delegate = LazyKt.lazy(r101, new SlcStyle$fontColor$2(this));
        this.fontSize$delegate = LazyKt.lazy(r101, new SlcStyle$fontSize$2(this));
        this.fontWeight$delegate = LazyKt.lazy(r101, new SlcStyle$fontWeight$2(this));
        this.opacity$delegate = LazyKt.lazy(r101, new SlcStyle$opacity$2(this));
        this.fontStyle$delegate = LazyKt.lazy(r101, new SlcStyle$fontStyle$2(this));
    }

    public final int heightPx(b r100) {
        Intrinsics.checkNotNullParameter(r100, "slcDisplayMetrics");
        Object r101 = getHeight();
        if ((r101 instanceof Number) == false) goto L6;
        return SlcDimensExtensionsKt.a((Number) r101, r100);
    L6:
        if ((r101 instanceof String) == true) goto L8;
    L19:
        return -2;
    L8:
        if (Intrinsics.areEqual(r101, "auto") == true) goto L19;
        if (Intrinsics.areEqual(r101, "stretch") == false) goto L14;
    L12:
        return -1;
    L14:
        if (Intrinsics.areEqual(r101, "100%") == true) goto L12;
        Float r102 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r101);
        if (r102 == null) goto L19;
        return Math.round(SlcDimensExtensionsKt.c(r102, r100));
    }

    public final int widthPx(b r100) {
        Intrinsics.checkNotNullParameter(r100, "slcDisplayMetrics");
        Object r101 = getWidth();
        if ((r101 instanceof Number) == false) goto L6;
        return SlcDimensExtensionsKt.a((Number) r101, r100);
    L6:
        if ((r101 instanceof String) == true) goto L8;
    L19:
        return -2;
    L8:
        if (Intrinsics.areEqual(r101, "auto") == true) goto L19;
        if (Intrinsics.areEqual(r101, "stretch") == false) goto L14;
    L12:
        return -1;
    L14:
        if (Intrinsics.areEqual(r101, "100%") == true) goto L12;
        Float r102 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r101);
        if (r102 == null) goto L19;
        return Math.round(SlcDimensExtensionsKt.c(r102, r100));
    }

    public SlcStyle(String r100, String r101) {
        this(new HashMap());
        Map<String, Object> r102 = this.attrs;
        if (r102 == null) goto L7;
        Map r103 = TypeIntrinsics.asMutableMap(r102);
        r103.put("width", r100);
        r103.put("height", r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
    }

    public /* synthetic */ SlcStyle(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }

    public static final String access$getString(SlcStyle r100, Map r101, String r102) {
        r100.getClass();
        if (r101 == null) goto L5;
        Object r103 = r101.get(r102);
    L7:
        return com.bytedance.android.ecom.arch.slice.render.util.b.r(r103);
    L5:
        r103 = null;
        goto L7
    }

    public /* synthetic */ SlcStyle(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
