package com.android.contacts.list;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LetterMatcher {
    private static Map<String, String[]> sJapaneseAlphabetsMap;
    private static volatile LetterMatcher sLetterMatcher;

    private LetterMatcher() {
    }

    public static LetterMatcher getInstance() {
        if (sLetterMatcher != null) goto L15;
        monitor-enter(LetterMatcher.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sLetterMatcher != null) goto L9;
        sLetterMatcher = new LetterMatcher();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LetterMatcher.class);     // Catch: Throwable -> L11
    L15:
        return sLetterMatcher;
    }

    public boolean match(Object r5, String r6, int r7) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return false;
    L8:
        if ((r5 instanceof SamContact) == false) goto L11;
        SamContact r8 = (SamContact) r5;
        String r1 = r8.section;
        String r9 = r8.sortkey;
    L14:
        if (TextUtils.isEmpty(r1) == false) goto L16;
        return false;
    L16:
        String r2 = Locale.getDefault().getLanguage();
        if (r7 != 0) goto L20;
        return r1.equals(r6);
    L20:
        if (TextUtils.isEmpty(r9) == true) goto L31;
        if (Locale.JAPAN.getLanguage().equals(r2) == false) goto L31;
        String[] r4 = getJapaneseMophonys(r6);
        if (r9.length() < 1) goto L28;
        if (r4 == null) goto L28;
        boolean r10 = Arrays.asList(r4).contains(String.valueOf(r9.charAt(0)));
    L37:
        return r10;
    L28:
        r10 = r1.equals(r6);
    L31:
        if (r1.equals(r6) == true) goto L33;
        return false;
    L33:
        return true;
    L11:
        if ((r5 instanceof ContactTileAdapter.ContactEntry) == false) goto L35;
        ContactTileAdapter.ContactEntry r11 = (ContactTileAdapter.ContactEntry) r5;
        r1 = r11.section;
        r9 = r11.sortkey;
        goto L14
    L35:
        return false;
    }

    public String[] getJapaneseMophonys(String r1) {
        return getJapaneseAlphabetsMap().get(r1);
    }

    private static synchronized Map<String, String[]> getJapaneseAlphabetsMap() {
        monitor-enter(LetterMatcher.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sJapaneseAlphabetsMap != null) goto L7;
        HashMap r1 = new HashMap();     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap = r1;     // Catch: Throwable -> L10
        r1.put("あ", new String[]{"あ", "ア"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("い", new String[]{"い", "イ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("う", new String[]{"う", "ウ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("え", new String[]{"え", "エ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("お", new String[]{"お", "オ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("か", new String[]{"か", "カ", "が", "ガ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("き", new String[]{"き", "キ", "ぎ", "ギ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("く", new String[]{"く", "ク", "ぐ", "グ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("け", new String[]{"け", "ケ", "げ", "ゲ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("こ", new String[]{"こ", "コ", "ご", "ゴ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("さ", new String[]{"さ", "サ", "ざ", "ザ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("し", new String[]{"し", "シ", "じ", "ジ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("す", new String[]{"す", "ス", "ず", "ズ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("せ", new String[]{"せ", "セ", "ぜ", "ゼ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("そ", new String[]{"そ", "ソ", "ぞ", "ゾ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("た", new String[]{"た", "タ", "だ", "ダ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ち", new String[]{"ち", "チ", "ぢ", "ヂ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("つ", new String[]{"つ", "ツ", "づ", "ヅ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("て", new String[]{"て", "テ", "で", "デ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("と", new String[]{"と", "ト", "ど", "ド"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("な", new String[]{"な", "ナ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("に", new String[]{"に", "ニ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ぬ", new String[]{"ぬ", "ヌ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ね", new String[]{"ね", "ネ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("の", new String[]{"の", "ノ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("は", new String[]{"は", "ハ", "ば", "バ", "ぱ", "パ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ひ", new String[]{"ひ", "ヒ", "び", "ビ", "ぴ", "ピ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ふ", new String[]{"ふ", "フ", "ぶ", "ブ", "ぷ", "プ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("へ", new String[]{"へ", "ヘ", "べ", "ベ", "ぺ", "ペ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ほ", new String[]{"ほ", "ホ", "ぼ", "ボ", "ぽ", "ポ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ま", new String[]{"ま", "マ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("み", new String[]{"み", "ミ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("む", new String[]{"む", "ム"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("め", new String[]{"め", "メ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("も", new String[]{"も", "モ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("や", new String[]{"や", "ヤ", "ゃ", "ャ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ゆ", new String[]{"ゆ", "ユ", "ゅ", "ュ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("よ", new String[]{"よ", "ヨ", "ょ", "ョ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ら", new String[]{"ら", "ラ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("り", new String[]{"り", "リ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("る", new String[]{"る", "ル"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("れ", new String[]{"れ", "レ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ろ", new String[]{"ろ", "ロ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("わ", new String[]{"わ", "ワ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("を", new String[]{"を", "ヲ"});     // Catch: Throwable -> L10
        sJapaneseAlphabetsMap.put("ん", new String[]{"ん", "ン"});     // Catch: Throwable -> L10
    L7:
        Map<String, String[]> r2 = sJapaneseAlphabetsMap;     // Catch: Throwable -> L10
        monitor-exit(LetterMatcher.class);
        return r2;
    }
}
