package com.bytedance.android.live.room.api.messagewindow.anim;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/anim/CardAnimType;", "", "ENTER", "UPDATE", "EXIT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardAnimType extends Enum<CardAnimType> {
    public static final CardAnimType ENTER = null;
    public static final CardAnimType EXIT = null;
    public static final CardAnimType UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardAnimType[] f98922a = null;

    static {
        CardAnimType r100 = new CardAnimType("ENTER", 0);
        ENTER = r100;
        CardAnimType r101 = new CardAnimType("UPDATE", 1);
        UPDATE = r101;
        CardAnimType r102 = new CardAnimType("EXIT", 2);
        EXIT = r102;
        f98922a = new CardAnimType[]{r100, r101, r102};
    }

    public static CardAnimType valueOf(String r100) {
        return (CardAnimType) a.a(CardAnimType.class, r100);
    }

    public static CardAnimType[] values() {
        return (CardAnimType[]) f98922a.clone();
    }

    public CardAnimType(String r100, int r101) {
        super(r100, r101);
    }
}
