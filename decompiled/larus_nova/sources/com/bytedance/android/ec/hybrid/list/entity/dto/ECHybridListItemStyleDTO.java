package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListItemStyleDTO;", "Ljava/io/Serializable;", "", "borderRadius", "Ljava/lang/Double;", "getBorderRadius", "()Ljava/lang/Double;", "", "", "borderRadiusList", "Ljava/util/List;", "getBorderRadiusList", "()Ljava/util/List;", "", "borderRadiusListMaxIndex", "Ljava/lang/Integer;", "getBorderRadiusListMaxIndex", "()Ljava/lang/Integer;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridListItemStyleDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("border_radius")
    private final Double borderRadius;

    @SerializedName("border_radius_list")
    private final List<Float> borderRadiusList;

    @SerializedName("border_radius_list_max_index")
    private final Integer borderRadiusListMaxIndex;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECHybridListItemStyleDTO() {
    }

    public final Double getBorderRadius() {
        return this.borderRadius;
    }

    public final List<Float> getBorderRadiusList() {
        return this.borderRadiusList;
    }

    public final Integer getBorderRadiusListMaxIndex() {
        return this.borderRadiusListMaxIndex;
    }
}
