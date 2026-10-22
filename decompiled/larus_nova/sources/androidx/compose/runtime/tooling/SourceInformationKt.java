package androidx.compose.runtime.tooling;

import androidx.compose.runtime.internal.Utils_androidKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\u001a\u0012\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t*\u00020\u0007H\u0002\u001a\f\u0010\u000e\u001a\u00020\u0003*\u00020\u0003H\u0002¨\u0006\u000f"}, d2 = {"parseSourceInformation", "Landroidx/compose/runtime/tooling/SourceInformation;", "data", "", "parseSourceInformationInternal", "hasSection", "", "Landroidx/compose/runtime/tooling/SourceInfoParserState;", "parseParameterIndex", "", "Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "parseParameterNames", "parseLocations", "Landroidx/compose/runtime/tooling/LocationSourceInformation;", "replaceComposePrefix", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SourceInformationKt {
    private static final boolean hasSection(SourceInfoParserState r100) {
        if (r100.getI() < (r100.getData().length() - 1)) goto L5;
    L9:
        return false;
    L5:
        if (Character.isLetter(r100.getData().charAt(r100.getI())) == false) goto L9;
        if (r100.getData().charAt(r100.getI() + 1) != '(') goto L9;
        return true;
    }

    private static final List<LocationSourceInformation> parseLocations(SourceInfoParserState r110) {
        ArrayList r100 = new ArrayList();
    L4:
        if (r110.atEnd() == true) goto L28;
        if (r110.matches(':') == true) goto L28;
        if (r110.matches('*') == false) goto L10;
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        boolean r101 = true;
    L12:
        if (r110.matches('@') == true) goto L14;
        Integer r102 = Integer.valueOf(r110.takeIntUntil("@") + 1);
    L15:
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        int r103 = r110.takeIntUntil("L,:");
        if (r110.matches(Matrix.MATRIX_TYPE_RANDOM_LT) == false) goto L18;
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        Integer r104 = Integer.valueOf(r110.takeIntUntil(",:"));
    L19:
        int r105 = -1;
        if (r102 == null) goto L22;
        int r106 = r102.intValue();
    L23:
        if (r104 == null) goto L25;
        r105 = r104.intValue();
    L25:
        r100.add(new LocationSourceInformation(r106, r103, r105, r101));
        if (r110.matches(',') == false) goto L4;
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        goto L4
    L22:
        r106 = -1;
        goto L23
    L18:
        r104 = null;
        goto L19
    L14:
        r102 = null;
        goto L15
    L10:
        r101 = false;
    L28:
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        return r100;
    }

    private static final List<ParameterSourceInformation> parseParameterIndex(SourceInfoParserState r110) {
        r110.advance(2);
        ArrayList r100 = new ArrayList();
        boolean r101 = false;
    L4:
        if (r110.atEnd() == true) goto L55;
        if (r110.matches(')') == true) goto L55;
        if (r110.matches('!') == false) goto L30;
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        String r102 = r110.takeUntil("!,)");
        if (r102.length() != 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        r101 = true;
    L53:
        if (r110.matches(',') == false) goto L4;
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        goto L4
    L15:
        int r104 = CastIntegerProtector.parseInt(r102);
        int r105 = 0;
    L16:
        if (r104 <= 0) goto L53;
        int r106 = r100.size();
        int r107 = 0;
    L18:
        if (r107 >= r106) goto L26;
        if (((ParameterSourceInformation) ListProtector.get(r100, r107)).getSortedIndex() != r105) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == true) goto L24;
        r107 = r107 + 1;
        goto L18
    L24:
        boolean r108 = true;
    L27:
        if (r108 == true) goto L28;
        r100.add(new ParameterSourceInformation(r105, null, null, 6, null));
        r104 = r104 - 1;
        goto L16
    L28:
        r105 = r105 + 1;
        goto L16
    L22:
        r111 = false;
        goto L23
    L26:
        r108 = false;
        goto L27
    L12:
        r103 = false;
        goto L13
    L30:
        int r109 = r110.takeIntUntil("!:,)");
        if (r110.matches(':') == false) goto L33;
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        String r112 = replaceComposePrefix(r110.takeUntil("!,)"));
    L34:
        if (r101 == false) goto L51;
        int r113 = 0;
    L36:
        if (r113 >= r109) goto L50;
        int r114 = r100.size();
        int r115 = 0;
    L38:
        if (r115 >= r114) goto L46;
        if (((ParameterSourceInformation) ListProtector.get(r100, r115)).getSortedIndex() != r113) goto L42;
        boolean r116 = true;
    L43:
        if (r116 == true) goto L44;
        r115 = r115 + 1;
        goto L38
    L44:
        boolean r117 = true;
    L47:
        if (r117 == true) goto L48;
        r100.add(new ParameterSourceInformation(r113, null, null, 6, null));
        goto L36
    L48:
        r113 = r113 + 1;
        goto L36
    L42:
        r116 = false;
        goto L43
    L46:
        r117 = false;
        goto L47
    L50:
        r101 = false;
    L51:
        r100.add(new ParameterSourceInformation(r109, null, r112, 2, null));
        goto L53
    L33:
        r112 = null;
    L55:
        r110.expect(')');
        SourceInfoParserState.advance$default(r110, 0, 1, null);
        return r100;
    }

    private static final List<ParameterSourceInformation> parseParameterNames(SourceInfoParserState r100) {
        r100.advance(2);
        ArrayList r101 = new ArrayList();
    L4:
        if (r100.atEnd() == true) goto L14;
        if (r100.matches(')') == true) goto L14;
        String r102 = r100.takeUntil(":,)");
        if (r100.matches(':') == false) goto L10;
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        String r103 = replaceComposePrefix(r100.takeUntil(",)"));
    L11:
        r101.add(new ParameterSourceInformation(r101.size(), r102, r103));
        if (r100.matches(',') == false) goto L4;
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        goto L4
    L10:
        r103 = null;
    L14:
        r100.expect(')');
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        return r101;
    }

    public static final SourceInformation parseSourceInformation(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L14;
        return null;
    L14:
        return parseSourceInformationInternal(r100);
    L11:
        e = move-exception;
        Utils_androidKt.logError(e.getMessage(), e);
        return null;
    L5:
        r101 = false;
        goto L7
    }

    public static final SourceInformation parseSourceInformationInternal(String r110) {
        SourceInfoParserState r100 = new SourceInfoParserState(r110);
        String r101 = null;
        if (r100.matches('C') == false) goto L13;
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        if (r100.matches('C') == false) goto L7;
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        boolean r102 = true;
    L9:
        if (r100.matches('(') == false) goto L11;
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        String r103 = r100.takeUntil(")");
        r100.expect(')');
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        String r111 = r103;
    L12:
        boolean r104 = true;
    L14:
        List<ParameterSourceInformation> r112 = CollectionsKt.emptyList();
    L16:
        if (hasSection(r100) == false) goto L40;
        char r105 = r100.current();
        if (r105 != 'N') goto L20;
        r112 = parseParameterNames(r100);
        goto L16
    L20:
        if (r105 != 'P') goto L21;
        r112 = parseParameterIndex(r100);
        goto L16
    L21:
        r100.advance(2);
        int r106 = 0;
    L22:
        if (r106 > 0) goto L28;
        if (r100.matches(')') == false) goto L28;
        r100.expect(')');
        SourceInfoParserState.advance$default(r100, 0, 1, null);
    L28:
        if (r100.atEnd() == true) goto L36;
        if (r100.matches('(') == false) goto L33;
        r106 = r106 + 1;
    L35:
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        goto L22
    L33:
        if (r100.matches(')') == false) goto L35;
        r106 = r106 - 1;
        goto L35
    L36:
        r100.throwParseError("unexpected end");
        throw new KotlinNothingValueException();
    L40:
        List<LocationSourceInformation> r107 = CollectionsKt.emptyList();
        if (r100.matches(':') == true) goto L43;
        r107 = parseLocations(r100);
    L44:
        List<LocationSourceInformation> r113 = r107;
        String r108 = r100.takeUntil("#");
        if (r108.length() <= 0) goto L47;
        boolean r109 = true;
    L48:
        if (r109 == false) goto L50;
        String r114 = r108;
    L52:
        if (r100.matches('#') == false) goto L55;
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        r101 = r100.takeUntilEnd();
    L55:
        return new SourceInformation(r104, r102, r111, r114, r112, r101, r113, r110);
    L50:
        r114 = null;
        goto L52
    L47:
        r109 = false;
        goto L48
    L43:
        SourceInfoParserState.advance$default(r100, 0, 1, null);
        goto L44
    L11:
        r111 = null;
        goto L12
    L7:
        r102 = false;
        goto L9
    L13:
        r111 = null;
        r104 = false;
        r102 = false;
        goto L14
    }

    private static final String replaceComposePrefix(String r100) {
        return StringsKt.replaceFirst$default(r100, "c#", "androidx.compose.", false, 4, null);
    }
}
