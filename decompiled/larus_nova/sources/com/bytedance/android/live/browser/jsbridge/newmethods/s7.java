package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.timon.calendar.ResultCode;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class s7<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i7 f63647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f63648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f63649c;

    public static final class a implements com.bytedance.timon.calendar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s7 f63650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f63651b;

        public a(s7 r100, SingleEmitter r101) {
            this.f63650a = r100;
            this.f63651b = r101;
        }

        @Override // com.bytedance.timon.calendar.a
        public final void a(boolean r100, ResultCode r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "errorCode");
            Intrinsics.checkNotNullParameter(r102, "msg");
            if (r100 == false) goto L5;
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_system_calendar_cancel", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_id", this.f63650a.f63648b), TuplesKt.to("anchor_id", this.f63650a.f63649c)}), new Object[0]);
            this.f63651b.onSuccess(ICalendarManager.ErrorCode.Success);
            return;
        L5:
            int r103 = j7.f63472b[r101.ordinal()];
            if (r103 == 1) goto L16;
            if (r103 != 2) goto L9;
            this.f63651b.onSuccess(ICalendarManager.ErrorCode.ArgumentError);
            return;
        L9:
            if (r103 != 3) goto L11;
            this.f63651b.onSuccess(ICalendarManager.ErrorCode.NoPermission);
            return;
        L11:
            if (r103 == 4) goto L13;
            this.f63651b.onSuccess(ICalendarManager.ErrorCode.Unknown);
            return;
        L13:
            this.f63651b.onSuccess(ICalendarManager.ErrorCode.NoAccount);
            return;
        L16:
            this.f63651b.onSuccess(ICalendarManager.ErrorCode.NotFound);
        }
    }

    public s7(i7 r100, String r101, String r102) {
        this.f63647a = r100;
        this.f63648b = r101;
        this.f63649c = r102;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<ICalendarManager.ErrorCode> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Function1<? super com.bytedance.timon.calendar.b, Unit> r101 = com.bytedance.timon.calendar.c.f270568a;
        com.bytedance.timon.calendar.c.a(this.f63647a.getContext(), this.f63648b, new a(this, r100));
    }
}
