package M0;

import M0.a;
import androidx.datastore.preferences.core.MutablePreferences;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a+\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LM0/a;", Const.INTENT_KEY_APIKEY, "()LM0/a;", "", "LM0/a$b;", "pairs", "Landroidx/datastore/preferences/core/MutablePreferences;", Const.INTENT_KEY_PKGNAME, "([LM0/a$b;)Landroidx/datastore/preferences/core/MutablePreferences;", "datastore-preferences-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class b {
    public static final a a() {
        return new MutablePreferences(null, true, 1, null);
    }

    public static final MutablePreferences b(a.b<?>... pairs) {
        p.i(pairs, "pairs");
        MutablePreferences mutablePreferences = new MutablePreferences(null, false, 1, null);
        mutablePreferences.g((a.b[]) Arrays.copyOf(pairs, pairs.length));
        return mutablePreferences;
    }
}
