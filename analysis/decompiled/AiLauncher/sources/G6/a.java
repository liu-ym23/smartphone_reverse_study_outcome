package G6;

import F6.a;
import F6.b;
import Y8.t;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.ame.api.CompareOp;
import com.stepos.ame.api.LogicOp;
import com.stepos.core.ability.converter.BundleContentBridge;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\b\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\u000b\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000e\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0011\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a#\u0010\u001b\u001a\u00060\u0004j\u0002`\u0005*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u001d\u001a\u00060\u0004j\u0002`\u0005*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001c\u001a\u001f\u0010\u0006\u001a\u00020\u0007*\u00060\u0004j\u0002`\u00052\u0006\u0010\u001e\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u001f¨\u0006 "}, d2 = {"LF6/a;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LF6/a;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "c", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/StringBuilder;LF6/a;)V", "LF6/a$e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/StringBuilder;LF6/a$e;)V", "LF6/a$c;", "f", "(Ljava/lang/StringBuilder;LF6/a$c;)V", "LF6/a$d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/StringBuilder;LF6/a$d;)V", "LF6/a$b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/StringBuilder;LF6/a$b;)V", "LF6/b;", "v", BundleContentBridge.KEY_ROLE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LF6/b;Ljava/lang/String;)V", "e", "(Ljava/lang/StringBuilder;LF6/b;)Ljava/lang/StringBuilder;", Const.INTENT_KEY_UMID, "s", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "vector_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: G6.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0038a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2812a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f2813b;

        static {
            int[] iArr = new int[CompareOp.values().length];
            try {
                iArr[CompareOp.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CompareOp.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CompareOp.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CompareOp.NOT_IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f2812a = iArr;
            int[] iArr2 = new int[LogicOp.values().length];
            try {
                iArr2[LogicOp.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[LogicOp.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[LogicOp.NOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f2813b = iArr2;
        }
    }

    public static final void a(StringBuilder sb2, a.CompositeCondition compositeCondition) {
        String str;
        int i10 = C0038a.f2813b[compositeCondition.getOp().ordinal()];
        if (i10 == 1) {
            str = "and";
        } else if (i10 == 2) {
            str = "or";
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "not";
        }
        if (compositeCondition.getOp() == LogicOp.NOT) {
            if (compositeCondition.a().size() != 1) {
                throw new IllegalArgumentException("composite NOT 必须恰好包含 1 个子条件");
            }
        } else if (compositeCondition.a().isEmpty()) {
            throw new IllegalArgumentException("composite " + str + " 的 conditions 不能为空");
        }
        sb2.append("{\"type\":\"composite\",\"op\":");
        c(sb2, str);
        sb2.append(",\"conditions\":[");
        int i11 = 0;
        for (Object obj : compositeCondition.a()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            F6.a aVar = (F6.a) obj;
            if (i11 > 0) {
                sb2.append(',');
            }
            b(sb2, aVar);
            i11 = i12;
        }
        sb2.append("]}");
    }

    public static final void b(StringBuilder sb2, F6.a aVar) {
        if (aVar instanceof a.ScalarRangeCondition) {
            h(sb2, (a.ScalarRangeCondition) aVar);
            return;
        }
        if (aVar instanceof a.ScalarEqCondition) {
            f(sb2, (a.ScalarEqCondition) aVar);
        } else if (aVar instanceof a.ScalarInCondition) {
            g(sb2, (a.ScalarInCondition) aVar);
        } else {
            if (!(aVar instanceof a.CompositeCondition)) {
                throw new NoWhenBranchMatchedException();
            }
            a(sb2, (a.CompositeCondition) aVar);
        }
    }

    public static final void c(StringBuilder sb2, String str) {
        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        sb2.append("\\b");
                        break;
                    case '\t':
                        sb2.append("\\t");
                        break;
                    case '\n':
                        sb2.append("\\n");
                        break;
                    default:
                        if (cCharAt < ' ') {
                            String str2 = String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(cCharAt)}, 1));
                            p.h(str2, "format(...)");
                            sb2.append(str2);
                            break;
                        } else {
                            sb2.append(cCharAt);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    public static final StringBuilder d(StringBuilder sb2, b bVar) {
        if (bVar instanceof b.BoolValue) {
            sb2.append(((b.BoolValue) bVar).getValue() ? "true" : "false");
            return sb2;
        }
        if (bVar instanceof b.StringValue) {
            c(sb2, ((b.StringValue) bVar).getValue());
            t tVar = t.f7040a;
            return sb2;
        }
        if (bVar instanceof b.Int32Value) {
            sb2.append(((b.Int32Value) bVar).getValue());
            return sb2;
        }
        if (bVar instanceof b.Int64Value) {
            sb2.append(((b.Int64Value) bVar).getValue());
            return sb2;
        }
        if (!(bVar instanceof b.FloatValue)) {
            throw new NoWhenBranchMatchedException();
        }
        sb2.append(((b.FloatValue) bVar).getValue());
        return sb2;
    }

    public static final StringBuilder e(StringBuilder sb2, b bVar) {
        if (bVar instanceof b.Int32Value) {
            sb2.append(((b.Int32Value) bVar).getValue());
            return sb2;
        }
        if (bVar instanceof b.Int64Value) {
            sb2.append(((b.Int64Value) bVar).getValue());
            return sb2;
        }
        if (!(bVar instanceof b.FloatValue)) {
            throw new IllegalArgumentException("expected numeric MetadataValue");
        }
        sb2.append(((b.FloatValue) bVar).getValue());
        return sb2;
    }

    public static final void f(StringBuilder sb2, a.ScalarEqCondition scalarEqCondition) {
        int i10 = C0038a.f2812a[scalarEqCondition.getOp().ordinal()];
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("scalar_eq 的 filter_json 仅支持 EQ/NE，当前 op=" + scalarEqCondition.getOp() + "；请改用其它条件类型或手写 JSON");
        }
        sb2.append("{\"type\":\"scalar_eq\",\"field\":");
        c(sb2, scalarEqCondition.getField());
        sb2.append(",\"value\":");
        d(sb2, scalarEqCondition.getValue());
        if (scalarEqCondition.getOp() == CompareOp.NE) {
            sb2.append(",\"op\":\"ne\"");
        }
        sb2.append('}');
    }

    public static final void g(StringBuilder sb2, a.ScalarInCondition scalarInCondition) {
        int i10 = C0038a.f2812a[scalarInCondition.getOp().ordinal()];
        if (i10 != 3 && i10 != 4) {
            throw new IllegalArgumentException("scalar_in 的 filter_json 仅支持 IN/NOT_IN，当前 op=" + scalarInCondition.getOp());
        }
        if (scalarInCondition.c().isEmpty()) {
            throw new IllegalArgumentException("scalar_in 的 values 不能为空（与引擎解析一致）");
        }
        sb2.append("{\"type\":\"scalar_in\",\"field\":");
        c(sb2, scalarInCondition.getField());
        sb2.append(",\"values\":[");
        int i11 = 0;
        for (Object obj : scalarInCondition.c()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            b bVar = (b) obj;
            if (i11 > 0) {
                sb2.append(',');
            }
            d(sb2, bVar);
            i11 = i12;
        }
        sb2.append(']');
        if (scalarInCondition.getOp() == CompareOp.NOT_IN) {
            sb2.append(",\"op\":\"not_in\"");
        }
        sb2.append('}');
    }

    public static final void h(StringBuilder sb2, a.ScalarRangeCondition scalarRangeCondition) {
        b minValue = scalarRangeCondition.getMinValue();
        if (minValue == null) {
            throw new IllegalArgumentException("scalar_range 的 minValue 不能为 null（引擎 JSON 要求 min/max 均为数字）");
        }
        b maxValue = scalarRangeCondition.getMaxValue();
        if (maxValue == null) {
            throw new IllegalArgumentException("scalar_range 的 maxValue 不能为 null（引擎 JSON 要求 min/max 均为数字）");
        }
        i(minValue, "min");
        i(maxValue, "max");
        sb2.append("{\"type\":\"scalar_range\",\"field\":");
        c(sb2, scalarRangeCondition.getField());
        sb2.append(",\"min\":");
        p.h(sb2, "append(...)");
        StringBuilder sbE = e(sb2, minValue);
        sbE.append(",\"max\":");
        p.h(sbE, "append(...)");
        e(sbE, maxValue);
        if (!scalarRangeCondition.getIncludeMin()) {
            sb2.append(",\"include_min\":false");
        }
        if (!scalarRangeCondition.getIncludeMax()) {
            sb2.append(",\"include_max\":false");
        }
        sb2.append('}');
    }

    public static final void i(b bVar, String str) {
        if ((bVar instanceof b.Int32Value) || (bVar instanceof b.Int64Value) || (bVar instanceof b.FloatValue)) {
            return;
        }
        throw new IllegalArgumentException("scalar_range 的 " + str + " 须为数值类型，当前为 " + kotlin.jvm.internal.t.b(bVar.getClass()).t());
    }

    public static final String j(F6.a aVar) {
        p.i(aVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        b(sb2, aVar);
        return sb2.toString();
    }
}
