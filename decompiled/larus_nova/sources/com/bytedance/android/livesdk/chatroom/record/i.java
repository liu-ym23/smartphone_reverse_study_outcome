package com.bytedance.android.livesdk.chatroom.record;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f108059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f108060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f108061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f108062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f108063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f108064f;

    public static final class a {
    }

    static {
    }

    public final void a(MotionEvent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.getAction();
        boolean r102 = true;
        if (r101 == 0) goto L26;
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L11;
        return;
    L11:
        if (this.f108061c == false) goto L13;
        return;
    L13:
        if (this.f108059a == true) goto L15;
        return;
    L15:
        if (Math.abs(this.f108063e - r100.getX()) < Math.abs(r100.getY() - this.f108062d)) goto L17;
    L19:
        r102 = false;
    L20:
        this.f108061c = r102;
        return;
    L17:
        if (Math.abs(r100.getY() - this.f108062d) <= this.f108060b) goto L19;
    L22:
        if (this.f108061c == true) goto L24;
        return;
    L24:
        if (this.f108059a == false) goto L42;
        f2.b(R.string.ttlive_record_recording_jump_other_room_tip, 0);
        this.f108059a = false;
        return;
    L42:
        return;
    L26:
        this.f108063e = r100.getX();
        this.f108062d = r100.getY();
        this.f108061c = false;
        DataCenter r103 = this.f108064f;
        if (r103 == null) goto L35;
        IAbilityCenter r104 = com.bytedance.android.live.core.utils.a0.a(r103);
        if (r104 == null) goto L35;
        IRoomRecordService r105 = (IRoomRecordService) r104.getAbility(IRoomRecordService.class);
        if (r105 == null) goto L35;
        if (r105.isRecording() != true) goto L35;
    L36:
        this.f108059a = r102;
        return;
    L35:
        r102 = false;
        goto L36
    }

    public i(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f108060b = 20;
        this.f108064f = r101;
        this.f108060b = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(r100));
    }
}
