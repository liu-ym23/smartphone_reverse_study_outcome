package com.bytedance.android.livesdk.dsl.recyclerview;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.TabItemAdapter;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.n;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, bu1.a> f122792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Function0<Unit>, Unit> f122793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<k> f122794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f122795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f122796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f122797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, ? extends Object> f122798g;

    public final Activity getActivity() {
        return this.f122795d;
    }

    public c(Activity r100, RecyclerView r101, TabItemAdapter r102, n r103, f r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "adapter");
        Intrinsics.checkNotNullParameter(r103, "triangleManager");
        Intrinsics.checkNotNullParameter(r104, "templateStore");
        this.f122795d = r100;
        this.f122796e = r103;
        this.f122797f = r104;
        this.f122798g = null;
        HashMap<String, bu1.a> r105 = new HashMap();
        this.f122792a = r105;
        this.f122794c = new ArrayList();
        bu1.b r106 = new bu1.b();
        String r107 = DSLActionEnum.ListItemRefresh.getText();
        Intrinsics.checkNotNullParameter(r107, "key");
        Intrinsics.checkNotNullParameter(r106, "action");
        r105.put(r107, r106);
    }
}
