package Ma;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"", UxipConstants.f30680s, "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", Const.INTENT_KEY_APIKEY, "(DLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)D", "", "c", "(JLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)J", Const.INTENT_KEY_PKGNAME, "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes5.dex */
public class c {
    public static final double a(double d10, DurationUnit sourceUnit, DurationUnit targetUnit) {
        p.i(sourceUnit, "sourceUnit");
        p.i(targetUnit, "targetUnit");
        long jConvert = targetUnit.getTimeUnit().convert(1L, sourceUnit.getTimeUnit());
        return jConvert > 0 ? d10 * jConvert : d10 / sourceUnit.getTimeUnit().convert(1L, targetUnit.getTimeUnit());
    }

    public static final long b(long j10, DurationUnit sourceUnit, DurationUnit targetUnit) {
        p.i(sourceUnit, "sourceUnit");
        p.i(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j10, sourceUnit.getTimeUnit());
    }

    public static final long c(long j10, DurationUnit sourceUnit, DurationUnit targetUnit) {
        p.i(sourceUnit, "sourceUnit");
        p.i(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j10, sourceUnit.getTimeUnit());
    }
}
