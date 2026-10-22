package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    static {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        boolean r0 = true;
    L6:
        COMPAT_OVERLAP_ANCHOR = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public AppCompatPopupWindow(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        init(r6, r7, r5, 0);
    }

    public AppCompatPopupWindow(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8, r5, r6);
        init(r7, r8, r5, r6);
    }

    private void init(Context r3, AttributeSet r4, int r5, int r6) {
        y r7 = y.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.PopupWindow, r5, r6);
        if (r7.g(ZeusTransformUtils.mapRes(R.styleable.PopupWindow_overlapAnchor, "styleable", "PopupWindow_overlapAnchor")) == false) goto L5;
        setSupportOverlapAnchor(r7.a(ZeusTransformUtils.mapRes(R.styleable.PopupWindow_overlapAnchor, "styleable", "PopupWindow_overlapAnchor"), false));
    L5:
        setBackgroundDrawable(r7.a(ZeusTransformUtils.mapRes(R.styleable.PopupWindow_android_popupBackground, "styleable", "PopupWindow_android_popupBackground")));
        r7.b();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r2, int r3, int r4) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        super.showAsDropDown(r2, r3, r4);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r4 = r4 - r2.getHeight();
        goto L7
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r2, int r3, int r4, int r5) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        super.showAsDropDown(r2, r3, r4, r5);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r4 = r4 - r2.getHeight();
        goto L7
    }

    @Override // android.widget.PopupWindow
    public void update(View r7, int r8, int r9, int r10, int r11) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        super.update(r7, r8, r9, r10, r11);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r9 = r9 - r7.getHeight();
        goto L7
    }

    private void setSupportOverlapAnchor(boolean r2) {
        if (COMPAT_OVERLAP_ANCHOR == false) goto L5;
        this.mOverlapAnchor = r2;
        return;
    L5:
        androidx.core.widget.f.a(this, r2);
    }
}
