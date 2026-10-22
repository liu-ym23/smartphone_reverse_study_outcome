package com.stepos.core.ability.speech;

import androidx.datastore.preferences.protobuf.b1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsUplinkShaper {
    public static final TtsUplinkShaper INSTANCE = new TtsUplinkShaper();

    private TtsUplinkShaper() {
    }

    private final List<String> buildLineSegments(String str, int i10, boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator it = gc.q.E0(str, new char[]{'\n'}).iterator();
        while (it.hasNext()) {
            String string = gc.q.L0(gc.o.h0((String) it.next(), '\r', ' ')).toString();
            if (string.length() != 0) {
                if (z) {
                    List<String> listSplitLineIntoSentences$ability_release = TtsWsModels.INSTANCE.splitLineIntoSentences$ability_release(string);
                    if (listSplitLineIntoSentences$ability_release.isEmpty()) {
                        arrayList.add(string);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        Iterator<String> it2 = listSplitLineIntoSentences$ability_release.iterator();
                        while (it2.hasNext()) {
                            sb2.append(it2.next());
                            if (sb2.length() >= i10) {
                                arrayList.add(sb2.toString());
                                sb2.setLength(0);
                            }
                        }
                        if (sb2.length() > 0) {
                            arrayList.add(sb2.toString());
                        }
                    }
                } else {
                    arrayList.add(string);
                }
            }
        }
        return arrayList;
    }

    private final int extendPastOpenParen(String str, int i10, int i11) {
        int i12 = 0;
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '(') {
                i12++;
            } else if (cCharAt == ')' && i12 > 0) {
                i12--;
            }
            i10++;
        }
        if (i12 <= 0) {
            return i11;
        }
        while (i11 < str.length() && i12 > 0) {
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 == '(') {
                i12++;
            } else if (cCharAt2 == ')') {
                i12--;
            }
            i11++;
        }
        return i11;
    }

    private final List<String> splitByPunctuation(String str, int i10, int i11) {
        if (str.length() <= i10) {
            return b1.P(str);
        }
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        while (i12 < str.length()) {
            String strSubstring = str.substring(i12);
            kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
            if (strSubstring.length() <= i10) {
                arrayList.add(strSubstring);
                return arrayList;
            }
            TtsWsModels ttsWsModels = TtsWsModels.INSTANCE;
            int iLastBreakEndAtOrBefore = ttsWsModels.lastBreakEndAtOrBefore(strSubstring, i10, true);
            if (iLastBreakEndAtOrBefore < i11) {
                int i13 = i11 - 1;
                if (i13 < 0) {
                    i13 = 0;
                }
                int iAnyBreakEndAtOrAfter = ttsWsModels.anyBreakEndAtOrAfter(strSubstring, i13, true);
                if (iAnyBreakEndAtOrAfter > 0) {
                    iLastBreakEndAtOrBefore = iAnyBreakEndAtOrAfter;
                }
            }
            if (iLastBreakEndAtOrBefore <= 0) {
                arrayList.add(strSubstring);
                return arrayList;
            }
            int iExtendPastOpenParen = extendPastOpenParen(str, i12, iLastBreakEndAtOrBefore + i12) - i12;
            if (iExtendPastOpenParen <= 0 || iExtendPastOpenParen >= strSubstring.length()) {
                arrayList.add(strSubstring);
                break;
            }
            String strSubstring2 = strSubstring.substring(0, iExtendPastOpenParen);
            kotlin.jvm.internal.g.e(strSubstring2, "substring(...)");
            arrayList.add(strSubstring2);
            i12 += iExtendPastOpenParen;
        }
        return arrayList;
    }

    public final List<String> shape(String text, TtsCloudConfig config) {
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(config, "config");
        List<List<String>> listShapeBySentence = shapeBySentence(text, config);
        kotlin.jvm.internal.g.f(listShapeBySentence, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listShapeBySentence.iterator();
        while (it.hasNext()) {
            mb.q.g0(arrayList, (Iterable) it.next());
        }
        return arrayList;
    }

    public final List<List<String>> shapeBySentence(String text, TtsCloudConfig config) {
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(config, "config");
        if (text.length() == 0) {
            return EmptyList.f10001a;
        }
        int iUplinkMaxCharsPerDelta = config.uplinkMaxCharsPerDelta();
        int iUplinkCommitMinChars = config.uplinkSentencePipeline() ? 0 : config.uplinkCommitMinChars();
        List<String> listBuildLineSegments = buildLineSegments(text, iUplinkCommitMinChars, config.uplinkPreferSentenceSplit());
        ArrayList arrayList = new ArrayList();
        for (String str : listBuildLineSegments) {
            List<String> listP = str.length() <= iUplinkMaxCharsPerDelta ? b1.P(str) : splitByPunctuation(str, iUplinkMaxCharsPerDelta, iUplinkCommitMinChars);
            if (!listP.isEmpty()) {
                arrayList.add(listP);
            }
        }
        return arrayList;
    }
}
