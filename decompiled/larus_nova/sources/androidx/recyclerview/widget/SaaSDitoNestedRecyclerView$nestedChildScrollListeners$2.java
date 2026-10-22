package androidx.recyclerview.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class SaaSDitoNestedRecyclerView$nestedChildScrollListeners$2 extends Lambda implements Function0<List<RecyclerView.OnScrollListener>> {
    public static final SaaSDitoNestedRecyclerView$nestedChildScrollListeners$2 INSTANCE = null;

    static {
        INSTANCE = new SaaSDitoNestedRecyclerView$nestedChildScrollListeners$2();
    }

    public SaaSDitoNestedRecyclerView$nestedChildScrollListeners$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<RecyclerView.OnScrollListener> invoke2() {
        return new ArrayList();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<RecyclerView.OnScrollListener> invoke() {
        return invoke2();
    }
}
