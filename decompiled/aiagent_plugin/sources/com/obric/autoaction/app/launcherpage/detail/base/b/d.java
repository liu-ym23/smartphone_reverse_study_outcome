package com.obric.autoaction.app.launcherpage.detail.base.b;

import com.obric.autoaction.app.launcherpage.detail.base.h;
import com.obric.autoaction.app.launcherpage.detail.base.i;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.DetailParams;
import com.obric.eventkit.task.model.EventTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.b.ak;

/* JADX INFO: compiled from: IDetailViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d {

    /* JADX INFO: compiled from: IDetailViewModel.kt */
    public static final class a {
        public static boolean a(d r2) {
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
            return false;
        }
    }

    void a(h r1);

    void a(DetailParams r1, c r2);

    void a(EventTask r1, String r2);

    kotlinx.coroutines.b.h<i> e();

    kotlinx.coroutines.b.h<com.obric.autoaction.app.launcherpage.detail.base.c> f();

    ak<Boolean> g();

    String i();

    EventTask l();

    EventTask m();

    String o();

    boolean q();

    boolean r();
}
