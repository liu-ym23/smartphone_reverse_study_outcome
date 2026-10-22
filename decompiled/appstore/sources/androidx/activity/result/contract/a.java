package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import bg.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.collections.j0;
import kotlin.collections.k0;
import kotlin.collections.n;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ActivityResultContract {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0005a f210a = null;

    /* JADX INFO: renamed from: androidx.activity.result.contract.a$a, reason: collision with other inner class name */
    public static final class C0005a {
        public /* synthetic */ C0005a(DefaultConstructorMarker r10) {
            this();
        }

        public final Intent a(String[] r10) {
            q.g(r10, "input");
            Intent r11 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", r10);
            q.f(r11, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return r11;
        }

        public C0005a() {
        }
    }

    static {
        f210a = new C0005a(null);
    }

    public a() {
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Intent a(Context r10, Object r11) {
        return d(r10, (String[]) r11);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ ActivityResultContract.a b(Context r10, Object r11) {
        return e(r10, (String[]) r11);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Object c(int r10, Intent r11) {
        return f(r10, r11);
    }

    public Intent d(Context r10, String[] r11) {
        q.g(r10, "context");
        q.g(r11, "input");
        return f210a.a(r11);
    }

    public ActivityResultContract.a e(Context r10, String[] r11) {
        q.g(r10, "context");
        q.g(r11, "input");
        if (r11.length == 0) goto L5;
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L12;
        if (ContextCompat.a(r10, r11[r14]) != 0) goto L11;
        r14 = r14 + 1;
        goto L7
    L11:
        return null;
    L12:
        LinkedHashMap r15 = new LinkedHashMap(h.d(j0.e(r11.length), 16));
        int r16 = r11.length;
    L13:
        if (r13 >= r16) goto L16;
        Pair r17 = d.a(r11[r13], Boolean.TRUE);
        r15.put(r17.getFirst(), r17.getSecond());
        r13 = r13 + 1;
        goto L13
    L16:
        return new ActivityResultContract.a(r15);
    L5:
        return new ActivityResultContract.a(k0.h());
    }

    public Map f(int r10, Intent r11) {
        if (r10 != (-1)) goto L5;
        if (r11 == null) goto L8;
        String[] r12 = r11.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] r13 = r11.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (r13 == null) goto L23;
        if (r12 == null) goto L23;
        ArrayList r14 = new ArrayList(r13.length);
        int r15 = r13.length;
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L21;
        if (r13[r16] != 0) goto L18;
        boolean r17 = true;
    L19:
        r14.add(Boolean.valueOf(r17));
        r16 = r16 + 1;
        goto L14
    L18:
        r17 = false;
        goto L19
    L21:
        return k0.q(b0.E0(n.q(r12), r14));
    L23:
        return k0.h();
    L8:
        return k0.h();
    L5:
        return k0.h();
    }
}
