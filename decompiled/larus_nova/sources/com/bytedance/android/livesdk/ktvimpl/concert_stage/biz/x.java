package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ChorusUserType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f143755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f143756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JoinChorusConcertStatus f143757c;

    public x() {
        this(0);
    }

    public final String toString() {
        return "JoinChorusConcertState(chorusId='" + this.f143755a + "', userType=" + this.f143756b + ", joinStatus=" + this.f143757c + ')';
    }

    public x(int r100) {
        int r101 = ChorusUserType.ChorusUserType_Unknow.getType();
        JoinChorusConcertStatus r102 = JoinChorusConcertStatus.NOT_JOINED;
        Intrinsics.checkNotNullParameter("0", "chorusId");
        Intrinsics.checkNotNullParameter(r102, "joinStatus");
        this.f143755a = "0";
        this.f143756b = r101;
        this.f143757c = r102;
    }
}
