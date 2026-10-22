package com.bytedance.ai.view.popup.anim;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AnimController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimProcessType f37826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimProcessType f37827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f37828c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/view/popup/anim/AnimController$AnimProcessType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "DOING", "DONE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnimProcessType extends Enum<AnimProcessType> {
        public static final AnimProcessType DOING = null;
        public static final AnimProcessType DONE = null;
        public static final AnimProcessType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimProcessType[] f37829a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f37830b = null;

        public static EnumEntries<AnimProcessType> getEntries() {
            return f37830b;
        }

        static {
            AnimProcessType r100 = new AnimProcessType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            AnimProcessType r101 = new AnimProcessType("DOING", 1);
            DOING = r101;
            AnimProcessType r102 = new AnimProcessType("DONE", 2);
            DONE = r102;
            AnimProcessType[] r103 = {r100, r101, r102};
            f37829a = r103;
            f37830b = EnumEntriesKt.enumEntries(r103);
        }

        public static AnimProcessType[] values() {
            return (AnimProcessType[]) f37829a.clone();
        }

        public static AnimProcessType valueOf(String r100) {
            return (AnimProcessType) r27.a.a(AnimProcessType.class, r100);
        }

        public AnimProcessType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AnimController() {
        AnimProcessType r100 = AnimProcessType.NONE;
        this.f37826a = r100;
        this.f37827b = r100;
    }

    public final void a(AnimProcessType r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "processType");
        if (r100 == AnimProcessType.DOING) goto L6;
        r102 = null;
    L6:
        this.f37828c = r102;
        if (r101 == false) goto L9;
        this.f37826a = r100;
        return;
    L9:
        this.f37827b = r100;
    }
}
