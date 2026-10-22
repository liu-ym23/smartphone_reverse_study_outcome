package com.bytedance.android.live.xplay.basic.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/xplay/basic/api/XplayBasicMessageType;", "", "Orser_Song_Message", "Virtual_Live_Message", "livexplaygamebasic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum XplayBasicMessageType extends Enum<XplayBasicMessageType> {
    public static final XplayBasicMessageType Orser_Song_Message = null;
    public static final XplayBasicMessageType Virtual_Live_Message = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XplayBasicMessageType[] f102771a = null;

    static {
        XplayBasicMessageType r100 = new XplayBasicMessageType("Orser_Song_Message", 0);
        Orser_Song_Message = r100;
        XplayBasicMessageType r101 = new XplayBasicMessageType("Virtual_Live_Message", 1);
        Virtual_Live_Message = r101;
        f102771a = new XplayBasicMessageType[]{r100, r101};
    }

    public static XplayBasicMessageType valueOf(String r100) {
        return (XplayBasicMessageType) a.a(XplayBasicMessageType.class, r100);
    }

    public static XplayBasicMessageType[] values() {
        return (XplayBasicMessageType[]) f102771a.clone();
    }

    public XplayBasicMessageType(String r100, int r101) {
        super(r100, r101);
    }
}
