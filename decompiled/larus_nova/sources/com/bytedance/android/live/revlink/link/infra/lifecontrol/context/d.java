package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface d extends com.bytedance.android.live.revlink.impl.global.c {
    String Ab();

    long G();

    Disposable Pi(Function1<? super b03.b, Unit> r100);

    PublishSubject<Integer> a9();

    NextLiveData<Long> bo();

    String eg();

    AnchorLinkUserCenterV2 getAnchorLinkUserCenter();

    com.bytedance.android.live.revlink.link.domain.anchorimpl.j getCommonService();

    int getContainerWidth();

    x11.a getInternalLinkService();

    ld.a getLinkDataSet();

    IRoom getRoom();

    wq2.f getRoomDataCenterService();

    long getRoomID();

    int getScene();

    NextLiveData<o51.e> getUiLayout();

    NextLiveData<f31.f> hh();

    com.bytedance.android.live.revlink.link.domain.anchorimpl.m im();

    x51.a k4();

    int l();

    com.bytedance.android.live.revlink.link.domain.anchorimpl.l md();

    boolean r9();

    PublishSubject<m> t();

    Disposable x7(Function0<Unit> r100, Function0<Unit> r101);
}
