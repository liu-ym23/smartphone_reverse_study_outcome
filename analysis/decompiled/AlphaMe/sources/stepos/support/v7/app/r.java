package stepos.support.v7.app;

import android.view.ActionMode;
import android.view.Window;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public abstract class r extends AbstractC0869n {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0873s f14584c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(AbstractC0873s abstractC0873s, Window.Callback callback) {
        super(abstractC0873s, callback);
        this.f14584c = abstractC0873s;
    }

    public final ActionMode a(ActionMode.Callback callback) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        AbstractC0873s abstractC0873s = this.f14584c;
        boolean z4 = true;
        j.g gVar = new j.g(abstractC0873s.f14509a, callback, 1);
        boolean z5 = false;
        if (callback != null) {
            String name = callback.getClass().getName();
            if (name.equals("com.android.internal.policy.impl.PhoneWindow$DecorView$ActionModeCallbackWrapper") || name.equals("com.android.internal.policy.PhoneWindow$DecorView$ActionModeCallback2Wrapper")) {
                try {
                    Field declaredField = callback.getClass().getDeclaredField("mWrapped");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(callback);
                    if (obj != null) {
                        name = obj.getClass().getName();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (!name.equals("android.widget.AbsListView$MultiChoiceModeWrapper") && !name.equals("stepos.support.v7.widget.StepOSRecyclerView$MultiChoiceModeWrapper")) {
                z4 = false;
            }
            z5 = z4;
        }
        K3.c cVarI = z5 ? abstractC0873s.i(gVar) : null;
        if (cVarI == null) {
            cVarI = abstractC0873s.j(gVar);
        }
        if (cVarI != null) {
            return gVar.i(cVarI);
        }
        return null;
    }
}
