package com.bytedance.android.shopping.anchorv4.helper;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/helper/JisooResponse;", "", "", "", BdpAppEventConstant.PARAMS_OUTPUT, "Ljava/util/List;", "getOutput", "()Ljava/util/List;", "createdAt", "Ljava/lang/String;", "getCreatedAt", "()Ljava/lang/String;", "updatedAt", "b", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JisooResponse {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f166878b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PackResponseDTO f166879a;

    @SerializedName("_createdAt")
    private final String createdAt;

    @SerializedName(BdpAppEventConstant.PARAMS_OUTPUT)
    private final List<String> output;

    @SerializedName("_updatedAt")
    private final String updatedAt;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof JisooResponse) == false) goto L12;
        JisooResponse r101 = (JisooResponse) r100;
        if (Intrinsics.areEqual(this.output, r101.output) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.createdAt, r101.createdAt) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.updatedAt, r101.updatedAt) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.output;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.createdAt;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.updatedAt;
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

    public final String toString() {
        return "JisooResponse(output=" + this.output + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }

    static {
        f166878b = LazyKt.lazy(JisooResponse$Companion$parsedDTOField$2.INSTANCE);
    }

    public final PackResponseDTO a() {
        if (this.f166879a != null) goto L21;
        List<String> r100 = this.output;
        if (r100 == null) goto L21;
        if ((!r100.isEmpty()) != true) goto L21;
        String r101 = (String) CollectionsKt.getOrNull(this.output, 0);
        if (r101 == null) goto L21;
        PackParsedDTO r102 = (PackParsedDTO) u0.b(r101, PackParsedDTO.class);     // Catch: Throwable -> L18
        AnchorV4HeadV2VO r103 = r102.getHeaderV2();     // Catch: Throwable -> L18
        if (r103 == null) goto L13;
        r103.setLocalIsFromJisoo(true);     // Catch: Throwable -> L18
    L13:
        PackResponseDTO r104 = new PackResponseDTO();     // Catch: Throwable -> L18
        Field r105 = (Field) f166878b.getValue();     // Catch: Throwable -> L18
        if (r105 == null) goto L16;
        r105.set(r104, r102);     // Catch: Throwable -> L18
    L16:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L18
        this.f166879a = r104;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        ECExceptionMonitor.e(th);
    L21:
        return this.f166879a;
    }

    public JisooResponse() {
        this.output = null;
        this.createdAt = null;
        this.updatedAt = null;
    }

    public final String b() {
        return this.updatedAt;
    }
}
