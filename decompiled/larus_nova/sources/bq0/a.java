package bq0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20011a;

    public abstract int a();

    public abstract BusinessToolType b();

    public abstract String c();

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "description");
        this.f20011a = r100;
    }
}
