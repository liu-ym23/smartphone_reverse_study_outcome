package com.bytedance.ai.model.objects;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/model/objects/PageStatus;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "STARTED", "LOADING_START", "VISIABLE", "LOADING_FINISH", "LOADING_ERROR", "INVISIABLE", "RE_CREATE", "DESTROY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStatus extends Enum<PageStatus> {
    public static final PageStatus DESTROY = null;
    public static final PageStatus INVISIABLE = null;
    public static final PageStatus LOADING_ERROR = null;
    public static final PageStatus LOADING_FINISH = null;
    public static final PageStatus LOADING_START = null;
    public static final PageStatus NONE = null;
    public static final PageStatus RE_CREATE = null;
    public static final PageStatus STARTED = null;
    public static final PageStatus VISIABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageStatus[] f36928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36929b = null;

    public static EnumEntries<PageStatus> getEntries() {
        return f36929b;
    }

    static {
        PageStatus r100 = new PageStatus(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        PageStatus r101 = new PageStatus("STARTED", 1);
        STARTED = r101;
        PageStatus r102 = new PageStatus("LOADING_START", 2);
        LOADING_START = r102;
        PageStatus r103 = new PageStatus("VISIABLE", 3);
        VISIABLE = r103;
        PageStatus r104 = new PageStatus("LOADING_FINISH", 4);
        LOADING_FINISH = r104;
        PageStatus r105 = new PageStatus("LOADING_ERROR", 5);
        LOADING_ERROR = r105;
        PageStatus r110 = new PageStatus("INVISIABLE", 6);
        INVISIABLE = r110;
        PageStatus r111 = new PageStatus("RE_CREATE", 7);
        RE_CREATE = r111;
        PageStatus r112 = new PageStatus("DESTROY", 8);
        DESTROY = r112;
        PageStatus[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f36928a = r113;
        f36929b = EnumEntriesKt.enumEntries(r113);
    }

    public static PageStatus[] values() {
        return (PageStatus[]) f36928a.clone();
    }

    public static PageStatus valueOf(String r100) {
        return (PageStatus) a.a(PageStatus.class, r100);
    }

    public PageStatus(String r100, int r101) {
        super(r100, r101);
    }
}
