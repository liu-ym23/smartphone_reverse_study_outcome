package com.bytedance.android.live.profit.format.voicechat.rtc;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ProfitRTCService$rtcEngineEventListener$2$1$onAudioVolumeChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $speakers;
    final /* synthetic */ ProfitRTCService$rtcEngineEventListener$2.a this$0;

    public ProfitRTCService$rtcEngineEventListener$2$1$onAudioVolumeChanged$1(ProfitRTCService$rtcEngineEventListener$2.a r100, List r101) {
        this.this$0 = r100;
        this.$speakers = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = this.$speakers.size();
        String[] r101 = new String[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        ((lu0.b) ListProtector.get(this.$speakers, r102)).getClass();
        r101[r102] = null;
        r102 = r102 + 1;
        goto L3
    L5:
        int r103 = this.$speakers.size();
        boolean[] r104 = new boolean[r103];
        int r105 = 0;
    L6:
        if (r105 >= r103) goto L8;
        ((lu0.b) ListProtector.get(this.$speakers, r105)).getClass();
        r104[r105] = false;
        r105 = r105 + 1;
        goto L6
    L8:
        int r106 = this.$speakers.size();
        int[] r107 = new int[r106];
        int r108 = 0;
    L9:
        if (r108 >= r106) goto L11;
        ((lu0.b) ListProtector.get(this.$speakers, r108)).getClass();
        r107[r108] = 0;
        r108 = r108 + 1;
        goto L9
    L11:
        int r109 = this.$speakers.size();
        int[] r110 = new int[r109];
        int r111 = 0;
    L12:
        if (r111 >= r109) goto L14;
        ((lu0.b) ListProtector.get(this.$speakers, r111)).getClass();
        r110[r111] = 0;
        r111 = r111 + 1;
        goto L12
    L14:
        Iterator<a> r112 = this.this$0.f87686a.this$0.f87679b.iterator();
    L16:
        if (r112.hasNext() == false) goto L18;
        r112.next().u();
        goto L16
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
