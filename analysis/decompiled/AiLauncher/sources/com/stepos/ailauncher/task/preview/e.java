package com.stepos.ailauncher.task.preview;

import Y8.j;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.Pair;
import v9.C5685n;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ5\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/task/preview/e;", "", "<init>", "()V", "Landroid/os/Bundle;", "extras", "", "maxEdgePx", "Lkotlin/Pair;", Const.INTENT_KEY_PKGNAME, "(Landroid/os/Bundle;I)Lkotlin/Pair;", "width", "height", Const.INTENT_KEY_APIKEY, "(III)Lkotlin/Pair;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final e INSTANCE = new e();

    public static /* synthetic */ Pair c(e eVar, Bundle bundle, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 4096;
        }
        return eVar.b(bundle, i10);
    }

    public final Pair<Integer, Integer> a(int width, int height, int maxEdgePx) {
        if (width <= 0 || height <= 0 || maxEdgePx <= 0) {
            return null;
        }
        return j.a(Integer.valueOf(C5685n.j(width, maxEdgePx)), Integer.valueOf(C5685n.j(height, maxEdgePx)));
    }

    public final Pair<Integer, Integer> b(Bundle extras, int maxEdgePx) {
        return a(extras != null ? extras.getInt("width") : 0, extras != null ? extras.getInt("height") : 0, maxEdgePx);
    }
}
