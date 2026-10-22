package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f81356a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f81357b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f81358c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f81359d = null;

    static {
        int[] r100 = new int[MultiLinkConfig.LinkSource.values().length];
        f81356a = r100;
        MultiLinkConfig.LinkSource r101 = MultiLinkConfig.LinkSource.APPLY;
        r100[r101.ordinal()] = 1;
        MultiLinkConfig.LinkSource r102 = MultiLinkConfig.LinkSource.REPLY;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[MultiLinkConfig.LinkSource.values().length];
        f81357b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        r103[MultiLinkConfig.LinkSource.JOIN.ordinal()] = 3;
        int[] r104 = new int[OperateType.values().length];
        f81358c = r104;
        r104[OperateType.APPLY.ordinal()] = 1;
        OperateType r105 = OperateType.REPLY;
        r104[r105.ordinal()] = 2;
        r104[OperateType.JOIN.ordinal()] = 3;
        int[] r106 = new int[OperateType.values().length];
        f81359d = r106;
        r106[r105.ordinal()] = 1;
    }
}
