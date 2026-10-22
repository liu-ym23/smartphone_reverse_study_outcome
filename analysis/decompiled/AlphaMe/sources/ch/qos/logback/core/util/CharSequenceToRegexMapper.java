package ch.qos.logback.core.util;

import B0.g;
import com.baidu.entity.pb.PoiResult;

/* loaded from: classes.dex */
class CharSequenceToRegexMapper {
    private String number(int i4) {
        return g.j("\\d{", i4, "}");
    }

    public String toRegex(CharSequenceState charSequenceState) {
        int i4 = charSequenceState.occurrences;
        char c4 = charSequenceState.f4518c;
        if (c4 != 'y') {
            if (c4 == 'z') {
                return ".*";
            }
            switch (c4) {
                case '\'':
                    if (i4 == 1) {
                        return "";
                    }
                    throw new IllegalStateException("Too many single quotes");
                case '.':
                    return "\\.";
                case PoiResult.Contents.BAR_BUTTON_FIELD_NUMBER /* 75 */:
                case 'S':
                case 'W':
                case 'd':
                case 'h':
                case 'k':
                case 'm':
                case 's':
                case 'w':
                    break;
                case PoiResult.Contents.CARD_TYPE_FIELD_NUMBER /* 77 */:
                    return i4 >= 3 ? ".{3,12}" : number(i4);
                case 'Z':
                    return "(\\+|-)\\d{4}";
                case '\\':
                    throw new IllegalStateException("Forward slashes are not allowed");
                case 'a':
                    return ".{2}";
                default:
                    switch (c4) {
                        case 'D':
                        case 'F':
                        case 'H':
                            break;
                        case 'E':
                            return ".{2,12}";
                        case 'G':
                            return ".*";
                        default:
                            if (i4 == 1) {
                                return "" + c4;
                            }
                            return c4 + "{" + i4 + "}";
                    }
            }
        }
        return number(i4);
    }
}
