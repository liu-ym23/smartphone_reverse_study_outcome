package a80;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.widgetdescriptor.template.config.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import h70.b;
import j70.e;
import j70.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c<T extends h70.b> extends a<T> implements o {
    @Override // j70.o
    public final /* synthetic */ Object[] a() {
        return null;
    }

    @Override // j70.o
    public final ViewGroup e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // j70.o
    public final boolean f() {
        return false;
    }

    @Override // j70.o
    public final /* synthetic */ boolean g() {
        return true;
    }

    @Override // j70.o
    public boolean h() {
        return !(this instanceof j);
    }

    @Override // j70.o
    public final boolean i() {
        return false;
    }

    @Override // j70.o
    public /* synthetic */ w70.a j() {
        return null;
    }

    @Override // a80.a
    public final e p() {
        return this;
    }

    public c(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        super(r100);
    }
}
