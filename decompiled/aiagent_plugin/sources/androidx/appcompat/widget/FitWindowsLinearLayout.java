package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements r {
    private r.a mListener;

    public FitWindowsLinearLayout(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public FitWindowsLinearLayout(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.appcompat.widget.r
    public void setOnFitSystemWindowsListener(r.a r3) {
        this.mListener = (r.a) ZeusTransformUtils.wrapperContextForParams(r3, r.a.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r2) {
        r.a r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        return super.fitSystemWindows(r2);
    }
}
