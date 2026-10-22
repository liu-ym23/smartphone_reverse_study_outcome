package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BmDrawableResource extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f32826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<WeakReference<BmDrawableResource>> f32827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f32828c;

    public interface a {
    }

    private static native boolean nativeSetListener(long r100, boolean r101);

    static {
        f32826a = new Object();
        f32827b = new ArrayList();
    }

    private BmDrawableResource() {
        super(55, 0);
        this.f32828c = null;
    }

    public BmDrawableResource(int r100, long r101) {
        super(r100, r101);
        this.f32828c = null;
    }
}
