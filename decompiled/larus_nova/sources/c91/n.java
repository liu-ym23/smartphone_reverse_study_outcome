package c91;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.message.model.j4;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j4 f22847a;

    public n(j4 r100) {
        this.f22847a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f22847a.G();
        if (r101 == null) goto L6;
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r100.getContext(), y0.a(r101, null, 6));
        return;
    }
}
