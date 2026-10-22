package b72;

import android.content.Context;
import android.widget.EditText;
import com.bytedance.android.live.core.widget.j;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.message.h f17923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f17924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f17925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f17926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EditText f17927e;

    public h(com.bytedance.android.live.base.model.message.h r100, Context r101, String r102, String r103, EditText r104) {
        this.f17923a = r100;
        this.f17924b = r101;
        this.f17925c = r102;
        this.f17926d = r103;
        this.f17927e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("input guide chat failed due to " + ((Throwable) r100).getMessage() + ", guide chat id: " + this.f17923a.b());
        int r101 = com.bytedance.android.livesdk.interactivity.api.expression.h.f133214a;
        j r102 = com.bytedance.android.livesdk.interactivity.api.expression.h.a(this.f17924b, this.f17923a, this.f17925c);
        int r103 = c.f17907a;
        c.b(r102, this.f17923a, this.f17925c, this.f17926d, this.f17927e);
    }
}
