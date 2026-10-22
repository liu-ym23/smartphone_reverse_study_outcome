package H2;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.stepos.familyguard.net.entity.BaseEntity;

/* loaded from: classes.dex */
public abstract class P0 extends com.stepos.familyguard.ui.base.i<String, Long> {
    public P0(Application application) {
        super(application);
    }

    public static long q0(Context context) {
        return context.getSharedPreferences("minor_sp", 0).getLong("phone_id", -1L);
    }

    public static void r0(Context context, String str, long j5) {
        context.getSharedPreferences("minor_sp", 0).edit().putLong("phone_id", j5).putString("phone", str).apply();
    }

    @Override // com.stepos.familyguard.ui.base.i
    protected void j0(String str, String str2, BaseEntity<Long> baseEntity) {
        super.j0(str, str2, baseEntity);
        if (TextUtils.isEmpty(str) || baseEntity == null || baseEntity.code != 200 || baseEntity.value.longValue() <= 0) {
            return;
        }
        r0(K(), str, baseEntity.value.longValue());
    }
}
