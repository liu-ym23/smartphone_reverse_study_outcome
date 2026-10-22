package com.bytedance.android.live.room.navi.userinfo.util;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ long $durationInMs;
    final /* synthetic */ View $hideView;
    final /* synthetic */ Function2 $onEndOrCancel;
    final /* synthetic */ View $showView;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo.util.LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1 this$0;

        public AnonymousClass3(LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1 r100) {
            this.this$0 = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(q4 r100) {
            Intrinsics.checkNotNullParameter(r100, "$receiver");
            r100.d(new AnonymousClass1(this));
            r100.a(this.this$0.$durationInMs);
            r100.d(new AnonymousClass2(this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(q4 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1(View r100, View r101, Function2 r102, long r103) {
        this.$showView = r100;
        this.$hideView = r101;
        this.$onEndOrCancel = r102;
        this.$durationInMs = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(q4 r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.f159134e = new AnonymousClass1(this);
        r100.f159135f = new AnonymousClass2(this);
        r100.c(new AnonymousClass3(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(q4 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
