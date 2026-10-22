package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class KeyParser {

    public interface DataType {
        int get(int i);
    }

    public interface Ids {
        int get(String str);
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject cLObject = CLParser.parse(str);
            int size = cLObject.size();
            for (int i = 0; i < size; i++) {
                CLKey cLKey = (CLKey) cLObject.get(i);
                String strContent = cLKey.content();
                CLElement value = cLKey.getValue();
                int i6 = ids.get(strContent);
                if (i6 == -1) {
                    System.err.println("unknown type " + strContent);
                } else {
                    int i10 = dataType.get(i6);
                    if (i10 == 1) {
                        typedBundle.add(i6, cLObject.getBoolean(i));
                    } else if (i10 == 2) {
                        typedBundle.add(i6, value.getInt());
                        System.out.println("parse " + strContent + " INT_MASK > " + value.getInt());
                    } else if (i10 == 4) {
                        typedBundle.add(i6, value.getFloat());
                        System.out.println("parse " + strContent + " FLOAT_MASK > " + value.getFloat());
                    } else if (i10 == 8) {
                        typedBundle.add(i6, value.content());
                        System.out.println("parse " + strContent + " STRING_MASK > " + value.content());
                    }
                }
            }
            return typedBundle;
        } catch (CLParsingException e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
            return typedBundle;
        }
    }

    public static TypedBundle parseAttributes(String str) {
        return parse(str, new a(), new a());
    }
}
