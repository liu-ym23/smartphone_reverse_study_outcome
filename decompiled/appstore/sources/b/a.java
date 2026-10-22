package b;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ActivityResultContract {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0063a f5917a = null;

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    public static final class C0063a {
        public /* synthetic */ C0063a(DefaultConstructorMarker r10) {
            this();
        }

        public C0063a() {
        }
    }

    static {
        f5917a = new C0063a(null);
    }

    public a() {
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Intent a(Context r10, Object r11) {
        return d(r10, (Intent) r11);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Object c(int r10, Intent r11) {
        return e(r10, r11);
    }

    public Intent d(Context r10, Intent r11) {
        q.g(r10, "context");
        q.g(r11, "input");
        return r11;
    }

    public ActivityResult e(int r10, Intent r11) {
        return new ActivityResult(r10, r11);
    }
}
