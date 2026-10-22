package ah3;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Queue;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Context, HashMap<String, Queue<WeakReference<View>>>> f3412a = null;

    static {
        f3412a = new WeakHashMap();
    }
}
