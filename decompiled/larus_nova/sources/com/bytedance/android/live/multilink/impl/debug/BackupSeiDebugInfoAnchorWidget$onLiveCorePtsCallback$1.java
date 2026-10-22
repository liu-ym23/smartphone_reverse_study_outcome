package com.bytedance.android.live.multilink.impl.debug;

import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class BackupSeiDebugInfoAnchorWidget$onLiveCorePtsCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $error;
    final /* synthetic */ int $from;
    final /* synthetic */ String $key;
    final /* synthetic */ long $pts;
    final /* synthetic */ BackupSeiDebugInfoAnchorWidget this$0;

    public BackupSeiDebugInfoAnchorWidget$onLiveCorePtsCallback$1(BackupSeiDebugInfoAnchorWidget r100, int r101, int r102, long r103, String r104) {
        this.this$0 = r100;
        this.$error = r101;
        this.$from = r102;
        this.$pts = r103;
        this.$key = r104;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        TextView r100 = this.this$0.f83414b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveCorePtsTv");
    L5:
        r100.setText("onLiveCorePtsCallback: \n error: " + this.$error + ", \n from: " + this.$from + ", \n pts: " + this.$pts + ", \n key: " + this.$key);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
