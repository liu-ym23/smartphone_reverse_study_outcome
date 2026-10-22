package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/container/ListActionEnum;", "", "ADD", "REMOVE", "UPDATE", "REFRESH", "toolbarservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ListActionEnum extends Enum<ListActionEnum> {
    public static final ListActionEnum ADD = null;
    public static final ListActionEnum REFRESH = null;
    public static final ListActionEnum REMOVE = null;
    public static final ListActionEnum UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListActionEnum[] f116038a = null;

    static {
        ListActionEnum r100 = new ListActionEnum("ADD", 0);
        ADD = r100;
        ListActionEnum r101 = new ListActionEnum("REMOVE", 1);
        REMOVE = r101;
        ListActionEnum r102 = new ListActionEnum("UPDATE", 2);
        UPDATE = r102;
        ListActionEnum r103 = new ListActionEnum("REFRESH", 3);
        REFRESH = r103;
        f116038a = new ListActionEnum[]{r100, r101, r102, r103};
    }

    public static ListActionEnum valueOf(String r100) {
        return (ListActionEnum) a.a(ListActionEnum.class, r100);
    }

    public static ListActionEnum[] values() {
        return (ListActionEnum[]) f116038a.clone();
    }

    public ListActionEnum(String r100, int r101) {
        super(r100, r101);
    }
}
