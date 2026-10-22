package com.bytedance.android.livesdk.chatroom.room.backend;

import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 implements Consumer<BackendGeneratedData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f110819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f110820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f110821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function3 f110822d;

    @Override // io.reactivex.functions.Consumer
    public final void accept(BackendGeneratedData r100) {
        BackendGeneratedData r101 = r100;
        if (r101 == null) goto L5;
        List r102 = r101.getTypedDataList(this.f110819a);
    L6:
        if (r101 == null) goto L10;
        Long r103 = r101.getTypedErrorCode(this.f110819a);
        if (r103 == null) goto L10;
        long r104 = r103.longValue();
    L11:
        if (r101 == null) goto L13;
        String r105 = r101.getTypedErrorMsgMap(this.f110819a);
    L14:
        if (r101 == null) goto L20;
        if (r102 == null) goto L20;
        Function3 r106 = this.f110822d;
        if (r106 == null) goto L27;
        Unit r107 = (Unit) r106.invoke(r102, r101, null);
        return;
    L27:
        return;
    L20:
        Function0 r108 = this.f110820b;
        if (r108 == null) goto L23;
        Unit r109 = (Unit) r108.invoke();
    L23:
        Function2 r110 = this.f110821c;
        if (r110 == null) goto L29;
        Unit r111 = (Unit) r110.invoke(Long.valueOf(r104), r105);
        return;
    L29:
        return;
    L13:
        r105 = null;
    L10:
        r104 = 0;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public c0(Class r100, Function0 r101, Function2 r102, Function3 r103) {
        this.f110819a = r100;
        this.f110820b = r101;
        this.f110821c = r102;
        this.f110822d = r103;
    }
}
