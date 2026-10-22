package com.autonavi.base.ae.gmap.glyph;

import java.text.BreakIterator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public ArrayList<Integer> breakResult;
    public int mBreakMode;

    public GlyphBreakIterator(int r100) {
        this.breakResult = new ArrayList();
        this.mBreakMode = r100;
    }

    public int[] setText(String r100) {
        BreakIterator r101 = null;
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        if (this.breakResult.isEmpty() == true) goto L8;
        this.breakResult.clear();
    L8:
        int r102 = this.mBreakMode;
        if (r102 != 1) goto L11;
        r101 = BreakIterator.getWordInstance();
    L15:
        r101.setText(r100);
        int r103 = r101.first();
        int r104 = r101.next();
    L16:
        int r105 = r104;
        int r106 = r103;
        r103 = r105;
        if (r103 == (-1)) goto L19;
        this.breakResult.add(Integer.valueOf(r106));
        r104 = r101.next();
        goto L16
    L19:
        this.breakResult.add(Integer.valueOf(r100.length()));
        int r107 = this.breakResult.size();
        Integer[] r108 = new Integer[r107];
        this.breakResult.toArray(r108);
        int[] r109 = new int[r107];
        int r110 = 0;
    L20:
        if (r110 >= r107) goto L22;
        r109[r110] = r108[r110].intValue();
        r110 = r110 + 1;
        goto L20
    L22:
        return r109;
    L11:
        if (r102 != 2) goto L15;
        r101 = BreakIterator.getCharacterInstance();
        goto L15
    }
}
