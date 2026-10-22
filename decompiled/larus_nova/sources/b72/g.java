package b72;

import android.widget.EditText;
import com.bytedance.android.live.core.widget.j;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f17920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f17921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EditText f17922c;

    public g(String r100, String r101, EditText r102) {
        this.f17920a = r100;
        this.f17921b = r101;
        this.f17922c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        j r102 = (j) r101.component1();
        com.bytedance.android.live.base.model.message.h r103 = (com.bytedance.android.live.base.model.message.h) r101.component2();
        int r104 = c.f17907a;
        c.b(r102, r103, this.f17920a, this.f17921b, this.f17922c);
    }
}
