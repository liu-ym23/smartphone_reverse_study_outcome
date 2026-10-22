package com.bytedance.android.live.revlink.link.biz.component.switchscenecompact;

import com.bytedance.android.live.revlink.link.biz.component.g;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "p3", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DoubleSceneCompactComponent$doubleEventTrackComponent$1 extends FunctionReferenceImpl implements Function3<Integer, Boolean, Long, Unit> {
    public DoubleSceneCompactComponent$doubleEventTrackComponent$1(g r100) {
        super(3, r100, g.class, "logChorusOver", "logChorusOver(IZJ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Boolean r101, Long r102) {
        invoke(r100.intValue(), r101.booleanValue(), r102.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, boolean r101, long r102) {
        ((g) this.receiver).a(r100, r101, r102);
    }
}
