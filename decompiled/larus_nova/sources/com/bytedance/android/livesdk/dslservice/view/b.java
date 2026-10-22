package com.bytedance.android.livesdk.dslservice.view;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import yt1.f;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, f<? extends View>> f123014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, f<? extends View>> f123015b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, f<? extends View>> f123016c = null;

    static {
        f123014a = new HashMap();
        f123015b = new HashMap();
        f123016c = new HashMap();
    }

    public static void a(String r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        HashMap<String, f<? extends View>> r102 = f123016c;
        if (r102.containsKey(r100) == false) goto L5;
        return;
    L5:
        r102.put(r100, r101);
        SliceRender r103 = SliceRender.f50121o;
        DSLCustomViewMap$register2Slice$1 r104 = new DSLCustomViewMap$register2Slice$1(r101);
        r103.getClass();
        ElementTypes.b(r100, r104);
    }

    public static void b(String r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        HashMap<String, f<? extends View>> r102 = f123014a;
        if (r102.containsKey(r100) == false) goto L5;
        return;
    L5:
        r102.put(r100, r101);
        SliceRender r103 = SliceRender.f50121o;
        DSLCustomViewMap$register2Slice$1 r104 = new DSLCustomViewMap$register2Slice$1(r101);
        r103.getClass();
        ElementTypes.b(r100, r104);
    }
}
