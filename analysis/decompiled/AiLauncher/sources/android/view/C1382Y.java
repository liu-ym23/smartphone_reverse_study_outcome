package android.view;

import android.view.View;
import android.view.viewmodel.R$id;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "Landroidx/lifecycle/W;", "viewModelStoreOwner", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Landroidx/lifecycle/W;)V", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.lifecycle.Y, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1382Y {
    public static final void a(View view, W w10) {
        p.i(view, "<this>");
        view.setTag(R$id.view_tree_view_model_store_owner, w10);
    }
}
