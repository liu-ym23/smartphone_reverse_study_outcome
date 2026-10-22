package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.multianchor.connect.MultiAnchorRelinkService;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.MultiLinkConfigManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.o;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public interface a extends d {
    MultiAnchorRelinkService Fa();

    String Me();

    boolean N(String r100);

    void S9(long r100);

    com.bytedance.android.live.revlink.impl.multianchor.utils.m X9();

    boolean ae();

    f21.a getConnectionContext();

    int getInviteType();

    String getInviteeList();

    n getLinkOutManagerFn();

    o getLinkTypeParams();

    int getMatchType();

    Pair<Integer, Integer> getPreviewSize();

    String ij();

    void na(com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r100);

    MultiLinkConfigManager sp();

    void vo(String r100, com.bytedance.android.live.revenuelink.i r101);

    String y3();
}
