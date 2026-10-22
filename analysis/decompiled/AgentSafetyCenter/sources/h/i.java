package h;

import android.os.Bundle;
import com.blankj.utilcode.util.UtilsTransActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements t4.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4841a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4842b;

    public /* synthetic */ i(int i) {
        this.f4841a = i;
    }

    @Override // t4.c
    public final Bundle a() {
        switch (this.f4841a) {
            case 0:
                Bundle bundle = new Bundle();
                ((UtilsTransActivity) this.f4842b).c().getClass();
                return bundle;
            default:
                Bundle bundleO = h5.t.o((jb.g[]) Arrays.copyOf(new jb.g[0], 0));
                List listL0 = kb.l.L0((LinkedHashSet) this.f4842b);
                bundleO.putStringArrayList("classes_to_restore", listL0 instanceof ArrayList ? (ArrayList) listL0 : new ArrayList<>(listL0));
                return bundleO;
        }
    }
}
