package c8c;

import android.view.ViewGroup;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.utils.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends LKUIStatus.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f22762f;

    public e(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
        this.f22762f = r100;
        i r101 = i.f444291a;
        this.f284258c = r101.g(R.string.Todo_Task_LoadFailedTryAgainLater);
        this.f284259d = R.drawable.illustration_placeholder_common_load_failed;
        r101.g(R.string.Lark_Legacy_CurrentPageEmpty);
    }
}
