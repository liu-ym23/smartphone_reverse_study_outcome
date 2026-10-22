package qb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.JsonDecodingException;
import mb.C4931a;
import pb.T;
import rb.L;
import rb.O;

@Metadata(d1 = {"\u0000\\\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u001a\u0010\u0017\u001a\u00020\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0015\u0010\u001e\u001a\u00020\u001b*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0017\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010!\"\u0015\u0010$\u001a\u00020\u0010*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b#\u0010\u0012\"\u0017\u0010'\u001a\u0004\u0018\u00010\u0010*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0015\u0010+\u001a\u00020(*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0015\u0010/\u001a\u00020,*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0017\u00102\u001a\u0004\u0018\u00010\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0017\u00105\u001a\u0004\u0018\u00010\b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"", UxipConstants.f30680s, "Lqb/F;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Boolean;)Lqb/F;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Number;)Lqb/F;", "", "c", "(Ljava/lang/String;)Lqb/F;", "Lqb/i;", "element", "", Const.INTENT_KEY_UMID, "(Lqb/i;Ljava/lang/String;)Ljava/lang/Void;", "", "o", "(Lqb/F;)J", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "l", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "jsonUnquotedLiteralDescriptor", "k", "(Lqb/i;)Lqb/F;", "jsonPrimitive", "Lqb/D;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lqb/i;)Lqb/D;", "jsonObject", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lqb/F;)Ljava/lang/Integer;", "intOrNull", "m", "long", "n", "(Lqb/F;)Ljava/lang/Long;", "longOrNull", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lqb/F;)D", "double", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lqb/F;)F", "float", "e", "(Lqb/F;)Ljava/lang/Boolean;", "booleanOrNull", "f", "(Lqb/F;)Ljava/lang/String;", "contentOrNull", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptor f38673a = T.a("kotlinx.serialization.json.JsonUnquotedLiteral", C4931a.H(kotlin.jvm.internal.y.f34840a));

    public static final F a(Boolean bool) {
        return bool == null ? C5168A.INSTANCE : new w(bool, false, null, 4, null);
    }

    public static final F b(Number number) {
        return number == null ? C5168A.INSTANCE : new w(number, false, null, 4, null);
    }

    public static final F c(String str) {
        return str == null ? C5168A.INSTANCE : new w(str, true, null, 4, null);
    }

    public static final Void d(i iVar, String str) {
        throw new IllegalArgumentException("Element " + kotlin.jvm.internal.t.b(iVar.getClass()) + " is not a " + str);
    }

    public static final Boolean e(F f10) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        return O.d(f10.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
    }

    public static final String f(F f10) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        if (f10 instanceof C5168A) {
            return null;
        }
        return f10.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String();
    }

    public static final double g(F f10) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        return Double.parseDouble(f10.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
    }

    public static final float h(F f10) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        return Float.parseFloat(f10.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String());
    }

    public static final Integer i(F f10) {
        Long lValueOf;
        kotlin.jvm.internal.p.i(f10, "<this>");
        try {
            lValueOf = Long.valueOf(o(f10));
        } catch (JsonDecodingException unused) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            long jLongValue = lValueOf.longValue();
            if (-2147483648L <= jLongValue && jLongValue <= 2147483647L) {
                return Integer.valueOf((int) jLongValue);
            }
        }
        return null;
    }

    public static final D j(i iVar) {
        kotlin.jvm.internal.p.i(iVar, "<this>");
        D d10 = iVar instanceof D ? (D) iVar : null;
        if (d10 != null) {
            return d10;
        }
        d(iVar, "JsonObject");
        throw new KotlinNothingValueException();
    }

    public static final F k(i iVar) {
        kotlin.jvm.internal.p.i(iVar, "<this>");
        F f10 = iVar instanceof F ? (F) iVar : null;
        if (f10 != null) {
            return f10;
        }
        d(iVar, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final SerialDescriptor l() {
        return f38673a;
    }

    public static final long m(F f10) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        try {
            return o(f10);
        } catch (JsonDecodingException e10) {
            throw new NumberFormatException(e10.getMessage());
        }
    }

    public static final Long n(F f10) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        try {
            return Long.valueOf(o(f10));
        } catch (JsonDecodingException unused) {
            return null;
        }
    }

    public static final long o(F f10) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        return new L(f10.getCom.stepos.ame.sdk.SkillStoreKt.SKILL_DOC_TYPE_CONTENT java.lang.String()).p();
    }
}
