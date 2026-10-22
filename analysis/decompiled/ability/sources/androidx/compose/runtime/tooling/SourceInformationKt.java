package androidx.compose.runtime.tooling;

import androidx.compose.runtime.internal.Utils_androidKt;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import j9.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\u001a\u0012\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t*\u00020\u0007H\u0002\u001a\f\u0010\u000e\u001a\u00020\u0003*\u00020\u0003H\u0002¨\u0006\u000f"}, d2 = {"parseSourceInformation", "Landroidx/compose/runtime/tooling/SourceInformation;", SettingsConfig.KEY_DATA, "", "parseSourceInformationInternal", "hasSection", "", "Landroidx/compose/runtime/tooling/SourceInfoParserState;", "parseParameterIndex", "", "Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "parseParameterNames", "parseLocations", "Landroidx/compose/runtime/tooling/LocationSourceInformation;", "replaceComposePrefix", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SourceInformationKt {
    private static final boolean hasSection(SourceInfoParserState sourceInfoParserState) {
        return sourceInfoParserState.getI() < sourceInfoParserState.getData().length() - 1 && Character.isLetter(sourceInfoParserState.getData().charAt(sourceInfoParserState.getI())) && sourceInfoParserState.getData().charAt(sourceInfoParserState.getI() + 1) == '(';
    }

    private static final List<LocationSourceInformation> parseLocations(SourceInfoParserState sourceInfoParserState) throws ParseException {
        boolean z10;
        Integer numValueOf;
        ArrayList arrayList = new ArrayList();
        while (!sourceInfoParserState.atEnd() && !sourceInfoParserState.matches(':')) {
            if (sourceInfoParserState.matches('*')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                z10 = true;
            } else {
                z10 = false;
            }
            Integer numValueOf2 = !sourceInfoParserState.matches('@') ? Integer.valueOf(sourceInfoParserState.takeIntUntil("@") + 1) : null;
            SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            int iTakeIntUntil = sourceInfoParserState.takeIntUntil("L,:");
            if (sourceInfoParserState.matches('L')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                numValueOf = Integer.valueOf(sourceInfoParserState.takeIntUntil(",:"));
            } else {
                numValueOf = null;
            }
            arrayList.add(new LocationSourceInformation(numValueOf2 != null ? numValueOf2.intValue() : -1, iTakeIntUntil, numValueOf != null ? numValueOf.intValue() : -1, z10));
            if (sourceInfoParserState.matches(',')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            }
        }
        SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
        return arrayList;
    }

    private static final List<ParameterSourceInformation> parseParameterIndex(SourceInfoParserState sourceInfoParserState) throws ParseException, NumberFormatException {
        String strReplaceComposePrefix;
        sourceInfoParserState.advance(2);
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        while (!sourceInfoParserState.atEnd() && !sourceInfoParserState.matches(')')) {
            if (sourceInfoParserState.matches('!')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                String strTakeUntil = sourceInfoParserState.takeUntil("!,)");
                if (strTakeUntil.length() != 0) {
                    int i = Integer.parseInt(strTakeUntil);
                    int i6 = 0;
                    while (i > 0) {
                        int size = arrayList.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size) {
                                arrayList.add(new ParameterSourceInformation(i6, null, null, 6, null));
                                i--;
                                break;
                            }
                            if (((ParameterSourceInformation) arrayList.get(i10)).getSortedIndex() == i6) {
                                i6++;
                                break;
                            }
                            i10++;
                        }
                    }
                } else {
                    z10 = true;
                }
            } else {
                int iTakeIntUntil = sourceInfoParserState.takeIntUntil("!:,)");
                if (sourceInfoParserState.matches(':')) {
                    SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                    strReplaceComposePrefix = replaceComposePrefix(sourceInfoParserState.takeUntil("!,)"));
                } else {
                    strReplaceComposePrefix = null;
                }
                if (z10) {
                    int i11 = 0;
                    while (i11 < iTakeIntUntil) {
                        int size2 = arrayList.size();
                        int i12 = 0;
                        while (true) {
                            if (i12 >= size2) {
                                arrayList.add(new ParameterSourceInformation(i11, null, null, 6, null));
                                break;
                            }
                            if (((ParameterSourceInformation) arrayList.get(i12)).getSortedIndex() == i11) {
                                i11++;
                                break;
                            }
                            i12++;
                        }
                    }
                    z10 = false;
                }
                arrayList.add(new ParameterSourceInformation(iTakeIntUntil, null, strReplaceComposePrefix, 2, null));
            }
            if (sourceInfoParserState.matches(',')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            }
        }
        sourceInfoParserState.expect(')');
        SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
        return arrayList;
    }

    private static final List<ParameterSourceInformation> parseParameterNames(SourceInfoParserState sourceInfoParserState) throws ParseException {
        String strReplaceComposePrefix;
        sourceInfoParserState.advance(2);
        ArrayList arrayList = new ArrayList();
        while (!sourceInfoParserState.atEnd() && !sourceInfoParserState.matches(')')) {
            String strTakeUntil = sourceInfoParserState.takeUntil(":,)");
            if (sourceInfoParserState.matches(':')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
                strReplaceComposePrefix = replaceComposePrefix(sourceInfoParserState.takeUntil(",)"));
            } else {
                strReplaceComposePrefix = null;
            }
            arrayList.add(new ParameterSourceInformation(arrayList.size(), strTakeUntil, strReplaceComposePrefix));
            if (sourceInfoParserState.matches(',')) {
                SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
            }
        }
        sourceInfoParserState.expect(')');
        SourceInfoParserState.advance$default(sourceInfoParserState, 0, 1, null);
        return arrayList;
    }

    @ComposeToolingApi
    public static final SourceInformation parseSourceInformation(String str) {
        if (str.length() == 0) {
            return null;
        }
        try {
            return parseSourceInformationInternal(str);
        } catch (ParseException e) {
            Utils_androidKt.logError(e.getMessage(), e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.runtime.tooling.SourceInformation parseSourceInformationInternal(java.lang.String r13) throws androidx.compose.runtime.tooling.ParseException, java.lang.NumberFormatException {
        /*
            androidx.compose.runtime.tooling.SourceInfoParserState r0 = new androidx.compose.runtime.tooling.SourceInfoParserState
            r0.<init>(r13)
            r1 = 67
            boolean r2 = r0.matches(r1)
            r3 = 40
            r4 = 41
            r5 = 1
            r6 = 0
            r7 = 0
            if (r2 == 0) goto L3d
            androidx.compose.runtime.tooling.SourceInfoParserState.advance$default(r0, r6, r5, r7)
            boolean r1 = r0.matches(r1)
            if (r1 == 0) goto L22
            androidx.compose.runtime.tooling.SourceInfoParserState.advance$default(r0, r6, r5, r7)
            r1 = r5
            goto L23
        L22:
            r1 = r6
        L23:
            boolean r2 = r0.matches(r3)
            if (r2 == 0) goto L3a
            androidx.compose.runtime.tooling.SourceInfoParserState.advance$default(r0, r6, r5, r7)
            java.lang.String r2 = ")"
            java.lang.String r2 = r0.takeUntil(r2)
            r0.expect(r4)
            androidx.compose.runtime.tooling.SourceInfoParserState.advance$default(r0, r6, r5, r7)
            r8 = r5
            goto L40
        L3a:
            r8 = r5
        L3b:
            r2 = r7
            goto L40
        L3d:
            r1 = r6
            r8 = r1
            goto L3b
        L40:
            kotlin.collections.EmptyList r10 = kotlin.collections.EmptyList.f4893a
        L42:
            boolean r11 = hasSection(r0)
            if (r11 == 0) goto L9a
            char r11 = r0.current()
            r12 = 78
            if (r11 == r12) goto L95
            r12 = 80
            if (r11 == r12) goto L90
            r11 = 2
            r0.advance(r11)
            r11 = r6
        L59:
            if (r11 > 0) goto L69
            boolean r12 = r0.matches(r4)
            if (r12 != 0) goto L62
            goto L69
        L62:
            r0.expect(r4)
            androidx.compose.runtime.tooling.SourceInfoParserState.advance$default(r0, r6, r5, r7)
            goto L42
        L69:
            boolean r12 = r0.atEnd()
            if (r12 != 0) goto L84
            boolean r12 = r0.matches(r3)
            if (r12 == 0) goto L78
            int r11 = r11 + 1
            goto L80
        L78:
            boolean r12 = r0.matches(r4)
            if (r12 == 0) goto L80
            int r11 = r11 + (-1)
        L80:
            androidx.compose.runtime.tooling.SourceInfoParserState.advance$default(r0, r6, r5, r7)
            goto L59
        L84:
            java.lang.String r1 = "unexpected end"
            r0.throwParseError(r1)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L90:
            java.util.List r10 = parseParameterIndex(r0)
            goto L42
        L95:
            java.util.List r10 = parseParameterNames(r0)
            goto L42
        L9a:
            kotlin.collections.EmptyList r3 = kotlin.collections.EmptyList.f4893a
            r4 = 58
            boolean r4 = r0.matches(r4)
            if (r4 != 0) goto La9
            java.util.List r3 = parseLocations(r0)
            goto Lac
        La9:
            androidx.compose.runtime.tooling.SourceInfoParserState.advance$default(r0, r6, r5, r7)
        Lac:
            java.lang.String r4 = "#"
            java.lang.String r4 = r0.takeUntil(r4)
            int r11 = r4.length()
            if (r11 <= 0) goto Lb9
            goto Lba
        Lb9:
            r4 = r7
        Lba:
            r11 = 35
            boolean r11 = r0.matches(r11)
            if (r11 == 0) goto Lc9
            androidx.compose.runtime.tooling.SourceInfoParserState.advance$default(r0, r6, r5, r7)
            java.lang.String r7 = r0.takeUntilEnd()
        Lc9:
            r5 = r4
            r4 = r2
            r2 = r8
            r8 = r3
            r3 = r1
            androidx.compose.runtime.tooling.SourceInformation r1 = new androidx.compose.runtime.tooling.SourceInformation
            r9 = r13
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.tooling.SourceInformationKt.parseSourceInformationInternal(java.lang.String):androidx.compose.runtime.tooling.SourceInformation");
    }

    private static final String replaceComposePrefix(String str) {
        k.f(str, "<this>");
        int iQ0 = m.q0(str, "c#", 0, false, 2);
        return iQ0 < 0 ? str : m.A0(str, iQ0, 2 + iQ0, "androidx.compose.").toString();
    }
}
