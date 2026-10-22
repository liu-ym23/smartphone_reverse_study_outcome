package co5;

import android.content.Context;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f24626e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f24627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SceneTemplateData f24628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24630d;

    public static final class a {
    }

    static {
    }

    public e(Context r100, SceneTemplateData r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f24627a = r100;
        this.f24628b = r101;
        this.f24629c = r102;
        this.f24630d = r103;
    }
}
