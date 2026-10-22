package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MenuProvider.java */
/* JADX INFO: loaded from: classes.dex */
public interface j {
    default void a(Menu r2) {
        Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.aiagent.plugin");
    }

    void a(Menu r1, MenuInflater r2);

    boolean a(MenuItem r1);

    default void b(Menu r2) {
        Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.aiagent.plugin");
    }
}
