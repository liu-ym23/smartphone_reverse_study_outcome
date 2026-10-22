package com.bytedance.android.live.liveinteract.digitavatar;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f72592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f72593b;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.digitavatar.a$a, reason: collision with other inner class name */
    public static final class C1162a {
    }

    static {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AvatarAction(desc=");
        int r101 = this.f72592a;
        if (r101 != 0) goto L5;
        String r102 = "null";
    L21:
        r100.append(r102);
        r100.append(", action=");
        r100.append(this.f72592a);
        r100.append(", playCount=");
        r100.append(this.f72593b);
        r100.append(')');
        return r100.toString();
    L5:
        if (r101 != 1) goto L7;
        r102 = "打招呼";
        goto L21
    L7:
        if (r101 != 2) goto L9;
        r102 = "拿起麦克风";
        goto L21
    L9:
        if (r101 != 3) goto L11;
        r102 = "正常唱歌";
        goto L21
    L11:
        if (r101 != 4) goto L13;
        r102 = "高潮唱歌";
        goto L21
    L13:
        if (r101 == 5) goto L15;
        r102 = "未知动作";
        goto L21
    L15:
        r102 = "放下麦克风";
        goto L21
    }

    public a(int r100) {
        this.f72592a = r100;
        this.f72593b = 1;
    }
}
