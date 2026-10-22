package bm4;

import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.dux.theme.ForceDayNight;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19592a = 0;

    public static final class a {
    }

    static {
    }

    public b(Context r100, Context r101, ForceDayNight r102) {
        Intrinsics.checkNotNullParameter(r100, "themedContext");
        Intrinsics.checkNotNullParameter(r101, "originContext");
        Intrinsics.checkNotNullParameter(r102, "forceDayNight");
        super(r100);
    }
}
