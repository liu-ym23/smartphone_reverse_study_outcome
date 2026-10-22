package b63;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.guessulike.model.FeedbackItem;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f17834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedbackItem f17835b;

    public c(Function3 r100, FeedbackItem r101) {
        this.f17834a = r100;
        this.f17835b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f17834a.invoke("more", Integer.valueOf(this.f17835b.getType()), this.f17835b.getText());
    }
}
