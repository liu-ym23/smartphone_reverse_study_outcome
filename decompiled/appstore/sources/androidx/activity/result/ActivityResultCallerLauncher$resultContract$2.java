package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "O", "androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$a", "invoke", "()Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$a;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class ActivityResultCallerLauncher$resultContract$2 extends Lambda implements Function0 {
    final /* synthetic */ androidx.activity.result.a this$0;

    public static final class a extends ActivityResultContract {
        public a(androidx.activity.result.a r10) {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent a(Context r10, Object r11) {
            return d(r10, (Unit) r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object c(int r10, Intent r11) {
            throw null;
        }

        public Intent d(Context r10, Unit r11) {
            throw null;
        }
    }

    public ActivityResultCallerLauncher$resultContract$2(androidx.activity.result.a r10) {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final a invoke() {
        return new a(null);
    }
}
