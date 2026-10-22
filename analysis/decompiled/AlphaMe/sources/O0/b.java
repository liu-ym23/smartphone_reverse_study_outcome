package O0;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public final class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1524a = new b();

    @Override // O0.k
    public final Object a(JsonReader jsonReader, float f4) throws IOException {
        jsonReader.beginObject();
        int iNextInt = 0;
        int iNextInt2 = 0;
        int iA = 0;
        int iA2 = 0;
        boolean zNextBoolean = true;
        String strNextString = null;
        String strNextString2 = null;
        double dNextDouble = 0.0d;
        double dNextDouble2 = 0.0d;
        double dNextDouble3 = 0.0d;
        double dNextDouble4 = 0.0d;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "f":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "j":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "s":
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case "t":
                    strNextString = jsonReader.nextString();
                    break;
                case "fc":
                    iA = com.stepos.statsrpk.c.A(jsonReader);
                    break;
                case "lh":
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case "ls":
                    dNextDouble3 = jsonReader.nextDouble();
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "sc":
                    iA2 = com.stepos.statsrpk.c.A(jsonReader);
                    break;
                case "sw":
                    dNextDouble4 = jsonReader.nextDouble();
                    break;
                case "tr":
                    iNextInt2 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new J0.b(strNextString, strNextString2, dNextDouble, iNextInt, iNextInt2, dNextDouble2, dNextDouble3, iA, iA2, dNextDouble4, zNextBoolean);
    }
}
