package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¨\u0006\u0012"}, d2 = {"Landroidx/recyclerview/widget/CustomStubView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "replaceView", "", "inflatedView", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "replaceWithInflatedView", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomStubView extends View {
    public CustomStubView(Context r100) {
        super(r100);
    }

    public CustomStubView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    private final void replaceWithInflatedView(View r100, ViewGroup.LayoutParams r101) {
        ViewParent r102 = getParent();
        if ((r102 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r102;
    L6:
        if (r103 == null) goto L12;
        ViewGroup.LayoutParams r104 = getLayoutParams();
        int r105 = r103.indexOfChild(this);
        r103.removeView(this);
        r100.setId(getId());
        if (r101 != null) goto L10;
        r101 = r104;
    L10:
        r103.addView(r100, r105, r101);
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void replaceView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "inflatedView");
        replaceWithInflatedView(r100, r101);
    }

    public CustomStubView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public static /* synthetic */ void replaceView$default(CustomStubView r100, View r101, ViewGroup.LayoutParams r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.replaceView(r101, r102);
    }
}
