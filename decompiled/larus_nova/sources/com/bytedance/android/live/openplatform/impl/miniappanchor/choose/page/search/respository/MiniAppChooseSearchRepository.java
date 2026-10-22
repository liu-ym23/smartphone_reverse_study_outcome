package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search.respository;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import np0.b;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/respository/MiniAppChooseSearchRepository;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseSearchRepository extends OpenPlatformContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f84295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<LinkedList<String>> f84296b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        qo0.a.c("choose_search", "destroy MiniAppChooseSearchRepository");
    }

    public MiniAppChooseSearchRepository(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f84295a = new m();
        this.f84296b = new b();
        qo0.a.c("choose_search", "init MiniAppChooseSearchRepository");
    }
}
