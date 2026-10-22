package ai0;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import jc1.k;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f3720b;

    public b(Context r100, Ref.ObjectRef r101) {
        this.f3719a = r100;
        this.f3720b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(this.f3719a, (String) this.f3720b.element);
    }
}
