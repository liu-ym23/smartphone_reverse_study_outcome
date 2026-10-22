package c5;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import com.stepos.account.oauth.OAuthConstants;
import java.util.Map;
import q7.k;

/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: b, reason: collision with root package name */
    public static final Moshi f1898b;

    /* renamed from: a, reason: collision with root package name */
    public final JsonAdapter f1899a;

    static {
        Moshi moshiBuild = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        k.d(moshiBuild, "build(...)");
        f1898b = moshiBuild;
    }

    public d() {
        Moshi moshi = f1898b;
        k.e(moshi, "moshi");
        this.f1899a = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class)).serializeNulls();
    }

    public final b a(String str) {
        k.e(str, "text");
        try {
            Map map = (Map) this.f1899a.fromJson(str);
            if (map == null) {
                throw new a("frame is null after parse", null);
            }
            Object obj = map.get("type");
            String str2 = obj instanceof String ? (String) obj : null;
            if (str2 != null) {
                return new b(str2, map);
            }
            throw new a("frame missing 'type' field", null);
        } catch (a e10) {
            throw e10;
        } catch (Exception e11) {
            String strW = a1.a.w("decode failed: ", e11.getMessage());
            k.e(strW, OAuthConstants.FACTOR_RESULT_MESSAGE);
            throw new a(strW, e11);
        }
    }

    public final String b(b bVar) {
        k.e(bVar, "frame");
        try {
            return this.f1899a.toJson(bVar.f1897b);
        } catch (Exception e10) {
            throw new a("encode failed", e10);
        }
    }
}
