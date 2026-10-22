package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BmDrawableResource extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private static Object f8688a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static List<WeakReference<BmDrawableResource>> f8689b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private a f8690c;

    public interface a {
    }

    private BmDrawableResource() {
        super(55, 0L);
        this.f8690c = null;
    }

    private static native boolean nativeSetListener(long j4, boolean z4);

    public BmDrawableResource(int i4, long j4) {
        super(i4, j4);
        this.f8690c = null;
    }
}
