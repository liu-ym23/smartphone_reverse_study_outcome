package com.bytedance.android.shopping.anchorv4.components;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreMeta;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/ShopFloatEntryVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/components/ShopFloatEntryDisplay;", "display", "Lcom/bytedance/android/shopping/anchorv4/components/ShopFloatEntryDisplay;", "getDisplay", "()Lcom/bytedance/android/shopping/anchorv4/components/ShopFloatEntryDisplay;", "setDisplay", "(Lcom/bytedance/android/shopping/anchorv4/components/ShopFloatEntryDisplay;)V", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreMeta;", "meta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreMeta;", "getMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreMeta;", "setMeta", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreMeta;)V", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "component", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "getComponent", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "setComponent", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/components/ShopFloatEntryDisplay;Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreMeta;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFloatEntryVO implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private ComponentDTO f165995component;
    private ShopFloatEntryDisplay display;
    private AnchorV4ShopAndStoreMeta meta;

    public static final class a {
        public a() {
        }

        public static ShopFloatEntryVO a(ComponentDTO r100) {
            Object r101 = null;
            if (r100 != null) goto L23;
            return null;
        L23:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
            ShopFloatEntryVO r103 = new ShopFloatEntryVO(null, null, null, 7, null);     // Catch: Throwable -> L15
            VO r104 = r100.getVo();     // Catch: Throwable -> L15
            if (r104 == null) goto L8;
            JsonObject r105 = r104.getDisplay();     // Catch: Throwable -> L15
        L9:
            r103.setDisplay((ShopFloatEntryDisplay) u0.a(r105, ShopFloatEntryDisplay.class));     // Catch: Throwable -> L15
            VO r106 = r100.getVo();     // Catch: Throwable -> L15
            if (r106 == null) goto L12;
            JsonObject r107 = r106.getMeta();     // Catch: Throwable -> L15
        L13:
            r103.setMeta((AnchorV4ShopAndStoreMeta) u0.a(r107, AnchorV4ShopAndStoreMeta.class));     // Catch: Throwable -> L15
            r103.setComponent(r100);     // Catch: Throwable -> L15
            Object r108 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L15
        L18:
            if (Result.m9455isFailureimpl(r108) == true) goto L22;
            r101 = r108;
        L22:
            return (ShopFloatEntryVO) r101;
        L12:
            r107 = null;
            goto L13
        L8:
            r105 = null;
        L15:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L18
        }
    }

    static {
        Companion = new a();
    }

    public ShopFloatEntryVO() {
        this(null, null, null, 7, null);
    }

    public final ComponentDTO getComponent() {
        return this.f165995component;
    }

    public final ShopFloatEntryDisplay getDisplay() {
        return this.display;
    }

    public final AnchorV4ShopAndStoreMeta getMeta() {
        return this.meta;
    }

    public final void setComponent(ComponentDTO r100) {
        this.f165995component = r100;
    }

    public final void setDisplay(ShopFloatEntryDisplay r100) {
        this.display = r100;
    }

    public final void setMeta(AnchorV4ShopAndStoreMeta r100) {
        this.meta = r100;
    }

    public ShopFloatEntryVO(ShopFloatEntryDisplay r100, AnchorV4ShopAndStoreMeta r101, ComponentDTO r102) {
        this.display = r100;
        this.meta = r101;
        this.f165995component = r102;
    }

    public /* synthetic */ ShopFloatEntryVO(ShopFloatEntryDisplay r100, AnchorV4ShopAndStoreMeta r101, ComponentDTO r102, int r103, DefaultConstructorMarker r104) {
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
