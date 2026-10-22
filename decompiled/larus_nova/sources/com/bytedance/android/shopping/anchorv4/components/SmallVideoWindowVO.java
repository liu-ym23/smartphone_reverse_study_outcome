package com.bytedance.android.shopping.anchorv4.components;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.anchorv3.VideoModelStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001(B9\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b%\u0010&J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0019\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J;\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/SmallVideoWindowVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/response/anchorv3/VideoModelStruct;", "component1", "", "", "", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "component3", "videoModel", "videoTrackMeta", "component", "copy", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/shopping/anchorv4/components/SmallVideoWindowMeta;", "smallVideoWindowMeta$delegate", "Lkotlin/Lazy;", "getSmallVideoWindowMeta", "()Lcom/bytedance/android/shopping/anchorv4/components/SmallVideoWindowMeta;", "smallVideoWindowMeta", "Lcom/bytedance/android/ec/model/response/anchorv3/VideoModelStruct;", "getVideoModel", "()Lcom/bytedance/android/ec/model/response/anchorv3/VideoModelStruct;", "Ljava/util/Map;", "getVideoTrackMeta", "()Ljava/util/Map;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "getComponent", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "setComponent", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "<init>", "(Lcom/bytedance/android/ec/model/response/anchorv3/VideoModelStruct;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmallVideoWindowVO implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private ComponentDTO f165996component;
    private final Lazy smallVideoWindowMeta$delegate;

    @SerializedName("video")
    private final VideoModelStruct videoModel;

    @SerializedName("video_track_meta")
    private final Map<String, Object> videoTrackMeta;

    public static final class a {
        public a() {
        }

        public static SmallVideoWindowVO a(ComponentDTO r100) {
            if (r100 == null) goto L25;
            int r101 = ECSdk.f48106a;
            IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
            boolean r103 = true;
            if (r102 == null) goto L12;
            com.bytedance.android.ec.adapter.api.j r104 = r102.getLiveWindowService();
            if (r104 == null) goto L12;
            if (r104.checkWindowConflict() != true) goto L12;
            r103 = false;
        L12:
            if (r103 == false) goto L14;
            ComponentDTO r105 = r100;
        L15:
            if (r105 == null) goto L25;
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L23
            VO r107 = r100.getVo();     // Catch: Throwable -> L23
            if (r107 == null) goto L20;
            JsonObject r108 = r107.getDisplay();     // Catch: Throwable -> L23
        L21:
            Object r109 = u0.a(r108, SmallVideoWindowVO.class);     // Catch: Throwable -> L23
            ((SmallVideoWindowVO) r109).setComponent(r100);     // Catch: Throwable -> L23
            return (SmallVideoWindowVO) r109;
        L20:
            r108 = null;
        L23:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L25
        L14:
            r105 = null;
        L25:
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public SmallVideoWindowVO() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SmallVideoWindowVO copy$default(SmallVideoWindowVO r100, VideoModelStruct r101, Map r102, ComponentDTO r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.videoModel;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.videoTrackMeta;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.f165996component;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final VideoModelStruct component1() {
        return this.videoModel;
    }

    public final Map<String, Object> component2() {
        return this.videoTrackMeta;
    }

    public final ComponentDTO component3() {
        return this.f165996component;
    }

    public final SmallVideoWindowVO copy(VideoModelStruct r100, Map<String, ? extends Object> r101, ComponentDTO r102) {
        return new SmallVideoWindowVO(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SmallVideoWindowVO) == false) goto L12;
        SmallVideoWindowVO r101 = (SmallVideoWindowVO) r100;
        if (Intrinsics.areEqual(this.videoModel, r101.videoModel) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.videoTrackMeta, r101.videoTrackMeta) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f165996component, r101.f165996component) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final SmallVideoWindowMeta getSmallVideoWindowMeta() {
        return (SmallVideoWindowMeta) this.smallVideoWindowMeta$delegate.getValue();
    }

    public int hashCode() {
        VideoModelStruct r100 = this.videoModel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.videoTrackMeta;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentDTO r107 = this.f165996component;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SmallVideoWindowVO(videoModel=" + this.videoModel + ", videoTrackMeta=" + this.videoTrackMeta + ", component=" + this.f165996component + ")";
    }

    public final ComponentDTO getComponent() {
        return this.f165996component;
    }

    public final VideoModelStruct getVideoModel() {
        return this.videoModel;
    }

    public final Map<String, Object> getVideoTrackMeta() {
        return this.videoTrackMeta;
    }

    public final void setComponent(ComponentDTO r100) {
        this.f165996component = r100;
    }

    public SmallVideoWindowVO(VideoModelStruct r100, Map<String, ? extends Object> r101, ComponentDTO r102) {
        this.videoModel = r100;
        this.videoTrackMeta = r101;
        this.f165996component = r102;
        this.smallVideoWindowMeta$delegate = LazyKt.lazy(new SmallVideoWindowVO$smallVideoWindowMeta$2(this));
    }

    public /* synthetic */ SmallVideoWindowVO(VideoModelStruct r100, Map r101, ComponentDTO r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
