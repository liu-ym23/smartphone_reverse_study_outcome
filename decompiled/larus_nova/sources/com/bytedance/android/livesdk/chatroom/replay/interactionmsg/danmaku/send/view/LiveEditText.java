package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes7.dex */
public class LiveEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f109142a;

    public LiveEditText(Context r100) {
        this(r100, null);
    }

    public static void setEnableHostTypeface(boolean r100) {
        f109142a = r100;
    }

    public LiveEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        if (f109142a == false) goto L9;
        if (r101 == null) goto L10;
        r101.getAttributeIntValue("https://schemas.android.com/apk/res/android", "textStyle", 0);
        return;
    L10:
        return;
    }

    public LiveEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
