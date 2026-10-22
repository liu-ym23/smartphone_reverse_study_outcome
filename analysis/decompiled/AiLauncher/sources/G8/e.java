package G8;

import G8.d;
import android.text.TextUtils;
import io.noties.markwon.image.h;
import java.util.Map;

/* loaded from: classes4.dex */
public class e implements d.a {

    /* renamed from: a, reason: collision with root package name */
    public final C8.b f2865a;

    public e(C8.b bVar) {
        this.f2865a = bVar;
    }

    @Override // G8.d.a
    public io.noties.markwon.image.h a(Map<String, String> map) {
        h.a aVarB;
        h.a aVarB2;
        String str = map.get("style");
        if (!TextUtils.isEmpty(str)) {
            aVarB = null;
            aVarB2 = null;
            for (C8.c cVar : this.f2865a.b(str)) {
                String strA = cVar.a();
                if ("width".equals(strA)) {
                    aVarB = b(cVar.c());
                } else if ("height".equals(strA)) {
                    aVarB2 = b(cVar.c());
                }
                if (aVarB != null && aVarB2 != null) {
                    break;
                }
            }
        } else {
            aVarB = null;
            aVarB2 = null;
        }
        if (aVarB != null && aVarB2 != null) {
            return new io.noties.markwon.image.h(aVarB, aVarB2);
        }
        if (aVarB == null) {
            aVarB = b(map.get("width"));
        }
        if (aVarB2 == null) {
            aVarB2 = b(map.get("height"));
        }
        if (aVarB == null && aVarB2 == null) {
            return null;
        }
        return new io.noties.markwon.image.h(aVarB, aVarB2);
    }

    public h.a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        int i10 = length - 1;
        int i11 = i10;
        while (i11 > -1) {
            if (Character.isDigit(str.charAt(i11))) {
                int i12 = i11 + 1;
                try {
                    return new h.a(Float.parseFloat(str.substring(0, i12)), i11 == i10 ? null : str.substring(i12, length));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            i11--;
        }
        return null;
    }
}
