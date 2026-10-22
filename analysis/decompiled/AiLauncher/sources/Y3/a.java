package Y3;

import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "LY3/b;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", "sdk_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    public static final List<AbilityMetaDataInfo> a(List<AbilityMetadataParcelable> list) {
        p.i(list, "<this>");
        List<AbilityMetadataParcelable> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (AbilityMetadataParcelable abilityMetadataParcelable : list2) {
            arrayList.add(new AbilityMetaDataInfo(abilityMetadataParcelable.getToolName(), abilityMetadataParcelable.getDescription(), abilityMetadataParcelable.getInputSchema(), abilityMetadataParcelable.getPackageName()));
        }
        return arrayList;
    }
}
