package F6;

import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.api.CompareOp;
import com.stepos.ame.api.LogicOp;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0005\u0005\u0006\u0007\b\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"LF6/a;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, "e", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "LF6/a$b;", "LF6/a$c;", "LF6/a$d;", "LF6/a$e;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000b\"\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LF6/a$a;", "", "<init>", "()V", "", "field", "LF6/b;", UxipConstants.f30680s, "LF6/a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;LF6/b;)LF6/a;", "", "conditions", Const.INTENT_KEY_APIKEY, "([LF6/a;)LF6/a;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: F6.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final a a(a... conditions) {
            p.i(conditions, "conditions");
            return new CompositeCondition(LogicOp.AND, r.T0(conditions));
        }

        public final a b(String field, b value) {
            p.i(field, "field");
            p.i(value, "value");
            return new ScalarEqCondition(field, value, CompareOp.EQ);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"LF6/a$b;", "LF6/a;", "Lcom/stepos/ame/api/LogicOp;", "op", "", "conditions", "<init>", "(Lcom/stepos/ame/api/LogicOp;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ame/api/LogicOp;", "()Lcom/stepos/ame/api/LogicOp;", "c", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: F6.a$b, reason: from toString */
    public static final /* data */ class CompositeCondition extends a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final LogicOp op;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<a> conditions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CompositeCondition(LogicOp op, List<? extends a> conditions) {
            super(null);
            p.i(op, "op");
            p.i(conditions, "conditions");
            this.op = op;
            this.conditions = conditions;
        }

        public final List<a> a() {
            return this.conditions;
        }

        /* renamed from: b, reason: from getter */
        public final LogicOp getOp() {
            return this.op;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CompositeCondition)) {
                return false;
            }
            CompositeCondition compositeCondition = (CompositeCondition) other;
            return this.op == compositeCondition.op && p.d(this.conditions, compositeCondition.conditions);
        }

        public int hashCode() {
            return (this.op.hashCode() * 31) + this.conditions.hashCode();
        }

        public String toString() {
            return "CompositeCondition(op=" + this.op + ", conditions=" + this.conditions + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c¨\u0006\u001d"}, d2 = {"LF6/a$c;", "LF6/a;", "", "field", "LF6/b;", UxipConstants.f30680s, "Lcom/stepos/ame/api/CompareOp;", "op", "<init>", "(Ljava/lang/String;LF6/b;Lcom/stepos/ame/api/CompareOp;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", "LF6/b;", "()LF6/b;", Const.INTENT_KEY_UMID, "Lcom/stepos/ame/api/CompareOp;", "()Lcom/stepos/ame/api/CompareOp;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: F6.a$c, reason: from toString */
    public static final /* data */ class ScalarEqCondition extends a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String field;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final b value;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final CompareOp op;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScalarEqCondition(String field, b value, CompareOp op) {
            super(null);
            p.i(field, "field");
            p.i(value, "value");
            p.i(op, "op");
            this.field = field;
            this.value = value;
            this.op = op;
        }

        /* renamed from: a, reason: from getter */
        public final String getField() {
            return this.field;
        }

        /* renamed from: b, reason: from getter */
        public final CompareOp getOp() {
            return this.op;
        }

        /* renamed from: c, reason: from getter */
        public final b getValue() {
            return this.value;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScalarEqCondition)) {
                return false;
            }
            ScalarEqCondition scalarEqCondition = (ScalarEqCondition) other;
            return p.d(this.field, scalarEqCondition.field) && p.d(this.value, scalarEqCondition.value) && this.op == scalarEqCondition.op;
        }

        public int hashCode() {
            return (((this.field.hashCode() * 31) + this.value.hashCode()) * 31) + this.op.hashCode();
        }

        public String toString() {
            return "ScalarEqCondition(field=" + this.field + ", value=" + this.value + ", op=" + this.op + ")";
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\r\u0010\u001a¨\u0006\u001c"}, d2 = {"LF6/a$d;", "LF6/a;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "field", "", "LF6/b;", "c", "Ljava/util/List;", "()Ljava/util/List;", "values", "Lcom/stepos/ame/api/CompareOp;", Const.INTENT_KEY_UMID, "Lcom/stepos/ame/api/CompareOp;", "()Lcom/stepos/ame/api/CompareOp;", "op", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: F6.a$d, reason: from toString */
    public static final /* data */ class ScalarInCondition extends a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String field;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<b> values;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final CompareOp op;

        /* renamed from: a, reason: from getter */
        public final String getField() {
            return this.field;
        }

        /* renamed from: b, reason: from getter */
        public final CompareOp getOp() {
            return this.op;
        }

        public final List<b> c() {
            return this.values;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScalarInCondition)) {
                return false;
            }
            ScalarInCondition scalarInCondition = (ScalarInCondition) other;
            return p.d(this.field, scalarInCondition.field) && p.d(this.values, scalarInCondition.values) && this.op == scalarInCondition.op;
        }

        public int hashCode() {
            return (((this.field.hashCode() * 31) + this.values.hashCode()) * 31) + this.op.hashCode();
        }

        public String toString() {
            return "ScalarInCondition(field=" + this.field + ", values=" + this.values + ", op=" + this.op + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u0012\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\r\u0010\u001a¨\u0006\u001e"}, d2 = {"LF6/a$e;", "LF6/a;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "field", "LF6/b;", "c", "LF6/b;", "e", "()LF6/b;", "minValue", Const.INTENT_KEY_UMID, "maxValue", "Z", "()Z", "includeMin", "f", "includeMax", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: F6.a$e, reason: from toString */
    public static final /* data */ class ScalarRangeCondition extends a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String field;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final b minValue;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final b maxValue;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean includeMin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean includeMax;

        /* renamed from: a, reason: from getter */
        public final String getField() {
            return this.field;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIncludeMax() {
            return this.includeMax;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIncludeMin() {
            return this.includeMin;
        }

        /* renamed from: d, reason: from getter */
        public final b getMaxValue() {
            return this.maxValue;
        }

        /* renamed from: e, reason: from getter */
        public final b getMinValue() {
            return this.minValue;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScalarRangeCondition)) {
                return false;
            }
            ScalarRangeCondition scalarRangeCondition = (ScalarRangeCondition) other;
            return p.d(this.field, scalarRangeCondition.field) && p.d(this.minValue, scalarRangeCondition.minValue) && p.d(this.maxValue, scalarRangeCondition.maxValue) && this.includeMin == scalarRangeCondition.includeMin && this.includeMax == scalarRangeCondition.includeMax;
        }

        public int hashCode() {
            int iHashCode = this.field.hashCode() * 31;
            b bVar = this.minValue;
            int iHashCode2 = (iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
            b bVar2 = this.maxValue;
            return ((((iHashCode2 + (bVar2 != null ? bVar2.hashCode() : 0)) * 31) + Boolean.hashCode(this.includeMin)) * 31) + Boolean.hashCode(this.includeMax);
        }

        public String toString() {
            return "ScalarRangeCondition(field=" + this.field + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", includeMin=" + this.includeMin + ", includeMax=" + this.includeMax + ")";
        }
    }

    public /* synthetic */ a(i iVar) {
        this();
    }

    public a() {
    }
}
