package c5;

import Y4.D;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e¨\u0006\u000f"}, d2 = {"Lc5/j;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "LY4/D;", "binding", "Lc5/l;", "callbacks", "<init>", "(LY4/D;Lc5/l;)V", "Lc5/x$c;", "item", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lc5/x$c;)V", "LY4/D;", "Lc5/l;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j extends RecyclerView.ViewHolder {
    private final D binding;
    private final SkillCardCallbacks callbacks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(D binding, SkillCardCallbacks callbacks) {
        super(binding.b());
        kotlin.jvm.internal.p.i(binding, "binding");
        kotlin.jvm.internal.p.i(callbacks, "callbacks");
        this.binding = binding;
        this.callbacks = callbacks;
    }

    public static final void c(j jVar, x.GroupHeader groupHeader, View view) {
        InterfaceC5074l<x.GroupHeader, Y8.t> interfaceC5074lC = jVar.callbacks.c();
        if (interfaceC5074lC != null) {
            interfaceC5074lC.invoke(groupHeader);
        }
    }

    public final void b(final x.GroupHeader item) {
        kotlin.jvm.internal.p.i(item, "item");
        this.binding.tvGroupTitle.setText(item.getTitle());
        TextView ivChevron = this.binding.ivChevron;
        kotlin.jvm.internal.p.h(ivChevron, "ivChevron");
        ivChevron.setVisibility(item.getShowChevron() ? 0 : 8);
        if (item.getIsClickable()) {
            this.binding.b().setClickable(true);
            this.binding.b().setOnClickListener(new View.OnClickListener() { // from class: c5.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.c(this.f15457a, item, view);
                }
            });
        } else {
            this.binding.b().setClickable(false);
            this.binding.b().setOnClickListener(null);
        }
    }
}
