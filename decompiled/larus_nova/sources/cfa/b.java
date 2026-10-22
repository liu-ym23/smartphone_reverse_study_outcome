package cfa;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.chat.p;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {
    public static final ICoreInputAbility a() {
        IObricActivityStackService r100 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r100 == null) goto L5;
        Activity r101 = r100.c();
    L7:
        if ((r101 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r102 = (FragmentActivity) r101;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        if (p.e(r102) == false) goto L14;
        t1a.b r103 = p.a(r102);
    L31:
        if (r103 != null) goto L33;
        return null;
    L33:
        return (ICoreInputAbility) r103.getAbility(ICoreInputAbility.class);
    L14:
        t1a.b r104 = p.a(r102);
        if (r104 == null) goto L17;
    L16:
        r103 = r104;
        goto L31
    L17:
        Iterator<T> r105 = r102.getSupportFragmentManager().getFragments().iterator();
    L19:
        if (r105.hasNext() == false) goto L30;
        Fragment r106 = (Fragment) r105.next();
        Intrinsics.checkNotNull(r106);
        if (r106.isAdded() == true) goto L23;
    L27:
        r104 = null;
    L28:
        if (r104 == null) goto L19;
    L23:
        if (r106.isVisible() == false) goto L27;
        r104 = s1a.a.g(r106);
        if (((ICoreInputAbility) r104.getAbility(ICoreInputAbility.class)) != null) goto L28;
    L30:
        r103 = null;
        goto L31
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }
}
