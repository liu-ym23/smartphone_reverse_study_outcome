package c5;

import Y4.B;
import Y4.D;
import Y4.E;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017¨\u0006\u001a"}, d2 = {"Lc5/w;", "Landroidx/recyclerview/widget/ListAdapter;", "Lc5/x;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lc5/l;", "callbacks", "<init>", "(Lc5/l;)V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "LY8/t;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "onViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Lc5/l;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w extends ListAdapter<x, RecyclerView.ViewHolder> {
    public static final int TYPE_CLI_CARD = 4;
    public static final int TYPE_ESSENTIAL_SLOT = 3;
    public static final int TYPE_GROUP_HEADER = 0;
    public static final int TYPE_LOADING_FOOTER = 2;
    public static final int TYPE_SKILL_CARD = 1;
    private final SkillCardCallbacks callbacks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(SkillCardCallbacks callbacks) {
        super(v.INSTANCE);
        kotlin.jvm.internal.p.i(callbacks, "callbacks");
        this.callbacks = callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        x item = getItem(position);
        if (item instanceof x.GroupHeader) {
            return 0;
        }
        if (item instanceof x.SkillCard) {
            return 1;
        }
        if (item instanceof x.CliCard) {
            return 4;
        }
        if (item instanceof x.d) {
            return 2;
        }
        if (item instanceof x.b) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        x item = getItem(position);
        if (item instanceof x.GroupHeader) {
            ((j) holder).b((x.GroupHeader) item);
            return;
        }
        if (item instanceof x.SkillCard) {
            ((u) holder).j((x.SkillCard) item);
            return;
        }
        if (item instanceof x.CliCard) {
            ((g) holder).h((x.CliCard) item);
        } else {
            if (item instanceof x.d) {
                return;
            }
            if (!(item instanceof x.b)) {
                throw new NoWhenBranchMatchedException();
            }
            ((h) holder).a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            D dC = D.c(layoutInflaterFrom, parent, false);
            kotlin.jvm.internal.p.h(dC, "inflate(...)");
            return new j(dC, this.callbacks);
        }
        if (viewType == 1) {
            B bC = B.c(layoutInflaterFrom, parent, false);
            kotlin.jvm.internal.p.h(bC, "inflate(...)");
            return new u(bC, this.callbacks);
        }
        if (viewType == 2) {
            E eC = E.c(layoutInflaterFrom, parent, false);
            kotlin.jvm.internal.p.h(eC, "inflate(...)");
            return new k(eC);
        }
        if (viewType == 3) {
            FrameLayout frameLayout = new FrameLayout(parent.getContext());
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new h(frameLayout, this.callbacks);
        }
        if (viewType == 4) {
            B bC2 = B.c(layoutInflaterFrom, parent, false);
            kotlin.jvm.internal.p.h(bC2, "inflate(...)");
            return new g(bC2, this.callbacks);
        }
        throw new IllegalStateException("Unknown viewType: " + viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        kotlin.jvm.internal.p.i(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof h) {
            ((h) holder).b();
        }
    }
}
