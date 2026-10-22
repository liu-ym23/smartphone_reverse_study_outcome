package w;

import android.content.Context;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class f extends AbstractC2079a {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i) {
        super(0);
        this.c = i;
    }

    @Override // w.AbstractC2079a
    public final Object a(Object[] objArr) {
        switch (this.c) {
            case 0:
                return ((Context) objArr[0]).getSharedPreferences("ug_install_settings_pref", 0);
            default:
                return UUID.randomUUID().toString();
        }
    }
}
