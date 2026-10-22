package I1;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class c implements J1.f {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f3271a;

    /* renamed from: b, reason: collision with root package name */
    public final Enum[] f3272b;

    public c(Class<?> cls) {
        this.f3271a = cls;
        this.f3272b = (Enum[]) cls.getEnumConstants();
    }

    @Override // J1.f
    public <T> T b(b bVar, Type type, Object obj) {
        try {
            d dVar = bVar.f3258e;
            int i10 = dVar.f3280a;
            if (i10 == 2) {
                int iJ = dVar.j();
                dVar.t(16);
                if (iJ >= 0) {
                    Object[] objArr = this.f3272b;
                    if (iJ <= objArr.length) {
                        return (T) objArr[iJ];
                    }
                }
                throw new JSONException("parse enum " + this.f3271a.getName() + " error, value : " + iJ);
            }
            if (i10 == 4) {
                String strX = dVar.X();
                dVar.t(16);
                if (strX.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(this.f3271a, strX);
            }
            if (i10 == 8) {
                dVar.t(16);
                return null;
            }
            throw new JSONException("parse enum " + this.f3271a.getName() + " error, value : " + bVar.J());
        } catch (JSONException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }
}
