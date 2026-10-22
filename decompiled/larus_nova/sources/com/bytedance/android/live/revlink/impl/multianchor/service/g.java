package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public interface g {
    void A(String r100, String r101);

    void X0(String r100, String r101);

    NextLiveData<String> c();

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    String mo8197c();

    long d();

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    NextLiveData<String> mo8198d();

    void e(String r100);

    void f(String r100, String r101);

    void f0(boolean r100);

    NextLiveData<Boolean> g();

    NextLiveData<Boolean> getBattleStatus();

    int getCloudCollaboratePanelType();

    void h();

    void i(boolean r100, String r101, List<String> r102, String r103, String r104);

    void j(com.bytedance.android.live.revlink.link.domain.anchorimpl.j r100);

    void k(String r100, String r101, String r102);

    boolean l();

    void m(String r100, String r101);

    boolean n();

    void reset();

    void s(String r100, String r101);

    void x(boolean r100);
}
