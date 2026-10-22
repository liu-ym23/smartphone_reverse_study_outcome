package B3;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f189a;

    static {
        HashMap map = new HashMap();
        f189a = map;
        map.put("Letter", "L");
        map.put("Lowercase_Letter", "Ll");
        map.put("Uppercase_Letter", "Lu");
        map.put("Titlecase_Letter", "Lt");
        map.put("Cased_Letter", "L&");
        map.put("Modifier_Letter", "Lm");
        map.put("Other_Letter", "Lo");
        map.put("Mark", "M");
        map.put("Non_Spacing_Mark", "Mn");
        map.put("Spacing_Combining_Mark", "Mc");
        map.put("Enclosing_Mark", "Me");
        map.put("Separator", "Z");
        map.put("Space_Separator", "Zs");
        map.put("Line_Separator", "Zl");
        map.put("Paragraph_Separator", "Zp");
        map.put("Symbol", ExifInterface.LATITUDE_SOUTH);
        map.put("Math_Symbol", "Sm");
        map.put("Currency_Symbol", "Sc");
        map.put("Modifier_Symbol", "Sk");
        map.put("Other_Symbol", "So");
        map.put("Number", "N");
        map.put("Decimal_Digit_Number", "Nd");
        map.put("Letter_Number", "Nl");
        map.put("Other_Number", "No");
        map.put("Punctuation", "P");
        map.put("Dash_Punctuation", "Pd");
        map.put("Open_Punctuation", "Ps");
        map.put("Close_Punctuation", "Pe");
        map.put("Initial_Punctuation", "Pi");
        map.put("Final_Punctuation", "Pf");
        map.put("Connector_Punctuation", "Pc");
        map.put("Other_Punctuation", "Po");
        map.put("Other", "C");
        map.put("Control", "Cc");
        map.put("Format", "Cf");
        map.put("Private_Use", "Co");
        map.put("Surrogate", "Cs");
        map.put("Unassigned", "Cn");
        map.put("digit", "Nd");
    }
}
