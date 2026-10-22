package b;

import android.view.View;
import androidx.activity.R$id;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "Lb/L;", "onBackPressedDispatcherOwner", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Lb/L;)V", "activity_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class P {
    public static final void a(View view, L onBackPressedDispatcherOwner) {
        kotlin.jvm.internal.p.i(view, "<this>");
        kotlin.jvm.internal.p.i(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R$id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
