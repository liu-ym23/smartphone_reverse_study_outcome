package com.bytedance.android.live.messagewindow.framework.process;

import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements h71.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h71.b f83193a;

    @Override // h71.e
    public final float a() {
        h71.b r100 = this.f83193a;
        float r101 = 0.0f;
        if (r100 == null) goto L14;
        HashMap<MsgWindowAdjustSource, h71.a> r102 = r100.k();
        if (r102 == null) goto L14;
        Iterator<Map.Entry<MsgWindowAdjustSource, h71.a>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<MsgWindowAdjustSource, h71.a> r104 = r103.next();
        Float r105 = r104.getValue().f483970c;
        if (r105 == null) goto L8;
        float r106 = r105.floatValue();
        if (r104.getValue().f483968a == false) goto L8;
        r101 = Math.max(r101, r106 + r101);
    L14:
        return r101;
    }

    @Override // h71.e
    public final float b() {
        h71.b r100 = this.f83193a;
        float r101 = 0.0f;
        if (r100 == null) goto L14;
        HashMap<MsgWindowAdjustSource, h71.a> r102 = r100.k();
        if (r102 == null) goto L14;
        Iterator<Map.Entry<MsgWindowAdjustSource, h71.a>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<MsgWindowAdjustSource, h71.a> r104 = r103.next();
        Float r105 = r104.getValue().f483972e;
        if (r105 == null) goto L8;
        float r106 = r105.floatValue();
        if (r104.getValue().f483968a == false) goto L8;
        r101 = Math.max(r101, r106 + r101);
    L14:
        return r101;
    }

    @Override // h71.e
    public final float c() {
        h71.b r100 = this.f83193a;
        float r101 = 0.0f;
        if (r100 == null) goto L14;
        HashMap<MsgWindowAdjustSource, h71.a> r102 = r100.k();
        if (r102 == null) goto L14;
        Iterator<Map.Entry<MsgWindowAdjustSource, h71.a>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<MsgWindowAdjustSource, h71.a> r104 = r103.next();
        Float r105 = r104.getValue().f483971d;
        if (r105 == null) goto L8;
        float r106 = r105.floatValue();
        if (r104.getValue().f483968a == false) goto L8;
        r101 = Math.max(r101, r106 + r101);
    L14:
        return r101;
    }

    @Override // h71.e
    public final float d() {
        h71.b r100 = this.f83193a;
        float r101 = 0.0f;
        if (r100 == null) goto L14;
        HashMap<MsgWindowAdjustSource, h71.a> r102 = r100.k();
        if (r102 == null) goto L14;
        Iterator<Map.Entry<MsgWindowAdjustSource, h71.a>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<MsgWindowAdjustSource, h71.a> r104 = r103.next();
        Float r105 = r104.getValue().f483969b;
        if (r105 == null) goto L8;
        float r106 = r105.floatValue();
        if (r104.getValue().f483968a == false) goto L8;
        r101 = Math.max(r101, r106 + r101);
    L14:
        return r101;
    }

    public e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "liveComponentsStatusHolder");
        this.f83193a = r100;
    }
}
