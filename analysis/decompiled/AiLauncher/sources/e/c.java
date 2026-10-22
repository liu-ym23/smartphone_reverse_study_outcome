package e;

import Y8.j;
import Z8.F;
import Z8.Q;
import Z8.r;
import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import e.AbstractC3969a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00162 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00040\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ9\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Le/c;", "Le/a;", "", "", "", "", "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "Le/a$a;", "e", "(Landroid/content/Context;[Ljava/lang/String;)Le/a$a;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c extends AbstractC3969a<String[], Map<String, Boolean>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Le/c$a;", "", "<init>", "()V", "", "", "input", "Landroid/content/Intent;", Const.INTENT_KEY_APIKEY, "([Ljava/lang/String;)Landroid/content/Intent;", "ACTION_REQUEST_PERMISSIONS", "Ljava/lang/String;", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Intent a(String[] input) {
            p.i(input, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            p.h(intentPutExtra, "putExtra(...)");
            return intentPutExtra;
        }

        public Companion() {
        }
    }

    @Override // e.AbstractC3969a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] input) {
        p.i(context, "context");
        p.i(input, "input");
        return INSTANCE.a(input);
    }

    @Override // e.AbstractC3969a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC3969a.C0391a<Map<String, Boolean>> b(Context context, String[] input) {
        p.i(context, "context");
        p.i(input, "input");
        if (input.length == 0) {
            return new AbstractC3969a.C0391a<>(kotlin.collections.a.i());
        }
        for (String str : input) {
            if (androidx.core.content.a.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(input.length), 16));
        for (String str2 : input) {
            Pair pairA = j.a(str2, Boolean.TRUE);
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return new AbstractC3969a.C0391a<>(linkedHashMap);
    }

    @Override // e.AbstractC3969a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> c(int resultCode, Intent intent) {
        if (resultCode == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return kotlin.collections.a.i();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i10 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i10 == 0));
            }
            return kotlin.collections.a.y(F.w1(r.V(stringArrayExtra), arrayList));
        }
        return kotlin.collections.a.i();
    }
}
