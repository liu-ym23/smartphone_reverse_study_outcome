package bjb;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class f implements e28.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19274b;

    @Override // e28.c
    public final String getUserAgent() {
        String r100 = this.f19274b;
        if (r100 != null) goto L6;
        Context r101 = this.f19273a;
        yob.e.a().getClass();
        int r102 = com.ss.android.lark.language.service.impl.a.f431092f;
        com.ss.android.lark.language.service.impl.a.b.f431098a.getLanguageSetting();
        String r103 = xoc.a.a(r101);
        this.f19274b = r103;
        return r103;
    L6:
        return r100;
    }

    @Inject
    public f(@ApplicationContext Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f19273a = r100;
    }
}
