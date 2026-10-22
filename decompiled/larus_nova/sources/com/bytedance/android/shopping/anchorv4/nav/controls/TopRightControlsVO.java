package com.bytedance.android.shopping.anchorv4.nav.controls;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001.B=\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J?\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\t\u0010\u0011\u001a\u00020\nHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b \u0010\u001fR$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/nav/controls/TopRightControlsVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/nav/controls/TopRightControlsMeta;", "getTopRightMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "component1", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "component3", "", "", "component4", "lightElements", "darkElements", "component", "showExtraElement", "copy", "toString", "", "hashCode", "", "other", "", "equals", "topRightControlsMeta$delegate", "Lkotlin/Lazy;", "getTopRightControlsMeta", "()Lcom/bytedance/android/shopping/anchorv4/nav/controls/TopRightControlsMeta;", "topRightControlsMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getLightElements", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getDarkElements", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "getComponent", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "setComponent", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "Ljava/util/List;", "getShowExtraElement", "()Ljava/util/List;", "setShowExtraElement", "(Ljava/util/List;)V", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopRightControlsVO implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private ComponentDTO f167135component;

    @SerializedName("dark_elements")
    private final TagsScrollBoxComponent darkElements;

    @SerializedName("light_elements")
    private final TagsScrollBoxComponent lightElements;
    private List<String> showExtraElement;
    private final Lazy topRightControlsMeta$delegate;

    public static final class a {
        public a() {
        }

        public static TopRightControlsVO a(ComponentDTO r100) {
            if (r100 != null) goto L14;
            return null;
        L14:
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
            VO r102 = r100.getVo();     // Catch: Throwable -> L11
            if (r102 == null) goto L8;
            JsonObject r103 = r102.getDisplay();     // Catch: Throwable -> L11
        L9:
            Object r104 = u0.a(r103, TopRightControlsVO.class);     // Catch: Throwable -> L11
            ((TopRightControlsVO) r104).setComponent(r100);     // Catch: Throwable -> L11
            return (TopRightControlsVO) r104;
        L8:
            r103 = null;
        L11:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public TopRightControlsVO() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TopRightControlsVO copy$default(TopRightControlsVO r100, TagsScrollBoxComponent r101, TagsScrollBoxComponent r102, ComponentDTO r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.lightElements;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.darkElements;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f167135component;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.showExtraElement;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final TagsScrollBoxComponent component1() {
        return this.lightElements;
    }

    public final TagsScrollBoxComponent component2() {
        return this.darkElements;
    }

    public final ComponentDTO component3() {
        return this.f167135component;
    }

    public final List<String> component4() {
        return this.showExtraElement;
    }

    public final TopRightControlsVO copy(TagsScrollBoxComponent r100, TagsScrollBoxComponent r101, ComponentDTO r102, List<String> r103) {
        return new TopRightControlsVO(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TopRightControlsVO) == false) goto L14;
        TopRightControlsVO r101 = (TopRightControlsVO) r100;
        if (Intrinsics.areEqual(this.lightElements, r101.lightElements) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.darkElements, r101.darkElements) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167135component, r101.f167135component) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showExtraElement, r101.showExtraElement) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final TopRightControlsMeta getTopRightControlsMeta() {
        return (TopRightControlsMeta) this.topRightControlsMeta$delegate.getValue();
    }

    public int hashCode() {
        TagsScrollBoxComponent r100 = this.lightElements;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TagsScrollBoxComponent r104 = this.darkElements;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentDTO r107 = this.f167135component;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.showExtraElement;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TopRightControlsVO(lightElements=" + this.lightElements + ", darkElements=" + this.darkElements + ", component=" + this.f167135component + ", showExtraElement=" + this.showExtraElement + ")";
    }

    public final TopRightControlsMeta getTopRightMeta() {
        return getTopRightControlsMeta();
    }

    public final ComponentDTO getComponent() {
        return this.f167135component;
    }

    public final TagsScrollBoxComponent getDarkElements() {
        return this.darkElements;
    }

    public final TagsScrollBoxComponent getLightElements() {
        return this.lightElements;
    }

    public final List<String> getShowExtraElement() {
        return this.showExtraElement;
    }

    public final void setComponent(ComponentDTO r100) {
        this.f167135component = r100;
    }

    public final void setShowExtraElement(List<String> r100) {
        this.showExtraElement = r100;
    }

    public TopRightControlsVO(TagsScrollBoxComponent r100, TagsScrollBoxComponent r101, ComponentDTO r102, List<String> r103) {
        this.lightElements = r100;
        this.darkElements = r101;
        this.f167135component = r102;
        this.showExtraElement = r103;
        this.topRightControlsMeta$delegate = LazyKt.lazy(new TopRightControlsVO$topRightControlsMeta$2(this));
    }

    public /* synthetic */ TopRightControlsVO(TagsScrollBoxComponent r100, TagsScrollBoxComponent r101, ComponentDTO r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
