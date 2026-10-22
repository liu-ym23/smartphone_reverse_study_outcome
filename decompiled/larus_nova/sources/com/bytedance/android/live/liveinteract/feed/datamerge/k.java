package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdkapi.service.MessageHub;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes46.dex */
public interface k {
    void a(List<? extends ILinkPlayerInfoBridge> r100);

    BehaviorSubject<wg0.a> b();

    void c(wg0.a r100);

    List<ch0.e> d();

    ch0.a e();

    BehaviorSubject<List<ch0.e>> f();

    BehaviorSubject<List<LinkmicPositionItem>> g();

    MessageHub getMessageHub();

    int getShowFrom();

    BehaviorSubject<List<ch0.e>> h();

    BehaviorSubject<ConcurrentHashMap<String, pf0.a>> i();

    wg0.a j();

    List<LinkmicPositionItem> k();

    void l(ch0.a r100);

    void m(String r100, pf0.a r101);

    void n(j.a r100);

    List<ch0.e> o();

    void p(List<? extends LinkmicPositionItem> r100);

    void q(cj r100);

    Map<String, pf0.a> r();

    BehaviorSubject<ch0.a> s();

    void t(j.a r100);
}
