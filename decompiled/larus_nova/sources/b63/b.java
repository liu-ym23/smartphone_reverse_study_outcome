package b63;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.guessulike.model.FeedbackItem;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f17832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedbackItem f17833b;

    public b(Function3 r100, FeedbackItem r101) {
        this.f17832a = r100;
        this.f17833b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f17832a.invoke("feedback", Integer.valueOf(this.f17833b.getType()), this.f17833b.getText());
    }
}
