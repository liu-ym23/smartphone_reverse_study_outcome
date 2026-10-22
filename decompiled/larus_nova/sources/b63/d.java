package b63;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.guessulike.model.FeedbackItem;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f17836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedbackItem f17837b;

    public d(Function3 r100, FeedbackItem r101) {
        this.f17836a = r100;
        this.f17837b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f17836a.invoke("feedback", Integer.valueOf(this.f17837b.getType()), this.f17837b.getText());
    }
}
