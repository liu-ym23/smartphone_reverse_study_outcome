package com.bytedance.android.livesdk.interactivity.api.chatchannel;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/ContainerType;", "", "PublicScreen", "MultiTab", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType MultiTab = null;
    public static final ContainerType PublicScreen = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f132918a = null;

    static {
        ContainerType r100 = new ContainerType("PublicScreen", 0);
        PublicScreen = r100;
        ContainerType r101 = new ContainerType("MultiTab", 1);
        MultiTab = r101;
        f132918a = new ContainerType[]{r100, r101};
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) a.a(ContainerType.class, r100);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f132918a.clone();
    }

    public ContainerType(String r100, int r101) {
        super(r100, r101);
    }
}
