package F1;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class y implements z {

    /* renamed from: a, reason: collision with root package name */
    public static final u f452a;

    /* renamed from: b, reason: collision with root package name */
    public static final v f453b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ y[] f454c;

    static {
        u uVar = new u();
        f452a = uVar;
        v vVar = new v();
        f453b = vVar;
        f454c = new y[]{uVar, vVar, new y() { // from class: F1.w
            @Override // F1.z
            public final Number a(JsonReader jsonReader) throws IOException, NumberFormatException {
                String strNextString = jsonReader.nextString();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strNextString));
                    } catch (NumberFormatException unused) {
                        Double dValueOf = Double.valueOf(strNextString);
                        if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                            if (!jsonReader.isLenient()) {
                                throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.getPreviousPath());
                            }
                        }
                        return dValueOf;
                    }
                } catch (NumberFormatException e4) {
                    StringBuilder sbW = B0.g.w("Cannot parse ", strNextString, "; at path ");
                    sbW.append(jsonReader.getPreviousPath());
                    throw new androidx.fragment.app.A(sbW.toString(), 5, e4);
                }
            }
        }, new y() { // from class: F1.x
            @Override // F1.z
            public final Number a(JsonReader jsonReader) throws IOException {
                String strNextString = jsonReader.nextString();
                try {
                    return new BigDecimal(strNextString);
                } catch (NumberFormatException e4) {
                    StringBuilder sbW = B0.g.w("Cannot parse ", strNextString, "; at path ");
                    sbW.append(jsonReader.getPreviousPath());
                    throw new androidx.fragment.app.A(sbW.toString(), 5, e4);
                }
            }
        }};
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) f454c.clone();
    }
}
