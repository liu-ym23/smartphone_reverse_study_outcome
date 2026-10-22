package c5;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u000e"}, d2 = {"Lc5/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "container", "Lc5/l;", "callbacks", "<init>", "(Landroid/widget/FrameLayout;Lc5/l;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_PKGNAME, "Landroid/widget/FrameLayout;", "Lc5/l;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h extends RecyclerView.ViewHolder {
    private final SkillCardCallbacks callbacks;
    private final FrameLayout container;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrameLayout container, SkillCardCallbacks callbacks) {
        super(container);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(callbacks, "callbacks");
        this.container = container;
        this.callbacks = callbacks;
    }

    public final void a() {
        InterfaceC5063a<View> interfaceC5063aG = this.callbacks.g();
        View viewInvoke = interfaceC5063aG != null ? interfaceC5063aG.invoke() : null;
        if (viewInvoke == null) {
            this.container.removeAllViews();
            return;
        }
        if (this.container.getChildCount() == 1 && this.container.getChildAt(0) == viewInvoke) {
            return;
        }
        this.container.removeAllViews();
        ViewParent parent = viewInvoke.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(viewInvoke);
        }
        this.container.addView(viewInvoke);
    }

    public final void b() {
        this.container.removeAllViews();
    }
}
