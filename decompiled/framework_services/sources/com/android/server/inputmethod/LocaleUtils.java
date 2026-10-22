package com.android.server.inputmethod;

import android.content.Context;
import android.icu.util.ULocale;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class LocaleUtils {

    public interface LocaleExtractor<T> {
        Locale get(T r1);
    }

    private static final class ScoreEntry implements Comparable<ScoreEntry> {
        public int mIndex;
        public final byte[] mScore;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ScoreEntry r1) {
            return compareTo2(r1);
        }

        ScoreEntry(byte[] score, int index) {
            this.mIndex = -1;
            this.mScore = new byte[score.length];
            set(score, index);
        }

        private void set(byte[] score, int index) {
            int i = 0;
        L4:
            if (i >= this.mScore.length) goto L6;
            this.mScore[i] = score[i];
            i = i + 1;
            goto L4
        L6:
            this.mIndex = index;
        }

        public void updateIfBetter(byte[] score, int index) {
            if (compare(this.mScore, score) != (-1)) goto L6;
            set(score, index);
            return;
        }

        private static int compare(byte[] left, byte[] right) {
            int i = 0;
        L4:
            if (i >= left.length) goto L14;
            if (left[i] > right[i]) goto L7;
            if (left[i] < right[i]) goto L11;
            i = i + 1;
            goto L4
        L11:
            return -1;
        L7:
            return 1;
        L14:
            return 0;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ScoreEntry other) {
            return compare(this.mScore, other.mScore) * (-1);
        }
    }

    LocaleUtils() {
    }

    private static byte calculateMatchingSubScore(ULocale supported, ULocale desired) {
        if (supported.equals(desired) == false) goto L5;
        return 4;
    L5:
        ULocale maxDesired = ULocale.addLikelySubtags(desired);
        String supportedScript = supported.getScript();
        if (supportedScript.isEmpty() == false) goto L8;
        return 1;
    L8:
        if (supportedScript.equals(maxDesired.getScript()) == false) goto L33;
        String supportedCountry = supported.getCountry();
        if (supportedCountry.isEmpty() == false) goto L13;
        return 2;
    L13:
        if (supportedCountry.equals(maxDesired.getCountry()) == false) goto L32;
        String desiredScript = desired.getScript();
        String desiredCountry = desired.getCountry();
        if (desiredScript.isEmpty() == true) goto L20;
        if (desiredScript.equals(maxDesired.getScript()) == true) goto L20;
        return 3;
    L20:
        if (desiredCountry.isEmpty() == false) goto L22;
    L26:
        return 4;
    L22:
        if (desiredCountry.equals(maxDesired.getCountry()) == true) goto L26;
        return 3;
    L32:
        return 2;
    L33:
        return 1;
    }

    public static <T> void filterByLanguage(List<T> sources, LocaleExtractor<T> extractor, LocaleList preferredLocales, ArrayList<T> dest) {
        if (preferredLocales.isEmpty() == false) goto L5;
        return;
    L5:
        int numPreferredLocales = preferredLocales.size();
        ArrayMap<String, ScoreEntry> scoreboard = new ArrayMap();
        byte[] score = new byte[numPreferredLocales];
        ULocale[] preferredULocaleCache = new ULocale[numPreferredLocales];
        int sourceSize = sources.size();
        int i = 0;
    L6:
        int r7 = 0;
        if (i >= sourceSize) goto L33;
        Locale locale = extractor.get(sources.get(i));
        if (locale == null) goto L32;
        boolean canSkip = true;
        int j = 0;
    L12:
        if (j >= numPreferredLocales) goto L26;
        Locale preferredLocale = preferredLocales.get(j);
        if (TextUtils.equals(locale.getLanguage(), preferredLocale.getLanguage()) == true) goto L17;
        score[j] = 0;
    L24:
        j = j + 1;
        goto L12
    L17:
        if (preferredULocaleCache[j] != null) goto L19;
        preferredULocaleCache[j] = ULocale.addLikelySubtags(ULocale.forLocale(preferredLocale));
    L19:
        score[j] = calculateMatchingSubScore(preferredULocaleCache[j], ULocale.forLocale(locale));
        if (canSkip == false) goto L24;
        if (score[j] == 0) goto L24;
        canSkip = false;
        goto L24
    L26:
        if (canSkip == true) goto L32;
        String lang = locale.getLanguage();
        ScoreEntry bestScore = scoreboard.get(lang);
        if (bestScore != null) goto L31;
        scoreboard.put(lang, new ScoreEntry(score, i));
        goto L32
    L31:
        bestScore.updateIfBetter(score, i);
    L32:
        i = i + 1;
        goto L6
    L33:
        int numEntries = scoreboard.size();
        ScoreEntry[] result = new ScoreEntry[numEntries];
        int i2 = 0;
    L34:
        if (i2 >= numEntries) goto L36;
        result[i2] = scoreboard.valueAt(i2);
        i2 = i2 + 1;
        goto L34
    L36:
        Arrays.sort(result);
        int r10 = result.length;
    L37:
        if (r7 >= r10) goto L40;
        ScoreEntry entry = result[r7];
        dest.add(sources.get(entry.mIndex));
        r7 = r7 + 1;
        goto L37
    }

    static String getLanguageFromLocaleString(String locale) {
        int idx = locale.indexOf(95);
        if (idx >= 0) goto L6;
        return locale;
    L6:
        return locale.substring(0, idx);
    }

    static Locale getSystemLocaleFromContext(Context context) {
        return context.getResources().getConfiguration().locale;
    L5:
        return null;
    }
}
