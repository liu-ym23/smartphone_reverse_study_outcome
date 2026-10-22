package com.bytedance.android.shopping.anchorv4.components.topbanner;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/topbanner/HalfStrandVO;", "Ljava/io/Serializable;", "", "isShowLiveEntry", "Lcom/bytedance/android/shopping/anchorv4/components/topbanner/LiveEntryVO;", "component1", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "component2", "liveEntry", "component", "copy", "", "toString", "", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/components/topbanner/HalfStrandMeta;", "halfStrandMeta$delegate", "Lkotlin/Lazy;", "getHalfStrandMeta", "()Lcom/bytedance/android/shopping/anchorv4/components/topbanner/HalfStrandMeta;", "halfStrandMeta", "Lcom/bytedance/android/shopping/anchorv4/components/topbanner/LiveEntryVO;", "getLiveEntry", "()Lcom/bytedance/android/shopping/anchorv4/components/topbanner/LiveEntryVO;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "getComponent", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "setComponent", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/components/topbanner/LiveEntryVO;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HalfStrandVO implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private ComponentDTO f166131component;
    private final Lazy halfStrandMeta$delegate;

    @SerializedName("live_entry_vo")
    private final LiveEntryVO liveEntry;

    public static final class a {
        public a() {
        }

        public static HalfStrandVO a(ComponentDTO r100) {
            if (r100 != null) goto L14;
            return null;
        L14:
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
            VO r102 = r100.getVo();     // Catch: Throwable -> L11
            if (r102 == null) goto L8;
            JsonObject r103 = r102.getDisplay();     // Catch: Throwable -> L11
        L9:
            Object r104 = u0.a(r103, HalfStrandVO.class);     // Catch: Throwable -> L11
            ((HalfStrandVO) r104).setComponent(r100);     // Catch: Throwable -> L11
            return (HalfStrandVO) r104;
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

    /* JADX WARN: Multi-variable type inference failed */
    public HalfStrandVO() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HalfStrandVO copy$default(HalfStrandVO r100, LiveEntryVO r101, ComponentDTO r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.liveEntry;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f166131component;
    L9:
        return r100.copy(r101, r102);
    }

    public final LiveEntryVO component1() {
        return this.liveEntry;
    }

    public final ComponentDTO component2() {
        return this.f166131component;
    }

    public final HalfStrandVO copy(LiveEntryVO r100, ComponentDTO r101) {
        return new HalfStrandVO(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HalfStrandVO) == false) goto L10;
        HalfStrandVO r101 = (HalfStrandVO) r100;
        if (Intrinsics.areEqual(this.liveEntry, r101.liveEntry) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f166131component, r101.f166131component) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final HalfStrandMeta getHalfStrandMeta() {
        return (HalfStrandMeta) this.halfStrandMeta$delegate.getValue();
    }

    public int hashCode() {
        LiveEntryVO r100 = this.liveEntry;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ComponentDTO r104 = this.f166131component;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "HalfStrandVO(liveEntry=" + this.liveEntry + ", component=" + this.f166131component + ")";
    }

    public final boolean isShowLiveEntry() {
        if (this.liveEntry == null) goto L10;
        HalfStrandMeta r100 = getHalfStrandMeta();
        if (r100 == null) goto L7;
        LiveEntryMeta r101 = r100.getLiveEntry();
    L8:
        if (r101 == null) goto L10;
        return true;
    L7:
        r101 = null;
    L10:
        return false;
    }

    public final ComponentDTO getComponent() {
        return this.f166131component;
    }

    public final LiveEntryVO getLiveEntry() {
        return this.liveEntry;
    }

    public final void setComponent(ComponentDTO r100) {
        this.f166131component = r100;
    }

    public HalfStrandVO(LiveEntryVO r100, ComponentDTO r101) {
        this.liveEntry = r100;
        this.f166131component = r101;
        this.halfStrandMeta$delegate = LazyKt.lazy(new HalfStrandVO$halfStrandMeta$2(this));
    }

    public /* synthetic */ HalfStrandVO(LiveEntryVO r100, ComponentDTO r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
