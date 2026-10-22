package androidx.viewpager2.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FragmentViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends RecyclerView.u {
    private b(FrameLayout r1) {
        super(r1);
    }

    static b a(ViewGroup r3) {
        FrameLayout r0 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.setId(ViewCompat.a());
        r0.setSaveEnabled(false);
        return new b(r0);
    }

    FrameLayout E() {
        return (FrameLayout) ZeusTransformUtils.preCheckCast(this.f2390a, FrameLayout.class, "com.obric.aiagent.plugin");
    }
}
