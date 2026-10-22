package c5;

import androidx.recyclerview.widget.DiffUtil;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lc5/v;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lc5/x;", "<init>", "()V", "oldItem", "newItem", "", Const.INTENT_KEY_PKGNAME, "(Lc5/x;Lc5/x;)Z", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class v extends DiffUtil.ItemCallback<x> {
    public static final v INSTANCE = new v();

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(x oldItem, x newItem) {
        kotlin.jvm.internal.p.i(oldItem, "oldItem");
        kotlin.jvm.internal.p.i(newItem, "newItem");
        if ((oldItem instanceof x.GroupHeader) && (newItem instanceof x.GroupHeader)) {
            return kotlin.jvm.internal.p.d(oldItem, newItem);
        }
        if ((oldItem instanceof x.SkillCard) && (newItem instanceof x.SkillCard)) {
            return kotlin.jvm.internal.p.d(oldItem, newItem);
        }
        if ((oldItem instanceof x.CliCard) && (newItem instanceof x.CliCard)) {
            return kotlin.jvm.internal.p.d(oldItem, newItem);
        }
        if ((oldItem instanceof x.d) && (newItem instanceof x.d)) {
            return true;
        }
        return (oldItem instanceof x.b) && (newItem instanceof x.b);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(x oldItem, x newItem) {
        kotlin.jvm.internal.p.i(oldItem, "oldItem");
        kotlin.jvm.internal.p.i(newItem, "newItem");
        if ((oldItem instanceof x.GroupHeader) && (newItem instanceof x.GroupHeader)) {
            return kotlin.jvm.internal.p.d(((x.GroupHeader) oldItem).getGroupId(), ((x.GroupHeader) newItem).getGroupId());
        }
        if ((oldItem instanceof x.SkillCard) && (newItem instanceof x.SkillCard)) {
            return kotlin.jvm.internal.p.d(((x.SkillCard) oldItem).getItem().getIdentifier(), ((x.SkillCard) newItem).getItem().getIdentifier());
        }
        if ((oldItem instanceof x.CliCard) && (newItem instanceof x.CliCard)) {
            return kotlin.jvm.internal.p.d(((x.CliCard) oldItem).getItem().getIdentifier(), ((x.CliCard) newItem).getItem().getIdentifier());
        }
        if ((oldItem instanceof x.d) && (newItem instanceof x.d)) {
            return true;
        }
        return (oldItem instanceof x.b) && (newItem instanceof x.b);
    }
}
