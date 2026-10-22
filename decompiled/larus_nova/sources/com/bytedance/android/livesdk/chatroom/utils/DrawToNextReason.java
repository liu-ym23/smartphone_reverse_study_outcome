package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/utils/DrawToNextReason;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "DISLIKE", "FEEDBACK", AccountType.OTHERS, "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DrawToNextReason extends Enum<DrawToNextReason> {
    public static final DrawToNextReason DISLIKE = null;
    public static final DrawToNextReason FEEDBACK = null;
    public static final DrawToNextReason OTHERS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrawToNextReason[] f114338a = null;
    private final String reason;

    static {
        DrawToNextReason r100 = new DrawToNextReason("DISLIKE", 0, AppConstants.BUNDLE_DISLIKE);
        DISLIKE = r100;
        DrawToNextReason r101 = new DrawToNextReason("FEEDBACK", 1, "feedback");
        FEEDBACK = r101;
        DrawToNextReason r102 = new DrawToNextReason(AccountType.OTHERS, 2, "others");
        OTHERS = r102;
        f114338a = new DrawToNextReason[]{r100, r101, r102};
    }

    public static DrawToNextReason valueOf(String r100) {
        return (DrawToNextReason) r27.a.a(DrawToNextReason.class, r100);
    }

    public static DrawToNextReason[] values() {
        return (DrawToNextReason[]) f114338a.clone();
    }

    public final String getReason() {
        return this.reason;
    }

    public DrawToNextReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.reason = r102;
    }
}
