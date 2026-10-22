package ch.qos.logback.core.pattern;

import com.stepos.alphame.awareness.AwarenessDataItem;

/* loaded from: classes.dex */
public class SpacePadder {
    static final String[] SPACES = {AwarenessDataItem.PERMISSION_SPLITTER, "  ", "    ", "        ", "                ", "                                "};

    public static final void leftPad(StringBuilder sb, String str, int i4) {
        int length = str != null ? str.length() : 0;
        if (length < i4) {
            spacePad(sb, i4 - length);
        }
        if (str != null) {
            sb.append(str);
        }
    }

    public static final void rightPad(StringBuilder sb, String str, int i4) {
        int length = str != null ? str.length() : 0;
        if (str != null) {
            sb.append(str);
        }
        if (length < i4) {
            spacePad(sb, i4 - length);
        }
    }

    public static final void spacePad(StringBuilder sb, int i4) {
        while (i4 >= 32) {
            sb.append(SPACES[5]);
            i4 -= 32;
        }
        for (int i5 = 4; i5 >= 0; i5--) {
            if (((1 << i5) & i4) != 0) {
                sb.append(SPACES[i5]);
            }
        }
    }
}
