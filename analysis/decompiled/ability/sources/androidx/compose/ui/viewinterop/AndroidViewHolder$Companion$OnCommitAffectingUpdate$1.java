package androidx.compose.ui.viewinterop;

import C7.r;
import S7.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "it", "LC7/r;", "invoke", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "<anonymous>"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes2.dex */
public final class AndroidViewHolder$Companion$OnCommitAffectingUpdate$1 extends Lambda implements k {
    public static final AndroidViewHolder$Companion$OnCommitAffectingUpdate$1 INSTANCE = new AndroidViewHolder$Companion$OnCommitAffectingUpdate$1();

    public AndroidViewHolder$Companion$OnCommitAffectingUpdate$1() {
        super(1);
    }

    @Override // S7.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AndroidViewHolder) obj);
        return r.f317a;
    }

    public final void invoke(AndroidViewHolder androidViewHolder) {
        androidViewHolder.getHandler().post(new a(0, androidViewHolder.runUpdate));
    }
}
