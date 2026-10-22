package com.bytedance.android.livesdk.chatroom.room.backend;

import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.android.livesdkapi.model.ErrorBackendItem;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements Consumer<BackendItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f110815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f110816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f110817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function3 f110818d;

    @Override // io.reactivex.functions.Consumer
    public final void accept(BackendItem r100) {
        BackendItem r101 = r100;
        if ((r101 instanceof ErrorBackendItem) == false) goto L11;
        Function2 r102 = this.f110815a;
        if (r102 == null) goto L7;
        ErrorBackendItem r103 = (ErrorBackendItem) r101;
        Unit r104 = (Unit) r102.invoke(Long.valueOf(r103.errorCode), r103.errorMsg);
    L7:
        Function0 r105 = this.f110816b;
        if (r105 == null) goto L27;
        Unit r106 = (Unit) r105.invoke();
        return;
    L27:
        return;
    L11:
        if (r101 == null) goto L13;
        List r107 = r101.getDataList(this.f110817c);
    L14:
        if (r101 == null) goto L20;
        if (r107 == null) goto L20;
        Function3 r108 = this.f110818d;
        if (r108 == null) goto L29;
        Unit r109 = (Unit) r108.invoke(r107, null, r101);
        return;
    L29:
        return;
    L20:
        Function0 r110 = this.f110816b;
        if (r110 == null) goto L23;
        Unit r111 = (Unit) r110.invoke();
    L23:
        Function2 r112 = this.f110815a;
        if (r112 == null) goto L31;
        Unit r113 = (Unit) r112.invoke(0L, "errorMsg");
        return;
    L31:
        return;
    L13:
        r107 = null;
        goto L14
    }

    public b0(Function2 r100, Function0 r101, Class r102, Function3 r103) {
        this.f110815a = r100;
        this.f110816b = r101;
        this.f110817c = r102;
        this.f110818d = r103;
    }
}
