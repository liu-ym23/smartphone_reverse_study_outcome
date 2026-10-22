package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t51.f;
import t51.h;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/f;", AbsMethodDelegate.TAG_INVOKE, "()Lt51/f;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MediaDefaultConfig$entrance$2 extends FunctionReferenceImpl implements Function0<f> {
    public MediaDefaultConfig$entrance$2(MediaDefaultConfig r100) {
        super(0, r100, MediaDefaultConfig.class, "initDefaultEntrance", "initDefaultEntrance()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevConfigEntrance;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final f invoke2() {
        MediaDefaultConfig r100 = (MediaDefaultConfig) this.receiver;
        int r101 = MediaDefaultConfig.f98591d;
        r100.getClass();
        f r102 = new f();
        ArrayList r103 = new ArrayList();
        h r104 = new h();
        o51.f.j r105 = o51.f.j.f522068e;
        r104.d(r105.f522057b);
        r104.c(r105.f522056a);
        Unit r106 = Unit.INSTANCE;
        r103.add(r104);
        h r107 = new h();
        o51.f.b r108 = o51.f.b.f522060e;
        r107.d(r108.f522057b);
        r107.c(r108.f522056a);
        r103.add(r107);
        h r109 = new h();
        o51.f.c r110 = o51.f.c.f522061e;
        r109.d(r110.f522057b);
        r109.c(r110.f522056a);
        r103.add(r109);
        r102.b(r103);
        return r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ f invoke() {
        return invoke2();
    }
}
